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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Functional Device</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The FunctionalDevice represents an abstract sensor or actuator that encapsulates sensor/actuator dynamics and the interfacing software. The
 * FunctionalDevice is the interface between the electronic architecture and the environment (connected by ClampConnectors). As such, it is a transfer
 * function between the AnalysisFunction and the physical entity that it measures or actuates.
 * A Realization dependency can be used for traceability between LocalDeviceManagers and Sensors/Actuators that are represented by the
 * FunctionalDevice.
 * 
 * Semantics:
 * The behavior associated with the FunctionalDevice is the transfer function between the environment model representing the environment and an
 * AnalysisFunction. The transfer function represents the sensor or actuator and its interfacing hardware and software (connectors, electronics,
 * in/out interface, driver software, and application software).
 * 
 * Constraints:
 * No additional constraints.
 * 
 * Changes:
 * Now specializes AnalysisFunctionType.
 * 
 * Extension: Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionalDevice()
 * @model
 * @generated
 */
public interface FunctionalDevice extends AnalysisFunctionType {
} // FunctionalDevice
