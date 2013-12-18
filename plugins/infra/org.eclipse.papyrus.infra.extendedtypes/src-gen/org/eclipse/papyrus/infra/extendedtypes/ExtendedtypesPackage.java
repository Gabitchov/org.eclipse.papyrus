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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesFactory
 * @model kind="package"
 * @generated
 */
public interface ExtendedtypesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "extendedtypes"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/1.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "extendedtypes"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ExtendedtypesPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl <em>Configuration Element</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ConfigurationElementImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getConfigurationElement()
	 * @generated
	 */
	int CONFIGURATION_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__ICON_ENTRY = 3;

	/**
	 * The number of structural features of the '<em>Configuration Element</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl <em>Extended Element Type Set</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedElementTypeSetImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getExtendedElementTypeSet()
	 * @generated
	 */
	int EXTENDED_ELEMENT_TYPE_SET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__ICON_ENTRY = CONFIGURATION_ELEMENT__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__ELEMENT_TYPE = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extensible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET__EXTENSIBLE = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extended Element Type Set</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ELEMENT_TYPE_SET_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl
	 * <em>Element Type Configuration</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getElementTypeConfiguration()
	 * @generated
	 */
	int ELEMENT_TYPE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY = CONFIGURATION_ELEMENT__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__HINT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__KIND_NAME = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = CONFIGURATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Element Type Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl
	 * <em>Icon Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.IconEntryImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getIconEntry()
	 * @generated
	 */
	int ICON_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__ICON_PATH = 0;

	/**
	 * The feature id for the '<em><b>Bundle Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__BUNDLE_ID = 1;

	/**
	 * The number of structural features of the '<em>Icon Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeAdviceConfigurationImpl
	 * <em>Element Type Advice Configuration</em>}' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ElementTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getElementTypeAdviceConfiguration()
	 * @generated
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY = CONFIGURATION_ELEMENT__ICON_ENTRY;

	/**
	 * The number of structural features of the '<em>Element Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ViewTypeAdviceConfigurationImpl
	 * <em>View Type Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ViewTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getViewTypeAdviceConfiguration()
	 * @generated
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION__NAME = ELEMENT_TYPE_ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The number of structural features of the '<em>View Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeAdviceConfigurationImpl
	 * <em>Semantic Type Advice Configuration</em>}' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION__NAME = ELEMENT_TYPE_ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The number of structural features of the '<em>Semantic Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.MatcherConfigurationImpl <em>Matcher Configuration</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.MatcherConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getMatcherConfiguration()
	 * @generated
	 */
	int MATCHER_CONFIGURATION = 6;

	/**
	 * The number of structural features of the '<em>Matcher Configuration</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MATCHER_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl <em>Action Configuration</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getActionConfiguration()
	 * @generated
	 */
	int ACTION_CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__ICON_ENTRY = CONFIGURATION_ELEMENT__ICON_ENTRY;

	/**
	 * The feature id for the ' <em><b>Pre Validation Query Configuration</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Configuration</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ViewActionConfigurationImpl <em>View Action Configuration</em>}
	 * ' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ViewActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getViewActionConfiguration()
	 * @generated
	 */
	int VIEW_ACTION_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION__NAME = ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION__DESCRIPTION = ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION__IDENTIFIER = ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION__ICON_ENTRY = ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the ' <em><b>Pre Validation Query Configuration</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION = ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION;

	/**
	 * The number of structural features of the '<em>View Action Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_ACTION_CONFIGURATION_FEATURE_COUNT = ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.SemanticActionConfigurationImpl
	 * <em>Semantic Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.SemanticActionConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getSemanticActionConfiguration()
	 * @generated
	 */
	int SEMANTIC_ACTION_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION__NAME = ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION__DESCRIPTION = ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION__IDENTIFIER = ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION__ICON_ENTRY = ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the ' <em><b>Pre Validation Query Configuration</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION = ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION;

	/**
	 * The number of structural features of the '<em>Semantic Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT = ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeConfigurationImpl
	 * <em>Semantic Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getSemanticTypeConfiguration()
	 * @generated
	 */
	int SEMANTIC_TYPE_CONFIGURATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__NAME = ELEMENT_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__HINT = ELEMENT_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__KIND_NAME = ELEMENT_TYPE_CONFIGURATION__KIND_NAME;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The number of structural features of the '<em>Semantic Type Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.impl.ViewTypeConfigurationImpl <em>View Type Configuration</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ViewTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.impl.ExtendedtypesPackageImpl#getViewTypeConfiguration()
	 * @generated
	 */
	int VIEW_TYPE_CONFIGURATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__NAME = ELEMENT_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__HINT = ELEMENT_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__KIND_NAME = ELEMENT_TYPE_CONFIGURATION__KIND_NAME;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Specialized Diagram Type ID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>View Type Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_TYPE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet <em>Extended Element Type Set</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extended Element Type Set</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet
	 * @generated
	 */
	EClass getExtendedElementTypeSet();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType()
	 * @see #getExtendedElementTypeSet()
	 * @generated
	 */
	EReference getExtendedElementTypeSet_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#isExtensible
	 * <em>Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Extensible</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#isExtensible()
	 * @see #getExtendedElementTypeSet()
	 * @generated
	 */
	EAttribute getExtendedElementTypeSet_Extensible();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration <em>Element Type Configuration</em>}
	 * '.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration
	 * @generated
	 */
	EClass getElementTypeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getHint <em>Hint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hint</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getHint()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeConfiguration_Hint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getKindName
	 * <em>Kind Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getKindName()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeConfiguration_KindName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getSpecializedTypesID
	 * <em>Specialized Types ID</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Specialized Types ID</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getSpecializedTypesID()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeConfiguration_SpecializedTypesID();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration#getMatcherConfiguration()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EReference getElementTypeConfiguration_MatcherConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry
	 * @generated
	 */
	EClass getIconEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_IconPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId <em>Bundle Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bundle Id</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_BundleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Element</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement
	 * @generated
	 */
	EClass getConfigurationElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getName()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getDescription
	 * <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getDescription()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getIdentifier
	 * <em>Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getIdentifier()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getIconEntry
	 * <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement#getIconEntry()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EReference getConfigurationElement_IconEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeAdviceConfiguration
	 * <em>View Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>View Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewTypeAdviceConfiguration
	 * @generated
	 */
	EClass getViewTypeAdviceConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticTypeAdviceConfiguration
	 * <em>Semantic Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Semantic Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticTypeAdviceConfiguration
	 * @generated
	 */
	EClass getSemanticTypeAdviceConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration
	 * @generated
	 */
	EClass getMatcherConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration <em>Action Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration
	 * @generated
	 */
	EClass getActionConfiguration();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getPreValidationQueryConfiguration
	 * <em>Pre Validation Query Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Pre Validation Query Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration#getPreValidationQueryConfiguration()
	 * @see #getActionConfiguration()
	 * @generated
	 */
	EReference getActionConfiguration_PreValidationQueryConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration <em>View Action Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>View Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration
	 * @generated
	 */
	EClass getViewActionConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration
	 * <em>Semantic Action Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Semantic Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration
	 * @generated
	 */
	EClass getSemanticActionConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration
	 * <em>Semantic Type Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Semantic Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration
	 * @generated
	 */
	EClass getSemanticTypeConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration <em>View Type Configuration</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>View Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration
	 * @generated
	 */
	EClass getViewTypeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration#getSpecializedDiagramTypeID
	 * <em>Specialized Diagram Type ID</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Specialized Diagram Type ID</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration#getSpecializedDiagramTypeID()
	 * @see #getViewTypeConfiguration()
	 * @generated
	 */
	EAttribute getViewTypeConfiguration_SpecializedDiagramTypeID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeAdviceConfiguration
	 * <em>Element Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeAdviceConfiguration
	 * @generated
	 */
	EClass getElementTypeAdviceConfiguration();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtendedtypesFactory getExtendedtypesFactory();
} // ExtendedtypesPackage
