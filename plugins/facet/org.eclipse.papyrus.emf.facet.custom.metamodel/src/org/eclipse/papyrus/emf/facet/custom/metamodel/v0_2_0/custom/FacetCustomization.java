/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Customization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A FacetCustomization contains the customization for a Facet. There must not exist two FacetCustomizations customizing the same facet in the same customization.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization#getCustomizedFacet <em>Customized Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getFacetCustomization()
 * @model
 * @generated
 */
public interface FacetCustomization extends Facet {
	/**
	 * Returns the value of the '<em><b>Customized Facet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customized Facet</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customized Facet</em>' reference.
	 * @see #setCustomizedFacet(Facet)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getFacetCustomization_CustomizedFacet()
	 * @model required="true"
	 * @generated
	 */
	Facet getCustomizedFacet();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization#getCustomizedFacet <em>Customized Facet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customized Facet</em>' reference.
	 * @see #getCustomizedFacet()
	 * @generated
	 */
	void setCustomizedFacet(Facet value);

} // FacetCustomization
