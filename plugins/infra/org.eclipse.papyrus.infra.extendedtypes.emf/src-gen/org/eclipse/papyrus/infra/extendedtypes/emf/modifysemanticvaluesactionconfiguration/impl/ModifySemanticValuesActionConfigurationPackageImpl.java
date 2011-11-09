/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;



import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.DynamicValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifySemanticValuesActionConfigurationPackageImpl extends EPackageImpl implements ModifySemanticValuesActionConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifySemanticValuesActionConfigurationEClass = null;

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifySemanticValuesActionConfigurationPackageImpl() {
		super(eNS_URI, ModifySemanticValuesActionConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModifySemanticValuesActionConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifySemanticValuesActionConfigurationPackage init() {
		if (isInited) return (ModifySemanticValuesActionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ModifySemanticValuesActionConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		ModifySemanticValuesActionConfigurationPackageImpl theModifySemanticValuesActionConfigurationPackage = (ModifySemanticValuesActionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifySemanticValuesActionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifySemanticValuesActionConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModifySemanticValuesActionConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theModifySemanticValuesActionConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifySemanticValuesActionConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifySemanticValuesActionConfigurationPackage.eNS_URI, theModifySemanticValuesActionConfigurationPackage);
		return theModifySemanticValuesActionConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifySemanticValuesActionConfiguration() {
		return modifySemanticValuesActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifySemanticValuesActionConfiguration_FeaturesToSet() {
		return (EReference)modifySemanticValuesActionConfigurationEClass.getEStructuralFeatures().get(0);
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
	public EReference getQueryExecutionValue_Configuration() {
		return (EReference)queryExecutionValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySemanticValuesActionConfigurationFactory getModifySemanticValuesActionConfigurationFactory() {
		return (ModifySemanticValuesActionConfigurationFactory)getEFactoryInstance();
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
		modifySemanticValuesActionConfigurationEClass = createEClass(MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION);
		createEReference(modifySemanticValuesActionConfigurationEClass, MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET);

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
		createEReference(queryExecutionValueEClass, QUERY_EXECUTION_VALUE__CONFIGURATION);
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
		ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigurationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modifySemanticValuesActionConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getPostActionConfiguration());
		dynamicValueEClass.getESuperTypes().add(this.getFeatureValue());
		constantValueEClass.getESuperTypes().add(this.getFeatureValue());
		listValueEClass.getESuperTypes().add(this.getFeatureValue());
		queryExecutionValueEClass.getESuperTypes().add(this.getFeatureValue());

		// Initialize classes and features; add operations and parameters
		initEClass(modifySemanticValuesActionConfigurationEClass, ModifySemanticValuesActionConfiguration.class, "ModifySemanticValuesActionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifySemanticValuesActionConfiguration_FeaturesToSet(), this.getFeatureToSet(), null, "featuresToSet", null, 0, -1, ModifySemanticValuesActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureToSetEClass, FeatureToSet.class, "FeatureToSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureToSet_FeatureName(), theEcorePackage.getEString(), "featureName", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureToSet_Value(), this.getFeatureValue(), null, "value", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureValueEClass, FeatureValue.class, "FeatureValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dynamicValueEClass, DynamicValue.class, "DynamicValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantValue_ValueInstance(), theUMLPackage.getValueSpecification(), null, "valueInstance", null, 0, 1, ConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listValueEClass, ListValue.class, "ListValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListValue_Values(), this.getFeatureValue(), null, "values", null, 0, -1, ListValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryExecutionValueEClass, QueryExecutionValue.class, "QueryExecutionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryExecutionValue_Configuration(), theConfigurationPackage.getQueryConfiguration(), null, "configuration", null, 0, 1, QueryExecutionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModifySemanticValuesActionConfigurationPackageImpl
