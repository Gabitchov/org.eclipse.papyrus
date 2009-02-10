/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Hook</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The purpose of this class is point to an external class (for example java classes).
 * the classpath is the path to the this extenal class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook#getClasspath <em>Classpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExternalHook()
 * @model
 * @generated
 */
public interface ExternalHook extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classpath</em>' attribute.
	 * @see #setClasspath(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExternalHook_Classpath()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getClasspath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(String value);

} // ExternalHook
