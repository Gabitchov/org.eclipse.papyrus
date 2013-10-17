package org.eclipse.papyrus.uml.alf.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.alf.AcceptClause;
import org.eclipse.papyrus.uml.alf.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.alf.AccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AndExpression;
import org.eclipse.papyrus.uml.alf.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.alf.Annotation;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.Block;
import org.eclipse.papyrus.uml.alf.alf.BlockStatement;
import org.eclipse.papyrus.uml.alf.alf.BreakStatement;
import org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression;
import org.eclipse.papyrus.uml.alf.alf.ClassificationClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.uml.alf.alf.ClassifyStatement;
import org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.uml.alf.alf.CompoundAcceptStatementCompletion;
import org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression;
import org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression;
import org.eclipse.papyrus.uml.alf.alf.DoStatement;
import org.eclipse.papyrus.uml.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.uml.alf.alf.EmptyStatement;
import org.eclipse.papyrus.uml.alf.alf.EqualityExpression;
import org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.uml.alf.alf.FinalClause;
import org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.uml.alf.alf.ForControl;
import org.eclipse.papyrus.uml.alf.alf.ForStatement;
import org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.IfStatement;
import org.eclipse.papyrus.uml.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.uml.alf.alf.InlineStatement;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTuple;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement;
import org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.uml.alf.alf.NonFinalClause;
import org.eclipse.papyrus.uml.alf.alf.NullExpression;
import org.eclipse.papyrus.uml.alf.alf.OperationCallExpression;
import org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.uml.alf.alf.PartialSequenceConstructionCompletion;
import org.eclipse.papyrus.uml.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameList;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.ReclassifyAllClause;
import org.eclipse.papyrus.uml.alf.alf.RelationalExpression;
import org.eclipse.papyrus.uml.alf.alf.ReturnStatement;
import org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequentialClauses;
import org.eclipse.papyrus.uml.alf.alf.ShiftExpression;
import org.eclipse.papyrus.uml.alf.alf.SimpleAcceptStatementCompletion;
import org.eclipse.papyrus.uml.alf.alf.StatementSequence;
import org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression;
import org.eclipse.papyrus.uml.alf.alf.SuperInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.SwitchCase;
import org.eclipse.papyrus.uml.alf.alf.SwitchClause;
import org.eclipse.papyrus.uml.alf.alf.SwitchDefaultClause;
import org.eclipse.papyrus.uml.alf.alf.SwitchStatement;
import org.eclipse.papyrus.uml.alf.alf.TemplateBinding;
import org.eclipse.papyrus.uml.alf.alf.Test;
import org.eclipse.papyrus.uml.alf.alf.ThisExpression;
import org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.Tuple;
import org.eclipse.papyrus.uml.alf.alf.TupleElement;
import org.eclipse.papyrus.uml.alf.alf.UNLIMITED_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.UnaryExpression;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion;
import org.eclipse.papyrus.uml.alf.alf.WhileStatement;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class AlfSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AlfGrammarAccess grammarAccess;
	
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
					sequence_BreakStatement(context, (BreakStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASS_EXTENT_EXPRESSION:
				if(context == grammarAccess.getClassExtentExpressionRule() ||
				   context == grammarAccess.getSuffixExpressionRule()) {
					sequence_ClassExtentExpression(context, (ClassExtentExpression) semanticObject); 
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
					sequence_EmptyStatement(context, (EmptyStatement) semanticObject); 
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
					sequence_NullExpression(context, (NullExpression) semanticObject); 
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (clause=AcceptClause block=Block)
	 */
	protected void sequence_AcceptBlock(EObject context, AcceptBlock semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ACCEPT_BLOCK__CLAUSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ACCEPT_BLOCK__CLAUSE));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ACCEPT_BLOCK__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ACCEPT_BLOCK__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAcceptBlockAccess().getClauseAcceptClauseParserRuleCall_0_0(), semanticObject.getClause());
		feeder.accept(grammarAccess.getAcceptBlockAccess().getBlockBlockParserRuleCall_1_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? qualifiedNameList=QualifiedNameList)
	 */
	protected void sequence_AcceptClause(EObject context, AcceptClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion))
	 */
	protected void sequence_AcceptStatement(EObject context, AcceptStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     accessIndex=Expression
	 */
	protected void sequence_AccessCompletion(EObject context, AccessCompletion semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ACCESS_COMPLETION__ACCESS_INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ACCESS_COMPLETION__ACCESS_INDEX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAccessCompletionAccess().getAccessIndexExpressionParserRuleCall_0_0(), semanticObject.getAccessIndex());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=MultiplicativeExpression ((op+='+' | op+='-') exp+=MultiplicativeExpression)*)
	 */
	protected void sequence_AdditiveExpression(EObject context, AdditiveExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=EqualityExpression exp+=EqualityExpression*)
	 */
	protected void sequence_AndExpression(EObject context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotation=Annotation statement=Statement)
	 */
	protected void sequence_AnnotatedStatement(EObject context, AnnotatedStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ANNOTATED_STATEMENT__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ANNOTATED_STATEMENT__ANNOTATION));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ANNOTATED_STATEMENT__STATEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ANNOTATED_STATEMENT__STATEMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAnnotatedStatementAccess().getAnnotationAnnotationParserRuleCall_1_0(), semanticObject.getAnnotation());
		feeder.accept(grammarAccess.getAnnotatedStatementAccess().getStatementStatementParserRuleCall_2_0(), semanticObject.getStatement());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=AnnotationKind (args+=ID args+=ID*)?)
	 */
	protected void sequence_Annotation(EObject context, Annotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=AssignmentOperator rightHandSide=SequenceElement)
	 */
	protected void sequence_AssignmentCompletion(EObject context, AssignmentCompletion semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ASSIGNMENT_COMPLETION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ASSIGNMENT_COMPLETION__OP));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentCompletionAccess().getOpAssignmentOperatorEnumRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getAssignmentCompletionAccess().getRightHandSideSequenceElementParserRuleCall_1_0(), semanticObject.getRightHandSide());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=BooleanValue
	 */
	protected void sequence_BOOLEAN_LITERAL(EObject context, BOOLEAN_LITERAL semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.BOOLEAN_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.BOOLEAN_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBOOLEAN_LITERALAccess().getValueBooleanValueEnumRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_BlockStatement(EObject context, BlockStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.BLOCK_STATEMENT__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.BLOCK_STATEMENT__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBlockStatementAccess().getBlockBlockParserRuleCall_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (sequence=StatementSequence?)
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BreakStatement}
	 */
	protected void sequence_BreakStatement(EObject context, BreakStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ClassExtentExpression}
	 */
	protected void sequence_ClassExtentExpression(EObject context, ClassExtentExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause?) | 
	 *         (reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause)
	 *     )
	 */
	protected void sequence_ClassificationClause(EObject context, ClassificationClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp=RelationalExpression ((op='instanceof' | op='hastype') typeName=NameExpression)?)
	 */
	protected void sequence_ClassificationExpression(EObject context, ClassificationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     qualifiedNameList=QualifiedNameList
	 */
	protected void sequence_ClassificationFromClause(EObject context, ClassificationFromClause semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0(), semanticObject.getQualifiedNameList());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     qualifiedNameList=QualifiedNameList
	 */
	protected void sequence_ClassificationToClause(EObject context, ClassificationToClause semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.CLASSIFICATION_TO_CLAUSE__QUALIFIED_NAME_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.CLASSIFICATION_TO_CLAUSE__QUALIFIED_NAME_LIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassificationToClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0(), semanticObject.getQualifiedNameList());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression clause=ClassificationClause)
	 */
	protected void sequence_ClassifyStatement(EObject context, ClassifyStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.CLASSIFY_STATEMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.CLASSIFY_STATEMENT__EXPRESSION));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.CLASSIFY_STATEMENT__CLAUSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.CLASSIFY_STATEMENT__CLAUSE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassifyStatementAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.accept(grammarAccess.getClassifyStatementAccess().getClauseClassificationClauseParserRuleCall_2_0(), semanticObject.getClause());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=CollectOrIterateOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_CollectOrIterateOperation(EObject context, CollectOrIterateOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (block=Block acceptBlock+=AcceptBlock*)
	 */
	protected void sequence_CompoundAcceptStatementCompletion(EObject context, CompoundAcceptStatementCompletion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nonFinalClause+=NonFinalClause nonFinalClause+=NonFinalClause*)
	 */
	protected void sequence_ConcurrentClauses(EObject context, ConcurrentClauses semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=InclusiveOrExpression exp+=InclusiveOrExpression*)
	 */
	protected void sequence_ConditionalAndExpression(EObject context, ConditionalAndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ConditionalAndExpression exp+=ConditionalAndExpression*)
	 */
	protected void sequence_ConditionalOrExpression(EObject context, ConditionalOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp=ConditionalOrExpression (whenTrue=ConditionalTestExpression whenFalse=ConditionalTestExpression)?)
	 */
	protected void sequence_ConditionalTestExpression(EObject context, ConditionalTestExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (block=Block condition=Expression)
	 */
	protected void sequence_DoStatement(EObject context, DoStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.DO_STATEMENT__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.DO_STATEMENT__BLOCK));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.DO_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.DO_STATEMENT__CONDITION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDoStatementAccess().getBlockBlockParserRuleCall_1_0(), semanticObject.getBlock());
		feeder.accept(grammarAccess.getDoStatementAccess().getConditionExpressionParserRuleCall_4_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((comment=ML_COMMENT | comment=SL_COMMENT)? statement=Statement)
	 */
	protected void sequence_DocumentedStatement(EObject context, DocumentedStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EmptyStatement}
	 */
	protected void sequence_EmptyStatement(EObject context, EmptyStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ClassificationExpression ((op+='==' | op+='!=') exp+=ClassificationExpression)*)
	 */
	protected void sequence_EqualityExpression(EObject context, EqualityExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=AndExpression exp+=AndExpression*)
	 */
	protected void sequence_ExclusiveOrExpression(EObject context, ExclusiveOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_FinalClause(EObject context, FinalClause semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.FINAL_CLAUSE__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.FINAL_CLAUSE__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFinalClauseAccess().getBlockBlockParserRuleCall_1_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=ForAllOrExistsOrOneOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_ForAllOrExistsOrOneOperation(EObject context, ForAllOrExistsOrOneOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (loopVariableDefinition+=LoopVariableDefinition loopVariableDefinition+=LoopVariableDefinition*)
	 */
	protected void sequence_ForControl(EObject context, ForControl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (control=ForControl block=Block)
	 */
	protected void sequence_ForStatement(EObject context, ForStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.FOR_STATEMENT__CONTROL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.FOR_STATEMENT__CONTROL));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.FOR_STATEMENT__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.FOR_STATEMENT__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getForStatementAccess().getControlForControlParserRuleCall_2_0(), semanticObject.getControl());
		feeder.accept(grammarAccess.getForStatementAccess().getBlockBlockParserRuleCall_4_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INTEGER_VALUE
	 */
	protected void sequence_INTEGER_LITERAL(EObject context, INTEGER_LITERAL semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NUMBER_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getINTEGER_LITERALAccess().getValueINTEGER_VALUETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (sequentialClausses=SequentialClauses finalClause=FinalClause?)
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=ExclusiveOrExpression exp+=ExclusiveOrExpression*)
	 */
	protected void sequence_InclusiveOrExpression(EObject context, InclusiveOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (langageName=ID body=STRING)
	 */
	protected void sequence_InlineStatement(EObject context, InlineStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.INLINE_STATEMENT__LANGAGE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.INLINE_STATEMENT__LANGAGE_NAME));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.INLINE_STATEMENT__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.INLINE_STATEMENT__BODY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInlineStatementAccess().getLangageNameIDTerminalRuleCall_3_0(), semanticObject.getLangageName());
		feeder.accept(grammarAccess.getInlineStatementAccess().getBodySTRINGTerminalRuleCall_5_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?)
	 */
	protected void sequence_InstanceCreationExpression(EObject context, InstanceCreationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     _new=InstanceCreationExpression
	 */
	protected void sequence_InstanceCreationInvocationStatement(EObject context, InstanceCreationInvocationStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_INVOCATION_STATEMENT__NEW) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_INVOCATION_STATEMENT__NEW));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInstanceCreationInvocationStatementAccess().get_newInstanceCreationExpressionParserRuleCall_0_0(), semanticObject.get_new());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (role=ID object=Expression)
	 */
	protected void sequence_InstanceCreationTupleElement(EObject context, InstanceCreationTupleElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_TUPLE_ELEMENT__ROLE));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInstanceCreationTupleElementAccess().getRoleIDTerminalRuleCall_0_0(), semanticObject.getRole());
		feeder.accept(grammarAccess.getInstanceCreationTupleElementAccess().getObjectExpressionParserRuleCall_2_0(), semanticObject.getObject());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((instanceCreationTupleElement+=InstanceCreationTupleElement instanceCreationTupleElement+=InstanceCreationTupleElement*)?)
	 */
	protected void sequence_InstanceCreationTuple(EObject context, InstanceCreationTuple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         typePart_OR_assignedPart_OR_invocationPart=NameExpression 
	 *         (variableDeclarationCompletion=VariableDeclarationCompletion | assignmentCompletion=AssignmentCompletion)?
	 *     )
	 */
	protected void sequence_InvocationOrAssignementOrDeclarationStatement(EObject context, InvocationOrAssignementOrDeclarationStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_IsUniqueOperation(EObject context, IsUniqueOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kind=LinkOperationKind tuple=LinkOperationTuple)
	 */
	protected void sequence_LinkOperationExpression(EObject context, LinkOperationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.LINK_OPERATION_EXPRESSION__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.LINK_OPERATION_EXPRESSION__KIND));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.LINK_OPERATION_EXPRESSION__TUPLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.LINK_OPERATION_EXPRESSION__TUPLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLinkOperationExpressionAccess().getKindLinkOperationKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getLinkOperationExpressionAccess().getTupleLinkOperationTupleParserRuleCall_2_0(), semanticObject.getTuple());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (role=ID roleIndex=Expression? object=Expression)
	 */
	protected void sequence_LinkOperationTupleElement(EObject context, LinkOperationTupleElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (linkOperationTupleElement+=LinkOperationTupleElement linkOperationTupleElement+=LinkOperationTupleElement*)
	 */
	protected void sequence_LinkOperationTuple(EObject context, LinkOperationTuple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varName=ID type=QualifiedNameWithBinding multiplicityIndicator?='['? init=SequenceElement)
	 */
	protected void sequence_LocalNameDeclarationStatement(EObject context, LocalNameDeclarationStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ID expression1=Expression expression2=Expression?) | (type=QualifiedNameWithBinding name=ID expression=Expression))
	 */
	protected void sequence_LoopVariableDefinition(EObject context, LoopVariableDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=UnaryExpression ((op+='*' | op+='/' | op+='%') exp+=UnaryExpression)*)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, MultiplicativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (formal=ID actual=QualifiedNameWithBinding)
	 */
	protected void sequence_NamedTemplateBinding(EObject context, NamedTemplateBinding semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NAMED_TEMPLATE_BINDING__FORMAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NAMED_TEMPLATE_BINDING__FORMAL));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NAMED_TEMPLATE_BINDING__ACTUAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NAMED_TEMPLATE_BINDING__ACTUAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedTemplateBindingAccess().getFormalIDTerminalRuleCall_0_0(), semanticObject.getFormal());
		feeder.accept(grammarAccess.getNamedTemplateBindingAccess().getActualQualifiedNameWithBindingParserRuleCall_2_0(), semanticObject.getActual());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     statement+=DocumentedStatement+
	 */
	protected void sequence_NonEmptyStatementSequence(EObject context, NonEmptyStatementSequence semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression block=Block)
	 */
	protected void sequence_NonFinalClause(EObject context, NonFinalClause semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NON_FINAL_CLAUSE__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NON_FINAL_CLAUSE__CONDITION));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NON_FINAL_CLAUSE__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NON_FINAL_CLAUSE__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNonFinalClauseAccess().getConditionExpressionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getNonFinalClauseAccess().getBlockBlockParserRuleCall_3_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {NullExpression}
	 */
	protected void sequence_NullExpression(EObject context, NullExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operationName=ID tuple=Tuple suffix=SuffixExpression?)
	 */
	protected void sequence_OperationCallExpression(EObject context, OperationCallExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expOrTypeCast=Expression (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?)
	 */
	protected void sequence_ParenthesizedExpression(EObject context, ParenthesizedExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=SequenceConstructionExpression
	 */
	protected void sequence_PartialSequenceConstructionCompletion(EObject context, PartialSequenceConstructionCompletion semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPartialSequenceConstructionCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     prefix=ValueSpecification
	 */
	protected void sequence_PrimaryExpression(EObject context, PrimaryExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.PRIMARY_EXPRESSION__PREFIX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.PRIMARY_EXPRESSION__PREFIX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0(), semanticObject.getPrefix());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (propertyName=ID index=Expression? suffix=SuffixExpression?)
	 */
	protected void sequence_PropertyCallExpression(EObject context, PropertyCallExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qualifiedName+=QualifiedNameWithBinding qualifiedName+=QualifiedNameWithBinding*)
	 */
	protected void sequence_QualifiedNameList(EObject context, QualifiedNameList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     namespace+=UnqualifiedName+
	 */
	protected void sequence_QualifiedNamePath(EObject context, QualifiedNamePath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ID binding=TemplateBinding? remaining=QualifiedNameWithBinding?)
	 */
	protected void sequence_QualifiedNameWithBinding(EObject context, QualifiedNameWithBinding semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_ReturnStatement(EObject context, ReturnStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.RETURN_STATEMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.RETURN_STATEMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_STRING_LITERAL(EObject context, STRING_LITERAL semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.STRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSTRING_LITERALAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=SelectOrRejectOperator name=ID expr=Expression suffix=SuffixExpression?)
	 */
	protected void sequence_SelectOrRejectOperation(EObject context, SelectOrRejectOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sequenceElement+=SequenceElement (sequenceElement+=SequenceElement* | rangeUpper=Expression))
	 */
	protected void sequence_SequenceConstructionExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (multiplicityIndicator?='[' (accessCompletion=AccessCompletion | sequenceCompletion=PartialSequenceConstructionCompletion)) | 
	 *         expression=SequenceConstructionExpression
	 *     )
	 */
	protected void sequence_SequenceConstructionOrAccessCompletion(EObject context, SequenceConstructionOrAccessCompletion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?)
	 */
	protected void sequence_SequenceOperationExpression(EObject context, SequenceOperationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (isOrdered?='ordered'? behavior=QualifiedNameWithBinding suffix=SuffixExpression?)
	 */
	protected void sequence_SequenceReductionExpression(EObject context, SequenceReductionExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conccurentClauses+=ConcurrentClauses conccurentClauses+=ConcurrentClauses*)
	 */
	protected void sequence_SequentialClauses(EObject context, SequentialClauses semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp+=AdditiveExpression ((op='<<' | op='>>' | op='>>>') exp+=AdditiveExpression)?)
	 */
	protected void sequence_ShiftExpression(EObject context, ShiftExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tuple=Tuple | (operationName=QualifiedNameWithBinding tuple=Tuple))
	 */
	protected void sequence_SuperInvocationExpression(EObject context, SuperInvocationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     _super=SuperInvocationExpression
	 */
	protected void sequence_SuperInvocationStatement(EObject context, SuperInvocationStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.SUPER_INVOCATION_STATEMENT__SUPER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.SUPER_INVOCATION_STATEMENT__SUPER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSuperInvocationStatementAccess().get_superSuperInvocationExpressionParserRuleCall_0_0(), semanticObject.get_super());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_SwitchCase(EObject context, SwitchCase semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.SWITCH_CASE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.SWITCH_CASE__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSwitchCaseAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence)
	 */
	protected void sequence_SwitchClause(EObject context, SwitchClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     statementSequence=NonEmptyStatementSequence
	 */
	protected void sequence_SwitchDefaultClause(EObject context, SwitchDefaultClause semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSwitchDefaultClauseAccess().getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0(), semanticObject.getStatementSequence());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression switchClause+=SwitchClause* defaultClause=SwitchDefaultClause?)
	 */
	protected void sequence_SwitchStatement(EObject context, SwitchStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bindings+=NamedTemplateBinding bindings+=NamedTemplateBinding*)
	 */
	protected void sequence_TemplateBinding(EObject context, TemplateBinding semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression+=Expression* assignExpression+=AssignmentCompletion* statements+=Statement* block=Block)
	 */
	protected void sequence_Test(EObject context, Test semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (suffix=SuffixExpression?)
	 */
	protected void sequence_ThisExpression(EObject context, ThisExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (_this=ThisExpression assignmentCompletion=AssignmentCompletion?)
	 */
	protected void sequence_ThisInvocationStatement(EObject context, ThisInvocationStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     argument=Expression
	 */
	protected void sequence_TupleElement(EObject context, TupleElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.TUPLE_ELEMENT__ARGUMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.TUPLE_ELEMENT__ARGUMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTupleElementAccess().getArgumentExpressionParserRuleCall_0(), semanticObject.getArgument());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((tupleElements+=TupleElement tupleElements+=TupleElement*)?)
	 */
	protected void sequence_Tuple(EObject context, Tuple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value='*'
	 */
	protected void sequence_UNLIMITED_LITERAL(EObject context, UNLIMITED_LITERAL semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.NUMBER_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUNLIMITED_LITERALAccess().getValueAsteriskKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((op='!' | op='-' | op='+' | op='$' | op='~')? exp=PrimaryExpression)
	 */
	protected void sequence_UnaryExpression(EObject context, UnaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID templateBinding=TemplateBinding?)
	 */
	protected void sequence_UnqualifiedName(EObject context, UnqualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (multiplicityIndicator?='['? variableName=ID initValue=AssignmentCompletion)
	 */
	protected void sequence_VariableDeclarationCompletion(EObject context, VariableDeclarationCompletion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression block=Block)
	 */
	protected void sequence_WhileStatement(EObject context, WhileStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.WHILE_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.WHILE_STATEMENT__CONDITION));
			if(transientValues.isValueTransient(semanticObject, AlfPackage.Literals.WHILE_STATEMENT__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlfPackage.Literals.WHILE_STATEMENT__BLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getWhileStatementAccess().getBlockBlockParserRuleCall_4_0(), semanticObject.getBlock());
		feeder.finish();
	}
}
