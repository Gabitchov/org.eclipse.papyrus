/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		R�gis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_NAME;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_TYPE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_UNDEFINED_TYPE;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.diagram.common.preferences.LabelPreferenceHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
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
 * {@link Connector} preference page.
 */
public class CustomConnectorPreferencePage extends ParametricDiagramLinkPreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_CONNECTOR_ID; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("Stereotype", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("Label", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("SourceMultiplicity", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("TargetMultiplicity", Boolean.TRUE); //$NON-NLS-1$	

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);
	}

	/** Constructor */
	public CustomConnectorPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_CONNECTOR_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations

		// Label default masks initialization
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(labelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_NAME | DISP_TYPE);
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(sourceMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_MULTIPLICITY);
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(targetMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_MULTIPLICITY);

		// End of user code

		// Initialize default visibility for labels in preference page.
		for(String labelName : labelDefaultVisibilityMap.keySet()) {
			String showLabelKey = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, labelName, PreferencesConstantsHelper.LABEL_VISIBILITY);
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

	/** buttons to select the display mask of the label */
	protected Button bttnName, bttnType, bttnUndefined_Type;

	/** buttons to select the display mask of the source labels */
	protected Button bttnSourceMultMultiplicity, bttnSourceMultDefault_Multiplicity;

	/** buttons to select the display mask of the target labels */
	protected Button bttnTargetMultMultiplicity, bttnTargetMultDefault_Multiplicity;

	/** Preference keys */
	public static String labelKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_CONNECTOR_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID; //$NON-NLS-1$	

	public static String sourceMultLabelKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_CONNECTOR_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID; //$NON-NLS-1$	

	public static String targetMultLabelKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_CONNECTOR_ID + "-" + UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID; //$NON-NLS-1$	

	private String labelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(labelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);

	private String sourceMultLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(sourceMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);

	private String targetMultLabelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(targetMultLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);

	/** Current property display styles for labels */
	private int labelDisplayValue = getPreferenceStore().getInt(labelDisplayPreferenceKey);

	private int sourceMultDisplayValue = getPreferenceStore().getInt(sourceMultLabelDisplayPreferenceKey);

	private int targetMultDisplayValue = getPreferenceStore().getInt(targetMultLabelDisplayPreferenceKey);

	/**
	 * Creates the group and check boxes to choose the kind of display
	 * 
	 * @param parent
	 *        the parent composite that holds the group
	 */
	protected void createLabelPreferencesButtons(Composite parent) {
		// create group that host the buttons
		Group group = new Group(parent, SWT.SHADOW_NONE);
		group.setText("Label Display");
		group.setLayout(new FormLayout());

		FormData data;

		bttnName = createLabelCheckButton(group, "Name", DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnName.setLayoutData(data);

		bttnType = createLabelCheckButton(group, "Type", DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(bttnName, 85);
		data.top = new FormAttachment(0, 0);
		bttnType.setLayoutData(data);

		bttnUndefined_Type = createLabelCheckButton(group, "Undefined_Type", DISP_UNDEFINED_TYPE);
		data = new FormData();
		data.left = new FormAttachment(bttnType, 85);
		data.top = new FormAttachment(0, 0);
		bttnUndefined_Type.setLayoutData(data);
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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// adds the label preferences check boxes
		createLabelPreferencesButtons(parent);
		createSourceMultLabelPreferencesButtons(parent);
		createTargetMultLabelPreferencesButtons(parent);

		refreshButtons();
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		labelDisplayValue = getPreferenceStore().getDefaultInt(labelDisplayPreferenceKey);
		sourceMultDisplayValue = getPreferenceStore().getDefaultInt(sourceMultLabelDisplayPreferenceKey);
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

		// Label refresh buttons
		bttnName.setSelection((labelDisplayValue & DISP_NAME) == DISP_NAME);
		bttnType.setSelection((labelDisplayValue & DISP_TYPE) == DISP_TYPE);
		bttnUndefined_Type.setSelection((labelDisplayValue & DISP_UNDEFINED_TYPE) == DISP_UNDEFINED_TYPE);

		// Source Label Buttons
		bttnSourceMultMultiplicity.setSelection((sourceMultDisplayValue & DISP_MULTIPLICITY) == DISP_MULTIPLICITY);
		bttnSourceMultDefault_Multiplicity.setSelection((sourceMultDisplayValue & DISP_DEFAULT_MULTIPLICITY) == DISP_DEFAULT_MULTIPLICITY);

		// Target Label Buttons
		bttnTargetMultMultiplicity.setSelection((targetMultDisplayValue & DISP_MULTIPLICITY) == DISP_MULTIPLICITY);
		bttnTargetMultDefault_Multiplicity.setSelection((targetMultDisplayValue & DISP_DEFAULT_MULTIPLICITY) == DISP_DEFAULT_MULTIPLICITY);

	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		super.storePreferences();
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(labelDisplayValue != store.getInt(labelDisplayPreferenceKey)) {
			store.setValue(labelDisplayPreferenceKey, labelDisplayValue);
		}
		if(sourceMultDisplayValue != store.getInt(sourceMultLabelDisplayPreferenceKey)) {
			store.setValue(sourceMultLabelDisplayPreferenceKey, sourceMultDisplayValue);
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
	protected Button createLabelCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new LabelAppearenceSelectionListener(mask));
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
	protected Button createTargetMultCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new TargetMultAppearenceSelectionListener(mask));
		return button;
	}

	/**
	 * Listeners for the check buttons that select the label display.
	 */
	private class LabelAppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public LabelAppearenceSelectionListener(int style) {
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
			labelDisplayValue = labelDisplayValue ^ style;

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
