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

import java.util.List;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.PreferenceConstants;
import org.eclipse.papyrus.infra.viewpoints.policy.WeightedConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Represents the preference page for the viewpoints configuration
 * @author Laurent Wouters
 */
public class ViewpointsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	private PapyrusConfiguration currentConfig;
	private boolean customConfig;
	private String scheme;
	
	private RadioGroupFieldEditor fieldType;
	private ComboFieldEditor fieldScheme;
	private ResourceFieldEditor fieldPath;
	private BooleanFieldEditor fieldForceMultiplicity;
	private UpdatableComboBoxFieldEditor fieldStakeholder;
	private UpdatableComboBoxFieldEditor fieldViewpoint;
	private Label labelConfig;
	private Group groupCustom;
	private Group groupVP;
	
	public ViewpointsPreferencePage() {
		super(GRID);
		setPreferenceStore(PolicyChecker.getPreferences());
		setDescription("Preference page for the configuration of Papyrus viewpoints");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		IPreferenceStore store = getPreferenceStore();
		currentConfig = PolicyChecker.getCurrent().getConfiguration();
		String valueType = store.getString(PreferenceConstants.P_CONF_TYPE);
		scheme = store.getString(PreferenceConstants.P_CONF_PATH_SCHEME);
		if (scheme == null || scheme.isEmpty())
			scheme = PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE;
		
		fieldType = new RadioGroupFieldEditor(PreferenceConstants.P_CONF_TYPE, "Configuration selection:", 1, new String[][]{
			{ PreferenceConstants.P_CONF_TYPE_DEFAULT_LABEL, PreferenceConstants.P_CONF_TYPE_DEFAULT_VALUE },
			{ PreferenceConstants.P_CONF_TYPE_EXTENSION_LABEL, PreferenceConstants.P_CONF_TYPE_EXTENSION_VALUE },
			{ PreferenceConstants.P_CONF_TYPE_USER_DEFINED_LABEL, PreferenceConstants.P_CONF_TYPE_USER_DEFINED_VALUE}
		}, getFieldEditorParent(), true);
		
		GridData gd = new GridData();
		gd.horizontalSpan = 3;
		gd.horizontalAlignment = GridData.FILL;
		Composite rest = new Composite(getFieldEditorParent(), SWT.SHADOW_NONE);
		rest.setLayout(new FillLayout(SWT.VERTICAL));
		rest.setLayoutData(gd);
		
		groupCustom = new Group(rest, SWT.SHADOW_ETCHED_IN);
		groupCustom.setText(PreferenceConstants.P_CONF_TYPE_USER_DEFINED_LABEL + ":");
		
		fieldScheme = new ComboFieldEditor(PreferenceConstants.P_CONF_PATH_SCHEME, "Access scheme:", new String[][]{
				{ PreferenceConstants.P_CONF_PATH_SCHEME_FILE_LABEL, PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE },
				{ PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_LABEL, PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE },
				{ PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_LABEL, PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE }
		}, groupCustom);
		fieldScheme.setEnabled(PreferenceConstants.P_CONF_TYPE_USER_DEFINED_VALUE.equals(valueType), groupCustom);
		
		fieldPath = new ResourceFieldEditor(PreferenceConstants.P_CONF_PATH, "&Path:", groupCustom);
		fieldPath.setMode(0);
		fieldPath.setEnabled(PreferenceConstants.P_CONF_TYPE_USER_DEFINED_VALUE.equals(valueType), groupCustom);
		if (PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_FILE);
		} else if (PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_WORKSPACE);
		} else if (PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_PLUGIN);
		}
		
		groupVP = new Group(rest, SWT.SHADOW_ETCHED_IN);
		groupVP.setText("Viewpoint selection:");
		
		gd = new GridData();
		gd.horizontalSpan = 1;
		Label titleConf = new Label(groupVP, SWT.LEFT);
		titleConf.setText("Configuration:");
		titleConf.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalSpan = 1;
		gd.horizontalAlignment = GridData.FILL;
		labelConfig = new Label(groupVP, SWT.LEFT);
		if (PreferenceConstants.P_CONF_TYPE_DEFAULT_VALUE.equals(valueType))
			labelConfig.setText("Builtin");
		else if (PreferenceConstants.P_CONF_TYPE_EXTENSION_VALUE.equals(valueType)) {
			WeightedConfiguration config = WeightedConfiguration.getTopConfiguration();
			labelConfig.setText((config == null) ? "No suitable configuration" : config.getURI());
		} else if (PreferenceConstants.P_CONF_TYPE_USER_DEFINED_VALUE.equals(valueType))
			labelConfig.setText(store.getString(PreferenceConstants.P_CONF_PATH));
		labelConfig.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalSpan = 1;
		Label labelMulti = new Label(groupVP, SWT.LEFT);
		labelMulti.setText("Multiplicity:");
		labelMulti.setLayoutData(gd);
		fieldForceMultiplicity = new BooleanFieldEditor(PreferenceConstants.P_FORCE_MULTIPLICITY, PreferenceConstants.P_FORCE_MULTIPLICITY_LABEL, groupVP);
		
		
		fieldStakeholder = new UpdatableComboBoxFieldEditor(PreferenceConstants.P_STAKEHOLDER, "&Stakeholder:", groupVP);
		fieldStakeholder.setContent(currentConfig.getStakeholders(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		
		fieldViewpoint = new UpdatableComboBoxFieldEditor(PreferenceConstants.P_VIEWPOINT, "&Viewpoint:", groupVP);
		fieldViewpoint.setContent(PolicyChecker.getCurrent().getStakeholder().getViewpoints(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		
		addField(fieldType);
		addField(fieldScheme);
		addField(fieldPath);
		addField(fieldStakeholder);
		addField(fieldViewpoint);
		
	}
	
	@Override
	protected void checkState() {
		super.checkState();
		if (currentConfig == null || fieldViewpoint.getSelection() == null || fieldStakeholder.getSelection() == null) {
			this.setMessage("The currently selected configuration does not provide adequate viewpoints", ERROR);
			setValid(false);
		} else {
			this.setMessage(null, NONE);
			setValid(true);
		}
	}
	
	@Override
    protected void performDefaults() {
		super.performDefaults();
		customConfig  = false;
		WeightedConfiguration config = WeightedConfiguration.getTopConfiguration();
		currentConfig = (config != null ? config.getConfiguration() : PolicyChecker.getDefaultConfiguration());
		fieldPath.setStringValue("");
		labelConfig.setText((config == null) ? "Builtin default" : config.getURI());
		fieldPath.setEnabled(false, groupCustom);
		fieldScheme.setEnabled(false, groupCustom);
		if (currentConfig != null) {
			List<Stakeholder> list = currentConfig.getStakeholders();
			fieldStakeholder.setContent(list, Iso42010Package.Literals.AD_ELEMENT__NAME);
			fieldViewpoint.setContent(list.get(0).getViewpoints(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		} else {
			fieldStakeholder.clearContent();
			fieldViewpoint.clearContent();
		}
    }

	@Override
    public boolean performOk() {
		boolean result = super.performOk();
		if (!result)
			return false;
		if (currentConfig == null || fieldViewpoint.getSelection() == null || fieldStakeholder.getSelection() == null)
			return false;
		PolicyChecker newPolicy = new PolicyChecker(currentConfig, (PapyrusViewpoint)fieldViewpoint.getSelection(), fieldForceMultiplicity.getBooleanValue());
		PolicyChecker.setCurrent(newPolicy);
    	return true;
    }
	
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if (event.getSource() == fieldType) {
			onChangeType(event);
		} else if (event.getSource() == fieldScheme) {
			onChangeScheme(event);
		} else if (event.getSource() == fieldPath) {
			onChangePath(event);
		} else if (event.getSource() == fieldStakeholder) {
			onChangeStakeholder(event);
		}
		checkState();
    }
	
	private void onChangeType(PropertyChangeEvent event) {
		currentConfig = null;
		if (PreferenceConstants.P_CONF_TYPE_DEFAULT_VALUE.equals(event.getNewValue())) {
			customConfig  = false;
			currentConfig = PolicyChecker.getDefaultConfiguration();
			fieldPath.setStringValue("");
			labelConfig.setText("Builtin default");
		} else if (PreferenceConstants.P_CONF_TYPE_EXTENSION_VALUE.equals(event.getNewValue())) {
			customConfig  = false;
			WeightedConfiguration config = WeightedConfiguration.getTopConfiguration();
			currentConfig = (config != null ? config.getConfiguration() : PolicyChecker.getDefaultConfiguration());
			fieldPath.setStringValue("");
			labelConfig.setText((config == null) ? "Builtin default" : config.getURI());
		} else if (PreferenceConstants.P_CONF_TYPE_USER_DEFINED_VALUE.equals(event.getNewValue())) {
			customConfig  = true;
			labelConfig.setText("...");
		}
		fieldPath.setEnabled(customConfig, groupCustom);
		fieldScheme.setEnabled(customConfig, groupCustom);
		if (currentConfig != null) {
			List<Stakeholder> list = currentConfig.getStakeholders();
			fieldStakeholder.setContent(list, Iso42010Package.Literals.AD_ELEMENT__NAME);
			fieldViewpoint.setContent(list.get(0).getViewpoints(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		} else {
			fieldStakeholder.clearContent();
			fieldViewpoint.clearContent();
		}
	}
	
	private void onChangeScheme(PropertyChangeEvent event) {
		scheme = event.getNewValue().toString();
		fieldPath.setStringValue("");
		if (PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_FILE);
		} else if (PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_WORKSPACE);
		} else if (PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE.equals(scheme)) {
			fieldPath.setMode(ResourceFieldEditor.MODE_PLUGIN);
		}
	}
	
	private void onChangePath(PropertyChangeEvent event) {
		if (!customConfig)
			return;
		String path = event.getNewValue().toString();
		currentConfig = null;
		if (path != null && !path.isEmpty()) {
			if (PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE.equals(scheme)) {
				currentConfig = PolicyChecker.loadConfigurationFrom(path);
			} else if (PreferenceConstants.P_CONF_PATH_SCHEME_WORKSPACE_VALUE.equals(scheme)) {
				currentConfig = PolicyChecker.loadConfigurationFrom(path);
			} else if (PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE.equals(scheme)) {
				currentConfig = PolicyChecker.loadConfigurationFrom(path);
			}
			labelConfig.setText(path);
		}
		if (currentConfig != null) {
			List<Stakeholder> list = currentConfig.getStakeholders();
			fieldStakeholder.setContent(list, Iso42010Package.Literals.AD_ELEMENT__NAME);
			fieldViewpoint.setContent(list.get(0).getViewpoints(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		} else {
			fieldStakeholder.clearContent();
			fieldViewpoint.clearContent();
		}
	}
	
	private void onChangeStakeholder(PropertyChangeEvent event) {
		Object value = event.getNewValue();
		if (value != null) {
			Stakeholder stakeholder = (Stakeholder)value;
			fieldViewpoint.setContent(stakeholder.getViewpoints(), Iso42010Package.Literals.AD_ELEMENT__NAME);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) { }
}