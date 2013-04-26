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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface NattableaxisconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattableaxisconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl <em>Abstract Header Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Index Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Display Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Label Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Axis Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Abstract Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_HEADER_AXIS_CONFIGURATION_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl <em>Axis Manager Representation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisManagerRepresentation()
	 * @generated
	 */
	int AXIS_MANAGER_REPRESENTATION = 1;

	/**
	 * The feature id for the '<em><b>Axis Manager Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID = 0;

	/**
	 * The feature id for the '<em><b>Label Provider Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Header Label Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Specific Axis Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATIONS = 3;

	/**
	 * The number of structural features of the '<em>Axis Manager Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Axis Manager Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_REPRESENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl <em>Axis Manager Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisManagerConfiguration()
	 * @generated
	 */
	int AXIS_MANAGER_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Local Header Label Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Axis Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Local Specific Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS = 2;

	/**
	 * The number of structural features of the '<em>Axis Manager Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Axis Manager Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_MANAGER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.TableHeaderAxisConfigurationImpl <em>Table Header Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.TableHeaderAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getTableHeaderAxisConfiguration()
	 * @generated
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__EANNOTATIONS = ABSTRACT_HEADER_AXIS_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Index Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__INDEX_STYLE = ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL;

	/**
	 * The feature id for the '<em><b>Display Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER;

	/**
	 * The feature id for the '<em><b>Display Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX;

	/**
	 * The feature id for the '<em><b>Owned Label Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION = ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Owned Axis Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION = ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Axis Managers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS = ABSTRACT_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT = ABSTRACT_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION___GET_EANNOTATION__STRING = ABSTRACT_HEADER_AXIS_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_HEADER_AXIS_CONFIGURATION_OPERATION_COUNT = ABSTRACT_HEADER_AXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.LocalTableHeaderAxisConfigurationImpl <em>Local Table Header Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.LocalTableHeaderAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getLocalTableHeaderAxisConfiguration()
	 * @generated
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__EANNOTATIONS = ABSTRACT_HEADER_AXIS_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Index Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__INDEX_STYLE = ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL;

	/**
	 * The feature id for the '<em><b>Display Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER;

	/**
	 * The feature id for the '<em><b>Display Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX = ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX;

	/**
	 * The feature id for the '<em><b>Owned Label Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION = ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Owned Axis Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION = ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Axis Manager Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS = ABSTRACT_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Table Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT = ABSTRACT_HEADER_AXIS_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION___GET_EANNOTATION__STRING = ABSTRACT_HEADER_AXIS_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Local Table Header Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TABLE_HEADER_AXIS_CONFIGURATION_OPERATION_COUNT = ABSTRACT_HEADER_AXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration <em>IAxis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIAxisConfiguration()
	 * @generated
	 */
	int IAXIS_CONFIGURATION = 5;

	/**
	 * The number of structural features of the '<em>IAxis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IAxis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.FeatureAxisConfigurationImpl <em>Feature Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.FeatureAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getFeatureAxisConfiguration()
	 * @generated
	 */
	int FEATURE_AXIS_CONFIGURATION = 6;

	/**
	 * The feature id for the '<em><b>Show Only Common Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE = IAXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_AXIS_CONFIGURATION_FEATURE_COUNT = IAXIS_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_AXIS_CONFIGURATION_OPERATION_COUNT = IAXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration <em>IFilling Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIFillingConfiguration()
	 * @generated
	 */
	int IFILLING_CONFIGURATION = 7;

	/**
	 * The number of structural features of the '<em>IFilling Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILLING_CONFIGURATION_FEATURE_COUNT = IAXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IFilling Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILLING_CONFIGURATION_OPERATION_COUNT = IAXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.EStructuralFeatureValueFillingConfigurationImpl <em>EStructural Feature Value Filling Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.EStructuralFeatureValueFillingConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getEStructuralFeatureValueFillingConfiguration()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Listen Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE = IFILLING_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EStructural Feature Value Filling Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION_FEATURE_COUNT = IFILLING_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EStructural Feature Value Filling Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION_OPERATION_COUNT = IFILLING_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl <em>IPaste Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIPasteConfiguration()
	 * @generated
	 */
	int IPASTE_CONFIGURATION = 9;

	/**
	 * The number of structural features of the '<em>IPaste Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPASTE_CONFIGURATION_FEATURE_COUNT = IAXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IPaste Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPASTE_CONFIGURATION_OPERATION_COUNT = IAXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.PasteEObjectConfigurationImpl <em>Paste EObject Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.PasteEObjectConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getPasteEObjectConfiguration()
	 * @generated
	 */
	int PASTE_EOBJECT_CONFIGURATION = 10;

	/**
	 * The feature id for the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_EOBJECT_CONFIGURATION__PASTED_ELEMENT_ID = IPASTE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Paste Element Containement Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_EOBJECT_CONFIGURATION__PASTE_ELEMENT_CONTAINEMENT_FEATURE = IPASTE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Paste EObject Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_EOBJECT_CONFIGURATION_FEATURE_COUNT = IPASTE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Paste EObject Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_EOBJECT_CONFIGURATION_OPERATION_COUNT = IPASTE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisIndexStyle()
	 * @generated
	 */
	int AXIS_INDEX_STYLE = 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration <em>Abstract Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration
	 * @generated
	 */
	EClass getAbstractHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getIndexStyle <em>Index Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Style</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getIndexStyle()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EAttribute getAbstractHeaderAxisConfiguration_IndexStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayLabel <em>Display Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Label</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayLabel()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EAttribute getAbstractHeaderAxisConfiguration_DisplayLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayFilter <em>Display Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Filter</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayFilter()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EAttribute getAbstractHeaderAxisConfiguration_DisplayFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayIndex <em>Display Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Index</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayIndex()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EAttribute getAbstractHeaderAxisConfiguration_DisplayIndex();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedLabelConfiguration <em>Owned Label Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Label Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedLabelConfiguration()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EReference getAbstractHeaderAxisConfiguration_OwnedLabelConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedAxisConfiguration <em>Owned Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedAxisConfiguration()
	 * @see #getAbstractHeaderAxisConfiguration()
	 * @generated
	 */
	EReference getAbstractHeaderAxisConfiguration_OwnedAxisConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation <em>Axis Manager Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axis Manager Representation</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation
	 * @generated
	 */
	EClass getAxisManagerRepresentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getAxisManagerId <em>Axis Manager Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Axis Manager Id</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getAxisManagerId()
	 * @see #getAxisManagerRepresentation()
	 * @generated
	 */
	EAttribute getAxisManagerRepresentation_AxisManagerId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getLabelProviderContext <em>Label Provider Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Provider Context</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getLabelProviderContext()
	 * @see #getAxisManagerRepresentation()
	 * @generated
	 */
	EAttribute getAxisManagerRepresentation_LabelProviderContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getHeaderLabelConfiguration <em>Header Label Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Header Label Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getHeaderLabelConfiguration()
	 * @see #getAxisManagerRepresentation()
	 * @generated
	 */
	EReference getAxisManagerRepresentation_HeaderLabelConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getSpecificAxisConfigurations <em>Specific Axis Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specific Axis Configurations</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getSpecificAxisConfigurations()
	 * @see #getAxisManagerRepresentation()
	 * @generated
	 */
	EReference getAxisManagerRepresentation_SpecificAxisConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration <em>Axis Manager Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axis Manager Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration
	 * @generated
	 */
	EClass getAxisManagerConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalHeaderLabelConfiguration <em>Local Header Label Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Header Label Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalHeaderLabelConfiguration()
	 * @see #getAxisManagerConfiguration()
	 * @generated
	 */
	EReference getAxisManagerConfiguration_LocalHeaderLabelConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getAxisManager <em>Axis Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Axis Manager</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getAxisManager()
	 * @see #getAxisManagerConfiguration()
	 * @generated
	 */
	EReference getAxisManagerConfiguration_AxisManager();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalSpecificConfigurations <em>Local Specific Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Specific Configurations</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalSpecificConfigurations()
	 * @see #getAxisManagerConfiguration()
	 * @generated
	 */
	EReference getAxisManagerConfiguration_LocalSpecificConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration <em>Table Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration
	 * @generated
	 */
	EClass getTableHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration#getAxisManagers <em>Axis Managers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axis Managers</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration#getAxisManagers()
	 * @see #getTableHeaderAxisConfiguration()
	 * @generated
	 */
	EReference getTableHeaderAxisConfiguration_AxisManagers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration <em>Local Table Header Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Table Header Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration
	 * @generated
	 */
	EClass getLocalTableHeaderAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration#getAxisManagerConfigurations <em>Axis Manager Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axis Manager Configurations</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration#getAxisManagerConfigurations()
	 * @see #getLocalTableHeaderAxisConfiguration()
	 * @generated
	 */
	EReference getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration <em>IAxis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAxis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration
	 * @generated
	 */
	EClass getIAxisConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration <em>Feature Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration
	 * @generated
	 */
	EClass getFeatureAxisConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration#isShowOnlyCommonFeature <em>Show Only Common Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Only Common Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration#isShowOnlyCommonFeature()
	 * @see #getFeatureAxisConfiguration()
	 * @generated
	 */
	EAttribute getFeatureAxisConfiguration_ShowOnlyCommonFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration <em>IFilling Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFilling Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration
	 * @generated
	 */
	EClass getIFillingConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration <em>EStructural Feature Value Filling Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EStructural Feature Value Filling Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration
	 * @generated
	 */
	EClass getEStructuralFeatureValueFillingConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration#getListenFeature <em>Listen Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listen Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration#getListenFeature()
	 * @see #getEStructuralFeatureValueFillingConfiguration()
	 * @generated
	 */
	EReference getEStructuralFeatureValueFillingConfiguration_ListenFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration <em>IPaste Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPaste Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration
	 * @generated
	 */
	EClass getIPasteConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration <em>Paste EObject Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paste EObject Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration
	 * @generated
	 */
	EClass getPasteEObjectConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPastedElementId <em>Pasted Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Id</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPastedElementId()
	 * @see #getPasteEObjectConfiguration()
	 * @generated
	 */
	EAttribute getPasteEObjectConfiguration_PastedElementId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPasteElementContainementFeature <em>Paste Element Containement Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Paste Element Containement Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPasteElementContainementFeature()
	 * @see #getPasteEObjectConfiguration()
	 * @generated
	 */
	EReference getPasteEObjectConfiguration_PasteElementContainementFeature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Axis Index Style</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @generated
	 */
	EEnum getAxisIndexStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableaxisconfigurationFactory getNattableaxisconfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl <em>Abstract Header Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAbstractHeaderAxisConfiguration()
		 * @generated
		 */
		EClass ABSTRACT_HEADER_AXIS_CONFIGURATION = eINSTANCE.getAbstractHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Index Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE = eINSTANCE.getAbstractHeaderAxisConfiguration_IndexStyle();

		/**
		 * The meta object literal for the '<em><b>Display Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL = eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayLabel();

		/**
		 * The meta object literal for the '<em><b>Display Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER = eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayFilter();

		/**
		 * The meta object literal for the '<em><b>Display Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX = eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayIndex();

		/**
		 * The meta object literal for the '<em><b>Owned Label Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATION = eINSTANCE.getAbstractHeaderAxisConfiguration_OwnedLabelConfiguration();

		/**
		 * The meta object literal for the '<em><b>Owned Axis Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATION = eINSTANCE.getAbstractHeaderAxisConfiguration_OwnedAxisConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl <em>Axis Manager Representation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisManagerRepresentation()
		 * @generated
		 */
		EClass AXIS_MANAGER_REPRESENTATION = eINSTANCE.getAxisManagerRepresentation();

		/**
		 * The meta object literal for the '<em><b>Axis Manager Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID = eINSTANCE.getAxisManagerRepresentation_AxisManagerId();

		/**
		 * The meta object literal for the '<em><b>Label Provider Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT = eINSTANCE.getAxisManagerRepresentation_LabelProviderContext();

		/**
		 * The meta object literal for the '<em><b>Header Label Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION = eINSTANCE.getAxisManagerRepresentation_HeaderLabelConfiguration();

		/**
		 * The meta object literal for the '<em><b>Specific Axis Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATIONS = eINSTANCE.getAxisManagerRepresentation_SpecificAxisConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl <em>Axis Manager Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisManagerConfiguration()
		 * @generated
		 */
		EClass AXIS_MANAGER_CONFIGURATION = eINSTANCE.getAxisManagerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Local Header Label Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION = eINSTANCE.getAxisManagerConfiguration_LocalHeaderLabelConfiguration();

		/**
		 * The meta object literal for the '<em><b>Axis Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER = eINSTANCE.getAxisManagerConfiguration_AxisManager();

		/**
		 * The meta object literal for the '<em><b>Local Specific Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS = eINSTANCE.getAxisManagerConfiguration_LocalSpecificConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.TableHeaderAxisConfigurationImpl <em>Table Header Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.TableHeaderAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getTableHeaderAxisConfiguration()
		 * @generated
		 */
		EClass TABLE_HEADER_AXIS_CONFIGURATION = eINSTANCE.getTableHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Axis Managers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS = eINSTANCE.getTableHeaderAxisConfiguration_AxisManagers();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.LocalTableHeaderAxisConfigurationImpl <em>Local Table Header Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.LocalTableHeaderAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getLocalTableHeaderAxisConfiguration()
		 * @generated
		 */
		EClass LOCAL_TABLE_HEADER_AXIS_CONFIGURATION = eINSTANCE.getLocalTableHeaderAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Axis Manager Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS = eINSTANCE.getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration <em>IAxis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIAxisConfiguration()
		 * @generated
		 */
		EClass IAXIS_CONFIGURATION = eINSTANCE.getIAxisConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.FeatureAxisConfigurationImpl <em>Feature Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.FeatureAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getFeatureAxisConfiguration()
		 * @generated
		 */
		EClass FEATURE_AXIS_CONFIGURATION = eINSTANCE.getFeatureAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Show Only Common Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE = eINSTANCE.getFeatureAxisConfiguration_ShowOnlyCommonFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration <em>IFilling Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIFillingConfiguration()
		 * @generated
		 */
		EClass IFILLING_CONFIGURATION = eINSTANCE.getIFillingConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.EStructuralFeatureValueFillingConfigurationImpl <em>EStructural Feature Value Filling Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.EStructuralFeatureValueFillingConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getEStructuralFeatureValueFillingConfiguration()
		 * @generated
		 */
		EClass ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION = eINSTANCE.getEStructuralFeatureValueFillingConfiguration();

		/**
		 * The meta object literal for the '<em><b>Listen Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE = eINSTANCE.getEStructuralFeatureValueFillingConfiguration_ListenFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl <em>IPaste Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.IPasteConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getIPasteConfiguration()
		 * @generated
		 */
		EClass IPASTE_CONFIGURATION = eINSTANCE.getIPasteConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.PasteEObjectConfigurationImpl <em>Paste EObject Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.PasteEObjectConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getPasteEObjectConfiguration()
		 * @generated
		 */
		EClass PASTE_EOBJECT_CONFIGURATION = eINSTANCE.getPasteEObjectConfiguration();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PASTE_EOBJECT_CONFIGURATION__PASTED_ELEMENT_ID = eINSTANCE.getPasteEObjectConfiguration_PastedElementId();

		/**
		 * The meta object literal for the '<em><b>Paste Element Containement Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASTE_EOBJECT_CONFIGURATION__PASTE_ELEMENT_CONTAINEMENT_FEATURE = eINSTANCE.getPasteEObjectConfiguration_PasteElementContainementFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisIndexStyle()
		 * @generated
		 */
		EEnum AXIS_INDEX_STYLE = eINSTANCE.getAxisIndexStyle();

	}

} //NattableaxisconfigurationPackage
