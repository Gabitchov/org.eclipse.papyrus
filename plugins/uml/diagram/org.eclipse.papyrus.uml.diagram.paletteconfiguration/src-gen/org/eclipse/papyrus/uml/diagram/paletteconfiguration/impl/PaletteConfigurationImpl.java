/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Palette Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl#getDrawerConfigurations <em>Drawer Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl#getRequiredProfiles <em>Required Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaletteConfigurationImpl extends ConfigurationImpl implements PaletteConfiguration {
	/**
	 * The cached value of the '{@link #getDrawerConfigurations() <em>Drawer Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawerConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<DrawerConfiguration> drawerConfigurations;

	/**
	 * The cached value of the '{@link #getRequiredProfiles() <em>Required Profiles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredProfiles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> requiredProfiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaletteConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PaletteconfigurationPackage.Literals.PALETTE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DrawerConfiguration> getDrawerConfigurations() {
		if (drawerConfigurations == null) {
			drawerConfigurations = new EObjectContainmentEList<DrawerConfiguration>(DrawerConfiguration.class, this, PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS);
		}
		return drawerConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRequiredProfiles() {
		if (requiredProfiles == null) {
			requiredProfiles = new EDataTypeUniqueEList<String>(String.class, this, PaletteconfigurationPackage.PALETTE_CONFIGURATION__REQUIRED_PROFILES);
		}
		return requiredProfiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
				return ((InternalEList<?>)getDrawerConfigurations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
				return getDrawerConfigurations();
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__REQUIRED_PROFILES:
				return getRequiredProfiles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
				getDrawerConfigurations().clear();
				getDrawerConfigurations().addAll((Collection<? extends DrawerConfiguration>)newValue);
				return;
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__REQUIRED_PROFILES:
				getRequiredProfiles().clear();
				getRequiredProfiles().addAll((Collection<? extends String>)newValue);
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
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
				getDrawerConfigurations().clear();
				return;
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__REQUIRED_PROFILES:
				getRequiredProfiles().clear();
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
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS:
				return drawerConfigurations != null && !drawerConfigurations.isEmpty();
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION__REQUIRED_PROFILES:
				return requiredProfiles != null && !requiredProfiles.isEmpty();
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
		result.append(" (requiredProfiles: ");
		result.append(requiredProfiles);
		result.append(')');
		return result.toString();
	}

} //PaletteConfigurationImpl
