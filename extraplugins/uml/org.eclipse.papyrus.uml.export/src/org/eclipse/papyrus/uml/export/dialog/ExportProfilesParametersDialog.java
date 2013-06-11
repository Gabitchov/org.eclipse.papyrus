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
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class ExportProfilesParametersDialog.
 */
public class ExportProfilesParametersDialog extends TrayDialog {

	/** The plugin name. */
	private String pluginName;

	/** The plugin provider. */
	private String pluginProvider;

	/** The plugin version. */
	private String pluginVersion;

	/** The plugin exec environment. */
	private String pluginExecEnvironment;

	/** The plugin name editor. */
	private StringEditor pluginNameEditor;

	/** The plugin provider editor. */
	private StringEditor pluginProviderEditor;

	/** The plugin version editor. */
	private StringEditor pluginVersionEditor;

	/** The plugin exec environment editor. */
	private StringEditor pluginExecEnvironmentEditor;

	private Object[] profiles;

	private String[] profilesIcons = new String[10];

	private StringFileSelector[] profileIconEditors = new StringFileSelector[10];

	/**
	 * Instantiates a new export profiles parameters dialog.
	 * 
	 * @param shell
	 *        the shell
	 * @param pluginName
	 *        the plugin name
	 * @param pluginProvider
	 *        the plugin provider
	 * @param pluginVersion
	 *        the plugin version
	 * @param execEnvironment
	 *        the exec environment
	 */
	public ExportProfilesParametersDialog(Shell shell, String pluginName, String pluginProvider, String pluginVersion, String execEnvironment, Object[] profiles) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.setPluginName(pluginName == null ? "" : pluginName); //$NON-NLS-1$
		this.setPluginProvider(pluginProvider == null ? "" : pluginProvider); //$NON-NLS-1$
		this.setPluginVersion(pluginVersion == null ? "" : pluginVersion); //$NON-NLS-1$
		this.setPluginExecEnvironment(execEnvironment == null ? "" : execEnvironment); //$NON-NLS-1$
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


		this.pluginNameEditor = new StringEditor(parent, SWT.NONE, Messages.ExportProfilesParametersDialog_0);
		this.pluginNameEditor.setValue(getPluginName());
		this.pluginNameEditor.setLayoutData(data);
		this.pluginNameEditor.setToolTipText(Messages.ExportProfilesParametersDialog_1);


		this.pluginProviderEditor = new StringEditor(parent, SWT.BORDER, Messages.ExportProfilesParametersDialog_2);
		this.pluginProviderEditor.setValue(getPluginProvider());
		this.pluginProviderEditor.setLayoutData(data);
		this.pluginProviderEditor.setToolTipText(Messages.ExportProfilesParametersDialog_7);

		this.pluginVersionEditor = new StringEditor(parent, SWT.BORDER, Messages.ExportProfilesParametersDialog_8);
		this.pluginVersionEditor.setValue(getPluginVersion());
		this.pluginVersionEditor.setLayoutData(data);
		this.pluginVersionEditor.setToolTipText(Messages.ExportProfilesParametersDialog_9);


		this.pluginExecEnvironmentEditor = new StringEditor(parent, SWT.BORDER, Messages.ExportProfilesParametersDialog_10);
		this.pluginExecEnvironmentEditor.setValue(getPluginExecEnvironment());
		this.pluginExecEnvironmentEditor.setLayoutData(data);
		this.pluginExecEnvironmentEditor.setToolTipText(Messages.ExportProfilesParametersDialog_11);

		for(int i = 0; i < this.profiles.length; i++) {
			this.profileIconEditors[i] = new StringFileSelector(parent, SWT.BORDER);
			this.profileIconEditors[i].setLayoutData(data);
			this.profileIconEditors[i].setLabel("Icon for " + ((Profile)this.profiles[i]).getName());
			this.profileIconEditors[i].setToolTipText("Enter the profile icon");
		}


		//Configure the shell
		getShell().setSize(800, 350);

		getShell().setText(Messages.ExportProfilesParametersDialog_12);


		getShell().layout();


	}

	/**
	 * Ok pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */

	@Override
	protected void okPressed() {

		loop: for(int i = 0; i < this.profileIconEditors.length; i++) {
			if(this.profileIconEditors[i] != null) {
				this.profilesIcons[i] = (String)this.profileIconEditors[i].getValue();
			} else {
				break loop;
			}
		}
		this.pluginExecEnvironment = (String)this.pluginExecEnvironmentEditor.getValue();
		this.pluginName = (String)this.pluginNameEditor.getValue();
		this.pluginProvider = (String)this.pluginProviderEditor.getValue();
		this.pluginVersion = (String)this.pluginVersionEditor.getValue();


		super.okPressed();
	}

	/**
	 * Gets the plugin name.
	 * 
	 * @return the plugin name
	 */
	public String getPluginName() {
		return pluginName;
	}

	/**
	 * Sets the plugin name.
	 * 
	 * @param pluginName
	 *        the new plugin name
	 */
	private void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	/**
	 * Gets the plugin provider.
	 * 
	 * @return the plugin provider
	 */
	public String getPluginProvider() {
		return pluginProvider;
	}

	/**
	 * Sets the plugin provider.
	 * 
	 * @param pluginProvider
	 *        the new plugin provider
	 */
	private void setPluginProvider(String pluginProvider) {
		this.pluginProvider = pluginProvider;
	}

	/**
	 * Gets the plugin version.
	 * 
	 * @return the plugin version
	 */
	public String getPluginVersion() {
		return pluginVersion;
	}

	/**
	 * Sets the plugin version.
	 * 
	 * @param pluginVersion
	 *        the new plugin version
	 */
	private void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	/**
	 * Gets the plugin exec environment.
	 * 
	 * @return the plugin exec environment
	 */
	public String getPluginExecEnvironment() {
		return pluginExecEnvironment;
	}

	/**
	 * Sets the plugin exec environment.
	 * 
	 * @param execEnvironment
	 *        the new plugin exec environment
	 */
	private void setPluginExecEnvironment(String execEnvironment) {
		this.pluginExecEnvironment = execEnvironment;
	}


	public String[] getProfilesIcons() {
		return profilesIcons;
	}

}
