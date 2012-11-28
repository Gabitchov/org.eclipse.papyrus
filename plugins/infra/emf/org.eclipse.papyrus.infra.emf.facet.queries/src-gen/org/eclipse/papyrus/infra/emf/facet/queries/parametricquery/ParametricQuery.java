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
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.facet.infra.query.ModelQuery;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Query</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getCalledQuery <em>Called Query</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage#getParametricQuery()
 * @model
 * @generated
 */
public interface ParametricQuery extends ModelQuery {

	/**
	 * Returns the value of the '<em><b>Called Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Query</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Called Query</em>' reference.
	 * @see #setCalledQuery(ModelQuery)
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage#getParametricQuery_CalledQuery()
	 * @model required="true"
	 * @generated
	 */
	ModelQuery getCalledQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getCalledQuery <em>Called Query</em>}
	 * ' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Called Query</em>' reference.
	 * @see #getCalledQuery()
	 * @generated
	 */
	void setCalledQuery(ModelQuery value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage#getParametricQuery_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Argument> getArguments();

} // ParametricQuery
