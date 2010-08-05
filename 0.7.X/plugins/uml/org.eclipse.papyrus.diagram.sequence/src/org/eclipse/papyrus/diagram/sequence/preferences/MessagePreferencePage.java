/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.preferences;

import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class MessagePreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public MessagePreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_Message");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated NOT use rectilinear as default routing style
	 */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault("ELEMENT_PapyrusUMLSequenceDiagram_Message.routing.style", Routing.RECTILINEAR);
	}

}
