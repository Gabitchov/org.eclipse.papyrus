/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element represents the tables used in Papyrus.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getFillingMode <em>Filling Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getContextFeature <em>Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingUser <em>Using User</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingContextFeature <em>Using Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#isUsingQueries <em>Using Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable()
 * @model
 * @generated
 */
public interface PapyrusTable extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field allows to store a name for the Papyrus Table.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field allows to store the type of the Papyrus Table. It is used to know how 
	 * to open it in the papyrus sasheditor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field reference the EMF-Facet table that we use for the papyrus Table.
	 * We choose to reference it (and not to do an inheritance) in order to be sure
	 * to respect their API.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Table</em>' containment reference.
	 * @see #setTable(Table)
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_Table()
	 * @model containment="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getTable <em>Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' containment reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Filling Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute allows to store how the table should be filled.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filling Mode</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @see #setFillingMode(FillingMode)
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_FillingMode()
	 * @model
	 * @generated
	 */
	FillingMode getFillingMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getFillingMode <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filling Mode</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @see #getFillingMode()
	 * @generated
	 */
	void setFillingMode(FillingMode value);

	/**
	 * Returns the value of the '<em><b>Context Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references the EStructuralFeature to listen when the table is in Feature Mode.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context Feature</em>' reference.
	 * @see #setContextFeature(EReference)
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_ContextFeature()
	 * @model
	 * @generated
	 */
	EReference getContextFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable#getContextFeature <em>Context Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Feature</em>' reference.
	 * @see #getContextFeature()
	 * @generated
	 */
	void setContextFeature(EReference value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references the queries used to fill table when the table is in queries mode.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Queries</em>' reference list.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_Queries()
	 * @model
	 * @generated
	 */
	EList<Query> getQueries();

	/**
	 * Returns the value of the '<em><b>Using User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute is true when fillingMode==User.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Using User</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_UsingUser()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isUsingUser();

	/**
	 * Returns the value of the '<em><b>Using Context Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute is true when fillingMode==Feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Using Context Feature</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_UsingContextFeature()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isUsingContextFeature();

	/**
	 * Returns the value of the '<em><b>Using Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute is true when fillingMode==Queries.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Using Queries</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#getPapyrusTable_UsingQueries()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isUsingQueries();

} // PapyrusTable
