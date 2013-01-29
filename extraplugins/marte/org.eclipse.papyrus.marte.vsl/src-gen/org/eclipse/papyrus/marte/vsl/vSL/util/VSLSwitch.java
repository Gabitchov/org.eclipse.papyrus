/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.marte.vsl.vSL.*;

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
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage
 * @generated
 */
public class VSLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VSLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VSLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = VSLPackage.eINSTANCE;
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
      case VSLPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseValueSpecification(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.AND_OR_XOR_EXPRESSION:
      {
        AndOrXorExpression andOrXorExpression = (AndOrXorExpression)theEObject;
        T result = caseAndOrXorExpression(andOrXorExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.EQUALITY_EXPRESSION:
      {
        EqualityExpression equalityExpression = (EqualityExpression)theEObject;
        T result = caseEqualityExpression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.ADDITIVE_EXPRESSION:
      {
        AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
        T result = caseAdditiveExpression(additiveExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.MULTIPLICATIVE_EXPRESSION:
      {
        MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
        T result = caseMultiplicativeExpression(multiplicativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.UNARY_EXPRESSION:
      {
        UnaryExpression unaryExpression = (UnaryExpression)theEObject;
        T result = caseUnaryExpression(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.PRIMARY_EXPRESSION:
      {
        PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
        T result = casePrimaryExpression(primaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.VALUE_SPECIFICATION:
      {
        ValueSpecification valueSpecification = (ValueSpecification)theEObject;
        T result = caseValueSpecification(valueSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.SUFFIX_EXPRESSION:
      {
        SuffixExpression suffixExpression = (SuffixExpression)theEObject;
        T result = caseSuffixExpression(suffixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.PROPERTY_CALL_EXPRESSION:
      {
        PropertyCallExpression propertyCallExpression = (PropertyCallExpression)theEObject;
        T result = casePropertyCallExpression(propertyCallExpression);
        if (result == null) result = caseSuffixExpression(propertyCallExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.OPERATION_CALL_EXPRESSION:
      {
        OperationCallExpression operationCallExpression = (OperationCallExpression)theEObject;
        T result = caseOperationCallExpression(operationCallExpression);
        if (result == null) result = caseSuffixExpression(operationCallExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseValueSpecification(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL:
      {
        NameOrChoiceOrBehaviorCall nameOrChoiceOrBehaviorCall = (NameOrChoiceOrBehaviorCall)theEObject;
        T result = caseNameOrChoiceOrBehaviorCall(nameOrChoiceOrBehaviorCall);
        if (result == null) result = caseValueSpecification(nameOrChoiceOrBehaviorCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.QUALIFIED_NAME:
      {
        QualifiedName qualifiedName = (QualifiedName)theEObject;
        T result = caseQualifiedName(qualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.INTERVAL:
      {
        Interval interval = (Interval)theEObject;
        T result = caseInterval(interval);
        if (result == null) result = caseValueSpecification(interval);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.COLLECTION_OR_TUPLE:
      {
        CollectionOrTuple collectionOrTuple = (CollectionOrTuple)theEObject;
        T result = caseCollectionOrTuple(collectionOrTuple);
        if (result == null) result = caseValueSpecification(collectionOrTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.TUPLE:
      {
        Tuple tuple = (Tuple)theEObject;
        T result = caseTuple(tuple);
        if (result == null) result = caseValueSpecification(tuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.LIST_OF_VALUES:
      {
        ListOfValues listOfValues = (ListOfValues)theEObject;
        T result = caseListOfValues(listOfValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS:
      {
        ListOfValueNamePairs listOfValueNamePairs = (ListOfValueNamePairs)theEObject;
        T result = caseListOfValueNamePairs(listOfValueNamePairs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.VALUE_NAME_PAIR:
      {
        ValueNamePair valueNamePair = (ValueNamePair)theEObject;
        T result = caseValueNamePair(valueNamePair);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.TIME_EXPRESSION:
      {
        TimeExpression timeExpression = (TimeExpression)theEObject;
        T result = caseTimeExpression(timeExpression);
        if (result == null) result = caseValueSpecification(timeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.INSTANT_OBS_EXPRESSION:
      {
        InstantObsExpression instantObsExpression = (InstantObsExpression)theEObject;
        T result = caseInstantObsExpression(instantObsExpression);
        if (result == null) result = caseTimeExpression(instantObsExpression);
        if (result == null) result = caseValueSpecification(instantObsExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.INSTANT_OBS_NAME:
      {
        InstantObsName instantObsName = (InstantObsName)theEObject;
        T result = caseInstantObsName(instantObsName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.DURATION_OBS_EXPRESSION:
      {
        DurationObsExpression durationObsExpression = (DurationObsExpression)theEObject;
        T result = caseDurationObsExpression(durationObsExpression);
        if (result == null) result = caseTimeExpression(durationObsExpression);
        if (result == null) result = caseValueSpecification(durationObsExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.DURATION_OBS_NAME:
      {
        DurationObsName durationObsName = (DurationObsName)theEObject;
        T result = caseDurationObsName(durationObsName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.JITTER_EXP:
      {
        JitterExp jitterExp = (JitterExp)theEObject;
        T result = caseJitterExp(jitterExp);
        if (result == null) result = caseTimeExpression(jitterExp);
        if (result == null) result = caseValueSpecification(jitterExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.VARIABLE_DECLARATION:
      {
        VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
        T result = caseVariableDeclaration(variableDeclaration);
        if (result == null) result = caseValueSpecification(variableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.DATA_TYPE_NAME:
      {
        DataTypeName dataTypeName = (DataTypeName)theEObject;
        T result = caseDataTypeName(dataTypeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.NUMBER_LITERAL_RULE:
      {
        NumberLiteralRule numberLiteralRule = (NumberLiteralRule)theEObject;
        T result = caseNumberLiteralRule(numberLiteralRule);
        if (result == null) result = caseLiteral(numberLiteralRule);
        if (result == null) result = caseValueSpecification(numberLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.INTEGER_LITERAL_RULE:
      {
        IntegerLiteralRule integerLiteralRule = (IntegerLiteralRule)theEObject;
        T result = caseIntegerLiteralRule(integerLiteralRule);
        if (result == null) result = caseNumberLiteralRule(integerLiteralRule);
        if (result == null) result = caseLiteral(integerLiteralRule);
        if (result == null) result = caseValueSpecification(integerLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.UNLIMITED_LITERAL_RULE:
      {
        UnlimitedLiteralRule unlimitedLiteralRule = (UnlimitedLiteralRule)theEObject;
        T result = caseUnlimitedLiteralRule(unlimitedLiteralRule);
        if (result == null) result = caseNumberLiteralRule(unlimitedLiteralRule);
        if (result == null) result = caseLiteral(unlimitedLiteralRule);
        if (result == null) result = caseValueSpecification(unlimitedLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.REAL_LITERAL_RULE:
      {
        RealLiteralRule realLiteralRule = (RealLiteralRule)theEObject;
        T result = caseRealLiteralRule(realLiteralRule);
        if (result == null) result = caseNumberLiteralRule(realLiteralRule);
        if (result == null) result = caseLiteral(realLiteralRule);
        if (result == null) result = caseValueSpecification(realLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.DATE_TIME_LITERAL_RULE:
      {
        DateTimeLiteralRule dateTimeLiteralRule = (DateTimeLiteralRule)theEObject;
        T result = caseDateTimeLiteralRule(dateTimeLiteralRule);
        if (result == null) result = caseLiteral(dateTimeLiteralRule);
        if (result == null) result = caseValueSpecification(dateTimeLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.BOOLEAN_LITERAL_RULE:
      {
        BooleanLiteralRule booleanLiteralRule = (BooleanLiteralRule)theEObject;
        T result = caseBooleanLiteralRule(booleanLiteralRule);
        if (result == null) result = caseLiteral(booleanLiteralRule);
        if (result == null) result = caseValueSpecification(booleanLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.NULL_LITERAL_RULE:
      {
        NullLiteralRule nullLiteralRule = (NullLiteralRule)theEObject;
        T result = caseNullLiteralRule(nullLiteralRule);
        if (result == null) result = caseLiteral(nullLiteralRule);
        if (result == null) result = caseValueSpecification(nullLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.DEFAULT_LITERAL_RULE:
      {
        DefaultLiteralRule defaultLiteralRule = (DefaultLiteralRule)theEObject;
        T result = caseDefaultLiteralRule(defaultLiteralRule);
        if (result == null) result = caseLiteral(defaultLiteralRule);
        if (result == null) result = caseValueSpecification(defaultLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VSLPackage.STRING_LITERAL_RULE:
      {
        StringLiteralRule stringLiteralRule = (StringLiteralRule)theEObject;
        T result = caseStringLiteralRule(stringLiteralRule);
        if (result == null) result = caseLiteral(stringLiteralRule);
        if (result == null) result = caseValueSpecification(stringLiteralRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>And Or Xor Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Or Xor Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndOrXorExpression(AndOrXorExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpression(ConditionalExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Or Choice Or Behavior Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Or Choice Or Behavior Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameOrChoiceOrBehaviorCall(NameOrChoiceOrBehaviorCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedName(QualifiedName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interval</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interval</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterval(Interval object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Or Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Or Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionOrTuple(CollectionOrTuple object)
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
   * Returns the result of interpreting the object as an instance of '<em>List Of Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Of Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListOfValues(ListOfValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Of Value Name Pairs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Of Value Name Pairs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListOfValueNamePairs(ListOfValueNamePairs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Name Pair</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Name Pair</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueNamePair(ValueNamePair object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeExpression(TimeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instant Obs Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instant Obs Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstantObsExpression(InstantObsExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instant Obs Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instant Obs Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstantObsName(InstantObsName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Duration Obs Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Duration Obs Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDurationObsExpression(DurationObsExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Duration Obs Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Duration Obs Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDurationObsName(DurationObsName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Jitter Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Jitter Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJitterExp(JitterExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclaration(VariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataTypeName(DataTypeName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteralRule(NumberLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteralRule(IntegerLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unlimited Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unlimited Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnlimitedLiteralRule(UnlimitedLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteralRule(RealLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Date Time Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Date Time Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDateTimeLiteralRule(DateTimeLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteralRule(BooleanLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullLiteralRule(NullLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Default Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Default Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefaultLiteralRule(DefaultLiteralRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralRule(StringLiteralRule object)
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

} //VSLSwitch
