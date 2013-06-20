/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Status</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPENDING <em>PENDING</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getACTIVE <em>ACTIVE</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPREEMPTED <em>PREEMPTED
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getSUCCEEDED <em>SUCCEEDED
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getABORTED <em>ABORTED</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getREJECTED <em>REJECTED
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPREEMPTING <em>PREEMPTING
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getRECALLING <em>RECALLING
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getRECALLED <em>RECALLED
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getLOST <em>LOST</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getText <em>Text</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus()
 * @model
 * @generated
 */
public interface GoalStatus extends EObject {

	/**
	 * Returns the value of the '<em><b>PENDING</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PENDING</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>PENDING</em>' attribute.
	 * @see #setPENDING(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_PENDING()
	 * @model default="0" dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getPENDING();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPENDING <em>PENDING</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>PENDING</em>' attribute.
	 * @see #getPENDING()
	 * @generated
	 */
	void setPENDING(char value);

	/**
	 * Returns the value of the '<em><b>ACTIVE</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ACTIVE</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>ACTIVE</em>' attribute.
	 * @see #setACTIVE(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_ACTIVE()
	 * @model default="1" dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getACTIVE();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getACTIVE <em>ACTIVE</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>ACTIVE</em>' attribute.
	 * @see #getACTIVE()
	 * @generated
	 */
	void setACTIVE(char value);

	/**
	 * Returns the value of the '<em><b>PREEMPTED</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PREEMPTED</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>PREEMPTED</em>' attribute.
	 * @see #setPREEMPTED(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_PREEMPTED()
	 * @model default="2" dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getPREEMPTED();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPREEMPTED
	 * <em>PREEMPTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>PREEMPTED</em>' attribute.
	 * @see #getPREEMPTED()
	 * @generated
	 */
	void setPREEMPTED(char value);

	/**
	 * Returns the value of the '<em><b>SUCCEEDED</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SUCCEEDED</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SUCCEEDED</em>' attribute.
	 * @see #setSUCCEEDED(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_SUCCEEDED()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getSUCCEEDED();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getSUCCEEDED
	 * <em>SUCCEEDED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>SUCCEEDED</em>' attribute.
	 * @see #getSUCCEEDED()
	 * @generated
	 */
	void setSUCCEEDED(char value);

	/**
	 * Returns the value of the '<em><b>ABORTED</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ABORTED</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>ABORTED</em>' attribute.
	 * @see #setABORTED(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_ABORTED()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getABORTED();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getABORTED <em>ABORTED</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>ABORTED</em>' attribute.
	 * @see #getABORTED()
	 * @generated
	 */
	void setABORTED(char value);

	/**
	 * Returns the value of the '<em><b>REJECTED</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>REJECTED</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>REJECTED</em>' attribute.
	 * @see #setREJECTED(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_REJECTED()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getREJECTED();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getREJECTED
	 * <em>REJECTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>REJECTED</em>' attribute.
	 * @see #getREJECTED()
	 * @generated
	 */
	void setREJECTED(char value);

	/**
	 * Returns the value of the '<em><b>PREEMPTING</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PREEMPTING</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>PREEMPTING</em>' attribute.
	 * @see #setPREEMPTING(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_PREEMPTING()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getPREEMPTING();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getPREEMPTING
	 * <em>PREEMPTING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>PREEMPTING</em>' attribute.
	 * @see #getPREEMPTING()
	 * @generated
	 */
	void setPREEMPTING(char value);

	/**
	 * Returns the value of the '<em><b>RECALLING</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RECALLING</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>RECALLING</em>' attribute.
	 * @see #setRECALLING(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_RECALLING()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getRECALLING();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getRECALLING
	 * <em>RECALLING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>RECALLING</em>' attribute.
	 * @see #getRECALLING()
	 * @generated
	 */
	void setRECALLING(char value);

	/**
	 * Returns the value of the '<em><b>RECALLED</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RECALLED</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>RECALLED</em>' attribute.
	 * @see #setRECALLED(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_RECALLED()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getRECALLED();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getRECALLED
	 * <em>RECALLED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>RECALLED</em>' attribute.
	 * @see #getRECALLED()
	 * @generated
	 */
	void setRECALLED(char value);

	/**
	 * Returns the value of the '<em><b>LOST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LOST</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>LOST</em>' attribute.
	 * @see #setLOST(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_LOST()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getLOST();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getLOST <em>LOST</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>LOST</em>' attribute.
	 * @see #getLOST()
	 * @generated
	 */
	void setLOST(char value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_Text()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getText <em>Text</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage#getGoalStatus_Status()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getStatus();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus#getStatus <em>Status</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(char value);

} // GoalStatus
