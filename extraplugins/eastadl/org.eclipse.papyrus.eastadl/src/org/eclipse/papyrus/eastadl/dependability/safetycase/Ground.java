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
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ground</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Claim is based on Grounds (evidences) - specific facts about a precise situation that clarify and make good the Claim. 
 * 
 * Ground represents statements that explain how the SafetyCase Ground clarifies and make good the Claim.
 * 
 * Ground has associations to the entities that are the evidences in the SafetyCase.
 * 
 * Semantics:
 * Ground (evidence) is information that supports the Claim that the safety requirements and objectives are met i.e. used as the basis of the safety argument.
 * 
 * Solution is evidence that the sub-goals have been met. This can be achieved by decomposing all goal claims to a level where direct reference to evidences was felt possible.
 * 
 * The evidences address different aspects of the goal. It always has to be ensured that each of them is defensible enough to confirm the underlying statement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground#getSafetyEvidence <em>Safety Evidence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground#getJustification <em>Justification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getGround()
 * @model
 * @generated
 */
public interface Ground extends TraceableSpecification {
	/**
	 * Returns the value of the '<em><b>Justification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Justification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Justification</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getGround_Justification()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Comment> getJustification();

	/**
	 * Returns the value of the '<em><b>Safety Evidence</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Safety evidence in system model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Safety Evidence</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getGround_SafetyEvidence()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NamedElement> getSafetyEvidence();

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getGround_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // Ground
