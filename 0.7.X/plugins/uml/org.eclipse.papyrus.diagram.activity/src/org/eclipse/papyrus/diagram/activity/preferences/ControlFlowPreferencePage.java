/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.swt.widgets.Composite;

/**
 * @generated
 */
public class ControlFlowPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ControlFlowPreferencePage() {
		super();
		setPreferenceKey(ActivityDiagramEditPart.MODEL_ID + "_ControlFlow");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

	/**
	 * Create preference page content concerning object flows
	 * 
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 * @param parent
	 *        parent composite
	 * @generated NOT
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// label visibility
		ActivityEdgeLabelVisibilityGroup connectionGroupComposite = new ActivityEdgeLabelVisibilityGroup(parent, getTitle(), this);
		addAbstractGroup(connectionGroupComposite);
	}

}
