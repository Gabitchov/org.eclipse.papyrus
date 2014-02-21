/*******************************************************************************
 * Copyright (c) 2010-2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 340339 - Need some Utils class for Folder/File/Project management
 *    Gregoire Dupe (Mia-Software) - Bug 340339 - Need some Utils class for Folder/File/Project management
 *    Nicolas Guyomar (Mia-Software) - Bug 340681 - Facet column implementation
 *    Nicolas Bros (Mia-Software) - Bug 380391 - PluginUtils#importPlugin should use the Bundle API
 *    Gregoire Dupe (Mia-Software) - Bug 408344 - [Releng] Deep folders cause build break
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.pde.core.internal;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FileUtils;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FolderUtils;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.IFilter;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.ibm.icu.lang.UCharacter;

public final class PluginUtils {

	// This class has been copied from
	// org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.PluginUtils

	private PluginUtils() {
		// utilities class
	}

	/**
	 * Returns whether the given file is registered in the plugin.xml of the
	 * given project, using the given extension point.
	 * 
	 * @param extensionPoint
	 *            the extension point that is used to register elements of this
	 *            kind (elements must be declared with a "file" attribute)
	 */
	public static boolean isRegistered(final IFile elementFile, final String extensionPoint) {
		final IProject project = elementFile.getProject();
		final IPluginModelBase pluginModel = PluginRegistry.findModel(project);
		boolean result = false;
		if (pluginModel != null) {
			final IExtensions extensions2 = pluginModel.getExtensions();
			final IPluginExtension[] extensions = extensions2.getExtensions();
			for (IPluginExtension pluginExtension : extensions) {
				if (extensionPoint.equals(pluginExtension.getPoint())) {
					final IPluginObject[] children = pluginExtension.getChildren();
					for (IPluginObject child : children) {
						if (child instanceof IPluginElement) {
							final IPluginElement pluginElement = (IPluginElement) child;
							final IPluginAttribute[] attributes = pluginElement.getAttributes();
							for (IPluginAttribute pluginAttribute : attributes) {
								if ("file".equalsIgnoreCase(pluginAttribute.getName())) { //$NON-NLS-1$
									final String strFile = pluginAttribute.getValue();
									if (strFile != null && strFile.length() > 0) {
										final IFile file = project.getFile(strFile);
										if (file.exists() && elementFile.equals(file)) {
											result = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Registers the given file in the plugin.xml of the given project, using
	 * the given extension point.
	 * 
	 * @param project
	 *            the project in which the element should be registered
	 * @param extensionToCheck
	 *            the file extension of the element that should be registered
	 * @param extensionPoint
	 *            the extension point that is used to register elements of this
	 *            kind (elements must be declared with a "file" attribute)
	 */
	/**
	 * Registers the given file in the plugin.xml of the given project, using
	 * the given extension point.
	 * 
	 * @param file
	 *            the file to register
	 * @param extensionPointId
	 *            the extension point that is used to register the file
	 * @param elementName
	 *            the name of the XML element in which an attribute named "file"
	 *            will be set to the path of the file
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws CoreException
	 */
	public static void register(final IFile file, final String extensionPointId,
			final String elementName) {
		if (isRegistered(file, extensionPointId)) {
			return;
		}

		final IPath filePath = file.getFullPath().removeFirstSegments(1);
		final IProject project = file.getProject();

		final IFile pluginXML = project.getFile("plugin.xml"); //$NON-NLS-1$
		if (pluginXML.exists()) {
			final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;

			try {
				docBuilder = docFactory.newDocumentBuilder();
				final String pluginXmlLoc = pluginXML.getLocation().toOSString();
				final Document doc = docBuilder.parse(pluginXmlLoc);
				final Element root = doc.getDocumentElement();

				final Text whitespace = doc.createTextNode("   "); //$NON-NLS-1$
				root.appendChild(whitespace);

				final Node extensionNode = doc.createElement("extension"); //$NON-NLS-1$
				final Attr pointAttr = doc.createAttribute("point"); //$NON-NLS-1$
				pointAttr.setValue(extensionPointId);
				extensionNode.getAttributes().setNamedItem(pointAttr);
				root.appendChild(extensionNode);

				final Node elementNode = doc.createElement(elementName);
				final Attr fileAttr = doc.createAttribute("file"); //$NON-NLS-1$
				fileAttr.setValue(filePath.toString());
				elementNode.getAttributes().setNamedItem(fileAttr);
				extensionNode.appendChild(elementNode);

				final TransformerFactory trFactory = TransformerFactory.newInstance();
				final int indent = 3;
				trFactory.setAttribute("indent-number", Integer.valueOf(indent)); //$NON-NLS-1$
				final Transformer transformer = trFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
				transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
				final StreamResult result = new StreamResult(new StringWriter());
				final DOMSource source = new DOMSource(doc);
				transformer.transform(source, result);
				final String xmlString = result.getWriter().toString();

				final byte[] byteArray = xmlString.getBytes("UTF-8"); //$NON-NLS-1$
				pluginXML.setContents(new ByteArrayInputStream(byteArray), true, true,
						new NullProgressMonitor());

			} catch (Exception e) {
				Logger.logError(e, Activator.getDefault());
			}
		} else {
			try {
				// create plugin.xml
				final String template = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" //$NON-NLS-1$
						+ "<?eclipse version=\"3.4\"?>\n" + "<plugin>\n" //$NON-NLS-1$ //$NON-NLS-2$
						+ "   <extension point=\"{0}\">\n" + "      <{1} file=\"{2}\"/>\n" //$NON-NLS-1$ //$NON-NLS-2$
						+ "   </extension>\n" //$NON-NLS-1$
						+ "</plugin>\n"; //$NON-NLS-1$

				final String content = NLS.bind(template, new Object[] { extensionPointId, elementName,
						filePath.toString() });
				byte[] byteArray;
				byteArray = content.getBytes("UTF-8"); //$NON-NLS-1$
				pluginXML.create(new ByteArrayInputStream(byteArray), true,
						new NullProgressMonitor());
				try {
					BuildPropertiesUtils.addToBuild(pluginXML);
				} catch (Exception e) {
					Logger.logError(e, "Error adding file " + pluginXML.getFullPath() //$NON-NLS-1$
							+ " to the build.properties", null); //$NON-NLS-1$
				}
			} catch (Exception e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
	}

	private static final String JAVA_VERSION = "J2SE-1.5"; //$NON-NLS-1$
	private static final String ACTIVATOR_NAME = "Activator"; //$NON-NLS-1$
	private static final String MANIFEST_MF_TPL = "resources/MANIFEST.MF.template"; //$NON-NLS-1$
	private static final String ACTIVATOR_TPL = "resources/Activator.java.template"; //$NON-NLS-1$
	private static final String PDE_CLASSPATH_ID = "org.eclipse.pde.core.requiredPlugins"; //$NON-NLS-1$
	private static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$

	private static void addPdeClassPath(final IProject project)
			throws JavaModelException {
		final IJavaProject javaProject = JavaCore.create(project);
		final IClasspathEntry[] oldClassPath = javaProject.getRawClasspath();
		for (IClasspathEntry classpathEntry : oldClassPath) {
			if (classpathEntry.getPath().equals(new Path(PluginUtils.PDE_CLASSPATH_ID))) {
				return;
			}
		}
		final IClasspathEntry[] newClassPath = new IClasspathEntry[oldClassPath.length + 1];
		System.arraycopy(oldClassPath, 0, newClassPath, 0, oldClassPath.length);
		newClassPath[oldClassPath.length] = JavaCore
				.newContainerEntry(new Path(PluginUtils.PDE_CLASSPATH_ID));
		javaProject.setRawClasspath(newClassPath, new NullProgressMonitor());
	}

	/**
	 * @author Gregoire Dupe (Mia-Software) - Removing "Require-Bundle"
	 *         statement
	 * @throws IOException
	 */
	private static void createManifest(final IProject project)
			throws CoreException, IOException {
		final IFolder folder = project.getFolder("META-INF"); //$NON-NLS-1$
		if (!folder.exists()) {
			folder.create(true, true, new NullProgressMonitor());
		}
		final IFile manifestFile = folder.getFile("MANIFEST.MF"); //$NON-NLS-1$
		if (!manifestFile.exists()) {
			String template = FileUtils.getFileContents(Activator.getDefault()
					.getBundle(), PluginUtils.MANIFEST_MF_TPL);
			template = template.replace("{projectName}", project.getName()); //$NON-NLS-1$
			final String packageName = PluginUtils
					.stringToValidPackageName(project.getName());
			template = template.replace("{packageName}", packageName); //$NON-NLS-1$
			final String activator = PluginUtils
					.bundleActivatorQualifiedName(packageName);
			template = template.replace("{activator}", activator); //$NON-NLS-1$
			template = template.replace("{javaVersion}", //$NON-NLS-1$
					PluginUtils.JAVA_VERSION);
			final InputStream source = new ByteArrayInputStream(
					template.getBytes());
			manifestFile.create(source, true, new NullProgressMonitor());
		}
	}

	private static String bundleActivatorQualifiedName(final String packageName) {
		return packageName + '.' + PluginUtils.ACTIVATOR_NAME;
	}

	private static void createActivator(final IProject project)
			throws CoreException, IOException {
		final String packageName = PluginUtils.stringToValidPackageName(project
				.getName());
		final String qualifiedName = PluginUtils
				.bundleActivatorQualifiedName(packageName);
		final String path = qualifiedName.replaceAll("\\.", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		final IFile activatorFile = project
				.getFile(new Path("src").append(path).addFileExtension("java")); //$NON-NLS-1$ //$NON-NLS-2$
		FolderUtils.createFolder((IFolder) activatorFile.getParent());
		if (!activatorFile.exists()) {
			final String template = FileUtils.getFileContents(Activator
					.getDefault().getBundle(), PluginUtils.ACTIVATOR_TPL);
			final String activatorContents = template.replace("{0}", packageName); //$NON-NLS-1$
			final InputStream source = new ByteArrayInputStream(
					activatorContents.getBytes());
			activatorFile.create(source, true, new NullProgressMonitor());
		}
	}

	/** Transform the given name into a valid package and bundle name */
	private static String stringToValidPackageName(final String name) {
		final StringBuilder builder = new StringBuilder();
		char prev = ' ';
		for (int i = 0; i < name.length(); i++) {
			final char character = name.charAt(i);
			if (character >= 'a' && character <= 'z' || character >= 'A'
					&& character <= 'Z' || character == '_') {
				builder.append(character);
				prev = character;
			} else if (character >= '0' && character <= '9') {
				if (builder.length() == 0 || prev == '.') {
					builder.append("_"); //$NON-NLS-1$
				}
				builder.append(character);
				prev = character;
			} else if (character == '.') {
				if (prev == '.') {
					continue;
				}
				if (builder.length() == 0 || prev >= '0' && prev <= '9') {
					builder.append("_"); //$NON-NLS-1$
				}
				builder.append(character);
				prev = character;
			} else {
				builder.append("_"); //$NON-NLS-1$
			}
		}

		String result = builder.toString();
		// first letter to lowercase
		if (result.length() > 0 && UCharacter.isUpperCase(result.charAt(0))) {
			result = UCharacter.toLowerCase(result.charAt(0))
					+ result.substring(1);
		}

		final IStatus status = JavaConventions.validatePackageName(result,
				JavaCore.VERSION_1_5, JavaCore.VERSION_1_5);
		if (!status.isOK()) {
			Logger.logWarning(
					"Couldn't make valid package name from project name: " //$NON-NLS-1$
							+ status.getMessage(), Activator.getDefault());
			result = name;
		}
		return result;
	}

	private static void addPdeNature(final IProject project)
			throws CoreException {
		final String pluginNature = PluginUtils.PLUGIN_NATURE;
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();
		if (!Arrays.asList(natures).contains(pluginNature)) {
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = pluginNature;
			description.setNatureIds(newNatures);
			project.setDescription(description, new NullProgressMonitor());
		}
	}

	/**
	 * This method transforms a Java project into a plug-in project by creating
	 * a MANIFEST.MF and an activator and by adding a the PDE nature and the PDE
	 * classpath.
	 * 
	 * @param project
	 *            The project to transform in an plug-in project
	 * @throws CoreException
	 * @throws IOException
	 */
	public static void configureAsPluginProject(final IProject project)
			throws CoreException, IOException {
		PluginUtils.addPdeNature(project);
		// PDE builders are automatically added when the PDE nature is added
		PluginUtils.addPdeClassPath(project);
		PluginUtils.createManifest(project);
		PluginUtils.createActivator(project);
	}

	/**
	 * This method returns true if the project is a plug-in project.
	 * 
	 * @param project
	 * @return True if the project is a plug-in project.
	 * @throws CoreException
	 */
	public static boolean isPluginProject(final IProject project)
			throws CoreException {
		boolean result = false;
		if (project.isAccessible()) {
			result = project.getNature(PluginUtils.PLUGIN_NATURE) != null;
		}
		return result;
	}

	/**
	 * This method returns true if the path refers a file or a folder contained
	 * in a plug-in project.
	 * 
	 * @param path
	 * @return True if the path refers a file or a folder contained in a plug-in
	 *         project.
	 * @throws CoreException
	 */
	public static boolean isInPluginProject(final IPath path)
			throws CoreException {
		IProject project;
		if (path.segmentCount() == 1) {
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(path.segment(0));
		} else {
			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(path);
			project = folder.getProject();
		}
		return isPluginProject(project);
	}

	/**
	 * This method imports a plug-in in the workspace.
	 * 
	 * @param bundle
	 *            the bundle to import into a new project
	 * @return the created project
	 * @throws CoreException
	 *             in case of error
	 */
	public static IProject importPlugin(final Bundle bundle) throws CoreException {
		return PluginUtils.importPlugin(bundle, new IFilter<String>() {
			public boolean filter(final String fileName) {
				return true;
			}
		});
	}

	/**
	 * This method imports a plug-in in the workspace.
	 * 
	 * @param bundle
	 *            the bundle to import into a new project
	 * @param filter
	 *            can be used to filter out files or folders from the import
	 * @return the created project
	 * @throws CoreException
	 *             in case of error
	 */
	public static IProject importPlugin(final Bundle bundle, final IFilter<String> filter) throws CoreException {
		final IProject[] project = new IProject[1];
		final IWorkspaceRunnable workspaceRunnable = new IWorkspaceRunnable() {
			public void run(final IProgressMonitor monitor) throws CoreException {
				project[0] = internalImportPlugin(bundle, filter);
			}
		};
		ResourcesPlugin.getWorkspace().run(workspaceRunnable, new NullProgressMonitor());
		return project[0];
	}

	/**
	 * This method imports a plug-in in the workspace.
	 * 
	 * @param bundle
	 *            the bundle to import into a new project
	 * @param filter
	 *            can be used to filter out files or folders from the import
	 * @return the created project
	 * @throws CoreException
	 *             in case of error
	 */
	protected static IProject internalImportPlugin(final Bundle bundle, final IFilter<String> filter) throws CoreException {
		final IProject project = createProjectWithUniqueName(bundle.getSymbolicName());
		final List<IStatus> errors = new ArrayList<IStatus>();
		final List<URL> urls = getURLsToCopy(bundle, project,
				"/", filter, errors); //$NON-NLS-1$
		for (URL url : urls) {
			copyUrlToFile(project, errors, url);
		}
		handleErrors(errors);
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		return project;
	}
	
	private static void copyUrlToFile(final IProject project,
			final List<IStatus> errors, final URL url) throws CoreException {
		try {
			final InputStream inputStream = url.openStream();
			final String strSubpath = url.toString().replaceAll(
					"bundleentry://[^/]*/", ""); //$NON-NLS-1$  //$NON-NLS-2$
			final IFile file = project.getFile(new Path(strSubpath));
			if (file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}
			final IContainer parent = file.getParent();
			if ((!parent.exists()) && parent instanceof IFolder) {
				createDir((IFolder) parent);
			}
			file.create(inputStream, true, new NullProgressMonitor());
			inputStream.close();
		} catch (FileNotFoundException e) {
			/*
			 * gdupe> We ignore files removed during the execution of
			 * internalImportPlugin.
			 */
			String message;
			try {
				message = String.format("Ignoring the missing file %s.", //$NON-NLS-1$
						url.toURI());
			} catch (URISyntaxException e1) {
				message = String.format("Ignoring the missing file."); //$NON-NLS-1$
			}
			Logger.logError(message, Activator.getDefault());
		} catch (IOException e) {
			final Bundle localBundle = Activator.getDefault().getBundle();
			final String symbolicName = localBundle.getSymbolicName();
			final Status status = new Status(IStatus.ERROR, symbolicName,
					e.getMessage(), e);
			errors.add(status);
		}
	}

	private static void createDir(final IFolder folder) throws CoreException {
		final IContainer parent = folder.getParent();
		if ((!parent.exists()) && parent instanceof IFolder) {
			createDir((IFolder) parent);
		}
		folder.create(true, true, new NullProgressMonitor());
	}
	protected static void handleErrors(final List<IStatus> errors) throws CoreException {
		if (!errors.isEmpty()) {
			final IStatus[] statusArray = errors.toArray(new IStatus[errors.size()]);
			final IStatus status = new MultiStatus(Activator.getDefault().getBundle().getSymbolicName(),
					IStatus.ERROR, statusArray, "Errors importing project", new Exception()); //$NON-NLS-1$
			throw new CoreException(status);
		}
	}

	private static List<URL> getURLsToCopy(final Bundle bundle,
			final IProject project, final String path,
			final IFilter<String> filter, final List<IStatus> errors) {
		final List<URL> result = new ArrayList<URL>();
		final Enumeration<?> entryPaths = bundle.getEntryPaths(path);
		while (entryPaths != null && entryPaths.hasMoreElements()) {
			final Object nextElement = entryPaths.nextElement();
			if (nextElement instanceof String) {
				final String strSubpath = (String) nextElement;
				if (filter.filter(strSubpath)) {
					// directory
					if (strSubpath.endsWith("/")) { //$NON-NLS-1$
						final List<URL> fromSubFolder = getURLsToCopy(bundle,
								project, strSubpath, filter, errors);
						result.addAll(fromSubFolder);
					} else {
						final URL url = bundle.getEntry(strSubpath);
						if (url != null) {
							result.add(url);
						}
					}
				}
			}
		}
		return result;
	}

	protected static IProject createProjectWithUniqueName(final String baseName) throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(baseName);
		if (project.exists()) {
			int version = 1;
			final int maxIter = 100;
			while (project.exists() && version < maxIter) {
				final String uniqueName = baseName + " (" + version + ')'; //$NON-NLS-1$
				project = root.getProject(uniqueName);
				version++;
			}
		}
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		return project;
	}
}
