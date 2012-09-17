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

package org.eclipse.papyrus.uml.textedit.property.xtext.services;

import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
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
public class UmlPropertyGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class PropertyRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall)cVisibilityAssignment_0.eContents().get(0);
		private final Assignment cIsDerivedAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsDerivedSolidusKeyword_1_0 = (Keyword)cIsDerivedAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cTypeAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cTypeTypeRuleParserRuleCall_4_0_0 = (RuleCall)cTypeAssignment_4_0.eContents().get(0);
		private final Keyword cUndefinedKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		private final Assignment cMultiplicityAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cMultiplicityMultiplicityRuleParserRuleCall_5_0 = (RuleCall)cMultiplicityAssignment_5.eContents().get(0);
		private final Assignment cModifiersAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cModifiersModifiersRuleParserRuleCall_6_0 = (RuleCall)cModifiersAssignment_6.eContents().get(0);
		private final Assignment cDefaultAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cDefaultDefaultValueRuleParserRuleCall_7_0 = (RuleCall)cDefaultAssignment_7.eContents().get(0);
		
		//PropertyRule:
		//	visibility=VisibilityKind isDerived="/"? name=ID ":" (type=TypeRule | "<Undefined>") multiplicity=MultiplicityRule?
		//	modifiers=ModifiersRule? default=DefaultValueRule?;
		public ParserRule getRule() { return rule; }

		//visibility=VisibilityKind isDerived="/"? name=ID ":" (type=TypeRule | "<Undefined>") multiplicity=MultiplicityRule?
		//modifiers=ModifiersRule? default=DefaultValueRule?
		public Group getGroup() { return cGroup; }

		//visibility=VisibilityKind
		public Assignment getVisibilityAssignment_0() { return cVisibilityAssignment_0; }

		//VisibilityKind
		public RuleCall getVisibilityVisibilityKindEnumRuleCall_0_0() { return cVisibilityVisibilityKindEnumRuleCall_0_0; }

		//isDerived="/"?
		public Assignment getIsDerivedAssignment_1() { return cIsDerivedAssignment_1; }

		//"/"
		public Keyword getIsDerivedSolidusKeyword_1_0() { return cIsDerivedSolidusKeyword_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//":"
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//type=TypeRule | "<Undefined>"
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//type=TypeRule
		public Assignment getTypeAssignment_4_0() { return cTypeAssignment_4_0; }

		//TypeRule
		public RuleCall getTypeTypeRuleParserRuleCall_4_0_0() { return cTypeTypeRuleParserRuleCall_4_0_0; }

		//"<Undefined>"
		public Keyword getUndefinedKeyword_4_1() { return cUndefinedKeyword_4_1; }

		//multiplicity=MultiplicityRule?
		public Assignment getMultiplicityAssignment_5() { return cMultiplicityAssignment_5; }

		//MultiplicityRule
		public RuleCall getMultiplicityMultiplicityRuleParserRuleCall_5_0() { return cMultiplicityMultiplicityRuleParserRuleCall_5_0; }

		//modifiers=ModifiersRule?
		public Assignment getModifiersAssignment_6() { return cModifiersAssignment_6; }

		//ModifiersRule
		public RuleCall getModifiersModifiersRuleParserRuleCall_6_0() { return cModifiersModifiersRuleParserRuleCall_6_0; }

		//default=DefaultValueRule?
		public Assignment getDefaultAssignment_7() { return cDefaultAssignment_7; }

		//DefaultValueRule
		public RuleCall getDefaultDefaultValueRuleParserRuleCall_7_0() { return cDefaultDefaultValueRuleParserRuleCall_7_0; }
	}

	public class TypeRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypeRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPathAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPathQualifiedNameParserRuleCall_0_0 = (RuleCall)cPathAssignment_0.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTypeClassifierCrossReference_1_0 = (CrossReference)cTypeAssignment_1.eContents().get(0);
		private final RuleCall cTypeClassifierIDTerminalRuleCall_1_0_1 = (RuleCall)cTypeClassifierCrossReference_1_0.eContents().get(1);
		
		//TypeRule:
		//	path=QualifiedName? type=[uml::Classifier];
		public ParserRule getRule() { return rule; }

		//path=QualifiedName? type=[uml::Classifier]
		public Group getGroup() { return cGroup; }

		//path=QualifiedName?
		public Assignment getPathAssignment_0() { return cPathAssignment_0; }

		//QualifiedName
		public RuleCall getPathQualifiedNameParserRuleCall_0_0() { return cPathQualifiedNameParserRuleCall_0_0; }

		//type=[uml::Classifier]
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }

		//[uml::Classifier]
		public CrossReference getTypeClassifierCrossReference_1_0() { return cTypeClassifierCrossReference_1_0; }

		//ID
		public RuleCall getTypeClassifierIDTerminalRuleCall_1_0_1() { return cTypeClassifierIDTerminalRuleCall_1_0_1; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPathAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPathNamespaceCrossReference_0_0 = (CrossReference)cPathAssignment_0.eContents().get(0);
		private final RuleCall cPathNamespaceIDTerminalRuleCall_0_0_1 = (RuleCall)cPathNamespaceCrossReference_0_0.eContents().get(1);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRemainingAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRemainingQualifiedNameParserRuleCall_2_0 = (RuleCall)cRemainingAssignment_2.eContents().get(0);
		
		//QualifiedName:
		//	path=[uml::Namespace] "::" remaining=QualifiedName?;
		public ParserRule getRule() { return rule; }

		//path=[uml::Namespace] "::" remaining=QualifiedName?
		public Group getGroup() { return cGroup; }

		//path=[uml::Namespace]
		public Assignment getPathAssignment_0() { return cPathAssignment_0; }

		//[uml::Namespace]
		public CrossReference getPathNamespaceCrossReference_0_0() { return cPathNamespaceCrossReference_0_0; }

		//ID
		public RuleCall getPathNamespaceIDTerminalRuleCall_0_0_1() { return cPathNamespaceIDTerminalRuleCall_0_0_1; }

		//"::"
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }

		//remaining=QualifiedName?
		public Assignment getRemainingAssignment_2() { return cRemainingAssignment_2; }

		//QualifiedName
		public RuleCall getRemainingQualifiedNameParserRuleCall_2_0() { return cRemainingQualifiedNameParserRuleCall_2_0; }
	}

	public class MultiplicityRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MultiplicityRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBoundsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBoundsBoundSpecificationParserRuleCall_1_0 = (RuleCall)cBoundsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cBoundsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cBoundsBoundSpecificationParserRuleCall_2_1_0 = (RuleCall)cBoundsAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//MultiplicityRule:
		//	"[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]";
		public ParserRule getRule() { return rule; }

		//"[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]"
		public Group getGroup() { return cGroup; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//bounds+=BoundSpecification
		public Assignment getBoundsAssignment_1() { return cBoundsAssignment_1; }

		//BoundSpecification
		public RuleCall getBoundsBoundSpecificationParserRuleCall_1_0() { return cBoundsBoundSpecificationParserRuleCall_1_0; }

		//(".." bounds+=BoundSpecification)?
		public Group getGroup_2() { return cGroup_2; }

		//".."
		public Keyword getFullStopFullStopKeyword_2_0() { return cFullStopFullStopKeyword_2_0; }

		//bounds+=BoundSpecification
		public Assignment getBoundsAssignment_2_1() { return cBoundsAssignment_2_1; }

		//BoundSpecification
		public RuleCall getBoundsBoundSpecificationParserRuleCall_2_1_0() { return cBoundsBoundSpecificationParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class BoundSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BoundSpecification");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueUnlimitedLiteralParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//BoundSpecification:
		//	value=UnlimitedLiteral;
		public ParserRule getRule() { return rule; }

		//value=UnlimitedLiteral
		public Assignment getValueAssignment() { return cValueAssignment; }

		//UnlimitedLiteral
		public RuleCall getValueUnlimitedLiteralParserRuleCall_0() { return cValueUnlimitedLiteralParserRuleCall_0; }
	}

	public class UnlimitedLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnlimitedLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAsteriskKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//UnlimitedLiteral returns ecore::EString:
		//	INT | "*";
		public ParserRule getRule() { return rule; }

		//INT | "*"
		public Alternatives getAlternatives() { return cAlternatives; }

		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//"*"
		public Keyword getAsteriskKeyword_1() { return cAsteriskKeyword_1; }
	}

	public class ModifiersRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModifiersRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValuesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValuesModifierSpecificationParserRuleCall_1_0 = (RuleCall)cValuesAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cValuesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cValuesModifierSpecificationParserRuleCall_2_1_0 = (RuleCall)cValuesAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ModifiersRule:
		//	"{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}";
		public ParserRule getRule() { return rule; }

		//"{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//values+=ModifierSpecification
		public Assignment getValuesAssignment_1() { return cValuesAssignment_1; }

		//ModifierSpecification
		public RuleCall getValuesModifierSpecificationParserRuleCall_1_0() { return cValuesModifierSpecificationParserRuleCall_1_0; }

		//("," values+=ModifierSpecification)*
		public Group getGroup_2() { return cGroup_2; }

		//","
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//values+=ModifierSpecification
		public Assignment getValuesAssignment_2_1() { return cValuesAssignment_2_1; }

		//ModifierSpecification
		public RuleCall getValuesModifierSpecificationParserRuleCall_2_1_0() { return cValuesModifierSpecificationParserRuleCall_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class ModifierSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModifierSpecification");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cValueModifierKindEnumRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cRedefinesAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cRedefinesRedefinesRuleParserRuleCall_1_0 = (RuleCall)cRedefinesAssignment_1.eContents().get(0);
		private final Assignment cSubsetsAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cSubsetsSubsetsRuleParserRuleCall_2_0 = (RuleCall)cSubsetsAssignment_2.eContents().get(0);
		
		//ModifierSpecification:
		//	value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule;
		public ParserRule getRule() { return rule; }

		//value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule
		public Alternatives getAlternatives() { return cAlternatives; }

		//value=ModifierKind
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//ModifierKind
		public RuleCall getValueModifierKindEnumRuleCall_0_0() { return cValueModifierKindEnumRuleCall_0_0; }

		//redefines=RedefinesRule
		public Assignment getRedefinesAssignment_1() { return cRedefinesAssignment_1; }

		//RedefinesRule
		public RuleCall getRedefinesRedefinesRuleParserRuleCall_1_0() { return cRedefinesRedefinesRuleParserRuleCall_1_0; }

		//subsets=SubsetsRule
		public Assignment getSubsetsAssignment_2() { return cSubsetsAssignment_2; }

		//SubsetsRule
		public RuleCall getSubsetsSubsetsRuleParserRuleCall_2_0() { return cSubsetsSubsetsRuleParserRuleCall_2_0; }
	}

	public class RedefinesRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RedefinesRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRedefinesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPropertyPropertyCrossReference_1_0 = (CrossReference)cPropertyAssignment_1.eContents().get(0);
		private final RuleCall cPropertyPropertyIDTerminalRuleCall_1_0_1 = (RuleCall)cPropertyPropertyCrossReference_1_0.eContents().get(1);
		
		//RedefinesRule:
		//	"redefines" property=[uml::Property];
		public ParserRule getRule() { return rule; }

		//"redefines" property=[uml::Property]
		public Group getGroup() { return cGroup; }

		//"redefines"
		public Keyword getRedefinesKeyword_0() { return cRedefinesKeyword_0; }

		//property=[uml::Property]
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }

		//[uml::Property]
		public CrossReference getPropertyPropertyCrossReference_1_0() { return cPropertyPropertyCrossReference_1_0; }

		//ID
		public RuleCall getPropertyPropertyIDTerminalRuleCall_1_0_1() { return cPropertyPropertyIDTerminalRuleCall_1_0_1; }
	}

	public class SubsetsRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SubsetsRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSubsetsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPropertyPropertyCrossReference_1_0 = (CrossReference)cPropertyAssignment_1.eContents().get(0);
		private final RuleCall cPropertyPropertyIDTerminalRuleCall_1_0_1 = (RuleCall)cPropertyPropertyCrossReference_1_0.eContents().get(1);
		
		//SubsetsRule:
		//	"subsets" property=[uml::Property];
		public ParserRule getRule() { return rule; }

		//"subsets" property=[uml::Property]
		public Group getGroup() { return cGroup; }

		//"subsets"
		public Keyword getSubsetsKeyword_0() { return cSubsetsKeyword_0; }

		//property=[uml::Property]
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }

		//[uml::Property]
		public CrossReference getPropertyPropertyCrossReference_1_0() { return cPropertyPropertyCrossReference_1_0; }

		//ID
		public RuleCall getPropertyPropertyIDTerminalRuleCall_1_0_1() { return cPropertyPropertyIDTerminalRuleCall_1_0_1; }
	}

	public class DefaultValueRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DefaultValueRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEqualsSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cDefaultAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDefaultSTRINGTerminalRuleCall_1_0 = (RuleCall)cDefaultAssignment_1.eContents().get(0);
		
		//DefaultValueRule:
		//	"=" default=STRING;
		public ParserRule getRule() { return rule; }

		//"=" default=STRING
		public Group getGroup() { return cGroup; }

		//"="
		public Keyword getEqualsSignKeyword_0() { return cEqualsSignKeyword_0; }

		//default=STRING
		public Assignment getDefaultAssignment_1() { return cDefaultAssignment_1; }

		//STRING
		public RuleCall getDefaultSTRINGTerminalRuleCall_1_0() { return cDefaultSTRINGTerminalRuleCall_1_0; }
	}
	
	
	public class VisibilityKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "VisibilityKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPublicEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPublicPlusSignKeyword_0_0 = (Keyword)cPublicEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPrivateEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPrivateHyphenMinusKeyword_1_0 = (Keyword)cPrivateEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cProtectedEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cProtectedNumberSignKeyword_2_0 = (Keyword)cProtectedEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cPackageEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cPackageTildeKeyword_3_0 = (Keyword)cPackageEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum VisibilityKind:
		//	public="+" | private="-" | protected="#" | package="~";
		public EnumRule getRule() { return rule; }

		//public="+" | private="-" | protected="#" | package="~"
		public Alternatives getAlternatives() { return cAlternatives; }

		//public="+"
		public EnumLiteralDeclaration getPublicEnumLiteralDeclaration_0() { return cPublicEnumLiteralDeclaration_0; }

		//"+"
		public Keyword getPublicPlusSignKeyword_0_0() { return cPublicPlusSignKeyword_0_0; }

		//private="-"
		public EnumLiteralDeclaration getPrivateEnumLiteralDeclaration_1() { return cPrivateEnumLiteralDeclaration_1; }

		//"-"
		public Keyword getPrivateHyphenMinusKeyword_1_0() { return cPrivateHyphenMinusKeyword_1_0; }

		//protected="#"
		public EnumLiteralDeclaration getProtectedEnumLiteralDeclaration_2() { return cProtectedEnumLiteralDeclaration_2; }

		//"#"
		public Keyword getProtectedNumberSignKeyword_2_0() { return cProtectedNumberSignKeyword_2_0; }

		//package="~"
		public EnumLiteralDeclaration getPackageEnumLiteralDeclaration_3() { return cPackageEnumLiteralDeclaration_3; }

		//"~"
		public Keyword getPackageTildeKeyword_3_0() { return cPackageTildeKeyword_3_0; }
	}

	public class ModifierKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ModifierKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cReadOnlyEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cReadOnlyReadOnlyKeyword_0_0 = (Keyword)cReadOnlyEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cUnionEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cUnionUnionKeyword_1_0 = (Keyword)cUnionEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cOrderedEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cOrderedOrderedKeyword_2_0 = (Keyword)cOrderedEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cUniqueEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cUniqueUniqueKeyword_3_0 = (Keyword)cUniqueEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum ModifierKind:
		//	readOnly | union | ordered | unique;
		public EnumRule getRule() { return rule; }

		//readOnly | union | ordered | unique
		public Alternatives getAlternatives() { return cAlternatives; }

		//readOnly
		public EnumLiteralDeclaration getReadOnlyEnumLiteralDeclaration_0() { return cReadOnlyEnumLiteralDeclaration_0; }

		//"readOnly"
		public Keyword getReadOnlyReadOnlyKeyword_0_0() { return cReadOnlyReadOnlyKeyword_0_0; }

		//union
		public EnumLiteralDeclaration getUnionEnumLiteralDeclaration_1() { return cUnionEnumLiteralDeclaration_1; }

		//"union"
		public Keyword getUnionUnionKeyword_1_0() { return cUnionUnionKeyword_1_0; }

		//ordered
		public EnumLiteralDeclaration getOrderedEnumLiteralDeclaration_2() { return cOrderedEnumLiteralDeclaration_2; }

		//"ordered"
		public Keyword getOrderedOrderedKeyword_2_0() { return cOrderedOrderedKeyword_2_0; }

		//unique
		public EnumLiteralDeclaration getUniqueEnumLiteralDeclaration_3() { return cUniqueEnumLiteralDeclaration_3; }

		//"unique"
		public Keyword getUniqueUniqueKeyword_3_0() { return cUniqueUniqueKeyword_3_0; }
	}
	
	private PropertyRuleElements pPropertyRule;
	private VisibilityKindElements unknownRuleVisibilityKind;
	private TypeRuleElements pTypeRule;
	private QualifiedNameElements pQualifiedName;
	private MultiplicityRuleElements pMultiplicityRule;
	private BoundSpecificationElements pBoundSpecification;
	private UnlimitedLiteralElements pUnlimitedLiteral;
	private ModifiersRuleElements pModifiersRule;
	private ModifierSpecificationElements pModifierSpecification;
	private ModifierKindElements unknownRuleModifierKind;
	private RedefinesRuleElements pRedefinesRule;
	private SubsetsRuleElements pSubsetsRule;
	private DefaultValueRuleElements pDefaultValueRule;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public UmlPropertyGrammarAccess(GrammarProvider grammarProvider,
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

	
	//PropertyRule:
	//	visibility=VisibilityKind isDerived="/"? name=ID ":" (type=TypeRule | "<Undefined>") multiplicity=MultiplicityRule?
	//	modifiers=ModifiersRule? default=DefaultValueRule?;
	public PropertyRuleElements getPropertyRuleAccess() {
		return (pPropertyRule != null) ? pPropertyRule : (pPropertyRule = new PropertyRuleElements());
	}
	
	public ParserRule getPropertyRuleRule() {
		return getPropertyRuleAccess().getRule();
	}

	//enum VisibilityKind:
	//	public="+" | private="-" | protected="#" | package="~";
	public VisibilityKindElements getVisibilityKindAccess() {
		return (unknownRuleVisibilityKind != null) ? unknownRuleVisibilityKind : (unknownRuleVisibilityKind = new VisibilityKindElements());
	}
	
	public EnumRule getVisibilityKindRule() {
		return getVisibilityKindAccess().getRule();
	}

	//TypeRule:
	//	path=QualifiedName? type=[uml::Classifier];
	public TypeRuleElements getTypeRuleAccess() {
		return (pTypeRule != null) ? pTypeRule : (pTypeRule = new TypeRuleElements());
	}
	
	public ParserRule getTypeRuleRule() {
		return getTypeRuleAccess().getRule();
	}

	//QualifiedName:
	//	path=[uml::Namespace] "::" remaining=QualifiedName?;
	public QualifiedNameElements getQualifiedNameAccess() {
		return (pQualifiedName != null) ? pQualifiedName : (pQualifiedName = new QualifiedNameElements());
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//MultiplicityRule:
	//	"[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]";
	public MultiplicityRuleElements getMultiplicityRuleAccess() {
		return (pMultiplicityRule != null) ? pMultiplicityRule : (pMultiplicityRule = new MultiplicityRuleElements());
	}
	
	public ParserRule getMultiplicityRuleRule() {
		return getMultiplicityRuleAccess().getRule();
	}

	//BoundSpecification:
	//	value=UnlimitedLiteral;
	public BoundSpecificationElements getBoundSpecificationAccess() {
		return (pBoundSpecification != null) ? pBoundSpecification : (pBoundSpecification = new BoundSpecificationElements());
	}
	
	public ParserRule getBoundSpecificationRule() {
		return getBoundSpecificationAccess().getRule();
	}

	//UnlimitedLiteral returns ecore::EString:
	//	INT | "*";
	public UnlimitedLiteralElements getUnlimitedLiteralAccess() {
		return (pUnlimitedLiteral != null) ? pUnlimitedLiteral : (pUnlimitedLiteral = new UnlimitedLiteralElements());
	}
	
	public ParserRule getUnlimitedLiteralRule() {
		return getUnlimitedLiteralAccess().getRule();
	}

	//ModifiersRule:
	//	"{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}";
	public ModifiersRuleElements getModifiersRuleAccess() {
		return (pModifiersRule != null) ? pModifiersRule : (pModifiersRule = new ModifiersRuleElements());
	}
	
	public ParserRule getModifiersRuleRule() {
		return getModifiersRuleAccess().getRule();
	}

	//ModifierSpecification:
	//	value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule;
	public ModifierSpecificationElements getModifierSpecificationAccess() {
		return (pModifierSpecification != null) ? pModifierSpecification : (pModifierSpecification = new ModifierSpecificationElements());
	}
	
	public ParserRule getModifierSpecificationRule() {
		return getModifierSpecificationAccess().getRule();
	}

	//enum ModifierKind:
	//	readOnly | union | ordered | unique;
	public ModifierKindElements getModifierKindAccess() {
		return (unknownRuleModifierKind != null) ? unknownRuleModifierKind : (unknownRuleModifierKind = new ModifierKindElements());
	}
	
	public EnumRule getModifierKindRule() {
		return getModifierKindAccess().getRule();
	}

	//RedefinesRule:
	//	"redefines" property=[uml::Property];
	public RedefinesRuleElements getRedefinesRuleAccess() {
		return (pRedefinesRule != null) ? pRedefinesRule : (pRedefinesRule = new RedefinesRuleElements());
	}
	
	public ParserRule getRedefinesRuleRule() {
		return getRedefinesRuleAccess().getRule();
	}

	//SubsetsRule:
	//	"subsets" property=[uml::Property];
	public SubsetsRuleElements getSubsetsRuleAccess() {
		return (pSubsetsRule != null) ? pSubsetsRule : (pSubsetsRule = new SubsetsRuleElements());
	}
	
	public ParserRule getSubsetsRuleRule() {
		return getSubsetsRuleAccess().getRule();
	}

	//DefaultValueRule:
	//	"=" default=STRING;
	public DefaultValueRuleElements getDefaultValueRuleAccess() {
		return (pDefaultValueRule != null) ? pDefaultValueRule : (pDefaultValueRule = new DefaultValueRuleElements());
	}
	
	public ParserRule getDefaultValueRuleRule() {
		return getDefaultValueRuleAccess().getRule();
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
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
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
