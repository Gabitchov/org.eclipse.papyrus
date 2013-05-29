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
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Specification Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * In general it is a standard practice (e.g. using IBM Rational DOORS) to define requirements and also rationales, explanations and other requirement related information as direct successors or predecessors of an appropriate requirement. Thus, requirements and requirement related information are generalized to RequirementSpecificationObject which in turn can be referenced by the structuring container structure (RequirementContainer).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject#getReferencingContainer <em>Referencing Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementSpecificationObject()
 * @model abstract="true"
 * @generated
 */
public interface RequirementSpecificationObject extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Referencing Container</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Container</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Container</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementSpecificationObject_ReferencingContainer()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<RequirementsContainer> getReferencingContainer();

} // RequirementSpecificationObject
