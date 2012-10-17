/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.papyrus.uml.textedit.operation.xtext.services.OperationGrammarAccess;

public class OperationParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private OperationGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.papyrus.uml.textedit.operation.xtext.parser.antlr.internal.InternalOperationParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.uml.textedit.operation.xtext.parser.antlr.internal.InternalOperationParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "OperationDefinitionOrStub";
	}
	
	public OperationGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(OperationGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
