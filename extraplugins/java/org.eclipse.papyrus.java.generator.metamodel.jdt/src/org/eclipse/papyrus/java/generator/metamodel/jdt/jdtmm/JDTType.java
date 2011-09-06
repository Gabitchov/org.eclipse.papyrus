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
 * A representation of the model object '<em><b>JDT Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getMethods <em>Methods</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getCompilationUnit <em>Compilation Unit</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isClass <em>Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isInterface <em>Interface</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isEnum <em>Enum</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isAbstract <em>Abstract</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isFinal <em>Final</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isStatic <em>Static</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getTypes <em>Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaces <em>Super Interfaces</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClass <em>Super Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaceNames <em>Super Interface Names</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClassName <em>Super Class Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType()
 * @model abstract="true"
 * @generated
 */
public interface JDTType extends JDTMember {

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getOwner <em>Owner</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren() <em>Children</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Methods()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<JDTMethod> getMethods();

	/**
	 * Returns the value of the '<em><b>Compilation Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getTypes
	 * <em>Types</em>}'.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent() <em>Parent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compilation Unit</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Compilation Unit</em>' container reference.
	 * @see #setCompilationUnit(JDTCompilationUnit)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_CompilationUnit()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getTypes
	 * @model opposite="types" transient="false" ordered="false"
	 * @generated
	 */
	JDTCompilationUnit getCompilationUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getCompilationUnit <em>Compilation Unit</em>}'
	 * container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Compilation Unit</em>' container reference.
	 * @see #getCompilationUnit()
	 * @generated
	 */
	void setCompilationUnit(JDTCompilationUnit value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass_(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Class()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isClass <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Class</em>' attribute.
	 * @see #isClass()
	 * @generated
	 */
	void setClass_(boolean value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Interface()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Enum</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enum</em>' attribute.
	 * @see #setEnum(boolean)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Enum()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isEnum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isEnum <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Enum</em>' attribute.
	 * @see #isEnum()
	 * @generated
	 */
	void setEnum(boolean value);

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
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Abstract()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isAbstract <em>Abstract</em>}' attribute.
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
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Final()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isFinal <em>Final</em>}' attribute.
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
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Static()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.boolean" required="true"
	 *        transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isStatic <em>Static</em>}' attribute.
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
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner <em>Owner</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren() <em>Children</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Types()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<JDTType> getTypes();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getTypes <em>Types</em>}'.
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
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Owner()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getTypes
	 * @model opposite="types" transient="false" ordered="false"
	 * @generated
	 */
	JDTType getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner <em>Owner</em>}' container reference.
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
	 * Returns the value of the '<em><b>Super Interfaces</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Interfaces</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Interfaces</em>' reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_SuperInterfaces()
	 * @model ordered="false"
	 * @generated
	 */
	EList<JDTType> getSuperInterfaces();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(JDTType)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_SuperClass()
	 * @model ordered="false"
	 * @generated
	 */
	JDTType getSuperClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(JDTType value);

	/**
	 * Returns the value of the '<em><b>Super Interface Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Interface Names</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Interface Names</em>' attribute list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_SuperInterfaceNames()
	 * @model unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.String" transient="true" changeable="false"
	 *        volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<String> getSuperInterfaceNames();

	/**
	 * Returns the value of the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class Name</em>' attribute.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_SuperClassName()
	 * @model unique="false" dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.String" required="true" transient="true"
	 *        changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getSuperClassName();

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner <em>Owner</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren() <em>Children</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTType_Fields()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<JDTField> getFields();

} // JDTType
