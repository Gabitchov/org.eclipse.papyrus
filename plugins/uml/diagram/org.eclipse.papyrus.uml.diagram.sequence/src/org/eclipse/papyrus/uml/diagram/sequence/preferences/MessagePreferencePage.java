/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @generated
 */
public class MessagePreferencePage extends AbstractPapyrusLinkPreferencePage {

	public static final String LABEL_DISPLAY_PREFERENCE = PackageEditPart.MODEL_ID + "_Message.label.display";

	public static final int DEFAULT_LABEL_DISPLAY = ICustomAppearence.DISP_NAME | ICustomAppearence.DISP_PARAMETER_NAME | ICustomAppearence.DISP_PARAMETER_TYPE | ICustomAppearence.DISP_RT_TYPE;

	/** current operation display style */
	private int displayValue = getPreferenceStore().getInt(LABEL_DISPLAY_PREFERENCE);

	/** buttons to select the display kind for the label of */
	private Button dispParamDir, dispParamMod, dispParamName, dispVis, dispParamType, dispReturnType, dispParamMul, dispParamDef, dispName, dispMod, dispParamVal;

	/**
	 * @generated
	 */
	public MessagePreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_Message");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	public static void initDefaults(IPreferenceStore store) {
		// default for label display
		store.setDefault(LABEL_DISPLAY_PREFERENCE, DEFAULT_LABEL_DISPLAY);
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
		group.setLayout(new GridLayout(2, true));
		dispParamDir = createCheckButton(group, "Parameters Direction", ICustomAppearence.DISP_PARAMETER_DIRECTION);
		dispParamMod = createCheckButton(group, "Parameters Modifiers", ICustomAppearence.DISP_PARAMETER_MODIFIERS);
		dispParamName = createCheckButton(group, "Parameters Name", ICustomAppearence.DISP_PARAMETER_NAME);
		dispVis = createCheckButton(group, "Visibility", ICustomAppearence.DISP_VISIBILITY);
		dispParamType = createCheckButton(group, "Parameters Type", ICustomAppearence.DISP_PARAMETER_TYPE);
		dispReturnType = createCheckButton(group, "Return Type", ICustomAppearence.DISP_RT_TYPE);
		dispParamMul = createCheckButton(group, "Parameters Multiplicity", ICustomAppearence.DISP_PARAMETER_MULTIPLICITY);
		dispParamDef = createCheckButton(group, "Parameters Default Value", ICustomAppearence.DISP_PARAMETER_DEFAULT);
		dispParamVal = createCheckButton(group, "Parameters Value", ICustomAppearence.DISP_DERIVE);
		dispName = createCheckButton(group, "Name", ICustomAppearence.DISP_NAME);
		dispMod = createCheckButton(group, "Modifiers", ICustomAppearence.DISP_MOFIFIERS);
	}

	protected void refreshButtons(SelectionEvent e) {
		dispParamDir.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_DIRECTION));
		dispParamMod.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_MODIFIERS));
		dispParamName.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_NAME));
		dispVis.setSelection(isCheck(displayValue, ICustomAppearence.DISP_VISIBILITY));
		dispParamType.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_TYPE));
		dispReturnType.setSelection(isCheck(displayValue, ICustomAppearence.DISP_RT_TYPE));
		dispParamMul.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_MULTIPLICITY));
		dispParamDef.setSelection(isCheck(displayValue, ICustomAppearence.DISP_PARAMETER_DEFAULT));
		dispParamVal.setSelection(isCheck(displayValue, ICustomAppearence.DISP_DERIVE));
		dispName.setSelection(isCheck(displayValue, ICustomAppearence.DISP_NAME));
		dispMod.setSelection(isCheck(displayValue, ICustomAppearence.DISP_MOFIFIERS));
		if(e != null && dispParamDef.getSelection() && dispParamVal.getSelection()) {
			// parameter default and value can only select one of them
			if(e.widget == dispParamDef) {
				dispParamVal.setSelection(false);
				displayValue = displayValue ^ ICustomAppearence.DISP_DERIVE;
			} else if(e.widget == dispParamVal) {
				dispParamDef.setSelection(false);
				displayValue = displayValue ^ ICustomAppearence.DISP_PARAMETER_DEFAULT;
			}
		}
	}

	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		// adds the label preferences checkboxes
		createLabelPreferencesButtons(parent);
		refreshButtons(null);
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	@Override
	protected void performDefaults() {
		displayValue = getPreferenceStore().getInt(LABEL_DISPLAY_PREFERENCE);
		refreshButtons(null);
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}

	private static boolean isCheck(int value, int mask) {
		return (value & mask) != 0;
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		super.storePreferences();
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(displayValue != store.getInt(LABEL_DISPLAY_PREFERENCE)) {
			store.setValue(LABEL_DISPLAY_PREFERENCE, displayValue);
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
	protected Button createCheckButton(Composite parent, String label, int mask) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(label);
		button.addSelectionListener(new AppearenceSelectionListener(mask));
		return button;
	}

	/**
	 * Listeners for the check buttons that select the display of the label
	 */
	private class AppearenceSelectionListener implements SelectionListener {

		/** the constant which refers the element to display or not */
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
			// add or remove the flag to the display Operation value (invert the current value)
			displayValue = displayValue ^ style;
			// refresh buttons at the end
			refreshButtons(e);
		}
	}
}
