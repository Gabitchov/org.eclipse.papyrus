/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.ui;

import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.UnknownProperty;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getWidgetType <em>Widget Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getUnresolvedProperty <em>Unresolved Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getContentProviderClass <em>Content Provider Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#isShowLabel <em>Show Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getCustomLabel <em>Custom Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor()
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
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getProperty <em>Property</em>}' reference.
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
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_ReadOnly()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#isReadOnly <em>Read Only</em>}' attribute.
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
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_WidgetType()
	 * @model required="true"
	 * @generated
	 */
	PropertyEditorType getWidgetType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getWidgetType <em>Widget Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Type</em>' reference.
	 * @see #getWidgetType()
	 * @generated
	 */
	void setWidgetType(PropertyEditorType value);

	/**
	 * Returns the value of the '<em><b>Unresolved Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unresolved Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unresolved Property</em>' containment reference.
	 * @see #setUnresolvedProperty(UnknownProperty)
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_UnresolvedProperty()
	 * @model containment="true"
	 * @generated
	 */
	UnknownProperty getUnresolvedProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getUnresolvedProperty <em>Unresolved Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unresolved Property</em>' containment reference.
	 * @see #getUnresolvedProperty()
	 * @generated
	 */
	void setUnresolvedProperty(UnknownProperty value);

	/**
	 * Returns the value of the '<em><b>Content Provider Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Provider Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Provider Class</em>' attribute.
	 * @see #setContentProviderClass(String)
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_ContentProviderClass()
	 * @model
	 * @generated
	 */
	String getContentProviderClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getContentProviderClass <em>Content Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Provider Class</em>' attribute.
	 * @see #getContentProviderClass()
	 * @generated
	 */
	void setContentProviderClass(String value);

	/**
	 * Returns the value of the '<em><b>Show Label</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Label</em>' attribute.
	 * @see #setShowLabel(boolean)
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_ShowLabel()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isShowLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#isShowLabel <em>Show Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Label</em>' attribute.
	 * @see #isShowLabel()
	 * @generated
	 */
	void setShowLabel(boolean value);

	/**
	 * Returns the value of the '<em><b>Custom Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Label</em>' attribute.
	 * @see #setCustomLabel(String)
	 * @see org.eclipse.papyrus.views.properties.ui.UiPackage#getPropertyEditor_CustomLabel()
	 * @model
	 * @generated
	 */
	String getCustomLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.ui.PropertyEditor#getCustomLabel <em>Custom Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Label</em>' attribute.
	 * @see #getCustomLabel()
	 * @generated
	 */
	void setCustomLabel(String value);

} // PropertyEditor
