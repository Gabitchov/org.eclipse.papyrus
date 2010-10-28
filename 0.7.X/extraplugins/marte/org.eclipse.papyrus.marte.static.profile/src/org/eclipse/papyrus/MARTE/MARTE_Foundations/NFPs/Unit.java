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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvFactor <em>Conv Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvOffset <em>Conv Offset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBase_EnumerationLiteral <em>Base Enumeration Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Conv Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conv Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conv Factor</em>' attribute.
	 * @see #setConvFactor(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage#getUnit_ConvFactor()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" ordered="false"
	 * @generated
	 */
	String getConvFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvFactor <em>Conv Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conv Factor</em>' attribute.
	 * @see #getConvFactor()
	 * @generated
	 */
	void setConvFactor(String value);

	/**
	 * Returns the value of the '<em><b>Conv Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conv Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conv Offset</em>' attribute.
	 * @see #setConvOffset(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage#getUnit_ConvOffset()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Real" ordered="false"
	 * @generated
	 */
	String getConvOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvOffset <em>Conv Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conv Offset</em>' attribute.
	 * @see #getConvOffset()
	 * @generated
	 */
	void setConvOffset(String value);

	/**
	 * Returns the value of the '<em><b>Base Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Unit</em>' reference.
	 * @see #setBaseUnit(Unit)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage#getUnit_BaseUnit()
	 * @model ordered="false"
	 * @generated
	 */
	Unit getBaseUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBaseUnit <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Unit</em>' reference.
	 * @see #getBaseUnit()
	 * @generated
	 */
	void setBaseUnit(Unit value);

	/**
	 * Returns the value of the '<em><b>Base Enumeration Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Enumeration Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Enumeration Literal</em>' reference.
	 * @see #setBase_EnumerationLiteral(EnumerationLiteral)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage#getUnit_Base_EnumerationLiteral()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumerationLiteral getBase_EnumerationLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBase_EnumerationLiteral <em>Base Enumeration Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Enumeration Literal</em>' reference.
	 * @see #getBase_EnumerationLiteral()
	 * @generated
	 */
	void setBase_EnumerationLiteral(EnumerationLiteral value);

} // Unit
