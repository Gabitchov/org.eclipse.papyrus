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
package org.eclipse.papyrus.infra.gmfdiag.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class CSSGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class StylesheetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Stylesheet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cCharsetKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cCharsetAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cCharsetSTRINGTerminalRuleCall_0_1_0 = (RuleCall)cCharsetAssignment_0_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final RuleCall cCDOTerminalRuleCall_1_1 = (RuleCall)cAlternatives_1.eContents().get(1);
		private final RuleCall cCDCTerminalRuleCall_1_2 = (RuleCall)cAlternatives_1.eContents().get(2);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cImportsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cImportsImportParserRuleCall_2_0_0 = (RuleCall)cImportsAssignment_2_0.eContents().get(0);
		private final Alternatives cAlternatives_2_1 = (Alternatives)cGroup_2.eContents().get(1);
		private final Group cGroup_2_1_0 = (Group)cAlternatives_2_1.eContents().get(0);
		private final RuleCall cCDOTerminalRuleCall_2_1_0_0 = (RuleCall)cGroup_2_1_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2_1_0_1 = (RuleCall)cGroup_2_1_0.eContents().get(1);
		private final Group cGroup_2_1_1 = (Group)cAlternatives_2_1.eContents().get(1);
		private final RuleCall cCDCTerminalRuleCall_2_1_1_0 = (RuleCall)cGroup_2_1_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2_1_1_1 = (RuleCall)cGroup_2_1_1.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cContentsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cContentsContentParserRuleCall_3_0_0 = (RuleCall)cContentsAssignment_3_0.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Group cGroup_3_1_0 = (Group)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cCDOTerminalRuleCall_3_1_0_0 = (RuleCall)cGroup_3_1_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3_1_0_1 = (RuleCall)cGroup_3_1_0.eContents().get(1);
		private final Group cGroup_3_1_1 = (Group)cAlternatives_3_1.eContents().get(1);
		private final RuleCall cCDCTerminalRuleCall_3_1_1_0 = (RuleCall)cGroup_3_1_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3_1_1_1 = (RuleCall)cGroup_3_1_1.eContents().get(1);
		
		////Do not create a Stylesheet for WS* (This seems to cause a serialization problem when editing an EMF Model from an Empty file)
		//
		//
		////Do not ignore WS as @charset must be followed by exactly one Space.
		// Stylesheet:
		//
		//	("@charset " charset=STRING ";")? (WS | CDO | CDC)* (imports+=Import (CDO WS* | CDC WS*)*)* (contents+=Content (CDO
		//
		//	WS* | CDC WS*)*)*;
		public ParserRule getRule() { return rule; }

		//("@charset " charset=STRING ";")? (WS | CDO | CDC)* (imports+=Import (CDO WS* | CDC WS*)*)* (contents+=Content (CDO WS*
		//
		//| CDC WS*)*)*
		public Group getGroup() { return cGroup; }

		//("@charset " charset=STRING ";")?
		public Group getGroup_0() { return cGroup_0; }

		//"@charset "
		public Keyword getCharsetKeyword_0_0() { return cCharsetKeyword_0_0; }

		//charset=STRING
		public Assignment getCharsetAssignment_0_1() { return cCharsetAssignment_0_1; }

		//STRING
		public RuleCall getCharsetSTRINGTerminalRuleCall_0_1_0() { return cCharsetSTRINGTerminalRuleCall_0_1_0; }

		//";"
		public Keyword getSemicolonKeyword_0_2() { return cSemicolonKeyword_0_2; }

		//(WS | CDO | CDC)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//WS
		public RuleCall getWSTerminalRuleCall_1_0() { return cWSTerminalRuleCall_1_0; }

		//CDO
		public RuleCall getCDOTerminalRuleCall_1_1() { return cCDOTerminalRuleCall_1_1; }

		//CDC
		public RuleCall getCDCTerminalRuleCall_1_2() { return cCDCTerminalRuleCall_1_2; }

		//(imports+=Import (CDO WS* | CDC WS*)*)*
		public Group getGroup_2() { return cGroup_2; }

		//imports+=Import
		public Assignment getImportsAssignment_2_0() { return cImportsAssignment_2_0; }

		//Import
		public RuleCall getImportsImportParserRuleCall_2_0_0() { return cImportsImportParserRuleCall_2_0_0; }

		//(CDO WS* | CDC WS*)*
		public Alternatives getAlternatives_2_1() { return cAlternatives_2_1; }

		//CDO WS*
		public Group getGroup_2_1_0() { return cGroup_2_1_0; }

		//CDO
		public RuleCall getCDOTerminalRuleCall_2_1_0_0() { return cCDOTerminalRuleCall_2_1_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_0_1() { return cWSTerminalRuleCall_2_1_0_1; }

		//CDC WS*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }

		//CDC
		public RuleCall getCDCTerminalRuleCall_2_1_1_0() { return cCDCTerminalRuleCall_2_1_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2_1_1_1() { return cWSTerminalRuleCall_2_1_1_1; }

		//(contents+=Content (CDO WS* | CDC WS*)*)*
		public Group getGroup_3() { return cGroup_3; }

		//contents+=Content
		public Assignment getContentsAssignment_3_0() { return cContentsAssignment_3_0; }

		//Content
		public RuleCall getContentsContentParserRuleCall_3_0_0() { return cContentsContentParserRuleCall_3_0_0; }

		//(CDO WS* | CDC WS*)*
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//CDO WS*
		public Group getGroup_3_1_0() { return cGroup_3_1_0; }

		//CDO
		public RuleCall getCDOTerminalRuleCall_3_1_0_0() { return cCDOTerminalRuleCall_3_1_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3_1_0_1() { return cWSTerminalRuleCall_3_1_0_1; }

		//CDC WS*
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }

		//CDC
		public RuleCall getCDCTerminalRuleCall_3_1_1_0() { return cCDCTerminalRuleCall_3_1_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3_1_1_1() { return cWSTerminalRuleCall_3_1_1_1; }
	}

	public class ContentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Content");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRulesetParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMediaParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cPageParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Content:
		//
		//	Ruleset | Media | Page;
		public ParserRule getRule() { return rule; }

		//Ruleset | Media | Page
		public Alternatives getAlternatives() { return cAlternatives; }

		//Ruleset
		public RuleCall getRulesetParserRuleCall_0() { return cRulesetParserRuleCall_0; }

		//Media
		public RuleCall getMediaParserRuleCall_1() { return cMediaParserRuleCall_1; }

		//Page
		public RuleCall getPageParserRuleCall_2() { return cPageParserRuleCall_2; }
	}

	public class ImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1_0_0 = (RuleCall)cGroup_1_0.eContents().get(0);
		private final Assignment cStringAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cStringSTRINGTerminalRuleCall_1_0_1_0 = (RuleCall)cStringAssignment_1_0_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_1_1_0 = (RuleCall)cGroup_1_1.eContents().get(0);
		private final Assignment cUriAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cUriUriParserRuleCall_1_1_1_0 = (RuleCall)cUriAssignment_1_1_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cMediaAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cMediaIDTerminalRuleCall_3_0_0 = (RuleCall)cMediaAssignment_3_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3_2_1 = (RuleCall)cGroup_3_2.eContents().get(1);
		private final Assignment cMediaAssignment_3_2_2 = (Assignment)cGroup_3_2.eContents().get(2);
		private final RuleCall cMediaIDTerminalRuleCall_3_2_2_0 = (RuleCall)cMediaAssignment_3_2_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final RuleCall cWSTerminalRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		
		//Import:
		//
		//	"@import" (WS* string=STRING | WS uri=Uri) WS* (media+=ID WS* ("," WS* media+=ID)*)? ";" WS*;
		public ParserRule getRule() { return rule; }

		//"@import" (WS* string=STRING | WS uri=Uri) WS* (media+=ID WS* ("," WS* media+=ID)*)? ";" WS*
		public Group getGroup() { return cGroup; }

		//"@import"
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//WS* string=STRING | WS uri=Uri
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//WS* string=STRING
		public Group getGroup_1_0() { return cGroup_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_0_0() { return cWSTerminalRuleCall_1_0_0; }

		//string=STRING
		public Assignment getStringAssignment_1_0_1() { return cStringAssignment_1_0_1; }

		//STRING
		public RuleCall getStringSTRINGTerminalRuleCall_1_0_1_0() { return cStringSTRINGTerminalRuleCall_1_0_1_0; }

		//WS uri=Uri
		public Group getGroup_1_1() { return cGroup_1_1; }

		//WS
		public RuleCall getWSTerminalRuleCall_1_1_0() { return cWSTerminalRuleCall_1_1_0; }

		//uri=Uri
		public Assignment getUriAssignment_1_1_1() { return cUriAssignment_1_1_1; }

		//Uri
		public RuleCall getUriUriParserRuleCall_1_1_1_0() { return cUriUriParserRuleCall_1_1_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }

		//(media+=ID WS* ("," WS* media+=ID)*)?
		public Group getGroup_3() { return cGroup_3; }

		//media+=ID
		public Assignment getMediaAssignment_3_0() { return cMediaAssignment_3_0; }

		//ID
		public RuleCall getMediaIDTerminalRuleCall_3_0_0() { return cMediaIDTerminalRuleCall_3_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3_1() { return cWSTerminalRuleCall_3_1; }

		//("," WS* media+=ID)*
		public Group getGroup_3_2() { return cGroup_3_2; }

		//","
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3_2_1() { return cWSTerminalRuleCall_3_2_1; }

		//media+=ID
		public Assignment getMediaAssignment_3_2_2() { return cMediaAssignment_3_2_2; }

		//ID
		public RuleCall getMediaIDTerminalRuleCall_3_2_2_0() { return cMediaIDTerminalRuleCall_3_2_2_0; }

		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }

		//WS*
		public RuleCall getWSTerminalRuleCall_5() { return cWSTerminalRuleCall_5; }
	}

	public class MediaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Media");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMediaKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cMediaAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMediaIDTerminalRuleCall_2_0 = (RuleCall)cMediaAssignment_2.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Assignment cMediaAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final RuleCall cMediaIDTerminalRuleCall_4_2_0 = (RuleCall)cMediaAssignment_4_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final RuleCall cWSTerminalRuleCall_6 = (RuleCall)cGroup.eContents().get(6);
		private final Assignment cRulesAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cRulesRulesetParserRuleCall_7_0 = (RuleCall)cRulesAssignment_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final RuleCall cWSTerminalRuleCall_9 = (RuleCall)cGroup.eContents().get(9);
		
		//Media:
		//
		//	"@media" WS media+=ID WS* ("," WS* media+=ID)* "{" WS* rules+=Ruleset* "}" WS*;
		public ParserRule getRule() { return rule; }

		//"@media" WS media+=ID WS* ("," WS* media+=ID)* "{" WS* rules+=Ruleset* "}" WS*
		public Group getGroup() { return cGroup; }

		//"@media"
		public Keyword getMediaKeyword_0() { return cMediaKeyword_0; }

		//WS
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }

		//media+=ID
		public Assignment getMediaAssignment_2() { return cMediaAssignment_2; }

		//ID
		public RuleCall getMediaIDTerminalRuleCall_2_0() { return cMediaIDTerminalRuleCall_2_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }

		//("," WS* media+=ID)*
		public Group getGroup_4() { return cGroup_4; }

		//","
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_4_1() { return cWSTerminalRuleCall_4_1; }

		//media+=ID
		public Assignment getMediaAssignment_4_2() { return cMediaAssignment_4_2; }

		//ID
		public RuleCall getMediaIDTerminalRuleCall_4_2_0() { return cMediaIDTerminalRuleCall_4_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }

		//WS*
		public RuleCall getWSTerminalRuleCall_6() { return cWSTerminalRuleCall_6; }

		//rules+=Ruleset*
		public Assignment getRulesAssignment_7() { return cRulesAssignment_7; }

		//Ruleset
		public RuleCall getRulesRulesetParserRuleCall_7_0() { return cRulesRulesetParserRuleCall_7_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }

		//WS*
		public RuleCall getWSTerminalRuleCall_9() { return cWSTerminalRuleCall_9; }
	}

	public class PageElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Page");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPageAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPageKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cPseudoAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cPseudoPseudoPageParserRuleCall_3_0 = (RuleCall)cPseudoAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final RuleCall cWSTerminalRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		private final Assignment cDeclarationsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cDeclarationsDeclarationParserRuleCall_6_0 = (RuleCall)cDeclarationsAssignment_6.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cSemicolonKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_7_1 = (RuleCall)cGroup_7.eContents().get(1);
		private final Assignment cDeclarationsAssignment_7_2 = (Assignment)cGroup_7.eContents().get(2);
		private final RuleCall cDeclarationsDeclarationParserRuleCall_7_2_0 = (RuleCall)cDeclarationsAssignment_7_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final RuleCall cWSTerminalRuleCall_9 = (RuleCall)cGroup.eContents().get(9);
		
		//Page:
		//
		//	{Page} "@page" WS* pseudo=PseudoPage? "{" WS* declarations+=Declaration? (";" WS* declarations+=Declaration?)* "}"
		//
		//	WS*;
		public ParserRule getRule() { return rule; }

		//{Page} "@page" WS* pseudo=PseudoPage? "{" WS* declarations+=Declaration? (";" WS* declarations+=Declaration?)* "}" WS*
		public Group getGroup() { return cGroup; }

		//{Page}
		public Action getPageAction_0() { return cPageAction_0; }

		//"@page"
		public Keyword getPageKeyword_1() { return cPageKeyword_1; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }

		//pseudo=PseudoPage?
		public Assignment getPseudoAssignment_3() { return cPseudoAssignment_3; }

		//PseudoPage
		public RuleCall getPseudoPseudoPageParserRuleCall_3_0() { return cPseudoPseudoPageParserRuleCall_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//WS*
		public RuleCall getWSTerminalRuleCall_5() { return cWSTerminalRuleCall_5; }

		//declarations+=Declaration?
		public Assignment getDeclarationsAssignment_6() { return cDeclarationsAssignment_6; }

		//Declaration
		public RuleCall getDeclarationsDeclarationParserRuleCall_6_0() { return cDeclarationsDeclarationParserRuleCall_6_0; }

		//(";" WS* declarations+=Declaration?)*
		public Group getGroup_7() { return cGroup_7; }

		//";"
		public Keyword getSemicolonKeyword_7_0() { return cSemicolonKeyword_7_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_7_1() { return cWSTerminalRuleCall_7_1; }

		//declarations+=Declaration?
		public Assignment getDeclarationsAssignment_7_2() { return cDeclarationsAssignment_7_2; }

		//Declaration
		public RuleCall getDeclarationsDeclarationParserRuleCall_7_2_0() { return cDeclarationsDeclarationParserRuleCall_7_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }

		//WS*
		public RuleCall getWSTerminalRuleCall_9() { return cWSTerminalRuleCall_9; }
	}

	public class PseudoPageElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PseudoPage");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cColonKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIdAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIdIDTerminalRuleCall_1_0 = (RuleCall)cIdAssignment_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//PseudoPage:
		//
		//	":" id=ID WS*;
		public ParserRule getRule() { return rule; }

		//":" id=ID WS*
		public Group getGroup() { return cGroup; }

		//":"
		public Keyword getColonKeyword_0() { return cColonKeyword_0; }

		//id=ID
		public Assignment getIdAssignment_1() { return cIdAssignment_1; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_1_0() { return cIdIDTerminalRuleCall_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }
	}

	public class RulesetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Ruleset");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSelectorsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSelectorsSelectorParserRuleCall_0_0 = (RuleCall)cSelectorsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Assignment cSelectorsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cSelectorsSelectorParserRuleCall_1_2_0 = (RuleCall)cSelectorsAssignment_1_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Assignment cPropertiesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cPropertiesDeclarationParserRuleCall_4_0 = (RuleCall)cPropertiesAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cSemicolonKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_5_1 = (RuleCall)cGroup_5.eContents().get(1);
		private final Assignment cPropertiesAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cPropertiesDeclarationParserRuleCall_5_2_0 = (RuleCall)cPropertiesAssignment_5_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final RuleCall cWSTerminalRuleCall_7 = (RuleCall)cGroup.eContents().get(7);
		
		//Ruleset:
		//
		//	selectors+=Selector ("," WS* selectors+=Selector)* "{" WS* properties+=Declaration? (";" WS*
		//
		//	properties+=Declaration?)* "}" WS*;
		public ParserRule getRule() { return rule; }

		//selectors+=Selector ("," WS* selectors+=Selector)* "{" WS* properties+=Declaration? (";" WS* properties+=Declaration?)*
		//
		//"}" WS*
		public Group getGroup() { return cGroup; }

		//selectors+=Selector
		public Assignment getSelectorsAssignment_0() { return cSelectorsAssignment_0; }

		//Selector
		public RuleCall getSelectorsSelectorParserRuleCall_0_0() { return cSelectorsSelectorParserRuleCall_0_0; }

		//("," WS* selectors+=Selector)*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_1() { return cWSTerminalRuleCall_1_1; }

		//selectors+=Selector
		public Assignment getSelectorsAssignment_1_2() { return cSelectorsAssignment_1_2; }

		//Selector
		public RuleCall getSelectorsSelectorParserRuleCall_1_2_0() { return cSelectorsSelectorParserRuleCall_1_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }

		//properties+=Declaration?
		public Assignment getPropertiesAssignment_4() { return cPropertiesAssignment_4; }

		//Declaration
		public RuleCall getPropertiesDeclarationParserRuleCall_4_0() { return cPropertiesDeclarationParserRuleCall_4_0; }

		//(";" WS* properties+=Declaration?)*
		public Group getGroup_5() { return cGroup_5; }

		//";"
		public Keyword getSemicolonKeyword_5_0() { return cSemicolonKeyword_5_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_5_1() { return cWSTerminalRuleCall_5_1; }

		//properties+=Declaration?
		public Assignment getPropertiesAssignment_5_2() { return cPropertiesAssignment_5_2; }

		//Declaration
		public RuleCall getPropertiesDeclarationParserRuleCall_5_2_0() { return cPropertiesDeclarationParserRuleCall_5_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }

		//WS*
		public RuleCall getWSTerminalRuleCall_7() { return cWSTerminalRuleCall_7; }
	}

	public class SelectorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Selector");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cSimpleSelectorParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final RuleCall cCompositeSelectorParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Selector:
		//
		//	SimpleSelector WS* | CompositeSelector;
		public ParserRule getRule() { return rule; }

		//SimpleSelector WS* | CompositeSelector
		public Alternatives getAlternatives() { return cAlternatives; }

		//SimpleSelector WS*
		public Group getGroup_0() { return cGroup_0; }

		//SimpleSelector
		public RuleCall getSimpleSelectorParserRuleCall_0_0() { return cSimpleSelectorParserRuleCall_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_0_1() { return cWSTerminalRuleCall_0_1; }

		//CompositeSelector
		public RuleCall getCompositeSelectorParserRuleCall_1() { return cCompositeSelectorParserRuleCall_1; }
	}

	public class CompositeSelectorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeSelector");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLeftAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLeftSimpleSelectorParserRuleCall_0_0 = (RuleCall)cLeftAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_1_1_0 = (RuleCall)cGroup_1_1.eContents().get(0);
		private final Assignment cCombinatorAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cCombinatorCombinatorParserRuleCall_1_1_1_0 = (RuleCall)cCombinatorAssignment_1_1_1.eContents().get(0);
		private final Assignment cRightAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRightSelectorParserRuleCall_2_0 = (RuleCall)cRightAssignment_2.eContents().get(0);
		
		////left=SimpleSelector (combinator=Combinator right=Selector | WS+ (combinator=Combinator? right=Selector)?)?;
		//
		//
		//CompositeSelector:
		//
		//	left=SimpleSelector (WS+ | WS* combinator=Combinator) right=Selector;
		public ParserRule getRule() { return rule; }

		//left=SimpleSelector (WS+ | WS* combinator=Combinator) right=Selector
		public Group getGroup() { return cGroup; }

		//left=SimpleSelector
		public Assignment getLeftAssignment_0() { return cLeftAssignment_0; }

		//SimpleSelector
		public RuleCall getLeftSimpleSelectorParserRuleCall_0_0() { return cLeftSimpleSelectorParserRuleCall_0_0; }

		//WS+ | WS* combinator=Combinator
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//WS+
		public RuleCall getWSTerminalRuleCall_1_0() { return cWSTerminalRuleCall_1_0; }

		//WS* combinator=Combinator
		public Group getGroup_1_1() { return cGroup_1_1; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_1_0() { return cWSTerminalRuleCall_1_1_0; }

		//combinator=Combinator
		public Assignment getCombinatorAssignment_1_1_1() { return cCombinatorAssignment_1_1_1; }

		//Combinator
		public RuleCall getCombinatorCombinatorParserRuleCall_1_1_1_0() { return cCombinatorCombinatorParserRuleCall_1_1_1_0; }

		//right=Selector
		public Assignment getRightAssignment_2() { return cRightAssignment_2; }

		//Selector
		public RuleCall getRightSelectorParserRuleCall_2_0() { return cRightSelectorParserRuleCall_2_0; }
	}

	public class SimpleSelectorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleSelector");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cElementNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final Alternatives cElementNameAlternatives_0_0_0 = (Alternatives)cElementNameAssignment_0_0.eContents().get(0);
		private final RuleCall cElementNameIDTerminalRuleCall_0_0_0_0 = (RuleCall)cElementNameAlternatives_0_0_0.eContents().get(0);
		private final Keyword cElementNameAsteriskKeyword_0_0_0_1 = (Keyword)cElementNameAlternatives_0_0_0.eContents().get(1);
		private final Assignment cConditionAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cConditionSelectorConditionParserRuleCall_0_1_0 = (RuleCall)cConditionAssignment_0_1.eContents().get(0);
		private final Assignment cConditionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cConditionSelectorConditionParserRuleCall_1_0 = (RuleCall)cConditionAssignment_1.eContents().get(0);
		
		//SimpleSelector:
		//
		//	elementName=(ID | "*") condition+=SelectorCondition* | condition+=SelectorCondition+;
		public ParserRule getRule() { return rule; }

		//elementName=(ID | "*") condition+=SelectorCondition* | condition+=SelectorCondition+
		public Alternatives getAlternatives() { return cAlternatives; }

		//elementName=(ID | "*") condition+=SelectorCondition*
		public Group getGroup_0() { return cGroup_0; }

		//elementName=(ID | "*")
		public Assignment getElementNameAssignment_0_0() { return cElementNameAssignment_0_0; }

		//ID | "*"
		public Alternatives getElementNameAlternatives_0_0_0() { return cElementNameAlternatives_0_0_0; }

		//ID
		public RuleCall getElementNameIDTerminalRuleCall_0_0_0_0() { return cElementNameIDTerminalRuleCall_0_0_0_0; }

		//"*"
		public Keyword getElementNameAsteriskKeyword_0_0_0_1() { return cElementNameAsteriskKeyword_0_0_0_1; }

		//condition+=SelectorCondition*
		public Assignment getConditionAssignment_0_1() { return cConditionAssignment_0_1; }

		//SelectorCondition
		public RuleCall getConditionSelectorConditionParserRuleCall_0_1_0() { return cConditionSelectorConditionParserRuleCall_0_1_0; }

		//condition+=SelectorCondition+
		public Assignment getConditionAssignment_1() { return cConditionAssignment_1; }

		//SelectorCondition
		public RuleCall getConditionSelectorConditionParserRuleCall_1_0() { return cConditionSelectorConditionParserRuleCall_1_0; }
	}

	public class SelectorConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SelectorCondition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCSSIdParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cClassParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cAttributeParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPseudoParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//SelectorCondition:
		//
		//	CSSId | Class | Attribute | Pseudo;
		public ParserRule getRule() { return rule; }

		//CSSId | Class | Attribute | Pseudo
		public Alternatives getAlternatives() { return cAlternatives; }

		//CSSId
		public RuleCall getCSSIdParserRuleCall_0() { return cCSSIdParserRuleCall_0; }

		//Class
		public RuleCall getClassParserRuleCall_1() { return cClassParserRuleCall_1; }

		//Attribute
		public RuleCall getAttributeParserRuleCall_2() { return cAttributeParserRuleCall_2; }

		//Pseudo
		public RuleCall getPseudoParserRuleCall_3() { return cPseudoParserRuleCall_3; }
	}

	public class CombinatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Combinator");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKindAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKindKINDEnumRuleCall_0_0 = (RuleCall)cKindAssignment_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//Combinator:
		//
		//	kind=KIND WS*;
		public ParserRule getRule() { return rule; }

		//kind=KIND WS*
		public Group getGroup() { return cGroup; }

		//kind=KIND
		public Assignment getKindAssignment_0() { return cKindAssignment_0; }

		//KIND
		public RuleCall getKindKINDEnumRuleCall_0_0() { return cKindKINDEnumRuleCall_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }
	}

	public class DeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Declaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPropertyIDTerminalRuleCall_0_0 = (RuleCall)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Assignment cExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExpressionExpressionParserRuleCall_4_0 = (RuleCall)cExpressionAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cImportantAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cImportantT_IMPORTANTTerminalRuleCall_5_0_0 = (RuleCall)cImportantAssignment_5_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_5_1 = (RuleCall)cGroup_5.eContents().get(1);
		
		//Declaration:
		//
		//	property=ID WS* ":" WS* expression=Expression (important?=T_IMPORTANT WS*)?;
		public ParserRule getRule() { return rule; }

		//property=ID WS* ":" WS* expression=Expression (important?=T_IMPORTANT WS*)?
		public Group getGroup() { return cGroup; }

		//property=ID
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//ID
		public RuleCall getPropertyIDTerminalRuleCall_0_0() { return cPropertyIDTerminalRuleCall_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }

		//expression=Expression
		public Assignment getExpressionAssignment_4() { return cExpressionAssignment_4; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_4_0() { return cExpressionExpressionParserRuleCall_4_0; }

		//(important?=T_IMPORTANT WS*)?
		public Group getGroup_5() { return cGroup_5; }

		//important?=T_IMPORTANT
		public Assignment getImportantAssignment_5_0() { return cImportantAssignment_5_0; }

		//T_IMPORTANT
		public RuleCall getImportantT_IMPORTANTTerminalRuleCall_5_0_0() { return cImportantT_IMPORTANTTerminalRuleCall_5_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_5_1() { return cWSTerminalRuleCall_5_1; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTermsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTermsTermParserRuleCall_0_0 = (RuleCall)cTermsAssignment_0.eContents().get(0);
		private final Assignment cSubtermsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSubtermsSubtermParserRuleCall_1_0 = (RuleCall)cSubtermsAssignment_1.eContents().get(0);
		
		//Expression:
		//
		//	terms=Term subterms+=Subterm*;
		public ParserRule getRule() { return rule; }

		//terms=Term subterms+=Subterm*
		public Group getGroup() { return cGroup; }

		//terms=Term
		public Assignment getTermsAssignment_0() { return cTermsAssignment_0; }

		//Term
		public RuleCall getTermsTermParserRuleCall_0_0() { return cTermsTermParserRuleCall_0_0; }

		//subterms+=Subterm*
		public Assignment getSubtermsAssignment_1() { return cSubtermsAssignment_1; }

		//Subterm
		public RuleCall getSubtermsSubtermParserRuleCall_1_0() { return cSubtermsSubtermParserRuleCall_1_0; }
	}

	public class SubtermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Subterm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOperatorAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOperatorOperatorParserRuleCall_0_0 = (RuleCall)cOperatorAssignment_0.eContents().get(0);
		private final Assignment cTermAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTermTermParserRuleCall_1_0 = (RuleCall)cTermAssignment_1.eContents().get(0);
		
		//Subterm:
		//
		//	operator=Operator? term=Term;
		public ParserRule getRule() { return rule; }

		//operator=Operator? term=Term
		public Group getGroup() { return cGroup; }

		//operator=Operator?
		public Assignment getOperatorAssignment_0() { return cOperatorAssignment_0; }

		//Operator
		public RuleCall getOperatorOperatorParserRuleCall_0_0() { return cOperatorOperatorParserRuleCall_0_0; }

		//term=Term
		public Assignment getTermAssignment_1() { return cTermAssignment_1; }

		//Term
		public RuleCall getTermTermParserRuleCall_1_0() { return cTermTermParserRuleCall_1_0; }
	}

	public class TermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Term");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cNumberParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cPercentageParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final RuleCall cLengthParserRuleCall_0_2 = (RuleCall)cAlternatives_0.eContents().get(2);
		private final RuleCall cEmsParserRuleCall_0_3 = (RuleCall)cAlternatives_0.eContents().get(3);
		private final RuleCall cExsParserRuleCall_0_4 = (RuleCall)cAlternatives_0.eContents().get(4);
		private final RuleCall cAngleParserRuleCall_0_5 = (RuleCall)cAlternatives_0.eContents().get(5);
		private final RuleCall cTimeParserRuleCall_0_6 = (RuleCall)cAlternatives_0.eContents().get(6);
		private final RuleCall cFrequencyParserRuleCall_0_7 = (RuleCall)cAlternatives_0.eContents().get(7);
		private final RuleCall cNameParserRuleCall_0_8 = (RuleCall)cAlternatives_0.eContents().get(8);
		private final RuleCall cStringValueParserRuleCall_0_9 = (RuleCall)cAlternatives_0.eContents().get(9);
		private final RuleCall cUriParserRuleCall_0_10 = (RuleCall)cAlternatives_0.eContents().get(10);
		private final RuleCall cHexColorParserRuleCall_0_11 = (RuleCall)cAlternatives_0.eContents().get(11);
		private final RuleCall cFunctionParserRuleCall_0_12 = (RuleCall)cAlternatives_0.eContents().get(12);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//Term:
		//
		//	(Number | Percentage | Length | Ems | Exs | Angle | Time | Frequency | Name | StringValue | Uri | HexColor |
		//
		//	Function) WS*;
		public ParserRule getRule() { return rule; }

		//(Number | Percentage | Length | Ems | Exs | Angle | Time | Frequency | Name | StringValue | Uri | HexColor | Function)
		//
		//WS*
		public Group getGroup() { return cGroup; }

		//Number | Percentage | Length | Ems | Exs | Angle | Time | Frequency | Name | StringValue | Uri | HexColor | Function
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//Number
		public RuleCall getNumberParserRuleCall_0_0() { return cNumberParserRuleCall_0_0; }

		//Percentage
		public RuleCall getPercentageParserRuleCall_0_1() { return cPercentageParserRuleCall_0_1; }

		//Length
		public RuleCall getLengthParserRuleCall_0_2() { return cLengthParserRuleCall_0_2; }

		//Ems
		public RuleCall getEmsParserRuleCall_0_3() { return cEmsParserRuleCall_0_3; }

		//Exs
		public RuleCall getExsParserRuleCall_0_4() { return cExsParserRuleCall_0_4; }

		//Angle
		public RuleCall getAngleParserRuleCall_0_5() { return cAngleParserRuleCall_0_5; }

		//Time
		public RuleCall getTimeParserRuleCall_0_6() { return cTimeParserRuleCall_0_6; }

		//Frequency
		public RuleCall getFrequencyParserRuleCall_0_7() { return cFrequencyParserRuleCall_0_7; }

		//Name
		public RuleCall getNameParserRuleCall_0_8() { return cNameParserRuleCall_0_8; }

		//StringValue
		public RuleCall getStringValueParserRuleCall_0_9() { return cStringValueParserRuleCall_0_9; }

		//Uri
		public RuleCall getUriParserRuleCall_0_10() { return cUriParserRuleCall_0_10; }

		//HexColor
		public RuleCall getHexColorParserRuleCall_0_11() { return cHexColorParserRuleCall_0_11; }

		//Function
		public RuleCall getFunctionParserRuleCall_0_12() { return cFunctionParserRuleCall_0_12; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Function");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cArgsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cArgsExpressionParserRuleCall_3_0 = (RuleCall)cArgsAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Function:
		//
		//	name=ID "(" WS* args=Expression ")";
		public ParserRule getRule() { return rule; }

		//name=ID "(" WS* args=Expression ")"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//WS*
		public RuleCall getWSTerminalRuleCall_2() { return cWSTerminalRuleCall_2; }

		//args=Expression
		public Assignment getArgsAssignment_3() { return cArgsAssignment_3; }

		//Expression
		public RuleCall getArgsExpressionParserRuleCall_3_0() { return cArgsExpressionParserRuleCall_3_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class NameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Name");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueIDTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//Name:
		//
		//	value=ID;
		public ParserRule getRule() { return rule; }

		//value=ID
		public Assignment getValueAssignment() { return cValueAssignment; }

		//ID
		public RuleCall getValueIDTerminalRuleCall_0() { return cValueIDTerminalRuleCall_0; }
	}

	public class NumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Number");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		////Terms  
		// Number:
		//
		//	op=UnaryOperator? value=T_NUM;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }
	}

	public class PercentageElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Percentage");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitPC_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Percentage:
		//
		//	op=UnaryOperator? value=T_NUM unit=PC_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=PC_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=PC_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//PC_UNIT
		public RuleCall getUnitPC_UNITTerminalRuleCall_2_0() { return cUnitPC_UNITTerminalRuleCall_2_0; }
	}

	public class LengthElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Length");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitLEN_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Length:
		//
		//	op=UnaryOperator? value=T_NUM unit=LEN_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=LEN_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=LEN_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//LEN_UNIT
		public RuleCall getUnitLEN_UNITTerminalRuleCall_2_0() { return cUnitLEN_UNITTerminalRuleCall_2_0; }
	}

	public class EmsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Ems");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitEM_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Ems:
		//
		//	op=UnaryOperator? value=T_NUM unit=EM_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=EM_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=EM_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//EM_UNIT
		public RuleCall getUnitEM_UNITTerminalRuleCall_2_0() { return cUnitEM_UNITTerminalRuleCall_2_0; }
	}

	public class ExsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Exs");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitEX_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Exs:
		//
		//	op=UnaryOperator? value=T_NUM unit=EX_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=EX_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=EX_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//EX_UNIT
		public RuleCall getUnitEX_UNITTerminalRuleCall_2_0() { return cUnitEX_UNITTerminalRuleCall_2_0; }
	}

	public class AngleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Angle");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitANGLE_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Angle:
		//
		//	op=UnaryOperator? value=T_NUM unit=ANGLE_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=ANGLE_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=ANGLE_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//ANGLE_UNIT
		public RuleCall getUnitANGLE_UNITTerminalRuleCall_2_0() { return cUnitANGLE_UNITTerminalRuleCall_2_0; }
	}

	public class TimeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Time");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitTIME_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Time:
		//
		//	op=UnaryOperator? value=T_NUM unit=TIME_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=TIME_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=TIME_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//TIME_UNIT
		public RuleCall getUnitTIME_UNITTerminalRuleCall_2_0() { return cUnitTIME_UNITTerminalRuleCall_2_0; }
	}

	public class FrequencyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Frequency");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpUnaryOperatorParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueT_NUMTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cUnitFREQ_UNITTerminalRuleCall_2_0 = (RuleCall)cUnitAssignment_2.eContents().get(0);
		
		//Frequency:
		//
		//	op=UnaryOperator? value=T_NUM unit=FREQ_UNIT;
		public ParserRule getRule() { return rule; }

		//op=UnaryOperator? value=T_NUM unit=FREQ_UNIT
		public Group getGroup() { return cGroup; }

		//op=UnaryOperator?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//UnaryOperator
		public RuleCall getOpUnaryOperatorParserRuleCall_0_0() { return cOpUnaryOperatorParserRuleCall_0_0; }

		//value=T_NUM
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//T_NUM
		public RuleCall getValueT_NUMTerminalRuleCall_1_0() { return cValueT_NUMTerminalRuleCall_1_0; }

		//unit=FREQ_UNIT
		public Assignment getUnitAssignment_2() { return cUnitAssignment_2; }

		//FREQ_UNIT
		public RuleCall getUnitFREQ_UNITTerminalRuleCall_2_0() { return cUnitFREQ_UNITTerminalRuleCall_2_0; }
	}

	public class UriElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Uri");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUrlKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		/// * | 'url(' WS? url=URL WS? ')' * / //TODO
		// Uri:
		//
		//	"url(" WS? value=STRING WS? ")";
		public ParserRule getRule() { return rule; }

		//"url(" WS? value=STRING WS? ")"
		public Group getGroup() { return cGroup; }

		//"url("
		public Keyword getUrlKeyword_0() { return cUrlKeyword_0; }

		//WS?
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }

		//value=STRING
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_0() { return cValueSTRINGTerminalRuleCall_2_0; }

		//WS?
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class StringValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StringValue");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//StringValue:
		//
		//	value=STRING;
		public ParserRule getRule() { return rule; }

		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}

	public class HexColorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "HexColor");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueHASHTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		////terminal URL:
		// //	(('!' | '#' | '$' | '%' | '&' | '*' | '-' | '~') / * | NON_ASCII  |  ESCAPE * /)*;
		//
		//
		////terminal NON_ASCII:
		// //	(\0240..\0377) //Chars 160 to 255
		// //;
		// //terminal UNICODE:
		//
		//
		////	'\\' HEXA (HEXA (HEXA (HEXA (HEXA (HEXA)?)?)?)?)? ('\r\n' | ' ' | '\t' | '\r' | '\n')?;
		// //
		// //terminal ESCAPE:
		//
		//
		////	UNICODE | ('\\' !('\r' | '\n' | '0'..'9' | 'a'..'f' | 'A'..'F'));
		// HexColor:
		//
		//	value=HASH;
		public ParserRule getRule() { return rule; }

		//value=HASH
		public Assignment getValueAssignment() { return cValueAssignment; }

		//HASH
		public RuleCall getValueHASHTerminalRuleCall_0() { return cValueHASHTerminalRuleCall_0; }
	}

	public class OperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Operator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cSolidusKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//Operator:
		//
		//	"/" WS* | "," WS*;
		public ParserRule getRule() { return rule; }

		//"/" WS* | "," WS*
		public Alternatives getAlternatives() { return cAlternatives; }

		//"/" WS*
		public Group getGroup_0() { return cGroup_0; }

		//"/"
		public Keyword getSolidusKeyword_0_0() { return cSolidusKeyword_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_0_1() { return cWSTerminalRuleCall_0_1; }

		//"," WS*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_1() { return cWSTerminalRuleCall_1_1; }
	}

	public class ClassElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Class");
		private final Assignment cClassAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cClassT_CLASSTerminalRuleCall_0 = (RuleCall)cClassAssignment.eContents().get(0);
		
		//Class:
		//
		//	class=T_CLASS;
		public ParserRule getRule() { return rule; }

		//class=T_CLASS
		public Assignment getClassAssignment() { return cClassAssignment; }

		//T_CLASS
		public RuleCall getClassT_CLASSTerminalRuleCall_0() { return cClassT_CLASSTerminalRuleCall_0; }
	}

	public class AttributeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Attribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Assignment cValueAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cValueAttributeValueParserRuleCall_4_0 = (RuleCall)cValueAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Attribute:
		//
		//	"[" WS* name=ID WS* value=AttributeValue? "]";
		public ParserRule getRule() { return rule; }

		//"[" WS* name=ID WS* value=AttributeValue? "]"
		public Group getGroup() { return cGroup; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }

		//value=AttributeValue?
		public Assignment getValueAssignment_4() { return cValueAssignment_4; }

		//AttributeValue
		public RuleCall getValueAttributeValueParserRuleCall_4_0() { return cValueAttributeValueParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class AttributeValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AttributeValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOperatorAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOperatorATTRIBUTE_OPEnumRuleCall_0_0 = (RuleCall)cOperatorAssignment_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cValueAlternatives_2_0 = (Alternatives)cValueAssignment_2.eContents().get(0);
		private final RuleCall cValueIDTerminalRuleCall_2_0_0 = (RuleCall)cValueAlternatives_2_0.eContents().get(0);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cValueAlternatives_2_0.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//AttributeValue:
		//
		//	operator=ATTRIBUTE_OP WS* value=(ID | STRING) WS*;
		public ParserRule getRule() { return rule; }

		//operator=ATTRIBUTE_OP WS* value=(ID | STRING) WS*
		public Group getGroup() { return cGroup; }

		//operator=ATTRIBUTE_OP
		public Assignment getOperatorAssignment_0() { return cOperatorAssignment_0; }

		//ATTRIBUTE_OP
		public RuleCall getOperatorATTRIBUTE_OPEnumRuleCall_0_0() { return cOperatorATTRIBUTE_OPEnumRuleCall_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1() { return cWSTerminalRuleCall_1; }

		//value=(ID | STRING)
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//ID | STRING
		public Alternatives getValueAlternatives_2_0() { return cValueAlternatives_2_0; }

		//ID
		public RuleCall getValueIDTerminalRuleCall_2_0_0() { return cValueIDTerminalRuleCall_2_0_0; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_0_1() { return cValueSTRINGTerminalRuleCall_2_0_1; }

		//WS*
		public RuleCall getWSTerminalRuleCall_3() { return cWSTerminalRuleCall_3; }
	}

	public class PseudoElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Pseudo");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cColonKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cPseudoAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cPseudoIDTerminalRuleCall_1_0_0 = (RuleCall)cPseudoAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Assignment cPseudoAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cPseudoIDTerminalRuleCall_1_1_0_0 = (RuleCall)cPseudoAssignment_1_1_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final RuleCall cWSTerminalRuleCall_1_1_2 = (RuleCall)cGroup_1_1.eContents().get(2);
		private final Group cGroup_1_1_3 = (Group)cGroup_1_1.eContents().get(3);
		private final Assignment cArgsAssignment_1_1_3_0 = (Assignment)cGroup_1_1_3.eContents().get(0);
		private final RuleCall cArgsIDTerminalRuleCall_1_1_3_0_0 = (RuleCall)cArgsAssignment_1_1_3_0.eContents().get(0);
		private final RuleCall cWSTerminalRuleCall_1_1_3_1 = (RuleCall)cGroup_1_1_3.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_1_4 = (Keyword)cGroup_1_1.eContents().get(4);
		
		//Pseudo:
		//
		//	":" (pseudo=ID | pseudo=ID "(" WS* (args=ID WS*)? ")");
		public ParserRule getRule() { return rule; }

		//":" (pseudo=ID | pseudo=ID "(" WS* (args=ID WS*)? ")")
		public Group getGroup() { return cGroup; }

		//":"
		public Keyword getColonKeyword_0() { return cColonKeyword_0; }

		//pseudo=ID | pseudo=ID "(" WS* (args=ID WS*)? ")"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//pseudo=ID
		public Assignment getPseudoAssignment_1_0() { return cPseudoAssignment_1_0; }

		//ID
		public RuleCall getPseudoIDTerminalRuleCall_1_0_0() { return cPseudoIDTerminalRuleCall_1_0_0; }

		//pseudo=ID "(" WS* (args=ID WS*)? ")"
		public Group getGroup_1_1() { return cGroup_1_1; }

		//pseudo=ID
		public Assignment getPseudoAssignment_1_1_0() { return cPseudoAssignment_1_1_0; }

		//ID
		public RuleCall getPseudoIDTerminalRuleCall_1_1_0_0() { return cPseudoIDTerminalRuleCall_1_1_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_1_1() { return cLeftParenthesisKeyword_1_1_1; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_1_2() { return cWSTerminalRuleCall_1_1_2; }

		//(args=ID WS*)?
		public Group getGroup_1_1_3() { return cGroup_1_1_3; }

		//args=ID
		public Assignment getArgsAssignment_1_1_3_0() { return cArgsAssignment_1_1_3_0; }

		//ID
		public RuleCall getArgsIDTerminalRuleCall_1_1_3_0_0() { return cArgsIDTerminalRuleCall_1_1_3_0_0; }

		//WS*
		public RuleCall getWSTerminalRuleCall_1_1_3_1() { return cWSTerminalRuleCall_1_1_3_1; }

		//")"
		public Keyword getRightParenthesisKeyword_1_1_4() { return cRightParenthesisKeyword_1_1_4; }
	}

	public class CSSIdElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CSSId");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueHASHTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//CSSId:
		//
		//	value=HASH;
		public ParserRule getRule() { return rule; }

		//value=HASH
		public Assignment getValueAssignment() { return cValueAssignment; }

		//HASH
		public RuleCall getValueHASHTerminalRuleCall_0() { return cValueHASHTerminalRuleCall_0; }
	}

	public class UnaryOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnaryOperator");
		private final Assignment cOperatorAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOperatorUNARYEnumRuleCall_0 = (RuleCall)cOperatorAssignment.eContents().get(0);
		
		//UnaryOperator:
		//
		//	operator=UNARY;
		public ParserRule getRule() { return rule; }

		//operator=UNARY
		public Assignment getOperatorAssignment() { return cOperatorAssignment; }

		//UNARY
		public RuleCall getOperatorUNARYEnumRuleCall_0() { return cOperatorUNARYEnumRuleCall_0; }
	}
	
	
	public class UNARYElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "UNARY");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cNEGEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cNEGHyphenMinusKeyword_0_0 = (Keyword)cNEGEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPLUSEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPLUSPlusSignKeyword_1_0 = (Keyword)cPLUSEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum UNARY:
		//
		//	NEG="-" | PLUS="+";
		public EnumRule getRule() { return rule; }

		//NEG="-" | PLUS="+"
		public Alternatives getAlternatives() { return cAlternatives; }

		//NEG="-"
		public EnumLiteralDeclaration getNEGEnumLiteralDeclaration_0() { return cNEGEnumLiteralDeclaration_0; }

		//"-"
		public Keyword getNEGHyphenMinusKeyword_0_0() { return cNEGHyphenMinusKeyword_0_0; }

		//PLUS="+"
		public EnumLiteralDeclaration getPLUSEnumLiteralDeclaration_1() { return cPLUSEnumLiteralDeclaration_1; }

		//"+"
		public Keyword getPLUSPlusSignKeyword_1_0() { return cPLUSPlusSignKeyword_1_0; }
	}

	public class KINDElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "KIND");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cFIRST_CHILDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cFIRST_CHILDGreaterThanSignKeyword_0_0 = (Keyword)cFIRST_CHILDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cSIBLINGEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cSIBLINGPlusSignKeyword_1_0 = (Keyword)cSIBLINGEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum KIND:
		//
		//	FIRST_CHILD=">" | SIBLING="+";
		public EnumRule getRule() { return rule; }

		//FIRST_CHILD=">" | SIBLING="+"
		public Alternatives getAlternatives() { return cAlternatives; }

		//FIRST_CHILD=">"
		public EnumLiteralDeclaration getFIRST_CHILDEnumLiteralDeclaration_0() { return cFIRST_CHILDEnumLiteralDeclaration_0; }

		//">"
		public Keyword getFIRST_CHILDGreaterThanSignKeyword_0_0() { return cFIRST_CHILDGreaterThanSignKeyword_0_0; }

		//SIBLING="+"
		public EnumLiteralDeclaration getSIBLINGEnumLiteralDeclaration_1() { return cSIBLINGEnumLiteralDeclaration_1; }

		//"+"
		public Keyword getSIBLINGPlusSignKeyword_1_0() { return cSIBLINGPlusSignKeyword_1_0; }
	}

	public class ATTRIBUTE_OPElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ATTRIBUTE_OP");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cEQUALSEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cEQUALSEqualsSignKeyword_0_0 = (Keyword)cEQUALSEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cCONTAINSEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cCONTAINSTildeEqualsSignKeyword_1_0 = (Keyword)cCONTAINSEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cUNEQUALSEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cUNEQUALSExclamationMarkEqualsSignKeyword_2_0 = (Keyword)cUNEQUALSEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum ATTRIBUTE_OP:
		//
		//	EQUALS="=" | CONTAINS="~=" | UNEQUALS="!=";
		public EnumRule getRule() { return rule; }

		//EQUALS="=" | CONTAINS="~=" | UNEQUALS="!="
		public Alternatives getAlternatives() { return cAlternatives; }

		//EQUALS="="
		public EnumLiteralDeclaration getEQUALSEnumLiteralDeclaration_0() { return cEQUALSEnumLiteralDeclaration_0; }

		//"="
		public Keyword getEQUALSEqualsSignKeyword_0_0() { return cEQUALSEqualsSignKeyword_0_0; }

		//CONTAINS="~="
		public EnumLiteralDeclaration getCONTAINSEnumLiteralDeclaration_1() { return cCONTAINSEnumLiteralDeclaration_1; }

		//"~="
		public Keyword getCONTAINSTildeEqualsSignKeyword_1_0() { return cCONTAINSTildeEqualsSignKeyword_1_0; }

		//UNEQUALS="!="
		public EnumLiteralDeclaration getUNEQUALSEnumLiteralDeclaration_2() { return cUNEQUALSEnumLiteralDeclaration_2; }

		//"!="
		public Keyword getUNEQUALSExclamationMarkEqualsSignKeyword_2_0() { return cUNEQUALSExclamationMarkEqualsSignKeyword_2_0; }
	}
	
	private StylesheetElements pStylesheet;
	private ContentElements pContent;
	private ImportElements pImport;
	private MediaElements pMedia;
	private PageElements pPage;
	private PseudoPageElements pPseudoPage;
	private RulesetElements pRuleset;
	private SelectorElements pSelector;
	private CompositeSelectorElements pCompositeSelector;
	private SimpleSelectorElements pSimpleSelector;
	private SelectorConditionElements pSelectorCondition;
	private CombinatorElements pCombinator;
	private DeclarationElements pDeclaration;
	private ExpressionElements pExpression;
	private SubtermElements pSubterm;
	private TermElements pTerm;
	private FunctionElements pFunction;
	private NameElements pName;
	private NumberElements pNumber;
	private PercentageElements pPercentage;
	private LengthElements pLength;
	private EmsElements pEms;
	private ExsElements pExs;
	private AngleElements pAngle;
	private TimeElements pTime;
	private FrequencyElements pFrequency;
	private UriElements pUri;
	private StringValueElements pStringValue;
	private HexColorElements pHexColor;
	private OperatorElements pOperator;
	private ClassElements pClass;
	private AttributeElements pAttribute;
	private AttributeValueElements pAttributeValue;
	private PseudoElements pPseudo;
	private CSSIdElements pCSSId;
	private UnaryOperatorElements pUnaryOperator;
	private UNARYElements unknownRuleUNARY;
	private KINDElements unknownRuleKIND;
	private ATTRIBUTE_OPElements unknownRuleATTRIBUTE_OP;
	private TerminalRule tHASH;
	private TerminalRule tT_CLASS;
	private TerminalRule tT_IMPORTANT;
	private TerminalRule tPC_UNIT;
	private TerminalRule tLEN_UNIT;
	private TerminalRule tEM_UNIT;
	private TerminalRule tEX_UNIT;
	private TerminalRule tANGLE_UNIT;
	private TerminalRule tTIME_UNIT;
	private TerminalRule tFREQ_UNIT;
	private TerminalRule tT_NUM;
	private TerminalRule tID;
	private TerminalRule tSTRING;
	private TerminalRule tCDO;
	private TerminalRule tCDC;
	private TerminalRule tML_COMMENT;
	private TerminalRule tWS;
	private TerminalRule tANY_OTHER;
	
	private final Grammar grammar;

	@Inject
	public CSSGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.papyrus.infra.gmfdiag.CSS".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	////Do not create a Stylesheet for WS* (This seems to cause a serialization problem when editing an EMF Model from an Empty file)
	//
	//
	////Do not ignore WS as @charset must be followed by exactly one Space.
	// Stylesheet:
	//
	//	("@charset " charset=STRING ";")? (WS | CDO | CDC)* (imports+=Import (CDO WS* | CDC WS*)*)* (contents+=Content (CDO
	//
	//	WS* | CDC WS*)*)*;
	public StylesheetElements getStylesheetAccess() {
		return (pStylesheet != null) ? pStylesheet : (pStylesheet = new StylesheetElements());
	}
	
	public ParserRule getStylesheetRule() {
		return getStylesheetAccess().getRule();
	}

	//Content:
	//
	//	Ruleset | Media | Page;
	public ContentElements getContentAccess() {
		return (pContent != null) ? pContent : (pContent = new ContentElements());
	}
	
	public ParserRule getContentRule() {
		return getContentAccess().getRule();
	}

	//Import:
	//
	//	"@import" (WS* string=STRING | WS uri=Uri) WS* (media+=ID WS* ("," WS* media+=ID)*)? ";" WS*;
	public ImportElements getImportAccess() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//Media:
	//
	//	"@media" WS media+=ID WS* ("," WS* media+=ID)* "{" WS* rules+=Ruleset* "}" WS*;
	public MediaElements getMediaAccess() {
		return (pMedia != null) ? pMedia : (pMedia = new MediaElements());
	}
	
	public ParserRule getMediaRule() {
		return getMediaAccess().getRule();
	}

	//Page:
	//
	//	{Page} "@page" WS* pseudo=PseudoPage? "{" WS* declarations+=Declaration? (";" WS* declarations+=Declaration?)* "}"
	//
	//	WS*;
	public PageElements getPageAccess() {
		return (pPage != null) ? pPage : (pPage = new PageElements());
	}
	
	public ParserRule getPageRule() {
		return getPageAccess().getRule();
	}

	//PseudoPage:
	//
	//	":" id=ID WS*;
	public PseudoPageElements getPseudoPageAccess() {
		return (pPseudoPage != null) ? pPseudoPage : (pPseudoPage = new PseudoPageElements());
	}
	
	public ParserRule getPseudoPageRule() {
		return getPseudoPageAccess().getRule();
	}

	//Ruleset:
	//
	//	selectors+=Selector ("," WS* selectors+=Selector)* "{" WS* properties+=Declaration? (";" WS*
	//
	//	properties+=Declaration?)* "}" WS*;
	public RulesetElements getRulesetAccess() {
		return (pRuleset != null) ? pRuleset : (pRuleset = new RulesetElements());
	}
	
	public ParserRule getRulesetRule() {
		return getRulesetAccess().getRule();
	}

	//Selector:
	//
	//	SimpleSelector WS* | CompositeSelector;
	public SelectorElements getSelectorAccess() {
		return (pSelector != null) ? pSelector : (pSelector = new SelectorElements());
	}
	
	public ParserRule getSelectorRule() {
		return getSelectorAccess().getRule();
	}

	////left=SimpleSelector (combinator=Combinator right=Selector | WS+ (combinator=Combinator? right=Selector)?)?;
	//
	//
	//CompositeSelector:
	//
	//	left=SimpleSelector (WS+ | WS* combinator=Combinator) right=Selector;
	public CompositeSelectorElements getCompositeSelectorAccess() {
		return (pCompositeSelector != null) ? pCompositeSelector : (pCompositeSelector = new CompositeSelectorElements());
	}
	
	public ParserRule getCompositeSelectorRule() {
		return getCompositeSelectorAccess().getRule();
	}

	//SimpleSelector:
	//
	//	elementName=(ID | "*") condition+=SelectorCondition* | condition+=SelectorCondition+;
	public SimpleSelectorElements getSimpleSelectorAccess() {
		return (pSimpleSelector != null) ? pSimpleSelector : (pSimpleSelector = new SimpleSelectorElements());
	}
	
	public ParserRule getSimpleSelectorRule() {
		return getSimpleSelectorAccess().getRule();
	}

	//SelectorCondition:
	//
	//	CSSId | Class | Attribute | Pseudo;
	public SelectorConditionElements getSelectorConditionAccess() {
		return (pSelectorCondition != null) ? pSelectorCondition : (pSelectorCondition = new SelectorConditionElements());
	}
	
	public ParserRule getSelectorConditionRule() {
		return getSelectorConditionAccess().getRule();
	}

	//Combinator:
	//
	//	kind=KIND WS*;
	public CombinatorElements getCombinatorAccess() {
		return (pCombinator != null) ? pCombinator : (pCombinator = new CombinatorElements());
	}
	
	public ParserRule getCombinatorRule() {
		return getCombinatorAccess().getRule();
	}

	//Declaration:
	//
	//	property=ID WS* ":" WS* expression=Expression (important?=T_IMPORTANT WS*)?;
	public DeclarationElements getDeclarationAccess() {
		return (pDeclaration != null) ? pDeclaration : (pDeclaration = new DeclarationElements());
	}
	
	public ParserRule getDeclarationRule() {
		return getDeclarationAccess().getRule();
	}

	//Expression:
	//
	//	terms=Term subterms+=Subterm*;
	public ExpressionElements getExpressionAccess() {
		return (pExpression != null) ? pExpression : (pExpression = new ExpressionElements());
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//Subterm:
	//
	//	operator=Operator? term=Term;
	public SubtermElements getSubtermAccess() {
		return (pSubterm != null) ? pSubterm : (pSubterm = new SubtermElements());
	}
	
	public ParserRule getSubtermRule() {
		return getSubtermAccess().getRule();
	}

	//Term:
	//
	//	(Number | Percentage | Length | Ems | Exs | Angle | Time | Frequency | Name | StringValue | Uri | HexColor |
	//
	//	Function) WS*;
	public TermElements getTermAccess() {
		return (pTerm != null) ? pTerm : (pTerm = new TermElements());
	}
	
	public ParserRule getTermRule() {
		return getTermAccess().getRule();
	}

	//Function:
	//
	//	name=ID "(" WS* args=Expression ")";
	public FunctionElements getFunctionAccess() {
		return (pFunction != null) ? pFunction : (pFunction = new FunctionElements());
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//Name:
	//
	//	value=ID;
	public NameElements getNameAccess() {
		return (pName != null) ? pName : (pName = new NameElements());
	}
	
	public ParserRule getNameRule() {
		return getNameAccess().getRule();
	}

	////Terms  
	// Number:
	//
	//	op=UnaryOperator? value=T_NUM;
	public NumberElements getNumberAccess() {
		return (pNumber != null) ? pNumber : (pNumber = new NumberElements());
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}

	//Percentage:
	//
	//	op=UnaryOperator? value=T_NUM unit=PC_UNIT;
	public PercentageElements getPercentageAccess() {
		return (pPercentage != null) ? pPercentage : (pPercentage = new PercentageElements());
	}
	
	public ParserRule getPercentageRule() {
		return getPercentageAccess().getRule();
	}

	//Length:
	//
	//	op=UnaryOperator? value=T_NUM unit=LEN_UNIT;
	public LengthElements getLengthAccess() {
		return (pLength != null) ? pLength : (pLength = new LengthElements());
	}
	
	public ParserRule getLengthRule() {
		return getLengthAccess().getRule();
	}

	//Ems:
	//
	//	op=UnaryOperator? value=T_NUM unit=EM_UNIT;
	public EmsElements getEmsAccess() {
		return (pEms != null) ? pEms : (pEms = new EmsElements());
	}
	
	public ParserRule getEmsRule() {
		return getEmsAccess().getRule();
	}

	//Exs:
	//
	//	op=UnaryOperator? value=T_NUM unit=EX_UNIT;
	public ExsElements getExsAccess() {
		return (pExs != null) ? pExs : (pExs = new ExsElements());
	}
	
	public ParserRule getExsRule() {
		return getExsAccess().getRule();
	}

	//Angle:
	//
	//	op=UnaryOperator? value=T_NUM unit=ANGLE_UNIT;
	public AngleElements getAngleAccess() {
		return (pAngle != null) ? pAngle : (pAngle = new AngleElements());
	}
	
	public ParserRule getAngleRule() {
		return getAngleAccess().getRule();
	}

	//Time:
	//
	//	op=UnaryOperator? value=T_NUM unit=TIME_UNIT;
	public TimeElements getTimeAccess() {
		return (pTime != null) ? pTime : (pTime = new TimeElements());
	}
	
	public ParserRule getTimeRule() {
		return getTimeAccess().getRule();
	}

	//Frequency:
	//
	//	op=UnaryOperator? value=T_NUM unit=FREQ_UNIT;
	public FrequencyElements getFrequencyAccess() {
		return (pFrequency != null) ? pFrequency : (pFrequency = new FrequencyElements());
	}
	
	public ParserRule getFrequencyRule() {
		return getFrequencyAccess().getRule();
	}

	/// * | 'url(' WS? url=URL WS? ')' * / //TODO
	// Uri:
	//
	//	"url(" WS? value=STRING WS? ")";
	public UriElements getUriAccess() {
		return (pUri != null) ? pUri : (pUri = new UriElements());
	}
	
	public ParserRule getUriRule() {
		return getUriAccess().getRule();
	}

	//StringValue:
	//
	//	value=STRING;
	public StringValueElements getStringValueAccess() {
		return (pStringValue != null) ? pStringValue : (pStringValue = new StringValueElements());
	}
	
	public ParserRule getStringValueRule() {
		return getStringValueAccess().getRule();
	}

	////terminal URL:
	// //	(('!' | '#' | '$' | '%' | '&' | '*' | '-' | '~') / * | NON_ASCII  |  ESCAPE * /)*;
	//
	//
	////terminal NON_ASCII:
	// //	(\0240..\0377) //Chars 160 to 255
	// //;
	// //terminal UNICODE:
	//
	//
	////	'\\' HEXA (HEXA (HEXA (HEXA (HEXA (HEXA)?)?)?)?)? ('\r\n' | ' ' | '\t' | '\r' | '\n')?;
	// //
	// //terminal ESCAPE:
	//
	//
	////	UNICODE | ('\\' !('\r' | '\n' | '0'..'9' | 'a'..'f' | 'A'..'F'));
	// HexColor:
	//
	//	value=HASH;
	public HexColorElements getHexColorAccess() {
		return (pHexColor != null) ? pHexColor : (pHexColor = new HexColorElements());
	}
	
	public ParserRule getHexColorRule() {
		return getHexColorAccess().getRule();
	}

	//Operator:
	//
	//	"/" WS* | "," WS*;
	public OperatorElements getOperatorAccess() {
		return (pOperator != null) ? pOperator : (pOperator = new OperatorElements());
	}
	
	public ParserRule getOperatorRule() {
		return getOperatorAccess().getRule();
	}

	//Class:
	//
	//	class=T_CLASS;
	public ClassElements getClassAccess() {
		return (pClass != null) ? pClass : (pClass = new ClassElements());
	}
	
	public ParserRule getClassRule() {
		return getClassAccess().getRule();
	}

	//Attribute:
	//
	//	"[" WS* name=ID WS* value=AttributeValue? "]";
	public AttributeElements getAttributeAccess() {
		return (pAttribute != null) ? pAttribute : (pAttribute = new AttributeElements());
	}
	
	public ParserRule getAttributeRule() {
		return getAttributeAccess().getRule();
	}

	//AttributeValue:
	//
	//	operator=ATTRIBUTE_OP WS* value=(ID | STRING) WS*;
	public AttributeValueElements getAttributeValueAccess() {
		return (pAttributeValue != null) ? pAttributeValue : (pAttributeValue = new AttributeValueElements());
	}
	
	public ParserRule getAttributeValueRule() {
		return getAttributeValueAccess().getRule();
	}

	//Pseudo:
	//
	//	":" (pseudo=ID | pseudo=ID "(" WS* (args=ID WS*)? ")");
	public PseudoElements getPseudoAccess() {
		return (pPseudo != null) ? pPseudo : (pPseudo = new PseudoElements());
	}
	
	public ParserRule getPseudoRule() {
		return getPseudoAccess().getRule();
	}

	//CSSId:
	//
	//	value=HASH;
	public CSSIdElements getCSSIdAccess() {
		return (pCSSId != null) ? pCSSId : (pCSSId = new CSSIdElements());
	}
	
	public ParserRule getCSSIdRule() {
		return getCSSIdAccess().getRule();
	}

	//UnaryOperator:
	//
	//	operator=UNARY;
	public UnaryOperatorElements getUnaryOperatorAccess() {
		return (pUnaryOperator != null) ? pUnaryOperator : (pUnaryOperator = new UnaryOperatorElements());
	}
	
	public ParserRule getUnaryOperatorRule() {
		return getUnaryOperatorAccess().getRule();
	}

	//enum UNARY:
	//
	//	NEG="-" | PLUS="+";
	public UNARYElements getUNARYAccess() {
		return (unknownRuleUNARY != null) ? unknownRuleUNARY : (unknownRuleUNARY = new UNARYElements());
	}
	
	public EnumRule getUNARYRule() {
		return getUNARYAccess().getRule();
	}

	//enum KIND:
	//
	//	FIRST_CHILD=">" | SIBLING="+";
	public KINDElements getKINDAccess() {
		return (unknownRuleKIND != null) ? unknownRuleKIND : (unknownRuleKIND = new KINDElements());
	}
	
	public EnumRule getKINDRule() {
		return getKINDAccess().getRule();
	}

	//enum ATTRIBUTE_OP:
	//
	//	EQUALS="=" | CONTAINS="~=" | UNEQUALS="!=";
	public ATTRIBUTE_OPElements getATTRIBUTE_OPAccess() {
		return (unknownRuleATTRIBUTE_OP != null) ? unknownRuleATTRIBUTE_OP : (unknownRuleATTRIBUTE_OP = new ATTRIBUTE_OPElements());
	}
	
	public EnumRule getATTRIBUTE_OPRule() {
		return getATTRIBUTE_OPAccess().getRule();
	}

	//terminal HASH:
	//
	//	"#" ("A".."Z" | "a".."z" | "0".."9")+;
	public TerminalRule getHASHRule() {
		return (tHASH != null) ? tHASH : (tHASH = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "HASH"));
	} 

	//terminal T_CLASS:
	//
	//	"." ID;
	public TerminalRule getT_CLASSRule() {
		return (tT_CLASS != null) ? tT_CLASS : (tT_CLASS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "T_CLASS"));
	} 

	////This is not the exact CSS Grammar
	// terminal T_IMPORTANT:
	//
	//	"!important";
	public TerminalRule getT_IMPORTANTRule() {
		return (tT_IMPORTANT != null) ? tT_IMPORTANT : (tT_IMPORTANT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "T_IMPORTANT"));
	} 

	//terminal PC_UNIT:
	//
	//	"%";
	public TerminalRule getPC_UNITRule() {
		return (tPC_UNIT != null) ? tPC_UNIT : (tPC_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "PC_UNIT"));
	} 

	//terminal LEN_UNIT:
	//
	//	"px" | "cm" | "mm" | "in" | "pt" | "pc";
	public TerminalRule getLEN_UNITRule() {
		return (tLEN_UNIT != null) ? tLEN_UNIT : (tLEN_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "LEN_UNIT"));
	} 

	//terminal EM_UNIT:
	//
	//	"em";
	public TerminalRule getEM_UNITRule() {
		return (tEM_UNIT != null) ? tEM_UNIT : (tEM_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "EM_UNIT"));
	} 

	//terminal EX_UNIT:
	//
	//	"ex";
	public TerminalRule getEX_UNITRule() {
		return (tEX_UNIT != null) ? tEX_UNIT : (tEX_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "EX_UNIT"));
	} 

	//terminal ANGLE_UNIT:
	//
	//	"deg" | "rad" | "grad";
	public TerminalRule getANGLE_UNITRule() {
		return (tANGLE_UNIT != null) ? tANGLE_UNIT : (tANGLE_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ANGLE_UNIT"));
	} 

	//terminal TIME_UNIT:
	//
	//	"s" | "ms";
	public TerminalRule getTIME_UNITRule() {
		return (tTIME_UNIT != null) ? tTIME_UNIT : (tTIME_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "TIME_UNIT"));
	} 

	//terminal FREQ_UNIT:
	//
	//	"hz" | "mhz";
	public TerminalRule getFREQ_UNITRule() {
		return (tFREQ_UNIT != null) ? tFREQ_UNIT : (tFREQ_UNIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "FREQ_UNIT"));
	} 

	//terminal T_NUM:
	//
	//	"0".."9"+ | "0".."9"* "." "0".."9"+;
	public TerminalRule getT_NUMRule() {
		return (tT_NUM != null) ? tT_NUM : (tT_NUM = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "T_NUM"));
	} 

	//terminal ID:
	//
	//	"-"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9" | "-")*;
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return (tSTRING != null) ? tSTRING : (tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	//terminal CDO:
	//
	//	"<!--";
	public TerminalRule getCDORule() {
		return (tCDO != null) ? tCDO : (tCDO = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "CDO"));
	} 

	//terminal CDC:
	//
	//	"-->";
	public TerminalRule getCDCRule() {
		return (tCDC != null) ? tCDC : (tCDC = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "CDC"));
	} 

	////Doesn't exactly match CSS Comments... * / can be protected by \ : \* / doesn't close the comment in XText, while it does in CSS 
	//
	//
	//terminal ML_COMMENT:
	//
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return (tML_COMMENT != null) ? tML_COMMENT : (tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return (tANY_OTHER != null) ? tANY_OTHER : (tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
