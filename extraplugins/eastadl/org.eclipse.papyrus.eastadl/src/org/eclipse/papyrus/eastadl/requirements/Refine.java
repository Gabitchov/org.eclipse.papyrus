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
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refine</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The Refine is a relationship metaclass, which signifies a dependency relationship in-between Requirements and EAElements, showing the relationship
 * when a client EAElement refines the supplier Requirement.
 * 
 * Semantics:
 * The Refine metaclass signifies a refined requirement/refined by relationship between a Requirement and an EAElement, where the modification of the
 * supplier Requirement may impact the refining client EAElement. The Refine metaclass implies the semantics that the refining client EAElement is not
 * complete, without the supplier Requirement.
 * 
 * Constraints:
 * [1] The property refinedBy must not have the types Requirement or RequirementContainer.
 * 
 * Notation:
 * A Refine relationship is shown as a dashed arrow between the Requirements and EAElement. The entity at the tail of the arrow (the refining
 * EAElement) depends on the Requirement at the arrowhead (the refined Requirement).
 * 
 * Extension: specializes UML2 stereotype Refine, which extends Dependency.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedRequirement <em>Refined Requirement</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy <em>Refined By</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Refine#getBase_Dependency <em>Base Dependency</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy_path <em>Refined By path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRefine()
 * @model
 * @generated
 */
public interface Refine extends RequirementsRelationship, org.eclipse.uml2.uml.profile.standard.Refine {

	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of ADLEntity participating to the refinement of the refined ADL requirements.
	 * {derived from UML::Dependency::client}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Refined By</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRefine_RefinedBy()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getRefinedBy();

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
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRefine_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.Refine#getBase_Dependency <em>Base Dependency</em>}' reference.
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
	 * Returns the value of the '<em><b>Refined By path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Refined By path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRefine_RefinedBy_path()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getRefinedBy_path();

	/**
	 * Returns the value of the '<em><b>Refined Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of refined requirements.
	 * {derived from UML::DirectedRelationship::target}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Refined Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRefine_RefinedRequirement()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getRefinedRequirement();

} // Refine
