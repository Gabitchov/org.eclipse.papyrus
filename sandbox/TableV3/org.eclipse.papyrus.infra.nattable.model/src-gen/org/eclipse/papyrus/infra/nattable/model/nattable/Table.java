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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration <em>Table Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis <em>Invert Axis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getColumnAxisProvidersHistory <em>Column Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getRowAxisProvidersHistory <em>Row Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration <em>Local Row Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration <em>Local Column Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider <em>Current Row Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider <em>Current Column Axis Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable()
 * @model
 * @generated
 */
public interface Table extends TableNamedElement {
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
	 * Returns the value of the '<em><b>Table Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Configuration</em>' reference.
	 * @see #setTableConfiguration(TableConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_TableConfiguration()
	 * @model required="true"
	 * @generated
	 */
	TableConfiguration getTableConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration <em>Table Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Configuration</em>' reference.
	 * @see #getTableConfiguration()
	 * @generated
	 */
	void setTableConfiguration(TableConfiguration value);

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

	/**
	 * Returns the value of the '<em><b>Column Axis Providers History</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Axis Providers History</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Axis Providers History</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_ColumnAxisProvidersHistory()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getColumnAxisProvidersHistory();

	/**
	 * Returns the value of the '<em><b>Row Axis Providers History</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Axis Providers History</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Axis Providers History</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_RowAxisProvidersHistory()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getRowAxisProvidersHistory();

	/**
	 * Returns the value of the '<em><b>Local Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Row Header Axis Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Row Header Axis Configuration</em>' containment reference.
	 * @see #setLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_LocalRowHeaderAxisConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	LocalTableHeaderAxisConfiguration getLocalRowHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration <em>Local Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Row Header Axis Configuration</em>' containment reference.
	 * @see #getLocalRowHeaderAxisConfiguration()
	 * @generated
	 */
	void setLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Local Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Column Header Axis Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Column Header Axis Configuration</em>' containment reference.
	 * @see #setLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_LocalColumnHeaderAxisConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	LocalTableHeaderAxisConfiguration getLocalColumnHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration <em>Local Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Column Header Axis Configuration</em>' containment reference.
	 * @see #getLocalColumnHeaderAxisConfiguration()
	 * @generated
	 */
	void setLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Current Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Row Axis Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Row Axis Provider</em>' reference.
	 * @see #setCurrentRowAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_CurrentRowAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getCurrentRowAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider <em>Current Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Row Axis Provider</em>' reference.
	 * @see #getCurrentRowAxisProvider()
	 * @generated
	 */
	void setCurrentRowAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Current Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Column Axis Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Column Axis Provider</em>' reference.
	 * @see #setCurrentColumnAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_CurrentColumnAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getCurrentColumnAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider <em>Current Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Column Axis Provider</em>' reference.
	 * @see #getCurrentColumnAxisProvider()
	 * @generated
	 */
	void setCurrentColumnAxisProvider(AbstractAxisProvider value);

} // Table
