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
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.UMLItemPropertyDescriptor;

/**
 * This class provides a dialog to initialize a SendSignalAction at its creation.
 */
public class CreateSendSignalActionDialog extends CreateInvocationActionDialog {

	/**
	 * Create a new dialog to initialize a SendSignalAction.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateSendSignalActionDialog(Shell shell, Activity owner) {
		super(shell, owner);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getInvocationSectionTitle()
	 */
	@Override
	protected String getInvocationSectionTitle() {
		return Messages.CreateCallActionDialog_SignalInvocationTitle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getTitle()
	 */
	@Override
	protected String getTitle() {
		return Messages.CreateCallActionDialog_SignalTitle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getInvocationFeature()
	 */
	@Override
	protected EReference getInvocationFeature() {
		return UMLPackage.eINSTANCE.getSendSignalAction_Signal();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getPossibleInvokedParents()
	 */
	@Override
	protected Set<EObject> getPossibleInvokedParents(EObject actionParent) {
		Collection<EObject> packages = UMLItemPropertyDescriptor.getReachableObjectsOfType(actionParent, UMLPackage.eINSTANCE.getPackage());
		Set<EObject> result = new HashSet<EObject>(packages);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateInvocationActionDialog#isPossibleInvokedParent(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean isPossibleInvokedParent(EObject parent) {
		return parent instanceof Package;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getPossibleInvokedTypes()
	 */
	@Override
	protected EClass[] getPossibleInvokedTypes() {
		return new EClass[]{ UMLPackage.eINSTANCE.getSignal() };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getCreationLabel()
	 */
	@Override
	protected String getCreationLabel() {
		return Messages.CreateCallActionDialog_CreateSignal;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getSelectionLabel()
	 */
	@Override
	protected String getSelectionLabel() {
		return Messages.CreateCallActionDialog_SelectSignal;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallActionDialog#getParentImage()
	 */
	@Override
	protected Image getParentImage() {
		return UMLElementTypes.getImage(UMLPackage.eINSTANCE.getPackage());
	}

}
