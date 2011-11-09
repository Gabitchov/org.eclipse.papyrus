/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;


import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.impl.PostActionConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modify Semantic Values Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationImpl#getFeaturesToSet <em>Features To Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifySemanticValuesActionConfigurationImpl extends PostActionConfigurationImpl implements ModifySemanticValuesActionConfiguration {
	/**
	 * The cached value of the '{@link #getFeaturesToSet() <em>Features To Set</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesToSet()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureToSet> featuresToSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifySemanticValuesActionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifySemanticValuesActionConfigurationPackage.Literals.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureToSet> getFeaturesToSet() {
		if (featuresToSet == null) {
			featuresToSet = new EObjectContainmentEList<FeatureToSet>(FeatureToSet.class, this, ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET);
		}
		return featuresToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET:
				return ((InternalEList<?>)getFeaturesToSet()).basicRemove(otherEnd, msgs);
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
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET:
				return getFeaturesToSet();
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
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET:
				getFeaturesToSet().clear();
				getFeaturesToSet().addAll((Collection<? extends FeatureToSet>)newValue);
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
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET:
				getFeaturesToSet().clear();
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
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION__FEATURES_TO_SET:
				return featuresToSet != null && !featuresToSet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModifySemanticValuesActionConfigurationImpl
