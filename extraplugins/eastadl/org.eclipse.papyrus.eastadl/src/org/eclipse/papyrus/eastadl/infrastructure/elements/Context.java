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
package org.eclipse.papyrus.eastadl.infrastructure.elements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Context represents a simple and practical way to allocate TraceableSpecifications to a specific EAST-ADL2 model context, and to let this specific
 * model context own Relationships.
 * 
 * Semantics:
 * See Relationship and TraceableSpecification.
 * 
 * 
 * Changes:
 * New class in EAST-ADL2
 * 
 * Extension:
 * The Context stereotype is an abstract stereotype which extends UML2 PackageableElement
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getTraceableSpecification <em>Traceable Specification</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context#getOwnedRelationship <em>Owned Relationship</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getContext()
 * @model abstract="true"
 * @generated
 */
public interface Context extends EAElement {

	/**
	 * Returns the value of the '<em><b>Owned Relationship</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Relationship(s) associated to this context.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Owned Relationship</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getContext_OwnedRelationship()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Relationship> getOwnedRelationship();

	/**
	 * Returns the value of the '<em><b>Traceable Specification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Traceable specification(s) allocated to this context.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Traceable Specification</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getContext_TraceableSpecification()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TraceableSpecification> getTraceableSpecification();

} // Context
