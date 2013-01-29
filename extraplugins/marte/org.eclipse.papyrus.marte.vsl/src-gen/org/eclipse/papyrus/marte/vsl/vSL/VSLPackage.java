/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLFactory
 * @model kind="package"
 * @generated
 */
public interface VSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "vSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/marte/vsl/VSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "vSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VSLPackage eINSTANCE = org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ValueSpecificationImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getValueSpecification()
   * @generated
   */
  int VALUE_SPECIFICATION = 9;

  /**
   * The number of structural features of the '<em>Value Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_SPECIFICATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXP = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.AndOrXorExpressionImpl <em>And Or Xor Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.AndOrXorExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getAndOrXorExpression()
   * @generated
   */
  int AND_OR_XOR_EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_XOR_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_XOR_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>And Or Xor Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_XOR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.RelationalExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ConditionalExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.AdditiveExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.MultiplicativeExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXP = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OP = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = 0;

  /**
   * The feature id for the '<em><b>Unary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__UNARY = 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP = 2;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__PREFIX = 0;

  /**
   * The feature id for the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__SUFFIX = 1;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.SuffixExpressionImpl <em>Suffix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.SuffixExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getSuffixExpression()
   * @generated
   */
  int SUFFIX_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUFFIX_EXPRESSION__SUFFIX = 0;

  /**
   * The number of structural features of the '<em>Suffix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUFFIX_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PropertyCallExpressionImpl <em>Property Call Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.PropertyCallExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getPropertyCallExpression()
   * @generated
   */
  int PROPERTY_CALL_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CALL_EXPRESSION__SUFFIX = SUFFIX_EXPRESSION__SUFFIX;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CALL_EXPRESSION__PROPERTY = SUFFIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Call Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CALL_EXPRESSION_FEATURE_COUNT = SUFFIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl <em>Operation Call Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getOperationCallExpression()
   * @generated
   */
  int OPERATION_CALL_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_EXPRESSION__SUFFIX = SUFFIX_EXPRESSION__SUFFIX;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_EXPRESSION__OPERATION = SUFFIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_EXPRESSION__ARGUMENTS = SUFFIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operation Call Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_EXPRESSION_FEATURE_COUNT = SUFFIX_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.LiteralImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VALUE = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl <em>Name Or Choice Or Behavior Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNameOrChoiceOrBehaviorCall()
   * @generated
   */
  int NAME_OR_CHOICE_OR_BEHAVIOR_CALL = 14;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS = VALUE_SPECIFICATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Name Or Choice Or Behavior Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_OR_CHOICE_OR_BEHAVIOR_CALL_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.QualifiedNameImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 15;

  /**
   * The feature id for the '<em><b>Path</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__PATH = 0;

  /**
   * The feature id for the '<em><b>Remaining</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__REMAINING = 1;

  /**
   * The number of structural features of the '<em>Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl <em>Interval</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInterval()
   * @generated
   */
  int INTERVAL = 16;

  /**
   * The feature id for the '<em><b>Is Lower Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__IS_LOWER_INCLUDED = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__LOWER = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__UPPER = VALUE_SPECIFICATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Is Upper Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__IS_UPPER_INCLUDED = VALUE_SPECIFICATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Interval</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.CollectionOrTupleImpl <em>Collection Or Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.CollectionOrTupleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getCollectionOrTuple()
   * @generated
   */
  int COLLECTION_OR_TUPLE = 17;

  /**
   * The feature id for the '<em><b>List Of Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_OR_TUPLE__LIST_OF_VALUES = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Collection Or Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_OR_TUPLE_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.TupleImpl <em>Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.TupleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getTuple()
   * @generated
   */
  int TUPLE = 18;

  /**
   * The feature id for the '<em><b>List Of Value Name Pairs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE__LIST_OF_VALUE_NAME_PAIRS = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValuesImpl <em>List Of Values</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValuesImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getListOfValues()
   * @generated
   */
  int LIST_OF_VALUES = 19;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF_VALUES__VALUES = 0;

  /**
   * The number of structural features of the '<em>List Of Values</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF_VALUES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValueNamePairsImpl <em>List Of Value Name Pairs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValueNamePairsImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getListOfValueNamePairs()
   * @generated
   */
  int LIST_OF_VALUE_NAME_PAIRS = 20;

  /**
   * The feature id for the '<em><b>Value Name Pairs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS = 0;

  /**
   * The number of structural features of the '<em>List Of Value Name Pairs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_OF_VALUE_NAME_PAIRS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ValueNamePairImpl <em>Value Name Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ValueNamePairImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getValueNamePair()
   * @generated
   */
  int VALUE_NAME_PAIR = 21;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NAME_PAIR__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NAME_PAIR__VALUE = 1;

  /**
   * The number of structural features of the '<em>Value Name Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NAME_PAIR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.TimeExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getTimeExpression()
   * @generated
   */
  int TIME_EXPRESSION = 22;

  /**
   * The number of structural features of the '<em>Time Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EXPRESSION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsExpressionImpl <em>Instant Obs Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInstantObsExpression()
   * @generated
   */
  int INSTANT_OBS_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_EXPRESSION__ID = TIME_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_EXPRESSION__INDEX = TIME_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_EXPRESSION__CONDITION = TIME_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Instant Obs Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_EXPRESSION_FEATURE_COUNT = TIME_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl <em>Instant Obs Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInstantObsName()
   * @generated
   */
  int INSTANT_OBS_NAME = 24;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_NAME__PATH = 0;

  /**
   * The feature id for the '<em><b>Instant Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_NAME__INSTANT_ID = 1;

  /**
   * The number of structural features of the '<em>Instant Obs Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANT_OBS_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsExpressionImpl <em>Duration Obs Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsExpressionImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDurationObsExpression()
   * @generated
   */
  int DURATION_OBS_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_EXPRESSION__ID = TIME_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_EXPRESSION__INDEX = TIME_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_EXPRESSION__CONDITION = TIME_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Duration Obs Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_EXPRESSION_FEATURE_COUNT = TIME_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsNameImpl <em>Duration Obs Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsNameImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDurationObsName()
   * @generated
   */
  int DURATION_OBS_NAME = 26;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_NAME__PATH = 0;

  /**
   * The feature id for the '<em><b>Duration Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_NAME__DURATION_ID = 1;

  /**
   * The number of structural features of the '<em>Duration Obs Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DURATION_OBS_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl <em>Jitter Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getJitterExp()
   * @generated
   */
  int JITTER_EXP = 27;

  /**
   * The feature id for the '<em><b>First Instant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JITTER_EXP__FIRST_INSTANT = TIME_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second Instant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JITTER_EXP__SECOND_INSTANT = TIME_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Jitter Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JITTER_EXP_FEATURE_COUNT = TIME_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 28;

  /**
   * The feature id for the '<em><b>Variable Declaration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__VARIABLE_DECLARATION = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAME = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = VALUE_SPECIFICATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Init Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__INIT_VALUE = VALUE_SPECIFICATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DataTypeNameImpl <em>Data Type Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DataTypeNameImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDataTypeName()
   * @generated
   */
  int DATA_TYPE_NAME = 29;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_NAME__PATH = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_NAME__TYPE = 1;

  /**
   * The number of structural features of the '<em>Data Type Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NumberLiteralRuleImpl <em>Number Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NumberLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNumberLiteralRule()
   * @generated
   */
  int NUMBER_LITERAL_RULE = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Number Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntegerLiteralRuleImpl <em>Integer Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.IntegerLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getIntegerLiteralRule()
   * @generated
   */
  int INTEGER_LITERAL_RULE = 31;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_RULE__VALUE = NUMBER_LITERAL_RULE__VALUE;

  /**
   * The number of structural features of the '<em>Integer Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_RULE_FEATURE_COUNT = NUMBER_LITERAL_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnlimitedLiteralRuleImpl <em>Unlimited Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.UnlimitedLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getUnlimitedLiteralRule()
   * @generated
   */
  int UNLIMITED_LITERAL_RULE = 32;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLIMITED_LITERAL_RULE__VALUE = NUMBER_LITERAL_RULE__VALUE;

  /**
   * The number of structural features of the '<em>Unlimited Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLIMITED_LITERAL_RULE_FEATURE_COUNT = NUMBER_LITERAL_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.RealLiteralRuleImpl <em>Real Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.RealLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getRealLiteralRule()
   * @generated
   */
  int REAL_LITERAL_RULE = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_RULE__VALUE = NUMBER_LITERAL_RULE__VALUE;

  /**
   * The number of structural features of the '<em>Real Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_RULE_FEATURE_COUNT = NUMBER_LITERAL_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DateTimeLiteralRuleImpl <em>Date Time Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DateTimeLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDateTimeLiteralRule()
   * @generated
   */
  int DATE_TIME_LITERAL_RULE = 34;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TIME_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Date Time Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TIME_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.BooleanLiteralRuleImpl <em>Boolean Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.BooleanLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getBooleanLiteralRule()
   * @generated
   */
  int BOOLEAN_LITERAL_RULE = 35;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Boolean Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NullLiteralRuleImpl <em>Null Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NullLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNullLiteralRule()
   * @generated
   */
  int NULL_LITERAL_RULE = 36;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Null Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DefaultLiteralRuleImpl <em>Default Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DefaultLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDefaultLiteralRule()
   * @generated
   */
  int DEFAULT_LITERAL_RULE = 37;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Default Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.StringLiteralRuleImpl <em>String Literal Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.StringLiteralRuleImpl
   * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getStringLiteralRule()
   * @generated
   */
  int STRING_LITERAL_RULE = 38;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_RULE__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>String Literal Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_RULE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.Expression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Expression#getExp()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Exp();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression <em>And Or Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Or Xor Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression
   * @generated
   */
  EClass getAndOrXorExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression#getExp()
   * @see #getAndOrXorExpression()
   * @generated
   */
  EReference getAndOrXorExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression#getOp()
   * @see #getAndOrXorExpression()
   * @generated
   */
  EAttribute getAndOrXorExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression#getExp()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression#getOp()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression#getExp()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression#getOp()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression#getExp()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression#getOp()
   * @see #getConditionalExpression()
   * @generated
   */
  EAttribute getConditionalExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression#getExp()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression#getOp()
   * @see #getAdditiveExpression()
   * @generated
   */
  EAttribute getAdditiveExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression#getExp()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Exp();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression#getOp()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EAttribute getMultiplicativeExpression_Op();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getUnary <em>Unary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unary</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getUnary()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Unary();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression#getExp()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Exp();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prefix</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression#getPrefix()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Prefix();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression#getSuffix <em>Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Suffix</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression#getSuffix()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Suffix();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification <em>Value Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Specification</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification
   * @generated
   */
  EClass getValueSpecification();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression <em>Suffix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suffix Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression
   * @generated
   */
  EClass getSuffixExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression#getSuffix <em>Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Suffix</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression#getSuffix()
   * @see #getSuffixExpression()
   * @generated
   */
  EReference getSuffixExpression_Suffix();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression <em>Property Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Call Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression
   * @generated
   */
  EClass getPropertyCallExpression();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression#getProperty()
   * @see #getPropertyCallExpression()
   * @generated
   */
  EReference getPropertyCallExpression_Property();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression <em>Operation Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression
   * @generated
   */
  EClass getOperationCallExpression();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression#getOperation()
   * @see #getOperationCallExpression()
   * @generated
   */
  EReference getOperationCallExpression_Operation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arguments</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression#getArguments()
   * @see #getOperationCallExpression()
   * @generated
   */
  EReference getOperationCallExpression_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.Literal#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Literal#getValue()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall <em>Name Or Choice Or Behavior Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Or Choice Or Behavior Call</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall
   * @generated
   */
  EClass getNameOrChoiceOrBehaviorCall();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getPath()
   * @see #getNameOrChoiceOrBehaviorCall()
   * @generated
   */
  EReference getNameOrChoiceOrBehaviorCall_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getId()
   * @see #getNameOrChoiceOrBehaviorCall()
   * @generated
   */
  EReference getNameOrChoiceOrBehaviorCall_Id();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arguments</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall#getArguments()
   * @see #getNameOrChoiceOrBehaviorCall()
   * @generated
   */
  EReference getNameOrChoiceOrBehaviorCall_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.QualifiedName
   * @generated
   */
  EClass getQualifiedName();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getPath()
   * @see #getQualifiedName()
   * @generated
   */
  EReference getQualifiedName_Path();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getRemaining <em>Remaining</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Remaining</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getRemaining()
   * @see #getQualifiedName()
   * @generated
   */
  EReference getQualifiedName_Remaining();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interval</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval
   * @generated
   */
  EClass getInterval();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsLowerIncluded <em>Is Lower Included</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Lower Included</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsLowerIncluded()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_IsLowerIncluded();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval#getLower()
   * @see #getInterval()
   * @generated
   */
  EReference getInterval_Lower();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval#getUpper()
   * @see #getInterval()
   * @generated
   */
  EReference getInterval_Upper();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsUpperIncluded <em>Is Upper Included</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Upper Included</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsUpperIncluded()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_IsUpperIncluded();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple <em>Collection Or Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Or Tuple</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple
   * @generated
   */
  EClass getCollectionOrTuple();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple#getListOfValues <em>List Of Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List Of Values</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple#getListOfValues()
   * @see #getCollectionOrTuple()
   * @generated
   */
  EReference getCollectionOrTuple_ListOfValues();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Tuple
   * @generated
   */
  EClass getTuple();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.Tuple#getListOfValueNamePairs <em>List Of Value Name Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List Of Value Name Pairs</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.Tuple#getListOfValueNamePairs()
   * @see #getTuple()
   * @generated
   */
  EReference getTuple_ListOfValueNamePairs();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValues <em>List Of Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Of Values</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValues
   * @generated
   */
  EClass getListOfValues();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValues#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValues#getValues()
   * @see #getListOfValues()
   * @generated
   */
  EReference getListOfValues_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs <em>List Of Value Name Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Of Value Name Pairs</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs
   * @generated
   */
  EClass getListOfValueNamePairs();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs#getValueNamePairs <em>Value Name Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value Name Pairs</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs#getValueNamePairs()
   * @see #getListOfValueNamePairs()
   * @generated
   */
  EReference getListOfValueNamePairs_ValueNamePairs();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair <em>Value Name Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Name Pair</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair
   * @generated
   */
  EClass getValueNamePair();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair#getProperty()
   * @see #getValueNamePair()
   * @generated
   */
  EReference getValueNamePair_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair#getValue()
   * @see #getValueNamePair()
   * @generated
   */
  EReference getValueNamePair_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.TimeExpression <em>Time Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.TimeExpression
   * @generated
   */
  EClass getTimeExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression <em>Instant Obs Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instant Obs Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression
   * @generated
   */
  EClass getInstantObsExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getId()
   * @see #getInstantObsExpression()
   * @generated
   */
  EReference getInstantObsExpression_Id();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getIndex()
   * @see #getInstantObsExpression()
   * @generated
   */
  EReference getInstantObsExpression_Index();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression#getCondition()
   * @see #getInstantObsExpression()
   * @generated
   */
  EReference getInstantObsExpression_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName <em>Instant Obs Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instant Obs Name</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsName
   * @generated
   */
  EClass getInstantObsName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getPath()
   * @see #getInstantObsName()
   * @generated
   */
  EReference getInstantObsName_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getInstantId <em>Instant Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instant Id</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getInstantId()
   * @see #getInstantObsName()
   * @generated
   */
  EReference getInstantObsName_InstantId();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression <em>Duration Obs Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Duration Obs Expression</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression
   * @generated
   */
  EClass getDurationObsExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getId()
   * @see #getDurationObsExpression()
   * @generated
   */
  EReference getDurationObsExpression_Id();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getIndex()
   * @see #getDurationObsExpression()
   * @generated
   */
  EReference getDurationObsExpression_Index();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression#getCondition()
   * @see #getDurationObsExpression()
   * @generated
   */
  EReference getDurationObsExpression_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsName <em>Duration Obs Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Duration Obs Name</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsName
   * @generated
   */
  EClass getDurationObsName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsName#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsName#getPath()
   * @see #getDurationObsName()
   * @generated
   */
  EReference getDurationObsName_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DurationObsName#getDurationId <em>Duration Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Duration Id</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DurationObsName#getDurationId()
   * @see #getDurationObsName()
   * @generated
   */
  EReference getDurationObsName_DurationId();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp <em>Jitter Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Jitter Exp</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.JitterExp
   * @generated
   */
  EClass getJitterExp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getFirstInstant <em>First Instant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First Instant</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getFirstInstant()
   * @see #getJitterExp()
   * @generated
   */
  EReference getJitterExp_FirstInstant();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getSecondInstant <em>Second Instant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second Instant</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getSecondInstant()
   * @see #getJitterExp()
   * @generated
   */
  EReference getJitterExp_SecondInstant();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getVariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable Declaration</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getVariableDeclaration()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_VariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getName()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getInitValue <em>Init Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Value</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getInitValue()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_InitValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.DataTypeName <em>Data Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type Name</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DataTypeName
   * @generated
   */
  EClass getDataTypeName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DataTypeName#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DataTypeName#getPath()
   * @see #getDataTypeName()
   * @generated
   */
  EReference getDataTypeName_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.marte.vsl.vSL.DataTypeName#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DataTypeName#getType()
   * @see #getDataTypeName()
   * @generated
   */
  EReference getDataTypeName_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.NumberLiteralRule <em>Number Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NumberLiteralRule
   * @generated
   */
  EClass getNumberLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule <em>Integer Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule
   * @generated
   */
  EClass getIntegerLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule <em>Unlimited Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unlimited Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule
   * @generated
   */
  EClass getUnlimitedLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule <em>Real Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule
   * @generated
   */
  EClass getRealLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule <em>Date Time Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Time Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule
   * @generated
   */
  EClass getDateTimeLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule <em>Boolean Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule
   * @generated
   */
  EClass getBooleanLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule <em>Null Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule
   * @generated
   */
  EClass getNullLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule <em>Default Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Default Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule
   * @generated
   */
  EClass getDefaultLiteralRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule <em>String Literal Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Rule</em>'.
   * @see org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule
   * @generated
   */
  EClass getStringLiteralRule();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  VSLFactory getVSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXP = eINSTANCE.getExpression_Exp();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.AndOrXorExpressionImpl <em>And Or Xor Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.AndOrXorExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getAndOrXorExpression()
     * @generated
     */
    EClass AND_OR_XOR_EXPRESSION = eINSTANCE.getAndOrXorExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_OR_XOR_EXPRESSION__EXP = eINSTANCE.getAndOrXorExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AND_OR_XOR_EXPRESSION__OP = eINSTANCE.getAndOrXorExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXP = eINSTANCE.getEqualityExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OP = eINSTANCE.getEqualityExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.RelationalExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXP = eINSTANCE.getRelationalExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OP = eINSTANCE.getRelationalExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ConditionalExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXP = eINSTANCE.getConditionalExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_EXPRESSION__OP = eINSTANCE.getConditionalExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.AdditiveExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXP = eINSTANCE.getAdditiveExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION__OP = eINSTANCE.getAdditiveExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.MultiplicativeExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXP = eINSTANCE.getMultiplicativeExpression_Exp();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION__OP = eINSTANCE.getMultiplicativeExpression_Op();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '<em><b>Unary</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__UNARY = eINSTANCE.getUnaryExpression_Unary();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP = eINSTANCE.getUnaryExpression_Exp();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__PREFIX = eINSTANCE.getPrimaryExpression_Prefix();

    /**
     * The meta object literal for the '<em><b>Suffix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__SUFFIX = eINSTANCE.getPrimaryExpression_Suffix();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ValueSpecificationImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getValueSpecification()
     * @generated
     */
    EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.SuffixExpressionImpl <em>Suffix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.SuffixExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getSuffixExpression()
     * @generated
     */
    EClass SUFFIX_EXPRESSION = eINSTANCE.getSuffixExpression();

    /**
     * The meta object literal for the '<em><b>Suffix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUFFIX_EXPRESSION__SUFFIX = eINSTANCE.getSuffixExpression_Suffix();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PropertyCallExpressionImpl <em>Property Call Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.PropertyCallExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getPropertyCallExpression()
     * @generated
     */
    EClass PROPERTY_CALL_EXPRESSION = eINSTANCE.getPropertyCallExpression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CALL_EXPRESSION__PROPERTY = eINSTANCE.getPropertyCallExpression_Property();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl <em>Operation Call Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getOperationCallExpression()
     * @generated
     */
    EClass OPERATION_CALL_EXPRESSION = eINSTANCE.getOperationCallExpression();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL_EXPRESSION__OPERATION = eINSTANCE.getOperationCallExpression_Operation();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL_EXPRESSION__ARGUMENTS = eINSTANCE.getOperationCallExpression_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.LiteralImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl <em>Name Or Choice Or Behavior Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNameOrChoiceOrBehaviorCall()
     * @generated
     */
    EClass NAME_OR_CHOICE_OR_BEHAVIOR_CALL = eINSTANCE.getNameOrChoiceOrBehaviorCall();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH = eINSTANCE.getNameOrChoiceOrBehaviorCall_Path();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID = eINSTANCE.getNameOrChoiceOrBehaviorCall_Id();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS = eINSTANCE.getNameOrChoiceOrBehaviorCall_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.QualifiedNameImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getQualifiedName()
     * @generated
     */
    EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAME__PATH = eINSTANCE.getQualifiedName_Path();

    /**
     * The meta object literal for the '<em><b>Remaining</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAME__REMAINING = eINSTANCE.getQualifiedName_Remaining();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl <em>Interval</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.IntervalImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInterval()
     * @generated
     */
    EClass INTERVAL = eINSTANCE.getInterval();

    /**
     * The meta object literal for the '<em><b>Is Lower Included</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__IS_LOWER_INCLUDED = eINSTANCE.getInterval_IsLowerIncluded();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__LOWER = eINSTANCE.getInterval_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__UPPER = eINSTANCE.getInterval_Upper();

    /**
     * The meta object literal for the '<em><b>Is Upper Included</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__IS_UPPER_INCLUDED = eINSTANCE.getInterval_IsUpperIncluded();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.CollectionOrTupleImpl <em>Collection Or Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.CollectionOrTupleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getCollectionOrTuple()
     * @generated
     */
    EClass COLLECTION_OR_TUPLE = eINSTANCE.getCollectionOrTuple();

    /**
     * The meta object literal for the '<em><b>List Of Values</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_OR_TUPLE__LIST_OF_VALUES = eINSTANCE.getCollectionOrTuple_ListOfValues();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.TupleImpl <em>Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.TupleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getTuple()
     * @generated
     */
    EClass TUPLE = eINSTANCE.getTuple();

    /**
     * The meta object literal for the '<em><b>List Of Value Name Pairs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE__LIST_OF_VALUE_NAME_PAIRS = eINSTANCE.getTuple_ListOfValueNamePairs();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValuesImpl <em>List Of Values</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValuesImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getListOfValues()
     * @generated
     */
    EClass LIST_OF_VALUES = eINSTANCE.getListOfValues();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_OF_VALUES__VALUES = eINSTANCE.getListOfValues_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValueNamePairsImpl <em>List Of Value Name Pairs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ListOfValueNamePairsImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getListOfValueNamePairs()
     * @generated
     */
    EClass LIST_OF_VALUE_NAME_PAIRS = eINSTANCE.getListOfValueNamePairs();

    /**
     * The meta object literal for the '<em><b>Value Name Pairs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS = eINSTANCE.getListOfValueNamePairs_ValueNamePairs();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.ValueNamePairImpl <em>Value Name Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.ValueNamePairImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getValueNamePair()
     * @generated
     */
    EClass VALUE_NAME_PAIR = eINSTANCE.getValueNamePair();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_NAME_PAIR__PROPERTY = eINSTANCE.getValueNamePair_Property();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_NAME_PAIR__VALUE = eINSTANCE.getValueNamePair_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.TimeExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getTimeExpression()
     * @generated
     */
    EClass TIME_EXPRESSION = eINSTANCE.getTimeExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsExpressionImpl <em>Instant Obs Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInstantObsExpression()
     * @generated
     */
    EClass INSTANT_OBS_EXPRESSION = eINSTANCE.getInstantObsExpression();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANT_OBS_EXPRESSION__ID = eINSTANCE.getInstantObsExpression_Id();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANT_OBS_EXPRESSION__INDEX = eINSTANCE.getInstantObsExpression_Index();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANT_OBS_EXPRESSION__CONDITION = eINSTANCE.getInstantObsExpression_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl <em>Instant Obs Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getInstantObsName()
     * @generated
     */
    EClass INSTANT_OBS_NAME = eINSTANCE.getInstantObsName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANT_OBS_NAME__PATH = eINSTANCE.getInstantObsName_Path();

    /**
     * The meta object literal for the '<em><b>Instant Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANT_OBS_NAME__INSTANT_ID = eINSTANCE.getInstantObsName_InstantId();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsExpressionImpl <em>Duration Obs Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsExpressionImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDurationObsExpression()
     * @generated
     */
    EClass DURATION_OBS_EXPRESSION = eINSTANCE.getDurationObsExpression();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DURATION_OBS_EXPRESSION__ID = eINSTANCE.getDurationObsExpression_Id();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DURATION_OBS_EXPRESSION__INDEX = eINSTANCE.getDurationObsExpression_Index();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DURATION_OBS_EXPRESSION__CONDITION = eINSTANCE.getDurationObsExpression_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsNameImpl <em>Duration Obs Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DurationObsNameImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDurationObsName()
     * @generated
     */
    EClass DURATION_OBS_NAME = eINSTANCE.getDurationObsName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DURATION_OBS_NAME__PATH = eINSTANCE.getDurationObsName_Path();

    /**
     * The meta object literal for the '<em><b>Duration Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DURATION_OBS_NAME__DURATION_ID = eINSTANCE.getDurationObsName_DurationId();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl <em>Jitter Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.JitterExpImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getJitterExp()
     * @generated
     */
    EClass JITTER_EXP = eINSTANCE.getJitterExp();

    /**
     * The meta object literal for the '<em><b>First Instant</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JITTER_EXP__FIRST_INSTANT = eINSTANCE.getJitterExp_FirstInstant();

    /**
     * The meta object literal for the '<em><b>Second Instant</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JITTER_EXP__SECOND_INSTANT = eINSTANCE.getJitterExp_SecondInstant();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getVariableDeclaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Variable Declaration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration_VariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Init Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__INIT_VALUE = eINSTANCE.getVariableDeclaration_InitValue();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DataTypeNameImpl <em>Data Type Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DataTypeNameImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDataTypeName()
     * @generated
     */
    EClass DATA_TYPE_NAME = eINSTANCE.getDataTypeName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE_NAME__PATH = eINSTANCE.getDataTypeName_Path();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE_NAME__TYPE = eINSTANCE.getDataTypeName_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NumberLiteralRuleImpl <em>Number Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NumberLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNumberLiteralRule()
     * @generated
     */
    EClass NUMBER_LITERAL_RULE = eINSTANCE.getNumberLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.IntegerLiteralRuleImpl <em>Integer Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.IntegerLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getIntegerLiteralRule()
     * @generated
     */
    EClass INTEGER_LITERAL_RULE = eINSTANCE.getIntegerLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnlimitedLiteralRuleImpl <em>Unlimited Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.UnlimitedLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getUnlimitedLiteralRule()
     * @generated
     */
    EClass UNLIMITED_LITERAL_RULE = eINSTANCE.getUnlimitedLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.RealLiteralRuleImpl <em>Real Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.RealLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getRealLiteralRule()
     * @generated
     */
    EClass REAL_LITERAL_RULE = eINSTANCE.getRealLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DateTimeLiteralRuleImpl <em>Date Time Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DateTimeLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDateTimeLiteralRule()
     * @generated
     */
    EClass DATE_TIME_LITERAL_RULE = eINSTANCE.getDateTimeLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.BooleanLiteralRuleImpl <em>Boolean Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.BooleanLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getBooleanLiteralRule()
     * @generated
     */
    EClass BOOLEAN_LITERAL_RULE = eINSTANCE.getBooleanLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NullLiteralRuleImpl <em>Null Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.NullLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getNullLiteralRule()
     * @generated
     */
    EClass NULL_LITERAL_RULE = eINSTANCE.getNullLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.DefaultLiteralRuleImpl <em>Default Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.DefaultLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getDefaultLiteralRule()
     * @generated
     */
    EClass DEFAULT_LITERAL_RULE = eINSTANCE.getDefaultLiteralRule();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.marte.vsl.vSL.impl.StringLiteralRuleImpl <em>String Literal Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.StringLiteralRuleImpl
     * @see org.eclipse.papyrus.marte.vsl.vSL.impl.VSLPackageImpl#getStringLiteralRule()
     * @generated
     */
    EClass STRING_LITERAL_RULE = eINSTANCE.getStringLiteralRule();

  }

} //VSLPackage
