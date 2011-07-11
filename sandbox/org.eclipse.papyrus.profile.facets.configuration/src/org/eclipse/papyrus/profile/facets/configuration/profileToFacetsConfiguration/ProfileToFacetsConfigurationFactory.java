/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationPackage
 * @generated
 */
public interface ProfileToFacetsConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfileToFacetsConfigurationFactory eINSTANCE = org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Profile To Facets Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile To Facets Configuration</em>'.
	 * @generated
	 */
	ProfileToFacetsConfiguration createProfileToFacetsConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProfileToFacetsConfigurationPackage getProfileToFacetsConfigurationPackage();

} //ProfileToFacetsConfigurationFactory
