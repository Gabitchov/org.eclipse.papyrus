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
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Action Configuration</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getPreValidationQueryConfiguration <em>Pre Validation Query Configuration
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getActionConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface ActionConfiguration extends ConfigurationElement {

	/**
	 * Returns the value of the ' <em><b>Pre Validation Query Configuration</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Validation Query Configuration</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pre Validation Query Configuration</em>'
	 *         reference.
	 * @see #setPreValidationQueryConfiguration(QueryConfiguration)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getActionConfiguration_PreValidationQueryConfiguration()
	 * @model
	 * @generated
	 */
	QueryConfiguration getPreValidationQueryConfiguration();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getPreValidationQueryConfiguration
	 * <em>Pre Validation Query Configuration</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the ' <em>Pre Validation Query Configuration</em>' reference.
	 * @see #getPreValidationQueryConfiguration()
	 * @generated
	 */
	void setPreValidationQueryConfiguration(QueryConfiguration value);
} // ActionConfiguration
