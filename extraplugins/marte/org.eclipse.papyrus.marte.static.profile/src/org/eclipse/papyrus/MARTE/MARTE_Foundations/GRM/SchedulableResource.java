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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedulable Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getSchedParams <em>Sched Params</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler <em>Dependent Scheduler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost <em>Host</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSchedulableResource()
 * @model
 * @generated
 */
public interface SchedulableResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Sched Params</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Params</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Params</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSchedulableResource_SchedParams()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedParameters" ordered="false"
	 * @generated
	 */
	EList<String> getSchedParams();

	/**
	 * Returns the value of the '<em><b>Dependent Scheduler</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler#getVirtualProcessingUnits <em>Virtual Processing Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependent Scheduler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependent Scheduler</em>' reference.
	 * @see #setDependentScheduler(SecondaryScheduler)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSchedulableResource_DependentScheduler()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler#getVirtualProcessingUnits
	 * @model opposite="virtualProcessingUnits" ordered="false"
	 * @generated
	 */
	SecondaryScheduler getDependentScheduler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler <em>Dependent Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Scheduler</em>' reference.
	 * @see #getDependentScheduler()
	 * @generated
	 */
	void setDependentScheduler(SecondaryScheduler value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedulableResources <em>Schedulable Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' reference.
	 * @see #setHost(Scheduler)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSchedulableResource_Host()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedulableResources
	 * @model opposite="schedulableResources" ordered="false"
	 * @generated
	 */
	Scheduler getHost();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost <em>Host</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' reference.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(Scheduler value);

} // SchedulableResource
