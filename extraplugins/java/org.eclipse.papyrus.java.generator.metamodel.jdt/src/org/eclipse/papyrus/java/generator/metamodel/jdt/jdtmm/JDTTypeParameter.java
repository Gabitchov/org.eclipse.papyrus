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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JDT Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter#getDeclaringMember <em>Declaring Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTTypeParameter()
 * @model
 * @generated
 */
public interface JDTTypeParameter extends JDTJavaElement {

	/**
	 * Returns the value of the '<em><b>Declaring Member</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Member</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Member</em>' container reference.
	 * @see #setDeclaringMember(JDTMember)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTTypeParameter_DeclaringMember()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getTypeParameters
	 * @model opposite="typeParameters" transient="false" ordered="false"
	 * @generated
	 */
	JDTMember getDeclaringMember();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter#getDeclaringMember <em>Declaring Member</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Member</em>' container reference.
	 * @see #getDeclaringMember()
	 * @generated
	 */
	void setDeclaringMember(JDTMember value);

} // JDTTypeParameter
