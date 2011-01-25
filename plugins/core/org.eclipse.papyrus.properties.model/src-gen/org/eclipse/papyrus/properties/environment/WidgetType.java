/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.WidgetType#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.WidgetType#getWidgetClass <em>Widget Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getWidgetType()
 * @model abstract="true"
 * @generated
 */
public interface WidgetType extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getWidgetType_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.WidgetType#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Widget Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Class</em>' attribute.
	 * @see #setWidgetClass(String)
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getWidgetType_WidgetClass()
	 * @model required="true"
	 * @generated
	 */
	String getWidgetClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.WidgetType#getWidgetClass <em>Widget Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Class</em>' attribute.
	 * @see #getWidgetClass()
	 * @generated
	 */
	void setWidgetClass(String value);

} // WidgetType
