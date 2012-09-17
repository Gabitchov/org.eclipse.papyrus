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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#isIsPreemptible <em>Is Preemptible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedPolicy <em>Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getOtherSchedPolicy <em>Other Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProcessingUnits <em>Processing Units</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getHost <em>Host</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProtectedSharedResources <em>Protected Shared Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedulableResources <em>Schedulable Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler()
 * @model
 * @generated
 */
public interface Scheduler extends Resource {
	/**
	 * Returns the value of the '<em><b>Is Preemptible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Preemptible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Preemptible</em>' attribute.
	 * @see #setIsPreemptible(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_IsPreemptible()
	 * @model default="true" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsPreemptible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#isIsPreemptible <em>Is Preemptible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Preemptible</em>' attribute.
	 * @see #isIsPreemptible()
	 * @generated
	 */
	void setIsPreemptible(boolean value);

	/**
	 * Returns the value of the '<em><b>Sched Policy</b></em>' attribute.
	 * The default value is <code>"FixedPriority"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @see #setSchedPolicy(SchedPolicyKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_SchedPolicy()
	 * @model default="FixedPriority" unique="false" ordered="false"
	 * @generated
	 */
	SchedPolicyKind getSchedPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedPolicy <em>Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sched Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @see #getSchedPolicy()
	 * @generated
	 */
	void setSchedPolicy(SchedPolicyKind value);

	/**
	 * Returns the value of the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Sched Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Sched Policy</em>' attribute.
	 * @see #setOtherSchedPolicy(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_OtherSchedPolicy()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.String" ordered="false"
	 * @generated
	 */
	String getOtherSchedPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getOtherSchedPolicy <em>Other Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Sched Policy</em>' attribute.
	 * @see #getOtherSchedPolicy()
	 * @generated
	 */
	void setOtherSchedPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' attribute.
	 * @see #setSchedule(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_Schedule()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ScheduleSpecification" ordered="false"
	 * @generated
	 */
	String getSchedule();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedule <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' attribute.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(String value);

	/**
	 * Returns the value of the '<em><b>Processing Units</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Units</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Units</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_ProcessingUnits()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ProcessingResource> getProcessingUnits();

	/**
	 * Returns the value of the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' reference.
	 * @see #setHost(ComputingResource)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_Host()
	 * @model ordered="false"
	 * @generated
	 */
	ComputingResource getHost();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getHost <em>Host</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' reference.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(ComputingResource value);

	/**
	 * Returns the value of the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protected Shared Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protected Shared Resources</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_ProtectedSharedResources()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler
	 * @model opposite="scheduler" ordered="false"
	 * @generated
	 */
	EList<MutualExclusionResource> getProtectedSharedResources();

	/**
	 * Returns the value of the '<em><b>Schedulable Resources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedulable Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedulable Resources</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getScheduler_SchedulableResources()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost
	 * @model opposite="host" ordered="false"
	 * @generated
	 */
	EList<SchedulableResource> getSchedulableResources();

} // Scheduler
