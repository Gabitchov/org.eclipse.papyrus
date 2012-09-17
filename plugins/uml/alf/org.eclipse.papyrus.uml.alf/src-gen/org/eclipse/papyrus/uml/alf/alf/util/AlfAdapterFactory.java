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
package org.eclipse.papyrus.uml.alf.alf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage
 * @generated
 */
public class AlfAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlfPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlfAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AlfPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlfSwitch<Adapter> modelSwitch =
    new AlfSwitch<Adapter>()
    {
      @Override
      public Adapter caseTest(Test object)
      {
        return createTestAdapter();
      }
      @Override
      public Adapter caseLITERAL(LITERAL object)
      {
        return createLITERALAdapter();
      }
      @Override
      public Adapter caseBOOLEAN_LITERAL(BOOLEAN_LITERAL object)
      {
        return createBOOLEAN_LITERALAdapter();
      }
      @Override
      public Adapter caseNUMBER_LITERAL(NUMBER_LITERAL object)
      {
        return createNUMBER_LITERALAdapter();
      }
      @Override
      public Adapter caseINTEGER_LITERAL(INTEGER_LITERAL object)
      {
        return createINTEGER_LITERALAdapter();
      }
      @Override
      public Adapter caseUNLIMITED_LITERAL(UNLIMITED_LITERAL object)
      {
        return createUNLIMITED_LITERALAdapter();
      }
      @Override
      public Adapter caseSTRING_LITERAL(STRING_LITERAL object)
      {
        return createSTRING_LITERALAdapter();
      }
      @Override
      public Adapter caseNameExpression(NameExpression object)
      {
        return createNameExpressionAdapter();
      }
      @Override
      public Adapter caseQualifiedNamePath(QualifiedNamePath object)
      {
        return createQualifiedNamePathAdapter();
      }
      @Override
      public Adapter caseUnqualifiedName(UnqualifiedName object)
      {
        return createUnqualifiedNameAdapter();
      }
      @Override
      public Adapter caseTemplateBinding(TemplateBinding object)
      {
        return createTemplateBindingAdapter();
      }
      @Override
      public Adapter caseNamedTemplateBinding(NamedTemplateBinding object)
      {
        return createNamedTemplateBindingAdapter();
      }
      @Override
      public Adapter caseQualifiedNameWithBinding(QualifiedNameWithBinding object)
      {
        return createQualifiedNameWithBindingAdapter();
      }
      @Override
      public Adapter caseTuple(Tuple object)
      {
        return createTupleAdapter();
      }
      @Override
      public Adapter caseTupleElement(TupleElement object)
      {
        return createTupleElementAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalTestExpression(ConditionalTestExpression object)
      {
        return createConditionalTestExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalOrExpression(ConditionalOrExpression object)
      {
        return createConditionalOrExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalAndExpression(ConditionalAndExpression object)
      {
        return createConditionalAndExpressionAdapter();
      }
      @Override
      public Adapter caseInclusiveOrExpression(InclusiveOrExpression object)
      {
        return createInclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseExclusiveOrExpression(ExclusiveOrExpression object)
      {
        return createExclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseClassificationExpression(ClassificationExpression object)
      {
        return createClassificationExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseSuffixExpression(SuffixExpression object)
      {
        return createSuffixExpressionAdapter();
      }
      @Override
      public Adapter caseOperationCallExpression(OperationCallExpression object)
      {
        return createOperationCallExpressionAdapter();
      }
      @Override
      public Adapter casePropertyCallExpression(PropertyCallExpression object)
      {
        return createPropertyCallExpressionAdapter();
      }
      @Override
      public Adapter caseLinkOperationExpression(LinkOperationExpression object)
      {
        return createLinkOperationExpressionAdapter();
      }
      @Override
      public Adapter caseLinkOperationTuple(LinkOperationTuple object)
      {
        return createLinkOperationTupleAdapter();
      }
      @Override
      public Adapter caseLinkOperationTupleElement(LinkOperationTupleElement object)
      {
        return createLinkOperationTupleElementAdapter();
      }
      @Override
      public Adapter caseSequenceOperationExpression(SequenceOperationExpression object)
      {
        return createSequenceOperationExpressionAdapter();
      }
      @Override
      public Adapter caseSequenceReductionExpression(SequenceReductionExpression object)
      {
        return createSequenceReductionExpressionAdapter();
      }
      @Override
      public Adapter caseSequenceExpansionExpression(SequenceExpansionExpression object)
      {
        return createSequenceExpansionExpressionAdapter();
      }
      @Override
      public Adapter caseSelectOrRejectOperation(SelectOrRejectOperation object)
      {
        return createSelectOrRejectOperationAdapter();
      }
      @Override
      public Adapter caseCollectOrIterateOperation(CollectOrIterateOperation object)
      {
        return createCollectOrIterateOperationAdapter();
      }
      @Override
      public Adapter caseForAllOrExistsOrOneOperation(ForAllOrExistsOrOneOperation object)
      {
        return createForAllOrExistsOrOneOperationAdapter();
      }
      @Override
      public Adapter caseIsUniqueOperation(IsUniqueOperation object)
      {
        return createIsUniqueOperationAdapter();
      }
      @Override
      public Adapter caseValueSpecification(ValueSpecification object)
      {
        return createValueSpecificationAdapter();
      }
      @Override
      public Adapter caseNonLiteralValueSpecification(NonLiteralValueSpecification object)
      {
        return createNonLiteralValueSpecificationAdapter();
      }
      @Override
      public Adapter caseParenthesizedExpression(ParenthesizedExpression object)
      {
        return createParenthesizedExpressionAdapter();
      }
      @Override
      public Adapter caseNullExpression(NullExpression object)
      {
        return createNullExpressionAdapter();
      }
      @Override
      public Adapter caseThisExpression(ThisExpression object)
      {
        return createThisExpressionAdapter();
      }
      @Override
      public Adapter caseSuperInvocationExpression(SuperInvocationExpression object)
      {
        return createSuperInvocationExpressionAdapter();
      }
      @Override
      public Adapter caseInstanceCreationExpression(InstanceCreationExpression object)
      {
        return createInstanceCreationExpressionAdapter();
      }
      @Override
      public Adapter caseInstanceCreationTuple(InstanceCreationTuple object)
      {
        return createInstanceCreationTupleAdapter();
      }
      @Override
      public Adapter caseInstanceCreationTupleElement(InstanceCreationTupleElement object)
      {
        return createInstanceCreationTupleElementAdapter();
      }
      @Override
      public Adapter caseSequenceConstructionOrAccessCompletion(SequenceConstructionOrAccessCompletion object)
      {
        return createSequenceConstructionOrAccessCompletionAdapter();
      }
      @Override
      public Adapter caseAccessCompletion(AccessCompletion object)
      {
        return createAccessCompletionAdapter();
      }
      @Override
      public Adapter casePartialSequenceConstructionCompletion(PartialSequenceConstructionCompletion object)
      {
        return createPartialSequenceConstructionCompletionAdapter();
      }
      @Override
      public Adapter caseSequenceConstructionExpression(SequenceConstructionExpression object)
      {
        return createSequenceConstructionExpressionAdapter();
      }
      @Override
      public Adapter caseSequenceElement(SequenceElement object)
      {
        return createSequenceElementAdapter();
      }
      @Override
      public Adapter caseClassExtentExpression(ClassExtentExpression object)
      {
        return createClassExtentExpressionAdapter();
      }
      @Override
      public Adapter caseBlock(Block object)
      {
        return createBlockAdapter();
      }
      @Override
      public Adapter caseStatementSequence(StatementSequence object)
      {
        return createStatementSequenceAdapter();
      }
      @Override
      public Adapter caseDocumentedStatement(DocumentedStatement object)
      {
        return createDocumentedStatementAdapter();
      }
      @Override
      public Adapter caseInlineStatement(InlineStatement object)
      {
        return createInlineStatementAdapter();
      }
      @Override
      public Adapter caseAnnotatedStatement(AnnotatedStatement object)
      {
        return createAnnotatedStatementAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseBlockStatement(BlockStatement object)
      {
        return createBlockStatementAdapter();
      }
      @Override
      public Adapter caseEmptyStatement(EmptyStatement object)
      {
        return createEmptyStatementAdapter();
      }
      @Override
      public Adapter caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
      {
        return createLocalNameDeclarationStatementAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseSequentialClauses(SequentialClauses object)
      {
        return createSequentialClausesAdapter();
      }
      @Override
      public Adapter caseConcurrentClauses(ConcurrentClauses object)
      {
        return createConcurrentClausesAdapter();
      }
      @Override
      public Adapter caseNonFinalClause(NonFinalClause object)
      {
        return createNonFinalClauseAdapter();
      }
      @Override
      public Adapter caseFinalClause(FinalClause object)
      {
        return createFinalClauseAdapter();
      }
      @Override
      public Adapter caseSwitchStatement(SwitchStatement object)
      {
        return createSwitchStatementAdapter();
      }
      @Override
      public Adapter caseSwitchClause(SwitchClause object)
      {
        return createSwitchClauseAdapter();
      }
      @Override
      public Adapter caseSwitchCase(SwitchCase object)
      {
        return createSwitchCaseAdapter();
      }
      @Override
      public Adapter caseSwitchDefaultClause(SwitchDefaultClause object)
      {
        return createSwitchDefaultClauseAdapter();
      }
      @Override
      public Adapter caseNonEmptyStatementSequence(NonEmptyStatementSequence object)
      {
        return createNonEmptyStatementSequenceAdapter();
      }
      @Override
      public Adapter caseWhileStatement(WhileStatement object)
      {
        return createWhileStatementAdapter();
      }
      @Override
      public Adapter caseDoStatement(DoStatement object)
      {
        return createDoStatementAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseForControl(ForControl object)
      {
        return createForControlAdapter();
      }
      @Override
      public Adapter caseLoopVariableDefinition(LoopVariableDefinition object)
      {
        return createLoopVariableDefinitionAdapter();
      }
      @Override
      public Adapter caseBreakStatement(BreakStatement object)
      {
        return createBreakStatementAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseAcceptStatement(AcceptStatement object)
      {
        return createAcceptStatementAdapter();
      }
      @Override
      public Adapter caseSimpleAcceptStatementCompletion(SimpleAcceptStatementCompletion object)
      {
        return createSimpleAcceptStatementCompletionAdapter();
      }
      @Override
      public Adapter caseCompoundAcceptStatementCompletion(CompoundAcceptStatementCompletion object)
      {
        return createCompoundAcceptStatementCompletionAdapter();
      }
      @Override
      public Adapter caseAcceptBlock(AcceptBlock object)
      {
        return createAcceptBlockAdapter();
      }
      @Override
      public Adapter caseAcceptClause(AcceptClause object)
      {
        return createAcceptClauseAdapter();
      }
      @Override
      public Adapter caseClassifyStatement(ClassifyStatement object)
      {
        return createClassifyStatementAdapter();
      }
      @Override
      public Adapter caseClassificationClause(ClassificationClause object)
      {
        return createClassificationClauseAdapter();
      }
      @Override
      public Adapter caseClassificationFromClause(ClassificationFromClause object)
      {
        return createClassificationFromClauseAdapter();
      }
      @Override
      public Adapter caseClassificationToClause(ClassificationToClause object)
      {
        return createClassificationToClauseAdapter();
      }
      @Override
      public Adapter caseReclassifyAllClause(ReclassifyAllClause object)
      {
        return createReclassifyAllClauseAdapter();
      }
      @Override
      public Adapter caseQualifiedNameList(QualifiedNameList object)
      {
        return createQualifiedNameListAdapter();
      }
      @Override
      public Adapter caseInvocationOrAssignementOrDeclarationStatement(InvocationOrAssignementOrDeclarationStatement object)
      {
        return createInvocationOrAssignementOrDeclarationStatementAdapter();
      }
      @Override
      public Adapter caseSuperInvocationStatement(SuperInvocationStatement object)
      {
        return createSuperInvocationStatementAdapter();
      }
      @Override
      public Adapter caseThisInvocationStatement(ThisInvocationStatement object)
      {
        return createThisInvocationStatementAdapter();
      }
      @Override
      public Adapter caseInstanceCreationInvocationStatement(InstanceCreationInvocationStatement object)
      {
        return createInstanceCreationInvocationStatementAdapter();
      }
      @Override
      public Adapter caseVariableDeclarationCompletion(VariableDeclarationCompletion object)
      {
        return createVariableDeclarationCompletionAdapter();
      }
      @Override
      public Adapter caseAssignmentCompletion(AssignmentCompletion object)
      {
        return createAssignmentCompletionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Test
   * @generated
   */
  public Adapter createTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LITERAL <em>LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LITERAL
   * @generated
   */
  public Adapter createLITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL <em>BOOLEAN LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL
   * @generated
   */
  public Adapter createBOOLEAN_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NUMBER_LITERAL <em>NUMBER LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NUMBER_LITERAL
   * @generated
   */
  public Adapter createNUMBER_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL <em>INTEGER LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL
   * @generated
   */
  public Adapter createINTEGER_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.UNLIMITED_LITERAL <em>UNLIMITED LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.UNLIMITED_LITERAL
   * @generated
   */
  public Adapter createUNLIMITED_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL <em>STRING LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL
   * @generated
   */
  public Adapter createSTRING_LITERALAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NameExpression <em>Name Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NameExpression
   * @generated
   */
  public Adapter createNameExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath <em>Qualified Name Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath
   * @generated
   */
  public Adapter createQualifiedNamePathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.UnqualifiedName <em>Unqualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.UnqualifiedName
   * @generated
   */
  public Adapter createUnqualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.TemplateBinding <em>Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.TemplateBinding
   * @generated
   */
  public Adapter createTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding <em>Named Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding
   * @generated
   */
  public Adapter createNamedTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding <em>Qualified Name With Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding
   * @generated
   */
  public Adapter createQualifiedNameWithBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Tuple
   * @generated
   */
  public Adapter createTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.TupleElement <em>Tuple Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.TupleElement
   * @generated
   */
  public Adapter createTupleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression <em>Conditional Test Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression
   * @generated
   */
  public Adapter createConditionalTestExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression <em>Conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression
   * @generated
   */
  public Adapter createConditionalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression <em>Conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression
   * @generated
   */
  public Adapter createConditionalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InclusiveOrExpression
   * @generated
   */
  public Adapter createInclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression
   * @generated
   */
  public Adapter createExclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression <em>Classification Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassificationExpression
   * @generated
   */
  public Adapter createClassificationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SuffixExpression <em>Suffix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SuffixExpression
   * @generated
   */
  public Adapter createSuffixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.OperationCallExpression <em>Operation Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.OperationCallExpression
   * @generated
   */
  public Adapter createOperationCallExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression <em>Property Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression
   * @generated
   */
  public Adapter createPropertyCallExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression <em>Link Operation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression
   * @generated
   */
  public Adapter createLinkOperationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTuple <em>Link Operation Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LinkOperationTuple
   * @generated
   */
  public Adapter createLinkOperationTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement <em>Link Operation Tuple Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LinkOperationTupleElement
   * @generated
   */
  public Adapter createLinkOperationTupleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression <em>Sequence Operation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression
   * @generated
   */
  public Adapter createSequenceOperationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression <em>Sequence Reduction Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression
   * @generated
   */
  public Adapter createSequenceReductionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression <em>Sequence Expansion Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression
   * @generated
   */
  public Adapter createSequenceExpansionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation <em>Select Or Reject Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation
   * @generated
   */
  public Adapter createSelectOrRejectOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation <em>Collect Or Iterate Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation
   * @generated
   */
  public Adapter createCollectOrIterateOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation <em>For All Or Exists Or One Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation
   * @generated
   */
  public Adapter createForAllOrExistsOrOneOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation <em>Is Unique Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation
   * @generated
   */
  public Adapter createIsUniqueOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ValueSpecification <em>Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ValueSpecification
   * @generated
   */
  public Adapter createValueSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NonLiteralValueSpecification <em>Non Literal Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NonLiteralValueSpecification
   * @generated
   */
  public Adapter createNonLiteralValueSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression
   * @generated
   */
  public Adapter createParenthesizedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NullExpression <em>Null Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NullExpression
   * @generated
   */
  public Adapter createNullExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ThisExpression <em>This Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ThisExpression
   * @generated
   */
  public Adapter createThisExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression <em>Super Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression
   * @generated
   */
  public Adapter createSuperInvocationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression <em>Instance Creation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression
   * @generated
   */
  public Adapter createInstanceCreationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationTuple <em>Instance Creation Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InstanceCreationTuple
   * @generated
   */
  public Adapter createInstanceCreationTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement <em>Instance Creation Tuple Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement
   * @generated
   */
  public Adapter createInstanceCreationTupleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion <em>Sequence Construction Or Access Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion
   * @generated
   */
  public Adapter createSequenceConstructionOrAccessCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AccessCompletion <em>Access Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AccessCompletion
   * @generated
   */
  public Adapter createAccessCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.PartialSequenceConstructionCompletion <em>Partial Sequence Construction Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.PartialSequenceConstructionCompletion
   * @generated
   */
  public Adapter createPartialSequenceConstructionCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression <em>Sequence Construction Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression
   * @generated
   */
  public Adapter createSequenceConstructionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequenceElement <em>Sequence Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequenceElement
   * @generated
   */
  public Adapter createSequenceElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression <em>Class Extent Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression
   * @generated
   */
  public Adapter createClassExtentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Block
   * @generated
   */
  public Adapter createBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.StatementSequence <em>Statement Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.StatementSequence
   * @generated
   */
  public Adapter createStatementSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.DocumentedStatement <em>Documented Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.DocumentedStatement
   * @generated
   */
  public Adapter createDocumentedStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InlineStatement <em>Inline Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InlineStatement
   * @generated
   */
  public Adapter createInlineStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AnnotatedStatement <em>Annotated Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AnnotatedStatement
   * @generated
   */
  public Adapter createAnnotatedStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.BlockStatement
   * @generated
   */
  public Adapter createBlockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.EmptyStatement <em>Empty Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.EmptyStatement
   * @generated
   */
  public Adapter createEmptyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement <em>Local Name Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement
   * @generated
   */
  public Adapter createLocalNameDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SequentialClauses <em>Sequential Clauses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SequentialClauses
   * @generated
   */
  public Adapter createSequentialClausesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses <em>Concurrent Clauses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses
   * @generated
   */
  public Adapter createConcurrentClausesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NonFinalClause <em>Non Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NonFinalClause
   * @generated
   */
  public Adapter createNonFinalClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.FinalClause <em>Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.FinalClause
   * @generated
   */
  public Adapter createFinalClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SwitchStatement
   * @generated
   */
  public Adapter createSwitchStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SwitchClause <em>Switch Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SwitchClause
   * @generated
   */
  public Adapter createSwitchClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SwitchCase <em>Switch Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SwitchCase
   * @generated
   */
  public Adapter createSwitchCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SwitchDefaultClause <em>Switch Default Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SwitchDefaultClause
   * @generated
   */
  public Adapter createSwitchDefaultClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence <em>Non Empty Statement Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence
   * @generated
   */
  public Adapter createNonEmptyStatementSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.WhileStatement
   * @generated
   */
  public Adapter createWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.DoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.DoStatement
   * @generated
   */
  public Adapter createDoStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ForControl <em>For Control</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ForControl
   * @generated
   */
  public Adapter createForControlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition <em>Loop Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition
   * @generated
   */
  public Adapter createLoopVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.BreakStatement
   * @generated
   */
  public Adapter createBreakStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AcceptStatement <em>Accept Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AcceptStatement
   * @generated
   */
  public Adapter createAcceptStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SimpleAcceptStatementCompletion <em>Simple Accept Statement Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SimpleAcceptStatementCompletion
   * @generated
   */
  public Adapter createSimpleAcceptStatementCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.CompoundAcceptStatementCompletion <em>Compound Accept Statement Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.CompoundAcceptStatementCompletion
   * @generated
   */
  public Adapter createCompoundAcceptStatementCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AcceptBlock <em>Accept Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AcceptBlock
   * @generated
   */
  public Adapter createAcceptBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AcceptClause <em>Accept Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AcceptClause
   * @generated
   */
  public Adapter createAcceptClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassifyStatement <em>Classify Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassifyStatement
   * @generated
   */
  public Adapter createClassifyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationClause <em>Classification Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassificationClause
   * @generated
   */
  public Adapter createClassificationClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause <em>Classification From Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause
   * @generated
   */
  public Adapter createClassificationFromClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationToClause <em>Classification To Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ClassificationToClause
   * @generated
   */
  public Adapter createClassificationToClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ReclassifyAllClause <em>Reclassify All Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ReclassifyAllClause
   * @generated
   */
  public Adapter createReclassifyAllClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNameList <em>Qualified Name List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.QualifiedNameList
   * @generated
   */
  public Adapter createQualifiedNameListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement <em>Invocation Or Assignement Or Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement
   * @generated
   */
  public Adapter createInvocationOrAssignementOrDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.SuperInvocationStatement <em>Super Invocation Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.SuperInvocationStatement
   * @generated
   */
  public Adapter createSuperInvocationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement <em>This Invocation Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement
   * @generated
   */
  public Adapter createThisInvocationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationInvocationStatement <em>Instance Creation Invocation Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.InstanceCreationInvocationStatement
   * @generated
   */
  public Adapter createInstanceCreationInvocationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion <em>Variable Declaration Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion
   * @generated
   */
  public Adapter createVariableDeclarationCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion <em>Assignment Completion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion
   * @generated
   */
  public Adapter createAssignmentCompletionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AlfAdapterFactory
