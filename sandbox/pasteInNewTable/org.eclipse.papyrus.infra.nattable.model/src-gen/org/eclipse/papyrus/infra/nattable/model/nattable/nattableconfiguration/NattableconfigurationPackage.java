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
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl <em>Table Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableNamedElement()
	 * @generated
	 */
	int TABLE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT__DESCRIPTION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Table Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_NAMED_ELEMENT_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl <em>Table Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableConfiguration()
	 * @generated
	 */
	int TABLE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__EANNOTATIONS = TABLE_NAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__DESCRIPTION = TABLE_NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__NAME = TABLE_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__TYPE = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__ICON_PATH = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Creation Tester</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__CREATION_TESTER = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cell Editor Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Row Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Column Header Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Column Axis Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Row Axis Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default Row Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Default Column Axis Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Table Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION_FEATURE_COUNT = TABLE_NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION___GET_EANNOTATION__STRING = TABLE_NAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CONFIGURATION_OPERATION_COUNT = TABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration <em>Cell Editor Declaration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getCellEditorDeclaration()
	 * @generated
	 */
	int CELL_EDITOR_DECLARATION = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement <em>Table Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Named Element</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement
	 * @generated
	 */
	EClass getTableNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement#getDescription()
	 * @see #getTableNamedElement()
	 * @generated
	 */
	EAttribute getTableNamedElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement#getName()
	 * @see #getTableNamedElement()
	 * @generated
	 */
	EAttribute getTableNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration <em>Table Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration
	 * @generated
	 */
	EClass getTableConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getType()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EAttribute getTableConfiguration_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getIconPath()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EAttribute getTableConfiguration_IconPath();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester <em>Creation Tester</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Creation Tester</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCreationTester()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_CreationTester();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration <em>Cell Editor Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cell Editor Declaration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getCellEditorDeclaration()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EAttribute getTableConfiguration_CellEditorDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration <em>Row Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Row Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowHeaderAxisConfiguration()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_RowHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration <em>Column Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Column Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnHeaderAxisConfiguration()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_ColumnHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnAxisProviders <em>Column Axis Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Column Axis Providers</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getColumnAxisProviders()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_ColumnAxisProviders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowAxisProviders <em>Row Axis Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row Axis Providers</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getRowAxisProviders()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_RowAxisProviders();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider <em>Default Row Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Row Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultRowAxisProvider()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_DefaultRowAxisProvider();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider <em>Default Column Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Column Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration#getDefaultColumnAxisProvider()
	 * @see #getTableConfiguration()
	 * @generated
	 */
	EReference getTableConfiguration_DefaultColumnAxisProvider();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl <em>Table Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableNamedElement()
		 * @generated
		 */
		EClass TABLE_NAMED_ELEMENT = eINSTANCE.getTableNamedElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getTableNamedElement_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_NAMED_ELEMENT__NAME = eINSTANCE.getTableNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl <em>Table Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getTableConfiguration()
		 * @generated
		 */
		EClass TABLE_CONFIGURATION = eINSTANCE.getTableConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_CONFIGURATION__TYPE = eINSTANCE.getTableConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_CONFIGURATION__ICON_PATH = eINSTANCE.getTableConfiguration_IconPath();

		/**
		 * The meta object literal for the '<em><b>Creation Tester</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__CREATION_TESTER = eINSTANCE.getTableConfiguration_CreationTester();

		/**
		 * The meta object literal for the '<em><b>Cell Editor Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION = eINSTANCE.getTableConfiguration_CellEditorDeclaration();

		/**
		 * The meta object literal for the '<em><b>Row Header Axis Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION = eINSTANCE.getTableConfiguration_RowHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Column Header Axis Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION = eINSTANCE.getTableConfiguration_ColumnHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Column Axis Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS = eINSTANCE.getTableConfiguration_ColumnAxisProviders();

		/**
		 * The meta object literal for the '<em><b>Row Axis Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS = eINSTANCE.getTableConfiguration_RowAxisProviders();

		/**
		 * The meta object literal for the '<em><b>Default Row Axis Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER = eINSTANCE.getTableConfiguration_DefaultRowAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Default Column Axis Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER = eINSTANCE.getTableConfiguration_DefaultColumnAxisProvider();

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
