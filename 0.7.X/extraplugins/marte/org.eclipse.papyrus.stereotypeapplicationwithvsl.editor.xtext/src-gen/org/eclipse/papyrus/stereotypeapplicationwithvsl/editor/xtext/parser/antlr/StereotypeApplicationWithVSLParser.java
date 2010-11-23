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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.services.StereotypeApplicationWithVSLGrammarAccess;

public class StereotypeApplicationWithVSLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private StereotypeApplicationWithVSLGrammarAccess grammarAccess;
	
	@Override
	protected IParseResult parse(String ruleName, CharStream in) {
		TokenSource tokenSource = createLexer(in);
		XtextTokenStream tokenStream = createTokenStream(tokenSource);
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLParser parser = createParser(tokenStream);
		parser.setTokenTypeMap(getTokenDefProvider().getTokenDefMap());
		parser.setSyntaxErrorProvider(getSyntaxErrorProvider());
		parser.setUnorderedGroupHelper(getUnorderedGroupHelper().get());
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	protected org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLParser(stream, getElementFactory(), getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "StereotypeApplicationsRule";
	}
	
	public StereotypeApplicationWithVSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(StereotypeApplicationWithVSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
