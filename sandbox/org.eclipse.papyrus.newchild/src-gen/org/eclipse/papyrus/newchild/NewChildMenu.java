/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Child Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.NewChildMenu#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.NewChildMenu#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.NewchildPackage#getNewChildMenu()
 * @model
 * @generated
 */
public interface NewChildMenu extends Menu {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"child"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.newchild.ElementPosition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.ElementPosition
	 * @see #setPosition(ElementPosition)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getNewChildMenu_Position()
	 * @model default="child" required="true"
	 * @generated
	 */
	ElementPosition getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.NewChildMenu#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.ElementPosition
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(ElementPosition value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"hierarchical"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.newchild.NewChildKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.NewChildKind
	 * @see #setKind(NewChildKind)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getNewChildMenu_Kind()
	 * @model default="hierarchical" required="true"
	 * @generated
	 */
	NewChildKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.NewChildMenu#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.NewChildKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(NewChildKind value);

} // NewChildMenu
