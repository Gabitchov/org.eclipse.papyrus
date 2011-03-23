/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.component.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

// TODO: Auto-generated Javadoc
/**
 * Preference page for CommentAnnotatedElement notation element.
 * Currently not generated.
 */
public class CommentAnnotatedElementPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * Instantiates a new comment annotated element preference page.
	 *
	 * @generated
	 */
	public CommentAnnotatedElementPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_CommentAnnotatedElement");
	}

	/**
	 * Gets the bundle id.
	 *
	 * @return the bundle id
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * Inits the defaults.
	 *
	 * @param store the store
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

}
