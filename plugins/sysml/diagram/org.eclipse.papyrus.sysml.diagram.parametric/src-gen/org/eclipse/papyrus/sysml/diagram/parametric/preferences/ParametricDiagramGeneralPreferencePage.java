/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;

public class ParametricDiagramGeneralPreferencePage extends DiagramPreferencePage {

	public ParametricDiagramGeneralPreferencePage() {
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
	}
}
