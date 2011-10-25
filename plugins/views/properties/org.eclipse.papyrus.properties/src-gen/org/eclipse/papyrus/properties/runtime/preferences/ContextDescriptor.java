/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.runtime.preferences;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#isApplied <em>Applied</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage#getContextDescriptor()
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
	 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#getName <em>Name</em>}' attribute.
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
	 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesPackage#getContextDescriptor_Applied()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isApplied();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#isApplied <em>Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Applied</em>' attribute.
	 * @see #isApplied()
	 * @generated
	 */
	void setApplied(boolean value);

} // ContextDescriptor
