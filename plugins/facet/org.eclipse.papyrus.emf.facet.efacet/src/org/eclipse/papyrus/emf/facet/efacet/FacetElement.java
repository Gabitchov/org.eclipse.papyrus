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

import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A facet element is owned by a facet. It can be a facet reference, a facet attribute or a facet operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetElement#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetElement#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.FacetElement#getOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetElement()
 * @model abstract="true"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface FacetElement extends ETypedElement {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetElement_Categories()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Facet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.facet.efacet.Facet#getFacetElements <em>Facet Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' container reference.
	 * @see #setFacet(Facet)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetElement_Facet()
	 * @see org.eclipse.emf.facet.efacet.Facet#getFacetElements
	 * @model opposite="facetElements" required="true" transient="false"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	Facet getFacet();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.FacetElement#getFacet <em>Facet</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet</em>' container reference.
	 * @see #getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setFacet(Facet value);

	/**
	 * Returns the value of the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' reference.
	 * @see #setOverride(ETypedElement)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getFacetElement_Override()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	ETypedElement getOverride();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.FacetElement#getOverride <em>Override</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' reference.
	 * @see #getOverride()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setOverride(ETypedElement value);

} // FacetElement
