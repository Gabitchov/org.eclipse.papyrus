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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;

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
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface InvariantStereotypeConfigurationPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "invariantstereotypeconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/semantictype/invariant/stereotype/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "invariantstereotypeconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantStereotypeConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl <em>Invariant Stereotype Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationPackageImpl#getInvariantStereotypeConfiguration()
	 * @generated
	 */
	int INVARIANT_STEREOTYPE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Invariant Stereotype Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_STEREOTYPE_CONFIGURATION_FEATURE_COUNT = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Invariant Stereotype Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_STEREOTYPE_CONFIGURATION_OPERATION_COUNT = InvariantSemanticTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration <em>Invariant Stereotype Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Stereotype Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration
	 * @generated
	 */
	EClass getInvariantStereotypeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration#getStereotypeQualifiedName()
	 * @see #getInvariantStereotypeConfiguration()
	 * @generated
	 */
	EAttribute getInvariantStereotypeConfiguration_StereotypeQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration#getRequiredProfile <em>Required Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Profile</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration#getRequiredProfile()
	 * @see #getInvariantStereotypeConfiguration()
	 * @generated
	 */
	EAttribute getInvariantStereotypeConfiguration_RequiredProfile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InvariantStereotypeConfigurationFactory getInvariantStereotypeConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl <em>Invariant Stereotype Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationPackageImpl#getInvariantStereotypeConfiguration()
		 * @generated
		 */
		EClass INVARIANT_STEREOTYPE_CONFIGURATION = eINSTANCE.getInvariantStereotypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME = eINSTANCE.getInvariantStereotypeConfiguration_StereotypeQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Required Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE = eINSTANCE.getInvariantStereotypeConfiguration_RequiredProfile();
	}
} //InvariantStereotypeConfigurationPackage
