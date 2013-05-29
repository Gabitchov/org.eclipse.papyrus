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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;


import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind;
import org.eclipse.uml2.uml.Port;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hardware Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * HardwarePin represents electrical connection points in the hardware architecture. Depending on modeling style, the actual wire or a logical connection can be considered.
 * 
 * Semantics
 * Hardware pin represents an electrical connection point.
 * 
 * Extension:
 * Port
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#isIsGround <em>Is Ground</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getVoltage <em>Voltage</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getImpedance <em>Impedance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getPower <em>Power</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin()
 * @model abstract="true"
 * @generated
 */
public interface HardwarePin extends EAElement {
	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The direction of current through the pin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind
	 * @see #setDirection(EADirectionKind)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_Direction()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EADirectionKind getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(EADirectionKind value);

	/**
	 * Returns the value of the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The internal impedance in Ohms to ground of the component as seen through this pin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Impedance</em>' attribute.
	 * @see #setImpedance(Float)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_Impedance()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" ordered="false"
	 * @generated
	 */
	Float getImpedance();

	/**
	 * Returns the value of the '<em><b>Power</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximal power in watts that can be provided by this pin or that is consumed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Power</em>' attribute.
	 * @see #setPower(Float)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_Power()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" ordered="false"
	 * @generated
	 */
	Float getPower();

	/**
	 * Returns the value of the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voltage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximal voltage in Volts provided by the pin. Shall not be defined if isGround=TRUE.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage</em>' attribute.
	 * @see #setVoltage(Float)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_Voltage()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" ordered="false"
	 * @generated
	 */
	Float getVoltage();

	/**
	 * Returns the value of the '<em><b>Is Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates that the pin is connected to ground.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ground</em>' attribute.
	 * @see #setIsGround(boolean)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwarePin_IsGround()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsGround();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getImpedance <em>Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impedance</em>' attribute.
	 * @see #getImpedance()
	 * @generated
	 */
	void setImpedance(Float value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#isIsGround <em>Is Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ground</em>' attribute.
	 * @see #isIsGround()
	 * @generated
	 */
	void setIsGround(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getPower <em>Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power</em>' attribute.
	 * @see #getPower()
	 * @generated
	 */
	void setPower(Float value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin#getVoltage <em>Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage</em>' attribute.
	 * @see #getVoltage()
	 * @generated
	 */
	void setVoltage(Float value);

} // HardwarePin
