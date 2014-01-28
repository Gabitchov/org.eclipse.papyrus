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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface InvariantSemanticTypeConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "invariantsemantictypeconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/semantictype/invariant/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "invariantsemantictypeconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantSemanticTypeConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationImpl <em>Invariant Semantic Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getInvariantSemanticTypeConfiguration()
	 * @generated
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__HINT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__KIND_NAME = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__KIND_NAME;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Invariant Rule Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invariant Semantic Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl <em>Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getInvariantRuleConfiguration()
	 * @generated
	 */
	int INVARIANT_RULE_CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.ComposedRuleConfigurationImpl <em>Composed Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.ComposedRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getComposedRuleConfiguration()
	 * @generated
	 */
	int COMPOSED_RULE_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composed Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_RULE_CONFIGURATION_FEATURE_COUNT = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composed Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_RULE_CONFIGURATION_OPERATION_COUNT = INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.AndRuleImpl <em>And Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.AndRuleImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getAndRule()
	 * @generated
	 */
	int AND_RULE = 3;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE__COMPOSED_RULES = COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES;

	/**
	 * The number of structural features of the '<em>And Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE_FEATURE_COUNT = COMPOSED_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_RULE_OPERATION_COUNT = COMPOSED_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.OrRuleImpl <em>Or Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.OrRuleImpl
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getOrRule()
	 * @generated
	 */
	int OR_RULE = 4;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE__COMPOSED_RULES = COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES;

	/**
	 * The number of structural features of the '<em>Or Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE_FEATURE_COUNT = COMPOSED_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_RULE_OPERATION_COUNT = COMPOSED_RULE_CONFIGURATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration <em>Invariant Semantic Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Semantic Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration
	 * @generated
	 */
	EClass getInvariantSemanticTypeConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration#getInvariantRuleConfiguration()
	 * @see #getInvariantSemanticTypeConfiguration()
	 * @generated
	 */
	EReference getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration <em>Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration
	 * @generated
	 */
	EClass getInvariantRuleConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration <em>Composed Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration
	 * @generated
	 */
	EClass getComposedRuleConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration#getComposedRules <em>Composed Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composed Rules</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.ComposedRuleConfiguration#getComposedRules()
	 * @see #getComposedRuleConfiguration()
	 * @generated
	 */
	EReference getComposedRuleConfiguration_ComposedRules();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.AndRule <em>And Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Rule</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.AndRule
	 * @generated
	 */
	EClass getAndRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.OrRule <em>Or Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Rule</em>'.
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.OrRule
	 * @generated
	 */
	EClass getOrRule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InvariantSemanticTypeConfigurationFactory getInvariantSemanticTypeConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationImpl <em>Invariant Semantic Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getInvariantSemanticTypeConfiguration()
		 * @generated
		 */
		EClass INVARIANT_SEMANTIC_TYPE_CONFIGURATION = eINSTANCE.getInvariantSemanticTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Invariant Rule Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVARIANT_SEMANTIC_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION = eINSTANCE.getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl <em>Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getInvariantRuleConfiguration()
		 * @generated
		 */
		EClass INVARIANT_RULE_CONFIGURATION = eINSTANCE.getInvariantRuleConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.ComposedRuleConfigurationImpl <em>Composed Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.ComposedRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getComposedRuleConfiguration()
		 * @generated
		 */
		EClass COMPOSED_RULE_CONFIGURATION = eINSTANCE.getComposedRuleConfiguration();

		/**
		 * The meta object literal for the '<em><b>Composed Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSED_RULE_CONFIGURATION__COMPOSED_RULES = eINSTANCE.getComposedRuleConfiguration_ComposedRules();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.AndRuleImpl <em>And Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.AndRuleImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getAndRule()
		 * @generated
		 */
		EClass AND_RULE = eINSTANCE.getAndRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.OrRuleImpl <em>Or Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.OrRuleImpl
		 * @see org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantSemanticTypeConfigurationPackageImpl#getOrRule()
		 * @generated
		 */
		EClass OR_RULE = eINSTANCE.getOrRule();

	}

} //InvariantSemanticTypeConfigurationPackage
