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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invariant Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class InvariantRuleConfigurationImpl extends MinimalEObjectImpl.Container implements InvariantRuleConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvariantRuleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantSemanticTypeConfigurationPackage.Literals.INVARIANT_RULE_CONFIGURATION;
	}

} //InvariantRuleConfigurationImpl
