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
package org.eclipse.papyrus.eastadl.dependability.errormodel;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault In Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The FaultInPort represents a propagation point for faults that propagate to the containing ErrorModelType. The EADatatype of the FaultInPort defines the range of valid failures.
 * 
 * Constraints:
 * [1] The direction of the nominal port must be in.
 * 
 * Semantics:
 * The value range of a FaultInPort represents faults propagated from a FailureOutPort in another ErrorModel. The value range is defined by the FaultInPort’s EADatatype.
 * 
 * If nominal Ports HWTarget or FunctionTarget are referenced, the faults on the FaultInPort.
 * 
 * 
 * Extension: 
 * UML::Port
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultInPort()
 * @model
 * @generated
 */
public interface FaultInPort extends FaultFailurePort {
} // FaultInPort
