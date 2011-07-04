/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getIconpath <em>Iconpath</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getProvider <em>Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUMLModel()
 * @model
 * @generated
 */
public interface UMLModel extends FileBasedCustomizableElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUMLModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Iconpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iconpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iconpath</em>' attribute.
	 * @see #setIconpath(String)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUMLModel_Iconpath()
	 * @model
	 * @generated
	 */
	String getIconpath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getIconpath <em>Iconpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iconpath</em>' attribute.
	 * @see #getIconpath()
	 * @generated
	 */
	void setIconpath(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUMLModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage#getUMLModel_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

} // UMLModel
