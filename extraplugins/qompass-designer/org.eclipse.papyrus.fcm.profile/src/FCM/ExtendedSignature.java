/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TemplateSignature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ExtendedSignature#getBase_TemplateSignature <em>Base Template Signature</em>}</li>
 *   <li>{@link FCM.ExtendedSignature#getBaseSignature <em>Base Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getExtendedSignature()
 * @model
 * @generated
 */
public interface ExtendedSignature extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Template Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Template Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Template Signature</em>' reference.
	 * @see #setBase_TemplateSignature(TemplateSignature)
	 * @see FCM.FCMPackage#getExtendedSignature_Base_TemplateSignature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateSignature getBase_TemplateSignature();

	/**
	 * Sets the value of the '{@link FCM.ExtendedSignature#getBase_TemplateSignature <em>Base Template Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Template Signature</em>' reference.
	 * @see #getBase_TemplateSignature()
	 * @generated
	 */
	void setBase_TemplateSignature(TemplateSignature value);

	/**
	 * Returns the value of the '<em><b>Base Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Signature</em>' reference.
	 * @see #setBaseSignature(TemplateSignature)
	 * @see FCM.FCMPackage#getExtendedSignature_BaseSignature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateSignature getBaseSignature();

	/**
	 * Sets the value of the '{@link FCM.ExtendedSignature#getBaseSignature <em>Base Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Signature</em>' reference.
	 * @see #getBaseSignature()
	 * @generated
	 */
	void setBaseSignature(TemplateSignature value);

} // ExtendedSignature
