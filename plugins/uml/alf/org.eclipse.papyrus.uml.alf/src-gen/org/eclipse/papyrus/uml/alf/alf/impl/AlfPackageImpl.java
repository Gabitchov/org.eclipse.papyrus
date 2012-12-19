/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.uml.alf.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.alf.AcceptClause;
import org.eclipse.papyrus.uml.alf.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.alf.AccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.uml.alf.alf.AlfFactory;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AndExpression;
import org.eclipse.papyrus.uml.alf.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.alf.Annotation;
import org.eclipse.papyrus.uml.alf.alf.AnnotationKind;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.AssignmentOperator;
import org.eclipse.papyrus.uml.alf.alf.Block;
import org.eclipse.papyrus.uml.alf.alf.BlockStatement;
import org.eclipse.papyrus.uml.alf.alf.BooleanValue;
import org.eclipse.papyrus.uml.alf.alf.BreakStatement;
import org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression;
import org.eclipse.papyrus.uml.alf.alf.ClassificationClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.uml.alf.alf.ClassifyStatement;
import org.eclipse.papyrus.uml.alf.alf.ClearAssocExpression;
import org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperator;
import org.eclipse.papyrus.uml.alf.alf.CompoundAcceptStatementCompletion;
import org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression;
import org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression;
import org.eclipse.papyrus.uml.alf.alf.CreateOrDestroyLinkOperationExpression;
import org.eclipse.papyrus.uml.alf.alf.DoStatement;
import org.eclipse.papyrus.uml.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.uml.alf.alf.EmptyStatement;
import org.eclipse.papyrus.uml.alf.alf.EqualityExpression;
import org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.FinalClause;
import org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperator;
import org.eclipse.papyrus.uml.alf.alf.ForControl;
import org.eclipse.papyrus.uml.alf.alf.ForStatement;
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
import org.eclipse.papyrus.uml.alf.alf.LinkOperationKind;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement;
import org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.uml.alf.alf.NonFinalClause;
import org.eclipse.papyrus.uml.alf.alf.NonLiteralValueSpecification;
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
import org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperator;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionCompletion;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.SequenceElement;
import org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequentialClauses;
import org.eclipse.papyrus.uml.alf.alf.ShiftExpression;
import org.eclipse.papyrus.uml.alf.alf.SimpleAcceptStatementCompletion;
import org.eclipse.papyrus.uml.alf.alf.Statement;
import org.eclipse.papyrus.uml.alf.alf.StatementSequence;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
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
import org.eclipse.papyrus.uml.alf.alf.UnaryExpression;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.alf.alf.ValueSpecification;
import org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion;
import org.eclipse.papyrus.uml.alf.alf.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfPackageImpl extends EPackageImpl implements AlfPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleaN_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numbeR_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integeR_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlimiteD_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass strinG_LITERALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNamePathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unqualifiedNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTemplateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameWithBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalTestExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suffixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationCallExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyCallExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass createOrDestroyLinkOperationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clearAssocExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationTupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationTupleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceOperationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceReductionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceExpansionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectOrRejectOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectOrIterateOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forAllOrExistsOrOneOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isUniqueOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonLiteralValueSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parenthesizedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass superInvocationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationTupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationTupleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceConstructionOrAccessCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass accessCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partialSequenceConstructionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceConstructionCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceConstructionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classExtentExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentedStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inlineStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotatedStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localNameDeclarationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequentialClausesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concurrentClausesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonFinalClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass finalClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchDefaultClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonEmptyStatementSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forControlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopVariableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass breakStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleAcceptStatementCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compoundAcceptStatementCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass acceptClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationFromClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationToClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reclassifyAllClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationOrAssignementOrDeclarationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass superInvocationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisInvocationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationInvocationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentCompletionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum booleanValueEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum linkOperationKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum selectOrRejectOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum collectOrIterateOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum forAllOrExistsOrOneOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum annotationKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assignmentOperatorEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AlfPackageImpl()
  {
    super(eNS_URI, AlfFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link AlfPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AlfPackage init()
  {
    if (isInited) return (AlfPackage)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI);

    // Obtain or create and register package
    AlfPackageImpl theAlfPackage = (AlfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlfPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theAlfPackage.createPackageContents();

    // Initialize created meta-data
    theAlfPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAlfPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AlfPackage.eNS_URI, theAlfPackage);
    return theAlfPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTest()
  {
    return testEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Expression()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_AssignExpression()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Statements()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Block()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLITERAL()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBOOLEAN_LITERAL()
  {
    return booleaN_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBOOLEAN_LITERAL_Value()
  {
    return (EAttribute)booleaN_LITERALEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNUMBER_LITERAL()
  {
    return numbeR_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNUMBER_LITERAL_Value()
  {
    return (EAttribute)numbeR_LITERALEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getINTEGER_LITERAL()
  {
    return integeR_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUNLIMITED_LITERAL()
  {
    return unlimiteD_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSTRING_LITERAL()
  {
    return strinG_LITERALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSTRING_LITERAL_Value()
  {
    return (EAttribute)strinG_LITERALEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameExpression()
  {
    return nameExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameExpression_PrefixOp()
  {
    return (EAttribute)nameExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpression_Path()
  {
    return (EReference)nameExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameExpression_Id()
  {
    return (EAttribute)nameExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpression_InvocationCompletion()
  {
    return (EReference)nameExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpression_SequenceConstructionCompletion()
  {
    return (EReference)nameExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameExpression_PostfixOp()
  {
    return (EAttribute)nameExpressionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpression_Suffix()
  {
    return (EReference)nameExpressionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNamePath()
  {
    return qualifiedNamePathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNamePath_Namespace()
  {
    return (EReference)qualifiedNamePathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnqualifiedName()
  {
    return unqualifiedNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnqualifiedName_Name()
  {
    return (EAttribute)unqualifiedNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnqualifiedName_TemplateBinding()
  {
    return (EReference)unqualifiedNameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateBinding()
  {
    return templateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateBinding_Bindings()
  {
    return (EReference)templateBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedTemplateBinding()
  {
    return namedTemplateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedTemplateBinding_Formal()
  {
    return (EAttribute)namedTemplateBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedTemplateBinding_Actual()
  {
    return (EReference)namedTemplateBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNameWithBinding()
  {
    return qualifiedNameWithBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedNameWithBinding_Id()
  {
    return (EAttribute)qualifiedNameWithBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameWithBinding_Binding()
  {
    return (EReference)qualifiedNameWithBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameWithBinding_Remaining()
  {
    return (EReference)qualifiedNameWithBindingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTuple()
  {
    return tupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTuple_TupleElements()
  {
    return (EReference)tupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleElement()
  {
    return tupleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleElement_Argument()
  {
    return (EReference)tupleElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalTestExpression()
  {
    return conditionalTestExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_Exp()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_WhenTrue()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_WhenFalse()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalOrExpression()
  {
    return conditionalOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalOrExpression_Exp()
  {
    return (EReference)conditionalOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalAndExpression()
  {
    return conditionalAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalAndExpression_Exp()
  {
    return (EReference)conditionalAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInclusiveOrExpression()
  {
    return inclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpression_Exp()
  {
    return (EReference)inclusiveOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExclusiveOrExpression()
  {
    return exclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpression_Exp()
  {
    return (EReference)exclusiveOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Exp()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpression()
  {
    return equalityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Exp()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpression_Op()
  {
    return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationExpression()
  {
    return classificationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_Exp()
  {
    return (EReference)classificationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassificationExpression_Op()
  {
    return (EAttribute)classificationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_TypeName()
  {
    return (EReference)classificationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Left()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Op()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Right()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Exp()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpression_Op()
  {
    return (EAttribute)shiftExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpression()
  {
    return additiveExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_Exp()
  {
    return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdditiveExpression_Op()
  {
    return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpression()
  {
    return multiplicativeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_Exp()
  {
    return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicativeExpression_Op()
  {
    return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpression()
  {
    return unaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Op()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpression_Exp()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpression()
  {
    return primaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Prefix()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuffixExpression()
  {
    return suffixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationCallExpression()
  {
    return operationCallExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationCallExpression_OperationName()
  {
    return (EAttribute)operationCallExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCallExpression_Tuple()
  {
    return (EReference)operationCallExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCallExpression_Suffix()
  {
    return (EReference)operationCallExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyCallExpression()
  {
    return propertyCallExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyCallExpression_PropertyName()
  {
    return (EAttribute)propertyCallExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyCallExpression_Index()
  {
    return (EReference)propertyCallExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyCallExpression_Suffix()
  {
    return (EReference)propertyCallExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationExpression()
  {
    return linkOperationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCreateOrDestroyLinkOperationExpression()
  {
    return createOrDestroyLinkOperationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCreateOrDestroyLinkOperationExpression_Kind()
  {
    return (EAttribute)createOrDestroyLinkOperationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCreateOrDestroyLinkOperationExpression_Tuple()
  {
    return (EReference)createOrDestroyLinkOperationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClearAssocExpression()
  {
    return clearAssocExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClearAssocExpression_End()
  {
    return (EReference)clearAssocExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationTuple()
  {
    return linkOperationTupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTuple_LinkOperationTupleElement()
  {
    return (EReference)linkOperationTupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationTupleElement()
  {
    return linkOperationTupleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLinkOperationTupleElement_Role()
  {
    return (EAttribute)linkOperationTupleElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTupleElement_RoleIndex()
  {
    return (EReference)linkOperationTupleElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationTupleElement_Object()
  {
    return (EReference)linkOperationTupleElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceOperationExpression()
  {
    return sequenceOperationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationExpression_OperationName()
  {
    return (EReference)sequenceOperationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationExpression_Tuple()
  {
    return (EReference)sequenceOperationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceOperationExpression_Suffix()
  {
    return (EReference)sequenceOperationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceReductionExpression()
  {
    return sequenceReductionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceReductionExpression_IsOrdered()
  {
    return (EAttribute)sequenceReductionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceReductionExpression_Behavior()
  {
    return (EReference)sequenceReductionExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceReductionExpression_Suffix()
  {
    return (EReference)sequenceReductionExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceExpansionExpression()
  {
    return sequenceExpansionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceExpansionExpression_Name()
  {
    return (EAttribute)sequenceExpansionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceExpansionExpression_Expr()
  {
    return (EReference)sequenceExpansionExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceExpansionExpression_Suffix()
  {
    return (EReference)sequenceExpansionExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectOrRejectOperation()
  {
    return selectOrRejectOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSelectOrRejectOperation_Op()
  {
    return (EAttribute)selectOrRejectOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectOrIterateOperation()
  {
    return collectOrIterateOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectOrIterateOperation_Op()
  {
    return (EAttribute)collectOrIterateOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForAllOrExistsOrOneOperation()
  {
    return forAllOrExistsOrOneOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForAllOrExistsOrOneOperation_Op()
  {
    return (EAttribute)forAllOrExistsOrOneOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsUniqueOperation()
  {
    return isUniqueOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueSpecification()
  {
    return valueSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonLiteralValueSpecification()
  {
    return nonLiteralValueSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParenthesizedExpression()
  {
    return parenthesizedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParenthesizedExpression_ExpOrTypeCast()
  {
    return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParenthesizedExpression_Casted()
  {
    return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParenthesizedExpression_Suffix()
  {
    return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullExpression()
  {
    return nullExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisExpression()
  {
    return thisExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisExpression_Suffix()
  {
    return (EReference)thisExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuperInvocationExpression()
  {
    return superInvocationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_Tuple()
  {
    return (EReference)superInvocationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_OperationName()
  {
    return (EReference)superInvocationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationExpression()
  {
    return instanceCreationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_Constructor()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_Tuple()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_Suffix()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_SequenceConstuctionCompletion()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationTuple()
  {
    return instanceCreationTupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationTuple_InstanceCreationTupleElement()
  {
    return (EReference)instanceCreationTupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationTupleElement()
  {
    return instanceCreationTupleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceCreationTupleElement_Role()
  {
    return (EAttribute)instanceCreationTupleElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationTupleElement_Object()
  {
    return (EReference)instanceCreationTupleElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceConstructionOrAccessCompletion()
  {
    return sequenceConstructionOrAccessCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceConstructionOrAccessCompletion_MultiplicityIndicator()
  {
    return (EAttribute)sequenceConstructionOrAccessCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionOrAccessCompletion_AccessCompletion()
  {
    return (EReference)sequenceConstructionOrAccessCompletionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionOrAccessCompletion_SequenceCompletion()
  {
    return (EReference)sequenceConstructionOrAccessCompletionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionOrAccessCompletion_Expression()
  {
    return (EReference)sequenceConstructionOrAccessCompletionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAccessCompletion()
  {
    return accessCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAccessCompletion_AccessIndex()
  {
    return (EReference)accessCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartialSequenceConstructionCompletion()
  {
    return partialSequenceConstructionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartialSequenceConstructionCompletion_Expression()
  {
    return (EReference)partialSequenceConstructionCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceConstructionCompletion()
  {
    return sequenceConstructionCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceConstructionCompletion_MultiplicityIndicator()
  {
    return (EAttribute)sequenceConstructionCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionCompletion_Expression()
  {
    return (EReference)sequenceConstructionCompletionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceConstructionExpression()
  {
    return sequenceConstructionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionExpression_SequenceElement()
  {
    return (EReference)sequenceConstructionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceConstructionExpression_RangeUpper()
  {
    return (EReference)sequenceConstructionExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceElement()
  {
    return sequenceElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassExtentExpression()
  {
    return classExtentExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassExtentExpression_Suffix()
  {
    return (EReference)classExtentExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_Sequence()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatementSequence()
  {
    return statementSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatementSequence_Statements()
  {
    return (EReference)statementSequenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentedStatement()
  {
    return documentedStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentedStatement_Comment()
  {
    return (EAttribute)documentedStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentedStatement_Statement()
  {
    return (EReference)documentedStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInlineStatement()
  {
    return inlineStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineStatement_LangageName()
  {
    return (EAttribute)inlineStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineStatement_Body()
  {
    return (EAttribute)inlineStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotatedStatement()
  {
    return annotatedStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotatedStatement_Annotation()
  {
    return (EReference)annotatedStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotatedStatement_Statement()
  {
    return (EReference)annotatedStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotation()
  {
    return annotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotation_Kind()
  {
    return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotation_Args()
  {
    return (EAttribute)annotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockStatement()
  {
    return blockStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlockStatement_Block()
  {
    return (EReference)blockStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyStatement()
  {
    return emptyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalNameDeclarationStatement()
  {
    return localNameDeclarationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalNameDeclarationStatement_VarName()
  {
    return (EAttribute)localNameDeclarationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_Type()
  {
    return (EReference)localNameDeclarationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalNameDeclarationStatement_MultiplicityIndicator()
  {
    return (EAttribute)localNameDeclarationStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_Init()
  {
    return (EReference)localNameDeclarationStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfStatement()
  {
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_SequentialClausses()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_FinalClause()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequentialClauses()
  {
    return sequentialClausesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequentialClauses_ConccurentClauses()
  {
    return (EReference)sequentialClausesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcurrentClauses()
  {
    return concurrentClausesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcurrentClauses_NonFinalClause()
  {
    return (EReference)concurrentClausesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonFinalClause()
  {
    return nonFinalClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Condition()
  {
    return (EReference)nonFinalClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Block()
  {
    return (EReference)nonFinalClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFinalClause()
  {
    return finalClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinalClause_Block()
  {
    return (EReference)finalClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchStatement()
  {
    return switchStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_Expression()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_SwitchClause()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_DefaultClause()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchClause()
  {
    return switchClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_SwitchCase()
  {
    return (EReference)switchClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_StatementSequence()
  {
    return (EReference)switchClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchCase()
  {
    return switchCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchCase_Expression()
  {
    return (EReference)switchCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchDefaultClause()
  {
    return switchDefaultClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchDefaultClause_StatementSequence()
  {
    return (EReference)switchDefaultClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonEmptyStatementSequence()
  {
    return nonEmptyStatementSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonEmptyStatementSequence_Statement()
  {
    return (EReference)nonEmptyStatementSequenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStatement()
  {
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Condition()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Block()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoStatement()
  {
    return doStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Block()
  {
    return (EReference)doStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Condition()
  {
    return (EReference)doStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForStatement()
  {
    return forStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Control()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Block()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForControl()
  {
    return forControlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForControl_LoopVariableDefinition()
  {
    return (EReference)forControlEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopVariableDefinition()
  {
    return loopVariableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopVariableDefinition_Name()
  {
    return (EAttribute)loopVariableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression1()
  {
    return (EReference)loopVariableDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression2()
  {
    return (EReference)loopVariableDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Type()
  {
    return (EReference)loopVariableDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariableDefinition_Expression()
  {
    return (EReference)loopVariableDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBreakStatement()
  {
    return breakStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnStatement()
  {
    return returnStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReturnStatement_Expression()
  {
    return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptStatement()
  {
    return acceptStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_Clause()
  {
    return (EReference)acceptStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_SimpleAccept()
  {
    return (EReference)acceptStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptStatement_CompoundAccept()
  {
    return (EReference)acceptStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleAcceptStatementCompletion()
  {
    return simpleAcceptStatementCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompoundAcceptStatementCompletion()
  {
    return compoundAcceptStatementCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundAcceptStatementCompletion_Block()
  {
    return (EReference)compoundAcceptStatementCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundAcceptStatementCompletion_AcceptBlock()
  {
    return (EReference)compoundAcceptStatementCompletionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptBlock()
  {
    return acceptBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptBlock_Clause()
  {
    return (EReference)acceptBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptBlock_Block()
  {
    return (EReference)acceptBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAcceptClause()
  {
    return acceptClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAcceptClause_Name()
  {
    return (EAttribute)acceptClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAcceptClause_QualifiedNameList()
  {
    return (EReference)acceptClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifyStatement()
  {
    return classifyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_Expression()
  {
    return (EReference)classifyStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_Clause()
  {
    return (EReference)classifyStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationClause()
  {
    return classificationClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ClassifyFromClause()
  {
    return (EReference)classificationClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ClassifyToClause()
  {
    return (EReference)classificationClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationClause_ReclassyAllClause()
  {
    return (EReference)classificationClauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationFromClause()
  {
    return classificationFromClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationFromClause_QualifiedNameList()
  {
    return (EReference)classificationFromClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationToClause()
  {
    return classificationToClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationToClause_QualifiedNameList()
  {
    return (EReference)classificationToClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReclassifyAllClause()
  {
    return reclassifyAllClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNameList()
  {
    return qualifiedNameListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedNameList_QualifiedName()
  {
    return (EReference)qualifiedNameListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocationOrAssignementOrDeclarationStatement()
  {
    return invocationOrAssignementOrDeclarationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()
  {
    return (EReference)invocationOrAssignementOrDeclarationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletion()
  {
    return (EReference)invocationOrAssignementOrDeclarationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()
  {
    return (EReference)invocationOrAssignementOrDeclarationStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuperInvocationStatement()
  {
    return superInvocationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationStatement__super()
  {
    return (EReference)superInvocationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisInvocationStatement()
  {
    return thisInvocationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisInvocationStatement__this()
  {
    return (EReference)thisInvocationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisInvocationStatement_AssignmentCompletion()
  {
    return (EReference)thisInvocationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationInvocationStatement()
  {
    return instanceCreationInvocationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationInvocationStatement__new()
  {
    return (EReference)instanceCreationInvocationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclarationCompletion()
  {
    return variableDeclarationCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDeclarationCompletion_MultiplicityIndicator()
  {
    return (EAttribute)variableDeclarationCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDeclarationCompletion_VariableName()
  {
    return (EAttribute)variableDeclarationCompletionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclarationCompletion_InitValue()
  {
    return (EReference)variableDeclarationCompletionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentCompletion()
  {
    return assignmentCompletionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentCompletion_Op()
  {
    return (EAttribute)assignmentCompletionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentCompletion_RightHandSide()
  {
    return (EReference)assignmentCompletionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBooleanValue()
  {
    return booleanValueEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLinkOperationKind()
  {
    return linkOperationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSelectOrRejectOperator()
  {
    return selectOrRejectOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCollectOrIterateOperator()
  {
    return collectOrIterateOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getForAllOrExistsOrOneOperator()
  {
    return forAllOrExistsOrOneOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAnnotationKind()
  {
    return annotationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssignmentOperator()
  {
    return assignmentOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfFactory getAlfFactory()
  {
    return (AlfFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    testEClass = createEClass(TEST);
    createEReference(testEClass, TEST__EXPRESSION);
    createEReference(testEClass, TEST__ASSIGN_EXPRESSION);
    createEReference(testEClass, TEST__STATEMENTS);
    createEReference(testEClass, TEST__BLOCK);

    literalEClass = createEClass(LITERAL);

    booleaN_LITERALEClass = createEClass(BOOLEAN_LITERAL);
    createEAttribute(booleaN_LITERALEClass, BOOLEAN_LITERAL__VALUE);

    numbeR_LITERALEClass = createEClass(NUMBER_LITERAL);
    createEAttribute(numbeR_LITERALEClass, NUMBER_LITERAL__VALUE);

    integeR_LITERALEClass = createEClass(INTEGER_LITERAL);

    unlimiteD_LITERALEClass = createEClass(UNLIMITED_LITERAL);

    strinG_LITERALEClass = createEClass(STRING_LITERAL);
    createEAttribute(strinG_LITERALEClass, STRING_LITERAL__VALUE);

    nameExpressionEClass = createEClass(NAME_EXPRESSION);
    createEAttribute(nameExpressionEClass, NAME_EXPRESSION__PREFIX_OP);
    createEReference(nameExpressionEClass, NAME_EXPRESSION__PATH);
    createEAttribute(nameExpressionEClass, NAME_EXPRESSION__ID);
    createEReference(nameExpressionEClass, NAME_EXPRESSION__INVOCATION_COMPLETION);
    createEReference(nameExpressionEClass, NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION);
    createEAttribute(nameExpressionEClass, NAME_EXPRESSION__POSTFIX_OP);
    createEReference(nameExpressionEClass, NAME_EXPRESSION__SUFFIX);

    qualifiedNamePathEClass = createEClass(QUALIFIED_NAME_PATH);
    createEReference(qualifiedNamePathEClass, QUALIFIED_NAME_PATH__NAMESPACE);

    unqualifiedNameEClass = createEClass(UNQUALIFIED_NAME);
    createEAttribute(unqualifiedNameEClass, UNQUALIFIED_NAME__NAME);
    createEReference(unqualifiedNameEClass, UNQUALIFIED_NAME__TEMPLATE_BINDING);

    templateBindingEClass = createEClass(TEMPLATE_BINDING);
    createEReference(templateBindingEClass, TEMPLATE_BINDING__BINDINGS);

    namedTemplateBindingEClass = createEClass(NAMED_TEMPLATE_BINDING);
    createEAttribute(namedTemplateBindingEClass, NAMED_TEMPLATE_BINDING__FORMAL);
    createEReference(namedTemplateBindingEClass, NAMED_TEMPLATE_BINDING__ACTUAL);

    qualifiedNameWithBindingEClass = createEClass(QUALIFIED_NAME_WITH_BINDING);
    createEAttribute(qualifiedNameWithBindingEClass, QUALIFIED_NAME_WITH_BINDING__ID);
    createEReference(qualifiedNameWithBindingEClass, QUALIFIED_NAME_WITH_BINDING__BINDING);
    createEReference(qualifiedNameWithBindingEClass, QUALIFIED_NAME_WITH_BINDING__REMAINING);

    tupleEClass = createEClass(TUPLE);
    createEReference(tupleEClass, TUPLE__TUPLE_ELEMENTS);

    tupleElementEClass = createEClass(TUPLE_ELEMENT);
    createEReference(tupleElementEClass, TUPLE_ELEMENT__ARGUMENT);

    expressionEClass = createEClass(EXPRESSION);

    conditionalTestExpressionEClass = createEClass(CONDITIONAL_TEST_EXPRESSION);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__EXP);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__WHEN_TRUE);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__WHEN_FALSE);

    conditionalOrExpressionEClass = createEClass(CONDITIONAL_OR_EXPRESSION);
    createEReference(conditionalOrExpressionEClass, CONDITIONAL_OR_EXPRESSION__EXP);

    conditionalAndExpressionEClass = createEClass(CONDITIONAL_AND_EXPRESSION);
    createEReference(conditionalAndExpressionEClass, CONDITIONAL_AND_EXPRESSION__EXP);

    inclusiveOrExpressionEClass = createEClass(INCLUSIVE_OR_EXPRESSION);
    createEReference(inclusiveOrExpressionEClass, INCLUSIVE_OR_EXPRESSION__EXP);

    exclusiveOrExpressionEClass = createEClass(EXCLUSIVE_OR_EXPRESSION);
    createEReference(exclusiveOrExpressionEClass, EXCLUSIVE_OR_EXPRESSION__EXP);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__EXP);

    equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__EXP);
    createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OP);

    classificationExpressionEClass = createEClass(CLASSIFICATION_EXPRESSION);
    createEReference(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__EXP);
    createEAttribute(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__OP);
    createEReference(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__TYPE_NAME);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OP);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT);

    shiftExpressionEClass = createEClass(SHIFT_EXPRESSION);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__EXP);
    createEAttribute(shiftExpressionEClass, SHIFT_EXPRESSION__OP);

    additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
    createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__EXP);
    createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OP);

    multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
    createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__EXP);
    createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OP);

    unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OP);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__EXP);

    primaryExpressionEClass = createEClass(PRIMARY_EXPRESSION);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__PREFIX);

    suffixExpressionEClass = createEClass(SUFFIX_EXPRESSION);

    operationCallExpressionEClass = createEClass(OPERATION_CALL_EXPRESSION);
    createEAttribute(operationCallExpressionEClass, OPERATION_CALL_EXPRESSION__OPERATION_NAME);
    createEReference(operationCallExpressionEClass, OPERATION_CALL_EXPRESSION__TUPLE);
    createEReference(operationCallExpressionEClass, OPERATION_CALL_EXPRESSION__SUFFIX);

    propertyCallExpressionEClass = createEClass(PROPERTY_CALL_EXPRESSION);
    createEAttribute(propertyCallExpressionEClass, PROPERTY_CALL_EXPRESSION__PROPERTY_NAME);
    createEReference(propertyCallExpressionEClass, PROPERTY_CALL_EXPRESSION__INDEX);
    createEReference(propertyCallExpressionEClass, PROPERTY_CALL_EXPRESSION__SUFFIX);

    linkOperationExpressionEClass = createEClass(LINK_OPERATION_EXPRESSION);

    createOrDestroyLinkOperationExpressionEClass = createEClass(CREATE_OR_DESTROY_LINK_OPERATION_EXPRESSION);
    createEAttribute(createOrDestroyLinkOperationExpressionEClass, CREATE_OR_DESTROY_LINK_OPERATION_EXPRESSION__KIND);
    createEReference(createOrDestroyLinkOperationExpressionEClass, CREATE_OR_DESTROY_LINK_OPERATION_EXPRESSION__TUPLE);

    clearAssocExpressionEClass = createEClass(CLEAR_ASSOC_EXPRESSION);
    createEReference(clearAssocExpressionEClass, CLEAR_ASSOC_EXPRESSION__END);

    linkOperationTupleEClass = createEClass(LINK_OPERATION_TUPLE);
    createEReference(linkOperationTupleEClass, LINK_OPERATION_TUPLE__LINK_OPERATION_TUPLE_ELEMENT);

    linkOperationTupleElementEClass = createEClass(LINK_OPERATION_TUPLE_ELEMENT);
    createEAttribute(linkOperationTupleElementEClass, LINK_OPERATION_TUPLE_ELEMENT__ROLE);
    createEReference(linkOperationTupleElementEClass, LINK_OPERATION_TUPLE_ELEMENT__ROLE_INDEX);
    createEReference(linkOperationTupleElementEClass, LINK_OPERATION_TUPLE_ELEMENT__OBJECT);

    sequenceOperationExpressionEClass = createEClass(SEQUENCE_OPERATION_EXPRESSION);
    createEReference(sequenceOperationExpressionEClass, SEQUENCE_OPERATION_EXPRESSION__OPERATION_NAME);
    createEReference(sequenceOperationExpressionEClass, SEQUENCE_OPERATION_EXPRESSION__TUPLE);
    createEReference(sequenceOperationExpressionEClass, SEQUENCE_OPERATION_EXPRESSION__SUFFIX);

    sequenceReductionExpressionEClass = createEClass(SEQUENCE_REDUCTION_EXPRESSION);
    createEAttribute(sequenceReductionExpressionEClass, SEQUENCE_REDUCTION_EXPRESSION__IS_ORDERED);
    createEReference(sequenceReductionExpressionEClass, SEQUENCE_REDUCTION_EXPRESSION__BEHAVIOR);
    createEReference(sequenceReductionExpressionEClass, SEQUENCE_REDUCTION_EXPRESSION__SUFFIX);

    sequenceExpansionExpressionEClass = createEClass(SEQUENCE_EXPANSION_EXPRESSION);
    createEAttribute(sequenceExpansionExpressionEClass, SEQUENCE_EXPANSION_EXPRESSION__NAME);
    createEReference(sequenceExpansionExpressionEClass, SEQUENCE_EXPANSION_EXPRESSION__EXPR);
    createEReference(sequenceExpansionExpressionEClass, SEQUENCE_EXPANSION_EXPRESSION__SUFFIX);

    selectOrRejectOperationEClass = createEClass(SELECT_OR_REJECT_OPERATION);
    createEAttribute(selectOrRejectOperationEClass, SELECT_OR_REJECT_OPERATION__OP);

    collectOrIterateOperationEClass = createEClass(COLLECT_OR_ITERATE_OPERATION);
    createEAttribute(collectOrIterateOperationEClass, COLLECT_OR_ITERATE_OPERATION__OP);

    forAllOrExistsOrOneOperationEClass = createEClass(FOR_ALL_OR_EXISTS_OR_ONE_OPERATION);
    createEAttribute(forAllOrExistsOrOneOperationEClass, FOR_ALL_OR_EXISTS_OR_ONE_OPERATION__OP);

    isUniqueOperationEClass = createEClass(IS_UNIQUE_OPERATION);

    valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);

    nonLiteralValueSpecificationEClass = createEClass(NON_LITERAL_VALUE_SPECIFICATION);

    parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
    createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST);
    createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__CASTED);
    createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__SUFFIX);

    nullExpressionEClass = createEClass(NULL_EXPRESSION);

    thisExpressionEClass = createEClass(THIS_EXPRESSION);
    createEReference(thisExpressionEClass, THIS_EXPRESSION__SUFFIX);

    superInvocationExpressionEClass = createEClass(SUPER_INVOCATION_EXPRESSION);
    createEReference(superInvocationExpressionEClass, SUPER_INVOCATION_EXPRESSION__TUPLE);
    createEReference(superInvocationExpressionEClass, SUPER_INVOCATION_EXPRESSION__OPERATION_NAME);

    instanceCreationExpressionEClass = createEClass(INSTANCE_CREATION_EXPRESSION);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__CONSTRUCTOR);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__TUPLE);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__SUFFIX);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__SEQUENCE_CONSTUCTION_COMPLETION);

    instanceCreationTupleEClass = createEClass(INSTANCE_CREATION_TUPLE);
    createEReference(instanceCreationTupleEClass, INSTANCE_CREATION_TUPLE__INSTANCE_CREATION_TUPLE_ELEMENT);

    instanceCreationTupleElementEClass = createEClass(INSTANCE_CREATION_TUPLE_ELEMENT);
    createEAttribute(instanceCreationTupleElementEClass, INSTANCE_CREATION_TUPLE_ELEMENT__ROLE);
    createEReference(instanceCreationTupleElementEClass, INSTANCE_CREATION_TUPLE_ELEMENT__OBJECT);

    sequenceConstructionOrAccessCompletionEClass = createEClass(SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION);
    createEAttribute(sequenceConstructionOrAccessCompletionEClass, SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__MULTIPLICITY_INDICATOR);
    createEReference(sequenceConstructionOrAccessCompletionEClass, SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__ACCESS_COMPLETION);
    createEReference(sequenceConstructionOrAccessCompletionEClass, SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__SEQUENCE_COMPLETION);
    createEReference(sequenceConstructionOrAccessCompletionEClass, SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION__EXPRESSION);

    accessCompletionEClass = createEClass(ACCESS_COMPLETION);
    createEReference(accessCompletionEClass, ACCESS_COMPLETION__ACCESS_INDEX);

    partialSequenceConstructionCompletionEClass = createEClass(PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION);
    createEReference(partialSequenceConstructionCompletionEClass, PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION__EXPRESSION);

    sequenceConstructionCompletionEClass = createEClass(SEQUENCE_CONSTRUCTION_COMPLETION);
    createEAttribute(sequenceConstructionCompletionEClass, SEQUENCE_CONSTRUCTION_COMPLETION__MULTIPLICITY_INDICATOR);
    createEReference(sequenceConstructionCompletionEClass, SEQUENCE_CONSTRUCTION_COMPLETION__EXPRESSION);

    sequenceConstructionExpressionEClass = createEClass(SEQUENCE_CONSTRUCTION_EXPRESSION);
    createEReference(sequenceConstructionExpressionEClass, SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT);
    createEReference(sequenceConstructionExpressionEClass, SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER);

    sequenceElementEClass = createEClass(SEQUENCE_ELEMENT);

    classExtentExpressionEClass = createEClass(CLASS_EXTENT_EXPRESSION);
    createEReference(classExtentExpressionEClass, CLASS_EXTENT_EXPRESSION__SUFFIX);

    blockEClass = createEClass(BLOCK);
    createEReference(blockEClass, BLOCK__SEQUENCE);

    statementSequenceEClass = createEClass(STATEMENT_SEQUENCE);
    createEReference(statementSequenceEClass, STATEMENT_SEQUENCE__STATEMENTS);

    documentedStatementEClass = createEClass(DOCUMENTED_STATEMENT);
    createEAttribute(documentedStatementEClass, DOCUMENTED_STATEMENT__COMMENT);
    createEReference(documentedStatementEClass, DOCUMENTED_STATEMENT__STATEMENT);

    inlineStatementEClass = createEClass(INLINE_STATEMENT);
    createEAttribute(inlineStatementEClass, INLINE_STATEMENT__LANGAGE_NAME);
    createEAttribute(inlineStatementEClass, INLINE_STATEMENT__BODY);

    annotatedStatementEClass = createEClass(ANNOTATED_STATEMENT);
    createEReference(annotatedStatementEClass, ANNOTATED_STATEMENT__ANNOTATION);
    createEReference(annotatedStatementEClass, ANNOTATED_STATEMENT__STATEMENT);

    statementEClass = createEClass(STATEMENT);

    annotationEClass = createEClass(ANNOTATION);
    createEAttribute(annotationEClass, ANNOTATION__KIND);
    createEAttribute(annotationEClass, ANNOTATION__ARGS);

    blockStatementEClass = createEClass(BLOCK_STATEMENT);
    createEReference(blockStatementEClass, BLOCK_STATEMENT__BLOCK);

    emptyStatementEClass = createEClass(EMPTY_STATEMENT);

    localNameDeclarationStatementEClass = createEClass(LOCAL_NAME_DECLARATION_STATEMENT);
    createEAttribute(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__VAR_NAME);
    createEReference(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__TYPE);
    createEAttribute(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__MULTIPLICITY_INDICATOR);
    createEReference(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__INIT);

    ifStatementEClass = createEClass(IF_STATEMENT);
    createEReference(ifStatementEClass, IF_STATEMENT__SEQUENTIAL_CLAUSSES);
    createEReference(ifStatementEClass, IF_STATEMENT__FINAL_CLAUSE);

    sequentialClausesEClass = createEClass(SEQUENTIAL_CLAUSES);
    createEReference(sequentialClausesEClass, SEQUENTIAL_CLAUSES__CONCCURENT_CLAUSES);

    concurrentClausesEClass = createEClass(CONCURRENT_CLAUSES);
    createEReference(concurrentClausesEClass, CONCURRENT_CLAUSES__NON_FINAL_CLAUSE);

    nonFinalClauseEClass = createEClass(NON_FINAL_CLAUSE);
    createEReference(nonFinalClauseEClass, NON_FINAL_CLAUSE__CONDITION);
    createEReference(nonFinalClauseEClass, NON_FINAL_CLAUSE__BLOCK);

    finalClauseEClass = createEClass(FINAL_CLAUSE);
    createEReference(finalClauseEClass, FINAL_CLAUSE__BLOCK);

    switchStatementEClass = createEClass(SWITCH_STATEMENT);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__EXPRESSION);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__SWITCH_CLAUSE);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__DEFAULT_CLAUSE);

    switchClauseEClass = createEClass(SWITCH_CLAUSE);
    createEReference(switchClauseEClass, SWITCH_CLAUSE__SWITCH_CASE);
    createEReference(switchClauseEClass, SWITCH_CLAUSE__STATEMENT_SEQUENCE);

    switchCaseEClass = createEClass(SWITCH_CASE);
    createEReference(switchCaseEClass, SWITCH_CASE__EXPRESSION);

    switchDefaultClauseEClass = createEClass(SWITCH_DEFAULT_CLAUSE);
    createEReference(switchDefaultClauseEClass, SWITCH_DEFAULT_CLAUSE__STATEMENT_SEQUENCE);

    nonEmptyStatementSequenceEClass = createEClass(NON_EMPTY_STATEMENT_SEQUENCE);
    createEReference(nonEmptyStatementSequenceEClass, NON_EMPTY_STATEMENT_SEQUENCE__STATEMENT);

    whileStatementEClass = createEClass(WHILE_STATEMENT);
    createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
    createEReference(whileStatementEClass, WHILE_STATEMENT__BLOCK);

    doStatementEClass = createEClass(DO_STATEMENT);
    createEReference(doStatementEClass, DO_STATEMENT__BLOCK);
    createEReference(doStatementEClass, DO_STATEMENT__CONDITION);

    forStatementEClass = createEClass(FOR_STATEMENT);
    createEReference(forStatementEClass, FOR_STATEMENT__CONTROL);
    createEReference(forStatementEClass, FOR_STATEMENT__BLOCK);

    forControlEClass = createEClass(FOR_CONTROL);
    createEReference(forControlEClass, FOR_CONTROL__LOOP_VARIABLE_DEFINITION);

    loopVariableDefinitionEClass = createEClass(LOOP_VARIABLE_DEFINITION);
    createEAttribute(loopVariableDefinitionEClass, LOOP_VARIABLE_DEFINITION__NAME);
    createEReference(loopVariableDefinitionEClass, LOOP_VARIABLE_DEFINITION__EXPRESSION1);
    createEReference(loopVariableDefinitionEClass, LOOP_VARIABLE_DEFINITION__EXPRESSION2);
    createEReference(loopVariableDefinitionEClass, LOOP_VARIABLE_DEFINITION__TYPE);
    createEReference(loopVariableDefinitionEClass, LOOP_VARIABLE_DEFINITION__EXPRESSION);

    breakStatementEClass = createEClass(BREAK_STATEMENT);

    returnStatementEClass = createEClass(RETURN_STATEMENT);
    createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

    acceptStatementEClass = createEClass(ACCEPT_STATEMENT);
    createEReference(acceptStatementEClass, ACCEPT_STATEMENT__CLAUSE);
    createEReference(acceptStatementEClass, ACCEPT_STATEMENT__SIMPLE_ACCEPT);
    createEReference(acceptStatementEClass, ACCEPT_STATEMENT__COMPOUND_ACCEPT);

    simpleAcceptStatementCompletionEClass = createEClass(SIMPLE_ACCEPT_STATEMENT_COMPLETION);

    compoundAcceptStatementCompletionEClass = createEClass(COMPOUND_ACCEPT_STATEMENT_COMPLETION);
    createEReference(compoundAcceptStatementCompletionEClass, COMPOUND_ACCEPT_STATEMENT_COMPLETION__BLOCK);
    createEReference(compoundAcceptStatementCompletionEClass, COMPOUND_ACCEPT_STATEMENT_COMPLETION__ACCEPT_BLOCK);

    acceptBlockEClass = createEClass(ACCEPT_BLOCK);
    createEReference(acceptBlockEClass, ACCEPT_BLOCK__CLAUSE);
    createEReference(acceptBlockEClass, ACCEPT_BLOCK__BLOCK);

    acceptClauseEClass = createEClass(ACCEPT_CLAUSE);
    createEAttribute(acceptClauseEClass, ACCEPT_CLAUSE__NAME);
    createEReference(acceptClauseEClass, ACCEPT_CLAUSE__QUALIFIED_NAME_LIST);

    classifyStatementEClass = createEClass(CLASSIFY_STATEMENT);
    createEReference(classifyStatementEClass, CLASSIFY_STATEMENT__EXPRESSION);
    createEReference(classifyStatementEClass, CLASSIFY_STATEMENT__CLAUSE);

    classificationClauseEClass = createEClass(CLASSIFICATION_CLAUSE);
    createEReference(classificationClauseEClass, CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE);
    createEReference(classificationClauseEClass, CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE);
    createEReference(classificationClauseEClass, CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE);

    classificationFromClauseEClass = createEClass(CLASSIFICATION_FROM_CLAUSE);
    createEReference(classificationFromClauseEClass, CLASSIFICATION_FROM_CLAUSE__QUALIFIED_NAME_LIST);

    classificationToClauseEClass = createEClass(CLASSIFICATION_TO_CLAUSE);
    createEReference(classificationToClauseEClass, CLASSIFICATION_TO_CLAUSE__QUALIFIED_NAME_LIST);

    reclassifyAllClauseEClass = createEClass(RECLASSIFY_ALL_CLAUSE);

    qualifiedNameListEClass = createEClass(QUALIFIED_NAME_LIST);
    createEReference(qualifiedNameListEClass, QUALIFIED_NAME_LIST__QUALIFIED_NAME);

    invocationOrAssignementOrDeclarationStatementEClass = createEClass(INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT);
    createEReference(invocationOrAssignementOrDeclarationStatementEClass, INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__TYPE_PART_OR_ASSIGNED_PART_OR_INVOCATION_PART);
    createEReference(invocationOrAssignementOrDeclarationStatementEClass, INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__VARIABLE_DECLARATION_COMPLETION);
    createEReference(invocationOrAssignementOrDeclarationStatementEClass, INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT__ASSIGNMENT_COMPLETION);

    superInvocationStatementEClass = createEClass(SUPER_INVOCATION_STATEMENT);
    createEReference(superInvocationStatementEClass, SUPER_INVOCATION_STATEMENT__SUPER);

    thisInvocationStatementEClass = createEClass(THIS_INVOCATION_STATEMENT);
    createEReference(thisInvocationStatementEClass, THIS_INVOCATION_STATEMENT__THIS);
    createEReference(thisInvocationStatementEClass, THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION);

    instanceCreationInvocationStatementEClass = createEClass(INSTANCE_CREATION_INVOCATION_STATEMENT);
    createEReference(instanceCreationInvocationStatementEClass, INSTANCE_CREATION_INVOCATION_STATEMENT__NEW);

    variableDeclarationCompletionEClass = createEClass(VARIABLE_DECLARATION_COMPLETION);
    createEAttribute(variableDeclarationCompletionEClass, VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR);
    createEAttribute(variableDeclarationCompletionEClass, VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME);
    createEReference(variableDeclarationCompletionEClass, VARIABLE_DECLARATION_COMPLETION__INIT_VALUE);

    assignmentCompletionEClass = createEClass(ASSIGNMENT_COMPLETION);
    createEAttribute(assignmentCompletionEClass, ASSIGNMENT_COMPLETION__OP);
    createEReference(assignmentCompletionEClass, ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE);

    // Create enums
    booleanValueEEnum = createEEnum(BOOLEAN_VALUE);
    linkOperationKindEEnum = createEEnum(LINK_OPERATION_KIND);
    selectOrRejectOperatorEEnum = createEEnum(SELECT_OR_REJECT_OPERATOR);
    collectOrIterateOperatorEEnum = createEEnum(COLLECT_OR_ITERATE_OPERATOR);
    forAllOrExistsOrOneOperatorEEnum = createEEnum(FOR_ALL_OR_EXISTS_OR_ONE_OPERATOR);
    annotationKindEEnum = createEEnum(ANNOTATION_KIND);
    assignmentOperatorEEnum = createEEnum(ASSIGNMENT_OPERATOR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    literalEClass.getESuperTypes().add(this.getValueSpecification());
    booleaN_LITERALEClass.getESuperTypes().add(this.getLITERAL());
    numbeR_LITERALEClass.getESuperTypes().add(this.getLITERAL());
    integeR_LITERALEClass.getESuperTypes().add(this.getNUMBER_LITERAL());
    unlimiteD_LITERALEClass.getESuperTypes().add(this.getNUMBER_LITERAL());
    strinG_LITERALEClass.getESuperTypes().add(this.getLITERAL());
    nameExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    nameExpressionEClass.getESuperTypes().add(this.getNonLiteralValueSpecification());
    expressionEClass.getESuperTypes().add(this.getSequenceElement());
    conditionalTestExpressionEClass.getESuperTypes().add(this.getExpression());
    operationCallExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    propertyCallExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    linkOperationExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    createOrDestroyLinkOperationExpressionEClass.getESuperTypes().add(this.getLinkOperationExpression());
    clearAssocExpressionEClass.getESuperTypes().add(this.getLinkOperationExpression());
    sequenceOperationExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    sequenceReductionExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    sequenceExpansionExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    selectOrRejectOperationEClass.getESuperTypes().add(this.getSequenceExpansionExpression());
    collectOrIterateOperationEClass.getESuperTypes().add(this.getSequenceExpansionExpression());
    forAllOrExistsOrOneOperationEClass.getESuperTypes().add(this.getSequenceExpansionExpression());
    isUniqueOperationEClass.getESuperTypes().add(this.getSequenceExpansionExpression());
    parenthesizedExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    parenthesizedExpressionEClass.getESuperTypes().add(this.getNonLiteralValueSpecification());
    nullExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    thisExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    thisExpressionEClass.getESuperTypes().add(this.getNonLiteralValueSpecification());
    superInvocationExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    superInvocationExpressionEClass.getESuperTypes().add(this.getNonLiteralValueSpecification());
    instanceCreationExpressionEClass.getESuperTypes().add(this.getValueSpecification());
    instanceCreationExpressionEClass.getESuperTypes().add(this.getNonLiteralValueSpecification());
    sequenceConstructionExpressionEClass.getESuperTypes().add(this.getSequenceElement());
    classExtentExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
    inlineStatementEClass.getESuperTypes().add(this.getStatement());
    annotatedStatementEClass.getESuperTypes().add(this.getStatement());
    blockStatementEClass.getESuperTypes().add(this.getStatement());
    emptyStatementEClass.getESuperTypes().add(this.getStatement());
    localNameDeclarationStatementEClass.getESuperTypes().add(this.getStatement());
    ifStatementEClass.getESuperTypes().add(this.getStatement());
    switchStatementEClass.getESuperTypes().add(this.getStatement());
    whileStatementEClass.getESuperTypes().add(this.getStatement());
    doStatementEClass.getESuperTypes().add(this.getStatement());
    forStatementEClass.getESuperTypes().add(this.getStatement());
    breakStatementEClass.getESuperTypes().add(this.getStatement());
    returnStatementEClass.getESuperTypes().add(this.getStatement());
    acceptStatementEClass.getESuperTypes().add(this.getStatement());
    classifyStatementEClass.getESuperTypes().add(this.getStatement());
    invocationOrAssignementOrDeclarationStatementEClass.getESuperTypes().add(this.getStatement());
    superInvocationStatementEClass.getESuperTypes().add(this.getStatement());
    thisInvocationStatementEClass.getESuperTypes().add(this.getStatement());
    instanceCreationInvocationStatementEClass.getESuperTypes().add(this.getStatement());

    // Initialize classes and features; add operations and parameters
    initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTest_Expression(), this.getExpression(), null, "expression", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_AssignExpression(), this.getAssignmentCompletion(), null, "assignExpression", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Statements(), this.getStatement(), null, "statements", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Block(), this.getBlock(), null, "block", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, org.eclipse.papyrus.uml.alf.alf.LITERAL.class, "LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(booleaN_LITERALEClass, org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL.class, "BOOLEAN_LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBOOLEAN_LITERAL_Value(), this.getBooleanValue(), "value", null, 0, 1, org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numbeR_LITERALEClass, org.eclipse.papyrus.uml.alf.alf.NUMBER_LITERAL.class, "NUMBER_LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNUMBER_LITERAL_Value(), ecorePackage.getEString(), "value", null, 0, 1, org.eclipse.papyrus.uml.alf.alf.NUMBER_LITERAL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integeR_LITERALEClass, org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL.class, "INTEGER_LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unlimiteD_LITERALEClass, org.eclipse.papyrus.uml.alf.alf.UNLIMITED_LITERAL.class, "UNLIMITED_LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(strinG_LITERALEClass, org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL.class, "STRING_LITERAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSTRING_LITERAL_Value(), ecorePackage.getEString(), "value", null, 0, 1, org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameExpressionEClass, NameExpression.class, "NameExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNameExpression_PrefixOp(), ecorePackage.getEString(), "prefixOp", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameExpression_Path(), this.getQualifiedNamePath(), null, "path", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNameExpression_Id(), ecorePackage.getEString(), "id", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameExpression_InvocationCompletion(), this.getTuple(), null, "invocationCompletion", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameExpression_SequenceConstructionCompletion(), this.getSequenceConstructionOrAccessCompletion(), null, "sequenceConstructionCompletion", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNameExpression_PostfixOp(), ecorePackage.getEString(), "postfixOp", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedNamePathEClass, QualifiedNamePath.class, "QualifiedNamePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQualifiedNamePath_Namespace(), this.getUnqualifiedName(), null, "namespace", null, 0, -1, QualifiedNamePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unqualifiedNameEClass, UnqualifiedName.class, "UnqualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnqualifiedName_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnqualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnqualifiedName_TemplateBinding(), this.getTemplateBinding(), null, "templateBinding", null, 0, 1, UnqualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(templateBindingEClass, TemplateBinding.class, "TemplateBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTemplateBinding_Bindings(), this.getNamedTemplateBinding(), null, "bindings", null, 0, -1, TemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedTemplateBindingEClass, NamedTemplateBinding.class, "NamedTemplateBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedTemplateBinding_Formal(), ecorePackage.getEString(), "formal", null, 0, 1, NamedTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedTemplateBinding_Actual(), this.getQualifiedNameWithBinding(), null, "actual", null, 0, 1, NamedTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedNameWithBindingEClass, QualifiedNameWithBinding.class, "QualifiedNameWithBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedNameWithBinding_Id(), ecorePackage.getEString(), "id", null, 0, 1, QualifiedNameWithBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedNameWithBinding_Binding(), this.getTemplateBinding(), null, "binding", null, 0, 1, QualifiedNameWithBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedNameWithBinding_Remaining(), this.getQualifiedNameWithBinding(), null, "remaining", null, 0, 1, QualifiedNameWithBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleEClass, Tuple.class, "Tuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTuple_TupleElements(), this.getTupleElement(), null, "tupleElements", null, 0, -1, Tuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleElementEClass, TupleElement.class, "TupleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleElement_Argument(), this.getExpression(), null, "argument", null, 0, 1, TupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalTestExpressionEClass, ConditionalTestExpression.class, "ConditionalTestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalTestExpression_Exp(), this.getConditionalOrExpression(), null, "exp", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalTestExpression_WhenTrue(), this.getConditionalTestExpression(), null, "whenTrue", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalTestExpression_WhenFalse(), this.getConditionalTestExpression(), null, "whenFalse", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalOrExpressionEClass, ConditionalOrExpression.class, "ConditionalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalOrExpression_Exp(), this.getConditionalAndExpression(), null, "exp", null, 0, -1, ConditionalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalAndExpressionEClass, ConditionalAndExpression.class, "ConditionalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalAndExpression_Exp(), this.getInclusiveOrExpression(), null, "exp", null, 0, -1, ConditionalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inclusiveOrExpressionEClass, InclusiveOrExpression.class, "InclusiveOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInclusiveOrExpression_Exp(), this.getExclusiveOrExpression(), null, "exp", null, 0, -1, InclusiveOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exclusiveOrExpressionEClass, ExclusiveOrExpression.class, "ExclusiveOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExclusiveOrExpression_Exp(), this.getAndExpression(), null, "exp", null, 0, -1, ExclusiveOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Exp(), this.getEqualityExpression(), null, "exp", null, 0, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityExpression_Exp(), this.getClassificationExpression(), null, "exp", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityExpression_Op(), ecorePackage.getEString(), "op", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationExpressionEClass, ClassificationExpression.class, "ClassificationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationExpression_Exp(), this.getRelationalExpression(), null, "exp", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassificationExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationExpression_TypeName(), this.getNameExpression(), null, "typeName", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Left(), this.getShiftExpression(), null, "left", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_Right(), this.getShiftExpression(), null, "right", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExpressionEClass, ShiftExpression.class, "ShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpression_Exp(), this.getAdditiveExpression(), null, "exp", null, 0, -1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdditiveExpression_Exp(), this.getMultiplicativeExpression(), null, "exp", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdditiveExpression_Op(), ecorePackage.getEString(), "op", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicativeExpression_Exp(), this.getUnaryExpression(), null, "exp", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicativeExpression_Op(), ecorePackage.getEString(), "op", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpression_Exp(), this.getPrimaryExpression(), null, "exp", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primaryExpressionEClass, PrimaryExpression.class, "PrimaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrimaryExpression_Prefix(), this.getValueSpecification(), null, "prefix", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suffixExpressionEClass, SuffixExpression.class, "SuffixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(operationCallExpressionEClass, OperationCallExpression.class, "OperationCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperationCallExpression_OperationName(), ecorePackage.getEString(), "operationName", null, 0, 1, OperationCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationCallExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, OperationCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationCallExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, OperationCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyCallExpressionEClass, PropertyCallExpression.class, "PropertyCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyCallExpression_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, PropertyCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyCallExpression_Index(), this.getExpression(), null, "index", null, 0, 1, PropertyCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyCallExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, PropertyCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkOperationExpressionEClass, LinkOperationExpression.class, "LinkOperationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(createOrDestroyLinkOperationExpressionEClass, CreateOrDestroyLinkOperationExpression.class, "CreateOrDestroyLinkOperationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCreateOrDestroyLinkOperationExpression_Kind(), this.getLinkOperationKind(), "kind", null, 0, 1, CreateOrDestroyLinkOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCreateOrDestroyLinkOperationExpression_Tuple(), this.getLinkOperationTuple(), null, "tuple", null, 0, 1, CreateOrDestroyLinkOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(clearAssocExpressionEClass, ClearAssocExpression.class, "ClearAssocExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClearAssocExpression_End(), this.getExpression(), null, "end", null, 0, 1, ClearAssocExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkOperationTupleEClass, LinkOperationTuple.class, "LinkOperationTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLinkOperationTuple_LinkOperationTupleElement(), this.getLinkOperationTupleElement(), null, "linkOperationTupleElement", null, 0, -1, LinkOperationTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkOperationTupleElementEClass, LinkOperationTupleElement.class, "LinkOperationTupleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLinkOperationTupleElement_Role(), ecorePackage.getEString(), "role", null, 0, 1, LinkOperationTupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkOperationTupleElement_RoleIndex(), this.getExpression(), null, "roleIndex", null, 0, 1, LinkOperationTupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkOperationTupleElement_Object(), this.getExpression(), null, "object", null, 0, 1, LinkOperationTupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceOperationExpressionEClass, SequenceOperationExpression.class, "SequenceOperationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequenceOperationExpression_OperationName(), this.getQualifiedNameWithBinding(), null, "operationName", null, 0, 1, SequenceOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceOperationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, SequenceOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceOperationExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, SequenceOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceReductionExpressionEClass, SequenceReductionExpression.class, "SequenceReductionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceReductionExpression_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", null, 0, 1, SequenceReductionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceReductionExpression_Behavior(), this.getQualifiedNameWithBinding(), null, "behavior", null, 0, 1, SequenceReductionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceReductionExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, SequenceReductionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceExpansionExpressionEClass, SequenceExpansionExpression.class, "SequenceExpansionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceExpansionExpression_Name(), ecorePackage.getEString(), "name", null, 0, 1, SequenceExpansionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceExpansionExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, SequenceExpansionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceExpansionExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, SequenceExpansionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectOrRejectOperationEClass, SelectOrRejectOperation.class, "SelectOrRejectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSelectOrRejectOperation_Op(), this.getSelectOrRejectOperator(), "op", null, 0, 1, SelectOrRejectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectOrIterateOperationEClass, CollectOrIterateOperation.class, "CollectOrIterateOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCollectOrIterateOperation_Op(), this.getCollectOrIterateOperator(), "op", null, 0, 1, CollectOrIterateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forAllOrExistsOrOneOperationEClass, ForAllOrExistsOrOneOperation.class, "ForAllOrExistsOrOneOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForAllOrExistsOrOneOperation_Op(), this.getForAllOrExistsOrOneOperator(), "op", null, 0, 1, ForAllOrExistsOrOneOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isUniqueOperationEClass, IsUniqueOperation.class, "IsUniqueOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nonLiteralValueSpecificationEClass, NonLiteralValueSpecification.class, "NonLiteralValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParenthesizedExpression_ExpOrTypeCast(), this.getExpression(), null, "expOrTypeCast", null, 0, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParenthesizedExpression_Casted(), this.getNonLiteralValueSpecification(), null, "casted", null, 0, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParenthesizedExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullExpressionEClass, NullExpression.class, "NullExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(thisExpressionEClass, ThisExpression.class, "ThisExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThisExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, ThisExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(superInvocationExpressionEClass, SuperInvocationExpression.class, "SuperInvocationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuperInvocationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, SuperInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuperInvocationExpression_OperationName(), this.getQualifiedNameWithBinding(), null, "operationName", null, 0, 1, SuperInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceCreationExpressionEClass, InstanceCreationExpression.class, "InstanceCreationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceCreationExpression_Constructor(), this.getQualifiedNameWithBinding(), null, "constructor", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceCreationExpression_Tuple(), this.getInstanceCreationTuple(), null, "tuple", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceCreationExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceCreationExpression_SequenceConstuctionCompletion(), this.getSequenceConstructionCompletion(), null, "sequenceConstuctionCompletion", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceCreationTupleEClass, InstanceCreationTuple.class, "InstanceCreationTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceCreationTuple_InstanceCreationTupleElement(), this.getInstanceCreationTupleElement(), null, "instanceCreationTupleElement", null, 0, -1, InstanceCreationTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceCreationTupleElementEClass, InstanceCreationTupleElement.class, "InstanceCreationTupleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInstanceCreationTupleElement_Role(), ecorePackage.getEString(), "role", null, 0, 1, InstanceCreationTupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceCreationTupleElement_Object(), this.getExpression(), null, "object", null, 0, 1, InstanceCreationTupleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceConstructionOrAccessCompletionEClass, SequenceConstructionOrAccessCompletion.class, "SequenceConstructionOrAccessCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceConstructionOrAccessCompletion_MultiplicityIndicator(), ecorePackage.getEBoolean(), "multiplicityIndicator", null, 0, 1, SequenceConstructionOrAccessCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceConstructionOrAccessCompletion_AccessCompletion(), this.getAccessCompletion(), null, "accessCompletion", null, 0, 1, SequenceConstructionOrAccessCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceConstructionOrAccessCompletion_SequenceCompletion(), this.getPartialSequenceConstructionCompletion(), null, "sequenceCompletion", null, 0, 1, SequenceConstructionOrAccessCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceConstructionOrAccessCompletion_Expression(), this.getSequenceConstructionExpression(), null, "expression", null, 0, 1, SequenceConstructionOrAccessCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(accessCompletionEClass, AccessCompletion.class, "AccessCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAccessCompletion_AccessIndex(), this.getExpression(), null, "accessIndex", null, 0, 1, AccessCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partialSequenceConstructionCompletionEClass, PartialSequenceConstructionCompletion.class, "PartialSequenceConstructionCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartialSequenceConstructionCompletion_Expression(), this.getSequenceConstructionExpression(), null, "expression", null, 0, 1, PartialSequenceConstructionCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceConstructionCompletionEClass, SequenceConstructionCompletion.class, "SequenceConstructionCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceConstructionCompletion_MultiplicityIndicator(), ecorePackage.getEBoolean(), "multiplicityIndicator", null, 0, 1, SequenceConstructionCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceConstructionCompletion_Expression(), this.getSequenceConstructionExpression(), null, "expression", null, 0, 1, SequenceConstructionCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceConstructionExpressionEClass, SequenceConstructionExpression.class, "SequenceConstructionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequenceConstructionExpression_SequenceElement(), this.getSequenceElement(), null, "sequenceElement", null, 0, -1, SequenceConstructionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceConstructionExpression_RangeUpper(), this.getExpression(), null, "rangeUpper", null, 0, 1, SequenceConstructionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceElementEClass, SequenceElement.class, "SequenceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(classExtentExpressionEClass, ClassExtentExpression.class, "ClassExtentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassExtentExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, ClassExtentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Sequence(), this.getStatementSequence(), null, "sequence", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementSequenceEClass, StatementSequence.class, "StatementSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatementSequence_Statements(), this.getDocumentedStatement(), null, "statements", null, 0, -1, StatementSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentedStatementEClass, DocumentedStatement.class, "DocumentedStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentedStatement_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, DocumentedStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentedStatement_Statement(), this.getStatement(), null, "statement", null, 0, 1, DocumentedStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inlineStatementEClass, InlineStatement.class, "InlineStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInlineStatement_LangageName(), ecorePackage.getEString(), "langageName", null, 0, 1, InlineStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInlineStatement_Body(), ecorePackage.getEString(), "body", null, 0, 1, InlineStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(annotatedStatementEClass, AnnotatedStatement.class, "AnnotatedStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnnotatedStatement_Annotation(), this.getAnnotation(), null, "annotation", null, 0, 1, AnnotatedStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnnotatedStatement_Statement(), this.getStatement(), null, "statement", null, 0, 1, AnnotatedStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnnotation_Kind(), this.getAnnotationKind(), "kind", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAnnotation_Args(), ecorePackage.getEString(), "args", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlockStatement_Block(), this.getBlock(), null, "block", null, 0, 1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emptyStatementEClass, EmptyStatement.class, "EmptyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(localNameDeclarationStatementEClass, LocalNameDeclarationStatement.class, "LocalNameDeclarationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalNameDeclarationStatement_VarName(), ecorePackage.getEString(), "varName", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalNameDeclarationStatement_Type(), this.getQualifiedNameWithBinding(), null, "type", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLocalNameDeclarationStatement_MultiplicityIndicator(), ecorePackage.getEBoolean(), "multiplicityIndicator", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalNameDeclarationStatement_Init(), this.getSequenceElement(), null, "init", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfStatement_SequentialClausses(), this.getSequentialClauses(), null, "sequentialClausses", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_FinalClause(), this.getFinalClause(), null, "finalClause", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequentialClausesEClass, SequentialClauses.class, "SequentialClauses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequentialClauses_ConccurentClauses(), this.getConcurrentClauses(), null, "conccurentClauses", null, 0, -1, SequentialClauses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(concurrentClausesEClass, ConcurrentClauses.class, "ConcurrentClauses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConcurrentClauses_NonFinalClause(), this.getNonFinalClause(), null, "nonFinalClause", null, 0, -1, ConcurrentClauses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonFinalClauseEClass, NonFinalClause.class, "NonFinalClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonFinalClause_Condition(), this.getExpression(), null, "condition", null, 0, 1, NonFinalClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNonFinalClause_Block(), this.getBlock(), null, "block", null, 0, 1, NonFinalClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(finalClauseEClass, FinalClause.class, "FinalClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFinalClause_Block(), this.getBlock(), null, "block", null, 0, 1, FinalClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchStatement_SwitchClause(), this.getSwitchClause(), null, "switchClause", null, 0, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchStatement_DefaultClause(), this.getSwitchDefaultClause(), null, "defaultClause", null, 0, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchClauseEClass, SwitchClause.class, "SwitchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchClause_SwitchCase(), this.getSwitchCase(), null, "switchCase", null, 0, -1, SwitchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchClause_StatementSequence(), this.getNonEmptyStatementSequence(), null, "statementSequence", null, 0, 1, SwitchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchCaseEClass, SwitchCase.class, "SwitchCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchCase_Expression(), this.getExpression(), null, "expression", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchDefaultClauseEClass, SwitchDefaultClause.class, "SwitchDefaultClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchDefaultClause_StatementSequence(), this.getNonEmptyStatementSequence(), null, "statementSequence", null, 0, 1, SwitchDefaultClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonEmptyStatementSequenceEClass, NonEmptyStatementSequence.class, "NonEmptyStatementSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonEmptyStatementSequence_Statement(), this.getDocumentedStatement(), null, "statement", null, 0, -1, NonEmptyStatementSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStatement_Block(), this.getBlock(), null, "block", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doStatementEClass, DoStatement.class, "DoStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDoStatement_Block(), this.getBlock(), null, "block", null, 0, 1, DoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDoStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, DoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForStatement_Control(), this.getForControl(), null, "control", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Block(), this.getBlock(), null, "block", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forControlEClass, ForControl.class, "ForControl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForControl_LoopVariableDefinition(), this.getLoopVariableDefinition(), null, "loopVariableDefinition", null, 0, -1, ForControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopVariableDefinitionEClass, LoopVariableDefinition.class, "LoopVariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoopVariableDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, LoopVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoopVariableDefinition_Expression1(), this.getExpression(), null, "expression1", null, 0, 1, LoopVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoopVariableDefinition_Expression2(), this.getExpression(), null, "expression2", null, 0, 1, LoopVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoopVariableDefinition_Type(), this.getQualifiedNameWithBinding(), null, "type", null, 0, 1, LoopVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoopVariableDefinition_Expression(), this.getExpression(), null, "expression", null, 0, 1, LoopVariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReturnStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(acceptStatementEClass, AcceptStatement.class, "AcceptStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAcceptStatement_Clause(), this.getAcceptClause(), null, "clause", null, 0, 1, AcceptStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAcceptStatement_SimpleAccept(), this.getSimpleAcceptStatementCompletion(), null, "simpleAccept", null, 0, 1, AcceptStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAcceptStatement_CompoundAccept(), this.getCompoundAcceptStatementCompletion(), null, "compoundAccept", null, 0, 1, AcceptStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleAcceptStatementCompletionEClass, SimpleAcceptStatementCompletion.class, "SimpleAcceptStatementCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(compoundAcceptStatementCompletionEClass, CompoundAcceptStatementCompletion.class, "CompoundAcceptStatementCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompoundAcceptStatementCompletion_Block(), this.getBlock(), null, "block", null, 0, 1, CompoundAcceptStatementCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompoundAcceptStatementCompletion_AcceptBlock(), this.getAcceptBlock(), null, "acceptBlock", null, 0, -1, CompoundAcceptStatementCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(acceptBlockEClass, AcceptBlock.class, "AcceptBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAcceptBlock_Clause(), this.getAcceptClause(), null, "clause", null, 0, 1, AcceptBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAcceptBlock_Block(), this.getBlock(), null, "block", null, 0, 1, AcceptBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(acceptClauseEClass, AcceptClause.class, "AcceptClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAcceptClause_Name(), ecorePackage.getEString(), "name", null, 0, 1, AcceptClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAcceptClause_QualifiedNameList(), this.getQualifiedNameList(), null, "qualifiedNameList", null, 0, 1, AcceptClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifyStatementEClass, ClassifyStatement.class, "ClassifyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifyStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifyStatement_Clause(), this.getClassificationClause(), null, "clause", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationClauseEClass, ClassificationClause.class, "ClassificationClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationClause_ClassifyFromClause(), this.getClassificationFromClause(), null, "classifyFromClause", null, 0, 1, ClassificationClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationClause_ClassifyToClause(), this.getClassificationToClause(), null, "classifyToClause", null, 0, 1, ClassificationClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationClause_ReclassyAllClause(), this.getReclassifyAllClause(), null, "reclassyAllClause", null, 0, 1, ClassificationClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationFromClauseEClass, ClassificationFromClause.class, "ClassificationFromClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationFromClause_QualifiedNameList(), this.getQualifiedNameList(), null, "qualifiedNameList", null, 0, 1, ClassificationFromClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationToClauseEClass, ClassificationToClause.class, "ClassificationToClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationToClause_QualifiedNameList(), this.getQualifiedNameList(), null, "qualifiedNameList", null, 0, 1, ClassificationToClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reclassifyAllClauseEClass, ReclassifyAllClause.class, "ReclassifyAllClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qualifiedNameListEClass, QualifiedNameList.class, "QualifiedNameList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQualifiedNameList_QualifiedName(), this.getQualifiedNameWithBinding(), null, "qualifiedName", null, 0, -1, QualifiedNameList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invocationOrAssignementOrDeclarationStatementEClass, InvocationOrAssignementOrDeclarationStatement.class, "InvocationOrAssignementOrDeclarationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart(), this.getNameExpression(), null, "typePart_OR_assignedPart_OR_invocationPart", null, 0, 1, InvocationOrAssignementOrDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletion(), this.getVariableDeclarationCompletion(), null, "variableDeclarationCompletion", null, 0, 1, InvocationOrAssignementOrDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion(), this.getAssignmentCompletion(), null, "assignmentCompletion", null, 0, 1, InvocationOrAssignementOrDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(superInvocationStatementEClass, SuperInvocationStatement.class, "SuperInvocationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuperInvocationStatement__super(), this.getSuperInvocationExpression(), null, "_super", null, 0, 1, SuperInvocationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thisInvocationStatementEClass, ThisInvocationStatement.class, "ThisInvocationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThisInvocationStatement__this(), this.getThisExpression(), null, "_this", null, 0, 1, ThisInvocationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThisInvocationStatement_AssignmentCompletion(), this.getAssignmentCompletion(), null, "assignmentCompletion", null, 0, 1, ThisInvocationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceCreationInvocationStatementEClass, InstanceCreationInvocationStatement.class, "InstanceCreationInvocationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceCreationInvocationStatement__new(), this.getInstanceCreationExpression(), null, "_new", null, 0, 1, InstanceCreationInvocationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDeclarationCompletionEClass, VariableDeclarationCompletion.class, "VariableDeclarationCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDeclarationCompletion_MultiplicityIndicator(), ecorePackage.getEBoolean(), "multiplicityIndicator", null, 0, 1, VariableDeclarationCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableDeclarationCompletion_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, VariableDeclarationCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDeclarationCompletion_InitValue(), this.getAssignmentCompletion(), null, "initValue", null, 0, 1, VariableDeclarationCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentCompletionEClass, AssignmentCompletion.class, "AssignmentCompletion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignmentCompletion_Op(), this.getAssignmentOperator(), "op", null, 0, 1, AssignmentCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentCompletion_RightHandSide(), this.getSequenceElement(), null, "rightHandSide", null, 0, 1, AssignmentCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(booleanValueEEnum, BooleanValue.class, "BooleanValue");
    addEEnumLiteral(booleanValueEEnum, BooleanValue.TRUE);
    addEEnumLiteral(booleanValueEEnum, BooleanValue.FALSE);

    initEEnum(linkOperationKindEEnum, LinkOperationKind.class, "LinkOperationKind");
    addEEnumLiteral(linkOperationKindEEnum, LinkOperationKind.CREATE);
    addEEnumLiteral(linkOperationKindEEnum, LinkOperationKind.DESTROY);

    initEEnum(selectOrRejectOperatorEEnum, SelectOrRejectOperator.class, "SelectOrRejectOperator");
    addEEnumLiteral(selectOrRejectOperatorEEnum, SelectOrRejectOperator.SELECT);
    addEEnumLiteral(selectOrRejectOperatorEEnum, SelectOrRejectOperator.REJECT);

    initEEnum(collectOrIterateOperatorEEnum, CollectOrIterateOperator.class, "CollectOrIterateOperator");
    addEEnumLiteral(collectOrIterateOperatorEEnum, CollectOrIterateOperator.COLLECT);
    addEEnumLiteral(collectOrIterateOperatorEEnum, CollectOrIterateOperator.ITERATE);

    initEEnum(forAllOrExistsOrOneOperatorEEnum, ForAllOrExistsOrOneOperator.class, "ForAllOrExistsOrOneOperator");
    addEEnumLiteral(forAllOrExistsOrOneOperatorEEnum, ForAllOrExistsOrOneOperator.FORALL);
    addEEnumLiteral(forAllOrExistsOrOneOperatorEEnum, ForAllOrExistsOrOneOperator.EXISTS);
    addEEnumLiteral(forAllOrExistsOrOneOperatorEEnum, ForAllOrExistsOrOneOperator.ONE);

    initEEnum(annotationKindEEnum, AnnotationKind.class, "AnnotationKind");
    addEEnumLiteral(annotationKindEEnum, AnnotationKind.ISOLATED);
    addEEnumLiteral(annotationKindEEnum, AnnotationKind.DETERMINED);
    addEEnumLiteral(annotationKindEEnum, AnnotationKind.ASSURED);
    addEEnumLiteral(annotationKindEEnum, AnnotationKind.PARALLEL);

    initEEnum(assignmentOperatorEEnum, AssignmentOperator.class, "AssignmentOperator");
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.PLUSASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MINUSASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MULTASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MODASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DIVASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ANDASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ORASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.XORASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.LSHIFTASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.RSHIFTASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.URSHIFTASSIGN);

    // Create resource
    createResource(eNS_URI);
  }

} //AlfPackageImpl
