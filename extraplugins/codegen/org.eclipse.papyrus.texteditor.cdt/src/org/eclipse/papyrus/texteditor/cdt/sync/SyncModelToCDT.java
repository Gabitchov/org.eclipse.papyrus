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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.acceleo.ModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.utils.LocateCppProject;
import org.eclipse.papyrus.infra.core.Activator;
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

		IProject modelProject = LocateCppProject.getTargetProject(classifier);
		if(modelProject == null) {
			return null;
		}

		IContainer srcPkg = null;
		IFile cppFile = null;
		try {
			String name = classifier.getName();
			// System.err.println("regen: " + name);

			// get the container for the current element
			ModelElementsCreator mec = new CppModelElementsCreator(modelProject);
			srcPkg = mec.getContainer(classifier);
			mec.createPackageableElement(srcPkg, null, classifier); // need listener for sync in both directions!
		
			cppFile = srcPkg.getFile(new Path(name + ".cpp"));	// TODO: extension is configurable! //$NON-NLS-1$
	
			// IStorage storage = new TextStorage(string);
		}
		catch (CoreException e) {
			Activator.log.error(e);
		}
		finally {
			// Refresh the container for the newly created files.  This needs to be done even
				// during error because of the possibility for partial results.
			try {
				if (srcPkg != null) {
					srcPkg.refreshLocal(IResource.DEPTH_INFINITE, null);
				}
			} catch(CoreException e) {
				Activator.log.error(e);
 			}
		}
		return cppFile;
	}
}
