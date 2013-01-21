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
	 * The feature id for the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Java Vertical Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__JAVA_VERTICAL_CONTENT_PROVIDER_IDS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Java Horizontal Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__JAVA_HORIZONTAL_CONTENT_PROVIDER_IDS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Vertical Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Horizontal Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Table Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.LocalTableEditorConfigurationImpl <em>Local Table Editor Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.LocalTableEditorConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getLocalTableEditorConfiguration()
	 * @generated
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__EANNOTATIONS = TABLE_EDITOR_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID = TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE = TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE;

	/**
	 * The feature id for the '<em><b>Java Vertical Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__JAVA_VERTICAL_CONTENT_PROVIDER_IDS = TABLE_EDITOR_CONFIGURATION__JAVA_VERTICAL_CONTENT_PROVIDER_IDS;

	/**
	 * The feature id for the '<em><b>Java Horizontal Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__JAVA_HORIZONTAL_CONTENT_PROVIDER_IDS = TABLE_EDITOR_CONFIGURATION__JAVA_HORIZONTAL_CONTENT_PROVIDER_IDS;

	/**
	 * The feature id for the '<em><b>Default Vertical Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER = TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER;

	/**
	 * The feature id for the '<em><b>Default Horizontal Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER = TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER;

	/**
	 * The feature id for the '<em><b>Default Table Editor Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION = TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION__TYPE = TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Local Table Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT = TABLE_EDITOR_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION___GET_EANNOTATION__STRING = TABLE_EDITOR_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Local Table Editor Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_EDITOR_CONFIGURATION_OPERATION_COUNT = TABLE_EDITOR_CONFIGURATION_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementTypeId <em>Pasted Element Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Type Id</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementTypeId()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getTableEditorConfiguration_PastedElementTypeId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pasted Element Containment Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EReference getTableEditorConfiguration_PastedElementContainmentFeature();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaVerticalContentProviderIds <em>Java Vertical Content Provider Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Vertical Content Provider Ids</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaVerticalContentProviderIds()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getTableEditorConfiguration_JavaVerticalContentProviderIds();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaHorizontalContentProviderIds <em>Java Horizontal Content Provider Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Horizontal Content Provider Ids</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaHorizontalContentProviderIds()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getTableEditorConfiguration_JavaHorizontalContentProviderIds();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultVerticalContentProvider <em>Default Vertical Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Vertical Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultVerticalContentProvider()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EReference getTableEditorConfiguration_DefaultVerticalContentProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultHorizontalContentProvider <em>Default Horizontal Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Horizontal Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultHorizontalContentProvider()
	 * @see #getTableEditorConfiguration()
	 * @generated
	 */
	EReference getTableEditorConfiguration_DefaultHorizontalContentProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration <em>Local Table Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Table Editor Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration
	 * @generated
	 */
	EClass getLocalTableEditorConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration#getDefaultTableEditorConfiguration <em>Default Table Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Table Editor Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration#getDefaultTableEditorConfiguration()
	 * @see #getLocalTableEditorConfiguration()
	 * @generated
	 */
	EReference getLocalTableEditorConfiguration_DefaultTableEditorConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration#getType()
	 * @see #getLocalTableEditorConfiguration()
	 * @generated
	 */
	EAttribute getLocalTableEditorConfiguration_Type();

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
		 * The meta object literal for the '<em><b>Pasted Element Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_TYPE_ID = eINSTANCE.getTableEditorConfiguration_PastedElementTypeId();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Containment Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EDITOR_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE = eINSTANCE.getTableEditorConfiguration_PastedElementContainmentFeature();

		/**
		 * The meta object literal for the '<em><b>Java Vertical Content Provider Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_EDITOR_CONFIGURATION__JAVA_VERTICAL_CONTENT_PROVIDER_IDS = eINSTANCE.getTableEditorConfiguration_JavaVerticalContentProviderIds();

		/**
		 * The meta object literal for the '<em><b>Java Horizontal Content Provider Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_EDITOR_CONFIGURATION__JAVA_HORIZONTAL_CONTENT_PROVIDER_IDS = eINSTANCE.getTableEditorConfiguration_JavaHorizontalContentProviderIds();

		/**
		 * The meta object literal for the '<em><b>Default Vertical Content Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EDITOR_CONFIGURATION__DEFAULT_VERTICAL_CONTENT_PROVIDER = eINSTANCE.getTableEditorConfiguration_DefaultVerticalContentProvider();

		/**
		 * The meta object literal for the '<em><b>Default Horizontal Content Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EDITOR_CONFIGURATION__DEFAULT_HORIZONTAL_CONTENT_PROVIDER = eINSTANCE.getTableEditorConfiguration_DefaultHorizontalContentProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.LocalTableEditorConfigurationImpl <em>Local Table Editor Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.LocalTableEditorConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl#getLocalTableEditorConfiguration()
		 * @generated
		 */
		EClass LOCAL_TABLE_EDITOR_CONFIGURATION = eINSTANCE.getLocalTableEditorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Default Table Editor Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION = eINSTANCE.getLocalTableEditorConfiguration_DefaultTableEditorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_TABLE_EDITOR_CONFIGURATION__TYPE = eINSTANCE.getLocalTableEditorConfiguration_Type();

	}

} //NattableconfigurationPackage
