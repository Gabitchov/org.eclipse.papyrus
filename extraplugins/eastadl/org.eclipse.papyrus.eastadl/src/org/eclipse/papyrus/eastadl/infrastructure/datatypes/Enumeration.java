/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.Enumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends EADatatype {

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumeration_Literal()
	 * @model containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiteral();

} // Enumeration
