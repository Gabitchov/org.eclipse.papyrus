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
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  A derived typed element is a virtual structural feature the value of which is computed using a query.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getDerivedTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface DerivedTypedElement extends FacetElement {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference.
	 * @see #setQuery(Query)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getDerivedTypedElement_Query()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Query getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(Query value);

	/**
	 * Returns the value of the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If it exists a facet A which extends a facet B then a derived typed element of A can override a typed element of B; if the both typed elements have the same name, same multiplicity, and same type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Override</em>' reference.
	 * @see #setOverride(DerivedTypedElement)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getDerivedTypedElement_Override()
	 * @model
	 * @generated
	 */
	DerivedTypedElement getOverride();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getOverride <em>Override</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' reference.
	 * @see #getOverride()
	 * @generated
	 */
	void setOverride(DerivedTypedElement value);

} // DerivedTypedElement
