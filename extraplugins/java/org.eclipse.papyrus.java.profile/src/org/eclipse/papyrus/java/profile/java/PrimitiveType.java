/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getBase_PrimitiveType <em>Base Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends JavaGen {
	/**
	 * Returns the value of the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Class</em>' attribute.
	 * @see #setImplementationClass(String)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getPrimitiveType_ImplementationClass()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getImplementationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getImplementationClass <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class</em>' attribute.
	 * @see #getImplementationClass()
	 * @generated
	 */
	void setImplementationClass(String value);

	/**
	 * Returns the value of the '<em><b>Base Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Primitive Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Primitive Type</em>' reference.
	 * @see #setBase_PrimitiveType(org.eclipse.uml2.uml.PrimitiveType)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getPrimitiveType_Base_PrimitiveType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.PrimitiveType getBase_PrimitiveType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.PrimitiveType#getBase_PrimitiveType <em>Base Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Primitive Type</em>' reference.
	 * @see #getBase_PrimitiveType()
	 * @generated
	 */
	void setBase_PrimitiveType(org.eclipse.uml2.uml.PrimitiveType value);

} // PrimitiveType
