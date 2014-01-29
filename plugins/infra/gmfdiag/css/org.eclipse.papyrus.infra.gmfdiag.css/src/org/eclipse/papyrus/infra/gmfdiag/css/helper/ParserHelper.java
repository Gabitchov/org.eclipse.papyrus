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
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import java.io.IOException;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;

/**
 * A Helper for parsing CSS property values.
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class ParserHelper {

	/**
	 * Parses a list of CSS Values, and returns them as an Array of Strings
	 * Used for multivalued CSS values (Space-separated)
	 * 
	 * @param engine
	 *        The engine used to parse the values
	 * @param value
	 *        The raw CSSValue to parse
	 * @return
	 *         An Array containing each parsed value
	 */
	public static String[] parseValues(CSSEngine engine, CSSValue cssValue) {
		if(cssValue instanceof CSSValueList) {
			CSSValueList list = (CSSValueList)cssValue;
			return toArray(list);
		}

		return new String[]{ cssValue.getCssText() };
	}

	/**
	 * Parses a list of CSS Values, and returns them as an Array of Strings
	 * Used for multivalued CSS values (Space-separated)
	 * 
	 * @param engine
	 *        The engine used to parse the values
	 * @param value
	 *        The raw value to parse
	 * @return
	 *         An Array containing each parsed value
	 * @deprecated Does not properly support quoted strings (e.g. firstValue "second value")
	 */
	@Deprecated
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

	/**
	 * Converts a CSSValueList to an Array of Strings
	 * 
	 * @param valueList
	 *        The CSSValueList to convert
	 * @return
	 *         An Array of Strings containing the CSSValues, in their raw form
	 *         (CSS Text form)
	 */
	public static String[] toArray(CSSValueList valueList) {
		String[] result = new String[valueList.getLength()];
		for(int i = 0; i < result.length; i++) {
			result[i] = valueList.item(i).getCssText();
		}
		return result;
	}
}
