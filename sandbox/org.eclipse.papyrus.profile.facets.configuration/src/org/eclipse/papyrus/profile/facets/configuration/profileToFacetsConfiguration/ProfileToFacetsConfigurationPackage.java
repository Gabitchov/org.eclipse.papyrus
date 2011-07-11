/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration;

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
 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ProfileToFacetsConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profileToFacetsConfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/profileToFacetsConfiguration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "profileToFacetsConfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfileToFacetsConfigurationPackage eINSTANCE = org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl <em>Profile To Facets Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationPackageImpl#getProfileToFacetsConfiguration()
	 * @generated
	 */
	int PROFILE_TO_FACETS_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION__PROFILE = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION__HEADER = 2;

	/**
	 * The feature id for the '<em><b>Java Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER = 3;

	/**
	 * The feature id for the '<em><b>Model Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER = 4;

	/**
	 * The number of structural features of the '<em>Profile To Facets Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_TO_FACETS_CONFIGURATION_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration <em>Profile To Facets Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile To Facets Configuration</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration
	 * @generated
	 */
	EClass getProfileToFacetsConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Profile</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getProfile()
	 * @see #getProfileToFacetsConfiguration()
	 * @generated
	 */
	EReference getProfileToFacetsConfiguration_Profile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getBasePackage <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getBasePackage()
	 * @see #getProfileToFacetsConfiguration()
	 * @generated
	 */
	EAttribute getProfileToFacetsConfiguration_BasePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getHeader()
	 * @see #getProfileToFacetsConfiguration()
	 * @generated
	 */
	EAttribute getProfileToFacetsConfiguration_Header();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getJavaFolder <em>Java Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Folder</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getJavaFolder()
	 * @see #getProfileToFacetsConfiguration()
	 * @generated
	 */
	EAttribute getProfileToFacetsConfiguration_JavaFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getModelFolder <em>Model Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Folder</em>'.
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration#getModelFolder()
	 * @see #getProfileToFacetsConfiguration()
	 * @generated
	 */
	EAttribute getProfileToFacetsConfiguration_ModelFolder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProfileToFacetsConfigurationFactory getProfileToFacetsConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl <em>Profile To Facets Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl
		 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationPackageImpl#getProfileToFacetsConfiguration()
		 * @generated
		 */
		EClass PROFILE_TO_FACETS_CONFIGURATION = eINSTANCE.getProfileToFacetsConfiguration();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_TO_FACETS_CONFIGURATION__PROFILE = eINSTANCE.getProfileToFacetsConfiguration_Profile();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE = eINSTANCE.getProfileToFacetsConfiguration_BasePackage();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TO_FACETS_CONFIGURATION__HEADER = eINSTANCE.getProfileToFacetsConfiguration_Header();

		/**
		 * The meta object literal for the '<em><b>Java Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER = eINSTANCE.getProfileToFacetsConfiguration_JavaFolder();

		/**
		 * The meta object literal for the '<em><b>Model Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER = eINSTANCE.getProfileToFacetsConfiguration_ModelFolder();

	}

} //ProfileToFacetsConfigurationPackage
