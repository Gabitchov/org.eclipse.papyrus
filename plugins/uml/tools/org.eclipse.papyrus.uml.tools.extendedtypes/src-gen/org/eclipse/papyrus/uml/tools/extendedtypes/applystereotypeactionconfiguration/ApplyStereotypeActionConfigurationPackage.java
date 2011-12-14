/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

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
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ApplyStereotypeActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "applystereotypeactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/diagram/types/applystereotypeactionconfiguration/0.7";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "applystereotypeactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplyStereotypeActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl <em>Apply Stereotype Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getApplyStereotypeActionConfiguration()
	 * @generated
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__LABEL = ExtendedtypesPackage.POST_ACTION_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__ID = ExtendedtypesPackage.POST_ACTION_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Stereotypes To Apply</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY = ExtendedtypesPackage.POST_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Apply Stereotype Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.POST_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl <em>Stereotype To Apply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getStereotypeToApply()
	 * @generated
	 */
	int STEREOTYPE_TO_APPLY = 1;

	/**
	 * The feature id for the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Update Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__UPDATE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Required Profiles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__REQUIRED_PROFILES = 2;

	/**
	 * The number of structural features of the '<em>Stereotype To Apply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration <em>Apply Stereotype Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Stereotype Action Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration
	 * @generated
	 */
	EClass getApplyStereotypeActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply <em>Stereotypes To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes To Apply</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply()
	 * @see #getApplyStereotypeActionConfiguration()
	 * @generated
	 */
	EReference getApplyStereotypeActionConfiguration_StereotypesToApply();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply <em>Stereotype To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype To Apply</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply
	 * @generated
	 */
	EClass getStereotypeToApply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_StereotypeQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName <em>Update Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Update Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_UpdateName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getRequiredProfiles <em>Required Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Required Profiles</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getRequiredProfiles()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_RequiredProfiles();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ApplyStereotypeActionConfigurationFactory getApplyStereotypeActionConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl <em>Apply Stereotype Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getApplyStereotypeActionConfiguration()
		 * @generated
		 */
		EClass APPLY_STEREOTYPE_ACTION_CONFIGURATION = eINSTANCE.getApplyStereotypeActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stereotypes To Apply</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY = eINSTANCE.getApplyStereotypeActionConfiguration_StereotypesToApply();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl <em>Stereotype To Apply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getStereotypeToApply()
		 * @generated
		 */
		EClass STEREOTYPE_TO_APPLY = eINSTANCE.getStereotypeToApply();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME = eINSTANCE.getStereotypeToApply_StereotypeQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Update Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__UPDATE_NAME = eINSTANCE.getStereotypeToApply_UpdateName();

		/**
		 * The meta object literal for the '<em><b>Required Profiles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__REQUIRED_PROFILES = eINSTANCE.getStereotypeToApply_RequiredProfiles();

	}

} //ApplyStereotypeActionConfigurationPackage
