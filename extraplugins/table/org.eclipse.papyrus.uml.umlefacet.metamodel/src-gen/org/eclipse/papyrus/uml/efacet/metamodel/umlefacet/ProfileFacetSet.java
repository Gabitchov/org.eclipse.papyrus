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
package org.eclipse.papyrus.uml.efacet.metamodel.umlefacet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile Facet Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * a 'ProfileFacetSet' is used to represent a UML Profile
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage#getProfileFacetSet()
 * @model
 * @generated
 */
public interface ProfileFacetSet extends FacetSet {
	/**
	 * Returns the value of the '<em><b>Profile Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the qualified name of the represented profile
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Profile Qualified Name</em>' attribute.
	 * @see #setProfileQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage#getProfileFacetSet_ProfileQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getProfileQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Qualified Name</em>' attribute.
	 * @see #getProfileQualifiedName()
	 * @generated
	 */
	void setProfileQualifiedName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns the ProfileFacetSet aggregated by this ProfileFacetSet
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ProfileFacetSet> getProfileFacetSet();

} // ProfileFacetSet
