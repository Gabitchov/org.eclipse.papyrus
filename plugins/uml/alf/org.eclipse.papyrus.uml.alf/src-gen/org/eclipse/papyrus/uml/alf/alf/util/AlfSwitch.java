/**
 */
package org.eclipse.papyrus.uml.alf.alf.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.uml.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage
 * @generated
 */
public class AlfSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlfPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AlfPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AlfPackage.TEST:
      {
        Test test = (Test)theEObject;
        T result = caseTest(test);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LITERAL:
      {
        LITERAL literal = (LITERAL)theEObject;
        T result = caseLITERAL(literal);
        if (result == null) result = caseValueSpecification(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BOOLEAN_LITERAL:
      {
        BOOLEAN_LITERAL booleaN_LITERAL = (BOOLEAN_LITERAL)theEObject;
        T result = caseBOOLEAN_LITERAL(booleaN_LITERAL);
        if (result == null) result = caseLITERAL(booleaN_LITERAL);
        if (result == null) result = caseValueSpecification(booleaN_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NUMBER_LITERAL:
      {
        NUMBER_LITERAL numbeR_LITERAL = (NUMBER_LITERAL)theEObject;
        T result = caseNUMBER_LITERAL(numbeR_LITERAL);
        if (result == null) result = caseLITERAL(numbeR_LITERAL);
        if (result == null) result = caseValueSpecification(numbeR_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INTEGER_LITERAL:
      {
        INTEGER_LITERAL integeR_LITERAL = (INTEGER_LITERAL)theEObject;
        T result = caseINTEGER_LITERAL(integeR_LITERAL);
        if (result == null) result = caseNUMBER_LITERAL(integeR_LITERAL);
        if (result == null) result = caseLITERAL(integeR_LITERAL);
        if (result == null) result = caseValueSpecification(integeR_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNLIMITED_LITERAL:
      {
        UNLIMITED_LITERAL unlimiteD_LITERAL = (UNLIMITED_LITERAL)theEObject;
        T result = caseUNLIMITED_LITERAL(unlimiteD_LITERAL);
        if (result == null) result = caseNUMBER_LITERAL(unlimiteD_LITERAL);
        if (result == null) result = caseLITERAL(unlimiteD_LITERAL);
        if (result == null) result = caseValueSpecification(unlimiteD_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STRING_LITERAL:
      {
        STRING_LITERAL strinG_LITERAL = (STRING_LITERAL)theEObject;
        T result = caseSTRING_LITERAL(strinG_LITERAL);
        if (result == null) result = caseLITERAL(strinG_LITERAL);
        if (result == null) result = caseValueSpecification(strinG_LITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAME_EXPRESSION:
      {
        NameExpression nameExpression = (NameExpression)theEObject;
        T result = caseNameExpression(nameExpression);
        if (result == null) result = caseValueSpecification(nameExpression);
        if (result == null) result = caseNonLiteralValueSpecification(nameExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME_PATH:
      {
        QualifiedNamePath qualifiedNamePath = (QualifiedNamePath)theEObject;
        T result = caseQualifiedNamePath(qualifiedNamePath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNQUALIFIED_NAME:
      {
        UnqualifiedName unqualifiedName = (UnqualifiedName)theEObject;
        T result = caseUnqualifiedName(unqualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TEMPLATE_BINDING:
      {
        TemplateBinding templateBinding = (TemplateBinding)theEObject;
        T result = caseTemplateBinding(templateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NAMED_TEMPLATE_BINDING:
      {
        NamedTemplateBinding namedTemplateBinding = (NamedTemplateBinding)theEObject;
        T result = caseNamedTemplateBinding(namedTemplateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME_WITH_BINDING:
      {
        QualifiedNameWithBinding qualifiedNameWithBinding = (QualifiedNameWithBinding)theEObject;
        T result = caseQualifiedNameWithBinding(qualifiedNameWithBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TUPLE:
      {
        Tuple tuple = (Tuple)theEObject;
        T result = caseTuple(tuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.TUPLE_ELEMENT:
      {
        TupleElement tupleElement = (TupleElement)theEObject;
        T result = caseTupleElement(tupleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseSequenceElement(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_TEST_EXPRESSION:
      {
        ConditionalTestExpression conditionalTestExpression = (ConditionalTestExpression)theEObject;
        T result = caseConditionalTestExpression(conditionalTestExpression);
        if (result == null) result = caseExpression(conditionalTestExpression);
        if (result == null) result = caseSequenceElement(conditionalTestExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_OR_EXPRESSION:
      {
        ConditionalOrExpression conditionalOrExpression = (ConditionalOrExpression)theEObject;
        T result = caseConditionalOrExpression(conditionalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONDITIONAL_AND_EXPRESSION:
      {
        ConditionalAndExpression conditionalAndExpression = (ConditionalAndExpression)theEObject;
        T result = caseConditionalAndExpression(conditionalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INCLUSIVE_OR_EXPRESSION:
      {
        InclusiveOrExpression inclusiveOrExpression = (InclusiveOrExpression)theEObject;
        T result = caseInclusiveOrExpression(inclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EXCLUSIVE_OR_EXPRESSION:
      {
        ExclusiveOrExpression exclusiveOrExpression = (ExclusiveOrExpression)theEObject;
        T result = caseExclusiveOrExpression(exclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EQUALITY_EXPRESSION:
      {
        EqualityExpression equalityExpression = (EqualityExpression)theEObject;
        T result = caseEqualityExpression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_EXPRESSION:
      {
        ClassificationExpression classificationExpression = (ClassificationExpression)theEObject;
        T result = caseClassificationExpression(classificationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SHIFT_EXPRESSION:
      {
        ShiftExpression shiftExpression = (ShiftExpression)theEObject;
        T result = caseShiftExpression(shiftExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ADDITIVE_EXPRESSION:
      {
        AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
        T result = caseAdditiveExpression(additiveExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.MULTIPLICATIVE_EXPRESSION:
      {
        MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
        T result = caseMultiplicativeExpression(multiplicativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.UNARY_EXPRESSION:
      {
        UnaryExpression unaryExpression = (UnaryExpression)theEObject;
        T result = caseUnaryExpression(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PRIMARY_EXPRESSION:
      {
        PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
        T result = casePrimaryExpression(primaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SUFFIX_EXPRESSION:
      {
        SuffixExpression suffixExpression = (SuffixExpression)theEObject;
        T result = caseSuffixExpression(suffixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.OPERATION_CALL_EXPRESSION:
      {
        OperationCallExpression operationCallExpression = (OperationCallExpression)theEObject;
        T result = caseOperationCallExpression(operationCallExpression);
        if (result == null) result = caseSuffixExpression(operationCallExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PROPERTY_CALL_EXPRESSION:
      {
        PropertyCallExpression propertyCallExpression = (PropertyCallExpression)theEObject;
        T result = casePropertyCallExpression(propertyCallExpression);
        if (result == null) result = caseSuffixExpression(propertyCallExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LINK_OPERATION_EXPRESSION:
      {
        LinkOperationExpression linkOperationExpression = (LinkOperationExpression)theEObject;
        T result = caseLinkOperationExpression(linkOperationExpression);
        if (result == null) result = caseSuffixExpression(linkOperationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LINK_OPERATION_TUPLE:
      {
        LinkOperationTuple linkOperationTuple = (LinkOperationTuple)theEObject;
        T result = caseLinkOperationTuple(linkOperationTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LINK_OPERATION_TUPLE_ELEMENT:
      {
        LinkOperationTupleElement linkOperationTupleElement = (LinkOperationTupleElement)theEObject;
        T result = caseLinkOperationTupleElement(linkOperationTupleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_OPERATION_EXPRESSION:
      {
        SequenceOperationExpression sequenceOperationExpression = (SequenceOperationExpression)theEObject;
        T result = caseSequenceOperationExpression(sequenceOperationExpression);
        if (result == null) result = caseSuffixExpression(sequenceOperationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION:
      {
        SequenceReductionExpression sequenceReductionExpression = (SequenceReductionExpression)theEObject;
        T result = caseSequenceReductionExpression(sequenceReductionExpression);
        if (result == null) result = caseSuffixExpression(sequenceReductionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION:
      {
        SequenceExpansionExpression sequenceExpansionExpression = (SequenceExpansionExpression)theEObject;
        T result = caseSequenceExpansionExpression(sequenceExpansionExpression);
        if (result == null) result = caseSuffixExpression(sequenceExpansionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SELECT_OR_REJECT_OPERATION:
      {
        SelectOrRejectOperation selectOrRejectOperation = (SelectOrRejectOperation)theEObject;
        T result = caseSelectOrRejectOperation(selectOrRejectOperation);
        if (result == null) result = caseSequenceExpansionExpression(selectOrRejectOperation);
        if (result == null) result = caseSuffixExpression(selectOrRejectOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COLLECT_OR_ITERATE_OPERATION:
      {
        CollectOrIterateOperation collectOrIterateOperation = (CollectOrIterateOperation)theEObject;
        T result = caseCollectOrIterateOperation(collectOrIterateOperation);
        if (result == null) result = caseSequenceExpansionExpression(collectOrIterateOperation);
        if (result == null) result = caseSuffixExpression(collectOrIterateOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_OPERATION:
      {
        ForAllOrExistsOrOneOperation forAllOrExistsOrOneOperation = (ForAllOrExistsOrOneOperation)theEObject;
        T result = caseForAllOrExistsOrOneOperation(forAllOrExistsOrOneOperation);
        if (result == null) result = caseSequenceExpansionExpression(forAllOrExistsOrOneOperation);
        if (result == null) result = caseSuffixExpression(forAllOrExistsOrOneOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IS_UNIQUE_OPERATION:
      {
        IsUniqueOperation isUniqueOperation = (IsUniqueOperation)theEObject;
        T result = caseIsUniqueOperation(isUniqueOperation);
        if (result == null) result = caseSequenceExpansionExpression(isUniqueOperation);
        if (result == null) result = caseSuffixExpression(isUniqueOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.VALUE_SPECIFICATION:
      {
        ValueSpecification valueSpecification = (ValueSpecification)theEObject;
        T result = caseValueSpecification(valueSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_LITERAL_VALUE_SPECIFICATION:
      {
        NonLiteralValueSpecification nonLiteralValueSpecification = (NonLiteralValueSpecification)theEObject;
        T result = caseNonLiteralValueSpecification(nonLiteralValueSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PARENTHESIZED_EXPRESSION:
      {
        ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
        T result = caseParenthesizedExpression(parenthesizedExpression);
        if (result == null) result = caseValueSpecification(parenthesizedExpression);
        if (result == null) result = caseNonLiteralValueSpecification(parenthesizedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NULL_EXPRESSION:
      {
        NullExpression nullExpression = (NullExpression)theEObject;
        T result = caseNullExpression(nullExpression);
        if (result == null) result = caseValueSpecification(nullExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.THIS_EXPRESSION:
      {
        ThisExpression thisExpression = (ThisExpression)theEObject;
        T result = caseThisExpression(thisExpression);
        if (result == null) result = caseValueSpecification(thisExpression);
        if (result == null) result = caseNonLiteralValueSpecification(thisExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SUPER_INVOCATION_EXPRESSION:
      {
        SuperInvocationExpression superInvocationExpression = (SuperInvocationExpression)theEObject;
        T result = caseSuperInvocationExpression(superInvocationExpression);
        if (result == null) result = caseValueSpecification(superInvocationExpression);
        if (result == null) result = caseNonLiteralValueSpecification(superInvocationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_CREATION_EXPRESSION:
      {
        InstanceCreationExpression instanceCreationExpression = (InstanceCreationExpression)theEObject;
        T result = caseInstanceCreationExpression(instanceCreationExpression);
        if (result == null) result = caseValueSpecification(instanceCreationExpression);
        if (result == null) result = caseNonLiteralValueSpecification(instanceCreationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_CREATION_TUPLE:
      {
        InstanceCreationTuple instanceCreationTuple = (InstanceCreationTuple)theEObject;
        T result = caseInstanceCreationTuple(instanceCreationTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_CREATION_TUPLE_ELEMENT:
      {
        InstanceCreationTupleElement instanceCreationTupleElement = (InstanceCreationTupleElement)theEObject;
        T result = caseInstanceCreationTupleElement(instanceCreationTupleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_CONSTRUCTION_OR_ACCESS_COMPLETION:
      {
        SequenceConstructionOrAccessCompletion sequenceConstructionOrAccessCompletion = (SequenceConstructionOrAccessCompletion)theEObject;
        T result = caseSequenceConstructionOrAccessCompletion(sequenceConstructionOrAccessCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCESS_COMPLETION:
      {
        AccessCompletion accessCompletion = (AccessCompletion)theEObject;
        T result = caseAccessCompletion(accessCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.PARTIAL_SEQUENCE_CONSTRUCTION_COMPLETION:
      {
        PartialSequenceConstructionCompletion partialSequenceConstructionCompletion = (PartialSequenceConstructionCompletion)theEObject;
        T result = casePartialSequenceConstructionCompletion(partialSequenceConstructionCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION:
      {
        SequenceConstructionExpression sequenceConstructionExpression = (SequenceConstructionExpression)theEObject;
        T result = caseSequenceConstructionExpression(sequenceConstructionExpression);
        if (result == null) result = caseSequenceElement(sequenceConstructionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENCE_ELEMENT:
      {
        SequenceElement sequenceElement = (SequenceElement)theEObject;
        T result = caseSequenceElement(sequenceElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASS_EXTENT_EXPRESSION:
      {
        ClassExtentExpression classExtentExpression = (ClassExtentExpression)theEObject;
        T result = caseClassExtentExpression(classExtentExpression);
        if (result == null) result = caseSuffixExpression(classExtentExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STATEMENT_SEQUENCE:
      {
        StatementSequence statementSequence = (StatementSequence)theEObject;
        T result = caseStatementSequence(statementSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DOCUMENTED_STATEMENT:
      {
        DocumentedStatement documentedStatement = (DocumentedStatement)theEObject;
        T result = caseDocumentedStatement(documentedStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INLINE_STATEMENT:
      {
        InlineStatement inlineStatement = (InlineStatement)theEObject;
        T result = caseInlineStatement(inlineStatement);
        if (result == null) result = caseStatement(inlineStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ANNOTATED_STATEMENT:
      {
        AnnotatedStatement annotatedStatement = (AnnotatedStatement)theEObject;
        T result = caseAnnotatedStatement(annotatedStatement);
        if (result == null) result = caseStatement(annotatedStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ANNOTATION:
      {
        Annotation annotation = (Annotation)theEObject;
        T result = caseAnnotation(annotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BLOCK_STATEMENT:
      {
        BlockStatement blockStatement = (BlockStatement)theEObject;
        T result = caseBlockStatement(blockStatement);
        if (result == null) result = caseStatement(blockStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.EMPTY_STATEMENT:
      {
        EmptyStatement emptyStatement = (EmptyStatement)theEObject;
        T result = caseEmptyStatement(emptyStatement);
        if (result == null) result = caseStatement(emptyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT:
      {
        LocalNameDeclarationStatement localNameDeclarationStatement = (LocalNameDeclarationStatement)theEObject;
        T result = caseLocalNameDeclarationStatement(localNameDeclarationStatement);
        if (result == null) result = caseStatement(localNameDeclarationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseStatement(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SEQUENTIAL_CLAUSES:
      {
        SequentialClauses sequentialClauses = (SequentialClauses)theEObject;
        T result = caseSequentialClauses(sequentialClauses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CONCURRENT_CLAUSES:
      {
        ConcurrentClauses concurrentClauses = (ConcurrentClauses)theEObject;
        T result = caseConcurrentClauses(concurrentClauses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_FINAL_CLAUSE:
      {
        NonFinalClause nonFinalClause = (NonFinalClause)theEObject;
        T result = caseNonFinalClause(nonFinalClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FINAL_CLAUSE:
      {
        FinalClause finalClause = (FinalClause)theEObject;
        T result = caseFinalClause(finalClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_STATEMENT:
      {
        SwitchStatement switchStatement = (SwitchStatement)theEObject;
        T result = caseSwitchStatement(switchStatement);
        if (result == null) result = caseStatement(switchStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_CLAUSE:
      {
        SwitchClause switchClause = (SwitchClause)theEObject;
        T result = caseSwitchClause(switchClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_CASE:
      {
        SwitchCase switchCase = (SwitchCase)theEObject;
        T result = caseSwitchCase(switchCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SWITCH_DEFAULT_CLAUSE:
      {
        SwitchDefaultClause switchDefaultClause = (SwitchDefaultClause)theEObject;
        T result = caseSwitchDefaultClause(switchDefaultClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.NON_EMPTY_STATEMENT_SEQUENCE:
      {
        NonEmptyStatementSequence nonEmptyStatementSequence = (NonEmptyStatementSequence)theEObject;
        T result = caseNonEmptyStatementSequence(nonEmptyStatementSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseStatement(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.DO_STATEMENT:
      {
        DoStatement doStatement = (DoStatement)theEObject;
        T result = caseDoStatement(doStatement);
        if (result == null) result = caseStatement(doStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FOR_STATEMENT:
      {
        ForStatement forStatement = (ForStatement)theEObject;
        T result = caseForStatement(forStatement);
        if (result == null) result = caseStatement(forStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.FOR_CONTROL:
      {
        ForControl forControl = (ForControl)theEObject;
        T result = caseForControl(forControl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.LOOP_VARIABLE_DEFINITION:
      {
        LoopVariableDefinition loopVariableDefinition = (LoopVariableDefinition)theEObject;
        T result = caseLoopVariableDefinition(loopVariableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.BREAK_STATEMENT:
      {
        BreakStatement breakStatement = (BreakStatement)theEObject;
        T result = caseBreakStatement(breakStatement);
        if (result == null) result = caseStatement(breakStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RETURN_STATEMENT:
      {
        ReturnStatement returnStatement = (ReturnStatement)theEObject;
        T result = caseReturnStatement(returnStatement);
        if (result == null) result = caseStatement(returnStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_STATEMENT:
      {
        AcceptStatement acceptStatement = (AcceptStatement)theEObject;
        T result = caseAcceptStatement(acceptStatement);
        if (result == null) result = caseStatement(acceptStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SIMPLE_ACCEPT_STATEMENT_COMPLETION:
      {
        SimpleAcceptStatementCompletion simpleAcceptStatementCompletion = (SimpleAcceptStatementCompletion)theEObject;
        T result = caseSimpleAcceptStatementCompletion(simpleAcceptStatementCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.COMPOUND_ACCEPT_STATEMENT_COMPLETION:
      {
        CompoundAcceptStatementCompletion compoundAcceptStatementCompletion = (CompoundAcceptStatementCompletion)theEObject;
        T result = caseCompoundAcceptStatementCompletion(compoundAcceptStatementCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_BLOCK:
      {
        AcceptBlock acceptBlock = (AcceptBlock)theEObject;
        T result = caseAcceptBlock(acceptBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ACCEPT_CLAUSE:
      {
        AcceptClause acceptClause = (AcceptClause)theEObject;
        T result = caseAcceptClause(acceptClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFY_STATEMENT:
      {
        ClassifyStatement classifyStatement = (ClassifyStatement)theEObject;
        T result = caseClassifyStatement(classifyStatement);
        if (result == null) result = caseStatement(classifyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_CLAUSE:
      {
        ClassificationClause classificationClause = (ClassificationClause)theEObject;
        T result = caseClassificationClause(classificationClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_FROM_CLAUSE:
      {
        ClassificationFromClause classificationFromClause = (ClassificationFromClause)theEObject;
        T result = caseClassificationFromClause(classificationFromClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.CLASSIFICATION_TO_CLAUSE:
      {
        ClassificationToClause classificationToClause = (ClassificationToClause)theEObject;
        T result = caseClassificationToClause(classificationToClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.RECLASSIFY_ALL_CLAUSE:
      {
        ReclassifyAllClause reclassifyAllClause = (ReclassifyAllClause)theEObject;
        T result = caseReclassifyAllClause(reclassifyAllClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.QUALIFIED_NAME_LIST:
      {
        QualifiedNameList qualifiedNameList = (QualifiedNameList)theEObject;
        T result = caseQualifiedNameList(qualifiedNameList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INVOCATION_OR_ASSIGNEMENT_OR_DECLARATION_STATEMENT:
      {
        InvocationOrAssignementOrDeclarationStatement invocationOrAssignementOrDeclarationStatement = (InvocationOrAssignementOrDeclarationStatement)theEObject;
        T result = caseInvocationOrAssignementOrDeclarationStatement(invocationOrAssignementOrDeclarationStatement);
        if (result == null) result = caseStatement(invocationOrAssignementOrDeclarationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.SUPER_INVOCATION_STATEMENT:
      {
        SuperInvocationStatement superInvocationStatement = (SuperInvocationStatement)theEObject;
        T result = caseSuperInvocationStatement(superInvocationStatement);
        if (result == null) result = caseStatement(superInvocationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.THIS_INVOCATION_STATEMENT:
      {
        ThisInvocationStatement thisInvocationStatement = (ThisInvocationStatement)theEObject;
        T result = caseThisInvocationStatement(thisInvocationStatement);
        if (result == null) result = caseStatement(thisInvocationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.INSTANCE_CREATION_INVOCATION_STATEMENT:
      {
        InstanceCreationInvocationStatement instanceCreationInvocationStatement = (InstanceCreationInvocationStatement)theEObject;
        T result = caseInstanceCreationInvocationStatement(instanceCreationInvocationStatement);
        if (result == null) result = caseStatement(instanceCreationInvocationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION:
      {
        VariableDeclarationCompletion variableDeclarationCompletion = (VariableDeclarationCompletion)theEObject;
        T result = caseVariableDeclarationCompletion(variableDeclarationCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlfPackage.ASSIGNMENT_COMPLETION:
      {
        AssignmentCompletion assignmentCompletion = (AssignmentCompletion)theEObject;
        T result = caseAssignmentCompletion(assignmentCompletion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTest(Test object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLITERAL(LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BOOLEAN LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BOOLEAN LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBOOLEAN_LITERAL(BOOLEAN_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NUMBER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NUMBER LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNUMBER_LITERAL(NUMBER_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INTEGER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INTEGER LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINTEGER_LITERAL(INTEGER_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UNLIMITED LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UNLIMITED LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUNLIMITED_LITERAL(UNLIMITED_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>STRING LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>STRING LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTRING_LITERAL(STRING_LITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameExpression(NameExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNamePath(QualifiedNamePath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unqualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unqualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnqualifiedName(UnqualifiedName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplateBinding(TemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedTemplateBinding(NamedTemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name With Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name With Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNameWithBinding(QualifiedNameWithBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTuple(Tuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleElement(TupleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalTestExpression(ConditionalTestExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalOrExpression(ConditionalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalAndExpression(ConditionalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclusiveOrExpression(InclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExclusiveOrExpression(ExclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityExpression(EqualityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationExpression(ClassificationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpression(ShiftExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdditiveExpression(AdditiveExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicativeExpression(MultiplicativeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpression(UnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpression(PrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suffix Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suffix Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuffixExpression(SuffixExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Call Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Call Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationCallExpression(OperationCallExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Call Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Call Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyCallExpression(PropertyCallExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationExpression(LinkOperationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationTuple(LinkOperationTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Tuple Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationTupleElement(LinkOperationTupleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Operation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceOperationExpression(SequenceOperationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Reduction Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Reduction Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceReductionExpression(SequenceReductionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Expansion Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Expansion Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceExpansionExpression(SequenceExpansionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select Or Reject Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select Or Reject Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectOrRejectOperation(SelectOrRejectOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collect Or Iterate Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collect Or Iterate Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectOrIterateOperation(CollectOrIterateOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For All Or Exists Or One Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For All Or Exists Or One Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForAllOrExistsOrOneOperation(ForAllOrExistsOrOneOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Is Unique Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Is Unique Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIsUniqueOperation(IsUniqueOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueSpecification(ValueSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Literal Value Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Literal Value Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonLiteralValueSpecification(NonLiteralValueSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParenthesizedExpression(ParenthesizedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullExpression(NullExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThisExpression(ThisExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuperInvocationExpression(SuperInvocationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationExpression(InstanceCreationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationTuple(InstanceCreationTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Tuple Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Tuple Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationTupleElement(InstanceCreationTupleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Construction Or Access Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Construction Or Access Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceConstructionOrAccessCompletion(SequenceConstructionOrAccessCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Access Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Access Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAccessCompletion(AccessCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partial Sequence Construction Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partial Sequence Construction Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartialSequenceConstructionCompletion(PartialSequenceConstructionCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Construction Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Construction Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceConstructionExpression(SequenceConstructionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceElement(SequenceElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassExtentExpression(ClassExtentExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementSequence(StatementSequence object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Documented Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Documented Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentedStatement(DocumentedStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inline Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inline Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInlineStatement(InlineStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotatedStatement(AnnotatedStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotation(Annotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockStatement(BlockStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyStatement(EmptyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfStatement(IfStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequential Clauses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequential Clauses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequentialClauses(SequentialClauses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcurrentClauses(ConcurrentClauses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonFinalClause(NonFinalClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Final Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Final Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFinalClause(FinalClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchStatement(SwitchStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchClause(SwitchClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchCase(SwitchCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Default Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Default Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchDefaultClause(SwitchDefaultClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Empty Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Empty Statement Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonEmptyStatementSequence(NonEmptyStatementSequence object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoStatement(DoStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForStatement(ForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Control</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Control</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForControl(ForControl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopVariableDefinition(LoopVariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBreakStatement(BreakStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReturnStatement(ReturnStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptStatement(AcceptStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Accept Statement Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleAcceptStatementCompletion(SimpleAcceptStatementCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Accept Statement Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundAcceptStatementCompletion(CompoundAcceptStatementCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptBlock(AcceptBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accept Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accept Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAcceptClause(AcceptClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifyStatement(ClassifyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationClause(ClassificationClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification From Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification From Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationFromClause(ClassificationFromClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification To Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification To Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationToClause(ClassificationToClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reclassify All Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reclassify All Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReclassifyAllClause(ReclassifyAllClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNameList(QualifiedNameList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Or Assignement Or Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Or Assignement Or Declaration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocationOrAssignementOrDeclarationStatement(InvocationOrAssignementOrDeclarationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Super Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Super Invocation Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuperInvocationStatement(SuperInvocationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This Invocation Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThisInvocationStatement(ThisInvocationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Invocation Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Invocation Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationInvocationStatement(InstanceCreationInvocationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclarationCompletion(VariableDeclarationCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Completion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Completion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentCompletion(AssignmentCompletion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AlfSwitch
