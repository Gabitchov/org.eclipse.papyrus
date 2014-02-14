/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Gregoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors
 */
package org.eclipse.emf.facet.efacet.ui.internal.composites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.SelectETypeWizardImpl;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//@SuppressWarnings("PMD.ConstructorCallsOverridableMethod") Temporary: this class must be deeply refactored.
//TODO remove the @SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//cf. bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=373248
public class SelectETypeComposite extends Composite {

	private static final int NUMBER_COLUMN = 3;

	/** to be returned by the composite */
	private EClassifier selectedEType = null;

	private EditingDomain editingDomain;

	private Label eTypeLabel;
	private Button selectButton;
	private Text eTypedTextField;

	private ETypeSelectionOptions eTypeSelectionOption;

	private boolean canChangeEPackage = true;

	private final EPackage ePackage;

	public enum ETypeSelectionOptions {
		ECLASSIFIER, EDATATYPE, ECLASS
	}

	public SelectETypeComposite(final Composite parent, final int style, final ETypeSelectionOptions option, final boolean canChangeEPackage,
			final EPackage ePackage) {
		super(parent, style);
		this.eTypeSelectionOption = option;
		this.ePackage = ePackage;
		this.canChangeEPackage = canChangeEPackage;
		init();
	}

	protected void createCompositeWidget() {
		this.eTypeLabel = new Label(this, SWT.NULL);
		this.eTypedTextField = new Text(this, SWT.BORDER | SWT.SINGLE);
		this.selectButton = new Button(this, SWT.PUSH);
	}

	private void init() {
		GridLayout gridLayout = new GridLayout(SelectETypeComposite.NUMBER_COLUMN, false);
		setLayout(gridLayout);
		createCompositeWidget();
		initializeWidgets();
		initializeLabelText();
	}

	private void initializeLabelText() {
		this.eTypeLabel.setText(Messages.Type);
		this.selectButton.setText(Messages.Select);
	}

	protected void initializeWidgets() {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		this.eTypedTextField.setLayoutData(gd);

		this.selectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				SelectETypeComposite.this.handleBrowse();
			}
		});
	}

	/**
	 * This method call the SelectETypeWizardImpl
	 */
	protected void handleBrowse() {
		if (this.eTypeSelectionOption == null) {
			this.eTypeSelectionOption = SelectETypeComposite.ETypeSelectionOptions.ECLASSIFIER;
		}
		SelectETypeWizardImpl dialog = new SelectETypeWizardImpl(this.editingDomain, this.eTypeSelectionOption, this.canChangeEPackage, this.ePackage);
		if (dialog.open() != Window.CANCEL) {
			setEClass(dialog.getSelectedEType());
			eTypeSelected();
		}
	}

	protected void eTypeSelected() {
		// Meant to be implemented
	}

	public void setEClass(final EClassifier eClass) {
		this.selectedEType = eClass;
		if (eClass != null) {
			this.eTypedTextField.setText(eClass.getName());
			this.eTypedTextField.redraw();
			this.eTypedTextField.setFocus();
		}
	}

	public void canChangeEType(final boolean canChange) {
		// this.eTypedTextField.setEditable(true);
		// this.eTypedTextField.setEnabled(false);
		this.selectButton.setEnabled(canChange);
	}

	public EClassifier getEType() {
		return this.selectedEType;
	}

	protected void setQueryLabel(final Label queryLabel) {
		this.eTypeLabel = queryLabel;
	}

	protected void setBrowseButton(final Button browseButton) {
		this.selectButton = browseButton;
	}

	protected void setQueryNameTextField(final Text queryNameTextField) {
		this.eTypedTextField = queryNameTextField;
	}

	public void setETypeLabel(final Label eTypeLabel) {
		this.eTypeLabel = eTypeLabel;
	}

	public void setSelectButton(final Button selectButton) {
		this.selectButton = selectButton;
	}

	public void setETypedTextField(final Text eTypedTextField) {
		this.eTypedTextField = eTypedTextField;
	}

	public void setEditingDomain(final EditingDomain editingDomain2) {
		this.editingDomain = editingDomain2;
	}

	public void setEType(final EClass type) {
		this.selectedEType = type;
		if (this.eTypedTextField != null) {
			this.eTypedTextField.setText(this.selectedEType.getName());
			this.eTypedTextField.redraw();
		}
	}

}
