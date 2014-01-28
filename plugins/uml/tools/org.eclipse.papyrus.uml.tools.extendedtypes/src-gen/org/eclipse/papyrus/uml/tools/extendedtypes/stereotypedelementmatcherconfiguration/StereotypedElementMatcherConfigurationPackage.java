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
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

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
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface StereotypedElementMatcherConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stereotypedelementmatcherconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/payrus/extendedtypes/uml/stereotypematcherconfiguration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stereotypedelementmatcherconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StereotypedElementMatcherConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationImpl <em>Stereotyped Element Matcher Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationPackageImpl#getStereotypedElementMatcherConfiguration()
	 * @generated
	 */
	int STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Stereotyped Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME = ExtendedtypesPackage.MATCHER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stereotyped Element Matcher Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.MATCHER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration <em>Stereotyped Element Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotyped Element Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration
	 * @generated
	 */
	EClass getStereotypedElementMatcherConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration#getStereotypedQualifiedName <em>Stereotyped Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotyped Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration#getStereotypedQualifiedName()
	 * @see #getStereotypedElementMatcherConfiguration()
	 * @generated
	 */
	EAttribute getStereotypedElementMatcherConfiguration_StereotypedQualifiedName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StereotypedElementMatcherConfigurationFactory getStereotypedElementMatcherConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationImpl <em>Stereotyped Element Matcher Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationPackageImpl#getStereotypedElementMatcherConfiguration()
		 * @generated
		 */
		EClass STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION = eINSTANCE.getStereotypedElementMatcherConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stereotyped Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME = eINSTANCE.getStereotypedElementMatcherConfiguration_StereotypedQualifiedName();

	}

} //StereotypedElementMatcherConfigurationPackage
