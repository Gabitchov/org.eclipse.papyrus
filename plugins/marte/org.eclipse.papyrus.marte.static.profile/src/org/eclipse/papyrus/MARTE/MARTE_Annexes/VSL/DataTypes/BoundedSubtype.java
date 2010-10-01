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
package org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Subtype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMinOpen <em>Is Min Open</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMaxOpen <em>Is Max Open</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype()
 * @model
 * @generated
 */
public interface BoundedSubtype extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(Property)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_BaseType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBaseType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBaseType <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(Property value);

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_MinValue()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getMinValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(String value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_MaxValue()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getMaxValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(String value);

	/**
	 * Returns the value of the '<em><b>Is Min Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Min Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Min Open</em>' attribute.
	 * @see #setIsMinOpen(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_IsMinOpen()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMinOpen();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMinOpen <em>Is Min Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Min Open</em>' attribute.
	 * @see #isIsMinOpen()
	 * @generated
	 */
	void setIsMinOpen(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Max Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Max Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Max Open</em>' attribute.
	 * @see #setIsMaxOpen(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_IsMaxOpen()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMaxOpen();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMaxOpen <em>Is Max Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Max Open</em>' attribute.
	 * @see #isIsMaxOpen()
	 * @generated
	 */
	void setIsMaxOpen(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage#getBoundedSubtype_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // BoundedSubtype
