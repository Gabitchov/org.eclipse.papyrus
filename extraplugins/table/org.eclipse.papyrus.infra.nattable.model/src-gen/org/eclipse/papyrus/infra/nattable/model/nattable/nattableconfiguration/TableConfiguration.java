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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.AbstractTableTester;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester <em>Creation Tester</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration <em>Cell Editor Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration <em>Row Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration <em>Column Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnAxisProviders <em>Column Axis Providers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowAxisProviders <em>Row Axis Providers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider <em>Default Row Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider <em>Default Column Axis Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration()
 * @model
 * @generated
 */
public interface TableConfiguration extends TableNamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_IconPath()
	 * @model
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Creation Tester</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Tester</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Tester</em>' containment reference.
	 * @see #setCreationTester(AbstractTableTester)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_CreationTester()
	 * @model containment="true"
	 * @generated
	 */
	AbstractTableTester getCreationTester();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester <em>Creation Tester</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Tester</em>' containment reference.
	 * @see #getCreationTester()
	 * @generated
	 */
	void setCreationTester(AbstractTableTester value);

	/**
	 * Returns the value of the '<em><b>Cell Editor Declaration</b></em>' attribute.
	 * The default value is <code>"COLUMN"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Editor Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #setCellEditorDeclaration(CellEditorDeclaration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_CellEditorDeclaration()
	 * @model default="COLUMN" required="true"
	 * @generated
	 */
	CellEditorDeclaration getCellEditorDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration <em>Cell Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #getCellEditorDeclaration()
	 * @generated
	 */
	void setCellEditorDeclaration(CellEditorDeclaration value);

	/**
	 * Returns the value of the '<em><b>Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Header Axis Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Header Axis Configuration</em>' containment reference.
	 * @see #setRowHeaderAxisConfiguration(TableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_RowHeaderAxisConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TableHeaderAxisConfiguration getRowHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration <em>Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Header Axis Configuration</em>' containment reference.
	 * @see #getRowHeaderAxisConfiguration()
	 * @generated
	 */
	void setRowHeaderAxisConfiguration(TableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Header Axis Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Header Axis Configuration</em>' containment reference.
	 * @see #setColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_ColumnHeaderAxisConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TableHeaderAxisConfiguration getColumnHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration <em>Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Header Axis Configuration</em>' containment reference.
	 * @see #getColumnHeaderAxisConfiguration()
	 * @generated
	 */
	void setColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Column Axis Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Axis Providers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Axis Providers</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_ColumnAxisProviders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getColumnAxisProviders();

	/**
	 * Returns the value of the '<em><b>Row Axis Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Axis Providers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Axis Providers</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_RowAxisProviders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getRowAxisProviders();

	/**
	 * Returns the value of the '<em><b>Default Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Row Axis Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Row Axis Provider</em>' reference.
	 * @see #setDefaultRowAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_DefaultRowAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getDefaultRowAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider <em>Default Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Row Axis Provider</em>' reference.
	 * @see #getDefaultRowAxisProvider()
	 * @generated
	 */
	void setDefaultRowAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Default Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Column Axis Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Column Axis Provider</em>' reference.
	 * @see #setDefaultColumnAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_DefaultColumnAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getDefaultColumnAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider <em>Default Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Column Axis Provider</em>' reference.
	 * @see #getDefaultColumnAxisProvider()
	 * @generated
	 */
	void setDefaultColumnAxisProvider(AbstractAxisProvider value);

} // TableConfiguration
