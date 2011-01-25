/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Context#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Context#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Context#getTabs <em>Tabs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Context#getDataContexts <em>Data Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject {
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
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getContext_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Context#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.View}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.View#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getContext_Views()
	 * @see org.eclipse.papyrus.properties.contexts.View#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>Tabs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.Tab}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tabs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tabs</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getContext_Tabs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tab> getTabs();

	/**
	 * Returns the value of the '<em><b>Data Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.DataContextRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Contexts</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getContext_DataContexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataContextRoot> getDataContexts();

} // Context
