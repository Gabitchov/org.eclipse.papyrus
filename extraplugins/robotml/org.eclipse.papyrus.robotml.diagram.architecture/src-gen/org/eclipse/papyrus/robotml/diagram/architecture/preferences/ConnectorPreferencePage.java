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

package org.eclipse.papyrus.robotml.diagram.architecture.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;

public class ConnectorPreferencePage extends ArchitectureDiagramLinkPreferencePage {

	public static String prefKey = ArchitectureDiagramEditPart.DIAGRAM_ID + "_Connector";

	public ConnectorPreferencePage() {
		super();
		setPreferenceKey(ArchitectureDiagramEditPart.DIAGRAM_ID + "_Connector"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {

	}
}
