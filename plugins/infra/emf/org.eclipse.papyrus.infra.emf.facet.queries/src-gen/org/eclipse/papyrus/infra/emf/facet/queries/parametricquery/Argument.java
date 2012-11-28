/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument#getArgumentName <em>Argument Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage#getArgument()
 * @model abstract="true"
 * @generated
 */
public interface Argument extends EObject {

	/**
	 * Returns the value of the '<em><b>Argument Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Argument Name</em>' attribute.
	 * @see #setArgumentName(String)
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage#getArgument_ArgumentName()
	 * @model
	 * @generated
	 */
	String getArgumentName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument#getArgumentName <em>Argument Name</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Argument Name</em>' attribute.
	 * @see #getArgumentName()
	 * @generated
	 */
	void setArgumentName(String value);
} // Argument
