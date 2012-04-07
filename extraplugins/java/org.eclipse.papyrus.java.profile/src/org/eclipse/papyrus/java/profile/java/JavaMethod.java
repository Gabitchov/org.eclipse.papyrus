/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isNative <em>Is Native</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isSynchronized <em>Is Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isConstructor <em>Is Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaMethod#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod()
 * @model
 * @generated
 */
public interface JavaMethod extends JavaNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsStatic()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Final</em>' attribute.
	 * @see #setIsFinal(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsFinal()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsAbstract()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Native</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Native</em>' attribute.
	 * @see #setIsNative(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsNative()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isNative <em>Is Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setIsNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Synchronized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Synchronized</em>' attribute.
	 * @see #setIsSynchronized(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsSynchronized()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isSynchronized();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isSynchronized <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Synchronized</em>' attribute.
	 * @see #isSynchronized()
	 * @generated
	 */
	void setIsSynchronized(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Constructor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Constructor</em>' attribute.
	 * @see #setIsConstructor(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_IsConstructor()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#isConstructor <em>Is Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Constructor</em>' attribute.
	 * @see #isConstructor()
	 * @generated
	 */
	void setIsConstructor(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Operation</em>' reference.
	 * @see #setBase_Operation(Operation)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaMethod#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

	/**
	 * Returns the value of the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Plain Text Required Imports</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Plain Text Required Imports</em>' attribute list.
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaMethod_ExplicitPlainTextRequiredImports()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getExplicitPlainTextRequiredImports();

} // JavaMethod
