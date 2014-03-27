/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.common.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForSelection;
import org.eclipse.papyrus.robotml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;

/**
 * This class is a Property tester used to check if current model (meaning the model currently opened in Papyrus) is a Proteus Model.
 * This class is used in order to create test for deciding whether a diagram creation command should be visible or not.
 * This property tester assumes that currently active editor is Papyrus, it should be used with care (simultaneously with a test to ensure Papyrus is
 * currently opened and active).
 *
 */
public class RobotmlSelectionTester extends PropertyTester {

	/** Tester ID for UML Model nature */
	public final static String IS_ROBOTML_MODEL = "isRobotmlModel";


	//public static String ROBOTML_ID = "RobotML";

	/** Default constructor */
	public RobotmlSelectionTester() {
	}

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure Papyrus is the active editor
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if((editor == null) || (!(editor instanceof IMultiDiagramEditor))) {
			return false;
		}

		Object currentValue = null;
		if(IS_ROBOTML_MODEL.equals(property)) {
			currentValue = testRobotmlModelNature(receiver);
			return (currentValue == expectedValue);
		}


		return false;
	}

	/** True is root object is a UML Model with RobotML Profile (and sub profiles) applied */
	protected boolean testRobotmlModelNature(Object receiver) {
		boolean isRobotmlModel = false;



		EObject root = getRoot(receiver);
		if(root instanceof Package) {
			return (((Package)root).getAppliedProfile("RobotML") != null);

			//FIX: UMLUtil.getProfile() loads the profile into the resource set. This is not desired.
			//
			//			Profile robotml = UMLUtil.getProfile(RobotMLPackage.eINSTANCE, root);
			//
			//			if(((Package)root).isProfileApplied(robotml)) {
			//				isRobotmlModel = true;
			//			}
		}


		return isRobotmlModel;
	}


	/** Returns the root EObject of currently opened model */
	private EObject getRoot(Object receiver) {
		EObject root = null;

		if(receiver instanceof ISelection) {
			ISelection selection = (ISelection)receiver;
			if(selection.isEmpty()) {
				return null;
			}

			try {
				//this is the case where the selection is on the Project Explorer
				IStructuredSelection selectionstructured = (IStructuredSelection)selection;

				Object selectedElement = selectionstructured.getFirstElement();

				Object selectedAdapter = Platform.getAdapterManager().getAdapter(selectedElement, IFile.class);


				if(selectedAdapter instanceof IFile) {
					final IFile selectedFile = (IFile)selectedAdapter;
					ModelSet modelSet = new ModelSet();
					ModelsReader reader = new ModelsReader();
					reader.readModel(modelSet);


					IPath workspacePath = selectedFile.getFullPath();

					URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);
					modelSet.loadModels(workspaceURI);

					UmlModel openedModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
					if(openedModel != null) {
						root = openedModel.lookupRoot();
					}
				} else {
					//this is the case where the selection is on the Model Explorer
					ServiceUtilsForSelection serviceUtils = ServiceUtilsForSelection.getInstance();
					UmlModel openedModel = (UmlModel)serviceUtils.getModelSet(selection).getModel(UmlModel.MODEL_ID);
					if(openedModel != null) {
						root = openedModel.lookupRoot();
					}
				}

			} catch (ServiceException e) {
				//Ignored: The selection cannot be used to retrieve the ServicesRegistry
			} catch (NotFoundException e) {
				Activator.log.error(e);
			} catch (ModelMultiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return root;
	}


}
