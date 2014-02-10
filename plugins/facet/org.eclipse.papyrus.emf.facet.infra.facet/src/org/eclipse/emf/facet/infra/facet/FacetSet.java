/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 *     Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.FacetSet#getExtendedPackage <em>Extended Package</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.FacetSet#getFacets <em>Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetSet()
 * @model
 * @generated
 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198)
 */
@Deprecated
public interface FacetSet extends EPackage {
	/**
	 * Returns the value of the '<em><b>Extended Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Package</em>' reference.
	 * @see #setExtendedPackage(EPackage)
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetSet_ExtendedPackage()
	 * @model required="true"
	 * @generated
	 */
	EPackage getExtendedPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.infra.facet.FacetSet#getExtendedPackage <em>Extended Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Package</em>' reference.
	 * @see #getExtendedPackage()
	 * @generated
	 */
	void setExtendedPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>Facets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.infra.facet.Facet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.facet.infra.facet.Facet#getFacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facets</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facets</em>' reference list.
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetSet_Facets()
	 * @see org.eclipse.emf.facet.infra.facet.Facet#getFacetSet
	 * @model opposite="facetSet" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Facet> getFacets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Facet getFacet(String name);

} // FacetSet
