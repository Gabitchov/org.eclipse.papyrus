/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;

import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;

public class BlockDefinitionDiagramElementPreferencePage extends AbstractPapyrusNodePreferencePage {

	/** Element preference key (supposed to be initialized by subclasses) */
	protected String key = ""; //$NON-NLS-1$

	public BlockDefinitionDiagramElementPreferencePage() {
		super();
		setPreferenceKey(key);
	}

	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}
}
