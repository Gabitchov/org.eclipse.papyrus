/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;

import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaParameter#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaParameter#getBase_Parameter <em>Base Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaParameter()
 * @model
 * @generated
 */
public interface JavaParameter extends JavaNamedElement {
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
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaParameter_IsFinal()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaParameter#isFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Parameter</em>' reference.
	 * @see #setBase_Parameter(Parameter)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaParameter_Base_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getBase_Parameter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaParameter#getBase_Parameter <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Parameter</em>' reference.
	 * @see #getBase_Parameter()
	 * @generated
	 */
	void setBase_Parameter(Parameter value);

} // JavaParameter
