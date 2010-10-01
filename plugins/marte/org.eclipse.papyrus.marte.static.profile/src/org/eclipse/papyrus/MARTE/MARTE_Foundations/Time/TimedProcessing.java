/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Time;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Processing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Action <em>Base Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Message <em>Base Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getFinish <em>Finish</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing()
 * @model
 * @generated
 */
public interface TimedProcessing extends TimedElement {
	/**
	 * Returns the value of the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Action</em>' reference.
	 * @see #setBase_Action(Action)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Base_Action()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Action getBase_Action();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Action <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Action</em>' reference.
	 * @see #getBase_Action()
	 * @generated
	 */
	void setBase_Action(Action value);

	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Base_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Behavior <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Returns the value of the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Message</em>' reference.
	 * @see #setBase_Message(Message)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Base_Message()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Message getBase_Message();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Message <em>Base Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Message</em>' reference.
	 * @see #getBase_Message()
	 * @generated
	 */
	void setBase_Message(Message value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' containment reference.
	 * @see #setDuration(ValueSpecification)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Duration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ValueSpecification getDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getDuration <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' containment reference.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(ValueSpecification value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(Event)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Start()
	 * @model ordered="false"
	 * @generated
	 */
	Event getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Event value);

	/**
	 * Returns the value of the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish</em>' reference.
	 * @see #setFinish(Event)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedProcessing_Finish()
	 * @model ordered="false"
	 * @generated
	 */
	Event getFinish();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getFinish <em>Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish</em>' reference.
	 * @see #getFinish()
	 * @generated
	 */
	void setFinish(Event value);

} // TimedProcessing
