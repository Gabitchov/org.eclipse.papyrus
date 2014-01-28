/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;

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
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface SetValuesActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "setvaluesactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/emf/setvaluesaction/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "setvaluesactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SetValuesActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationImpl <em>Set Values Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getSetValuesActionConfiguration()
	 * @generated
	 */
	int SET_VALUES_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Features To Set</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Values Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUES_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureToSetImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getFeatureToSet()
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
	 * The feature id for the '<em><b>At Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__AT_RUNTIME = 2;

	/**
	 * The number of structural features of the '<em>Feature To Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getFeatureValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.DynamicValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getDynamicValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ConstantValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getConstantValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ListValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getListValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.QueryExecutionValueImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getQueryExecutionValue()
	 * @generated
	 */
	int QUERY_EXECUTION_VALUE = 6;

	/**
	 * The number of structural features of the '<em>Query Execution Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE_FEATURE_COUNT = DYNAMIC_VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfiguration <em>Set Values Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Values Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfiguration
	 * @generated
	 */
	EClass getSetValuesActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfiguration#getFeaturesToSet <em>Features To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features To Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfiguration#getFeaturesToSet()
	 * @see #getSetValuesActionConfiguration()
	 * @generated
	 */
	EReference getSetValuesActionConfiguration_FeaturesToSet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet <em>Feature To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature To Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet
	 * @generated
	 */
	EClass getFeatureToSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#getFeatureName()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EAttribute getFeatureToSet_FeatureName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#getValue()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EReference getFeatureToSet_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#isAtRuntime <em>At Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Runtime</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureToSet#isAtRuntime()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EAttribute getFeatureToSet_AtRuntime();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureValue <em>Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureValue
	 * @generated
	 */
	EClass getFeatureValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.DynamicValue
	 * @generated
	 */
	EClass getDynamicValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ConstantValue
	 * @generated
	 */
	EClass getConstantValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ConstantValue#getValueInstance <em>Value Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Instance</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ConstantValue#getValueInstance()
	 * @see #getConstantValue()
	 * @generated
	 */
	EReference getConstantValue_ValueInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue
	 * @generated
	 */
	EClass getListValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue#getValues()
	 * @see #getListValue()
	 * @generated
	 */
	EReference getListValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Execution Value</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.QueryExecutionValue
	 * @generated
	 */
	EClass getQueryExecutionValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SetValuesActionConfigurationFactory getSetValuesActionConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationImpl <em>Set Values Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getSetValuesActionConfiguration()
		 * @generated
		 */
		EClass SET_VALUES_ACTION_CONFIGURATION = eINSTANCE.getSetValuesActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Features To Set</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET = eINSTANCE.getSetValuesActionConfiguration_FeaturesToSet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureToSetImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getFeatureToSet()
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
		 * The meta object literal for the '<em><b>At Runtime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TO_SET__AT_RUNTIME = eINSTANCE.getFeatureToSet_AtRuntime();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.FeatureValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getFeatureValue()
		 * @generated
		 */
		EClass FEATURE_VALUE = eINSTANCE.getFeatureValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.DynamicValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getDynamicValue()
		 * @generated
		 */
		EClass DYNAMIC_VALUE = eINSTANCE.getDynamicValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ConstantValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getConstantValue()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ListValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getListValue()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.QueryExecutionValueImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.SetValuesActionConfigurationPackageImpl#getQueryExecutionValue()
		 * @generated
		 */
		EClass QUERY_EXECUTION_VALUE = eINSTANCE.getQueryExecutionValue();

	}

} //SetValuesActionConfigurationPackage
