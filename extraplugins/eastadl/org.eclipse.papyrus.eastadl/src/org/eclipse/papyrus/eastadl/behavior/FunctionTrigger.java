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
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Trigger</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * FunctionTrigger represents the triggering parameters necessary to define the execution of an identified FunctionType or FunctionPrototype. When
 * referring to a FunctionType, a FunctionTrigger applies to all FunctionPrototypes of the given type. When referring to a FunctionPrototype, the
 * trigger is only valid for this particular FunctionPrototype.
 * 
 * Triggering is defined either as event-driven or time-driven - depending on the property triggerPolicy. If set to TIME, the timing constraint is
 * defined with an event constraint associated with the Function’s or FunctionPrototype’s EventFunction. The function event refers to the activation
 * of the function. If set to EVENT, one or several ports of the Function triggers the function, i.e. activates the function. In both cases, a
 * triggerCondition is provided in the form of a Boolean expression that must evaluate to true for the function to execute. The triggerCondition
 * syntax and grammar is unspecified.
 * 
 * In addition a FunctionTrigger may refer to a list of Modes in which the trigger will be considered as potentially active. Because of
 * FunctionBehaviors may also refer to Modes, it is thus possible to arrange various function configurations for which different sets of triggers and
 * behaviors are active. And this, at various level of granularity, either with a type-wise scope (by referring to a FunctionType) or specifically at
 * prototype level (by referring to a FunctionPrototype).
 * 
 * Note that several FunctionTriggers may be assigned to the same Function (Type or Prototype), for instance to define alternative trigger conditions
 * and/or timing constraints.
 * 
 * 
 * Semantics:
 * Association Mode defines in which modes the trigger is active
 * 
 * It is possible to have multiple triggers on a function, e.g. a slow period complemented with an event trigger allows fast response when needed but
 * a minimal execution rate.
 * 
 * 
 * Constraints:
 * [1] The port association must not be empty when triggerPolicy is EVENT.
 * 
 * [2] The port association is empty when triggerPolicy is TIME.
 * 
 * [3] Function and functionPrototype are mutually exclusive associations. A FunctionTrigger either identifies a FunctionType or a FunctionPrototype
 * as its target function, but not both.
 * 
 * [4] Only FunctionFlowPort of FlowDirection=in shall be referred to in the association port and at least one of them shall trigger the function
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerCondition <em>Trigger Condition</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerPolicy <em>Trigger Policy</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getMode <em>Mode</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunction <em>Function</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getPort <em>Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunctionPrototype <em>Function Prototype</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger()
 * @model
 * @generated
 */
public interface FunctionTrigger extends EAElement {

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionType)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_Function()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionType getFunction();

	/**
	 * Returns the value of the '<em><b>Function Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Prototype</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Function Prototype</em>' reference.
	 * @see #setFunctionPrototype(FunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_FunctionPrototype()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionPrototype getFunctionPrototype();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mode</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_Mode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getMode();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_Port()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionPort> getPort();

	/**
	 * Returns the value of the '<em><b>Trigger Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An OCL expression that allows release of the ADLFunctionType only if it evaluates to TRUE.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Trigger Condition</em>' attribute.
	 * @see #setTriggerCondition(String)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_TriggerCondition()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getTriggerCondition();

	/**
	 * Returns the value of the '<em><b>Trigger Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines whether time or trigger events on ports makes the Function execute
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Trigger Policy</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind
	 * @see #setTriggerPolicy(TriggerPolicyKind)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_TriggerPolicy()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	TriggerPolicyKind getTriggerPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionType value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunctionPrototype <em>Function Prototype</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Function Prototype</em>' reference.
	 * @see #getFunctionPrototype()
	 * @generated
	 */
	void setFunctionPrototype(FunctionPrototype value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerCondition <em>Trigger Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Trigger Condition</em>' attribute.
	 * @see #getTriggerCondition()
	 * @generated
	 */
	void setTriggerCondition(String value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getFunctionTrigger_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerPolicy <em>Trigger Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Trigger Policy</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind
	 * @see #getTriggerPolicy()
	 * @generated
	 */
	void setTriggerPolicy(TriggerPolicyKind value);

} // FunctionTrigger
