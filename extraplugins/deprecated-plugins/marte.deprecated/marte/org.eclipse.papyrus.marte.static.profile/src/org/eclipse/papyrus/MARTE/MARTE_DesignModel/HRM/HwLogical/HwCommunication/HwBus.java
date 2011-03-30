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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hw Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getAdressWidth <em>Adress Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getWordWidth <em>Word Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getIsSynchronous <em>Is Synchronous</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getIsSerial <em>Is Serial</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#getHwBus()
 * @model
 * @generated
 */
public interface HwBus extends HwMedia {
	/**
	 * Returns the value of the '<em><b>Adress Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adress Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adress Width</em>' attribute.
	 * @see #setAdressWidth(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#getHwBus_AdressWidth()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getAdressWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getAdressWidth <em>Adress Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adress Width</em>' attribute.
	 * @see #getAdressWidth()
	 * @generated
	 */
	void setAdressWidth(String value);

	/**
	 * Returns the value of the '<em><b>Word Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Width</em>' attribute.
	 * @see #setWordWidth(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#getHwBus_WordWidth()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getWordWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getWordWidth <em>Word Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Width</em>' attribute.
	 * @see #getWordWidth()
	 * @generated
	 */
	void setWordWidth(String value);

	/**
	 * Returns the value of the '<em><b>Is Synchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Synchronous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Synchronous</em>' attribute.
	 * @see #setIsSynchronous(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#getHwBus_IsSynchronous()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsSynchronous();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getIsSynchronous <em>Is Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Synchronous</em>' attribute.
	 * @see #getIsSynchronous()
	 * @generated
	 */
	void setIsSynchronous(String value);

	/**
	 * Returns the value of the '<em><b>Is Serial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Serial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Serial</em>' attribute.
	 * @see #setIsSerial(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#getHwBus_IsSerial()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsSerial();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus#getIsSerial <em>Is Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Serial</em>' attribute.
	 * @see #getIsSerial()
	 * @generated
	 */
	void setIsSerial(String value);

} // HwBus
