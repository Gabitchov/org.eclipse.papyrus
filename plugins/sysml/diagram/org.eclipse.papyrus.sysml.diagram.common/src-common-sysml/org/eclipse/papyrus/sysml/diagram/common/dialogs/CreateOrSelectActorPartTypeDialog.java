/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.common.dialogs;

import org.eclipse.papyrus.sysml.diagram.common.messages.Messages;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of ActorPart (Property) type (the type is either selected or created).
 */
public class CreateOrSelectActorPartTypeDialog extends CreateOrSelectTypeDialog {

	/** Constructor */
	public CreateOrSelectActorPartTypeDialog(Shell shell, NamedElement owner) {
		super(shell, owner, UMLElementTypes.ACTOR, UMLPackage.eINSTANCE.getTypedElement_Type(), UMLPackage.eINSTANCE.getActor(), UMLElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage_PackagedElement(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDialogTitle() {
		return Messages.CreateOrSelectActorPartTypeDialog_DialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionTitle() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectionSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionRadioLabel() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectionSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionTitle() {
		return Messages.CreateOrSelectActorPartTypeDialog_CreationSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionRadioLabel() {
		return Messages.CreateOrSelectActorPartTypeDialog_CreationSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeNameLabel() {
		return Messages.CreateOrSelectActorPartTypeDialog_NewTypeNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerNameLabel() {
		return Messages.CreateOrSelectActorPartTypeDialog_NewTypeContainerNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogTitle() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectNewTypeContainerDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogMessage() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectNewTypeContainerDialogMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogTitle() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectTypeDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogMessage() {
		return Messages.CreateOrSelectActorPartTypeDialog_SelectTypeDialogMessage;
	}
}
