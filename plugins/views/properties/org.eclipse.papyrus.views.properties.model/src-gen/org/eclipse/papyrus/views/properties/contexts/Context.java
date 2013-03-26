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
 *   Christian W. Damus - add prototype reference to Context (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.contexts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getTabs <em>Tabs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getDataContexts <em>Data Contexts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.contexts.Context#getPrototype <em>Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EModelElement {
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
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.Context#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.views.properties.contexts.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_Dependencies()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Context> getDependencies();

	/**
	 * Returns the value of the '<em><b>Tabs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.views.properties.contexts.Tab}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tabs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tabs</em>' containment reference list.
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_Tabs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tab> getTabs();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.views.properties.contexts.View}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.views.properties.contexts.View#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_Views()
	 * @see org.eclipse.papyrus.views.properties.contexts.View#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<View> getViews();

	/**
	 * Returns the value of the '<em><b>Data Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.views.properties.contexts.DataContextRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Contexts</em>' containment reference list.
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_DataContexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataContextRoot> getDataContexts();

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the context from which a context was copied.  The context manager caches the prototype reference so that it can enable a prototype when the copied context is not available.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see #setPrototype(Context)
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getContext_Prototype()
	 * @model
	 * @generated
	 */
	Context getPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.Context#getPrototype <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prototype</em>' reference.
	 * @see #getPrototype()
	 * @generated
	 */
	void setPrototype(Context value);

} // Context
