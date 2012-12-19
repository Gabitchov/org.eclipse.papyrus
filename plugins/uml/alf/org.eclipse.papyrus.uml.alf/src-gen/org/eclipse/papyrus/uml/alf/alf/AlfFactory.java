/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage
 * @generated
 */
public interface AlfFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlfFactory eINSTANCE = org.eclipse.papyrus.uml.alf.alf.impl.AlfFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test</em>'.
   * @generated
   */
  Test createTest();

  /**
   * Returns a new object of class '<em>LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LITERAL</em>'.
   * @generated
   */
  LITERAL createLITERAL();

  /**
   * Returns a new object of class '<em>BOOLEAN LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>BOOLEAN LITERAL</em>'.
   * @generated
   */
  BOOLEAN_LITERAL createBOOLEAN_LITERAL();

  /**
   * Returns a new object of class '<em>NUMBER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NUMBER LITERAL</em>'.
   * @generated
   */
  NUMBER_LITERAL createNUMBER_LITERAL();

  /**
   * Returns a new object of class '<em>INTEGER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>INTEGER LITERAL</em>'.
   * @generated
   */
  INTEGER_LITERAL createINTEGER_LITERAL();

  /**
   * Returns a new object of class '<em>UNLIMITED LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UNLIMITED LITERAL</em>'.
   * @generated
   */
  UNLIMITED_LITERAL createUNLIMITED_LITERAL();

  /**
   * Returns a new object of class '<em>STRING LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>STRING LITERAL</em>'.
   * @generated
   */
  STRING_LITERAL createSTRING_LITERAL();

  /**
   * Returns a new object of class '<em>Name Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Expression</em>'.
   * @generated
   */
  NameExpression createNameExpression();

  /**
   * Returns a new object of class '<em>Qualified Name Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name Path</em>'.
   * @generated
   */
  QualifiedNamePath createQualifiedNamePath();

  /**
   * Returns a new object of class '<em>Unqualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unqualified Name</em>'.
   * @generated
   */
  UnqualifiedName createUnqualifiedName();

  /**
   * Returns a new object of class '<em>Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template Binding</em>'.
   * @generated
   */
  TemplateBinding createTemplateBinding();

  /**
   * Returns a new object of class '<em>Named Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Template Binding</em>'.
   * @generated
   */
  NamedTemplateBinding createNamedTemplateBinding();

  /**
   * Returns a new object of class '<em>Qualified Name With Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name With Binding</em>'.
   * @generated
   */
  QualifiedNameWithBinding createQualifiedNameWithBinding();

  /**
   * Returns a new object of class '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple</em>'.
   * @generated
   */
  Tuple createTuple();

  /**
   * Returns a new object of class '<em>Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Element</em>'.
   * @generated
   */
  TupleElement createTupleElement();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Conditional Test Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Test Expression</em>'.
   * @generated
   */
  ConditionalTestExpression createConditionalTestExpression();

  /**
   * Returns a new object of class '<em>Conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Or Expression</em>'.
   * @generated
   */
  ConditionalOrExpression createConditionalOrExpression();

  /**
   * Returns a new object of class '<em>Conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional And Expression</em>'.
   * @generated
   */
  ConditionalAndExpression createConditionalAndExpression();

  /**
   * Returns a new object of class '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inclusive Or Expression</em>'.
   * @generated
   */
  InclusiveOrExpression createInclusiveOrExpression();

  /**
   * Returns a new object of class '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclusive Or Expression</em>'.
   * @generated
   */
  ExclusiveOrExpression createExclusiveOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Expression</em>'.
   * @generated
   */
  ClassificationExpression createClassificationExpression();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression</em>'.
   * @generated
   */
  ShiftExpression createShiftExpression();

  /**
   * Returns a new object of class '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression</em>'.
   * @generated
   */
  AdditiveExpression createAdditiveExpression();

  /**
   * Returns a new object of class '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression</em>'.
   * @generated
   */
  MultiplicativeExpression createMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Suffix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suffix Expression</em>'.
   * @generated
   */
  SuffixExpression createSuffixExpression();

  /**
   * Returns a new object of class '<em>Operation Call Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Call Expression</em>'.
   * @generated
   */
  OperationCallExpression createOperationCallExpression();

  /**
   * Returns a new object of class '<em>Property Call Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Call Expression</em>'.
   * @generated
   */
  PropertyCallExpression createPropertyCallExpression();

  /**
   * Returns a new object of class '<em>Link Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Expression</em>'.
   * @generated
   */
  LinkOperationExpression createLinkOperationExpression();

  /**
   * Returns a new object of class '<em>Create Or Destroy Link Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Create Or Destroy Link Operation Expression</em>'.
   * @generated
   */
  CreateOrDestroyLinkOperationExpression createCreateOrDestroyLinkOperationExpression();

  /**
   * Returns a new object of class '<em>Clear Assoc Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clear Assoc Expression</em>'.
   * @generated
   */
  ClearAssocExpression createClearAssocExpression();

  /**
   * Returns a new object of class '<em>Link Operation Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Tuple</em>'.
   * @generated
   */
  LinkOperationTuple createLinkOperationTuple();

  /**
   * Returns a new object of class '<em>Link Operation Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Tuple Element</em>'.
   * @generated
   */
  LinkOperationTupleElement createLinkOperationTupleElement();

  /**
   * Returns a new object of class '<em>Sequence Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Operation Expression</em>'.
   * @generated
   */
  SequenceOperationExpression createSequenceOperationExpression();

  /**
   * Returns a new object of class '<em>Sequence Reduction Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Reduction Expression</em>'.
   * @generated
   */
  SequenceReductionExpression createSequenceReductionExpression();

  /**
   * Returns a new object of class '<em>Sequence Expansion Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Expansion Expression</em>'.
   * @generated
   */
  SequenceExpansionExpression createSequenceExpansionExpression();

  /**
   * Returns a new object of class '<em>Select Or Reject Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Select Or Reject Operation</em>'.
   * @generated
   */
  SelectOrRejectOperation createSelectOrRejectOperation();

  /**
   * Returns a new object of class '<em>Collect Or Iterate Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collect Or Iterate Operation</em>'.
   * @generated
   */
  CollectOrIterateOperation createCollectOrIterateOperation();

  /**
   * Returns a new object of class '<em>For All Or Exists Or One Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For All Or Exists Or One Operation</em>'.
   * @generated
   */
  ForAllOrExistsOrOneOperation createForAllOrExistsOrOneOperation();

  /**
   * Returns a new object of class '<em>Is Unique Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is Unique Operation</em>'.
   * @generated
   */
  IsUniqueOperation createIsUniqueOperation();

  /**
   * Returns a new object of class '<em>Value Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Specification</em>'.
   * @generated
   */
  ValueSpecification createValueSpecification();

  /**
   * Returns a new object of class '<em>Non Literal Value Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Literal Value Specification</em>'.
   * @generated
   */
  NonLiteralValueSpecification createNonLiteralValueSpecification();

  /**
   * Returns a new object of class '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parenthesized Expression</em>'.
   * @generated
   */
  ParenthesizedExpression createParenthesizedExpression();

  /**
   * Returns a new object of class '<em>Null Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Expression</em>'.
   * @generated
   */
  NullExpression createNullExpression();

  /**
   * Returns a new object of class '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>This Expression</em>'.
   * @generated
   */
  ThisExpression createThisExpression();

  /**
   * Returns a new object of class '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Super Invocation Expression</em>'.
   * @generated
   */
  SuperInvocationExpression createSuperInvocationExpression();

  /**
   * Returns a new object of class '<em>Instance Creation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Expression</em>'.
   * @generated
   */
  InstanceCreationExpression createInstanceCreationExpression();

  /**
   * Returns a new object of class '<em>Instance Creation Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Tuple</em>'.
   * @generated
   */
  InstanceCreationTuple createInstanceCreationTuple();

  /**
   * Returns a new object of class '<em>Instance Creation Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Tuple Element</em>'.
   * @generated
   */
  InstanceCreationTupleElement createInstanceCreationTupleElement();

  /**
   * Returns a new object of class '<em>Sequence Construction Or Access Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Construction Or Access Completion</em>'.
   * @generated
   */
  SequenceConstructionOrAccessCompletion createSequenceConstructionOrAccessCompletion();

  /**
   * Returns a new object of class '<em>Access Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Access Completion</em>'.
   * @generated
   */
  AccessCompletion createAccessCompletion();

  /**
   * Returns a new object of class '<em>Partial Sequence Construction Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partial Sequence Construction Completion</em>'.
   * @generated
   */
  PartialSequenceConstructionCompletion createPartialSequenceConstructionCompletion();

  /**
   * Returns a new object of class '<em>Sequence Construction Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Construction Completion</em>'.
   * @generated
   */
  SequenceConstructionCompletion createSequenceConstructionCompletion();

  /**
   * Returns a new object of class '<em>Sequence Construction Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Construction Expression</em>'.
   * @generated
   */
  SequenceConstructionExpression createSequenceConstructionExpression();

  /**
   * Returns a new object of class '<em>Sequence Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Element</em>'.
   * @generated
   */
  SequenceElement createSequenceElement();

  /**
   * Returns a new object of class '<em>Class Extent Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Extent Expression</em>'.
   * @generated
   */
  ClassExtentExpression createClassExtentExpression();

  /**
   * Returns a new object of class '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block</em>'.
   * @generated
   */
  Block createBlock();

  /**
   * Returns a new object of class '<em>Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement Sequence</em>'.
   * @generated
   */
  StatementSequence createStatementSequence();

  /**
   * Returns a new object of class '<em>Documented Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Documented Statement</em>'.
   * @generated
   */
  DocumentedStatement createDocumentedStatement();

  /**
   * Returns a new object of class '<em>Inline Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline Statement</em>'.
   * @generated
   */
  InlineStatement createInlineStatement();

  /**
   * Returns a new object of class '<em>Annotated Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotated Statement</em>'.
   * @generated
   */
  AnnotatedStatement createAnnotatedStatement();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Statement</em>'.
   * @generated
   */
  BlockStatement createBlockStatement();

  /**
   * Returns a new object of class '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Empty Statement</em>'.
   * @generated
   */
  EmptyStatement createEmptyStatement();

  /**
   * Returns a new object of class '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Name Declaration Statement</em>'.
   * @generated
   */
  LocalNameDeclarationStatement createLocalNameDeclarationStatement();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Sequential Clauses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequential Clauses</em>'.
   * @generated
   */
  SequentialClauses createSequentialClauses();

  /**
   * Returns a new object of class '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concurrent Clauses</em>'.
   * @generated
   */
  ConcurrentClauses createConcurrentClauses();

  /**
   * Returns a new object of class '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Final Clause</em>'.
   * @generated
   */
  NonFinalClause createNonFinalClause();

  /**
   * Returns a new object of class '<em>Final Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Final Clause</em>'.
   * @generated
   */
  FinalClause createFinalClause();

  /**
   * Returns a new object of class '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Statement</em>'.
   * @generated
   */
  SwitchStatement createSwitchStatement();

  /**
   * Returns a new object of class '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Clause</em>'.
   * @generated
   */
  SwitchClause createSwitchClause();

  /**
   * Returns a new object of class '<em>Switch Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Case</em>'.
   * @generated
   */
  SwitchCase createSwitchCase();

  /**
   * Returns a new object of class '<em>Switch Default Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Default Clause</em>'.
   * @generated
   */
  SwitchDefaultClause createSwitchDefaultClause();

  /**
   * Returns a new object of class '<em>Non Empty Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Empty Statement Sequence</em>'.
   * @generated
   */
  NonEmptyStatementSequence createNonEmptyStatementSequence();

  /**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
  WhileStatement createWhileStatement();

  /**
   * Returns a new object of class '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Do Statement</em>'.
   * @generated
   */
  DoStatement createDoStatement();

  /**
   * Returns a new object of class '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Statement</em>'.
   * @generated
   */
  ForStatement createForStatement();

  /**
   * Returns a new object of class '<em>For Control</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Control</em>'.
   * @generated
   */
  ForControl createForControl();

  /**
   * Returns a new object of class '<em>Loop Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop Variable Definition</em>'.
   * @generated
   */
  LoopVariableDefinition createLoopVariableDefinition();

  /**
   * Returns a new object of class '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Break Statement</em>'.
   * @generated
   */
  BreakStatement createBreakStatement();

  /**
   * Returns a new object of class '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Return Statement</em>'.
   * @generated
   */
  ReturnStatement createReturnStatement();

  /**
   * Returns a new object of class '<em>Accept Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Statement</em>'.
   * @generated
   */
  AcceptStatement createAcceptStatement();

  /**
   * Returns a new object of class '<em>Simple Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Accept Statement Completion</em>'.
   * @generated
   */
  SimpleAcceptStatementCompletion createSimpleAcceptStatementCompletion();

  /**
   * Returns a new object of class '<em>Compound Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Accept Statement Completion</em>'.
   * @generated
   */
  CompoundAcceptStatementCompletion createCompoundAcceptStatementCompletion();

  /**
   * Returns a new object of class '<em>Accept Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Block</em>'.
   * @generated
   */
  AcceptBlock createAcceptBlock();

  /**
   * Returns a new object of class '<em>Accept Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Clause</em>'.
   * @generated
   */
  AcceptClause createAcceptClause();

  /**
   * Returns a new object of class '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classify Statement</em>'.
   * @generated
   */
  ClassifyStatement createClassifyStatement();

  /**
   * Returns a new object of class '<em>Classification Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Clause</em>'.
   * @generated
   */
  ClassificationClause createClassificationClause();

  /**
   * Returns a new object of class '<em>Classification From Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification From Clause</em>'.
   * @generated
   */
  ClassificationFromClause createClassificationFromClause();

  /**
   * Returns a new object of class '<em>Classification To Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification To Clause</em>'.
   * @generated
   */
  ClassificationToClause createClassificationToClause();

  /**
   * Returns a new object of class '<em>Reclassify All Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reclassify All Clause</em>'.
   * @generated
   */
  ReclassifyAllClause createReclassifyAllClause();

  /**
   * Returns a new object of class '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name List</em>'.
   * @generated
   */
  QualifiedNameList createQualifiedNameList();

  /**
   * Returns a new object of class '<em>Invocation Or Assignement Or Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invocation Or Assignement Or Declaration Statement</em>'.
   * @generated
   */
  InvocationOrAssignementOrDeclarationStatement createInvocationOrAssignementOrDeclarationStatement();

  /**
   * Returns a new object of class '<em>Super Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Super Invocation Statement</em>'.
   * @generated
   */
  SuperInvocationStatement createSuperInvocationStatement();

  /**
   * Returns a new object of class '<em>This Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>This Invocation Statement</em>'.
   * @generated
   */
  ThisInvocationStatement createThisInvocationStatement();

  /**
   * Returns a new object of class '<em>Instance Creation Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Invocation Statement</em>'.
   * @generated
   */
  InstanceCreationInvocationStatement createInstanceCreationInvocationStatement();

  /**
   * Returns a new object of class '<em>Variable Declaration Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration Completion</em>'.
   * @generated
   */
  VariableDeclarationCompletion createVariableDeclarationCompletion();

  /**
   * Returns a new object of class '<em>Assignment Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Completion</em>'.
   * @generated
   */
  AssignmentCompletion createAssignmentCompletion();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AlfPackage getAlfPackage();

} //AlfFactory
