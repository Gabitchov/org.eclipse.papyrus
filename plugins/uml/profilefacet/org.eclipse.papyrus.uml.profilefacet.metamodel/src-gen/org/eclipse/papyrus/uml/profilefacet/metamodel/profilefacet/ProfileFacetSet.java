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
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.facet.infra.facet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a 'ProfileFacetSet' is used to represent a UML Profile
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getStereotypeFacets <em>Stereotype Facets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getSubProfileFacetSet <em>Sub Profile Facet Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getProfileFacetSet()
 * @model
 * @generated
 */
public interface ProfileFacetSet extends FacetSet, EObjectFacetRepresentation {
	/**
	 * Returns the value of the '<em><b>Profile Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the qualified name of the represented profile
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Profile Qualified Name</em>' attribute.
	 * @see #setProfileQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getProfileFacetSet_ProfileQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getProfileQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Qualified Name</em>' attribute.
	 * @see #getProfileQualifiedName()
	 * @generated
	 */
	void setProfileQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Stereotype Facets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Facets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Facets</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getProfileFacetSet_StereotypeFacets()
	 * @model containment="true"
	 * @generated
	 */
	EList<StereotypeFacet> getStereotypeFacets();

	/**
	 * Returns the value of the '<em><b>Sub Profile Facet Set</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Profile Facet Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Profile Facet Set</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#getProfileFacetSet_SubProfileFacetSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProfileFacetSet> getSubProfileFacetSet();

} // ProfileFacetSet
