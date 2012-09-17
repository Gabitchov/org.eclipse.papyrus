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
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfFactoryImpl extends EFactoryImpl implements AlfFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AlfFactory init()
  {
    try
    {
      AlfFactory theAlfFactory = (AlfFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/alf/Alf"); 
      if (theAlfFactory != null)
      {
        return theAlfFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AlfFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AlfPackage.TEST: return createTest();
      case AlfPackage.LITERAL: return createLITERAL();
      case AlfPackage.BOOLEAN_LITERAL: return createBOOLEAN_LITERAL();
      case AlfPackage.NUMBER_LITERAL: return createNUMBER_LITERAL();
      case AlfPackage.INTEGER_LITERAL: return createINTEGER_LITERAL();
      case AlfPackage.UNLIMITED_LITERAL: return createUNLIMITED_LITERAL();
      case AlfPackage.STRING_LITERAL: return createSTRING_LITERAL();
      case AlfPackage.NAME_EXPRESSION: return createNameExpression();
      case AlfPackage.QUALIFIED_NAME_PATH: return createQualifiedNamePath();
      case AlfPackage.UNQUALIFIED_NAME: return createUnqualifiedName();
      case AlfPackage.TEMPLATE_BINDING: return createTemplateBinding();
      case AlfPackage.NAMED_TEMPLATE_BINDING: return createNamedTemplateBinding();
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING: return createQualifiedNameWithBinding();
      case AlfPackage.TUPLE: return createTuple();
      case AlfPackage.TUPLE_ELEMENT: return createTupleElement();
      case AlfPackage.EXPRESSION: return createExpression();
      case AlfPackage.CONDITIONAL_TEST_EXPRESSION: return createConditionalTestExpression();
      case AlfPackage.CONDITIONAL_OR_EXPRESSION: return createConditionalOrExpression();
      case AlfPackage.CONDITIONAL_AND_EXPRESSION: return createConditionalAndExpression();
      case AlfPackage.INCLUSIVE_OR_EXPRESSION: return createInclusiveOrExpression();
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION: return createExclusiveOrExpression();
      case AlfPackage.AND_EXPRESSION: return createAndExpression();
      case AlfPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case AlfPackage.CLASSIFICATION_EXPRESSION: return createClassificationExpression();
      case AlfPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case AlfPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case AlfPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case AlfPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case AlfPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case AlfPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case AlfPackage.SUFFIX_EXPRESSION: return createSuffixExpression();
      case AlfPackage.OPERATION_CALL_EXPRESSION: return createOperationCallExpression();
      case AlfPackage.PROPERTY_CALL_EXPRESSION: return createPropertyCallExpression();
      case AlfPackage.LINK_OPERATION_EXPRESSION: return createLinkOperationExpression();
      case AlfPackage.LINK_OPERATION_TUPLE: return createLinkOperationTuple();
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT: return createLinkOperationTupleElement();
      case AlfPackage.SEQUENCE_OPERATION_EXPRESSION: return createSequenceOperationExpression();
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION: return createSequenceReductionExpression();
      case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION: return createSequenceExpansionExpression();
      case AlfPackage.SELECT_OR_REJECT_OPERATION: return createSelectOrRejectOperation();
      case AlfPackage.COLLECT_OR_ITERATE_OPERATION: return createCollectOrIterateOperation();
      case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_OPERATION: return createForAllOrExistsOrOneOperation();
      case AlfPackage.IS_UNIQUE_OPERATION: return createIsUniqueOperation();
      case AlfPackage.VALUE_SPECIFICATION: return createValueSpecification();
      case AlfPackage.NON_LITERAL_VALUE_SPECIFICATION: return createNonLiteralValueSpecification();
      case AlfPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
      case AlfPackage.NULL_EXPRESSION: return createNullExpression();
      case AlfPackage.THIS_EXPRESSION: return createThisExpression();
      case AlfPackage.SUPER_INVOCATION_EXPRESSION: return createSuperInvocationExpression();
      case AlfPackage.INSTANCE_CREATION_EXPRESSION: return createInstanceCreationExpression();
      case AlfPackage.INSTANCE_CREATION_TUPLE: return createInstanceCreationTuple();
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT: return createInstanceCreationTupleElement();
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION: return createSequenceConstructionOrAccessCompletion();
      case AlfPackage.ACCESS_COMPLETION: return createAccessCompletion();
      case AlfPackage.PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION: return createPartialSequenceConstructionCompletion();
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION: return createSequenceConstructionExpression();
      case AlfPackage.SEQUENCE_ELEMENT: return createSequenceElement();
      case AlfPackage.CLASS_EXTENT_EXPRESSION: return createClassExtentExpression();
      case AlfPackage.BLOCK: return createBlock();
      case AlfPackage.STATEMENT_SEQUENCE: return createStatementSequence();
      case AlfPackage.DOCUMENTED_STATEMENT: return createDocumentedStatement();
      case AlfPackage.INLINE_STATEMENT: return createInlineStatement();
      case AlfPackage.ANNOTATED_STATEMENT: return createAnnotatedStatement();
      case AlfPackage.STATEMENT: return createStatement();
      case AlfPackage.ANNOTATION: return createAnnotation();
      case AlfPackage.BLOCK_STATEMENT: return createBlockStatement();
      case AlfPackage.EMPTY_STATEMENT: return createEmptyStatement();
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT: return createLocalNameDeclarationStatement();
      case AlfPackage.IF_STATEMENT: return createIfStatement();
      case AlfPackage.SEQUENTIAL_CLAUSES: return createSequentialClauses();
      case AlfPackage.CONCURRENT_CLAUSES: return createConcurrentClauses();
      case AlfPackage.NON_FINAL_CLAUSE: return createNonFinalClause();
      case AlfPackage.FINAL_CLAUSE: return createFinalClause();
      case AlfPackage.SWITCH_STATEMENT: return createSwitchStatement();
      case AlfPackage.SWITCH_CLAUSE: return createSwitchClause();
      case AlfPackage.SWITCH_CASE: return createSwitchCase();
      case AlfPackage.SWITCH_DEFAULT_CLAUSE: return createSwitchDefaultClause();
      case AlfPackage.NON_EMPTY_STATEMENT_SEQUENCE: return createNonEmptyStatementSequence();
      case AlfPackage.WHILE_STATEMENT: return createWhileStatement();
      case AlfPackage.DO_STATEMENT: return createDoStatement();
      case AlfPackage.FOR_STATEMENT: return createForStatement();
      case AlfPackage.FOR_CONTROL: return createForControl();
      case AlfPackage.LOOP_VARIABLE_DEFINITION: return createLoopVariableDefinition();
      case AlfPackage.BREAK_STATEMENT: return createBreakStatement();
      case AlfPackage.RETURN_STATEMENT: return createReturnStatement();
      case AlfPackage.ACCEPT_STATEMENT: return createAcceptStatement();
      case AlfPackage.SIMPLE_ACCEPT_STATEMENT_COMPLETION: return createSimpleAcceptStatementCompletion();
      case AlfPackage.COMPOUND_ACCEPT_STATEMENT_COMPLETION: return createCompoundAcceptStatementCompletion();
      case AlfPackage.ACCEPT_BLOCK: return createAcceptBlock();
      case AlfPackage.ACCEPT_CLAUSE: return createAcceptClause();
      case AlfPackage.CLASSIFY_STATEMENT: return createClassifyStatement();
      case AlfPackage.CLASSIFICATION_CLAUSE: return createClassificationClause();
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE: return createClassificationFromClause();
      case AlfPackage.CLASSIFICATION_TO_CLAUSE: return createClassificationToClause();
      case AlfPackage.RECLASSIFY_ALL_CLAUSE: return createReclassifyAllClause();
      case AlfPackage.QUALIFIED_NAME_LIST: return createQualifiedNameList();
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT: return createInvocationOrAssignementOrDeclarationStatement();
      case AlfPackage.SUPER_INVOCATION_STATEMENT: return createSuperInvocationStatement();
      case AlfPackage.THIS_INVOCATION_STATEMENT: return createThisInvocationStatement();
      case AlfPackage.INSTANCE_CREATION_INVOCATION_STATEMENT: return createInstanceCreationInvocationStatement();
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION: return createVariableDeclarationCompletion();
      case AlfPackage.ASSIGNMENT_COMPLETION: return createAssignmentCompletion();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AlfPackage.BOOLEAN_VALUE:
        return createBooleanValueFromString(eDataType, initialValue);
      case AlfPackage.LINK_OPERATION_KIND:
        return createLinkOperationKindFromString(eDataType, initialValue);
      case AlfPackage.SELECT_OR_REJECT_OPERATOR:
        return createSelectOrRejectOperatorFromString(eDataType, initialValue);
      case AlfPackage.COLLECT_OR_ITERATE_OPERATOR:
        return createCollectOrIterateOperatorFromString(eDataType, initialValue);
      case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_OPERATOR:
        return createForAllOrExistsOrOneOperatorFromString(eDataType, initialValue);
      case AlfPackage.ANNOTATION_KIND:
        return createAnnotationKindFromString(eDataType, initialValue);
      case AlfPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AlfPackage.BOOLEAN_VALUE:
        return convertBooleanValueToString(eDataType, instanceValue);
      case AlfPackage.LINK_OPERATION_KIND:
        return convertLinkOperationKindToString(eDataType, instanceValue);
      case AlfPackage.SELECT_OR_REJECT_OPERATOR:
        return convertSelectOrRejectOperatorToString(eDataType, instanceValue);
      case AlfPackage.COLLECT_OR_ITERATE_OPERATOR:
        return convertCollectOrIterateOperatorToString(eDataType, instanceValue);
      case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_OPERATOR:
        return convertForAllOrExistsOrOneOperatorToString(eDataType, instanceValue);
      case AlfPackage.ANNOTATION_KIND:
        return convertAnnotationKindToString(eDataType, instanceValue);
      case AlfPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Test createTest()
  {
    TestImpl test = new TestImpl();
    return test;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LITERAL createLITERAL()
  {
    LITERALImpl literal = new LITERALImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BOOLEAN_LITERAL createBOOLEAN_LITERAL()
  {
    BOOLEAN_LITERALImpl booleaN_LITERAL = new BOOLEAN_LITERALImpl();
    return booleaN_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NUMBER_LITERAL createNUMBER_LITERAL()
  {
    NUMBER_LITERALImpl numbeR_LITERAL = new NUMBER_LITERALImpl();
    return numbeR_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTEGER_LITERAL createINTEGER_LITERAL()
  {
    INTEGER_LITERALImpl integeR_LITERAL = new INTEGER_LITERALImpl();
    return integeR_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UNLIMITED_LITERAL createUNLIMITED_LITERAL()
  {
    UNLIMITED_LITERALImpl unlimiteD_LITERAL = new UNLIMITED_LITERALImpl();
    return unlimiteD_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STRING_LITERAL createSTRING_LITERAL()
  {
    STRING_LITERALImpl strinG_LITERAL = new STRING_LITERALImpl();
    return strinG_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExpression createNameExpression()
  {
    NameExpressionImpl nameExpression = new NameExpressionImpl();
    return nameExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNamePath createQualifiedNamePath()
  {
    QualifiedNamePathImpl qualifiedNamePath = new QualifiedNamePathImpl();
    return qualifiedNamePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnqualifiedName createUnqualifiedName()
  {
    UnqualifiedNameImpl unqualifiedName = new UnqualifiedNameImpl();
    return unqualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBinding createTemplateBinding()
  {
    TemplateBindingImpl templateBinding = new TemplateBindingImpl();
    return templateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTemplateBinding createNamedTemplateBinding()
  {
    NamedTemplateBindingImpl namedTemplateBinding = new NamedTemplateBindingImpl();
    return namedTemplateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithBinding createQualifiedNameWithBinding()
  {
    QualifiedNameWithBindingImpl qualifiedNameWithBinding = new QualifiedNameWithBindingImpl();
    return qualifiedNameWithBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple createTuple()
  {
    TupleImpl tuple = new TupleImpl();
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleElement createTupleElement()
  {
    TupleElementImpl tupleElement = new TupleElementImpl();
    return tupleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalTestExpression createConditionalTestExpression()
  {
    ConditionalTestExpressionImpl conditionalTestExpression = new ConditionalTestExpressionImpl();
    return conditionalTestExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalOrExpression createConditionalOrExpression()
  {
    ConditionalOrExpressionImpl conditionalOrExpression = new ConditionalOrExpressionImpl();
    return conditionalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpression createConditionalAndExpression()
  {
    ConditionalAndExpressionImpl conditionalAndExpression = new ConditionalAndExpressionImpl();
    return conditionalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpression createInclusiveOrExpression()
  {
    InclusiveOrExpressionImpl inclusiveOrExpression = new InclusiveOrExpressionImpl();
    return inclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExclusiveOrExpression createExclusiveOrExpression()
  {
    ExclusiveOrExpressionImpl exclusiveOrExpression = new ExclusiveOrExpressionImpl();
    return exclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationExpression createClassificationExpression()
  {
    ClassificationExpressionImpl classificationExpression = new ClassificationExpressionImpl();
    return classificationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuffixExpression createSuffixExpression()
  {
    SuffixExpressionImpl suffixExpression = new SuffixExpressionImpl();
    return suffixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCallExpression createOperationCallExpression()
  {
    OperationCallExpressionImpl operationCallExpression = new OperationCallExpressionImpl();
    return operationCallExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyCallExpression createPropertyCallExpression()
  {
    PropertyCallExpressionImpl propertyCallExpression = new PropertyCallExpressionImpl();
    return propertyCallExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationExpression createLinkOperationExpression()
  {
    LinkOperationExpressionImpl linkOperationExpression = new LinkOperationExpressionImpl();
    return linkOperationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationTuple createLinkOperationTuple()
  {
    LinkOperationTupleImpl linkOperationTuple = new LinkOperationTupleImpl();
    return linkOperationTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationTupleElement createLinkOperationTupleElement()
  {
    LinkOperationTupleElementImpl linkOperationTupleElement = new LinkOperationTupleElementImpl();
    return linkOperationTupleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceOperationExpression createSequenceOperationExpression()
  {
    SequenceOperationExpressionImpl sequenceOperationExpression = new SequenceOperationExpressionImpl();
    return sequenceOperationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceReductionExpression createSequenceReductionExpression()
  {
    SequenceReductionExpressionImpl sequenceReductionExpression = new SequenceReductionExpressionImpl();
    return sequenceReductionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceExpansionExpression createSequenceExpansionExpression()
  {
    SequenceExpansionExpressionImpl sequenceExpansionExpression = new SequenceExpansionExpressionImpl();
    return sequenceExpansionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectOrRejectOperation createSelectOrRejectOperation()
  {
    SelectOrRejectOperationImpl selectOrRejectOperation = new SelectOrRejectOperationImpl();
    return selectOrRejectOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectOrIterateOperation createCollectOrIterateOperation()
  {
    CollectOrIterateOperationImpl collectOrIterateOperation = new CollectOrIterateOperationImpl();
    return collectOrIterateOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForAllOrExistsOrOneOperation createForAllOrExistsOrOneOperation()
  {
    ForAllOrExistsOrOneOperationImpl forAllOrExistsOrOneOperation = new ForAllOrExistsOrOneOperationImpl();
    return forAllOrExistsOrOneOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsUniqueOperation createIsUniqueOperation()
  {
    IsUniqueOperationImpl isUniqueOperation = new IsUniqueOperationImpl();
    return isUniqueOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueSpecification createValueSpecification()
  {
    ValueSpecificationImpl valueSpecification = new ValueSpecificationImpl();
    return valueSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonLiteralValueSpecification createNonLiteralValueSpecification()
  {
    NonLiteralValueSpecificationImpl nonLiteralValueSpecification = new NonLiteralValueSpecificationImpl();
    return nonLiteralValueSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParenthesizedExpression createParenthesizedExpression()
  {
    ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
    return parenthesizedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullExpression createNullExpression()
  {
    NullExpressionImpl nullExpression = new NullExpressionImpl();
    return nullExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThisExpression createThisExpression()
  {
    ThisExpressionImpl thisExpression = new ThisExpressionImpl();
    return thisExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperInvocationExpression createSuperInvocationExpression()
  {
    SuperInvocationExpressionImpl superInvocationExpression = new SuperInvocationExpressionImpl();
    return superInvocationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationExpression createInstanceCreationExpression()
  {
    InstanceCreationExpressionImpl instanceCreationExpression = new InstanceCreationExpressionImpl();
    return instanceCreationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationTuple createInstanceCreationTuple()
  {
    InstanceCreationTupleImpl instanceCreationTuple = new InstanceCreationTupleImpl();
    return instanceCreationTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationTupleElement createInstanceCreationTupleElement()
  {
    InstanceCreationTupleElementImpl instanceCreationTupleElement = new InstanceCreationTupleElementImpl();
    return instanceCreationTupleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionOrAccessCompletion createSequenceConstructionOrAccessCompletion()
  {
    SequenceConstructionOrAccessCompletionImpl sequenceConstructionOrAccessCompletion = new SequenceConstructionOrAccessCompletionImpl();
    return sequenceConstructionOrAccessCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccessCompletion createAccessCompletion()
  {
    AccessCompletionImpl accessCompletion = new AccessCompletionImpl();
    return accessCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialSequenceConstructionCompletion createPartialSequenceConstructionCompletion()
  {
    PartialSequenceConstructionCompletionImpl partialSequenceConstructionCompletion = new PartialSequenceConstructionCompletionImpl();
    return partialSequenceConstructionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionExpression createSequenceConstructionExpression()
  {
    SequenceConstructionExpressionImpl sequenceConstructionExpression = new SequenceConstructionExpressionImpl();
    return sequenceConstructionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElement createSequenceElement()
  {
    SequenceElementImpl sequenceElement = new SequenceElementImpl();
    return sequenceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExtentExpression createClassExtentExpression()
  {
    ClassExtentExpressionImpl classExtentExpression = new ClassExtentExpressionImpl();
    return classExtentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementSequence createStatementSequence()
  {
    StatementSequenceImpl statementSequence = new StatementSequenceImpl();
    return statementSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentedStatement createDocumentedStatement()
  {
    DocumentedStatementImpl documentedStatement = new DocumentedStatementImpl();
    return documentedStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineStatement createInlineStatement()
  {
    InlineStatementImpl inlineStatement = new InlineStatementImpl();
    return inlineStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotatedStatement createAnnotatedStatement()
  {
    AnnotatedStatementImpl annotatedStatement = new AnnotatedStatementImpl();
    return annotatedStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockStatement createBlockStatement()
  {
    BlockStatementImpl blockStatement = new BlockStatementImpl();
    return blockStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyStatement createEmptyStatement()
  {
    EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
    return emptyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatement createLocalNameDeclarationStatement()
  {
    LocalNameDeclarationStatementImpl localNameDeclarationStatement = new LocalNameDeclarationStatementImpl();
    return localNameDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequentialClauses createSequentialClauses()
  {
    SequentialClausesImpl sequentialClauses = new SequentialClausesImpl();
    return sequentialClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcurrentClauses createConcurrentClauses()
  {
    ConcurrentClausesImpl concurrentClauses = new ConcurrentClausesImpl();
    return concurrentClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonFinalClause createNonFinalClause()
  {
    NonFinalClauseImpl nonFinalClause = new NonFinalClauseImpl();
    return nonFinalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinalClause createFinalClause()
  {
    FinalClauseImpl finalClause = new FinalClauseImpl();
    return finalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchStatement createSwitchStatement()
  {
    SwitchStatementImpl switchStatement = new SwitchStatementImpl();
    return switchStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchClause createSwitchClause()
  {
    SwitchClauseImpl switchClause = new SwitchClauseImpl();
    return switchClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchCase createSwitchCase()
  {
    SwitchCaseImpl switchCase = new SwitchCaseImpl();
    return switchCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchDefaultClause createSwitchDefaultClause()
  {
    SwitchDefaultClauseImpl switchDefaultClause = new SwitchDefaultClauseImpl();
    return switchDefaultClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonEmptyStatementSequence createNonEmptyStatementSequence()
  {
    NonEmptyStatementSequenceImpl nonEmptyStatementSequence = new NonEmptyStatementSequenceImpl();
    return nonEmptyStatementSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoStatement createDoStatement()
  {
    DoStatementImpl doStatement = new DoStatementImpl();
    return doStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForControl createForControl()
  {
    ForControlImpl forControl = new ForControlImpl();
    return forControl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopVariableDefinition createLoopVariableDefinition()
  {
    LoopVariableDefinitionImpl loopVariableDefinition = new LoopVariableDefinitionImpl();
    return loopVariableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakStatement createBreakStatement()
  {
    BreakStatementImpl breakStatement = new BreakStatementImpl();
    return breakStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptStatement createAcceptStatement()
  {
    AcceptStatementImpl acceptStatement = new AcceptStatementImpl();
    return acceptStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAcceptStatementCompletion createSimpleAcceptStatementCompletion()
  {
    SimpleAcceptStatementCompletionImpl simpleAcceptStatementCompletion = new SimpleAcceptStatementCompletionImpl();
    return simpleAcceptStatementCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundAcceptStatementCompletion createCompoundAcceptStatementCompletion()
  {
    CompoundAcceptStatementCompletionImpl compoundAcceptStatementCompletion = new CompoundAcceptStatementCompletionImpl();
    return compoundAcceptStatementCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptBlock createAcceptBlock()
  {
    AcceptBlockImpl acceptBlock = new AcceptBlockImpl();
    return acceptBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptClause createAcceptClause()
  {
    AcceptClauseImpl acceptClause = new AcceptClauseImpl();
    return acceptClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifyStatement createClassifyStatement()
  {
    ClassifyStatementImpl classifyStatement = new ClassifyStatementImpl();
    return classifyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationClause createClassificationClause()
  {
    ClassificationClauseImpl classificationClause = new ClassificationClauseImpl();
    return classificationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationFromClause createClassificationFromClause()
  {
    ClassificationFromClauseImpl classificationFromClause = new ClassificationFromClauseImpl();
    return classificationFromClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationToClause createClassificationToClause()
  {
    ClassificationToClauseImpl classificationToClause = new ClassificationToClauseImpl();
    return classificationToClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReclassifyAllClause createReclassifyAllClause()
  {
    ReclassifyAllClauseImpl reclassifyAllClause = new ReclassifyAllClauseImpl();
    return reclassifyAllClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList createQualifiedNameList()
  {
    QualifiedNameListImpl qualifiedNameList = new QualifiedNameListImpl();
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationOrAssignementOrDeclarationStatement createInvocationOrAssignementOrDeclarationStatement()
  {
    InvocationOrAssignementOrDeclarationStatementImpl invocationOrAssignementOrDeclarationStatement = new InvocationOrAssignementOrDeclarationStatementImpl();
    return invocationOrAssignementOrDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperInvocationStatement createSuperInvocationStatement()
  {
    SuperInvocationStatementImpl superInvocationStatement = new SuperInvocationStatementImpl();
    return superInvocationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThisInvocationStatement createThisInvocationStatement()
  {
    ThisInvocationStatementImpl thisInvocationStatement = new ThisInvocationStatementImpl();
    return thisInvocationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationInvocationStatement createInstanceCreationInvocationStatement()
  {
    InstanceCreationInvocationStatementImpl instanceCreationInvocationStatement = new InstanceCreationInvocationStatementImpl();
    return instanceCreationInvocationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclarationCompletion createVariableDeclarationCompletion()
  {
    VariableDeclarationCompletionImpl variableDeclarationCompletion = new VariableDeclarationCompletionImpl();
    return variableDeclarationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentCompletion createAssignmentCompletion()
  {
    AssignmentCompletionImpl assignmentCompletion = new AssignmentCompletionImpl();
    return assignmentCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanValue createBooleanValueFromString(EDataType eDataType, String initialValue)
  {
    BooleanValue result = BooleanValue.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanValueToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationKind createLinkOperationKindFromString(EDataType eDataType, String initialValue)
  {
    LinkOperationKind result = LinkOperationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLinkOperationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectOrRejectOperator createSelectOrRejectOperatorFromString(EDataType eDataType, String initialValue)
  {
    SelectOrRejectOperator result = SelectOrRejectOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSelectOrRejectOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectOrIterateOperator createCollectOrIterateOperatorFromString(EDataType eDataType, String initialValue)
  {
    CollectOrIterateOperator result = CollectOrIterateOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCollectOrIterateOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForAllOrExistsOrOneOperator createForAllOrExistsOrOneOperatorFromString(EDataType eDataType, String initialValue)
  {
    ForAllOrExistsOrOneOperator result = ForAllOrExistsOrOneOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertForAllOrExistsOrOneOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationKind createAnnotationKindFromString(EDataType eDataType, String initialValue)
  {
    AnnotationKind result = AnnotationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAnnotationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfPackage getAlfPackage()
  {
    return (AlfPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlfPackage getPackage()
  {
    return AlfPackage.eINSTANCE;
  }

} //AlfFactoryImpl
