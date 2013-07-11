/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.example.text.instance.papyrustextinstance;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Text Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getEditedObject <em>Edited Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrustextinstancePackage#getPapyrusTextInstance()
 * @model
 * @generated
 */
public interface PapyrusTextInstance extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Edited Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edited Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edited Object</em>' reference.
	 * @see #setEditedObject(EObject)
	 * @see org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrustextinstancePackage#getPapyrusTextInstance_EditedObject()
	 * @model
	 * @generated
	 */
	EObject getEditedObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getEditedObject <em>Edited Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edited Object</em>' reference.
	 * @see #getEditedObject()
	 * @generated
	 */
	void setEditedObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrustextinstancePackage#getPapyrusTextInstance_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrustextinstancePackage#getPapyrusTextInstance_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // PapyrusTextInstance
