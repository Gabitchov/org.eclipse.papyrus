/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.MenuRoot#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.MenuRoot#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getMenuRoot()
 * @model
 * @generated
 */
public interface MenuRoot extends MenuContainer, DisplayUnit {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.newchild.MenuGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getMenuRoot_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuGroup> getGroups();

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
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getMenuRoot_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.MenuRoot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MenuRoot
