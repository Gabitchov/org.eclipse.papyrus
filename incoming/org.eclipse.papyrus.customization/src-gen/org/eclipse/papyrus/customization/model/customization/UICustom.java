/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Custom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.UICustom#isLoadByDefault <em>Load By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUICustom()
 * @model
 * @generated
 */
public interface UICustom extends FileBasedCustomizableElement {
	/**
	 * Returns the value of the '<em><b>Load By Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load By Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load By Default</em>' attribute.
	 * @see #setLoadByDefault(boolean)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUICustom_LoadByDefault()
	 * @model default="false"
	 * @generated
	 */
	boolean isLoadByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.UICustom#isLoadByDefault <em>Load By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load By Default</em>' attribute.
	 * @see #isLoadByDefault()
	 * @generated
	 */
	void setLoadByDefault(boolean value);

} // UICustom
