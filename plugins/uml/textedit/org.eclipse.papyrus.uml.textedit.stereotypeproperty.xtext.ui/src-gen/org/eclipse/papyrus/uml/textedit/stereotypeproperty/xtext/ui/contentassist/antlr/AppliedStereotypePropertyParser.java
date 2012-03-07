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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.services.AppliedStereotypePropertyGrammarAccess;

public class AppliedStereotypePropertyParser extends AbstractContentAssistParser {
	
	@Inject
	private AppliedStereotypePropertyGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr.internal.InternalAppliedStereotypePropertyParser createParser() {
		org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr.internal.InternalAppliedStereotypePropertyParser result = new org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr.internal.InternalAppliedStereotypePropertyParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getLITERALAccess().getAlternatives(), "rule__LITERAL__Alternatives");
					put(grammarAccess.getNUMBER_LITERALAccess().getAlternatives(), "rule__NUMBER_LITERAL__Alternatives");
					put(grammarAccess.getNameExpressionAccess().getAlternatives_0(), "rule__NameExpression__Alternatives_0");
					put(grammarAccess.getNameExpressionAccess().getPrefixOpAlternatives_0_0_0_0(), "rule__NameExpression__PrefixOpAlternatives_0_0_0_0");
					put(grammarAccess.getNameExpressionAccess().getAlternatives_0_1_2(), "rule__NameExpression__Alternatives_0_1_2");
					put(grammarAccess.getNameExpressionAccess().getPostfixOpAlternatives_0_1_2_2_0(), "rule__NameExpression__PostfixOpAlternatives_0_1_2_2_0");
					put(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_0_0(), "rule__EqualityExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getClassificationExpressionAccess().getOpAlternatives_1_0_0(), "rule__ClassificationExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getRelationalExpressionAccess().getOpAlternatives_1_0_0(), "rule__RelationalExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_0(), "rule__ShiftExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_0_0(), "rule__AdditiveExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_0_0(), "rule__MultiplicativeExpression__OpAlternatives_1_0_0");
					put(grammarAccess.getUnaryExpressionAccess().getOpAlternatives_0_0(), "rule__UnaryExpression__OpAlternatives_0_0");
					put(grammarAccess.getSuffixExpressionAccess().getAlternatives(), "rule__SuffixExpression__Alternatives");
					put(grammarAccess.getSequenceExpansionExpressionAccess().getAlternatives(), "rule__SequenceExpansionExpression__Alternatives");
					put(grammarAccess.getValueSpecificationAccess().getAlternatives(), "rule__ValueSpecification__Alternatives");
					put(grammarAccess.getNonLiteralValueSpecificationAccess().getAlternatives(), "rule__NonLiteralValueSpecification__Alternatives");
					put(grammarAccess.getParenthesizedExpressionAccess().getAlternatives_3(), "rule__ParenthesizedExpression__Alternatives_3");
					put(grammarAccess.getSuperInvocationExpressionAccess().getAlternatives_1(), "rule__SuperInvocationExpression__Alternatives_1");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAlternatives(), "rule__SequenceConstructionOrAccessCompletion__Alternatives");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAlternatives_0_1(), "rule__SequenceConstructionOrAccessCompletion__Alternatives_0_1");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getAlternatives_2(), "rule__SequenceConstructionExpression__Alternatives_2");
					put(grammarAccess.getSequenceElementAccess().getAlternatives(), "rule__SequenceElement__Alternatives");
					put(grammarAccess.getDocumentedStatementAccess().getCommentAlternatives_0_0(), "rule__DocumentedStatement__CommentAlternatives_0_0");
					put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
					put(grammarAccess.getLoopVariableDefinitionAccess().getAlternatives(), "rule__LoopVariableDefinition__Alternatives");
					put(grammarAccess.getAcceptStatementAccess().getAlternatives_1(), "rule__AcceptStatement__Alternatives_1");
					put(grammarAccess.getClassificationClauseAccess().getAlternatives(), "rule__ClassificationClause__Alternatives");
					put(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAlternatives_1(), "rule__InvocationOrAssignementOrDeclarationStatement__Alternatives_1");
					put(grammarAccess.getBooleanValueAccess().getAlternatives(), "rule__BooleanValue__Alternatives");
					put(grammarAccess.getLinkOperationKindAccess().getAlternatives(), "rule__LinkOperationKind__Alternatives");
					put(grammarAccess.getSelectOrRejectOperatorAccess().getAlternatives(), "rule__SelectOrRejectOperator__Alternatives");
					put(grammarAccess.getCollectOrIterateOperatorAccess().getAlternatives(), "rule__CollectOrIterateOperator__Alternatives");
					put(grammarAccess.getForAllOrExistsOrOneOperatorAccess().getAlternatives(), "rule__ForAllOrExistsOrOneOperator__Alternatives");
					put(grammarAccess.getAnnotationKindAccess().getAlternatives(), "rule__AnnotationKind__Alternatives");
					put(grammarAccess.getAssignmentOperatorAccess().getAlternatives(), "rule__AssignmentOperator__Alternatives");
					put(grammarAccess.getAppliedStereotypePropertyRuleAccess().getGroup(), "rule__AppliedStereotypePropertyRule__Group__0");
					put(grammarAccess.getTestAccess().getGroup(), "rule__Test__Group__0");
					put(grammarAccess.getTestAccess().getGroup_0(), "rule__Test__Group_0__0");
					put(grammarAccess.getTestAccess().getGroup_1(), "rule__Test__Group_1__0");
					put(grammarAccess.getTestAccess().getGroup_2(), "rule__Test__Group_2__0");
					put(grammarAccess.getTestAccess().getGroup_3(), "rule__Test__Group_3__0");
					put(grammarAccess.getNameExpressionAccess().getGroup(), "rule__NameExpression__Group__0");
					put(grammarAccess.getNameExpressionAccess().getGroup_0_0(), "rule__NameExpression__Group_0_0__0");
					put(grammarAccess.getNameExpressionAccess().getGroup_0_1(), "rule__NameExpression__Group_0_1__0");
					put(grammarAccess.getQualifiedNamePathAccess().getGroup(), "rule__QualifiedNamePath__Group__0");
					put(grammarAccess.getUnqualifiedNameAccess().getGroup(), "rule__UnqualifiedName__Group__0");
					put(grammarAccess.getTemplateBindingAccess().getGroup(), "rule__TemplateBinding__Group__0");
					put(grammarAccess.getTemplateBindingAccess().getGroup_2(), "rule__TemplateBinding__Group_2__0");
					put(grammarAccess.getNamedTemplateBindingAccess().getGroup(), "rule__NamedTemplateBinding__Group__0");
					put(grammarAccess.getQualifiedNameWithBindingAccess().getGroup(), "rule__QualifiedNameWithBinding__Group__0");
					put(grammarAccess.getQualifiedNameWithBindingAccess().getGroup_2(), "rule__QualifiedNameWithBinding__Group_2__0");
					put(grammarAccess.getTupleAccess().getGroup(), "rule__Tuple__Group__0");
					put(grammarAccess.getTupleAccess().getGroup_2(), "rule__Tuple__Group_2__0");
					put(grammarAccess.getTupleAccess().getGroup_2_1(), "rule__Tuple__Group_2_1__0");
					put(grammarAccess.getConditionalTestExpressionAccess().getGroup(), "rule__ConditionalTestExpression__Group__0");
					put(grammarAccess.getConditionalTestExpressionAccess().getGroup_1(), "rule__ConditionalTestExpression__Group_1__0");
					put(grammarAccess.getConditionalOrExpressionAccess().getGroup(), "rule__ConditionalOrExpression__Group__0");
					put(grammarAccess.getConditionalOrExpressionAccess().getGroup_1(), "rule__ConditionalOrExpression__Group_1__0");
					put(grammarAccess.getConditionalAndExpressionAccess().getGroup(), "rule__ConditionalAndExpression__Group__0");
					put(grammarAccess.getConditionalAndExpressionAccess().getGroup_1(), "rule__ConditionalAndExpression__Group_1__0");
					put(grammarAccess.getInclusiveOrExpressionAccess().getGroup(), "rule__InclusiveOrExpression__Group__0");
					put(grammarAccess.getInclusiveOrExpressionAccess().getGroup_1(), "rule__InclusiveOrExpression__Group_1__0");
					put(grammarAccess.getExclusiveOrExpressionAccess().getGroup(), "rule__ExclusiveOrExpression__Group__0");
					put(grammarAccess.getExclusiveOrExpressionAccess().getGroup_1(), "rule__ExclusiveOrExpression__Group_1__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
					put(grammarAccess.getClassificationExpressionAccess().getGroup(), "rule__ClassificationExpression__Group__0");
					put(grammarAccess.getClassificationExpressionAccess().getGroup_1(), "rule__ClassificationExpression__Group_1__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
					put(grammarAccess.getShiftExpressionAccess().getGroup(), "rule__ShiftExpression__Group__0");
					put(grammarAccess.getShiftExpressionAccess().getGroup_1(), "rule__ShiftExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup(), "rule__UnaryExpression__Group__0");
					put(grammarAccess.getOperationCallExpressionAccess().getGroup(), "rule__OperationCallExpression__Group__0");
					put(grammarAccess.getPropertyCallExpressionAccess().getGroup(), "rule__PropertyCallExpression__Group__0");
					put(grammarAccess.getPropertyCallExpressionAccess().getGroup_2(), "rule__PropertyCallExpression__Group_2__0");
					put(grammarAccess.getLinkOperationExpressionAccess().getGroup(), "rule__LinkOperationExpression__Group__0");
					put(grammarAccess.getLinkOperationTupleAccess().getGroup(), "rule__LinkOperationTuple__Group__0");
					put(grammarAccess.getLinkOperationTupleAccess().getGroup_2(), "rule__LinkOperationTuple__Group_2__0");
					put(grammarAccess.getLinkOperationTupleElementAccess().getGroup(), "rule__LinkOperationTupleElement__Group__0");
					put(grammarAccess.getLinkOperationTupleElementAccess().getGroup_1(), "rule__LinkOperationTupleElement__Group_1__0");
					put(grammarAccess.getSequenceOperationExpressionAccess().getGroup(), "rule__SequenceOperationExpression__Group__0");
					put(grammarAccess.getSequenceReductionExpressionAccess().getGroup(), "rule__SequenceReductionExpression__Group__0");
					put(grammarAccess.getSelectOrRejectOperationAccess().getGroup(), "rule__SelectOrRejectOperation__Group__0");
					put(grammarAccess.getCollectOrIterateOperationAccess().getGroup(), "rule__CollectOrIterateOperation__Group__0");
					put(grammarAccess.getForAllOrExistsOrOneOperationAccess().getGroup(), "rule__ForAllOrExistsOrOneOperation__Group__0");
					put(grammarAccess.getIsUniqueOperationAccess().getGroup(), "rule__IsUniqueOperation__Group__0");
					put(grammarAccess.getParenthesizedExpressionAccess().getGroup(), "rule__ParenthesizedExpression__Group__0");
					put(grammarAccess.getNullExpressionAccess().getGroup(), "rule__NullExpression__Group__0");
					put(grammarAccess.getThisExpressionAccess().getGroup(), "rule__ThisExpression__Group__0");
					put(grammarAccess.getSuperInvocationExpressionAccess().getGroup(), "rule__SuperInvocationExpression__Group__0");
					put(grammarAccess.getSuperInvocationExpressionAccess().getGroup_1_1(), "rule__SuperInvocationExpression__Group_1_1__0");
					put(grammarAccess.getInstanceCreationExpressionAccess().getGroup(), "rule__InstanceCreationExpression__Group__0");
					put(grammarAccess.getInstanceCreationTupleAccess().getGroup(), "rule__InstanceCreationTuple__Group__0");
					put(grammarAccess.getInstanceCreationTupleAccess().getGroup_2(), "rule__InstanceCreationTuple__Group_2__0");
					put(grammarAccess.getInstanceCreationTupleAccess().getGroup_2_1(), "rule__InstanceCreationTuple__Group_2_1__0");
					put(grammarAccess.getInstanceCreationTupleElementAccess().getGroup(), "rule__InstanceCreationTupleElement__Group__0");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getGroup_0(), "rule__SequenceConstructionOrAccessCompletion__Group_0__0");
					put(grammarAccess.getAccessCompletionAccess().getGroup(), "rule__AccessCompletion__Group__0");
					put(grammarAccess.getPartialSequenceConstructionCompletionAccess().getGroup(), "rule__PartialSequenceConstructionCompletion__Group__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup(), "rule__SequenceConstructionExpression__Group__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2_0(), "rule__SequenceConstructionExpression__Group_2_0__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2_1(), "rule__SequenceConstructionExpression__Group_2_1__0");
					put(grammarAccess.getClassExtentExpressionAccess().getGroup(), "rule__ClassExtentExpression__Group__0");
					put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
					put(grammarAccess.getDocumentedStatementAccess().getGroup(), "rule__DocumentedStatement__Group__0");
					put(grammarAccess.getInlineStatementAccess().getGroup(), "rule__InlineStatement__Group__0");
					put(grammarAccess.getAnnotatedStatementAccess().getGroup(), "rule__AnnotatedStatement__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup_1(), "rule__Annotation__Group_1__0");
					put(grammarAccess.getAnnotationAccess().getGroup_1_2(), "rule__Annotation__Group_1_2__0");
					put(grammarAccess.getEmptyStatementAccess().getGroup(), "rule__EmptyStatement__Group__0");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getGroup(), "rule__LocalNameDeclarationStatement__Group__0");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getGroup_4(), "rule__LocalNameDeclarationStatement__Group_4__0");
					put(grammarAccess.getIfStatementAccess().getGroup(), "rule__IfStatement__Group__0");
					put(grammarAccess.getSequentialClausesAccess().getGroup(), "rule__SequentialClauses__Group__0");
					put(grammarAccess.getSequentialClausesAccess().getGroup_1(), "rule__SequentialClauses__Group_1__0");
					put(grammarAccess.getConcurrentClausesAccess().getGroup(), "rule__ConcurrentClauses__Group__0");
					put(grammarAccess.getConcurrentClausesAccess().getGroup_1(), "rule__ConcurrentClauses__Group_1__0");
					put(grammarAccess.getNonFinalClauseAccess().getGroup(), "rule__NonFinalClause__Group__0");
					put(grammarAccess.getFinalClauseAccess().getGroup(), "rule__FinalClause__Group__0");
					put(grammarAccess.getSwitchStatementAccess().getGroup(), "rule__SwitchStatement__Group__0");
					put(grammarAccess.getSwitchClauseAccess().getGroup(), "rule__SwitchClause__Group__0");
					put(grammarAccess.getSwitchCaseAccess().getGroup(), "rule__SwitchCase__Group__0");
					put(grammarAccess.getSwitchDefaultClauseAccess().getGroup(), "rule__SwitchDefaultClause__Group__0");
					put(grammarAccess.getWhileStatementAccess().getGroup(), "rule__WhileStatement__Group__0");
					put(grammarAccess.getDoStatementAccess().getGroup(), "rule__DoStatement__Group__0");
					put(grammarAccess.getForStatementAccess().getGroup(), "rule__ForStatement__Group__0");
					put(grammarAccess.getForControlAccess().getGroup(), "rule__ForControl__Group__0");
					put(grammarAccess.getForControlAccess().getGroup_1(), "rule__ForControl__Group_1__0");
					put(grammarAccess.getLoopVariableDefinitionAccess().getGroup_0(), "rule__LoopVariableDefinition__Group_0__0");
					put(grammarAccess.getLoopVariableDefinitionAccess().getGroup_0_3(), "rule__LoopVariableDefinition__Group_0_3__0");
					put(grammarAccess.getLoopVariableDefinitionAccess().getGroup_1(), "rule__LoopVariableDefinition__Group_1__0");
					put(grammarAccess.getBreakStatementAccess().getGroup(), "rule__BreakStatement__Group__0");
					put(grammarAccess.getReturnStatementAccess().getGroup(), "rule__ReturnStatement__Group__0");
					put(grammarAccess.getAcceptStatementAccess().getGroup(), "rule__AcceptStatement__Group__0");
					put(grammarAccess.getSimpleAcceptStatementCompletionAccess().getGroup(), "rule__SimpleAcceptStatementCompletion__Group__0");
					put(grammarAccess.getCompoundAcceptStatementCompletionAccess().getGroup(), "rule__CompoundAcceptStatementCompletion__Group__0");
					put(grammarAccess.getCompoundAcceptStatementCompletionAccess().getGroup_1(), "rule__CompoundAcceptStatementCompletion__Group_1__0");
					put(grammarAccess.getAcceptBlockAccess().getGroup(), "rule__AcceptBlock__Group__0");
					put(grammarAccess.getAcceptClauseAccess().getGroup(), "rule__AcceptClause__Group__0");
					put(grammarAccess.getAcceptClauseAccess().getGroup_2(), "rule__AcceptClause__Group_2__0");
					put(grammarAccess.getClassifyStatementAccess().getGroup(), "rule__ClassifyStatement__Group__0");
					put(grammarAccess.getClassificationClauseAccess().getGroup_0(), "rule__ClassificationClause__Group_0__0");
					put(grammarAccess.getClassificationClauseAccess().getGroup_1(), "rule__ClassificationClause__Group_1__0");
					put(grammarAccess.getClassificationFromClauseAccess().getGroup(), "rule__ClassificationFromClause__Group__0");
					put(grammarAccess.getClassificationToClauseAccess().getGroup(), "rule__ClassificationToClause__Group__0");
					put(grammarAccess.getReclassifyAllClauseAccess().getGroup(), "rule__ReclassifyAllClause__Group__0");
					put(grammarAccess.getQualifiedNameListAccess().getGroup(), "rule__QualifiedNameList__Group__0");
					put(grammarAccess.getQualifiedNameListAccess().getGroup_1(), "rule__QualifiedNameList__Group_1__0");
					put(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getGroup(), "rule__InvocationOrAssignementOrDeclarationStatement__Group__0");
					put(grammarAccess.getSuperInvocationStatementAccess().getGroup(), "rule__SuperInvocationStatement__Group__0");
					put(grammarAccess.getThisInvocationStatementAccess().getGroup(), "rule__ThisInvocationStatement__Group__0");
					put(grammarAccess.getInstanceCreationInvocationStatementAccess().getGroup(), "rule__InstanceCreationInvocationStatement__Group__0");
					put(grammarAccess.getVariableDeclarationCompletionAccess().getGroup(), "rule__VariableDeclarationCompletion__Group__0");
					put(grammarAccess.getVariableDeclarationCompletionAccess().getGroup_0(), "rule__VariableDeclarationCompletion__Group_0__0");
					put(grammarAccess.getAssignmentCompletionAccess().getGroup(), "rule__AssignmentCompletion__Group__0");
					put(grammarAccess.getAppliedStereotypePropertyRuleAccess().getPropertyAssignment_0(), "rule__AppliedStereotypePropertyRule__PropertyAssignment_0");
					put(grammarAccess.getAppliedStereotypePropertyRuleAccess().getValueAssignment_1(), "rule__AppliedStereotypePropertyRule__ValueAssignment_1");
					put(grammarAccess.getTestAccess().getExpressionAssignment_0_1(), "rule__Test__ExpressionAssignment_0_1");
					put(grammarAccess.getTestAccess().getAssignExpressionAssignment_1_1(), "rule__Test__AssignExpressionAssignment_1_1");
					put(grammarAccess.getTestAccess().getStatementsAssignment_2_1(), "rule__Test__StatementsAssignment_2_1");
					put(grammarAccess.getTestAccess().getBlockAssignment_3_1(), "rule__Test__BlockAssignment_3_1");
					put(grammarAccess.getBOOLEAN_LITERALAccess().getValueAssignment(), "rule__BOOLEAN_LITERAL__ValueAssignment");
					put(grammarAccess.getINTEGER_LITERALAccess().getValueAssignment(), "rule__INTEGER_LITERAL__ValueAssignment");
					put(grammarAccess.getUNLIMITED_LITERALAccess().getValueAssignment(), "rule__UNLIMITED_LITERAL__ValueAssignment");
					put(grammarAccess.getSTRING_LITERALAccess().getValueAssignment(), "rule__STRING_LITERAL__ValueAssignment");
					put(grammarAccess.getNameExpressionAccess().getPrefixOpAssignment_0_0_0(), "rule__NameExpression__PrefixOpAssignment_0_0_0");
					put(grammarAccess.getNameExpressionAccess().getPathAssignment_0_0_1(), "rule__NameExpression__PathAssignment_0_0_1");
					put(grammarAccess.getNameExpressionAccess().getIdAssignment_0_0_2(), "rule__NameExpression__IdAssignment_0_0_2");
					put(grammarAccess.getNameExpressionAccess().getPathAssignment_0_1_0(), "rule__NameExpression__PathAssignment_0_1_0");
					put(grammarAccess.getNameExpressionAccess().getIdAssignment_0_1_1(), "rule__NameExpression__IdAssignment_0_1_1");
					put(grammarAccess.getNameExpressionAccess().getInvocationCompletionAssignment_0_1_2_0(), "rule__NameExpression__InvocationCompletionAssignment_0_1_2_0");
					put(grammarAccess.getNameExpressionAccess().getSequenceConstructionCompletionAssignment_0_1_2_1(), "rule__NameExpression__SequenceConstructionCompletionAssignment_0_1_2_1");
					put(grammarAccess.getNameExpressionAccess().getPostfixOpAssignment_0_1_2_2(), "rule__NameExpression__PostfixOpAssignment_0_1_2_2");
					put(grammarAccess.getNameExpressionAccess().getSuffixAssignment_1(), "rule__NameExpression__SuffixAssignment_1");
					put(grammarAccess.getQualifiedNamePathAccess().getNamespaceAssignment_0(), "rule__QualifiedNamePath__NamespaceAssignment_0");
					put(grammarAccess.getUnqualifiedNameAccess().getNameAssignment_0(), "rule__UnqualifiedName__NameAssignment_0");
					put(grammarAccess.getUnqualifiedNameAccess().getTemplateBindingAssignment_1(), "rule__UnqualifiedName__TemplateBindingAssignment_1");
					put(grammarAccess.getTemplateBindingAccess().getBindingsAssignment_1(), "rule__TemplateBinding__BindingsAssignment_1");
					put(grammarAccess.getTemplateBindingAccess().getBindingsAssignment_2_1(), "rule__TemplateBinding__BindingsAssignment_2_1");
					put(grammarAccess.getNamedTemplateBindingAccess().getFormalAssignment_0(), "rule__NamedTemplateBinding__FormalAssignment_0");
					put(grammarAccess.getNamedTemplateBindingAccess().getActualAssignment_2(), "rule__NamedTemplateBinding__ActualAssignment_2");
					put(grammarAccess.getQualifiedNameWithBindingAccess().getIdAssignment_0(), "rule__QualifiedNameWithBinding__IdAssignment_0");
					put(grammarAccess.getQualifiedNameWithBindingAccess().getBindingAssignment_1(), "rule__QualifiedNameWithBinding__BindingAssignment_1");
					put(grammarAccess.getQualifiedNameWithBindingAccess().getRemainingAssignment_2_1(), "rule__QualifiedNameWithBinding__RemainingAssignment_2_1");
					put(grammarAccess.getTupleAccess().getTupleElementsAssignment_2_0(), "rule__Tuple__TupleElementsAssignment_2_0");
					put(grammarAccess.getTupleAccess().getTupleElementsAssignment_2_1_1(), "rule__Tuple__TupleElementsAssignment_2_1_1");
					put(grammarAccess.getTupleElementAccess().getArgumentAssignment(), "rule__TupleElement__ArgumentAssignment");
					put(grammarAccess.getConditionalTestExpressionAccess().getExpAssignment_0(), "rule__ConditionalTestExpression__ExpAssignment_0");
					put(grammarAccess.getConditionalTestExpressionAccess().getWhenTrueAssignment_1_1(), "rule__ConditionalTestExpression__WhenTrueAssignment_1_1");
					put(grammarAccess.getConditionalTestExpressionAccess().getWhenFalseAssignment_1_3(), "rule__ConditionalTestExpression__WhenFalseAssignment_1_3");
					put(grammarAccess.getConditionalOrExpressionAccess().getExpAssignment_0(), "rule__ConditionalOrExpression__ExpAssignment_0");
					put(grammarAccess.getConditionalOrExpressionAccess().getExpAssignment_1_1(), "rule__ConditionalOrExpression__ExpAssignment_1_1");
					put(grammarAccess.getConditionalAndExpressionAccess().getExpAssignment_0(), "rule__ConditionalAndExpression__ExpAssignment_0");
					put(grammarAccess.getConditionalAndExpressionAccess().getExpAssignment_1_1(), "rule__ConditionalAndExpression__ExpAssignment_1_1");
					put(grammarAccess.getInclusiveOrExpressionAccess().getExpAssignment_0(), "rule__InclusiveOrExpression__ExpAssignment_0");
					put(grammarAccess.getInclusiveOrExpressionAccess().getExpAssignment_1_1(), "rule__InclusiveOrExpression__ExpAssignment_1_1");
					put(grammarAccess.getExclusiveOrExpressionAccess().getExpAssignment_0(), "rule__ExclusiveOrExpression__ExpAssignment_0");
					put(grammarAccess.getExclusiveOrExpressionAccess().getExpAssignment_1_1(), "rule__ExclusiveOrExpression__ExpAssignment_1_1");
					put(grammarAccess.getAndExpressionAccess().getExpAssignment_0(), "rule__AndExpression__ExpAssignment_0");
					put(grammarAccess.getAndExpressionAccess().getExpAssignment_1_1(), "rule__AndExpression__ExpAssignment_1_1");
					put(grammarAccess.getEqualityExpressionAccess().getExpAssignment_0(), "rule__EqualityExpression__ExpAssignment_0");
					put(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0(), "rule__EqualityExpression__OpAssignment_1_0");
					put(grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1(), "rule__EqualityExpression__ExpAssignment_1_1");
					put(grammarAccess.getClassificationExpressionAccess().getExpAssignment_0(), "rule__ClassificationExpression__ExpAssignment_0");
					put(grammarAccess.getClassificationExpressionAccess().getOpAssignment_1_0(), "rule__ClassificationExpression__OpAssignment_1_0");
					put(grammarAccess.getClassificationExpressionAccess().getTypeNameAssignment_1_1(), "rule__ClassificationExpression__TypeNameAssignment_1_1");
					put(grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0(), "rule__RelationalExpression__LeftAssignment_0");
					put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0(), "rule__RelationalExpression__OpAssignment_1_0");
					put(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1(), "rule__RelationalExpression__RightAssignment_1_1");
					put(grammarAccess.getShiftExpressionAccess().getExpAssignment_0(), "rule__ShiftExpression__ExpAssignment_0");
					put(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0(), "rule__ShiftExpression__OpAssignment_1_0");
					put(grammarAccess.getShiftExpressionAccess().getExpAssignment_1_1(), "rule__ShiftExpression__ExpAssignment_1_1");
					put(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0(), "rule__AdditiveExpression__ExpAssignment_0");
					put(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0(), "rule__AdditiveExpression__OpAssignment_1_0");
					put(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1(), "rule__AdditiveExpression__ExpAssignment_1_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0(), "rule__MultiplicativeExpression__ExpAssignment_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0(), "rule__MultiplicativeExpression__OpAssignment_1_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1(), "rule__MultiplicativeExpression__ExpAssignment_1_1");
					put(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0(), "rule__UnaryExpression__OpAssignment_0");
					put(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1(), "rule__UnaryExpression__ExpAssignment_1");
					put(grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment(), "rule__PrimaryExpression__PrefixAssignment");
					put(grammarAccess.getOperationCallExpressionAccess().getOperationNameAssignment_1(), "rule__OperationCallExpression__OperationNameAssignment_1");
					put(grammarAccess.getOperationCallExpressionAccess().getTupleAssignment_2(), "rule__OperationCallExpression__TupleAssignment_2");
					put(grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_3(), "rule__OperationCallExpression__SuffixAssignment_3");
					put(grammarAccess.getPropertyCallExpressionAccess().getPropertyNameAssignment_1(), "rule__PropertyCallExpression__PropertyNameAssignment_1");
					put(grammarAccess.getPropertyCallExpressionAccess().getIndexAssignment_2_1(), "rule__PropertyCallExpression__IndexAssignment_2_1");
					put(grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_3(), "rule__PropertyCallExpression__SuffixAssignment_3");
					put(grammarAccess.getLinkOperationExpressionAccess().getKindAssignment_1(), "rule__LinkOperationExpression__KindAssignment_1");
					put(grammarAccess.getLinkOperationExpressionAccess().getTupleAssignment_2(), "rule__LinkOperationExpression__TupleAssignment_2");
					put(grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementAssignment_1(), "rule__LinkOperationTuple__LinkOperationTupleElementAssignment_1");
					put(grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementAssignment_2_1(), "rule__LinkOperationTuple__LinkOperationTupleElementAssignment_2_1");
					put(grammarAccess.getLinkOperationTupleElementAccess().getRoleAssignment_0(), "rule__LinkOperationTupleElement__RoleAssignment_0");
					put(grammarAccess.getLinkOperationTupleElementAccess().getRoleIndexAssignment_1_1(), "rule__LinkOperationTupleElement__RoleIndexAssignment_1_1");
					put(grammarAccess.getLinkOperationTupleElementAccess().getObjectAssignment_3(), "rule__LinkOperationTupleElement__ObjectAssignment_3");
					put(grammarAccess.getSequenceOperationExpressionAccess().getOperationNameAssignment_1(), "rule__SequenceOperationExpression__OperationNameAssignment_1");
					put(grammarAccess.getSequenceOperationExpressionAccess().getTupleAssignment_2(), "rule__SequenceOperationExpression__TupleAssignment_2");
					put(grammarAccess.getSequenceOperationExpressionAccess().getSuffixAssignment_3(), "rule__SequenceOperationExpression__SuffixAssignment_3");
					put(grammarAccess.getSequenceReductionExpressionAccess().getIsOrderedAssignment_2(), "rule__SequenceReductionExpression__IsOrderedAssignment_2");
					put(grammarAccess.getSequenceReductionExpressionAccess().getBehaviorAssignment_3(), "rule__SequenceReductionExpression__BehaviorAssignment_3");
					put(grammarAccess.getSequenceReductionExpressionAccess().getSuffixAssignment_4(), "rule__SequenceReductionExpression__SuffixAssignment_4");
					put(grammarAccess.getSelectOrRejectOperationAccess().getOpAssignment_1(), "rule__SelectOrRejectOperation__OpAssignment_1");
					put(grammarAccess.getSelectOrRejectOperationAccess().getNameAssignment_2(), "rule__SelectOrRejectOperation__NameAssignment_2");
					put(grammarAccess.getSelectOrRejectOperationAccess().getExprAssignment_4(), "rule__SelectOrRejectOperation__ExprAssignment_4");
					put(grammarAccess.getSelectOrRejectOperationAccess().getSuffixAssignment_6(), "rule__SelectOrRejectOperation__SuffixAssignment_6");
					put(grammarAccess.getCollectOrIterateOperationAccess().getOpAssignment_1(), "rule__CollectOrIterateOperation__OpAssignment_1");
					put(grammarAccess.getCollectOrIterateOperationAccess().getNameAssignment_2(), "rule__CollectOrIterateOperation__NameAssignment_2");
					put(grammarAccess.getCollectOrIterateOperationAccess().getExprAssignment_4(), "rule__CollectOrIterateOperation__ExprAssignment_4");
					put(grammarAccess.getCollectOrIterateOperationAccess().getSuffixAssignment_6(), "rule__CollectOrIterateOperation__SuffixAssignment_6");
					put(grammarAccess.getForAllOrExistsOrOneOperationAccess().getOpAssignment_1(), "rule__ForAllOrExistsOrOneOperation__OpAssignment_1");
					put(grammarAccess.getForAllOrExistsOrOneOperationAccess().getNameAssignment_2(), "rule__ForAllOrExistsOrOneOperation__NameAssignment_2");
					put(grammarAccess.getForAllOrExistsOrOneOperationAccess().getExprAssignment_4(), "rule__ForAllOrExistsOrOneOperation__ExprAssignment_4");
					put(grammarAccess.getForAllOrExistsOrOneOperationAccess().getSuffixAssignment_6(), "rule__ForAllOrExistsOrOneOperation__SuffixAssignment_6");
					put(grammarAccess.getIsUniqueOperationAccess().getNameAssignment_2(), "rule__IsUniqueOperation__NameAssignment_2");
					put(grammarAccess.getIsUniqueOperationAccess().getExprAssignment_4(), "rule__IsUniqueOperation__ExprAssignment_4");
					put(grammarAccess.getIsUniqueOperationAccess().getSuffixAssignment_6(), "rule__IsUniqueOperation__SuffixAssignment_6");
					put(grammarAccess.getParenthesizedExpressionAccess().getExpOrTypeCastAssignment_1(), "rule__ParenthesizedExpression__ExpOrTypeCastAssignment_1");
					put(grammarAccess.getParenthesizedExpressionAccess().getCastedAssignment_3_0(), "rule__ParenthesizedExpression__CastedAssignment_3_0");
					put(grammarAccess.getParenthesizedExpressionAccess().getSuffixAssignment_3_1(), "rule__ParenthesizedExpression__SuffixAssignment_3_1");
					put(grammarAccess.getThisExpressionAccess().getSuffixAssignment_2(), "rule__ThisExpression__SuffixAssignment_2");
					put(grammarAccess.getSuperInvocationExpressionAccess().getTupleAssignment_1_0(), "rule__SuperInvocationExpression__TupleAssignment_1_0");
					put(grammarAccess.getSuperInvocationExpressionAccess().getOperationNameAssignment_1_1_1(), "rule__SuperInvocationExpression__OperationNameAssignment_1_1_1");
					put(grammarAccess.getSuperInvocationExpressionAccess().getTupleAssignment_1_1_2(), "rule__SuperInvocationExpression__TupleAssignment_1_1_2");
					put(grammarAccess.getInstanceCreationExpressionAccess().getConstructorAssignment_1(), "rule__InstanceCreationExpression__ConstructorAssignment_1");
					put(grammarAccess.getInstanceCreationExpressionAccess().getTupleAssignment_2(), "rule__InstanceCreationExpression__TupleAssignment_2");
					put(grammarAccess.getInstanceCreationExpressionAccess().getSuffixAssignment_3(), "rule__InstanceCreationExpression__SuffixAssignment_3");
					put(grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementAssignment_2_0(), "rule__InstanceCreationTuple__InstanceCreationTupleElementAssignment_2_0");
					put(grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementAssignment_2_1_1(), "rule__InstanceCreationTuple__InstanceCreationTupleElementAssignment_2_1_1");
					put(grammarAccess.getInstanceCreationTupleElementAccess().getRoleAssignment_0(), "rule__InstanceCreationTupleElement__RoleAssignment_0");
					put(grammarAccess.getInstanceCreationTupleElementAccess().getObjectAssignment_2(), "rule__InstanceCreationTupleElement__ObjectAssignment_2");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getMultiplicityIndicatorAssignment_0_0(), "rule__SequenceConstructionOrAccessCompletion__MultiplicityIndicatorAssignment_0_0");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAccessCompletionAssignment_0_1_0(), "rule__SequenceConstructionOrAccessCompletion__AccessCompletionAssignment_0_1_0");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getSequenceCompletionAssignment_0_1_1(), "rule__SequenceConstructionOrAccessCompletion__SequenceCompletionAssignment_0_1_1");
					put(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getExpressionAssignment_1(), "rule__SequenceConstructionOrAccessCompletion__ExpressionAssignment_1");
					put(grammarAccess.getAccessCompletionAccess().getAccessIndexAssignment_0(), "rule__AccessCompletion__AccessIndexAssignment_0");
					put(grammarAccess.getPartialSequenceConstructionCompletionAccess().getExpressionAssignment_1(), "rule__PartialSequenceConstructionCompletion__ExpressionAssignment_1");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementAssignment_1(), "rule__SequenceConstructionExpression__SequenceElementAssignment_1");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementAssignment_2_0_1(), "rule__SequenceConstructionExpression__SequenceElementAssignment_2_0_1");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getRangeUpperAssignment_2_1_1(), "rule__SequenceConstructionExpression__RangeUpperAssignment_2_1_1");
					put(grammarAccess.getBlockAccess().getSequenceAssignment_2(), "rule__Block__SequenceAssignment_2");
					put(grammarAccess.getStatementSequenceAccess().getStatementsAssignment(), "rule__StatementSequence__StatementsAssignment");
					put(grammarAccess.getDocumentedStatementAccess().getCommentAssignment_0(), "rule__DocumentedStatement__CommentAssignment_0");
					put(grammarAccess.getDocumentedStatementAccess().getStatementAssignment_1(), "rule__DocumentedStatement__StatementAssignment_1");
					put(grammarAccess.getInlineStatementAccess().getLangageNameAssignment_3(), "rule__InlineStatement__LangageNameAssignment_3");
					put(grammarAccess.getInlineStatementAccess().getBodyAssignment_5(), "rule__InlineStatement__BodyAssignment_5");
					put(grammarAccess.getAnnotatedStatementAccess().getAnnotationAssignment_1(), "rule__AnnotatedStatement__AnnotationAssignment_1");
					put(grammarAccess.getAnnotatedStatementAccess().getStatementAssignment_2(), "rule__AnnotatedStatement__StatementAssignment_2");
					put(grammarAccess.getAnnotationAccess().getKindAssignment_0(), "rule__Annotation__KindAssignment_0");
					put(grammarAccess.getAnnotationAccess().getArgsAssignment_1_1(), "rule__Annotation__ArgsAssignment_1_1");
					put(grammarAccess.getAnnotationAccess().getArgsAssignment_1_2_1(), "rule__Annotation__ArgsAssignment_1_2_1");
					put(grammarAccess.getBlockStatementAccess().getBlockAssignment(), "rule__BlockStatement__BlockAssignment");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getVarNameAssignment_1(), "rule__LocalNameDeclarationStatement__VarNameAssignment_1");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getTypeAssignment_3(), "rule__LocalNameDeclarationStatement__TypeAssignment_3");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getMultiplicityIndicatorAssignment_4_0(), "rule__LocalNameDeclarationStatement__MultiplicityIndicatorAssignment_4_0");
					put(grammarAccess.getLocalNameDeclarationStatementAccess().getInitAssignment_6(), "rule__LocalNameDeclarationStatement__InitAssignment_6");
					put(grammarAccess.getIfStatementAccess().getSequentialClaussesAssignment_1(), "rule__IfStatement__SequentialClaussesAssignment_1");
					put(grammarAccess.getIfStatementAccess().getFinalClauseAssignment_2(), "rule__IfStatement__FinalClauseAssignment_2");
					put(grammarAccess.getSequentialClausesAccess().getConccurentClausesAssignment_0(), "rule__SequentialClauses__ConccurentClausesAssignment_0");
					put(grammarAccess.getSequentialClausesAccess().getConccurentClausesAssignment_1_2(), "rule__SequentialClauses__ConccurentClausesAssignment_1_2");
					put(grammarAccess.getConcurrentClausesAccess().getNonFinalClauseAssignment_0(), "rule__ConcurrentClauses__NonFinalClauseAssignment_0");
					put(grammarAccess.getConcurrentClausesAccess().getNonFinalClauseAssignment_1_2(), "rule__ConcurrentClauses__NonFinalClauseAssignment_1_2");
					put(grammarAccess.getNonFinalClauseAccess().getConditionAssignment_1(), "rule__NonFinalClause__ConditionAssignment_1");
					put(grammarAccess.getNonFinalClauseAccess().getBlockAssignment_3(), "rule__NonFinalClause__BlockAssignment_3");
					put(grammarAccess.getFinalClauseAccess().getBlockAssignment_1(), "rule__FinalClause__BlockAssignment_1");
					put(grammarAccess.getSwitchStatementAccess().getExpressionAssignment_2(), "rule__SwitchStatement__ExpressionAssignment_2");
					put(grammarAccess.getSwitchStatementAccess().getSwitchClauseAssignment_5(), "rule__SwitchStatement__SwitchClauseAssignment_5");
					put(grammarAccess.getSwitchStatementAccess().getDefaultClauseAssignment_6(), "rule__SwitchStatement__DefaultClauseAssignment_6");
					put(grammarAccess.getSwitchClauseAccess().getSwitchCaseAssignment_0(), "rule__SwitchClause__SwitchCaseAssignment_0");
					put(grammarAccess.getSwitchClauseAccess().getSwitchCaseAssignment_1(), "rule__SwitchClause__SwitchCaseAssignment_1");
					put(grammarAccess.getSwitchClauseAccess().getStatementSequenceAssignment_2(), "rule__SwitchClause__StatementSequenceAssignment_2");
					put(grammarAccess.getSwitchCaseAccess().getExpressionAssignment_1(), "rule__SwitchCase__ExpressionAssignment_1");
					put(grammarAccess.getSwitchDefaultClauseAccess().getStatementSequenceAssignment_2(), "rule__SwitchDefaultClause__StatementSequenceAssignment_2");
					put(grammarAccess.getNonEmptyStatementSequenceAccess().getStatementAssignment(), "rule__NonEmptyStatementSequence__StatementAssignment");
					put(grammarAccess.getWhileStatementAccess().getConditionAssignment_2(), "rule__WhileStatement__ConditionAssignment_2");
					put(grammarAccess.getWhileStatementAccess().getBlockAssignment_4(), "rule__WhileStatement__BlockAssignment_4");
					put(grammarAccess.getDoStatementAccess().getBlockAssignment_1(), "rule__DoStatement__BlockAssignment_1");
					put(grammarAccess.getDoStatementAccess().getConditionAssignment_4(), "rule__DoStatement__ConditionAssignment_4");
					put(grammarAccess.getForStatementAccess().getControlAssignment_2(), "rule__ForStatement__ControlAssignment_2");
					put(grammarAccess.getForStatementAccess().getBlockAssignment_4(), "rule__ForStatement__BlockAssignment_4");
					put(grammarAccess.getForControlAccess().getLoopVariableDefinitionAssignment_0(), "rule__ForControl__LoopVariableDefinitionAssignment_0");
					put(grammarAccess.getForControlAccess().getLoopVariableDefinitionAssignment_1_1(), "rule__ForControl__LoopVariableDefinitionAssignment_1_1");
					put(grammarAccess.getLoopVariableDefinitionAccess().getNameAssignment_0_0(), "rule__LoopVariableDefinition__NameAssignment_0_0");
					put(grammarAccess.getLoopVariableDefinitionAccess().getExpression1Assignment_0_2(), "rule__LoopVariableDefinition__Expression1Assignment_0_2");
					put(grammarAccess.getLoopVariableDefinitionAccess().getExpression2Assignment_0_3_1(), "rule__LoopVariableDefinition__Expression2Assignment_0_3_1");
					put(grammarAccess.getLoopVariableDefinitionAccess().getTypeAssignment_1_0(), "rule__LoopVariableDefinition__TypeAssignment_1_0");
					put(grammarAccess.getLoopVariableDefinitionAccess().getNameAssignment_1_1(), "rule__LoopVariableDefinition__NameAssignment_1_1");
					put(grammarAccess.getLoopVariableDefinitionAccess().getExpressionAssignment_1_3(), "rule__LoopVariableDefinition__ExpressionAssignment_1_3");
					put(grammarAccess.getReturnStatementAccess().getExpressionAssignment_1(), "rule__ReturnStatement__ExpressionAssignment_1");
					put(grammarAccess.getAcceptStatementAccess().getClauseAssignment_0(), "rule__AcceptStatement__ClauseAssignment_0");
					put(grammarAccess.getAcceptStatementAccess().getSimpleAcceptAssignment_1_0(), "rule__AcceptStatement__SimpleAcceptAssignment_1_0");
					put(grammarAccess.getAcceptStatementAccess().getCompoundAcceptAssignment_1_1(), "rule__AcceptStatement__CompoundAcceptAssignment_1_1");
					put(grammarAccess.getCompoundAcceptStatementCompletionAccess().getBlockAssignment_0(), "rule__CompoundAcceptStatementCompletion__BlockAssignment_0");
					put(grammarAccess.getCompoundAcceptStatementCompletionAccess().getAcceptBlockAssignment_1_1(), "rule__CompoundAcceptStatementCompletion__AcceptBlockAssignment_1_1");
					put(grammarAccess.getAcceptBlockAccess().getClauseAssignment_0(), "rule__AcceptBlock__ClauseAssignment_0");
					put(grammarAccess.getAcceptBlockAccess().getBlockAssignment_1(), "rule__AcceptBlock__BlockAssignment_1");
					put(grammarAccess.getAcceptClauseAccess().getNameAssignment_2_0(), "rule__AcceptClause__NameAssignment_2_0");
					put(grammarAccess.getAcceptClauseAccess().getQualifiedNameListAssignment_3(), "rule__AcceptClause__QualifiedNameListAssignment_3");
					put(grammarAccess.getClassifyStatementAccess().getExpressionAssignment_1(), "rule__ClassifyStatement__ExpressionAssignment_1");
					put(grammarAccess.getClassifyStatementAccess().getClauseAssignment_2(), "rule__ClassifyStatement__ClauseAssignment_2");
					put(grammarAccess.getClassificationClauseAccess().getClassifyFromClauseAssignment_0_0(), "rule__ClassificationClause__ClassifyFromClauseAssignment_0_0");
					put(grammarAccess.getClassificationClauseAccess().getClassifyToClauseAssignment_0_1(), "rule__ClassificationClause__ClassifyToClauseAssignment_0_1");
					put(grammarAccess.getClassificationClauseAccess().getReclassyAllClauseAssignment_1_0(), "rule__ClassificationClause__ReclassyAllClauseAssignment_1_0");
					put(grammarAccess.getClassificationClauseAccess().getClassifyToClauseAssignment_1_1(), "rule__ClassificationClause__ClassifyToClauseAssignment_1_1");
					put(grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListAssignment_1(), "rule__ClassificationFromClause__QualifiedNameListAssignment_1");
					put(grammarAccess.getClassificationToClauseAccess().getQualifiedNameListAssignment_1(), "rule__ClassificationToClause__QualifiedNameListAssignment_1");
					put(grammarAccess.getQualifiedNameListAccess().getQualifiedNameAssignment_0(), "rule__QualifiedNameList__QualifiedNameAssignment_0");
					put(grammarAccess.getQualifiedNameListAccess().getQualifiedNameAssignment_1_1(), "rule__QualifiedNameList__QualifiedNameAssignment_1_1");
					put(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getTypePart_OR_assignedPart_OR_invocationPartAssignment_0(), "rule__InvocationOrAssignementOrDeclarationStatement__TypePart_OR_assignedPart_OR_invocationPartAssignment_0");
					put(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getVariableDeclarationCompletionAssignment_1_0(), "rule__InvocationOrAssignementOrDeclarationStatement__VariableDeclarationCompletionAssignment_1_0");
					put(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAssignmentCompletionAssignment_1_1(), "rule__InvocationOrAssignementOrDeclarationStatement__AssignmentCompletionAssignment_1_1");
					put(grammarAccess.getSuperInvocationStatementAccess().get_superAssignment_0(), "rule__SuperInvocationStatement___superAssignment_0");
					put(grammarAccess.getThisInvocationStatementAccess().get_thisAssignment_0(), "rule__ThisInvocationStatement___thisAssignment_0");
					put(grammarAccess.getThisInvocationStatementAccess().getAssignmentCompletionAssignment_1(), "rule__ThisInvocationStatement__AssignmentCompletionAssignment_1");
					put(grammarAccess.getInstanceCreationInvocationStatementAccess().get_newAssignment_0(), "rule__InstanceCreationInvocationStatement___newAssignment_0");
					put(grammarAccess.getVariableDeclarationCompletionAccess().getMultiplicityIndicatorAssignment_0_0(), "rule__VariableDeclarationCompletion__MultiplicityIndicatorAssignment_0_0");
					put(grammarAccess.getVariableDeclarationCompletionAccess().getVariableNameAssignment_1(), "rule__VariableDeclarationCompletion__VariableNameAssignment_1");
					put(grammarAccess.getVariableDeclarationCompletionAccess().getInitValueAssignment_2(), "rule__VariableDeclarationCompletion__InitValueAssignment_2");
					put(grammarAccess.getAssignmentCompletionAccess().getOpAssignment_0(), "rule__AssignmentCompletion__OpAssignment_0");
					put(grammarAccess.getAssignmentCompletionAccess().getRightHandSideAssignment_1(), "rule__AssignmentCompletion__RightHandSideAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr.internal.InternalAppliedStereotypePropertyParser typedParser = (org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contentassist.antlr.internal.InternalAppliedStereotypePropertyParser) parser;
			typedParser.entryRuleAppliedStereotypePropertyRule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AppliedStereotypePropertyGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AppliedStereotypePropertyGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
