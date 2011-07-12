/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.constraints.DisplayUnit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuRoot#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuRoot()
 * @model
 * @generated
 */
public interface MenuRoot extends MenuContainer, DisplayUnit {

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.newchild.MenuGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuRoot_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuGroup> getGroups();
} // MenuRoot
