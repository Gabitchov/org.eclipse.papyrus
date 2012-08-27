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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getSpeedFactor <em>Speed Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getMainScheduler <em>Main Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getProcessingResource()
 * @model
 * @generated
 */
public interface ProcessingResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Speed Factor</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Factor</em>' attribute.
	 * @see #setSpeedFactor(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getProcessingResource_SpeedFactor()
	 * @model default="1.0" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getSpeedFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getSpeedFactor <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Factor</em>' attribute.
	 * @see #getSpeedFactor()
	 * @generated
	 */
	void setSpeedFactor(String value);

	/**
	 * Returns the value of the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Scheduler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Scheduler</em>' reference.
	 * @see #setMainScheduler(Scheduler)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getProcessingResource_MainScheduler()
	 * @model ordered="false"
	 * @generated
	 */
	Scheduler getMainScheduler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getMainScheduler <em>Main Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Scheduler</em>' reference.
	 * @see #getMainScheduler()
	 * @generated
	 */
	void setMainScheduler(Scheduler value);

} // ProcessingResource
