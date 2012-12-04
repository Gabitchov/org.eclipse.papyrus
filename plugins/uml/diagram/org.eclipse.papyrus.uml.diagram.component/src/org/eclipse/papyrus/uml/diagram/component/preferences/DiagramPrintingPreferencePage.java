/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class DiagramPrintingPreferencePage.
 * 
 * @generated
 */
public class DiagramPrintingPreferencePage extends PrintingPreferencePage {

	/**
	 * Instantiates a new diagram printing preference page.
	 * 
	 * @generated
	 */
	public DiagramPrintingPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
	}
}
