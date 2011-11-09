/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

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
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ModifySemanticValuesActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifysemanticvaluesactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/diagram/types/modifysemanticvaluesactionconfiguration/0.8";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modifysemanticvaluesactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifySemanticValuesActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationImpl <em>Modify Semantic Values Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getModifySemanticValuesActionConfiguration()
	 * @generated
	 */
	int MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__LABEL = ExtendedtypesPackage.POST_ACTION_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__ID = ExtendedtypesPackage.POST_ACTION_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Features To Set</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET = ExtendedtypesPackage.POST_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Modify Semantic Values Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.POST_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureToSetImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getFeatureToSet()
	 * @generated
	 */
	int FEATURE_TO_SET = 1;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__FEATURE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Feature To Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getFeatureValue()
	 * @generated
	 */
	int FEATURE_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.DynamicValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getDynamicValue()
	 * @generated
	 */
	int DYNAMIC_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Dynamic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ConstantValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getConstantValue()
	 * @generated
	 */
	int CONSTANT_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE__VALUE_INSTANCE = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ListValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getListValue()
	 * @generated
	 */
	int LIST_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__VALUES = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.QueryExecutionValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getQueryExecutionValue()
	 * @generated
	 */
	int QUERY_EXECUTION_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE__CONFIGURATION = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Execution Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration <em>Modify Semantic Values Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modify Semantic Values Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration
	 * @generated
	 */
	EClass getModifySemanticValuesActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration#getFeaturesToSet <em>Features To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features To Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration#getFeaturesToSet()
	 * @see #getModifySemanticValuesActionConfiguration()
	 * @generated
	 */
	EReference getModifySemanticValuesActionConfiguration_FeaturesToSet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet <em>Feature To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature To Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet
	 * @generated
	 */
	EClass getFeatureToSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet#getFeatureName()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EAttribute getFeatureToSet_FeatureName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet#getValue()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EReference getFeatureToSet_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureValue <em>Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureValue
	 * @generated
	 */
	EClass getFeatureValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.DynamicValue
	 * @generated
	 */
	EClass getDynamicValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue
	 * @generated
	 */
	EClass getConstantValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue#getValueInstance <em>Value Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Instance</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue#getValueInstance()
	 * @see #getConstantValue()
	 * @generated
	 */
	EReference getConstantValue_ValueInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue
	 * @generated
	 */
	EClass getListValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue#getValues()
	 * @see #getListValue()
	 * @generated
	 */
	EReference getListValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Execution Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue
	 * @generated
	 */
	EClass getQueryExecutionValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue#getConfiguration()
	 * @see #getQueryExecutionValue()
	 * @generated
	 */
	EReference getQueryExecutionValue_Configuration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifySemanticValuesActionConfigurationFactory getModifySemanticValuesActionConfigurationFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationImpl <em>Modify Semantic Values Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getModifySemanticValuesActionConfiguration()
		 * @generated
		 */
		EClass MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION = eINSTANCE.getModifySemanticValuesActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Features To Set</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET = eINSTANCE.getModifySemanticValuesActionConfiguration_FeaturesToSet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureToSetImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getFeatureToSet()
		 * @generated
		 */
		EClass FEATURE_TO_SET = eINSTANCE.getFeatureToSet();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TO_SET__FEATURE_NAME = eINSTANCE.getFeatureToSet_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TO_SET__VALUE = eINSTANCE.getFeatureToSet_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.FeatureValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getFeatureValue()
		 * @generated
		 */
		EClass FEATURE_VALUE = eINSTANCE.getFeatureValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.DynamicValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getDynamicValue()
		 * @generated
		 */
		EClass DYNAMIC_VALUE = eINSTANCE.getDynamicValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ConstantValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getConstantValue()
		 * @generated
		 */
		EClass CONSTANT_VALUE = eINSTANCE.getConstantValue();

		/**
		 * The meta object literal for the '<em><b>Value Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_VALUE__VALUE_INSTANCE = eINSTANCE.getConstantValue_ValueInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ListValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getListValue()
		 * @generated
		 */
		EClass LIST_VALUE = eINSTANCE.getListValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_VALUE__VALUES = eINSTANCE.getListValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.QueryExecutionValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationPackageImpl#getQueryExecutionValue()
		 * @generated
		 */
		EClass QUERY_EXECUTION_VALUE = eINSTANCE.getQueryExecutionValue();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_EXECUTION_VALUE__CONFIGURATION = eINSTANCE.getQueryExecutionValue_Configuration();

	}

} //ModifySemanticValuesActionConfigurationPackage
