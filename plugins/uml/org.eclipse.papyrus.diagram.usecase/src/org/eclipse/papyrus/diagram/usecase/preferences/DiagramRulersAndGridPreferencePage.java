/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramRulersAndGridPreferencePage extends RulerGridPreferencePage {

	/**
	 * @generated
	 */
	public DiagramRulersAndGridPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
