/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;

import org.eclipse.papyrus.extendedtypes.ExtendedElementTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuAction#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuAction#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuAction()
 * @model
 * @generated
 */
public interface MenuAction extends MenuItem {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(ExtendedElementTypeConfiguration)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuAction_ElementType()
	 * @model required="true"
	 * @generated
	 */
	ExtendedElementTypeConfiguration getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.MenuAction#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(ExtendedElementTypeConfiguration value);

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
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuAction_Position()
	 * @model default="child" required="true"
	 * @generated
	 */
	ElementPosition getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.MenuAction#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.ElementPosition
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(ElementPosition value);

} // MenuAction
