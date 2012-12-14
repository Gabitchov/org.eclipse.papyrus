/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a 'StereotypeFacet' is used to represent a UML Stereotype
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage#getStereotypeFacet()
 * @model
 * @generated
 */
public interface StereotypeFacet extends Facet, EObjectFacetRepresentation {
	/**
	 * Returns the value of the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the qualified name of the represented stereotype
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #setStereotypeQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage#getStereotypeFacet_StereotypeQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getStereotypeQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 */
	void setStereotypeQualifiedName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns the StereotypePropertyelement owned by this StereotypeFacet
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<StereotypePropertyElement> getStereotypePropertyElements();

} // StereotypeFacet
