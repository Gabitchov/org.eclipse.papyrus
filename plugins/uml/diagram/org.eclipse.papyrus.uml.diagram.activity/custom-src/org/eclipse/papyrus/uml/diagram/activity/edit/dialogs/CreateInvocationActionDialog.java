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

import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.actions.LabelHelper;
import org.eclipse.papyrus.uml.diagram.common.ui.helper.HelpComponentFactory;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class provides a dialog to initialize a CallAction at its creation.
 */
public abstract class CreateInvocationActionDialog extends FormDialog {

	private static final String MAP_FORMAT = "%s|%s";

	private static final Pattern MAP_PATTERN = Pattern.compile("(.*?)\\|(.*)");

	private Button creationRadio;

	private Button selectionRadio;

	private Text selectionText;

	private Button selectionButton;

	private Text creationNameText;

	private Text creationParentText;

	private Button creationParentButton;

	private EObject selectedInvoked = null;

	private EObject selectedParent = null;

	private Activity actionParent;

	private EClass selectedType = null;

	private String selectedName = null;

	private ComboViewer typeComboViewer = null;

	private Combo creationTypeCombo = null;

	private ILabelProvider labelProvider;
	
	/**
	 * New Object about to be created
	 */
	private InvocationAction invocationAction;

	/**
	 * Create a new dialog to initialize a CallAction.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateInvocationActionDialog(Shell shell, Activity owner,InvocationAction newAction) {
		super(shell);
		actionParent = owner;
		selectedParent = getDefaultParent(owner);
		labelProvider = getCustomLabelProvider();
		this.invocationAction = newAction;
	}
	
	

	
	/**
	 * Invocation action about to be created
	 * @return
	 */
	public InvocationAction getInvocationAction() {
		return invocationAction;
	}



	/**
	 * Get the parent to propose as default choice for the element creation
	 * 
	 * @param owner
	 *        the invocation action's owner
	 * @return default parent to select
	 */
	private EObject getDefaultParent(Activity owner) {
		// try recovering last user choice from preferences
		IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String ownerString = prefStore.getString(getCreationDefaultOwnerPreference());
		if(ownerString != null && !"".equals(ownerString)) {
			Matcher match = MAP_PATTERN.matcher(ownerString);
			if(match.matches() && match.groupCount() >= 2) {
				String ressURI = match.group(1);
				String parentURI = match.group(2);
				if(owner.eResource().getURI().toString().equals(ressURI)) {
					EObject parent = owner.eResource().getEObject(parentURI);
					if(parent != null) {
						return parent;
					}
				}
			}
		}
		// recover default choice from the action's owner
		EObject parent = owner;
		while(!isPossibleInvokedParent(parent)) {
			parent = parent.eContainer();
		}
		return parent;
	}

	/**
	 * Create the form to :
	 * 
	 * - ask the user to choose or create an invoked element.
	 * 
	 * - decide whether the action is synchronous.
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
		createInvocationCreationSection(scrolledForm.getBody(), toolkit);
		createInvocationSelectionSection(scrolledForm.getBody(), toolkit);
		createExtraSections(scrolledForm.getBody(), toolkit);
		refreshSectionsEnable(isSelectionDefault());
		hookListeners();
		// invoked name is set after listeners, since we count on listener to
		// update it properly
		setInvokedName(null);
		scrolledForm.reflow(true);
	}

	/**
	 * Get whether the selection of an existing element is the default
	 * 
	 * @return true if selection by default
	 */
	protected boolean isSelectionDefault() {
		IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		return prefStore.getBoolean(getSelectionIsDefaultPreference());
	}

	/**
	 * Get the id of the preference storing whether selection is the default
	 * choice.
	 * 
	 * @return preference id
	 */
	abstract protected String getSelectionIsDefaultPreference();

	/**
	 * Get the id of the preference storing the last selected owner.
	 * 
	 * @return preference id
	 */
	abstract protected String getCreationDefaultOwnerPreference();

	/**
	 * Create the other needed sections. Subclasses can override this method.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	protected void createExtraSections(Composite pParent, FormToolkit pToolkit) {
		// do nothing
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
	 * Create the section to ask the user to choose or create an invoked
	 * element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createInvocationSelectionSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getInvocationSelectionSectionTitle();
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
		selectionRadio = pToolkit.createButton(lBody, getSelectionLabel(), SWT.RADIO);
		// selectionRadio.setSelection(false);
		selectionRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		pToolkit.createLabel(lBody, getInvokedObjectLabel(), SWT.NONE);
		selectionText = pToolkit.createText(lBody, "", SWT.BORDER | SWT.READ_ONLY);
		selectionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectionButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = UMLElementTypes.getImage(getInvocationFeature());
		selectionButton.setImage(image);
		selectionButton.setLayoutData(new GridData(SWT.NONE));
		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Create the section to ask the user to choose or create an invoked
	 * element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createInvocationCreationSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getInvocationCreationSectionTitle();
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}
		ImageHyperlink componentHelp = HelpComponentFactory.createHelpComponent(lSection, pToolkit, getInvocationCreationSectionHelp(), true);
		lSection.setTextClient(componentHelp);
		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();
		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);
		// content of the section
		creationRadio = pToolkit.createButton(lBody, getCreationLabel(), SWT.RADIO);
		// creationRadio.setSelection(true);
		creationRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		if(getPossibleInvokedTypes().length == 1) {
			selectedType = getPossibleInvokedTypes()[0];
		} else {
			pToolkit.createLabel(lBody, getInvokedTypeLabel(), SWT.NONE);
			creationTypeCombo = new Combo(lBody, SWT.DROP_DOWN | SWT.READ_ONLY);
			typeComboViewer = new ComboViewer(creationTypeCombo);
			pToolkit.adapt(creationTypeCombo);
			creationTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			typeComboViewer.setLabelProvider(labelProvider);
			typeComboViewer.add(getPossibleInvokedTypes());
			if(getPossibleInvokedTypes().length > 1) {
				// initialize selection
				typeComboViewer.setSelection(new StructuredSelection(getPossibleInvokedTypes()[0]));
				selectedType = getPossibleInvokedTypes()[0];
			}
		}
		pToolkit.createLabel(lBody, getInvokedNameLabel(), SWT.NONE);
		creationNameText = pToolkit.createText(lBody, "", SWT.BORDER);
		creationNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		creationNameText.setFocus();
		pToolkit.createLabel(lBody, getInvokedParentLabel(), SWT.NONE);
		creationParentText = pToolkit.createText(lBody, labelProvider.getText(selectedParent), SWT.BORDER | SWT.READ_ONLY);
		creationParentText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		creationParentButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = getParentImage();
		creationParentButton.setImage(image);
		creationParentButton.setLayoutData(new GridData(SWT.NONE));
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
			selectedInvoked = UMLFactory.eINSTANCE.create(selectedType);
			if(selectedInvoked instanceof NamedElement) {
				((NamedElement)selectedInvoked).setName(selectedName);
			}
			addInvokedInParent(selectedParent, selectedInvoked);
		}
		// store user choices in preference
		IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		// store choice between selection and creation
		prefStore.setValue(getSelectionIsDefaultPreference(), isSelectionSelected);
		if(!isSelectionSelected) {
			// store the owner choice
			String ressUri = selectedParent.eResource().getURI().toString();
			String parentURI = selectedParent.eResource().getURIFragment(selectedParent);
			String prefValue = String.format(MAP_FORMAT, ressUri, parentURI);
			prefStore.setValue(getCreationDefaultOwnerPreference(), prefValue);
		}
		super.okPressed();
	}

	/**
	 * Get the invoked object that have been selected or created.
	 * 
	 * @return the invoked object to use.
	 */
	public EObject getSelectedInvoked() {
		return selectedInvoked;
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
				handleChooseInvoked();
				refreshOkButton();
			}
		};
		selectionButton.addSelectionListener(selectBtnListener);
		if(creationTypeCombo != null && typeComboViewer != null) {
			// listener to select invocation type
			ModifyListener lTypeListener = new ModifyListener() {

				/**
				 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
				 */
				public void modifyText(ModifyEvent e) {
					ISelection sel = typeComboViewer.getSelection();
					if(sel instanceof StructuredSelection) {
						Object type = ((StructuredSelection)sel).getFirstElement();
						if(type instanceof EClass) {
							selectedType = (EClass)type;
						} else {
							selectedType = null;
						}
						// reset name
						setInvokedName(null);
						refreshOkButton();
					}
				}
			};
			creationTypeCombo.addModifyListener(lTypeListener);
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
				handleChooseParent();
				// reset name if not set
				if(selectedName == null) {
					setInvokedName(null);
				}
				refreshOkButton();
			}
		};
		creationParentButton.addSelectionListener(selectParentBtnListener);
	}

	/**
	 * Set the name chosen for the invoked element
	 * 
	 * @param text
	 *        the text string or null for auto-initialization
	 */
	private void setInvokedName(String text) {
		String name = text;
		if(text == null && selectedParent != null && selectedType != null) {
			name = LabelHelper.INSTANCE.findName(selectedParent, selectedType);
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
	 * Open the dialog to choose the existing element to select
	 * 
	 */
	private void handleChooseInvoked() {
		TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
		dialog.setContentProvider(new UMLContentProvider(getInvocationAction(), getInvocationFeature()));
		dialog.setLabelProvider(new UMLLabelProvider());
		//		UMLMultiEClassifierTreeSelectorDialog dialog = new UMLMultiEClassifierTreeSelectorDialog(getShell(), actionParent, Collections.singleton(getInvocationFeature().getEType()));
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		if(dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();
			if (result != null && result.length > 0 && result[0] instanceof EObject)
			setInvokedSelection((EObject)result[0]);
		}
	}

	/**
	 * Define the object that will be invoked by the action (if selection mode
	 * is chosen)
	 * 
	 * @param invokedElement
	 *        the selected element
	 */
	protected void setInvokedSelection(EObject invokedElement) {
		selectedInvoked = invokedElement;
		if(selectedInvoked instanceof NamedElement) {
			selectionText.setText(labelProvider.getText(selectedInvoked));
		} else {
			selectionText.setText("");
		}
	}

	/**
	 * Open the dialog to choose the parent of element to create
	 * 
	 */
	private void handleChooseParent() {
		/*
		 * TODO BACKPORT
		 */
		//		UMLMultiEClassifierTreeSelectorDialog dialog = new UMLMultiEClassifierTreeSelectorDialog(getShell(), actionParent, getPossibleInvokedParents(actionParent),true);
		//		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		//		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		//		if(dialog.open() == Window.OK) {
		//			setInvokedParent((EObject)dialog.getTheResult());
		//		}
	}

	/**
	 * Define the object in which invoked object will be created (if creation
	 * mode is chosen)
	 * 
	 * @param invokedParent
	 *        the selected parent
	 */
	private void setInvokedParent(EObject invokedParent) {
		selectedParent = invokedParent;
		if(selectedParent instanceof NamedElement) {
			creationParentText.setText(labelProvider.getText(selectedParent));
		} else {
			creationParentText.setText("");
		}
	}

	/**
	 * Refresh the enabled and disabled elements in various sections
	 * 
	 * @param isSelectionSelected
	 *        true if we choose to select an existing element, false if we
	 *        choose to create an element
	 */
	protected void refreshSectionsEnable(boolean isSelectionSelected) {
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
		if(creationTypeCombo != null) {
			creationTypeCombo.setEnabled(!isSelectionSelected);
		}
		creationNameText.setEnabled(!isSelectionSelected);
		creationNameText.setFocus();
		creationParentText.setEnabled(!isSelectionSelected);
		creationParentButton.setEnabled(!isSelectionSelected);
	}

	/**
	 * Refresh the OK button activation
	 */
	private void refreshOkButton() {
		boolean isSelectionSelected = selectionRadio.getSelection();
		if(getButton(IDialogConstants.OK_ID) != null && !getButton(IDialogConstants.OK_ID).isDisposed()) {
			if(isSelectionSelected) {
				getButton(IDialogConstants.OK_ID).setEnabled(selectedInvoked != null);
			} else {
				getButton(IDialogConstants.OK_ID).setEnabled(selectedParent != null && selectedType != null && selectedName != null);
			}
		}
	}

	/**
	 * Add the created invoked object to its selected parent
	 */
	protected void addInvokedInParent(EObject selectedParent, EObject createdInvoked) {
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		// Let the command find the relation on its own.
		Command addCmd = AddCommand.create(editingdomain, selectedParent, null, Collections.singleton(createdInvoked));
		addCmd.execute();
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
	 * Get the possible types for creating a new invoked element
	 * 
	 * @return array of EClasses
	 */
	abstract protected EClass[] getPossibleInvokedTypes();

	/**
	 * Get the possible parents of the new invoked element
	 * 
	 * @param actionParent
	 *        the parent of the action
	 * @return collection of EObject possible owners
	 */
	abstract protected Set<? extends EClassifier> getPossibleInvokedParents(EObject actionParent);

	/**
	 * Whether element can be parent of the new invoked element
	 * 
	 * @param parent
	 *        the parent to test
	 * @return true if parent is of an appropriate eclass
	 */
	abstract protected boolean isPossibleInvokedParent(EObject parent);

	/**
	 * Get feature referencing the invoked object
	 * 
	 * @return invocation feature
	 */
	abstract protected EReference getInvocationFeature();

	/**
	 * Get the image for the parent selection button
	 * 
	 * @return image
	 */
	abstract protected Image getParentImage();

	/**
	 * Get the label to present the name of the invoked object
	 * 
	 * @return label
	 */
	protected String getInvokedNameLabel() {
		return Messages.CreateCallActionDialog_NameLabel;
	}

	/**
	 * Get the label to present the type of the invoked object
	 * 
	 * @return label
	 */
	protected String getInvokedTypeLabel() {
		return Messages.CreateCallActionDialog_TypeLabel;
	}

	/**
	 * Get the label to present parent of the invoked object
	 * 
	 * @return label
	 */
	protected String getInvokedParentLabel() {
		return Messages.CreateCallActionDialog_ParentLabel;
	}

	/**
	 * Get the label to present the invoked object
	 * 
	 * @return label
	 */
	protected String getInvokedObjectLabel() {
		return getInvocationFeature().getEReferenceType().getName() + ":";
	}

	/**
	 * Get the title of the dialog
	 * 
	 * @return dialog title
	 */
	abstract protected String getTitle();

	/**
	 * Get the title of the invocation creation section
	 * 
	 * @return section title
	 */
	abstract protected String getInvocationCreationSectionTitle();

	/**
	 * Get the help description of the invocation creation section
	 * 
	 * @return section title
	 */
	abstract protected String getInvocationCreationSectionHelp();

	/**
	 * Get the title of the invocation selection section
	 * 
	 * @return section title
	 */
	abstract protected String getInvocationSelectionSectionTitle();

	/**
	 * Get the label to choose to select an existing element
	 * 
	 * @return label
	 */
	abstract protected String getSelectionLabel();

	/**
	 * Get the label to choose to create a new element
	 * 
	 * @return label
	 */
	abstract protected String getCreationLabel();
}
