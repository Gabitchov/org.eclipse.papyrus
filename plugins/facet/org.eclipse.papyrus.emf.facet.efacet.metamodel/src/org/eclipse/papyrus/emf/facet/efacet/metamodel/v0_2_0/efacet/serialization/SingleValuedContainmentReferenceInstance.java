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
 * A representation of the model object '<em><b>Single Valued Containment Reference Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance#getOwnedElement <em>Owned Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getSingleValuedContainmentReferenceInstance()
 * @model
 * @generated
 */
public interface SingleValuedContainmentReferenceInstance extends AbstractReferenceInstance {
	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Element</em>' containment reference.
	 * @see #setOwnedElement(EObject)
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getSingleValuedContainmentReferenceInstance_OwnedElement()
	 * @model containment="true"
	 * @generated
	 */
	EObject getOwnedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance#getOwnedElement <em>Owned Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Element</em>' containment reference.
	 * @see #getOwnedElement()
	 * @generated
	 */
	void setOwnedElement(EObject value);

} // SingleValuedContainmentReferenceInstance
