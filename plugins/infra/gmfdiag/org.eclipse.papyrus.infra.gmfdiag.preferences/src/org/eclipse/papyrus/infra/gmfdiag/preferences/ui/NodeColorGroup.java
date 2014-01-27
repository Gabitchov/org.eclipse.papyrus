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
import org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class NodeColorGroup contains field editor to manage color of a node
 */
public class NodeColorGroup extends LinkColorGroup {

	/** The font color editor. */
	protected ColorFieldEditor fontColorEditor;

	/** The line color editor. */
	protected ColorFieldEditor lineColorEditor;

	/** The fill color editor. */
	protected ColorFieldEditor fillColorEditor;

	/**
	 * create a composite to display the group color for a node.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param dialogPage
	 *        to set the page in field editor
	 * @param title
	 *        the title
	 */


	public NodeColorGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
	}

	/**
	 * create the content.
	 * 
	 * @param parent
	 *        : the parent composite
	 */
	protected void createContent(Composite parent) {
		super.createContent(parent);

		Composite fillColorEditorCompo = getEncapsulatedCompo(getToolbar());
		fillColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.COLOR_FILL), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		fillColorEditor.setPage(dialogPage);

		addFieldEditor(fillColorEditor);
	}

}
