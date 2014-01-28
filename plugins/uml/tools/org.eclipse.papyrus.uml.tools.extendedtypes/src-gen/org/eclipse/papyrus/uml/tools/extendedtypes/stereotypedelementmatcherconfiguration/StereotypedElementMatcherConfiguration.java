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
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration;

import org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotyped Element Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration#getStereotypedQualifiedName <em>Stereotyped Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage#getStereotypedElementMatcherConfiguration()
 * @model
 * @generated
 */
public interface StereotypedElementMatcherConfiguration extends MatcherConfiguration {
	/**
	 * Returns the value of the '<em><b>Stereotyped Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotyped Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotyped Qualified Name</em>' attribute.
	 * @see #setStereotypedQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage#getStereotypedElementMatcherConfiguration_StereotypedQualifiedName()
	 * @model
	 * @generated
	 */
	String getStereotypedQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration#getStereotypedQualifiedName <em>Stereotyped Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotyped Qualified Name</em>' attribute.
	 * @see #getStereotypedQualifiedName()
	 * @generated
	 */
	void setStereotypedQualifiedName(String value);

} // StereotypedElementMatcherConfiguration
