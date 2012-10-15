/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This class is a Property tester used to check is current model (meaning the model currently opened in Papyrus) is a SysML Model.
 * This class is used in order to create test for deciding whether a diagram creation command should be visible or not.
 * This property tester assumes that currently active editor is Papyrus, it should be used with care (simultaneously with a test to ensure Papyrus is
 * currently opened and active).
 * 
 */
public class SysMLSelectionTester extends PropertyTester {

	/** Tester ID for SysML Model nature. This is currently a test on: is this a blocks profiles package... */
	public final static String IS_SYSML_MODEL = "isSysMLModel"; //$NON-NLS-N$
	
	/** Tester ID for SysML Requirements Model nature */
	public final static String IS_SYSML_REQUIREMENTS_MODEL = "isSysMLRequirementsModel"; //$NON-NLS-N$
	
	/** Tester ID for SysML Blocks Model nature */
	public final static String IS_SYSML_BLOCKS_MODEL = "isSysMLBlocksModel"; //$NON-NLS-N$

	/** Default constructor */
	public SysMLSelectionTester() {
	}

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure Papyrus is the active editor
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		if(editor == null) {
			return false;
		}
		Object currentValue = null;
		if(IS_SYSML_MODEL.equals(property)) {
			currentValue = testSysMLModelNature(receiver);
			return (currentValue == expectedValue);
		}  else if(IS_SYSML_BLOCKS_MODEL.equals(property)) {
			currentValue = testSysMLBlocksModelNature(receiver);
			return (currentValue == expectedValue);
		} else if(IS_SYSML_REQUIREMENTS_MODEL.equals(property)) {
			currentValue = testSysMLRequirementsModelNature(receiver);
			return (currentValue == expectedValue);
		}

		return false;
	}

	/** True is root object is a UML Model with SysML Profile (and sub profiles) applied */
	protected boolean testSysMLModelNature(Object receiver) {
		boolean isSysMLModel = false;

		EObject root = getRoot();
		if(root instanceof Package) {
			Profile sysml = UMLUtil.getProfile(SysmlPackage.eINSTANCE, root);					
			if(((Package)root).isProfileApplied(sysml)) {
				isSysMLModel = true;
			}
		}

		return isSysMLModel;
	}
	
	/** True is root object is a UML Model with SysML Requirements Profile applied */
	protected boolean testSysMLRequirementsModelNature(Object receiver) {
		boolean isSysMLModel = false;

		EObject root = getRoot();
		if(root instanceof Package) {
			Profile sysml = UMLUtil.getProfile(RequirementsPackage.eINSTANCE, root);					
			if(((Package)root).isProfileApplied(sysml)) {
				isSysMLModel = true;
			}
		}

		return isSysMLModel;
	}
	
	/** True is root object is a UML Model with SysML Blocks Profile applied */
	protected boolean testSysMLBlocksModelNature(Object receiver) {
		boolean isSysMLModel = false;

		EObject root = getRoot();
		if(root instanceof Package) {
			Profile sysml = UMLUtil.getProfile(BlocksPackage.eINSTANCE, root);					
			if(((Package)root).isProfileApplied(sysml)) {
				isSysMLModel = true;
			}
		}

		return isSysMLModel;
	}
	
	/** Returns the root EObject of currently opened model */
	private EObject getRoot() {
		EObject root = null;

		try {
			ServiceUtilsForActionHandlers serviceUtils = ServiceUtilsForActionHandlers.getInstance();
			UmlModel openedModel = (UmlModel)serviceUtils.getModelSet().getModel(UmlModel.MODEL_ID);
			if(openedModel != null) {
				root = openedModel.lookupRoot();
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		} catch (NotFoundException e) {
			Activator.log.error(e);
		}

		return root;
	}

}
