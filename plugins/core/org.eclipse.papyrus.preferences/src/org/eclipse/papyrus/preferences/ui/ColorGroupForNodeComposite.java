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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.ui;

import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.widgets.Composite;

public class ColorGroupForNodeComposite extends ColorGroupForLinkComposite {

	protected ColorFieldEditor fontColorEditor;

	protected ColorFieldEditor lineColorEditor;

	protected ColorFieldEditor fillColorEditor;

	/**
	 * create a composite to display the group color dor a node
	 * 
	 * @param parent
	 * @param title
	 */

	public ColorGroupForNodeComposite(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
	}

	/**
	 * create the content
	 * 
	 * @param parent
	 *            : the parent composite
	 */
	protected void createContent(Composite parent) {
		super.createContent(parent);

		Composite fillColorEditorCompo = getEncapsulatedCompo(getToolbar());
		fillColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_FILL),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		fillColorEditor.setPage(dialogPage);
	}

	/**
	 * @return the fontColorEditor
	 */
	protected ColorFieldEditor getFontColorEditor() {
		return fontColorEditor;
	}

	/**
	 * @return the lineColorEditor
	 */
	protected ColorFieldEditor getLineColorEditor() {
		return lineColorEditor;
	}

	/**
	 * @return the fillColorEditor
	 */
	protected ColorFieldEditor getFillColorEditor() {
		return fillColorEditor;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		fillColorEditor.setPreferenceStore(preferenceStore);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void load() {
		super.load();
		fillColorEditor.load();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void storePreferences() {
		super.storePreferences();
		fillColorEditor.store();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void loadDefault() {
		super.loadDefault();
		fillColorEditor.loadDefault();
	}
}
