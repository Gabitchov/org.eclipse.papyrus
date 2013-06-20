/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.componentdef.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;

public class CommentPreferencePage extends ComponentdefDiagramNodePreferencePage {

	public static String prefKey = ComponentdefDiagramEditPart.DIAGRAM_ID + "_Comment";


	public CommentPreferencePage() {
		super();
		setPreferenceKey(ComponentdefDiagramEditPart.DIAGRAM_ID + "_Comment"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
	}

}
