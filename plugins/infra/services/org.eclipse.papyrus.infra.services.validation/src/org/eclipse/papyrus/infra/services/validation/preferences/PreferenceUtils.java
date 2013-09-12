/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions.MarkChildren;
import org.eclipse.papyrus.infra.services.validation.Activator;

/**
 * Two small functions that return the values of preference choices
 */
public class PreferenceUtils {

	/**
	 * @return the value of the  auto-open-validation-view preference choice
	 */
	public static boolean getAutoShowValidation() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		return store.getBoolean(PreferenceConstants.AUTO_SHOW_VALIDATION_VIEW);
	}

	/**
	 * @return the value of the hierarchical-marker preference choice
	 */
	public static MarkChildren getHierarchicalMarkers() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String choice = store.getString(PreferenceConstants.HIERARCHICAL_MARKERS);
		if(choice.equals("NO")) { //$NON-NLS-1$
			return MarkChildren.NO;
		}
		else if(choice.equals("DIRECT")) { //$NON-NLS-1$
			return MarkChildren.DIRECT;
		}
		else {
			return MarkChildren.ALL;
		}
	}

}
