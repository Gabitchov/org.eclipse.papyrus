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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface NattableconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattableconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/nattableconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattableconfiguration"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattableconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl <em>Table Editor Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableEditorConfiguration()
	 * @generated
	 */
	int TABLE_EDITOR_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Vertical Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Horizontal Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editor Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Table Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration <em>Cell Editor Declaration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getCellEditorDeclaration()
	 * @generated
	 */
	int CELL_EDITOR_DECLARATION = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration <em>Table Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Editor Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration
	 * @generated
	 */
	EClass getTableEditorConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getVerticalAxisProvider <em>Vertical Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertical Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getVerticalAxisProvider()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EReference getTableEditorConfiguration_VerticalAxisProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Horizontal Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getHorizontalAxisProvider()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EReference getTableEditorConfiguration_HorizontalAxisProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getEditorDeclaration <em>Editor Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editor Declaration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getEditorDeclaration()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getTableEditorConfiguration_EditorDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getType()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getTableEditorConfiguration_Type();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration <em>Cell Editor Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cell Editor Declaration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @generated
	 */
	EEnum getCellEditorDeclaration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableconfigurationFactory getNattableconfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl <em>Table Editor Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableEditorConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableEditorConfiguration()
		 * @generated
		 */
		EClass TABLE_EDITOR_CONFIGURATION = eINSTANCE.getTableEditorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Vertical Axis Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EDITOR_CONFIGURATION__VERTICAL_AXIS_PROVIDER = eINSTANCE.getTableEditorConfiguration_VerticalAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Horizontal Axis Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EDITOR_CONFIGURATION__HORIZONTAL_AXIS_PROVIDER = eINSTANCE.getTableEditorConfiguration_HorizontalAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Editor Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_EDITOR_CONFIGURATION__EDITOR_DECLARATION = eINSTANCE.getTableEditorConfiguration_EditorDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_EDITOR_CONFIGURATION__TYPE = eINSTANCE.getTableEditorConfiguration_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration <em>Cell Editor Declaration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getCellEditorDeclaration()
		 * @generated
		 */
		EEnum CELL_EDITOR_DECLARATION = eINSTANCE.getCellEditorDeclaration();

	}

} //NattableconfigurationPackage
