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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Folder#getMenu <em>Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends Menu {
	/**
	 * Returns the value of the '<em><b>Menu</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage#getFolder_Menu()
	 * @model containment="true"
	 * @generated
	 */
	EList<Menu> getMenu();

} // Folder
