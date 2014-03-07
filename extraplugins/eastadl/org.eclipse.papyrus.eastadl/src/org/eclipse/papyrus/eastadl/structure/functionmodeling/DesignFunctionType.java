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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Design Function Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The DesignFunctionType is a concrete FunctionType and therefore inherits the elementary function properties from the abstract metaclass
 * FunctionType. The DesignFunctionType is used to model the functional structure on DesignLevel. The syntax of DesignFunctionTypes is inspired from
 * the type-prototype pattern used by AUTOSAR.
 * 
 * The DesignFunctions may interact with other DesignFunctions (i.e., also BasicSoftwareFunctions, HardwareFunctions, and LocalDeviceManager) through
 * their FunctionPorts.
 * 
 * Furthermore, a DesignFunction may be decomposed into (sub-)DesignFunctions. This allows breaking up hierarchically the functionalities provided by
 * the parent DesignFunction into subfunctionalities.
 * 
 * Execution time constraints on the DesignFunctionType can be expressed by ExecutionTimeConstraints, see the Timing package.
 * 
 * If two or more occurrences of an elementary Function are allocated on the same ECU, the code will be placed on the ECU only once (so these
 * occurrences will use the same code but separate memory areas for data).
 * 
 * 
 * Semantics:
 * The DesignFunctionType represents a node in a tree structure corresponding to the functional decomposition of a top level DesignFunction. The
 * DesignFunction is representing the design function used to describe the functionalities provided by a vehicle on the DesignLevel. At the
 * DesignLevel, DesignFunctions are defined and structured according to the functional and hardware system design.
 * 
 * Constraints:
 * [1] DesignFunctionTypes may only be used on DesignLevel.
 * 
 * 
 * 
 * Extension: UML Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getDesignFunctionType()
 * @model
 * @generated
 */
public interface DesignFunctionType extends FunctionType {

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getDesignFunctionType_Part()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<DesignFunctionPrototype> getPart();

} // DesignFunctionType
