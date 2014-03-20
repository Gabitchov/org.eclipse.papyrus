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
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Satisfy</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The Satisfy is a relationship metaclass, which signifies relationship between Requirements and an element intended to satisfy the Requirement.
 * 
 * Semantics:
 * The Satisfy metaclass signifies a satisfied requirement/satisfied by relationship between a set of Requirements and a set of satisfying entities,
 * where the modification of the supplier Requirements may impact the satisfying client entities. The Satisfy metaclass implies the semantics that the
 * satisfying client entities are not complete, without the supplier Requirement.
 * 
 * Constraints:
 * [1] The EAElement in the association satisfiedBy may not be a Requirement or RequirementContainer.
 * [2] An element of type Satisfy is only allowed to have associations to either elements of type UseCase (see satisfiedUseCase) or elements of type
 * Requirement (see satisfiedRequirement). Not both at the same time!
 * 
 * Notation:
 * A Satisfy relationship is shown as a dashed line with a arrowhead at the end that corresponds to the satisfied Requirement or UseCaseUseCase. The
 * entity at the tail of the arrow (the satisfying EAElement or the satisfying ARElement) depends on the entity at the arrowhead (the satisfied
 * Requirement or UseCaseUseCase).
 * 
 * Extension:
 * To specialize SysML::Satisfy, which extends Realization.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedRequirement <em>Satisfied Requirement</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy <em>Satisfied By</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy_path <em>Satisfied By path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedUseCase <em>Satisfied Use Case</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getSatisfy()
 * @model
 * @generated
 */
public interface Satisfy extends RequirementsRelationship, org.eclipse.papyrus.sysml.requirements.Satisfy {

	/**
	 * Returns the value of the '<em><b>Satisfied By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of satisfied ADL use cases, which are satisfied by the client ADL entities or satisfied by the client AUTOSAR elements.
	 * {derived from UML::Dependency::client}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Satisfied By</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getSatisfy_SatisfiedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getSatisfiedBy();

	/**
	 * Returns the value of the '<em><b>Satisfied By path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied By path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Satisfied By path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getSatisfy_SatisfiedBy_path()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getSatisfiedBy_path();

	/**
	 * Returns the value of the '<em><b>Satisfied Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of satisfied ADL requirements, which are satisfied by the client ADL entities.
	 * {derived from UML::DirectedRelationship::target}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Satisfied Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getSatisfy_SatisfiedRequirement()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getSatisfiedRequirement();

	/**
	 * Returns the value of the '<em><b>Satisfied Use Case</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied Use Case</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Satisfied Use Case</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getSatisfy_SatisfiedUseCase()
	 * @model ordered="false"
	 * @generated
	 */
	EList<UseCase> getSatisfiedUseCase();

} // Satisfy
