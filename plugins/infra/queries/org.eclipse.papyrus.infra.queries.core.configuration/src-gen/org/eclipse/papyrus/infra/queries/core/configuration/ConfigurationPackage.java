/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.queries.core.configuration;

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
 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/core/queries/0.7";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryConfigurationImpl <em>Query Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryConfigurationImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getQueryConfiguration()
	 * @generated
	 */
	int QUERY_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CONFIGURATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Query Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl <em>Modisco Query Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getModiscoQueryConfiguration()
	 * @generated
	 */
	int MODISCO_QUERY_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODISCO_QUERY_CONFIGURATION__NAME = QUERY_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODISCO_QUERY_CONFIGURATION__QUERY = QUERY_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES = QUERY_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Modisco Query Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODISCO_QUERY_CONFIGURATION_FEATURE_COUNT = QUERY_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ParameterValueImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getParameterValue()
	 * @generated
	 */
	int PARAMETER_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryExecutionValueImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getQueryExecutionValue()
	 * @generated
	 */
	int QUERY_EXECUTION_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE__PARAMETER = PARAMETER_VALUE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE__CONFIGURATION = PARAMETER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Execution Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE_FEATURE_COUNT = PARAMETER_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ConstantParameterValueImpl <em>Constant Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConstantParameterValueImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getConstantParameterValue()
	 * @generated
	 */
	int CONSTANT_PARAMETER_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PARAMETER_VALUE__PARAMETER = PARAMETER_VALUE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Value Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE = PARAMETER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PARAMETER_VALUE_FEATURE_COUNT = PARAMETER_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ListParameterValueImpl <em>List Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ListParameterValueImpl
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getListParameterValue()
	 * @generated
	 */
	int LIST_PARAMETER_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PARAMETER_VALUE__PARAMETER = PARAMETER_VALUE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PARAMETER_VALUE__VALUES = PARAMETER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PARAMETER_VALUE_FEATURE_COUNT = PARAMETER_VALUE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration <em>Query Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration
	 * @generated
	 */
	EClass getQueryConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration#getName()
	 * @see #getQueryConfiguration()
	 * @generated
	 */
	EAttribute getQueryConfiguration_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration <em>Modisco Query Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modisco Query Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration
	 * @generated
	 */
	EClass getModiscoQueryConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getQuery()
	 * @see #getModiscoQueryConfiguration()
	 * @generated
	 */
	EReference getModiscoQueryConfiguration_Query();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getParameterValues()
	 * @see #getModiscoQueryConfiguration()
	 * @generated
	 */
	EReference getModiscoQueryConfiguration_ParameterValues();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue
	 * @generated
	 */
	EClass getParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue#getParameter()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Execution Value</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.QueryExecutionValue
	 * @generated
	 */
	EClass getQueryExecutionValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.queries.core.configuration.QueryExecutionValue#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.QueryExecutionValue#getConfiguration()
	 * @see #getQueryExecutionValue()
	 * @generated
	 */
	EReference getQueryExecutionValue_Configuration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.ConstantParameterValue <em>Constant Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Parameter Value</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConstantParameterValue
	 * @generated
	 */
	EClass getConstantParameterValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.queries.core.configuration.ConstantParameterValue#getValueInstance <em>Value Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Instance</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConstantParameterValue#getValueInstance()
	 * @see #getConstantParameterValue()
	 * @generated
	 */
	EReference getConstantParameterValue_ValueInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.queries.core.configuration.ListParameterValue <em>List Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Parameter Value</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ListParameterValue
	 * @generated
	 */
	EClass getListParameterValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.queries.core.configuration.ListParameterValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ListParameterValue#getValues()
	 * @see #getListParameterValue()
	 * @generated
	 */
	EReference getListParameterValue_Values();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryConfigurationImpl <em>Query Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryConfigurationImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getQueryConfiguration()
		 * @generated
		 */
		EClass QUERY_CONFIGURATION = eINSTANCE.getQueryConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_CONFIGURATION__NAME = eINSTANCE.getQueryConfiguration_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl <em>Modisco Query Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getModiscoQueryConfiguration()
		 * @generated
		 */
		EClass MODISCO_QUERY_CONFIGURATION = eINSTANCE.getModiscoQueryConfiguration();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODISCO_QUERY_CONFIGURATION__QUERY = eINSTANCE.getModiscoQueryConfiguration_Query();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES = eINSTANCE.getModiscoQueryConfiguration_ParameterValues();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ParameterValueImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getParameterValue()
		 * @generated
		 */
		EClass PARAMETER_VALUE = eINSTANCE.getParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__PARAMETER = eINSTANCE.getParameterValue_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.QueryExecutionValueImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getQueryExecutionValue()
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

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ConstantParameterValueImpl <em>Constant Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConstantParameterValueImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getConstantParameterValue()
		 * @generated
		 */
		EClass CONSTANT_PARAMETER_VALUE = eINSTANCE.getConstantParameterValue();

		/**
		 * The meta object literal for the '<em><b>Value Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE = eINSTANCE.getConstantParameterValue_ValueInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ListParameterValueImpl <em>List Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ListParameterValueImpl
		 * @see org.eclipse.papyrus.infra.queries.core.configuration.impl.ConfigurationPackageImpl#getListParameterValue()
		 * @generated
		 */
		EClass LIST_PARAMETER_VALUE = eINSTANCE.getListParameterValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_PARAMETER_VALUE__VALUES = eINSTANCE.getListParameterValue_Values();

	}

} //ConfigurationPackage
