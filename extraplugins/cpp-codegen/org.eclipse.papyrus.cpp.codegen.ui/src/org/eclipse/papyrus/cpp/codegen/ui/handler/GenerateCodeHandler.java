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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.papyrus.cpp.codegen.transformation.ModelElementsCreator;
import org.eclipse.papyrus.infra.core.utils.BusinessModelResolver;
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
				return true;
			}
		}

		selectedEObj = null;
		return super.isEnabled();
	}

	@Override
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
				ModelElementsCreator mec = new ModelElementsCreator(modelProject, headerSuffix, bodySuffix, CppCodeGenUtils.getCommentHeader());
				IContainer srcPkg = mec.getContainer(classifier);
				try {
					mec.createPackageableElement(srcPkg, null, classifier);

					IFile cppFile = srcPkg.getFile(new Path(name + "." + bodySuffix));
					IFile hFile = srcPkg.getFile(new Path(name + "." + headerSuffix));
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
