/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.properties.environment.ConstraintType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.SimpleConstraint#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.SimpleConstraint#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSimpleConstraint()
 * @model
 * @generated
 */
public interface SimpleConstraint extends ConstraintDescriptor {
	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Type</em>' reference.
	 * @see #setConstraintType(ConstraintType)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSimpleConstraint_ConstraintType()
	 * @model required="true"
	 * @generated
	 */
	ConstraintType getConstraintType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.SimpleConstraint#getConstraintType <em>Constraint Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Type</em>' reference.
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(ConstraintType value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.ConfigProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSimpleConstraint_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigProperty> getProperties();

} // SimpleConstraint
