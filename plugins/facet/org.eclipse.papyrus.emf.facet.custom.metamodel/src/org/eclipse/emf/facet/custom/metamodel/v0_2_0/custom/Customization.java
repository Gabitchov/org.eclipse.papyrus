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
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The customization model element is the root of a customization model. A customization is applied to only one ePackage and contains EClassCustomizations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization#isMustBeLoadedByDefault <em>Must Be Loaded By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getCustomization()
 * @model
 * @generated
 */
public interface Customization extends FacetSet {
	/**
	 * Returns the value of the '<em><b>Must Be Loaded By Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When Customization::mustBeloadedByDefault is true, the customization will be automatically loaded in the customizable model browsers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Must Be Loaded By Default</em>' attribute.
	 * @see #setMustBeLoadedByDefault(boolean)
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getCustomization_MustBeLoadedByDefault()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMustBeLoadedByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization#isMustBeLoadedByDefault <em>Must Be Loaded By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Must Be Loaded By Default</em>' attribute.
	 * @see #isMustBeLoadedByDefault()
	 * @generated
	 */
	void setMustBeLoadedByDefault(boolean value);

} // Customization
