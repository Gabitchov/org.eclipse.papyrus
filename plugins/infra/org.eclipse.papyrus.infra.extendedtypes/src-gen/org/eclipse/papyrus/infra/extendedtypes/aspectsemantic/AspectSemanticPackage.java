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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantic;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticFactory
 * @model kind="package"
 * @generated
 */
public interface AspectSemanticPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "aspectsemantic";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/semantic/aspect/1.0";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "aspectsemantic";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	AspectSemanticPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeConfigurationImpl
	 * <em>Type Configuration</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticPackageImpl#getAspectSemanticTypeConfiguration()
	 * @generated
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__HINT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__KIND_NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__KIND_NAME;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Advice Configuration</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Configuration</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeAdviceConfigurationImpl
	 * <em>Type Advice Configuration</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticPackageImpl#getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Pre Action Configuration</b></em>'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Post Action Configuration</b></em>'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '
	 * <em>Type Advice Configuration</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeConfiguration
	 * <em>Type Configuration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeConfiguration
	 * @generated
	 */
	EClass getAspectSemanticTypeConfiguration();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeConfiguration#getAdviceConfiguration
	 * <em>Advice Configuration</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '
	 *         <em>Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeConfiguration#getAdviceConfiguration()
	 * @see #getAspectSemanticTypeConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeConfiguration_AdviceConfiguration();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration
	 * <em>Type Advice Configuration</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration
	 * @generated
	 */
	EClass getAspectSemanticTypeAdviceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration#getPreActionConfiguration
	 * <em>Pre Action Configuration</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Pre Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration#getPreActionConfiguration()
	 * @see #getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeAdviceConfiguration_PreActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration#getPostActionConfiguration
	 * <em>Post Action Configuration</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Post Action Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration#getPostActionConfiguration()
	 * @see #getAspectSemanticTypeAdviceConfiguration()
	 * @generated
	 */
	EReference getAspectSemanticTypeAdviceConfiguration_PostActionConfiguration();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AspectSemanticFactory getAspectSemanticFactory();

} // AspectSemanticPackage
