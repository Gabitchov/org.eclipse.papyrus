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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Query is the abstract representation of the concept of query. This class has to be sub-classed for each existing query language (Java, OCL, etc.)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query#isCanHaveSideEffects <em>Can Have Side Effects</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query#isCanBeCached <em>Can Be Cached</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage#getQuery()
 * @model abstract="true"
 * @generated
 */
public interface Query extends EObject {
	/**
	 * Returns the value of the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Have Side Effects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Have Side Effects</em>' attribute.
	 * @see #setCanHaveSideEffects(boolean)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage#getQuery_CanHaveSideEffects()
	 * @model
	 * @generated
	 */
	boolean isCanHaveSideEffects();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query#isCanHaveSideEffects <em>Can Have Side Effects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Have Side Effects</em>' attribute.
	 * @see #isCanHaveSideEffects()
	 * @generated
	 */
	void setCanHaveSideEffects(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Be Cached</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Be Cached</em>' attribute.
	 * @see #setCanBeCached(boolean)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage#getQuery_CanBeCached()
	 * @model
	 * @generated
	 */
	boolean isCanBeCached();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query#isCanBeCached <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Be Cached</em>' attribute.
	 * @see #isCanBeCached()
	 * @generated
	 */
	void setCanBeCached(boolean value);

} // Query
