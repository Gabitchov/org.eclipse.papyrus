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

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * This object represents the table. It is used to save the interesting informations of the graphical table.
 * 
 * The currentAxisProviders can be : Master/Master, Master/Slave, Slave/Master and never Slave/Slave.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration <em>Table Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis <em>Invert Axis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getColumnAxisProvidersHistory <em>Column Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getRowAxisProvidersHistory <em>Row Axis Providers History</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration <em>Local Row Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration <em>Local Column Header Axis Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider <em>Current Row Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider <em>Current Column Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='currentRowAxisInHistory currentColumnAxisInHistory'"
 *        annotation=
 *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot currentRowAxisInHistory='rowAxisProvidersHistory->includes(currentRowAxisProvider)' currentColumnAxisInHistory='columnAxisProvidersHistory->includes(currentColumnAxisProvider)'"
 * @generated
 */
public interface Table extends TableNamedElement {

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The context is used for two things :
	 * <ul>
	 * <li>"virtual" parent to display the table in the Papyrus Model Explorer</li>
	 * <li>container of the objects created in the table</li>
	 * </ul>
	 * The context can't be null;
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Context()
	 * @model required="true"
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Owner()
	 * @model required="true"
	 * @generated
	 */
	EObject getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(EObject value);

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see #setPrototype(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Prototype()
	 * @model required="true"
	 * @generated
	 */
	EObject getPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getPrototype <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prototype</em>' reference.
	 * @see #getPrototype()
	 * @generated
	 */
	void setPrototype(EObject value);

	/**
	 * Returns the value of the '<em><b>Table Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference the configuration used by the table. This field can't be null.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Table Configuration</em>' reference.
	 * @see #setTableConfiguration(TableConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_TableConfiguration()
	 * @model required="true"
	 * @generated
	 */
	TableConfiguration getTableConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration <em>Table Configuration</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Table Configuration</em>' reference.
	 * @see #getTableConfiguration()
	 * @generated
	 */
	void setTableConfiguration(TableConfiguration value);

	/**
	 * Returns the value of the '<em><b>Invert Axis</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, the axis will be inverted on the screen. When the user inverts the axis,
	 * only this boolean is changed. We must not invert the currentRowAxis and the currentColumnAxis neither the histories or the AxisConfiguration
	 * <!-- end-model-doc -->
	 * 
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
	 * 
	 * @param value
	 *        the new value of the '<em>Invert Axis</em>' attribute.
	 * @see #isInvertAxis()
	 * @generated
	 */
	void setInvertAxis(boolean value);

	/**
	 * Returns the value of the '<em><b>Column Axis Providers History</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list contains all the columns configurations already used by the user and saved in this list by him.
	 * <!-- end-model-doc -->
	 * 
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list contains all the rowsconfigurations already used by the user and saved in this list by him.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Row Axis Providers History</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_RowAxisProvidersHistory()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractAxisProvider> getRowAxisProvidersHistory();

	/**
	 * Returns the value of the '<em><b>Local Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field contains the row headerAxisConfiguration. It could be null.
	 * In this case we use the row TableHeaderAxisConfiguration stored in the TableConfiguration of this table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Local Row Header Axis Configuration</em>' containment reference.
	 * @see #setLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_LocalRowHeaderAxisConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	LocalTableHeaderAxisConfiguration getLocalRowHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration
	 * <em>Local Row Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Local Row Header Axis Configuration</em>' containment reference.
	 * @see #getLocalRowHeaderAxisConfiguration()
	 * @generated
	 */
	void setLocalRowHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Local Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field contains the columnheaderAxisConfiguration. It could be null.
	 * In this case we use the column TableHeaderAxisConfiguration stored in the TableConfiguration of this table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Local Column Header Axis Configuration</em>' containment reference.
	 * @see #setLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_LocalColumnHeaderAxisConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	LocalTableHeaderAxisConfiguration getLocalColumnHeaderAxisConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration
	 * <em>Local Column Header Axis Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Local Column Header Axis Configuration</em>' containment reference.
	 * @see #getLocalColumnHeaderAxisConfiguration()
	 * @generated
	 */
	void setLocalColumnHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration value);

	/**
	 * Returns the value of the '<em><b>Current Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the current row AxisProvider used in the table.
	 * The value must be owned by rowAxisProviderHistory
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Current Row Axis Provider</em>' reference.
	 * @see #setCurrentRowAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_CurrentRowAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getCurrentRowAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider
	 * <em>Current Row Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Current Row Axis Provider</em>' reference.
	 * @see #getCurrentRowAxisProvider()
	 * @generated
	 */
	void setCurrentRowAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Current Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the current column AxisProvider used in the table.
	 * The value must be owned by column AxisProviderHistory
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Current Column Axis Provider</em>' reference.
	 * @see #setCurrentColumnAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_CurrentColumnAxisProvider()
	 * @model required="true"
	 * @generated
	 */
	AbstractAxisProvider getCurrentColumnAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider
	 * <em>Current Column Axis Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Current Column Axis Provider</em>' reference.
	 * @see #getCurrentColumnAxisProvider()
	 * @generated
	 */
	void setCurrentColumnAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cells of the table. They are used when the value to display can't be deduced of
	 * the intersection of the row and the column.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Cells</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getTable_Cells()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cell> getCells();

} // Table
