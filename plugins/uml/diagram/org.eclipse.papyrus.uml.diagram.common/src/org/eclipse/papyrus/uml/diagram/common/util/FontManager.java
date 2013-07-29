/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * 
 * 
 * @author Patrick Tessier
 * @since 21 sept. 06
 * 
 *        this class is a singletion to manage font in the papyrus Application.
 *        It is forbidden to create a new font without use this class.
 */
public class FontManager extends FontRegistry {

	/**
	 * this class create a font from a fontdata.
	 * 
	 * @param fontData
	 * 
	 * @return the associated font
	 */
	public Font get(FontData fontData[]) {

		String symbolicName = "";
		for(int i = 0; i < fontData.length; i++) {
			symbolicName = symbolicName + fontData[i];
		}
		Font font = super.get(symbolicName);
		if(font.equals(this.defaultFont())) {
			super.put(symbolicName, fontData);
			font = super.get(symbolicName);
		}
		return font;
	}

}
