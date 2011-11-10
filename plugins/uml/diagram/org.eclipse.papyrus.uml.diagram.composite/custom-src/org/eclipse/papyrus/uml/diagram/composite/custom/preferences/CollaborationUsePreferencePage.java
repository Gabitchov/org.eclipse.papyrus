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
package org.eclipse.papyrus.uml.diagram.composite.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusElementPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
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

/**
 * Specific {@link CollaborationUse} preference page for label management.
 */
public class CollaborationUsePreferencePage extends AbstractPapyrusElementPreferencePage {

	/** Preference page identifier */
	public static final String ID = "org.eclipse.papyrus.uml.diagram.composite.custom.preferences.CollaborationUsePreferencePage"; //$NON-NLS-1$

	/**
	 * Listeners for the check buttons that select the display of the {@link CollaborationUse}
	 */
	private class AppearenceSelectionListener implements SelectionListener {

		/** the constant which refers the element to display or not */
		final private int style;

		/**
		 * Default Constructor.
		 * 
		 * @param style
		 *        of label display
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

			// refresh buttons at the end
			refreshButtons();
		}
	}

	/**
	 * Initialize default preference values
	 */
	public static void initDefaults(IPreferenceStore store) {

		String elementName = "CollaborationUse";
		PreferenceConverter.setDefault(store, PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(177, 207, 229));

		// Set the default for the gradient
		store.setDefault(PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.GRADIENT_POLICY), false);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255, 255, 255), new org.eclipse.swt.graphics.RGB(177, 207, 229), 0, 0);
		store.setDefault(PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

		// custom code
		store.setDefault(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE, ICustomAppearence.DEFAULT_UML_PROPERTY);

	}

	/** buttons to select the display kind for the label of the {@link CollaborationUse} */
	protected Button displVisibility, displName, displType;

	/** current property display style */
	private int propertyValue = getPreferenceStore().getInt(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE);

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

		displType = createCheckButton(group, "Type", ICustomAppearence.DISP_TYPE);
		data = new FormData();
		data.left = new FormAttachment(displName, 85);
		data.top = new FormAttachment(0, 0);
		displType.setLayoutData(data);
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

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	protected void loadDefaultPreferences() {
		propertyValue = getPreferenceStore().getInt(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE);
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

		displVisibility.setSelection((propertyValue & ICustomAppearence.DISP_VISIBILITY) == ICustomAppearence.DISP_VISIBILITY);
		displName.setSelection((propertyValue & ICustomAppearence.DISP_NAME) == ICustomAppearence.DISP_NAME);
		displType.setSelection((propertyValue & ICustomAppearence.DISP_TYPE) == ICustomAppearence.DISP_TYPE);
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	protected void storePreferences() {
		IPreferenceStore store = getPreferenceStore();
		// checks the stored value and the actual one, so does not refresh diagram if it is not
		// needed
		if(propertyValue != store.getInt(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE)) {
			store.setValue(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE, propertyValue);
		}
	}
}
