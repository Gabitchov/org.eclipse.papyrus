/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage
 * @generated
 */
public interface VSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VSLFactory eINSTANCE = org.eclipse.papyrus.marte.vsl.vSL.impl.VSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>And Or Xor Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Or Xor Expression</em>'.
   * @generated
   */
  AndOrXorExpression createAndOrXorExpression();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression</em>'.
   * @generated
   */
  ConditionalExpression createConditionalExpression();

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
   * Returns a new object of class '<em>Value Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Specification</em>'.
   * @generated
   */
  ValueSpecification createValueSpecification();

  /**
   * Returns a new object of class '<em>Suffix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suffix Expression</em>'.
   * @generated
   */
  SuffixExpression createSuffixExpression();

  /**
   * Returns a new object of class '<em>Property Call Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Call Expression</em>'.
   * @generated
   */
  PropertyCallExpression createPropertyCallExpression();

  /**
   * Returns a new object of class '<em>Operation Call Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Call Expression</em>'.
   * @generated
   */
  OperationCallExpression createOperationCallExpression();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Name Or Choice Or Behavior Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Or Choice Or Behavior Call</em>'.
   * @generated
   */
  NameOrChoiceOrBehaviorCall createNameOrChoiceOrBehaviorCall();

  /**
   * Returns a new object of class '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name</em>'.
   * @generated
   */
  QualifiedName createQualifiedName();

  /**
   * Returns a new object of class '<em>Interval</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interval</em>'.
   * @generated
   */
  Interval createInterval();

  /**
   * Returns a new object of class '<em>Collection Or Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Or Tuple</em>'.
   * @generated
   */
  CollectionOrTuple createCollectionOrTuple();

  /**
   * Returns a new object of class '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple</em>'.
   * @generated
   */
  Tuple createTuple();

  /**
   * Returns a new object of class '<em>List Of Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Of Values</em>'.
   * @generated
   */
  ListOfValues createListOfValues();

  /**
   * Returns a new object of class '<em>List Of Value Name Pairs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Of Value Name Pairs</em>'.
   * @generated
   */
  ListOfValueNamePairs createListOfValueNamePairs();

  /**
   * Returns a new object of class '<em>Value Name Pair</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Name Pair</em>'.
   * @generated
   */
  ValueNamePair createValueNamePair();

  /**
   * Returns a new object of class '<em>Time Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Expression</em>'.
   * @generated
   */
  TimeExpression createTimeExpression();

  /**
   * Returns a new object of class '<em>Instant Obs Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instant Obs Expression</em>'.
   * @generated
   */
  InstantObsExpression createInstantObsExpression();

  /**
   * Returns a new object of class '<em>Instant Obs Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instant Obs Name</em>'.
   * @generated
   */
  InstantObsName createInstantObsName();

  /**
   * Returns a new object of class '<em>Duration Obs Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Duration Obs Expression</em>'.
   * @generated
   */
  DurationObsExpression createDurationObsExpression();

  /**
   * Returns a new object of class '<em>Duration Obs Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Duration Obs Name</em>'.
   * @generated
   */
  DurationObsName createDurationObsName();

  /**
   * Returns a new object of class '<em>Jitter Exp</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Jitter Exp</em>'.
   * @generated
   */
  JitterExp createJitterExp();

  /**
   * Returns a new object of class '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration</em>'.
   * @generated
   */
  VariableDeclaration createVariableDeclaration();

  /**
   * Returns a new object of class '<em>Data Type Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Name</em>'.
   * @generated
   */
  DataTypeName createDataTypeName();

  /**
   * Returns a new object of class '<em>Number Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Literal Rule</em>'.
   * @generated
   */
  NumberLiteralRule createNumberLiteralRule();

  /**
   * Returns a new object of class '<em>Integer Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Literal Rule</em>'.
   * @generated
   */
  IntegerLiteralRule createIntegerLiteralRule();

  /**
   * Returns a new object of class '<em>Unlimited Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unlimited Literal Rule</em>'.
   * @generated
   */
  UnlimitedLiteralRule createUnlimitedLiteralRule();

  /**
   * Returns a new object of class '<em>Real Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Literal Rule</em>'.
   * @generated
   */
  RealLiteralRule createRealLiteralRule();

  /**
   * Returns a new object of class '<em>Date Time Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Time Literal Rule</em>'.
   * @generated
   */
  DateTimeLiteralRule createDateTimeLiteralRule();

  /**
   * Returns a new object of class '<em>Boolean Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal Rule</em>'.
   * @generated
   */
  BooleanLiteralRule createBooleanLiteralRule();

  /**
   * Returns a new object of class '<em>Null Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Literal Rule</em>'.
   * @generated
   */
  NullLiteralRule createNullLiteralRule();

  /**
   * Returns a new object of class '<em>Default Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Default Literal Rule</em>'.
   * @generated
   */
  DefaultLiteralRule createDefaultLiteralRule();

  /**
   * Returns a new object of class '<em>String Literal Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal Rule</em>'.
   * @generated
   */
  StringLiteralRule createStringLiteralRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  VSLPackage getVSLPackage();

} //VSLFactory
