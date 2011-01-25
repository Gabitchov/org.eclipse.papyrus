/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.runtime.preferences;

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
 * <li>{@link org.eclipse.papyrus.properties.runtime.preferences.Preferences#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage#getPreferences()
 * @model
 * @generated
 */
public interface Preferences extends EObject {

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage#getPreferences_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextDescriptor> getContexts();

} // Preferences
