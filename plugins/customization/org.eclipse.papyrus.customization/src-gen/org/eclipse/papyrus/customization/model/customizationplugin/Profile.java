/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.model.customizationplugin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getQualifiednames <em>Qualifiednames</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getIconpath <em>Iconpath</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile()
 * @model
 * @generated
 */
public interface Profile extends FileBasedCustomizableElement {
	/**
	 * Returns the value of the '<em><b>Qualifiednames</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiednames</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiednames</em>' attribute.
	 * @see #setQualifiednames(String)
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile_Qualifiednames()
	 * @model
	 * @generated
	 */
	String getQualifiednames();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getQualifiednames <em>Qualifiednames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifiednames</em>' attribute.
	 * @see #getQualifiednames()
	 * @generated
	 */
	void setQualifiednames(String value);

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
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile_Iconpath()
	 * @model
	 * @generated
	 */
	String getIconpath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getIconpath <em>Iconpath</em>}' attribute.
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
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getDescription <em>Description</em>}' attribute.
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
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

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
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getProfile_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Profile
