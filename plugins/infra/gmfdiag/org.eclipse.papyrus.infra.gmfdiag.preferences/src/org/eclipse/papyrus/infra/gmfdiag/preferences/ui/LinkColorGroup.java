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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr 
 *  Thibault Landre (Atos Origin) 
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class LinkColorGroup contains editor to edit preference of link color
 */
public class LinkColorGroup extends AbstractGroup {

	/** The font color editor. */
	protected ColorFieldEditor fontColorEditor;

	/** The line color editor. */
	protected ColorFieldEditor lineColorEditor;

	/** The toolbar. */
	protected Group toolbar;

	/**
	 * creation of a colorGroup Composite.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param dialogPage
	 *        to set the page in field editor
	 * @param title
	 *        the title
	 */

	public LinkColorGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	/**
	 * Gets the toolbar.
	 * 
	 * @return the group that contains editors
	 */
	protected Group getToolbar() {
		return toolbar;
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	protected void createContent(Composite parent) {
		toolbar = new Group(parent, SWT.SHADOW_NONE);
		toolbar.setText(Messages.AbstractPapyrusElementPreferencePage_Colors);
		toolbar.setLayout(new GridLayout(3, false));

		Composite fontColorEditorCompo = getEncapsulatedCompo(toolbar);
		fontColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.COLOR_FONT), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FONT_COLOR), fontColorEditorCompo);
		fontColorEditor.setPage(dialogPage);

		addFieldEditor(fontColorEditor);

		Composite lineColorEditorCompo = getEncapsulatedCompo(toolbar);
		lineColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.COLOR_LINE), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_LINE_COLOR), lineColorEditorCompo);

		lineColorEditor.setPage(dialogPage);

		addFieldEditor(lineColorEditor);
	}

}
