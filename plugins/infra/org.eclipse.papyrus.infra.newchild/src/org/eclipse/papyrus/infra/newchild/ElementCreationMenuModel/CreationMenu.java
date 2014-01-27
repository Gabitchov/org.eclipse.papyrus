/**
 * Copyright (c) 2013 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Creation Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#getElementTypeIdRef <em>Element Type Id Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#isDisplayAllRoles <em>Display All Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getCreationMenu()
 * @model
 * @generated
 */
public interface CreationMenu extends Menu {
	/**
	 * Returns the value of the '<em><b>Element Type Id Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Id Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Id Ref</em>' attribute.
	 * @see #setElementTypeIdRef(String)
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getCreationMenu_ElementTypeIdRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getElementTypeIdRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#getElementTypeIdRef <em>Element Type Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Id Ref</em>' attribute.
	 * @see #getElementTypeIdRef()
	 * @generated
	 */
	void setElementTypeIdRef(String value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see #setRole(String)
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getCreationMenu_Role()
	 * @model ordered="false"
	 * @generated
	 */
	String getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(String value);

	/**
	 * Returns the value of the '<em><b>Display All Roles</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display All Roles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display All Roles</em>' attribute.
	 * @see #setDisplayAllRoles(boolean)
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getCreationMenu_DisplayAllRoles()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isDisplayAllRoles();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu#isDisplayAllRoles <em>Display All Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display All Roles</em>' attribute.
	 * @see #isDisplayAllRoles()
	 * @generated
	 */
	void setDisplayAllRoles(boolean value);

} // CreationMenu
