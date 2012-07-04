/**
 */
package org.eclipse.papyrus.customization.model.customizationplugin.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl#getQualifiednames <em>Qualifiednames</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl#getIconpath <em>Iconpath</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileImpl extends FileBasedCustomizableElementImpl implements Profile {
	/**
	 * The default value of the '{@link #getQualifiednames() <em>Qualifiednames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiednames()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIEDNAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiednames() <em>Qualifiednames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiednames()
	 * @generated
	 * @ordered
	 */
	protected String qualifiednames = QUALIFIEDNAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconpath() <em>Iconpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconpath()
	 * @generated
	 * @ordered
	 */
	protected static final String ICONPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconpath() <em>Iconpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconpath()
	 * @generated
	 * @ordered
	 */
	protected String iconpath = ICONPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomizationPluginPackage.Literals.PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiednames() {
		return qualifiednames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiednames(String newQualifiednames) {
		String oldQualifiednames = qualifiednames;
		qualifiednames = newQualifiednames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationPluginPackage.PROFILE__QUALIFIEDNAMES, oldQualifiednames, qualifiednames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconpath() {
		return iconpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconpath(String newIconpath) {
		String oldIconpath = iconpath;
		iconpath = newIconpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationPluginPackage.PROFILE__ICONPATH, oldIconpath, iconpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationPluginPackage.PROFILE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationPluginPackage.PROFILE__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomizationPluginPackage.PROFILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomizationPluginPackage.PROFILE__QUALIFIEDNAMES:
				return getQualifiednames();
			case CustomizationPluginPackage.PROFILE__ICONPATH:
				return getIconpath();
			case CustomizationPluginPackage.PROFILE__DESCRIPTION:
				return getDescription();
			case CustomizationPluginPackage.PROFILE__PROVIDER:
				return getProvider();
			case CustomizationPluginPackage.PROFILE__NAME:
				return getName();
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
			case CustomizationPluginPackage.PROFILE__QUALIFIEDNAMES:
				setQualifiednames((String)newValue);
				return;
			case CustomizationPluginPackage.PROFILE__ICONPATH:
				setIconpath((String)newValue);
				return;
			case CustomizationPluginPackage.PROFILE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CustomizationPluginPackage.PROFILE__PROVIDER:
				setProvider((String)newValue);
				return;
			case CustomizationPluginPackage.PROFILE__NAME:
				setName((String)newValue);
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
			case CustomizationPluginPackage.PROFILE__QUALIFIEDNAMES:
				setQualifiednames(QUALIFIEDNAMES_EDEFAULT);
				return;
			case CustomizationPluginPackage.PROFILE__ICONPATH:
				setIconpath(ICONPATH_EDEFAULT);
				return;
			case CustomizationPluginPackage.PROFILE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CustomizationPluginPackage.PROFILE__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case CustomizationPluginPackage.PROFILE__NAME:
				setName(NAME_EDEFAULT);
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
			case CustomizationPluginPackage.PROFILE__QUALIFIEDNAMES:
				return QUALIFIEDNAMES_EDEFAULT == null ? qualifiednames != null : !QUALIFIEDNAMES_EDEFAULT.equals(qualifiednames);
			case CustomizationPluginPackage.PROFILE__ICONPATH:
				return ICONPATH_EDEFAULT == null ? iconpath != null : !ICONPATH_EDEFAULT.equals(iconpath);
			case CustomizationPluginPackage.PROFILE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CustomizationPluginPackage.PROFILE__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case CustomizationPluginPackage.PROFILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (qualifiednames: ");
		result.append(qualifiednames);
		result.append(", iconpath: ");
		result.append(iconpath);
		result.append(", description: ");
		result.append(description);
		result.append(", provider: ");
		result.append(provider);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ProfileImpl
