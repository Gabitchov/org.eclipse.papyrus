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
package org.eclipse.papyrus.uml.diagram.component.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusElementPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
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

// TODO: Auto-generated Javadoc
/**
 * Specific {@link Property} preference page.
 */
public class PropertyPreferencePage extends AbstractPapyrusElementPreferencePage {

	/** Preference page identifier. */
	public static final String ID = "org.eclipse.papyrus.uml.diagram.composite.custom.preferences.PropertyPreferencePage"; //$NON-NLS-1$

	/**
	 * Listeners for the check buttons that select the display of the {@link Property}.
	 *
	 * @see AppearenceSelectionEvent
	 */
	private class AppearenceSelectionListener implements SelectionListener {

		/** the constant which refers the element to display or not. */
		final private int style;

		/**
		 * Default Constructor.
		 *
		 * @param style the style
		 */
		public AppearenceSelectionListener(int style) {
			this.style = style;
		}

		/**
		 * Widget default selected.
		 *
		 * @param e the e
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {

		}

		/**
		 * Widget selected.
		 *
		 * @param e the e
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// add or remove the flag to the display property value (invert the current value)
			propertyValue = propertyValue ^ style;

			// refresh buttons at the end
			refreshButtons();
		}
	}

	/**
	 * Initialize preferences.
	 *
	 * @param store the store
	 */
	public static void initDefaults(IPreferenceStore store) {

		String elementName = "Property";
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(177, 207, 229));

		// Set the default for the gradient
		store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.GRADIENT_POLICY), false);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255, 255, 255), new org.eclipse.swt.graphics.RGB(177, 207, 229), 0, 0);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

		// custom code
		store.setDefault(IPapyrusPropertyPreferencesConstant.LABEL_DISPLAY_PREFERENCE, ICustomAppearence.DEFAULT_UML_PROPERTY);

	}

	/** buttons to select the display kind for the label of the {@link Property}. */
	protected Button displVisibility, displDerive, displName, displType, displMutliplicity, displDfltValue, displModifiers;

	/** current property display style. */
	private int propertyValue = getPreferenceStore().getInt(IPapyrusPropertyPreferencesConstant.LABEL_DISPLAY_PREFERENCE);

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
	 * Creates the group and check boxes to choose the kind of display.
	 *
	 * @param parent the parent composite that holds the group
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

		displDerive = createCheckButton(group, "Derived", ICustomAppearence.DISP_DERIVE);
		data = new FormData();
		data.left = new FormAttachment(displVisibility, 85);
		data.top = new FormAttachment(0, 0);
		displDerive.setLayoutData(data);

		displName = createCheckButton(group, "Name", ICustomAppearence.DISP_NAME);
		data = new FormData();
		data.left = new FormAttachment(displDerive, 85);
		data.top = new FormAttachment(0, 0);
		displName.setLayoutData(data);

		displType = createCheckButton(group, "Type", ICustomAppearence.DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(displName, 85);
		data.top = new FormAttachment(0, 0);
		displType.setLayoutData(data);

		displMutliplicity = createCheckButton(group, "Multiplicity", ICustomAppearence.DISP_MULTIPLICITY);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(displVisibility, ITabbedPropertyConstants.HSPACE);
		displMutliplicity.setLayoutData(data);

		displDfltValue = createCheckButton(group, "Default Value", ICustomAppearence.DISP_DFLT_VALUE);
		data = new FormData();
		data.left = new FormAttachment(displVisibility, 85);
		data.top = new FormAttachment(displVisibility, ITabbedPropertyConstants.HSPACE);
		displDfltValue.setLayoutData(data);

		displModifiers = createCheckButton(group, "Modifiers", ICustomAppearence.DISP_MOFIFIERS);
		data = new FormData();
		data.left = new FormAttachment(displDerive, 85);
		data.top = new FormAttachment(displVisibility, ITabbedPropertyConstants.HSPACE);
		displModifiers.setLayoutData(data);
	}

	/**
	 * Creates the page contents.
	 *
	 * @param parent the parent
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
	 * Gets the bundle id.
	 *
	 * @return the bundle id
	 * {@inheritDoc}
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * Load the default preferences of the fields contained in this page.
	 */
	protected void loadDefaultPreferences() {
		propertyValue = getPreferenceStore().getInt(IPapyrusPropertyPreferencesConstant.LABEL_DISPLAY_PREFERENCE);
		refreshButtons();
	}

	/**
	 * Perform defaults.
	 *
	 * {@inheritDoc}
	 */
	@Override
	protected void performDefaults() {
		loadDefaultPreferences();
		super.performDefaults();
	}

	/**
	 * Perform ok.
	 *
	 * @return true, if successful
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

		displVisibility.setSelection((propertyValue & ICustomAppearence.DISP_VISIBILITY) == ICustomAppearence.DISP_VISIBILITY);
		displDerive.setSelection((propertyValue & ICustomAppearence.DISP_DERIVE) == ICustomAppearence.DISP_DERIVE);
		displName.setSelection((propertyValue & ICustomAppearence.DISP_NAME) == ICustomAppearence.DISP_NAME);
		displType.setSelection((propertyValue & ICustomAppearence.DISP_TYPE) == ICustomAppearence.DISP_TYPE);
		displMutliplicity.setSelection((propertyValue & ICustomAppearence.DISP_MULTIPLICITY) == ICustomAppearence.DISP_MULTIPLICITY);
		displDfltValue.setSelection((propertyValue & ICustomAppearence.DISP_DFLT_VALUE) == ICustomAppearence.DISP_DFLT_VALUE);
		displModifiers.setSelection((propertyValue & ICustomAppearence.DISP_MOFIFIERS) == ICustomAppearence.DISP_MOFIFIERS);
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	@Override
	protected void storePreferences() {
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(propertyValue != store.getInt(IPapyrusPropertyPreferencesConstant.LABEL_DISPLAY_PREFERENCE)) {
			store.setValue(IPapyrusPropertyPreferencesConstant.LABEL_DISPLAY_PREFERENCE, propertyValue);
		}
	}
}
