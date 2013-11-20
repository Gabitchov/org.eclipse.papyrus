/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interception Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionKind <em>Interception Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionSet <em>Interception Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptionRule()
 * @model
 * @generated
 */
public interface InterceptionRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Interception Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.FCM.InterceptionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interception Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interception Kind</em>' attribute.
	 * @see org.eclipse.papyrus.FCM.InterceptionKind
	 * @see #setInterceptionKind(InterceptionKind)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptionRule_InterceptionKind()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	InterceptionKind getInterceptionKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionKind <em>Interception Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interception Kind</em>' attribute.
	 * @see org.eclipse.papyrus.FCM.InterceptionKind
	 * @see #getInterceptionKind()
	 * @generated
	 */
	void setInterceptionKind(InterceptionKind value);

	/**
	 * Returns the value of the '<em><b>Interception Set</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interception Set</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interception Set</em>' reference list.
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptionRule_InterceptionSet()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Feature> getInterceptionSet();

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
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptionRule_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

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
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInterceptionRule_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // InterceptionRule
