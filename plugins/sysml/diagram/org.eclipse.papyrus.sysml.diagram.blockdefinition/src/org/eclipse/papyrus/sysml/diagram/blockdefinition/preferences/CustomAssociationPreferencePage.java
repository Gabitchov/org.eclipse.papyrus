/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;

import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DERIVE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MODIFIERS;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_NAME;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_TYPE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_VISIBILITY;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.diagram.common.preferences.LabelPreferenceHelper;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * {@link Association} preference page.
 */
public class CustomAssociationPreferencePage extends BlockDefinitionDiagramLinkPreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("Stereotype", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("Name", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("SourceRole", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("SourceMultiplicity", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("TargetRole", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("TargetMultiplicity", Boolean.TRUE); //$NON-NLS-1$	

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);
	}

	/** Constructor */
	public CustomAssociationPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		
		// Label default masks initialization
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(sourceRoleLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_NAME);
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(sourceMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_MULTIPLICITY);
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(targetRoleLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_NAME);
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(targetMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_MULTIPLICITY);
		
		// End of user code

		// Initialize default visibility for labels in preference page.
		for(String labelName : labelDefaultVisibilityMap.keySet()) {
			String showLabelKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, labelName, PreferenceConstantHelper.LABEL_VISIBILITY);
			store.setDefault(showLabelKey, labelDefaultVisibilityMap.get(labelName));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeLabelsList() {
		for(String name : labelDefaultVisibilityMap.keySet()) {
			this.labelsList.add(name);
		}
	}
	
	// Label display mask management in preference page
	
	/** buttons to select the display mask of the source labels */
	protected Button bttnSourceRoleVisibility, bttnSourceRoleDerive, bttnSourceRoleName, bttnSourceRoleType;
	protected Button bttnSourceMultMultiplicity, bttnSourceMultDefault_Multiplicity, bttnSourceMultModifiers;

	/** buttons to select the display mask of the target labels */
	protected Button bttnTargetRoleVisibility, bttnTargetRoleDerive, bttnTargetRoleName, bttnTargetRoleType;
	protected Button bttnTargetMultMultiplicity, bttnTargetMultDefault_Multiplicity, bttnTargetMultModifiers;
		
	/** Preference keys */
	public static String sourceRoleLabelKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_ROLE_ID; //$NON-NLS-1$	
	public static String sourceMultLabelKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_MULTIPLICITY_ID; //$NON-NLS-1$	
	public static String targetRoleLabelKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_ROLE_ID; //$NON-NLS-1$	
	public static String targetMultLabelKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_MULTIPLICITY_ID; //$NON-NLS-1$	

	private String sourceRoleLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(sourceRoleLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);
	private String sourceMultLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(sourceMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);
	private String targetRoleLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(targetRoleLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);
	private String targetMultLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(targetMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);
	
	/** Current property display styles for labels */
	private int sourceRoleDisplayValue = getPreferenceStore().getInt(sourceRoleLabelDisplayPreferenceKey);
	private int sourceMultDisplayValue = getPreferenceStore().getInt(sourceMultLabelDisplayPreferenceKey);
	private int targetRoleDisplayValue = getPreferenceStore().getInt(targetRoleLabelDisplayPreferenceKey);
	private int targetMultDisplayValue = getPreferenceStore().getInt(targetMultLabelDisplayPreferenceKey);
	
	/**
	 * Creates the group and check boxes to choose the kind of display for source role label
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createSourceRoleLabelPreferencesButtons(Composite parent) {
		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Source Role Label Display");
		group.setLayout(new FormLayout());

		FormData data;

		bttnSourceRoleVisibility = createSourceRoleCheckButton(group, "Visibility", DISP_VISIBILITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnSourceRoleVisibility.setLayoutData(data);

		bttnSourceRoleDerive = createSourceRoleCheckButton(group, "Derive", DISP_DERIVE);
		data = new FormData();
		data.left = new FormAttachment(bttnSourceRoleVisibility, 85);
		data.top = new FormAttachment(0, 0);
		bttnSourceRoleDerive.setLayoutData(data);

		bttnSourceRoleName = createSourceRoleCheckButton(group, "Name", DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(bttnSourceRoleDerive, 85);
		data.top = new FormAttachment(0, 0);
		bttnSourceRoleName.setLayoutData(data);

		bttnSourceRoleType = createSourceRoleCheckButton(group, "Type", DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(bttnSourceRoleName, 85);
		data.top = new FormAttachment(0, 0);
		bttnSourceRoleType.setLayoutData(data);
	}

	/**
	 * Creates the group and check boxes to choose the kind of display
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createSourceMultLabelPreferencesButtons(Composite parent) {
		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Source Multiplicity Label Display");
		group.setLayout(new FormLayout());

		FormData data;

		bttnSourceMultMultiplicity = createSourceMultCheckButton(group, "Multiplicity", DISP_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnSourceMultMultiplicity.setLayoutData(data);

		bttnSourceMultDefault_Multiplicity = createSourceMultCheckButton(group, "Default_Multiplicity", DISP_DEFAULT_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(bttnSourceMultMultiplicity, 85);
		data.top = new FormAttachment(0, 0);
		bttnSourceMultDefault_Multiplicity.setLayoutData(data);

		bttnSourceMultModifiers = createSourceMultCheckButton(group, "Modifiers", DISP_MODIFIERS);
		data = new FormData();
		data.left = new FormAttachment(bttnSourceMultDefault_Multiplicity, 85);
		data.top = new FormAttachment(0, 0);
		bttnSourceMultModifiers.setLayoutData(data);

	}
	
	/**
	 * Creates the group and check boxes to choose the kind of display for source role label
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createTargetRoleLabelPreferencesButtons(Composite parent) {
		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Target Role Label Display");
		group.setLayout(new FormLayout());

		FormData data;

		bttnTargetRoleVisibility = createTargetRoleCheckButton(group, "Visibility", DISP_VISIBILITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnTargetRoleVisibility.setLayoutData(data);

		bttnTargetRoleDerive = createTargetRoleCheckButton(group, "Derive", DISP_DERIVE);
		data = new FormData();
		data.left = new FormAttachment(bttnTargetRoleVisibility, 85);
		data.top = new FormAttachment(0, 0);
		bttnTargetRoleDerive.setLayoutData(data);

		bttnTargetRoleName = createTargetRoleCheckButton(group, "Name", DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(bttnTargetRoleDerive, 85);
		data.top = new FormAttachment(0, 0);
		bttnTargetRoleName.setLayoutData(data);

		bttnTargetRoleType = createTargetRoleCheckButton(group, "Type", DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(bttnTargetRoleName, 85);
		data.top = new FormAttachment(0, 0);
		bttnTargetRoleType.setLayoutData(data);
	}

	/**
	 * Creates the group and check boxes to choose the kind of display
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createTargetMultLabelPreferencesButtons(Composite parent) {
		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Target Multiplicity Label Display");
		group.setLayout(new FormLayout());

		FormData data;

		bttnTargetMultMultiplicity = createTargetMultCheckButton(group, "Multiplicity", DISP_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnTargetMultMultiplicity.setLayoutData(data);

		bttnTargetMultDefault_Multiplicity = createTargetMultCheckButton(group, "Default_Multiplicity", DISP_DEFAULT_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(bttnTargetMultMultiplicity, 85);
		data.top = new FormAttachment(0, 0);
		bttnTargetMultDefault_Multiplicity.setLayoutData(data);

		bttnTargetMultModifiers = createTargetMultCheckButton(group, "Modifiers", DISP_MODIFIERS);
		data = new FormData();
		data.left = new FormAttachment(bttnTargetMultDefault_Multiplicity, 85);
		data.top = new FormAttachment(0, 0);
		bttnTargetMultModifiers.setLayoutData(data);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// adds the label preferences check boxes
		createSourceRoleLabelPreferencesButtons(parent);
		createSourceMultLabelPreferencesButtons(parent);
		createTargetRoleLabelPreferencesButtons(parent);
		createTargetMultLabelPreferencesButtons(parent);
		
		refreshButtons();
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		sourceRoleDisplayValue = getPreferenceStore().getDefaultInt(sourceRoleLabelDisplayPreferenceKey);
		sourceMultDisplayValue = getPreferenceStore().getDefaultInt(sourceMultLabelDisplayPreferenceKey);
		targetRoleDisplayValue = getPreferenceStore().getDefaultInt(targetRoleLabelDisplayPreferenceKey);
		targetMultDisplayValue = getPreferenceStore().getDefaultInt(targetMultLabelDisplayPreferenceKey);
		
		refreshButtons();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performDefaults() {
		loadDefaultPreferences();
		super.performDefaults();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}

	/**
	 * Refresh the buttons that manages the display.
	 */
	protected void refreshButtons() {

		// Source Label Buttons
		bttnSourceRoleVisibility.setSelection((sourceRoleDisplayValue & DISP_VISIBILITY) == DISP_VISIBILITY);
		bttnSourceRoleDerive.setSelection((sourceRoleDisplayValue & DISP_DERIVE) == DISP_DERIVE);
		bttnSourceRoleName.setSelection((sourceRoleDisplayValue & DISP_NAME) == DISP_NAME);
		bttnSourceRoleType.setSelection((sourceRoleDisplayValue & DISP_TYPE) == DISP_TYPE);
		bttnSourceMultMultiplicity.setSelection((sourceMultDisplayValue & DISP_MULTIPLICITY) == DISP_MULTIPLICITY);
		bttnSourceMultDefault_Multiplicity.setSelection((sourceMultDisplayValue & DISP_DEFAULT_MULTIPLICITY) == DISP_DEFAULT_MULTIPLICITY);
		bttnSourceMultModifiers.setSelection((sourceMultDisplayValue & DISP_MODIFIERS) == DISP_MODIFIERS);

		// Target Label Buttons
		bttnTargetRoleVisibility.setSelection((targetRoleDisplayValue & DISP_VISIBILITY) == DISP_VISIBILITY);
		bttnTargetRoleDerive.setSelection((targetRoleDisplayValue & DISP_DERIVE) == DISP_DERIVE);
		bttnTargetRoleName.setSelection((targetRoleDisplayValue & DISP_NAME) == DISP_NAME);
		bttnTargetRoleType.setSelection((targetRoleDisplayValue & DISP_TYPE) == DISP_TYPE);
		bttnTargetMultMultiplicity.setSelection((targetMultDisplayValue & DISP_MULTIPLICITY) == DISP_MULTIPLICITY);
		bttnTargetMultDefault_Multiplicity.setSelection((targetMultDisplayValue & DISP_DEFAULT_MULTIPLICITY) == DISP_DEFAULT_MULTIPLICITY);
		bttnTargetMultModifiers.setSelection((targetMultDisplayValue & DISP_MODIFIERS) == DISP_MODIFIERS);
		
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		super.storePreferences();
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(sourceRoleDisplayValue != store.getInt(sourceRoleLabelDisplayPreferenceKey)) {
			store.setValue(sourceRoleLabelDisplayPreferenceKey, sourceRoleDisplayValue);
		}
		if(sourceMultDisplayValue != store.getInt(sourceMultLabelDisplayPreferenceKey)) {
			store.setValue(sourceMultLabelDisplayPreferenceKey, sourceMultDisplayValue);
		}
		if(targetRoleDisplayValue != store.getInt(targetRoleLabelDisplayPreferenceKey)) {
			store.setValue(targetRoleLabelDisplayPreferenceKey, targetRoleDisplayValue);
		}
		if(targetMultDisplayValue != store.getInt(targetMultLabelDisplayPreferenceKey)) {
			store.setValue(targetMultLabelDisplayPreferenceKey, targetMultDisplayValue);
		}
	}

	/**
	 * Creates a button with the {@link SWT#CHECK} style.
	 * 
	 * @param parent
	 *        the parent of the button
	 * @param label
	 *        the label of the button
	 * @param mask
	 *        the value controlled by the button
	 * @return the button created
	 */
	protected Button createSourceRoleCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new SourceRoleAppearenceSelectionListener(mask));
		return button;
	}
	
	/**
	 * Creates a button with the {@link SWT#CHECK} style.
	 * 
	 * @param parent
	 *        the parent of the button
	 * @param label
	 *        the label of the button
	 * @param mask
	 *        the value controlled by the button
	 * @return the button created
	 */
	protected Button createSourceMultCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new SourceMultAppearenceSelectionListener(mask));
		return button;
	}
	
	/**
	 * Creates a button with the {@link SWT#CHECK} style.
	 * 
	 * @param parent
	 *        the parent of the button
	 * @param label
	 *        the label of the button
	 * @param mask
	 *        the value controlled by the button
	 * @return the button created
	 */
	protected Button createTargetRoleCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new TargetRoleAppearenceSelectionListener(mask));
		return button;
	}
	
	/**
	 * Creates a button with the {@link SWT#CHECK} style.
	 * 
	 * @param parent
	 *        the parent of the button
	 * @param label
	 *        the label of the button
	 * @param mask
	 *        the value controlled by the button
	 * @return the button created
	 */
	protected Button createTargetMultCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new TargetMultAppearenceSelectionListener(mask));
		return button;
	}
	
	/**
	 * Listeners for the check buttons that select the source role display.
	 */
	private class SourceRoleAppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public SourceRoleAppearenceSelectionListener(int style) {
			this.style = style;
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// add or remove the flag to the display property value (invert the current value)
			sourceRoleDisplayValue = sourceRoleDisplayValue ^ style;

			// refresh buttons to show current values
			refreshButtons();
		}
	}
	
	/**
	 * Listeners for the check buttons that select the source multiplicity display.
	 */
	private class SourceMultAppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public SourceMultAppearenceSelectionListener(int style) {
			this.style = style;
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// add or remove the flag to the display property value (invert the current value)
			sourceMultDisplayValue = sourceMultDisplayValue ^ style;

			// refresh buttons to show current values
			refreshButtons();
		}
	}
	
	/**
	 * Listeners for the check buttons that select the target role display.
	 */
	private class TargetRoleAppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public TargetRoleAppearenceSelectionListener(int style) {
			this.style = style;
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// add or remove the flag to the display property value (invert the current value)
			targetRoleDisplayValue = targetRoleDisplayValue ^ style;

			// refresh buttons to show current values
			refreshButtons();
		}
	}
	
	/**
	 * Listeners for the check buttons that select the target multiplicity display.
	 */
	private class TargetMultAppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public TargetMultAppearenceSelectionListener(int style) {
			this.style = style;
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// add or remove the flag to the display property value (invert the current value)
			targetMultDisplayValue = targetMultDisplayValue ^ style;

			// refresh buttons to show current values
			refreshButtons();
		}
	}
	
}
