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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

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
 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface AspectSemanticTypeConfigurationPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "aspectsemantictypeconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/semantic/aspect/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "aspectsemantictypeconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	AspectSemanticTypeConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationImpl
	 * <em>Aspect Semantic Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationPackageImpl#getAspectSemanticTypeConfiguration()
	 * @generated
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__HINT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__KIND_NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__KIND_NAME;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Advice Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aspect Semantic Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeAdviceConfigurationImpl
	 * <em>Aspect Semantic Type Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl.AspectSemanticTypeConfigurationPackageImpl#getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Pre Action Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Post Action Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aspect Semantic Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfiguration
	 * <em>Aspect Semantic Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Aspect Semantic Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfiguration
	 * @generated
	 */
	EClass getAspectSemanticTypeConfiguration();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfiguration#getAdviceConfiguration
	 * <em>Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfiguration#getAdviceConfiguration()
	 * @see #getAspectSemanticTypeConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeConfiguration_AdviceConfiguration();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration
	 * <em>Aspect Semantic Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Aspect Semantic Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration
	 * @generated
	 */
	EClass getAspectSemanticTypeAdviceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration#getPreActionConfiguration
	 * <em>Pre Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Pre Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration#getPreActionConfiguration()
	 * @see #getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeAdviceConfiguration_PreActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration#getPostActionConfiguration
	 * <em>Post Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Post Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration#getPostActionConfiguration()
	 * @see #getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeAdviceConfiguration_PostActionConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AspectSemanticTypeConfigurationFactory getAspectSemanticTypeConfigurationFactory();
} //AspectSemanticTypeConfigurationPackage
