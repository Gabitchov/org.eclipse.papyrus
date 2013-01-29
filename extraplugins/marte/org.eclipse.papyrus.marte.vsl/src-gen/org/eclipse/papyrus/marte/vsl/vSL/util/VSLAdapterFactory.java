/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.marte.vsl.vSL.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage
 * @generated
 */
public class VSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VSLPackage.eINSTANCE;
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
  protected VSLSwitch<Adapter> modelSwitch =
    new VSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseAndOrXorExpression(AndOrXorExpression object)
      {
        return createAndOrXorExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
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
      public Adapter caseValueSpecification(ValueSpecification object)
      {
        return createValueSpecificationAdapter();
      }
      @Override
      public Adapter caseSuffixExpression(SuffixExpression object)
      {
        return createSuffixExpressionAdapter();
      }
      @Override
      public Adapter casePropertyCallExpression(PropertyCallExpression object)
      {
        return createPropertyCallExpressionAdapter();
      }
      @Override
      public Adapter caseOperationCallExpression(OperationCallExpression object)
      {
        return createOperationCallExpressionAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseNameOrChoiceOrBehaviorCall(NameOrChoiceOrBehaviorCall object)
      {
        return createNameOrChoiceOrBehaviorCallAdapter();
      }
      @Override
      public Adapter caseQualifiedName(QualifiedName object)
      {
        return createQualifiedNameAdapter();
      }
      @Override
      public Adapter caseInterval(Interval object)
      {
        return createIntervalAdapter();
      }
      @Override
      public Adapter caseCollectionOrTuple(CollectionOrTuple object)
      {
        return createCollectionOrTupleAdapter();
      }
      @Override
      public Adapter caseTuple(Tuple object)
      {
        return createTupleAdapter();
      }
      @Override
      public Adapter caseListOfValues(ListOfValues object)
      {
        return createListOfValuesAdapter();
      }
      @Override
      public Adapter caseListOfValueNamePairs(ListOfValueNamePairs object)
      {
        return createListOfValueNamePairsAdapter();
      }
      @Override
      public Adapter caseValueNamePair(ValueNamePair object)
      {
        return createValueNamePairAdapter();
      }
      @Override
      public Adapter caseTimeExpression(TimeExpression object)
      {
        return createTimeExpressionAdapter();
      }
      @Override
      public Adapter caseInstantObsExpression(InstantObsExpression object)
      {
        return createInstantObsExpressionAdapter();
      }
      @Override
      public Adapter caseInstantObsName(InstantObsName object)
      {
        return createInstantObsNameAdapter();
      }
      @Override
      public Adapter caseDurationObsExpression(DurationObsExpression object)
      {
        return createDurationObsExpressionAdapter();
      }
      @Override
      public Adapter caseDurationObsName(DurationObsName object)
      {
        return createDurationObsNameAdapter();
      }
      @Override
      public Adapter caseJitterExp(JitterExp object)
      {
        return createJitterExpAdapter();
      }
      @Override
      public Adapter caseVariableDeclaration(VariableDeclaration object)
      {
        return createVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseDataTypeName(DataTypeName object)
      {
        return createDataTypeNameAdapter();
      }
      @Override
      public Adapter caseNumberLiteralRule(NumberLiteralRule object)
      {
        return createNumberLiteralRuleAdapter();
      }
      @Override
      public Adapter caseIntegerLiteralRule(IntegerLiteralRule object)
      {
        return createIntegerLiteralRuleAdapter();
      }
      @Override
      public Adapter caseUnlimitedLiteralRule(UnlimitedLiteralRule object)
      {
        return createUnlimitedLiteralRuleAdapter();
      }
      @Override
      public Adapter caseRealLiteralRule(RealLiteralRule object)
      {
        return createRealLiteralRuleAdapter();
      }
      @Override
      public Adapter caseDateTimeLiteralRule(DateTimeLiteralRule object)
      {
        return createDateTimeLiteralRuleAdapter();
      }
      @Override
      public Adapter caseBooleanLiteralRule(BooleanLiteralRule object)
      {
        return createBooleanLiteralRuleAdapter();
      }
      @Override
      public Adapter caseNullLiteralRule(NullLiteralRule object)
      {
        return createNullLiteralRuleAdapter();
      }
      @Override
      public Adapter caseDefaultLiteralRule(DefaultLiteralRule object)
      {
        return createDefaultLiteralRuleAdapter();
      }
      @Override
      public Adapter caseStringLiteralRule(StringLiteralRule object)
      {
        return createStringLiteralRuleAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression <em>And Or Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression
   * @generated
   */
  public Adapter createAndOrXorExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression
   * @generated
   */
  public Adapter createConditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification <em>Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification
   * @generated
   */
  public Adapter createValueSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression <em>Suffix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression
   * @generated
   */
  public Adapter createSuffixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression <em>Property Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression
   * @generated
   */
  public Adapter createPropertyCallExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression <em>Operation Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression
   * @generated
   */
  public Adapter createOperationCallExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall <em>Name Or Choice Or Behavior Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall
   * @generated
   */
  public Adapter createNameOrChoiceOrBehaviorCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.QualifiedName
   * @generated
   */
  public Adapter createQualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval
   * @generated
   */
  public Adapter createIntervalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple <em>Collection Or Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple
   * @generated
   */
  public Adapter createCollectionOrTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Tuple
   * @generated
   */
  public Adapter createTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValues <em>List Of Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValues
   * @generated
   */
  public Adapter createListOfValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs <em>List Of Value Name Pairs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs
   * @generated
   */
  public Adapter createListOfValueNamePairsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair <em>Value Name Pair</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair
   * @generated
   */
  public Adapter createValueNamePairAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.TimeExpression <em>Time Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.TimeExpression
   * @generated
   */
  public Adapter createTimeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression <em>Instant Obs Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression
   * @generated
   */
  public Adapter createInstantObsExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName <em>Instant Obs Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsName
   * @generated
   */
  public Adapter createInstantObsNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression <em>Duration Obs Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression
   * @generated
   */
  public Adapter createDurationObsExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsName <em>Duration Obs Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsName
   * @generated
   */
  public Adapter createDurationObsNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp <em>Jitter Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.JitterExp
   * @generated
   */
  public Adapter createJitterExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration
   * @generated
   */
  public Adapter createVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.DataTypeName <em>Data Type Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DataTypeName
   * @generated
   */
  public Adapter createDataTypeNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.NumberLiteralRule <em>Number Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NumberLiteralRule
   * @generated
   */
  public Adapter createNumberLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule <em>Integer Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule
   * @generated
   */
  public Adapter createIntegerLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule <em>Unlimited Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule
   * @generated
   */
  public Adapter createUnlimitedLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule <em>Real Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule
   * @generated
   */
  public Adapter createRealLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule <em>Date Time Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule
   * @generated
   */
  public Adapter createDateTimeLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule <em>Boolean Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule
   * @generated
   */
  public Adapter createBooleanLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule <em>Null Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule
   * @generated
   */
  public Adapter createNullLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule <em>Default Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule
   * @generated
   */
  public Adapter createDefaultLiteralRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule <em>String Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule
   * @generated
   */
  public Adapter createStringLiteralRuleAdapter()
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

} //VSLAdapterFactory
