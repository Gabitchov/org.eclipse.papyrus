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
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget;
import org.eclipse.uml2.uml.Dependency;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FunctionAllocation represents an allocation constraint binding an AllocateableElement on an AllocationTarget.
 * 
 * The same constraint could be expressed in a textual design constraint.
 * 
 * Semantics:
 * AllocationTarget is specialized by HardwareComponentPrototype in the HardwareModeling package and AllocateableElement is specialized by the concrete elements DesignFunctionPrototype and FunctionConnector in the FunctionModeling package.
 * 
 * Notation:
 * A FunctionAllocation is shown as a dependency (dashed line) with an "allocation" keyword attached to it.
 * 
 * 
 * Extension: Class, specializesDesignConstraint
 * target to AUTOSAR::ECUResourceTemplate::ECU
 * allocatedAutosarComponent to AUTOSAR::Components::ClientPort
 * 
 * ToDo:
 * Cf. AUTOSAR SWMapping::MappingConstraint
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement <em>Allocated Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getAllocatedElement_path <em>Allocated Element path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getTarget_path <em>Target path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation()
 * @model
 * @generated
 */
public interface FunctionAllocation extends EAElement {
	/**
	 * Returns the value of the '<em><b>Allocated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Element</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation_AllocatedElement()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	AllocateableElement getAllocatedElement();

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Allocated Element path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AllocateableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Element path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Element path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation_AllocatedElement_path()
	 * @model
	 * @generated
	 */
	EList<AllocateableElement> getAllocatedElement_path();

	/**
	 * Returns the value of the '<em><b>Target path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation_Target_path()
	 * @model
	 * @generated
	 */
	EList<AllocationTarget> getTarget_path();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ECU where the functionality must be allocated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionAllocation_Target()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	AllocationTarget getTarget();

} // FunctionAllocation
