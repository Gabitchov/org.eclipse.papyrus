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
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;


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
 * This subprofile defines a set of stereotypes concerning the definition of safety requirements inked to ISO26262 norm.
 * 
 * Overview:
 * This subprofile defines a set of stereotypes concerning the definition of safety requirements linked to the ISO26262 norm.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementFactory
 * @model kind="package"
 * @generated
 */
public interface SafetyrequirementPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.FunctionalSafetyConceptImpl
		 * <em>Functional Safety Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.FunctionalSafetyConceptImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getFunctionalSafetyConcept()
		 * @generated
		 */
		EClass FUNCTIONAL_SAFETY_CONCEPT = eINSTANCE.getFunctionalSafetyConcept();

		/**
		 * The meta object literal for the '<em><b>Functional Safety Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTIONAL_SAFETY_CONCEPT__FUNCTIONAL_SAFETY_REQUIREMENT = eINSTANCE.getFunctionalSafetyConcept_FunctionalSafetyRequirement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl
		 * <em>Safety Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getSafetyGoal()
		 * @generated
		 */
		EClass SAFETY_GOAL = eINSTANCE.getSafetyGoal();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_GOAL__DERIVED_FROM = eINSTANCE.getSafetyGoal_DerivedFrom();

		/**
		 * The meta object literal for the '<em><b>Safe States</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SAFETY_GOAL__SAFE_STATES = eINSTANCE.getSafetyGoal_SafeStates();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_GOAL__BASE_CLASS = eINSTANCE.getSafetyGoal_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_GOAL__REQUIREMENT = eINSTANCE.getSafetyGoal_Requirement();

		/**
		 * The meta object literal for the '<em><b>Hazard Classification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SAFETY_GOAL__HAZARD_CLASSIFICATION = eINSTANCE.getSafetyGoal_HazardClassification();

		/**
		 * The meta object literal for the '<em><b>Safe Modes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_GOAL__SAFE_MODES = eINSTANCE.getSafetyGoal_SafeModes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.TechnicalSafetyConceptImpl
		 * <em>Technical Safety Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.TechnicalSafetyConceptImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getTechnicalSafetyConcept()
		 * @generated
		 */
		EClass TECHNICAL_SAFETY_CONCEPT = eINSTANCE.getTechnicalSafetyConcept();

		/**
		 * The meta object literal for the '<em><b>Technical Safety Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT = eINSTANCE.getTechnicalSafetyConcept_TechnicalSafetyRequirement();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "safetyrequirement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Dependability/SafetyRequirement/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "SafetyRequirement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SafetyrequirementPackage eINSTANCE = org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.FunctionalSafetyConceptImpl
	 * <em>Functional Safety Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.FunctionalSafetyConceptImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getFunctionalSafetyConcept()
	 * @generated
	 */
	int FUNCTIONAL_SAFETY_CONCEPT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__NAME = RequirementsPackage.REQUIREMENTS_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__BASE_NAMED_ELEMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__OWNED_COMMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__BASE_PACKAGEABLE_ELEMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__NOTE = RequirementsPackage.REQUIREMENTS_CONTAINER__NOTE;

	/**
	 * The feature id for the '<em><b>Child Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__CHILD_CONTAINER = RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER;

	/**
	 * The feature id for the '<em><b>Parent Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__PARENT_CONTAINER = RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__BASE_CLASS = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__BASE_PACKAGE = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Contained Req Spec Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__CONTAINED_REQ_SPEC_OBJECT = RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT;

	/**
	 * The feature id for the '<em><b>Functional Safety Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT__FUNCTIONAL_SAFETY_REQUIREMENT = RequirementsPackage.REQUIREMENTS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Functional Safety Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_SAFETY_CONCEPT_FEATURE_COUNT = RequirementsPackage.REQUIREMENTS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl <em>Safety Goal</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getSafetyGoal()
	 * @generated
	 */
	int SAFETY_GOAL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__DERIVED_FROM = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Safe States</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__SAFE_STATES = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__REQUIREMENT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hazard Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__HAZARD_CLASSIFICATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Safe Modes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL__SAFE_MODES = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Safety Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_GOAL_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.TechnicalSafetyConceptImpl
	 * <em>Technical Safety Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.TechnicalSafetyConceptImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl#getTechnicalSafetyConcept()
	 * @generated
	 */
	int TECHNICAL_SAFETY_CONCEPT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__NAME = RequirementsPackage.REQUIREMENTS_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__BASE_NAMED_ELEMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__OWNED_COMMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__BASE_PACKAGEABLE_ELEMENT = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__NOTE = RequirementsPackage.REQUIREMENTS_CONTAINER__NOTE;

	/**
	 * The feature id for the '<em><b>Child Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__CHILD_CONTAINER = RequirementsPackage.REQUIREMENTS_CONTAINER__CHILD_CONTAINER;

	/**
	 * The feature id for the '<em><b>Parent Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__PARENT_CONTAINER = RequirementsPackage.REQUIREMENTS_CONTAINER__PARENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__BASE_CLASS = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__BASE_PACKAGE = RequirementsPackage.REQUIREMENTS_CONTAINER__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Contained Req Spec Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__CONTAINED_REQ_SPEC_OBJECT = RequirementsPackage.REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT;

	/**
	 * The feature id for the '<em><b>Technical Safety Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT = RequirementsPackage.REQUIREMENTS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Technical Safety Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TECHNICAL_SAFETY_CONCEPT_FEATURE_COUNT = RequirementsPackage.REQUIREMENTS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept
	 * <em>Functional Safety Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Functional Safety Concept</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept
	 * @generated
	 */
	EClass getFunctionalSafetyConcept();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept#getFunctionalSafetyRequirement
	 * <em>Functional Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Functional Safety Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept#getFunctionalSafetyRequirement()
	 * @see #getFunctionalSafetyConcept()
	 * @generated
	 */
	EReference getFunctionalSafetyConcept_FunctionalSafetyRequirement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal <em>Safety Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Safety Goal</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal
	 * @generated
	 */
	EClass getSafetyGoal();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getDerivedFrom
	 * <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getDerivedFrom()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_DerivedFrom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getHazardClassification <em>Hazard Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hazard Classification</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getHazardClassification()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EAttribute getSafetyGoal_HazardClassification();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getRequirement
	 * <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getRequirement()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_Requirement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeModes
	 * <em>Safe Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Safe Modes</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeModes()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_SafeModes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeStates
	 * <em>Safe States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Safe States</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeStates()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EAttribute getSafetyGoal_SafeStates();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getBase_Class()
	 * @see #getSafetyGoal()
	 * @generated
	 */
	EReference getSafetyGoal_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SafetyrequirementFactory getSafetyrequirementFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept
	 * <em>Technical Safety Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Technical Safety Concept</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept
	 * @generated
	 */
	EClass getTechnicalSafetyConcept();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept#getTechnicalSafetyRequirement
	 * <em>Technical Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Technical Safety Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept#getTechnicalSafetyRequirement()
	 * @see #getTechnicalSafetyConcept()
	 * @generated
	 */
	EReference getTechnicalSafetyConcept_TechnicalSafetyRequirement();

} //SafetyrequirementPackage
