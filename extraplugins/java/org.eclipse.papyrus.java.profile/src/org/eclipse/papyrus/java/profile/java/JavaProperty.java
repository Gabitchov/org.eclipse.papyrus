/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateGetter <em>Generate Getter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateSetter <em>Generate Setter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty()
 * @model
 * @generated
 */
public interface JavaProperty extends JavaNamedElement {
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
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_IsAbstract()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

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
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_IsFinal()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_IsTransient()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Generate Getter</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.java.profile.java.TrueFalseDefault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Getter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Getter</em>' attribute.
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @see #setGenerateGetter(TrueFalseDefault)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_GenerateGetter()
	 * @model default="default" required="true" ordered="false"
	 * @generated
	 */
	TrueFalseDefault getGenerateGetter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateGetter <em>Generate Getter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Getter</em>' attribute.
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @see #getGenerateGetter()
	 * @generated
	 */
	void setGenerateGetter(TrueFalseDefault value);

	/**
	 * Returns the value of the '<em><b>Generate Setter</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.java.profile.java.TrueFalseDefault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Setter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Setter</em>' attribute.
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @see #setGenerateSetter(TrueFalseDefault)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_GenerateSetter()
	 * @model default="default" required="true" ordered="false"
	 * @generated
	 */
	TrueFalseDefault getGenerateSetter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#getGenerateSetter <em>Generate Setter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Setter</em>' attribute.
	 * @see org.eclipse.papyrus.java.profile.java.TrueFalseDefault
	 * @see #getGenerateSetter()
	 * @generated
	 */
	void setGenerateSetter(TrueFalseDefault value);

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
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_IsStatic()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaProperty#isStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

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
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaProperty_ExplicitPlainTextRequiredImports()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getExplicitPlainTextRequiredImports();

} // JavaProperty
