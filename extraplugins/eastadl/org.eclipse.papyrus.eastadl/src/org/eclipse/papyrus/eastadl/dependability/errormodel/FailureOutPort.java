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
 * A representation of the model object '<em><b>Failure Out Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The FailureOutPort represents a propagation point for failures that propagate out from the containing ErrorModelType.The EADatatype of the FailureOutPort defines the range of valid failures.
 * 
 * 
 * Constraints:
 * [1] The direction of the nominal port must be out.
 * 
 * Semantics:
 * The value range of a FailureOutPort represents failures that can propagate to FaultInPorts in other ErrorModels. The value range is defined by the FailureOutPort’s EADatatype.
 * 
 * If nominal Ports HWTargets or FunctionTargets are referenced, the failures of the FailureOutPort correspond to data on these nominal ports.
 * 
 * 
 * Extension: 
 * UML::Port
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFailureOutPort()
 * @model
 * @generated
 */
public interface FailureOutPort extends FaultFailurePort {
} // FailureOutPort
