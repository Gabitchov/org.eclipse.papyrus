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
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM;

import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tiler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getPaving <em>Paving</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getFitting <em>Fitting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getTiler <em>Tiler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getBase_ConnectorEnd <em>Base Connector End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler()
 * @model
 * @generated
 */
public interface Tiler extends LinkTopology {
	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see #setOrigin(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler_Origin()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.IntegerVector" ordered="false"
	 * @generated
	 */
	String getOrigin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

	/**
	 * Returns the value of the '<em><b>Paving</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paving</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paving</em>' attribute.
	 * @see #setPaving(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler_Paving()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.IntegerMatrix" ordered="false"
	 * @generated
	 */
	String getPaving();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getPaving <em>Paving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paving</em>' attribute.
	 * @see #getPaving()
	 * @generated
	 */
	void setPaving(String value);

	/**
	 * Returns the value of the '<em><b>Fitting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fitting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fitting</em>' attribute.
	 * @see #setFitting(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler_Fitting()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.IntegerMatrix" ordered="false"
	 * @generated
	 */
	String getFitting();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getFitting <em>Fitting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fitting</em>' attribute.
	 * @see #getFitting()
	 * @generated
	 */
	void setFitting(String value);

	/**
	 * Returns the value of the '<em><b>Tiler</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiler</em>' attribute.
	 * @see #setTiler(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler_Tiler()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.TilerSpecification" ordered="false"
	 * @generated
	 */
	String getTiler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getTiler <em>Tiler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiler</em>' attribute.
	 * @see #getTiler()
	 * @generated
	 */
	void setTiler(String value);

	/**
	 * Returns the value of the '<em><b>Base Connector End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector End</em>' reference.
	 * @see #setBase_ConnectorEnd(ConnectorEnd)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getTiler_Base_ConnectorEnd()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectorEnd getBase_ConnectorEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler#getBase_ConnectorEnd <em>Base Connector End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector End</em>' reference.
	 * @see #getBase_ConnectorEnd()
	 * @generated
	 */
	void setBase_ConnectorEnd(ConnectorEnd value);

} // Tiler
