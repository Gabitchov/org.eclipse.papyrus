/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

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
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/viewpoints/configuration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl <em>Papyrus Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusConfiguration()
	 * @generated
	 */
	int PAPYRUS_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__STAKEHOLDERS = Iso42010Package.ARCHITECTURE_FRAMEWORK__STAKEHOLDERS;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__VIEWPOINTS = Iso42010Package.ARCHITECTURE_FRAMEWORK__VIEWPOINTS;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__RULES = Iso42010Package.ARCHITECTURE_FRAMEWORK__RULES;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__CONCERNS = Iso42010Package.ARCHITECTURE_FRAMEWORK__CONCERNS;

	/**
	 * The feature id for the '<em><b>Default Stakeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER = Iso42010Package.ARCHITECTURE_FRAMEWORK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__METAMODEL = Iso42010Package.ARCHITECTURE_FRAMEWORK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION__CATEGORIES = Iso42010Package.ARCHITECTURE_FRAMEWORK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Papyrus Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION_FEATURE_COUNT = Iso42010Package.ARCHITECTURE_FRAMEWORK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Papyrus Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_CONFIGURATION_OPERATION_COUNT = Iso42010Package.ARCHITECTURE_FRAMEWORK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewpointImpl <em>Papyrus Viewpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewpointImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusViewpoint()
	 * @generated
	 */
	int PAPYRUS_VIEWPOINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__NAME = Iso42010Package.ARCHITECTURE_VIEWPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__AFFECTED_BY = Iso42010Package.ARCHITECTURE_VIEWPOINT__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Model Kinds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__MODEL_KINDS = Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__GOVERNS = Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__FRAMES = Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT__PARENT = Iso42010Package.ARCHITECTURE_VIEWPOINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Papyrus Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT_FEATURE_COUNT = Iso42010Package.ARCHITECTURE_VIEWPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Papyrus Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEWPOINT_OPERATION_COUNT = Iso42010Package.ARCHITECTURE_VIEWPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl <em>Papyrus View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusView()
	 * @generated
	 */
	int PAPYRUS_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__NAME = Iso42010Package.MODEL_KIND__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__AFFECTED_BY = Iso42010Package.MODEL_KIND__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__GOVERNS = Iso42010Package.MODEL_KIND__GOVERNS;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__VIEWPOINT = Iso42010Package.MODEL_KIND__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__ICON = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__PARENT = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__PROFILES = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__MODEL_RULES = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__OWNING_RULES = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implementation ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__IMPLEMENTATION_ID = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW__CATEGORIES = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Papyrus View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_FEATURE_COUNT = Iso42010Package.MODEL_KIND_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Papyrus View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_OPERATION_COUNT = Iso42010Package.MODEL_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl <em>Papyrus Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusDiagram()
	 * @generated
	 */
	int PAPYRUS_DIAGRAM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__NAME = PAPYRUS_VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__AFFECTED_BY = PAPYRUS_VIEW__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__GOVERNS = PAPYRUS_VIEW__GOVERNS;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__VIEWPOINT = PAPYRUS_VIEW__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__ICON = PAPYRUS_VIEW__ICON;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__PARENT = PAPYRUS_VIEW__PARENT;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__PROFILES = PAPYRUS_VIEW__PROFILES;

	/**
	 * The feature id for the '<em><b>Model Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__MODEL_RULES = PAPYRUS_VIEW__MODEL_RULES;

	/**
	 * The feature id for the '<em><b>Owning Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__OWNING_RULES = PAPYRUS_VIEW__OWNING_RULES;

	/**
	 * The feature id for the '<em><b>Implementation ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__IMPLEMENTATION_ID = PAPYRUS_VIEW__IMPLEMENTATION_ID;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__CATEGORIES = PAPYRUS_VIEW__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Custom Palette</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__CUSTOM_PALETTE = PAPYRUS_VIEW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Custom Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__CUSTOM_STYLE = PAPYRUS_VIEW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Child Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__CHILD_RULES = PAPYRUS_VIEW_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Palette Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM__PALETTE_RULES = PAPYRUS_VIEW_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Papyrus Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM_FEATURE_COUNT = PAPYRUS_VIEW_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Papyrus Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIAGRAM_OPERATION_COUNT = PAPYRUS_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusSyncTableImpl <em>Papyrus Sync Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusSyncTableImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusSyncTable()
	 * @generated
	 */
	int PAPYRUS_SYNC_TABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__NAME = PAPYRUS_VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__AFFECTED_BY = PAPYRUS_VIEW__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__GOVERNS = PAPYRUS_VIEW__GOVERNS;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__VIEWPOINT = PAPYRUS_VIEW__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__ICON = PAPYRUS_VIEW__ICON;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__PARENT = PAPYRUS_VIEW__PARENT;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__PROFILES = PAPYRUS_VIEW__PROFILES;

	/**
	 * The feature id for the '<em><b>Model Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__MODEL_RULES = PAPYRUS_VIEW__MODEL_RULES;

	/**
	 * The feature id for the '<em><b>Owning Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__OWNING_RULES = PAPYRUS_VIEW__OWNING_RULES;

	/**
	 * The feature id for the '<em><b>Implementation ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__IMPLEMENTATION_ID = PAPYRUS_VIEW__IMPLEMENTATION_ID;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE__CATEGORIES = PAPYRUS_VIEW__CATEGORIES;

	/**
	 * The number of structural features of the '<em>Papyrus Sync Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE_FEATURE_COUNT = PAPYRUS_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Papyrus Sync Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_SYNC_TABLE_OPERATION_COUNT = PAPYRUS_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusTableImpl <em>Papyrus Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusTableImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusTable()
	 * @generated
	 */
	int PAPYRUS_TABLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__NAME = PAPYRUS_VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__AFFECTED_BY = PAPYRUS_VIEW__AFFECTED_BY;

	/**
	 * The feature id for the '<em><b>Governs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__GOVERNS = PAPYRUS_VIEW__GOVERNS;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__VIEWPOINT = PAPYRUS_VIEW__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__ICON = PAPYRUS_VIEW__ICON;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__PARENT = PAPYRUS_VIEW__PARENT;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__PROFILES = PAPYRUS_VIEW__PROFILES;

	/**
	 * The feature id for the '<em><b>Model Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__MODEL_RULES = PAPYRUS_VIEW__MODEL_RULES;

	/**
	 * The feature id for the '<em><b>Owning Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__OWNING_RULES = PAPYRUS_VIEW__OWNING_RULES;

	/**
	 * The feature id for the '<em><b>Implementation ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__IMPLEMENTATION_ID = PAPYRUS_VIEW__IMPLEMENTATION_ID;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__CATEGORIES = PAPYRUS_VIEW__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE__CONFIGURATION = PAPYRUS_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Papyrus Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_FEATURE_COUNT = PAPYRUS_VIEW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Papyrus Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_OPERATION_COUNT = PAPYRUS_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.RuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 6;

	/**
	 * The feature id for the '<em><b>Permit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PERMIT = 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelRuleImpl <em>Model Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelRuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getModelRule()
	 * @generated
	 */
	int MODEL_RULE = 7;

	/**
	 * The feature id for the '<em><b>Permit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__PERMIT = RULE__PERMIT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__ELEMENT = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__STEREOTYPES = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__MULTIPLICITY = RULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Model Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE_OPERATION_COUNT = RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.OwningRuleImpl <em>Owning Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.OwningRuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getOwningRule()
	 * @generated
	 */
	int OWNING_RULE = 8;

	/**
	 * The feature id for the '<em><b>Permit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE__PERMIT = RULE__PERMIT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE__ELEMENT = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE__STEREOTYPES = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE__MULTIPLICITY = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New Model Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE__NEW_MODEL_PATH = RULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Owning Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Owning Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNING_RULE_OPERATION_COUNT = RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl <em>Child Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getChildRule()
	 * @generated
	 */
	int CHILD_RULE = 9;

	/**
	 * The feature id for the '<em><b>Permit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE__PERMIT = RULE__PERMIT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE__ELEMENT = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE__STEREOTYPES = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE__ORIGIN = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Insertion Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE__INSERTION_PATH = RULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Child Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Child Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RULE_OPERATION_COUNT = RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PaletteRuleImpl <em>Palette Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PaletteRuleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPaletteRule()
	 * @generated
	 */
	int PALETTE_RULE = 10;

	/**
	 * The feature id for the '<em><b>Permit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_RULE__PERMIT = RULE__PERMIT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_RULE__ELEMENT = RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Palette Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Palette Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_RULE_OPERATION_COUNT = RULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl <em>Path Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPathElement()
	 * @generated
	 */
	int PATH_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT__FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT__ORIGIN = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Path Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Path Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.CategoryImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl <em>Model Auto Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getModelAutoCreate()
	 * @generated
	 */
	int MODEL_AUTO_CREATE = 13;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_AUTO_CREATE__FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_AUTO_CREATE__ORIGIN = 1;

	/**
	 * The feature id for the '<em><b>Creation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_AUTO_CREATE__CREATION_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Model Auto Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_AUTO_CREATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Model Auto Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_AUTO_CREATE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration <em>Papyrus Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration
	 * @generated
	 */
	EClass getPapyrusConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getDefaultStakeholder <em>Default Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Stakeholder</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getDefaultStakeholder()
	 * @see #getPapyrusConfiguration()
	 * @generated
	 */
	EReference getPapyrusConfiguration_DefaultStakeholder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getMetamodel()
	 * @see #getPapyrusConfiguration()
	 * @generated
	 */
	EReference getPapyrusConfiguration_Metamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getCategories()
	 * @see #getPapyrusConfiguration()
	 * @generated
	 */
	EReference getPapyrusConfiguration_Categories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint <em>Papyrus Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Viewpoint</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint
	 * @generated
	 */
	EClass getPapyrusViewpoint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint#getParent()
	 * @see #getPapyrusViewpoint()
	 * @generated
	 */
	EReference getPapyrusViewpoint_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView <em>Papyrus View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus View</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView
	 * @generated
	 */
	EClass getPapyrusView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getIcon()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EAttribute getPapyrusView_Icon();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getParent()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EReference getPapyrusView_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Profiles</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getProfiles()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EReference getPapyrusView_Profiles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getModelRules <em>Model Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getModelRules()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EReference getPapyrusView_ModelRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getOwningRules <em>Owning Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owning Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getOwningRules()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EReference getPapyrusView_OwningRules();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getImplementationID <em>Implementation ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation ID</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getImplementationID()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EAttribute getPapyrusView_ImplementationID();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getCategories()
	 * @see #getPapyrusView()
	 * @generated
	 */
	EReference getPapyrusView_Categories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram <em>Papyrus Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Diagram</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram
	 * @generated
	 */
	EClass getPapyrusDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomPalette <em>Custom Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Palette</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomPalette()
	 * @see #getPapyrusDiagram()
	 * @generated
	 */
	EAttribute getPapyrusDiagram_CustomPalette();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomStyle <em>Custom Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Style</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomStyle()
	 * @see #getPapyrusDiagram()
	 * @generated
	 */
	EAttribute getPapyrusDiagram_CustomStyle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getChildRules <em>Child Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getChildRules()
	 * @see #getPapyrusDiagram()
	 * @generated
	 */
	EReference getPapyrusDiagram_ChildRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getPaletteRules <em>Palette Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Palette Rules</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getPaletteRules()
	 * @see #getPapyrusDiagram()
	 * @generated
	 */
	EReference getPapyrusDiagram_PaletteRules();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable <em>Papyrus Sync Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Sync Table</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable
	 * @generated
	 */
	EClass getPapyrusSyncTable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable <em>Papyrus Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable
	 * @generated
	 */
	EClass getPapyrusTable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable#getConfiguration()
	 * @see #getPapyrusTable()
	 * @generated
	 */
	EAttribute getPapyrusTable_Configuration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule <em>Model Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule
	 * @generated
	 */
	EClass getModelRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getElement()
	 * @see #getModelRule()
	 * @generated
	 */
	EReference getModelRule_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stereotypes</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getStereotypes()
	 * @see #getModelRule()
	 * @generated
	 */
	EReference getModelRule_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getMultiplicity()
	 * @see #getModelRule()
	 * @generated
	 */
	EAttribute getModelRule_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule <em>Owning Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Owning Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule
	 * @generated
	 */
	EClass getOwningRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getElement()
	 * @see #getOwningRule()
	 * @generated
	 */
	EReference getOwningRule_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stereotypes</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getStereotypes()
	 * @see #getOwningRule()
	 * @generated
	 */
	EReference getOwningRule_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getMultiplicity()
	 * @see #getOwningRule()
	 * @generated
	 */
	EAttribute getOwningRule_Multiplicity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getNewModelPath <em>New Model Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>New Model Path</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule#getNewModelPath()
	 * @see #getOwningRule()
	 * @generated
	 */
	EReference getOwningRule_NewModelPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule <em>Child Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule
	 * @generated
	 */
	EClass getChildRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getElement()
	 * @see #getChildRule()
	 * @generated
	 */
	EReference getChildRule_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stereotypes</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getStereotypes()
	 * @see #getChildRule()
	 * @generated
	 */
	EReference getChildRule_Stereotypes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getOrigin()
	 * @see #getChildRule()
	 * @generated
	 */
	EReference getChildRule_Origin();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getInsertionPath <em>Insertion Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Insertion Path</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule#getInsertionPath()
	 * @see #getChildRule()
	 * @generated
	 */
	EReference getChildRule_InsertionPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule <em>Palette Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule
	 * @generated
	 */
	EClass getPaletteRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule#getElement()
	 * @see #getPaletteRule()
	 * @generated
	 */
	EAttribute getPaletteRule_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.Rule#isPermit <em>Permit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permit</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.Rule#isPermit()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Permit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement <em>Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement
	 * @generated
	 */
	EClass getPathElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getFeature()
	 * @see #getPathElement()
	 * @generated
	 */
	EReference getPathElement_Feature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getOrigin()
	 * @see #getPathElement()
	 * @generated
	 */
	EReference getPathElement_Origin();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getTarget()
	 * @see #getPathElement()
	 * @generated
	 */
	EReference getPathElement_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate <em>Model Auto Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Auto Create</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate
	 * @generated
	 */
	EClass getModelAutoCreate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getFeature()
	 * @see #getModelAutoCreate()
	 * @generated
	 */
	EReference getModelAutoCreate_Feature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getOrigin()
	 * @see #getModelAutoCreate()
	 * @generated
	 */
	EReference getModelAutoCreate_Origin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getCreationType <em>Creation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Type</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getCreationType()
	 * @see #getModelAutoCreate()
	 * @generated
	 */
	EAttribute getModelAutoCreate_CreationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl <em>Papyrus Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusConfigurationImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusConfiguration()
		 * @generated
		 */
		EClass PAPYRUS_CONFIGURATION = eINSTANCE.getPapyrusConfiguration();

		/**
		 * The meta object literal for the '<em><b>Default Stakeholder</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_CONFIGURATION__DEFAULT_STAKEHOLDER = eINSTANCE.getPapyrusConfiguration_DefaultStakeholder();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_CONFIGURATION__METAMODEL = eINSTANCE.getPapyrusConfiguration_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_CONFIGURATION__CATEGORIES = eINSTANCE.getPapyrusConfiguration_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewpointImpl <em>Papyrus Viewpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewpointImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusViewpoint()
		 * @generated
		 */
		EClass PAPYRUS_VIEWPOINT = eINSTANCE.getPapyrusViewpoint();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEWPOINT__PARENT = eINSTANCE.getPapyrusViewpoint_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl <em>Papyrus View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusViewImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusView()
		 * @generated
		 */
		EClass PAPYRUS_VIEW = eINSTANCE.getPapyrusView();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_VIEW__ICON = eINSTANCE.getPapyrusView_Icon();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW__PARENT = eINSTANCE.getPapyrusView_Parent();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW__PROFILES = eINSTANCE.getPapyrusView_Profiles();

		/**
		 * The meta object literal for the '<em><b>Model Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW__MODEL_RULES = eINSTANCE.getPapyrusView_ModelRules();

		/**
		 * The meta object literal for the '<em><b>Owning Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW__OWNING_RULES = eINSTANCE.getPapyrusView_OwningRules();

		/**
		 * The meta object literal for the '<em><b>Implementation ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_VIEW__IMPLEMENTATION_ID = eINSTANCE.getPapyrusView_ImplementationID();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW__CATEGORIES = eINSTANCE.getPapyrusView_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl <em>Papyrus Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusDiagram()
		 * @generated
		 */
		EClass PAPYRUS_DIAGRAM = eINSTANCE.getPapyrusDiagram();

		/**
		 * The meta object literal for the '<em><b>Custom Palette</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_DIAGRAM__CUSTOM_PALETTE = eINSTANCE.getPapyrusDiagram_CustomPalette();

		/**
		 * The meta object literal for the '<em><b>Custom Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_DIAGRAM__CUSTOM_STYLE = eINSTANCE.getPapyrusDiagram_CustomStyle();

		/**
		 * The meta object literal for the '<em><b>Child Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_DIAGRAM__CHILD_RULES = eINSTANCE.getPapyrusDiagram_ChildRules();

		/**
		 * The meta object literal for the '<em><b>Palette Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_DIAGRAM__PALETTE_RULES = eINSTANCE.getPapyrusDiagram_PaletteRules();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusSyncTableImpl <em>Papyrus Sync Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusSyncTableImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusSyncTable()
		 * @generated
		 */
		EClass PAPYRUS_SYNC_TABLE = eINSTANCE.getPapyrusSyncTable();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusTableImpl <em>Papyrus Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusTableImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPapyrusTable()
		 * @generated
		 */
		EClass PAPYRUS_TABLE = eINSTANCE.getPapyrusTable();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE__CONFIGURATION = eINSTANCE.getPapyrusTable_Configuration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelRuleImpl <em>Model Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelRuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getModelRule()
		 * @generated
		 */
		EClass MODEL_RULE = eINSTANCE.getModelRule();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RULE__ELEMENT = eINSTANCE.getModelRule_Element();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RULE__STEREOTYPES = eINSTANCE.getModelRule_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_RULE__MULTIPLICITY = eINSTANCE.getModelRule_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.OwningRuleImpl <em>Owning Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.OwningRuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getOwningRule()
		 * @generated
		 */
		EClass OWNING_RULE = eINSTANCE.getOwningRule();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWNING_RULE__ELEMENT = eINSTANCE.getOwningRule_Element();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWNING_RULE__STEREOTYPES = eINSTANCE.getOwningRule_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OWNING_RULE__MULTIPLICITY = eINSTANCE.getOwningRule_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>New Model Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWNING_RULE__NEW_MODEL_PATH = eINSTANCE.getOwningRule_NewModelPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl <em>Child Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ChildRuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getChildRule()
		 * @generated
		 */
		EClass CHILD_RULE = eINSTANCE.getChildRule();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_RULE__ELEMENT = eINSTANCE.getChildRule_Element();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_RULE__STEREOTYPES = eINSTANCE.getChildRule_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_RULE__ORIGIN = eINSTANCE.getChildRule_Origin();

		/**
		 * The meta object literal for the '<em><b>Insertion Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_RULE__INSERTION_PATH = eINSTANCE.getChildRule_InsertionPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PaletteRuleImpl <em>Palette Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PaletteRuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPaletteRule()
		 * @generated
		 */
		EClass PALETTE_RULE = eINSTANCE.getPaletteRule();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PALETTE_RULE__ELEMENT = eINSTANCE.getPaletteRule_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.RuleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Permit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__PERMIT = eINSTANCE.getRule_Permit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl <em>Path Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getPathElement()
		 * @generated
		 */
		EClass PATH_ELEMENT = eINSTANCE.getPathElement();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT__FEATURE = eINSTANCE.getPathElement_Feature();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT__ORIGIN = eINSTANCE.getPathElement_Origin();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT__TARGET = eINSTANCE.getPathElement_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.CategoryImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl <em>Model Auto Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationPackageImpl#getModelAutoCreate()
		 * @generated
		 */
		EClass MODEL_AUTO_CREATE = eINSTANCE.getModelAutoCreate();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_AUTO_CREATE__FEATURE = eINSTANCE.getModelAutoCreate_Feature();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_AUTO_CREATE__ORIGIN = eINSTANCE.getModelAutoCreate_Origin();

		/**
		 * The meta object literal for the '<em><b>Creation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_AUTO_CREATE__CREATION_TYPE = eINSTANCE.getModelAutoCreate_CreationType();

	}

} //ConfigurationPackage
