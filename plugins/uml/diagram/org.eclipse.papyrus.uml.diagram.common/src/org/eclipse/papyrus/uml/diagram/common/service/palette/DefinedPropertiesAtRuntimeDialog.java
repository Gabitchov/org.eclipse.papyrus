/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This Class provides a dialog to edit meta-elements properties. The editor is
 * chosen following the property type. The editor order is the following :
 * <ul>
 * <li> {@link Text}</li>
 * <li> {@link Combo}</li>
 * <li> {@link Button} (checkBox)</li>
 * </ul>
 * 
 */
public class DefinedPropertiesAtRuntimeDialog extends Dialog {

	/** The runtime properties. */
	protected List<String> runtimeProperties;

	/** The title. */
	protected String title;

	/** The message. */
	private String message;

	/** The element to edit. */
	private EObject elementToEdit;

	/** The list of applied stereotypes */
	protected List<Stereotype> appliedStereotypes = null;

	/** The boolean meta properties. */
	private ArrayList<EAttribute> booleanMetaProperties = new ArrayList<EAttribute>();

	/** The string meta properties. */
	private ArrayList<EAttribute> stringMetaProperties = new ArrayList<EAttribute>();

	/** The enumeration meta properties. */
	private ArrayList<EAttribute> enumerationMetaProperties = new ArrayList<EAttribute>();

	/**
	 * Instantiates a new dialog.
	 * 
	 * @param shell
	 *        the shell
	 * @param title
	 *        the title
	 * @param message
	 *        the message
	 * @param runtimeProperties
	 *        the runtime properties
	 * @param objectToEdit
	 *        the object to edit
	 */
	protected DefinedPropertiesAtRuntimeDialog(Shell shell, String title, String message, List<String> runtimeProperties, EObject objectToEdit) {
		super(shell);
		this.runtimeProperties = runtimeProperties;
		this.title = title;
		this.elementToEdit = objectToEdit;
		this.message = message;
		if(elementToEdit instanceof Element) {
			appliedStereotypes = ((Element)elementToEdit).getAppliedStereotypes();
		}
		EClass currentEClass = (EClass)elementToEdit.eClass();
		EList<EAttribute> allAttributs = currentEClass.getEAllAttributes();
		for(EAttribute eAttribute : allAttributs) {
			if((!eAttribute.isDerived()) && eAttribute.isChangeable()) {
				// we class the properties following its type
				EClassifier eType = eAttribute.getEType();
				String instanceTypeName = eType.getInstanceClassName();
				if(runtimeProperties.contains(eAttribute.getName())) {
					if(eType instanceof EEnum) {
						enumerationMetaProperties.add(eAttribute);
					} else if(instanceTypeName.equals(Integer.class.getCanonicalName())) {
						stringMetaProperties.add(eAttribute);
					} else if(instanceTypeName.equals("boolean")) { //$NON-NLS-1$
						booleanMetaProperties.add(eAttribute);
					} else if(instanceTypeName.equals(String.class.getCanonicalName())) {
						stringMetaProperties.add(eAttribute);
					}
				}
			}

		}

	}

	/**
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 * 
	 * @param shell
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if(title != null) {
			shell.setText(title);
		}

	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 *      we remove the CANCEL Button
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		// create the composite
		Composite composite = (Composite)super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(data);

		// trick to have the message on the two columns!(a GridData with
		// horizontalSpan = 2 on label doesn't work)
		Composite compo = new Composite(composite, SWT.NONE);
		GridLayout compoLayout = new GridLayout(1, false);
		compo.setLayout(compoLayout);
		GridData compoData = new GridData(GridData.FILL_HORIZONTAL);
		compoData.horizontalSpan = 2;
		compo.setLayoutData(compoData);

		Label label = new Label(compo, SWT.NONE);
		label.setText(message);

		// create the editors
		if(stringMetaProperties.size() != 0) {
			createTextArea(composite);
		}
		if(enumerationMetaProperties.size() != 0) {
			createCombo(composite);
		}
		if(booleanMetaProperties.size() != 0) {
			createCheckBox(composite);
		}

		return composite;
	}

	/**
	 * Makes the title, that's to say, put the first letter in upper case
	 * 
	 * @param name
	 *        the name
	 * @return the string
	 */
	protected String makeTitle(String name) {
		String title = null;
		if(name != null) {
			title = new String(name);
			String firstLetter = name.substring(0, 1);
			title = title.replaceFirst(firstLetter, firstLetter.toUpperCase());
		}
		return title;
	}

	/**
	 * Creates the text area.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createTextArea(Composite composite) {
		for(int iter = 0; iter < stringMetaProperties.size(); iter++) {
			Label label = new Label(composite, SWT.NONE);
			String fieldTitle = makeTitle(stringMetaProperties.get(iter).getName()) + " :"; //$NON-NLS-1$
			label.setText(fieldTitle);

			Text text = new Text(composite, SWT.BORDER);
			GridData textData = new GridData(GridData.FILL_HORIZONTAL);
			text.setLayoutData(textData);

			String value = (String)((EObject)elementToEdit).eGet(stringMetaProperties.get(iter));
			text.setText(value);

			final int iterFinal = iter;
			final Text textFinal = text;
			text.addFocusListener(new FocusAdapter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
				 */
				public void focusLost(FocusEvent e) {
					((EObject)elementToEdit).eSet(stringMetaProperties.get(iterFinal), textFinal.getText());
				}
			});

		}

	}

	/**
	 * Creates the combo.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createCombo(Composite composite) {
		for(int iter = 0; iter < enumerationMetaProperties.size(); iter++) {
			Label label = new Label(composite, SWT.NONE);
			String fieldTitle = makeTitle(enumerationMetaProperties.get(iter).getName()) + " :"; //$NON-NLS-1$
			label.setText(fieldTitle);
			Combo combo = new Combo(composite, SWT.READ_ONLY);

			// get the items
			EAttribute currentAttributes = enumerationMetaProperties.get(iter);
			EEnum eType = (EEnum)currentAttributes.getEType();

			final List<EEnumLiteral> literals = eType.getELiterals();
			final String[] proposals = new String[literals.size() + 1];
			ArrayList<String> list = new ArrayList<String>();
			list.add(""); //$NON-NLS-1$
			proposals[0] = ""; //$NON-NLS-1$
			for(int i = 0; i < literals.size(); i++) {
				// i+1 because there is already the "" string
				proposals[i + 1] = literals.get(i).getLiteral();
				list.add(i + 1, literals.get(i).getLiteral());
			}
			combo.setItems(proposals);
			// get initial value
			Object selection = ((EObject)elementToEdit).eGet(currentAttributes);
			combo.select(list.indexOf(selection.toString()));
			GridData textData = new GridData(GridData.FILL_HORIZONTAL);
			combo.setLayoutData(textData);
			final Combo comboFinal = combo;
			final int iterFinal = iter;
			combo.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					int index = comboFinal.getSelectionIndex();
					if(index == 0) {
						((EObject)elementToEdit).eUnset(enumerationMetaProperties.get(iterFinal));
					} else {
						((EObject)elementToEdit).eSet(enumerationMetaProperties.get(iterFinal), literals.get(index - 1).getInstance());
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});

		}
	}

	/**
	 * Creates the check box.
	 * 
	 * @param parent
	 *        the parent
	 */
	private void createCheckBox(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		GridData data = new GridData();
		data.horizontalSpan = 2;

		composite.setLayoutData(data);
		layout.numColumns = 3;
		composite.setLayout(layout);
		for(int iter = 0; iter < booleanMetaProperties.size(); iter++) {
			Composite grp = new Composite(composite, SWT.NONE);
			GridLayout layout2 = new GridLayout();
			layout2.numColumns = 2;
			grp.setLayout(layout2);

			Button button = new Button(grp, SWT.FLAT | SWT.CHECK);
			Label label = new Label(grp, SWT.NONE);
			String fieldTitle = makeTitle(booleanMetaProperties.get(iter).getName());
			label.setText(fieldTitle);
			// get button state
			Boolean state = (Boolean)((EObject)elementToEdit).eGet(booleanMetaProperties.get(iter));
			button.setSelection(state);
			final int iterFinal = iter;
			button.addSelectionListener(new SelectionAdapter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				public void widgetSelected(SelectionEvent e) {
					// get the old value
					Boolean oldValue = (Boolean)((EObject)elementToEdit).eGet(booleanMetaProperties.get(iterFinal));
					((EObject)elementToEdit).eSet(booleanMetaProperties.get(iterFinal), !oldValue);
				}
			});

		}
	}
}
