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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.diagram.common.preferences.LabelPreferenceHelper;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class OperationPreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID; //$NON-NLS-1$

	/** Constructor */
	public OperationPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		//		store.setDefault(LabelPreferenceHelper.getPreferenceConstant(prefKey, ILabelPreferenceConstants.LABEL_DISPLAY_PREFERENCE), DISP_NAME | DISP_TYPE | DISP_PARAM_DIRECTION | DISP_PARAM_NAME | DISP_PARAM_TYPE);
		// End of user code
	}

	/** buttons to select the display mask of the label */
	protected Button bttnVisibility, bttnName, bttnType, bttnModifiers, bttnParam_Direction, bttnParam_Name, bttnParam_Type, bttnParam_Multiplicity, bttnParam_DefaultValue, bttnParam_Modifiers;

	public static String prefLabelKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID; //$NON-NLS-1$

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
		//		Group group = new Group(parent, SWT.SHADOW_NONE);
		//		group.setText("Label Display");
		//		group.setLayout(new FormLayout());
		//
		//		FormData data;
		//
		//		bttnVisibility = createCheckButton(group, "Visibility", DISP_VISIBILITY);
		//		data = new FormData();
		//		data.left = new FormAttachment(0, 0);
		//		data.top = new FormAttachment(0, 0);
		//		bttnVisibility.setLayoutData(data);
		//
		//		bttnName = createCheckButton(group, "Name", DISP_NAME);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnVisibility, 85);
		//		data.top = new FormAttachment(0, 0);
		//		bttnName.setLayoutData(data);
		//
		//		bttnType = createCheckButton(group, "Type", DISP_TYPE);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnName, 85);
		//		data.top = new FormAttachment(0, 0);
		//		bttnType.setLayoutData(data);
		//
		//		bttnModifiers = createCheckButton(group, "Modifiers", DISP_MODIFIERS);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnType, 85);
		//		data.top = new FormAttachment(0, 0);
		//		bttnModifiers.setLayoutData(data);
		//
		//		bttnParam_Direction = createCheckButton(group, "Param_Direction", DISP_PARAM_DIRECTION);
		//		data = new FormData();
		//		data.left = new FormAttachment(0, 0);
		//		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_Direction.setLayoutData(data);
		//
		//		bttnParam_Name = createCheckButton(group, "Param_Name", DISP_PARAM_NAME);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnVisibility, 85);
		//		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_Name.setLayoutData(data);
		//
		//		bttnParam_Type = createCheckButton(group, "Param_Type", DISP_PARAM_TYPE);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnName, 85);
		//		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_Type.setLayoutData(data);
		//
		//		bttnParam_Multiplicity = createCheckButton(group, "Param_Multiplicity", DISP_PARAM_MULTIPLICITY);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnType, 85);
		//		data.top = new FormAttachment(bttnVisibility, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_Multiplicity.setLayoutData(data);
		//
		//		bttnParam_DefaultValue = createCheckButton(group, "Param_DefaultValue", DISP_PARAM_DEFAULTVALUE);
		//		data = new FormData();
		//		data.left = new FormAttachment(0, 0);
		//		data.top = new FormAttachment(bttnParam_Direction, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_DefaultValue.setLayoutData(data);
		//
		//		bttnParam_Modifiers = createCheckButton(group, "Param_Modifiers", DISP_PARAM_MODIFIERS);
		//		data = new FormData();
		//		data.left = new FormAttachment(bttnVisibility, 85);
		//		data.top = new FormAttachment(bttnParam_Direction, ITabbedPropertyConstants.HSPACE);
		//		bttnParam_Modifiers.setLayoutData(data);

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

		//		bttnVisibility.setSelection((propertyValue & DISP_VISIBILITY) == DISP_VISIBILITY);
		//		bttnName.setSelection((propertyValue & DISP_NAME) == DISP_NAME);
		//		bttnType.setSelection((propertyValue & DISP_TYPE) == DISP_TYPE);
		//		bttnModifiers.setSelection((propertyValue & DISP_MODIFIERS) == DISP_MODIFIERS);
		//		bttnParam_Direction.setSelection((propertyValue & DISP_PARAM_DIRECTION) == DISP_PARAM_DIRECTION);
		//		bttnParam_Name.setSelection((propertyValue & DISP_PARAM_NAME) == DISP_PARAM_NAME);
		//		bttnParam_Type.setSelection((propertyValue & DISP_PARAM_TYPE) == DISP_PARAM_TYPE);
		//		bttnParam_Multiplicity.setSelection((propertyValue & DISP_PARAM_MULTIPLICITY) == DISP_PARAM_MULTIPLICITY);
		//		bttnParam_DefaultValue.setSelection((propertyValue & DISP_PARAM_DEFAULTVALUE) == DISP_PARAM_DEFAULTVALUE);
		//		bttnParam_Modifiers.setSelection((propertyValue & DISP_PARAM_MODIFIERS) == DISP_PARAM_MODIFIERS);

	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	@Override
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
