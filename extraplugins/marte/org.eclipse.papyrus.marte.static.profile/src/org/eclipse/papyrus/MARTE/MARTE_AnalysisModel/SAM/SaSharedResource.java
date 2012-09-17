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
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sa Shared Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsPreemp <em>Is Preemp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsConsum <em>Is Consum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getAcquisT <em>Acquis T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getReleaseT <em>Release T</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource()
 * @model
 * @generated
 */
public interface SaSharedResource extends MutualExclusionResource {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource_Capacity()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getCapacity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(String value);

	/**
	 * Returns the value of the '<em><b>Is Preemp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Preemp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Preemp</em>' attribute.
	 * @see #setIsPreemp(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource_IsPreemp()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsPreemp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsPreemp <em>Is Preemp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Preemp</em>' attribute.
	 * @see #getIsPreemp()
	 * @generated
	 */
	void setIsPreemp(String value);

	/**
	 * Returns the value of the '<em><b>Is Consum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Consum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Consum</em>' attribute.
	 * @see #setIsConsum(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource_IsConsum()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsConsum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsConsum <em>Is Consum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Consum</em>' attribute.
	 * @see #getIsConsum()
	 * @generated
	 */
	void setIsConsum(String value);

	/**
	 * Returns the value of the '<em><b>Acquis T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acquis T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquis T</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource_AcquisT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getAcquisT();

	/**
	 * Returns the value of the '<em><b>Release T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release T</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaSharedResource_ReleaseT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getReleaseT();

} // SaSharedResource
