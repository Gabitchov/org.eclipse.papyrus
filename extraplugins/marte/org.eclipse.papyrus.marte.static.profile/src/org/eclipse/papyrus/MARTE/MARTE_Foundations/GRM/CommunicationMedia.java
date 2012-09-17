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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind;
import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Media</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getElementSize <em>Element Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getTransmMode <em>Transm Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBlockT <em>Block T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getPacketT <em>Packet T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getCapacity <em>Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia()
 * @model
 * @generated
 */
public interface CommunicationMedia extends ProcessingResource {
	/**
	 * Returns the value of the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Size</em>' attribute.
	 * @see #setElementSize(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_ElementSize()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getElementSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getElementSize <em>Element Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Size</em>' attribute.
	 * @see #getElementSize()
	 * @generated
	 */
	void setElementSize(String value);

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>Transm Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transm Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transm Mode</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind
	 * @see #setTransmMode(TransmModeKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_TransmMode()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	TransmModeKind getTransmMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getTransmMode <em>Transm Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transm Mode</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.TransmModeKind
	 * @see #getTransmMode()
	 * @generated
	 */
	void setTransmMode(TransmModeKind value);

	/**
	 * Returns the value of the '<em><b>Block T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block T</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_BlockT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getBlockT();

	/**
	 * Returns the value of the '<em><b>Packet T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packet T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packet T</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_PacketT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getPacketT();

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getCommunicationMedia_Capacity()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataTxRate" ordered="false"
	 * @generated
	 */
	EList<String> getCapacity();

} // CommunicationMedia
