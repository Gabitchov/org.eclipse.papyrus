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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acquire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire#isIsBlocking <em>Is Blocking</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getAcquire()
 * @model
 * @generated
 */
public interface Acquire extends GrService {
	/**
	 * Returns the value of the '<em><b>Is Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Blocking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Blocking</em>' attribute.
	 * @see #setIsBlocking(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getAcquire_IsBlocking()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsBlocking();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire#isIsBlocking <em>Is Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Blocking</em>' attribute.
	 * @see #isIsBlocking()
	 * @generated
	 */
	void setIsBlocking(boolean value);

} // Acquire
