/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// TODO: Auto-generated Javadoc
/**
 * The Class DimensionGroup that display fields for the the dimension of a node (width, height)
 */
public class DimensionGroup extends AbstractGroup {

	/** The Constant HEIGHT_INTFIELDEDITOR_LABEL. */
	private static final String HEIGHT_INTFIELDEDITOR_LABEL = "height";

	/** The Constant WIDTH_INTFIELDEDITOR_LABEL. */
	private static final String WIDTH_INTFIELDEDITOR_LABEL = "width";

	/** The width fied editor. */
	protected IntegerFieldEditor widthFiedEditor;

	/** The height fied editor. */
	protected IntegerFieldEditor heightFiedEditor;

	/**
	 * Instantiates a new dimension group.
	 * 
	 * @param parent
	 *        the parent
	 * @param key
	 *        the key
	 * @param dialogPage
	 *        the dialog page
	 */
	public DimensionGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	public void createContent(Composite parent) {
		Group decorationGroup = new Group(parent, 4);
		decorationGroup.setLayout(new GridLayout());
		decorationGroup.setText(Messages.DimensionGroupName);

		widthFiedEditor = new IntegerFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.WIDTH), WIDTH_INTFIELDEDITOR_LABEL, decorationGroup);
		widthFiedEditor.setPage(dialogPage);

		addFieldEditor(widthFiedEditor);

		heightFiedEditor = new IntegerFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.HEIGHT), HEIGHT_INTFIELDEDITOR_LABEL, decorationGroup);
		heightFiedEditor.setPage(dialogPage);

		addFieldEditor(heightFiedEditor);

	}
}
