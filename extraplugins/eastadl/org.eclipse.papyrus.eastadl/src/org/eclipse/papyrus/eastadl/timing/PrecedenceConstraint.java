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
package org.eclipse.papyrus.eastadl.timing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.uml2.uml.Dependency;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precedence Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The PrecedenceConstraint represents a particular constraint applied on the execution sequence of functions.
 * 
 * Semantics:
 * The semantics for the PrecedenceConstraint metaclass is to define an association relationship between Functions, indicating the association
 * relationship such that all predecessors have completed before the successors are started.
 * 
 * Note: Without a precedence relation, Functions are executed according to their data dependencies, if these are uni-directional. For bi-directional
 * data dependencies, execution order is not defined unless the PrecedenceDependency relationship is used.
 * 
 * Notation:
 * PrecedenceConstraint is shown as a dashed arrow with "Precedes" next to it. It points from preceeding to the successive entity.
 * 
 * Changes:
 * Renamed from Precedes
 * 
 * Extension:
 * The PrecedenceConstraint extends UML2 metaclass Class and Dependency.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getSuccessive <em>Successive</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getPreceding <em>Preceding</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getBase_Dependency <em>Base Dependency</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getSuccessive_path <em>Successive path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getPreceding_path <em>Preceding path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint()
 * @model
 * @generated
 */
public interface PrecedenceConstraint extends TimingConstraint {

	/**
	 * Returns the value of the '<em><b>Preceding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function prototype that must be executed first.
	 * {derived from UML::DirectedRelationship::source}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Preceding</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint_Preceding()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FunctionPrototype getPreceding();

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint_Base_Dependency()
	 * @model ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Successive path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successive path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Successive path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint_Successive_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getSuccessive_path();

	/**
	 * Returns the value of the '<em><b>Preceding path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preceding path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Preceding path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint_Preceding_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getPreceding_path();

	/**
	 * Returns the value of the '<em><b>Successive</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function prototypes that must be executed after preceding was executed.
	 * {derived from UML::DirectedRelationship::target}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Successive</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getPrecedenceConstraint_Successive()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<FunctionPrototype> getSuccessive();

} // PrecedenceConstraint
