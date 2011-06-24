/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getCustomizationConfiguration()
 * @model
 * @generated
 */
public interface CustomizationConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getCustomizationConfiguration_Plugin()
	 * @model required="true"
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.model.customization.CustomizableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getCustomizationConfiguration_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<CustomizableElement> getElements();

} // CustomizationConfiguration
