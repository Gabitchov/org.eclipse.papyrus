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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Element Type Configuration</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getHint <em>Hint</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getKindName <em>Kind Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getSpecializedTypesID <em>Specialized Types ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getElementTypeConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface ElementTypeConfiguration extends ConfigurationElement {

	/**
	 * Returns the value of the '<em><b>Hint</b></em>' attribute.
	 * The default value is <code>"ExtendedElements"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hint</em>' attribute.
	 * @see #setHint(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getElementTypeConfiguration_Hint()
	 * @model default="ExtendedElements"
	 * @generated
	 */
	String getHint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getHint <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Hint</em>' attribute.
	 * @see #getHint()
	 * @generated
	 */
	void setHint(String value);

	/**
	 * Returns the value of the '<em><b>Kind Name</b></em>' attribute. The
	 * default value is <code>"org.eclipse.gmf.runtime.emf.type.core.IHintedType"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Kind Name</em>' attribute.
	 * @see #setKindName(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getElementTypeConfiguration_KindName()
	 * @model default="org.eclipse.gmf.runtime.emf.type.core.IHintedType"
	 * @generated
	 */
	String getKindName();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getKindName
	 * <em>Kind Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Kind Name</em>' attribute.
	 * @see #getKindName()
	 * @generated
	 */
	void setKindName(String value);

	/**
	 * Returns the value of the '<em><b>Specialized Types ID</b></em>' attribute
	 * list. The list contents are of type {@link java.lang.String}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Types ID</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Specialized Types ID</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getElementTypeConfiguration_SpecializedTypesID()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getSpecializedTypesID();

	/**
	 * Returns the value of the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher Configuration</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Matcher Configuration</em>' containment reference.
	 * @see #setMatcherConfiguration(MatcherConfiguration)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getElementTypeConfiguration_MatcherConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	MatcherConfiguration getMatcherConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getMatcherConfiguration
	 * <em>Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Matcher Configuration</em>' containment reference.
	 * @see #getMatcherConfiguration()
	 * @generated
	 */
	void setMatcherConfiguration(MatcherConfiguration value);
} // ElementTypeConfiguration
