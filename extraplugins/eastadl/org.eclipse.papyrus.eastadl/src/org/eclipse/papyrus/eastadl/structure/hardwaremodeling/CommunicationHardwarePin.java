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
 * A representation of the model object '<em><b>Communication Hardware Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CommunicationHardwarePin represents an electrical connection point that can be used to define how the wire harness is logically defined. 
 * 
 * Semantics:
 * The CommunicationHardwarePin represents the hardware connection point of a communication bus. 
 * 
 * Depending on modeling style, one or two pins may be defined for a dual-wire bus.
 * 
 * Notation:
 * CommunicationHardwarePin is shown as a solid square with a C inside. Its name may appear outside the square.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getCommunicationHardwarePin()
 * @model
 * @generated
 */
public interface CommunicationHardwarePin extends HardwarePin {
} // CommunicationHardwarePin
