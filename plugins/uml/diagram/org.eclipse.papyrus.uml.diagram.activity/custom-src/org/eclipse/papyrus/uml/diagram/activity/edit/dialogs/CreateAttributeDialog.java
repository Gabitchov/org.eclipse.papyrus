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
package org.eclipse.papyrus.uml.diagram.activity.edit.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.actions.LabelHelper;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * DialogBox in order to link a parameter with the new ActivityParameterNode
 * that will be created
 * 
 */
public class CreateAttributeDialog extends FormDialog {

	private Text creationNameText;

	private Text creationTypeText;

	private Button creationTypeButton;

	private Property createdProperty = null;

	private EObject selectedType = null;

	private NamedElement attributeOwner;

	private String selectedName = null;

	private EClass selectedEClass = null;

	private ComboViewer eClassComboViewer = null;

	private Combo creationEClassCombo = null;

	private ILabelProvider labelProvider;

	/**
	 * Create a new dialog to initialize an ActivityParameterNode.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateAttributeDialog(Shell shell, NamedElement owner) {
		super(shell);
		attributeOwner = owner;
		labelProvider = getCustomLabelProvider();
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
		pForm.getForm().setText(getTitle());
		ScrolledForm scrolledForm = pForm.getForm();
		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());
		createAttributeSection(scrolledForm.getBody(), toolkit);
		hookListeners();
		// invoked name is set after listeners, since we count on listener to
		// update it properly
		setInvokedName(null);
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
	 * Create the section to ask the user to create an attribute.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	protected void createAttributeSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getCreationTitle();
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
		// eclass
		pToolkit.createLabel(lBody, getEClassLabel(), SWT.NONE);
		creationEClassCombo = new Combo(lBody, SWT.DROP_DOWN | SWT.READ_ONLY);
		eClassComboViewer = new ComboViewer(creationEClassCombo);
		pToolkit.adapt(creationEClassCombo);
		creationEClassCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		eClassComboViewer.setLabelProvider(labelProvider);
		eClassComboViewer.add(getPossibleAttributes());
		if(getPossibleAttributes().length > 1) {
			// initialize selection
			eClassComboViewer.setSelection(new StructuredSelection(getPossibleAttributes()[0]));
			selectedEClass = getPossibleAttributes()[0];
		}
		// name
		pToolkit.createLabel(lBody, getNameLabel(), SWT.NONE);
		creationNameText = pToolkit.createText(lBody, "", SWT.BORDER);
		creationNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		creationNameText.setFocus();
		// manage type selection
		pToolkit.createLabel(lBody, getTypeLabel(), SWT.NONE);
		creationTypeText = pToolkit.createText(lBody, labelProvider.getText(selectedType), SWT.BORDER | SWT.READ_ONLY);
		creationTypeText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		creationTypeButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = getTypeImage();
		creationTypeButton.setImage(image);
		creationTypeButton.setLayoutData(new GridData(SWT.NONE));
		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Set correctly the object, by creating it if needed. Then, notifies that
	 * the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		// create element
		createdProperty = (Property)UMLFactory.eINSTANCE.create(selectedEClass);
		createdProperty.setName(selectedName);
		createdProperty.setType((Type)selectedType);
		addAttribute(createdProperty);
		super.okPressed();
	}

	/**
	 * Get the invoked object that have been selected or created.
	 * 
	 * @return the invoked object to use.
	 */
	public Property getCreatedAttribute() {
		return createdProperty;
	}

	/**
	 * Add listeners to widgets
	 */
	private void hookListeners() {
		if(creationEClassCombo != null && eClassComboViewer != null) {
			// listener to select invocation eclass
			ModifyListener lTypeListener = new ModifyListener() {

				/**
				 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
				 */
				public void modifyText(ModifyEvent e) {
					ISelection sel = eClassComboViewer.getSelection();
					if(sel instanceof StructuredSelection) {
						Object type = ((StructuredSelection)sel).getFirstElement();
						if(type instanceof EClass) {
							selectedEClass = (EClass)type;
						} else {
							selectedEClass = null;
						}
						// reset name
						setInvokedName(null);
						refreshOkButton();
					}
				}
			};
			creationEClassCombo.addModifyListener(lTypeListener);
		}
		// listener to invocation element name
		ModifyListener lNameListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setInvokedName(creationNameText.getText());
			}
		};
		creationNameText.addModifyListener(lNameListener);
		// listener to select new element parent
		SelectionListener selectParentBtnListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleChooseType();
				// reset name if not set
				if(selectedName == null) {
					setInvokedName(null);
				}
				refreshOkButton();
			}
		};
		creationTypeButton.addSelectionListener(selectParentBtnListener);
	}

	/**
	 * Set the name chosen for the invoked element
	 * 
	 * @param text
	 *        the text string or null for auto-initialization
	 */
	private void setInvokedName(String text) {
		String name = text;
		if(text == null && selectedEClass != null) {
			name = LabelHelper.INSTANCE.findName(attributeOwner, selectedEClass);
			// the name assignment will be performed by listener's call
			creationNameText.setText(name);
		} else if(name != null && !"".equals(name.trim())) {
			selectedName = name.trim();
			Color black = creationNameText.getDisplay().getSystemColor(SWT.COLOR_BLACK);
			creationNameText.setForeground(black);
			refreshOkButton();
		} else {
			selectedName = null;
			Color red = creationNameText.getDisplay().getSystemColor(SWT.COLOR_RED);
			creationNameText.setForeground(red);
			refreshOkButton();
		}
	}

	/**
	 * Open the dialog to choose the type of element to create
	 * 
	 */
	private void handleChooseType() {
		Set<Object> types = getPossibleTypes();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(types.toArray());
		if(dialog.open() == Window.OK) {
			Object firstResult = dialog.getFirstResult();
			if(firstResult instanceof EObject) {
				setType((EObject)dialog.getFirstResult());
			} else {
				setType(null);
			}
		}
	}

	/**
	 * Define the type of the object that will be created
	 * 
	 * @param type
	 *        the selected type
	 */
	private void setType(EObject type) {
		selectedType = type;
		if(selectedType instanceof NamedElement) {
			creationTypeText.setText(labelProvider.getText(selectedType));
		} else {
			creationTypeText.setText("");
		}
	}

	/**
	 * Refresh the OK button activation
	 */
	private void refreshOkButton() {
		if(getButton(IDialogConstants.OK_ID) != null && !getButton(IDialogConstants.OK_ID).isDisposed()) {
			getButton(IDialogConstants.OK_ID).setEnabled(selectedEClass != null && selectedName != null);
		}
	}

	/**
	 * Add the created invoked object to its selected parent
	 */
	protected void addAttribute(Property createdAttribute) {
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		// Let the command find the relation on its own.
		Command addCmd = AddCommand.create(editingdomain, attributeOwner, null, Collections.singleton(createdAttribute));
		addCmd.execute();
	}

	/**
	 * Gets the possible types for the parameter
	 * 
	 * @return the possible types
	 */
	private Set<Object> getPossibleTypes() {
		Collection<EObject> types = ModelSetQuery.getObjectsOfType(attributeOwner, UMLPackage.eINSTANCE.getTypedElement_Type().getEType());
		Set<Object> result = new HashSet<Object>();
		result.add("");
		result.addAll(types);
		return result;
	}

	/**
	 * Gets the custom label provider that parses label for EClass
	 * 
	 * @return the custom label provider
	 */
	private ILabelProvider getCustomLabelProvider() {
		AdapterFactoryLabelProvider adapterFactory = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()) {

			/**
			 * Override label provider for EClass
			 * 
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object object) {
				String text = super.getText(object);
				if(object instanceof EClass) {
					return text.substring(0, text.indexOf("[") - 1);
				} else {
					return text;
				}
			}
		};
		return adapterFactory;
	}

	/**
	 * Get possible classes to create an attribute
	 * 
	 * @return classes inheriting {@link Property}
	 */
	protected EClass[] getPossibleAttributes() {
		return new EClass[]{ UMLPackage.eINSTANCE.getProperty(), UMLPackage.eINSTANCE.getExtensionEnd(), UMLPackage.eINSTANCE.getPort() };
	}

	private Image getTypeImage() {
		return UMLElementTypes.getImage(UMLPackage.eINSTANCE.getPackage_PackagedElement());
	}

	private String getTitle() {
		return CustomMessages.CreateAttributeDialog_DialogTitle;
	}

	private String getCreationTitle() {
		return CustomMessages.CreateAttributeDialog_CreationTitle;
	}

	private String getNameLabel() {
		return CustomMessages.CreateAttributeDialog_NameLabel;
	}

	private String getEClassLabel() {
		return CustomMessages.CreateAttributeDialog_EClassLabel;
	}

	private String getTypeLabel() {
		return CustomMessages.CreateAttributeDialog_TypeLabel;
	}
}
