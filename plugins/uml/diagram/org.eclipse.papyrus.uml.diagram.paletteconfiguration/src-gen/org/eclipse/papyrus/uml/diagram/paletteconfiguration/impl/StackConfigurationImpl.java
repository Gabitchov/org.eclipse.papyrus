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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.StackConfigurationImpl#getOwnedConfigurations <em>Owned Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StackConfigurationImpl extends ChildConfigurationImpl implements StackConfiguration {
	/**
	 * The cached value of the '{@link #getOwnedConfigurations() <em>Owned Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafConfiguration> ownedConfigurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StackConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PaletteconfigurationPackage.Literals.STACK_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafConfiguration> getOwnedConfigurations() {
		if (ownedConfigurations == null) {
			ownedConfigurations = new EObjectContainmentEList<LeafConfiguration>(LeafConfiguration.class, this, PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS);
		}
		return ownedConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS:
				return ((InternalEList<?>)getOwnedConfigurations()).basicRemove(otherEnd, msgs);
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS:
				return getOwnedConfigurations();
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS:
				getOwnedConfigurations().clear();
				getOwnedConfigurations().addAll((Collection<? extends LeafConfiguration>)newValue);
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS:
				getOwnedConfigurations().clear();
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__OWNED_CONFIGURATIONS:
				return ownedConfigurations != null && !ownedConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StackConfigurationImpl
