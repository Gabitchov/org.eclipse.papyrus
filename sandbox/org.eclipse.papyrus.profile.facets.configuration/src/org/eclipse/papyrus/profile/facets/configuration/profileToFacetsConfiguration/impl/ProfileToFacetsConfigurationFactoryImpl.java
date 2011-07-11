/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileToFacetsConfigurationFactoryImpl extends EFactoryImpl implements ProfileToFacetsConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfileToFacetsConfigurationFactory init() {
		try {
			ProfileToFacetsConfigurationFactory theProfileToFacetsConfigurationFactory = (ProfileToFacetsConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Papyrus/profileToFacetsConfiguration"); 
			if (theProfileToFacetsConfigurationFactory != null) {
				return theProfileToFacetsConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfileToFacetsConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileToFacetsConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION: return createProfileToFacetsConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileToFacetsConfiguration createProfileToFacetsConfiguration() {
		ProfileToFacetsConfigurationImpl profileToFacetsConfiguration = new ProfileToFacetsConfigurationImpl();
		return profileToFacetsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileToFacetsConfigurationPackage getProfileToFacetsConfigurationPackage() {
		return (ProfileToFacetsConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfileToFacetsConfigurationPackage getPackage() {
		return ProfileToFacetsConfigurationPackage.eINSTANCE;
	}

} //ProfileToFacetsConfigurationFactoryImpl
