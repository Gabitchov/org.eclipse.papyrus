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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rt Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsDynamic <em>Is Dynamic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsMain <em>Is Main</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolSize <em>Sr Pool Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolPolicy <em>Sr Pool Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolWaitingTime <em>Sr Pool Waiting Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getOperationalMode <em>Operational Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMain <em>Main</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSchedPolicy <em>Queue Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSize <em>Queue Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMsgMaxSize <em>Msg Max Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit()
 * @model
 * @generated
 */
public interface RtUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Dynamic</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dynamic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dynamic</em>' attribute.
	 * @see #setIsDynamic(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_IsDynamic()
	 * @model default="true" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsDynamic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsDynamic <em>Is Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dynamic</em>' attribute.
	 * @see #isIsDynamic()
	 * @generated
	 */
	void setIsDynamic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Main</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Main</em>' attribute.
	 * @see #setIsMain(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_IsMain()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsMain();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsMain <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Main</em>' attribute.
	 * @see #isIsMain()
	 * @generated
	 */
	void setIsMain(boolean value);

	/**
	 * Returns the value of the '<em><b>Sr Pool Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sr Pool Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sr Pool Size</em>' attribute.
	 * @see #setSrPoolSize(int)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_SrPoolSize()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Integer" ordered="false"
	 * @generated
	 */
	int getSrPoolSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolSize <em>Sr Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sr Pool Size</em>' attribute.
	 * @see #getSrPoolSize()
	 * @generated
	 */
	void setSrPoolSize(int value);

	/**
	 * Returns the value of the '<em><b>Sr Pool Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sr Pool Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sr Pool Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind
	 * @see #setSrPoolPolicy(PoolMgtPolicyKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_SrPoolPolicy()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	PoolMgtPolicyKind getSrPoolPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolPolicy <em>Sr Pool Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sr Pool Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind
	 * @see #getSrPoolPolicy()
	 * @generated
	 */
	void setSrPoolPolicy(PoolMgtPolicyKind value);

	/**
	 * Returns the value of the '<em><b>Sr Pool Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sr Pool Waiting Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sr Pool Waiting Time</em>' attribute.
	 * @see #setSrPoolWaitingTime(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_SrPoolWaitingTime()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getSrPoolWaitingTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolWaitingTime <em>Sr Pool Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sr Pool Waiting Time</em>' attribute.
	 * @see #getSrPoolWaitingTime()
	 * @generated
	 */
	void setSrPoolWaitingTime(String value);

	/**
	 * Returns the value of the '<em><b>Operational Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Mode</em>' reference.
	 * @see #setOperationalMode(Behavior)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_OperationalMode()
	 * @model ordered="false"
	 * @generated
	 */
	Behavior getOperationalMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getOperationalMode <em>Operational Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operational Mode</em>' reference.
	 * @see #getOperationalMode()
	 * @generated
	 */
	void setOperationalMode(Behavior value);

	/**
	 * Returns the value of the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' reference.
	 * @see #setMain(Operation)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_Main()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getMain();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMain <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(Operation value);

	/**
	 * Returns the value of the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Size</em>' attribute.
	 * @see #setMemorySize(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_MemorySize()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getMemorySize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(String value);

	/**
	 * Returns the value of the '<em><b>Base Behaviored Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behaviored Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behaviored Classifier</em>' reference.
	 * @see #setBase_BehavioredClassifier(BehavioredClassifier)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_Base_BehavioredClassifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BehavioredClassifier getBase_BehavioredClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behaviored Classifier</em>' reference.
	 * @see #getBase_BehavioredClassifier()
	 * @generated
	 */
	void setBase_BehavioredClassifier(BehavioredClassifier value);

	/**
	 * Returns the value of the '<em><b>Queue Sched Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Sched Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Sched Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @see #setQueueSchedPolicy(SchedPolicyKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_QueueSchedPolicy()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	SchedPolicyKind getQueueSchedPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSchedPolicy <em>Queue Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Sched Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @see #getQueueSchedPolicy()
	 * @generated
	 */
	void setQueueSchedPolicy(SchedPolicyKind value);

	/**
	 * Returns the value of the '<em><b>Queue Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Size</em>' attribute.
	 * @see #setQueueSize(int)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_QueueSize()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Integer" ordered="false"
	 * @generated
	 */
	int getQueueSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSize <em>Queue Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Size</em>' attribute.
	 * @see #getQueueSize()
	 * @generated
	 */
	void setQueueSize(int value);

	/**
	 * Returns the value of the '<em><b>Msg Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg Max Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg Max Size</em>' attribute.
	 * @see #setMsgMaxSize(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage#getRtUnit_MsgMaxSize()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getMsgMaxSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMsgMaxSize <em>Msg Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg Max Size</em>' attribute.
	 * @see #getMsgMaxSize()
	 * @generated
	 */
	void setMsgMaxSize(String value);

} // RtUnit
