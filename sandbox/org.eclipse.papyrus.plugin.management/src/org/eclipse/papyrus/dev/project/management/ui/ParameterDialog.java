/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.dev.project.management.ui;



import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



/**
 * The Class ParameterDialog.
 */
public class ParameterDialog extends InputDialog {

	/** boolean to check the HTML file. */
	private boolean checkHTMLFile = false;

	/** boolean to check the mark incubation. */
	private boolean checkIncubation = true;

	/** String for the version number. */
	private String versionNumber = "0.0.0";

	/** the plugin name pattern. */
	private String pluginNamePattern = "org.eclipse.papyrus.*";

	/** the provider name for these plugins. */
	private String providerName = "Eclipse Modeling Project";

	/** The version text. */
	private Text versionText;

	/** The provider text. */
	private Text providerText;

	/** The plugin pattern text. */
	private Text pluginPatternText;

	/** The verify incubation button. */
	private Button verifyIncubationButton;

	/** The verify html file button. */
	private Button verifyHTMLFileButton;
	
	/**
	 * Instantiates a new parameter dialog.
	 *
	 * @param activeShell the active shell
	 */
	public ParameterDialog(Shell activeShell) {
		super(activeShell, "Plugin managment", "Apply the modifications on the plugin beginning with : ", "org.eclipse.papyrus*", null);
	}

	/**
	 * @see org.eclipse.jface.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		//				Composite composite = new Composite(parent, SWT.NONE);
		//				GridLayout layout = new GridLayout();
		//				layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		//				layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		//				layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		//				layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		//				composite.setLayout(layout);
		//				composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		//				applyDialogFont(composite);
		//				return composite;

		//the field with the plugin name pattern
		//				Label pluginNameLabel = new Label(composite, SWT.WRAP);
		//				pluginNameLabel.setText("Apply the modifications on the plugin beginning with : ");
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		//				data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		//				pluginNameLabel.setLayoutData(data);
		//				pluginNameLabel.setFont(parent.getFont());
		//				Text pluginNameText = new Text(composite, getInputTextStyle());
		//				pluginNameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		//				applyDialogFont(composite);
		//				pluginNameText.setText("org.eclipse.papyrus");

		//		//the field for the version number
		Label versioLabel = new Label(composite, SWT.WRAP);
		versioLabel.setText("Version : ");
		//		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		versioLabel.setLayoutData(data);
		versioLabel.setFont(parent.getFont());
		versionText = new Text(composite, getInputTextStyle());
		versionText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		applyDialogFont(composite);
		versionText.setText("0.0.0");


		//the field with the provider name
		Label providerNameLabel = new Label(composite, SWT.WRAP);
		providerNameLabel.setText("Provider name : ");
		//		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		providerNameLabel.setLayoutData(data);
		providerNameLabel.setFont(parent.getFont());
		providerText = new Text(composite, getInputTextStyle());
		providerText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		applyDialogFont(composite);
		providerText.setText("Eclipse Modeling Project");

		// verify the HTML File
		verifyHTMLFileButton = new Button(composite, SWT.CHECK);
		verifyHTMLFileButton.setText("Verify the about.html file ?");
		verifyHTMLFileButton.setSelection(true);
		verifyHTMLFileButton.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		applyDialogFont(composite);

		//verify the text ("Incubation") in the plugin name?
		verifyIncubationButton = new Button(composite, SWT.CHECK);
		verifyIncubationButton.setText("Verify the mark 'Incubation' in the plugin name?");
		verifyIncubationButton.setSelection(true);
		verifyIncubationButton.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		applyDialogFont(composite);

		return composite;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 *
	 */
	@Override
	protected void okPressed() {
		//we get the value before the dispose of the widgets
		this.checkIncubation = this.verifyIncubationButton.getSelection();
		this.versionNumber = this.versionText.getText();
		this.pluginNamePattern = getText().getText();//pluginPatternText.getText();
//		this.pluginNamePattern = this.pluginPatternText.getText();
		this.providerName = this.providerText.getText();
		this.checkHTMLFile = this.verifyHTMLFileButton.getSelection();
		super.okPressed();
	}


	/**
	 * Checks if there is the html file.
	 *
	 * @return true, if there is the html file.
	 */
	public boolean isCheckHTMLFile() {
		return checkHTMLFile;
	}


/**
 * 
 * @return
 * true, if we check the mark "(Incubation)"
 */
	public boolean isCheckIncubation() {
		return checkIncubation;
	}


	/**
	 * Gets the plugin name pattern.
	 *
	 * @return the plugin name pattern
	 */
	public String getPluginNamePattern() {
		return pluginNamePattern;
	}

	/**
	 * Gets the provider name.
	 *
	 * @return the provider name
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * Gets the version number.
	 *
	 * @return the version number
	 */
	public String getVersionNumber() {
		return this.versionNumber;
	}

}
