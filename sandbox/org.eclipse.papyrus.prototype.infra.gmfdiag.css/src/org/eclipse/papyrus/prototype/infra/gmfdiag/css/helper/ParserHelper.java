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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper;

import java.io.IOException;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.Activator;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;


public class ParserHelper {

	//TODO : Handle quote-protected values
	//parseValue("fo o" bar "foobar") = ["fo o","bar","foobar"]
	public static String[] parseValues(CSSEngine engine, String value) {
		CSSValue cssValue;
		try {
			cssValue = engine.parsePropertyValue(value);
		} catch (IOException ex) {
			Activator.log.error(ex);
			return new String[0];
		}

		if(cssValue instanceof CSSValueList) {
			CSSValueList list = (CSSValueList)cssValue;
			return toArray(list);
		}

		return new String[]{ cssValue.getCssText() };
	}

	public static String[] toArray(CSSValueList valueList) {
		String[] result = new String[valueList.getLength()];
		for(int i = 0; i < result.length; i++) {
			result[i] = valueList.item(i).getCssText();
		}
		return result;
	}
}
