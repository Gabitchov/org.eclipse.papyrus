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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource;

import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sw Timer Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource#getDurationElements <em>Duration Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage#getSwTimerResource()
 * @model
 * @generated
 */
public interface SwTimerResource extends TimerResource {
	/**
	 * Returns the value of the '<em><b>Duration Elements</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration Elements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration Elements</em>' reference.
	 * @see #setDurationElements(TypedElement)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage#getSwTimerResource_DurationElements()
	 * @model ordered="false"
	 * @generated
	 */
	TypedElement getDurationElements();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource#getDurationElements <em>Duration Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration Elements</em>' reference.
	 * @see #getDurationElements()
	 * @generated
	 */
	void setDurationElements(TypedElement value);

} // SwTimerResource
