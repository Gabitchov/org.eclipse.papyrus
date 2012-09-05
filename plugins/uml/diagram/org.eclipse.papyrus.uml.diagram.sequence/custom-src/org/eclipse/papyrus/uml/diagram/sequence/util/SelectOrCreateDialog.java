/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class provides a generic dialog to select or create an element.
 */
public class SelectOrCreateDialog extends FormDialog {

	private EObject selectedElement = null;

	private EClass selectedType = null;

	private String selectedName = null;

	private EObject selectedParent = null;

	private Collection<EObject> existingElements;

	private LinkedHashMap<EClass, List<EObject>> mapTypesPossibleParents;

	private Button nothingRadio;

	private Button selectionRadio;

	private Text selectionText;

	private Button selectionButton;

	private Button creationRadio;

	private Text creationNameText;

	private ComboViewer typeComboViewer = null;

	private Combo creationTypeCombo = null;

	private Button creationParentButton;

	private Text creationParentText;

	private String title;

	private ILabelProvider typeLabelProvider;

	private ILabelProvider elementLabelProvider;

	private final TransactionalEditingDomain transactionalEditingDomain;

	private Button filterSignalButton;

	private List<Type> types;

	/**
	 * 
	 * @param shell
	 *        parent shell
	 * @param title
	 *        The title of the dialog
	 * @param typeLabelProvider
	 *        The label provider to generate type label
	 * @param elementLabelProvider
	 *        The label provider to generate elements label
	 * @param transactionalEditingDomain
	 *        The domain where to create the element if necessary.
	 * @param existingElements
	 *        The list of existing elements that can be selected.
	 * @param mapTypesPossibleParents
	 *        The map of possible types for the element
	 *        and the possible parents where the element
	 *        can be created.
	 * @param types 
	 */
	public SelectOrCreateDialog(Shell shell, String title, ILabelProvider typeLabelProvider, ILabelProvider elementLabelProvider, TransactionalEditingDomain transactionalEditingDomain, Collection<EObject> existingElements, LinkedHashMap<EClass, List<EObject>> mapTypesPossibleParents, List<Type> types) {
		super(shell);
		this.typeLabelProvider = typeLabelProvider;
		this.elementLabelProvider = elementLabelProvider;
		this.existingElements = existingElements;
		this.mapTypesPossibleParents = mapTypesPossibleParents;
		this.title = title;
		this.transactionalEditingDomain = transactionalEditingDomain;
		this.types = types;
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
	 * Create the form to :
	 * 
	 * - ask the user to select or create an element.
	 * 
	 * - decide whether the action is synchronous.
	 * 
	 * @see org.eclipse.ui.forms.FormDialog#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm pForm) {
		ScrolledForm scrolledForm = pForm.getForm();
		scrolledForm.setText(title);

		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());

		// Create the selection section
		createSelectionSection(scrolledForm.getBody(), toolkit);
		// Create the creation section
		createCreationSection(scrolledForm.getBody(), toolkit);


		// Create the nothing section
		createNothingSection(scrolledForm.getBody(), toolkit);


		refreshSectionsEnable(selectionRadio);
		hookListeners();

		// name is set after listeners, since we count on listener to update it properly
		setName(null);

		scrolledForm.reflow(true);
	}

	private void createNothingSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		lBody.setLayout(new GridLayout(1, false));

		// content of the section
		nothingRadio = pToolkit.createButton(lBody, Messages.SelectOrCreateDialog_NothingLabel, SWT.RADIO);
		nothingRadio.setSelection(true);
		nothingRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Create the section to ask the user to select or create an element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createSelectionSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		lBody.setLayout(new GridLayout(3, false));

		// content of the section
		selectionRadio = pToolkit.createButton(lBody, Messages.SelectOrCreateDialog_SelectLabel, SWT.RADIO);
		selectionRadio.setSelection(true);
		selectionRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		selectionText = pToolkit.createText(lBody, "", SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
		selectionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		selectionButton = pToolkit.createButton(lBody, "...", SWT.FLAT); //$NON-NLS-1$

		// find the first non null eobject and use its associated image
		if(existingElements != null) {
			Iterator<EObject> it = existingElements.iterator();
			while(it.hasNext()) {
				EObject next = it.next();
				if(next != null) {
					selectionButton.setImage(UMLElementTypes.getImage(next.eClass()));
					break;
				}
			}
		}

		selectionButton.setLayoutData(new GridData(SWT.NONE));
		
		filterSignalButton = pToolkit.createButton(lBody, "filter out all signals which are not receivable", SWT.CHECK);
		
		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Create the section to ask the user to select or create an element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createCreationSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		lBody.setLayout(new GridLayout(3, false));

		// content of the section
		creationRadio = pToolkit.createButton(lBody, Messages.SelectOrCreateDialog_CreateLabel, SWT.RADIO);
		creationRadio.setSelection(false);
		creationRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		EClass defaultType = null;
		Set<EClass> possibleTypes = mapTypesPossibleParents.keySet();

		// only create the type selection buttons if more than one type
		// is possible
		if(possibleTypes.size() == 1) {
			defaultType = (EClass)possibleTypes.toArray()[0];
		} else {
			pToolkit.createLabel(lBody, Messages.SelectOrCreateDialog_TypeLabel, SWT.NONE);
			creationTypeCombo = new Combo(lBody, SWT.DROP_DOWN | SWT.READ_ONLY);
			typeComboViewer = new ComboViewer(creationTypeCombo);
			pToolkit.adapt(creationTypeCombo);
			creationTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			typeComboViewer.setLabelProvider(typeLabelProvider);
			typeComboViewer.add(possibleTypes.toArray());
			if(possibleTypes.size() > 1) {
				// initialize selection
				defaultType = (EClass)possibleTypes.toArray()[0];
				typeComboViewer.setSelection(new StructuredSelection(defaultType));
			}
		}

		pToolkit.createLabel(lBody, Messages.SelectOrCreateDialog_NameLabel, SWT.NONE);
		creationNameText = pToolkit.createText(lBody, "", SWT.BORDER); //$NON-NLS-1$
		creationNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		pToolkit.createLabel(lBody, Messages.SelectOrCreateDialog_OwnerLabel + ":", SWT.NONE); //$NON-NLS-1$
		creationParentText = pToolkit.createText(lBody, elementLabelProvider.getText(selectedParent), SWT.BORDER | SWT.READ_ONLY);
		creationParentText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		creationParentButton = pToolkit.createButton(lBody, "...", SWT.FLAT); //$NON-NLS-1$
		creationParentButton.setLayoutData(new GridData(SWT.NONE));

		setType(defaultType);

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Add listeners to widgets
	 */
	private void hookListeners() {
		// listener to choose active section
		SelectionListener radioListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				refreshSectionsEnable(e.getSource());
				refreshOkButton();
			}
		};
		selectionRadio.addSelectionListener(radioListener);
		creationRadio.addSelectionListener(radioListener);
		nothingRadio.addSelectionListener(radioListener);

		// listener to select existing element
		SelectionListener selectBtnListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSelectElement();
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
							setType((EClass)type);
						} else {
							setType(null);
						}
						// reset name
						setName(null);
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
				selectedName = creationNameText.getText();
				refreshOkButton();
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
				handleSelectParent();
			}
		};
		creationParentButton.addSelectionListener(selectParentBtnListener);
	}

	/**
	 * Refresh the OK button activation
	 */
	private void refreshOkButton() {
		Button okButton = getButton(IDialogConstants.OK_ID);
		if(okButton != null && !okButton.isDisposed()) {
			if(selectionRadio.getSelection()) {
				okButton.setEnabled(selectedElement != null);
			} else if(nothingRadio.getSelection()) {
				okButton.setEnabled(true);
			} else {
				okButton.setEnabled(selectedType != null && selectedParent != null && selectedName != null && !"".equals(selectedName)); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Add the created element to its selected parent
	 */
	protected void addElementInParent(EObject selectedParent, EObject createdElement) {
		// Let the command find the relation on its own.
		Command addCmd = AddCommand.create(transactionalEditingDomain, selectedParent, null, Collections.singleton(createdElement));
		if(addCmd.canExecute()) {
			addCmd.execute();
		}
	}

	/**
	 * Set correctly the element, by creating it if needed.
	 * Then, notifies that the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		// create element if needed
		if(creationRadio.getSelection()) {
			selectedElement = UMLFactory.eINSTANCE.create(selectedType);
			if(selectedElement instanceof NamedElement) {
				((NamedElement)selectedElement).setName(selectedName);
			}
			addElementInParent(selectedParent, selectedElement);
		} else if(nothingRadio.getSelection()) {
			selectedElement = null;
		}
		super.okPressed();
	}

	/**
	 * Open the dialog to choose the existing element to select
	 * 
	 */
	private void handleSelectElement() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), elementLabelProvider);
		dialog.setMessage(Messages.SelectOrCreateDialog_SelectLabel);
		dialog.setMultipleSelection(false);
		dialog.setElements(filterElements(existingElements));		
		if(dialog.open() == Window.OK) {
			setElementSelection((EObject)dialog.getFirstResult());
		}
	}
	
	private Set<Signal> getAllSignals(List<Type> types){
		Set<Signal> accept = new HashSet<Signal>();
		Set<Classifier> collected = new HashSet<Classifier>();
		for(Type t: types)
			if(t instanceof Classifier){
				Classifier c = (Classifier)t;				
				collectSignals(c, accept, collected);
			}
		
		return accept;
	}

	protected void collectSignals(Classifier c, Set<Signal> accept, Set<Classifier> collected) {
		if(collected.contains(c))
			return;		
		collected.add(c);
		
		EList<Property> attrs = c.getAllAttributes();
		for(Property p : attrs)
			if(p.getType() instanceof Signal){
				accept.add((Signal)p.getType());
			}else if(p.getType() instanceof Classifier){
				collectSignals((Classifier)p.getType(), accept, collected); 
			}
	}

	private Object[] filterElements(Collection<EObject> elements) {
		if(!filterSignalButton.getSelection() || types == null || types.isEmpty())
			return elements.toArray(new EObject[elements.size()]);
				
		Set<Signal> accept = getAllSignals(types);
		
		List<EObject> result = new ArrayList<EObject>();
		for(EObject o:elements)
			if(!(o instanceof Signal))
				result.add(o);
			else if( accept.contains(o))
				result.add(o);
		return result.toArray(new EObject[result.size()]);
	}

	/**
	 * Open the dialog to choose the parent of element to create
	 * 
	 */
	private void handleSelectParent() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), elementLabelProvider);
		dialog.setMessage(Messages.SelectOrCreateDialog_OwnerLabel);
		dialog.setMultipleSelection(false);
		List<EObject> possibleParents = mapTypesPossibleParents.get(selectedType);
		if(possibleParents != null) {
			dialog.setElements(possibleParents.toArray());
		}
		if(dialog.open() == Window.OK) {
			setParent((EObject)dialog.getFirstResult());
		}
	}

	/**
	 * Define the object in which element will be created (if creation mode is chosen)
	 * 
	 * @param parent
	 *        the selected parent
	 */
	private void setParent(EObject parent) {
		selectedParent = parent;
		if(selectedParent instanceof NamedElement) {
			creationParentText.setText(elementLabelProvider.getText(selectedParent));
			creationParentButton.setImage(UMLElementTypes.getImage(parent.eClass()));
		} else {
			creationParentText.setText(""); //$NON-NLS-1$
		}
		refreshOkButton();
	}

	/**
	 * Define the name of the object that will be created by the action
	 * 
	 * @param name
	 *        the name of the element
	 */
	private void setName(String name) {
		selectedName = name;
		if(name != null) {
			creationNameText.setText(name);
		} else {
			creationNameText.setText(""); //$NON-NLS-1$
		}
		refreshOkButton();
	}

	/**
	 * Define the type of the object that will be created by the action
	 * 
	 * @param type
	 *        the type of the element
	 */
	private void setType(EClass type) {
		selectedType = type;
		List<EObject> possibleParents = mapTypesPossibleParents.get(type);
		if(possibleParents != null && possibleParents.size() > 0) {
			setParent(possibleParents.get(0));
		} else {
			setParent(null);
		}
		refreshOkButton();
	}

	/**
	 * Define the object that will be returned by the action (if selection mode is chosen)
	 * 
	 * @param element
	 *        the selected element
	 */
	private void setElementSelection(EObject element) {
		selectedElement = element;
		if(selectedElement instanceof NamedElement) {
			selectionText.setText(elementLabelProvider.getText(selectedElement));
		} else {
			selectionText.setText(""); //$NON-NLS-1$
		}
		refreshOkButton();
	}

	/**
	 * Refresh the enabled and disabled elements in various sections
	 * 
	 */
	private void refreshSectionsEnable(Object radioObject) {
		boolean nothingSelected = false;
		boolean selectionSelected = false;
		boolean creationSelected = false;
		if(selectionRadio.equals(radioObject)) {
			selectionSelected = true;
		} else if(creationRadio.equals(radioObject)) {
			creationSelected = true;
		} else {
			nothingSelected = true;
		}

		// Selection widgets
		selectionRadio.setSelection(selectionSelected);
		selectionText.setEnabled(selectionSelected);
		selectionButton.setEnabled(selectionSelected);

		// Creation widgets
		creationRadio.setSelection(creationSelected);
		if(creationTypeCombo != null) {
			creationTypeCombo.setEnabled(creationSelected);
		}
		creationNameText.setEnabled(creationSelected);
		creationParentText.setEnabled(creationSelected);
		creationParentButton.setEnabled(creationSelected);

		// Nothing widgets
		nothingRadio.setSelection(nothingSelected);
	}

	/**
	 * Get the object that have been selected or created.
	 * 
	 * @return the object to use.
	 */
	public EObject getSelected() {
		return selectedElement;
	}

}
