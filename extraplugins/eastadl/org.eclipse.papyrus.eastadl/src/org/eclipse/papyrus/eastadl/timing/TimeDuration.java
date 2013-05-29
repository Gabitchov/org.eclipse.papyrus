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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.timing;


import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.DataType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Duration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CseCodeType 
 * 0:	1 탎ec 		Time	
 * 1:	10 탎ec		Time	
 * 2:	100 탎ec	Time	
 * 3:	1 msec		Time	
 * 4:	10 msec		Time	
 * 5:	100 msec	Time	
 * 6:	1 sec		Time	
 * 7:	10 sec		Time	
 * 8:	1 min		Time	
 * 9:	1 h		Time	
 * 10:	1 d		Time	
 * 
 * 100:	Angular degrees			Angle	
 * 101:	Revolutions 360 degrees	Angle	
 * 102:	Cycle 720 degrees		Angle	e.g. in case of IC engines
 * 103:	Cylinder segment		Combustion	e.g. in case of IC engines
 * 998:	When frame available	Time	Source defined in the ASAP 2 keyword, FRAME
 * 999:	Always if there is new value		Calculation of a new upper range limit after receiving a new partial value, e.g. when calculating a complex trigger condition
 * 1000:	Non deterministic		Without fixed scaling
 * 
 * If, for example, the value in swCseCodeFactor is 360 and the value in swCseCode is 100, this is equivalent to the value 1 in swCseCodeFactor and the value 101 in swCseCode.
 * 
 * CseCodeType is from AUTOSAR and MSR/ASAM.
 * 
 * Note that we have set the cseCodeType for 1 탎ec to 0 (error in AUTOSAR R3). And have changed cseCodeType 2 to 100 탎ec (error in MSR).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getCseCode <em>Cse Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getCseCodeFactor <em>Cse Code Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTimeDuration()
 * @model
 * @generated
 */
public interface TimeDuration extends EAElement {
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
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTimeDuration_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Cse Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Within TIMMO this is normally time, note that when it is expressed as angle it can be converted to time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cse Code</em>' attribute.
	 * @see #setCseCode(int)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTimeDuration_CseCode()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getCseCode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getCseCode <em>Cse Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cse Code</em>' attribute.
	 * @see #getCseCode()
	 * @generated
	 */
	void setCseCode(int value);

	/**
	 * Returns the value of the '<em><b>Cse Code Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Is normally equal to 1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cse Code Factor</em>' attribute.
	 * @see #setCseCodeFactor(int)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTimeDuration_CseCodeFactor()
	 * @model default="1" unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getCseCodeFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getCseCodeFactor <em>Cse Code Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cse Code Factor</em>' attribute.
	 * @see #getCseCodeFactor()
	 * @generated
	 */
	void setCseCodeFactor(int value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual value complemented with the cseCode.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Float)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getTimeDuration_Value()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" required="true" ordered="false"
	 * @generated
	 */
	Float getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.TimeDuration#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Float value);

} // TimeDuration
