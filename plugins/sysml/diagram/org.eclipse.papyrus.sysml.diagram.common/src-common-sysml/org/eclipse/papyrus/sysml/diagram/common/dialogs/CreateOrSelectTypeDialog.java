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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.diagram.common.messages.Messages;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of Property type (the type is either selected or created).
 */
public class CreateOrSelectTypeDialog extends FormDialog {

	protected Button creationRadio;

	protected Button selectionRadio;

	protected Text newTypeNameText;

	protected Text newTypeContainerNameText;

	protected Button newTypeContainerButton;

	protected String newTypeName = null;

	protected ICommand newTypeCreateCommand = null;

	protected EObject newTypeContainer = null;

	protected Text existingTypeNameText;

	protected Button existingTypeButton;

	protected EObject existingType = null;

	protected EObject defaultContainer;

	protected ILabelProvider labelProvider;

	protected IElementType elementType;

	protected EStructuralFeature editedFeature;

	protected EClass elementEClass;

	protected IElementType containerType;

	protected EStructuralFeature containerFeature;

	protected EClass containerEClass;

	protected List<?> notWantedMetaclasses;

	/**
	 * Create a new dialog to initialize an ActivityParameterNode.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateOrSelectTypeDialog(Shell shell, EObject defaultContainer, IElementType elementType, EStructuralFeature editedFeature, EClass elementEClass, IElementType containerType, EStructuralFeature containerFeature, EClass containerEClass) {
		super(shell);
		this.defaultContainer = defaultContainer;
		this.elementType = elementType;
		this.editedFeature = editedFeature;
		this.elementEClass = elementEClass;
		this.containerType = containerType;
		this.containerFeature = containerFeature;
		this.containerEClass = containerEClass;
		this.labelProvider = new UMLLabelProvider();
		this.notWantedMetaclasses = new LinkedList<Object>();
	}

	/**
	 * Create a new dialog to initialize an ActivityParameterNode.
	 * This dialog will filter certain Stereotypes
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateOrSelectTypeDialog(Shell shell, EObject defaultContainer, IElementType elementType, EStructuralFeature editedFeature, EClass elementEClass, IElementType containerType, EStructuralFeature containerFeature, EClass containerEClass, List<?> notWantedMetaclasses) {
		this(shell, defaultContainer, elementType, editedFeature, elementEClass, containerType, containerFeature, containerEClass);
		this.notWantedMetaclasses = notWantedMetaclasses;
	}

	protected String getDialogTitle() {
		return Messages.CreateOrSelectTypeDialog_DialogTitle;
	}

	protected String getSelectionSectionTitle() {
		return Messages.CreateOrSelectTypeDialog_SelectionSectionTitle;
	}

	protected String getSelectionSectionRadioLabel() {
		return Messages.CreateOrSelectTypeDialog_SelectionSectionRadioLabel;
	}

	protected String getCreationSectionTitle() {
		return Messages.CreateOrSelectTypeDialog_CreationSectionTitle;
	}

	protected String getCreationSectionRadioLabel() {
		return Messages.CreateOrSelectTypeDialog_CreationSectionRadioLabel;
	}

	protected String getNewTypeNameLabel() {
		return Messages.CreateOrSelectTypeDialog_NewTypeNameLabel;
	}

	protected String getNewTypeContainerNameLabel() {
		return Messages.CreateOrSelectTypeDialog_NewTypeContainerNameLabel;
	}

	protected String getNewTypeContainerDialogTitle() {
		return Messages.CreateOrSelectTypeDialog_SelectNewTypeContainerDialogTitle;
	}

	protected String getNewTypeContainerDialogMessage() {
		return Messages.CreateOrSelectTypeDialog_SelectNewTypeContainerDialogMessage;
	}

	protected String getTypeDialogTitle() {
		return Messages.CreateOrSelectTypeDialog_SelectTypeDialogTitle;
	}

	protected String getTypeDialogMessage() {
		return Messages.CreateOrSelectTypeDialog_SelectTypeDialogMessage;
	}

	/**
	 * Create the form to :
	 * 
	 * - ask the user to choose or create an existing element.
	 * 
	 * @see org.eclipse.ui.forms.FormDialog#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm pForm) {
		pForm.getForm().setText(getDialogTitle());
		ScrolledForm scrolledForm = pForm.getForm();
		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());

		createFormCreationSection(scrolledForm.getBody(), toolkit);
		createFormSelectionSection(scrolledForm.getBody(), toolkit);

		refreshSectionsEnable(false);
		hookListeners();
		// invoked name is set after listeners, since we count on listener to update it properly
		setNewTypeContainer(defaultContainer);
		setNewTypeName(null);

		scrolledForm.reflow(true);
	}

	/**
	 * Adds buttons to this dialog's button bar.
	 * 
	 * @param parent
	 *        the button bar composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		refreshOkButton();
	}

	/**
	 * Create the section to ask the user to choose an existing element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	protected void createFormSelectionSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getSelectionSectionTitle();
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
		selectionRadio = pToolkit.createButton(lBody, getSelectionSectionRadioLabel(), SWT.RADIO);
		selectionRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		// manage elementType selection
		pToolkit.createLabel(lBody, elementType.getDisplayName(), SWT.NONE);
		existingTypeNameText = pToolkit.createText(lBody, "", SWT.BORDER | SWT.READ_ONLY);
		existingTypeNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		existingTypeButton = pToolkit.createButton(lBody, "...", SWT.FLAT);

		Image image = Activator.getInstance().getImage(elementType.getEClass());
		if(elementEClass != null) {
			image = Activator.getInstance().getImage(elementEClass);
		}

		existingTypeButton.setImage(image);
		existingTypeButton.setLayoutData(new GridData(SWT.NONE));

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Create the section to ask the user to create an invoked element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
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

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}


	@Override
	protected void okPressed() {

		// Build type creation command if needed
		boolean isSelectionMode = selectionRadio.getSelection();
		if(!isSelectionMode) {
			// Creation mode - Prepare type creation command and set existing type to null.
			existingType = null;
			buildNewTypeCreateCommand();

		} else {
			// Selection mode - Set the type creation command to null.
			newTypeCreateCommand = null;
		}

		super.okPressed();
	}

	protected void buildNewTypeCreateCommand() {
		// The new element is expected to be a NamedElement.
		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(newTypeContainer);
		if(commandService != null) {
			CreateElementRequest createTypeRequest = new CreateElementRequest(newTypeContainer, elementType);
			createTypeRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getNamedElement_Name(), newTypeNameText.getText()));
			newTypeCreateCommand = commandService.getEditCommand(createTypeRequest);
		}
	}

	public ICommand getNewTypeCreateCommand() {
		return newTypeCreateCommand;
	}

	public String getNewTypeName() {
		return newTypeNameText.getText();
	}

	public EObject getExistingType() {
		return existingType;
	}

	/**
	 * Add listeners to widgets
	 */
	protected void hookListeners() {
		// listener to choose active section
		SelectionListener selectCreateListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(creationRadio.equals(e.getSource())) {
					refreshSectionsEnable(false);
				} else {
					refreshSectionsEnable(true);
				}
				refreshOkButton();
			}
		};
		selectionRadio.addSelectionListener(selectCreateListener);
		creationRadio.addSelectionListener(selectCreateListener);

		// listener to select existing element
		SelectionListener selectBtnListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleChooseType();
				refreshOkButton();
			}
		};
		existingTypeButton.addSelectionListener(selectBtnListener);

		// listener to existing element name
		ModifyListener lNameListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setNewTypeName(existingTypeNameText.getText());
			}
		};
		existingTypeNameText.addModifyListener(lNameListener);

		// listener to select new element type container
		SelectionListener selectTypeBtnListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleChooseNewTypeContainer();
				// reset name if not set
				if(newTypeName == null) {
					setNewTypeName(null);
				}
				refreshOkButton();
			}
		};
		newTypeContainerButton.addSelectionListener(selectTypeBtnListener);

		// listener to new element name
		ModifyListener lNewNameListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				validateNewTypeName();
				refreshOkButton();
			}
		};
		newTypeNameText.addModifyListener(lNewNameListener);
	}

	/**
	 * Set the name of the new type
	 * 
	 * @param text
	 *        the text string or null for auto-initialization
	 */
	protected void setNewTypeName(String text) {
		String name = text;
		if(text == null) {
			name = NamedElementUtil.getDefaultNameWithIncrementFromBase(elementType.getEClass().getName(), newTypeContainer.eContents());
			if(elementEClass != null) {
				name = NamedElementUtil.getDefaultNameWithIncrementFromBase(elementEClass.getName(), newTypeContainer.eContents());
			}
			newTypeNameText.setText(name);

		} else {
			newTypeNameText.setText(name);
			newTypeName = name;
		}

		validateNewTypeName();
		refreshOkButton();
	}

	protected void validateNewTypeName() {
		if(isValidName(newTypeContainer, newTypeNameText.getText())) {
			Color black = newTypeNameText.getDisplay().getSystemColor(SWT.COLOR_BLACK);
			newTypeNameText.setForeground(black);

		} else {
			Color red = newTypeNameText.getDisplay().getSystemColor(SWT.COLOR_RED);
			newTypeNameText.setForeground(red);
		}
	}

	protected boolean isValidName(EObject container, String newName) {
		boolean isValid = true;
		if(container instanceof Namespace) {
			if(((Namespace)container).getOwnedMember(newName) != null) {
				isValid = false;
			}
		}

		return isValid;
	}

	/** Open the dialog to choose an existing type */
	protected void handleChooseType() {

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());

		dialog.setMessage(getTypeDialogMessage());
		dialog.setTitle(getTypeDialogTitle());
		dialog.setInput(EcoreUtil.getRootContainer(defaultContainer));

		ServiceEditContentProvider provider = new ServiceEditContentProvider(elementType, editedFeature, EcoreUtil.getRootContainer(defaultContainer));
		provider.setNotWantedMetaclasses(notWantedMetaclasses);

		dialog.setContentProvider(provider);
		dialog.setLabelProvider(labelProvider);
		
		if(dialog.open() == Window.OK) {
			Object result = dialog.getResult()[0];
			if(result instanceof IAdaptable) {
				result = EMFHelper.getEObject(result);
			}

			if(result instanceof EObject) {
				setExistingTypeSelection((EObject)result);
			} else {
				setExistingTypeSelection(null);
			}
		}
	}

	/**
	 * Set the existing type selected (if selection mode is chosen)
	 * 
	 * @param invokedElement
	 *        the selected element
	 */
	protected void setExistingTypeSelection(EObject type) {
		if(type == null) {
			existingTypeNameText.setText("");
		} else {
			existingType = type;
			existingTypeNameText.setText(labelProvider.getText(existingType));
		}
	}

	/** Open the dialog to choose new type container */
	protected void handleChooseNewTypeContainer() {

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());

		dialog.setMessage(getNewTypeContainerDialogMessage());
		dialog.setTitle(getNewTypeContainerDialogTitle());
		dialog.setInput(EcoreUtil.getRootContainer(defaultContainer));

		ServiceEditContentProvider provider = new ServiceEditContentProvider(containerType, containerFeature, EcoreUtil.getRootContainer(defaultContainer));
		dialog.setContentProvider(provider);
		dialog.setLabelProvider(labelProvider);

		if(dialog.open() == Window.OK) {
			Object result = dialog.getResult()[0];
			if(result instanceof IAdaptable) {
				result = EMFHelper.getEObject(result);
			}

			if(result instanceof EObject) {
				setNewTypeContainer((EObject)result);
			} else {
				setNewTypeContainer(null);
			}
		}
	}

	/**
	 * Define the type of the object that will be created (if creation mode is chosen)
	 * 
	 * @param the
	 *        selected parent
	 */
	protected void setNewTypeContainer(EObject container) {

		if((containerType instanceof ISpecializationType) && ((ISpecializationType)containerType).getMatcher().matches(container)) {
			newTypeContainer = container;
			newTypeContainerNameText.setText(labelProvider.getText(newTypeContainer));

		} else if(containerType.getEClass().isInstance(container)) {
			newTypeContainer = container;
			newTypeContainerNameText.setText(labelProvider.getText(newTypeContainer));

		} else {
			newTypeContainer = null;
			newTypeContainerNameText.setText("");
		}
	}

	/**
	 * Refresh the enabled and disabled elements in various sections
	 * 
	 * @param isSelectionSelected
	 *        true if we choose to select an existing element, false if we choose to create an element
	 */
	private void refreshSectionsEnable(boolean isSelectionSelected) {
		// handle radio button value
		if(isSelectionSelected) {
			creationRadio.setSelection(false);
			if(!selectionRadio.getSelection()) {
				selectionRadio.setSelection(true);
			}
		} else {
			selectionRadio.setSelection(false);
			if(!creationRadio.getSelection()) {
				creationRadio.setSelection(true);
			}
		}
		// handle disabled section
		existingTypeNameText.setEnabled(isSelectionSelected);
		existingTypeButton.setEnabled(isSelectionSelected);
		newTypeNameText.setEnabled(!isSelectionSelected);
		newTypeNameText.setFocus();
		newTypeContainerNameText.setEnabled(!isSelectionSelected);
		newTypeContainerButton.setEnabled(!isSelectionSelected);
	}


	/** Refresh the OK button activation */
	protected void refreshOkButton() {
		boolean isSelectionSelected = selectionRadio.getSelection();
		if(getButton(IDialogConstants.OK_ID) != null && !getButton(IDialogConstants.OK_ID).isDisposed()) {
			if(isSelectionSelected) {
				getButton(IDialogConstants.OK_ID).setEnabled(existingType != null);
			} else {
				getButton(IDialogConstants.OK_ID).setEnabled((newTypeContainer != null) && (isValidName(newTypeContainer, newTypeNameText.getText())));
			}
		}
	}
}
