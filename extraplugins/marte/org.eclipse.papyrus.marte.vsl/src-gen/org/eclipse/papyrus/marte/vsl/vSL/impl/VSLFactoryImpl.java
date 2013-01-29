/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.marte.vsl.vSL.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VSLFactoryImpl extends EFactoryImpl implements VSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VSLFactory init()
  {
    try
    {
      VSLFactory theVSLFactory = (VSLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/marte/vsl/VSL"); 
      if (theVSLFactory != null)
      {
        return theVSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new VSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VSLFactoryImpl()
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
      case VSLPackage.EXPRESSION: return createExpression();
      case VSLPackage.AND_OR_XOR_EXPRESSION: return createAndOrXorExpression();
      case VSLPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case VSLPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case VSLPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case VSLPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case VSLPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case VSLPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case VSLPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case VSLPackage.VALUE_SPECIFICATION: return createValueSpecification();
      case VSLPackage.SUFFIX_EXPRESSION: return createSuffixExpression();
      case VSLPackage.PROPERTY_CALL_EXPRESSION: return createPropertyCallExpression();
      case VSLPackage.OPERATION_CALL_EXPRESSION: return createOperationCallExpression();
      case VSLPackage.LITERAL: return createLiteral();
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL: return createNameOrChoiceOrBehaviorCall();
      case VSLPackage.QUALIFIED_NAME: return createQualifiedName();
      case VSLPackage.INTERVAL: return createInterval();
      case VSLPackage.COLLECTION_OR_TUPLE: return createCollectionOrTuple();
      case VSLPackage.TUPLE: return createTuple();
      case VSLPackage.LIST_OF_VALUES: return createListOfValues();
      case VSLPackage.LIST_OF_VALUE_NAME_PAIRS: return createListOfValueNamePairs();
      case VSLPackage.VALUE_NAME_PAIR: return createValueNamePair();
      case VSLPackage.TIME_EXPRESSION: return createTimeExpression();
      case VSLPackage.INSTANT_OBS_EXPRESSION: return createInstantObsExpression();
      case VSLPackage.INSTANT_OBS_NAME: return createInstantObsName();
      case VSLPackage.DURATION_OBS_EXPRESSION: return createDurationObsExpression();
      case VSLPackage.DURATION_OBS_NAME: return createDurationObsName();
      case VSLPackage.JITTER_EXP: return createJitterExp();
      case VSLPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case VSLPackage.DATA_TYPE_NAME: return createDataTypeName();
      case VSLPackage.NUMBER_LITERAL_RULE: return createNumberLiteralRule();
      case VSLPackage.INTEGER_LITERAL_RULE: return createIntegerLiteralRule();
      case VSLPackage.UNLIMITED_LITERAL_RULE: return createUnlimitedLiteralRule();
      case VSLPackage.REAL_LITERAL_RULE: return createRealLiteralRule();
      case VSLPackage.DATE_TIME_LITERAL_RULE: return createDateTimeLiteralRule();
      case VSLPackage.BOOLEAN_LITERAL_RULE: return createBooleanLiteralRule();
      case VSLPackage.NULL_LITERAL_RULE: return createNullLiteralRule();
      case VSLPackage.DEFAULT_LITERAL_RULE: return createDefaultLiteralRule();
      case VSLPackage.STRING_LITERAL_RULE: return createStringLiteralRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public AndOrXorExpression createAndOrXorExpression()
  {
    AndOrXorExpressionImpl andOrXorExpression = new AndOrXorExpressionImpl();
    return andOrXorExpression;
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
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
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
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameOrChoiceOrBehaviorCall createNameOrChoiceOrBehaviorCall()
  {
    NameOrChoiceOrBehaviorCallImpl nameOrChoiceOrBehaviorCall = new NameOrChoiceOrBehaviorCallImpl();
    return nameOrChoiceOrBehaviorCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName createQualifiedName()
  {
    QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interval createInterval()
  {
    IntervalImpl interval = new IntervalImpl();
    return interval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionOrTuple createCollectionOrTuple()
  {
    CollectionOrTupleImpl collectionOrTuple = new CollectionOrTupleImpl();
    return collectionOrTuple;
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
  public ListOfValues createListOfValues()
  {
    ListOfValuesImpl listOfValues = new ListOfValuesImpl();
    return listOfValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValueNamePairs createListOfValueNamePairs()
  {
    ListOfValueNamePairsImpl listOfValueNamePairs = new ListOfValueNamePairsImpl();
    return listOfValueNamePairs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueNamePair createValueNamePair()
  {
    ValueNamePairImpl valueNamePair = new ValueNamePairImpl();
    return valueNamePair;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeExpression createTimeExpression()
  {
    TimeExpressionImpl timeExpression = new TimeExpressionImpl();
    return timeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstantObsExpression createInstantObsExpression()
  {
    InstantObsExpressionImpl instantObsExpression = new InstantObsExpressionImpl();
    return instantObsExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstantObsName createInstantObsName()
  {
    InstantObsNameImpl instantObsName = new InstantObsNameImpl();
    return instantObsName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DurationObsExpression createDurationObsExpression()
  {
    DurationObsExpressionImpl durationObsExpression = new DurationObsExpressionImpl();
    return durationObsExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DurationObsName createDurationObsName()
  {
    DurationObsNameImpl durationObsName = new DurationObsNameImpl();
    return durationObsName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JitterExp createJitterExp()
  {
    JitterExpImpl jitterExp = new JitterExpImpl();
    return jitterExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration createVariableDeclaration()
  {
    VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeName createDataTypeName()
  {
    DataTypeNameImpl dataTypeName = new DataTypeNameImpl();
    return dataTypeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteralRule createNumberLiteralRule()
  {
    NumberLiteralRuleImpl numberLiteralRule = new NumberLiteralRuleImpl();
    return numberLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerLiteralRule createIntegerLiteralRule()
  {
    IntegerLiteralRuleImpl integerLiteralRule = new IntegerLiteralRuleImpl();
    return integerLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnlimitedLiteralRule createUnlimitedLiteralRule()
  {
    UnlimitedLiteralRuleImpl unlimitedLiteralRule = new UnlimitedLiteralRuleImpl();
    return unlimitedLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteralRule createRealLiteralRule()
  {
    RealLiteralRuleImpl realLiteralRule = new RealLiteralRuleImpl();
    return realLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateTimeLiteralRule createDateTimeLiteralRule()
  {
    DateTimeLiteralRuleImpl dateTimeLiteralRule = new DateTimeLiteralRuleImpl();
    return dateTimeLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteralRule createBooleanLiteralRule()
  {
    BooleanLiteralRuleImpl booleanLiteralRule = new BooleanLiteralRuleImpl();
    return booleanLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullLiteralRule createNullLiteralRule()
  {
    NullLiteralRuleImpl nullLiteralRule = new NullLiteralRuleImpl();
    return nullLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefaultLiteralRule createDefaultLiteralRule()
  {
    DefaultLiteralRuleImpl defaultLiteralRule = new DefaultLiteralRuleImpl();
    return defaultLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralRule createStringLiteralRule()
  {
    StringLiteralRuleImpl stringLiteralRule = new StringLiteralRuleImpl();
    return stringLiteralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VSLPackage getVSLPackage()
  {
    return (VSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static VSLPackage getPackage()
  {
    return VSLPackage.eINSTANCE;
  }

} //VSLFactoryImpl
