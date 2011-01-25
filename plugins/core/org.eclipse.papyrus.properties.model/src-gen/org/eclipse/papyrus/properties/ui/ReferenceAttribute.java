/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.ui.ReferenceAttribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.ui.UiPackage#getReferenceAttribute()
 * @model
 * @generated
 */
public interface ReferenceAttribute extends WidgetAttribute {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(UIComponent)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getReferenceAttribute_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UIComponent getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.ReferenceAttribute#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(UIComponent value);

} // ReferenceAttribute
