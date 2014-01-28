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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant Semantic Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage#getInvariantSemanticTypeConfiguration()
 * @model
 * @generated
 */
public interface InvariantSemanticTypeConfiguration extends SemanticTypeConfiguration {
	/**
	 * Returns the value of the '<em><b>Invariant Rule Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant Rule Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant Rule Configuration</em>' containment reference.
	 * @see #setInvariantRuleConfiguration(InvariantRuleConfiguration)
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage#getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InvariantRuleConfiguration getInvariantRuleConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant Rule Configuration</em>' containment reference.
	 * @see #getInvariantRuleConfiguration()
	 * @generated
	 */
	void setInvariantRuleConfiguration(InvariantRuleConfiguration value);

} // InvariantSemanticTypeConfiguration
