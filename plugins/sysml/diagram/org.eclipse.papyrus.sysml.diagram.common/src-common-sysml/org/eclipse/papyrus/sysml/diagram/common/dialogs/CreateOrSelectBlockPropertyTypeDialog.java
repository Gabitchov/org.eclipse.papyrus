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

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.common.messages.Messages;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of Part (Property) type (the type is either selected or created).
 */
public class CreateOrSelectBlockPropertyTypeDialog extends CreateOrSelectTypeDialog {

	/** Constructor */
	public CreateOrSelectBlockPropertyTypeDialog(Shell shell, NamedElement owner) {
		super(shell, owner, SysMLElementTypes.BLOCK, UMLPackage.eINSTANCE.getTypedElement_Type(), BlocksPackage.eINSTANCE.getBlock(), UMLElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage_PackagedElement(), null, getConstraintBlockAsStereotype());
	}
	
	/**
	 * If we create a Part type by a ConstraintBlock, thisPart will become a ConstraintProperty and representation will immediately disappear.
	 * So we filter ConstraintBlock type => Only strict Block are allowed 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private static List<?> getConstraintBlockAsStereotype() {
		// We create a mock Stereotype to pass in the good code section of SemanticUMLContentProvider.isCompatibleMetaclass (bad gestion of static stereotypes)
		Stereotype mockStereotype = UMLFactory.eINSTANCE.createStereotype();
		// We use this stereotype with namespace instead of ConstraintsPackage.eINSTANCE.getConstraintBlock()
		mockStereotype.setName(SysmlResource.CONSTRAINT_BLOCK_ID);
		return Arrays.asList(mockStereotype);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDialogTitle() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_DialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionTitle() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectionSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionRadioLabel() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectionSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionTitle() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_CreationSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionRadioLabel() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_CreationSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeNameLabel() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_NewTypeNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerNameLabel() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_NewTypeContainerNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogTitle() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectNewTypeContainerDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogMessage() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectNewTypeContainerDialogMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogTitle() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectTypeDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogMessage() {
		return Messages.CreateOrSelectBlockPropertyTypeDialog_SelectTypeDialogMessage;
	}
}
