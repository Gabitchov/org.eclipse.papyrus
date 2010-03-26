/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.dialogs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.preferences.IActivityPreferenceConstants;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.UMLItemPropertyDescriptor;

/**
 * This class provides a dialog to initialize a CallOperationAction at its creation.
 */
public class CreateCallOperationActionDialog extends CreateCallActionDialog {

	/**
	 * Create a new dialog to initialize a CallOperationAction.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateCallOperationActionDialog(Shell shell, Activity owner) {
		super(shell, owner);
	}

	/**
	 * Get the id of the preference storing whether selection is the default choice.
	 * 
	 * @return preference id
	 */
	protected String getSelectionIsDefaultPreference() {
		return IActivityPreferenceConstants.PREF_NEW_CALL_OPERATION_ACTION_SELECT_AS_DEFAULT;
	}

	/**
	 * Get the id of the preference storing the last selected owner.
	 * 
	 * @return preference id
	 */
	protected String getCreationDefaultOwnerPreference() {
		return IActivityPreferenceConstants.PREF_NEW_CALL_OPERATION_ACTION_CREATION_OWNER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getInvocationFeature()
	 */
	@Override
	protected EReference getInvocationFeature() {
		return UMLPackage.eINSTANCE.getCallOperationAction_Operation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getPossibleInvokedTypes()
	 */
	@Override
	protected EClass[] getPossibleInvokedTypes() {
		return new EClass[]{ UMLPackage.eINSTANCE.getOperation() };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#hasOutParameters(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean hasOutParameters(EObject invokedObject) {
		if(invokedObject instanceof Operation) {
			for(Parameter param : ((Operation)invokedObject).getOwnedParameters()) {
				if(ParameterDirectionKind.INOUT_LITERAL.equals(param.getDirection()) || ParameterDirectionKind.OUT_LITERAL.equals(param.getDirection())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getPossibleInvokedParents()
	 */
	@Override
	protected Set<EObject> getPossibleInvokedParents(EObject actionParent) {
		Collection<EObject> classes = UMLItemPropertyDescriptor.getReachableObjectsOfType(actionParent, UMLPackage.eINSTANCE.getClass_());
		Set<EObject> result = new HashSet<EObject>(classes);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateInvocationActionDialog#isPossibleInvokedParent(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean isPossibleInvokedParent(EObject parent) {
		return parent instanceof Class;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionTitle()
	 */
	@Override
	protected String getInvocationCreationSectionTitle() {
		return Messages.CreateCallActionDialog_OperationInvocationCreationTitle;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionHelp()
	 */
	@Override
	protected String getInvocationCreationSectionHelp() {
		return Messages.CreateCallActionDialog_OperationInvocationCreationHelp;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationSelectionSectionTitle()
	 */
	@Override
	protected String getInvocationSelectionSectionTitle() {
		return Messages.CreateCallActionDialog_OperationInvocationSelectionTitle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getTitle()
	 */
	@Override
	protected String getTitle() {
		return Messages.CreateCallActionDialog_OperationTitle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getCreationLabel()
	 */
	@Override
	protected String getCreationLabel() {
		return Messages.CreateCallActionDialog_CreateOperation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getSelectionLabel()
	 */
	@Override
	protected String getSelectionLabel() {
		return Messages.CreateCallActionDialog_SelectOperation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getParentImage()
	 */
	@Override
	protected Image getParentImage() {
		return UMLElementTypes.getImage(UMLPackage.eINSTANCE.getClass_());
	}

}
