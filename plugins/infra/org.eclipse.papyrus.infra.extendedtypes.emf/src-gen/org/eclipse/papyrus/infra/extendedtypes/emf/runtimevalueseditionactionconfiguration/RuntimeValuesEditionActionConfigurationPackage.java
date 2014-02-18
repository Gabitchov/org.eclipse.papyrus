/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface RuntimeValuesEditionActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtimevalueseditionactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/emf/runtimevalueseditionaction/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "runtimevalueseditionactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeValuesEditionActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationImpl <em>Runtime Values Edition Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationPackageImpl#getRuntimeValuesEditionActionConfiguration()
	 * @generated
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Views To Display</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Runtime Values Edition Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.ViewToDisplayImpl <em>View To Display</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.ViewToDisplayImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationPackageImpl#getViewToDisplay()
	 * @generated
	 */
	int VIEW_TO_DISPLAY = 1;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_TO_DISPLAY__VIEW = 0;

	/**
	 * The number of structural features of the '<em>View To Display</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_TO_DISPLAY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>View To Display</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_TO_DISPLAY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration <em>Runtime Values Edition Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Values Edition Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration
	 * @generated
	 */
	EClass getRuntimeValuesEditionActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration#getViewsToDisplay <em>Views To Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views To Display</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration#getViewsToDisplay()
	 * @see #getRuntimeValuesEditionActionConfiguration()
	 * @generated
	 */
	EReference getRuntimeValuesEditionActionConfiguration_ViewsToDisplay();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay <em>View To Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View To Display</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay
	 * @generated
	 */
	EClass getViewToDisplay();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay#getView()
	 * @see #getViewToDisplay()
	 * @generated
	 */
	EReference getViewToDisplay_View();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeValuesEditionActionConfigurationFactory getRuntimeValuesEditionActionConfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationImpl <em>Runtime Values Edition Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationPackageImpl#getRuntimeValuesEditionActionConfiguration()
		 * @generated
		 */
		EClass RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION = eINSTANCE.getRuntimeValuesEditionActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Views To Display</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY = eINSTANCE.getRuntimeValuesEditionActionConfiguration_ViewsToDisplay();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.ViewToDisplayImpl <em>View To Display</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.ViewToDisplayImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationPackageImpl#getViewToDisplay()
		 * @generated
		 */
		EClass VIEW_TO_DISPLAY = eINSTANCE.getViewToDisplay();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_TO_DISPLAY__VIEW = eINSTANCE.getViewToDisplay_View();

	}

} //RuntimeValuesEditionActionConfigurationPackage
