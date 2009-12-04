/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.wizards;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

/**
 * Wizard page for information about the new drawer
 */
public class DrawerInformationPage extends WizardPage implements Listener {

	/** text area for the name of the palette definition */
	protected Text nameText;

	/** text area for the id of the palette definition */
	protected Text idText;

	/** parent composite for advanced fields */
	protected Composite advancedComposite;

	/** Button to show/hide advanced fields */
	protected Button advancedButton;

	/** drawer ID */
	protected String drawerID;

	/** palette name */
	protected String name;

	/** image descriptor for the drawer icon */
	protected String imageDescriptorPath;

	/** Text area for icon path */
	protected Text imageText;

	/** drawer proxy to edit, if one exists */
	protected final PaletteLocalDrawerProxy drawerProxy;

	/** path to the icon */
	protected static final String WIZARD_ICON = "/icons/new_drawer_wiz.gif";

	/**
	 * Creates a new wizard page with the given name, title, and image.
	 * 
	 * @param part
	 *        the editor part in which the wizard was created
	 */
	public DrawerInformationPage() {
		super(Messages.Wizard_Drawer_Page_Name, Messages.Wizard_Drawer_Page_Title, Activator
				.getImageDescriptor(WIZARD_ICON));
		drawerProxy = null;
	}

	/**
	 * Creates a new wizard page with the given name, title, and image.
	 * 
	 * @param part
	 *        the editor part in which the wizard was created
	 */
	public DrawerInformationPage(PaletteLocalDrawerProxy drawerProxy) {
		super(Messages.Wizard_Drawer_Page_Name, Messages.Wizard_Drawer_Page_Title, Activator
				.getImageDescriptor(WIZARD_ICON));
		this.drawerProxy = drawerProxy;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {

		// initialize dialog units
		initializeDialogUnits(parent);

		// initialize values
		intializeValues();

		// Create a new composite as there is the title bar seperator
		// to deal with
		Composite control = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		control.setLayout(layout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(control);

		createNameControl(control);

		createAdvancedControls(control);

		// end of the control creation
		Dialog.applyDialogFont(control);

		validatePage();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setPageComplete(false);
		setControl(control);
	}

	/**
	 * initializes fields using context information
	 */
	protected void intializeValues() {
		initName();
		initDrawerID();
		initImageDescriptor();
	}

	/**
	 * Returns the current value of palette name
	 * 
	 * @return the current value of palette name
	 */
	public String getDrawerName() {
		return name;
	}

	/**
	 * Returns the current value of palette ID
	 * 
	 * @return the current value of palette ID
	 */
	public String getDrawerID() {
		return drawerID;
	}

	/**
	 * Returns the current value of path for image descriptor
	 * 
	 * @return the current value of path for image descriptor
	 */
	public String getImageDescriptorPath() {
		return imageDescriptorPath;
	}

	/**
	 * inits the name field value
	 */
	protected void initName() {
		if(drawerProxy == null) {
			name = "";
		} else {
			name = drawerProxy.getLabel();
		}

	}

	/**
	 * inits the palette id value
	 */
	protected void initDrawerID() {
		if(drawerProxy == null) {
			drawerID = "drawer_" + System.currentTimeMillis();
		} else {
			drawerID = drawerProxy.getId();
		}

	}

	/**
	 * Inits the image descriptor
	 */
	protected void initImageDescriptor() {
		if(drawerProxy == null) {
			imageDescriptorPath = "/icons/drawer.gif";
		} else {
			imageDescriptorPath = drawerProxy.getImagePath();
		}

	}

	/**
	 * Validates the content of the fields in this page
	 */
	protected boolean validatePage() {
		boolean valid = true;
		if(advancedComposite != null && !advancedComposite.isDisposed()) {

			if("".equals(getDrawerID())) {
				setErrorMessage(Messages.Wizard_Drawer_Error_Id);
				valid = false;
			} else if("".equals(getImageDescriptorPath())) {
				setErrorMessage(Messages.Wizard_Drawer_Error_Icon);
				valid = false;
			}
		}

		if("".equals(getDrawerName())) {
			setErrorMessage(Messages.Wizard_Drawer_Error_Name);
			valid = false;
		}

		if(valid) {
			setMessage(null);
			setErrorMessage(null);
		}
		return valid;
	}

	/**
	 * Creates the widget for advanced options.
	 * 
	 * @param parent
	 *        the parent composite
	 */
	protected void createAdvancedControls(Composite parent) {
		advancedButton = new Button(parent, SWT.PUSH);
		advancedButton.setFont(parent.getFont());
		advancedButton.setText(Messages.Dialog_Advanced_Button_Closed);
		GridData data = setButtonLayoutData(advancedButton);
		data.horizontalAlignment = GridData.BEGINNING;
		data.horizontalSpan = 2;
		advancedButton.setLayoutData(data);
		advancedButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				handleAdvancedButtonSelect();
			}
		});
	}

	public Composite createAdvancedComposite(Composite parent) {
		advancedComposite = new Composite(parent, SWT.NONE);
		advancedComposite.setFont(parent.getFont());
		advancedComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		advancedComposite.setLayout(layout);

		createIconControl(advancedComposite);

		createIDControl(advancedComposite);

		advancedComposite.getParent().layout();
		return advancedComposite;
	}

	/**
	 * creates the control area for the icon path definition
	 * 
	 * @param composite
	 *        the parent composite
	 */
	protected void createIconControl(Composite composite) {
		final Label iconLabel = new Label(composite, SWT.NONE);
		iconLabel.setText(Messages.Wizard_Drawer_Icon);
		iconLabel.setToolTipText(Messages.Wizard_Drawer_Icon_Tooltip);

		imageText = new Text(composite, SWT.BORDER);
		imageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		imageText.setToolTipText(Messages.Wizard_Drawer_Icon_Tooltip);

		// initialize, then add the listener...
		initialPopulateDrawerIconField();

		imageText.addListener(SWT.Modify, this);

	}

	/**
	 * Shows/hides the advanced option widgets.
	 */
	protected void handleAdvancedButtonSelect() {
		Composite composite = (Composite)getControl();

		if(advancedComposite != null) {
			advancedComposite.dispose();
			advancedComposite = null;
			advancedButton.setText(Messages.Dialog_Advanced_Button_Closed);
		} else {
			createAdvancedComposite(composite);
			advancedButton.setText(Messages.Dialog_Advanced_Button_Opened);
		}
	}

	/**
	 * creates the control area for the id definition
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createIDControl(Composite control) {
		final Label idLabel = new Label(control, SWT.NONE);
		idLabel.setText(Messages.Wizard_Drawer_Id);
		idLabel.setToolTipText(Messages.Wizard_Drawer_Id_Tooltip);

		idText = new Text(control, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		idText.setToolTipText(Messages.Wizard_Drawer_Id_Tooltip);

		// initialize, then add the listener...
		initialPopulateDrawerIDField();

		idText.addListener(SWT.Modify, this);
	}

	/**
	 * intialize the field using current value of the palette id
	 */
	protected void initialPopulateDrawerIconField() {
		imageText.setText(imageDescriptorPath);
	}

	/**
	 * intialize the field using current value of the palette id
	 */
	protected void initialPopulateDrawerIDField() {
		idText.setText(drawerID);
	}

	/**
	 * creates the control area for the name definition
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createNameControl(Composite control) {
		final Label nameLabel = new Label(control, SWT.NONE);
		nameLabel.setText(Messages.Wizard_Drawer_Name);
		nameLabel.setToolTipText(Messages.Wizard_Drawer_Name_Tooltip);

		nameText = new Text(control, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		nameText.setToolTipText(Messages.Wizard_Drawer_Name_Tooltip);

		// initialize, then add the listener...
		initialPopulateNameField();

		nameText.addListener(SWT.Modify, this);

	}

	/**
	 * initialize name field
	 */
	protected void initialPopulateNameField() {
		nameText.setText(name);
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this <code>Listener</code> method handles all events and enablements for controls
	 * on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		Widget widget = event.widget;
		if(widget.equals(nameText)) {
			name = nameText.getText();
		} else if(widget.equals(idText)) {
			drawerID = idText.getText();
		} else if(widget.equals(imageText)) {
			imageDescriptorPath = imageText.getText();
		}
		setPageComplete(validatePage());
	}

}
