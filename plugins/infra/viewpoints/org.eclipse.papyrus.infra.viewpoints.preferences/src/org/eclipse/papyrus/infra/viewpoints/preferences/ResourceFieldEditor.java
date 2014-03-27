/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.preferences;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.pluginexplorer.Plugin;
import org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry;
import org.eclipse.papyrus.infra.core.pluginexplorer.PluginsContentDialog;
import org.eclipse.papyrus.infra.core.pluginexplorer.PluginsContentSelectionValidator;
import org.eclipse.papyrus.infra.viewpoints.policy.PreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * Represents the preference field for the custom configuration selection
 * @author Laurent Wouters
 */
public class ResourceFieldEditor extends StringButtonFieldEditor {
	
	/**
	 * Absolute path selection mode
	 */
	public static final int MODE_FILE = 0;
	/**
	 * Workspace resource selection mode
	 */
	public static final int MODE_WORKSPACE = 1;
	/**
	 * Plugin's resource selection mode
	 */
	public static final int MODE_PLUGIN = 2;
	
    protected String[] extensions;
    protected int mode;
    
    /**
     * Initializes this field
     * @param name The field's name
     * @param labelText The displayed label
     * @param parent The parent component
     */
    public ResourceFieldEditor(String name, String labelText, Composite parent) {
    	init(name, labelText);
    	this.extensions = new String[] { "*.configuration" };
    	this.mode = 0;
        setErrorMessage(JFaceResources.getString("FileFieldEditor.errorMessage"));//$NON-NLS-1$
        setChangeButtonText(JFaceResources.getString("openBrowse"));//$NON-NLS-1$
        createControl(parent);
    }
    
    /**
     * Changes the field mode
     * @param mode The new mode
     */
    public void setMode(int mode) {
    	this.mode = mode;
    }

    /* (non-Javadoc)
     * Method declared on StringButtonFieldEditor.
     * Opens the file chooser dialog and returns the selected file.
     */
    protected String changePressed() {
    	switch (mode) {
    		case MODE_FILE:
    			return selectFile();
    		case MODE_WORKSPACE:
    			return selectInWorkspace();
    		case MODE_PLUGIN:
    			return selectInPlugin();
    		default:
    			return selectFile();
    	}
    }
    
    private String selectFile() {
    	FileDialog dialog = new FileDialog(getShell(), SWT.OPEN | SWT.SHEET);
    	dialog.setFilterExtensions(extensions);
    	String value = getTextControl().getText();
    	if (value != null && !value.isEmpty())
    		dialog.setFileName(value);
    	value = dialog.open();
        if (value != null) {
        	value = value.trim();
            if (value.length() > 0) {
            	File f = new File(value);
				return f.getAbsolutePath();
			}
        }
        return null;
    }
    
    private String selectInWorkspace() {
    	ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
    	dialog.setTitle("Configuration Selection");
    	dialog.setMessage("Select the custom configuration resource:");
    	dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
    	dialog.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection == null || selection.length == 0)
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No selected item!");
				if (selection.length > 1)
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Only one item should be selected!");
				if (!(selection[0] instanceof IFile))
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected item is not a configuration file!");
				IFile file = (IFile)selection[0];
				if (!file.getName().endsWith(".configuration"))
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected item is not a configuration file!");
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
			}
    	});
    	int value = dialog.open();
    	if (value != ElementTreeSelectionDialog.OK)
    		return null;
    	IFile file = (IFile)dialog.getFirstResult();
    	return PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE + file.getProject().getName() + "/" + file.getProjectRelativePath().toString();
    }
    
    private String selectInPlugin() {
    	PluginsContentDialog dialog = new PluginsContentDialog(getShell(), new PluginsContentSelectionValidator() {
			public boolean isValid(Plugin plugin) { return false; }
			public boolean isValid(PluginEntry entry) {
				return entry.getName().endsWith(".configuration");
			}
    	}, "Viewpoints configuration selection", "Select a configuration resource (*.configuration):");
    	int result = dialog.open();
    	if (result != Window.OK)
    		return null;
    	PluginEntry entry = (PluginEntry)dialog.getSelection();
    	if (entry == null)
    		return null;
    	return entry.getLogicalPath();
    }
}
