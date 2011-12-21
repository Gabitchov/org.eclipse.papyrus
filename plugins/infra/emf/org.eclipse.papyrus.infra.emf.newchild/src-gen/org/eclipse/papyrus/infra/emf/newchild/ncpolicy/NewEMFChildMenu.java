/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.emf.newchild.Menu;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New EMF Child Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu#getCreateIn <em>Create In</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewEMFChildMenu()
 * @model
 * @generated
 */
public interface NewEMFChildMenu extends Menu {
	/**
	 * Returns the value of the '<em><b>Create In</b></em>' attribute.
	 * The default value is <code>"self"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CreateIn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create In</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create In</em>' attribute.
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CreateIn
	 * @see #setCreateIn(CreateIn)
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewEMFChildMenu_CreateIn()
	 * @model default="self" required="true"
	 * @generated
	 */
	CreateIn getCreateIn();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu#getCreateIn <em>Create In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create In</em>' attribute.
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CreateIn
	 * @see #getCreateIn()
	 * @generated
	 */
	void setCreateIn(CreateIn value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * The default value is <code>"hierarchical"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.Layout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.Layout
	 * @see #setLayout(Layout)
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewEMFChildMenu_Layout()
	 * @model default="hierarchical" required="true"
	 * @generated
	 */
	Layout getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewEMFChildMenu#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.Layout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout value);

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
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewEMFChildMenu_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuGroup> getGroups();

} // NewEMFChildMenu
