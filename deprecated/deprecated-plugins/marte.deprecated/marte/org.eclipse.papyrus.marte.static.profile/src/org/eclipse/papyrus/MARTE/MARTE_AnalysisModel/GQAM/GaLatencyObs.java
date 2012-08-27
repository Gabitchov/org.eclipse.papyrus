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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ga Latency Obs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getLatency <em>Latency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMiss <em>Miss</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getUtility <em>Utility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMaxJitter <em>Max Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaLatencyObs()
 * @model
 * @generated
 */
public interface GaLatencyObs extends GaTimedObs {
	/**
	 * Returns the value of the '<em><b>Latency</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latency</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latency</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaLatencyObs_Latency()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getLatency();

	/**
	 * Returns the value of the '<em><b>Miss</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Miss</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Miss</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaLatencyObs_Miss()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	EList<String> getMiss();

	/**
	 * Returns the value of the '<em><b>Utility</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utility</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utility</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaLatencyObs_Utility()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.UtilityType" ordered="false"
	 * @generated
	 */
	EList<String> getUtility();

	/**
	 * Returns the value of the '<em><b>Max Jitter</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Jitter</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Jitter</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaLatencyObs_MaxJitter()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getMaxJitter();

} // GaLatencyObs
