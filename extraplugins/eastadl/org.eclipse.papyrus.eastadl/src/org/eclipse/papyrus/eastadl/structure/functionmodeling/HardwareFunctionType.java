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
package org.eclipse.papyrus.eastadl.structure.functionmodeling;

import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hardware Function Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The HardwareFunctionType is the transfer function for the identified HardwareComponentType or a specification of an intended transfer function.
 * HardwareFunctionType types DesignFunctionPrototypes in the FunctionalDesignArchitecture. The DesignFunctionPrototype is typically the end of the
 * ClampConnector on DesignLevel.
 * 
 * Prototypes typed by HardwareComponentType may be allocated to HardwareComponents in which case the HardwareFunctionType must match the
 * HardwareFunctionType of the target HardwareComponent.
 * 
 * DesignFunctionPrototypes typed by HardwareFunctionType may be allocated to HardwareComponents in which case the HardwareFunctionType must match the
 * HardwareFunctionType of the target HardwareComponent.
 * 
 * Constraints:
 * [1] A DesignFunctionPrototype typed by a HardwareFunctionType shall be connected to the EnvironmentModel via ClampConnectors and to BSWFunctions
 * via FunctionConnectors.
 * 
 * Semantics:
 * The HardwareFunctionHardwareFunctionType is the transfer function for hardware components such as sensors, actuators, amplifiers, etc or a
 * specification of an intended transfer function.
 * 
 * HardwareFunctions can be allocated to Sensors or Actuators, i.e. the interfacing element to the plant model.
 * 
 * 
 * Extension:
 * UML Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType#getHardwareComponent <em>Hardware Component</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getHardwareFunctionType()
 * @model
 * @generated
 */
public interface HardwareFunctionType extends DesignFunctionType {

	/**
	 * Returns the value of the '<em><b>Hardware Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hardware Component</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hardware Component</em>' reference.
	 * @see #setHardwareComponent(HardwareComponentType)
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getHardwareFunctionType_HardwareComponent()
	 * @model ordered="false"
	 * @generated
	 */
	HardwareComponentType getHardwareComponent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType#getHardwareComponent
	 * <em>Hardware Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Hardware Component</em>' reference.
	 * @see #getHardwareComponent()
	 * @generated
	 */
	void setHardwareComponent(HardwareComponentType value);

} // HardwareFunctionType
