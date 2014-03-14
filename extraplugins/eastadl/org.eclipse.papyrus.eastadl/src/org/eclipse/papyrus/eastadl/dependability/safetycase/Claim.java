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
package org.eclipse.papyrus.eastadl.dependability.safetycase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.uml2.uml.Comment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Claim represents a statement the truth of which needs to be confirmed.
 * 
 * Claim has associations to the strategy for goal decomposition and to supported arguments. It also holds associations to the evidences for the
 * SafetyCase.
 * 
 * Semantics:
 * Goal-based development provides the claim what should be achieved.
 * 
 * Goal is what the argument must show to be true.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getSafetyRequirement <em>Safety Requirement</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getSupportedArgument <em>Supported Argument</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getGoalDecompositionStrategy <em>Goal Decomposition Strategy</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getJustification <em>Justification</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getEvidence <em>Evidence</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim()
 * @model
 * @generated
 */
public interface Claim extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Evidence</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evidence</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Evidence</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_Evidence()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Ground> getEvidence();

	/**
	 * Returns the value of the '<em><b>Goal Decomposition Strategy</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal Decomposition Strategy</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Goal Decomposition Strategy</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_GoalDecompositionStrategy()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Warrant> getGoalDecompositionStrategy();

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Justification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Justification</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Justification</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_Justification()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Comment> getJustification();

	/**
	 * Returns the value of the '<em><b>Safety Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Safety requirements and objectives in system model.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Safety Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_SafetyRequirement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TraceableSpecification> getSafetyRequirement();

	/**
	 * Returns the value of the '<em><b>Supported Argument</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported Argument</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Supported Argument</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getClaim_SupportedArgument()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Warrant> getSupportedArgument();

} // Claim
