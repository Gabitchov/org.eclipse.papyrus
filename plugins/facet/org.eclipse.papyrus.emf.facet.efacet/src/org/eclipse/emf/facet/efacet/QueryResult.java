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
 * A representation of the model object '<em><b>Query Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents the result of a query execution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getParameterValues <em>Parameter Values</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryResult#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult()
 * @model
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface QueryResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference "query" references the executed query.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Query</em>' reference.
	 * @see #setQuery(Query)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_Query()
	 * @model required="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	Query getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QueryResult#getQuery <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' reference.
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setQuery(Query value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The scope references the model elements on which the query has been applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope</em>' reference.
	 * @see #setScope(EObject)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_Scope()
	 * @model required="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EObject getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QueryResult#getScope <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' reference.
	 * @see #getScope()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setScope(EObject value);

	/**
	 * Returns the value of the '<em><b>Parameter Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.ParameterValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the list of the values given as parameters for the query execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Values</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_ParameterValues()
	 * @model containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<ParameterValue> getParameterValues();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the result returned by the query execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(Object)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_Result()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	Object getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QueryResult#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setResult(Object value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(Exception)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_Exception()
	 * @model dataType="org.eclipse.emf.facet.efacet.JavaException"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	Exception getException();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QueryResult#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setException(Exception value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryResult_Source()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EObject getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.QueryResult#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setSource(EObject value);

} // QueryResult
