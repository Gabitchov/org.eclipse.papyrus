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
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.uml2.uml.Image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract metaclass FunctionType abstracts the function component types that are used to model the functional structure, which is distinguished from the implementation of component types using AUTOSAR. The syntax of FunctionTypes is inspired from the concept of Block from SysML.
 * 
 * FunctionBehavior and FunctionTrigger in the Behavior package are associated to a FunctionType.
 * 
 * 
 * Semantics:
 * The FunctionType abstracts the function component types that are used to model the functional structure on AnalysisLevel and DesignLevel.
 * Leaf functions of an EAST-ADL2 function hierarchy are called elementary Functions.
 * Elementary Functions have synchronous execution semantics:
 * 1. Read inputs
 * 2. Execute (duration: Execution time)
 * 3. Write outputs
 * Execution is defined by a behavior that acts as a transfer function.
 * Subclasses of the abstract class FunctionType add their own semantics.
 * 
 * If a behavior is attached to the FunctionType, the execution semantic for a discrete elementary FunctionType complies with the run-to-completion semantic. This has the following implications:
 * 
 * 1. Input that arrives at the input FunctionPorts after execution begins will be ignored until the next execution cycle.
 * 
 * 2. If more than one input value arrives per FunctionPort before execution begins the last value will override all previous ones in the public part of the input FunctionPort (single element buffers for input).
 * 
 * 3. The local part of a FunctionPort does not change its value during execution of the behavior.
 * 
 * 4. During an execution cycle only one output value can be sent per FunctionPort. If consecutive output values are produced on the same FunctionPort during a single execution cycle, the last value will override all previous ones on the output FunctionPort (single element buffers for output).
 * 
 * 5. Output will not be available at an output FunctionPort before execution ends.
 * 
 * 6. Elementary FunctionTypes may not produce any side effects (i.e., all data passes the FunctionPorts).
 * 
 * 
 * Constraints:
 * [1] Elementary FunctionTypes shall not have parts.
 * 
 * Notation:
 * The FunctionType is shown as a solid-outline rectangle containing the name, with its FunctionPorts or PortGroups on the perimeter. Contained entities may be shown with its FunctionConnectors (White-box view)
 * 
 * Extension: UML Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#isIsElementary <em>Is Elementary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getPortGroup <em>Port Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionType()
 * @model abstract="true"
 * @generated
 */
public interface FunctionType extends Context, Block {
	/**
	 * Returns the value of the '<em><b>Connector</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionType_Connector()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FunctionConnector> getConnector();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	Image getIcon();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Owned in- and out-flow ports.
	 * {derived from UML::EncapsulatedClassifier::ownedPort}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Port</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionType_Port()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FunctionPort> getPort();

	/**
	 * Returns the value of the '<em><b>Port Group</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Grouping of ports owned by this element.
	 * {derived from UML::Class::nestedClassifier}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Port Group</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionType_PortGroup()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<PortGroup> getPortGroup();

	/**
	 * Returns the value of the '<em><b>Is Elementary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Elementary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Elementary</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionType_IsElementary()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isIsElementary();

} // FunctionType
