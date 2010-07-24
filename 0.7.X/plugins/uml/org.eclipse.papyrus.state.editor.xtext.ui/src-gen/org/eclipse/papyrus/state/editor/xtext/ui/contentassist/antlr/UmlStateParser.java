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
package org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.papyrus.state.editor.xtext.services.UmlStateGrammarAccess;

public class UmlStateParser extends AbstractContentAssistParser {
	
	@Inject
	private UmlStateGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal.InternalUmlStateParser createParser() {
		org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal.InternalUmlStateParser result = new org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal.InternalUmlStateParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getBehaviorKindAccess().getAlternatives(), "rule__BehaviorKind__Alternatives");
					put(grammarAccess.getStateRuleAccess().getGroup(), "rule__StateRule__Group__0");
					put(grammarAccess.getEntryRuleAccess().getGroup(), "rule__EntryRule__Group__0");
					put(grammarAccess.getDoRuleAccess().getGroup(), "rule__DoRule__Group__0");
					put(grammarAccess.getExitRuleAccess().getGroup(), "rule__ExitRule__Group__0");
					put(grammarAccess.getStateRuleAccess().getNameAssignment_0(), "rule__StateRule__NameAssignment_0");
					put(grammarAccess.getStateRuleAccess().getEntryAssignment_1_0(), "rule__StateRule__EntryAssignment_1_0");
					put(grammarAccess.getStateRuleAccess().getDoAssignment_1_1(), "rule__StateRule__DoAssignment_1_1");
					put(grammarAccess.getStateRuleAccess().getExitAssignment_1_2(), "rule__StateRule__ExitAssignment_1_2");
					put(grammarAccess.getEntryRuleAccess().getKindAssignment_1(), "rule__EntryRule__KindAssignment_1");
					put(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2(), "rule__EntryRule__BehaviorNameAssignment_2");
					put(grammarAccess.getDoRuleAccess().getKindAssignment_1(), "rule__DoRule__KindAssignment_1");
					put(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2(), "rule__DoRule__BehaviorNameAssignment_2");
					put(grammarAccess.getExitRuleAccess().getKindAssignment_1(), "rule__ExitRule__KindAssignment_1");
					put(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2(), "rule__ExitRule__BehaviorNameAssignment_2");
					put(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), "rule__StateRule__UnorderedGroup_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal.InternalUmlStateParser typedParser = (org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal.InternalUmlStateParser) parser;
			typedParser.entryRuleStateRule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public UmlStateGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(UmlStateGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
