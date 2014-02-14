/*******************************************************************************
 * Copyright (c) 2011 Soft-Maint.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Fabien Treguer (Soft-Maint) - Bug 418565 - [Unit Test Failure] Missing dependencies during tests, target platform creation and load
 ******************************************************************************/
package org.eclipse.emf.facet.util.pde.core.internal.exported;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.util.pde.core.internal.Activator;
import org.eclipse.emf.facet.util.pde.core.internal.exported.exception.PdeCoreUtilsException;
import org.eclipse.emf.facet.util.pde.core.internal.exported.exception.ReflexiveDiscouragedAccessException;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public final class TargetPlatformUtils {

	private static final String BUNDLE_SEPARATOR = ","; //$NON-NLS-1$
	private static final String JAR_EXT = ".jar";	//$NON-NLS-1$
	private static final String JAR_DIRECTORY = "jarFiles"; //$NON-NLS-1$
	private static final int BUFFER_SIZE = 4096;
	private static final String BUNDLE_PREFIX = "reference:file:"; //$NON-NLS-1$
	private static final String FRAMEWORK_PREFIX = "file:"; //$NON-NLS-1$
	private static final String OSGI_PROP = "osgi.bundles"; //$NON-NLS-1$
	private static final String OSGI_PROP_FRK = "osgi.framework"; //$NON-NLS-1$
	private static final String ARRAY_PREFIX = "[L"; //$NON-NLS-1$

	private TargetPlatformUtils() { 
		//Must not be used.
	}

	/**
	 * Creates and loads a target platform with all needed bundles.
	 * @throws PdeCoreUtilsException 
	 * @throws IOException 
	 */
	public static void loadTargetPlatform() throws PdeCoreUtilsException {
		String copyDirectoryPath;
		try {
			/*ITargetPlatformService*/
			final Object targetPlServ = reflexiveCall(
					true, 
					"org.eclipse.pde.internal.core.target.TargetPlatformService", //$NON-NLS-1$
					"getDefault", //$NON-NLS-1$
					null);
			/*ITargetDefinition*/
			final Object targetDefinition = reflexiveCall(
					false,
					targetPlServ,
					"newTarget", //$NON-NLS-1$
					null);
			copyDirectoryPath =  Activator.getDefault().getStateLocation()
					+ File.separator + JAR_DIRECTORY;

			final File copyDirectory = new File(copyDirectoryPath);
			copyDirectory.mkdirs();

			final List<String> dirPaths = parseBundlesList();

			/*IBundleContainer*/
			final Object[] dirContainers =
					copyJarsAndGetContainers(dirPaths, copyDirectory);
			reflexiveCall(
					false,
					targetDefinition,
					getContainerSetterName(),
					new Object[]{dirContainers});
			reflexiveCall(
					false,
					targetDefinition,
					"resolve", //$NON-NLS-1$
					new Object[]{new NullProgressMonitor()});
			reflexiveCall(
					true,
					getLoadTargetDefinitionJobQualifiedName(),
					"load", //$NON-NLS-1$
					new Object[]{targetDefinition});
			reflexiveCall(
					false,
					targetPlServ,
					"saveTargetDefinition", //$NON-NLS-1$
					new Object[]{targetDefinition});
		} catch (Exception e) {
			throw new PdeCoreUtilsException(e);
		}
		new File(copyDirectoryPath).delete();
	}

	private static boolean isHigherVersion() {
		final Version version = new Version(3, 7, 1);
		final Bundle bundle = Platform.getBundle("org.eclipse.pde.core"); //$NON-NLS-1$
		final Version currentVersion = bundle.getVersion();
		return currentVersion.compareTo(version) > 0;
	}
	
	private static String getLoadTargetDefinitionJobQualifiedName() {
		String lTDefJobName;
		if (isHigherVersion()) {
			lTDefJobName = 
					"org.eclipse.pde.core.target.LoadTargetDefinitionJob"; //$NON-NLS-1$
		} else {
			lTDefJobName = 
					"org.eclipse.pde.internal.core.target.provisional.LoadTargetDefinitionJob"; //$NON-NLS-1$
		}
		return lTDefJobName;
	}
	
	private static String getContainerSetterName() {
		String setterName;
		if (isHigherVersion()) {
			setterName = 
					"setTargetLocations"; //$NON-NLS-1$
		} else {
			setterName = 
					"setBundleContainers"; //$NON-NLS-1$
		}
		return setterName;
	}

	/**
	 * Parses osgi.bundles property value to load all required bundles directories.
	 * @return List<String> array
	 * @throws PdeCoreUtilsException 
	 * @throws IOException 
	 */
	private static List<String> parseBundlesList()
			throws PdeCoreUtilsException, IOException {
		final LinkedList<String> result = new LinkedList<String>();
		final String bundlesFromConfig = System.getProperty(OSGI_PROP);
		final String frwkFromConfig = System.getProperty(OSGI_PROP_FRK);
		if (bundlesFromConfig != null && !"".equals(bundlesFromConfig)) { //$NON-NLS-1$
			final String[] bundlesStr = 
					bundlesFromConfig.split(BUNDLE_SEPARATOR);
			result.addAll(trimPaths(bundlesStr, BUNDLE_PREFIX));
		}
		if (frwkFromConfig != null && !"".equals(frwkFromConfig)) { //$NON-NLS-1$
			final String[] frameworkStr = 
					frwkFromConfig.split(BUNDLE_SEPARATOR);
			result.addAll(trimPaths(frameworkStr, FRAMEWORK_PREFIX));
		}
		return result;
	}

	/**
	 * Returns list of trimmed paths;
	 * @param paths String[]
	 * @param prefix String
	 * @return List<String>
	 */
	private static List<String> trimPaths(final String[] paths,
			final String prefix) {
		final LinkedList<String> result = new LinkedList<String>();
		for (String path : paths) {
			int indexSuffix = path.indexOf("@"); //$NON-NLS-1$
			if (indexSuffix < 0) {
				indexSuffix = path.length();
			}
			result.add(path.substring(prefix.length(),
					indexSuffix));
		}	
		return result;
	}

	/**
	 * Reflexive call of DirectoryBundleContainer constructor.
	 * @param containerPath String
	 * @return Object
	 * @throws PdeCoreUtilsException
	 */
	private static Object newDirectoryBundleContainer(
			final String containerPath)
					throws PdeCoreUtilsException {
		Object container = null;
		try {
			final Bundle bundle = Activator.getDefault().getBundle();
			final Class<?> classs = 
					bundle.loadClass("org.eclipse.pde.internal.core.target.DirectoryBundleContainer"); //$NON-NLS-1$
			final Class<?>[] paramTypes = new Class[] {containerPath.getClass()};
			final Constructor<?> constructor = classs.getConstructor(paramTypes);
			final Object[] initargs = new Object[] { containerPath };
			container = constructor.newInstance(initargs);
		} catch (Exception e) {
			throw new PdeCoreUtilsException(e);
		}
		return container;
	}

	/**
	 * Copies all needed jar files in a directory and returns set of containers.
	 * @param bundlesStr List<String>
	 * @param copyDirectory File
	 * @return Object[]
	 * @throws PdeCoreUtilsException
	 * @throws IOException 
	 */
	private static Object[] copyJarsAndGetContainers(
			final List<String> bundlesStr, final File copyDirectory)
					throws PdeCoreUtilsException, IOException {
		final List<Object> bundleContainers = new LinkedList<Object>();
		final Iterator<String> bundlesStrIter = bundlesStr.iterator();
		while (bundlesStrIter.hasNext()) {
			final File bundleFile = new File(bundlesStrIter.next()); // NOPMD
			// NOPMD: gdupe> No other way to write this code
			if (bundleFile.exists()) {
				if (bundleFile.isDirectory()) {
					copyJarFileOrAddContainerDirectory(bundleFile,
							bundleContainers, copyDirectory);
				} else {
					try {
						//FIXME gdupe> is a call to close() required ?
						final JarFile jarFile = new JarFile(bundleFile); // NOPMD
						// NOPMD: gdupe> No other way to write this code
						copyJarFile(jarFile, copyDirectory);
					} catch (IOException e) {
						throw new PdeCoreUtilsException(e);
					}
				}
			}
		}
		final Object copyDirContainer = 
				newDirectoryBundleContainer(copyDirectory.getAbsolutePath());
		bundleContainers.add(copyDirContainer);
		return bundleContainers.toArray();
	}

	/**
	 * Copies jarFile to the specified directory or creates a container
	 * if bundleFile is a directory.
	 * @param bundleFile File
	 * @param bundleContainers List<Object>
	 * @param copyDirectory File
	 * @throws PdeCoreUtilsException
	 * @throws IOException 
	 */
	private static void copyJarFileOrAddContainerDirectory(
			final File bundleFile, final List<Object> bundleContainers,
			final File copyDirectory)
					throws PdeCoreUtilsException, IOException {
		Object container;
		//FIXME gdupe> is a call to close() required ?
		final JarFile jarFile = getFirstMatchingJarFile(bundleFile);
		if (jarFile == null) {
			container = newDirectoryBundleContainer(bundleFile.getAbsolutePath());
			bundleContainers.add(container);
		} else {
			copyJarFile(jarFile, copyDirectory);
		}
	}		

	/**
	 * Return first jar file that match with the bundle directory.
	 * @param bundleFile File
	 * @return JarFile
	 * @throws IOException
	 */
	private static JarFile getFirstMatchingJarFile(final File bundleFile)
			throws IOException {
		JarFile result = null;
		if (bundleFile.exists() && bundleFile.isDirectory()) {
			final String bundleFileName = bundleFile.getName();
			final File jar = findJarFile(bundleFile, bundleFileName);
			if (jar != null) {
				result = new JarFile(jar);
			}
		}
		return result;
	}

	/**
	 * Search jar file in directory and sub-directories.
	 * @param directory File
	 * @param fileName String
	 * @return File
	 */
	private static File findJarFile(final File directory,
			final String fileName) {
		final File[] children = directory.listFiles();
		final LinkedList<File> toVisit = new LinkedList<File>();
		int cpt = 0;
		File foundFile = null;
		String childName;
		while (foundFile != null && cpt < children.length) {
			final File child = children[cpt];
			if (child.isFile()) {
				childName = child.getName();
				if (childName.startsWith(fileName)
						&& childName.endsWith(JAR_EXT)) {
					foundFile = child;
				}
			} else {
				toVisit.add(child);
			}
			cpt++;
		}
		if (foundFile == null) {
			foundFile = searchInSubDirectories(fileName, toVisit);
		}
		return foundFile;
	}

	/**
	 * Search jar file and sub-directories.
	 * @param fileName String
	 * @param toVisit List<File>
	 * @return File
	 */
	private static File searchInSubDirectories(final String fileName,
			final List<File> toVisit) {
		File result = null;
		final Iterator<File> childrenIterator = toVisit.iterator();
		while (childrenIterator.hasNext() && result != null) {
			final File child = childrenIterator.next();
			result = findJarFile(child.getAbsoluteFile(), fileName);
		}
		return result;
	}


	/**
	 * Copies a jarFile into specified directory.
	 * @param jarFile JarFile
	 * @param copyTo File
	 * @throws PdeCoreUtilsException 
	 */
	private static void copyJarFile(final JarFile jarFile, final File copyTo)
			throws PdeCoreUtilsException {
		final String fileName = jarFile.getName();
		final String bundleName = fileName.substring(fileName
				.lastIndexOf(File.separator));
		final File copyToDirectory = new File(copyTo, bundleName);
		JarOutputStream jarOutputStream = null;
		try {
			jarOutputStream = new JarOutputStream(
					new FileOutputStream(copyToDirectory));
			final Enumeration<JarEntry> jarFileEntries = jarFile.entries();
			final byte[] buffer = new byte[BUFFER_SIZE];
			while (jarFileEntries.hasMoreElements()) {
				final JarEntry sourceEntry = jarFileEntries.nextElement();
				final InputStream inputStream =
						jarFile.getInputStream(sourceEntry);
				final JarEntry targetEntry =
						new JarEntry(sourceEntry.getName()); // NOPMD
				// ftreguer> NOPMD This loop has to create one jar entry for
				// each loop iteration
				jarOutputStream.putNextEntry(targetEntry);
				int bytesRead = inputStream.read(buffer);
				while (bytesRead != -1) {
					jarOutputStream.write(buffer, 0, bytesRead);
					bytesRead = inputStream.read(buffer);
				}
				inputStream.close();
				jarOutputStream.flush();
				jarOutputStream.closeEntry();
			}
		} catch (IOException e) {
			throw new PdeCoreUtilsException(e);
		} finally { // NOPMD gdupe> No other choice if I want to managed the
		// stream closing
			if (jarOutputStream != null) {
				try {
					jarOutputStream.close();
				} catch (IOException e) {
					throw new PdeCoreUtilsException(e);
				}
			}
		}
	}

	/**
	 * Calls a method reflexively on an object or a class (static call) with
	 * specified arguments.
	 * @param staticCall boolean
	 * @param callOn Object
	 * @param calledMethodName String
	 * @param args Object[]
	 * @throws ExpException 
	 */
	private static Object reflexiveCall(final boolean staticCall,
			final Object callOn, final String calledMethodName,
			final Object[] args) throws ReflexiveDiscouragedAccessException {
		Object result = null;
		Method aMethod;
		final Class<?>[] classes = getClassesFromArgs(args);
		try {
			if (staticCall) {
				// ftreguer> Static Call, the second parameter should be a
				// String representing Class name.
				if (callOn instanceof String) {
					final Class<?> clazz = Activator.getDefault()
							.getBundle().loadClass((String) callOn);
					aMethod = getMethod(clazz, calledMethodName, classes);
				} else {
					throw new ReflexiveDiscouragedAccessException(
							"Invalid parameter, callOn parameter should be a String. (Static Call)"); //$NON-NLS-1$
				}
			} else {
				aMethod = getMethod(callOn.getClass(),
						calledMethodName, classes);
			}
			if (aMethod == null) {
				throw new ReflexiveDiscouragedAccessException(
						"API break, no method with specified arguments found."); //$NON-NLS-1$
			} 
			result = aMethod.invoke(callOn, manageArguments(args));
		} catch (Exception e) {
			throw new ReflexiveDiscouragedAccessException(e);
		}
		return result;
	}


	/**
	 * Transforms Object arrays to specific arrays.
	 * @param arguments Object[]
	 * @return Object[]
	 */
	private static Object[] manageArguments(final Object[] arguments) {
		Object[] result;
		if (arguments != null && arguments.length > 0) {
			result = new Object[arguments.length];
			Object arg;
			for (int i = 0; i < arguments.length; i++) {
				arg = arguments[i];
				if (isArray(arg)) {
					final Object argElement = ((Object[]) arg)[0];
					final int arraySize = Array.getLength(arg);
					Object[] argTmp = (Object[]) Array.newInstance(
							argElement.getClass(), arraySize);
					for (int y = 0; y < arraySize; y++) {
						argTmp[y] = ((Object[]) arg)[y];
					}
					result[i] = argTmp;
				} else {
					result[i] = arg;
				}
			}
		} else {
			result = arguments;
		}
		return result;	
	}

	/**
	 * Returns true if the parameter represents an array.
	 * @param obj Object
	 * @return boolean
	 */
	private static boolean isArray(final Object obj) {
		return obj.getClass().getName().startsWith(ARRAY_PREFIX);
	}

	/**
	 * Returns array of Class that represents types of each arguments.
	 * @param args Object[]
	 * @return Class<?>[]
	 */
	private static Class<?>[] getClassesFromArgs(final Object[] args) {
		Class<?>[] classes = null;
		if (args != null) {
			classes = new Class[args.length];
			Object arg = null;
			for (int i = 0; i < args.length; i++) {
				arg = args[i];
				if (arg != null) {
					if (isArray(arg)) {
						arg = ((Object[]) arg)[0];
						arg = Array.newInstance(arg.getClass(), 0);
					}
					classes[i] = arg.getClass();
				}
			}
		}
		return classes;
	}

	/**
	 * Returns a Method object that correspond to the specified name
	 * and parameters.
	 * @param clazz Class<?>
	 * @param methodName String
	 * @param parameterTypes Class<?>[]
	 * @return Method
	 * @throws ClassNotFoundException
	 */
	private static Method getMethod(final Class<?> clazz,
			final String methodName, final Class<?>... parameterTypes)
			throws ClassNotFoundException {
		Method result = null;
		final Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				final Class<?>[] parameters = method.getParameterTypes();
				if (checkTypes(parameters, parameterTypes)) {
					result = method;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Checks if all parameters are the same in both arrays.
	 * @param refParams
	 * @param parameterToTest
	 * @return boolean
	 * @throws ClassNotFoundException 
	 */
	private static boolean checkTypes(final Class<?>[] refParams,
			final Class<?>[] parameterToTest) throws ClassNotFoundException {
		boolean result = true;
		if (refParams != null && parameterToTest != null
				&& (refParams.length == parameterToTest.length)) {
			String refClazzName = null;
			String clazzName = null;
			for (int i = 0; i < parameterToTest.length; i++) {
				refClazzName = refParams[i].getName();
				clazzName = parameterToTest[i].getName();	
				if (!clazzName.equals(refClazzName)) {
					final boolean isRefArray = refClazzName
							.startsWith(ARRAY_PREFIX);
					final boolean isParamArray = clazzName
							.startsWith(ARRAY_PREFIX);
					if (isRefArray == isParamArray) {
						if (isRefArray) {
							refClazzName = refClazzName
									.substring(ARRAY_PREFIX.length(),
											refClazzName.length() - 1);
							clazzName = clazzName
									.substring(ARRAY_PREFIX.length(),
											clazzName.length() - 1);
						}
						result = paramExtendsRef(refClazzName, clazzName);
					} 
				}
			}
		}
		return result;
	}

	/**
	 * Returns true if className is a SubType of refClassName.
	 * @param refClassName String
	 * @param className String
	 * @return boolean
	 * @throws ClassNotFoundException
	 */
	private static boolean paramExtendsRef(final String refClassName,
			final String className) throws ClassNotFoundException {
		final Bundle bundle = Activator.getDefault().getBundle();
		final Class<?> refClazz =  bundle.loadClass(refClassName);
		final Class<?> clazz =  bundle.loadClass(className);
		return refClazz.isAssignableFrom(clazz);		
	}

}
