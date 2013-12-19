/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomLifelinePreferencePage extends LifelinePreferencePage {

	public static final String LABEL_DISPLAY_PREFERENCE = PackageEditPart.MODEL_ID + "_Lifeline.label.display";

	public static final int SHOW_REPRESENT_NAME = 1 << 1;

	public static final int SHOW_REPRESENT_TYPE = 1 << 2;

	public static final int SHOW_UNDEFINED_TYPE = 1 << 3;

	public static final int SHOW_LIFELINE_NAME = 1 << 4;

	public static final int DEFAULT_LABEL_DISPLAY = SHOW_REPRESENT_NAME | SHOW_REPRESENT_TYPE;

	/**
	 * @Override
	 */
	public static void initDefaults(IPreferenceStore store) {
		String key = PackageEditPart.MODEL_ID + "_Lifeline";
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.WIDTH), 100);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.HEIGHT), 250);
		store.setDefault(LABEL_DISPLAY_PREFERENCE, DEFAULT_LABEL_DISPLAY);
	}

	/** buttons to select the display kind for the label of the */
	protected Button showRepName, showRepType, showUndefined, showName;

	/** current operation display style */
	private int displayValue = getPreferenceStore().getInt(LABEL_DISPLAY_PREFERENCE);

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
			refreshButtons();
		}
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
		group.setLayout(new GridLayout(1, true));
		showRepName = createCheckButton(group, "Show represent name", SHOW_REPRESENT_NAME);
		showRepType = createCheckButton(group, "Show represent type", SHOW_REPRESENT_TYPE);
		showUndefined = createCheckButton(group, "Always show undefined type", SHOW_UNDEFINED_TYPE);
		showName = createCheckButton(group, "Always show lifeline name", SHOW_LIFELINE_NAME);
	}

	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		// adds the label preferences checkboxes
		createLabelPreferencesButtons(parent);
		refreshButtons();
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		displayValue = getPreferenceStore().getInt(LABEL_DISPLAY_PREFERENCE);
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

	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}

	protected void refreshButtons() {
		showRepName.setSelection(isCheck(displayValue, SHOW_REPRESENT_NAME));
		showRepType.setSelection(isCheck(displayValue, SHOW_REPRESENT_TYPE));
		showUndefined.setSelection(isCheck(displayValue, SHOW_UNDEFINED_TYPE));
		showName.setSelection(isCheck(displayValue, SHOW_LIFELINE_NAME));
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
}
