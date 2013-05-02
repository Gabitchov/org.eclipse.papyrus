/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interceptor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptorConfiguration#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptorConfiguration#getInterceptor <em>Interceptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptorConfiguration()
 * @model
 * @generated
 */
public interface InterceptorConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Slot</em>' reference.
	 * @see #setBase_Slot(Slot)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptorConfiguration_Base_Slot()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Slot getBase_Slot();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InterceptorConfiguration#getBase_Slot <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Slot</em>' reference.
	 * @see #getBase_Slot()
	 * @generated
	 */
	void setBase_Slot(Slot value);

	/**
	 * Returns the value of the '<em><b>Interceptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interceptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interceptor</em>' reference.
	 * @see #setInterceptor(Port)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptorConfiguration_Interceptor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getInterceptor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InterceptorConfiguration#getInterceptor <em>Interceptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interceptor</em>' reference.
	 * @see #getInterceptor()
	 * @generated
	 */
	void setInterceptor(Port value);

} // InterceptorConfiguration
