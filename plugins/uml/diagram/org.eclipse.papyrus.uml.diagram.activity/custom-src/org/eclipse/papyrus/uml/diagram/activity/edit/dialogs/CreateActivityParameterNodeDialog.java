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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.papyrus.uml.diagram.common.ui.helper.HelpComponentFactory;
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
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * DialogBox in order to link a parameter with the new ActivityParameterNode
 * that will be created
 * 
 */
public class CreateActivityParameterNodeDialog extends FormDialog {

	private Button creationRadio;

	private Button selectionRadio;

	private Text selectionText;

	private Button selectionButton;

	private Text creationNameText;

	private Text creationTypeText;

	private Button creationTypeButton;

	private Parameter selectedParameter = null;

	private EObject selectedType = null;

	private Activity activityOwner;

	private String selectedName = null;

	private ParameterDirectionKind selectedDirection = null;

	private ComboViewer directionComboViewer = null;

	private Combo creationDirectionCombo = null;

	private ILabelProvider labelProvider;

	/**
	 * Create a new dialog to initialize an ActivityParameterNode.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateActivityParameterNodeDialog(Shell shell, Activity owner) {
		super(shell);
		activityOwner = owner;
		labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
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
		pForm.getForm().setText(CustomMessages.CreateActivityParameterNodeDialog_DialogTitle);
		ScrolledForm scrolledForm = pForm.getForm();
		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());
		createInvocationCreationSection(scrolledForm.getBody(), toolkit);
		createInvocationSelectionSection(scrolledForm.getBody(), toolkit);
		refreshSectionsEnable(false);
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
	 * Create the section to ask the user to choose an existing element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createInvocationSelectionSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = CustomMessages.CreateActivityParameterNodeDialog_ParameterSelectionTitle;
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}
		ImageHyperlink componentHelp = HelpComponentFactory.createHelpComponent(lSection, pToolkit, CustomMessages.CreateActivityParameterNodeDialog_ParameterSelectionHelp);
		lSection.setTextClient(componentHelp);
		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();
		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);
		// content of the section
		selectionRadio = pToolkit.createButton(lBody, CustomMessages.CreateActivityParameterNodeDialog_ParameterSelectionLabel, SWT.RADIO);
		selectionRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		// manage parameter selection
		pToolkit.createLabel(lBody, getParameterFeature().getEReferenceType().getName() + ":", SWT.NONE);
		selectionText = pToolkit.createText(lBody, "", SWT.BORDER | SWT.READ_ONLY);
		selectionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectionButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = UMLElementTypes.getImage(getParameterFeature());
		selectionButton.setImage(image);
		selectionButton.setLayoutData(new GridData(SWT.NONE));
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
	private void createInvocationCreationSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = CustomMessages.CreateActivityParameterNodeDialog_ParameterCreationTitle;
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}
		ImageHyperlink componentHelp = HelpComponentFactory.createHelpComponent(lSection, pToolkit, CustomMessages.CreateActivityParameterNodeDialog_ParameterCreationHelp);
		lSection.setTextClient(componentHelp);
		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();
		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);
		// content of the section
		creationRadio = pToolkit.createButton(lBody, CustomMessages.CreateActivityParameterNodeDialog_ParameterCreationLabel, SWT.RADIO);
		creationRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		pToolkit.createLabel(lBody, CustomMessages.CreateActivityParameterNodeDialog_NameLabel, SWT.NONE);
		creationNameText = pToolkit.createText(lBody, "", SWT.BORDER);
		creationNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		creationNameText.setFocus();
		// manage type selection
		pToolkit.createLabel(lBody, CustomMessages.CreateActivityParameterNodeDialog_TypeLabel, SWT.NONE);
		creationTypeText = pToolkit.createText(lBody, labelProvider.getText(selectedType), SWT.BORDER | SWT.READ_ONLY);
		creationTypeText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		creationTypeButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = UMLElementTypes.getImage(UMLPackage.eINSTANCE.getPackage_PackagedElement());
		creationTypeButton.setImage(image);
		creationTypeButton.setLayoutData(new GridData(SWT.NONE));
		// manage direction selection
		pToolkit.createLabel(lBody, CustomMessages.CreateActivityParameterNodeDialog_DirectionLabel, SWT.NONE);
		creationDirectionCombo = new Combo(lBody, SWT.DROP_DOWN | SWT.READ_ONLY);
		directionComboViewer = new ComboViewer(creationDirectionCombo);
		pToolkit.adapt(creationDirectionCombo);
		creationDirectionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		directionComboViewer.setLabelProvider(labelProvider);
		directionComboViewer.add(getDirections());
		// initialize selection
		directionComboViewer.setSelection(new StructuredSelection(getDirections()[0]));
		selectedDirection = ParameterDirectionKind.getByName(getDirections()[0]);
		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Set correctly the invoked object, by creating it if needed. Then,
	 * notifies that the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		boolean isSelectionSelected = selectionRadio.getSelection();
		// create element if needed
		if(!isSelectionSelected) {
			selectedParameter = UMLFactory.eINSTANCE.createParameter();
			selectedParameter.setName(selectedName);
			selectedParameter.setType((Type)selectedType);
			selectedParameter.setDirection(selectedDirection);
			addParameter(selectedParameter);
		}
		super.okPressed();
	}

	/**
	 * Get the invoked object that have been selected or created.
	 * 
	 * @return the invoked object to use.
	 */
	public EObject getSelectedInvoked() {
		return selectedParameter;
	}

	/**
	 * Add listeners to widgets
	 */
	private void hookListeners() {
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
				handleChooseParameter();
				refreshOkButton();
			}
		};
		selectionButton.addSelectionListener(selectBtnListener);
		if(creationDirectionCombo != null && directionComboViewer != null) {
			// listener to select direction
			ModifyListener lTypeListener = new ModifyListener() {

				/**
				 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
				 */
				public void modifyText(ModifyEvent e) {
					ISelection sel = directionComboViewer.getSelection();
					if(sel instanceof StructuredSelection) {
						String firstElement = ((StructuredSelection)sel).getFirstElement().toString();
						selectedDirection = ParameterDirectionKind.getByName(firstElement);
					} else {
						selectedDirection = null;
					}
					// reset name
					setInvokedName(null);
					refreshOkButton();
				}
			};
			creationDirectionCombo.addModifyListener(lTypeListener);
		}
		// listener to element name
		ModifyListener lNameListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				setInvokedName(creationNameText.getText());
			}
		};
		creationNameText.addModifyListener(lNameListener);
		// listener to select new element type
		SelectionListener selectTypeBtnListener = new SelectionAdapter() {

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
		creationTypeButton.addSelectionListener(selectTypeBtnListener);
	}

	/**
	 * Set the name chosen for the invoked element
	 * 
	 * @param text
	 *        the text string or null for auto-initialization
	 */
	private void setInvokedName(String text) {
		String name = text;
		if(text == null) {
			name = LabelHelper.INSTANCE.findName(activityOwner, UMLPackage.eINSTANCE.getParameter());
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
	 * Open the dialog to choose the existing parameter to select
	 * 
	 */
	private void handleChooseParameter() {
		Collection<EObject> elements = ModelSetQuery.getObjectsOfType(activityOwner, getParameterFeature().getEType());
		// only keep parameter that are children of the activity
		for(Iterator<EObject> it = elements.iterator(); it.hasNext();) {
			EObject eObject = (EObject)it.next();
			if(!(activityOwner.equals(((Parameter)eObject).getOwner()))) {
				it.remove();
			}
		}
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setFilter("*");
		dialog.setMultipleSelection(false);
		dialog.setElements(elements.toArray(new EObject[elements.size()]));
		if(dialog.open() == Window.OK) {
			setParameterSelection((EObject)dialog.getFirstResult());
		}
	}

	/**
	 * Define the parameter that will be set for the parameter node (if
	 * selection mode is chosen)
	 * 
	 * @param invokedElement
	 *        the selected element
	 */
	private void setParameterSelection(EObject invokedElement) {
		if(invokedElement instanceof Parameter) {
			selectedParameter = (Parameter)invokedElement;
			selectionText.setText(labelProvider.getText(selectedParameter));
		} else {
			selectionText.setText("");
		}
	}

	/**
	 * Open the dialog to choose the type of element to create
	 * 
	 */
	private void handleChooseType() {
		Set<Object> types = getAvailableTypes();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setFilter("*");
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(types.toArray());
		if(dialog.open() == Window.OK) {
			Object firstResult = dialog.getFirstResult();
			if(firstResult instanceof EObject) {
				setSelectedType((EObject)dialog.getFirstResult());
			} else {
				setSelectedType(null);
			}
		}
	}

	/**
	 * Define the type of the object that will be created (if creation mode is
	 * chosen)
	 * 
	 * @param the
	 *        selected parent
	 */
	private void setSelectedType(EObject invokedType) {
		selectedType = invokedType;
		if(selectedType instanceof NamedElement) {
			creationTypeText.setText(labelProvider.getText(selectedType));
		} else {
			creationTypeText.setText("");
		}
	}

	/**
	 * Refresh the enabled and disabled elements in various sections
	 * 
	 * @param isSelectionSelected
	 *        true if we choose to select an existing element, false if we
	 *        choose to create an element
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
		selectionText.setEnabled(isSelectionSelected);
		selectionButton.setEnabled(isSelectionSelected);
		if(creationDirectionCombo != null) {
			creationDirectionCombo.setEnabled(!isSelectionSelected);
		}
		creationNameText.setEnabled(!isSelectionSelected);
		creationNameText.setFocus();
		creationTypeText.setEnabled(!isSelectionSelected);
		creationTypeButton.setEnabled(!isSelectionSelected);
	}

	/**
	 * Refresh the OK button activation
	 */
	private void refreshOkButton() {
		boolean isSelectionSelected = selectionRadio.getSelection();
		if(getButton(IDialogConstants.OK_ID) != null && !getButton(IDialogConstants.OK_ID).isDisposed()) {
			if(isSelectionSelected) {
				getButton(IDialogConstants.OK_ID).setEnabled(selectedParameter != null);
			} else {
				getButton(IDialogConstants.OK_ID).setEnabled(selectedDirection != null && selectedName != null);
			}
		}
	}

	/**
	 * Gets the parameter feature.
	 * 
	 * @return the parameter feature
	 */
	private EReference getParameterFeature() {
		return UMLPackage.eINSTANCE.getBehavior_OwnedParameter();
	}

	/**
	 * Create the new Parameter
	 */
	protected void addParameter(EObject newEObject) {
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		// Let the command find the relation on its own.
		Command addCmd = AddCommand.create(editingdomain, activityOwner, null, Collections.singleton(newEObject));
		addCmd.execute();
	}

	/**
	 * Gets the available types for the parameter
	 * 
	 * @return the available types
	 */
	private Set<Object> getAvailableTypes() {
		Collection<EObject> types = ModelSetQuery.getObjectsOfType(activityOwner, UMLPackage.eINSTANCE.getTypedElement_Type().getEType());
		Set<Object> result = new HashSet<Object>();
		result.add("");
		result.addAll(types);
		return result;
	}

	/**
	 * Gets the possible directions.
	 * 
	 * @return the possible directions
	 */
	private String[] getDirections() {
		List<ParameterDirectionKind> values = ParameterDirectionKind.VALUES;
		String[] ret = new String[values.size()];
		for(int i = 0; i < values.size(); i++) {
			ret[i] = values.get(i).getName();
		}
		return ret;
	}
}
