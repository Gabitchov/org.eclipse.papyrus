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
package org.eclipse.papyrus.infra.gmfdiag.validation;

import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;
import org.eclipse.xtext.validation.Check;


public class CSSJavaValidator extends AbstractCSSJavaValidator {

	public static final String INVALID_HEX_COLOR = "InvalidHexColor";

	public static final String EMPTY_ELEMENT_NAME = "EmptyElementName";

	//////////////////////////
	//		EMF + XText		//
	//////////////////////////
	@Check
	public void checkHexColor(HexColor color) {
		if(!color.getValue().matches("[0-9A-Fa-f]{6}")) {
			error("Invalid color. The color must be a 6-digit Hexadecimal number", CssPackage.Literals.HEX_COLOR__VALUE);
		}
	}

	//////////////////////////
	//		EMF Only		//
	//////////////////////////
	@Check
	public void checkElementName(SimpleSelector selector) {
		if("".equals(selector.getElementName())) {
			error("The selector's name should either be null or non-empty", CssPackage.Literals.SIMPLE_SELECTOR__ELEMENT_NAME);
		}
	}

	@Check
	public void checkSimpleSelector(SimpleSelector selector) {
		if(!selector.eIsSet(CssPackage.Literals.SIMPLE_SELECTOR__ELEMENT_NAME)) {
			if(selector.getCondition().isEmpty()) {
				error("The SimpleSelector should have either a non-empty name or at least one condition", CssPackage.Literals.SIMPLE_SELECTOR__ELEMENT_NAME);
			}
		}
	}

	@Check
	public void checkAttribute(Attribute attribute) {
		if("".equals(attribute.getName())) {
			error("The attribute's name should not be empty", CssPackage.Literals.ATTRIBUTE__NAME);
		}
	}

}
