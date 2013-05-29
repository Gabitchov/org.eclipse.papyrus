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
package org.eclipse.papyrus.eastadl.behavior;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.uml2.uml.Behavior;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FunctionBehavior represents the behavior of a particular FunctionType - referred to by the association to FunctionType. What is meant by behavior is a transfer function performing some data computation (in case of FlowPort interaction) or an operation that can be called by another function (in case of ClientServer interaction). The representation property indicates the kind of representation used to describe the behavior (see FunctionBehaviorKind). The representation itself (e.g defined in an external model file) is identified by a URL String in the path property. If the representation is provided in the same model file as the system itself, the path property is not used. It is merely a placeholder with the purpose of containing information about and links to the external behavioral model.
 * 
 * FunctionBehavior may refer to execution modes - by the association to the element Mode. This is not mandatory, however when provided, the relation indicates the list of execution Modes in which the FunctionBehavior can potentially be executed (see element Mode).
 * 
 * The triggering of a FunctionBehavior is unknown to the behavior. It is defined by FunctionTriggers (see this element).
 * 
 * Note that the association between FunctionBehavior and FunctionType is specified as a one-way navigable link from FunctionBehavior to FunctionType: what this means is that the EAST-ADL2 language specification does not require that a FunctionType be aware of the FunctionBehavior it is assigned to. Only the navigation from behavior to function is mandatory, the implementation of a reverse link might however be provided depending on the tool support.
 * 
 * Although each FunctionBehavior can refer to at most one FunctionType, note that several FunctionBehaviors can be referring to the same FunctionType. In this case when a FunctionType has several behaviors, only one behavior shall be active at any given time instant, i.e. no concurrent behaviors are allowed in EAST-ADL2 functions. For instance we cannot have one active behavior in Simulink and one in Modelica. Both can be referenced in the same function but at any given time, only one is executable. Conditions such as modes, etc. must prevent two behaviors being potentially active.
 * 
 * Note also that FunctionBehaviors are assigned to FunctionTypes and not to FunctionPrototypes. This means that among a set of FunctionPrototypes, which share the same type, behaviors are also shared. However when a FunctionBehavior refer to Modes, which are referred to by different FunctionTriggers, different triggering conditions can be provided among a set of FunctionPrototypes for the same set of behaviors - see FunctionTrigger.
 * 
 * In the case where the identified FunctionType is decomposed in parts, the behavior is a specification for the composed behavior of the FunctionType. 
 * 
 * 
 * Semantics:
 * Though the representation provided to a FunctionBehavior follows the semantics of the behavioral representation used (for instance SIMULINK, ASCET, etc.). Externally, in relation to the EAST-ADL2 model, however, the FunctionBehavior has synchronous execution semantics:
 * 1. Read inputs from input ports
 * 2. Execute Behavior with fixed inputs (run to completion)
 * 3. Provide outputs to output ports
 * 
 * The data transfer between the EAST-ADL2 ports and the FunctionBehavior is representation specific and considered part of the execution of the FunctionBehavior.
 * 
 * 
 * 
 * Notation:
 * FunctionBehavior appears, if shown in a diagram, as a solid-outline rectangle with "Behavior" at the top right. The rectangle contains the name. 
 * 
 * 
 * Extension: Behavior
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior()
 * @model
 * @generated
 */
public interface FunctionBehavior extends Context {
	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior_Base_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getBase_Behavior <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionType)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior_Function()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionType getFunction();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior_Mode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getMode();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The path to the file or model entity containing the ExternalBehavior
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior_Path()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getPath();

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of behavior that the ExternalBehavior represents.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Representation</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind
	 * @see #setRepresentation(FunctionBehaviorKind)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionBehavior_Representation()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	FunctionBehaviorKind getRepresentation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionType value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getRepresentation <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(FunctionBehaviorKind value);

} // FunctionBehavior
