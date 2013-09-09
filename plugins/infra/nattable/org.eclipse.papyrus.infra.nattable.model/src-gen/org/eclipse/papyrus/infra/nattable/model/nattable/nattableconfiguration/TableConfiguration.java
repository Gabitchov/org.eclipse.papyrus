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
 * <!-- begin-model-doc -->
 * This object is used to configure a table. To create a new type of table, you must create
 * a new file *.nattableConfiguration and register it using the extension point org.eclipse.papyrus.infra.nattable.configuration
 * 
 * the defaultAxisProviders can be : Master/Master, Master/Slave, Slave/Master and never Slave/Slave.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath <em>Icon Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester <em>Creation Tester</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration <em>Cell Editor
 * Declaration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration <em>Row Header
 * Axis Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration <em>Column
 * Header Axis Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnAxisProviders <em>Column Axis
 * Providers</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowAxisProviders <em>Row Axis Providers
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider <em>Default Row
 * Axis Provider</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider <em>Default
 * Column Axis Provider</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration()
 * @model annotation=
 *        "http://www.eclipse.org/emf/2002/Ecore constraints='defaultRowAxisProviderExistsInCollection defaultColumnAxisProviderExistsInCollection'"
 *        annotation=
 *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot defaultRowAxisProviderExistsInCollection='rowAxisProviders->includes(defaultRowAxisProvider)' defaultColumnAxisProviderExistsInCollection='columnAxisProviders->includes(defaultColumnAxisProvider)'"
 * @generated
 */
public interface TableConfiguration extends TableNamedElement {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the table. This value is used to be able to open/close easily the table editor in Papyrus.
	 * Moreover it allows to distinghuish easily the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType <em>Type</em>}
	 * ' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The path of the icon to use for the table which references this TableConfiguration.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_IconPath()
	 * @model
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath
	 * <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Creation Tester</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value could be null. The tester is used to know if this tableConfiguration can be used
	 * to create a new table using as context the selected element.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Creation Tester</em>' containment reference.
	 * @see #setCreationTester(AbstractTableTester)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_CreationTester()
	 * @model containment="true"
	 * @generated
	 */
	AbstractTableTester getCreationTester();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester
	 * <em>Creation Tester</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Creation Tester</em>' containment reference.
	 * @see #getCreationTester()
	 * @generated
	 */
	void setCreationTester(AbstractTableTester value);

	/**
	 * Returns the value of the '<em><b>Cell Editor Declaration</b></em>' attribute.
	 * The default value is <code>"COLUMN"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. Indicates how the CellEditor must be declared.
	 * In the common table, we display features as columns and objects as line.
	 * In this case the cell editors are specific to features, so the cell editor must be declared on the columns.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Cell Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #setCellEditorDeclaration(CellEditorDeclaration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_CellEditorDeclaration()
	 * @model default="COLUMN" required="true"
	 * @generated
	 */
	CellEditorDeclaration getCellEditorDeclaration();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration
	 * <em>Cell Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Cell Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #getCellEditorDeclaration()
	 * @generated
	 */
	void setCellEditorDeclaration(CellEditorDeclaration value);

	/**
	 * Returns the value of the '<em><b>Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. Gives the initial row configuration of the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Row Header Axis Configuration</em>' containment reference.
	 * @see #setRowHeaderAxisConfiguration(TableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_RowHeaderAxisConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TableHeaderAxisConfiguration getRowHeaderAxisConfiguration();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration
	 * <em>Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Row Header Axis Configuration</em>' containment reference.
	 * @see #getRowHeaderAxisConfiguration()
	 * @generated
	 */
	void setRowHeaderAxisConfiguration(TableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. Gives the initial column configuration of the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Column Header Axis Configuration</em>' containment reference.
	 * @see #setColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_ColumnHeaderAxisConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TableHeaderAxisConfiguration getColumnHeaderAxisConfiguration();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration
	 * <em>Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Column Header Axis Configuration</em>' containment reference.
	 * @see #getColumnHeaderAxisConfiguration()
	 * @generated
	 */
	void setColumnHeaderAxisConfiguration(TableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Column Axis Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list can't be empty. Contains list of possible column AxisProvider for the table.
	 * <!-- end-model-doc -->
	 * 
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list can't be empty. Contains a list of possible row AxisProvider for the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Row Axis Providers</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_RowAxisProviders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getRowAxisProviders();

	/**
	 * Returns the value of the '<em><b>Default Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. References the Axis Provider to use by default for rows.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Default Row Axis Provider</em>' reference.
	 * @see #setDefaultRowAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_DefaultRowAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getDefaultRowAxisProvider();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider
	 * <em>Default Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Default Row Axis Provider</em>' reference.
	 * @see #getDefaultRowAxisProvider()
	 * @generated
	 */
	void setDefaultRowAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Default Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. References the Axis Provider to use by default for columns.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Default Column Axis Provider</em>' reference.
	 * @see #setDefaultColumnAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableConfiguration_DefaultColumnAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getDefaultColumnAxisProvider();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider
	 * <em>Default Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Default Column Axis Provider</em>' reference.
	 * @see #getDefaultColumnAxisProvider()
	 * @generated
	 */
	void setDefaultColumnAxisProvider(AbstractAxisProvider value);

} // TableConfiguration
