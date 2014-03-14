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
package org.eclipse.papyrus.eastadl.dependability;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Dependability of a system is the ability to avoid service failures that are more frequent and more severe than is acceptable. Dependability
 * includes several aspects, namely Availability, Reliability, Safety, Integrity and Maintainability. The Dependability package includes support for
 * defining and classifying safety requirements through preliminary Hazard Analysis Risk Assessment, tracing and categorizing safety requirements
 * according to role in safety life-cycle, formalizing safety requirements using safety constraints, formalizing and assessing fault propagation
 * through error models and organizing evidence of safety in a Safety Case.
 * The support for safety is designed to support the automotive standard for Functional Safety, ISO/DIS 26262.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityFactory
 * @model kind="package"
 * @generated
 */
public interface DependabilityPackage extends EPackage {

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl <em>Hazardous Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getHazardousEvent()
		 * @generated
		 */
		EClass HAZARDOUS_EVENT = eINSTANCE.getHazardousEvent();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__BASE_CLASS = eINSTANCE.getHazardousEvent_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Controllability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HAZARDOUS_EVENT__CONTROLLABILITY = eINSTANCE.getHazardousEvent_Controllability();

		/**
		 * The meta object literal for the '<em><b>Exposure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HAZARDOUS_EVENT__EXPOSURE = eINSTANCE.getHazardousEvent_Exposure();

		/**
		 * The meta object literal for the '<em><b>Hazard Classification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HAZARDOUS_EVENT__HAZARD_CLASSIFICATION = eINSTANCE.getHazardousEvent_HazardClassification();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HAZARDOUS_EVENT__SEVERITY = eINSTANCE.getHazardousEvent_Severity();

		/**
		 * The meta object literal for the '<em><b>Classification Assumptions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS = eINSTANCE.getHazardousEvent_ClassificationAssumptions();

		/**
		 * The meta object literal for the '<em><b>Hazard</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__HAZARD = eINSTANCE.getHazardousEvent_Hazard();

		/**
		 * The meta object literal for the '<em><b>Traffic</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__TRAFFIC = eINSTANCE.getHazardousEvent_Traffic();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__ENVIRONMENT = eINSTANCE.getHazardousEvent_Environment();

		/**
		 * The meta object literal for the '<em><b>Operational Situation Use Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE = eINSTANCE.getHazardousEvent_OperationalSituationUseCase();

		/**
		 * The meta object literal for the '<em><b>Operating Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__OPERATING_MODE = eINSTANCE.getHazardousEvent_OperatingMode();

		/**
		 * The meta object literal for the '<em><b>External Measures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARDOUS_EVENT__EXTERNAL_MEASURES = eINSTANCE.getHazardousEvent_ExternalMeasures();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardImpl <em>Hazard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.HazardImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getHazard()
		 * @generated
		 */
		EClass HAZARD = eINSTANCE.getHazard();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARD__BASE_CLASS = eINSTANCE.getHazard_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Malfunction</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARD__MALFUNCTION = eINSTANCE.getHazard_Malfunction();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HAZARD__ITEM = eINSTANCE.getHazard_Item();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.FeatureFlawImpl <em>Feature Flaw</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.FeatureFlawImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getFeatureFlaw()
		 * @generated
		 */
		EClass FEATURE_FLAW = eINSTANCE.getFeatureFlaw();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_FLAW__BASE_CLASS = eINSTANCE.getFeatureFlaw_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_FLAW__ITEM = eINSTANCE.getFeatureFlaw_Item();

		/**
		 * The meta object literal for the '<em><b>Non Fulfilled Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_FLAW__NON_FULFILLED_REQUIREMENT = eINSTANCE.getFeatureFlaw_NonFulfilledRequirement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITEM__BASE_CLASS = eINSTANCE.getItem_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Development Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITEM__DEVELOPMENT_CATEGORY = eINSTANCE.getItem_DevelopmentCategory();

		/**
		 * The meta object literal for the '<em><b>Vehicle Feature</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITEM__VEHICLE_FEATURE = eINSTANCE.getItem_VehicleFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl <em>Dependability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getDependability()
		 * @generated
		 */
		EClass DEPENDABILITY = eINSTANCE.getDependability();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__BASE_CLASS = eINSTANCE.getDependability_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__BASE_PACKAGE = eINSTANCE.getDependability_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Functional Safety Concept</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT = eINSTANCE.getDependability_FunctionalSafetyConcept();

		/**
		 * The meta object literal for the '<em><b>Safety Goal</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__SAFETY_GOAL = eINSTANCE.getDependability_SafetyGoal();

		/**
		 * The meta object literal for the '<em><b>Technical Safety Concept</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT = eINSTANCE.getDependability_TechnicalSafetyConcept();

		/**
		 * The meta object literal for the '<em><b>Hazardous Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__HAZARDOUS_EVENT = eINSTANCE.getDependability_HazardousEvent();

		/**
		 * The meta object literal for the '<em><b>Feature Flaw</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__FEATURE_FLAW = eINSTANCE.getDependability_FeatureFlaw();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__ITEM = eINSTANCE.getDependability_Item();

		/**
		 * The meta object literal for the '<em><b>EA Datatype</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__EA_DATATYPE = eINSTANCE.getDependability_EADatatype();

		/**
		 * The meta object literal for the '<em><b>Fault Failure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__FAULT_FAILURE = eINSTANCE.getDependability_FaultFailure();

		/**
		 * The meta object literal for the '<em><b>Quantitative Safety Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT = eINSTANCE.getDependability_QuantitativeSafetyConstraint();

		/**
		 * The meta object literal for the '<em><b>Safety Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__SAFETY_CONSTRAINT = eINSTANCE.getDependability_SafetyConstraint();

		/**
		 * The meta object literal for the '<em><b>Safety Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__SAFETY_CASE = eINSTANCE.getDependability_SafetyCase();

		/**
		 * The meta object literal for the '<em><b>Error Model Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDABILITY__ERROR_MODEL_TYPE = eINSTANCE.getDependability_ErrorModelType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
		 * <em>Controllability Class Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getControllabilityClassKind()
		 * @generated
		 */
		EEnum CONTROLLABILITY_CLASS_KIND = eINSTANCE.getControllabilityClassKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.ExposureClassKind <em>Exposure Class Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.ExposureClassKind
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getExposureClassKind()
		 * @generated
		 */
		EEnum EXPOSURE_CLASS_KIND = eINSTANCE.getExposureClassKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.SeverityClassKind <em>Severity Class Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.SeverityClassKind
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getSeverityClassKind()
		 * @generated
		 */
		EEnum SEVERITY_CLASS_KIND = eINSTANCE.getSeverityClassKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
		 * <em>Development Category Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
		 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getDevelopmentCategoryKind()
		 * @generated
		 */
		EEnum DEVELOPMENT_CATEGORY_KIND = eINSTANCE.getDevelopmentCategoryKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "dependability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Dependability/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Dependability";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DependabilityPackage eINSTANCE = org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl.init();


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl <em>Hazardous Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.HazardousEventImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getHazardousEvent()
	 * @generated
	 */
	int HAZARDOUS_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Controllability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__CONTROLLABILITY = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exposure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__EXPOSURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hazard Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__HAZARD_CLASSIFICATION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__SEVERITY = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Classification Assumptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__CLASSIFICATION_ASSUMPTIONS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hazard</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__HAZARD = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Traffic</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__TRAFFIC = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__ENVIRONMENT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Operational Situation Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__OPERATIONAL_SITUATION_USE_CASE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Operating Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__OPERATING_MODE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>External Measures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT__EXTERNAL_MEASURES = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Hazardous Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARDOUS_EVENT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.HazardImpl <em>Hazard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.HazardImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getHazard()
	 * @generated
	 */
	int HAZARD = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Malfunction</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__MALFUNCTION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD__ITEM = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hazard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HAZARD_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.FeatureFlawImpl <em>Feature Flaw</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.FeatureFlawImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getFeatureFlaw()
	 * @generated
	 */
	int FEATURE_FLAW = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__ITEM = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Non Fulfilled Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW__NON_FULFILLED_REQUIREMENT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature Flaw</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FLAW_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Development Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__DEVELOPMENT_CATEGORY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Vehicle Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM__VEHICLE_FEATURE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl <em>Dependability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getDependability()
	 * @generated
	 */
	int DEPENDABILITY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functional Safety Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Safety Goal</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__SAFETY_GOAL = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Technical Safety Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hazardous Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__HAZARDOUS_EVENT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Feature Flaw</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__FEATURE_FLAW = ElementsPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__ITEM = ElementsPackage.CONTEXT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EA Datatype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__EA_DATATYPE = ElementsPackage.CONTEXT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Fault Failure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__FAULT_FAILURE = ElementsPackage.CONTEXT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Quantitative Safety Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT = ElementsPackage.CONTEXT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Safety Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__SAFETY_CONSTRAINT = ElementsPackage.CONTEXT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Safety Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__SAFETY_CASE = ElementsPackage.CONTEXT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Error Model Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY__ERROR_MODEL_TYPE = ElementsPackage.CONTEXT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Dependability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDABILITY_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind <em>Controllability Class Kind</em>}'
	 * enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getControllabilityClassKind()
	 * @generated
	 */
	int CONTROLLABILITY_CLASS_KIND = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.ExposureClassKind <em>Exposure Class Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.ExposureClassKind
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getExposureClassKind()
	 * @generated
	 */
	int EXPOSURE_CLASS_KIND = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.SeverityClassKind <em>Severity Class Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.SeverityClassKind
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getSeverityClassKind()
	 * @generated
	 */
	int SEVERITY_CLASS_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind <em>Development Category Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
	 * @see org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl#getDevelopmentCategoryKind()
	 * @generated
	 */
	int DEVELOPMENT_CATEGORY_KIND = 8;

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
	 * <em>Controllability Class Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Controllability Class Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.ControllabilityClassKind
	 * @generated
	 */
	EEnum getControllabilityClassKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.Dependability <em>Dependability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dependability</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability
	 * @generated
	 */
	EClass getDependability();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Class()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Package()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getErrorModelType
	 * <em>Error Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Error Model Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getErrorModelType()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_ErrorModelType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFaultFailure
	 * <em>Fault Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Fault Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getFaultFailure()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_FaultFailure();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFeatureFlaw
	 * <em>Feature Flaw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Feature Flaw</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getFeatureFlaw()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_FeatureFlaw();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFunctionalSafetyConcept
	 * <em>Functional Safety Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Functional Safety Concept</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getFunctionalSafetyConcept()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_FunctionalSafetyConcept();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getHazardousEvent
	 * <em>Hazardous Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hazardous Event</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getHazardousEvent()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_HazardousEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Item</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getItem()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_Item();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getEADatatype
	 * <em>EA Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>EA Datatype</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getEADatatype()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_EADatatype();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getQuantitativeSafetyConstraint
	 * <em>Quantitative Safety Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Quantitative Safety Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getQuantitativeSafetyConstraint()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_QuantitativeSafetyConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyCase
	 * <em>Safety Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Safety Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyCase()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_SafetyCase();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyConstraint
	 * <em>Safety Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Safety Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyConstraint()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_SafetyConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyGoal
	 * <em>Safety Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Safety Goal</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyGoal()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_SafetyGoal();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getTechnicalSafetyConcept
	 * <em>Technical Safety Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Technical Safety Concept</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Dependability#getTechnicalSafetyConcept()
	 * @see #getDependability()
	 * @generated
	 */
	EReference getDependability_TechnicalSafetyConcept();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DependabilityFactory getDependabilityFactory();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind <em>Development Category Kind</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Development Category Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind
	 * @generated
	 */
	EEnum getDevelopmentCategoryKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.ExposureClassKind <em>Exposure Class Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Exposure Class Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.ExposureClassKind
	 * @generated
	 */
	EEnum getExposureClassKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.FeatureFlaw <em>Feature Flaw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature Flaw</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.FeatureFlaw
	 * @generated
	 */
	EClass getFeatureFlaw();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getBase_Class()
	 * @see #getFeatureFlaw()
	 * @generated
	 */
	EReference getFeatureFlaw_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Item</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getItem()
	 * @see #getFeatureFlaw()
	 * @generated
	 */
	EReference getFeatureFlaw_Item();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getNonFulfilledRequirement
	 * <em>Non Fulfilled Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Non Fulfilled Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.FeatureFlaw#getNonFulfilledRequirement()
	 * @see #getFeatureFlaw()
	 * @generated
	 */
	EReference getFeatureFlaw_NonFulfilledRequirement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.Hazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hazard</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Hazard
	 * @generated
	 */
	EClass getHazard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.Hazard#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Hazard#getBase_Class()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Hazard#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Item</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Hazard#getItem()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Item();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Hazard#getMalfunction <em>Malfunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Malfunction</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Hazard#getMalfunction()
	 * @see #getHazard()
	 * @generated
	 */
	EReference getHazard_Malfunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent <em>Hazardous Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hazardous Event</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent
	 * @generated
	 */
	EClass getHazardousEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getBase_Class()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getClassificationAssumptions
	 * <em>Classification Assumptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Classification Assumptions</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getClassificationAssumptions()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EAttribute getHazardousEvent_ClassificationAssumptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getControllability
	 * <em>Controllability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Controllability</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getControllability()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EAttribute getHazardousEvent_Controllability();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getEnvironment
	 * <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Environment</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getEnvironment()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_Environment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExposure <em>Exposure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exposure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExposure()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EAttribute getHazardousEvent_Exposure();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExternalMeasures
	 * <em>External Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>External Measures</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getExternalMeasures()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_ExternalMeasures();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazard <em>Hazard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hazard</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazard()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_Hazard();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazardClassification
	 * <em>Hazard Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hazard Classification</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getHazardClassification()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EAttribute getHazardousEvent_HazardClassification();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperatingMode
	 * <em>Operating Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Operating Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperatingMode()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_OperatingMode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperationalSituationUseCase
	 * <em>Operational Situation Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Operational Situation Use Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getOperationalSituationUseCase()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_OperationalSituationUseCase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getSeverity()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EAttribute getHazardousEvent_Severity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getTraffic <em>Traffic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Traffic</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.HazardousEvent#getTraffic()
	 * @see #getHazardousEvent()
	 * @generated
	 */
	EReference getHazardousEvent_Traffic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.Item#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Item#getBase_Class()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.Item#getDevelopmentCategory
	 * <em>Development Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Development Category</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Item#getDevelopmentCategory()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_DevelopmentCategory();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.Item#getVehicleFeature
	 * <em>Vehicle Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vehicle Feature</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.Item#getVehicleFeature()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_VehicleFeature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.SeverityClassKind <em>Severity Class Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Severity Class Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.SeverityClassKind
	 * @generated
	 */
	EEnum getSeverityClassKind();

} //DependabilityPackage
