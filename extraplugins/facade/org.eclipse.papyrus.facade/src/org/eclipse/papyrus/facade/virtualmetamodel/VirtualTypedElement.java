/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface VirtualTypedElement extends VirtualElement {
	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualTypedElement_Lower()
	 * @model required="true"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualTypedElement_Upper()
	 * @model required="true"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(VirtualClassifier)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualTypedElement_Type()
	 * @model required="true"
	 * @generated
	 */
	VirtualClassifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(VirtualClassifier value);

} // VirtualTypedElement
