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
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.dialog;



import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class ExportProfilesIconsDialog.
 */
public class ExportProfilesIconsDialog extends TrayDialog {

	/** The profiles. */
	private Object[] profiles;

	/** The profiles icons. */
	private String[] profilesIcons = new String[10];




	/** The table icon editor. */
	private StringFileSelector[] profileIconEditors = new StringFileSelector[10];

	/**
	 * Instantiates a new export profiles icons dialog.
	 *
	 * @param shell the shell
	 * @param profiles the profiles
	 */
	public ExportProfilesIconsDialog(Shell shell, Object[] profiles) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.profiles = profiles;

	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 *
	 */
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		this.createEditors();
	}

	/**
	 * Creates the editors.
	 */
	protected void createEditors() {
		GridData data = new GridData();
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;

		Composite parent = (Composite)getDialogArea();
		for(int i = 0; i < this.profiles.length; i++) {
			this.profileIconEditors[i] = new StringFileSelector(parent, SWT.BORDER);
			this.profileIconEditors[i].setLayoutData(data);
			this.profileIconEditors[i].setLabel("Icon for " + ((Profile)this.profiles[i]).getName());
			this.profileIconEditors[i].setToolTipText("Enter the profile icon");
		}

		// Configure the shell
		getShell().setSize(800, 250);
		getShell().setText("Choose icons for the profiles to export");
		getShell().layout();

	}

	/**
	 * Gets the profiles icons.
	 *
	 * @return the profiles icons
	 */
	public String[] getProfilesIcons() {
		return profilesIcons;
	}

	/**
	 * Ok pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */

	@Override
	protected void okPressed() {

		loop: for(int i = 0; i < this.profileIconEditors.length; i++) {
			if(this.profileIconEditors[i] != null)
				this.profilesIcons[i] = (String)this.profileIconEditors[i].getValue();
			else
				break loop;
		}

		super.okPressed();
	}

}
