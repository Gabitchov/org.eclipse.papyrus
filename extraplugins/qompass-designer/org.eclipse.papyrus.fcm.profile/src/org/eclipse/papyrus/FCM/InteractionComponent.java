/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Collaboration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.InteractionComponent#isForDistribution <em>For Distribution</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InteractionComponent#getConnectionPattern <em>Connection Pattern</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InteractionComponent#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getInteractionComponent()
 * @model
 * @generated
 */
public interface InteractionComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>For Distribution</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Distribution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Distribution</em>' attribute.
	 * @see #setForDistribution(boolean)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInteractionComponent_ForDistribution()
	 * @model default="false" unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isForDistribution();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InteractionComponent#isForDistribution <em>For Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Distribution</em>' attribute.
	 * @see #isForDistribution()
	 * @generated
	 */
	void setForDistribution(boolean value);

	/**
	 * Returns the value of the '<em><b>Connection Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Pattern</em>' reference.
	 * @see #setConnectionPattern(Collaboration)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInteractionComponent_ConnectionPattern()
	 * @model ordered="false"
	 * @generated
	 */
	Collaboration getConnectionPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InteractionComponent#getConnectionPattern <em>Connection Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Pattern</em>' reference.
	 * @see #getConnectionPattern()
	 * @generated
	 */
	void setConnectionPattern(Collaboration value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInteractionComponent_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InteractionComponent#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // InteractionComponent
