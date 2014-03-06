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
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functional Safety Concept</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * FunctionalSafetyConcept represents the set of functional safety requirements that together fulfils a SafetyGoal in accordance with ISO 26262.
 * 
 * To comply with the SafetyGoals, the FunctionalSafetyConcept specifies the basic safety mechanisms and safety measures in the form of functional
 * safety requirements.
 * 
 * Constraints:
 * [1] Contained functionalSafetyRequirements shall not be of type SafetyGoal.
 * 
 * Semantics:
 * The collection of requirements in the FunctionalSafetyConcept defines the requirements necessary to make the Item safe. The requirements are
 * abstract and do not specify technical details.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept#getFunctionalSafetyRequirement <em>Functional Safety
 * Requirement</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getFunctionalSafetyConcept()
 * @model
 * @generated
 */
public interface FunctionalSafetyConcept extends RequirementsContainer {

	/**
	 * Returns the value of the '<em><b>Functional Safety Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Safety Requirement</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Functional Safety Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getFunctionalSafetyConcept_FunctionalSafetyRequirement()
	 * @model
	 * @generated
	 */
	EList<Requirement> getFunctionalSafetyRequirement();

} // FunctionalSafetyConcept
