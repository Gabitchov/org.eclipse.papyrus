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

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a class used to evaluate a query on every given model element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryContext#getSelectedModelElements <em>Selected Model Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.QueryContext#getSelectedModels <em>Selected Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryContext()
 * @model
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface QueryContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Selected Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Model Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Model Elements</em>' reference list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryContext_SelectedModelElements()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<EObject> getSelectedModelElements();

	/**
	 * Returns the value of the '<em><b>Selected Models</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.resource.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Models</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Models</em>' attribute list.
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#getQueryContext_SelectedModels()
	 * @model transient="true"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EList<Resource> getSelectedModels();

} // QueryContext
