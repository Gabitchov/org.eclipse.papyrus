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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rt Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Message <em>Base Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Signal <em>Base Signal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_InvocationAction <em>Base Invocation Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature()
 * @model
 * @generated
 */
public interface RtFeature extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavioral Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behavioral Feature</em>' reference.
	 * @see #setBase_BehavioralFeature(BehavioralFeature)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Base_BehavioralFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BehavioralFeature getBase_BehavioralFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behavioral Feature</em>' reference.
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 */
	void setBase_BehavioralFeature(BehavioralFeature value);

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
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Base_Message()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Message getBase_Message();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Message <em>Base Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Message</em>' reference.
	 * @see #getBase_Message()
	 * @generated
	 */
	void setBase_Message(Message value);

	/**
	 * Returns the value of the '<em><b>Base Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Signal</em>' reference.
	 * @see #setBase_Signal(Signal)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Base_Signal()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signal getBase_Signal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Signal <em>Base Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Signal</em>' reference.
	 * @see #getBase_Signal()
	 * @generated
	 */
	void setBase_Signal(Signal value);

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Base Invocation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Invocation Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Invocation Action</em>' reference.
	 * @see #setBase_InvocationAction(InvocationAction)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Base_InvocationAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InvocationAction getBase_InvocationAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_InvocationAction <em>Base Invocation Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Invocation Action</em>' reference.
	 * @see #getBase_InvocationAction()
	 * @generated
	 */
	void setBase_InvocationAction(InvocationAction value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtFeature_Specification()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<RtSpecification> getSpecification();

} // RtFeature
