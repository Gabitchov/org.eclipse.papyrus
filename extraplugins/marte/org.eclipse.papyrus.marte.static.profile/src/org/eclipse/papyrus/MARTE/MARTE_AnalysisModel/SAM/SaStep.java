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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;
import org.eclipse.uml2.uml.BehavioralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sa Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSpareCap <em>Spare Cap</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSchSlack <em>Sch Slack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getPreemptT <em>Preempt T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getReadyT <em>Ready T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNonpreemptionBlocking <em>Nonpreemption Blocking</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSharedRes <em>Shared Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSelfSuspensionBlocking <em>Self Suspension Blocking</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNumberSelfSuspensions <em>Number Self Suspensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep()
 * @model
 * @generated
 */
public interface SaStep extends GaStep {
	/**
	 * Returns the value of the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavioral Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behavioral Feature</em>' reference.
	 * @see #setBase_BehavioralFeature(BehavioralFeature)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_Base_BehavioralFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BehavioralFeature getBase_BehavioralFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behavioral Feature</em>' reference.
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 */
	void setBase_BehavioralFeature(BehavioralFeature value);

	/**
	 * Returns the value of the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline</em>' attribute.
	 * @see #setDeadline(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_Deadline()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getDeadline();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getDeadline <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' attribute.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(String value);

	/**
	 * Returns the value of the '<em><b>Spare Cap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spare Cap</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spare Cap</em>' attribute.
	 * @see #setSpareCap(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_SpareCap()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getSpareCap();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSpareCap <em>Spare Cap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spare Cap</em>' attribute.
	 * @see #getSpareCap()
	 * @generated
	 */
	void setSpareCap(String value);

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
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_SchSlack()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getSchSlack();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSchSlack <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sch Slack</em>' attribute.
	 * @see #getSchSlack()
	 * @generated
	 */
	void setSchSlack(String value);

	/**
	 * Returns the value of the '<em><b>Preempt T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preempt T</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preempt T</em>' attribute.
	 * @see #setPreemptT(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_PreemptT()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getPreemptT();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getPreemptT <em>Preempt T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preempt T</em>' attribute.
	 * @see #getPreemptT()
	 * @generated
	 */
	void setPreemptT(String value);

	/**
	 * Returns the value of the '<em><b>Ready T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ready T</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ready T</em>' attribute.
	 * @see #setReadyT(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_ReadyT()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getReadyT();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getReadyT <em>Ready T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ready T</em>' attribute.
	 * @see #getReadyT()
	 * @generated
	 */
	void setReadyT(String value);

	/**
	 * Returns the value of the '<em><b>Nonpreemption Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nonpreemption Blocking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nonpreemption Blocking</em>' attribute.
	 * @see #setNonpreemptionBlocking(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_NonpreemptionBlocking()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getNonpreemptionBlocking();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNonpreemptionBlocking <em>Nonpreemption Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nonpreemption Blocking</em>' attribute.
	 * @see #getNonpreemptionBlocking()
	 * @generated
	 */
	void setNonpreemptionBlocking(String value);

	/**
	 * Returns the value of the '<em><b>Shared Res</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Res</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Res</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_SharedRes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SaSharedResource> getSharedRes();

	/**
	 * Returns the value of the '<em><b>Self Suspension Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Suspension Blocking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Suspension Blocking</em>' attribute.
	 * @see #setSelfSuspensionBlocking(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_SelfSuspensionBlocking()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getSelfSuspensionBlocking();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSelfSuspensionBlocking <em>Self Suspension Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Suspension Blocking</em>' attribute.
	 * @see #getSelfSuspensionBlocking()
	 * @generated
	 */
	void setSelfSuspensionBlocking(String value);

	/**
	 * Returns the value of the '<em><b>Number Self Suspensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Self Suspensions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Self Suspensions</em>' attribute.
	 * @see #setNumberSelfSuspensions(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaStep_NumberSelfSuspensions()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getNumberSelfSuspensions();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNumberSelfSuspensions <em>Number Self Suspensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Self Suspensions</em>' attribute.
	 * @see #getNumberSelfSuspensions()
	 * @generated
	 */
	void setNumberSelfSuspensions(String value);

} // SaStep
