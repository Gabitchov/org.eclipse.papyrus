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
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ColorGroupForLinkComposite extends AbstractGroupComposite {

	protected ColorFieldEditor fontColorEditor;

	protected ColorFieldEditor lineColorEditor;

	protected Group toolbar;

	/**
	 * creation of a colorGroup Composite
	 * 
	 * @param parent
	 *            the parent composite
	 * @param title
	 *            the title
	 */

	public ColorGroupForLinkComposite(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
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
	 * @return the group that contains editors
	 */
	protected Group getToolbar() {
		return toolbar;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Composite getEncapsulatedCompo(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		compo.setLayout(new GridLayout());
		return compo;
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 */
	protected void createContent(Composite parent) {
		toolbar = new Group(parent, SWT.SHADOW_NONE);
		toolbar.setText(Messages.AbstractPapyrusElementPreferencePage_Colors);
		toolbar.setLayout(new GridLayout(3, false));

		Composite fontColorEditorCompo = getEncapsulatedCompo(toolbar);
		fontColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_FONT),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FONT_COLOR), fontColorEditorCompo);
		fontColorEditor.setPage(dialogPage);

		Composite lineColorEditorCompo = getEncapsulatedCompo(toolbar);
		lineColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_LINE),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_LINE_COLOR), lineColorEditorCompo);

		lineColorEditor.setPage(dialogPage);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		fontColorEditor.setPreferenceStore(preferenceStore);
		lineColorEditor.setPreferenceStore(preferenceStore);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void load() {
		fontColorEditor.load();
		lineColorEditor.load();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void storePreferences() {
		fontColorEditor.store();
		lineColorEditor.store();
	}

	@Override
	public void loadDefault() {
		fontColorEditor.loadDefault();
		lineColorEditor.loadDefault();

	}
}
