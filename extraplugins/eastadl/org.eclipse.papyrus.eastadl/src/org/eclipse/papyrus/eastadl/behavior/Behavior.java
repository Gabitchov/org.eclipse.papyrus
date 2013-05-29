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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Behavior is a container of FunctionBehaviors, it enables to regroup the behaviors assigned to functions in a particular context on which TraceableSpecifications can be applied. This can take any appropriate form depending on the language implementation (for instance in a UML implementation it could be a Package).
 * 
 * The collection of functional behaviors can be done across the EAST-ADL2 abstraction levels.
 * 
 * Semantics:
 * This element has the same role and semantics as Context, but for behavioral aspects.
 * 
 * Extension: BehavioredClassifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getFunctionTrigger <em>Function Trigger</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getModeGroup <em>Mode Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior()
 * @model
 * @generated
 */
public interface Behavior extends Context {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior_Behavior()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionBehavior> getBehavior();

	/**
	 * Returns the value of the '<em><b>Function Trigger</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Trigger</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Trigger</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior_FunctionTrigger()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionTrigger> getFunctionTrigger();

	/**
	 * Returns the value of the '<em><b>Mode Group</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.ModeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Group</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior_ModeGroup()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeGroup> getModeGroup();

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage#getBehavior_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // Behavior
