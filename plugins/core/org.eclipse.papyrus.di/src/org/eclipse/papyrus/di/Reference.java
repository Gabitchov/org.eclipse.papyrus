/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.Reference#isIsIndividualRepresentation <em>Is Individual Representation</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.Reference#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends DiagramElement {

	/**
	 * Returns the value of the '<em><b>Is Individual Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Individual Representation</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Individual Representation</em>' attribute.
	 * @see #setIsIndividualRepresentation(boolean)
	 * @see org.eclipse.papyrus.di.DiPackage#getReference_IsIndividualRepresentation()
	 * @model dataType="org.eclipse.uml2.uml.Boolean"
	 * @generated
	 */
	boolean isIsIndividualRepresentation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.Reference#isIsIndividualRepresentation <em>Is Individual Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Individual Representation</em>' attribute.
	 * @see #isIsIndividualRepresentation()
	 * @generated
	 */
	void setIsIndividualRepresentation(boolean value);

	/**
	 * Returns the value of the '<em><b>Referenced</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referenced</em>' reference.
	 * @see #setReferenced(DiagramElement)
	 * @see org.eclipse.papyrus.di.DiPackage#getReference_Referenced()
	 * @model required="true"
	 * @generated
	 */
	DiagramElement getReferenced();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.di.Reference#getReferenced <em>Referenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Referenced</em>' reference.
	 * @see #getReferenced()
	 * @generated
	 */
	void setReferenced(DiagramElement value);

} // Reference
