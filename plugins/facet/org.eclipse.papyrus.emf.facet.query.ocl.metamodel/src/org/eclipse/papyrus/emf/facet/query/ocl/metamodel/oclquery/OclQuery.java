/**
 *  Copyright (c) 2012 Mia-Software.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 
 * 
 */
package org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage#getOclQuery()
 * @model
 * @generated
 */
public interface OclQuery extends Query {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EClassifier)
	 * @see org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage#getOclQuery_Context()
	 * @model
	 * @generated
	 */
	EClassifier getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' attribute.
	 * @see #setOclExpression(String)
	 * @see org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage#getOclQuery_OclExpression()
	 * @model
	 * @generated
	 */
	String getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getOclExpression <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' attribute.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return getOclExpression();'"
	 * @generated
	 */
	String toString();

} // OclQuery
