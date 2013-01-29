/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression;
import org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DataTypeName;
import org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsName;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.JitterExp;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.Literal;
import org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.NumberLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression;
import org.eclipse.papyrus.marte.vsl.vSL.TimeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.VSLFactory;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class VSLPackageImpl extends EPackageImpl implements VSLPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass andOrXorExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass equalityExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass relationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass conditionalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass additiveExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass multiplicativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass primaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass valueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass suffixExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyCallExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationCallExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nameOrChoiceOrBehaviorCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass intervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collectionOrTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass tupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass listOfValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass listOfValueNamePairsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass valueNamePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass instantObsExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass instantObsNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass durationObsExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass durationObsNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jitterExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dataTypeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass numberLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass integerLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass unlimitedLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass realLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dateTimeLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass booleanLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nullLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultLiteralRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringLiteralRuleEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VSLPackageImpl() {
		super(eNS_URI, VSLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link VSLPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VSLPackage init() {
		if(isInited) {
			return (VSLPackage)EPackage.Registry.INSTANCE.getEPackage(VSLPackage.eNS_URI);
		}

		// Obtain or create and register package
		VSLPackageImpl theVSLPackage = (VSLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VSLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VSLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVSLPackage.createPackageContents();

		// Initialize created meta-data
		theVSLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVSLPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VSLPackage.eNS_URI, theVSLPackage);
		return theVSLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExpression_Exp() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAndOrXorExpression() {
		return andOrXorExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAndOrXorExpression_Exp() {
		return (EReference)andOrXorExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAndOrXorExpression_Op() {
		return (EAttribute)andOrXorExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEqualityExpression() {
		return equalityExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEqualityExpression_Exp() {
		return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEqualityExpression_Op() {
		return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRelationalExpression() {
		return relationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRelationalExpression_Exp() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRelationalExpression_Op() {
		return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConditionalExpression() {
		return conditionalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConditionalExpression_Exp() {
		return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConditionalExpression_Op() {
		return (EAttribute)conditionalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAdditiveExpression() {
		return additiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAdditiveExpression_Exp() {
		return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAdditiveExpression_Op() {
		return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMultiplicativeExpression() {
		return multiplicativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiplicativeExpression_Exp() {
		return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMultiplicativeExpression_Op() {
		return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUnaryExpression_Op() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUnaryExpression_Unary() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUnaryExpression_Exp() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPrimaryExpression() {
		return primaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPrimaryExpression_Prefix() {
		return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPrimaryExpression_Suffix() {
		return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getValueSpecification() {
		return valueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSuffixExpression() {
		return suffixExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSuffixExpression_Suffix() {
		return (EReference)suffixExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyCallExpression() {
		return propertyCallExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyCallExpression_Property() {
		return (EReference)propertyCallExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationCallExpression() {
		return operationCallExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationCallExpression_Operation() {
		return (EReference)operationCallExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationCallExpression_Arguments() {
		return (EReference)operationCallExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteral_Value() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNameOrChoiceOrBehaviorCall() {
		return nameOrChoiceOrBehaviorCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNameOrChoiceOrBehaviorCall_Path() {
		return (EReference)nameOrChoiceOrBehaviorCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNameOrChoiceOrBehaviorCall_Id() {
		return (EReference)nameOrChoiceOrBehaviorCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNameOrChoiceOrBehaviorCall_Arguments() {
		return (EReference)nameOrChoiceOrBehaviorCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getQualifiedName() {
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Path() {
		return (EReference)qualifiedNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Remaining() {
		return (EReference)qualifiedNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInterval() {
		return intervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getInterval_IsLowerIncluded() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInterval_Lower() {
		return (EReference)intervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInterval_Upper() {
		return (EReference)intervalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getInterval_IsUpperIncluded() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollectionOrTuple() {
		return collectionOrTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionOrTuple_ListOfValues() {
		return (EReference)collectionOrTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTuple() {
		return tupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTuple_ListOfValueNamePairs() {
		return (EReference)tupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getListOfValues() {
		return listOfValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getListOfValues_Values() {
		return (EReference)listOfValuesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getListOfValueNamePairs() {
		return listOfValueNamePairsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getListOfValueNamePairs_ValueNamePairs() {
		return (EReference)listOfValueNamePairsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getValueNamePair() {
		return valueNamePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getValueNamePair_Property() {
		return (EReference)valueNamePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getValueNamePair_Value() {
		return (EReference)valueNamePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeExpression() {
		return timeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInstantObsExpression() {
		return instantObsExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstantObsExpression_Id() {
		return (EReference)instantObsExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstantObsExpression_Index() {
		return (EReference)instantObsExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstantObsExpression_Condition() {
		return (EReference)instantObsExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInstantObsName() {
		return instantObsNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstantObsName_Path() {
		return (EReference)instantObsNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstantObsName_InstantId() {
		return (EReference)instantObsNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDurationObsExpression() {
		return durationObsExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDurationObsExpression_Id() {
		return (EReference)durationObsExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDurationObsExpression_Index() {
		return (EReference)durationObsExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDurationObsExpression_Condition() {
		return (EReference)durationObsExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDurationObsName() {
		return durationObsNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDurationObsName_Path() {
		return (EReference)durationObsNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDurationObsName_DurationId() {
		return (EReference)durationObsNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJitterExp() {
		return jitterExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJitterExp_FirstInstant() {
		return (EReference)jitterExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJitterExp_SecondInstant() {
		return (EReference)jitterExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVariableDeclaration_VariableDeclaration() {
		return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVariableDeclaration_Name() {
		return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_Type() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_InitValue() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDataTypeName() {
		return dataTypeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDataTypeName_Path() {
		return (EReference)dataTypeNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDataTypeName_Type() {
		return (EReference)dataTypeNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNumberLiteralRule() {
		return numberLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIntegerLiteralRule() {
		return integerLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUnlimitedLiteralRule() {
		return unlimitedLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRealLiteralRule() {
		return realLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDateTimeLiteralRule() {
		return dateTimeLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBooleanLiteralRule() {
		return booleanLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNullLiteralRule() {
		return nullLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefaultLiteralRule() {
		return defaultLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStringLiteralRule() {
		return stringLiteralRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VSLFactory getVSLFactory() {
		return (VSLFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		expressionEClass = createEClass(EXPRESSION);
		createEReference(expressionEClass, EXPRESSION__EXP);

		andOrXorExpressionEClass = createEClass(AND_OR_XOR_EXPRESSION);
		createEReference(andOrXorExpressionEClass, AND_OR_XOR_EXPRESSION__EXP);
		createEAttribute(andOrXorExpressionEClass, AND_OR_XOR_EXPRESSION__OP);

		equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
		createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__EXP);
		createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OP);

		relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__EXP);
		createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OP);

		conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
		createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__EXP);
		createEAttribute(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__OP);

		additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
		createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__EXP);
		createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OP);

		multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
		createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__EXP);
		createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OP);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OP);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__UNARY);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__EXP);

		primaryExpressionEClass = createEClass(PRIMARY_EXPRESSION);
		createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__PREFIX);
		createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__SUFFIX);

		valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);

		suffixExpressionEClass = createEClass(SUFFIX_EXPRESSION);
		createEReference(suffixExpressionEClass, SUFFIX_EXPRESSION__SUFFIX);

		propertyCallExpressionEClass = createEClass(PROPERTY_CALL_EXPRESSION);
		createEReference(propertyCallExpressionEClass, PROPERTY_CALL_EXPRESSION__PROPERTY);

		operationCallExpressionEClass = createEClass(OPERATION_CALL_EXPRESSION);
		createEReference(operationCallExpressionEClass, OPERATION_CALL_EXPRESSION__OPERATION);
		createEReference(operationCallExpressionEClass, OPERATION_CALL_EXPRESSION__ARGUMENTS);

		literalEClass = createEClass(LITERAL);
		createEAttribute(literalEClass, LITERAL__VALUE);

		nameOrChoiceOrBehaviorCallEClass = createEClass(NAME_OR_CHOICE_OR_BEHAVIOR_CALL);
		createEReference(nameOrChoiceOrBehaviorCallEClass, NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH);
		createEReference(nameOrChoiceOrBehaviorCallEClass, NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID);
		createEReference(nameOrChoiceOrBehaviorCallEClass, NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS);

		qualifiedNameEClass = createEClass(QUALIFIED_NAME);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__PATH);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__REMAINING);

		intervalEClass = createEClass(INTERVAL);
		createEAttribute(intervalEClass, INTERVAL__IS_LOWER_INCLUDED);
		createEReference(intervalEClass, INTERVAL__LOWER);
		createEReference(intervalEClass, INTERVAL__UPPER);
		createEAttribute(intervalEClass, INTERVAL__IS_UPPER_INCLUDED);

		collectionOrTupleEClass = createEClass(COLLECTION_OR_TUPLE);
		createEReference(collectionOrTupleEClass, COLLECTION_OR_TUPLE__LIST_OF_VALUES);

		tupleEClass = createEClass(TUPLE);
		createEReference(tupleEClass, TUPLE__LIST_OF_VALUE_NAME_PAIRS);

		listOfValuesEClass = createEClass(LIST_OF_VALUES);
		createEReference(listOfValuesEClass, LIST_OF_VALUES__VALUES);

		listOfValueNamePairsEClass = createEClass(LIST_OF_VALUE_NAME_PAIRS);
		createEReference(listOfValueNamePairsEClass, LIST_OF_VALUE_NAME_PAIRS__VALUE_NAME_PAIRS);

		valueNamePairEClass = createEClass(VALUE_NAME_PAIR);
		createEReference(valueNamePairEClass, VALUE_NAME_PAIR__PROPERTY);
		createEReference(valueNamePairEClass, VALUE_NAME_PAIR__VALUE);

		timeExpressionEClass = createEClass(TIME_EXPRESSION);

		instantObsExpressionEClass = createEClass(INSTANT_OBS_EXPRESSION);
		createEReference(instantObsExpressionEClass, INSTANT_OBS_EXPRESSION__ID);
		createEReference(instantObsExpressionEClass, INSTANT_OBS_EXPRESSION__INDEX);
		createEReference(instantObsExpressionEClass, INSTANT_OBS_EXPRESSION__CONDITION);

		instantObsNameEClass = createEClass(INSTANT_OBS_NAME);
		createEReference(instantObsNameEClass, INSTANT_OBS_NAME__PATH);
		createEReference(instantObsNameEClass, INSTANT_OBS_NAME__INSTANT_ID);

		durationObsExpressionEClass = createEClass(DURATION_OBS_EXPRESSION);
		createEReference(durationObsExpressionEClass, DURATION_OBS_EXPRESSION__ID);
		createEReference(durationObsExpressionEClass, DURATION_OBS_EXPRESSION__INDEX);
		createEReference(durationObsExpressionEClass, DURATION_OBS_EXPRESSION__CONDITION);

		durationObsNameEClass = createEClass(DURATION_OBS_NAME);
		createEReference(durationObsNameEClass, DURATION_OBS_NAME__PATH);
		createEReference(durationObsNameEClass, DURATION_OBS_NAME__DURATION_ID);

		jitterExpEClass = createEClass(JITTER_EXP);
		createEReference(jitterExpEClass, JITTER_EXP__FIRST_INSTANT);
		createEReference(jitterExpEClass, JITTER_EXP__SECOND_INSTANT);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INIT_VALUE);

		dataTypeNameEClass = createEClass(DATA_TYPE_NAME);
		createEReference(dataTypeNameEClass, DATA_TYPE_NAME__PATH);
		createEReference(dataTypeNameEClass, DATA_TYPE_NAME__TYPE);

		numberLiteralRuleEClass = createEClass(NUMBER_LITERAL_RULE);

		integerLiteralRuleEClass = createEClass(INTEGER_LITERAL_RULE);

		unlimitedLiteralRuleEClass = createEClass(UNLIMITED_LITERAL_RULE);

		realLiteralRuleEClass = createEClass(REAL_LITERAL_RULE);

		dateTimeLiteralRuleEClass = createEClass(DATE_TIME_LITERAL_RULE);

		booleanLiteralRuleEClass = createEClass(BOOLEAN_LITERAL_RULE);

		nullLiteralRuleEClass = createEClass(NULL_LITERAL_RULE);

		defaultLiteralRuleEClass = createEClass(DEFAULT_LITERAL_RULE);

		stringLiteralRuleEClass = createEClass(STRING_LITERAL_RULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		expressionEClass.getESuperTypes().add(this.getValueSpecification());
		propertyCallExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
		operationCallExpressionEClass.getESuperTypes().add(this.getSuffixExpression());
		literalEClass.getESuperTypes().add(this.getValueSpecification());
		nameOrChoiceOrBehaviorCallEClass.getESuperTypes().add(this.getValueSpecification());
		intervalEClass.getESuperTypes().add(this.getValueSpecification());
		collectionOrTupleEClass.getESuperTypes().add(this.getValueSpecification());
		tupleEClass.getESuperTypes().add(this.getValueSpecification());
		timeExpressionEClass.getESuperTypes().add(this.getValueSpecification());
		instantObsExpressionEClass.getESuperTypes().add(this.getTimeExpression());
		durationObsExpressionEClass.getESuperTypes().add(this.getTimeExpression());
		jitterExpEClass.getESuperTypes().add(this.getTimeExpression());
		variableDeclarationEClass.getESuperTypes().add(this.getValueSpecification());
		numberLiteralRuleEClass.getESuperTypes().add(this.getLiteral());
		integerLiteralRuleEClass.getESuperTypes().add(this.getNumberLiteralRule());
		unlimitedLiteralRuleEClass.getESuperTypes().add(this.getNumberLiteralRule());
		realLiteralRuleEClass.getESuperTypes().add(this.getNumberLiteralRule());
		dateTimeLiteralRuleEClass.getESuperTypes().add(this.getLiteral());
		booleanLiteralRuleEClass.getESuperTypes().add(this.getLiteral());
		nullLiteralRuleEClass.getESuperTypes().add(this.getLiteral());
		defaultLiteralRuleEClass.getESuperTypes().add(this.getLiteral());
		stringLiteralRuleEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes and features; add operations and parameters
		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpression_Exp(), this.getAndOrXorExpression(), null, "exp", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(expressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(andOrXorExpressionEClass, AndOrXorExpression.class, "AndOrXorExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndOrXorExpression_Exp(), this.getEqualityExpression(), null, "exp", null, 0, -1, AndOrXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAndOrXorExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, AndOrXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(andOrXorExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(andOrXorExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(andOrXorExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEqualityExpression_Exp(), this.getRelationalExpression(), null, "exp", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEqualityExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(equalityExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(equalityExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(equalityExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalExpression_Exp(), this.getConditionalExpression(), null, "exp", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationalExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationalExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(relationalExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(relationalExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalExpression_Exp(), this.getAdditiveExpression(), null, "exp", null, 0, -1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(conditionalExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(conditionalExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(conditionalExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdditiveExpression_Exp(), this.getMultiplicativeExpression(), null, "exp", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdditiveExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(additiveExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(additiveExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(additiveExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicativeExpression_Exp(), this.getUnaryExpression(), null, "exp", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicativeExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(multiplicativeExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(multiplicativeExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(multiplicativeExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_Op(), theEcorePackage.getEString(), "op", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Unary(), this.getUnaryExpression(), null, "unary", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Exp(), this.getPrimaryExpression(), null, "exp", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(unaryExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(unaryExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(unaryExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primaryExpressionEClass, PrimaryExpression.class, "PrimaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimaryExpression_Prefix(), this.getValueSpecification(), null, "prefix", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(primaryExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(primaryExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(primaryExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(valueSpecificationEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(valueSpecificationEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(valueSpecificationEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(suffixExpressionEClass, SuffixExpression.class, "SuffixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuffixExpression_Suffix(), this.getSuffixExpression(), null, "suffix", null, 0, 1, SuffixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(suffixExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(suffixExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(suffixExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyCallExpressionEClass, PropertyCallExpression.class, "PropertyCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyCallExpression_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, PropertyCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyCallExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(propertyCallExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(propertyCallExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operationCallExpressionEClass, OperationCallExpression.class, "OperationCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCallExpression_Operation(), theUMLPackage.getOperation(), null, "operation", null, 0, 1, OperationCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCallExpression_Arguments(), this.getListOfValues(), null, "arguments", null, 0, 1, OperationCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(operationCallExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(operationCallExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(operationCallExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(literalEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(literalEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(literalEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nameOrChoiceOrBehaviorCallEClass, NameOrChoiceOrBehaviorCall.class, "NameOrChoiceOrBehaviorCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNameOrChoiceOrBehaviorCall_Path(), this.getQualifiedName(), null, "path", null, 0, 1, NameOrChoiceOrBehaviorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNameOrChoiceOrBehaviorCall_Id(), theUMLPackage.getNamedElement(), null, "id", null, 0, 1, NameOrChoiceOrBehaviorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNameOrChoiceOrBehaviorCall_Arguments(), this.getListOfValues(), null, "arguments", null, 0, 1, NameOrChoiceOrBehaviorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(nameOrChoiceOrBehaviorCallEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nameOrChoiceOrBehaviorCallEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nameOrChoiceOrBehaviorCallEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedName_Path(), theUMLPackage.getNamespace(), null, "path", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedName_Remaining(), this.getQualifiedName(), null, "remaining", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(qualifiedNameEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(qualifiedNameEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(qualifiedNameEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(intervalEClass, Interval.class, "Interval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterval_IsLowerIncluded(), theEcorePackage.getEString(), "isLowerIncluded", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterval_Lower(), this.getExpression(), null, "lower", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterval_Upper(), this.getExpression(), null, "upper", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_IsUpperIncluded(), theEcorePackage.getEString(), "isUpperIncluded", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(intervalEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(intervalEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(intervalEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(collectionOrTupleEClass, CollectionOrTuple.class, "CollectionOrTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionOrTuple_ListOfValues(), this.getListOfValues(), null, "listOfValues", null, 0, 1, CollectionOrTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionOrTupleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(collectionOrTupleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(collectionOrTupleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tupleEClass, Tuple.class, "Tuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTuple_ListOfValueNamePairs(), this.getListOfValueNamePairs(), null, "listOfValueNamePairs", null, 0, 1, Tuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tupleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(tupleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(tupleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(listOfValuesEClass, ListOfValues.class, "ListOfValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListOfValues_Values(), this.getExpression(), null, "values", null, 0, -1, ListOfValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(listOfValuesEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(listOfValuesEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(listOfValuesEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(listOfValueNamePairsEClass, ListOfValueNamePairs.class, "ListOfValueNamePairs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListOfValueNamePairs_ValueNamePairs(), this.getValueNamePair(), null, "valueNamePairs", null, 0, -1, ListOfValueNamePairs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(listOfValueNamePairsEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(listOfValueNamePairsEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(listOfValueNamePairsEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueNamePairEClass, ValueNamePair.class, "ValueNamePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueNamePair_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, ValueNamePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValueNamePair_Value(), this.getExpression(), null, "value", null, 0, 1, ValueNamePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(valueNamePairEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(valueNamePairEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(valueNamePairEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(timeExpressionEClass, TimeExpression.class, "TimeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(timeExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(timeExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(timeExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instantObsExpressionEClass, InstantObsExpression.class, "InstantObsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantObsExpression_Id(), this.getInstantObsName(), null, "id", null, 0, 1, InstantObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantObsExpression_Index(), this.getExpression(), null, "index", null, 0, 1, InstantObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantObsExpression_Condition(), this.getExpression(), null, "condition", null, 0, 1, InstantObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(instantObsExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(instantObsExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(instantObsExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instantObsNameEClass, InstantObsName.class, "InstantObsName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantObsName_Path(), this.getQualifiedName(), null, "path", null, 0, 1, InstantObsName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantObsName_InstantId(), theUMLPackage.getTimeObservation(), null, "instantId", null, 0, 1, InstantObsName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(instantObsNameEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(instantObsNameEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(instantObsNameEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(durationObsExpressionEClass, DurationObsExpression.class, "DurationObsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDurationObsExpression_Id(), this.getDurationObsName(), null, "id", null, 0, 1, DurationObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDurationObsExpression_Index(), this.getExpression(), null, "index", null, 0, 1, DurationObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDurationObsExpression_Condition(), this.getExpression(), null, "condition", null, 0, 1, DurationObsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(durationObsExpressionEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(durationObsExpressionEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(durationObsExpressionEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(durationObsNameEClass, DurationObsName.class, "DurationObsName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDurationObsName_Path(), this.getQualifiedName(), null, "path", null, 0, 1, DurationObsName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDurationObsName_DurationId(), theUMLPackage.getDurationObservation(), null, "durationId", null, 0, 1, DurationObsName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(durationObsNameEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(durationObsNameEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(durationObsNameEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jitterExpEClass, JitterExp.class, "JitterExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJitterExp_FirstInstant(), this.getInstantObsExpression(), null, "firstInstant", null, 0, 1, JitterExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJitterExp_SecondInstant(), this.getInstantObsExpression(), null, "secondInstant", null, 0, 1, JitterExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jitterExpEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jitterExpEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jitterExpEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclaration_VariableDeclaration(), theEcorePackage.getEString(), "variableDeclaration", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_Type(), this.getDataTypeName(), null, "type", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_InitValue(), this.getExpression(), null, "initValue", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDeclarationEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDeclarationEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDeclarationEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataTypeNameEClass, DataTypeName.class, "DataTypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeName_Path(), this.getQualifiedName(), null, "path", null, 0, 1, DataTypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTypeName_Type(), theUMLPackage.getDataType(), null, "type", null, 0, 1, DataTypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dataTypeNameEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeNameEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeNameEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(numberLiteralRuleEClass, NumberLiteralRule.class, "NumberLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(numberLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(numberLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(numberLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(integerLiteralRuleEClass, IntegerLiteralRule.class, "IntegerLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(integerLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(integerLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(integerLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unlimitedLiteralRuleEClass, UnlimitedLiteralRule.class, "UnlimitedLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(unlimitedLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(unlimitedLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(unlimitedLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(realLiteralRuleEClass, RealLiteralRule.class, "RealLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(realLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(realLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(realLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dateTimeLiteralRuleEClass, DateTimeLiteralRule.class, "DateTimeLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(dateTimeLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dateTimeLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dateTimeLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(booleanLiteralRuleEClass, BooleanLiteralRule.class, "BooleanLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(booleanLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(booleanLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(booleanLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nullLiteralRuleEClass, NullLiteralRule.class, "NullLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(nullLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nullLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nullLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(defaultLiteralRuleEClass, DefaultLiteralRule.class, "DefaultLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(defaultLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(defaultLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(defaultLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stringLiteralRuleEClass, StringLiteralRule.class, "StringLiteralRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(stringLiteralRuleEClass, theEcorePackage.getEObject(), "getFilteredParentRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(stringLiteralRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(stringLiteralRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VSLPackageImpl
