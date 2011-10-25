/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.root;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.properties.contexts.Context;

import org.eclipse.papyrus.properties.environment.Environment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Root</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.properties.root.PropertiesRoot#getEnvironments <em>Environments</em>}</li>
 * <li>{@link org.eclipse.papyrus.properties.root.PropertiesRoot#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.properties.root.RootPackage#getPropertiesRoot()
 * @model
 * @generated
 */
public interface PropertiesRoot extends EObject {

	/**
	 * Returns the value of the '<em><b>Environments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.Environment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environments</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Environments</em>' reference list.
	 * @see org.eclipse.papyrus.properties.root.RootPackage#getPropertiesRoot_Environments()
	 * @model
	 * @generated
	 */
	EList<Environment> getEnvironments();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contexts</em>' reference list.
	 * @see org.eclipse.papyrus.properties.root.RootPackage#getPropertiesRoot_Contexts()
	 * @model
	 * @generated
	 */
	EList<Context> getContexts();

} // PropertiesRoot
