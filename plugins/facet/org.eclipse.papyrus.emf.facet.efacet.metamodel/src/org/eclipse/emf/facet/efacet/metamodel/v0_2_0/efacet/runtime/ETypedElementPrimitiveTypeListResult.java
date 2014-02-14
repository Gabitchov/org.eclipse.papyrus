/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETyped Element Primitive Type List Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents the result of evaluating the value of a multiplicity-many DerivedTypedElement by means of a multi-valued query .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult#getResultList <em>Result List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage#getETypedElementPrimitiveTypeListResult()
 * @model
 * @generated
 */
public interface ETypedElementPrimitiveTypeListResult<T> extends ETypedElementResult {
	/**
	 * Returns the value of the '<em><b>Result List</b></em>' attribute list.
	 * The list contents are of type {@link T}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result List</em>' attribute list.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage#getETypedElementPrimitiveTypeListResult_ResultList()
	 * @model
	 * @generated
	 */
	EList<T> getResultList();

} // ETypedElementPrimitiveTypeListResult
