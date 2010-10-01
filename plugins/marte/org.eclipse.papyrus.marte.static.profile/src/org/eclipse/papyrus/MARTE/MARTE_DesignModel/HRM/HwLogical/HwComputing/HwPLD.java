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

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwRAM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw PLD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getTechnology <em>Technology</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNbLUTs <em>Nb LU Ts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNdLUT_Inputs <em>Nd LUT Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNbFlipFlops <em>Nb Flip Flops</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getBlocksRAM <em>Blocks RAM</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getBlocksComputing <em>Blocks Computing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD()
 * @model
 * @generated
 */
public interface HwPLD extends HwComputingResource {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Technology}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technology</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Technology
	 * @see #setTechnology(PLD_Technology)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_Technology()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	PLD_Technology getTechnology();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getTechnology <em>Technology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Technology
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(PLD_Technology value);

	/**
	 * Returns the value of the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' attribute.
	 * @see #setOrganization(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_Organization()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Organization" ordered="false"
	 * @generated
	 */
	String getOrganization();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getOrganization <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' attribute.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(String value);

	/**
	 * Returns the value of the '<em><b>Nb LU Ts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb LU Ts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb LU Ts</em>' attribute.
	 * @see #setNbLUTs(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_NbLUTs()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbLUTs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNbLUTs <em>Nb LU Ts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb LU Ts</em>' attribute.
	 * @see #getNbLUTs()
	 * @generated
	 */
	void setNbLUTs(String value);

	/**
	 * Returns the value of the '<em><b>Nd LUT Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nd LUT Inputs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nd LUT Inputs</em>' attribute.
	 * @see #setNdLUT_Inputs(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_NdLUT_Inputs()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNdLUT_Inputs();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNdLUT_Inputs <em>Nd LUT Inputs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nd LUT Inputs</em>' attribute.
	 * @see #getNdLUT_Inputs()
	 * @generated
	 */
	void setNdLUT_Inputs(String value);

	/**
	 * Returns the value of the '<em><b>Nb Flip Flops</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Flip Flops</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Flip Flops</em>' attribute.
	 * @see #setNbFlipFlops(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_NbFlipFlops()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Natural" ordered="false"
	 * @generated
	 */
	String getNbFlipFlops();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD#getNbFlipFlops <em>Nb Flip Flops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Flip Flops</em>' attribute.
	 * @see #getNbFlipFlops()
	 * @generated
	 */
	void setNbFlipFlops(String value);

	/**
	 * Returns the value of the '<em><b>Blocks RAM</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwRAM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks RAM</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks RAM</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_BlocksRAM()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwRAM> getBlocksRAM();

	/**
	 * Returns the value of the '<em><b>Blocks Computing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks Computing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks Computing</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#getHwPLD_BlocksComputing()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HwComputingResource> getBlocksComputing();

} // HwPLD
