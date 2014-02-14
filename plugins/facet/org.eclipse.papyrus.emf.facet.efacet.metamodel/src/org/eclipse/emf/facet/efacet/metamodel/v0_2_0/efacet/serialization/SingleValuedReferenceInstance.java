/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Valued Reference Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance#getReferencedElement <em>Referenced Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getSingleValuedReferenceInstance()
 * @model
 * @generated
 */
public interface SingleValuedReferenceInstance extends AbstractReferenceInstance {
	/**
	 * Returns the value of the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Element</em>' reference.
	 * @see #setReferencedElement(EObject)
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getSingleValuedReferenceInstance_ReferencedElement()
	 * @model
	 * @generated
	 */
	EObject getReferencedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance#getReferencedElement <em>Referenced Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Element</em>' reference.
	 * @see #getReferencedElement()
	 * @generated
	 */
	void setReferencedElement(EObject value);

} // SingleValuedReferenceInstance
