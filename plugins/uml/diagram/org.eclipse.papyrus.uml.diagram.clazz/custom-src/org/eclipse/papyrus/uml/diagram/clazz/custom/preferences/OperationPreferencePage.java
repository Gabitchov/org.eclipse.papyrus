/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusElementPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
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
 * Specific {@link Operation} preference page
 */
public class OperationPreferencePage extends AbstractPapyrusElementPreferencePage {

	/**
	 * Listeners for the check buttons that select the display of the {@link Operation}
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
			operationValue = operationValue ^ style;

			// refresh buttons at the end
			refreshButtons();
		}
	}

	/**
	 * Initialize the preferences in the preference store.
	 * 
	 * @param store
	 *        the preference store to initialize
	 */
	public static void initDefaults(IPreferenceStore store) {
		String elementName = "Operation";
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(177, 207, 229));

		// Set the default for the gradient
		store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.GRADIENT_POLICY), false);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255, 255, 255), new org.eclipse.swt.graphics.RGB(177, 207, 229), 0, 0);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

		// default for Operation label display
		store.setDefault(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE, ICustomAppearence.DEFAULT_UML_OPERATION);
	}

	/** buttons to select the display kind for the label of the {@link Operation} */
	protected Button displVisibility, displName, displParamDirection, displParameterType, displModifiers;

	/** current operation display style */
	private int operationValue = getPreferenceStore().getInt(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE);

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

		displVisibility = createCheckButton(group, "Visibility", ICustomAppearence.DISP_VISIBILITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		displVisibility.setLayoutData(data);

		displName = createCheckButton(group, "Name", ICustomAppearence.DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(displVisibility, 85);
		data.top = new FormAttachment(0, 0);
		displName.setLayoutData(data);

		displParamDirection = createCheckButton(group, "Parameter Direction", ICustomAppearence.DISP_PARAMETER_DIRECTION);
		data = new FormData();
		data.left = new FormAttachment(displName, 85);
		data.top = new FormAttachment(0, 0);
		displParamDirection.setLayoutData(data);

		displModifiers = createCheckButton(group, "Modifiers", ICustomAppearence.DISP_MOFIFIERS);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(displVisibility, ITabbedPropertyConstants.HSPACE);
		displModifiers.setLayoutData(data);

		displParameterType = createCheckButton(group, "Parameter Type", ICustomAppearence.DISP_PARAMETER_TYPE);
		data = new FormData();
		data.left = new FormAttachment(displModifiers, 85);
		data.top = new FormAttachment(displVisibility, ITabbedPropertyConstants.HSPACE);
		displParameterType.setLayoutData(data);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// adds the label preferences checkboxes
		createLabelPreferencesButtons(parent);

		refreshButtons();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// protected String getFontColorPreferenceName() {
	// return IPapyrusOperationPreferencesConstant.OPERATION_PREF_FONT_COLOR;
	// }
	//
	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// protected String getFontPreferenceName() {
	// return IPapyrusOperationPreferencesConstant.OPERATION_PREF_FONT;
	// }
	//
	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// protected String getLineColorPreferenceName() {
	// return IPapyrusOperationPreferencesConstant.OPERATION_PREF_LINE_COLOR;
	// }

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		operationValue = getPreferenceStore().getInt(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE);
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
		// IPreferenceStore store = getPreferenceStore();
		// int displayValue =
		// store.getInt(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE);
		// if (proper == 0) {
		// displayValue = ICustomAppearence.DEFAULT_UML_OPERATION;
		// }

		displVisibility.setSelection((operationValue & ICustomAppearence.DISP_VISIBILITY) == ICustomAppearence.DISP_VISIBILITY);
		displName.setSelection((operationValue & ICustomAppearence.DISP_NAME) == ICustomAppearence.DISP_NAME);
		displParamDirection.setSelection((operationValue & ICustomAppearence.DISP_PARAMETER_DIRECTION) == ICustomAppearence.DISP_PARAMETER_DIRECTION);
		displParameterType.setSelection((operationValue & ICustomAppearence.DISP_PARAMETER_TYPE) == ICustomAppearence.DISP_PARAMETER_TYPE);
		displModifiers.setSelection((operationValue & ICustomAppearence.DISP_MOFIFIERS) == ICustomAppearence.DISP_MOFIFIERS);
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(operationValue != store.getInt(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE)) {
			store.setValue(IPapyrusOperationPreferencesConstant.OPERATION_LABEL_DISPLAY_PREFERENCE, operationValue);
		}
	}
}
