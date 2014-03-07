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
 * A representation of the model object '<em><b>Technical Safety Concept</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * TechnicalSafetyConcept represents the set of technical safety requirements that together fulfils a FunctionalSafetyConcept and SafetyGoal in
 * accordance with ISO 26262.
 * 
 * These are derived from FunctionalSafetyConcepts i.e. TechnicalSafetyRequirements are derived from FunctionalSafetyRequirements.
 * 
 * 
 * Semantics:
 * The TechnicalSafetyConcept consists of the technical safety requirements and details the functional safety concept considering the functional
 * concept and the preliminary architectural design. It corresponds to the Technical Safety Concept of ISO26262.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept#getTechnicalSafetyRequirement <em>Technical Safety
 * Requirement</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getTechnicalSafetyConcept()
 * @model
 * @generated
 */
public interface TechnicalSafetyConcept extends RequirementsContainer {

	/**
	 * Returns the value of the '<em><b>Technical Safety Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * technicalSafety Requirements.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Technical Safety Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getTechnicalSafetyConcept_TechnicalSafetyRequirement()
	 * @model
	 * @generated
	 */
	EList<Requirement> getTechnicalSafetyRequirement();

} // TechnicalSafetyConcept
