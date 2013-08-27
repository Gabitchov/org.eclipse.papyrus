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
import org.eclipse.cdt.core.CProjectNature;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Classifier;

/**
 * <b><u>SyncURI Handler</u></b>
 * <p>
 * Install a filter that only shows events corresponding to a selected URI
 */
public class GenerateCodeHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Execution
	// ------------------------------------------------------------------------

	private EObject selectedEObj;

	@Override
	public boolean isEnabled() {
		// intercept isEnabled operation in order to get selected eObject.

		// Get current selection
		Object selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}
		
		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if(businessObject instanceof EObject) {

				selectedEObj = (EObject)businessObject;
				
				URI uri = selectedEObj.eResource().getURI();

				// URIConverter uriConverter = resource.getResourceSet().getURIConverter();
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				if(uri.segmentCount() < 2) {
					return false;
				}
				IProject modelProject = root.getProject(uri.segment(1));
				if(modelProject.exists()) {
					try {
						// check whether the project is a C or C++ project
						if(modelProject.hasNature(CProjectNature.C_NATURE_ID) ||
							modelProject.hasNature(CCProjectNature.CC_NATURE_ID)) {
							return true;
						}
					}
					catch (CoreException e) {
						Activator.getDefault().getLog().log(new Status(IStatus.ERROR,
							Activator.PLUGIN_ID, e.getMessage(), e));
					}
				}
			}
		}

		selectedEObj = null;
		return false;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		if(selectedEObj instanceof Classifier) {
			Classifier classifier = (Classifier)selectedEObj;

			
			URI uri = classifier.eResource().getURI();

			// URIConverter uriConverter = resource.getResourceSet().getURIConverter();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			if(uri.segmentCount() < 2) {
				return null;
			}
			IProject modelProject = root.getProject(uri.segment(1));
			if(modelProject.exists()) {
				String name = classifier.getName();

				// get the container for the current element
				String headerSuffix = CppCodeGenUtils.getHeaderSuffix();
				String bodySuffix = CppCodeGenUtils.getBodySuffix();
				AcceleoDriver.clearErrors();
				CppModelElementsCreator mec = new CppModelElementsCreator(modelProject);
				IContainer srcPkg = mec.getContainer(classifier);
				try {
					mec.createPackageableElement(srcPkg, null, classifier);

					if (AcceleoDriver.hasErrors()) {
						MessageDialog.openInformation(new Shell(), "Errors during code generation", //$NON-NLS-1$
								"Errors occured during code generation. Please check the error log"); //$NON-NLS-1$
					}
					IFile cppFile = srcPkg.getFile(new Path(name + "." + bodySuffix)); //$NON-NLS-1$
					IFile hFile = srcPkg.getFile(new Path(name + "." + headerSuffix)); //$NON-NLS-1$
					if(!cppFile.exists()) {
						return null;
					}
					if(cppFile != null) {
						cppFile.refreshLocal(0, null);
					}
					if(hFile != null) {
						hFile.refreshLocal(0, null);
					}
				} catch (CoreException coreException) {
					return null;
				}
			}
		}
		return null;
	}
}
