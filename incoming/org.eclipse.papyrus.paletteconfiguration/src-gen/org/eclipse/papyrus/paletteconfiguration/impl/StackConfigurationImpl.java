/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.paletteconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.paletteconfiguration.ToolConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.paletteconfiguration.impl.StackConfigurationImpl#getToolConfigurations <em>Tool Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StackConfigurationImpl extends ChildConfigurationImpl implements StackConfiguration {
	/**
	 * The cached value of the '{@link #getToolConfigurations() <em>Tool Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<ToolConfiguration> toolConfigurations;

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
	public EList<ToolConfiguration> getToolConfigurations() {
		if (toolConfigurations == null) {
			toolConfigurations = new EObjectContainmentEList<ToolConfiguration>(ToolConfiguration.class, this, PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS);
		}
		return toolConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS:
				return ((InternalEList<?>)getToolConfigurations()).basicRemove(otherEnd, msgs);
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS:
				return getToolConfigurations();
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS:
				getToolConfigurations().clear();
				getToolConfigurations().addAll((Collection<? extends ToolConfiguration>)newValue);
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS:
				getToolConfigurations().clear();
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
			case PaletteconfigurationPackage.STACK_CONFIGURATION__TOOL_CONFIGURATIONS:
				return toolConfigurations != null && !toolConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StackConfigurationImpl
