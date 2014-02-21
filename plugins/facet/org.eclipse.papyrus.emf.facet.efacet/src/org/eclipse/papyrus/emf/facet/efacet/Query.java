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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A query is the abstract representation of the concept query. This class has to be sub-classed for each existing query language (Java, OCL,...)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.Query#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.Query#isHasSideEffect <em>Has Side Effect</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.Query#isCanBeCached <em>Can Be Cached</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.Query#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuery()
 * @model abstract="true"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface Query extends ETypedElement {
	/**
	 * Returns the value of the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query's scope defines the type of model elements a query can be applied on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope</em>' reference.
	 * @see #setScope(EClass)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuery_Scope()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.Query#getScope <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' reference.
	 * @see #getScope()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setScope(EClass value);

	/**
	 * Returns the value of the '<em><b>Has Side Effect</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute has to be true if the query modify the model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Has Side Effect</em>' attribute.
	 * @see #setHasSideEffect(boolean)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuery_HasSideEffect()
	 * @model default="false"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	boolean isHasSideEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.Query#isHasSideEffect <em>Has Side Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Side Effect</em>' attribute.
	 * @see #isHasSideEffect()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setHasSideEffect(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Be Cached</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute "canBeCached" has to be true if calling a query on the same model element will always return the same result.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Can Be Cached</em>' attribute.
	 * @see #setCanBeCached(boolean)
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuery_CanBeCached()
	 * @model default="false"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	boolean isCanBeCached();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.efacet.Query#isCanBeCached <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Be Cached</em>' attribute.
	 * @see #isCanBeCached()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setCanBeCached(boolean value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQuery_Parameters()
	 * @model containment="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Parameter> getParameters();

} // Query
