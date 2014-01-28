/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.extendedtypes.impl.SemanticActionConfigurationImpl;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Apply Stereotype Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl#getStereotypesToApply <em>Stereotypes To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplyStereotypeActionConfigurationImpl extends SemanticActionConfigurationImpl implements ApplyStereotypeActionConfiguration {
	/**
	 * The cached value of the '{@link #getStereotypesToApply() <em>Stereotypes To Apply</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypesToApply()
	 * @generated
	 * @ordered
	 */
	protected EList<StereotypeToApply> stereotypesToApply;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplyStereotypeActionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplyStereotypeActionConfigurationPackage.Literals.APPLY_STEREOTYPE_ACTION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StereotypeToApply> getStereotypesToApply() {
		if (stereotypesToApply == null) {
			stereotypesToApply = new EObjectContainmentEList<StereotypeToApply>(StereotypeToApply.class, this, ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY);
		}
		return stereotypesToApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY:
				return ((InternalEList<?>)getStereotypesToApply()).basicRemove(otherEnd, msgs);
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
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY:
				return getStereotypesToApply();
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
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY:
				getStereotypesToApply().clear();
				getStereotypesToApply().addAll((Collection<? extends StereotypeToApply>)newValue);
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
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY:
				getStereotypesToApply().clear();
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
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY:
				return stereotypesToApply != null && !stereotypesToApply.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplyStereotypeActionConfigurationImpl
