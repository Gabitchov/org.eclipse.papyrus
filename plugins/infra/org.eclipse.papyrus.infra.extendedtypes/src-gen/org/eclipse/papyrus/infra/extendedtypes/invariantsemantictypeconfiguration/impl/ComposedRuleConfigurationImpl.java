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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.ComposedRuleConfigurationImpl#getComposedRules <em>Composed Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComposedRuleConfigurationImpl extends InvariantRuleConfigurationImpl implements ComposedRuleConfiguration {
	/**
	 * The cached value of the '{@link #getComposedRules() <em>Composed Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedRules()
	 * @generated
	 * @ordered
	 */
	protected EList<InvariantRuleConfiguration> composedRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedRuleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantSemanticTypeConfigurationPackage.Literals.COMPOSED_RULE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InvariantRuleConfiguration> getComposedRules() {
		if (composedRules == null) {
			composedRules = new EObjectResolvingEList<InvariantRuleConfiguration>(InvariantRuleConfiguration.class, this, InvariantSemanticTypeConfigurationPackage.COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES);
		}
		return composedRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvariantSemanticTypeConfigurationPackage.COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES:
				return getComposedRules();
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
			case InvariantSemanticTypeConfigurationPackage.COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES:
				getComposedRules().clear();
				getComposedRules().addAll((Collection<? extends InvariantRuleConfiguration>)newValue);
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
			case InvariantSemanticTypeConfigurationPackage.COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES:
				getComposedRules().clear();
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
			case InvariantSemanticTypeConfigurationPackage.COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES:
				return composedRules != null && !composedRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComposedRuleConfigurationImpl
