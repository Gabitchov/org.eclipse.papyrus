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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The Relationship is an abstract metaclass which represents a relationship between arbitrary elements.
 * 
 * Semantics:
 * In many cases, Contexts such as functions and sensors need to have requirements and other specification elements allocated them. In other cases,
 * the relation between an element and the related specification element is specific for a certain Context: for example a Requirement on a sensor is
 * only applicable in certain hardware architecture. These relationships are modeled by concrete specializations of Relationship.
 * 
 * See Context and TraceableSpecification.
 * 
 * 
 * Changes:
 * New class in EAST-ADL2
 * 
 * Extension:
 * The Relationship stereotype is abstract
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRelationship()
 * @model abstract="true"
 * @generated
 */
public interface Relationship extends EAElement {
} // Relationship
