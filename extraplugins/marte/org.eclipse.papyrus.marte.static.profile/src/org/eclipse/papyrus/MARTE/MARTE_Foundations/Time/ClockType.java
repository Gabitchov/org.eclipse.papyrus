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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Time;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clock Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#isIsLogical <em>Is Logical</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getResolAttr <em>Resol Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getMaxValAttr <em>Max Val Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getOffsetAttr <em>Offset Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getGetTime <em>Get Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getSetTime <em>Set Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getIndexToValue <em>Index To Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType()
 * @model
 * @generated
 */
public interface ClockType extends EObject {
	/**
	 * Returns the value of the '<em><b>Nature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind
	 * @see #setNature(TimeNatureKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_Nature()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	TimeNatureKind getNature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getNature <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind
	 * @see #getNature()
	 * @generated
	 */
	void setNature(TimeNatureKind value);

	/**
	 * Returns the value of the '<em><b>Unit Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Type</em>' reference.
	 * @see #setUnitType(Enumeration)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_UnitType()
	 * @model ordered="false"
	 * @generated
	 */
	Enumeration getUnitType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getUnitType <em>Unit Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Type</em>' reference.
	 * @see #getUnitType()
	 * @generated
	 */
	void setUnitType(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Is Logical</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Logical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Logical</em>' attribute.
	 * @see #setIsLogical(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_IsLogical()
	 * @model default="false" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsLogical();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#isIsLogical <em>Is Logical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Logical</em>' attribute.
	 * @see #isIsLogical()
	 * @generated
	 */
	void setIsLogical(boolean value);

	/**
	 * Returns the value of the '<em><b>Resol Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resol Attr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resol Attr</em>' reference.
	 * @see #setResolAttr(Property)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_ResolAttr()
	 * @model ordered="false"
	 * @generated
	 */
	Property getResolAttr();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getResolAttr <em>Resol Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resol Attr</em>' reference.
	 * @see #getResolAttr()
	 * @generated
	 */
	void setResolAttr(Property value);

	/**
	 * Returns the value of the '<em><b>Max Val Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Val Attr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Val Attr</em>' reference.
	 * @see #setMaxValAttr(Property)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_MaxValAttr()
	 * @model ordered="false"
	 * @generated
	 */
	Property getMaxValAttr();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getMaxValAttr <em>Max Val Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Val Attr</em>' reference.
	 * @see #getMaxValAttr()
	 * @generated
	 */
	void setMaxValAttr(Property value);

	/**
	 * Returns the value of the '<em><b>Offset Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Attr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Attr</em>' reference.
	 * @see #setOffsetAttr(Property)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_OffsetAttr()
	 * @model ordered="false"
	 * @generated
	 */
	Property getOffsetAttr();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getOffsetAttr <em>Offset Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Attr</em>' reference.
	 * @see #getOffsetAttr()
	 * @generated
	 */
	void setOffsetAttr(Property value);

	/**
	 * Returns the value of the '<em><b>Get Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Time</em>' reference.
	 * @see #setGetTime(Operation)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_GetTime()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getGetTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getGetTime <em>Get Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Time</em>' reference.
	 * @see #getGetTime()
	 * @generated
	 */
	void setGetTime(Operation value);

	/**
	 * Returns the value of the '<em><b>Set Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Time</em>' reference.
	 * @see #setSetTime(Operation)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_SetTime()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getSetTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getSetTime <em>Set Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Time</em>' reference.
	 * @see #getSetTime()
	 * @generated
	 */
	void setSetTime(Operation value);

	/**
	 * Returns the value of the '<em><b>Index To Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index To Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index To Value</em>' reference.
	 * @see #setIndexToValue(Operation)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_IndexToValue()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getIndexToValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getIndexToValue <em>Index To Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index To Value</em>' reference.
	 * @see #getIndexToValue()
	 * @generated
	 */
	void setIndexToValue(Operation value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockType_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // ClockType
