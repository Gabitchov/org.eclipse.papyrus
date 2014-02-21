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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended EObject Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getExtendedEObject <em>Extended EObject</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getAttributeInstances <em>Attribute Instances</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getReferenceInstances <em>Reference Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getExtendedEObjectReference()
 * @model
 * @generated
 */
public interface ExtendedEObjectReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Extended EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended EObject</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended EObject</em>' reference.
	 * @see #setExtendedEObject(EObject)
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getExtendedEObjectReference_ExtendedEObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getExtendedEObject();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getExtendedEObject <em>Extended EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended EObject</em>' reference.
	 * @see #getExtendedEObject()
	 * @generated
	 */
	void setExtendedEObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Attribute Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Instances</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getExtendedEObjectReference_AttributeInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractAttributeInstance> getAttributeInstances();

	/**
	 * Returns the value of the '<em><b>Reference Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Instances</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#getExtendedEObjectReference_ReferenceInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractReferenceInstance> getReferenceInstances();

} // ExtendedEObjectReference
