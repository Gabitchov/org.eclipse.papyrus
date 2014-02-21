/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETyped Element Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Case part of the ETypedElementSwitchQuery.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getETypedElementCase()
 * @model
 * @generated
 */
public interface ETypedElementCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' reference.
	 * @see #setCase(ETypedElement)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getETypedElementCase_Case()
	 * @model required="true"
	 * @generated
	 */
	ETypedElement getCase();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getCase <em>Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case</em>' reference.
	 * @see #getCase()
	 * @generated
	 */
	void setCase(ETypedElement value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Query)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#getETypedElementCase_Value()
	 * @model containment="true"
	 * @generated
	 */
	Query getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Query value);

} // ETypedElementCase
