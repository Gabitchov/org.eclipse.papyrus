/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.properties.tabbed.customization.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * Creates the page for the selection of the xml file to be edited.
 * <p>
 * This page should display three choices:
 * <ul>
 * <li>Create a new one from scratch</li>
 * <li>Create a new one, based on a exiting one</li>
 * <li>Modify an existing one</li>
 * </ul>
 * </p>
 */
public class SelectConfigurationFileWizardPage extends WizardPage {

	/** Button used to initialize the xml file from an existing one */
	protected Button createFromExistingConfigurationButton;

	/** Button used to modify an existing configuration */
	protected Button modifyExistingConfigurationButton;

	/** Button used to create an empty configuration */
	protected Button createFromScratchButton;

	/** selection listener for the radio buttons */
	protected SelectionListener selectionListener = new SelectionListener() {

		public void widgetSelected(SelectionEvent e) {
			notifyButtonChanged(e);
		}

		public void widgetDefaultSelected(SelectionEvent e) {

		}
	};

	/** field that contains the name of the new configuration file */
	protected Text createFromScratchText;

	/** button that opens dialog to select configuration to copy and modify */
	protected Button createFromExistingConfigurationSelectionButton;

	/** text area that display the name of the configuration file to modify */
	protected Text modifyExistingConfigurationText;

	/** button that opens dialog to select configuration to modify */
	protected Button modifyExistingConfigurationSelectionButton;

	/** text area that display the name of the configuration file to copy and modify */
	protected Text createFromExistingConfigurationText;

	/**
	 * Creates a new SelectConfigurationFileWizardPage.
	 */
	protected SelectConfigurationFileWizardPage() {
		super(Messages.SelectConfigurationFileWizardPage_PageName, Messages.SelectConfigurationFileWizardPage_Title, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
		composite.setLayoutData(data);
		GridLayout layout = new GridLayout();
		// layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		// sets the new control
		setControl(composite);

		// creates the content
		createContentArea(composite);
	}

	/**
	 * creates the content area for this wizard page
	 * 
	 * @param composite
	 *        the parent composite for the created composites in the content area
	 */
	protected void createContentArea(Composite composite) {
		// first group: Create from scratch
		Composite createFromScratchComposite = new Composite(composite, SWT.BORDER);
		createFromScratchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createFromScratchComposite.setLayout(new GridLayout(3, false));
		createFromScratchButton = new Button(createFromScratchComposite, SWT.RADIO);
		createFromScratchButton.addSelectionListener(selectionListener);
		Label createFromScratchLabel = new Label(createFromScratchComposite, SWT.NONE);
		createFromScratchLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		createFromScratchLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateFromScratch_Label);
		createFromScratchText = new Text(createFromScratchComposite, SWT.BORDER);
		createFromScratchText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));

		// create from an existing configuration composite
		Composite createFromExistingConfigurationComposite = new Composite(composite, SWT.BORDER);
		createFromExistingConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createFromExistingConfigurationComposite.setLayout(new GridLayout(3, false));
		createFromExistingConfigurationButton = new Button(createFromExistingConfigurationComposite, SWT.RADIO);
		createFromExistingConfigurationButton.addSelectionListener(selectionListener);
		Label createFromExistingConfigurationLabel = new Label(createFromExistingConfigurationComposite, SWT.NONE);
		createFromExistingConfigurationLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		createFromExistingConfigurationLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfiguration_Label);
		createFromExistingConfigurationText = new Text(createFromExistingConfigurationComposite, SWT.BORDER | SWT.READ_ONLY);
		createFromExistingConfigurationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		createFromExistingConfigurationSelectionButton = new Button(createFromExistingConfigurationComposite, SWT.NONE);
		createFromExistingConfigurationSelectionButton.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigurationSelectionButton_Label);

		// modify an existing configuration composite
		Composite modifyExistingConfigurationComposite = new Composite(composite, SWT.BORDER);
		modifyExistingConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		modifyExistingConfigurationComposite.setLayout(new GridLayout(3, false));
		modifyExistingConfigurationButton = new Button(modifyExistingConfigurationComposite, SWT.RADIO);
		modifyExistingConfigurationButton.addSelectionListener(selectionListener);
		Label modifyExistingConfigurationLabel = new Label(modifyExistingConfigurationComposite, SWT.NONE);
		modifyExistingConfigurationLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		modifyExistingConfigurationLabel.setText(Messages.SelectConfigurationFileWizardPage_ModifyExistingConfiguration_Label);
		modifyExistingConfigurationText = new Text(modifyExistingConfigurationComposite, SWT.BORDER | SWT.READ_ONLY);
		modifyExistingConfigurationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		modifyExistingConfigurationSelectionButton = new Button(modifyExistingConfigurationComposite, SWT.NONE);
		modifyExistingConfigurationSelectionButton.setText(Messages.SelectConfigurationFileWizardPage_ModifyExistingConfigurationSelectionButton_Label);

	}

	/**
	 * Notifies that one of the radio button has been selected
	 * 
	 * @param e
	 *        selection event that triggers this method
	 */
	protected void notifyButtonChanged(SelectionEvent e) {
		if(createFromExistingConfigurationButton.equals(e.widget)) {
			selectCreateFromExistingConfigurationArea();
		} else if(modifyExistingConfigurationButton.equals(e.widget)) {
			selectModifyExistingConfigurationArea();
		} else {
			selectCreateFromScratchArea();
		}
	}

	/**
	 * Selects the "Create From Scratch" area, and disable the other ones
	 */
	protected void selectCreateFromScratchArea() {
		enableCreateFromScratchArea(true);
		enableModifyExistingConfigurationArea(false);
		enableCreateFromExistingConfigurationArea(false);
	}

	/**
	 * Selects the "Modify an existing configuration" area, and disable the other ones
	 */
	protected void selectModifyExistingConfigurationArea() {
		enableCreateFromScratchArea(false);
		enableModifyExistingConfigurationArea(true);
		enableCreateFromExistingConfigurationArea(false);
	}

	/**
	 * Selects the Create From existing configuration area, and disable the other ones
	 */
	protected void selectCreateFromExistingConfigurationArea() {
		enableCreateFromScratchArea(false);
		enableModifyExistingConfigurationArea(false);
		enableCreateFromExistingConfigurationArea(true);
	}

	/**
	 * Enables or disables the button and labels of create from existing configuration area
	 * 
	 * @param enable
	 *        boolean indicating the enable state: <code>true</code> when enable
	 */
	protected void enableCreateFromExistingConfigurationArea(boolean enable) {
		if(isValid(createFromExistingConfigurationButton)) {
			createFromExistingConfigurationButton.setSelection(enable);
			createFromExistingConfigurationSelectionButton.setEnabled(enable);
			createFromExistingConfigurationText.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the button and labels of modify existing configuration area
	 * 
	 * @param enable
	 *        boolean indicating the enable state: <code>true</code> when enable
	 */
	protected void enableModifyExistingConfigurationArea(boolean enable) {
		if(isValid(modifyExistingConfigurationButton)) {
			modifyExistingConfigurationButton.setSelection(enable);
			modifyExistingConfigurationText.setEnabled(enable);
			modifyExistingConfigurationSelectionButton.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the button and labels of create from scratch area
	 * 
	 * @param enable
	 *        boolean indicating the enable state: <code>true</code> when enable
	 */
	protected void enableCreateFromScratchArea(boolean enable) {
		if(isValid(createFromScratchButton)) {
			createFromScratchButton.setSelection(enable);
			createFromScratchText.setEnabled(enable);
		}
	}

	/**
	 * Checks if the specified control is valid.
	 * 
	 * @param control
	 *        the control to check
	 * @return <code>true</code> if the control is valid, i.e. not <code>null</code> and not disposed.
	 */
	protected boolean isValid(Control control) {
		return (control != null && !control.isDisposed());
	}

}
