/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 *     Gregoire DUPE (Mia-Software) - Bug 339880 - To be able to edit derived facet attributes and derived facet references
 *     Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.ModelQuery;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.FacetStructuralFeature#getValueQuery <em>Value Query</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.FacetStructuralFeature#getSetQuery <em>Set Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetStructuralFeature()
 * @model abstract="true"
 * @generated
 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198)
 */
@Deprecated
public interface FacetStructuralFeature extends EObject {
	/**
	 * Returns the value of the '<em><b>Value Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Query</em>' reference.
	 * @see #setValueQuery(ModelQuery)
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetStructuralFeature_ValueQuery()
	 * @model required="true"
	 * @generated
	 */
	ModelQuery getValueQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.infra.facet.FacetStructuralFeature#getValueQuery <em>Value Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Query</em>' reference.
	 * @see #getValueQuery()
	 * @generated
	 */
	void setValueQuery(ModelQuery value);

	/**
	 * Returns the value of the '<em><b>Set Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set query has to have one parameter. This parameter will be used to send the new value of the derived structural feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Set Query</em>' reference.
	 * @see #setSetQuery(ModelQuery)
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getFacetStructuralFeature_SetQuery()
	 * @model
	 * @generated
	 */
	ModelQuery getSetQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.infra.facet.FacetStructuralFeature#getSetQuery <em>Set Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Query</em>' reference.
	 * @see #getSetQuery()
	 * @generated
	 */
	void setSetQuery(ModelQuery value);

} // FacetStructuralFeature
