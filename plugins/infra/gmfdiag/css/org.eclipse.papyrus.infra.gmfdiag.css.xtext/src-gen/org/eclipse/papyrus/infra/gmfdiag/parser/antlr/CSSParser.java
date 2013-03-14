/*****************************************************************************
 * Copyright (c) 2012-2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.papyrus.infra.gmfdiag.services.CSSGrammarAccess;

public class CSSParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private CSSGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_ML_COMMENT");
	}
	
	@Override
	protected org.eclipse.papyrus.infra.gmfdiag.parser.antlr.internal.InternalCSSParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.infra.gmfdiag.parser.antlr.internal.InternalCSSParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Stylesheet";
	}
	
	public CSSGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CSSGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
