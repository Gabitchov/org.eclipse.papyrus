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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellFactory
 * @model kind="package"
 * @generated
 */
public interface NattablecellPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "nattablecell"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattablecell"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "nattablecell"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	NattablecellPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Column Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL__COLUMN_WRAPPER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Row Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL__ROW_WRAPPER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL__PROBLEMS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper <em>ICell Axis Wrapper</em>}
	 * ' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getICellAxisWrapper()
	 * @generated
	 */
	int ICELL_AXIS_WRAPPER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICELL_AXIS_WRAPPER__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The number of structural features of the '<em>ICell Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICELL_AXIS_WRAPPER_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICELL_AXIS_WRAPPER___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICELL_AXIS_WRAPPER___GET_ELEMENT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>ICell Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICELL_AXIS_WRAPPER_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.EObjectAxisWrapperImpl
	 * <em>EObject Axis Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.EObjectAxisWrapperImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getEObjectAxisWrapper()
	 * @generated
	 */
	int EOBJECT_AXIS_WRAPPER = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER__EANNOTATIONS = ICELL_AXIS_WRAPPER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER__ELEMENT = ICELL_AXIS_WRAPPER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER_FEATURE_COUNT = ICELL_AXIS_WRAPPER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER___GET_EANNOTATION__STRING = ICELL_AXIS_WRAPPER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER___GET_ELEMENT = ICELL_AXIS_WRAPPER___GET_ELEMENT;

	/**
	 * The number of operations of the '<em>EObject Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_WRAPPER_OPERATION_COUNT = ICELL_AXIS_WRAPPER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.IdAxisWrapperImpl
	 * <em>Id Axis Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.IdAxisWrapperImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getIdAxisWrapper()
	 * @generated
	 */
	int ID_AXIS_WRAPPER = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER__EANNOTATIONS = ICELL_AXIS_WRAPPER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER__ELEMENT = ICELL_AXIS_WRAPPER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Id Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER_FEATURE_COUNT = ICELL_AXIS_WRAPPER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER___GET_EANNOTATION__STRING = ICELL_AXIS_WRAPPER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER___GET_ELEMENT = ICELL_AXIS_WRAPPER___GET_ELEMENT;

	/**
	 * The number of operations of the '<em>Id Axis Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ID_AXIS_WRAPPER_OPERATION_COUNT = ICELL_AXIS_WRAPPER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getColumnWrapper <em>Column Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Column Wrapper</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getColumnWrapper()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_ColumnWrapper();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getRowWrapper <em>Row Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Row Wrapper</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getRowWrapper()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_RowWrapper();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Problems</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getProblems()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Problems();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper
	 * <em>ICell Axis Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ICell Axis Wrapper</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper
	 * @generated
	 */
	EClass getICellAxisWrapper();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper#getElement()
	 * <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Element</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper#getElement()
	 * @generated
	 */
	EOperation getICellAxisWrapper__GetElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.EObjectAxisWrapper
	 * <em>EObject Axis Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EObject Axis Wrapper</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.EObjectAxisWrapper
	 * @generated
	 */
	EClass getEObjectAxisWrapper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.EObjectAxisWrapper#getElement
	 * <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.EObjectAxisWrapper#getElement()
	 * @see #getEObjectAxisWrapper()
	 * @generated
	 */
	EReference getEObjectAxisWrapper_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper
	 * <em>Id Axis Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Id Axis Wrapper</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper
	 * @generated
	 */
	EClass getIdAxisWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper#getElement
	 * <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper#getElement()
	 * @see #getIdAxisWrapper()
	 * @generated
	 */
	EAttribute getIdAxisWrapper_Element();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattablecellFactory getNattablecellFactory();

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
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.CellImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Column Wrapper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CELL__COLUMN_WRAPPER = eINSTANCE.getCell_ColumnWrapper();

		/**
		 * The meta object literal for the '<em><b>Row Wrapper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CELL__ROW_WRAPPER = eINSTANCE.getCell_RowWrapper();

		/**
		 * The meta object literal for the '<em><b>Problems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CELL__PROBLEMS = eINSTANCE.getCell_Problems();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper
		 * <em>ICell Axis Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getICellAxisWrapper()
		 * @generated
		 */
		EClass ICELL_AXIS_WRAPPER = eINSTANCE.getICellAxisWrapper();

		/**
		 * The meta object literal for the '<em><b>Get Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation ICELL_AXIS_WRAPPER___GET_ELEMENT = eINSTANCE.getICellAxisWrapper__GetElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.EObjectAxisWrapperImpl
		 * <em>EObject Axis Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.EObjectAxisWrapperImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getEObjectAxisWrapper()
		 * @generated
		 */
		EClass EOBJECT_AXIS_WRAPPER = eINSTANCE.getEObjectAxisWrapper();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_AXIS_WRAPPER__ELEMENT = eINSTANCE.getEObjectAxisWrapper_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.IdAxisWrapperImpl
		 * <em>Id Axis Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.IdAxisWrapperImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl#getIdAxisWrapper()
		 * @generated
		 */
		EClass ID_AXIS_WRAPPER = eINSTANCE.getIdAxisWrapper();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ID_AXIS_WRAPPER__ELEMENT = eINSTANCE.getIdAxisWrapper_Element();

	}

} //NattablecellPackage
