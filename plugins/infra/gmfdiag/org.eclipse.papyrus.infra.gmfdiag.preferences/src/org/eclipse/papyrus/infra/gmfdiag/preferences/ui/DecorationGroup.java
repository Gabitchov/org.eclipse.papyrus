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
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class DecorationGroup that display field for shadow, element icon, and qualified name
 */
public class DecorationGroup extends AbstractGroup {

	/** The Constant SHADOW_BOOLEANFIELDEDITOR_LABEL. */
	protected static final String SHADOW_BOOLEANFIELDEDITOR_LABEL = "Shadow";

	/** The Constant ELEMENTICON_BOOLEANFIELDEDITOR_LABEL. */
	private static final String ELEMENTICON_BOOLEANFIELDEDITOR_LABEL = "Element icon";

	/** The Constant QUALIFIEDNAME_BOOLEANFIELDEDITOR_LABEL. */
	private static final String QUALIFIEDNAME_BOOLEANFIELDEDITOR_LABEL = "Qualified name";

	/** The shadow fied editor. */
	protected BooleanFieldEditor shadowFiedEditor;

	/** The element icon. */
	protected BooleanFieldEditor elementIcon;

	/** The qualifiedname. */
	protected BooleanFieldEditor qualifiedname;

	/**
	 * Instantiates a new decoration group.
	 * 
	 * @param parent
	 *        the parent
	 * @param key
	 *        the key
	 * @param dialogPage
	 *        the dialog page
	 */
	public DecorationGroup(Composite parent, String key, DialogPage dialogPage) {
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
		Group decorationGroup = new Group(parent, 2);
		decorationGroup.setLayout(new GridLayout());
		decorationGroup.setText(Messages.DecorationGroup_Name);

		shadowFiedEditor = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.SHADOW), SHADOW_BOOLEANFIELDEDITOR_LABEL, decorationGroup);
		shadowFiedEditor.setPage(dialogPage);

		addFieldEditor(shadowFiedEditor);

		elementIcon = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.ELEMENTICON), ELEMENTICON_BOOLEANFIELDEDITOR_LABEL, decorationGroup);
		elementIcon.setPage(dialogPage);
		addFieldEditor(elementIcon);

		qualifiedname = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.QUALIFIEDNAME), QUALIFIEDNAME_BOOLEANFIELDEDITOR_LABEL, decorationGroup);
		qualifiedname.setPage(dialogPage);
		addFieldEditor(qualifiedname);

	}
}
