/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - add version number to Preferences model (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.preferences;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.Preferences#getContexts <em>Contexts</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.Preferences#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getPreferences()
 * @model
 * @generated
 */
public interface Preferences extends EObject {

	/**
	 * The current version of the Preferences model.
	 * 
	 * @generated NOT
	 */
	int CURRENT_VERSION = 2;
	
	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getPreferences_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextDescriptor> getContexts();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An incremental version number. The version number changes when the semantics
	 * or interpretation of the preferences model changes. It is required for migration of
	 * preferences data in workspace upgrades. The model structure, itself, always
	 * maintains backwards compatibility.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getPreferences_Version()
	 * @model default="1"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.runtime.preferences.Preferences#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

} // Preferences
