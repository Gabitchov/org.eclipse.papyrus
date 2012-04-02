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
package org.eclipse.papyrus.infra.gmfdiag.formatting;

import org.eclipse.papyrus.infra.gmfdiag.services.CSSGrammarAccess;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class CSSFormatter extends AbstractDeclarativeFormatter {


	@Override
	protected void configureFormatting(FormattingConfig c) {
		// It's usually a good idea to activate the following three statements.
		// They will add and preserve newlines around comments
		// c.setLinewrap(0, 1, 2).before(getGrammarAccess().getSL_COMMENTRule());
		//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getML_COMMENTRule());
		//		c.setLinewrap(0, 1, 1).after(getGrammarAccess().getML_COMMENTRule());

		//Semantic formatting (Prevent XText from adding invalid spaces)

		//		c.setWhitespaceRule(getGrammarAccess().getWSRule());
		//		c.setNoSpace().around(getGrammarAccess().getWSRule());
		c.setNoSpace().around(getGrammarAccess().getANY_OTHERRule());

		//Preserve the charset spaces
		c.setNoSpace().after(getGrammarAccess().getStylesheetAccess().getCharsetKeyword_0_0());
		c.setNoSpace().before(getGrammarAccess().getStylesheetAccess().getSemicolonKeyword_0_2());

		//No spaces before units
		c.setNoSpace().before(getGrammarAccess().getEM_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getFREQ_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getTIME_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getEX_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getPC_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getANGLE_UNITRule());
		c.setNoSpace().before(getGrammarAccess().getLEN_UNITRule());

		//No spaces between unary operator and number
		c.setNoSpace().after(getGrammarAccess().getUnaryOperatorRule());
		c.setNoSpace().before(getGrammarAccess().getNumberRule());

		//No spaces before simpleSelector condition
		c.setNoSpace().before(getGrammarAccess().getSelectorConditionRule());
		c.setNoSpace().around(getGrammarAccess().getPseudoAccess().getColonKeyword_0());
		c.setNoSpace().after(getGrammarAccess().getPseudoAccess().getPseudoAssignment_1_1_0());

		//Pretty printing

		//c.setWrappedLineIndentation(4);

		//Charset
		c.setLinewrap(2).after(getGrammarAccess().getStylesheetAccess().getSemicolonKeyword_0_2());


		//Declarations
		c.setNoSpace().after(getGrammarAccess().getDeclarationRule());
		c.setNoSpace().before(getGrammarAccess().getDeclarationAccess().getColonKeyword_2());
		c.setSpace(" ").after(getGrammarAccess().getDeclarationAccess().getColonKeyword_2());
		//		c.setNoSpace().around(getGrammarAccess().getTermRule());
		c.setNoLinewrap().before(getGrammarAccess().getRulesetAccess().getSemicolonKeyword_5_0());
		c.setNoSpace().before(getGrammarAccess().getRulesetAccess().getSemicolonKeyword_5_0());

		c.setIndentationIncrement().after(getGrammarAccess().getRulesetAccess().getLeftCurlyBracketKeyword_2());
		c.setLinewrap().after(getGrammarAccess().getRulesetAccess().getLeftCurlyBracketKeyword_2());


		//Attribute
		c.setNoSpace().after(getGrammarAccess().getAttributeAccess().getLeftSquareBracketKeyword_0());
		c.setNoSpace().before(getGrammarAccess().getAttributeAccess().getRightSquareBracketKeyword_5());
		c.setNoSpace().around(getGrammarAccess().getAttributeValueAccess().getOperatorAssignment_0());

		//Ruleset
		c.setIndentationDecrement().before(getGrammarAccess().getRulesetAccess().getRightCurlyBracketKeyword_6());
		c.setLinewrap().before(getGrammarAccess().getRulesetAccess().getRightCurlyBracketKeyword_6());
		//c.setLinewrap(2).after(getGrammarAccess().getContentRule());
		c.setLinewrap(2).after(getGrammarAccess().getRulesetAccess().getRightCurlyBracketKeyword_6());

		c.setLinewrap().after(getGrammarAccess().getRulesetAccess().getSemicolonKeyword_5_0());
	}

	@Override
	public CSSGrammarAccess getGrammarAccess() {
		return (CSSGrammarAccess)super.getGrammarAccess();
	}
}
