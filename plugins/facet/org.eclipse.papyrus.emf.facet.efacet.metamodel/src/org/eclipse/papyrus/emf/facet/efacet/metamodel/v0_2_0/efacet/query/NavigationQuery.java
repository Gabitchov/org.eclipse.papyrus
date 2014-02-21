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
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This query points to a typed element (another attribute, reference or operation for example) that lends it value to the query.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#isFailOnError <em>Fail On Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getNavigationQuery()
 * @model
 * @generated
 */
public interface NavigationQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.ETypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getNavigationQuery_Path()
	 * @model required="true"
	 * @generated
	 */
	EList<ETypedElement> getPath();

	/**
	 * Returns the value of the '<em><b>Fail On Error</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fail On Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fail On Error</em>' attribute.
	 * @see #setFailOnError(boolean)
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#getNavigationQuery_FailOnError()
	 * @model default="true"
	 * @generated
	 */
	boolean isFailOnError();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#isFailOnError <em>Fail On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fail On Error</em>' attribute.
	 * @see #isFailOnError()
	 * @generated
	 */
	void setFailOnError(boolean value);

} // NavigationQuery
