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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.properties.environment.ConstraintType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay <em>Display</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#isOverrideable <em>Overrideable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getOverriddenConstraints <em>Overridden Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getConstraintDescriptor()
 * @model abstract="true"
 * @generated
 */
public interface ConstraintDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getConstraintDescriptor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Display</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.DisplayUnit#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display</em>' container reference.
	 * @see #setDisplay(DisplayUnit)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getConstraintDescriptor_Display()
	 * @see org.eclipse.papyrus.properties.contexts.DisplayUnit#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	DisplayUnit getDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay <em>Display</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display</em>' container reference.
	 * @see #getDisplay()
	 * @generated
	 */
	void setDisplay(DisplayUnit value);

	/**
	 * Returns the value of the '<em><b>Overridden Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.SimpleConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden Constraints</em>' reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getConstraintDescriptor_OverriddenConstraints()
	 * @model
	 * @generated
	 */
	EList<SimpleConstraint> getOverriddenConstraints();

	/**
	 * Returns the value of the '<em><b>Overrideable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrideable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrideable</em>' attribute.
	 * @see #setOverrideable(boolean)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getConstraintDescriptor_Overrideable()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isOverrideable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#isOverrideable <em>Overrideable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrideable</em>' attribute.
	 * @see #isOverrideable()
	 * @generated
	 */
	void setOverrideable(boolean value);

} // ConstraintDescriptor
