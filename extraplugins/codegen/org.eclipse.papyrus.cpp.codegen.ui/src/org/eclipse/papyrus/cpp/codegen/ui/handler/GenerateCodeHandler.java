/*******************************************************************************
 * Copyright (c) 2012 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ansgar Radermacher - Initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.ui.handler;

import org.eclipse.cdt.core.CCProjectNature;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.ui.handlers.CmdHandler;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.ui.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Handler for C++ code generation
 */
public class GenerateCodeHandler extends CmdHandler {

	// ------------------------------------------------------------------------
	// Execution
	// ------------------------------------------------------------------------

	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		
		if (selectedEObject != null) {
			URI uri = selectedEObject.eResource().getURI();

			// URIConverter uriConverter = resource.getResourceSet().getURIConverter();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			if(uri.segmentCount() < 2) {
				return false;
			}
			IProject modelProject = root.getProject(uri.segment(1));
			return modelProject.exists();
		}

		return false;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		if(selectedEObject instanceof PackageableElement) {
			PackageableElement pe = (PackageableElement)selectedEObject;

			IProject modelProject = getTargetProject(pe);
			if(modelProject == null) {
				return null;
			}
			
			// get the container for the current element
			AcceleoDriver.clearErrors();
			CppModelElementsCreator mec = new CppModelElementsCreator(modelProject);
			IContainer srcPkg = mec.getContainer(pe);
			try {
				mec.createPackageableElement(srcPkg, null, pe);
				
				if (AcceleoDriver.hasErrors()) {
					MessageDialog.openInformation(new Shell(), "Errors during code generation", //$NON-NLS-1$
							"Errors occured during code generation. Please check the error log"); //$NON-NLS-1$
				}	
			}
			catch (CoreException coreException) {
				Activator.log.error(coreException);
				return null;
			}
			finally {
				// Refresh the container for the newly created files.  This needs to be done even
					// during error because of the possibility for partial results.
				try {
					srcPkg.refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch(CoreException e) {
					Activator.log.error(e);
	 			}
			}
		}
		return null;
	}
	
	/**
	 * Locate and return the target project for the given packagable element.  Return null if
	 * no target project can be found.
	 *
	 * Ensures that the target project is correctly setup to contain generated C/C++ code.  Does
	 * not create a new project, but may modify existing ones.
	*/
	private static IProject getTargetProject(PackageableElement pe) {
		URI uri = pe.eResource().getURI();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if(uri.segmentCount() < 2)
			return null;
			
		IProject modelProject = root.getProject(uri.segment(1));
		if(!modelProject.exists())
			return null;
	
		// Make sure the target project has the C and C++ build natures.
		try {
			if(!modelProject.hasNature(CCProjectNature.CC_NATURE_ID)) {
				boolean apply = MessageDialog.openQuestion(new Shell(),
						"Need to apply C++ nature", "Code generation requires that the underlying project has a C++ nature. Do you want to apply this nature?");
				if (!apply) {
					return null;
				}
				CCProjectNature.addCCNature(modelProject, null);
			}
		}
		catch(CoreException e) {
			Activator.log.error(e);
		}
		return modelProject;
	}
}
