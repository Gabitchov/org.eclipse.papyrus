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

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETyped Element Switch Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This query can return a value depending of an instance of ETypedElement. This query is dedicated to the definition of customizations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery#getCases <em>Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getETypedElementSwitchQuery()
 * @model
 * @generated
 */
public interface ETypedElementSwitchQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getETypedElementSwitchQuery_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<ETypedElementCase> getCases();

} // ETypedElementSwitchQuery
