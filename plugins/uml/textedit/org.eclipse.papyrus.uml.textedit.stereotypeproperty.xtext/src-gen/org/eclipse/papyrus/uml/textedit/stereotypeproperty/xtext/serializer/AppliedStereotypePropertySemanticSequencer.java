package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.serializer;

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
import org.eclipse.papyrus.uml.alf.serializer.AlfSemanticSequencer;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.ExpressionValueRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.services.AppliedStereotypePropertyGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class AppliedStereotypePropertySemanticSequencer extends AlfSemanticSequencer {

	@Inject
	private AppliedStereotypePropertyGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == AppliedStereotypePropertyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AppliedStereotypePropertyPackage.APPLIED_STEREOTYPE_PROPERTY_RULE:
				if(context == grammarAccess.getAppliedStereotypePropertyRuleRule()) {
					sequence_AppliedStereotypePropertyRule(context, (AppliedStereotypePropertyRule) semanticObject); 
					return; 
				}
				else break;
			case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE:
				if(context == grammarAccess.getExpressionValueRuleRule()) {
					sequence_ExpressionValueRule(context, (ExpressionValueRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (property=[Property|ID] value=ExpressionValueRule)
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
		feeder.accept(grammarAccess.getAppliedStereotypePropertyRuleAccess().getValueExpressionValueRuleParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=SequenceElement
	 */
	protected void sequence_ExpressionValueRule(EObject context, ExpressionValueRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AppliedStereotypePropertyPackage.Literals.EXPRESSION_VALUE_RULE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AppliedStereotypePropertyPackage.Literals.EXPRESSION_VALUE_RULE__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionValueRuleAccess().getExpressionSequenceElementParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
}
