/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.texteditor.cdt.sync;

import org.eclipse.cdt.core.CCProjectNature;
import org.eclipse.cdt.core.CProjectNature;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.acceleo.ModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.uml2.uml.Classifier;

/**
 * Main listener for model changes (registered via plugin.xml). It will delegate
 * to the sub-listeners for specific sub-elements (type, operation, port, ...) that
 * can be found in this package
 * 
 */
public class SyncModelToCDT {

	/**
	 * set to true, if a synchronization from an CDT editor to the model is active
	 */
	public static boolean syncFromEditor;

	public static IFile syncModelToCDT(Classifier classifier) {
		if((classifier == null) || (classifier.eResource() == null)) {
			return null;
		}

		URI uri = classifier.eResource().getURI();

		// URIConverter uriConverter = resource.getResourceSet().getURIConverter();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if(uri.segmentCount() < 2) {
			return null;
		}
		IProject modelProject = root.getProject(uri.segment(1));
		if(modelProject.exists()) {
			try {
				// check whether the project is a C or C++ project
				if(modelProject.hasNature(CProjectNature.C_NATURE_ID) ||
					modelProject.hasNature(CCProjectNature.CC_NATURE_ID))
				{
					String name = classifier.getName();
					// System.err.println("regen: " + name);

					// get the container for the current element
					ModelElementsCreator mec = new CppModelElementsCreator(modelProject);
					IContainer srcPkg = mec.getContainer(classifier);
					try {
						mec.createPackageableElement(srcPkg, null, classifier); // need listener for sync in both directions!
					} catch (CoreException coreException) {
						return null;
					}
					IFile cppFile = srcPkg.getFile(new Path(name + ".cpp"));	// TODO: extension is configurable!
					IFile hFile = srcPkg.getFile(new Path(name + ".h"));
					if(!cppFile.exists()) {
						return null;
					}
					if(cppFile != null) {
						cppFile.refreshLocal(0, null);
					}
					if(hFile != null) {
						hFile.refreshLocal(0, null);
					}

					return cppFile;
					// IStorage storage = new TextStorage(string);
				}
			} catch (CoreException e) {
			}
		}

		return null;
	}
}
