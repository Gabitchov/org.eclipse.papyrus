/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRuleFactory;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusDSMLValidationRulePackageImpl extends EPackageImpl implements PapyrusDSMLValidationRulePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum severityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusDSMLValidationRulePackageImpl() {
		super(eNS_URI, PapyrusDSMLValidationRuleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PapyrusDSMLValidationRulePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrusDSMLValidationRulePackage init() {
		if (isInited) return (PapyrusDSMLValidationRulePackage)EPackage.Registry.INSTANCE.getEPackage(PapyrusDSMLValidationRulePackage.eNS_URI);

		// Obtain or create and register package
		PapyrusDSMLValidationRulePackageImpl thePapyrusDSMLValidationRulePackage = (PapyrusDSMLValidationRulePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrusDSMLValidationRulePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrusDSMLValidationRulePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusDSMLValidationRulePackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusDSMLValidationRulePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusDSMLValidationRulePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrusDSMLValidationRulePackage.eNS_URI, thePapyrusDSMLValidationRulePackage);
		return thePapyrusDSMLValidationRulePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidationRule() {
		return validationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Severity() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Mode() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_IsEnabledByDefault() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidationRule_Base_Constraint() {
		return (EReference)validationRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_StatusCode() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Message() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Description() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Target() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Class() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidationRule_Id() {
		return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSeverity() {
		return severityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMode() {
		return modeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusDSMLValidationRuleFactory getPapyrusDSMLValidationRuleFactory() {
		return (PapyrusDSMLValidationRuleFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		validationRuleEClass = createEClass(VALIDATION_RULE);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__SEVERITY);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__MODE);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__IS_ENABLED_BY_DEFAULT);
		createEReference(validationRuleEClass, VALIDATION_RULE__BASE_CONSTRAINT);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__STATUS_CODE);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__MESSAGE);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__DESCRIPTION);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__TARGET);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__CLASS);
		createEAttribute(validationRuleEClass, VALIDATION_RULE__ID);

		// Create enums
		severityEEnum = createEEnum(SEVERITY);
		modeEEnum = createEEnum(MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(validationRuleEClass, ValidationRule.class, "ValidationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidationRule_Severity(), this.getSeverity(), "severity", "ERROR", 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Mode(), this.getMode(), "mode", "Batch", 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_IsEnabledByDefault(), theTypesPackage.getBoolean(), "isEnabledByDefault", "true", 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getValidationRule_Base_Constraint(), theUMLPackage.getConstraint(), null, "base_Constraint", null, 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_StatusCode(), theTypesPackage.getInteger(), "statusCode", "1", 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Message(), theTypesPackage.getString(), "message", null, 0, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Description(), theTypesPackage.getString(), "description", null, 0, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Target(), theTypesPackage.getString(), "target", null, 0, -1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Class(), theTypesPackage.getString(), "class", null, 0, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidationRule_Id(), theTypesPackage.getString(), "id", null, 0, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(severityEEnum, Severity.class, "Severity");
		addEEnumLiteral(severityEEnum, Severity.ERROR);
		addEEnumLiteral(severityEEnum, Severity.WARNING);
		addEEnumLiteral(severityEEnum, Severity.INFO);
		addEEnumLiteral(severityEEnum, Severity.CANCEL);

		initEEnum(modeEEnum, Mode.class, "Mode");
		addEEnumLiteral(modeEEnum, Mode.BATCH);
		addEEnumLiteral(modeEEnum, Mode.LIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrusDSMLValidationRulePackageImpl
