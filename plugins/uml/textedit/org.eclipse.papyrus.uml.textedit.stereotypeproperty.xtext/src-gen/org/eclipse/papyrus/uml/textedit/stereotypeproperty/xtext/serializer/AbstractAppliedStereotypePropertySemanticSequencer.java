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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.alf.AcceptBlock;
import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AcceptStatement;
import org.eclipse.papyrus.alf.alf.AccessCompletion;
import org.eclipse.papyrus.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AndExpression;
import org.eclipse.papyrus.alf.alf.AnnotatedStatement;
import org.eclipse.papyrus.alf.alf.Annotation;
import org.eclipse.papyrus.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.alf.alf.Block;
import org.eclipse.papyrus.alf.alf.BlockStatement;
import org.eclipse.papyrus.alf.alf.BreakStatement;
import org.eclipse.papyrus.alf.alf.ClassExtentExpression;
import org.eclipse.papyrus.alf.alf.ClassificationClause;
import org.eclipse.papyrus.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.alf.alf.ClassifyStatement;
import org.eclipse.papyrus.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.alf.alf.CompoundAcceptStatementCompletion;
import org.eclipse.papyrus.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.alf.alf.ConditionalOrExpression;
import org.eclipse.papyrus.alf.alf.ConditionalTestExpression;
import org.eclipse.papyrus.alf.alf.DoStatement;
import org.eclipse.papyrus.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.alf.alf.EmptyStatement;
import org.eclipse.papyrus.alf.alf.EqualityExpression;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.FinalClause;
import org.eclipse.papyrus.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.alf.alf.ForControl;
import org.eclipse.papyrus.alf.alf.ForStatement;
import org.eclipse.papyrus.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.alf.alf.IfStatement;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.InlineStatement;
import org.eclipse.papyrus.alf.alf.InstanceCreationExpression;
import org.eclipse.papyrus.alf.alf.InstanceCreationInvocationStatement;
import org.eclipse.papyrus.alf.alf.InstanceCreationTuple;
import org.eclipse.papyrus.alf.alf.InstanceCreationTupleElement;
import org.eclipse.papyrus.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.alf.alf.IsUniqueOperation;
import org.eclipse.papyrus.alf.alf.LinkOperationExpression;
import org.eclipse.papyrus.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.alf.alf.LinkOperationTupleElement;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.alf.alf.NameExpression;
import org.eclipse.papyrus.alf.alf.NamedTemplateBinding;
import org.eclipse.papyrus.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.alf.alf.NonFinalClause;
import org.eclipse.papyrus.alf.alf.NullExpression;
import org.eclipse.papyrus.alf.alf.OperationCallExpression;
import org.eclipse.papyrus.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.alf.alf.PartialSequenceConstructionCompletion;
import org.eclipse.papyrus.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.alf.alf.PropertyCallExpression;
import org.eclipse.papyrus.alf.alf.QualifiedNameList;
import org.eclipse.papyrus.alf.alf.QualifiedNamePath;
import org.eclipse.papyrus.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.alf.alf.ReclassifyAllClause;
import org.eclipse.papyrus.alf.alf.RelationalExpression;
import org.eclipse.papyrus.alf.alf.ReturnStatement;
import org.eclipse.papyrus.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.alf.alf.SequenceConstructionOrAccessCompletion;
import org.eclipse.papyrus.alf.alf.SequenceOperationExpression;
import org.eclipse.papyrus.alf.alf.SequenceReductionExpression;
import org.eclipse.papyrus.alf.alf.SequentialClauses;
import org.eclipse.papyrus.alf.alf.ShiftExpression;
import org.eclipse.papyrus.alf.alf.SimpleAcceptStatementCompletion;
import org.eclipse.papyrus.alf.alf.StatementSequence;
import org.eclipse.papyrus.alf.alf.SuperInvocationExpression;
import org.eclipse.papyrus.alf.alf.SuperInvocationStatement;
import org.eclipse.papyrus.alf.alf.SwitchCase;
import org.eclipse.papyrus.alf.alf.SwitchClause;
import org.eclipse.papyrus.alf.alf.SwitchDefaultClause;
import org.eclipse.papyrus.alf.alf.SwitchStatement;
import org.eclipse.papyrus.alf.alf.TemplateBinding;
import org.eclipse.papyrus.alf.alf.Test;
import org.eclipse.papyrus.alf.alf.ThisExpression;
import org.eclipse.papyrus.alf.alf.ThisInvocationStatement;
import org.eclipse.papyrus.alf.alf.Tuple;
import org.eclipse.papyrus.alf.alf.TupleElement;
import org.eclipse.papyrus.alf.alf.UNLIMITED_LITERAL;
import org.eclipse.papyrus.alf.alf.UnaryExpression;
import org.eclipse.papyrus.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.alf.alf.VariableDeclarationCompletion;
import org.eclipse.papyrus.alf.alf.WhileStatement;
import org.eclipse.papyrus.alf.serializer.AbstractAlfSemanticSequencer;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.services.AppliedStereotypePropertyGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class AbstractAppliedStereotypePropertySemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected AppliedStereotypePropertyGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	@Inject
	protected Provider<AbstractAlfSemanticSequencer> superSequencerProvider;
	 
	protected AbstractAlfSemanticSequencer superSequencer; 
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.superSequencer = superSequencerProvider.get();
		this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AlfPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AlfPackage.ACCEPT_BLOCK:
				if(context == grammarAccess.getAcceptBlockRule()) {
					sequence_AcceptBlock(context, (AcceptBlock) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACCEPT_CLAUSE:
				if(context == grammarAccess.getAcceptClauseRule()) {
					sequence_AcceptClause(context, (AcceptClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACCEPT_STATEMENT:
				if(context == grammarAccess.getAcceptStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_AcceptStatement(context, (AcceptStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACCESS_COMPLETION:
				if(context == grammarAccess.getAccessCompletionRule()) {
					sequence_AccessCompletion(context, (AccessCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ADDITIVE_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule()) {
					sequence_AdditiveExpression(context, (AdditiveExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.AND_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ANNOTATED_STATEMENT:
				if(context == grammarAccess.getAnnotatedStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_AnnotatedStatement(context, (AnnotatedStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ANNOTATION:
				if(context == grammarAccess.getAnnotationRule()) {
					sequence_Annotation(context, (Annotation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ASSIGNMENT_COMPLETION:
				if(context == grammarAccess.getAssignmentCompletionRule()) {
					sequence_AssignmentCompletion(context, (AssignmentCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BOOLEAN_LITERAL:
				if(context == grammarAccess.getBOOLEAN_LITERALRule() ||
				   context == grammarAccess.getLITERALRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_BOOLEAN_LITERAL(context, (BOOLEAN_LITERAL) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BLOCK:
				if(context == grammarAccess.getBlockRule()) {
					sequence_Block(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BLOCK_STATEMENT:
				if(context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_BlockStatement(context, (BlockStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BREAK_STATEMENT:
				if(context == grammarAccess.getBreakStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (BreakStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASS_EXTENT_EXPRESSION:
				if(context == grammarAccess.getClassExtentExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_SuffixExpression(context, (ClassExtentExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFICATION_CLAUSE:
				if(context == grammarAccess.getClassificationClauseRule()) {
					sequence_ClassificationClause(context, (ClassificationClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFICATION_EXPRESSION:
				if(context == grammarAccess.getClassificationExpressionRule()) {
					sequence_ClassificationExpression(context, (ClassificationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFICATION_FROM_CLAUSE:
				if(context == grammarAccess.getClassificationFromClauseRule()) {
					sequence_ClassificationFromClause(context, (ClassificationFromClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFICATION_TO_CLAUSE:
				if(context == grammarAccess.getClassificationToClauseRule()) {
					sequence_ClassificationToClause(context, (ClassificationToClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFY_STATEMENT:
				if(context == grammarAccess.getClassifyStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ClassifyStatement(context, (ClassifyStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.COLLECT_OR_ITERATE_OPERATION:
				if(context == grammarAccess.getCollectOrIterateOperationRule() ||
				   context == grammarAccess.getSequenceExpansionExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_CollectOrIterateOperation(context, (CollectOrIterateOperation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.COMPOUND_ACCEPT_STATEMENT_COMPLETION:
				if(context == grammarAccess.getCompoundAcceptStatementCompletionRule()) {
					sequence_CompoundAcceptStatementCompletion(context, (CompoundAcceptStatementCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONCURRENT_CLAUSES:
				if(context == grammarAccess.getConcurrentClausesRule()) {
					sequence_ConcurrentClauses(context, (ConcurrentClauses) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONDITIONAL_AND_EXPRESSION:
				if(context == grammarAccess.getConditionalAndExpressionRule()) {
					sequence_ConditionalAndExpression(context, (ConditionalAndExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONDITIONAL_OR_EXPRESSION:
				if(context == grammarAccess.getConditionalOrExpressionRule()) {
					sequence_ConditionalOrExpression(context, (ConditionalOrExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONDITIONAL_TEST_EXPRESSION:
				if(context == grammarAccess.getConditionalTestExpressionRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getSequenceElementRule()) {
					sequence_ConditionalTestExpression(context, (ConditionalTestExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.DO_STATEMENT:
				if(context == grammarAccess.getDoStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_DoStatement(context, (DoStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.DOCUMENTED_STATEMENT:
				if(context == grammarAccess.getDocumentedStatementRule()) {
					sequence_DocumentedStatement(context, (DocumentedStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EMPTY_STATEMENT:
				if(context == grammarAccess.getEmptyStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (EmptyStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EQUALITY_EXPRESSION:
				if(context == grammarAccess.getEqualityExpressionRule()) {
					sequence_EqualityExpression(context, (EqualityExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EXCLUSIVE_OR_EXPRESSION:
				if(context == grammarAccess.getExclusiveOrExpressionRule()) {
					sequence_ExclusiveOrExpression(context, (ExclusiveOrExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FINAL_CLAUSE:
				if(context == grammarAccess.getFinalClauseRule()) {
					sequence_FinalClause(context, (FinalClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_OPERATION:
				if(context == grammarAccess.getForAllOrExistsOrOneOperationRule() ||
				   context == grammarAccess.getSequenceExpansionExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_ForAllOrExistsOrOneOperation(context, (ForAllOrExistsOrOneOperation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FOR_CONTROL:
				if(context == grammarAccess.getForControlRule()) {
					sequence_ForControl(context, (ForControl) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FOR_STATEMENT:
				if(context == grammarAccess.getForStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ForStatement(context, (ForStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INTEGER_LITERAL:
				if(context == grammarAccess.getINTEGER_LITERALRule() ||
				   context == grammarAccess.getLITERALRule() ||
				   context == grammarAccess.getNUMBER_LITERALRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_INTEGER_LITERAL(context, (INTEGER_LITERAL) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.IF_STATEMENT:
				if(context == grammarAccess.getIfStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_IfStatement(context, (IfStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INCLUSIVE_OR_EXPRESSION:
				if(context == grammarAccess.getInclusiveOrExpressionRule()) {
					sequence_InclusiveOrExpression(context, (InclusiveOrExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INLINE_STATEMENT:
				if(context == grammarAccess.getInlineStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_InlineStatement(context, (InlineStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INSTANCE_CREATION_EXPRESSION:
				if(context == grammarAccess.getInstanceCreationExpressionRule() ||
				   context == grammarAccess.getNonLiteralValueSpecificationRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_InstanceCreationExpression(context, (InstanceCreationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INSTANCE_CREATION_INVOCATION_STATEMENT:
				if(context == grammarAccess.getInstanceCreationInvocationStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_InstanceCreationInvocationStatement(context, (InstanceCreationInvocationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INSTANCE_CREATION_TUPLE:
				if(context == grammarAccess.getInstanceCreationTupleRule()) {
					sequence_InstanceCreationTuple(context, (InstanceCreationTuple) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT:
				if(context == grammarAccess.getInstanceCreationTupleElementRule()) {
					sequence_InstanceCreationTupleElement(context, (InstanceCreationTupleElement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT:
				if(context == grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_InvocationOrAssignementOrDeclarationStatement(context, (InvocationOrAssignementOrDeclarationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.IS_UNIQUE_OPERATION:
				if(context == grammarAccess.getIsUniqueOperationRule() ||
				   context == grammarAccess.getSequenceExpansionExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_IsUniqueOperation(context, (IsUniqueOperation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LINK_OPERATION_EXPRESSION:
				if(context == grammarAccess.getLinkOperationExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_LinkOperationExpression(context, (LinkOperationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LINK_OPERATION_TUPLE:
				if(context == grammarAccess.getLinkOperationTupleRule()) {
					sequence_LinkOperationTuple(context, (LinkOperationTuple) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT:
				if(context == grammarAccess.getLinkOperationTupleElementRule()) {
					sequence_LinkOperationTupleElement(context, (LinkOperationTupleElement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT:
				if(context == grammarAccess.getLocalNameDeclarationStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_LocalNameDeclarationStatement(context, (LocalNameDeclarationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LOOP_VARIABLE_DEFINITION:
				if(context == grammarAccess.getLoopVariableDefinitionRule()) {
					sequence_LoopVariableDefinition(context, (LoopVariableDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.MULTIPLICATIVE_EXPRESSION:
				if(context == grammarAccess.getMultiplicativeExpressionRule()) {
					sequence_MultiplicativeExpression(context, (MultiplicativeExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAME_EXPRESSION:
				if(context == grammarAccess.getNameExpressionRule() ||
				   context == grammarAccess.getNonLiteralValueSpecificationRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_NameExpression(context, (NameExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAMED_TEMPLATE_BINDING:
				if(context == grammarAccess.getNamedTemplateBindingRule()) {
					sequence_NamedTemplateBinding(context, (NamedTemplateBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NON_EMPTY_STATEMENT_SEQUENCE:
				if(context == grammarAccess.getNonEmptyStatementSequenceRule()) {
					sequence_NonEmptyStatementSequence(context, (NonEmptyStatementSequence) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NON_FINAL_CLAUSE:
				if(context == grammarAccess.getNonFinalClauseRule()) {
					sequence_NonFinalClause(context, (NonFinalClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NULL_EXPRESSION:
				if(context == grammarAccess.getNullExpressionRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_ValueSpecification(context, (NullExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.OPERATION_CALL_EXPRESSION:
				if(context == grammarAccess.getOperationCallExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_OperationCallExpression(context, (OperationCallExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PARENTHESIZED_EXPRESSION:
				if(context == grammarAccess.getNonLiteralValueSpecificationRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_ParenthesizedExpression(context, (ParenthesizedExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION:
				if(context == grammarAccess.getPartialSequenceConstructionCompletionRule()) {
					sequence_PartialSequenceConstructionCompletion(context, (PartialSequenceConstructionCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PRIMARY_EXPRESSION:
				if(context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression(context, (PrimaryExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PROPERTY_CALL_EXPRESSION:
				if(context == grammarAccess.getPropertyCallExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_PropertyCallExpression(context, (PropertyCallExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.QUALIFIED_NAME_LIST:
				if(context == grammarAccess.getQualifiedNameListRule()) {
					sequence_QualifiedNameList(context, (QualifiedNameList) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.QUALIFIED_NAME_PATH:
				if(context == grammarAccess.getQualifiedNamePathRule()) {
					sequence_QualifiedNamePath(context, (QualifiedNamePath) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.QUALIFIED_NAME_WITH_BINDING:
				if(context == grammarAccess.getQualifiedNameWithBindingRule()) {
					sequence_QualifiedNameWithBinding(context, (QualifiedNameWithBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RECLASSIFY_ALL_CLAUSE:
				if(context == grammarAccess.getReclassifyAllClauseRule()) {
					sequence_ReclassifyAllClause(context, (ReclassifyAllClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RELATIONAL_EXPRESSION:
				if(context == grammarAccess.getRelationalExpressionRule()) {
					sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RETURN_STATEMENT:
				if(context == grammarAccess.getReturnStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ReturnStatement(context, (ReturnStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.STRING_LITERAL:
				if(context == grammarAccess.getLITERALRule() ||
				   context == grammarAccess.getSTRING_LITERALRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_STRING_LITERAL(context, (STRING_LITERAL) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SELECT_OR_REJECT_OPERATION:
				if(context == grammarAccess.getSelectOrRejectOperationRule() ||
				   context == grammarAccess.getSequenceExpansionExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_SelectOrRejectOperation(context, (SelectOrRejectOperation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION:
				if(context == grammarAccess.getSequenceConstructionExpressionRule() ||
				   context == grammarAccess.getSequenceElementRule()) {
					sequence_SequenceConstructionExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION:
				if(context == grammarAccess.getSequenceConstructionOrAccessCompletionRule()) {
					sequence_SequenceConstructionOrAccessCompletion(context, (SequenceConstructionOrAccessCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION:
				if(context == grammarAccess.getSequenceOperationExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_SequenceOperationExpression(context, (SequenceOperationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION:
				if(context == grammarAccess.getSequenceReductionExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_SequenceReductionExpression(context, (SequenceReductionExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENTIAL_CLAUSES:
				if(context == grammarAccess.getSequentialClausesRule()) {
					sequence_SequentialClauses(context, (SequentialClauses) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SHIFT_EXPRESSION:
				if(context == grammarAccess.getShiftExpressionRule()) {
					sequence_ShiftExpression(context, (ShiftExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SIMPLE_ACCEPT_STATEMENT_COMPLETION:
				if(context == grammarAccess.getSimpleAcceptStatementCompletionRule()) {
					sequence_SimpleAcceptStatementCompletion(context, (SimpleAcceptStatementCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.STATEMENT_SEQUENCE:
				if(context == grammarAccess.getStatementSequenceRule()) {
					sequence_StatementSequence(context, (StatementSequence) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SUPER_INVOCATION_EXPRESSION:
				if(context == grammarAccess.getNonLiteralValueSpecificationRule() ||
				   context == grammarAccess.getSuperInvocationExpressionRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_SuperInvocationExpression(context, (SuperInvocationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SUPER_INVOCATION_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getSuperInvocationStatementRule()) {
					sequence_SuperInvocationStatement(context, (SuperInvocationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_CASE:
				if(context == grammarAccess.getSwitchCaseRule()) {
					sequence_SwitchCase(context, (SwitchCase) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_CLAUSE:
				if(context == grammarAccess.getSwitchClauseRule()) {
					sequence_SwitchClause(context, (SwitchClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_DEFAULT_CLAUSE:
				if(context == grammarAccess.getSwitchDefaultClauseRule()) {
					sequence_SwitchDefaultClause(context, (SwitchDefaultClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getSwitchStatementRule()) {
					sequence_SwitchStatement(context, (SwitchStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TEMPLATE_BINDING:
				if(context == grammarAccess.getTemplateBindingRule()) {
					sequence_TemplateBinding(context, (TemplateBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TEST:
				if(context == grammarAccess.getTestRule()) {
					sequence_Test(context, (Test) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.THIS_EXPRESSION:
				if(context == grammarAccess.getNonLiteralValueSpecificationRule() ||
				   context == grammarAccess.getThisExpressionRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_ThisExpression(context, (ThisExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.THIS_INVOCATION_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getThisInvocationStatementRule()) {
					sequence_ThisInvocationStatement(context, (ThisInvocationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TUPLE:
				if(context == grammarAccess.getTupleRule()) {
					sequence_Tuple(context, (Tuple) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TUPLE_ELEMENT:
				if(context == grammarAccess.getTupleElementRule()) {
					sequence_TupleElement(context, (TupleElement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.UNLIMITED_LITERAL:
				if(context == grammarAccess.getLITERALRule() ||
				   context == grammarAccess.getNUMBER_LITERALRule() ||
				   context == grammarAccess.getUNLIMITED_LITERALRule() ||
				   context == grammarAccess.getValueSpecificationRule()) {
					sequence_UNLIMITED_LITERAL(context, (UNLIMITED_LITERAL) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.UNARY_EXPRESSION:
				if(context == grammarAccess.getUnaryExpressionRule()) {
					sequence_UnaryExpression(context, (UnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.UNQUALIFIED_NAME:
				if(context == grammarAccess.getUnqualifiedNameRule()) {
					sequence_UnqualifiedName(context, (UnqualifiedName) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.VARIABLE_DECLARATION_COMPLETION:
				if(context == grammarAccess.getVariableDeclarationCompletionRule()) {
					sequence_VariableDeclarationCompletion(context, (VariableDeclarationCompletion) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.WHILE_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileStatementRule()) {
					sequence_WhileStatement(context, (WhileStatement) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == AppliedStereotypePropertyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AppliedStereotypePropertyPackage.APPLIED_STEREOTYPE_PROPERTY_RULE:
				if(context == grammarAccess.getAppliedStereotypePropertyRuleRule()) {
					sequence_AppliedStereotypePropertyRule(context, (AppliedStereotypePropertyRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (clause=AcceptClause block=Block)
	 */
	protected void sequence_AcceptBlock(EObject context, AcceptBlock semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? qualifiedNameList=QualifiedNameList)
	 */
	protected void sequence_AcceptClause(EObject context, AcceptClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion))
	 */
	protected void sequence_AcceptStatement(EObject context, AcceptStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     accessIndex=Expression
	 */
	protected void sequence_AccessCompletion(EObject context, AccessCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=MultiplicativeExpression ((op+='+' | op+='-') exp+=MultiplicativeExpression)*)
	 */
	protected void sequence_AdditiveExpression(EObject context, AdditiveExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=EqualityExpression exp+=EqualityExpression*)
	 */
	protected void sequence_AndExpression(EObject context, AndExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotation=Annotation statement=Statement)
	 */
	protected void sequence_AnnotatedStatement(EObject context, AnnotatedStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kind=AnnotationKind (args+=ID args+=ID*)?)
	 */
	protected void sequence_Annotation(EObject context, Annotation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[Property|ID] value=Expression)
	 */
	protected void sequence_AppliedStereotypePropertyRule(EObject context, AppliedStereotypePropertyRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AppliedStereotypePropertyPackage.Literals.APPLIED_STEREOTYPE_PROPERTY_RULE__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AppliedStereotypePropertyPackage.Literals.APPLIED_STEREOTYPE_PROPERTY_RULE__PROPERTY));
			if(transientValues.isValueTransient(semanticObject, AppliedStereotypePropertyPackage.Literals.APPLIED_STEREOTYPE_PROPERTY_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AppliedStereotypePropertyPackage.Literals.APPLIED_STEREOTYPE_PROPERTY_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAppliedStereotypePropertyRuleAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1(), semanticObject.getProperty());
		feeder.accept(grammarAccess.getAppliedStereotypePropertyRuleAccess().getValueExpressionParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=AssignmentOperator rightHandSide=SequenceElement)
	 */
	protected void sequence_AssignmentCompletion(EObject context, AssignmentCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=BooleanValue
	 */
	protected void sequence_BOOLEAN_LITERAL(EObject context, BOOLEAN_LITERAL semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_BlockStatement(EObject context, BlockStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sequence=StatementSequence?)
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause?) | 
	 *         (reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause)
	 *     )
	 */
	protected void sequence_ClassificationClause(EObject context, ClassificationClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp=RelationalExpression ((op='instanceof' | op='hastype') typeName=NameExpression)?)
	 */
	protected void sequence_ClassificationExpression(EObject context, ClassificationExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     qualifiedNameList=QualifiedNameList
	 */
	protected void sequence_ClassificationFromClause(EObject context, ClassificationFromClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     qualifiedNameList=QualifiedNameList
	 */
	protected void sequence_ClassificationToClause(EObject context, ClassificationToClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression clause=ClassificationClause)
	 */
	protected void sequence_ClassifyStatement(EObject context, ClassifyStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=CollectOrIterateOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_CollectOrIterateOperation(EObject context, CollectOrIterateOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (block=Block acceptBlock+=AcceptBlock*)
	 */
	protected void sequence_CompoundAcceptStatementCompletion(EObject context, CompoundAcceptStatementCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nonFinalClause+=NonFinalClause nonFinalClause+=NonFinalClause*)
	 */
	protected void sequence_ConcurrentClauses(EObject context, ConcurrentClauses semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=InclusiveOrExpression exp+=InclusiveOrExpression*)
	 */
	protected void sequence_ConditionalAndExpression(EObject context, ConditionalAndExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ConditionalAndExpression exp+=ConditionalAndExpression*)
	 */
	protected void sequence_ConditionalOrExpression(EObject context, ConditionalOrExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp=ConditionalOrExpression (whenTrue=ConditionalTestExpression whenFalse=ConditionalTestExpression)?)
	 */
	protected void sequence_ConditionalTestExpression(EObject context, ConditionalTestExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (block=Block condition=Expression)
	 */
	protected void sequence_DoStatement(EObject context, DoStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((comment=ML_COMMENT | comment=SL_COMMENT)? statement=Statement)
	 */
	protected void sequence_DocumentedStatement(EObject context, DocumentedStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ClassificationExpression ((op+='==' | op+='!=') exp+=ClassificationExpression)*)
	 */
	protected void sequence_EqualityExpression(EObject context, EqualityExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=AndExpression exp+=AndExpression*)
	 */
	protected void sequence_ExclusiveOrExpression(EObject context, ExclusiveOrExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_FinalClause(EObject context, FinalClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=ForAllOrExistsOrOneOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_ForAllOrExistsOrOneOperation(EObject context, ForAllOrExistsOrOneOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (loopVariableDefinition+=LoopVariableDefinition loopVariableDefinition+=LoopVariableDefinition*)
	 */
	protected void sequence_ForControl(EObject context, ForControl semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (control=ForControl block=Block)
	 */
	protected void sequence_ForStatement(EObject context, ForStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=IntegerValue
	 */
	protected void sequence_INTEGER_LITERAL(EObject context, INTEGER_LITERAL semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sequentialClausses=SequentialClauses finalClause=FinalClause?)
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ExclusiveOrExpression exp+=ExclusiveOrExpression*)
	 */
	protected void sequence_InclusiveOrExpression(EObject context, InclusiveOrExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (langageName=ID body=STRING)
	 */
	protected void sequence_InlineStatement(EObject context, InlineStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?)
	 */
	protected void sequence_InstanceCreationExpression(EObject context, InstanceCreationExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     _new=InstanceCreationExpression
	 */
	protected void sequence_InstanceCreationInvocationStatement(EObject context, InstanceCreationInvocationStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (role=ID object=Expression)
	 */
	protected void sequence_InstanceCreationTupleElement(EObject context, InstanceCreationTupleElement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((instanceCreationTupleElement+=InstanceCreationTupleElement instanceCreationTupleElement+=InstanceCreationTupleElement*)?)
	 */
	protected void sequence_InstanceCreationTuple(EObject context, InstanceCreationTuple semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         typePart_OR_assignedPart_OR_invocationPart=NameExpression 
	 *         (variableDeclarationCompletion=VariableDeclarationCompletion | assignmentCompletion=AssignmentCompletion)?
	 *     )
	 */
	protected void sequence_InvocationOrAssignementOrDeclarationStatement(EObject context, InvocationOrAssignementOrDeclarationStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_IsUniqueOperation(EObject context, IsUniqueOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kind=LinkOperationKind tuple=LinkOperationTuple)
	 */
	protected void sequence_LinkOperationExpression(EObject context, LinkOperationExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (role=ID roleIndex=Expression? object=Expression)
	 */
	protected void sequence_LinkOperationTupleElement(EObject context, LinkOperationTupleElement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (linkOperationTupleElement+=LinkOperationTupleElement linkOperationTupleElement+=LinkOperationTupleElement*)
	 */
	protected void sequence_LinkOperationTuple(EObject context, LinkOperationTuple semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varName=ID type=QualifiedNameWithBinding multiplicityIndicator?='['? init=SequenceElement)
	 */
	protected void sequence_LocalNameDeclarationStatement(EObject context, LocalNameDeclarationStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID expression1=Expression expression2=Expression?) | (type=QualifiedNameWithBinding name=ID expression=Expression))
	 */
	protected void sequence_LoopVariableDefinition(EObject context, LoopVariableDefinition semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=UnaryExpression ((op+='*' | op+='/' | op+='%') exp+=UnaryExpression)*)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, MultiplicativeExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             ((prefixOp='++' | prefixOp='--') path=QualifiedNamePath? id=ID) | 
	 *             (
	 *                 path=QualifiedNamePath? 
	 *                 id=ID 
	 *                 (invocationCompletion=Tuple | sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp='++' | postfixOp='--')?
	 *             )
	 *         ) 
	 *         suffix=SuffixExpression?
	 *     )
	 */
	protected void sequence_NameExpression(EObject context, NameExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (formal=ID actual=QualifiedNameWithBinding)
	 */
	protected void sequence_NamedTemplateBinding(EObject context, NamedTemplateBinding semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     statement+=DocumentedStatement+
	 */
	protected void sequence_NonEmptyStatementSequence(EObject context, NonEmptyStatementSequence semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression block=Block)
	 */
	protected void sequence_NonFinalClause(EObject context, NonFinalClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operationName=ID tuple=Tuple suffix=SuffixExpression?)
	 */
	protected void sequence_OperationCallExpression(EObject context, OperationCallExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expOrTypeCast=Expression (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?)
	 */
	protected void sequence_ParenthesizedExpression(EObject context, ParenthesizedExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=SequenceConstructionExpression
	 */
	protected void sequence_PartialSequenceConstructionCompletion(EObject context, PartialSequenceConstructionCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     prefix=ValueSpecification
	 */
	protected void sequence_PrimaryExpression(EObject context, PrimaryExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (propertyName=ID index=Expression? suffix=SuffixExpression?)
	 */
	protected void sequence_PropertyCallExpression(EObject context, PropertyCallExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qualifiedName+=QualifiedNameWithBinding qualifiedName+=QualifiedNameWithBinding*)
	 */
	protected void sequence_QualifiedNameList(EObject context, QualifiedNameList semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namespace+=UnqualifiedName+
	 */
	protected void sequence_QualifiedNamePath(EObject context, QualifiedNamePath semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID binding=TemplateBinding? remaining=QualifiedNameWithBinding?)
	 */
	protected void sequence_QualifiedNameWithBinding(EObject context, QualifiedNameWithBinding semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ReclassifyAllClause}
	 */
	protected void sequence_ReclassifyAllClause(EObject context, ReclassifyAllClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=ShiftExpression ((op='<' | op='>' | op='<=' | op='>=') right=ShiftExpression)?)
	 */
	protected void sequence_RelationalExpression(EObject context, RelationalExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_ReturnStatement(EObject context, ReturnStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_STRING_LITERAL(EObject context, STRING_LITERAL semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=SelectOrRejectOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_SelectOrRejectOperation(EObject context, SelectOrRejectOperation semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sequenceElement+=SequenceElement (sequenceElement+=SequenceElement* | rangeUpper=Expression))
	 */
	protected void sequence_SequenceConstructionExpression(EObject context, SequenceConstructionExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (multiplicityIndicator?='[' (accessCompletion=AccessCompletion | sequenceCompletion=PartialSequenceConstructionCompletion)) | 
	 *         expression=SequenceConstructionExpression
	 *     )
	 */
	protected void sequence_SequenceConstructionOrAccessCompletion(EObject context, SequenceConstructionOrAccessCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?)
	 */
	protected void sequence_SequenceOperationExpression(EObject context, SequenceOperationExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (isOrdered?='ordered'? behavior=QualifiedNameWithBinding suffix=SuffixExpression?)
	 */
	protected void sequence_SequenceReductionExpression(EObject context, SequenceReductionExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conccurentClauses+=ConcurrentClauses conccurentClauses+=ConcurrentClauses*)
	 */
	protected void sequence_SequentialClauses(EObject context, SequentialClauses semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=AdditiveExpression ((op='<<' | op='>>' | op='>>>') exp+=AdditiveExpression)?)
	 */
	protected void sequence_ShiftExpression(EObject context, ShiftExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {SimpleAcceptStatementCompletion}
	 */
	protected void sequence_SimpleAcceptStatementCompletion(EObject context, SimpleAcceptStatementCompletion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     statements+=DocumentedStatement+
	 */
	protected void sequence_StatementSequence(EObject context, StatementSequence semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BreakStatement}
	 */
	protected void sequence_Statement(EObject context, BreakStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EmptyStatement}
	 */
	protected void sequence_Statement(EObject context, EmptyStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ClassExtentExpression}
	 */
	protected void sequence_SuffixExpression(EObject context, ClassExtentExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tuple=Tuple | (operationName=QualifiedNameWithBinding tuple=Tuple))
	 */
	protected void sequence_SuperInvocationExpression(EObject context, SuperInvocationExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     _super=SuperInvocationExpression
	 */
	protected void sequence_SuperInvocationStatement(EObject context, SuperInvocationStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_SwitchCase(EObject context, SwitchCase semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence)
	 */
	protected void sequence_SwitchClause(EObject context, SwitchClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     statementSequence=NonEmptyStatementSequence
	 */
	protected void sequence_SwitchDefaultClause(EObject context, SwitchDefaultClause semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression switchClause+=SwitchClause* defaultClause=SwitchDefaultClause?)
	 */
	protected void sequence_SwitchStatement(EObject context, SwitchStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bindings+=NamedTemplateBinding bindings+=NamedTemplateBinding*)
	 */
	protected void sequence_TemplateBinding(EObject context, TemplateBinding semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression+=Expression* assignExpression+=AssignmentCompletion* statements+=Statement* block=Block)
	 */
	protected void sequence_Test(EObject context, Test semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (suffix=SuffixExpression?)
	 */
	protected void sequence_ThisExpression(EObject context, ThisExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (_this=ThisExpression assignmentCompletion=AssignmentCompletion?)
	 */
	protected void sequence_ThisInvocationStatement(EObject context, ThisInvocationStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     argument=Expression
	 */
	protected void sequence_TupleElement(EObject context, TupleElement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tupleElements+=TupleElement tupleElements+=TupleElement*)?)
	 */
	protected void sequence_Tuple(EObject context, Tuple semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value='*'
	 */
	protected void sequence_UNLIMITED_LITERAL(EObject context, UNLIMITED_LITERAL semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((op='!' | op='-' | op='+' | op='$' | op='~')? exp=PrimaryExpression)
	 */
	protected void sequence_UnaryExpression(EObject context, UnaryExpression semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID templateBinding=TemplateBinding?)
	 */
	protected void sequence_UnqualifiedName(EObject context, UnqualifiedName semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {NullExpression}
	 */
	protected void sequence_ValueSpecification(EObject context, NullExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (multiplicityIndicator?='['? variableName=ID initValue=AssignmentCompletion)
	 */
	protected void sequence_VariableDeclarationCompletion(EObject context, VariableDeclarationCompletion semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression block=Block)
	 */
	protected void sequence_WhileStatement(EObject context, WhileStatement semanticObject) {
		superSequencer.createSequence(context, semanticObject);
	}
}
