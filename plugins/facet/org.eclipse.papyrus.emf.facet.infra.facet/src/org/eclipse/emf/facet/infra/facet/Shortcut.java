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
 *     Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shortcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.Shortcut#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.Shortcut#getOppositeReference <em>Opposite Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getShortcut()
 * @model
 * @generated
 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198)
 */
@Deprecated
public interface Shortcut extends EReference {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' reference list.
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getShortcut_Path()
	 * @model
	 * @generated
	 */
	EList<EReference> getPath();

	/**
	 * Returns the value of the '<em><b>Opposite Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Reference</em>' reference.
	 * @see #setOppositeReference(EReference)
	 * @see org.eclipse.emf.facet.infra.facet.FacetPackage#getShortcut_OppositeReference()
	 * @model
	 * @generated
	 */
	EReference getOppositeReference();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.infra.facet.Shortcut#getOppositeReference <em>Opposite Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Reference</em>' reference.
	 * @see #getOppositeReference()
	 * @generated
	 */
	void setOppositeReference(EReference value);

} // Shortcut
