/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.MenuContainer#getSubmenus <em>Submenus</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getMenuContainer()
 * @model abstract="true"
 * @generated
 */
public interface MenuContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Submenus</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.newchild.MenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submenus</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submenus</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getMenuContainer_Submenus()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuItem> getSubmenus();

} // MenuContainer
