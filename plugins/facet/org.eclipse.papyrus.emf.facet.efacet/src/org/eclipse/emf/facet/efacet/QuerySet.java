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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.QuerySet#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QuerySet#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuerySet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='not(self.queries->exists(q1|self.queries->exists(q2|q2&lt;>q1 and q2.name = q1.name and q2.scope=q1.scope and q2.parameters = q1.parameters) and self.queries->forAll(q|q.scope = null)'"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface QuerySet extends EObject {
	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.Query}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuerySet_Queries()
	 * @model containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Query> getQueries();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuerySet_Name()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QuerySet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setName(String value);

} // QuerySet
