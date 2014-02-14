/**
 * Copyright (c) 2011-2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Design
 *    Nicolas Guyomar (Mia-Software) - Implementation
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 *    Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *    Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *    Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *    Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *    Nicolas Bros (Mia-Software) - Bug 372626 - [Facet] Aggregates
 *    Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 * 
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EOperation;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getOperationCallQuery()
 * @model
 * @generated
 * @since 0.2
 */
public interface OperationCallQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EOperation)
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getOperationCallQuery_Operation()
	 * @model
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getOperationCallQuery_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Query> getArguments();

} // OperationCallQuery
