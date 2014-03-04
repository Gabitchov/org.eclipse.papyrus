/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.JavaUtils;
import org.eclipse.papyrus.emf.facet.util.pde.core.internal.exported.PluginUtils;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.ManifestElement;

public final class JdtUtils {

	private JdtUtils() {
		// Must no be used
	}

	public static ICompilationUnit createJavaClass(
			final EClassifier returnTypeClass,
			final boolean multiValues, final EClassifier scope,
			final IPackageFragment packageFragment,
			final IPackageFragmentRoot root,
			final String typeName, final String cuName)
			throws JavaModelException {
		IPackageFragment packgeFragment2;
		if (packageFragment == null) {
			packgeFragment2 = root.getPackageFragment(""); //$NON-NLS-1$
		} else {
			packgeFragment2 = packageFragment;
		}
		final String packageName = packgeFragment2.getElementName();
		if (!packgeFragment2.exists()) {
			packgeFragment2 = root.createPackageFragment(packageName, true,
					new NullProgressMonitor());
		}
		final StringBuilder contents = new StringBuilder();
		createJavaClassContents(contents, typeName, packageName,
				returnTypeClass, multiValues, scope);
		return packgeFragment2.createCompilationUnit(cuName,
				contents.toString(),
				false, new NullProgressMonitor());
	}

	private static void createJavaClassContents(final StringBuilder contents,
			final String name, final String packageName,
			final EClassifier returnTypeClass, final boolean multiValues,
			final EClassifier scope) {
		if (packageName.length() > 0) {
			contents.append("package "); //$NON-NLS-1$
			contents.append(packageName);
			contents.append(";\n\n"); //$NON-NLS-1$
		}
		boolean importCollection = false;

		String returnType;
		String shortReturnType;
		if (returnTypeClass == null) {
			returnType = "java.lang.Object"; //$NON-NLS-1$
			shortReturnType = "Object"; //$NON-NLS-1$
		} else {
			returnType = returnTypeClass.getInstanceClassName();
			returnType = JavaUtils.objectType(returnType);
			final int lastDotPos = returnType.lastIndexOf('.');
			if (multiValues) {
				importCollection = true;
				shortReturnType = "Collection<" + returnType.substring(lastDotPos + 1) + ">"; //$NON-NLS-1$//$NON-NLS-2$
			} else {
				shortReturnType = returnType.substring(lastDotPos + 1);
			}
		}

		// EList<EClass> scope = modelQuery.getScope();
		String scopeType;
		String shortScopeType;
		// if (scope != null && scope.size() == 1) {
		if (scope == null) {
			scopeType = "org.eclipse.emf.ecore.EObject"; //$NON-NLS-1$
			shortScopeType = "EObject"; //$NON-NLS-1$
		} else {
			scopeType = scope.getInstanceClassName();
			scopeType = JavaUtils.objectType(scopeType);
			shortScopeType = scopeType
					.substring(scopeType.lastIndexOf('.') + 1);
		}

		if (importCollection) {
			contents.append("import java.util.Collection;\n"); //$NON-NLS-1$
		}
		if (mustImport(returnType)) {
			contents.append("import " + returnType + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (!returnType.equals(scopeType) && mustImport(scopeType)) {
			contents.append("import " + scopeType + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		contents.append("import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;\n"); //$NON-NLS-1$
		contents.append("import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;\n"); //$NON-NLS-1$
		contents.append("import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;\n"); //$NON-NLS-1$
		contents.append("import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;\n"); //$NON-NLS-1$
		contents.append("\n"); //$NON-NLS-1$
		contents.append("public class " + name + " implements IJavaQuery2<" + shortScopeType + ", " + shortReturnType + "> {\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		contents.append("	public " + shortReturnType + " evaluate(final " + shortScopeType + " context, \n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		contents.append("			final IParameterValueList2 parameterValues,\n"); //$NON-NLS-1$
		contents.append("			final IFacetManager facetManager)\n"); //$NON-NLS-1$ 
		contents.append("			throws DerivedTypedElementException {\n"); //$NON-NLS-1$
		contents.append("		// TODO Auto-generated method stub\n"); //$NON-NLS-1$
		contents.append("		return null;\n"); //$NON-NLS-1$
		contents.append("	}\n"); //$NON-NLS-1$
		contents.append("}\n"); //$NON-NLS-1$
	}

	private static boolean mustImport(final String type) {
		return type.contains(".") && !type.startsWith("java.lang."); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Setup the given project's Manifest so that metamodels referenced by the
	 * query's <code>returnType</code> and <code>scope</code> are available on
	 * the classpath.
	 */
	public static void setupProject(final IProject project,
			final EClassifier returnType, final EClassifier scope) {
		try {
			final String[] requiredBundles = findRequiredBundles(returnType,
					scope);
			// start with all and then remove those already present
			final List<String> missingBundles = new ArrayList<String>();
			for (final String requiredBundle : requiredBundles) {
				missingBundles.add(requiredBundle);
			}
			missingBundles.add("org.eclipse.papyrus.emf.facet.efacet.core"); //$NON-NLS-1$
			missingBundles.add("org.eclipse.papyrus.emf.facet.query.java.core"); //$NON-NLS-1$

			PluginUtils.configureAsPluginProject(project);
			final IFile manifestResource = (IFile) project.findMember(new Path(
					"/META-INF/MANIFEST.MF")); //$NON-NLS-1$
			manifestResource.refreshLocal(IResource.DEPTH_ONE,
					new NullProgressMonitor());
			final InputStream contents = manifestResource.getContents();
			final Manifest manifest = new Manifest(contents);
			final String requires = manifest.getMainAttributes().getValue(
					"Require-Bundle"); //$NON-NLS-1$
			if (requires != null) {
				final ManifestElement[] manifestElements = ManifestElement
						.parseHeader("Require-Bundle", requires); //$NON-NLS-1$
				for (final ManifestElement manifestElement : manifestElements) {
					// make sure it won't be duplicated
					missingBundles.remove(manifestElement.getValue());
				}
			}

			final StringBuilder newRequires = new StringBuilder();
			if (requires != null) {
				newRequires.append(requires);
			}
			for (int i = 0; i < missingBundles.size(); i++) {
				final String missingBundle = missingBundles.get(i);
				if ((i != 0) || (requires != null)) {
					newRequires.append(","); //$NON-NLS-1$
				}
				newRequires.append(missingBundle);
			}

			manifest.getMainAttributes().putValue(
					"Require-Bundle", newRequires.toString()); //$NON-NLS-1$

			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			manifest.write(outputStream);
			final ByteArrayInputStream inputStream = new ByteArrayInputStream(
					outputStream.toByteArray());
			manifestResource.setContents(inputStream, true, true,
					new NullProgressMonitor());
		} catch (final Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
	}

	/**
	 * Find the bundles containing the implementations of the metamodels
	 * referenced by the given classifiers.
	 */
	private static String[] findRequiredBundles(final EClassifier returnType,
			final EClassifier scope) {
		final Set<String> requiredBundles = new HashSet<String>();
		final Set<EPackage> requiredEPackages = new HashSet<EPackage>();
		if (returnType != null) {
			requiredEPackages.add(returnType.getEPackage());
		}
		if (scope != null) {
			requiredEPackages.add(scope.getEPackage());
		}

		final Map<String, URI> genModelLocMap = EcorePlugin
				.getEPackageNsURIToGenModelLocationMap();

		for (final EPackage ePackage : requiredEPackages) {
			try {
				final URI genModelURI = genModelLocMap.get(ePackage.getNsURI());
				if (genModelURI == null) {
					Logger.logWarning(
							"Couldn't add the metamodel implementation plug-in" //$NON-NLS-1$
									+ " to the dependencies automatically because" //$NON-NLS-1$
									+ " the corresponding genmodel couldn't be found: " //$NON-NLS-1$
									+ ePackage.getNsURI(),
							Activator.getDefault());
				} else {
					final ResourceSet resourceSet = createResource();
					final Resource resource = resourceSet
							.createResource(genModelURI);
					resource.load(Collections.emptyMap());
					final GenModel genModel = (GenModel) resource.getContents()
							.get(0);
					final String modelPluginID = genModel.getModelPluginID();
					if (modelPluginID != null) {
						requiredBundles.add(modelPluginID);
					}
				}
			} catch (final Exception e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
		return requiredBundles.toArray(new String[requiredBundles.size()]);
	}

	private static ResourceSetImpl createResource() {
		return new ResourceSetImpl();
	}
}
