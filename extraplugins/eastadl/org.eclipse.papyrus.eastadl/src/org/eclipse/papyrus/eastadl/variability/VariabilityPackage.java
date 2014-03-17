/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc --> This subprofile contains elements to express
 * variability at the analysis architecture (AA), design architecture (DA) and implementation
 * architecture (IA). These will sometimes be called the artifact level. This work is based on
 * conceptual meta-model of the European project Families that describes variability expression in
 * system family. It also contains a set of stereotypes to define reuse-related information.
 * 
 * Overview: The stereotypes defined here are divided into two elements, those relative to
 * variability management, and those related to reuse management. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityFactory
 * @model kind="package"
 * @generated
 */
public interface VariabilityPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariationGroupImpl <em>Variation Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariationGroupImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariationGroup()
		 * @generated
		 */
		EClass VARIATION_GROUP = eINSTANCE.getVariationGroup();

		/**
		 * The meta object literal for the '<em><b>Variable Element</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_GROUP__VARIABLE_ELEMENT = eINSTANCE.getVariationGroup_VariableElement();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VARIATION_GROUP__CONSTRAINT = eINSTANCE.getVariationGroup_Constraint();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VARIATION_GROUP__KIND = eINSTANCE.getVariationGroup_Kind();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIATION_GROUP__BASE_CLASS = eINSTANCE.getVariationGroup_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl
		 * <em>Reuse Meta Information</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getReuseMetaInformation()
		 * @generated
		 */
		EClass REUSE_META_INFORMATION = eINSTANCE.getReuseMetaInformation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REUSE_META_INFORMATION__BASE_CLASS = eINSTANCE.getReuseMetaInformation_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl <em>Variability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariability()
		 * @generated
		 */
		EClass VARIABILITY = eINSTANCE.getVariability();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__BASE_CLASS = eINSTANCE.getVariability_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__BASE_PACKAGE = eINSTANCE.getVariability_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Configurable Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__CONFIGURABLE_CONTAINER = eINSTANCE.getVariability_ConfigurableContainer();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__CONFIGURATION = eINSTANCE.getVariability_Configuration();

		/**
		 * The meta object literal for the '<em><b>Product Feature Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__PRODUCT_FEATURE_MODEL = eINSTANCE.getVariability_ProductFeatureModel();

		/**
		 * The meta object literal for the '<em><b>Decision Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__DECISION_MODEL = eINSTANCE.getVariability_DecisionModel();

		/**
		 * The meta object literal for the '<em><b>Variable Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABILITY__VARIABLE_ELEMENT = eINSTANCE.getVariability_VariableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.FeatureConfigurationImpl
		 * <em>Feature Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.FeatureConfigurationImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getFeatureConfiguration()
		 * @generated
		 */
		EClass FEATURE_CONFIGURATION = eINSTANCE.getFeatureConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configured Feature Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL = eINSTANCE.getFeatureConfiguration_ConfiguredFeatureModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VehicleLevelBindingImpl
		 * <em>Vehicle Level Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VehicleLevelBindingImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVehicleLevelBinding()
		 * @generated
		 */
		EClass VEHICLE_LEVEL_BINDING = eINSTANCE.getVehicleLevelBinding();

		/**
		 * The meta object literal for the '<em><b>Source Vehicle Feature Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VEHICLE_LEVEL_BINDING__SOURCE_VEHICLE_FEATURE_MODEL = eINSTANCE.getVehicleLevelBinding_SourceVehicleFeatureModel();

		/**
		 * The meta object literal for the '<em><b>Target Feature Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VEHICLE_LEVEL_BINDING__TARGET_FEATURE_MODEL = eINSTANCE.getVehicleLevelBinding_TargetFeatureModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionImpl
		 * <em>Configuration Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecision()
		 * @generated
		 */
		EClass CONFIGURATION_DECISION = eINSTANCE.getConfigurationDecision();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONFIGURATION_DECISION__EFFECT = eINSTANCE.getConfigurationDecision_Effect();

		/**
		 * The meta object literal for the '<em><b>Criterion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONFIGURATION_DECISION__CRITERION = eINSTANCE.getConfigurationDecision_Criterion();

		/**
		 * The meta object literal for the '<em><b>Is Equivalence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONFIGURATION_DECISION__IS_EQUIVALENCE = eINSTANCE.getConfigurationDecision_IsEquivalence();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION__TARGET = eINSTANCE.getConfigurationDecision_Target();

		/**
		 * The meta object literal for the '<em><b>Selection Criterion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION__SELECTION_CRITERION = eINSTANCE.getConfigurationDecision_SelectionCriterion();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.SelectionCriterionImpl <em>Selection Criterion</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.SelectionCriterionImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getSelectionCriterion()
		 * @generated
		 */
		EClass SELECTION_CRITERION = eINSTANCE.getSelectionCriterion();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SELECTION_CRITERION__SOURCE = eINSTANCE.getSelectionCriterion_Source();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SELECTION_CRITERION__BASE_CLASS = eINSTANCE.getSelectionCriterion_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionFolderImpl
		 * <em>Configuration Decision Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionFolderImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionFolder()
		 * @generated
		 */
		EClass CONFIGURATION_DECISION_FOLDER = eINSTANCE.getConfigurationDecisionFolder();

		/**
		 * The meta object literal for the '<em><b>Child Entry</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION_FOLDER__CHILD_ENTRY = eINSTANCE.getConfigurationDecisionFolder_ChildEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ContainerConfigurationImpl
		 * <em>Container Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ContainerConfigurationImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getContainerConfiguration()
		 * @generated
		 */
		EClass CONTAINER_CONFIGURATION = eINSTANCE.getContainerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configured Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER = eINSTANCE.getContainerConfiguration_ConfiguredContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.PrivateContentImpl <em>Private Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.PrivateContentImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getPrivateContent()
		 * @generated
		 */
		EClass PRIVATE_CONTENT = eINSTANCE.getPrivateContent();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PRIVATE_CONTENT__BASE_CLASS = eINSTANCE.getPrivateContent_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Private Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PRIVATE_CONTENT__PRIVATE_ELEMENT = eINSTANCE.getPrivateContent_PrivateElement();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REUSE_META_INFORMATION__INFORMATION = eINSTANCE.getReuseMetaInformation_Information();

		/**
		 * The meta object literal for the '<em><b>Is Reusable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REUSE_META_INFORMATION__IS_REUSABLE = eINSTANCE.getReuseMetaInformation_IsReusable();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl
		 * <em>Configurable Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurableContainer()
		 * @generated
		 */
		EClass CONFIGURABLE_CONTAINER = eINSTANCE.getConfigurableContainer();

		/**
		 * The meta object literal for the '<em><b>Internal Binding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__INTERNAL_BINDING = eINSTANCE.getConfigurableContainer_InternalBinding();

		/**
		 * The meta object literal for the '<em><b>Variation Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__VARIATION_GROUP = eINSTANCE.getConfigurableContainer_VariationGroup();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__BASE_CLASS = eINSTANCE.getConfigurableContainer_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__BASE_PACKAGE = eINSTANCE.getConfigurableContainer_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Configurable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT = eINSTANCE.getConfigurableContainer_ConfigurableElement();

		/**
		 * The meta object literal for the '<em><b>Public Feature Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL = eINSTANCE.getConfigurableContainer_PublicFeatureModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.InternalBindingImpl <em>Internal Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.InternalBindingImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getInternalBinding()
		 * @generated
		 */
		EClass INTERNAL_BINDING = eINSTANCE.getInternalBinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelImpl
		 * <em>Configuration Decision Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionModel()
		 * @generated
		 */
		EClass CONFIGURATION_DECISION_MODEL = eINSTANCE.getConfigurationDecisionModel();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION_MODEL__BASE_PACKAGE = eINSTANCE.getConfigurationDecisionModel_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION_MODEL__BASE_CLASS = eINSTANCE.getConfigurationDecisionModel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Root Entry</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION_MODEL__ROOT_ENTRY = eINSTANCE.getConfigurationDecisionModel_RootEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelEntryImpl
		 * <em>Configuration Decision Model Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelEntryImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionModelEntry()
		 * @generated
		 */
		EClass CONFIGURATION_DECISION_MODEL_ENTRY = eINSTANCE.getConfigurationDecisionModelEntry();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONFIGURATION_DECISION_MODEL_ENTRY__IS_ACTIVE = eINSTANCE.getConfigurationDecisionModelEntry_IsActive();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_DECISION_MODEL_ENTRY__BASE_CLASS = eINSTANCE.getConfigurationDecisionModelEntry_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl <em>Variable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl
		 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariableElement()
		 * @generated
		 */
		EClass VARIABLE_ELEMENT = eINSTANCE.getVariableElement();

		/**
		 * The meta object literal for the '<em><b>Required Binding Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_ELEMENT__REQUIRED_BINDING_TIME = eINSTANCE.getVariableElement_RequiredBindingTime();

		/**
		 * The meta object literal for the '<em><b>Reuse Meta Information</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_ELEMENT__REUSE_META_INFORMATION = eINSTANCE.getVariableElement_ReuseMetaInformation();

		/**
		 * The meta object literal for the '<em><b>Optional Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_ELEMENT__OPTIONAL_ELEMENT = eINSTANCE.getVariableElement_OptionalElement();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_ELEMENT__BASE_CLASS = eINSTANCE.getVariableElement_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Actual Binding Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_ELEMENT__ACTUAL_BINDING_TIME = eINSTANCE.getVariableElement_ActualBindingTime();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "variability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Variability/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Variability";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	VariabilityPackage eINSTANCE = org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariationGroupImpl <em>Variation Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariationGroupImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariationGroup()
	 * @generated
	 */
	int VARIATION_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__CONSTRAINT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__KIND = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable Element</b></em>' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP__VARIABLE_ELEMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variation Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIATION_GROUP_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl <em>Reuse Meta Information</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getReuseMetaInformation()
	 * @generated
	 */
	int REUSE_META_INFORMATION = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl <em>Configurable Container</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurableContainerImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurableContainer()
	 * @generated
	 */
	int CONFIGURABLE_CONTAINER = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl <em>Variable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariableElement()
	 * @generated
	 */
	int VARIABLE_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl <em>Variability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVariability()
	 * @generated
	 */
	int VARIABILITY = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.FeatureConfigurationImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getFeatureConfiguration()
	 * @generated
	 */
	int FEATURE_CONFIGURATION = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionImpl <em>Configuration Decision</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecision()
	 * @generated
	 */
	int CONFIGURATION_DECISION = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.SelectionCriterionImpl <em>Selection Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.SelectionCriterionImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getSelectionCriterion()
	 * @generated
	 */
	int SELECTION_CRITERION = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionFolderImpl
	 * <em>Configuration Decision Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionFolderImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionFolder()
	 * @generated
	 */
	int CONFIGURATION_DECISION_FOLDER = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ContainerConfigurationImpl <em>Container Configuration</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ContainerConfigurationImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getContainerConfiguration()
	 * @generated
	 */
	int CONTAINER_CONFIGURATION = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.PrivateContentImpl <em>Private Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.PrivateContentImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getPrivateContent()
	 * @generated
	 */
	int PRIVATE_CONTENT = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelImpl
	 * <em>Configuration Decision Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionModel()
	 * @generated
	 */
	int CONFIGURATION_DECISION_MODEL = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.InternalBindingImpl <em>Internal Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.InternalBindingImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getInternalBinding()
	 * @generated
	 */
	int INTERNAL_BINDING = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelEntryImpl
	 * <em>Configuration Decision Model Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.ConfigurationDecisionModelEntryImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getConfigurationDecisionModelEntry()
	 * @generated
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Required Binding Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__REQUIRED_BINDING_TIME = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual Binding Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__ACTUAL_BINDING_TIME = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reuse Meta Information</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__REUSE_META_INFORMATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Optional Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__OPTIONAL_ELEMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Variable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ELEMENT_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Information</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__INFORMATION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Reusable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__IS_REUSABLE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reuse Meta Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REUSE_META_INFORMATION_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Internal Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__INTERNAL_BINDING = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variation Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__VARIATION_GROUP = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__BASE_PACKAGE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Configurable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__CONFIGURABLE_ELEMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Public Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER__PUBLIC_FEATURE_MODEL = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Configurable Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_CONTAINER_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__BASE_PACKAGE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL__ROOT_ENTRY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configuration Decision Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__NAME = CONFIGURATION_DECISION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__BASE_PACKAGE = CONFIGURATION_DECISION_MODEL__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__BASE_CLASS = CONFIGURATION_DECISION_MODEL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Root Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING__ROOT_ENTRY = CONFIGURATION_DECISION_MODEL__ROOT_ENTRY;

	/**
	 * The number of structural features of the '<em>Internal Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_BINDING_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY__IS_ACTIVE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configuration Decision Model Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Configurable Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__CONFIGURABLE_CONTAINER = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__CONFIGURATION = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Product Feature Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__PRODUCT_FEATURE_MODEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Decision Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__DECISION_MODEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Variable Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY__VARIABLE_ELEMENT = ElementsPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Variability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__NAME = CONFIGURATION_DECISION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__BASE_PACKAGE = CONFIGURATION_DECISION_MODEL__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__BASE_CLASS = CONFIGURATION_DECISION_MODEL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Root Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__ROOT_ENTRY = CONFIGURATION_DECISION_MODEL__ROOT_ENTRY;

	/**
	 * The feature id for the '<em><b>Configured Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.variability.impl.VehicleLevelBindingImpl <em>Vehicle Level Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VehicleLevelBindingImpl
	 * @see org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl#getVehicleLevelBinding()
	 * @generated
	 */
	int VEHICLE_LEVEL_BINDING = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__NAME = CONFIGURATION_DECISION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__BASE_PACKAGE = CONFIGURATION_DECISION_MODEL__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__BASE_CLASS = CONFIGURATION_DECISION_MODEL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Root Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__ROOT_ENTRY = CONFIGURATION_DECISION_MODEL__ROOT_ENTRY;

	/**
	 * The feature id for the '<em><b>Source Vehicle Feature Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__SOURCE_VEHICLE_FEATURE_MODEL = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Feature Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING__TARGET_FEATURE_MODEL = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Vehicle Level Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_BINDING_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__NAME = CONFIGURATION_DECISION_MODEL_ENTRY__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL_ENTRY__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL_ENTRY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__IS_ACTIVE = CONFIGURATION_DECISION_MODEL_ENTRY__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__BASE_CLASS = CONFIGURATION_DECISION_MODEL_ENTRY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__EFFECT = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__CRITERION = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Equivalence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__IS_EQUIVALENCE = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__TARGET = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Selection Criterion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION__SELECTION_CRITERION = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Configuration Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION__SOURCE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Selection Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SELECTION_CRITERION_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__NAME = CONFIGURATION_DECISION_MODEL_ENTRY__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL_ENTRY__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL_ENTRY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__IS_ACTIVE = CONFIGURATION_DECISION_MODEL_ENTRY__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__BASE_CLASS = CONFIGURATION_DECISION_MODEL_ENTRY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Child Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER__CHILD_ENTRY = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configuration Decision Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DECISION_FOLDER_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__NAME = CONFIGURATION_DECISION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__BASE_NAMED_ELEMENT = CONFIGURATION_DECISION_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__OWNED_COMMENT = CONFIGURATION_DECISION_MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__BASE_PACKAGE = CONFIGURATION_DECISION_MODEL__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__BASE_CLASS = CONFIGURATION_DECISION_MODEL__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Root Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__ROOT_ENTRY = CONFIGURATION_DECISION_MODEL__ROOT_ENTRY;

	/**
	 * The feature id for the '<em><b>Configured Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_DECISION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Private Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT__PRIVATE_ELEMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Private Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIVATE_CONTENT_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer <em>Configurable Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configurable Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer
	 * @generated
	 */
	EClass getConfigurableContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getConfigurableElement
	 * <em>Configurable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Configurable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getConfigurableElement()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_ConfigurableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getInternalBinding
	 * <em>Internal Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Internal Binding</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getInternalBinding()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_InternalBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getPublicFeatureModel
	 * <em>Public Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Public Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getPublicFeatureModel()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_PublicFeatureModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getVariationGroup
	 * <em>Variation Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variation Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getVariationGroup()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_VariationGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Class()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Package()
	 * @see #getConfigurableContainer()
	 * @generated
	 */
	EReference getConfigurableContainer_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision <em>Configuration Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Decision</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision
	 * @generated
	 */
	EClass getConfigurationDecision();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getCriterion
	 * <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Criterion</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getCriterion()
	 * @see #getConfigurationDecision()
	 * @generated
	 */
	EAttribute getConfigurationDecision_Criterion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Effect</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getEffect()
	 * @see #getConfigurationDecision()
	 * @generated
	 */
	EAttribute getConfigurationDecision_Effect();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#isIsEquivalence
	 * <em>Is Equivalence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Equivalence</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#isIsEquivalence()
	 * @see #getConfigurationDecision()
	 * @generated
	 */
	EAttribute getConfigurationDecision_IsEquivalence();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getSelectionCriterion
	 * <em>Selection Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Selection Criterion</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getSelectionCriterion()
	 * @see #getConfigurationDecision()
	 * @generated
	 */
	EReference getConfigurationDecision_SelectionCriterion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getTarget <em>Target</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getTarget()
	 * @see #getConfigurationDecision()
	 * @generated
	 */
	EReference getConfigurationDecision_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder
	 * <em>Configuration Decision Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Decision Folder</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder
	 * @generated
	 */
	EClass getConfigurationDecisionFolder();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder#getChildEntry
	 * <em>Child Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Child Entry</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder#getChildEntry()
	 * @see #getConfigurationDecisionFolder()
	 * @generated
	 */
	EReference getConfigurationDecisionFolder_ChildEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel
	 * <em>Configuration Decision Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Decision Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel
	 * @generated
	 */
	EClass getConfigurationDecisionModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Package()
	 * @see #getConfigurationDecisionModel()
	 * @generated
	 */
	EReference getConfigurationDecisionModel_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Class()
	 * @see #getConfigurationDecisionModel()
	 * @generated
	 */
	EReference getConfigurationDecisionModel_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getRootEntry
	 * <em>Root Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Root Entry</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getRootEntry()
	 * @see #getConfigurationDecisionModel()
	 * @generated
	 */
	EReference getConfigurationDecisionModel_RootEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry
	 * <em>Configuration Decision Model Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Decision Model Entry</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry
	 * @generated
	 */
	EClass getConfigurationDecisionModelEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry#isIsActive
	 * <em>Is Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Active</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry#isIsActive()
	 * @see #getConfigurationDecisionModelEntry()
	 * @generated
	 */
	EAttribute getConfigurationDecisionModelEntry_IsActive();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry#getBase_Class()
	 * @see #getConfigurationDecisionModelEntry()
	 * @generated
	 */
	EReference getConfigurationDecisionModelEntry_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ContainerConfiguration <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Container Configuration</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ContainerConfiguration
	 * @generated
	 */
	EClass getContainerConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ContainerConfiguration#getConfiguredContainer
	 * <em>Configured Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Configured Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ContainerConfiguration#getConfiguredContainer()
	 * @see #getContainerConfiguration()
	 * @generated
	 */
	EReference getContainerConfiguration_ConfiguredContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature Configuration</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.FeatureConfiguration
	 * @generated
	 */
	EClass getFeatureConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration#getConfiguredFeatureModel
	 * <em>Configured Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Configured Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.FeatureConfiguration#getConfiguredFeatureModel()
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
	EReference getFeatureConfiguration_ConfiguredFeatureModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding <em>Vehicle Level Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Vehicle Level Binding</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding
	 * @generated
	 */
	EClass getVehicleLevelBinding();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getSourceVehicleFeatureModel <em>Source Vehicle Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Source Vehicle Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getSourceVehicleFeatureModel()
	 * @see #getVehicleLevelBinding()
	 * @generated
	 */
	EReference getVehicleLevelBinding_SourceVehicleFeatureModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getTargetFeatureModel
	 * <em>Target Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Target Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getTargetFeatureModel()
	 * @see #getVehicleLevelBinding()
	 * @generated
	 */
	EReference getVehicleLevelBinding_TargetFeatureModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.InternalBinding <em>Internal Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Internal Binding</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.InternalBinding
	 * @generated
	 */
	EClass getInternalBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.PrivateContent <em>Private Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Private Content</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.PrivateContent
	 * @generated
	 */
	EClass getPrivateContent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.PrivateContent#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.PrivateContent#getBase_Class()
	 * @see #getPrivateContent()
	 * @generated
	 */
	EReference getPrivateContent_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.PrivateContent#getPrivateElement
	 * <em>Private Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Private Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.PrivateContent#getPrivateElement()
	 * @see #getPrivateContent()
	 * @generated
	 */
	EReference getPrivateContent_PrivateElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation <em>Reuse Meta Information</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reuse Meta Information</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation
	 * @generated
	 */
	EClass getReuseMetaInformation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getInformation
	 * <em>Information</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Information</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getInformation()
	 * @see #getReuseMetaInformation()
	 * @generated
	 */
	EAttribute getReuseMetaInformation_Information();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#isIsReusable
	 * <em>Is Reusable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Reusable</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#isIsReusable()
	 * @see #getReuseMetaInformation()
	 * @generated
	 */
	EAttribute getReuseMetaInformation_IsReusable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getBase_Class()
	 * @see #getReuseMetaInformation()
	 * @generated
	 */
	EReference getReuseMetaInformation_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.SelectionCriterion <em>Selection Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Selection Criterion</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.SelectionCriterion
	 * @generated
	 */
	EClass getSelectionCriterion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.SelectionCriterion#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.SelectionCriterion#getSource()
	 * @see #getSelectionCriterion()
	 * @generated
	 */
	EReference getSelectionCriterion_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.SelectionCriterion#getBase_Class <em>Base Class</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.SelectionCriterion#getBase_Class()
	 * @see #getSelectionCriterion()
	 * @generated
	 */
	EReference getSelectionCriterion_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.Variability <em>Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variability</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability
	 * @generated
	 */
	EClass getVariability();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getBase_Class()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getBase_Package()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.Variability#getConfigurableContainer
	 * <em>Configurable Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Configurable Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getConfigurableContainer()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_ConfigurableContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.Variability#getConfiguration
	 * <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getConfiguration()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_Configuration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.Variability#getDecisionModel
	 * <em>Decision Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Decision Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getDecisionModel()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_DecisionModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.Variability#getProductFeatureModel
	 * <em>Product Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Product Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getProductFeatureModel()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_ProductFeatureModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.Variability#getVariableElement
	 * <em>Variable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability#getVariableElement()
	 * @see #getVariability()
	 * @generated
	 */
	EReference getVariability_VariableElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariabilityFactory getVariabilityFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.VariableElement <em>Variable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement
	 * @generated
	 */
	EClass getVariableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getActualBindingTime
	 * <em>Actual Binding Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Actual Binding Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement#getActualBindingTime()
	 * @see #getVariableElement()
	 * @generated
	 */
	EReference getVariableElement_ActualBindingTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getOptionalElement
	 * <em>Optional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Optional Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement#getOptionalElement()
	 * @see #getVariableElement()
	 * @generated
	 */
	EReference getVariableElement_OptionalElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement#getBase_Class()
	 * @see #getVariableElement()
	 * @generated
	 */
	EReference getVariableElement_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getRequiredBindingTime
	 * <em>Required Binding Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Required Binding Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement#getRequiredBindingTime()
	 * @see #getVariableElement()
	 * @generated
	 */
	EReference getVariableElement_RequiredBindingTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariableElement#getReuseMetaInformation
	 * <em>Reuse Meta Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Reuse Meta Information</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement#getReuseMetaInformation()
	 * @see #getVariableElement()
	 * @generated
	 */
	EReference getVariableElement_ReuseMetaInformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup <em>Variation Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variation Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup
	 * @generated
	 */
	EClass getVariationGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup#getConstraint()
	 * @see #getVariationGroup()
	 * @generated
	 */
	EAttribute getVariationGroup_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup#getKind()
	 * @see #getVariationGroup()
	 * @generated
	 */
	EAttribute getVariationGroup_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup#getBase_Class()
	 * @see #getVariationGroup()
	 * @generated
	 */
	EReference getVariationGroup_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getVariableElement
	 * <em>Variable Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup#getVariableElement()
	 * @see #getVariationGroup()
	 * @generated
	 */
	EReference getVariationGroup_VariableElement();

} // VariabilityPackage
