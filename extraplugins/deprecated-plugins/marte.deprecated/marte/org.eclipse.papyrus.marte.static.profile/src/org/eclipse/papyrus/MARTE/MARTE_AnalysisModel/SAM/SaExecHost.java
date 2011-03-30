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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sa Exec Host</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchSlack <em>Sch Slack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchedUtiliz <em>Sched Utiliz</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRswitchT <em>IS Rswitch T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRprioRange <em>IS Rprio Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost()
 * @model
 * @generated
 */
public interface SaExecHost extends GaExecHost {
	/**
	 * Returns the value of the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sched</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sched</em>' attribute.
	 * @see #setIsSched(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost_IsSched()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsSched();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getIsSched <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sched</em>' attribute.
	 * @see #getIsSched()
	 * @generated
	 */
	void setIsSched(String value);

	/**
	 * Returns the value of the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sch Slack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sch Slack</em>' attribute.
	 * @see #setSchSlack(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost_SchSlack()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getSchSlack();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchSlack <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sch Slack</em>' attribute.
	 * @see #getSchSlack()
	 * @generated
	 */
	void setSchSlack(String value);

	/**
	 * Returns the value of the '<em><b>Sched Utiliz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Utiliz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Utiliz</em>' attribute.
	 * @see #setSchedUtiliz(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost_SchedUtiliz()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getSchedUtiliz();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchedUtiliz <em>Sched Utiliz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sched Utiliz</em>' attribute.
	 * @see #getSchedUtiliz()
	 * @generated
	 */
	void setSchedUtiliz(String value);

	/**
	 * Returns the value of the '<em><b>IS Rswitch T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IS Rswitch T</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IS Rswitch T</em>' attribute.
	 * @see #setISRswitchT(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost_ISRswitchT()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getISRswitchT();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRswitchT <em>IS Rswitch T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IS Rswitch T</em>' attribute.
	 * @see #getISRswitchT()
	 * @generated
	 */
	void setISRswitchT(String value);

	/**
	 * Returns the value of the '<em><b>IS Rprio Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IS Rprio Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IS Rprio Range</em>' attribute.
	 * @see #setISRprioRange(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaExecHost_ISRprioRange()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.IntegerInterval" ordered="false"
	 * @generated
	 */
	String getISRprioRange();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRprioRange <em>IS Rprio Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IS Rprio Range</em>' attribute.
	 * @see #getISRprioRange()
	 * @generated
	 */
	void setISRprioRange(String value);

} // SaExecHost
