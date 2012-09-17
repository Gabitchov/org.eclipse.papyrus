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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource#getOp_Frequencies <em>Op Frequencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwComputingResource()
 * @model
 * @generated
 */
public interface HwComputingResource extends HwResource, ComputingResource {
	/**
	 * Returns the value of the '<em><b>Op Frequencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op Frequencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op Frequencies</em>' attribute.
	 * @see #setOp_Frequencies(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwComputingResource_Op_Frequencies()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.NFP_FrequencyInterval" ordered="false"
	 * @generated
	 */
	String getOp_Frequencies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource#getOp_Frequencies <em>Op Frequencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op Frequencies</em>' attribute.
	 * @see #getOp_Frequencies()
	 * @generated
	 */
	void setOp_Frequencies(String value);

} // HwComputingResource
