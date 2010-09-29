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
package org.eclipse.papyrus.diagram.composite.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class DependencyPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public DependencyPreferencePage() {
		super();
		setPreferenceKey(CompositeStructureDiagramEditPart.MODEL_ID + "_Dependency");
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
