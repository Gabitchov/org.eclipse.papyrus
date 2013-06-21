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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForSelection;
import org.eclipse.papyrus.robotml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

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

	/** True is root object is a UML Model with Proteus Profile (and sub profiles) applied */
	protected boolean testRobotmlModelNature(Object receiver) {
		boolean isRobotmlModel = false;



		EObject root = getRoot(receiver);
		if(root instanceof Package) {

			Profile robotml = UMLUtil.getProfile(RobotMLPackage.eINSTANCE, root);

			if(((Package)root).isProfileApplied(robotml)) {
				isRobotmlModel = true;
			}
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
				ServiceUtilsForSelection serviceUtils = ServiceUtilsForSelection.getInstance();
				UmlModel openedModel = (UmlModel)serviceUtils.getModelSet(selection).getModel(UmlModel.MODEL_ID);
				if(openedModel != null) {
					root = openedModel.lookupRoot();
				}
			} catch (ServiceException e) {
				//Ignored: The selection cannot be used to retrieve the ServicesRegistry
			} catch (NotFoundException e) {
				Activator.log.error(e);
			}
		}

		return root;
	}


}
