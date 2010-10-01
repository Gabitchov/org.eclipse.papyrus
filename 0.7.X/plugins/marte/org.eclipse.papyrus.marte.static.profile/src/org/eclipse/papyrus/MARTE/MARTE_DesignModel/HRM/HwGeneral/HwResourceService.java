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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw Resource Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService#getConsumption <em>Consumption</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService#getDissipation <em>Dissipation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage#getHwResourceService()
 * @model
 * @generated
 */
public interface HwResourceService extends GrService {
	/**
	 * Returns the value of the '<em><b>Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consumption</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumption</em>' attribute.
	 * @see #setConsumption(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage#getHwResourceService_Consumption()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Power" ordered="false"
	 * @generated
	 */
	String getConsumption();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService#getConsumption <em>Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consumption</em>' attribute.
	 * @see #getConsumption()
	 * @generated
	 */
	void setConsumption(String value);

	/**
	 * Returns the value of the '<em><b>Dissipation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dissipation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dissipation</em>' attribute.
	 * @see #setDissipation(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage#getHwResourceService_Dissipation()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Power" ordered="false"
	 * @generated
	 */
	String getDissipation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService#getDissipation <em>Dissipation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dissipation</em>' attribute.
	 * @see #getDissipation()
	 * @generated
	 */
	void setDissipation(String value);

} // HwResourceService
