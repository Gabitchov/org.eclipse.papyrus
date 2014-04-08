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
 *  Gabriel Pascual	(ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.swt.graphics.Image;


public class CSSThemeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object value) {
		Theme theme = getTheme(value);
		if(theme != null) {
			return theme.getLabel();
		}
		return super.getText(value);
	}

	@Override
	public Image getImage(Object value) {
		Theme theme = getTheme(value);
		if(theme != null) {
			Image icon = ThemeManager.instance.getThemeIcon(theme);
			return icon;
		}
		return super.getImage(value);
	}

	protected Theme getTheme(Object value) {
		if(value instanceof String) {
			String themeId = (String)value;
			Theme theme = ThemeManager.instance.getTheme(themeId);
			return theme;
		}
		return null;
	}
}
