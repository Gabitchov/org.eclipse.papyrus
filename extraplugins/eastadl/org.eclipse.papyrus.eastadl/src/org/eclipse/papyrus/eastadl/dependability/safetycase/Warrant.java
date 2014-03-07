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
 * A representation of the model object '<em><b>Warrant</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Warrant represents argumentation of the facts to the Claim in general ways.
 * 
 * The Warrant entity has associations to the decomposed goals and to the evidences for the SafetyCase.
 * 
 * Semantics:
 * The overall objective of an argument is to lead the evidence to the claim.
 * 
 * Arguments are actions of inferring a conclusion from premised propositions. An argument is considered valid if the conclusion can be logically
 * derived from its premises. An argument is considered sound if it is valid and all premises are true.
 * 
 * A goal decomposition strategy breaks down a goal into a number of sub-goals. It is recommended that the strategies are of specific form.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant#getDecomposedGoal <em>Decomposed Goal</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant#getEvidence <em>Evidence</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant#getJustification <em>Justification</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getWarrant()
 * @model
 * @generated
 */
public interface Warrant extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Decomposed Goal</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decomposed Goal</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decomposed Goal</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getWarrant_DecomposedGoal()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Claim> getDecomposedGoal();

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getWarrant_Evidence()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Ground> getEvidence();

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getWarrant_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant#getBase_Class <em>Base Class</em>}' reference.
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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getWarrant_Justification()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Comment> getJustification();

} // Warrant
