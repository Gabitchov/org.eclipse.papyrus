/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui;

import org.eclipse.papyrus.properties.contexts.Property;

import org.eclipse.papyrus.properties.environment.PropertyEditorType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.ui.PropertyEditor#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getWidgetType <em>Widget Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.ui.UiPackage#getPropertyEditor()
 * @model
 * @generated
 */
public interface PropertyEditor extends Widget {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getPropertyEditor_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getPropertyEditor_ReadOnly()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Widget Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Type</em>' reference.
	 * @see #setWidgetType(PropertyEditorType)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getPropertyEditor_WidgetType()
	 * @model required="true"
	 * @generated
	 */
	PropertyEditorType getWidgetType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getWidgetType <em>Widget Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Type</em>' reference.
	 * @see #getWidgetType()
	 * @generated
	 */
	void setWidgetType(PropertyEditorType value);

} // PropertyEditor
