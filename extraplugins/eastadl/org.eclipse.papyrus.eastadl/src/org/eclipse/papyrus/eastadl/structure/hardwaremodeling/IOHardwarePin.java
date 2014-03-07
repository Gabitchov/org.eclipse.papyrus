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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IO Hardware Pin</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * IOHardwarePin represents an electrical connection point for digital or analog I/O.
 * 
 * Semantics:
 * The IOHardwarePin represents an electrical pin or connection point.
 * 
 * Notation:
 * IOHardwarePin is shown as a solid square with an IO inside. Its name may appear outside the square.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getIOHardwarePin()
 * @model
 * @generated
 */
public interface IOHardwarePin extends HardwarePin {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kind defines whether the IOHardwarePort is digital, analog or PWM (Pulse Width Modulated).
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
	 * @see #setType(IOHardwarePinKind)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getIOHardwarePin_Type()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	IOHardwarePinKind getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePinKind
	 * @see #getType()
	 * @generated
	 */
	void setType(IOHardwarePinKind value);
} // IOHardwarePin
