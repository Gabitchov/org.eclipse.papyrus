/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.modelelement;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.preferences.ThemePreferences;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSThemeLabelProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.PreferencesModelElement;


public class CSSPreferencesModelElement extends PreferencesModelElement {

	public CSSPreferencesModelElement(DataContextElement context) {
		super(context);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		if(ThemePreferences.CURRENT_THEME.equals(propertyPath)) {
			return new CSSThemeLabelProvider();
		}
		return super.getLabelProvider(propertyPath);
	}

}
