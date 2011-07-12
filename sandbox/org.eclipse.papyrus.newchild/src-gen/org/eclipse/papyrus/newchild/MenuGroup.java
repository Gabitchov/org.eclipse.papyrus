/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuGroup#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuGroup#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.newchild.MenuGroup#getAbsolutePosition <em>Absolute Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuGroup()
 * @model
 * @generated
 */
public interface MenuGroup extends MenuContainer {
	/**
	 * Returns the value of the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' attribute.
	 * @see #setBefore(String)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuGroup_Before()
	 * @model
	 * @generated
	 */
	String getBefore();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.MenuGroup#getBefore <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Before</em>' attribute.
	 * @see #getBefore()
	 * @generated
	 */
	void setBefore(String value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' attribute.
	 * @see #setAfter(String)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuGroup_After()
	 * @model
	 * @generated
	 */
	String getAfter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.MenuGroup#getAfter <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' attribute.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(String value);

	/**
	 * Returns the value of the '<em><b>Absolute Position</b></em>' attribute.
	 * The default value is <code>"top"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.newchild.MenuPosition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absolute Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Absolute Position</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.MenuPosition
	 * @see #setAbsolutePosition(MenuPosition)
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getMenuGroup_AbsolutePosition()
	 * @model default="top"
	 * @generated
	 */
	MenuPosition getAbsolutePosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.newchild.MenuGroup#getAbsolutePosition <em>Absolute Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Absolute Position</em>' attribute.
	 * @see org.eclipse.papyrus.newchild.MenuPosition
	 * @see #getAbsolutePosition()
	 * @generated
	 */
	void setAbsolutePosition(MenuPosition value);

} // MenuGroup
