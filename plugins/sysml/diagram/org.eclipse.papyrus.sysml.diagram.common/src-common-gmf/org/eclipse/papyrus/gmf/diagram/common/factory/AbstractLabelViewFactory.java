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
package org.eclipse.papyrus.gmf.diagram.common.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.DecorationNodeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ThemeInitializerManager;

/**
 * Default view Factory for Papyrus custom labels.
 */
public abstract class AbstractLabelViewFactory extends DecorationNodeViewFactory {

	@Override
	protected void initializeFromPreferences(View view) {
		//Do not call initializeFromPreferences when the preference initializer is disabled (Typical use case: CSS are installed)
		if(ThemeInitializerManager.instance.usePreferenceInitializer(view)) {
			super.initializeFromPreferences(view);
		}
	}
}
