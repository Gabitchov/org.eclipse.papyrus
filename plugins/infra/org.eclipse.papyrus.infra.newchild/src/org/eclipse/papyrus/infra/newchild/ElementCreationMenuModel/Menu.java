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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getMenu()
 * @model abstract="true"
 * @generated
 */
public interface Menu extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getMenu_Label()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getMenu_Icon()
	 * @model ordered="false"
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

} // Menu
