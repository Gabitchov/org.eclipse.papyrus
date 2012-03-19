package org.eclipse.papyrus.infra.gmfdiag.ui.color;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;


public class CSSTokenScanner extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		return super.calculateId(tokenName, tokenType);
		//		if("RULE_ID".equals(tokenName)) {
		//			return DefaultHighlightingConfiguration.NUMBER_ID;
		//		}
		//		return DefaultHighlightingConfiguration.DEFAULT_ID; //Skip Lexical coloring
		//		if("RULE_STRING".equals(tokenName)) {
		//			return DefaultHighlightingConfiguration.DEFAULT_ID; //Skip parent coloring
		//		}
		//		return super.calculateId(tokenName, tokenType);
		//		return CSSHighlightingConfiguration.DEFAULT_ID;
	}
}
