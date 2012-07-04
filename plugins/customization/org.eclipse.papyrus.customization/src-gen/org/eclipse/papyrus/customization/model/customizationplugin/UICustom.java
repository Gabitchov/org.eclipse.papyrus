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
 * A representation of the model object '<em><b>UI Custom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.UICustom#isLoadByDefault <em>Load By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getUICustom()
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
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getUICustom_LoadByDefault()
	 * @model default="false"
	 * @generated
	 */
	boolean isLoadByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.UICustom#isLoadByDefault <em>Load By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load By Default</em>' attribute.
	 * @see #isLoadByDefault()
	 * @generated
	 */
	void setLoadByDefault(boolean value);

} // UICustom
