/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigFactory
 * @model kind="package"
 * @generated
 */
public interface LayersconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layersconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.eclipse.papyrus.layersconfig.0.10";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "layersconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersconfigPackage eINSTANCE = org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderElementImpl <em>Folder Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderElementImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getFolderElement()
	 * @generated
	 */
	int FOLDER_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Folder Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Folder Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = FOLDER_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Folder Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__FOLDER_ELEMENTS = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl <em>Instanciable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getInstanciableElement()
	 * @generated
	 */
	int INSTANCIABLE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__NAME = FOLDER_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__CLASSNAME = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__BUNDLE_ID = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__DISPLAY_NAME = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__ICON_PATH = FOLDER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Classname Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT__CLASSNAME_KIND = FOLDER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Instanciable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Instanciable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCIABLE_ELEMENT_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl <em>Layer Operator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorConfig()
	 * @generated
	 */
	int LAYER_OPERATOR_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__NAME = INSTANCIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__CLASSNAME = INSTANCIABLE_ELEMENT__CLASSNAME;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__BUNDLE_ID = INSTANCIABLE_ELEMENT__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__DISPLAY_NAME = INSTANCIABLE_ELEMENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__ICON_PATH = INSTANCIABLE_ELEMENT__ICON_PATH;

	/**
	 * The feature id for the '<em><b>Classname Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG__CLASSNAME_KIND = INSTANCIABLE_ELEMENT__CLASSNAME_KIND;

	/**
	 * The number of structural features of the '<em>Layer Operator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG_FEATURE_COUNT = INSTANCIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Layers Operator Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG___CREATE_LAYERS_OPERATOR_DESCRIPTOR = INSTANCIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Layer Operator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_CONFIG_OPERATION_COUNT = INSTANCIABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl <em>Operator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getOperatorConfig()
	 * @generated
	 */
	int OPERATOR_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__NAME = INSTANCIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__CLASSNAME = INSTANCIABLE_ELEMENT__CLASSNAME;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__BUNDLE_ID = INSTANCIABLE_ELEMENT__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__DISPLAY_NAME = INSTANCIABLE_ELEMENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__ICON_PATH = INSTANCIABLE_ELEMENT__ICON_PATH;

	/**
	 * The feature id for the '<em><b>Classname Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG__CLASSNAME_KIND = INSTANCIABLE_ELEMENT__CLASSNAME_KIND;

	/**
	 * The number of structural features of the '<em>Operator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG_FEATURE_COUNT = INSTANCIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Operator Descriptor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG___CREATE_OPERATOR_DESCRIPTOR = INSTANCIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CONFIG_OPERATION_COUNT = INSTANCIABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.PropertyIdImpl <em>Property Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.PropertyIdImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getPropertyId()
	 * @generated
	 */
	int PROPERTY_ID = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ID__NAME = FOLDER_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ID__TYPE = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ID_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ID_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.TypeConfigImpl <em>Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.TypeConfigImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getTypeConfig()
	 * @generated
	 */
	int TYPE_CONFIG = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONFIG__NAME = FOLDER_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONFIG_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CONFIG_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl <em>Layer Operator Multiple Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorMultipleBinding()
	 * @generated
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING__NAME = FOLDER_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Layer Operator Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG = FOLDER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS = FOLDER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Layer Operator Multiple Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING_FEATURE_COUNT = FOLDER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Layer Operator Multiple Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_OPERATOR_MULTIPLE_BINDING_OPERATION_COUNT = FOLDER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl <em>Operator Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getOperatorBinding()
	 * @generated
	 */
	int OPERATOR_BINDING = 8;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING__OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Layer Operator Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING__LAYER_OPERATOR_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING__PROPERTY_ID = 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING__OWNER = 3;

	/**
	 * The number of structural features of the '<em>Operator Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Operator Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind <em>Classname Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getClassnameKind()
	 * @generated
	 */
	int CLASSNAME_KIND = 9;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getString()
	 * @generated
	 */
	int STRING = 10;


	/**
	 * The meta object id for the '<em>Instanciation Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.stackmodel.InstanciationException
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getInstanciationException()
	 * @generated
	 */
	int INSTANCIATION_EXCEPTION = 11;

	/**
	 * The meta object id for the '<em>Layer Operator Descriptor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorDescriptor()
	 * @generated
	 */
	int LAYER_OPERATOR_DESCRIPTOR = 12;


	/**
	 * The meta object id for the '<em>Property Operator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getPropertyOperator()
	 * @generated
	 */
	int PROPERTY_OPERATOR = 13;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.Folder#getFolderElements <em>Folder Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folder Elements</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.Folder#getFolderElements()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_FolderElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.FolderElement <em>Folder Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder Element</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.FolderElement
	 * @generated
	 */
	EClass getFolderElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.FolderElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.FolderElement#getName()
	 * @see #getFolderElement()
	 * @generated
	 */
	EAttribute getFolderElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig <em>Layer Operator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Operator Config</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig
	 * @generated
	 */
	EClass getLayerOperatorConfig();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig#createLayersOperatorDescriptor() <em>Create Layers Operator Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Layers Operator Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig#createLayersOperatorDescriptor()
	 * @generated
	 */
	EOperation getLayerOperatorConfig__CreateLayersOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement <em>Instanciable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instanciable Element</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement
	 * @generated
	 */
	EClass getInstanciableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassname()
	 * @see #getInstanciableElement()
	 * @generated
	 */
	EAttribute getInstanciableElement_Classname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getBundleID <em>Bundle ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle ID</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getBundleID()
	 * @see #getInstanciableElement()
	 * @generated
	 */
	EAttribute getInstanciableElement_BundleID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getDisplayName()
	 * @see #getInstanciableElement()
	 * @generated
	 */
	EAttribute getInstanciableElement_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getIconPath()
	 * @see #getInstanciableElement()
	 * @generated
	 */
	EAttribute getInstanciableElement_IconPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassnameKind <em>Classname Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname Kind</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassnameKind()
	 * @see #getInstanciableElement()
	 * @generated
	 */
	EAttribute getInstanciableElement_ClassnameKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig <em>Operator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Config</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig
	 * @generated
	 */
	EClass getOperatorConfig();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig#createOperatorDescriptor() <em>Create Operator Descriptor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Operator Descriptor</em>' operation.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig#createOperatorDescriptor()
	 * @generated
	 */
	EOperation getOperatorConfig__CreateOperatorDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Id</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId
	 * @generated
	 */
	EClass getPropertyId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId#getType()
	 * @see #getPropertyId()
	 * @generated
	 */
	EReference getPropertyId_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig <em>Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Config</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig
	 * @generated
	 */
	EClass getTypeConfig();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding <em>Layer Operator Multiple Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Operator Multiple Binding</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding
	 * @generated
	 */
	EClass getLayerOperatorMultipleBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getLayerOperatorConfig <em>Layer Operator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layer Operator Config</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getLayerOperatorConfig()
	 * @see #getLayerOperatorMultipleBinding()
	 * @generated
	 */
	EReference getLayerOperatorMultipleBinding_LayerOperatorConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings()
	 * @see #getLayerOperatorMultipleBinding()
	 * @generated
	 */
	EReference getLayerOperatorMultipleBinding_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding <em>Operator Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Binding</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding
	 * @generated
	 */
	EClass getOperatorBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOperator()
	 * @see #getOperatorBinding()
	 * @generated
	 */
	EReference getOperatorBinding_Operator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getLayerOperatorConfig <em>Layer Operator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layer Operator Config</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getLayerOperatorConfig()
	 * @see #getOperatorBinding()
	 * @generated
	 */
	EReference getOperatorBinding_LayerOperatorConfig();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getPropertyId()
	 * @see #getOperatorBinding()
	 * @generated
	 */
	EReference getOperatorBinding_PropertyId();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOwner()
	 * @see #getOperatorBinding()
	 * @generated
	 */
	EReference getOperatorBinding_Owner();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind <em>Classname Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Classname Kind</em>'.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind
	 * @generated
	 */
	EEnum getClassnameKind();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.layers.stackmodel.InstanciationException <em>Instanciation Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Instanciation Exception</em>'.
	 * @see org.eclipse.papyrus.layers.stackmodel.InstanciationException
	 * @model instanceClass="org.eclipse.papyrus.layers.stackmodel.InstanciationException"
	 * @generated
	 */
	EDataType getInstanciationException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor <em>Layer Operator Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Layer Operator Descriptor</em>'.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor
	 * @model instanceClass="org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor"
	 * @generated
	 */
	EDataType getLayerOperatorDescriptor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator <em>Property Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property Operator</em>'.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator
	 * @model instanceClass="org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator"
	 * @generated
	 */
	EDataType getPropertyOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayersconfigFactory getLayersconfigFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Folder Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__FOLDER_ELEMENTS = eINSTANCE.getFolder_FolderElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderElementImpl <em>Folder Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.FolderElementImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getFolderElement()
		 * @generated
		 */
		EClass FOLDER_ELEMENT = eINSTANCE.getFolderElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOLDER_ELEMENT__NAME = eINSTANCE.getFolderElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl <em>Layer Operator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorConfig()
		 * @generated
		 */
		EClass LAYER_OPERATOR_CONFIG = eINSTANCE.getLayerOperatorConfig();

		/**
		 * The meta object literal for the '<em><b>Create Layers Operator Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LAYER_OPERATOR_CONFIG___CREATE_LAYERS_OPERATOR_DESCRIPTOR = eINSTANCE.getLayerOperatorConfig__CreateLayersOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl <em>Instanciable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getInstanciableElement()
		 * @generated
		 */
		EClass INSTANCIABLE_ELEMENT = eINSTANCE.getInstanciableElement();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCIABLE_ELEMENT__CLASSNAME = eINSTANCE.getInstanciableElement_Classname();

		/**
		 * The meta object literal for the '<em><b>Bundle ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCIABLE_ELEMENT__BUNDLE_ID = eINSTANCE.getInstanciableElement_BundleID();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCIABLE_ELEMENT__DISPLAY_NAME = eINSTANCE.getInstanciableElement_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCIABLE_ELEMENT__ICON_PATH = eINSTANCE.getInstanciableElement_IconPath();

		/**
		 * The meta object literal for the '<em><b>Classname Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCIABLE_ELEMENT__CLASSNAME_KIND = eINSTANCE.getInstanciableElement_ClassnameKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl <em>Operator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorConfigImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getOperatorConfig()
		 * @generated
		 */
		EClass OPERATOR_CONFIG = eINSTANCE.getOperatorConfig();

		/**
		 * The meta object literal for the '<em><b>Create Operator Descriptor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR_CONFIG___CREATE_OPERATOR_DESCRIPTOR = eINSTANCE.getOperatorConfig__CreateOperatorDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.PropertyIdImpl <em>Property Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.PropertyIdImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getPropertyId()
		 * @generated
		 */
		EClass PROPERTY_ID = eINSTANCE.getPropertyId();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ID__TYPE = eINSTANCE.getPropertyId_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.TypeConfigImpl <em>Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.TypeConfigImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getTypeConfig()
		 * @generated
		 */
		EClass TYPE_CONFIG = eINSTANCE.getTypeConfig();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl <em>Layer Operator Multiple Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorMultipleBindingImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorMultipleBinding()
		 * @generated
		 */
		EClass LAYER_OPERATOR_MULTIPLE_BINDING = eINSTANCE.getLayerOperatorMultipleBinding();

		/**
		 * The meta object literal for the '<em><b>Layer Operator Config</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_MULTIPLE_BINDING__LAYER_OPERATOR_CONFIG = eINSTANCE.getLayerOperatorMultipleBinding_LayerOperatorConfig();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS = eINSTANCE.getLayerOperatorMultipleBinding_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl <em>Operator Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getOperatorBinding()
		 * @generated
		 */
		EClass OPERATOR_BINDING = eINSTANCE.getOperatorBinding();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BINDING__OPERATOR = eINSTANCE.getOperatorBinding_Operator();

		/**
		 * The meta object literal for the '<em><b>Layer Operator Config</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BINDING__LAYER_OPERATOR_CONFIG = eINSTANCE.getOperatorBinding_LayerOperatorConfig();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BINDING__PROPERTY_ID = eINSTANCE.getOperatorBinding_PropertyId();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BINDING__OWNER = eINSTANCE.getOperatorBinding_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind <em>Classname Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getClassnameKind()
		 * @generated
		 */
		EEnum CLASSNAME_KIND = eINSTANCE.getClassnameKind();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Instanciation Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.stackmodel.InstanciationException
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getInstanciationException()
		 * @generated
		 */
		EDataType INSTANCIATION_EXCEPTION = eINSTANCE.getInstanciationException();

		/**
		 * The meta object literal for the '<em>Layer Operator Descriptor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getLayerOperatorDescriptor()
		 * @generated
		 */
		EDataType LAYER_OPERATOR_DESCRIPTOR = eINSTANCE.getLayerOperatorDescriptor();

		/**
		 * The meta object literal for the '<em>Property Operator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator
		 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayersconfigPackageImpl#getPropertyOperator()
		 * @generated
		 */
		EDataType PROPERTY_OPERATOR = eINSTANCE.getPropertyOperator();

	}

} //LayersconfigPackage
