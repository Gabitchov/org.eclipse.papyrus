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

package org.eclipse.papyrus.state.editor.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class UmlStateGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class StateRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StateRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final UnorderedGroup cUnorderedGroup_1 = (UnorderedGroup)cGroup.eContents().get(1);
		private final Assignment cEntryAssignment_1_0 = (Assignment)cUnorderedGroup_1.eContents().get(0);
		private final RuleCall cEntryEntryRuleParserRuleCall_1_0_0 = (RuleCall)cEntryAssignment_1_0.eContents().get(0);
		private final Assignment cDoAssignment_1_1 = (Assignment)cUnorderedGroup_1.eContents().get(1);
		private final RuleCall cDoDoRuleParserRuleCall_1_1_0 = (RuleCall)cDoAssignment_1_1.eContents().get(0);
		private final Assignment cExitAssignment_1_2 = (Assignment)cUnorderedGroup_1.eContents().get(2);
		private final RuleCall cExitExitRuleParserRuleCall_1_2_0 = (RuleCall)cExitAssignment_1_2.eContents().get(0);
		
		//StateRule:
		//	name=ID (entry=EntryRule? & do=DoRule? & exit=ExitRule?);
		public ParserRule getRule() { return rule; }

		//name=ID (entry=EntryRule? & do=DoRule? & exit=ExitRule?)
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//entry=EntryRule? & do=DoRule? & exit=ExitRule?
		public UnorderedGroup getUnorderedGroup_1() { return cUnorderedGroup_1; }

		//entry=EntryRule?
		public Assignment getEntryAssignment_1_0() { return cEntryAssignment_1_0; }

		//EntryRule
		public RuleCall getEntryEntryRuleParserRuleCall_1_0_0() { return cEntryEntryRuleParserRuleCall_1_0_0; }

		//do=DoRule?
		public Assignment getDoAssignment_1_1() { return cDoAssignment_1_1; }

		//DoRule
		public RuleCall getDoDoRuleParserRuleCall_1_1_0() { return cDoDoRuleParserRuleCall_1_1_0; }

		//exit=ExitRule?
		public Assignment getExitAssignment_1_2() { return cExitAssignment_1_2; }

		//ExitRule
		public RuleCall getExitExitRuleParserRuleCall_1_2_0() { return cExitExitRuleParserRuleCall_1_2_0; }
	}

	public class EntryRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EntryRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEntryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindBehaviorKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Assignment cBehaviorNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBehaviorNameIDTerminalRuleCall_2_0 = (RuleCall)cBehaviorNameAssignment_2.eContents().get(0);
		
		//EntryRule:
		//	"entry" kind=BehaviorKind behaviorName=ID;
		public ParserRule getRule() { return rule; }

		//"entry" kind=BehaviorKind behaviorName=ID
		public Group getGroup() { return cGroup; }

		//"entry"
		public Keyword getEntryKeyword_0() { return cEntryKeyword_0; }

		//kind=BehaviorKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }

		//BehaviorKind
		public RuleCall getKindBehaviorKindEnumRuleCall_1_0() { return cKindBehaviorKindEnumRuleCall_1_0; }

		//behaviorName=ID
		public Assignment getBehaviorNameAssignment_2() { return cBehaviorNameAssignment_2; }

		//ID
		public RuleCall getBehaviorNameIDTerminalRuleCall_2_0() { return cBehaviorNameIDTerminalRuleCall_2_0; }
	}

	public class DoRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DoRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDoKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindBehaviorKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Assignment cBehaviorNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBehaviorNameIDTerminalRuleCall_2_0 = (RuleCall)cBehaviorNameAssignment_2.eContents().get(0);
		
		//DoRule:
		//	"do" kind=BehaviorKind behaviorName=ID;
		public ParserRule getRule() { return rule; }

		//"do" kind=BehaviorKind behaviorName=ID
		public Group getGroup() { return cGroup; }

		//"do"
		public Keyword getDoKeyword_0() { return cDoKeyword_0; }

		//kind=BehaviorKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }

		//BehaviorKind
		public RuleCall getKindBehaviorKindEnumRuleCall_1_0() { return cKindBehaviorKindEnumRuleCall_1_0; }

		//behaviorName=ID
		public Assignment getBehaviorNameAssignment_2() { return cBehaviorNameAssignment_2; }

		//ID
		public RuleCall getBehaviorNameIDTerminalRuleCall_2_0() { return cBehaviorNameIDTerminalRuleCall_2_0; }
	}

	public class ExitRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExitRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExitKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindBehaviorKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Assignment cBehaviorNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBehaviorNameIDTerminalRuleCall_2_0 = (RuleCall)cBehaviorNameAssignment_2.eContents().get(0);
		
		//ExitRule:
		//	"exit" kind=BehaviorKind behaviorName=ID;
		public ParserRule getRule() { return rule; }

		//"exit" kind=BehaviorKind behaviorName=ID
		public Group getGroup() { return cGroup; }

		//"exit"
		public Keyword getExitKeyword_0() { return cExitKeyword_0; }

		//kind=BehaviorKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }

		//BehaviorKind
		public RuleCall getKindBehaviorKindEnumRuleCall_1_0() { return cKindBehaviorKindEnumRuleCall_1_0; }

		//behaviorName=ID
		public Assignment getBehaviorNameAssignment_2() { return cBehaviorNameAssignment_2; }

		//ID
		public RuleCall getBehaviorNameIDTerminalRuleCall_2_0() { return cBehaviorNameIDTerminalRuleCall_2_0; }
	}
	
	
	public class BehaviorKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "BehaviorKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cACTIVITYEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cACTIVITYActivityKeyword_0_0 = (Keyword)cACTIVITYEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cSTATE_MACHINEEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cSTATE_MACHINEStateMachineKeyword_1_0 = (Keyword)cSTATE_MACHINEEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cOPAQUE_BEHAVIOREnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cOPAQUE_BEHAVIOROpaqueBehaviorKeyword_2_0 = (Keyword)cOPAQUE_BEHAVIOREnumLiteralDeclaration_2.eContents().get(0);
		
		//enum BehaviorKind:
		//	ACTIVITY="Activity" | STATE_MACHINE="StateMachine" | OPAQUE_BEHAVIOR="OpaqueBehavior";
		public EnumRule getRule() { return rule; }

		//ACTIVITY="Activity" | STATE_MACHINE="StateMachine" | OPAQUE_BEHAVIOR="OpaqueBehavior"
		public Alternatives getAlternatives() { return cAlternatives; }

		//ACTIVITY="Activity"
		public EnumLiteralDeclaration getACTIVITYEnumLiteralDeclaration_0() { return cACTIVITYEnumLiteralDeclaration_0; }

		//"Activity"
		public Keyword getACTIVITYActivityKeyword_0_0() { return cACTIVITYActivityKeyword_0_0; }

		//STATE_MACHINE="StateMachine"
		public EnumLiteralDeclaration getSTATE_MACHINEEnumLiteralDeclaration_1() { return cSTATE_MACHINEEnumLiteralDeclaration_1; }

		//"StateMachine"
		public Keyword getSTATE_MACHINEStateMachineKeyword_1_0() { return cSTATE_MACHINEStateMachineKeyword_1_0; }

		//OPAQUE_BEHAVIOR="OpaqueBehavior"
		public EnumLiteralDeclaration getOPAQUE_BEHAVIOREnumLiteralDeclaration_2() { return cOPAQUE_BEHAVIOREnumLiteralDeclaration_2; }

		//"OpaqueBehavior"
		public Keyword getOPAQUE_BEHAVIOROpaqueBehaviorKeyword_2_0() { return cOPAQUE_BEHAVIOROpaqueBehaviorKeyword_2_0; }
	}
	
	private StateRuleElements pStateRule;
	private EntryRuleElements pEntryRule;
	private DoRuleElements pDoRule;
	private ExitRuleElements pExitRule;
	private BehaviorKindElements unknownRuleBehaviorKind;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public UmlStateGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//StateRule:
	//	name=ID (entry=EntryRule? & do=DoRule? & exit=ExitRule?);
	public StateRuleElements getStateRuleAccess() {
		return (pStateRule != null) ? pStateRule : (pStateRule = new StateRuleElements());
	}
	
	public ParserRule getStateRuleRule() {
		return getStateRuleAccess().getRule();
	}

	//EntryRule:
	//	"entry" kind=BehaviorKind behaviorName=ID;
	public EntryRuleElements getEntryRuleAccess() {
		return (pEntryRule != null) ? pEntryRule : (pEntryRule = new EntryRuleElements());
	}
	
	public ParserRule getEntryRuleRule() {
		return getEntryRuleAccess().getRule();
	}

	//DoRule:
	//	"do" kind=BehaviorKind behaviorName=ID;
	public DoRuleElements getDoRuleAccess() {
		return (pDoRule != null) ? pDoRule : (pDoRule = new DoRuleElements());
	}
	
	public ParserRule getDoRuleRule() {
		return getDoRuleAccess().getRule();
	}

	//ExitRule:
	//	"exit" kind=BehaviorKind behaviorName=ID;
	public ExitRuleElements getExitRuleAccess() {
		return (pExitRule != null) ? pExitRule : (pExitRule = new ExitRuleElements());
	}
	
	public ParserRule getExitRuleRule() {
		return getExitRuleAccess().getRule();
	}

	//enum BehaviorKind:
	//	ACTIVITY="Activity" | STATE_MACHINE="StateMachine" | OPAQUE_BEHAVIOR="OpaqueBehavior";
	public BehaviorKindElements getBehaviorKindAccess() {
		return (unknownRuleBehaviorKind != null) ? unknownRuleBehaviorKind : (unknownRuleBehaviorKind = new BehaviorKindElements());
	}
	
	public EnumRule getBehaviorKindRule() {
		return getBehaviorKindAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" | "n" |
	//	"f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
