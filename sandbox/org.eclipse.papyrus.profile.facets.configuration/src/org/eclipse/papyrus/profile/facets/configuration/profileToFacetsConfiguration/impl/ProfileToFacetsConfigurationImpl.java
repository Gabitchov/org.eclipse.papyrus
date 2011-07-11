/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration;
import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationPackage;

import org.eclipse.uml2.uml.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile To Facets Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl#getJavaFolder <em>Java Folder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl.ProfileToFacetsConfigurationImpl#getModelFolder <em>Model Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileToFacetsConfigurationImpl extends EObjectImpl implements ProfileToFacetsConfiguration {
	/**
	 * The cached value of the '{@link #getProfile() <em>Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfile()
	 * @generated
	 * @ordered
	 */
	protected Profile profile;

	/**
	 * The default value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePackage()
	 * @generated
	 * @ordered
	 */
	protected String basePackage = BASE_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected String header = HEADER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaFolder() <em>Java Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_FOLDER_EDEFAULT = "src-gen";

	/**
	 * The cached value of the '{@link #getJavaFolder() <em>Java Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaFolder()
	 * @generated
	 * @ordered
	 */
	protected String javaFolder = JAVA_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelFolder() <em>Model Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_FOLDER_EDEFAULT = "resources";

	/**
	 * The cached value of the '{@link #getModelFolder() <em>Model Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelFolder()
	 * @generated
	 * @ordered
	 */
	protected String modelFolder = MODEL_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileToFacetsConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfileToFacetsConfigurationPackage.Literals.PROFILE_TO_FACETS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile getProfile() {
		if (profile != null && profile.eIsProxy()) {
			InternalEObject oldProfile = (InternalEObject)profile;
			profile = (Profile)eResolveProxy(oldProfile);
			if (profile != oldProfile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE, oldProfile, profile));
			}
		}
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile basicGetProfile() {
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfile(Profile newProfile) {
		Profile oldProfile = profile;
		profile = newProfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE, oldProfile, profile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePackage(String newBasePackage) {
		String oldBasePackage = basePackage;
		basePackage = newBasePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE, oldBasePackage, basePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(String newHeader) {
		String oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__HEADER, oldHeader, header));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavaFolder() {
		return javaFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaFolder(String newJavaFolder) {
		String oldJavaFolder = javaFolder;
		javaFolder = newJavaFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER, oldJavaFolder, javaFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelFolder() {
		return modelFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelFolder(String newModelFolder) {
		String oldModelFolder = modelFolder;
		modelFolder = newModelFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER, oldModelFolder, modelFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE:
				if (resolve) return getProfile();
				return basicGetProfile();
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE:
				return getBasePackage();
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__HEADER:
				return getHeader();
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER:
				return getJavaFolder();
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER:
				return getModelFolder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE:
				setProfile((Profile)newValue);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE:
				setBasePackage((String)newValue);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__HEADER:
				setHeader((String)newValue);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER:
				setJavaFolder((String)newValue);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER:
				setModelFolder((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE:
				setProfile((Profile)null);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE:
				setBasePackage(BASE_PACKAGE_EDEFAULT);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__HEADER:
				setHeader(HEADER_EDEFAULT);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER:
				setJavaFolder(JAVA_FOLDER_EDEFAULT);
				return;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER:
				setModelFolder(MODEL_FOLDER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__PROFILE:
				return profile != null;
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE:
				return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER:
				return JAVA_FOLDER_EDEFAULT == null ? javaFolder != null : !JAVA_FOLDER_EDEFAULT.equals(javaFolder);
			case ProfileToFacetsConfigurationPackage.PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER:
				return MODEL_FOLDER_EDEFAULT == null ? modelFolder != null : !MODEL_FOLDER_EDEFAULT.equals(modelFolder);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (basePackage: ");
		result.append(basePackage);
		result.append(", header: ");
		result.append(header);
		result.append(", javaFolder: ");
		result.append(javaFolder);
		result.append(", modelFolder: ");
		result.append(modelFolder);
		result.append(')');
		return result.toString();
	}

} //ProfileToFacetsConfigurationImpl
