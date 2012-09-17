/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.parser.antlr;

import org.eclipse.papyrus.uml.textedit.property.xtext.services.UmlPropertyGrammarAccess;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

public class UmlPropertyParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private UmlPropertyGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.papyrus.uml.textedit.property.xtext.parser.antlr.internal.InternalUmlPropertyParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.uml.textedit.property.xtext.parser.antlr.internal.InternalUmlPropertyParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "PropertyRule";
	}
	
	public UmlPropertyGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(UmlPropertyGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
