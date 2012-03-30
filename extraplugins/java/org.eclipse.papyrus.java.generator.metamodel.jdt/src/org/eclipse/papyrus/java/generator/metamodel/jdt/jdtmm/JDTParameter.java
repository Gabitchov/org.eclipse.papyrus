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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JDT Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getParameterOwner <em>Parameter Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isMultiValued <em>Is Multi Valued</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getReturnOwner <em>Return Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter()
 * @model
 * @generated
 */
public interface JDTParameter extends JDTMember {

	/**
	 * Returns the value of the '<em><b>Parameter Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Owner</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Owner</em>' container reference.
	 * @see #setParameterOwner(JDTMethod)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter_ParameterOwner()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getParameters
	 * @model opposite="parameters" transient="false" ordered="false"
	 * @generated
	 */
	JDTMethod getParameterOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getParameterOwner <em>Parameter Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Owner</em>' container reference.
	 * @see #getParameterOwner()
	 * @generated
	 */
	void setParameterOwner(JDTMethod value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter_Final()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Multi Valued</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi Valued</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Multi Valued</em>' attribute.
	 * @see #setIsMultiValued(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter_IsMultiValued()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isMultiValued <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multi Valued</em>' attribute.
	 * @see #isMultiValued()
	 * @generated
	 */
	void setIsMultiValued(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JDTType)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter_Type()
	 * @model ordered="false"
	 * @generated
	 */
	JDTType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JDTType value);

	/**
	 * Returns the value of the '<em><b>Return Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Owner</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Owner</em>' container reference.
	 * @see #setReturnOwner(JDTMethod)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTParameter_ReturnOwner()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getReturnType
	 * @model opposite="returnType" transient="false" ordered="false"
	 * @generated
	 */
	JDTMethod getReturnOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getReturnOwner <em>Return Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Owner</em>' container reference.
	 * @see #getReturnOwner()
	 * @generated
	 */
	void setReturnOwner(JDTMethod value);
} // JDTParameter
