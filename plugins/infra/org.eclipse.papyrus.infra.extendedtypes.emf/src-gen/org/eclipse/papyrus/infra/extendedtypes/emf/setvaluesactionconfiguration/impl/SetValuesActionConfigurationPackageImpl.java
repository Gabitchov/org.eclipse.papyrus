/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ConstantValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.DynamicValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetValuesActionConfigurationPackageImpl extends EPackageImpl implements SetValuesActionConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setValuesActionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureToSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryExecutionValueEClass = null;

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SetValuesActionConfigurationPackageImpl() {
		super(eNS_URI, SetValuesActionConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SetValuesActionConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SetValuesActionConfigurationPackage init() {
		if (isInited) return (SetValuesActionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(SetValuesActionConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		SetValuesActionConfigurationPackageImpl theSetValuesActionConfigurationPackage = (SetValuesActionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SetValuesActionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SetValuesActionConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSetValuesActionConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theSetValuesActionConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSetValuesActionConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SetValuesActionConfigurationPackage.eNS_URI, theSetValuesActionConfigurationPackage);
		return theSetValuesActionConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetValuesActionConfiguration() {
		return setValuesActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetValuesActionConfiguration_FeaturesToSet() {
		return (EReference)setValuesActionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureToSet() {
		return featureToSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureToSet_FeatureName() {
		return (EAttribute)featureToSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureToSet_Value() {
		return (EReference)featureToSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureValue() {
		return featureValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicValue() {
		return dynamicValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantValue() {
		return constantValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstantValue_ValueInstance() {
		return (EReference)constantValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListValue() {
		return listValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListValue_Values() {
		return (EReference)listValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryExecutionValue() {
		return queryExecutionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValuesActionConfigurationFactory getSetValuesActionConfigurationFactory() {
		return (SetValuesActionConfigurationFactory)getEFactoryInstance();
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
		setValuesActionConfigurationEClass = createEClass(SET_VALUES_ACTION_CONFIGURATION);
		createEReference(setValuesActionConfigurationEClass, SET_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET);

		featureToSetEClass = createEClass(FEATURE_TO_SET);
		createEAttribute(featureToSetEClass, FEATURE_TO_SET__FEATURE_NAME);
		createEReference(featureToSetEClass, FEATURE_TO_SET__VALUE);

		featureValueEClass = createEClass(FEATURE_VALUE);

		dynamicValueEClass = createEClass(DYNAMIC_VALUE);

		constantValueEClass = createEClass(CONSTANT_VALUE);
		createEReference(constantValueEClass, CONSTANT_VALUE__VALUE_INSTANCE);

		listValueEClass = createEClass(LIST_VALUE);
		createEReference(listValueEClass, LIST_VALUE__VALUES);

		queryExecutionValueEClass = createEClass(QUERY_EXECUTION_VALUE);
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
		ExtendedtypesPackage theExtendedtypesPackage = (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		setValuesActionConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticActionConfiguration());
		dynamicValueEClass.getESuperTypes().add(this.getFeatureValue());
		constantValueEClass.getESuperTypes().add(this.getFeatureValue());
		listValueEClass.getESuperTypes().add(this.getFeatureValue());
		queryExecutionValueEClass.getESuperTypes().add(this.getDynamicValue());

		// Initialize classes and features; add operations and parameters
		initEClass(setValuesActionConfigurationEClass, SetValuesActionConfiguration.class, "SetValuesActionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetValuesActionConfiguration_FeaturesToSet(), this.getFeatureToSet(), null, "featuresToSet", null, 0, -1, SetValuesActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureToSetEClass, FeatureToSet.class, "FeatureToSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureToSet_FeatureName(), theEcorePackage.getEString(), "featureName", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureToSet_Value(), this.getFeatureValue(), null, "value", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureValueEClass, FeatureValue.class, "FeatureValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dynamicValueEClass, DynamicValue.class, "DynamicValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantValue_ValueInstance(), theUMLPackage.getValueSpecification(), null, "valueInstance", null, 0, 1, ConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listValueEClass, ListValue.class, "ListValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListValue_Values(), this.getFeatureValue(), null, "values", null, 0, -1, ListValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryExecutionValueEClass, QueryExecutionValue.class, "QueryExecutionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SetValuesActionConfigurationPackageImpl
