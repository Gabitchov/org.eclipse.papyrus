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

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwCache;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwMMU;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getMips <em>Mips</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getIpc <em>Ipc</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbCores <em>Nb Cores</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbPipelines <em>Nb Pipelines</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbStages <em>Nb Stages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbALUs <em>Nb AL Us</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbFPUs <em>Nb FP Us</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getOwnedISAs <em>Owned IS As</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getPredictors <em>Predictors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getCaches <em>Caches</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getOwnedMMUs <em>Owned MM Us</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor()
 * @model
 * @generated
 */
public interface HwProcessor extends HwComputingResource {
	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Architecture</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #setArchitecture(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_Architecture()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getArchitecture();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Mips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mips</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mips</em>' attribute.
	 * @see #setMips(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_Mips()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getMips();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getMips <em>Mips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mips</em>' attribute.
	 * @see #getMips()
	 * @generated
	 */
	void setMips(String value);

	/**
	 * Returns the value of the '<em><b>Ipc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ipc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ipc</em>' attribute.
	 * @see #setIpc(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_Ipc()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getIpc();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getIpc <em>Ipc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ipc</em>' attribute.
	 * @see #getIpc()
	 * @generated
	 */
	void setIpc(String value);

	/**
	 * Returns the value of the '<em><b>Nb Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Cores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Cores</em>' attribute.
	 * @see #setNbCores(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_NbCores()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbCores();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbCores <em>Nb Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Cores</em>' attribute.
	 * @see #getNbCores()
	 * @generated
	 */
	void setNbCores(String value);

	/**
	 * Returns the value of the '<em><b>Nb Pipelines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Pipelines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Pipelines</em>' attribute.
	 * @see #setNbPipelines(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_NbPipelines()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbPipelines();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbPipelines <em>Nb Pipelines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Pipelines</em>' attribute.
	 * @see #getNbPipelines()
	 * @generated
	 */
	void setNbPipelines(String value);

	/**
	 * Returns the value of the '<em><b>Nb Stages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Stages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Stages</em>' attribute.
	 * @see #setNbStages(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_NbStages()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbStages();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbStages <em>Nb Stages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Stages</em>' attribute.
	 * @see #getNbStages()
	 * @generated
	 */
	void setNbStages(String value);

	/**
	 * Returns the value of the '<em><b>Nb AL Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb AL Us</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb AL Us</em>' attribute.
	 * @see #setNbALUs(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_NbALUs()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbALUs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbALUs <em>Nb AL Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb AL Us</em>' attribute.
	 * @see #getNbALUs()
	 * @generated
	 */
	void setNbALUs(String value);

	/**
	 * Returns the value of the '<em><b>Nb FP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb FP Us</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb FP Us</em>' attribute.
	 * @see #setNbFPUs(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_NbFPUs()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbFPUs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor#getNbFPUs <em>Nb FP Us</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb FP Us</em>' attribute.
	 * @see #getNbFPUs()
	 * @generated
	 */
	void setNbFPUs(String value);

	/**
	 * Returns the value of the '<em><b>Owned IS As</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwISA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned IS As</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned IS As</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_OwnedISAs()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwISA> getOwnedISAs();

	/**
	 * Returns the value of the '<em><b>Predictors</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwBranchPredictor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predictors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predictors</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_Predictors()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwBranchPredictor> getPredictors();

	/**
	 * Returns the value of the '<em><b>Caches</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwCache}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caches</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caches</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_Caches()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwCache> getCaches();

	/**
	 * Returns the value of the '<em><b>Owned MM Us</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwMMU}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned MM Us</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned MM Us</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwProcessor_OwnedMMUs()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwMMU> getOwnedMMUs();

} // HwProcessor
