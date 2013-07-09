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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface NattablePackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattable"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattable"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablePackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__EANNOTATIONS = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__DESCRIPTION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CONTEXT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TABLE_CONFIGURATION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invert Axis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__INVERT_AXIS = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Column Axis Providers History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMN_AXIS_PROVIDERS_HISTORY = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Row Axis Providers History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW_AXIS_PROVIDERS_HISTORY = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Local Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Local Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Current Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CURRENT_ROW_AXIS_PROVIDER = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Current Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CURRENT_COLUMN_AXIS_PROVIDER = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CELLS = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_EANNOTATION__STRING = NattableconfigurationPackage.TABLE_NAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell <em>ICell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getICell()
	 * @generated
	 */
	int ICELL = 1;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICELL__PROBLEMS = 0;

	/**
	 * The number of structural features of the '<em>ICell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICELL_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Row Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICELL___GET_ROW_ELEMENT = 0;

	/**
	 * The operation id for the '<em>Get Column Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICELL___GET_COLUMN_ELEMENT = 1;

	/**
	 * The number of operations of the '<em>ICell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICELL_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Problem <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Problem
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__EANNOTATIONS = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DESCRIPTION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__NAME = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM___GET_EANNOTATION__STRING = NattableconfigurationPackage.TABLE_NAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_OPERATION_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl <em>Paste Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getPasteProblem()
	 * @generated
	 */
	int PASTE_PROBLEM = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM__EANNOTATIONS = PROBLEM__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM__DESCRIPTION = PROBLEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM__NAME = PROBLEM__NAME;

	/**
	 * The feature id for the '<em><b>Pasted Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM__PASTED_TEXT = PROBLEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unresolved Text</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM__UNRESOLVED_TEXT = PROBLEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Paste Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM_FEATURE_COUNT = PROBLEM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM___GET_EANNOTATION__STRING = PROBLEM___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Paste Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_PROBLEM_OPERATION_COUNT = PROBLEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl <em>EObject Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getEObjectCell()
	 * @generated
	 */
	int EOBJECT_CELL = 4;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL__PROBLEMS = ICELL__PROBLEMS;

	/**
	 * The feature id for the '<em><b>Row Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL__ROW_ELEMENT = ICELL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL__COLUMN_ELEMENT = ICELL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EObject Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL_FEATURE_COUNT = ICELL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Row Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL___GET_ROW_ELEMENT = ICELL___GET_ROW_ELEMENT;

	/**
	 * The operation id for the '<em>Get Column Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL___GET_COLUMN_ELEMENT = ICELL___GET_COLUMN_ELEMENT;

	/**
	 * The number of operations of the '<em>EObject Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_CELL_OPERATION_COUNT = ICELL_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration <em>Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getTableConfiguration()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_TableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis <em>Invert Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invert Axis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#isInvertAxis()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_InvertAxis();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getColumnAxisProvidersHistory <em>Column Axis Providers History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Column Axis Providers History</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getColumnAxisProvidersHistory()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_ColumnAxisProvidersHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getRowAxisProvidersHistory <em>Row Axis Providers History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row Axis Providers History</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getRowAxisProvidersHistory()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_RowAxisProvidersHistory();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration <em>Local Row Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Row Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalRowHeaderAxisConfiguration()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_LocalRowHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration <em>Local Column Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Column Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getLocalColumnHeaderAxisConfiguration()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_LocalColumnHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider <em>Current Row Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Row Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentRowAxisProvider()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_CurrentRowAxisProvider();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider <em>Current Column Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Column Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCurrentColumnAxisProvider()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_CurrentColumnAxisProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cells</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getCells()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Cells();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell <em>ICell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICell</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell
	 * @generated
	 */
	EClass getICell();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Problems</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getProblems()
	 * @see #getICell()
	 * @generated
	 */
	EReference getICell_Problems();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getRowElement() <em>Get Row Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Row Element</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getRowElement()
	 * @generated
	 */
	EOperation getICell__GetRowElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getColumnElement() <em>Get Column Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Column Element</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell#getColumnElement()
	 * @generated
	 */
	EOperation getICell__GetColumnElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem <em>Paste Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paste Problem</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem
	 * @generated
	 */
	EClass getPasteProblem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getPastedText <em>Pasted Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Text</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getPastedText()
	 * @see #getPasteProblem()
	 * @generated
	 */
	EAttribute getPasteProblem_PastedText();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getUnresolvedText <em>Unresolved Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unresolved Text</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getUnresolvedText()
	 * @see #getPasteProblem()
	 * @generated
	 */
	EAttribute getPasteProblem_UnresolvedText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell <em>EObject Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Cell</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell
	 * @generated
	 */
	EClass getEObjectCell();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getRowElement <em>Row Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Row Element</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getRowElement()
	 * @see #getEObjectCell()
	 * @generated
	 */
	EReference getEObjectCell_RowElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getColumnElement <em>Column Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column Element</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getColumnElement()
	 * @see #getEObjectCell()
	 * @generated
	 */
	EReference getEObjectCell_ColumnElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableFactory getNattableFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CONTEXT = eINSTANCE.getTable_Context();

		/**
		 * The meta object literal for the '<em><b>Table Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TABLE_CONFIGURATION = eINSTANCE.getTable_TableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Invert Axis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__INVERT_AXIS = eINSTANCE.getTable_InvertAxis();

		/**
		 * The meta object literal for the '<em><b>Column Axis Providers History</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMN_AXIS_PROVIDERS_HISTORY = eINSTANCE.getTable_ColumnAxisProvidersHistory();

		/**
		 * The meta object literal for the '<em><b>Row Axis Providers History</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROW_AXIS_PROVIDERS_HISTORY = eINSTANCE.getTable_RowAxisProvidersHistory();

		/**
		 * The meta object literal for the '<em><b>Local Row Header Axis Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__LOCAL_ROW_HEADER_AXIS_CONFIGURATION = eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Local Column Header Axis Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION = eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Current Row Axis Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CURRENT_ROW_AXIS_PROVIDER = eINSTANCE.getTable_CurrentRowAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Current Column Axis Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CURRENT_COLUMN_AXIS_PROVIDER = eINSTANCE.getTable_CurrentColumnAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CELLS = eINSTANCE.getTable_Cells();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.ICell <em>ICell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.ICell
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getICell()
		 * @generated
		 */
		EClass ICELL = eINSTANCE.getICell();

		/**
		 * The meta object literal for the '<em><b>Problems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ICELL__PROBLEMS = eINSTANCE.getICell_Problems();

		/**
		 * The meta object literal for the '<em><b>Get Row Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ICELL___GET_ROW_ELEMENT = eINSTANCE.getICell__GetRowElement();

		/**
		 * The meta object literal for the '<em><b>Get Column Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ICELL___GET_COLUMN_ELEMENT = eINSTANCE.getICell__GetColumnElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Problem <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Problem
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl <em>Paste Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getPasteProblem()
		 * @generated
		 */
		EClass PASTE_PROBLEM = eINSTANCE.getPasteProblem();

		/**
		 * The meta object literal for the '<em><b>Pasted Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASTE_PROBLEM__PASTED_TEXT = eINSTANCE.getPasteProblem_PastedText();

		/**
		 * The meta object literal for the '<em><b>Unresolved Text</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASTE_PROBLEM__UNRESOLVED_TEXT = eINSTANCE.getPasteProblem_UnresolvedText();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl <em>EObject Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectCellImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getEObjectCell()
		 * @generated
		 */
		EClass EOBJECT_CELL = eINSTANCE.getEObjectCell();

		/**
		 * The meta object literal for the '<em><b>Row Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_CELL__ROW_ELEMENT = eINSTANCE.getEObjectCell_RowElement();

		/**
		 * The meta object literal for the '<em><b>Column Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_CELL__COLUMN_ELEMENT = eINSTANCE.getEObjectCell_ColumnElement();

	}

} //NattablePackage
