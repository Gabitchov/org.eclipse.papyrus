/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeConfigurationImpl;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invariant Semantic Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationImpl#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvariantSemanticTypeConfigurationImpl extends SemanticTypeConfigurationImpl implements InvariantSemanticTypeConfiguration {
	/**
	 * The cached value of the '{@link #getInvariantRuleConfiguration() <em>Invariant Rule Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariantRuleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected InvariantRuleConfiguration invariantRuleConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvariantSemanticTypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantSemanticTypeConfigurationPackage.Literals.INVARIANT_SEMANTIC_TYPE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantRuleConfiguration getInvariantRuleConfiguration() {
		return invariantRuleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvariantRuleConfiguration(InvariantRuleConfiguration newInvariantRuleConfiguration, NotificationChain msgs) {
		InvariantRuleConfiguration oldInvariantRuleConfiguration = invariantRuleConfiguration;
		invariantRuleConfiguration = newInvariantRuleConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION, oldInvariantRuleConfiguration, newInvariantRuleConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariantRuleConfiguration(InvariantRuleConfiguration newInvariantRuleConfiguration) {
		if (newInvariantRuleConfiguration != invariantRuleConfiguration) {
			NotificationChain msgs = null;
			if (invariantRuleConfiguration != null)
				msgs = ((InternalEObject)invariantRuleConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION, null, msgs);
			if (newInvariantRuleConfiguration != null)
				msgs = ((InternalEObject)newInvariantRuleConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION, null, msgs);
			msgs = basicSetInvariantRuleConfiguration(newInvariantRuleConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION, newInvariantRuleConfiguration, newInvariantRuleConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION:
				return basicSetInvariantRuleConfiguration(null, msgs);
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
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION:
				return getInvariantRuleConfiguration();
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
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION:
				setInvariantRuleConfiguration((InvariantRuleConfiguration)newValue);
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
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION:
				setInvariantRuleConfiguration((InvariantRuleConfiguration)null);
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
			case InvariantSemanticTypeConfigurationPackage.INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION:
				return invariantRuleConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //InvariantSemanticTypeConfigurationImpl
