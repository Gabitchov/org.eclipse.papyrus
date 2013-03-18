/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getEditorConfiguration <em>Editor Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getVerticalAxisProvider <em>Vertical Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis <em>Invert Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EModelElement {
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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Context()
	 * @model
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Editor Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Configuration</em>' reference.
	 * @see #setEditorConfiguration(TableEditorConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_EditorConfiguration()
	 * @model required="true"
	 * @generated
	 */
	TableEditorConfiguration getEditorConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getEditorConfiguration <em>Editor Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Configuration</em>' reference.
	 * @see #getEditorConfiguration()
	 * @generated
	 */
	void setEditorConfiguration(TableEditorConfiguration value);

	/**
	 * Returns the value of the '<em><b>Vertical Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Axis Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Axis Provider</em>' containment reference.
	 * @see #setVerticalAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_VerticalAxisProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractAxisProvider getVerticalAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getVerticalAxisProvider <em>Vertical Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Axis Provider</em>' containment reference.
	 * @see #getVerticalAxisProvider()
	 * @generated
	 */
	void setVerticalAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Horizontal Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Axis Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Axis Provider</em>' containment reference.
	 * @see #setHorizontalAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_HorizontalAxisProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractAxisProvider getHorizontalAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Axis Provider</em>' containment reference.
	 * @see #getHorizontalAxisProvider()
	 * @generated
	 */
	void setHorizontalAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Invert Axis</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invert Axis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invert Axis</em>' attribute.
	 * @see #setInvertAxis(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_InvertAxis()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isInvertAxis();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis <em>Invert Axis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invert Axis</em>' attribute.
	 * @see #isInvertAxis()
	 * @generated
	 */
	void setInvertAxis(boolean value);

} // Table
