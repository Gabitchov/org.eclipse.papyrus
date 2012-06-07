/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.activity.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class ExceptionHandlerPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ExceptionHandlerPreferencePage() {
		super();
		setPreferenceKey(ActivityDiagramEditPart.MODEL_ID + "_ExceptionHandler");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
	}
}
