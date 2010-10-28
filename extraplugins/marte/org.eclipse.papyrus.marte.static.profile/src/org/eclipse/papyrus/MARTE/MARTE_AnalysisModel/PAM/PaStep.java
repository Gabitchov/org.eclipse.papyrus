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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pa Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getNoSync <em>No Sync</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getExtOpDemand <em>Ext Op Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getExtOpCount <em>Ext Op Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getBehavDemand <em>Behav Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getBehavCount <em>Behav Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep()
 * @model
 * @generated
 */
public interface PaStep extends GaStep {
	/**
	 * Returns the value of the '<em><b>No Sync</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Sync</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Sync</em>' attribute.
	 * @see #setNoSync(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep_NoSync()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getNoSync();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep#getNoSync <em>No Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Sync</em>' attribute.
	 * @see #getNoSync()
	 * @generated
	 */
	void setNoSync(String value);

	/**
	 * Returns the value of the '<em><b>Ext Op Demand</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ext Op Demand</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ext Op Demand</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep_ExtOpDemand()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.String"
	 * @generated
	 */
	EList<String> getExtOpDemand();

	/**
	 * Returns the value of the '<em><b>Ext Op Count</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ext Op Count</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ext Op Count</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep_ExtOpCount()
	 * @model default="1" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real"
	 * @generated
	 */
	EList<String> getExtOpCount();

	/**
	 * Returns the value of the '<em><b>Behav Demand</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behav Demand</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behav Demand</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep_BehavDemand()
	 * @model
	 * @generated
	 */
	EList<GaScenario> getBehavDemand();

	/**
	 * Returns the value of the '<em><b>Behav Count</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behav Count</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behav Count</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaStep_BehavCount()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real"
	 * @generated
	 */
	EList<String> getBehavCount();

} // PaStep
