/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JDT Parent</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getFlags <em>Flags</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParent()
 * @model abstract="true"
 * @generated
 */
public interface JDTParent extends EObject {

	/**
	 * Returns the value of the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flags</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Flags</em>' attribute.
	 * @see #setFlags(int)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParent_Flags()
	 * @model unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.int" required="true" ordered="false"
	 * @generated
	 */
	int getFlags();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getFlags <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Flags</em>' attribute.
	 * @see #getFlags()
	 * @generated
	 */
	void setFlags(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 *        flagDataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.int" flagRequired="true" flagOrdered="false"
	 * @generated
	 */
	boolean isFlagSet(int flag);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent
	 * <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParent_Children()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent
	 * @model opposite="parent" transient="true" changeable="false" volatile="true" ordered="false"
	 * @generated
	 */
	EList<JDTJavaElement> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model flagDataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.int" flagRequired="true" flagOrdered="false"
	 *        valueDataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	void setFlag(int flag, boolean value);

} // JDTParent
