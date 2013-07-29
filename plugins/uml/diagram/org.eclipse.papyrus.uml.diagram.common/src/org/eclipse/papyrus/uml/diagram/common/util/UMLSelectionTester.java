/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForSelection;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * This class is a Property tester used to check is current model (meaning the model currently opened in Papyrus) is a UML Model or a UML Profile.
 * This class is used in order to create test for deciding whether a diagram creation command should be visible or not.
 * This property tester assumes that currently active editor is Papyrus, it should be used with care (simultaneously with a test to ensure Papyrus is
 * currently opened and active).
 */
public class UMLSelectionTester extends PropertyTester {

	/** Tester ID for UML Model nature */
	public final static String IS_UML_MODEL = "isUMLModel";

	/** Tester ID for UML Profile nature */
	public final static String IS_UML_PROFILE = "isUMLProfile";

	/** Default constructor */
	public UMLSelectionTester() {
	}

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure Papyrus is the active editor
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		if(editor == null) {
			return false;
		}

		Object currentValue = null;
		if(IS_UML_MODEL.equals(property)) {
			currentValue = testUMLModelNature(receiver);
			return (currentValue == expectedValue);
		} else if(IS_UML_PROFILE.equals(property)) {
			currentValue = testUMLProfileNature(receiver);
			return (currentValue == expectedValue);
		}

		return false;
	}

	/** True if root object is a UML Model */
	protected boolean testUMLModelNature(Object receiver) {
		EObject root = getRoot(receiver);

		/*
		 * For controlled resources, it is very important to consider root of UML model can be a Package. Of course, we
		 * can still exclude Profile, which should be dedicated to profile diagrams.
		 */
		return root instanceof Package && !(root instanceof Profile);
	}

	/** True if root object is a UML Profile */
	protected boolean testUMLProfileNature(Object receiver) {
		return (getRoot(receiver) instanceof Profile);
	}

	private EObject getRoot(Object receiver) {
		if(receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)receiver;
			try {
				ModelSet modelSet = ServiceUtilsForSelection.getInstance().getModelSet(selection);
				EObject root = getRoot(modelSet);
				return root;
			} catch (ServiceException ex) {
				return null;
			}
		}

		return null;
	}

	/** Returns the root EObject of currently opened model */
	private EObject getRoot(ModelSet modelSet) {
		UmlModel openedModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		if(openedModel != null) {
			EObject root;
			try {
				root = openedModel.lookupRoot();
			} catch (NotFoundException e) {
				return null;
			}
			return root;
		}

		return null;
	}
}
