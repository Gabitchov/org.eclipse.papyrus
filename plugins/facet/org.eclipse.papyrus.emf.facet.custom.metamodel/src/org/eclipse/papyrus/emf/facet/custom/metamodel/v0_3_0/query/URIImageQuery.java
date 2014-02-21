/**
 *  Copyright (c) 2013 Soft-Maint.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 		David Couvrand (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *  	Nicolas Rault (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>URI Image Query</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery#getUri
 * <em>Uri</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.QueryPackage#getURIImageQuery()
 * @model
 * @generated
 * @since 0.3
 */
public interface URIImageQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.QueryPackage#getURIImageQuery_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // URIImageQuery
