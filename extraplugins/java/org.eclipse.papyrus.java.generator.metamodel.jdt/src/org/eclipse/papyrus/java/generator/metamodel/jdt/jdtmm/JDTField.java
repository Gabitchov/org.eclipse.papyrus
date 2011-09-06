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
 * A representation of the model object '<em><b>JDT Field</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isAbstract <em>Abstract</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isFinal <em>Final</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isStatic <em>Static</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isMultiValued <em>Is Multi Valued</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateGetter <em>Generate Getter</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateSetter <em>Generate Setter</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField()
 * @model
 * @generated
 */
public interface JDTField extends JDTMember {

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getFields <em>Fields</em>}'.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent() <em>Parent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(JDTType)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Owner()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getFields
	 * @model opposite="fields" required="true" transient="false" ordered="false"
	 * @generated
	 */
	JDTType getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(JDTType value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Abstract()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Final()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Static()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Multi Valued</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi Valued</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Multi Valued</em>' attribute.
	 * @see #setIsMultiValued(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_IsMultiValued()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isMultiValued <em>Is Multi Valued</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Multi Valued</em>' attribute.
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
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JDTType)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Type()
	 * @model ordered="false"
	 * @generated
	 */
	JDTType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JDTType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_Value()
	 * @model dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.String" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Generate Getter</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Getter</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Generate Getter</em>' attribute.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @see #setGenerateGetter(TrueFalseDefault)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_GenerateGetter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TrueFalseDefault getGenerateGetter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateGetter <em>Generate Getter</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Generate Getter</em>' attribute.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @see #getGenerateGetter()
	 * @generated
	 */
	void setGenerateGetter(TrueFalseDefault value);

	/**
	 * Returns the value of the '<em><b>Generate Setter</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Setter</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Generate Setter</em>' attribute.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @see #setGenerateSetter(TrueFalseDefault)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTField_GenerateSetter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TrueFalseDefault getGenerateSetter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateSetter <em>Generate Setter</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Generate Setter</em>' attribute.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @see #getGenerateSetter()
	 * @generated
	 */
	void setGenerateSetter(TrueFalseDefault value);

} // JDTField
