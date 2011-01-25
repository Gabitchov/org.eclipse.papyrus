/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.properties.environment.CompositeWidgetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgets <em>Widgets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgetType <em>Widget Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.ui.UiPackage#getCompositeWidget()
 * @model
 * @generated
 */
public interface CompositeWidget extends Widget {
	/**
	 * Returns the value of the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' containment reference.
	 * @see #setLayout(Layout)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getCompositeWidget_Layout()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Layout getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getLayout <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' containment reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout value);

	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.ui.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getCompositeWidget_Widgets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

	/**
	 * Returns the value of the '<em><b>Widget Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Type</em>' reference.
	 * @see #setWidgetType(CompositeWidgetType)
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#getCompositeWidget_WidgetType()
	 * @model required="true"
	 * @generated
	 */
	CompositeWidgetType getWidgetType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgetType <em>Widget Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Type</em>' reference.
	 * @see #getWidgetType()
	 * @generated
	 */
	void setWidgetType(CompositeWidgetType value);

} // CompositeWidget
