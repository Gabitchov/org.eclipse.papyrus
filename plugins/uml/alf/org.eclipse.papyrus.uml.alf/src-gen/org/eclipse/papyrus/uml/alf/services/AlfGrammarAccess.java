/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

package org.eclipse.papyrus.uml.alf.services;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AlfGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TestElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Test");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cTestExpressionKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cExpressionAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_0_1_0 = (RuleCall)cExpressionAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cTestAssignmentExpressionKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cAssignExpressionAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cAssignExpressionAssignmentCompletionParserRuleCall_1_1_0 = (RuleCall)cAssignExpressionAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cTestStatementKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cStatementsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cStatementsStatementParserRuleCall_2_1_0 = (RuleCall)cStatementsAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cTestBlockKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cBlockAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_3_1_0 = (RuleCall)cBlockAssignment_3_1.eContents().get(0);
		
		/// *
		//  Test rule
		// * / Test:
		//	("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
		//	("testStatement" statements+=Statement)* ("testBlock" block=Block);
		public ParserRule getRule() { return rule; }

		//("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
		//("testStatement" statements+=Statement)* ("testBlock" block=Block)
		public Group getGroup() { return cGroup; }

		//("testExpression" expression+=Expression)*
		public Group getGroup_0() { return cGroup_0; }

		//"testExpression"
		public Keyword getTestExpressionKeyword_0_0() { return cTestExpressionKeyword_0_0; }

		//expression+=Expression
		public Assignment getExpressionAssignment_0_1() { return cExpressionAssignment_0_1; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_0_1_0() { return cExpressionExpressionParserRuleCall_0_1_0; }

		//("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
		public Group getGroup_1() { return cGroup_1; }

		//"testAssignmentExpression"
		public Keyword getTestAssignmentExpressionKeyword_1_0() { return cTestAssignmentExpressionKeyword_1_0; }

		//assignExpression+=AssignmentCompletion
		public Assignment getAssignExpressionAssignment_1_1() { return cAssignExpressionAssignment_1_1; }

		//AssignmentCompletion
		public RuleCall getAssignExpressionAssignmentCompletionParserRuleCall_1_1_0() { return cAssignExpressionAssignmentCompletionParserRuleCall_1_1_0; }

		//("testStatement" statements+=Statement)*
		public Group getGroup_2() { return cGroup_2; }

		//"testStatement"
		public Keyword getTestStatementKeyword_2_0() { return cTestStatementKeyword_2_0; }

		//statements+=Statement
		public Assignment getStatementsAssignment_2_1() { return cStatementsAssignment_2_1; }

		//Statement
		public RuleCall getStatementsStatementParserRuleCall_2_1_0() { return cStatementsStatementParserRuleCall_2_1_0; }

		//"testBlock" block=Block
		public Group getGroup_3() { return cGroup_3; }

		//"testBlock"
		public Keyword getTestBlockKeyword_3_0() { return cTestBlockKeyword_3_0; }

		//block=Block
		public Assignment getBlockAssignment_3_1() { return cBlockAssignment_3_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_3_1_0() { return cBlockBlockParserRuleCall_3_1_0; }
	}

	public class LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LITERAL");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBOOLEAN_LITERALParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNUMBER_LITERALParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSTRING_LITERALParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		////('testStatementSequence' statement += StatementSequence)* ;
		/// *********************************
		// * PrimitiveLiterals
		// ********************************** / LITERAL:
		//	BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL;
		public ParserRule getRule() { return rule; }

		//BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL
		public Alternatives getAlternatives() { return cAlternatives; }

		//BOOLEAN_LITERAL
		public RuleCall getBOOLEAN_LITERALParserRuleCall_0() { return cBOOLEAN_LITERALParserRuleCall_0; }

		//NUMBER_LITERAL
		public RuleCall getNUMBER_LITERALParserRuleCall_1() { return cNUMBER_LITERALParserRuleCall_1; }

		//STRING_LITERAL
		public RuleCall getSTRING_LITERALParserRuleCall_2() { return cSTRING_LITERALParserRuleCall_2; }
	}

	public class BOOLEAN_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BOOLEAN_LITERAL");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueBooleanValueEnumRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//// (suffix = SuffixExpression) ? ;
		//BOOLEAN_LITERAL:
		//	value=BooleanValue;
		public ParserRule getRule() { return rule; }

		//value=BooleanValue
		public Assignment getValueAssignment() { return cValueAssignment; }

		//BooleanValue
		public RuleCall getValueBooleanValueEnumRuleCall_0() { return cValueBooleanValueEnumRuleCall_0; }
	}

	public class NUMBER_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NUMBER_LITERAL");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTEGER_LITERALParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUNLIMITED_LITERALParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NUMBER_LITERAL:
		//	INTEGER_LITERAL | UNLIMITED_LITERAL;
		public ParserRule getRule() { return rule; }

		//INTEGER_LITERAL | UNLIMITED_LITERAL
		public Alternatives getAlternatives() { return cAlternatives; }

		//INTEGER_LITERAL
		public RuleCall getINTEGER_LITERALParserRuleCall_0() { return cINTEGER_LITERALParserRuleCall_0; }

		//UNLIMITED_LITERAL
		public RuleCall getUNLIMITED_LITERALParserRuleCall_1() { return cUNLIMITED_LITERALParserRuleCall_1; }
	}

	public class INTEGER_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "INTEGER_LITERAL");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueIntegerValueTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//// (suffix = SuffixExpression) ? ;
		//INTEGER_LITERAL:
		//	value=IntegerValue;
		public ParserRule getRule() { return rule; }

		//value=IntegerValue
		public Assignment getValueAssignment() { return cValueAssignment; }

		//IntegerValue
		public RuleCall getValueIntegerValueTerminalRuleCall_0() { return cValueIntegerValueTerminalRuleCall_0; }
	}

	public class UNLIMITED_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UNLIMITED_LITERAL");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueAsteriskKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//// (suffix = SuffixExpression) ? ;
		//UNLIMITED_LITERAL:
		//	value="*";
		public ParserRule getRule() { return rule; }

		//value="*"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"*"
		public Keyword getValueAsteriskKeyword_0() { return cValueAsteriskKeyword_0; }
	}

	public class STRING_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "STRING_LITERAL");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//// (suffix = SuffixExpression) ?;
		//STRING_LITERAL:
		//	value=STRING;
		public ParserRule getRule() { return rule; }

		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}

	public class NameExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NameExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cPrefixOpAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Alternatives cPrefixOpAlternatives_0_0_0_0 = (Alternatives)cPrefixOpAssignment_0_0_0.eContents().get(0);
		private final Keyword cPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0 = (Keyword)cPrefixOpAlternatives_0_0_0_0.eContents().get(0);
		private final Keyword cPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1 = (Keyword)cPrefixOpAlternatives_0_0_0_0.eContents().get(1);
		private final Assignment cPathAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final RuleCall cPathQualifiedNamePathParserRuleCall_0_0_1_0 = (RuleCall)cPathAssignment_0_0_1.eContents().get(0);
		private final Assignment cIdAssignment_0_0_2 = (Assignment)cGroup_0_0.eContents().get(2);
		private final RuleCall cIdIDTerminalRuleCall_0_0_2_0 = (RuleCall)cIdAssignment_0_0_2.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cPathAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final RuleCall cPathQualifiedNamePathParserRuleCall_0_1_0_0 = (RuleCall)cPathAssignment_0_1_0.eContents().get(0);
		private final Assignment cIdAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cIdIDTerminalRuleCall_0_1_1_0 = (RuleCall)cIdAssignment_0_1_1.eContents().get(0);
		private final Alternatives cAlternatives_0_1_2 = (Alternatives)cGroup_0_1.eContents().get(2);
		private final Assignment cInvocationCompletionAssignment_0_1_2_0 = (Assignment)cAlternatives_0_1_2.eContents().get(0);
		private final RuleCall cInvocationCompletionTupleParserRuleCall_0_1_2_0_0 = (RuleCall)cInvocationCompletionAssignment_0_1_2_0.eContents().get(0);
		private final Assignment cSequenceConstructionCompletionAssignment_0_1_2_1 = (Assignment)cAlternatives_0_1_2.eContents().get(1);
		private final RuleCall cSequenceConstructionCompletionSequenceConstructionOrAccessCompletionParserRuleCall_0_1_2_1_0 = (RuleCall)cSequenceConstructionCompletionAssignment_0_1_2_1.eContents().get(0);
		private final Assignment cPostfixOpAssignment_0_1_2_2 = (Assignment)cAlternatives_0_1_2.eContents().get(2);
		private final Alternatives cPostfixOpAlternatives_0_1_2_2_0 = (Alternatives)cPostfixOpAssignment_0_1_2_2.eContents().get(0);
		private final Keyword cPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0 = (Keyword)cPostfixOpAlternatives_0_1_2_2_0.eContents().get(0);
		private final Keyword cPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1 = (Keyword)cPostfixOpAlternatives_0_1_2_2_0.eContents().get(1);
		private final Assignment cSuffixAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_1_0 = (RuleCall)cSuffixAssignment_1.eContents().get(0);
		
		//NameExpression:
		//	(prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
		//	sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
		//	suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//(prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
		//sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
		//suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
		//sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//prefixOp=("++" | "--") path=QualifiedNamePath? id=ID
		public Group getGroup_0_0() { return cGroup_0_0; }

		//prefixOp=("++" | "--")
		public Assignment getPrefixOpAssignment_0_0_0() { return cPrefixOpAssignment_0_0_0; }

		//"++" | "--"
		public Alternatives getPrefixOpAlternatives_0_0_0_0() { return cPrefixOpAlternatives_0_0_0_0; }

		//"++"
		public Keyword getPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0() { return cPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0; }

		//"--"
		public Keyword getPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1() { return cPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1; }

		//path=QualifiedNamePath?
		public Assignment getPathAssignment_0_0_1() { return cPathAssignment_0_0_1; }

		//QualifiedNamePath
		public RuleCall getPathQualifiedNamePathParserRuleCall_0_0_1_0() { return cPathQualifiedNamePathParserRuleCall_0_0_1_0; }

		//id=ID
		public Assignment getIdAssignment_0_0_2() { return cIdAssignment_0_0_2; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_0_0_2_0() { return cIdIDTerminalRuleCall_0_0_2_0; }

		//path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
		//sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//path=QualifiedNamePath?
		public Assignment getPathAssignment_0_1_0() { return cPathAssignment_0_1_0; }

		//QualifiedNamePath
		public RuleCall getPathQualifiedNamePathParserRuleCall_0_1_0_0() { return cPathQualifiedNamePathParserRuleCall_0_1_0_0; }

		//id=ID
		public Assignment getIdAssignment_0_1_1() { return cIdAssignment_0_1_1; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_0_1_1_0() { return cIdIDTerminalRuleCall_0_1_1_0; }

		//(invocationCompletion=Tuple | sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" |
		//"--"))?
		public Alternatives getAlternatives_0_1_2() { return cAlternatives_0_1_2; }

		//invocationCompletion=Tuple
		public Assignment getInvocationCompletionAssignment_0_1_2_0() { return cInvocationCompletionAssignment_0_1_2_0; }

		//Tuple
		public RuleCall getInvocationCompletionTupleParserRuleCall_0_1_2_0_0() { return cInvocationCompletionTupleParserRuleCall_0_1_2_0_0; }

		//sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion
		public Assignment getSequenceConstructionCompletionAssignment_0_1_2_1() { return cSequenceConstructionCompletionAssignment_0_1_2_1; }

		//SequenceConstructionOrAccessCompletion
		public RuleCall getSequenceConstructionCompletionSequenceConstructionOrAccessCompletionParserRuleCall_0_1_2_1_0() { return cSequenceConstructionCompletionSequenceConstructionOrAccessCompletionParserRuleCall_0_1_2_1_0; }

		//postfixOp=("++" | "--")
		public Assignment getPostfixOpAssignment_0_1_2_2() { return cPostfixOpAssignment_0_1_2_2; }

		//"++" | "--"
		public Alternatives getPostfixOpAlternatives_0_1_2_2_0() { return cPostfixOpAlternatives_0_1_2_2_0; }

		//"++"
		public Keyword getPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0() { return cPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0; }

		//"--"
		public Keyword getPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1() { return cPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_1() { return cSuffixAssignment_1; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_1_0() { return cSuffixSuffixExpressionParserRuleCall_1_0; }
	}

	public class QualifiedNamePathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedNamePath");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNamespaceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNamespaceUnqualifiedNameParserRuleCall_0_0 = (RuleCall)cNamespaceAssignment_0.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//QualifiedNamePath:
		//	(namespace+=UnqualifiedName "::")+;
		public ParserRule getRule() { return rule; }

		//(namespace+=UnqualifiedName "::")+
		public Group getGroup() { return cGroup; }

		//namespace+=UnqualifiedName
		public Assignment getNamespaceAssignment_0() { return cNamespaceAssignment_0; }

		//UnqualifiedName
		public RuleCall getNamespaceUnqualifiedNameParserRuleCall_0_0() { return cNamespaceUnqualifiedNameParserRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }
	}

	public class UnqualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnqualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cTemplateBindingAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTemplateBindingTemplateBindingParserRuleCall_1_0 = (RuleCall)cTemplateBindingAssignment_1.eContents().get(0);
		
		//UnqualifiedName:
		//	name=ID templateBinding=TemplateBinding?;
		public ParserRule getRule() { return rule; }

		//name=ID templateBinding=TemplateBinding?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//templateBinding=TemplateBinding?
		public Assignment getTemplateBindingAssignment_1() { return cTemplateBindingAssignment_1; }

		//TemplateBinding
		public RuleCall getTemplateBindingTemplateBindingParserRuleCall_1_0() { return cTemplateBindingTemplateBindingParserRuleCall_1_0; }
	}

	public class TemplateBindingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TemplateBinding");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLessThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBindingsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBindingsNamedTemplateBindingParserRuleCall_1_0 = (RuleCall)cBindingsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cBindingsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cBindingsNamedTemplateBindingParserRuleCall_2_1_0 = (RuleCall)cBindingsAssignment_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TemplateBinding:
		//	"<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">";
		public ParserRule getRule() { return rule; }

		//"<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">"
		public Group getGroup() { return cGroup; }

		//"<"
		public Keyword getLessThanSignKeyword_0() { return cLessThanSignKeyword_0; }

		//bindings+=NamedTemplateBinding
		public Assignment getBindingsAssignment_1() { return cBindingsAssignment_1; }

		//NamedTemplateBinding
		public RuleCall getBindingsNamedTemplateBindingParserRuleCall_1_0() { return cBindingsNamedTemplateBindingParserRuleCall_1_0; }

		//("," bindings+=NamedTemplateBinding)*
		public Group getGroup_2() { return cGroup_2; }

		//","
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//bindings+=NamedTemplateBinding
		public Assignment getBindingsAssignment_2_1() { return cBindingsAssignment_2_1; }

		//NamedTemplateBinding
		public RuleCall getBindingsNamedTemplateBindingParserRuleCall_2_1_0() { return cBindingsNamedTemplateBindingParserRuleCall_2_1_0; }

		//">"
		public Keyword getGreaterThanSignKeyword_3() { return cGreaterThanSignKeyword_3; }
	}

	public class NamedTemplateBindingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NamedTemplateBinding");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cFormalAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cFormalIDTerminalRuleCall_0_0 = (RuleCall)cFormalAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cActualAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cActualQualifiedNameWithBindingParserRuleCall_2_0 = (RuleCall)cActualAssignment_2.eContents().get(0);
		
		//NamedTemplateBinding:
		//	formal=ID "=>" actual=QualifiedNameWithBinding;
		public ParserRule getRule() { return rule; }

		//formal=ID "=>" actual=QualifiedNameWithBinding
		public Group getGroup() { return cGroup; }

		//formal=ID
		public Assignment getFormalAssignment_0() { return cFormalAssignment_0; }

		//ID
		public RuleCall getFormalIDTerminalRuleCall_0_0() { return cFormalIDTerminalRuleCall_0_0; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//actual=QualifiedNameWithBinding
		public Assignment getActualAssignment_2() { return cActualAssignment_2; }

		//QualifiedNameWithBinding
		public RuleCall getActualQualifiedNameWithBindingParserRuleCall_2_0() { return cActualQualifiedNameWithBindingParserRuleCall_2_0; }
	}

	public class QualifiedNameWithBindingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedNameWithBinding");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIdAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cIdIDTerminalRuleCall_0_0 = (RuleCall)cIdAssignment_0.eContents().get(0);
		private final Assignment cBindingAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBindingTemplateBindingParserRuleCall_1_0 = (RuleCall)cBindingAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cRemainingAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cRemainingQualifiedNameWithBindingParserRuleCall_2_1_0 = (RuleCall)cRemainingAssignment_2_1.eContents().get(0);
		
		//QualifiedNameWithBinding:
		//	id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?;
		public ParserRule getRule() { return rule; }

		//id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?
		public Group getGroup() { return cGroup; }

		//id=ID
		public Assignment getIdAssignment_0() { return cIdAssignment_0; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_0_0() { return cIdIDTerminalRuleCall_0_0; }

		//binding=TemplateBinding?
		public Assignment getBindingAssignment_1() { return cBindingAssignment_1; }

		//TemplateBinding
		public RuleCall getBindingTemplateBindingParserRuleCall_1_0() { return cBindingTemplateBindingParserRuleCall_1_0; }

		//("::" remaining=QualifiedNameWithBinding)?
		public Group getGroup_2() { return cGroup_2; }

		//"::"
		public Keyword getColonColonKeyword_2_0() { return cColonColonKeyword_2_0; }

		//remaining=QualifiedNameWithBinding
		public Assignment getRemainingAssignment_2_1() { return cRemainingAssignment_2_1; }

		//QualifiedNameWithBinding
		public RuleCall getRemainingQualifiedNameWithBindingParserRuleCall_2_1_0() { return cRemainingQualifiedNameWithBindingParserRuleCall_2_1_0; }
	}

	public class TupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Tuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTupleAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cTupleElementsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cTupleElementsTupleElementParserRuleCall_2_0_0 = (RuleCall)cTupleElementsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cTupleElementsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cTupleElementsTupleElementParserRuleCall_2_1_1_0 = (RuleCall)cTupleElementsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Tuple:
		//	{Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")";
		public ParserRule getRule() { return rule; }

		//{Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")"
		public Group getGroup() { return cGroup; }

		//{Tuple}
		public Action getTupleAction_0() { return cTupleAction_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)?
		public Group getGroup_2() { return cGroup_2; }

		//tupleElements+=TupleElement
		public Assignment getTupleElementsAssignment_2_0() { return cTupleElementsAssignment_2_0; }

		//TupleElement
		public RuleCall getTupleElementsTupleElementParserRuleCall_2_0_0() { return cTupleElementsTupleElementParserRuleCall_2_0_0; }

		//("," tupleElements+=TupleElement)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//tupleElements+=TupleElement
		public Assignment getTupleElementsAssignment_2_1_1() { return cTupleElementsAssignment_2_1_1; }

		//TupleElement
		public RuleCall getTupleElementsTupleElementParserRuleCall_2_1_1_0() { return cTupleElementsTupleElementParserRuleCall_2_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class TupleElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TupleElement");
		private final Assignment cArgumentAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cArgumentExpressionParserRuleCall_0 = (RuleCall)cArgumentAssignment.eContents().get(0);
		
		//TupleElement:
		//	argument=Expression;
		public ParserRule getRule() { return rule; }

		//argument=Expression
		public Assignment getArgumentAssignment() { return cArgumentAssignment; }

		//Expression
		public RuleCall getArgumentExpressionParserRuleCall_0() { return cArgumentExpressionParserRuleCall_0; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final RuleCall cConditionalTestExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		/// **************
		// * Expressions
		// ************** / Expression:
		//	ConditionalTestExpression;
		public ParserRule getRule() { return rule; }

		//ConditionalTestExpression
		public RuleCall getConditionalTestExpressionParserRuleCall() { return cConditionalTestExpressionParserRuleCall; }
	}

	public class ConditionalTestExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConditionalTestExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpConditionalOrExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cQuestionMarkKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cWhenTrueAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cWhenTrueConditionalTestExpressionParserRuleCall_1_1_0 = (RuleCall)cWhenTrueAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cWhenFalseAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cWhenFalseConditionalTestExpressionParserRuleCall_1_3_0 = (RuleCall)cWhenFalseAssignment_1_3.eContents().get(0);
		
		//ConditionalTestExpression:
		//	exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?;
		public ParserRule getRule() { return rule; }

		//exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?
		public Group getGroup() { return cGroup; }

		//exp=ConditionalOrExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//ConditionalOrExpression
		public RuleCall getExpConditionalOrExpressionParserRuleCall_0_0() { return cExpConditionalOrExpressionParserRuleCall_0_0; }

		//("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?
		public Group getGroup_1() { return cGroup_1; }

		//"?"
		public Keyword getQuestionMarkKeyword_1_0() { return cQuestionMarkKeyword_1_0; }

		//whenTrue=ConditionalTestExpression
		public Assignment getWhenTrueAssignment_1_1() { return cWhenTrueAssignment_1_1; }

		//ConditionalTestExpression
		public RuleCall getWhenTrueConditionalTestExpressionParserRuleCall_1_1_0() { return cWhenTrueConditionalTestExpressionParserRuleCall_1_1_0; }

		//":"
		public Keyword getColonKeyword_1_2() { return cColonKeyword_1_2; }

		//whenFalse=ConditionalTestExpression
		public Assignment getWhenFalseAssignment_1_3() { return cWhenFalseAssignment_1_3; }

		//ConditionalTestExpression
		public RuleCall getWhenFalseConditionalTestExpressionParserRuleCall_1_3_0() { return cWhenFalseConditionalTestExpressionParserRuleCall_1_3_0; }
	}

	public class ConditionalOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConditionalOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpConditionalAndExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cVerticalLineVerticalLineKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpConditionalAndExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//ConditionalOrExpression:
		//	exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=ConditionalAndExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//ConditionalAndExpression
		public RuleCall getExpConditionalAndExpressionParserRuleCall_0_0() { return cExpConditionalAndExpressionParserRuleCall_0_0; }

		//("||" exp+=ConditionalAndExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//"||"
		public Keyword getVerticalLineVerticalLineKeyword_1_0() { return cVerticalLineVerticalLineKeyword_1_0; }

		//exp+=ConditionalAndExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//ConditionalAndExpression
		public RuleCall getExpConditionalAndExpressionParserRuleCall_1_1_0() { return cExpConditionalAndExpressionParserRuleCall_1_1_0; }
	}

	public class ConditionalAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConditionalAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpInclusiveOrExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAmpersandAmpersandKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpInclusiveOrExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//ConditionalAndExpression:
		//	exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=InclusiveOrExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//InclusiveOrExpression
		public RuleCall getExpInclusiveOrExpressionParserRuleCall_0_0() { return cExpInclusiveOrExpressionParserRuleCall_0_0; }

		//("&&" exp+=InclusiveOrExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//"&&"
		public Keyword getAmpersandAmpersandKeyword_1_0() { return cAmpersandAmpersandKeyword_1_0; }

		//exp+=InclusiveOrExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//InclusiveOrExpression
		public RuleCall getExpInclusiveOrExpressionParserRuleCall_1_1_0() { return cExpInclusiveOrExpressionParserRuleCall_1_1_0; }
	}

	public class InclusiveOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InclusiveOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpExclusiveOrExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cVerticalLineKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpExclusiveOrExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//InclusiveOrExpression:
		//	exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=ExclusiveOrExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//ExclusiveOrExpression
		public RuleCall getExpExclusiveOrExpressionParserRuleCall_0_0() { return cExpExclusiveOrExpressionParserRuleCall_0_0; }

		//("|" exp+=ExclusiveOrExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//"|"
		public Keyword getVerticalLineKeyword_1_0() { return cVerticalLineKeyword_1_0; }

		//exp+=ExclusiveOrExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//ExclusiveOrExpression
		public RuleCall getExpExclusiveOrExpressionParserRuleCall_1_1_0() { return cExpExclusiveOrExpressionParserRuleCall_1_1_0; }
	}

	public class ExclusiveOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExclusiveOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpAndExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCircumflexAccentKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpAndExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//ExclusiveOrExpression:
		//	exp+=AndExpression ("^" exp+=AndExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=AndExpression ("^" exp+=AndExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=AndExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//AndExpression
		public RuleCall getExpAndExpressionParserRuleCall_0_0() { return cExpAndExpressionParserRuleCall_0_0; }

		//("^" exp+=AndExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//"^"
		public Keyword getCircumflexAccentKeyword_1_0() { return cCircumflexAccentKeyword_1_0; }

		//exp+=AndExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//AndExpression
		public RuleCall getExpAndExpressionParserRuleCall_1_1_0() { return cExpAndExpressionParserRuleCall_1_1_0; }
	}

	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpEqualityExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAmpersandKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpEqualityExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//AndExpression:
		//	exp+=EqualityExpression ("&" exp+=EqualityExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=EqualityExpression ("&" exp+=EqualityExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=EqualityExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//EqualityExpression
		public RuleCall getExpEqualityExpressionParserRuleCall_0_0() { return cExpEqualityExpressionParserRuleCall_0_0; }

		//("&" exp+=EqualityExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//"&"
		public Keyword getAmpersandKeyword_1_0() { return cAmpersandKeyword_1_0; }

		//exp+=EqualityExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//EqualityExpression
		public RuleCall getExpEqualityExpressionParserRuleCall_1_1_0() { return cExpEqualityExpressionParserRuleCall_1_1_0; }
	}

	public class EqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EqualityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpClassificationExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpEqualsSignEqualsSignKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpExclamationMarkEqualsSignKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpClassificationExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		//EqualityExpression:
		//	exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=ClassificationExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//ClassificationExpression
		public RuleCall getExpClassificationExpressionParserRuleCall_0_0() { return cExpClassificationExpressionParserRuleCall_0_0; }

		//(op+=("==" | "!=") exp+=ClassificationExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//op+=("==" | "!=")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"==" | "!="
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"=="
		public Keyword getOpEqualsSignEqualsSignKeyword_1_0_0_0() { return cOpEqualsSignEqualsSignKeyword_1_0_0_0; }

		//"!="
		public Keyword getOpExclamationMarkEqualsSignKeyword_1_0_0_1() { return cOpExclamationMarkEqualsSignKeyword_1_0_0_1; }

		//exp+=ClassificationExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//ClassificationExpression
		public RuleCall getExpClassificationExpressionParserRuleCall_1_1_0() { return cExpClassificationExpressionParserRuleCall_1_1_0; }
	}

	public class ClassificationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassificationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpRelationalExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpInstanceofKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpHastypeKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Assignment cTypeNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeNameNameExpressionParserRuleCall_1_1_0 = (RuleCall)cTypeNameAssignment_1_1.eContents().get(0);
		
		////enum EqualityOperator :
		////	EQUALS = '==' |
		////	NOT_EQUALS = '!='
		////;
		//ClassificationExpression:
		//	exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?;
		public ParserRule getRule() { return rule; }

		//exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?
		public Group getGroup() { return cGroup; }

		//exp=RelationalExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//RelationalExpression
		public RuleCall getExpRelationalExpressionParserRuleCall_0_0() { return cExpRelationalExpressionParserRuleCall_0_0; }

		//(op=("instanceof" | "hastype") typeName=NameExpression)?
		public Group getGroup_1() { return cGroup_1; }

		//op=("instanceof" | "hastype")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"instanceof" | "hastype"
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"instanceof"
		public Keyword getOpInstanceofKeyword_1_0_0_0() { return cOpInstanceofKeyword_1_0_0_0; }

		//"hastype"
		public Keyword getOpHastypeKeyword_1_0_0_1() { return cOpHastypeKeyword_1_0_0_1; }

		//typeName=NameExpression
		public Assignment getTypeNameAssignment_1_1() { return cTypeNameAssignment_1_1; }

		//NameExpression
		public RuleCall getTypeNameNameExpressionParserRuleCall_1_1_0() { return cTypeNameNameExpressionParserRuleCall_1_1_0; }
	}

	public class RelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLeftAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLeftShiftExpressionParserRuleCall_0_0 = (RuleCall)cLeftAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpLessThanSignKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpGreaterThanSignKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Keyword cOpLessThanSignEqualsSignKeyword_1_0_0_2 = (Keyword)cOpAlternatives_1_0_0.eContents().get(2);
		private final Keyword cOpGreaterThanSignEqualsSignKeyword_1_0_0_3 = (Keyword)cOpAlternatives_1_0_0.eContents().get(3);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightShiftExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		////enum ClassificationOperator :
		////	INSTANCEOF = 'instanceof' |
		////	HASTYPE = 'hastype'
		////;
		//RelationalExpression:
		//	left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?;
		public ParserRule getRule() { return rule; }

		//left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?
		public Group getGroup() { return cGroup; }

		//left=ShiftExpression
		public Assignment getLeftAssignment_0() { return cLeftAssignment_0; }

		//ShiftExpression
		public RuleCall getLeftShiftExpressionParserRuleCall_0_0() { return cLeftShiftExpressionParserRuleCall_0_0; }

		//(op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?
		public Group getGroup_1() { return cGroup_1; }

		//op=("<" | ">" | "<=" | ">=")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"<" | ">" | "<=" | ">="
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"<"
		public Keyword getOpLessThanSignKeyword_1_0_0_0() { return cOpLessThanSignKeyword_1_0_0_0; }

		//">"
		public Keyword getOpGreaterThanSignKeyword_1_0_0_1() { return cOpGreaterThanSignKeyword_1_0_0_1; }

		//"<="
		public Keyword getOpLessThanSignEqualsSignKeyword_1_0_0_2() { return cOpLessThanSignEqualsSignKeyword_1_0_0_2; }

		//">="
		public Keyword getOpGreaterThanSignEqualsSignKeyword_1_0_0_3() { return cOpGreaterThanSignEqualsSignKeyword_1_0_0_3; }

		//right=ShiftExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//ShiftExpression
		public RuleCall getRightShiftExpressionParserRuleCall_1_1_0() { return cRightShiftExpressionParserRuleCall_1_1_0; }
	}

	public class ShiftExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ShiftExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpAdditiveExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpLessThanSignLessThanSignKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Keyword cOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2 = (Keyword)cOpAlternatives_1_0_0.eContents().get(2);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpAdditiveExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		////RelationalOperator :
		////	LOWER = '<' |
		////	UPPER = '>' |
		////	LOWER_EQUALS = '<=' |
		////	UPPER_EQUALS = '>='
		////;
		//ShiftExpression:
		//	exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?;
		public ParserRule getRule() { return rule; }

		//exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?
		public Group getGroup() { return cGroup; }

		//exp+=AdditiveExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//AdditiveExpression
		public RuleCall getExpAdditiveExpressionParserRuleCall_0_0() { return cExpAdditiveExpressionParserRuleCall_0_0; }

		//(op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?
		public Group getGroup_1() { return cGroup_1; }

		//op=("<<" | ">>" | ">>>")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"<<" | ">>" | ">>>"
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"<<"
		public Keyword getOpLessThanSignLessThanSignKeyword_1_0_0_0() { return cOpLessThanSignLessThanSignKeyword_1_0_0_0; }

		//">>"
		public Keyword getOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1() { return cOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1; }

		//">>>"
		public Keyword getOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2() { return cOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2; }

		//exp+=AdditiveExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//AdditiveExpression
		public RuleCall getExpAdditiveExpressionParserRuleCall_1_1_0() { return cExpAdditiveExpressionParserRuleCall_1_1_0; }
	}

	public class AdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AdditiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpMultiplicativeExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpPlusSignKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpMultiplicativeExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		////enum ShiftOperator :
		////	LSHIFT = '<<' |
		////	RSHIFT = '>>' |
		////	URSHIFT = '>>>'
		////;
		//AdditiveExpression:
		//	exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=MultiplicativeExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//MultiplicativeExpression
		public RuleCall getExpMultiplicativeExpressionParserRuleCall_0_0() { return cExpMultiplicativeExpressionParserRuleCall_0_0; }

		//(op+=("+" | "-") exp+=MultiplicativeExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//op+=("+" | "-")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"+" | "-"
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"+"
		public Keyword getOpPlusSignKeyword_1_0_0_0() { return cOpPlusSignKeyword_1_0_0_0; }

		//"-"
		public Keyword getOpHyphenMinusKeyword_1_0_0_1() { return cOpHyphenMinusKeyword_1_0_0_1; }

		//exp+=MultiplicativeExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//MultiplicativeExpression
		public RuleCall getExpMultiplicativeExpressionParserRuleCall_1_1_0() { return cExpMultiplicativeExpressionParserRuleCall_1_1_0; }
	}

	public class MultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MultiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpUnaryExpressionParserRuleCall_0_0 = (RuleCall)cExpAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cOpAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_0_0 = (Alternatives)cOpAssignment_1_0.eContents().get(0);
		private final Keyword cOpAsteriskKeyword_1_0_0_0 = (Keyword)cOpAlternatives_1_0_0.eContents().get(0);
		private final Keyword cOpSolidusKeyword_1_0_0_1 = (Keyword)cOpAlternatives_1_0_0.eContents().get(1);
		private final Keyword cOpPercentSignKeyword_1_0_0_2 = (Keyword)cOpAlternatives_1_0_0.eContents().get(2);
		private final Assignment cExpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpUnaryExpressionParserRuleCall_1_1_0 = (RuleCall)cExpAssignment_1_1.eContents().get(0);
		
		////enum AdditiveOp :
		////	PLUS = '+' |
		////	MINUS = '-'
		////;
		//MultiplicativeExpression:
		//	exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*;
		public ParserRule getRule() { return rule; }

		//exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*
		public Group getGroup() { return cGroup; }

		//exp+=UnaryExpression
		public Assignment getExpAssignment_0() { return cExpAssignment_0; }

		//UnaryExpression
		public RuleCall getExpUnaryExpressionParserRuleCall_0_0() { return cExpUnaryExpressionParserRuleCall_0_0; }

		//(op+=("*" | "/" | "%") exp+=UnaryExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//op+=("*" | "/" | "%")
		public Assignment getOpAssignment_1_0() { return cOpAssignment_1_0; }

		//"*" | "/" | "%"
		public Alternatives getOpAlternatives_1_0_0() { return cOpAlternatives_1_0_0; }

		//"*"
		public Keyword getOpAsteriskKeyword_1_0_0_0() { return cOpAsteriskKeyword_1_0_0_0; }

		//"/"
		public Keyword getOpSolidusKeyword_1_0_0_1() { return cOpSolidusKeyword_1_0_0_1; }

		//"%"
		public Keyword getOpPercentSignKeyword_1_0_0_2() { return cOpPercentSignKeyword_1_0_0_2; }

		//exp+=UnaryExpression
		public Assignment getExpAssignment_1_1() { return cExpAssignment_1_1; }

		//UnaryExpression
		public RuleCall getExpUnaryExpressionParserRuleCall_1_1_0() { return cExpUnaryExpressionParserRuleCall_1_1_0; }
	}

	public class UnaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnaryExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cOpAlternatives_0_0 = (Alternatives)cOpAssignment_0.eContents().get(0);
		private final Keyword cOpExclamationMarkKeyword_0_0_0 = (Keyword)cOpAlternatives_0_0.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_0_0_1 = (Keyword)cOpAlternatives_0_0.eContents().get(1);
		private final Keyword cOpPlusSignKeyword_0_0_2 = (Keyword)cOpAlternatives_0_0.eContents().get(2);
		private final Keyword cOpDollarSignKeyword_0_0_3 = (Keyword)cOpAlternatives_0_0.eContents().get(3);
		private final Keyword cOpTildeKeyword_0_0_4 = (Keyword)cOpAlternatives_0_0.eContents().get(4);
		private final Assignment cExpAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpPrimaryExpressionParserRuleCall_1_0 = (RuleCall)cExpAssignment_1.eContents().get(0);
		
		////enum MultiplicativeOp :
		////	MULT = '*' |
		////	DIV = '/' |
		////	MOD = '%'
		////;
		//UnaryExpression:
		//	op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression;
		public ParserRule getRule() { return rule; }

		//op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression
		public Group getGroup() { return cGroup; }

		//op=("!" | "-" | "+" | "$" | "~")?
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//"!" | "-" | "+" | "$" | "~"
		public Alternatives getOpAlternatives_0_0() { return cOpAlternatives_0_0; }

		//"!"
		public Keyword getOpExclamationMarkKeyword_0_0_0() { return cOpExclamationMarkKeyword_0_0_0; }

		//"-"
		public Keyword getOpHyphenMinusKeyword_0_0_1() { return cOpHyphenMinusKeyword_0_0_1; }

		//"+"
		public Keyword getOpPlusSignKeyword_0_0_2() { return cOpPlusSignKeyword_0_0_2; }

		//"$"
		public Keyword getOpDollarSignKeyword_0_0_3() { return cOpDollarSignKeyword_0_0_3; }

		//"~"
		public Keyword getOpTildeKeyword_0_0_4() { return cOpTildeKeyword_0_0_4; }

		//exp=PrimaryExpression
		public Assignment getExpAssignment_1() { return cExpAssignment_1; }

		//PrimaryExpression
		public RuleCall getExpPrimaryExpressionParserRuleCall_1_0() { return cExpPrimaryExpressionParserRuleCall_1_0; }
	}

	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PrimaryExpression");
		private final Assignment cPrefixAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cPrefixValueSpecificationParserRuleCall_0 = (RuleCall)cPrefixAssignment.eContents().get(0);
		
		////PrimaryExpression :
		////	prefix = ValueSpecification (suffix = SuffixExpression)? 
		////;
		//PrimaryExpression:
		//	prefix=ValueSpecification;
		public ParserRule getRule() { return rule; }

		//prefix=ValueSpecification
		public Assignment getPrefixAssignment() { return cPrefixAssignment; }

		//ValueSpecification
		public RuleCall getPrefixValueSpecificationParserRuleCall_0() { return cPrefixValueSpecificationParserRuleCall_0; }
	}

	public class SuffixExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SuffixExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cOperationCallExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPropertyCallExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLinkOperationExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSequenceOperationExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cSequenceReductionExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cSequenceExpansionExpressionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cClassExtentExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//SuffixExpression:
		//	OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
		//	SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression;
		public ParserRule getRule() { return rule; }

		//OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
		//SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//OperationCallExpression
		public RuleCall getOperationCallExpressionParserRuleCall_0() { return cOperationCallExpressionParserRuleCall_0; }

		//PropertyCallExpression
		public RuleCall getPropertyCallExpressionParserRuleCall_1() { return cPropertyCallExpressionParserRuleCall_1; }

		//LinkOperationExpression
		public RuleCall getLinkOperationExpressionParserRuleCall_2() { return cLinkOperationExpressionParserRuleCall_2; }

		//SequenceOperationExpression
		public RuleCall getSequenceOperationExpressionParserRuleCall_3() { return cSequenceOperationExpressionParserRuleCall_3; }

		//SequenceReductionExpression
		public RuleCall getSequenceReductionExpressionParserRuleCall_4() { return cSequenceReductionExpressionParserRuleCall_4; }

		//SequenceExpansionExpression
		public RuleCall getSequenceExpansionExpressionParserRuleCall_5() { return cSequenceExpansionExpressionParserRuleCall_5; }

		//ClassExtentExpression
		public RuleCall getClassExtentExpressionParserRuleCall_6() { return cClassExtentExpressionParserRuleCall_6; }
	}

	public class OperationCallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OperationCallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFullStopKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOperationNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOperationNameIDTerminalRuleCall_1_0 = (RuleCall)cOperationNameAssignment_1.eContents().get(0);
		private final Assignment cTupleAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTupleTupleParserRuleCall_2_0 = (RuleCall)cTupleAssignment_2.eContents().get(0);
		private final Assignment cSuffixAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_3_0 = (RuleCall)cSuffixAssignment_3.eContents().get(0);
		
		//OperationCallExpression:
		//	"." operationName=ID tuple=Tuple suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"." operationName=ID tuple=Tuple suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"."
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }

		//operationName=ID
		public Assignment getOperationNameAssignment_1() { return cOperationNameAssignment_1; }

		//ID
		public RuleCall getOperationNameIDTerminalRuleCall_1_0() { return cOperationNameIDTerminalRuleCall_1_0; }

		//tuple=Tuple
		public Assignment getTupleAssignment_2() { return cTupleAssignment_2; }

		//Tuple
		public RuleCall getTupleTupleParserRuleCall_2_0() { return cTupleTupleParserRuleCall_2_0; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_3() { return cSuffixAssignment_3; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_3_0() { return cSuffixSuffixExpressionParserRuleCall_3_0; }
	}

	public class PropertyCallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyCallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFullStopKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPropertyNameIDTerminalRuleCall_1_0 = (RuleCall)cPropertyNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cIndexAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cIndexExpressionParserRuleCall_2_1_0 = (RuleCall)cIndexAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Assignment cSuffixAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_3_0 = (RuleCall)cSuffixAssignment_3.eContents().get(0);
		
		//// OperationCallExpressionWithoutDot :
		//// 	operationName = ID tuple = Tuple (suffix = SuffixExpression)?
		//// ;
		//PropertyCallExpression:
		//	"." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"."
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }

		//propertyName=ID
		public Assignment getPropertyNameAssignment_1() { return cPropertyNameAssignment_1; }

		//ID
		public RuleCall getPropertyNameIDTerminalRuleCall_1_0() { return cPropertyNameIDTerminalRuleCall_1_0; }

		//("[" index=Expression "]")?
		public Group getGroup_2() { return cGroup_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_0() { return cLeftSquareBracketKeyword_2_0; }

		//index=Expression
		public Assignment getIndexAssignment_2_1() { return cIndexAssignment_2_1; }

		//Expression
		public RuleCall getIndexExpressionParserRuleCall_2_1_0() { return cIndexExpressionParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_2() { return cRightSquareBracketKeyword_2_2; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_3() { return cSuffixAssignment_3; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_3_0() { return cSuffixSuffixExpressionParserRuleCall_3_0; }
	}

	public class LinkOperationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LinkOperationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFullStopKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindLinkOperationKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Assignment cTupleAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTupleLinkOperationTupleParserRuleCall_2_0 = (RuleCall)cTupleAssignment_2.eContents().get(0);
		
		//LinkOperationExpression:
		//	"." kind=LinkOperationKind tuple=LinkOperationTuple;
		public ParserRule getRule() { return rule; }

		//"." kind=LinkOperationKind tuple=LinkOperationTuple
		public Group getGroup() { return cGroup; }

		//"."
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }

		//kind=LinkOperationKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }

		//LinkOperationKind
		public RuleCall getKindLinkOperationKindEnumRuleCall_1_0() { return cKindLinkOperationKindEnumRuleCall_1_0; }

		//tuple=LinkOperationTuple
		public Assignment getTupleAssignment_2() { return cTupleAssignment_2; }

		//LinkOperationTuple
		public RuleCall getTupleLinkOperationTupleParserRuleCall_2_0() { return cTupleLinkOperationTupleParserRuleCall_2_0; }
	}

	public class LinkOperationTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LinkOperationTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLinkOperationTupleElementAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_1_0 = (RuleCall)cLinkOperationTupleElementAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cLinkOperationTupleElementAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_2_1_0 = (RuleCall)cLinkOperationTupleElementAssignment_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//LinkOperationTuple:
		//	"(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)*
		//	")";
		public ParserRule getRule() { return rule; }

		//"(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)* ")"
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//linkOperationTupleElement+=LinkOperationTupleElement
		public Assignment getLinkOperationTupleElementAssignment_1() { return cLinkOperationTupleElementAssignment_1; }

		//LinkOperationTupleElement
		public RuleCall getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_1_0() { return cLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_1_0; }

		//("," linkOperationTupleElement+=LinkOperationTupleElement)*
		public Group getGroup_2() { return cGroup_2; }

		//","
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//linkOperationTupleElement+=LinkOperationTupleElement
		public Assignment getLinkOperationTupleElementAssignment_2_1() { return cLinkOperationTupleElementAssignment_2_1; }

		//LinkOperationTupleElement
		public RuleCall getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_2_1_0() { return cLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class LinkOperationTupleElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LinkOperationTupleElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRoleAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cRoleIDTerminalRuleCall_0_0 = (RuleCall)cRoleAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cRoleIndexAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRoleIndexExpressionParserRuleCall_1_1_0 = (RuleCall)cRoleIndexAssignment_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Keyword cEqualsSignGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cObjectAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cObjectExpressionParserRuleCall_3_0 = (RuleCall)cObjectAssignment_3.eContents().get(0);
		
		////LinkOperationTupleElement :
		////	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
		////;
		//LinkOperationTupleElement:
		//	role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression;
		public ParserRule getRule() { return rule; }

		//role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression
		public Group getGroup() { return cGroup; }

		//role=ID
		public Assignment getRoleAssignment_0() { return cRoleAssignment_0; }

		//ID
		public RuleCall getRoleIDTerminalRuleCall_0_0() { return cRoleIDTerminalRuleCall_0_0; }

		//("[" roleIndex=Expression "]")?
		public Group getGroup_1() { return cGroup_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1_0() { return cLeftSquareBracketKeyword_1_0; }

		//roleIndex=Expression
		public Assignment getRoleIndexAssignment_1_1() { return cRoleIndexAssignment_1_1; }

		//Expression
		public RuleCall getRoleIndexExpressionParserRuleCall_1_1_0() { return cRoleIndexExpressionParserRuleCall_1_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1_2() { return cRightSquareBracketKeyword_1_2; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_2() { return cEqualsSignGreaterThanSignKeyword_2; }

		//object=Expression
		public Assignment getObjectAssignment_3() { return cObjectAssignment_3; }

		//Expression
		public RuleCall getObjectExpressionParserRuleCall_3_0() { return cObjectExpressionParserRuleCall_3_0; }
	}

	public class SequenceOperationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceOperationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOperationNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOperationNameQualifiedNameWithBindingParserRuleCall_1_0 = (RuleCall)cOperationNameAssignment_1.eContents().get(0);
		private final Assignment cTupleAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTupleTupleParserRuleCall_2_0 = (RuleCall)cTupleAssignment_2.eContents().get(0);
		private final Assignment cSuffixAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_3_0 = (RuleCall)cSuffixAssignment_3.eContents().get(0);
		
		//SequenceOperationExpression: //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
		//	"->" operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		////'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
		//"->" operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		////'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//operationName=QualifiedNameWithBinding
		public Assignment getOperationNameAssignment_1() { return cOperationNameAssignment_1; }

		//QualifiedNameWithBinding
		public RuleCall getOperationNameQualifiedNameWithBindingParserRuleCall_1_0() { return cOperationNameQualifiedNameWithBindingParserRuleCall_1_0; }

		//tuple=Tuple
		public Assignment getTupleAssignment_2() { return cTupleAssignment_2; }

		//Tuple
		public RuleCall getTupleTupleParserRuleCall_2_0() { return cTupleTupleParserRuleCall_2_0; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_3() { return cSuffixAssignment_3; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_3_0() { return cSuffixSuffixExpressionParserRuleCall_3_0; }
	}

	public class SequenceReductionExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceReductionExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cReduceKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIsOrderedAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cIsOrderedOrderedKeyword_2_0 = (Keyword)cIsOrderedAssignment_2.eContents().get(0);
		private final Assignment cBehaviorAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBehaviorQualifiedNameWithBindingParserRuleCall_3_0 = (RuleCall)cBehaviorAssignment_3.eContents().get(0);
		private final Assignment cSuffixAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_4_0 = (RuleCall)cSuffixAssignment_4.eContents().get(0);
		
		//SequenceReductionExpression:
		//	"->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//"reduce"
		public Keyword getReduceKeyword_1() { return cReduceKeyword_1; }

		//isOrdered?="ordered"?
		public Assignment getIsOrderedAssignment_2() { return cIsOrderedAssignment_2; }

		//"ordered"
		public Keyword getIsOrderedOrderedKeyword_2_0() { return cIsOrderedOrderedKeyword_2_0; }

		//behavior=QualifiedNameWithBinding
		public Assignment getBehaviorAssignment_3() { return cBehaviorAssignment_3; }

		//QualifiedNameWithBinding
		public RuleCall getBehaviorQualifiedNameWithBindingParserRuleCall_3_0() { return cBehaviorQualifiedNameWithBindingParserRuleCall_3_0; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_4() { return cSuffixAssignment_4; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_4_0() { return cSuffixSuffixExpressionParserRuleCall_4_0; }
	}

	public class SequenceExpansionExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceExpansionExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSelectOrRejectOperationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCollectOrIterateOperationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cForAllOrExistsOrOneOperationParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cIsUniqueOperationParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//SequenceExpansionExpression:
		//	SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation;
		public ParserRule getRule() { return rule; }

		//SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation
		public Alternatives getAlternatives() { return cAlternatives; }

		//SelectOrRejectOperation
		public RuleCall getSelectOrRejectOperationParserRuleCall_0() { return cSelectOrRejectOperationParserRuleCall_0; }

		//CollectOrIterateOperation
		public RuleCall getCollectOrIterateOperationParserRuleCall_1() { return cCollectOrIterateOperationParserRuleCall_1; }

		//ForAllOrExistsOrOneOperation
		public RuleCall getForAllOrExistsOrOneOperationParserRuleCall_2() { return cForAllOrExistsOrOneOperationParserRuleCall_2; }

		//IsUniqueOperation
		public RuleCall getIsUniqueOperationParserRuleCall_3() { return cIsUniqueOperationParserRuleCall_3; }
	}

	public class SelectOrRejectOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SelectOrRejectOperation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOpAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOpSelectOrRejectOperatorEnumRuleCall_1_0 = (RuleCall)cOpAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cExprAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExprExpressionParserRuleCall_4_0 = (RuleCall)cExprAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cSuffixAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_6_0 = (RuleCall)cSuffixAssignment_6.eContents().get(0);
		
		//SelectOrRejectOperation:
		//	"->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//op=SelectOrRejectOperator
		public Assignment getOpAssignment_1() { return cOpAssignment_1; }

		//SelectOrRejectOperator
		public RuleCall getOpSelectOrRejectOperatorEnumRuleCall_1_0() { return cOpSelectOrRejectOperatorEnumRuleCall_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//expr=Expression
		public Assignment getExprAssignment_4() { return cExprAssignment_4; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_4_0() { return cExprExpressionParserRuleCall_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_6() { return cSuffixAssignment_6; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_6_0() { return cSuffixSuffixExpressionParserRuleCall_6_0; }
	}

	public class CollectOrIterateOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CollectOrIterateOperation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOpAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOpCollectOrIterateOperatorEnumRuleCall_1_0 = (RuleCall)cOpAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cExprAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExprExpressionParserRuleCall_4_0 = (RuleCall)cExprAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cSuffixAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_6_0 = (RuleCall)cSuffixAssignment_6.eContents().get(0);
		
		//CollectOrIterateOperation:
		//	"->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//op=CollectOrIterateOperator
		public Assignment getOpAssignment_1() { return cOpAssignment_1; }

		//CollectOrIterateOperator
		public RuleCall getOpCollectOrIterateOperatorEnumRuleCall_1_0() { return cOpCollectOrIterateOperatorEnumRuleCall_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//expr=Expression
		public Assignment getExprAssignment_4() { return cExprAssignment_4; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_4_0() { return cExprExpressionParserRuleCall_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_6() { return cSuffixAssignment_6; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_6_0() { return cSuffixSuffixExpressionParserRuleCall_6_0; }
	}

	public class ForAllOrExistsOrOneOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ForAllOrExistsOrOneOperation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOpAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0 = (RuleCall)cOpAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cExprAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExprExpressionParserRuleCall_4_0 = (RuleCall)cExprAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cSuffixAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_6_0 = (RuleCall)cSuffixAssignment_6.eContents().get(0);
		
		//ForAllOrExistsOrOneOperation:
		//	"->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//op=ForAllOrExistsOrOneOperator
		public Assignment getOpAssignment_1() { return cOpAssignment_1; }

		//ForAllOrExistsOrOneOperator
		public RuleCall getOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0() { return cOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//expr=Expression
		public Assignment getExprAssignment_4() { return cExprAssignment_4; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_4_0() { return cExprExpressionParserRuleCall_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_6() { return cSuffixAssignment_6; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_6_0() { return cSuffixSuffixExpressionParserRuleCall_6_0; }
	}

	public class IsUniqueOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IsUniqueOperation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cIsUniqueKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cExprAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExprExpressionParserRuleCall_4_0 = (RuleCall)cExprAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cSuffixAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_6_0 = (RuleCall)cSuffixAssignment_6.eContents().get(0);
		
		//IsUniqueOperation:
		//	"->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//"->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//"isUnique"
		public Keyword getIsUniqueKeyword_1() { return cIsUniqueKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//expr=Expression
		public Assignment getExprAssignment_4() { return cExprAssignment_4; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_4_0() { return cExprExpressionParserRuleCall_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_6() { return cSuffixAssignment_6; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_6_0() { return cSuffixSuffixExpressionParserRuleCall_6_0; }
	}

	public class ValueSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ValueSpecification");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNameExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLITERALParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cThisExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSuperInvocationExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cInstanceCreationExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cParenthesizedExpressionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cNullExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//ValueSpecification:
		//	NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
		//	ParenthesizedExpression | NullExpression;
		public ParserRule getRule() { return rule; }

		//NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
		//ParenthesizedExpression | NullExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//NameExpression
		public RuleCall getNameExpressionParserRuleCall_0() { return cNameExpressionParserRuleCall_0; }

		//LITERAL
		public RuleCall getLITERALParserRuleCall_1() { return cLITERALParserRuleCall_1; }

		//ThisExpression
		public RuleCall getThisExpressionParserRuleCall_2() { return cThisExpressionParserRuleCall_2; }

		//SuperInvocationExpression
		public RuleCall getSuperInvocationExpressionParserRuleCall_3() { return cSuperInvocationExpressionParserRuleCall_3; }

		//InstanceCreationExpression
		public RuleCall getInstanceCreationExpressionParserRuleCall_4() { return cInstanceCreationExpressionParserRuleCall_4; }

		//ParenthesizedExpression
		public RuleCall getParenthesizedExpressionParserRuleCall_5() { return cParenthesizedExpressionParserRuleCall_5; }

		//NullExpression
		public RuleCall getNullExpressionParserRuleCall_6() { return cNullExpressionParserRuleCall_6; }
	}

	public class NonLiteralValueSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NonLiteralValueSpecification");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNameExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cParenthesizedExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cInstanceCreationExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cThisExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cSuperInvocationExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//NonLiteralValueSpecification:
		//	NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression;
		public ParserRule getRule() { return rule; }

		//NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//NameExpression
		public RuleCall getNameExpressionParserRuleCall_0() { return cNameExpressionParserRuleCall_0; }

		//ParenthesizedExpression
		public RuleCall getParenthesizedExpressionParserRuleCall_1() { return cParenthesizedExpressionParserRuleCall_1; }

		//InstanceCreationExpression
		public RuleCall getInstanceCreationExpressionParserRuleCall_2() { return cInstanceCreationExpressionParserRuleCall_2; }

		//ThisExpression
		public RuleCall getThisExpressionParserRuleCall_3() { return cThisExpressionParserRuleCall_3; }

		//SuperInvocationExpression
		public RuleCall getSuperInvocationExpressionParserRuleCall_4() { return cSuperInvocationExpressionParserRuleCall_4; }
	}

	public class ParenthesizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ParenthesizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpOrTypeCastAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpOrTypeCastExpressionParserRuleCall_1_0 = (RuleCall)cExpOrTypeCastAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cCastedAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cCastedNonLiteralValueSpecificationParserRuleCall_3_0_0 = (RuleCall)cCastedAssignment_3_0.eContents().get(0);
		private final Assignment cSuffixAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_3_1_0 = (RuleCall)cSuffixAssignment_3_1.eContents().get(0);
		
		//ParenthesizedExpression:
		//	"(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?;
		public ParserRule getRule() { return rule; }

		//"(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//expOrTypeCast=Expression
		public Assignment getExpOrTypeCastAssignment_1() { return cExpOrTypeCastAssignment_1; }

		//Expression
		public RuleCall getExpOrTypeCastExpressionParserRuleCall_1_0() { return cExpOrTypeCastExpressionParserRuleCall_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }

		//(casted=NonLiteralValueSpecification | suffix=SuffixExpression)?
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//casted=NonLiteralValueSpecification
		public Assignment getCastedAssignment_3_0() { return cCastedAssignment_3_0; }

		//NonLiteralValueSpecification
		public RuleCall getCastedNonLiteralValueSpecificationParserRuleCall_3_0_0() { return cCastedNonLiteralValueSpecificationParserRuleCall_3_0_0; }

		//suffix=SuffixExpression
		public Assignment getSuffixAssignment_3_1() { return cSuffixAssignment_3_1; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_3_1_0() { return cSuffixSuffixExpressionParserRuleCall_3_1_0; }
	}

	public class NullExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NullExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNullExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//NullExpression:
		//	{NullExpression} "null";
		public ParserRule getRule() { return rule; }

		//{NullExpression} "null"
		public Group getGroup() { return cGroup; }

		//{NullExpression}
		public Action getNullExpressionAction_0() { return cNullExpressionAction_0; }

		//"null"
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}

	public class ThisExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ThisExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cThisExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cThisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cSuffixAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_2_0 = (RuleCall)cSuffixAssignment_2.eContents().get(0);
		
		//ThisExpression:
		//	{ThisExpression} "this" suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		//{ThisExpression} "this" suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		//{ThisExpression}
		public Action getThisExpressionAction_0() { return cThisExpressionAction_0; }

		//"this"
		public Keyword getThisKeyword_1() { return cThisKeyword_1; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_2() { return cSuffixAssignment_2; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_2_0() { return cSuffixSuffixExpressionParserRuleCall_2_0; }
	}

	public class SuperInvocationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SuperInvocationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSuperKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cTupleAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cTupleTupleParserRuleCall_1_0_0 = (RuleCall)cTupleAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cFullStopKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cOperationNameAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cOperationNameQualifiedNameWithBindingParserRuleCall_1_1_1_0 = (RuleCall)cOperationNameAssignment_1_1_1.eContents().get(0);
		private final Assignment cTupleAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cTupleTupleParserRuleCall_1_1_2_0 = (RuleCall)cTupleAssignment_1_1_2.eContents().get(0);
		
		//// SuperInvocationExpression :
		////	//{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
		////	'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression) 
		////;
		//SuperInvocationExpression: //{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
		////'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
		////'super' ((tuple = Tuple) |
		////		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
		//	"super" (tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple);
		public ParserRule getRule() { return rule; }

		////{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
		////'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
		////'super' ((tuple = Tuple) |
		////		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
		//"super" (tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple)
		public Group getGroup() { return cGroup; }

		////{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
		////'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
		////'super' ((tuple = Tuple) |
		////		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
		//"super"
		public Keyword getSuperKeyword_0() { return cSuperKeyword_0; }

		//tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//tuple=Tuple
		public Assignment getTupleAssignment_1_0() { return cTupleAssignment_1_0; }

		//Tuple
		public RuleCall getTupleTupleParserRuleCall_1_0_0() { return cTupleTupleParserRuleCall_1_0_0; }

		//"." operationName=QualifiedNameWithBinding tuple=Tuple
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"."
		public Keyword getFullStopKeyword_1_1_0() { return cFullStopKeyword_1_1_0; }

		//operationName=QualifiedNameWithBinding
		public Assignment getOperationNameAssignment_1_1_1() { return cOperationNameAssignment_1_1_1; }

		//QualifiedNameWithBinding
		public RuleCall getOperationNameQualifiedNameWithBindingParserRuleCall_1_1_1_0() { return cOperationNameQualifiedNameWithBindingParserRuleCall_1_1_1_0; }

		//tuple=Tuple
		public Assignment getTupleAssignment_1_1_2() { return cTupleAssignment_1_1_2; }

		//Tuple
		public RuleCall getTupleTupleParserRuleCall_1_1_2_0() { return cTupleTupleParserRuleCall_1_1_2_0; }
	}

	public class InstanceCreationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceCreationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNewKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConstructorAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConstructorQualifiedNameWithBindingParserRuleCall_1_0 = (RuleCall)cConstructorAssignment_1.eContents().get(0);
		private final Assignment cTupleAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTupleInstanceCreationTupleParserRuleCall_2_0 = (RuleCall)cTupleAssignment_2.eContents().get(0);
		private final Assignment cSuffixAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSuffixSuffixExpressionParserRuleCall_3_0 = (RuleCall)cSuffixAssignment_3.eContents().get(0);
		
		////InstanceCreationExpression :
		////'new' constructor=QualifiedNameWithBinding 
		////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
		////'new' constructor=QualifiedNameWithBinding 
		////	tuple = Tuple (suffix = SuffixExpression) ?
		////;
		//InstanceCreationExpression: //'new' constructor=QualifiedNameWithBinding 
		////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
		//	"new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?;
		public ParserRule getRule() { return rule; }

		////'new' constructor=QualifiedNameWithBinding 
		////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
		//"new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?
		public Group getGroup() { return cGroup; }

		////'new' constructor=QualifiedNameWithBinding 
		////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
		//"new"
		public Keyword getNewKeyword_0() { return cNewKeyword_0; }

		//constructor=QualifiedNameWithBinding
		public Assignment getConstructorAssignment_1() { return cConstructorAssignment_1; }

		//QualifiedNameWithBinding
		public RuleCall getConstructorQualifiedNameWithBindingParserRuleCall_1_0() { return cConstructorQualifiedNameWithBindingParserRuleCall_1_0; }

		//tuple=InstanceCreationTuple
		public Assignment getTupleAssignment_2() { return cTupleAssignment_2; }

		//InstanceCreationTuple
		public RuleCall getTupleInstanceCreationTupleParserRuleCall_2_0() { return cTupleInstanceCreationTupleParserRuleCall_2_0; }

		//suffix=SuffixExpression?
		public Assignment getSuffixAssignment_3() { return cSuffixAssignment_3; }

		//SuffixExpression
		public RuleCall getSuffixSuffixExpressionParserRuleCall_3_0() { return cSuffixSuffixExpressionParserRuleCall_3_0; }
	}

	public class InstanceCreationTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceCreationTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInstanceCreationTupleAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cInstanceCreationTupleElementAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_0_0 = (RuleCall)cInstanceCreationTupleElementAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cInstanceCreationTupleElementAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_1_1_0 = (RuleCall)cInstanceCreationTupleElementAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//InstanceCreationTuple:
		//	{InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
		//	instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")";
		public ParserRule getRule() { return rule; }

		//{InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
		//instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")"
		public Group getGroup() { return cGroup; }

		//{InstanceCreationTuple}
		public Action getInstanceCreationTupleAction_0() { return cInstanceCreationTupleAction_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(instanceCreationTupleElement+=InstanceCreationTupleElement (","
		//instanceCreationTupleElement+=InstanceCreationTupleElement)*)?
		public Group getGroup_2() { return cGroup_2; }

		//instanceCreationTupleElement+=InstanceCreationTupleElement
		public Assignment getInstanceCreationTupleElementAssignment_2_0() { return cInstanceCreationTupleElementAssignment_2_0; }

		//InstanceCreationTupleElement
		public RuleCall getInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_0_0() { return cInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_0_0; }

		//("," instanceCreationTupleElement+=InstanceCreationTupleElement)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//instanceCreationTupleElement+=InstanceCreationTupleElement
		public Assignment getInstanceCreationTupleElementAssignment_2_1_1() { return cInstanceCreationTupleElementAssignment_2_1_1; }

		//InstanceCreationTupleElement
		public RuleCall getInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_1_1_0() { return cInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class InstanceCreationTupleElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceCreationTupleElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRoleAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cRoleIDTerminalRuleCall_0_0 = (RuleCall)cRoleAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cObjectAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cObjectExpressionParserRuleCall_2_0 = (RuleCall)cObjectAssignment_2.eContents().get(0);
		
		////LinkOperationTupleElement :
		////	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
		////;
		//InstanceCreationTupleElement:
		//	role=ID "=>" object=Expression;
		public ParserRule getRule() { return rule; }

		//role=ID "=>" object=Expression
		public Group getGroup() { return cGroup; }

		//role=ID
		public Assignment getRoleAssignment_0() { return cRoleAssignment_0; }

		//ID
		public RuleCall getRoleIDTerminalRuleCall_0_0() { return cRoleIDTerminalRuleCall_0_0; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//object=Expression
		public Assignment getObjectAssignment_2() { return cObjectAssignment_2; }

		//Expression
		public RuleCall getObjectExpressionParserRuleCall_2_0() { return cObjectExpressionParserRuleCall_2_0; }
	}

	public class SequenceConstructionOrAccessCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceConstructionOrAccessCompletion");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cMultiplicityIndicatorAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final Keyword cMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0 = (Keyword)cMultiplicityIndicatorAssignment_0_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Assignment cAccessCompletionAssignment_0_1_0 = (Assignment)cAlternatives_0_1.eContents().get(0);
		private final RuleCall cAccessCompletionAccessCompletionParserRuleCall_0_1_0_0 = (RuleCall)cAccessCompletionAssignment_0_1_0.eContents().get(0);
		private final Assignment cSequenceCompletionAssignment_0_1_1 = (Assignment)cAlternatives_0_1.eContents().get(1);
		private final RuleCall cSequenceCompletionPartialSequenceConstructionCompletionParserRuleCall_0_1_1_0 = (RuleCall)cSequenceCompletionAssignment_0_1_1.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cExpressionSequenceConstructionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		
		//SequenceConstructionOrAccessCompletion:
		//	multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
		//	sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression;
		public ParserRule getRule() { return rule; }

		//multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
		//sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
		//sequenceCompletion=PartialSequenceConstructionCompletion)
		public Group getGroup_0() { return cGroup_0; }

		//multiplicityIndicator?="["
		public Assignment getMultiplicityIndicatorAssignment_0_0() { return cMultiplicityIndicatorAssignment_0_0; }

		//"["
		public Keyword getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0() { return cMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0; }

		//accessCompletion=AccessCompletion | sequenceCompletion=PartialSequenceConstructionCompletion
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//accessCompletion=AccessCompletion
		public Assignment getAccessCompletionAssignment_0_1_0() { return cAccessCompletionAssignment_0_1_0; }

		//AccessCompletion
		public RuleCall getAccessCompletionAccessCompletionParserRuleCall_0_1_0_0() { return cAccessCompletionAccessCompletionParserRuleCall_0_1_0_0; }

		//sequenceCompletion=PartialSequenceConstructionCompletion
		public Assignment getSequenceCompletionAssignment_0_1_1() { return cSequenceCompletionAssignment_0_1_1; }

		//PartialSequenceConstructionCompletion
		public RuleCall getSequenceCompletionPartialSequenceConstructionCompletionParserRuleCall_0_1_1_0() { return cSequenceCompletionPartialSequenceConstructionCompletionParserRuleCall_0_1_1_0; }

		//expression=SequenceConstructionExpression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//SequenceConstructionExpression
		public RuleCall getExpressionSequenceConstructionExpressionParserRuleCall_1_0() { return cExpressionSequenceConstructionExpressionParserRuleCall_1_0; }
	}

	public class AccessCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AccessCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAccessIndexAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAccessIndexExpressionParserRuleCall_0_0 = (RuleCall)cAccessIndexAssignment_0.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//AccessCompletion:
		//	accessIndex=Expression "]";
		public ParserRule getRule() { return rule; }

		//accessIndex=Expression "]"
		public Group getGroup() { return cGroup; }

		//accessIndex=Expression
		public Assignment getAccessIndexAssignment_0() { return cAccessIndexAssignment_0; }

		//Expression
		public RuleCall getAccessIndexExpressionParserRuleCall_0_0() { return cAccessIndexExpressionParserRuleCall_0_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1() { return cRightSquareBracketKeyword_1; }
	}

	public class PartialSequenceConstructionCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PartialSequenceConstructionCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionSequenceConstructionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		
		//PartialSequenceConstructionCompletion:
		//	"]" expression=SequenceConstructionExpression;
		public ParserRule getRule() { return rule; }

		//"]" expression=SequenceConstructionExpression
		public Group getGroup() { return cGroup; }

		//"]"
		public Keyword getRightSquareBracketKeyword_0() { return cRightSquareBracketKeyword_0; }

		//expression=SequenceConstructionExpression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//SequenceConstructionExpression
		public RuleCall getExpressionSequenceConstructionExpressionParserRuleCall_1_0() { return cExpressionSequenceConstructionExpressionParserRuleCall_1_0; }
	}

	public class SequenceConstructionExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceConstructionExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSequenceElementAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSequenceElementSequenceElementParserRuleCall_1_0 = (RuleCall)cSequenceElementAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Keyword cCommaKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Assignment cSequenceElementAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cSequenceElementSequenceElementParserRuleCall_2_0_1_0 = (RuleCall)cSequenceElementAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cRangeUpperAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cRangeUpperExpressionParserRuleCall_2_1_1_0 = (RuleCall)cRangeUpperAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		////SequenceConstructionCompletion :
		////	(multiplicityIndicator ?= '['']')? expression = SequenceConstructionExpression
		////;
		//SequenceConstructionExpression:
		//	"{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}";
		public ParserRule getRule() { return rule; }

		//"{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//sequenceElement+=SequenceElement
		public Assignment getSequenceElementAssignment_1() { return cSequenceElementAssignment_1; }

		//SequenceElement
		public RuleCall getSequenceElementSequenceElementParserRuleCall_1_0() { return cSequenceElementSequenceElementParserRuleCall_1_0; }

		//("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//("," sequenceElement+=SequenceElement)*
		public Group getGroup_2_0() { return cGroup_2_0; }

		//","
		public Keyword getCommaKeyword_2_0_0() { return cCommaKeyword_2_0_0; }

		//sequenceElement+=SequenceElement
		public Assignment getSequenceElementAssignment_2_0_1() { return cSequenceElementAssignment_2_0_1; }

		//SequenceElement
		public RuleCall getSequenceElementSequenceElementParserRuleCall_2_0_1_0() { return cSequenceElementSequenceElementParserRuleCall_2_0_1_0; }

		//".." rangeUpper=Expression
		public Group getGroup_2_1() { return cGroup_2_1; }

		//".."
		public Keyword getFullStopFullStopKeyword_2_1_0() { return cFullStopFullStopKeyword_2_1_0; }

		//rangeUpper=Expression
		public Assignment getRangeUpperAssignment_2_1_1() { return cRangeUpperAssignment_2_1_1; }

		//Expression
		public RuleCall getRangeUpperExpressionParserRuleCall_2_1_1_0() { return cRangeUpperExpressionParserRuleCall_2_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class SequenceElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequenceElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSequenceConstructionExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//SequenceElement:
		//	Expression | SequenceConstructionExpression;
		public ParserRule getRule() { return rule; }

		//Expression | SequenceConstructionExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//Expression
		public RuleCall getExpressionParserRuleCall_0() { return cExpressionParserRuleCall_0; }

		//SequenceConstructionExpression
		public RuleCall getSequenceConstructionExpressionParserRuleCall_1() { return cSequenceConstructionExpressionParserRuleCall_1; }
	}

	public class ClassExtentExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassExtentExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cClassExtentExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cAllInstancesKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//ClassExtentExpression:
		//	{ClassExtentExpression} "." "allInstances" "(" ")";
		public ParserRule getRule() { return rule; }

		//{ClassExtentExpression} "." "allInstances" "(" ")"
		public Group getGroup() { return cGroup; }

		//{ClassExtentExpression}
		public Action getClassExtentExpressionAction_0() { return cClassExtentExpressionAction_0; }

		//"."
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//"allInstances"
		public Keyword getAllInstancesKeyword_2() { return cAllInstancesKeyword_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class BlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Block");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cBlockAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cSequenceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cSequenceStatementSequenceParserRuleCall_2_0 = (RuleCall)cSequenceAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		/// *****************
		// * Statements
		// **************** / Block:
		//	"{" {Block} sequence=StatementSequence? "}";
		public ParserRule getRule() { return rule; }

		//"{" {Block} sequence=StatementSequence? "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//{Block}
		public Action getBlockAction_1() { return cBlockAction_1; }

		//sequence=StatementSequence?
		public Assignment getSequenceAssignment_2() { return cSequenceAssignment_2; }

		//StatementSequence
		public RuleCall getSequenceStatementSequenceParserRuleCall_2_0() { return cSequenceStatementSequenceParserRuleCall_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class StatementSequenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StatementSequence");
		private final Assignment cStatementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cStatementsDocumentedStatementParserRuleCall_0 = (RuleCall)cStatementsAssignment.eContents().get(0);
		
		//StatementSequence:
		//	statements+=DocumentedStatement+;
		public ParserRule getRule() { return rule; }

		//statements+=DocumentedStatement+
		public Assignment getStatementsAssignment() { return cStatementsAssignment; }

		//DocumentedStatement
		public RuleCall getStatementsDocumentedStatementParserRuleCall_0() { return cStatementsDocumentedStatementParserRuleCall_0; }
	}

	public class DocumentedStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DocumentedStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCommentAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cCommentAlternatives_0_0 = (Alternatives)cCommentAssignment_0.eContents().get(0);
		private final RuleCall cCommentML_COMMENTTerminalRuleCall_0_0_0 = (RuleCall)cCommentAlternatives_0_0.eContents().get(0);
		private final RuleCall cCommentSL_COMMENTTerminalRuleCall_0_0_1 = (RuleCall)cCommentAlternatives_0_0.eContents().get(1);
		private final Assignment cStatementAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStatementStatementParserRuleCall_1_0 = (RuleCall)cStatementAssignment_1.eContents().get(0);
		
		//DocumentedStatement:
		//	comment=(ML_COMMENT | SL_COMMENT)? statement=Statement;
		public ParserRule getRule() { return rule; }

		//comment=(ML_COMMENT | SL_COMMENT)? statement=Statement
		public Group getGroup() { return cGroup; }

		//comment=(ML_COMMENT | SL_COMMENT)?
		public Assignment getCommentAssignment_0() { return cCommentAssignment_0; }

		//ML_COMMENT | SL_COMMENT
		public Alternatives getCommentAlternatives_0_0() { return cCommentAlternatives_0_0; }

		//ML_COMMENT
		public RuleCall getCommentML_COMMENTTerminalRuleCall_0_0_0() { return cCommentML_COMMENTTerminalRuleCall_0_0_0; }

		//SL_COMMENT
		public RuleCall getCommentSL_COMMENTTerminalRuleCall_0_0_1() { return cCommentSL_COMMENTTerminalRuleCall_0_0_1; }

		//statement=Statement
		public Assignment getStatementAssignment_1() { return cStatementAssignment_1; }

		//Statement
		public RuleCall getStatementStatementParserRuleCall_1_0() { return cStatementStatementParserRuleCall_1_0; }
	}

	public class InlineStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InlineStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSolidusAsteriskCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cInlineKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cLangageNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cLangageNameIDTerminalRuleCall_3_0 = (RuleCall)cLangageNameAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cBodyAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cBodySTRINGTerminalRuleCall_5_0 = (RuleCall)cBodyAssignment_5.eContents().get(0);
		private final Keyword cAsteriskSolidusKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//InlineStatement:
		//	"/ *@" "inline" "(" langageName=ID ")" body=STRING "* /";
		public ParserRule getRule() { return rule; }

		//"/ *@" "inline" "(" langageName=ID ")" body=STRING "* /"
		public Group getGroup() { return cGroup; }

		//"/ *@"
		public Keyword getSolidusAsteriskCommercialAtKeyword_0() { return cSolidusAsteriskCommercialAtKeyword_0; }

		//"inline"
		public Keyword getInlineKeyword_1() { return cInlineKeyword_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//langageName=ID
		public Assignment getLangageNameAssignment_3() { return cLangageNameAssignment_3; }

		//ID
		public RuleCall getLangageNameIDTerminalRuleCall_3_0() { return cLangageNameIDTerminalRuleCall_3_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }

		//body=STRING
		public Assignment getBodyAssignment_5() { return cBodyAssignment_5; }

		//STRING
		public RuleCall getBodySTRINGTerminalRuleCall_5_0() { return cBodySTRINGTerminalRuleCall_5_0; }

		//"* /"
		public Keyword getAsteriskSolidusKeyword_6() { return cAsteriskSolidusKeyword_6; }
	}

	public class AnnotatedStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AnnotatedStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSolidusSolidusCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cAnnotationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationAssignment_1.eContents().get(0);
		private final Assignment cStatementAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatementStatementParserRuleCall_2_0 = (RuleCall)cStatementAssignment_2.eContents().get(0);
		
		//AnnotatedStatement:
		//	"//@" annotation= //block = Block
		//	Annotation statement=Statement;
		public ParserRule getRule() { return rule; }

		//"//@" annotation= //block = Block
		//Annotation statement=Statement
		public Group getGroup() { return cGroup; }

		//"//@"
		public Keyword getSolidusSolidusCommercialAtKeyword_0() { return cSolidusSolidusCommercialAtKeyword_0; }

		//annotation= //block = Block
		//Annotation
		public Assignment getAnnotationAssignment_1() { return cAnnotationAssignment_1; }

		////block = Block
		//Annotation
		public RuleCall getAnnotationAnnotationParserRuleCall_1_0() { return cAnnotationAnnotationParserRuleCall_1_0; }

		//statement=Statement
		public Assignment getStatementAssignment_2() { return cStatementAssignment_2; }

		//Statement
		public RuleCall getStatementStatementParserRuleCall_2_0() { return cStatementStatementParserRuleCall_2_0; }
	}

	public class StatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Statement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAnnotatedStatementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cInlineStatementParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBlockStatementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cEmptyStatementParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cLocalNameDeclarationStatementParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cIfStatementParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cSwitchStatementParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cWhileStatementParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cDoStatementParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cForStatementParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cBreakStatementParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cReturnStatementParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		private final RuleCall cAcceptStatementParserRuleCall_12 = (RuleCall)cAlternatives.eContents().get(12);
		private final RuleCall cClassifyStatementParserRuleCall_13 = (RuleCall)cAlternatives.eContents().get(13);
		private final RuleCall cInvocationOrAssignementOrDeclarationStatementParserRuleCall_14 = (RuleCall)cAlternatives.eContents().get(14);
		private final RuleCall cSuperInvocationStatementParserRuleCall_15 = (RuleCall)cAlternatives.eContents().get(15);
		private final RuleCall cThisInvocationStatementParserRuleCall_16 = (RuleCall)cAlternatives.eContents().get(16);
		private final RuleCall cInstanceCreationInvocationStatementParserRuleCall_17 = (RuleCall)cAlternatives.eContents().get(17);
		
		//Statement:
		//	AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement |
		//	SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement |
		//	ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement | ThisInvocationStatement
		//	| InstanceCreationInvocationStatement;
		public ParserRule getRule() { return rule; }

		//AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement |
		//SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement |
		//ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement | ThisInvocationStatement
		//| InstanceCreationInvocationStatement
		public Alternatives getAlternatives() { return cAlternatives; }

		//AnnotatedStatement
		public RuleCall getAnnotatedStatementParserRuleCall_0() { return cAnnotatedStatementParserRuleCall_0; }

		//InlineStatement
		public RuleCall getInlineStatementParserRuleCall_1() { return cInlineStatementParserRuleCall_1; }

		//BlockStatement
		public RuleCall getBlockStatementParserRuleCall_2() { return cBlockStatementParserRuleCall_2; }

		//EmptyStatement
		public RuleCall getEmptyStatementParserRuleCall_3() { return cEmptyStatementParserRuleCall_3; }

		//LocalNameDeclarationStatement
		public RuleCall getLocalNameDeclarationStatementParserRuleCall_4() { return cLocalNameDeclarationStatementParserRuleCall_4; }

		//IfStatement
		public RuleCall getIfStatementParserRuleCall_5() { return cIfStatementParserRuleCall_5; }

		//SwitchStatement
		public RuleCall getSwitchStatementParserRuleCall_6() { return cSwitchStatementParserRuleCall_6; }

		//WhileStatement
		public RuleCall getWhileStatementParserRuleCall_7() { return cWhileStatementParserRuleCall_7; }

		//DoStatement
		public RuleCall getDoStatementParserRuleCall_8() { return cDoStatementParserRuleCall_8; }

		//ForStatement
		public RuleCall getForStatementParserRuleCall_9() { return cForStatementParserRuleCall_9; }

		//BreakStatement
		public RuleCall getBreakStatementParserRuleCall_10() { return cBreakStatementParserRuleCall_10; }

		//ReturnStatement
		public RuleCall getReturnStatementParserRuleCall_11() { return cReturnStatementParserRuleCall_11; }

		//AcceptStatement
		public RuleCall getAcceptStatementParserRuleCall_12() { return cAcceptStatementParserRuleCall_12; }

		//ClassifyStatement
		public RuleCall getClassifyStatementParserRuleCall_13() { return cClassifyStatementParserRuleCall_13; }

		//InvocationOrAssignementOrDeclarationStatement
		public RuleCall getInvocationOrAssignementOrDeclarationStatementParserRuleCall_14() { return cInvocationOrAssignementOrDeclarationStatementParserRuleCall_14; }

		//SuperInvocationStatement
		public RuleCall getSuperInvocationStatementParserRuleCall_15() { return cSuperInvocationStatementParserRuleCall_15; }

		//ThisInvocationStatement
		public RuleCall getThisInvocationStatementParserRuleCall_16() { return cThisInvocationStatementParserRuleCall_16; }

		//InstanceCreationInvocationStatement
		public RuleCall getInstanceCreationInvocationStatementParserRuleCall_17() { return cInstanceCreationInvocationStatementParserRuleCall_17; }
	}

	public class AnnotationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Annotation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKindAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKindAnnotationKindEnumRuleCall_0_0 = (RuleCall)cKindAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgsIDTerminalRuleCall_1_1_0 = (RuleCall)cArgsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cArgsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cArgsIDTerminalRuleCall_1_2_1_0 = (RuleCall)cArgsAssignment_1_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		
		//Annotation:
		//	kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?;
		public ParserRule getRule() { return rule; }

		//kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?
		public Group getGroup() { return cGroup; }

		//kind=AnnotationKind
		public Assignment getKindAssignment_0() { return cKindAssignment_0; }

		//AnnotationKind
		public RuleCall getKindAnnotationKindEnumRuleCall_0_0() { return cKindAnnotationKindEnumRuleCall_0_0; }

		//("(" args+=ID ("," args+=ID)* ")")?
		public Group getGroup_1() { return cGroup_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//args+=ID
		public Assignment getArgsAssignment_1_1() { return cArgsAssignment_1_1; }

		//ID
		public RuleCall getArgsIDTerminalRuleCall_1_1_0() { return cArgsIDTerminalRuleCall_1_1_0; }

		//("," args+=ID)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//","
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//args+=ID
		public Assignment getArgsAssignment_1_2_1() { return cArgsAssignment_1_2_1; }

		//ID
		public RuleCall getArgsIDTerminalRuleCall_1_2_1_0() { return cArgsIDTerminalRuleCall_1_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_3() { return cRightParenthesisKeyword_1_3; }
	}

	public class BlockStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BlockStatement");
		private final Assignment cBlockAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_0 = (RuleCall)cBlockAssignment.eContents().get(0);
		
		//BlockStatement:
		//	block=Block;
		public ParserRule getRule() { return rule; }

		//block=Block
		public Assignment getBlockAssignment() { return cBlockAssignment; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_0() { return cBlockBlockParserRuleCall_0; }
	}

	public class EmptyStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EmptyStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEmptyStatementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//EmptyStatement:
		//	{EmptyStatement} ";";
		public ParserRule getRule() { return rule; }

		//{EmptyStatement} ";"
		public Group getGroup() { return cGroup; }

		//{EmptyStatement}
		public Action getEmptyStatementAction_0() { return cEmptyStatementAction_0; }

		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class LocalNameDeclarationStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LocalNameDeclarationStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cVarNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVarNameIDTerminalRuleCall_1_0 = (RuleCall)cVarNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeQualifiedNameWithBindingParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cMultiplicityIndicatorAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final Keyword cMultiplicityIndicatorLeftSquareBracketKeyword_4_0_0 = (Keyword)cMultiplicityIndicatorAssignment_4_0.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cInitAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cInitSequenceElementParserRuleCall_6_0 = (RuleCall)cInitAssignment_6.eContents().get(0);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//LocalNameDeclarationStatement:
		//	"let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
		//	"=" init=SequenceElement ";";
		public ParserRule getRule() { return rule; }

		//"let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
		//"=" init=SequenceElement ";"
		public Group getGroup() { return cGroup; }

		//"let"
		public Keyword getLetKeyword_0() { return cLetKeyword_0; }

		//varName=ID
		public Assignment getVarNameAssignment_1() { return cVarNameAssignment_1; }

		//ID
		public RuleCall getVarNameIDTerminalRuleCall_1_0() { return cVarNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//type=QualifiedNameWithBinding
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }

		//QualifiedNameWithBinding
		public RuleCall getTypeQualifiedNameWithBindingParserRuleCall_3_0() { return cTypeQualifiedNameWithBindingParserRuleCall_3_0; }

		//(multiplicityIndicator?="[" "]")?
		public Group getGroup_4() { return cGroup_4; }

		//multiplicityIndicator?="["
		public Assignment getMultiplicityIndicatorAssignment_4_0() { return cMultiplicityIndicatorAssignment_4_0; }

		//"["
		public Keyword getMultiplicityIndicatorLeftSquareBracketKeyword_4_0_0() { return cMultiplicityIndicatorLeftSquareBracketKeyword_4_0_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4_1() { return cRightSquareBracketKeyword_4_1; }

		////'=' init = Expression ';'
		//"="
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }

		//init=SequenceElement
		public Assignment getInitAssignment_6() { return cInitAssignment_6; }

		//SequenceElement
		public RuleCall getInitSequenceElementParserRuleCall_6_0() { return cInitSequenceElementParserRuleCall_6_0; }

		//";"
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}

	public class IfStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IfStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSequentialClaussesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSequentialClaussesSequentialClausesParserRuleCall_1_0 = (RuleCall)cSequentialClaussesAssignment_1.eContents().get(0);
		private final Assignment cFinalClauseAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFinalClauseFinalClauseParserRuleCall_2_0 = (RuleCall)cFinalClauseAssignment_2.eContents().get(0);
		
		//IfStatement:
		//	"if" sequentialClausses=SequentialClauses finalClause=FinalClause?;
		public ParserRule getRule() { return rule; }

		//"if" sequentialClausses=SequentialClauses finalClause=FinalClause?
		public Group getGroup() { return cGroup; }

		//"if"
		public Keyword getIfKeyword_0() { return cIfKeyword_0; }

		//sequentialClausses=SequentialClauses
		public Assignment getSequentialClaussesAssignment_1() { return cSequentialClaussesAssignment_1; }

		//SequentialClauses
		public RuleCall getSequentialClaussesSequentialClausesParserRuleCall_1_0() { return cSequentialClaussesSequentialClausesParserRuleCall_1_0; }

		//finalClause=FinalClause?
		public Assignment getFinalClauseAssignment_2() { return cFinalClauseAssignment_2; }

		//FinalClause
		public RuleCall getFinalClauseFinalClauseParserRuleCall_2_0() { return cFinalClauseFinalClauseParserRuleCall_2_0; }
	}

	public class SequentialClausesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SequentialClauses");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cConccurentClausesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cConccurentClausesConcurrentClausesParserRuleCall_0_0 = (RuleCall)cConccurentClausesAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cElseKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cIfKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cConccurentClausesAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cConccurentClausesConcurrentClausesParserRuleCall_1_2_0 = (RuleCall)cConccurentClausesAssignment_1_2.eContents().get(0);
		
		//SequentialClauses:
		//	conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*;
		public ParserRule getRule() { return rule; }

		//conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*
		public Group getGroup() { return cGroup; }

		//conccurentClauses+=ConcurrentClauses
		public Assignment getConccurentClausesAssignment_0() { return cConccurentClausesAssignment_0; }

		//ConcurrentClauses
		public RuleCall getConccurentClausesConcurrentClausesParserRuleCall_0_0() { return cConccurentClausesConcurrentClausesParserRuleCall_0_0; }

		//("else" "if" conccurentClauses+=ConcurrentClauses)*
		public Group getGroup_1() { return cGroup_1; }

		//"else"
		public Keyword getElseKeyword_1_0() { return cElseKeyword_1_0; }

		//"if"
		public Keyword getIfKeyword_1_1() { return cIfKeyword_1_1; }

		//conccurentClauses+=ConcurrentClauses
		public Assignment getConccurentClausesAssignment_1_2() { return cConccurentClausesAssignment_1_2; }

		//ConcurrentClauses
		public RuleCall getConccurentClausesConcurrentClausesParserRuleCall_1_2_0() { return cConccurentClausesConcurrentClausesParserRuleCall_1_2_0; }
	}

	public class ConcurrentClausesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConcurrentClauses");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNonFinalClauseAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNonFinalClauseNonFinalClauseParserRuleCall_0_0 = (RuleCall)cNonFinalClauseAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cOrKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cIfKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cNonFinalClauseAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cNonFinalClauseNonFinalClauseParserRuleCall_1_2_0 = (RuleCall)cNonFinalClauseAssignment_1_2.eContents().get(0);
		
		//ConcurrentClauses:
		//	nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*;
		public ParserRule getRule() { return rule; }

		//nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*
		public Group getGroup() { return cGroup; }

		//nonFinalClause+=NonFinalClause
		public Assignment getNonFinalClauseAssignment_0() { return cNonFinalClauseAssignment_0; }

		//NonFinalClause
		public RuleCall getNonFinalClauseNonFinalClauseParserRuleCall_0_0() { return cNonFinalClauseNonFinalClauseParserRuleCall_0_0; }

		//("or" "if" nonFinalClause+=NonFinalClause)*
		public Group getGroup_1() { return cGroup_1; }

		//"or"
		public Keyword getOrKeyword_1_0() { return cOrKeyword_1_0; }

		//"if"
		public Keyword getIfKeyword_1_1() { return cIfKeyword_1_1; }

		//nonFinalClause+=NonFinalClause
		public Assignment getNonFinalClauseAssignment_1_2() { return cNonFinalClauseAssignment_1_2; }

		//NonFinalClause
		public RuleCall getNonFinalClauseNonFinalClauseParserRuleCall_1_2_0() { return cNonFinalClauseNonFinalClauseParserRuleCall_1_2_0; }
	}

	public class NonFinalClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NonFinalClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConditionExpressionParserRuleCall_1_0 = (RuleCall)cConditionAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cBlockAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBlockBlockParserRuleCall_3_0 = (RuleCall)cBlockAssignment_3.eContents().get(0);
		
		//NonFinalClause:
		//	"(" condition=Expression ")" block=Block;
		public ParserRule getRule() { return rule; }

		//"(" condition=Expression ")" block=Block
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//condition=Expression
		public Assignment getConditionAssignment_1() { return cConditionAssignment_1; }

		//Expression
		public RuleCall getConditionExpressionParserRuleCall_1_0() { return cConditionExpressionParserRuleCall_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }

		//block=Block
		public Assignment getBlockAssignment_3() { return cBlockAssignment_3; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_3_0() { return cBlockBlockParserRuleCall_3_0; }
	}

	public class FinalClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FinalClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cElseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_1_0 = (RuleCall)cBlockAssignment_1.eContents().get(0);
		
		//FinalClause:
		//	"else" block=Block;
		public ParserRule getRule() { return rule; }

		//"else" block=Block
		public Group getGroup() { return cGroup; }

		//"else"
		public Keyword getElseKeyword_0() { return cElseKeyword_0; }

		//block=Block
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_1_0() { return cBlockBlockParserRuleCall_1_0; }
	}

	public class SwitchStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SwitchStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSwitchKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionExpressionParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSwitchClauseAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cSwitchClauseSwitchClauseParserRuleCall_5_0 = (RuleCall)cSwitchClauseAssignment_5.eContents().get(0);
		private final Assignment cDefaultClauseAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cDefaultClauseSwitchDefaultClauseParserRuleCall_6_0 = (RuleCall)cDefaultClauseAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//SwitchStatement:
		//	"switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}";
		public ParserRule getRule() { return rule; }

		//"switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}"
		public Group getGroup() { return cGroup; }

		//"switch"
		public Keyword getSwitchKeyword_0() { return cSwitchKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//expression=Expression
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_2_0() { return cExpressionExpressionParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//switchClause+=SwitchClause*
		public Assignment getSwitchClauseAssignment_5() { return cSwitchClauseAssignment_5; }

		//SwitchClause
		public RuleCall getSwitchClauseSwitchClauseParserRuleCall_5_0() { return cSwitchClauseSwitchClauseParserRuleCall_5_0; }

		//defaultClause=SwitchDefaultClause?
		public Assignment getDefaultClauseAssignment_6() { return cDefaultClauseAssignment_6; }

		//SwitchDefaultClause
		public RuleCall getDefaultClauseSwitchDefaultClauseParserRuleCall_6_0() { return cDefaultClauseSwitchDefaultClauseParserRuleCall_6_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}

	public class SwitchClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SwitchClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSwitchCaseAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSwitchCaseSwitchCaseParserRuleCall_0_0 = (RuleCall)cSwitchCaseAssignment_0.eContents().get(0);
		private final Assignment cSwitchCaseAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSwitchCaseSwitchCaseParserRuleCall_1_0 = (RuleCall)cSwitchCaseAssignment_1.eContents().get(0);
		private final Assignment cStatementSequenceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0 = (RuleCall)cStatementSequenceAssignment_2.eContents().get(0);
		
		//SwitchClause:
		//	switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence;
		public ParserRule getRule() { return rule; }

		//switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence
		public Group getGroup() { return cGroup; }

		//switchCase+=SwitchCase
		public Assignment getSwitchCaseAssignment_0() { return cSwitchCaseAssignment_0; }

		//SwitchCase
		public RuleCall getSwitchCaseSwitchCaseParserRuleCall_0_0() { return cSwitchCaseSwitchCaseParserRuleCall_0_0; }

		//switchCase+=SwitchCase*
		public Assignment getSwitchCaseAssignment_1() { return cSwitchCaseAssignment_1; }

		//SwitchCase
		public RuleCall getSwitchCaseSwitchCaseParserRuleCall_1_0() { return cSwitchCaseSwitchCaseParserRuleCall_1_0; }

		//statementSequence=NonEmptyStatementSequence
		public Assignment getStatementSequenceAssignment_2() { return cStatementSequenceAssignment_2; }

		//NonEmptyStatementSequence
		public RuleCall getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0() { return cStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0; }
	}

	public class SwitchCaseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SwitchCase");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCaseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//SwitchCase:
		//	"case" expression=Expression ":";
		public ParserRule getRule() { return rule; }

		//"case" expression=Expression ":"
		public Group getGroup() { return cGroup; }

		//"case"
		public Keyword getCaseKeyword_0() { return cCaseKeyword_0; }

		//expression=Expression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_1_0() { return cExpressionExpressionParserRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
	}

	public class SwitchDefaultClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SwitchDefaultClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDefaultKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStatementSequenceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0 = (RuleCall)cStatementSequenceAssignment_2.eContents().get(0);
		
		//SwitchDefaultClause:
		//	"default" ":" statementSequence=NonEmptyStatementSequence;
		public ParserRule getRule() { return rule; }

		//"default" ":" statementSequence=NonEmptyStatementSequence
		public Group getGroup() { return cGroup; }

		//"default"
		public Keyword getDefaultKeyword_0() { return cDefaultKeyword_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//statementSequence=NonEmptyStatementSequence
		public Assignment getStatementSequenceAssignment_2() { return cStatementSequenceAssignment_2; }

		//NonEmptyStatementSequence
		public RuleCall getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0() { return cStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0; }
	}

	public class NonEmptyStatementSequenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NonEmptyStatementSequence");
		private final Assignment cStatementAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cStatementDocumentedStatementParserRuleCall_0 = (RuleCall)cStatementAssignment.eContents().get(0);
		
		//NonEmptyStatementSequence:
		//	statement+=DocumentedStatement+;
		public ParserRule getRule() { return rule; }

		//statement+=DocumentedStatement+
		public Assignment getStatementAssignment() { return cStatementAssignment; }

		//DocumentedStatement
		public RuleCall getStatementDocumentedStatementParserRuleCall_0() { return cStatementDocumentedStatementParserRuleCall_0; }
	}

	public class WhileStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WhileStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cWhileKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConditionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cConditionExpressionParserRuleCall_2_0 = (RuleCall)cConditionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cBlockAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cBlockBlockParserRuleCall_4_0 = (RuleCall)cBlockAssignment_4.eContents().get(0);
		
		/// * WHILE STATEMENTS * / WhileStatement:
		//	"while" "(" condition=Expression ")" block=Block;
		public ParserRule getRule() { return rule; }

		//"while" "(" condition=Expression ")" block=Block
		public Group getGroup() { return cGroup; }

		//"while"
		public Keyword getWhileKeyword_0() { return cWhileKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//condition=Expression
		public Assignment getConditionAssignment_2() { return cConditionAssignment_2; }

		//Expression
		public RuleCall getConditionExpressionParserRuleCall_2_0() { return cConditionExpressionParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }

		//block=Block
		public Assignment getBlockAssignment_4() { return cBlockAssignment_4; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0() { return cBlockBlockParserRuleCall_4_0; }
	}

	public class DoStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DoStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDoKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_1_0 = (RuleCall)cBlockAssignment_1.eContents().get(0);
		private final Keyword cWhileKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cConditionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cConditionExpressionParserRuleCall_4_0 = (RuleCall)cConditionAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		/// * DO STATEMENTS * / DoStatement:
		//	"do" block=Block "while" "(" condition=Expression ")" ";";
		public ParserRule getRule() { return rule; }

		//"do" block=Block "while" "(" condition=Expression ")" ";"
		public Group getGroup() { return cGroup; }

		//"do"
		public Keyword getDoKeyword_0() { return cDoKeyword_0; }

		//block=Block
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_1_0() { return cBlockBlockParserRuleCall_1_0; }

		//"while"
		public Keyword getWhileKeyword_2() { return cWhileKeyword_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//condition=Expression
		public Assignment getConditionAssignment_4() { return cConditionAssignment_4; }

		//Expression
		public RuleCall getConditionExpressionParserRuleCall_4_0() { return cConditionExpressionParserRuleCall_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//";"
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class ForStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ForStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cForKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cControlAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cControlForControlParserRuleCall_2_0 = (RuleCall)cControlAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cBlockAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cBlockBlockParserRuleCall_4_0 = (RuleCall)cBlockAssignment_4.eContents().get(0);
		
		/// * FOR STATEMENTS * / ForStatement:
		//	"for" "(" control=ForControl ")" block=Block;
		public ParserRule getRule() { return rule; }

		//"for" "(" control=ForControl ")" block=Block
		public Group getGroup() { return cGroup; }

		//"for"
		public Keyword getForKeyword_0() { return cForKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//control=ForControl
		public Assignment getControlAssignment_2() { return cControlAssignment_2; }

		//ForControl
		public RuleCall getControlForControlParserRuleCall_2_0() { return cControlForControlParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }

		//block=Block
		public Assignment getBlockAssignment_4() { return cBlockAssignment_4; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0() { return cBlockBlockParserRuleCall_4_0; }
	}

	public class ForControlElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ForControl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLoopVariableDefinitionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_0_0 = (RuleCall)cLoopVariableDefinitionAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cLoopVariableDefinitionAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_1_1_0 = (RuleCall)cLoopVariableDefinitionAssignment_1_1.eContents().get(0);
		
		//ForControl:
		//	loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*;
		public ParserRule getRule() { return rule; }

		//loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*
		public Group getGroup() { return cGroup; }

		//loopVariableDefinition+=LoopVariableDefinition
		public Assignment getLoopVariableDefinitionAssignment_0() { return cLoopVariableDefinitionAssignment_0; }

		//LoopVariableDefinition
		public RuleCall getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_0_0() { return cLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_0_0; }

		//("," loopVariableDefinition+=LoopVariableDefinition)*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//loopVariableDefinition+=LoopVariableDefinition
		public Assignment getLoopVariableDefinitionAssignment_1_1() { return cLoopVariableDefinitionAssignment_1_1; }

		//LoopVariableDefinition
		public RuleCall getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_1_1_0() { return cLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_1_1_0; }
	}

	public class LoopVariableDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LoopVariableDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cInKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cExpression1Assignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cExpression1ExpressionParserRuleCall_0_2_0 = (RuleCall)cExpression1Assignment_0_2.eContents().get(0);
		private final Group cGroup_0_3 = (Group)cGroup_0.eContents().get(3);
		private final Keyword cFullStopFullStopKeyword_0_3_0 = (Keyword)cGroup_0_3.eContents().get(0);
		private final Assignment cExpression2Assignment_0_3_1 = (Assignment)cGroup_0_3.eContents().get(1);
		private final RuleCall cExpression2ExpressionParserRuleCall_0_3_1_0 = (RuleCall)cExpression2Assignment_0_3_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cTypeAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cTypeQualifiedNameWithBindingParserRuleCall_1_0_0 = (RuleCall)cTypeAssignment_1_0.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cExpressionAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cExpressionExpressionParserRuleCall_1_3_0 = (RuleCall)cExpressionAssignment_1_3.eContents().get(0);
		
		//LoopVariableDefinition:
		//	name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
		//	expression=Expression;
		public ParserRule getRule() { return rule; }

		//name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
		//expression=Expression
		public Alternatives getAlternatives() { return cAlternatives; }

		//name=ID "in" expression1=Expression (".." expression2=Expression)?
		public Group getGroup_0() { return cGroup_0; }

		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }

		//"in"
		public Keyword getInKeyword_0_1() { return cInKeyword_0_1; }

		//expression1=Expression
		public Assignment getExpression1Assignment_0_2() { return cExpression1Assignment_0_2; }

		//Expression
		public RuleCall getExpression1ExpressionParserRuleCall_0_2_0() { return cExpression1ExpressionParserRuleCall_0_2_0; }

		//(".." expression2=Expression)?
		public Group getGroup_0_3() { return cGroup_0_3; }

		//".."
		public Keyword getFullStopFullStopKeyword_0_3_0() { return cFullStopFullStopKeyword_0_3_0; }

		//expression2=Expression
		public Assignment getExpression2Assignment_0_3_1() { return cExpression2Assignment_0_3_1; }

		//Expression
		public RuleCall getExpression2ExpressionParserRuleCall_0_3_1_0() { return cExpression2ExpressionParserRuleCall_0_3_1_0; }

		//type=QualifiedNameWithBinding name=ID ":" expression=Expression
		public Group getGroup_1() { return cGroup_1; }

		//type=QualifiedNameWithBinding
		public Assignment getTypeAssignment_1_0() { return cTypeAssignment_1_0; }

		//QualifiedNameWithBinding
		public RuleCall getTypeQualifiedNameWithBindingParserRuleCall_1_0_0() { return cTypeQualifiedNameWithBindingParserRuleCall_1_0_0; }

		//name=ID
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_1_0() { return cNameIDTerminalRuleCall_1_1_0; }

		//":"
		public Keyword getColonKeyword_1_2() { return cColonKeyword_1_2; }

		//expression=Expression
		public Assignment getExpressionAssignment_1_3() { return cExpressionAssignment_1_3; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_1_3_0() { return cExpressionExpressionParserRuleCall_1_3_0; }
	}

	public class BreakStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BreakStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBreakStatementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cBreakKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		/// * BREAK STATEMENTS * / BreakStatement:
		//	{BreakStatement} "break" ";";
		public ParserRule getRule() { return rule; }

		//{BreakStatement} "break" ";"
		public Group getGroup() { return cGroup; }

		//{BreakStatement}
		public Action getBreakStatementAction_0() { return cBreakStatementAction_0; }

		//"break"
		public Keyword getBreakKeyword_1() { return cBreakKeyword_1; }

		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class ReturnStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReturnStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReturnKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		/// * RETURN STATEMENTS * / ReturnStatement:
		//	"return" expression=Expression ";";
		public ParserRule getRule() { return rule; }

		//"return" expression=Expression ";"
		public Group getGroup() { return cGroup; }

		//"return"
		public Keyword getReturnKeyword_0() { return cReturnKeyword_0; }

		//expression=Expression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_1_0() { return cExpressionExpressionParserRuleCall_1_0; }

		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class AcceptStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AcceptStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cClauseAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cClauseAcceptClauseParserRuleCall_0_0 = (RuleCall)cClauseAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cSimpleAcceptAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cSimpleAcceptSimpleAcceptStatementCompletionParserRuleCall_1_0_0 = (RuleCall)cSimpleAcceptAssignment_1_0.eContents().get(0);
		private final Assignment cCompoundAcceptAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cCompoundAcceptCompoundAcceptStatementCompletionParserRuleCall_1_1_0 = (RuleCall)cCompoundAcceptAssignment_1_1.eContents().get(0);
		
		/// * ACCEPT STATEMENTS * / AcceptStatement:
		//	clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion);
		public ParserRule getRule() { return rule; }

		//clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion)
		public Group getGroup() { return cGroup; }

		//clause=AcceptClause
		public Assignment getClauseAssignment_0() { return cClauseAssignment_0; }

		//AcceptClause
		public RuleCall getClauseAcceptClauseParserRuleCall_0_0() { return cClauseAcceptClauseParserRuleCall_0_0; }

		//simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//simpleAccept=SimpleAcceptStatementCompletion
		public Assignment getSimpleAcceptAssignment_1_0() { return cSimpleAcceptAssignment_1_0; }

		//SimpleAcceptStatementCompletion
		public RuleCall getSimpleAcceptSimpleAcceptStatementCompletionParserRuleCall_1_0_0() { return cSimpleAcceptSimpleAcceptStatementCompletionParserRuleCall_1_0_0; }

		//compoundAccept=CompoundAcceptStatementCompletion
		public Assignment getCompoundAcceptAssignment_1_1() { return cCompoundAcceptAssignment_1_1; }

		//CompoundAcceptStatementCompletion
		public RuleCall getCompoundAcceptCompoundAcceptStatementCompletionParserRuleCall_1_1_0() { return cCompoundAcceptCompoundAcceptStatementCompletionParserRuleCall_1_1_0; }
	}

	public class SimpleAcceptStatementCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleAcceptStatementCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSimpleAcceptStatementCompletionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//SimpleAcceptStatementCompletion:
		//	{SimpleAcceptStatementCompletion} ";";
		public ParserRule getRule() { return rule; }

		//{SimpleAcceptStatementCompletion} ";"
		public Group getGroup() { return cGroup; }

		//{SimpleAcceptStatementCompletion}
		public Action getSimpleAcceptStatementCompletionAction_0() { return cSimpleAcceptStatementCompletionAction_0; }

		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class CompoundAcceptStatementCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompoundAcceptStatementCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cBlockAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_0_0 = (RuleCall)cBlockAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cOrKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cAcceptBlockAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cAcceptBlockAcceptBlockParserRuleCall_1_1_0 = (RuleCall)cAcceptBlockAssignment_1_1.eContents().get(0);
		
		//CompoundAcceptStatementCompletion:
		//	block=Block ("or" acceptBlock+=AcceptBlock)*;
		public ParserRule getRule() { return rule; }

		//block=Block ("or" acceptBlock+=AcceptBlock)*
		public Group getGroup() { return cGroup; }

		//block=Block
		public Assignment getBlockAssignment_0() { return cBlockAssignment_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_0_0() { return cBlockBlockParserRuleCall_0_0; }

		//("or" acceptBlock+=AcceptBlock)*
		public Group getGroup_1() { return cGroup_1; }

		//"or"
		public Keyword getOrKeyword_1_0() { return cOrKeyword_1_0; }

		//acceptBlock+=AcceptBlock
		public Assignment getAcceptBlockAssignment_1_1() { return cAcceptBlockAssignment_1_1; }

		//AcceptBlock
		public RuleCall getAcceptBlockAcceptBlockParserRuleCall_1_1_0() { return cAcceptBlockAcceptBlockParserRuleCall_1_1_0; }
	}

	public class AcceptBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AcceptBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cClauseAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cClauseAcceptClauseParserRuleCall_0_0 = (RuleCall)cClauseAssignment_0.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_1_0 = (RuleCall)cBlockAssignment_1.eContents().get(0);
		
		//AcceptBlock:
		//	clause=AcceptClause block=Block;
		public ParserRule getRule() { return rule; }

		//clause=AcceptClause block=Block
		public Group getGroup() { return cGroup; }

		//clause=AcceptClause
		public Assignment getClauseAssignment_0() { return cClauseAssignment_0; }

		//AcceptClause
		public RuleCall getClauseAcceptClauseParserRuleCall_0_0() { return cClauseAcceptClauseParserRuleCall_0_0; }

		//block=Block
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_1_0() { return cBlockBlockParserRuleCall_1_0; }
	}

	public class AcceptClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AcceptClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAcceptKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_2_0_0 = (RuleCall)cNameAssignment_2_0.eContents().get(0);
		private final Keyword cColonKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cQualifiedNameListAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cQualifiedNameListQualifiedNameListParserRuleCall_3_0 = (RuleCall)cQualifiedNameListAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AcceptClause:
		//	"accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")";
		public ParserRule getRule() { return rule; }

		//"accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")"
		public Group getGroup() { return cGroup; }

		//"accept"
		public Keyword getAcceptKeyword_0() { return cAcceptKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(name=ID ":")?
		public Group getGroup_2() { return cGroup_2; }

		//name=ID
		public Assignment getNameAssignment_2_0() { return cNameAssignment_2_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0_0() { return cNameIDTerminalRuleCall_2_0_0; }

		//":"
		public Keyword getColonKeyword_2_1() { return cColonKeyword_2_1; }

		//qualifiedNameList=QualifiedNameList
		public Assignment getQualifiedNameListAssignment_3() { return cQualifiedNameListAssignment_3; }

		//QualifiedNameList
		public RuleCall getQualifiedNameListQualifiedNameListParserRuleCall_3_0() { return cQualifiedNameListQualifiedNameListParserRuleCall_3_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class ClassifyStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassifyStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClassifyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Assignment cClauseAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cClauseClassificationClauseParserRuleCall_2_0 = (RuleCall)cClauseAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		/// * CLASSIFY STATEMENTS * / ClassifyStatement:
		//	"classify" expression=Expression clause=ClassificationClause ";";
		public ParserRule getRule() { return rule; }

		//"classify" expression=Expression clause=ClassificationClause ";"
		public Group getGroup() { return cGroup; }

		//"classify"
		public Keyword getClassifyKeyword_0() { return cClassifyKeyword_0; }

		//expression=Expression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_1_0() { return cExpressionExpressionParserRuleCall_1_0; }

		//clause=ClassificationClause
		public Assignment getClauseAssignment_2() { return cClauseAssignment_2; }

		//ClassificationClause
		public RuleCall getClauseClassificationClauseParserRuleCall_2_0() { return cClauseClassificationClauseParserRuleCall_2_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class ClassificationClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassificationClause");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cClassifyFromClauseAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cClassifyFromClauseClassificationFromClauseParserRuleCall_0_0_0 = (RuleCall)cClassifyFromClauseAssignment_0_0.eContents().get(0);
		private final Assignment cClassifyToClauseAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cClassifyToClauseClassificationToClauseParserRuleCall_0_1_0 = (RuleCall)cClassifyToClauseAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cReclassyAllClauseAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cReclassyAllClauseReclassifyAllClauseParserRuleCall_1_0_0 = (RuleCall)cReclassyAllClauseAssignment_1_0.eContents().get(0);
		private final Assignment cClassifyToClauseAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cClassifyToClauseClassificationToClauseParserRuleCall_1_1_0 = (RuleCall)cClassifyToClauseAssignment_1_1.eContents().get(0);
		
		//ClassificationClause:
		//	classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
		//	reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause;
		public ParserRule getRule() { return rule; }

		//classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
		//reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause
		public Alternatives getAlternatives() { return cAlternatives; }

		//classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause?
		public Group getGroup_0() { return cGroup_0; }

		//classifyFromClause=ClassificationFromClause
		public Assignment getClassifyFromClauseAssignment_0_0() { return cClassifyFromClauseAssignment_0_0; }

		//ClassificationFromClause
		public RuleCall getClassifyFromClauseClassificationFromClauseParserRuleCall_0_0_0() { return cClassifyFromClauseClassificationFromClauseParserRuleCall_0_0_0; }

		//classifyToClause=ClassificationToClause?
		public Assignment getClassifyToClauseAssignment_0_1() { return cClassifyToClauseAssignment_0_1; }

		//ClassificationToClause
		public RuleCall getClassifyToClauseClassificationToClauseParserRuleCall_0_1_0() { return cClassifyToClauseClassificationToClauseParserRuleCall_0_1_0; }

		//reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause
		public Group getGroup_1() { return cGroup_1; }

		//reclassyAllClause=ReclassifyAllClause?
		public Assignment getReclassyAllClauseAssignment_1_0() { return cReclassyAllClauseAssignment_1_0; }

		//ReclassifyAllClause
		public RuleCall getReclassyAllClauseReclassifyAllClauseParserRuleCall_1_0_0() { return cReclassyAllClauseReclassifyAllClauseParserRuleCall_1_0_0; }

		//classifyToClause=ClassificationToClause
		public Assignment getClassifyToClauseAssignment_1_1() { return cClassifyToClauseAssignment_1_1; }

		//ClassificationToClause
		public RuleCall getClassifyToClauseClassificationToClauseParserRuleCall_1_1_0() { return cClassifyToClauseClassificationToClauseParserRuleCall_1_1_0; }
	}

	public class ClassificationFromClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassificationFromClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFromKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cQualifiedNameListAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cQualifiedNameListQualifiedNameListParserRuleCall_1_0 = (RuleCall)cQualifiedNameListAssignment_1.eContents().get(0);
		
		//ClassificationFromClause:
		//	"from" qualifiedNameList=QualifiedNameList;
		public ParserRule getRule() { return rule; }

		//"from" qualifiedNameList=QualifiedNameList
		public Group getGroup() { return cGroup; }

		//"from"
		public Keyword getFromKeyword_0() { return cFromKeyword_0; }

		//qualifiedNameList=QualifiedNameList
		public Assignment getQualifiedNameListAssignment_1() { return cQualifiedNameListAssignment_1; }

		//QualifiedNameList
		public RuleCall getQualifiedNameListQualifiedNameListParserRuleCall_1_0() { return cQualifiedNameListQualifiedNameListParserRuleCall_1_0; }
	}

	public class ClassificationToClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassificationToClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cToKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cQualifiedNameListAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cQualifiedNameListQualifiedNameListParserRuleCall_1_0 = (RuleCall)cQualifiedNameListAssignment_1.eContents().get(0);
		
		//ClassificationToClause:
		//	"to" qualifiedNameList=QualifiedNameList;
		public ParserRule getRule() { return rule; }

		//"to" qualifiedNameList=QualifiedNameList
		public Group getGroup() { return cGroup; }

		//"to"
		public Keyword getToKeyword_0() { return cToKeyword_0; }

		//qualifiedNameList=QualifiedNameList
		public Assignment getQualifiedNameListAssignment_1() { return cQualifiedNameListAssignment_1; }

		//QualifiedNameList
		public RuleCall getQualifiedNameListQualifiedNameListParserRuleCall_1_0() { return cQualifiedNameListQualifiedNameListParserRuleCall_1_0; }
	}

	public class ReclassifyAllClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReclassifyAllClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cReclassifyAllClauseAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cFromKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cAsteriskKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ReclassifyAllClause:
		//	{ReclassifyAllClause} "from" "*";
		public ParserRule getRule() { return rule; }

		//{ReclassifyAllClause} "from" "*"
		public Group getGroup() { return cGroup; }

		//{ReclassifyAllClause}
		public Action getReclassifyAllClauseAction_0() { return cReclassifyAllClauseAction_0; }

		//"from"
		public Keyword getFromKeyword_1() { return cFromKeyword_1; }

		//"*"
		public Keyword getAsteriskKeyword_2() { return cAsteriskKeyword_2; }
	}

	public class QualifiedNameListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedNameList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cQualifiedNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cQualifiedNameQualifiedNameWithBindingParserRuleCall_0_0 = (RuleCall)cQualifiedNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cQualifiedNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cQualifiedNameQualifiedNameWithBindingParserRuleCall_1_1_0 = (RuleCall)cQualifiedNameAssignment_1_1.eContents().get(0);
		
		//QualifiedNameList:
		//	qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*;
		public ParserRule getRule() { return rule; }

		//qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*
		public Group getGroup() { return cGroup; }

		//qualifiedName+=QualifiedNameWithBinding
		public Assignment getQualifiedNameAssignment_0() { return cQualifiedNameAssignment_0; }

		//QualifiedNameWithBinding
		public RuleCall getQualifiedNameQualifiedNameWithBindingParserRuleCall_0_0() { return cQualifiedNameQualifiedNameWithBindingParserRuleCall_0_0; }

		//("," qualifiedName+=QualifiedNameWithBinding)*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//qualifiedName+=QualifiedNameWithBinding
		public Assignment getQualifiedNameAssignment_1_1() { return cQualifiedNameAssignment_1_1; }

		//QualifiedNameWithBinding
		public RuleCall getQualifiedNameQualifiedNameWithBindingParserRuleCall_1_1_0() { return cQualifiedNameQualifiedNameWithBindingParserRuleCall_1_1_0; }
	}

	public class InvocationOrAssignementOrDeclarationStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InvocationOrAssignementOrDeclarationStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypePart_OR_assignedPart_OR_invocationPartAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypePart_OR_assignedPart_OR_invocationPartNameExpressionParserRuleCall_0_0 = (RuleCall)cTypePart_OR_assignedPart_OR_invocationPartAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cVariableDeclarationCompletionAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cVariableDeclarationCompletionVariableDeclarationCompletionParserRuleCall_1_0_0 = (RuleCall)cVariableDeclarationCompletionAssignment_1_0.eContents().get(0);
		private final Assignment cAssignmentCompletionAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cAssignmentCompletionAssignmentCompletionParserRuleCall_1_1_0 = (RuleCall)cAssignmentCompletionAssignment_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//InvocationOrAssignementOrDeclarationStatement:
		//	typePart_OR_assignedPart_OR_invocationPart=NameExpression (variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
		//	| assignmentCompletion=AssignmentCompletion)? ";";
		public ParserRule getRule() { return rule; }

		//typePart_OR_assignedPart_OR_invocationPart=NameExpression (variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
		//| assignmentCompletion=AssignmentCompletion)? ";"
		public Group getGroup() { return cGroup; }

		//typePart_OR_assignedPart_OR_invocationPart=NameExpression
		public Assignment getTypePart_OR_assignedPart_OR_invocationPartAssignment_0() { return cTypePart_OR_assignedPart_OR_invocationPartAssignment_0; }

		//NameExpression
		public RuleCall getTypePart_OR_assignedPart_OR_invocationPartNameExpressionParserRuleCall_0_0() { return cTypePart_OR_assignedPart_OR_invocationPartNameExpressionParserRuleCall_0_0; }

		//(variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
		//| assignmentCompletion=AssignmentCompletion)?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//variableDeclarationCompletion=VariableDeclarationCompletion
		public Assignment getVariableDeclarationCompletionAssignment_1_0() { return cVariableDeclarationCompletionAssignment_1_0; }

		//VariableDeclarationCompletion
		public RuleCall getVariableDeclarationCompletionVariableDeclarationCompletionParserRuleCall_1_0_0() { return cVariableDeclarationCompletionVariableDeclarationCompletionParserRuleCall_1_0_0; }

		//assignmentCompletion=AssignmentCompletion
		public Assignment getAssignmentCompletionAssignment_1_1() { return cAssignmentCompletionAssignment_1_1; }

		//AssignmentCompletion
		public RuleCall getAssignmentCompletionAssignmentCompletionParserRuleCall_1_1_0() { return cAssignmentCompletionAssignmentCompletionParserRuleCall_1_1_0; }

		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class SuperInvocationStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SuperInvocationStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c_superAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c_superSuperInvocationExpressionParserRuleCall_0_0 = (RuleCall)c_superAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//SuperInvocationStatement:
		//	_super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
		//	";";
		public ParserRule getRule() { return rule; }

		//_super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
		//";"
		public Group getGroup() { return cGroup; }

		//_super=SuperInvocationExpression
		public Assignment get_superAssignment_0() { return c_superAssignment_0; }

		//SuperInvocationExpression
		public RuleCall get_superSuperInvocationExpressionParserRuleCall_0_0() { return c_superSuperInvocationExpressionParserRuleCall_0_0; }

		////(suffix = SuffixCompletion)? ';'
		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class ThisInvocationStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ThisInvocationStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c_thisAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c_thisThisExpressionParserRuleCall_0_0 = (RuleCall)c_thisAssignment_0.eContents().get(0);
		private final Assignment cAssignmentCompletionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAssignmentCompletionAssignmentCompletionParserRuleCall_1_0 = (RuleCall)cAssignmentCompletionAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ThisInvocationStatement: //_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
		//	_this=ThisExpression assignmentCompletion=AssignmentCompletion? ";";
		public ParserRule getRule() { return rule; }

		////_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
		//_this=ThisExpression assignmentCompletion=AssignmentCompletion? ";"
		public Group getGroup() { return cGroup; }

		////_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
		//_this=ThisExpression
		public Assignment get_thisAssignment_0() { return c_thisAssignment_0; }

		//ThisExpression
		public RuleCall get_thisThisExpressionParserRuleCall_0_0() { return c_thisThisExpressionParserRuleCall_0_0; }

		//assignmentCompletion=AssignmentCompletion?
		public Assignment getAssignmentCompletionAssignment_1() { return cAssignmentCompletionAssignment_1; }

		//AssignmentCompletion
		public RuleCall getAssignmentCompletionAssignmentCompletionParserRuleCall_1_0() { return cAssignmentCompletionAssignmentCompletionParserRuleCall_1_0; }

		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class InstanceCreationInvocationStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceCreationInvocationStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c_newAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c_newInstanceCreationExpressionParserRuleCall_0_0 = (RuleCall)c_newAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//InstanceCreationInvocationStatement:
		//	_new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
		//	";";
		public ParserRule getRule() { return rule; }

		//_new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
		//";"
		public Group getGroup() { return cGroup; }

		//_new=InstanceCreationExpression
		public Assignment get_newAssignment_0() { return c_newAssignment_0; }

		//InstanceCreationExpression
		public RuleCall get_newInstanceCreationExpressionParserRuleCall_0_0() { return c_newInstanceCreationExpressionParserRuleCall_0_0; }

		////(suffix = SuffixCompletion)? ';'
		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class VariableDeclarationCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VariableDeclarationCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cMultiplicityIndicatorAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final Keyword cMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0 = (Keyword)cMultiplicityIndicatorAssignment_0_0.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cVariableNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVariableNameIDTerminalRuleCall_1_0 = (RuleCall)cVariableNameAssignment_1.eContents().get(0);
		private final Assignment cInitValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cInitValueAssignmentCompletionParserRuleCall_2_0 = (RuleCall)cInitValueAssignment_2.eContents().get(0);
		
		////SuffixCompletion :
		////	suffix = SuffixExpression
		////;
		//VariableDeclarationCompletion:
		//	(multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion;
		public ParserRule getRule() { return rule; }

		//(multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion
		public Group getGroup() { return cGroup; }

		//(multiplicityIndicator?="[" "]")?
		public Group getGroup_0() { return cGroup_0; }

		//multiplicityIndicator?="["
		public Assignment getMultiplicityIndicatorAssignment_0_0() { return cMultiplicityIndicatorAssignment_0_0; }

		//"["
		public Keyword getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0() { return cMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_0_1() { return cRightSquareBracketKeyword_0_1; }

		//variableName=ID
		public Assignment getVariableNameAssignment_1() { return cVariableNameAssignment_1; }

		//ID
		public RuleCall getVariableNameIDTerminalRuleCall_1_0() { return cVariableNameIDTerminalRuleCall_1_0; }

		//initValue=AssignmentCompletion
		public Assignment getInitValueAssignment_2() { return cInitValueAssignment_2; }

		//AssignmentCompletion
		public RuleCall getInitValueAssignmentCompletionParserRuleCall_2_0() { return cInitValueAssignmentCompletionParserRuleCall_2_0; }
	}

	public class AssignmentCompletionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssignmentCompletion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpAssignmentOperatorEnumRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cRightHandSideAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRightHandSideSequenceElementParserRuleCall_1_0 = (RuleCall)cRightHandSideAssignment_1.eContents().get(0);
		
		////op=('=' | '+=' | '-=' | '*=' | '%=' | '/=' | '&=' |
		////	'|=' | '^=' | '<<=' | '>>=' | '>>>=') rightHandSide = Expression
		//AssignmentCompletion:
		//	op=AssignmentOperator rightHandSide=SequenceElement;
		public ParserRule getRule() { return rule; }

		//op=AssignmentOperator rightHandSide=SequenceElement
		public Group getGroup() { return cGroup; }

		//op=AssignmentOperator
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//AssignmentOperator
		public RuleCall getOpAssignmentOperatorEnumRuleCall_0_0() { return cOpAssignmentOperatorEnumRuleCall_0_0; }

		//rightHandSide=SequenceElement
		public Assignment getRightHandSideAssignment_1() { return cRightHandSideAssignment_1; }

		//SequenceElement
		public RuleCall getRightHandSideSequenceElementParserRuleCall_1_0() { return cRightHandSideSequenceElementParserRuleCall_1_0; }
	}
	
	
	public class BooleanValueElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "BooleanValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cTRUEEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cTRUETrueKeyword_0_0 = (Keyword)cTRUEEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFALSEEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFALSEFalseKeyword_1_0 = (Keyword)cFALSEEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum BooleanValue:
		//	TRUE="true" | FALSE="false";
		public EnumRule getRule() { return rule; }

		//TRUE="true" | FALSE="false"
		public Alternatives getAlternatives() { return cAlternatives; }

		//TRUE="true"
		public EnumLiteralDeclaration getTRUEEnumLiteralDeclaration_0() { return cTRUEEnumLiteralDeclaration_0; }

		//"true"
		public Keyword getTRUETrueKeyword_0_0() { return cTRUETrueKeyword_0_0; }

		//FALSE="false"
		public EnumLiteralDeclaration getFALSEEnumLiteralDeclaration_1() { return cFALSEEnumLiteralDeclaration_1; }

		//"false"
		public Keyword getFALSEFalseKeyword_1_0() { return cFALSEFalseKeyword_1_0; }
	}

	public class LinkOperationKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "LinkOperationKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCREATEEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCREATECreateLinkKeyword_0_0 = (Keyword)cCREATEEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cDESTROYEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cDESTROYDestroyLinkKeyword_1_0 = (Keyword)cDESTROYEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cCLEAREnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cCLEARClearAssocKeyword_2_0 = (Keyword)cCLEAREnumLiteralDeclaration_2.eContents().get(0);
		
		//enum LinkOperationKind:
		//	CREATE="createLink" | DESTROY="destroyLink" | CLEAR="clearAssoc";
		public EnumRule getRule() { return rule; }

		//CREATE="createLink" | DESTROY="destroyLink" | CLEAR="clearAssoc"
		public Alternatives getAlternatives() { return cAlternatives; }

		//CREATE="createLink"
		public EnumLiteralDeclaration getCREATEEnumLiteralDeclaration_0() { return cCREATEEnumLiteralDeclaration_0; }

		//"createLink"
		public Keyword getCREATECreateLinkKeyword_0_0() { return cCREATECreateLinkKeyword_0_0; }

		//DESTROY="destroyLink"
		public EnumLiteralDeclaration getDESTROYEnumLiteralDeclaration_1() { return cDESTROYEnumLiteralDeclaration_1; }

		//"destroyLink"
		public Keyword getDESTROYDestroyLinkKeyword_1_0() { return cDESTROYDestroyLinkKeyword_1_0; }

		//CLEAR="clearAssoc"
		public EnumLiteralDeclaration getCLEAREnumLiteralDeclaration_2() { return cCLEAREnumLiteralDeclaration_2; }

		//"clearAssoc"
		public Keyword getCLEARClearAssocKeyword_2_0() { return cCLEARClearAssocKeyword_2_0; }
	}

	public class SelectOrRejectOperatorElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "SelectOrRejectOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cSELECTEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cSELECTSelectKeyword_0_0 = (Keyword)cSELECTEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cREJECTEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cREJECTRejectKeyword_1_0 = (Keyword)cREJECTEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum SelectOrRejectOperator:
		//	SELECT="select" | REJECT="reject";
		public EnumRule getRule() { return rule; }

		//SELECT="select" | REJECT="reject"
		public Alternatives getAlternatives() { return cAlternatives; }

		//SELECT="select"
		public EnumLiteralDeclaration getSELECTEnumLiteralDeclaration_0() { return cSELECTEnumLiteralDeclaration_0; }

		//"select"
		public Keyword getSELECTSelectKeyword_0_0() { return cSELECTSelectKeyword_0_0; }

		//REJECT="reject"
		public EnumLiteralDeclaration getREJECTEnumLiteralDeclaration_1() { return cREJECTEnumLiteralDeclaration_1; }

		//"reject"
		public Keyword getREJECTRejectKeyword_1_0() { return cREJECTRejectKeyword_1_0; }
	}

	public class CollectOrIterateOperatorElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "CollectOrIterateOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCOLLECTEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCOLLECTCollectKeyword_0_0 = (Keyword)cCOLLECTEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cITERATEEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cITERATEIterateKeyword_1_0 = (Keyword)cITERATEEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum CollectOrIterateOperator:
		//	COLLECT="collect" | ITERATE="iterate";
		public EnumRule getRule() { return rule; }

		//COLLECT="collect" | ITERATE="iterate"
		public Alternatives getAlternatives() { return cAlternatives; }

		//COLLECT="collect"
		public EnumLiteralDeclaration getCOLLECTEnumLiteralDeclaration_0() { return cCOLLECTEnumLiteralDeclaration_0; }

		//"collect"
		public Keyword getCOLLECTCollectKeyword_0_0() { return cCOLLECTCollectKeyword_0_0; }

		//ITERATE="iterate"
		public EnumLiteralDeclaration getITERATEEnumLiteralDeclaration_1() { return cITERATEEnumLiteralDeclaration_1; }

		//"iterate"
		public Keyword getITERATEIterateKeyword_1_0() { return cITERATEIterateKeyword_1_0; }
	}

	public class ForAllOrExistsOrOneOperatorElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ForAllOrExistsOrOneOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cFORALLEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cFORALLForAllKeyword_0_0 = (Keyword)cFORALLEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cEXISTSEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cEXISTSExistsKeyword_1_0 = (Keyword)cEXISTSEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cONEEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cONEOneKeyword_2_0 = (Keyword)cONEEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum ForAllOrExistsOrOneOperator:
		//	FORALL="forAll" | EXISTS="exists" | ONE="one";
		public EnumRule getRule() { return rule; }

		//FORALL="forAll" | EXISTS="exists" | ONE="one"
		public Alternatives getAlternatives() { return cAlternatives; }

		//FORALL="forAll"
		public EnumLiteralDeclaration getFORALLEnumLiteralDeclaration_0() { return cFORALLEnumLiteralDeclaration_0; }

		//"forAll"
		public Keyword getFORALLForAllKeyword_0_0() { return cFORALLForAllKeyword_0_0; }

		//EXISTS="exists"
		public EnumLiteralDeclaration getEXISTSEnumLiteralDeclaration_1() { return cEXISTSEnumLiteralDeclaration_1; }

		//"exists"
		public Keyword getEXISTSExistsKeyword_1_0() { return cEXISTSExistsKeyword_1_0; }

		//ONE="one"
		public EnumLiteralDeclaration getONEEnumLiteralDeclaration_2() { return cONEEnumLiteralDeclaration_2; }

		//"one"
		public Keyword getONEOneKeyword_2_0() { return cONEOneKeyword_2_0; }
	}

	public class AnnotationKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "AnnotationKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cISOLATEDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cISOLATEDIsolatedKeyword_0_0 = (Keyword)cISOLATEDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cDETERMINEDEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cDETERMINEDDeterminedKeyword_1_0 = (Keyword)cDETERMINEDEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cASSUREDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cASSUREDAssuredKeyword_2_0 = (Keyword)cASSUREDEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cPARALLELEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cPARALLELParallelKeyword_3_0 = (Keyword)cPARALLELEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum AnnotationKind:
		//	ISOLATED="isolated" | DETERMINED="determined" | ASSURED="assured" | PARALLEL="parallel";
		public EnumRule getRule() { return rule; }

		//ISOLATED="isolated" | DETERMINED="determined" | ASSURED="assured" | PARALLEL="parallel"
		public Alternatives getAlternatives() { return cAlternatives; }

		//ISOLATED="isolated"
		public EnumLiteralDeclaration getISOLATEDEnumLiteralDeclaration_0() { return cISOLATEDEnumLiteralDeclaration_0; }

		//"isolated"
		public Keyword getISOLATEDIsolatedKeyword_0_0() { return cISOLATEDIsolatedKeyword_0_0; }

		//DETERMINED="determined"
		public EnumLiteralDeclaration getDETERMINEDEnumLiteralDeclaration_1() { return cDETERMINEDEnumLiteralDeclaration_1; }

		//"determined"
		public Keyword getDETERMINEDDeterminedKeyword_1_0() { return cDETERMINEDDeterminedKeyword_1_0; }

		//ASSURED="assured"
		public EnumLiteralDeclaration getASSUREDEnumLiteralDeclaration_2() { return cASSUREDEnumLiteralDeclaration_2; }

		//"assured"
		public Keyword getASSUREDAssuredKeyword_2_0() { return cASSUREDAssuredKeyword_2_0; }

		//PARALLEL="parallel"
		public EnumLiteralDeclaration getPARALLELEnumLiteralDeclaration_3() { return cPARALLELEnumLiteralDeclaration_3; }

		//"parallel"
		public Keyword getPARALLELParallelKeyword_3_0() { return cPARALLELParallelKeyword_3_0; }
	}

	public class AssignmentOperatorElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "AssignmentOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cASSIGNEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cASSIGNEqualsSignKeyword_0_0 = (Keyword)cASSIGNEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPLUSASSIGNEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPLUSASSIGNPlusSignEqualsSignKeyword_1_0 = (Keyword)cPLUSASSIGNEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cMINUSASSIGNEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cMINUSASSIGNHyphenMinusEqualsSignKeyword_2_0 = (Keyword)cMINUSASSIGNEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cMULTASSIGNEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cMULTASSIGNAsteriskEqualsSignKeyword_3_0 = (Keyword)cMULTASSIGNEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cMODASSIGNEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cMODASSIGNPercentSignEqualsSignKeyword_4_0 = (Keyword)cMODASSIGNEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cDIVASSIGNEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cDIVASSIGNSolidusEqualsSignKeyword_5_0 = (Keyword)cDIVASSIGNEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cANDASSIGNEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cANDASSIGNAmpersandEqualsSignKeyword_6_0 = (Keyword)cANDASSIGNEnumLiteralDeclaration_6.eContents().get(0);
		private final EnumLiteralDeclaration cORASSIGNEnumLiteralDeclaration_7 = (EnumLiteralDeclaration)cAlternatives.eContents().get(7);
		private final Keyword cORASSIGNVerticalLineEqualsSignKeyword_7_0 = (Keyword)cORASSIGNEnumLiteralDeclaration_7.eContents().get(0);
		private final EnumLiteralDeclaration cXORASSIGNEnumLiteralDeclaration_8 = (EnumLiteralDeclaration)cAlternatives.eContents().get(8);
		private final Keyword cXORASSIGNCircumflexAccentEqualsSignKeyword_8_0 = (Keyword)cXORASSIGNEnumLiteralDeclaration_8.eContents().get(0);
		private final EnumLiteralDeclaration cLSHIFTASSIGNEnumLiteralDeclaration_9 = (EnumLiteralDeclaration)cAlternatives.eContents().get(9);
		private final Keyword cLSHIFTASSIGNLessThanSignLessThanSignEqualsSignKeyword_9_0 = (Keyword)cLSHIFTASSIGNEnumLiteralDeclaration_9.eContents().get(0);
		private final EnumLiteralDeclaration cRSHIFTASSIGNEnumLiteralDeclaration_10 = (EnumLiteralDeclaration)cAlternatives.eContents().get(10);
		private final Keyword cRSHIFTASSIGNGreaterThanSignGreaterThanSignEqualsSignKeyword_10_0 = (Keyword)cRSHIFTASSIGNEnumLiteralDeclaration_10.eContents().get(0);
		private final EnumLiteralDeclaration cURSHIFTASSIGNEnumLiteralDeclaration_11 = (EnumLiteralDeclaration)cAlternatives.eContents().get(11);
		private final Keyword cURSHIFTASSIGNGreaterThanSignGreaterThanSignGreaterThanSignEqualsSignKeyword_11_0 = (Keyword)cURSHIFTASSIGNEnumLiteralDeclaration_11.eContents().get(0);
		
		//enum AssignmentOperator:
		//	ASSIGN="=" | PLUSASSIGN="+=" | MINUSASSIGN="-=" | MULTASSIGN="*=" | MODASSIGN="%=" | DIVASSIGN="/=" | ANDASSIGN="&=" |
		//	ORASSIGN="|=" | XORASSIGN="^=" | LSHIFTASSIGN="<<=" | RSHIFTASSIGN=">>=" | URSHIFTASSIGN=">>>=";
		public EnumRule getRule() { return rule; }

		//ASSIGN="=" | PLUSASSIGN="+=" | MINUSASSIGN="-=" | MULTASSIGN="*=" | MODASSIGN="%=" | DIVASSIGN="/=" | ANDASSIGN="&=" |
		//ORASSIGN="|=" | XORASSIGN="^=" | LSHIFTASSIGN="<<=" | RSHIFTASSIGN=">>=" | URSHIFTASSIGN=">>>="
		public Alternatives getAlternatives() { return cAlternatives; }

		//ASSIGN="="
		public EnumLiteralDeclaration getASSIGNEnumLiteralDeclaration_0() { return cASSIGNEnumLiteralDeclaration_0; }

		//"="
		public Keyword getASSIGNEqualsSignKeyword_0_0() { return cASSIGNEqualsSignKeyword_0_0; }

		//PLUSASSIGN="+="
		public EnumLiteralDeclaration getPLUSASSIGNEnumLiteralDeclaration_1() { return cPLUSASSIGNEnumLiteralDeclaration_1; }

		//"+="
		public Keyword getPLUSASSIGNPlusSignEqualsSignKeyword_1_0() { return cPLUSASSIGNPlusSignEqualsSignKeyword_1_0; }

		//MINUSASSIGN="-="
		public EnumLiteralDeclaration getMINUSASSIGNEnumLiteralDeclaration_2() { return cMINUSASSIGNEnumLiteralDeclaration_2; }

		//"-="
		public Keyword getMINUSASSIGNHyphenMinusEqualsSignKeyword_2_0() { return cMINUSASSIGNHyphenMinusEqualsSignKeyword_2_0; }

		//MULTASSIGN="*="
		public EnumLiteralDeclaration getMULTASSIGNEnumLiteralDeclaration_3() { return cMULTASSIGNEnumLiteralDeclaration_3; }

		//"*="
		public Keyword getMULTASSIGNAsteriskEqualsSignKeyword_3_0() { return cMULTASSIGNAsteriskEqualsSignKeyword_3_0; }

		//MODASSIGN="%="
		public EnumLiteralDeclaration getMODASSIGNEnumLiteralDeclaration_4() { return cMODASSIGNEnumLiteralDeclaration_4; }

		//"%="
		public Keyword getMODASSIGNPercentSignEqualsSignKeyword_4_0() { return cMODASSIGNPercentSignEqualsSignKeyword_4_0; }

		//DIVASSIGN="/="
		public EnumLiteralDeclaration getDIVASSIGNEnumLiteralDeclaration_5() { return cDIVASSIGNEnumLiteralDeclaration_5; }

		//"/="
		public Keyword getDIVASSIGNSolidusEqualsSignKeyword_5_0() { return cDIVASSIGNSolidusEqualsSignKeyword_5_0; }

		//ANDASSIGN="&="
		public EnumLiteralDeclaration getANDASSIGNEnumLiteralDeclaration_6() { return cANDASSIGNEnumLiteralDeclaration_6; }

		//"&="
		public Keyword getANDASSIGNAmpersandEqualsSignKeyword_6_0() { return cANDASSIGNAmpersandEqualsSignKeyword_6_0; }

		//ORASSIGN="|="
		public EnumLiteralDeclaration getORASSIGNEnumLiteralDeclaration_7() { return cORASSIGNEnumLiteralDeclaration_7; }

		//"|="
		public Keyword getORASSIGNVerticalLineEqualsSignKeyword_7_0() { return cORASSIGNVerticalLineEqualsSignKeyword_7_0; }

		//XORASSIGN="^="
		public EnumLiteralDeclaration getXORASSIGNEnumLiteralDeclaration_8() { return cXORASSIGNEnumLiteralDeclaration_8; }

		//"^="
		public Keyword getXORASSIGNCircumflexAccentEqualsSignKeyword_8_0() { return cXORASSIGNCircumflexAccentEqualsSignKeyword_8_0; }

		//LSHIFTASSIGN="<<="
		public EnumLiteralDeclaration getLSHIFTASSIGNEnumLiteralDeclaration_9() { return cLSHIFTASSIGNEnumLiteralDeclaration_9; }

		//"<<="
		public Keyword getLSHIFTASSIGNLessThanSignLessThanSignEqualsSignKeyword_9_0() { return cLSHIFTASSIGNLessThanSignLessThanSignEqualsSignKeyword_9_0; }

		//RSHIFTASSIGN=">>="
		public EnumLiteralDeclaration getRSHIFTASSIGNEnumLiteralDeclaration_10() { return cRSHIFTASSIGNEnumLiteralDeclaration_10; }

		//">>="
		public Keyword getRSHIFTASSIGNGreaterThanSignGreaterThanSignEqualsSignKeyword_10_0() { return cRSHIFTASSIGNGreaterThanSignGreaterThanSignEqualsSignKeyword_10_0; }

		//URSHIFTASSIGN=">>>="
		public EnumLiteralDeclaration getURSHIFTASSIGNEnumLiteralDeclaration_11() { return cURSHIFTASSIGNEnumLiteralDeclaration_11; }

		//">>>="
		public Keyword getURSHIFTASSIGNGreaterThanSignGreaterThanSignGreaterThanSignEqualsSignKeyword_11_0() { return cURSHIFTASSIGNGreaterThanSignGreaterThanSignGreaterThanSignEqualsSignKeyword_11_0; }
	}
	
	private TestElements pTest;
	private LITERALElements pLITERAL;
	private BOOLEAN_LITERALElements pBOOLEAN_LITERAL;
	private BooleanValueElements unknownRuleBooleanValue;
	private NUMBER_LITERALElements pNUMBER_LITERAL;
	private INTEGER_LITERALElements pINTEGER_LITERAL;
	private UNLIMITED_LITERALElements pUNLIMITED_LITERAL;
	private TerminalRule tIntegerValue;
	private STRING_LITERALElements pSTRING_LITERAL;
	private NameExpressionElements pNameExpression;
	private QualifiedNamePathElements pQualifiedNamePath;
	private UnqualifiedNameElements pUnqualifiedName;
	private TemplateBindingElements pTemplateBinding;
	private NamedTemplateBindingElements pNamedTemplateBinding;
	private QualifiedNameWithBindingElements pQualifiedNameWithBinding;
	private TupleElements pTuple;
	private TupleElementElements pTupleElement;
	private ExpressionElements pExpression;
	private ConditionalTestExpressionElements pConditionalTestExpression;
	private ConditionalOrExpressionElements pConditionalOrExpression;
	private ConditionalAndExpressionElements pConditionalAndExpression;
	private InclusiveOrExpressionElements pInclusiveOrExpression;
	private ExclusiveOrExpressionElements pExclusiveOrExpression;
	private AndExpressionElements pAndExpression;
	private EqualityExpressionElements pEqualityExpression;
	private ClassificationExpressionElements pClassificationExpression;
	private RelationalExpressionElements pRelationalExpression;
	private ShiftExpressionElements pShiftExpression;
	private AdditiveExpressionElements pAdditiveExpression;
	private MultiplicativeExpressionElements pMultiplicativeExpression;
	private UnaryExpressionElements pUnaryExpression;
	private PrimaryExpressionElements pPrimaryExpression;
	private SuffixExpressionElements pSuffixExpression;
	private OperationCallExpressionElements pOperationCallExpression;
	private PropertyCallExpressionElements pPropertyCallExpression;
	private LinkOperationExpressionElements pLinkOperationExpression;
	private LinkOperationTupleElements pLinkOperationTuple;
	private LinkOperationTupleElementElements pLinkOperationTupleElement;
	private LinkOperationKindElements unknownRuleLinkOperationKind;
	private SequenceOperationExpressionElements pSequenceOperationExpression;
	private SequenceReductionExpressionElements pSequenceReductionExpression;
	private SequenceExpansionExpressionElements pSequenceExpansionExpression;
	private SelectOrRejectOperationElements pSelectOrRejectOperation;
	private SelectOrRejectOperatorElements unknownRuleSelectOrRejectOperator;
	private CollectOrIterateOperationElements pCollectOrIterateOperation;
	private CollectOrIterateOperatorElements unknownRuleCollectOrIterateOperator;
	private ForAllOrExistsOrOneOperationElements pForAllOrExistsOrOneOperation;
	private ForAllOrExistsOrOneOperatorElements unknownRuleForAllOrExistsOrOneOperator;
	private IsUniqueOperationElements pIsUniqueOperation;
	private ValueSpecificationElements pValueSpecification;
	private NonLiteralValueSpecificationElements pNonLiteralValueSpecification;
	private ParenthesizedExpressionElements pParenthesizedExpression;
	private NullExpressionElements pNullExpression;
	private ThisExpressionElements pThisExpression;
	private SuperInvocationExpressionElements pSuperInvocationExpression;
	private InstanceCreationExpressionElements pInstanceCreationExpression;
	private InstanceCreationTupleElements pInstanceCreationTuple;
	private InstanceCreationTupleElementElements pInstanceCreationTupleElement;
	private SequenceConstructionOrAccessCompletionElements pSequenceConstructionOrAccessCompletion;
	private AccessCompletionElements pAccessCompletion;
	private PartialSequenceConstructionCompletionElements pPartialSequenceConstructionCompletion;
	private SequenceConstructionExpressionElements pSequenceConstructionExpression;
	private SequenceElementElements pSequenceElement;
	private ClassExtentExpressionElements pClassExtentExpression;
	private BlockElements pBlock;
	private StatementSequenceElements pStatementSequence;
	private DocumentedStatementElements pDocumentedStatement;
	private InlineStatementElements pInlineStatement;
	private AnnotatedStatementElements pAnnotatedStatement;
	private StatementElements pStatement;
	private AnnotationElements pAnnotation;
	private AnnotationKindElements unknownRuleAnnotationKind;
	private BlockStatementElements pBlockStatement;
	private EmptyStatementElements pEmptyStatement;
	private LocalNameDeclarationStatementElements pLocalNameDeclarationStatement;
	private IfStatementElements pIfStatement;
	private SequentialClausesElements pSequentialClauses;
	private ConcurrentClausesElements pConcurrentClauses;
	private NonFinalClauseElements pNonFinalClause;
	private FinalClauseElements pFinalClause;
	private SwitchStatementElements pSwitchStatement;
	private SwitchClauseElements pSwitchClause;
	private SwitchCaseElements pSwitchCase;
	private SwitchDefaultClauseElements pSwitchDefaultClause;
	private NonEmptyStatementSequenceElements pNonEmptyStatementSequence;
	private WhileStatementElements pWhileStatement;
	private DoStatementElements pDoStatement;
	private ForStatementElements pForStatement;
	private ForControlElements pForControl;
	private LoopVariableDefinitionElements pLoopVariableDefinition;
	private BreakStatementElements pBreakStatement;
	private ReturnStatementElements pReturnStatement;
	private AcceptStatementElements pAcceptStatement;
	private SimpleAcceptStatementCompletionElements pSimpleAcceptStatementCompletion;
	private CompoundAcceptStatementCompletionElements pCompoundAcceptStatementCompletion;
	private AcceptBlockElements pAcceptBlock;
	private AcceptClauseElements pAcceptClause;
	private ClassifyStatementElements pClassifyStatement;
	private ClassificationClauseElements pClassificationClause;
	private ClassificationFromClauseElements pClassificationFromClause;
	private ClassificationToClauseElements pClassificationToClause;
	private ReclassifyAllClauseElements pReclassifyAllClause;
	private QualifiedNameListElements pQualifiedNameList;
	private InvocationOrAssignementOrDeclarationStatementElements pInvocationOrAssignementOrDeclarationStatement;
	private SuperInvocationStatementElements pSuperInvocationStatement;
	private ThisInvocationStatementElements pThisInvocationStatement;
	private InstanceCreationInvocationStatementElements pInstanceCreationInvocationStatement;
	private VariableDeclarationCompletionElements pVariableDeclarationCompletion;
	private AssignmentCompletionElements pAssignmentCompletion;
	private AssignmentOperatorElements unknownRuleAssignmentOperator;
	private TerminalRule tID;
	private TerminalRule tSTRING;
	private TerminalRule tML_COMMENT;
	private TerminalRule tSL_COMMENT;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public AlfGrammarAccess(GrammarProvider grammarProvider,
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

	
	/// *
	//  Test rule
	// * / Test:
	//	("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
	//	("testStatement" statements+=Statement)* ("testBlock" block=Block);
	public TestElements getTestAccess() {
		return (pTest != null) ? pTest : (pTest = new TestElements());
	}
	
	public ParserRule getTestRule() {
		return getTestAccess().getRule();
	}

	////('testStatementSequence' statement += StatementSequence)* ;
	/// *********************************
	// * PrimitiveLiterals
	// ********************************** / LITERAL:
	//	BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL;
	public LITERALElements getLITERALAccess() {
		return (pLITERAL != null) ? pLITERAL : (pLITERAL = new LITERALElements());
	}
	
	public ParserRule getLITERALRule() {
		return getLITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	//BOOLEAN_LITERAL:
	//	value=BooleanValue;
	public BOOLEAN_LITERALElements getBOOLEAN_LITERALAccess() {
		return (pBOOLEAN_LITERAL != null) ? pBOOLEAN_LITERAL : (pBOOLEAN_LITERAL = new BOOLEAN_LITERALElements());
	}
	
	public ParserRule getBOOLEAN_LITERALRule() {
		return getBOOLEAN_LITERALAccess().getRule();
	}

	//enum BooleanValue:
	//	TRUE="true" | FALSE="false";
	public BooleanValueElements getBooleanValueAccess() {
		return (unknownRuleBooleanValue != null) ? unknownRuleBooleanValue : (unknownRuleBooleanValue = new BooleanValueElements());
	}
	
	public EnumRule getBooleanValueRule() {
		return getBooleanValueAccess().getRule();
	}

	//NUMBER_LITERAL:
	//	INTEGER_LITERAL | UNLIMITED_LITERAL;
	public NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return (pNUMBER_LITERAL != null) ? pNUMBER_LITERAL : (pNUMBER_LITERAL = new NUMBER_LITERALElements());
	}
	
	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	//INTEGER_LITERAL:
	//	value=IntegerValue;
	public INTEGER_LITERALElements getINTEGER_LITERALAccess() {
		return (pINTEGER_LITERAL != null) ? pINTEGER_LITERAL : (pINTEGER_LITERAL = new INTEGER_LITERALElements());
	}
	
	public ParserRule getINTEGER_LITERALRule() {
		return getINTEGER_LITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	//UNLIMITED_LITERAL:
	//	value="*";
	public UNLIMITED_LITERALElements getUNLIMITED_LITERALAccess() {
		return (pUNLIMITED_LITERAL != null) ? pUNLIMITED_LITERAL : (pUNLIMITED_LITERAL = new UNLIMITED_LITERALElements());
	}
	
	public ParserRule getUNLIMITED_LITERALRule() {
		return getUNLIMITED_LITERALAccess().getRule();
	}

	//terminal IntegerValue:
	//	("0" | "1".."9" ("_"? "0".."9")*) //DECIMAL 
	//	// BINARY
	//	// HEX
	//	// OCT
	//	| ("0b" | "0B") "0".."1" ("_"? "0".."1")* | ("0x" | "0X") ("0".."9" | "a".."f" | "A".."F") ("_"? ("0".."9" | "a".."f" |
	//	"A".."F"))* | "0" "_"? "0".."7" ("_"? "0".."7")*;
	public TerminalRule getIntegerValueRule() {
		return (tIntegerValue != null) ? tIntegerValue : (tIntegerValue = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "IntegerValue"));
	} 

	//// (suffix = SuffixExpression) ?;
	//STRING_LITERAL:
	//	value=STRING;
	public STRING_LITERALElements getSTRING_LITERALAccess() {
		return (pSTRING_LITERAL != null) ? pSTRING_LITERAL : (pSTRING_LITERAL = new STRING_LITERALElements());
	}
	
	public ParserRule getSTRING_LITERALRule() {
		return getSTRING_LITERALAccess().getRule();
	}

	//NameExpression:
	//	(prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
	//	sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
	//	suffix=SuffixExpression?;
	public NameExpressionElements getNameExpressionAccess() {
		return (pNameExpression != null) ? pNameExpression : (pNameExpression = new NameExpressionElements());
	}
	
	public ParserRule getNameExpressionRule() {
		return getNameExpressionAccess().getRule();
	}

	//QualifiedNamePath:
	//	(namespace+=UnqualifiedName "::")+;
	public QualifiedNamePathElements getQualifiedNamePathAccess() {
		return (pQualifiedNamePath != null) ? pQualifiedNamePath : (pQualifiedNamePath = new QualifiedNamePathElements());
	}
	
	public ParserRule getQualifiedNamePathRule() {
		return getQualifiedNamePathAccess().getRule();
	}

	//UnqualifiedName:
	//	name=ID templateBinding=TemplateBinding?;
	public UnqualifiedNameElements getUnqualifiedNameAccess() {
		return (pUnqualifiedName != null) ? pUnqualifiedName : (pUnqualifiedName = new UnqualifiedNameElements());
	}
	
	public ParserRule getUnqualifiedNameRule() {
		return getUnqualifiedNameAccess().getRule();
	}

	//TemplateBinding:
	//	"<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">";
	public TemplateBindingElements getTemplateBindingAccess() {
		return (pTemplateBinding != null) ? pTemplateBinding : (pTemplateBinding = new TemplateBindingElements());
	}
	
	public ParserRule getTemplateBindingRule() {
		return getTemplateBindingAccess().getRule();
	}

	//NamedTemplateBinding:
	//	formal=ID "=>" actual=QualifiedNameWithBinding;
	public NamedTemplateBindingElements getNamedTemplateBindingAccess() {
		return (pNamedTemplateBinding != null) ? pNamedTemplateBinding : (pNamedTemplateBinding = new NamedTemplateBindingElements());
	}
	
	public ParserRule getNamedTemplateBindingRule() {
		return getNamedTemplateBindingAccess().getRule();
	}

	//QualifiedNameWithBinding:
	//	id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?;
	public QualifiedNameWithBindingElements getQualifiedNameWithBindingAccess() {
		return (pQualifiedNameWithBinding != null) ? pQualifiedNameWithBinding : (pQualifiedNameWithBinding = new QualifiedNameWithBindingElements());
	}
	
	public ParserRule getQualifiedNameWithBindingRule() {
		return getQualifiedNameWithBindingAccess().getRule();
	}

	//Tuple:
	//	{Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")";
	public TupleElements getTupleAccess() {
		return (pTuple != null) ? pTuple : (pTuple = new TupleElements());
	}
	
	public ParserRule getTupleRule() {
		return getTupleAccess().getRule();
	}

	//TupleElement:
	//	argument=Expression;
	public TupleElementElements getTupleElementAccess() {
		return (pTupleElement != null) ? pTupleElement : (pTupleElement = new TupleElementElements());
	}
	
	public ParserRule getTupleElementRule() {
		return getTupleElementAccess().getRule();
	}

	/// **************
	// * Expressions
	// ************** / Expression:
	//	ConditionalTestExpression;
	public ExpressionElements getExpressionAccess() {
		return (pExpression != null) ? pExpression : (pExpression = new ExpressionElements());
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//ConditionalTestExpression:
	//	exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?;
	public ConditionalTestExpressionElements getConditionalTestExpressionAccess() {
		return (pConditionalTestExpression != null) ? pConditionalTestExpression : (pConditionalTestExpression = new ConditionalTestExpressionElements());
	}
	
	public ParserRule getConditionalTestExpressionRule() {
		return getConditionalTestExpressionAccess().getRule();
	}

	//ConditionalOrExpression:
	//	exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*;
	public ConditionalOrExpressionElements getConditionalOrExpressionAccess() {
		return (pConditionalOrExpression != null) ? pConditionalOrExpression : (pConditionalOrExpression = new ConditionalOrExpressionElements());
	}
	
	public ParserRule getConditionalOrExpressionRule() {
		return getConditionalOrExpressionAccess().getRule();
	}

	//ConditionalAndExpression:
	//	exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*;
	public ConditionalAndExpressionElements getConditionalAndExpressionAccess() {
		return (pConditionalAndExpression != null) ? pConditionalAndExpression : (pConditionalAndExpression = new ConditionalAndExpressionElements());
	}
	
	public ParserRule getConditionalAndExpressionRule() {
		return getConditionalAndExpressionAccess().getRule();
	}

	//InclusiveOrExpression:
	//	exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*;
	public InclusiveOrExpressionElements getInclusiveOrExpressionAccess() {
		return (pInclusiveOrExpression != null) ? pInclusiveOrExpression : (pInclusiveOrExpression = new InclusiveOrExpressionElements());
	}
	
	public ParserRule getInclusiveOrExpressionRule() {
		return getInclusiveOrExpressionAccess().getRule();
	}

	//ExclusiveOrExpression:
	//	exp+=AndExpression ("^" exp+=AndExpression)*;
	public ExclusiveOrExpressionElements getExclusiveOrExpressionAccess() {
		return (pExclusiveOrExpression != null) ? pExclusiveOrExpression : (pExclusiveOrExpression = new ExclusiveOrExpressionElements());
	}
	
	public ParserRule getExclusiveOrExpressionRule() {
		return getExclusiveOrExpressionAccess().getRule();
	}

	//AndExpression:
	//	exp+=EqualityExpression ("&" exp+=EqualityExpression)*;
	public AndExpressionElements getAndExpressionAccess() {
		return (pAndExpression != null) ? pAndExpression : (pAndExpression = new AndExpressionElements());
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}

	//EqualityExpression:
	//	exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*;
	public EqualityExpressionElements getEqualityExpressionAccess() {
		return (pEqualityExpression != null) ? pEqualityExpression : (pEqualityExpression = new EqualityExpressionElements());
	}
	
	public ParserRule getEqualityExpressionRule() {
		return getEqualityExpressionAccess().getRule();
	}

	////enum EqualityOperator :
	////	EQUALS = '==' |
	////	NOT_EQUALS = '!='
	////;
	//ClassificationExpression:
	//	exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?;
	public ClassificationExpressionElements getClassificationExpressionAccess() {
		return (pClassificationExpression != null) ? pClassificationExpression : (pClassificationExpression = new ClassificationExpressionElements());
	}
	
	public ParserRule getClassificationExpressionRule() {
		return getClassificationExpressionAccess().getRule();
	}

	////enum ClassificationOperator :
	////	INSTANCEOF = 'instanceof' |
	////	HASTYPE = 'hastype'
	////;
	//RelationalExpression:
	//	left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?;
	public RelationalExpressionElements getRelationalExpressionAccess() {
		return (pRelationalExpression != null) ? pRelationalExpression : (pRelationalExpression = new RelationalExpressionElements());
	}
	
	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}

	////RelationalOperator :
	////	LOWER = '<' |
	////	UPPER = '>' |
	////	LOWER_EQUALS = '<=' |
	////	UPPER_EQUALS = '>='
	////;
	//ShiftExpression:
	//	exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?;
	public ShiftExpressionElements getShiftExpressionAccess() {
		return (pShiftExpression != null) ? pShiftExpression : (pShiftExpression = new ShiftExpressionElements());
	}
	
	public ParserRule getShiftExpressionRule() {
		return getShiftExpressionAccess().getRule();
	}

	////enum ShiftOperator :
	////	LSHIFT = '<<' |
	////	RSHIFT = '>>' |
	////	URSHIFT = '>>>'
	////;
	//AdditiveExpression:
	//	exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*;
	public AdditiveExpressionElements getAdditiveExpressionAccess() {
		return (pAdditiveExpression != null) ? pAdditiveExpression : (pAdditiveExpression = new AdditiveExpressionElements());
	}
	
	public ParserRule getAdditiveExpressionRule() {
		return getAdditiveExpressionAccess().getRule();
	}

	////enum AdditiveOp :
	////	PLUS = '+' |
	////	MINUS = '-'
	////;
	//MultiplicativeExpression:
	//	exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*;
	public MultiplicativeExpressionElements getMultiplicativeExpressionAccess() {
		return (pMultiplicativeExpression != null) ? pMultiplicativeExpression : (pMultiplicativeExpression = new MultiplicativeExpressionElements());
	}
	
	public ParserRule getMultiplicativeExpressionRule() {
		return getMultiplicativeExpressionAccess().getRule();
	}

	////enum MultiplicativeOp :
	////	MULT = '*' |
	////	DIV = '/' |
	////	MOD = '%'
	////;
	//UnaryExpression:
	//	op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression;
	public UnaryExpressionElements getUnaryExpressionAccess() {
		return (pUnaryExpression != null) ? pUnaryExpression : (pUnaryExpression = new UnaryExpressionElements());
	}
	
	public ParserRule getUnaryExpressionRule() {
		return getUnaryExpressionAccess().getRule();
	}

	////PrimaryExpression :
	////	prefix = ValueSpecification (suffix = SuffixExpression)? 
	////;
	//PrimaryExpression:
	//	prefix=ValueSpecification;
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return (pPrimaryExpression != null) ? pPrimaryExpression : (pPrimaryExpression = new PrimaryExpressionElements());
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}

	//SuffixExpression:
	//	OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
	//	SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression;
	public SuffixExpressionElements getSuffixExpressionAccess() {
		return (pSuffixExpression != null) ? pSuffixExpression : (pSuffixExpression = new SuffixExpressionElements());
	}
	
	public ParserRule getSuffixExpressionRule() {
		return getSuffixExpressionAccess().getRule();
	}

	//OperationCallExpression:
	//	"." operationName=ID tuple=Tuple suffix=SuffixExpression?;
	public OperationCallExpressionElements getOperationCallExpressionAccess() {
		return (pOperationCallExpression != null) ? pOperationCallExpression : (pOperationCallExpression = new OperationCallExpressionElements());
	}
	
	public ParserRule getOperationCallExpressionRule() {
		return getOperationCallExpressionAccess().getRule();
	}

	//// OperationCallExpressionWithoutDot :
	//// 	operationName = ID tuple = Tuple (suffix = SuffixExpression)?
	//// ;
	//PropertyCallExpression:
	//	"." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?;
	public PropertyCallExpressionElements getPropertyCallExpressionAccess() {
		return (pPropertyCallExpression != null) ? pPropertyCallExpression : (pPropertyCallExpression = new PropertyCallExpressionElements());
	}
	
	public ParserRule getPropertyCallExpressionRule() {
		return getPropertyCallExpressionAccess().getRule();
	}

	//LinkOperationExpression:
	//	"." kind=LinkOperationKind tuple=LinkOperationTuple;
	public LinkOperationExpressionElements getLinkOperationExpressionAccess() {
		return (pLinkOperationExpression != null) ? pLinkOperationExpression : (pLinkOperationExpression = new LinkOperationExpressionElements());
	}
	
	public ParserRule getLinkOperationExpressionRule() {
		return getLinkOperationExpressionAccess().getRule();
	}

	//LinkOperationTuple:
	//	"(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)*
	//	")";
	public LinkOperationTupleElements getLinkOperationTupleAccess() {
		return (pLinkOperationTuple != null) ? pLinkOperationTuple : (pLinkOperationTuple = new LinkOperationTupleElements());
	}
	
	public ParserRule getLinkOperationTupleRule() {
		return getLinkOperationTupleAccess().getRule();
	}

	////LinkOperationTupleElement :
	////	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
	////;
	//LinkOperationTupleElement:
	//	role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression;
	public LinkOperationTupleElementElements getLinkOperationTupleElementAccess() {
		return (pLinkOperationTupleElement != null) ? pLinkOperationTupleElement : (pLinkOperationTupleElement = new LinkOperationTupleElementElements());
	}
	
	public ParserRule getLinkOperationTupleElementRule() {
		return getLinkOperationTupleElementAccess().getRule();
	}

	//enum LinkOperationKind:
	//	CREATE="createLink" | DESTROY="destroyLink" | CLEAR="clearAssoc";
	public LinkOperationKindElements getLinkOperationKindAccess() {
		return (unknownRuleLinkOperationKind != null) ? unknownRuleLinkOperationKind : (unknownRuleLinkOperationKind = new LinkOperationKindElements());
	}
	
	public EnumRule getLinkOperationKindRule() {
		return getLinkOperationKindAccess().getRule();
	}

	//SequenceOperationExpression: //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
	//	"->" operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?;
	public SequenceOperationExpressionElements getSequenceOperationExpressionAccess() {
		return (pSequenceOperationExpression != null) ? pSequenceOperationExpression : (pSequenceOperationExpression = new SequenceOperationExpressionElements());
	}
	
	public ParserRule getSequenceOperationExpressionRule() {
		return getSequenceOperationExpressionAccess().getRule();
	}

	//SequenceReductionExpression:
	//	"->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?;
	public SequenceReductionExpressionElements getSequenceReductionExpressionAccess() {
		return (pSequenceReductionExpression != null) ? pSequenceReductionExpression : (pSequenceReductionExpression = new SequenceReductionExpressionElements());
	}
	
	public ParserRule getSequenceReductionExpressionRule() {
		return getSequenceReductionExpressionAccess().getRule();
	}

	//SequenceExpansionExpression:
	//	SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation;
	public SequenceExpansionExpressionElements getSequenceExpansionExpressionAccess() {
		return (pSequenceExpansionExpression != null) ? pSequenceExpansionExpression : (pSequenceExpansionExpression = new SequenceExpansionExpressionElements());
	}
	
	public ParserRule getSequenceExpansionExpressionRule() {
		return getSequenceExpansionExpressionAccess().getRule();
	}

	//SelectOrRejectOperation:
	//	"->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public SelectOrRejectOperationElements getSelectOrRejectOperationAccess() {
		return (pSelectOrRejectOperation != null) ? pSelectOrRejectOperation : (pSelectOrRejectOperation = new SelectOrRejectOperationElements());
	}
	
	public ParserRule getSelectOrRejectOperationRule() {
		return getSelectOrRejectOperationAccess().getRule();
	}

	//enum SelectOrRejectOperator:
	//	SELECT="select" | REJECT="reject";
	public SelectOrRejectOperatorElements getSelectOrRejectOperatorAccess() {
		return (unknownRuleSelectOrRejectOperator != null) ? unknownRuleSelectOrRejectOperator : (unknownRuleSelectOrRejectOperator = new SelectOrRejectOperatorElements());
	}
	
	public EnumRule getSelectOrRejectOperatorRule() {
		return getSelectOrRejectOperatorAccess().getRule();
	}

	//CollectOrIterateOperation:
	//	"->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public CollectOrIterateOperationElements getCollectOrIterateOperationAccess() {
		return (pCollectOrIterateOperation != null) ? pCollectOrIterateOperation : (pCollectOrIterateOperation = new CollectOrIterateOperationElements());
	}
	
	public ParserRule getCollectOrIterateOperationRule() {
		return getCollectOrIterateOperationAccess().getRule();
	}

	//enum CollectOrIterateOperator:
	//	COLLECT="collect" | ITERATE="iterate";
	public CollectOrIterateOperatorElements getCollectOrIterateOperatorAccess() {
		return (unknownRuleCollectOrIterateOperator != null) ? unknownRuleCollectOrIterateOperator : (unknownRuleCollectOrIterateOperator = new CollectOrIterateOperatorElements());
	}
	
	public EnumRule getCollectOrIterateOperatorRule() {
		return getCollectOrIterateOperatorAccess().getRule();
	}

	//ForAllOrExistsOrOneOperation:
	//	"->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public ForAllOrExistsOrOneOperationElements getForAllOrExistsOrOneOperationAccess() {
		return (pForAllOrExistsOrOneOperation != null) ? pForAllOrExistsOrOneOperation : (pForAllOrExistsOrOneOperation = new ForAllOrExistsOrOneOperationElements());
	}
	
	public ParserRule getForAllOrExistsOrOneOperationRule() {
		return getForAllOrExistsOrOneOperationAccess().getRule();
	}

	//enum ForAllOrExistsOrOneOperator:
	//	FORALL="forAll" | EXISTS="exists" | ONE="one";
	public ForAllOrExistsOrOneOperatorElements getForAllOrExistsOrOneOperatorAccess() {
		return (unknownRuleForAllOrExistsOrOneOperator != null) ? unknownRuleForAllOrExistsOrOneOperator : (unknownRuleForAllOrExistsOrOneOperator = new ForAllOrExistsOrOneOperatorElements());
	}
	
	public EnumRule getForAllOrExistsOrOneOperatorRule() {
		return getForAllOrExistsOrOneOperatorAccess().getRule();
	}

	//IsUniqueOperation:
	//	"->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public IsUniqueOperationElements getIsUniqueOperationAccess() {
		return (pIsUniqueOperation != null) ? pIsUniqueOperation : (pIsUniqueOperation = new IsUniqueOperationElements());
	}
	
	public ParserRule getIsUniqueOperationRule() {
		return getIsUniqueOperationAccess().getRule();
	}

	//ValueSpecification:
	//	NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
	//	ParenthesizedExpression | NullExpression;
	public ValueSpecificationElements getValueSpecificationAccess() {
		return (pValueSpecification != null) ? pValueSpecification : (pValueSpecification = new ValueSpecificationElements());
	}
	
	public ParserRule getValueSpecificationRule() {
		return getValueSpecificationAccess().getRule();
	}

	//NonLiteralValueSpecification:
	//	NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression;
	public NonLiteralValueSpecificationElements getNonLiteralValueSpecificationAccess() {
		return (pNonLiteralValueSpecification != null) ? pNonLiteralValueSpecification : (pNonLiteralValueSpecification = new NonLiteralValueSpecificationElements());
	}
	
	public ParserRule getNonLiteralValueSpecificationRule() {
		return getNonLiteralValueSpecificationAccess().getRule();
	}

	//ParenthesizedExpression:
	//	"(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?;
	public ParenthesizedExpressionElements getParenthesizedExpressionAccess() {
		return (pParenthesizedExpression != null) ? pParenthesizedExpression : (pParenthesizedExpression = new ParenthesizedExpressionElements());
	}
	
	public ParserRule getParenthesizedExpressionRule() {
		return getParenthesizedExpressionAccess().getRule();
	}

	//NullExpression:
	//	{NullExpression} "null";
	public NullExpressionElements getNullExpressionAccess() {
		return (pNullExpression != null) ? pNullExpression : (pNullExpression = new NullExpressionElements());
	}
	
	public ParserRule getNullExpressionRule() {
		return getNullExpressionAccess().getRule();
	}

	//ThisExpression:
	//	{ThisExpression} "this" suffix=SuffixExpression?;
	public ThisExpressionElements getThisExpressionAccess() {
		return (pThisExpression != null) ? pThisExpression : (pThisExpression = new ThisExpressionElements());
	}
	
	public ParserRule getThisExpressionRule() {
		return getThisExpressionAccess().getRule();
	}

	//// SuperInvocationExpression :
	////	//{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
	////	'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression) 
	////;
	//SuperInvocationExpression: //{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
	////'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
	////'super' ((tuple = Tuple) |
	////		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
	//	"super" (tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple);
	public SuperInvocationExpressionElements getSuperInvocationExpressionAccess() {
		return (pSuperInvocationExpression != null) ? pSuperInvocationExpression : (pSuperInvocationExpression = new SuperInvocationExpressionElements());
	}
	
	public ParserRule getSuperInvocationExpressionRule() {
		return getSuperInvocationExpressionAccess().getRule();
	}

	////InstanceCreationExpression :
	////'new' constructor=QualifiedNameWithBinding 
	////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
	////'new' constructor=QualifiedNameWithBinding 
	////	tuple = Tuple (suffix = SuffixExpression) ?
	////;
	//InstanceCreationExpression: //'new' constructor=QualifiedNameWithBinding 
	////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
	//	"new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?;
	public InstanceCreationExpressionElements getInstanceCreationExpressionAccess() {
		return (pInstanceCreationExpression != null) ? pInstanceCreationExpression : (pInstanceCreationExpression = new InstanceCreationExpressionElements());
	}
	
	public ParserRule getInstanceCreationExpressionRule() {
		return getInstanceCreationExpressionAccess().getRule();
	}

	//InstanceCreationTuple:
	//	{InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
	//	instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")";
	public InstanceCreationTupleElements getInstanceCreationTupleAccess() {
		return (pInstanceCreationTuple != null) ? pInstanceCreationTuple : (pInstanceCreationTuple = new InstanceCreationTupleElements());
	}
	
	public ParserRule getInstanceCreationTupleRule() {
		return getInstanceCreationTupleAccess().getRule();
	}

	////LinkOperationTupleElement :
	////	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
	////;
	//InstanceCreationTupleElement:
	//	role=ID "=>" object=Expression;
	public InstanceCreationTupleElementElements getInstanceCreationTupleElementAccess() {
		return (pInstanceCreationTupleElement != null) ? pInstanceCreationTupleElement : (pInstanceCreationTupleElement = new InstanceCreationTupleElementElements());
	}
	
	public ParserRule getInstanceCreationTupleElementRule() {
		return getInstanceCreationTupleElementAccess().getRule();
	}

	//SequenceConstructionOrAccessCompletion:
	//	multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
	//	sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression;
	public SequenceConstructionOrAccessCompletionElements getSequenceConstructionOrAccessCompletionAccess() {
		return (pSequenceConstructionOrAccessCompletion != null) ? pSequenceConstructionOrAccessCompletion : (pSequenceConstructionOrAccessCompletion = new SequenceConstructionOrAccessCompletionElements());
	}
	
	public ParserRule getSequenceConstructionOrAccessCompletionRule() {
		return getSequenceConstructionOrAccessCompletionAccess().getRule();
	}

	//AccessCompletion:
	//	accessIndex=Expression "]";
	public AccessCompletionElements getAccessCompletionAccess() {
		return (pAccessCompletion != null) ? pAccessCompletion : (pAccessCompletion = new AccessCompletionElements());
	}
	
	public ParserRule getAccessCompletionRule() {
		return getAccessCompletionAccess().getRule();
	}

	//PartialSequenceConstructionCompletion:
	//	"]" expression=SequenceConstructionExpression;
	public PartialSequenceConstructionCompletionElements getPartialSequenceConstructionCompletionAccess() {
		return (pPartialSequenceConstructionCompletion != null) ? pPartialSequenceConstructionCompletion : (pPartialSequenceConstructionCompletion = new PartialSequenceConstructionCompletionElements());
	}
	
	public ParserRule getPartialSequenceConstructionCompletionRule() {
		return getPartialSequenceConstructionCompletionAccess().getRule();
	}

	////SequenceConstructionCompletion :
	////	(multiplicityIndicator ?= '['']')? expression = SequenceConstructionExpression
	////;
	//SequenceConstructionExpression:
	//	"{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}";
	public SequenceConstructionExpressionElements getSequenceConstructionExpressionAccess() {
		return (pSequenceConstructionExpression != null) ? pSequenceConstructionExpression : (pSequenceConstructionExpression = new SequenceConstructionExpressionElements());
	}
	
	public ParserRule getSequenceConstructionExpressionRule() {
		return getSequenceConstructionExpressionAccess().getRule();
	}

	//SequenceElement:
	//	Expression | SequenceConstructionExpression;
	public SequenceElementElements getSequenceElementAccess() {
		return (pSequenceElement != null) ? pSequenceElement : (pSequenceElement = new SequenceElementElements());
	}
	
	public ParserRule getSequenceElementRule() {
		return getSequenceElementAccess().getRule();
	}

	//ClassExtentExpression:
	//	{ClassExtentExpression} "." "allInstances" "(" ")";
	public ClassExtentExpressionElements getClassExtentExpressionAccess() {
		return (pClassExtentExpression != null) ? pClassExtentExpression : (pClassExtentExpression = new ClassExtentExpressionElements());
	}
	
	public ParserRule getClassExtentExpressionRule() {
		return getClassExtentExpressionAccess().getRule();
	}

	/// *****************
	// * Statements
	// **************** / Block:
	//	"{" {Block} sequence=StatementSequence? "}";
	public BlockElements getBlockAccess() {
		return (pBlock != null) ? pBlock : (pBlock = new BlockElements());
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}

	//StatementSequence:
	//	statements+=DocumentedStatement+;
	public StatementSequenceElements getStatementSequenceAccess() {
		return (pStatementSequence != null) ? pStatementSequence : (pStatementSequence = new StatementSequenceElements());
	}
	
	public ParserRule getStatementSequenceRule() {
		return getStatementSequenceAccess().getRule();
	}

	//DocumentedStatement:
	//	comment=(ML_COMMENT | SL_COMMENT)? statement=Statement;
	public DocumentedStatementElements getDocumentedStatementAccess() {
		return (pDocumentedStatement != null) ? pDocumentedStatement : (pDocumentedStatement = new DocumentedStatementElements());
	}
	
	public ParserRule getDocumentedStatementRule() {
		return getDocumentedStatementAccess().getRule();
	}

	//InlineStatement:
	//	"/ *@" "inline" "(" langageName=ID ")" body=STRING "* /";
	public InlineStatementElements getInlineStatementAccess() {
		return (pInlineStatement != null) ? pInlineStatement : (pInlineStatement = new InlineStatementElements());
	}
	
	public ParserRule getInlineStatementRule() {
		return getInlineStatementAccess().getRule();
	}

	//AnnotatedStatement:
	//	"//@" annotation= //block = Block
	//	Annotation statement=Statement;
	public AnnotatedStatementElements getAnnotatedStatementAccess() {
		return (pAnnotatedStatement != null) ? pAnnotatedStatement : (pAnnotatedStatement = new AnnotatedStatementElements());
	}
	
	public ParserRule getAnnotatedStatementRule() {
		return getAnnotatedStatementAccess().getRule();
	}

	//Statement:
	//	AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement |
	//	SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement |
	//	ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement | ThisInvocationStatement
	//	| InstanceCreationInvocationStatement;
	public StatementElements getStatementAccess() {
		return (pStatement != null) ? pStatement : (pStatement = new StatementElements());
	}
	
	public ParserRule getStatementRule() {
		return getStatementAccess().getRule();
	}

	//Annotation:
	//	kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?;
	public AnnotationElements getAnnotationAccess() {
		return (pAnnotation != null) ? pAnnotation : (pAnnotation = new AnnotationElements());
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}

	//enum AnnotationKind:
	//	ISOLATED="isolated" | DETERMINED="determined" | ASSURED="assured" | PARALLEL="parallel";
	public AnnotationKindElements getAnnotationKindAccess() {
		return (unknownRuleAnnotationKind != null) ? unknownRuleAnnotationKind : (unknownRuleAnnotationKind = new AnnotationKindElements());
	}
	
	public EnumRule getAnnotationKindRule() {
		return getAnnotationKindAccess().getRule();
	}

	//BlockStatement:
	//	block=Block;
	public BlockStatementElements getBlockStatementAccess() {
		return (pBlockStatement != null) ? pBlockStatement : (pBlockStatement = new BlockStatementElements());
	}
	
	public ParserRule getBlockStatementRule() {
		return getBlockStatementAccess().getRule();
	}

	//EmptyStatement:
	//	{EmptyStatement} ";";
	public EmptyStatementElements getEmptyStatementAccess() {
		return (pEmptyStatement != null) ? pEmptyStatement : (pEmptyStatement = new EmptyStatementElements());
	}
	
	public ParserRule getEmptyStatementRule() {
		return getEmptyStatementAccess().getRule();
	}

	//LocalNameDeclarationStatement:
	//	"let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
	//	"=" init=SequenceElement ";";
	public LocalNameDeclarationStatementElements getLocalNameDeclarationStatementAccess() {
		return (pLocalNameDeclarationStatement != null) ? pLocalNameDeclarationStatement : (pLocalNameDeclarationStatement = new LocalNameDeclarationStatementElements());
	}
	
	public ParserRule getLocalNameDeclarationStatementRule() {
		return getLocalNameDeclarationStatementAccess().getRule();
	}

	//IfStatement:
	//	"if" sequentialClausses=SequentialClauses finalClause=FinalClause?;
	public IfStatementElements getIfStatementAccess() {
		return (pIfStatement != null) ? pIfStatement : (pIfStatement = new IfStatementElements());
	}
	
	public ParserRule getIfStatementRule() {
		return getIfStatementAccess().getRule();
	}

	//SequentialClauses:
	//	conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*;
	public SequentialClausesElements getSequentialClausesAccess() {
		return (pSequentialClauses != null) ? pSequentialClauses : (pSequentialClauses = new SequentialClausesElements());
	}
	
	public ParserRule getSequentialClausesRule() {
		return getSequentialClausesAccess().getRule();
	}

	//ConcurrentClauses:
	//	nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*;
	public ConcurrentClausesElements getConcurrentClausesAccess() {
		return (pConcurrentClauses != null) ? pConcurrentClauses : (pConcurrentClauses = new ConcurrentClausesElements());
	}
	
	public ParserRule getConcurrentClausesRule() {
		return getConcurrentClausesAccess().getRule();
	}

	//NonFinalClause:
	//	"(" condition=Expression ")" block=Block;
	public NonFinalClauseElements getNonFinalClauseAccess() {
		return (pNonFinalClause != null) ? pNonFinalClause : (pNonFinalClause = new NonFinalClauseElements());
	}
	
	public ParserRule getNonFinalClauseRule() {
		return getNonFinalClauseAccess().getRule();
	}

	//FinalClause:
	//	"else" block=Block;
	public FinalClauseElements getFinalClauseAccess() {
		return (pFinalClause != null) ? pFinalClause : (pFinalClause = new FinalClauseElements());
	}
	
	public ParserRule getFinalClauseRule() {
		return getFinalClauseAccess().getRule();
	}

	//SwitchStatement:
	//	"switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}";
	public SwitchStatementElements getSwitchStatementAccess() {
		return (pSwitchStatement != null) ? pSwitchStatement : (pSwitchStatement = new SwitchStatementElements());
	}
	
	public ParserRule getSwitchStatementRule() {
		return getSwitchStatementAccess().getRule();
	}

	//SwitchClause:
	//	switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence;
	public SwitchClauseElements getSwitchClauseAccess() {
		return (pSwitchClause != null) ? pSwitchClause : (pSwitchClause = new SwitchClauseElements());
	}
	
	public ParserRule getSwitchClauseRule() {
		return getSwitchClauseAccess().getRule();
	}

	//SwitchCase:
	//	"case" expression=Expression ":";
	public SwitchCaseElements getSwitchCaseAccess() {
		return (pSwitchCase != null) ? pSwitchCase : (pSwitchCase = new SwitchCaseElements());
	}
	
	public ParserRule getSwitchCaseRule() {
		return getSwitchCaseAccess().getRule();
	}

	//SwitchDefaultClause:
	//	"default" ":" statementSequence=NonEmptyStatementSequence;
	public SwitchDefaultClauseElements getSwitchDefaultClauseAccess() {
		return (pSwitchDefaultClause != null) ? pSwitchDefaultClause : (pSwitchDefaultClause = new SwitchDefaultClauseElements());
	}
	
	public ParserRule getSwitchDefaultClauseRule() {
		return getSwitchDefaultClauseAccess().getRule();
	}

	//NonEmptyStatementSequence:
	//	statement+=DocumentedStatement+;
	public NonEmptyStatementSequenceElements getNonEmptyStatementSequenceAccess() {
		return (pNonEmptyStatementSequence != null) ? pNonEmptyStatementSequence : (pNonEmptyStatementSequence = new NonEmptyStatementSequenceElements());
	}
	
	public ParserRule getNonEmptyStatementSequenceRule() {
		return getNonEmptyStatementSequenceAccess().getRule();
	}

	/// * WHILE STATEMENTS * / WhileStatement:
	//	"while" "(" condition=Expression ")" block=Block;
	public WhileStatementElements getWhileStatementAccess() {
		return (pWhileStatement != null) ? pWhileStatement : (pWhileStatement = new WhileStatementElements());
	}
	
	public ParserRule getWhileStatementRule() {
		return getWhileStatementAccess().getRule();
	}

	/// * DO STATEMENTS * / DoStatement:
	//	"do" block=Block "while" "(" condition=Expression ")" ";";
	public DoStatementElements getDoStatementAccess() {
		return (pDoStatement != null) ? pDoStatement : (pDoStatement = new DoStatementElements());
	}
	
	public ParserRule getDoStatementRule() {
		return getDoStatementAccess().getRule();
	}

	/// * FOR STATEMENTS * / ForStatement:
	//	"for" "(" control=ForControl ")" block=Block;
	public ForStatementElements getForStatementAccess() {
		return (pForStatement != null) ? pForStatement : (pForStatement = new ForStatementElements());
	}
	
	public ParserRule getForStatementRule() {
		return getForStatementAccess().getRule();
	}

	//ForControl:
	//	loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*;
	public ForControlElements getForControlAccess() {
		return (pForControl != null) ? pForControl : (pForControl = new ForControlElements());
	}
	
	public ParserRule getForControlRule() {
		return getForControlAccess().getRule();
	}

	//LoopVariableDefinition:
	//	name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
	//	expression=Expression;
	public LoopVariableDefinitionElements getLoopVariableDefinitionAccess() {
		return (pLoopVariableDefinition != null) ? pLoopVariableDefinition : (pLoopVariableDefinition = new LoopVariableDefinitionElements());
	}
	
	public ParserRule getLoopVariableDefinitionRule() {
		return getLoopVariableDefinitionAccess().getRule();
	}

	/// * BREAK STATEMENTS * / BreakStatement:
	//	{BreakStatement} "break" ";";
	public BreakStatementElements getBreakStatementAccess() {
		return (pBreakStatement != null) ? pBreakStatement : (pBreakStatement = new BreakStatementElements());
	}
	
	public ParserRule getBreakStatementRule() {
		return getBreakStatementAccess().getRule();
	}

	/// * RETURN STATEMENTS * / ReturnStatement:
	//	"return" expression=Expression ";";
	public ReturnStatementElements getReturnStatementAccess() {
		return (pReturnStatement != null) ? pReturnStatement : (pReturnStatement = new ReturnStatementElements());
	}
	
	public ParserRule getReturnStatementRule() {
		return getReturnStatementAccess().getRule();
	}

	/// * ACCEPT STATEMENTS * / AcceptStatement:
	//	clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion);
	public AcceptStatementElements getAcceptStatementAccess() {
		return (pAcceptStatement != null) ? pAcceptStatement : (pAcceptStatement = new AcceptStatementElements());
	}
	
	public ParserRule getAcceptStatementRule() {
		return getAcceptStatementAccess().getRule();
	}

	//SimpleAcceptStatementCompletion:
	//	{SimpleAcceptStatementCompletion} ";";
	public SimpleAcceptStatementCompletionElements getSimpleAcceptStatementCompletionAccess() {
		return (pSimpleAcceptStatementCompletion != null) ? pSimpleAcceptStatementCompletion : (pSimpleAcceptStatementCompletion = new SimpleAcceptStatementCompletionElements());
	}
	
	public ParserRule getSimpleAcceptStatementCompletionRule() {
		return getSimpleAcceptStatementCompletionAccess().getRule();
	}

	//CompoundAcceptStatementCompletion:
	//	block=Block ("or" acceptBlock+=AcceptBlock)*;
	public CompoundAcceptStatementCompletionElements getCompoundAcceptStatementCompletionAccess() {
		return (pCompoundAcceptStatementCompletion != null) ? pCompoundAcceptStatementCompletion : (pCompoundAcceptStatementCompletion = new CompoundAcceptStatementCompletionElements());
	}
	
	public ParserRule getCompoundAcceptStatementCompletionRule() {
		return getCompoundAcceptStatementCompletionAccess().getRule();
	}

	//AcceptBlock:
	//	clause=AcceptClause block=Block;
	public AcceptBlockElements getAcceptBlockAccess() {
		return (pAcceptBlock != null) ? pAcceptBlock : (pAcceptBlock = new AcceptBlockElements());
	}
	
	public ParserRule getAcceptBlockRule() {
		return getAcceptBlockAccess().getRule();
	}

	//AcceptClause:
	//	"accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")";
	public AcceptClauseElements getAcceptClauseAccess() {
		return (pAcceptClause != null) ? pAcceptClause : (pAcceptClause = new AcceptClauseElements());
	}
	
	public ParserRule getAcceptClauseRule() {
		return getAcceptClauseAccess().getRule();
	}

	/// * CLASSIFY STATEMENTS * / ClassifyStatement:
	//	"classify" expression=Expression clause=ClassificationClause ";";
	public ClassifyStatementElements getClassifyStatementAccess() {
		return (pClassifyStatement != null) ? pClassifyStatement : (pClassifyStatement = new ClassifyStatementElements());
	}
	
	public ParserRule getClassifyStatementRule() {
		return getClassifyStatementAccess().getRule();
	}

	//ClassificationClause:
	//	classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
	//	reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause;
	public ClassificationClauseElements getClassificationClauseAccess() {
		return (pClassificationClause != null) ? pClassificationClause : (pClassificationClause = new ClassificationClauseElements());
	}
	
	public ParserRule getClassificationClauseRule() {
		return getClassificationClauseAccess().getRule();
	}

	//ClassificationFromClause:
	//	"from" qualifiedNameList=QualifiedNameList;
	public ClassificationFromClauseElements getClassificationFromClauseAccess() {
		return (pClassificationFromClause != null) ? pClassificationFromClause : (pClassificationFromClause = new ClassificationFromClauseElements());
	}
	
	public ParserRule getClassificationFromClauseRule() {
		return getClassificationFromClauseAccess().getRule();
	}

	//ClassificationToClause:
	//	"to" qualifiedNameList=QualifiedNameList;
	public ClassificationToClauseElements getClassificationToClauseAccess() {
		return (pClassificationToClause != null) ? pClassificationToClause : (pClassificationToClause = new ClassificationToClauseElements());
	}
	
	public ParserRule getClassificationToClauseRule() {
		return getClassificationToClauseAccess().getRule();
	}

	//ReclassifyAllClause:
	//	{ReclassifyAllClause} "from" "*";
	public ReclassifyAllClauseElements getReclassifyAllClauseAccess() {
		return (pReclassifyAllClause != null) ? pReclassifyAllClause : (pReclassifyAllClause = new ReclassifyAllClauseElements());
	}
	
	public ParserRule getReclassifyAllClauseRule() {
		return getReclassifyAllClauseAccess().getRule();
	}

	//QualifiedNameList:
	//	qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*;
	public QualifiedNameListElements getQualifiedNameListAccess() {
		return (pQualifiedNameList != null) ? pQualifiedNameList : (pQualifiedNameList = new QualifiedNameListElements());
	}
	
	public ParserRule getQualifiedNameListRule() {
		return getQualifiedNameListAccess().getRule();
	}

	//InvocationOrAssignementOrDeclarationStatement:
	//	typePart_OR_assignedPart_OR_invocationPart=NameExpression (variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
	//	| assignmentCompletion=AssignmentCompletion)? ";";
	public InvocationOrAssignementOrDeclarationStatementElements getInvocationOrAssignementOrDeclarationStatementAccess() {
		return (pInvocationOrAssignementOrDeclarationStatement != null) ? pInvocationOrAssignementOrDeclarationStatement : (pInvocationOrAssignementOrDeclarationStatement = new InvocationOrAssignementOrDeclarationStatementElements());
	}
	
	public ParserRule getInvocationOrAssignementOrDeclarationStatementRule() {
		return getInvocationOrAssignementOrDeclarationStatementAccess().getRule();
	}

	//SuperInvocationStatement:
	//	_super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
	//	";";
	public SuperInvocationStatementElements getSuperInvocationStatementAccess() {
		return (pSuperInvocationStatement != null) ? pSuperInvocationStatement : (pSuperInvocationStatement = new SuperInvocationStatementElements());
	}
	
	public ParserRule getSuperInvocationStatementRule() {
		return getSuperInvocationStatementAccess().getRule();
	}

	//ThisInvocationStatement: //_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
	//	_this=ThisExpression assignmentCompletion=AssignmentCompletion? ";";
	public ThisInvocationStatementElements getThisInvocationStatementAccess() {
		return (pThisInvocationStatement != null) ? pThisInvocationStatement : (pThisInvocationStatement = new ThisInvocationStatementElements());
	}
	
	public ParserRule getThisInvocationStatementRule() {
		return getThisInvocationStatementAccess().getRule();
	}

	//InstanceCreationInvocationStatement:
	//	_new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
	//	";";
	public InstanceCreationInvocationStatementElements getInstanceCreationInvocationStatementAccess() {
		return (pInstanceCreationInvocationStatement != null) ? pInstanceCreationInvocationStatement : (pInstanceCreationInvocationStatement = new InstanceCreationInvocationStatementElements());
	}
	
	public ParserRule getInstanceCreationInvocationStatementRule() {
		return getInstanceCreationInvocationStatementAccess().getRule();
	}

	////SuffixCompletion :
	////	suffix = SuffixExpression
	////;
	//VariableDeclarationCompletion:
	//	(multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion;
	public VariableDeclarationCompletionElements getVariableDeclarationCompletionAccess() {
		return (pVariableDeclarationCompletion != null) ? pVariableDeclarationCompletion : (pVariableDeclarationCompletion = new VariableDeclarationCompletionElements());
	}
	
	public ParserRule getVariableDeclarationCompletionRule() {
		return getVariableDeclarationCompletionAccess().getRule();
	}

	////op=('=' | '+=' | '-=' | '*=' | '%=' | '/=' | '&=' |
	////	'|=' | '^=' | '<<=' | '>>=' | '>>>=') rightHandSide = Expression
	//AssignmentCompletion:
	//	op=AssignmentOperator rightHandSide=SequenceElement;
	public AssignmentCompletionElements getAssignmentCompletionAccess() {
		return (pAssignmentCompletion != null) ? pAssignmentCompletion : (pAssignmentCompletion = new AssignmentCompletionElements());
	}
	
	public ParserRule getAssignmentCompletionRule() {
		return getAssignmentCompletionAccess().getRule();
	}

	//enum AssignmentOperator:
	//	ASSIGN="=" | PLUSASSIGN="+=" | MINUSASSIGN="-=" | MULTASSIGN="*=" | MODASSIGN="%=" | DIVASSIGN="/=" | ANDASSIGN="&=" |
	//	ORASSIGN="|=" | XORASSIGN="^=" | LSHIFTASSIGN="<<=" | RSHIFTASSIGN=">>=" | URSHIFTASSIGN=">>>=";
	public AssignmentOperatorElements getAssignmentOperatorAccess() {
		return (unknownRuleAssignmentOperator != null) ? unknownRuleAssignmentOperator : (unknownRuleAssignmentOperator = new AssignmentOperatorElements());
	}
	
	public EnumRule getAssignmentOperatorRule() {
		return getAssignmentOperatorAccess().getRule();
	}

	/// ****************
	// * Terminals
	// ***************** / //terminal DOUBLE_COLON : '::' ;
	//terminal ID:
	//	("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")* | "\'"->"\'";
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return (tSTRING != null) ? tSTRING : (tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	//terminal ML_COMMENT:
	//	"/ *" !"@"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return (tML_COMMENT != null) ? tML_COMMENT : (tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	////terminal IDENTIFIER : ID  ;
	////terminal IDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*  | ('\'' -> '\'')  ;
	////terminal DOCUMENTATION_COMMENT : '/ *' -> '* /' ;
	////terminal ML_COMMENT	: '/°' -> '°/';
	////terminal SL_COMMENT 	: '°°' !('\n'|'\r')* ('\r'? '\n')?;
	////terminal WS			: (' '|'\t'|'\r'|'\n')+; terminal SL_COMMENT:
	//	"//" !("\n" | "\r" | "@")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return (tSL_COMMENT != null) ? tSL_COMMENT : (tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
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
