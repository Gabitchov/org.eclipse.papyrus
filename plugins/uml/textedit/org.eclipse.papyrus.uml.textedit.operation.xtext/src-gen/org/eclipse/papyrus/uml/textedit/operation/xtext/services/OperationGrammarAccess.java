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

package org.eclipse.papyrus.uml.textedit.operation.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;

@Singleton
public class OperationGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class OperationDefinitionOrStubElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OperationDefinitionOrStub");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cDeclarationAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cDeclarationOperationDeclarationParserRuleCall_0_0 = (RuleCall)cDeclarationAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cBodyAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cBodyBlockParserRuleCall_1_1_0 = (RuleCall)cBodyAssignment_1_1.eContents().get(0);
		
		//OperationDefinitionOrStub:
		//
		//	declaration=OperationDeclaration (";" | body=Block);
		public ParserRule getRule() { return rule; }

		//declaration=OperationDeclaration (";" | body=Block)
		public Group getGroup() { return cGroup; }

		//declaration=OperationDeclaration
		public Assignment getDeclarationAssignment_0() { return cDeclarationAssignment_0; }

		//OperationDeclaration
		public RuleCall getDeclarationOperationDeclarationParserRuleCall_0_0() { return cDeclarationOperationDeclarationParserRuleCall_0_0; }

		//";" | body=Block
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//";"
		public Keyword getSemicolonKeyword_1_0() { return cSemicolonKeyword_1_0; }

		//body=Block
		public Assignment getBodyAssignment_1_1() { return cBodyAssignment_1_1; }

		//Block
		public RuleCall getBodyBlockParserRuleCall_1_1_0() { return cBodyBlockParserRuleCall_1_1_0; }
	}

	public class OperationDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OperationDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cIsConstructorAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cIsConstructorCreateKeyword_0_0_0 = (Keyword)cIsConstructorAssignment_0_0.eContents().get(0);
		private final Assignment cIsDestructorAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cIsDestructorDestroyKeyword_0_1_0 = (Keyword)cIsDestructorAssignment_0_1.eContents().get(0);
		private final Assignment cVisibilityIndicatorAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVisibilityIndicatorVisibilityIndicatorEnumRuleCall_1_0 = (RuleCall)cVisibilityIndicatorAssignment_1.eContents().get(0);
		private final Assignment cAbstractAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cAbstractAbstractKeyword_2_0 = (Keyword)cAbstractAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Assignment cFormalParametersAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFormalParametersFormalParametersParserRuleCall_4_0 = (RuleCall)cFormalParametersAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cReturnTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cReturnTypeTypePartParserRuleCall_5_1_0 = (RuleCall)cReturnTypeAssignment_5_1.eContents().get(0);
		private final Assignment cRedefinitionAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cRedefinitionRedefinitionClauseParserRuleCall_6_0 = (RuleCall)cRedefinitionAssignment_6.eContents().get(0);
		
		//OperationDeclaration:
		//
		//	(isConstructor?="@Create" | isDestructor?="@Destroy")? visibilityIndicator=VisibilityIndicator? abstract?="abstract"?
		//
		//	name=ID formalParameters=FormalParameters (":" returnType=TypePart)? redefinition=RedefinitionClause?;
		public ParserRule getRule() { return rule; }

		//(isConstructor?="@Create" | isDestructor?="@Destroy")? visibilityIndicator=VisibilityIndicator? abstract?="abstract"?
		//
		//name=ID formalParameters=FormalParameters (":" returnType=TypePart)? redefinition=RedefinitionClause?
		public Group getGroup() { return cGroup; }

		//(isConstructor?="@Create" | isDestructor?="@Destroy")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//isConstructor?="@Create"
		public Assignment getIsConstructorAssignment_0_0() { return cIsConstructorAssignment_0_0; }

		//"@Create"
		public Keyword getIsConstructorCreateKeyword_0_0_0() { return cIsConstructorCreateKeyword_0_0_0; }

		//isDestructor?="@Destroy"
		public Assignment getIsDestructorAssignment_0_1() { return cIsDestructorAssignment_0_1; }

		//"@Destroy"
		public Keyword getIsDestructorDestroyKeyword_0_1_0() { return cIsDestructorDestroyKeyword_0_1_0; }

		//visibilityIndicator=VisibilityIndicator?
		public Assignment getVisibilityIndicatorAssignment_1() { return cVisibilityIndicatorAssignment_1; }

		//VisibilityIndicator
		public RuleCall getVisibilityIndicatorVisibilityIndicatorEnumRuleCall_1_0() { return cVisibilityIndicatorVisibilityIndicatorEnumRuleCall_1_0; }

		//abstract?="abstract"?
		public Assignment getAbstractAssignment_2() { return cAbstractAssignment_2; }

		//"abstract"
		public Keyword getAbstractAbstractKeyword_2_0() { return cAbstractAbstractKeyword_2_0; }

		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }

		//formalParameters=FormalParameters
		public Assignment getFormalParametersAssignment_4() { return cFormalParametersAssignment_4; }

		//FormalParameters
		public RuleCall getFormalParametersFormalParametersParserRuleCall_4_0() { return cFormalParametersFormalParametersParserRuleCall_4_0; }

		//(":" returnType=TypePart)?
		public Group getGroup_5() { return cGroup_5; }

		//":"
		public Keyword getColonKeyword_5_0() { return cColonKeyword_5_0; }

		//returnType=TypePart
		public Assignment getReturnTypeAssignment_5_1() { return cReturnTypeAssignment_5_1; }

		//TypePart
		public RuleCall getReturnTypeTypePartParserRuleCall_5_1_0() { return cReturnTypeTypePartParserRuleCall_5_1_0; }

		//redefinition=RedefinitionClause?
		public Assignment getRedefinitionAssignment_6() { return cRedefinitionAssignment_6; }

		//RedefinitionClause
		public RuleCall getRedefinitionRedefinitionClauseParserRuleCall_6_0() { return cRedefinitionRedefinitionClauseParserRuleCall_6_0; }
	}

	public class FormalParametersElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FormalParameters");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cFormalParametersAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cFormalParameterListAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFormalParameterListFormalParameterListParserRuleCall_2_0 = (RuleCall)cFormalParameterListAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//FormalParameters:
		//
		//	{FormalParameters} "(" formalParameterList=FormalParameterList? ")";
		public ParserRule getRule() { return rule; }

		//{FormalParameters} "(" formalParameterList=FormalParameterList? ")"
		public Group getGroup() { return cGroup; }

		//{FormalParameters}
		public Action getFormalParametersAction_0() { return cFormalParametersAction_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//formalParameterList=FormalParameterList?
		public Assignment getFormalParameterListAssignment_2() { return cFormalParameterListAssignment_2; }

		//FormalParameterList
		public RuleCall getFormalParameterListFormalParameterListParserRuleCall_2_0() { return cFormalParameterListFormalParameterListParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class FormalParameterListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FormalParameterList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cFormalParameterAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cFormalParameterFormalParameterParserRuleCall_0_0 = (RuleCall)cFormalParameterAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cFormalParameterAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cFormalParameterFormalParameterParserRuleCall_1_1_0 = (RuleCall)cFormalParameterAssignment_1_1.eContents().get(0);
		
		//FormalParameterList:
		//
		//	formalParameter+=FormalParameter ("," formalParameter+=FormalParameter)*;
		public ParserRule getRule() { return rule; }

		//formalParameter+=FormalParameter ("," formalParameter+=FormalParameter)*
		public Group getGroup() { return cGroup; }

		//formalParameter+=FormalParameter
		public Assignment getFormalParameterAssignment_0() { return cFormalParameterAssignment_0; }

		//FormalParameter
		public RuleCall getFormalParameterFormalParameterParserRuleCall_0_0() { return cFormalParameterFormalParameterParserRuleCall_0_0; }

		//("," formalParameter+=FormalParameter)*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//formalParameter+=FormalParameter
		public Assignment getFormalParameterAssignment_1_1() { return cFormalParameterAssignment_1_1; }

		//FormalParameter
		public RuleCall getFormalParameterFormalParameterParserRuleCall_1_1_0() { return cFormalParameterFormalParameterParserRuleCall_1_1_0; }
	}

	public class FormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cDirectionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cDirectionParameterDirectionEnumRuleCall_0_0 = (RuleCall)cDirectionAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTypePartParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		
		//FormalParameter: // To be added ( <DOCUMENTATION_COMMENT> )?
		// //stereotypeAnnotations = StereotypeAnnotations 
		//
		//
		//	direction=ParameterDirection name=ID ":" type=TypePart;
		public ParserRule getRule() { return rule; }

		//// To be added ( <DOCUMENTATION_COMMENT> )?
		// //stereotypeAnnotations = StereotypeAnnotations 
		//
		//
		//direction=ParameterDirection name=ID ":" type=TypePart
		public Group getGroup() { return cGroup; }

		//// To be added ( <DOCUMENTATION_COMMENT> )?
		// //stereotypeAnnotations = StereotypeAnnotations 
		//
		//
		//direction=ParameterDirection
		public Assignment getDirectionAssignment_0() { return cDirectionAssignment_0; }

		//ParameterDirection
		public RuleCall getDirectionParameterDirectionEnumRuleCall_0_0() { return cDirectionParameterDirectionEnumRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//type=TypePart
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }

		//TypePart
		public RuleCall getTypeTypePartParserRuleCall_3_0() { return cTypeTypePartParserRuleCall_3_0; }
	}

	public class TypePartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypePart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeNameTypeNameParserRuleCall_0_0 = (RuleCall)cTypeNameAssignment_0.eContents().get(0);
		private final Assignment cMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMultiplicityMultiplicityParserRuleCall_1_0 = (RuleCall)cMultiplicityAssignment_1.eContents().get(0);
		
		//TypePart:
		//
		//	typeName=TypeName multiplicity=Multiplicity?;
		public ParserRule getRule() { return rule; }

		//typeName=TypeName multiplicity=Multiplicity?
		public Group getGroup() { return cGroup; }

		//typeName=TypeName
		public Assignment getTypeNameAssignment_0() { return cTypeNameAssignment_0; }

		//TypeName
		public RuleCall getTypeNameTypeNameParserRuleCall_0_0() { return cTypeNameTypeNameParserRuleCall_0_0; }

		//multiplicity=Multiplicity?
		public Assignment getMultiplicityAssignment_1() { return cMultiplicityAssignment_1; }

		//Multiplicity
		public RuleCall getMultiplicityMultiplicityParserRuleCall_1_0() { return cMultiplicityMultiplicityParserRuleCall_1_0; }
	}

	public class MultiplicityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Multiplicity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMultiplicityAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRangeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRangeMultiplicityRangeParserRuleCall_2_0 = (RuleCall)cRangeAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cAlternatives_4.eContents().get(0);
		private final Assignment cOrderedAssignment_4_0_0 = (Assignment)cGroup_4_0.eContents().get(0);
		private final Keyword cOrderedOrderedKeyword_4_0_0_0 = (Keyword)cOrderedAssignment_4_0_0.eContents().get(0);
		private final Assignment cNonUniqueAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final Keyword cNonUniqueNonUniqueKeyword_4_0_1_0 = (Keyword)cNonUniqueAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cAlternatives_4.eContents().get(1);
		private final Assignment cNonUniqueAssignment_4_1_0 = (Assignment)cGroup_4_1.eContents().get(0);
		private final Keyword cNonUniqueNonUniqueKeyword_4_1_0_0 = (Keyword)cNonUniqueAssignment_4_1_0.eContents().get(0);
		private final Assignment cOrderedAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final Keyword cOrderedOrderedKeyword_4_1_1_0 = (Keyword)cOrderedAssignment_4_1_1.eContents().get(0);
		private final Assignment cSequenceAssignment_4_2 = (Assignment)cAlternatives_4.eContents().get(2);
		private final Keyword cSequenceSequenceKeyword_4_2_0 = (Keyword)cSequenceAssignment_4_2.eContents().get(0);
		
		//Multiplicity:
		//
		//	{Multiplicity} "[" range=MultiplicityRange? "]" (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique"
		//
		//	ordered?="ordered"? | sequence?="sequence")?;
		public ParserRule getRule() { return rule; }

		//{Multiplicity} "[" range=MultiplicityRange? "]" (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique"
		//
		//ordered?="ordered"? | sequence?="sequence")?
		public Group getGroup() { return cGroup; }

		//{Multiplicity}
		public Action getMultiplicityAction_0() { return cMultiplicityAction_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//range=MultiplicityRange?
		public Assignment getRangeAssignment_2() { return cRangeAssignment_2; }

		//MultiplicityRange
		public RuleCall getRangeMultiplicityRangeParserRuleCall_2_0() { return cRangeMultiplicityRangeParserRuleCall_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }

		//(ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique" ordered?="ordered"? | sequence?="sequence")?
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//ordered?="ordered" nonUnique?="nonUnique"?
		public Group getGroup_4_0() { return cGroup_4_0; }

		//ordered?="ordered"
		public Assignment getOrderedAssignment_4_0_0() { return cOrderedAssignment_4_0_0; }

		//"ordered"
		public Keyword getOrderedOrderedKeyword_4_0_0_0() { return cOrderedOrderedKeyword_4_0_0_0; }

		//nonUnique?="nonUnique"?
		public Assignment getNonUniqueAssignment_4_0_1() { return cNonUniqueAssignment_4_0_1; }

		//"nonUnique"
		public Keyword getNonUniqueNonUniqueKeyword_4_0_1_0() { return cNonUniqueNonUniqueKeyword_4_0_1_0; }

		//nonUnique?="nonUnique" ordered?="ordered"?
		public Group getGroup_4_1() { return cGroup_4_1; }

		//nonUnique?="nonUnique"
		public Assignment getNonUniqueAssignment_4_1_0() { return cNonUniqueAssignment_4_1_0; }

		//"nonUnique"
		public Keyword getNonUniqueNonUniqueKeyword_4_1_0_0() { return cNonUniqueNonUniqueKeyword_4_1_0_0; }

		//ordered?="ordered"?
		public Assignment getOrderedAssignment_4_1_1() { return cOrderedAssignment_4_1_1; }

		//"ordered"
		public Keyword getOrderedOrderedKeyword_4_1_1_0() { return cOrderedOrderedKeyword_4_1_1_0; }

		//sequence?="sequence"
		public Assignment getSequenceAssignment_4_2() { return cSequenceAssignment_4_2; }

		//"sequence"
		public Keyword getSequenceSequenceKeyword_4_2_0() { return cSequenceSequenceKeyword_4_2_0; }
	}

	public class MultiplicityRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MultiplicityRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cLowerAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cLowerNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0_0_0 = (RuleCall)cLowerAssignment_0_0.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cUpperAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cUpperNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_1_0 = (RuleCall)cUpperAssignment_1.eContents().get(0);
		
		//MultiplicityRange:
		//
		//	(lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")? upper=NUMBER_LITERAL_WITHOUT_SUFFIX;
		public ParserRule getRule() { return rule; }

		//(lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")? upper=NUMBER_LITERAL_WITHOUT_SUFFIX
		public Group getGroup() { return cGroup; }

		//(lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")?
		public Group getGroup_0() { return cGroup_0; }

		//lower=NUMBER_LITERAL_WITHOUT_SUFFIX
		public Assignment getLowerAssignment_0_0() { return cLowerAssignment_0_0; }

		//NUMBER_LITERAL_WITHOUT_SUFFIX
		public RuleCall getLowerNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0_0_0() { return cLowerNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0_0_0; }

		//".."
		public Keyword getFullStopFullStopKeyword_0_1() { return cFullStopFullStopKeyword_0_1; }

		//upper=NUMBER_LITERAL_WITHOUT_SUFFIX
		public Assignment getUpperAssignment_1() { return cUpperAssignment_1; }

		//NUMBER_LITERAL_WITHOUT_SUFFIX
		public RuleCall getUpperNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_1_0() { return cUpperNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_1_0; }
	}

	public class NUMBER_LITERAL_WITHOUT_SUFFIXElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NUMBER_LITERAL_WITHOUT_SUFFIX");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NUMBER_LITERAL_WITHOUT_SUFFIX:
		//
		//	INTEGER_LITERAL_WITHOUT_SUFFIX | UNLIMITED_LITERAL_WITHOUT_SUFFIX;
		public ParserRule getRule() { return rule; }

		//INTEGER_LITERAL_WITHOUT_SUFFIX | UNLIMITED_LITERAL_WITHOUT_SUFFIX
		public Alternatives getAlternatives() { return cAlternatives; }

		//INTEGER_LITERAL_WITHOUT_SUFFIX
		public RuleCall getINTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0() { return cINTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0; }

		//UNLIMITED_LITERAL_WITHOUT_SUFFIX
		public RuleCall getUNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1() { return cUNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1; }
	}

	public class INTEGER_LITERAL_WITHOUT_SUFFIXElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "INTEGER_LITERAL_WITHOUT_SUFFIX");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueIntegerValueTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//INTEGER_LITERAL_WITHOUT_SUFFIX:
		//
		//	value=IntegerValue;
		public ParserRule getRule() { return rule; }

		//value=IntegerValue
		public Assignment getValueAssignment() { return cValueAssignment; }

		//IntegerValue
		public RuleCall getValueIntegerValueTerminalRuleCall_0() { return cValueIntegerValueTerminalRuleCall_0; }
	}

	public class UNLIMITED_LITERAL_WITHOUT_SUFFIXElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UNLIMITED_LITERAL_WITHOUT_SUFFIX");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueAsteriskKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//UNLIMITED_LITERAL_WITHOUT_SUFFIX:
		//
		//	value="*";
		public ParserRule getRule() { return rule; }

		//value="*"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"*"
		public Keyword getValueAsteriskKeyword_0() { return cValueAsteriskKeyword_0; }
	}

	public class TypeNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypeName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTypeNameAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cQualifiedNameAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cQualifiedNameQualifiedNameWithBindingParserRuleCall_1_0_0 = (RuleCall)cQualifiedNameAssignment_1_0.eContents().get(0);
		private final Keyword cAnyKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//TypeName:
		//
		//	{TypeName} (qualifiedName=QualifiedNameWithBinding | "any");
		public ParserRule getRule() { return rule; }

		//{TypeName} (qualifiedName=QualifiedNameWithBinding | "any")
		public Group getGroup() { return cGroup; }

		//{TypeName}
		public Action getTypeNameAction_0() { return cTypeNameAction_0; }

		//qualifiedName=QualifiedNameWithBinding | "any"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//qualifiedName=QualifiedNameWithBinding
		public Assignment getQualifiedNameAssignment_1_0() { return cQualifiedNameAssignment_1_0; }

		//QualifiedNameWithBinding
		public RuleCall getQualifiedNameQualifiedNameWithBindingParserRuleCall_1_0_0() { return cQualifiedNameQualifiedNameWithBindingParserRuleCall_1_0_0; }

		//"any"
		public Keyword getAnyKeyword_1_1() { return cAnyKeyword_1_1; }
	}

	public class RedefinitionClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RedefinitionClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRedefinesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRedefinedOperationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRedefinedOperationsQualifiedNameListParserRuleCall_1_0 = (RuleCall)cRedefinedOperationsAssignment_1.eContents().get(0);
		
		//RedefinitionClause:
		//
		//	"redefines" redefinedOperations=QualifiedNameList;
		public ParserRule getRule() { return rule; }

		//"redefines" redefinedOperations=QualifiedNameList
		public Group getGroup() { return cGroup; }

		//"redefines"
		public Keyword getRedefinesKeyword_0() { return cRedefinesKeyword_0; }

		//redefinedOperations=QualifiedNameList
		public Assignment getRedefinedOperationsAssignment_1() { return cRedefinedOperationsAssignment_1; }

		//QualifiedNameList
		public RuleCall getRedefinedOperationsQualifiedNameListParserRuleCall_1_0() { return cRedefinedOperationsQualifiedNameListParserRuleCall_1_0; }
	}
	
	
	public class VisibilityIndicatorElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "VisibilityIndicator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPUBLICEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPUBLICPublicKeyword_0_0 = (Keyword)cPUBLICEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPRIVATEEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPRIVATEPrivateKeyword_1_0 = (Keyword)cPRIVATEEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cPROTECTEDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cPROTECTEDProtectedKeyword_2_0 = (Keyword)cPROTECTEDEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum VisibilityIndicator:
		//
		//	PUBLIC="public" | PRIVATE="private" | PROTECTED="protected";
		public EnumRule getRule() { return rule; }

		//PUBLIC="public" | PRIVATE="private" | PROTECTED="protected"
		public Alternatives getAlternatives() { return cAlternatives; }

		//PUBLIC="public"
		public EnumLiteralDeclaration getPUBLICEnumLiteralDeclaration_0() { return cPUBLICEnumLiteralDeclaration_0; }

		//"public"
		public Keyword getPUBLICPublicKeyword_0_0() { return cPUBLICPublicKeyword_0_0; }

		//PRIVATE="private"
		public EnumLiteralDeclaration getPRIVATEEnumLiteralDeclaration_1() { return cPRIVATEEnumLiteralDeclaration_1; }

		//"private"
		public Keyword getPRIVATEPrivateKeyword_1_0() { return cPRIVATEPrivateKeyword_1_0; }

		//PROTECTED="protected"
		public EnumLiteralDeclaration getPROTECTEDEnumLiteralDeclaration_2() { return cPROTECTEDEnumLiteralDeclaration_2; }

		//"protected"
		public Keyword getPROTECTEDProtectedKeyword_2_0() { return cPROTECTEDProtectedKeyword_2_0; }
	}

	public class ParameterDirectionElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ParameterDirection");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cINEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cINInKeyword_0_0 = (Keyword)cINEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cOUTEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cOUTOutKeyword_1_0 = (Keyword)cOUTEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cINOUTEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cINOUTInoutKeyword_2_0 = (Keyword)cINOUTEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum ParameterDirection:
		//
		//	IN="in" | OUT="out" | INOUT="inout";
		public EnumRule getRule() { return rule; }

		//IN="in" | OUT="out" | INOUT="inout"
		public Alternatives getAlternatives() { return cAlternatives; }

		//IN="in"
		public EnumLiteralDeclaration getINEnumLiteralDeclaration_0() { return cINEnumLiteralDeclaration_0; }

		//"in"
		public Keyword getINInKeyword_0_0() { return cINInKeyword_0_0; }

		//OUT="out"
		public EnumLiteralDeclaration getOUTEnumLiteralDeclaration_1() { return cOUTEnumLiteralDeclaration_1; }

		//"out"
		public Keyword getOUTOutKeyword_1_0() { return cOUTOutKeyword_1_0; }

		//INOUT="inout"
		public EnumLiteralDeclaration getINOUTEnumLiteralDeclaration_2() { return cINOUTEnumLiteralDeclaration_2; }

		//"inout"
		public Keyword getINOUTInoutKeyword_2_0() { return cINOUTInoutKeyword_2_0; }
	}
	
	private OperationDefinitionOrStubElements pOperationDefinitionOrStub;
	private OperationDeclarationElements pOperationDeclaration;
	private VisibilityIndicatorElements unknownRuleVisibilityIndicator;
	private FormalParametersElements pFormalParameters;
	private FormalParameterListElements pFormalParameterList;
	private FormalParameterElements pFormalParameter;
	private TypePartElements pTypePart;
	private MultiplicityElements pMultiplicity;
	private MultiplicityRangeElements pMultiplicityRange;
	private NUMBER_LITERAL_WITHOUT_SUFFIXElements pNUMBER_LITERAL_WITHOUT_SUFFIX;
	private INTEGER_LITERAL_WITHOUT_SUFFIXElements pINTEGER_LITERAL_WITHOUT_SUFFIX;
	private UNLIMITED_LITERAL_WITHOUT_SUFFIXElements pUNLIMITED_LITERAL_WITHOUT_SUFFIX;
	private TypeNameElements pTypeName;
	private ParameterDirectionElements unknownRuleParameterDirection;
	private RedefinitionClauseElements pRedefinitionClause;
	
	private final Grammar grammar;

	private AlfGrammarAccess gaAlf;

	@Inject
	public OperationGrammarAccess(GrammarProvider grammarProvider,
		AlfGrammarAccess gaAlf) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaAlf = gaAlf;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.papyrus.uml.textedit.operation.xtext.Operation".equals(grammar.getName())) {
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
	

	public AlfGrammarAccess getAlfGrammarAccess() {
		return gaAlf;
	}

	
	//OperationDefinitionOrStub:
	//
	//	declaration=OperationDeclaration (";" | body=Block);
	public OperationDefinitionOrStubElements getOperationDefinitionOrStubAccess() {
		return (pOperationDefinitionOrStub != null) ? pOperationDefinitionOrStub : (pOperationDefinitionOrStub = new OperationDefinitionOrStubElements());
	}
	
	public ParserRule getOperationDefinitionOrStubRule() {
		return getOperationDefinitionOrStubAccess().getRule();
	}

	//OperationDeclaration:
	//
	//	(isConstructor?="@Create" | isDestructor?="@Destroy")? visibilityIndicator=VisibilityIndicator? abstract?="abstract"?
	//
	//	name=ID formalParameters=FormalParameters (":" returnType=TypePart)? redefinition=RedefinitionClause?;
	public OperationDeclarationElements getOperationDeclarationAccess() {
		return (pOperationDeclaration != null) ? pOperationDeclaration : (pOperationDeclaration = new OperationDeclarationElements());
	}
	
	public ParserRule getOperationDeclarationRule() {
		return getOperationDeclarationAccess().getRule();
	}

	//enum VisibilityIndicator:
	//
	//	PUBLIC="public" | PRIVATE="private" | PROTECTED="protected";
	public VisibilityIndicatorElements getVisibilityIndicatorAccess() {
		return (unknownRuleVisibilityIndicator != null) ? unknownRuleVisibilityIndicator : (unknownRuleVisibilityIndicator = new VisibilityIndicatorElements());
	}
	
	public EnumRule getVisibilityIndicatorRule() {
		return getVisibilityIndicatorAccess().getRule();
	}

	//FormalParameters:
	//
	//	{FormalParameters} "(" formalParameterList=FormalParameterList? ")";
	public FormalParametersElements getFormalParametersAccess() {
		return (pFormalParameters != null) ? pFormalParameters : (pFormalParameters = new FormalParametersElements());
	}
	
	public ParserRule getFormalParametersRule() {
		return getFormalParametersAccess().getRule();
	}

	//FormalParameterList:
	//
	//	formalParameter+=FormalParameter ("," formalParameter+=FormalParameter)*;
	public FormalParameterListElements getFormalParameterListAccess() {
		return (pFormalParameterList != null) ? pFormalParameterList : (pFormalParameterList = new FormalParameterListElements());
	}
	
	public ParserRule getFormalParameterListRule() {
		return getFormalParameterListAccess().getRule();
	}

	//FormalParameter: // To be added ( <DOCUMENTATION_COMMENT> )?
	// //stereotypeAnnotations = StereotypeAnnotations 
	//
	//
	//	direction=ParameterDirection name=ID ":" type=TypePart;
	public FormalParameterElements getFormalParameterAccess() {
		return (pFormalParameter != null) ? pFormalParameter : (pFormalParameter = new FormalParameterElements());
	}
	
	public ParserRule getFormalParameterRule() {
		return getFormalParameterAccess().getRule();
	}

	//TypePart:
	//
	//	typeName=TypeName multiplicity=Multiplicity?;
	public TypePartElements getTypePartAccess() {
		return (pTypePart != null) ? pTypePart : (pTypePart = new TypePartElements());
	}
	
	public ParserRule getTypePartRule() {
		return getTypePartAccess().getRule();
	}

	//Multiplicity:
	//
	//	{Multiplicity} "[" range=MultiplicityRange? "]" (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique"
	//
	//	ordered?="ordered"? | sequence?="sequence")?;
	public MultiplicityElements getMultiplicityAccess() {
		return (pMultiplicity != null) ? pMultiplicity : (pMultiplicity = new MultiplicityElements());
	}
	
	public ParserRule getMultiplicityRule() {
		return getMultiplicityAccess().getRule();
	}

	//MultiplicityRange:
	//
	//	(lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")? upper=NUMBER_LITERAL_WITHOUT_SUFFIX;
	public MultiplicityRangeElements getMultiplicityRangeAccess() {
		return (pMultiplicityRange != null) ? pMultiplicityRange : (pMultiplicityRange = new MultiplicityRangeElements());
	}
	
	public ParserRule getMultiplicityRangeRule() {
		return getMultiplicityRangeAccess().getRule();
	}

	//NUMBER_LITERAL_WITHOUT_SUFFIX:
	//
	//	INTEGER_LITERAL_WITHOUT_SUFFIX | UNLIMITED_LITERAL_WITHOUT_SUFFIX;
	public NUMBER_LITERAL_WITHOUT_SUFFIXElements getNUMBER_LITERAL_WITHOUT_SUFFIXAccess() {
		return (pNUMBER_LITERAL_WITHOUT_SUFFIX != null) ? pNUMBER_LITERAL_WITHOUT_SUFFIX : (pNUMBER_LITERAL_WITHOUT_SUFFIX = new NUMBER_LITERAL_WITHOUT_SUFFIXElements());
	}
	
	public ParserRule getNUMBER_LITERAL_WITHOUT_SUFFIXRule() {
		return getNUMBER_LITERAL_WITHOUT_SUFFIXAccess().getRule();
	}

	//INTEGER_LITERAL_WITHOUT_SUFFIX:
	//
	//	value=IntegerValue;
	public INTEGER_LITERAL_WITHOUT_SUFFIXElements getINTEGER_LITERAL_WITHOUT_SUFFIXAccess() {
		return (pINTEGER_LITERAL_WITHOUT_SUFFIX != null) ? pINTEGER_LITERAL_WITHOUT_SUFFIX : (pINTEGER_LITERAL_WITHOUT_SUFFIX = new INTEGER_LITERAL_WITHOUT_SUFFIXElements());
	}
	
	public ParserRule getINTEGER_LITERAL_WITHOUT_SUFFIXRule() {
		return getINTEGER_LITERAL_WITHOUT_SUFFIXAccess().getRule();
	}

	//UNLIMITED_LITERAL_WITHOUT_SUFFIX:
	//
	//	value="*";
	public UNLIMITED_LITERAL_WITHOUT_SUFFIXElements getUNLIMITED_LITERAL_WITHOUT_SUFFIXAccess() {
		return (pUNLIMITED_LITERAL_WITHOUT_SUFFIX != null) ? pUNLIMITED_LITERAL_WITHOUT_SUFFIX : (pUNLIMITED_LITERAL_WITHOUT_SUFFIX = new UNLIMITED_LITERAL_WITHOUT_SUFFIXElements());
	}
	
	public ParserRule getUNLIMITED_LITERAL_WITHOUT_SUFFIXRule() {
		return getUNLIMITED_LITERAL_WITHOUT_SUFFIXAccess().getRule();
	}

	//TypeName:
	//
	//	{TypeName} (qualifiedName=QualifiedNameWithBinding | "any");
	public TypeNameElements getTypeNameAccess() {
		return (pTypeName != null) ? pTypeName : (pTypeName = new TypeNameElements());
	}
	
	public ParserRule getTypeNameRule() {
		return getTypeNameAccess().getRule();
	}

	//enum ParameterDirection:
	//
	//	IN="in" | OUT="out" | INOUT="inout";
	public ParameterDirectionElements getParameterDirectionAccess() {
		return (unknownRuleParameterDirection != null) ? unknownRuleParameterDirection : (unknownRuleParameterDirection = new ParameterDirectionElements());
	}
	
	public EnumRule getParameterDirectionRule() {
		return getParameterDirectionAccess().getRule();
	}

	//RedefinitionClause:
	//
	//	"redefines" redefinedOperations=QualifiedNameList;
	public RedefinitionClauseElements getRedefinitionClauseAccess() {
		return (pRedefinitionClause != null) ? pRedefinitionClause : (pRedefinitionClause = new RedefinitionClauseElements());
	}
	
	public ParserRule getRedefinitionClauseRule() {
		return getRedefinitionClauseAccess().getRule();
	}

	/// *
	//  Test rule
	// * / Test:
	//
	//	("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
	//
	//	("testStatement" statements+=Statement)* ("testBlock" block=Block);
	public AlfGrammarAccess.TestElements getTestAccess() {
		return gaAlf.getTestAccess();
	}
	
	public ParserRule getTestRule() {
		return getTestAccess().getRule();
	}

	////('testStatementSequence' statement += StatementSequence)* ;
	//
	//
	/// *********************************
	// * PrimitiveLiterals
	// ********************************** / LITERAL:
	//
	//	BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL;
	public AlfGrammarAccess.LITERALElements getLITERALAccess() {
		return gaAlf.getLITERALAccess();
	}
	
	public ParserRule getLITERALRule() {
		return getLITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	// BOOLEAN_LITERAL:
	//
	//	value=BooleanValue;
	public AlfGrammarAccess.BOOLEAN_LITERALElements getBOOLEAN_LITERALAccess() {
		return gaAlf.getBOOLEAN_LITERALAccess();
	}
	
	public ParserRule getBOOLEAN_LITERALRule() {
		return getBOOLEAN_LITERALAccess().getRule();
	}

	//enum BooleanValue:
	//
	//	TRUE="true" | FALSE="false";
	public AlfGrammarAccess.BooleanValueElements getBooleanValueAccess() {
		return gaAlf.getBooleanValueAccess();
	}
	
	public EnumRule getBooleanValueRule() {
		return getBooleanValueAccess().getRule();
	}

	//NUMBER_LITERAL:
	//
	//	INTEGER_LITERAL | UNLIMITED_LITERAL;
	public AlfGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaAlf.getNUMBER_LITERALAccess();
	}
	
	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	// INTEGER_LITERAL:
	//
	//	value=IntegerValue;
	public AlfGrammarAccess.INTEGER_LITERALElements getINTEGER_LITERALAccess() {
		return gaAlf.getINTEGER_LITERALAccess();
	}
	
	public ParserRule getINTEGER_LITERALRule() {
		return getINTEGER_LITERALAccess().getRule();
	}

	//// (suffix = SuffixExpression) ? ;
	// UNLIMITED_LITERAL:
	//
	//	value="*";
	public AlfGrammarAccess.UNLIMITED_LITERALElements getUNLIMITED_LITERALAccess() {
		return gaAlf.getUNLIMITED_LITERALAccess();
	}
	
	public ParserRule getUNLIMITED_LITERALRule() {
		return getUNLIMITED_LITERALAccess().getRule();
	}

	//terminal IntegerValue:
	//
	//	("0" | "1".."9" ("_"? "0".."9")*) //DECIMAL 
	// // BINARY
	// // HEX
	// // OCT
	// | ("0b" | "0B") "0".."1" ("_"? "0".."1")* |
	//
	//	("0x" | "0X") ("0".."9" | "a".."f" | "A".."F") ("_"? ("0".."9" | "a".."f" | "A".."F"))* | "0" "_"? "0".."7" ("_"?
	//
	//	"0".."7")*;
	public TerminalRule getIntegerValueRule() {
		return gaAlf.getIntegerValueRule();
	} 

	//// (suffix = SuffixExpression) ?;
	// STRING_LITERAL:
	//
	//	value=STRING;
	public AlfGrammarAccess.STRING_LITERALElements getSTRING_LITERALAccess() {
		return gaAlf.getSTRING_LITERALAccess();
	}
	
	public ParserRule getSTRING_LITERALRule() {
		return getSTRING_LITERALAccess().getRule();
	}

	//NameExpression:
	//
	//	(prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
	//
	//	sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
	//
	//	suffix=SuffixExpression?;
	public AlfGrammarAccess.NameExpressionElements getNameExpressionAccess() {
		return gaAlf.getNameExpressionAccess();
	}
	
	public ParserRule getNameExpressionRule() {
		return getNameExpressionAccess().getRule();
	}

	//QualifiedNamePath:
	//
	//	(namespace+=UnqualifiedName "::")+;
	public AlfGrammarAccess.QualifiedNamePathElements getQualifiedNamePathAccess() {
		return gaAlf.getQualifiedNamePathAccess();
	}
	
	public ParserRule getQualifiedNamePathRule() {
		return getQualifiedNamePathAccess().getRule();
	}

	//UnqualifiedName:
	//
	//	name=ID templateBinding=TemplateBinding?;
	public AlfGrammarAccess.UnqualifiedNameElements getUnqualifiedNameAccess() {
		return gaAlf.getUnqualifiedNameAccess();
	}
	
	public ParserRule getUnqualifiedNameRule() {
		return getUnqualifiedNameAccess().getRule();
	}

	//TemplateBinding:
	//
	//	"<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">";
	public AlfGrammarAccess.TemplateBindingElements getTemplateBindingAccess() {
		return gaAlf.getTemplateBindingAccess();
	}
	
	public ParserRule getTemplateBindingRule() {
		return getTemplateBindingAccess().getRule();
	}

	//NamedTemplateBinding:
	//
	//	formal=ID "=>" actual=QualifiedNameWithBinding;
	public AlfGrammarAccess.NamedTemplateBindingElements getNamedTemplateBindingAccess() {
		return gaAlf.getNamedTemplateBindingAccess();
	}
	
	public ParserRule getNamedTemplateBindingRule() {
		return getNamedTemplateBindingAccess().getRule();
	}

	//QualifiedNameWithBinding:
	//
	//	id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?;
	public AlfGrammarAccess.QualifiedNameWithBindingElements getQualifiedNameWithBindingAccess() {
		return gaAlf.getQualifiedNameWithBindingAccess();
	}
	
	public ParserRule getQualifiedNameWithBindingRule() {
		return getQualifiedNameWithBindingAccess().getRule();
	}

	//Tuple:
	//
	//	{Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")";
	public AlfGrammarAccess.TupleElements getTupleAccess() {
		return gaAlf.getTupleAccess();
	}
	
	public ParserRule getTupleRule() {
		return getTupleAccess().getRule();
	}

	//TupleElement:
	//
	//	argument=Expression;
	public AlfGrammarAccess.TupleElementElements getTupleElementAccess() {
		return gaAlf.getTupleElementAccess();
	}
	
	public ParserRule getTupleElementRule() {
		return getTupleElementAccess().getRule();
	}

	/// **************
	// * Expressions
	// ************** / Expression:
	//
	//	ConditionalTestExpression;
	public AlfGrammarAccess.ExpressionElements getExpressionAccess() {
		return gaAlf.getExpressionAccess();
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//ConditionalTestExpression:
	//
	//	exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?;
	public AlfGrammarAccess.ConditionalTestExpressionElements getConditionalTestExpressionAccess() {
		return gaAlf.getConditionalTestExpressionAccess();
	}
	
	public ParserRule getConditionalTestExpressionRule() {
		return getConditionalTestExpressionAccess().getRule();
	}

	//ConditionalOrExpression:
	//
	//	exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*;
	public AlfGrammarAccess.ConditionalOrExpressionElements getConditionalOrExpressionAccess() {
		return gaAlf.getConditionalOrExpressionAccess();
	}
	
	public ParserRule getConditionalOrExpressionRule() {
		return getConditionalOrExpressionAccess().getRule();
	}

	//ConditionalAndExpression:
	//
	//	exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*;
	public AlfGrammarAccess.ConditionalAndExpressionElements getConditionalAndExpressionAccess() {
		return gaAlf.getConditionalAndExpressionAccess();
	}
	
	public ParserRule getConditionalAndExpressionRule() {
		return getConditionalAndExpressionAccess().getRule();
	}

	//InclusiveOrExpression:
	//
	//	exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*;
	public AlfGrammarAccess.InclusiveOrExpressionElements getInclusiveOrExpressionAccess() {
		return gaAlf.getInclusiveOrExpressionAccess();
	}
	
	public ParserRule getInclusiveOrExpressionRule() {
		return getInclusiveOrExpressionAccess().getRule();
	}

	//ExclusiveOrExpression:
	//
	//	exp+=AndExpression ("^" exp+=AndExpression)*;
	public AlfGrammarAccess.ExclusiveOrExpressionElements getExclusiveOrExpressionAccess() {
		return gaAlf.getExclusiveOrExpressionAccess();
	}
	
	public ParserRule getExclusiveOrExpressionRule() {
		return getExclusiveOrExpressionAccess().getRule();
	}

	//AndExpression:
	//
	//	exp+=EqualityExpression ("&" exp+=EqualityExpression)*;
	public AlfGrammarAccess.AndExpressionElements getAndExpressionAccess() {
		return gaAlf.getAndExpressionAccess();
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}

	//EqualityExpression:
	//
	//	exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*;
	public AlfGrammarAccess.EqualityExpressionElements getEqualityExpressionAccess() {
		return gaAlf.getEqualityExpressionAccess();
	}
	
	public ParserRule getEqualityExpressionRule() {
		return getEqualityExpressionAccess().getRule();
	}

	////enum EqualityOperator :
	// //	EQUALS = '==' |
	// //	NOT_EQUALS = '!='
	// //;
	// ClassificationExpression:
	//
	//	exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?;
	public AlfGrammarAccess.ClassificationExpressionElements getClassificationExpressionAccess() {
		return gaAlf.getClassificationExpressionAccess();
	}
	
	public ParserRule getClassificationExpressionRule() {
		return getClassificationExpressionAccess().getRule();
	}

	////enum ClassificationOperator :
	// //	INSTANCEOF = 'instanceof' |
	// //	HASTYPE = 'hastype'
	// //;
	// RelationalExpression:
	//
	//	left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?;
	public AlfGrammarAccess.RelationalExpressionElements getRelationalExpressionAccess() {
		return gaAlf.getRelationalExpressionAccess();
	}
	
	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}

	////RelationalOperator :
	// //	LOWER = '<' |
	// //	UPPER = '>' |
	// //	LOWER_EQUALS = '<=' |
	// //	UPPER_EQUALS = '>='
	// //;
	//
	//
	//ShiftExpression:
	//
	//	exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?;
	public AlfGrammarAccess.ShiftExpressionElements getShiftExpressionAccess() {
		return gaAlf.getShiftExpressionAccess();
	}
	
	public ParserRule getShiftExpressionRule() {
		return getShiftExpressionAccess().getRule();
	}

	////enum ShiftOperator :
	// //	LSHIFT = '<<' |
	// //	RSHIFT = '>>' |
	// //	URSHIFT = '>>>'
	// //;
	// AdditiveExpression:
	//
	//	exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*;
	public AlfGrammarAccess.AdditiveExpressionElements getAdditiveExpressionAccess() {
		return gaAlf.getAdditiveExpressionAccess();
	}
	
	public ParserRule getAdditiveExpressionRule() {
		return getAdditiveExpressionAccess().getRule();
	}

	////enum AdditiveOp :
	// //	PLUS = '+' |
	// //	MINUS = '-'
	// //;
	// MultiplicativeExpression:
	//
	//	exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*;
	public AlfGrammarAccess.MultiplicativeExpressionElements getMultiplicativeExpressionAccess() {
		return gaAlf.getMultiplicativeExpressionAccess();
	}
	
	public ParserRule getMultiplicativeExpressionRule() {
		return getMultiplicativeExpressionAccess().getRule();
	}

	////enum MultiplicativeOp :
	// //	MULT = '*' |
	// //	DIV = '/' |
	// //	MOD = '%'
	// //;
	// UnaryExpression:
	//
	//	op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression;
	public AlfGrammarAccess.UnaryExpressionElements getUnaryExpressionAccess() {
		return gaAlf.getUnaryExpressionAccess();
	}
	
	public ParserRule getUnaryExpressionRule() {
		return getUnaryExpressionAccess().getRule();
	}

	////PrimaryExpression :
	// //	prefix = ValueSpecification (suffix = SuffixExpression)? 
	// //;
	// PrimaryExpression:
	//
	//	prefix=ValueSpecification;
	public AlfGrammarAccess.PrimaryExpressionElements getPrimaryExpressionAccess() {
		return gaAlf.getPrimaryExpressionAccess();
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}

	//SuffixExpression:
	//
	//	OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
	//
	//	SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression;
	public AlfGrammarAccess.SuffixExpressionElements getSuffixExpressionAccess() {
		return gaAlf.getSuffixExpressionAccess();
	}
	
	public ParserRule getSuffixExpressionRule() {
		return getSuffixExpressionAccess().getRule();
	}

	//OperationCallExpression:
	//
	//	"." operationName=ID tuple=Tuple suffix=SuffixExpression?;
	public AlfGrammarAccess.OperationCallExpressionElements getOperationCallExpressionAccess() {
		return gaAlf.getOperationCallExpressionAccess();
	}
	
	public ParserRule getOperationCallExpressionRule() {
		return getOperationCallExpressionAccess().getRule();
	}

	//// OperationCallExpressionWithoutDot :
	// // 	operationName = ID tuple = Tuple (suffix = SuffixExpression)?
	// // ;
	//
	//
	//PropertyCallExpression:
	//
	//	"." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?;
	public AlfGrammarAccess.PropertyCallExpressionElements getPropertyCallExpressionAccess() {
		return gaAlf.getPropertyCallExpressionAccess();
	}
	
	public ParserRule getPropertyCallExpressionRule() {
		return getPropertyCallExpressionAccess().getRule();
	}

	////LinkOperationExpression :
	// //	'.' kind = LinkOperationKind tuple = LinkOperationTuple
	// //;
	// LinkOperationExpression:
	//
	//	CreateOrDestroyLinkOperationExpression | ClearAssocExpression;
	public AlfGrammarAccess.LinkOperationExpressionElements getLinkOperationExpressionAccess() {
		return gaAlf.getLinkOperationExpressionAccess();
	}
	
	public ParserRule getLinkOperationExpressionRule() {
		return getLinkOperationExpressionAccess().getRule();
	}

	//CreateOrDestroyLinkOperationExpression:
	//
	//	"." kind=LinkOperationKind tuple=LinkOperationTuple;
	public AlfGrammarAccess.CreateOrDestroyLinkOperationExpressionElements getCreateOrDestroyLinkOperationExpressionAccess() {
		return gaAlf.getCreateOrDestroyLinkOperationExpressionAccess();
	}
	
	public ParserRule getCreateOrDestroyLinkOperationExpressionRule() {
		return getCreateOrDestroyLinkOperationExpressionAccess().getRule();
	}

	//ClearAssocExpression:
	//
	//	"." "clearAssoc" "(" end=Expression ")";
	public AlfGrammarAccess.ClearAssocExpressionElements getClearAssocExpressionAccess() {
		return gaAlf.getClearAssocExpressionAccess();
	}
	
	public ParserRule getClearAssocExpressionRule() {
		return getClearAssocExpressionAccess().getRule();
	}

	//LinkOperationTuple:
	//
	//	"(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)*
	//
	//	")";
	public AlfGrammarAccess.LinkOperationTupleElements getLinkOperationTupleAccess() {
		return gaAlf.getLinkOperationTupleAccess();
	}
	
	public ParserRule getLinkOperationTupleRule() {
		return getLinkOperationTupleAccess().getRule();
	}

	////LinkOperationTupleElement :
	// //	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
	// //;
	//
	//
	//LinkOperationTupleElement:
	//
	//	role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression;
	public AlfGrammarAccess.LinkOperationTupleElementElements getLinkOperationTupleElementAccess() {
		return gaAlf.getLinkOperationTupleElementAccess();
	}
	
	public ParserRule getLinkOperationTupleElementRule() {
		return getLinkOperationTupleElementAccess().getRule();
	}

	//enum LinkOperationKind:
	//
	//	CREATE="createLink" | DESTROY="destroyLink";
	public AlfGrammarAccess.LinkOperationKindElements getLinkOperationKindAccess() {
		return gaAlf.getLinkOperationKindAccess();
	}
	
	public EnumRule getLinkOperationKindRule() {
		return getLinkOperationKindAccess().getRule();
	}

	//SequenceOperationExpression: //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
	// "->"
	//
	//	operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?;
	public AlfGrammarAccess.SequenceOperationExpressionElements getSequenceOperationExpressionAccess() {
		return gaAlf.getSequenceOperationExpressionAccess();
	}
	
	public ParserRule getSequenceOperationExpressionRule() {
		return getSequenceOperationExpressionAccess().getRule();
	}

	//SequenceReductionExpression:
	//
	//	"->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?;
	public AlfGrammarAccess.SequenceReductionExpressionElements getSequenceReductionExpressionAccess() {
		return gaAlf.getSequenceReductionExpressionAccess();
	}
	
	public ParserRule getSequenceReductionExpressionRule() {
		return getSequenceReductionExpressionAccess().getRule();
	}

	//SequenceExpansionExpression:
	//
	//	SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation;
	public AlfGrammarAccess.SequenceExpansionExpressionElements getSequenceExpansionExpressionAccess() {
		return gaAlf.getSequenceExpansionExpressionAccess();
	}
	
	public ParserRule getSequenceExpansionExpressionRule() {
		return getSequenceExpansionExpressionAccess().getRule();
	}

	//SelectOrRejectOperation:
	//
	//	"->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public AlfGrammarAccess.SelectOrRejectOperationElements getSelectOrRejectOperationAccess() {
		return gaAlf.getSelectOrRejectOperationAccess();
	}
	
	public ParserRule getSelectOrRejectOperationRule() {
		return getSelectOrRejectOperationAccess().getRule();
	}

	//enum SelectOrRejectOperator:
	//
	//	SELECT="select" | REJECT="reject";
	public AlfGrammarAccess.SelectOrRejectOperatorElements getSelectOrRejectOperatorAccess() {
		return gaAlf.getSelectOrRejectOperatorAccess();
	}
	
	public EnumRule getSelectOrRejectOperatorRule() {
		return getSelectOrRejectOperatorAccess().getRule();
	}

	//CollectOrIterateOperation:
	//
	//	"->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public AlfGrammarAccess.CollectOrIterateOperationElements getCollectOrIterateOperationAccess() {
		return gaAlf.getCollectOrIterateOperationAccess();
	}
	
	public ParserRule getCollectOrIterateOperationRule() {
		return getCollectOrIterateOperationAccess().getRule();
	}

	//enum CollectOrIterateOperator:
	//
	//	COLLECT="collect" | ITERATE="iterate";
	public AlfGrammarAccess.CollectOrIterateOperatorElements getCollectOrIterateOperatorAccess() {
		return gaAlf.getCollectOrIterateOperatorAccess();
	}
	
	public EnumRule getCollectOrIterateOperatorRule() {
		return getCollectOrIterateOperatorAccess().getRule();
	}

	//ForAllOrExistsOrOneOperation:
	//
	//	"->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public AlfGrammarAccess.ForAllOrExistsOrOneOperationElements getForAllOrExistsOrOneOperationAccess() {
		return gaAlf.getForAllOrExistsOrOneOperationAccess();
	}
	
	public ParserRule getForAllOrExistsOrOneOperationRule() {
		return getForAllOrExistsOrOneOperationAccess().getRule();
	}

	//enum ForAllOrExistsOrOneOperator:
	//
	//	FORALL="forAll" | EXISTS="exists" | ONE="one";
	public AlfGrammarAccess.ForAllOrExistsOrOneOperatorElements getForAllOrExistsOrOneOperatorAccess() {
		return gaAlf.getForAllOrExistsOrOneOperatorAccess();
	}
	
	public EnumRule getForAllOrExistsOrOneOperatorRule() {
		return getForAllOrExistsOrOneOperatorAccess().getRule();
	}

	//IsUniqueOperation:
	//
	//	"->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
	public AlfGrammarAccess.IsUniqueOperationElements getIsUniqueOperationAccess() {
		return gaAlf.getIsUniqueOperationAccess();
	}
	
	public ParserRule getIsUniqueOperationRule() {
		return getIsUniqueOperationAccess().getRule();
	}

	//ValueSpecification:
	//
	//	NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
	//
	//	ParenthesizedExpression | NullExpression;
	public AlfGrammarAccess.ValueSpecificationElements getValueSpecificationAccess() {
		return gaAlf.getValueSpecificationAccess();
	}
	
	public ParserRule getValueSpecificationRule() {
		return getValueSpecificationAccess().getRule();
	}

	//NonLiteralValueSpecification:
	//
	//	NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression;
	public AlfGrammarAccess.NonLiteralValueSpecificationElements getNonLiteralValueSpecificationAccess() {
		return gaAlf.getNonLiteralValueSpecificationAccess();
	}
	
	public ParserRule getNonLiteralValueSpecificationRule() {
		return getNonLiteralValueSpecificationAccess().getRule();
	}

	//ParenthesizedExpression:
	//
	//	"(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?;
	public AlfGrammarAccess.ParenthesizedExpressionElements getParenthesizedExpressionAccess() {
		return gaAlf.getParenthesizedExpressionAccess();
	}
	
	public ParserRule getParenthesizedExpressionRule() {
		return getParenthesizedExpressionAccess().getRule();
	}

	//NullExpression:
	//
	//	{NullExpression} "null";
	public AlfGrammarAccess.NullExpressionElements getNullExpressionAccess() {
		return gaAlf.getNullExpressionAccess();
	}
	
	public ParserRule getNullExpressionRule() {
		return getNullExpressionAccess().getRule();
	}

	//ThisExpression:
	//
	//	{ThisExpression} "this" suffix=SuffixExpression?;
	public AlfGrammarAccess.ThisExpressionElements getThisExpressionAccess() {
		return gaAlf.getThisExpressionAccess();
	}
	
	public ParserRule getThisExpressionRule() {
		return getThisExpressionAccess().getRule();
	}

	//// SuperInvocationExpression :
	//
	//
	////	//{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
	//
	//
	////	'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression) 
	//
	//
	////;
	// SuperInvocationExpression:
	//
	////{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
	//
	//
	////'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
	//
	//
	////'super' ((tuple = Tuple) |
	// //		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
	// "super"
	//
	//	(tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple);
	public AlfGrammarAccess.SuperInvocationExpressionElements getSuperInvocationExpressionAccess() {
		return gaAlf.getSuperInvocationExpressionAccess();
	}
	
	public ParserRule getSuperInvocationExpressionRule() {
		return getSuperInvocationExpressionAccess().getRule();
	}

	////InstanceCreationExpression :
	// //'new' constructor=QualifiedNameWithBinding 
	//
	//
	////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
	//
	//
	////'new' constructor=QualifiedNameWithBinding 
	// //	tuple = Tuple (suffix = SuffixExpression) ?
	// //;
	//
	//
	//InstanceCreationExpression: //'new' constructor=QualifiedNameWithBinding 
	//
	//
	////	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
	//
	//
	//	"new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?;
	public AlfGrammarAccess.InstanceCreationExpressionElements getInstanceCreationExpressionAccess() {
		return gaAlf.getInstanceCreationExpressionAccess();
	}
	
	public ParserRule getInstanceCreationExpressionRule() {
		return getInstanceCreationExpressionAccess().getRule();
	}

	//InstanceCreationTuple:
	//
	//	{InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
	//
	//	instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")";
	public AlfGrammarAccess.InstanceCreationTupleElements getInstanceCreationTupleAccess() {
		return gaAlf.getInstanceCreationTupleAccess();
	}
	
	public ParserRule getInstanceCreationTupleRule() {
		return getInstanceCreationTupleAccess().getRule();
	}

	////LinkOperationTupleElement :
	// //	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
	// //;
	//
	//
	//InstanceCreationTupleElement:
	//
	//	role=ID "=>" object=Expression;
	public AlfGrammarAccess.InstanceCreationTupleElementElements getInstanceCreationTupleElementAccess() {
		return gaAlf.getInstanceCreationTupleElementAccess();
	}
	
	public ParserRule getInstanceCreationTupleElementRule() {
		return getInstanceCreationTupleElementAccess().getRule();
	}

	//SequenceConstructionOrAccessCompletion:
	//
	//	multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
	//
	//	sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression;
	public AlfGrammarAccess.SequenceConstructionOrAccessCompletionElements getSequenceConstructionOrAccessCompletionAccess() {
		return gaAlf.getSequenceConstructionOrAccessCompletionAccess();
	}
	
	public ParserRule getSequenceConstructionOrAccessCompletionRule() {
		return getSequenceConstructionOrAccessCompletionAccess().getRule();
	}

	//AccessCompletion:
	//
	//	accessIndex=Expression "]";
	public AlfGrammarAccess.AccessCompletionElements getAccessCompletionAccess() {
		return gaAlf.getAccessCompletionAccess();
	}
	
	public ParserRule getAccessCompletionRule() {
		return getAccessCompletionAccess().getRule();
	}

	//PartialSequenceConstructionCompletion:
	//
	//	"]" expression=SequenceConstructionExpression;
	public AlfGrammarAccess.PartialSequenceConstructionCompletionElements getPartialSequenceConstructionCompletionAccess() {
		return gaAlf.getPartialSequenceConstructionCompletionAccess();
	}
	
	public ParserRule getPartialSequenceConstructionCompletionRule() {
		return getPartialSequenceConstructionCompletionAccess().getRule();
	}

	////SequenceConstructionCompletion :
	// //	(multiplicityIndicator ?= '['']')? expression = SequenceConstructionExpression
	//
	//
	////;
	// SequenceConstructionExpression:
	//
	//	"{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}";
	public AlfGrammarAccess.SequenceConstructionExpressionElements getSequenceConstructionExpressionAccess() {
		return gaAlf.getSequenceConstructionExpressionAccess();
	}
	
	public ParserRule getSequenceConstructionExpressionRule() {
		return getSequenceConstructionExpressionAccess().getRule();
	}

	//SequenceElement:
	//
	//	Expression | SequenceConstructionExpression;
	public AlfGrammarAccess.SequenceElementElements getSequenceElementAccess() {
		return gaAlf.getSequenceElementAccess();
	}
	
	public ParserRule getSequenceElementRule() {
		return getSequenceElementAccess().getRule();
	}

	//ClassExtentExpression:
	//
	//	{ClassExtentExpression} "." "allInstances" "(" ")" suffix=SuffixExpression?;
	public AlfGrammarAccess.ClassExtentExpressionElements getClassExtentExpressionAccess() {
		return gaAlf.getClassExtentExpressionAccess();
	}
	
	public ParserRule getClassExtentExpressionRule() {
		return getClassExtentExpressionAccess().getRule();
	}

	/// *****************
	// * Statements
	// **************** / Block:
	//
	//	"{" {Block} sequence=StatementSequence? "}";
	public AlfGrammarAccess.BlockElements getBlockAccess() {
		return gaAlf.getBlockAccess();
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}

	//StatementSequence:
	//
	//	statements+=DocumentedStatement+;
	public AlfGrammarAccess.StatementSequenceElements getStatementSequenceAccess() {
		return gaAlf.getStatementSequenceAccess();
	}
	
	public ParserRule getStatementSequenceRule() {
		return getStatementSequenceAccess().getRule();
	}

	//DocumentedStatement:
	//
	//	comment=(ML_COMMENT | SL_COMMENT)? statement=Statement;
	public AlfGrammarAccess.DocumentedStatementElements getDocumentedStatementAccess() {
		return gaAlf.getDocumentedStatementAccess();
	}
	
	public ParserRule getDocumentedStatementRule() {
		return getDocumentedStatementAccess().getRule();
	}

	//InlineStatement:
	//
	//	"/ *@" "inline" "(" langageName=ID ")" body=STRING "* /";
	public AlfGrammarAccess.InlineStatementElements getInlineStatementAccess() {
		return gaAlf.getInlineStatementAccess();
	}
	
	public ParserRule getInlineStatementRule() {
		return getInlineStatementAccess().getRule();
	}

	//AnnotatedStatement:
	//
	//	"//@" annotation= //block = Block
	// Annotation statement=Statement;
	public AlfGrammarAccess.AnnotatedStatementElements getAnnotatedStatementAccess() {
		return gaAlf.getAnnotatedStatementAccess();
	}
	
	public ParserRule getAnnotatedStatementRule() {
		return getAnnotatedStatementAccess().getRule();
	}

	//Statement:
	//
	//	AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement
	//
	//	| SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement
	//
	//	| ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement |
	//
	//	ThisInvocationStatement | InstanceCreationInvocationStatement;
	public AlfGrammarAccess.StatementElements getStatementAccess() {
		return gaAlf.getStatementAccess();
	}
	
	public ParserRule getStatementRule() {
		return getStatementAccess().getRule();
	}

	//Annotation:
	//
	//	kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?;
	public AlfGrammarAccess.AnnotationElements getAnnotationAccess() {
		return gaAlf.getAnnotationAccess();
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}

	//enum AnnotationKind:
	//
	//	ISOLATED="isolated" | DETERMINED="determined" | ASSURED="assured" | PARALLEL="parallel";
	public AlfGrammarAccess.AnnotationKindElements getAnnotationKindAccess() {
		return gaAlf.getAnnotationKindAccess();
	}
	
	public EnumRule getAnnotationKindRule() {
		return getAnnotationKindAccess().getRule();
	}

	//BlockStatement:
	//
	//	block=Block;
	public AlfGrammarAccess.BlockStatementElements getBlockStatementAccess() {
		return gaAlf.getBlockStatementAccess();
	}
	
	public ParserRule getBlockStatementRule() {
		return getBlockStatementAccess().getRule();
	}

	//EmptyStatement:
	//
	//	{EmptyStatement} ";";
	public AlfGrammarAccess.EmptyStatementElements getEmptyStatementAccess() {
		return gaAlf.getEmptyStatementAccess();
	}
	
	public ParserRule getEmptyStatementRule() {
		return getEmptyStatementAccess().getRule();
	}

	//LocalNameDeclarationStatement:
	//
	//	"let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
	// "="
	//
	//	init=SequenceElement ";";
	public AlfGrammarAccess.LocalNameDeclarationStatementElements getLocalNameDeclarationStatementAccess() {
		return gaAlf.getLocalNameDeclarationStatementAccess();
	}
	
	public ParserRule getLocalNameDeclarationStatementRule() {
		return getLocalNameDeclarationStatementAccess().getRule();
	}

	//IfStatement:
	//
	//	"if" sequentialClausses=SequentialClauses finalClause=FinalClause?;
	public AlfGrammarAccess.IfStatementElements getIfStatementAccess() {
		return gaAlf.getIfStatementAccess();
	}
	
	public ParserRule getIfStatementRule() {
		return getIfStatementAccess().getRule();
	}

	//SequentialClauses:
	//
	//	conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*;
	public AlfGrammarAccess.SequentialClausesElements getSequentialClausesAccess() {
		return gaAlf.getSequentialClausesAccess();
	}
	
	public ParserRule getSequentialClausesRule() {
		return getSequentialClausesAccess().getRule();
	}

	//ConcurrentClauses:
	//
	//	nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*;
	public AlfGrammarAccess.ConcurrentClausesElements getConcurrentClausesAccess() {
		return gaAlf.getConcurrentClausesAccess();
	}
	
	public ParserRule getConcurrentClausesRule() {
		return getConcurrentClausesAccess().getRule();
	}

	//NonFinalClause:
	//
	//	"(" condition=Expression ")" block=Block;
	public AlfGrammarAccess.NonFinalClauseElements getNonFinalClauseAccess() {
		return gaAlf.getNonFinalClauseAccess();
	}
	
	public ParserRule getNonFinalClauseRule() {
		return getNonFinalClauseAccess().getRule();
	}

	//FinalClause:
	//
	//	"else" block=Block;
	public AlfGrammarAccess.FinalClauseElements getFinalClauseAccess() {
		return gaAlf.getFinalClauseAccess();
	}
	
	public ParserRule getFinalClauseRule() {
		return getFinalClauseAccess().getRule();
	}

	//SwitchStatement:
	//
	//	"switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}";
	public AlfGrammarAccess.SwitchStatementElements getSwitchStatementAccess() {
		return gaAlf.getSwitchStatementAccess();
	}
	
	public ParserRule getSwitchStatementRule() {
		return getSwitchStatementAccess().getRule();
	}

	//SwitchClause:
	//
	//	switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence;
	public AlfGrammarAccess.SwitchClauseElements getSwitchClauseAccess() {
		return gaAlf.getSwitchClauseAccess();
	}
	
	public ParserRule getSwitchClauseRule() {
		return getSwitchClauseAccess().getRule();
	}

	//SwitchCase:
	//
	//	"case" expression=Expression ":";
	public AlfGrammarAccess.SwitchCaseElements getSwitchCaseAccess() {
		return gaAlf.getSwitchCaseAccess();
	}
	
	public ParserRule getSwitchCaseRule() {
		return getSwitchCaseAccess().getRule();
	}

	//SwitchDefaultClause:
	//
	//	"default" ":" statementSequence=NonEmptyStatementSequence;
	public AlfGrammarAccess.SwitchDefaultClauseElements getSwitchDefaultClauseAccess() {
		return gaAlf.getSwitchDefaultClauseAccess();
	}
	
	public ParserRule getSwitchDefaultClauseRule() {
		return getSwitchDefaultClauseAccess().getRule();
	}

	//NonEmptyStatementSequence:
	//
	//	statement+=DocumentedStatement+;
	public AlfGrammarAccess.NonEmptyStatementSequenceElements getNonEmptyStatementSequenceAccess() {
		return gaAlf.getNonEmptyStatementSequenceAccess();
	}
	
	public ParserRule getNonEmptyStatementSequenceRule() {
		return getNonEmptyStatementSequenceAccess().getRule();
	}

	/// * WHILE STATEMENTS * / WhileStatement:
	//
	//	"while" "(" condition=Expression ")" block=Block;
	public AlfGrammarAccess.WhileStatementElements getWhileStatementAccess() {
		return gaAlf.getWhileStatementAccess();
	}
	
	public ParserRule getWhileStatementRule() {
		return getWhileStatementAccess().getRule();
	}

	/// * DO STATEMENTS * / DoStatement:
	//
	//	"do" block=Block "while" "(" condition=Expression ")" ";";
	public AlfGrammarAccess.DoStatementElements getDoStatementAccess() {
		return gaAlf.getDoStatementAccess();
	}
	
	public ParserRule getDoStatementRule() {
		return getDoStatementAccess().getRule();
	}

	/// * FOR STATEMENTS * / ForStatement:
	//
	//	"for" "(" control=ForControl ")" block=Block;
	public AlfGrammarAccess.ForStatementElements getForStatementAccess() {
		return gaAlf.getForStatementAccess();
	}
	
	public ParserRule getForStatementRule() {
		return getForStatementAccess().getRule();
	}

	//ForControl:
	//
	//	loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*;
	public AlfGrammarAccess.ForControlElements getForControlAccess() {
		return gaAlf.getForControlAccess();
	}
	
	public ParserRule getForControlRule() {
		return getForControlAccess().getRule();
	}

	//LoopVariableDefinition:
	//
	//	name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
	//
	//	expression=Expression;
	public AlfGrammarAccess.LoopVariableDefinitionElements getLoopVariableDefinitionAccess() {
		return gaAlf.getLoopVariableDefinitionAccess();
	}
	
	public ParserRule getLoopVariableDefinitionRule() {
		return getLoopVariableDefinitionAccess().getRule();
	}

	/// * BREAK STATEMENTS * / BreakStatement:
	//
	//	{BreakStatement} "break" ";";
	public AlfGrammarAccess.BreakStatementElements getBreakStatementAccess() {
		return gaAlf.getBreakStatementAccess();
	}
	
	public ParserRule getBreakStatementRule() {
		return getBreakStatementAccess().getRule();
	}

	/// * RETURN STATEMENTS * / ReturnStatement:
	//
	//	"return" expression=Expression ";";
	public AlfGrammarAccess.ReturnStatementElements getReturnStatementAccess() {
		return gaAlf.getReturnStatementAccess();
	}
	
	public ParserRule getReturnStatementRule() {
		return getReturnStatementAccess().getRule();
	}

	/// * ACCEPT STATEMENTS * / AcceptStatement:
	//
	//	clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion |
	//
	//	compoundAccept=CompoundAcceptStatementCompletion);
	public AlfGrammarAccess.AcceptStatementElements getAcceptStatementAccess() {
		return gaAlf.getAcceptStatementAccess();
	}
	
	public ParserRule getAcceptStatementRule() {
		return getAcceptStatementAccess().getRule();
	}

	//SimpleAcceptStatementCompletion:
	//
	//	{SimpleAcceptStatementCompletion} ";";
	public AlfGrammarAccess.SimpleAcceptStatementCompletionElements getSimpleAcceptStatementCompletionAccess() {
		return gaAlf.getSimpleAcceptStatementCompletionAccess();
	}
	
	public ParserRule getSimpleAcceptStatementCompletionRule() {
		return getSimpleAcceptStatementCompletionAccess().getRule();
	}

	//CompoundAcceptStatementCompletion:
	//
	//	block=Block ("or" acceptBlock+=AcceptBlock)*;
	public AlfGrammarAccess.CompoundAcceptStatementCompletionElements getCompoundAcceptStatementCompletionAccess() {
		return gaAlf.getCompoundAcceptStatementCompletionAccess();
	}
	
	public ParserRule getCompoundAcceptStatementCompletionRule() {
		return getCompoundAcceptStatementCompletionAccess().getRule();
	}

	//AcceptBlock:
	//
	//	clause=AcceptClause block=Block;
	public AlfGrammarAccess.AcceptBlockElements getAcceptBlockAccess() {
		return gaAlf.getAcceptBlockAccess();
	}
	
	public ParserRule getAcceptBlockRule() {
		return getAcceptBlockAccess().getRule();
	}

	//AcceptClause:
	//
	//	"accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")";
	public AlfGrammarAccess.AcceptClauseElements getAcceptClauseAccess() {
		return gaAlf.getAcceptClauseAccess();
	}
	
	public ParserRule getAcceptClauseRule() {
		return getAcceptClauseAccess().getRule();
	}

	/// * CLASSIFY STATEMENTS * / ClassifyStatement:
	//
	//	"classify" expression=Expression clause=ClassificationClause ";";
	public AlfGrammarAccess.ClassifyStatementElements getClassifyStatementAccess() {
		return gaAlf.getClassifyStatementAccess();
	}
	
	public ParserRule getClassifyStatementRule() {
		return getClassifyStatementAccess().getRule();
	}

	//ClassificationClause:
	//
	//	classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
	//
	//	reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause;
	public AlfGrammarAccess.ClassificationClauseElements getClassificationClauseAccess() {
		return gaAlf.getClassificationClauseAccess();
	}
	
	public ParserRule getClassificationClauseRule() {
		return getClassificationClauseAccess().getRule();
	}

	//ClassificationFromClause:
	//
	//	"from" qualifiedNameList=QualifiedNameList;
	public AlfGrammarAccess.ClassificationFromClauseElements getClassificationFromClauseAccess() {
		return gaAlf.getClassificationFromClauseAccess();
	}
	
	public ParserRule getClassificationFromClauseRule() {
		return getClassificationFromClauseAccess().getRule();
	}

	//ClassificationToClause:
	//
	//	"to" qualifiedNameList=QualifiedNameList;
	public AlfGrammarAccess.ClassificationToClauseElements getClassificationToClauseAccess() {
		return gaAlf.getClassificationToClauseAccess();
	}
	
	public ParserRule getClassificationToClauseRule() {
		return getClassificationToClauseAccess().getRule();
	}

	//ReclassifyAllClause:
	//
	//	{ReclassifyAllClause} "from" "*";
	public AlfGrammarAccess.ReclassifyAllClauseElements getReclassifyAllClauseAccess() {
		return gaAlf.getReclassifyAllClauseAccess();
	}
	
	public ParserRule getReclassifyAllClauseRule() {
		return getReclassifyAllClauseAccess().getRule();
	}

	//QualifiedNameList:
	//
	//	qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*;
	public AlfGrammarAccess.QualifiedNameListElements getQualifiedNameListAccess() {
		return gaAlf.getQualifiedNameListAccess();
	}
	
	public ParserRule getQualifiedNameListRule() {
		return getQualifiedNameListAccess().getRule();
	}

	//InvocationOrAssignementOrDeclarationStatement:
	//
	//	typePart_OR_assignedPart_OR_invocationPart=NameExpression
	//
	//	(variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
	// |
	//
	//	assignmentCompletion=AssignmentCompletion)? ";";
	public AlfGrammarAccess.InvocationOrAssignementOrDeclarationStatementElements getInvocationOrAssignementOrDeclarationStatementAccess() {
		return gaAlf.getInvocationOrAssignementOrDeclarationStatementAccess();
	}
	
	public ParserRule getInvocationOrAssignementOrDeclarationStatementRule() {
		return getInvocationOrAssignementOrDeclarationStatementAccess().getRule();
	}

	//SuperInvocationStatement:
	//
	//	_super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
	// ";";
	public AlfGrammarAccess.SuperInvocationStatementElements getSuperInvocationStatementAccess() {
		return gaAlf.getSuperInvocationStatementAccess();
	}
	
	public ParserRule getSuperInvocationStatementRule() {
		return getSuperInvocationStatementAccess().getRule();
	}

	//ThisInvocationStatement:
	//
	////_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
	//
	//
	//	_this=ThisExpression assignmentCompletion=AssignmentCompletion? ";";
	public AlfGrammarAccess.ThisInvocationStatementElements getThisInvocationStatementAccess() {
		return gaAlf.getThisInvocationStatementAccess();
	}
	
	public ParserRule getThisInvocationStatementRule() {
		return getThisInvocationStatementAccess().getRule();
	}

	//InstanceCreationInvocationStatement:
	//
	//	_new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
	// ";";
	public AlfGrammarAccess.InstanceCreationInvocationStatementElements getInstanceCreationInvocationStatementAccess() {
		return gaAlf.getInstanceCreationInvocationStatementAccess();
	}
	
	public ParserRule getInstanceCreationInvocationStatementRule() {
		return getInstanceCreationInvocationStatementAccess().getRule();
	}

	////SuffixCompletion :
	// //	suffix = SuffixExpression
	// //;
	// VariableDeclarationCompletion:
	//
	//	(multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion;
	public AlfGrammarAccess.VariableDeclarationCompletionElements getVariableDeclarationCompletionAccess() {
		return gaAlf.getVariableDeclarationCompletionAccess();
	}
	
	public ParserRule getVariableDeclarationCompletionRule() {
		return getVariableDeclarationCompletionAccess().getRule();
	}

	////op=('=' | '+=' | '-=' | '*=' | '%=' | '/=' | '&=' |
	//
	//
	////	'|=' | '^=' | '<<=' | '>>=' | '>>>=') rightHandSide = Expression
	// AssignmentCompletion:
	//
	//	op=AssignmentOperator rightHandSide=SequenceElement;
	public AlfGrammarAccess.AssignmentCompletionElements getAssignmentCompletionAccess() {
		return gaAlf.getAssignmentCompletionAccess();
	}
	
	public ParserRule getAssignmentCompletionRule() {
		return getAssignmentCompletionAccess().getRule();
	}

	//enum AssignmentOperator:
	//
	//	ASSIGN="=" | PLUSASSIGN="+=" | MINUSASSIGN="-=" | MULTASSIGN="*=" | MODASSIGN="%=" | DIVASSIGN="/=" | ANDASSIGN="&="
	//
	//	| ORASSIGN="|=" | XORASSIGN="^=" | LSHIFTASSIGN="<<=" | RSHIFTASSIGN=">>=" | URSHIFTASSIGN=">>>=";
	public AlfGrammarAccess.AssignmentOperatorElements getAssignmentOperatorAccess() {
		return gaAlf.getAssignmentOperatorAccess();
	}
	
	public EnumRule getAssignmentOperatorRule() {
		return getAssignmentOperatorAccess().getRule();
	}

	/// ****************
	// * Terminals
	// ***************** / //terminal DOUBLE_COLON : '::' ;
	// terminal ID:
	//
	//	("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")* | "\'"->"\'";
	public TerminalRule getIDRule() {
		return gaAlf.getIDRule();
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return gaAlf.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//
	//	"/ *" !"@"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaAlf.getML_COMMENTRule();
	} 

	////terminal IDENTIFIER : ID  ;
	//
	//
	////terminal IDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*  | ('\'' -> '\'')  ;
	//
	//
	////terminal DOCUMENTATION_COMMENT : '/ *' -> '* /' ;
	// //terminal ML_COMMENT	: '/°' -> '°/';
	//
	//
	////terminal SL_COMMENT 	: '°°' !('\n'|'\r')* ('\r'? '\n')?;
	// //terminal WS			: (' '|'\t'|'\r'|'\n')+; terminal
	//
	//SL_COMMENT:
	//
	//	"//" !("\n" | "\r" | "@")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaAlf.getSL_COMMENTRule();
	} 

	//terminal INT returns ecore::EInt:
	//
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaAlf.getINTRule();
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaAlf.getWSRule();
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaAlf.getANY_OTHERRule();
	} 
}
