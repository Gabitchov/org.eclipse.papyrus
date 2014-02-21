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
package org.eclipse.papyrus.emf.facet.efacet;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opposite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a virtual opposite reference of an existing reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.OppositeReference#getFOpposite <em>FOpposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getOppositeReference()
 * @model
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface OppositeReference extends FacetElement {
	/**
	 * Returns the value of the '<em><b>FOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FOpposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FOpposite</em>' reference.
	 * @see #setFOpposite(EReference)
	 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage#getOppositeReference_FOpposite()
	 * @model
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.OppositeReference#getFOpposite <em>FOpposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FOpposite</em>' reference.
	 * @see #getFOpposite()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	void setFOpposite(EReference value);

} // OppositeReference
