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
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DEFAULTVALUE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_DERIVE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MODIFIERS;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MULTIPLICITY;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_NAME;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_TYPE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_UNDEFINED_TYPE;
import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_VISIBILITY;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
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
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * {@link Port} preference page.
 */
public class ConstraintParameterAsBorderItemPreferencePage extends ParametricDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID; //$NON-NLS-1$

	public static String prefLabelKey = prefKey + "-" + UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("Stereotype", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("Label", Boolean.TRUE); //$NON-NLS-1$	

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);
	}

	/** Constructor */
	public ConstraintParameterAsBorderItemPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(prefLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_NAME | DISP_TYPE | DISP_MULTIPLICITY | DISP_UNDEFINED_TYPE);

		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 20);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 20);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.ELEMENTICON), 0);

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

	/** buttons to select the display mask of the label */
	protected Button bttnVisibility, bttnDerive, bttnName, bttnType, bttnUndefined_Type, bttnMultiplicity, bttnDefault_Multiplicity, bttnDefaultValue, bttnModifiers;

	private String labelDisplayPreferenceKey = LabelPreferenceHelper.getPreferenceConstant(prefLabelKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE);

	/** current property display style */
	private int propertyValue = getPreferenceStore().getInt(labelDisplayPreferenceKey);

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
	protected Button createCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new AppearenceSelectionListener(mask));
		return button;
	}

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

		bttnVisibility = createCheckButton(group, "Visibility", DISP_VISIBILITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		bttnVisibility.setLayoutData(data);

		bttnDerive = createCheckButton(group, "Derive", DISP_DERIVE);
		data = new FormData();
		data.left = new FormAttachment(bttnVisibility, 85);
		data.top = new FormAttachment(0, 0);
		bttnDerive.setLayoutData(data);

		bttnName = createCheckButton(group, "Name", DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(bttnDerive, 85);
		data.top = new FormAttachment(0, 0);
		bttnName.setLayoutData(data);

		bttnType = createCheckButton(group, "Type", DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(bttnName, 85);
		data.top = new FormAttachment(0, 0);
		bttnType.setLayoutData(data);

		bttnUndefined_Type = createCheckButton(group, "Undefined_Type", DISP_UNDEFINED_TYPE);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		bttnUndefined_Type.setLayoutData(data);

		bttnMultiplicity = createCheckButton(group, "Multiplicity", DISP_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(bttnVisibility, 85);
		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		bttnMultiplicity.setLayoutData(data);

		bttnDefault_Multiplicity = createCheckButton(group, "Default_Multiplicity", DISP_DEFAULT_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(bttnDerive, 85);
		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		bttnDefault_Multiplicity.setLayoutData(data);

		bttnDefaultValue = createCheckButton(group, "DefaultValue", DISP_DEFAULTVALUE);
		data = new FormData();
		data.left = new FormAttachment(bttnName, 85);
		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		bttnDefaultValue.setLayoutData(data);

		bttnModifiers = createCheckButton(group, "Modifiers", DISP_MODIFIERS);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(bttnUndefined_Type, ITabbedPropertyConstants.HSPACE);
		bttnModifiers.setLayoutData(data);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// adds the label preferences check boxes
		createLabelPreferencesButtons(parent);

		refreshButtons();
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		propertyValue = getPreferenceStore().getDefaultInt(labelDisplayPreferenceKey);
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

		bttnVisibility.setSelection((propertyValue & DISP_VISIBILITY) == DISP_VISIBILITY);
		bttnDerive.setSelection((propertyValue & DISP_DERIVE) == DISP_DERIVE);
		bttnName.setSelection((propertyValue & DISP_NAME) == DISP_NAME);
		bttnType.setSelection((propertyValue & DISP_TYPE) == DISP_TYPE);
		bttnUndefined_Type.setSelection((propertyValue & DISP_UNDEFINED_TYPE) == DISP_UNDEFINED_TYPE);
		bttnMultiplicity.setSelection((propertyValue & DISP_MULTIPLICITY) == DISP_MULTIPLICITY);
		bttnDefault_Multiplicity.setSelection((propertyValue & DISP_DEFAULT_MULTIPLICITY) == DISP_DEFAULT_MULTIPLICITY);
		bttnDefaultValue.setSelection((propertyValue & DISP_DEFAULTVALUE) == DISP_DEFAULTVALUE);
		bttnModifiers.setSelection((propertyValue & DISP_MODIFIERS) == DISP_MODIFIERS);

	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		super.storePreferences();
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(propertyValue != store.getInt(labelDisplayPreferenceKey)) {
			store.setValue(labelDisplayPreferenceKey, propertyValue);
		}
	}

	/**
	 * Listeners for the check buttons that select the display.
	 */
	private class AppearenceSelectionListener implements SelectionListener {

		/** The constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 */
		public AppearenceSelectionListener(int style) {
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
			propertyValue = propertyValue ^ style;
			// refresh buttons to show current values
			refreshButtons();
		}
	}
}
