/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;

/**
 * Preference management for Node elements (referenced by Class, Package)
 * 
 */
public class RequirementDiagramNodePreferencePage extends AbstractPapyrusNodePreferencePage {

	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}
}
