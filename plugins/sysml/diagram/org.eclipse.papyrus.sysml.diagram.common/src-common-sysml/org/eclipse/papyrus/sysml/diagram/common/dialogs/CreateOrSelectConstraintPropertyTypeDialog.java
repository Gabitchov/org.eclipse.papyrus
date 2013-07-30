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
package org.eclipse.papyrus.sysml.diagram.common.dialogs;

import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.diagram.common.messages.Messages;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of Part (Property) type (the type is either selected or created).
 */
public class CreateOrSelectConstraintPropertyTypeDialog extends CreateOrSelectTypeDialog {

	/** Constructor */
	public CreateOrSelectConstraintPropertyTypeDialog(Shell shell, NamedElement owner) {
		super(shell, owner, SysMLElementTypes.CONSTRAINT_BLOCK, UMLPackage.eINSTANCE.getTypedElement_Type(), ConstraintsPackage.eINSTANCE.getConstraintBlock(), UMLElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage_PackagedElement(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDialogTitle() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_DialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionTitle() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectionSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionRadioLabel() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectionSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionTitle() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_CreationSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionRadioLabel() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_CreationSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeNameLabel() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_NewTypeNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerNameLabel() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_NewTypeContainerNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogTitle() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectNewTypeContainerDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogMessage() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectNewTypeContainerDialogMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogTitle() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectTypeDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogMessage() {
		return Messages.CreateOrSelectConstraintPropertyTypeDialog_SelectTypeDialogMessage;
	}
	
}
