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
 *   Christian W. Damus - add prototype reference to ContextDescriptor (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.preferences;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#isApplied <em>Applied</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#getPrototype <em>Prototype</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getContextDescriptor()
 * @model
 * @generated
 */
public interface ContextDescriptor extends EObject {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Applied</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Applied</em>' attribute.
	 * @see #setApplied(boolean)
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Applied()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isApplied();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#isApplied <em>Applied</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Applied</em>' attribute.
	 * @see #isApplied()
	 * @generated
	 */
	void setApplied(boolean value);

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the descriptor of the context from which a context was copied. This allows the configuration manager to apply the original context
	 * when the copy is not available. This process is recursive over a chain of missing prototypes.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see #setPrototype(ContextDescriptor)
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Prototype()
	 * @model
	 * @generated
	 */
	ContextDescriptor getPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#getPrototype <em>Prototype</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Prototype</em>' reference.
	 * @see #getPrototype()
	 * @generated
	 */
	void setPrototype(ContextDescriptor value);

	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the context was explicitly deleted by the user. If not explicitly deleted, and there isn't currently a matching context available, then
	 * the context is deemed to be missing.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #setDeleted(boolean)
	 * @see org.eclipse.papyrus.views.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Deleted()
	 * @model required="true"
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.runtime.preferences.ContextDescriptor#isDeleted <em>Deleted</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

} // ContextDescriptor
