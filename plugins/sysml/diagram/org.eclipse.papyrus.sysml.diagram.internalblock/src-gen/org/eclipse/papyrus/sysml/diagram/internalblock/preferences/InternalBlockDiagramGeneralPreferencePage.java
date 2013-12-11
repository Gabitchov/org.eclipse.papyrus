/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;

public class InternalBlockDiagramGeneralPreferencePage extends DiagramPreferencePage {

	public InternalBlockDiagramGeneralPreferencePage() {
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
		setPreferenceKey(ElementTypes.DIAGRAM_ID);
	}
}
