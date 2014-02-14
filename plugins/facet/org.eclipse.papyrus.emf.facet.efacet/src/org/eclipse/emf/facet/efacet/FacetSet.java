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
 *  
 */
package org.eclipse.emf.facet.efacet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetSet#getFacets <em>Facets</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetSet#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetSet#getExtendedEPackage <em>Extended EPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetSet()
 * @model annotation="GenModel documentation='A \"FacetSet\" is the root element of a facet model. It contains a list of \"Facet\".'"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface FacetSet extends EPackage {
	/**
	 * Returns the value of the '<em><b>Facets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.Facet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.facet.efacet.Facet#getFacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facets</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetSet_Facets()
	 * @see org.eclipse.emf.facet.efacet.Facet#getFacetSet
	 * @model opposite="facetSet" containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Facet> getFacets();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetSet_Categories()
	 * @model containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Extended EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended EPackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended EPackage</em>' reference.
	 * @see #setExtendedEPackage(EPackage)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetSet_ExtendedEPackage()
	 * @model required="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EPackage getExtendedEPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.FacetSet#getExtendedEPackage <em>Extended EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended EPackage</em>' reference.
	 * @see #getExtendedEPackage()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setExtendedEPackage(EPackage value);

} // FacetSet
