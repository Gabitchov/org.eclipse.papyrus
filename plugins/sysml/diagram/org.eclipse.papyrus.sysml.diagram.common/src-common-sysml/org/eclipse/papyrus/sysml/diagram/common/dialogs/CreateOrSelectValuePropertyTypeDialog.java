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

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.gmf.diagram.common.provider.ElementTypeLabelProvider;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.diagram.common.messages.Messages;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of Value (Property) type (the type is either selected or created).
 */
public class CreateOrSelectValuePropertyTypeDialog extends CreateOrSelectTypeDialog {

	protected ComboViewer newTypeKindComboViewer = null;

	protected Combo newTypeKindCombo = null;

	protected IElementType[] valueTypeKind = { UMLElementTypes.DATA_TYPE, SysMLElementTypes.VALUE_TYPE, UMLElementTypes.PRIMITIVE_TYPE, UMLElementTypes.ENUMERATION };

	protected IElementType newTypeKind = UMLElementTypes.DATA_TYPE;

	/** Constructor */
	public CreateOrSelectValuePropertyTypeDialog(Shell shell, NamedElement owner) {
		super(shell, owner, UMLElementTypes.DATA_TYPE, UMLPackage.eINSTANCE.getTypedElement_Type(), null, UMLElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage_PackagedElement(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormCreationSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getCreationSectionTitle();
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);

		// content of the section
		creationRadio = pToolkit.createButton(lBody, getCreationSectionRadioLabel(), SWT.RADIO);
		creationRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		pToolkit.createLabel(lBody, getNewTypeNameLabel(), SWT.NONE);
		newTypeNameText = pToolkit.createText(lBody, "", SWT.BORDER);
		newTypeNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		newTypeNameText.setFocus();

		// manage type selection
		pToolkit.createLabel(lBody, getNewTypeContainerNameLabel(), SWT.NONE);
		newTypeContainerNameText = pToolkit.createText(lBody, labelProvider.getText(newTypeContainer), SWT.BORDER | SWT.READ_ONLY);
		newTypeContainerNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		newTypeContainerButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = Activator.getInstance().getImage(containerType.getEClass());
		if(containerEClass != null) {
			image = Activator.getInstance().getImage(containerEClass);
		}
		newTypeContainerButton.setImage(image);
		newTypeContainerButton.setLayoutData(new GridData(SWT.NONE));

		pToolkit.createLabel(lBody, getNewTypeKindLabel(), SWT.NONE);
		newTypeKindCombo = new Combo(lBody, SWT.DROP_DOWN | SWT.READ_ONLY);
		newTypeKindComboViewer = new ComboViewer(newTypeKindCombo);
		pToolkit.adapt(newTypeKindCombo);
		newTypeKindCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		newTypeKindComboViewer.setLabelProvider(new ElementTypeLabelProvider());
		newTypeKindComboViewer.add(valueTypeKind);
		newTypeKindComboViewer.setSelection(new StructuredSelection(valueTypeKind[0]));

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildNewTypeCreateCommand() {
		// The new element is expected to be a NamedElement.
		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(newTypeContainer);
		if(commandService != null) {
			CreateElementRequest createTypeRequest = new CreateElementRequest(newTypeContainer, newTypeKind);
			createTypeRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getNamedElement_Name(), newTypeNameText.getText()));
			newTypeCreateCommand = commandService.getEditCommand(createTypeRequest);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void hookListeners() {
		super.hookListeners();

		// listener to select invocation type
		ModifyListener newTypeKindListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				ISelection sel = newTypeKindComboViewer.getSelection();
				if(sel instanceof StructuredSelection) {
					Object type = ((StructuredSelection)sel).getFirstElement();
					if(type instanceof IElementType) {
						newTypeKind = (IElementType)type;
					} else {
						newTypeKind = null;
					}

					// reset name
					setNewTypeName(null);
				}
			}
		};
		newTypeKindCombo.addModifyListener(newTypeKindListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setNewTypeName(String text) {
		String name = text;
		if(text == null) {
			name = NamedElementUtil.getDefaultNameWithIncrementFromBase(newTypeKind.getEClass().getName(), newTypeContainer.eContents());
			if(newTypeKind == SysMLElementTypes.VALUE_TYPE) {
				name = NamedElementUtil.getDefaultNameWithIncrementFromBase(BlocksPackage.eINSTANCE.getValueType().getName(), newTypeContainer.eContents());
			}
			newTypeNameText.setText(name);

		} else {
			newTypeNameText.setText(name);
			newTypeName = name;
		}

		validateNewTypeName();
		refreshOkButton();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDialogTitle() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_DialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionTitle() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectionSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSelectionSectionRadioLabel() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectionSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionTitle() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_CreationSectionTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getCreationSectionRadioLabel() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_CreationSectionRadioLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeNameLabel() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_NewTypeNameLabel;
	}

	/**
	 * Get the newTypeKind label.
	 * 
	 * @return the label
	 */
	protected String getNewTypeKindLabel() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_NewTypeKindLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerNameLabel() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_NewTypeContainerNameLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogTitle() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectNewTypeContainerDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getNewTypeContainerDialogMessage() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectNewTypeContainerDialogMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogTitle() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectTypeDialogTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTypeDialogMessage() {
		return Messages.CreateOrSelectValuePropertyTypeDialog_SelectTypeDialogMessage;
	}
}
