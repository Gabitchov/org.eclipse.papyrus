/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui;

import org.eclipse.papyrus.properties.environment.LayoutType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.ui.Layout#getLayoutType <em>Layout Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.ui.UiPackage#getLayout()
 * @model
 * @generated
 */
public interface Layout extends UIComponent {
	/**
	 * Returns the value of the '<em><b>Layout Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Type</em>' reference.
	 * @see #setLayoutType(LayoutType)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getLayout_LayoutType()
	 * @model required="true"
	 * @generated
	 */
	LayoutType getLayoutType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.Layout#getLayoutType <em>Layout Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Type</em>' reference.
	 * @see #getLayoutType()
	 * @generated
	 */
	void setLayoutType(LayoutType value);

} // Layout
