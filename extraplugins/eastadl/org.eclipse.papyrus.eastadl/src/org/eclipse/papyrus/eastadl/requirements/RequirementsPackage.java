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
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- end-user-doc --> <!-- begin-model-doc --> Requirements do not constitute an independent view
 * in EAST-ADL2. In a general ADL architecture, requirement entities will be parts of already
 * existing artifacts. The present framework will show several constructs, which could be used, in
 * principle, in any artifact (VFM, FAA, FDA..). Specific constraints on this will be shown in the
 * related sections. A requirement expresses a condition or capability that must be met or possessed
 * by a system or system component to satisfy a contract, standard, specification or other formally
 * imposed properties. Requirements can be introduced in different phases of the development process
 * for different reasons. They could be introduced by marketing people, control engineers, system
 * engineers, software engineers, Driver/OS developers, basic software developers or hardware
 * engineers. This leads to the fact that requirements have many sources, and requirements are of
 * many types (at different level of detail) and have several relations between them. Under these
 * conditions the number of requirements can become quickly unmanageable if appropriate management
 * does not exist. Note that, requirements can change during the project development and the changes
 * should be taken into account. Requirements are organized hierarchically through several kinds of
 * refinement relations. EAST-ADL2 has constructs that deal with these problems. Some of these
 * constructs are constructs that deals with general issues in software development and have been
 * already addressed in the past by general processes, like IBM RUP (IBM Rational Unified Process).
 * Here, RUP will not be intended as a guideline; concepts and definitions from RUP will though be
 * used when useful whereas new ones will be introduced when required. As done for the structure
 * part of EAST-ADL2, the requirements part will be compliant with UML2. The EAST-ADL2 adapts
 * existing concepts whenever possible and develops new ones otherwise. And important source on the
 * level of requirements is the Requirements Interchange Format (RIF). The purpose of the
 * metaclasses in the Requirements domain meta-model package is to specify rigorously ("formally")
 * the Requirements concepts for the specific domain. Support for requirement modeling is provided
 * by the EAST-ADL2 on two levels: a generic level and a specialized level where specialized
 * requirement entities are provided which are intended for certain special uses.
 * 
 * Overview: The set of requirements are decomposed according to various issue of concerns among
 * which timing issues are of acute importance. For timing issues, DelaySegment introduces a generic
 * concept of delay between events occurring on input and output ports. It is further refined in
 * various stereotypes to account for different specialized delays. Timing requirements Other
 * requirements concern design constraints, allocation constraints, or precedence constraints
 * between functions. <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementsPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.QualityRequirementImpl <em>Quality Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.QualityRequirementImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getQualityRequirement()
		 * @generated
		 */
		EClass QUALITY_REQUIREMENT = eINSTANCE.getQualityRequirement();

		/**
		 * The meta object literal for the '<em><b>Quality Requirement Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE = eINSTANCE.getQualityRequirement_QualityRequirementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementSpecificationObjectImpl <em>Requirement Specification Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementSpecificationObjectImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementSpecificationObject()
		 * @generated
		 */
		EClass REQUIREMENT_SPECIFICATION_OBJECT = eINSTANCE.getRequirementSpecificationObject();

		/**
		 * The meta object literal for the '<em><b>Referencing Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER = eINSTANCE.getRequirementSpecificationObject_ReferencingContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsContainer()
		 * @generated
		 */
		EClass REQUIREMENTS_CONTAINER = eINSTANCE.getRequirementsContainer();

		/**
		 * The meta object literal for the '<em><b>Child Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_CONTAINER__CHILD_CONTAINER = eINSTANCE.getRequirementsContainer_ChildContainer();

		/**
		 * The meta object literal for the '<em><b>Parent Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_CONTAINER__PARENT_CONTAINER = eINSTANCE.getRequirementsContainer_ParentContainer();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_CONTAINER__BASE_CLASS = eINSTANCE.getRequirementsContainer_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_CONTAINER__BASE_PACKAGE = eINSTANCE.getRequirementsContainer_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Contained Req Spec Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT = eINSTANCE.getRequirementsContainer_ContainedReqSpecObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelatedInformationImpl <em>Related Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelatedInformationImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelatedInformation()
		 * @generated
		 */
		EClass REQUIREMENTS_RELATED_INFORMATION = eINSTANCE.getRequirementsRelatedInformation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_RELATED_INFORMATION__BASE_CLASS = eINSTANCE.getRequirementsRelatedInformation_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationshipImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelationship()
		 * @generated
		 */
		EClass REQUIREMENTS_RELATIONSHIP = eINSTANCE.getRequirementsRelationship();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_RELATIONSHIP__BASE_CLASS = eINSTANCE.getRequirementsRelationship_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl <em>Satisfy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getSatisfy()
		 * @generated
		 */
		EClass SATISFY = eINSTANCE.getSatisfy();

		/**
		 * The meta object literal for the '<em><b>Satisfied Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SATISFY__SATISFIED_REQUIREMENT = eINSTANCE.getSatisfy_SatisfiedRequirement();

		/**
		 * The meta object literal for the '<em><b>Satisfied By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SATISFY__SATISFIED_BY = eINSTANCE.getSatisfy_SatisfiedBy();

		/**
		 * The meta object literal for the '<em><b>Satisfied Use Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SATISFY__SATISFIED_USE_CASE = eINSTANCE.getSatisfy_SatisfiedUseCase();

		/**
		 * The meta object literal for the '<em><b>Satisfied By path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SATISFY__SATISFIED_BY_PATH = eINSTANCE.getSatisfy_SatisfiedBy_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Base Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__BASE_USE_CASE = eINSTANCE.getUseCase_Base_UseCase();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__INCLUDE = eINSTANCE.getUseCase_Include();

		/**
		 * The meta object literal for the '<em><b>Extend</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__EXTEND = eINSTANCE.getUseCase_Extend();

		/**
		 * The meta object literal for the '<em><b>Extension Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__EXTENSION_POINT = eINSTANCE.getUseCase_ExtensionPoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.IncludeImpl <em>Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.IncludeImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getInclude()
		 * @generated
		 */
		EClass INCLUDE = eINSTANCE.getInclude();

		/**
		 * The meta object literal for the '<em><b>Base Include</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__BASE_INCLUDE = eINSTANCE.getInclude_Base_Include();

		/**
		 * The meta object literal for the '<em><b>Addition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__ADDITION = eINSTANCE.getInclude_Addition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ExtendImpl <em>Extend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.ExtendImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getExtend()
		 * @generated
		 */
		EClass EXTEND = eINSTANCE.getExtend();

		/**
		 * The meta object literal for the '<em><b>Base Extend</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTEND__BASE_EXTEND = eINSTANCE.getExtend_Base_Extend();

		/**
		 * The meta object literal for the '<em><b>Extended Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTEND__EXTENDED_CASE = eINSTANCE.getExtend_ExtendedCase();

		/**
		 * The meta object literal for the '<em><b>Extension Location</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTEND__EXTENSION_LOCATION = eINSTANCE.getExtend_ExtensionLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.ExtensionPointImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getExtensionPoint()
		 * @generated
		 */
		EClass EXTENSION_POINT = eINSTANCE.getExtensionPoint();

		/**
		 * The meta object literal for the '<em><b>Base Extension Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_POINT__BASE_EXTENSION_POINT = eINSTANCE.getExtensionPoint_Base_ExtensionPoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RedefinableElementImpl <em>Redefinable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RedefinableElementImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRedefinableElement()
		 * @generated
		 */
		EClass REDEFINABLE_ELEMENT = eINSTANCE.getRedefinableElement();

		/**
		 * The meta object literal for the '<em><b>Base Redefinable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDEFINABLE_ELEMENT__BASE_REDEFINABLE_ELEMENT = eINSTANCE.getRedefinableElement_Base_RedefinableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RefineImpl <em>Refine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RefineImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRefine()
		 * @generated
		 */
		EClass REFINE = eINSTANCE.getRefine();

		/**
		 * The meta object literal for the '<em><b>Refined Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINE__REFINED_REQUIREMENT = eINSTANCE.getRefine_RefinedRequirement();

		/**
		 * The meta object literal for the '<em><b>Refined By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINE__REFINED_BY = eINSTANCE.getRefine_RefinedBy();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINE__BASE_DEPENDENCY = eINSTANCE.getRefine_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Refined By path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFINE__REFINED_BY_PATH = eINSTANCE.getRefine_RefinedBy_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl <em>Derive Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getDeriveRequirement()
		 * @generated
		 */
		EClass DERIVE_REQUIREMENT = eINSTANCE.getDeriveRequirement();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVE_REQUIREMENT__DERIVED = eINSTANCE.getDeriveRequirement_Derived();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVE_REQUIREMENT__DERIVED_FROM = eINSTANCE.getDeriveRequirement_DerivedFrom();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationGroupImpl <em>Relation Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationGroupImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelationGroup()
		 * @generated
		 */
		EClass REQUIREMENTS_RELATION_GROUP = eINSTANCE.getRequirementsRelationGroup();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_RELATION_GROUP__RELATION = eINSTANCE.getRequirementsRelationGroup_Relation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_RELATION_GROUP__BASE_CLASS = eINSTANCE.getRequirementsRelationGroup_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_RELATION_GROUP__BASE_PACKAGE = eINSTANCE.getRequirementsRelationGroup_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsLinkImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsLink()
		 * @generated
		 */
		EClass REQUIREMENTS_LINK = eINSTANCE.getRequirementsLink();

		/**
		 * The meta object literal for the '<em><b>Is Bidirectional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENTS_LINK__IS_BIDIRECTIONAL = eINSTANCE.getRequirementsLink_IsBidirectional();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_LINK__SOURCE = eINSTANCE.getRequirementsLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_LINK__TARGET = eINSTANCE.getRequirementsLink_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsModel()
		 * @generated
		 */
		EClass REQUIREMENTS_MODEL = eINSTANCE.getRequirementsModel();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_MODEL__USE_CASE = eINSTANCE.getRequirementsModel_UseCase();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_MODEL__REQUIREMENT = eINSTANCE.getRequirementsModel_Requirement();

		/**
		 * The meta object literal for the '<em><b>Requirement Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER = eINSTANCE.getRequirementsModel_RequirementContainer();

		/**
		 * The meta object literal for the '<em><b>Operational Situation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_MODEL__OPERATIONAL_SITUATION = eINSTANCE.getRequirementsModel_OperationalSituation();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENTS_MODEL__BASE_PACKAGE = eINSTANCE.getRequirementsModel_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.OperationalSituationImpl <em>Operational Situation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.OperationalSituationImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getOperationalSituation()
		 * @generated
		 */
		EClass OPERATIONAL_SITUATION = eINSTANCE.getOperationalSituation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONAL_SITUATION__BASE_CLASS = eINSTANCE.getOperationalSituation_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.ActorImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Base Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__BASE_ACTOR = eINSTANCE.getActor_Base_Actor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Formalism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__FORMALISM = eINSTANCE.getRequirement_Formalism();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__URL = eINSTANCE.getRequirement_Url();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__MODE = eINSTANCE.getRequirement_Mode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind <em>Quality Requirement Kind</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind
		 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getQualityRequirementKind()
		 * @generated
		 */
		EEnum QUALITY_REQUIREMENT_KIND = eINSTANCE.getQualityRequirementKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requirements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Requirements/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Requirements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	RequirementsPackage eINSTANCE = org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TEXT = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__TEXT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DERIVED = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__DERIVED;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DERIVED_FROM = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__SATISFIED_BY = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFINED_BY = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Traced To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TRACED_TO = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__TRACED_TO;

	/**
	 * The feature id for the '<em><b>Verified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VERIFIED_BY = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__VERIFIED_BY;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MASTER = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__MASTER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__BASE_CLASS = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__BASE_NAMED_ELEMENT = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__OWNED_COMMENT = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__BASE_PACKAGEABLE_ELEMENT = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NOTE = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referencing Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFERENCING_CONTAINER = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Formalism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__FORMALISM = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__URL = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MODE = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = org.eclipse.papyrus.sysml.requirements.RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.QualityRequirementImpl <em>Quality Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.QualityRequirementImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getQualityRequirement()
	 * @generated
	 */
	int QUALITY_REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__TEXT = REQUIREMENT__TEXT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__DERIVED = REQUIREMENT__DERIVED;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__DERIVED_FROM = REQUIREMENT__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__SATISFIED_BY = REQUIREMENT__SATISFIED_BY;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__REFINED_BY = REQUIREMENT__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Traced To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__TRACED_TO = REQUIREMENT__TRACED_TO;

	/**
	 * The feature id for the '<em><b>Verified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__VERIFIED_BY = REQUIREMENT__VERIFIED_BY;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__MASTER = REQUIREMENT__MASTER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__BASE_CLASS = REQUIREMENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__BASE_NAMED_ELEMENT = REQUIREMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__OWNED_COMMENT = REQUIREMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__BASE_PACKAGEABLE_ELEMENT = REQUIREMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__NOTE = REQUIREMENT__NOTE;

	/**
	 * The feature id for the '<em><b>Referencing Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__REFERENCING_CONTAINER = REQUIREMENT__REFERENCING_CONTAINER;

	/**
	 * The feature id for the '<em><b>Formalism</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__FORMALISM = REQUIREMENT__FORMALISM;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__URL = REQUIREMENT__URL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__MODE = REQUIREMENT__MODE;

	/**
	 * The feature id for the '<em><b>Quality Requirement Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quality Requirement</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUALITY_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementSpecificationObjectImpl <em>Requirement Specification Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementSpecificationObjectImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementSpecificationObject()
	 * @generated
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Referencing Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Requirement Specification Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPECIFICATION_OBJECT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsContainer()
	 * @generated
	 */
	int REQUIREMENTS_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Child Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__CHILD_CONTAINER = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__PARENT_CONTAINER = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__BASE_PACKAGE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contained Req Spec Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER__CONTAINED_REQ_SPEC_OBJECT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_CONTAINER_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelatedInformationImpl <em>Related Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelatedInformationImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelatedInformation()
	 * @generated
	 */
	int REQUIREMENTS_RELATED_INFORMATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__NAME = REQUIREMENT_SPECIFICATION_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__BASE_NAMED_ELEMENT = REQUIREMENT_SPECIFICATION_OBJECT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__OWNED_COMMENT = REQUIREMENT_SPECIFICATION_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__BASE_PACKAGEABLE_ELEMENT = REQUIREMENT_SPECIFICATION_OBJECT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__NOTE = REQUIREMENT_SPECIFICATION_OBJECT__NOTE;

	/**
	 * The feature id for the '<em><b>Referencing Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__REFERENCING_CONTAINER = REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION__BASE_CLASS = REQUIREMENT_SPECIFICATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Related Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATED_INFORMATION_FEATURE_COUNT = REQUIREMENT_SPECIFICATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationshipImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelationship()
	 * @generated
	 */
	int REQUIREMENTS_RELATIONSHIP = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATIONSHIP__NAME = ElementsPackage.RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT = ElementsPackage.RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT = ElementsPackage.RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATIONSHIP__BASE_CLASS = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl <em>Satisfy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getSatisfy()
	 * @generated
	 */
	int SATISFY = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RefineImpl <em>Refine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RefineImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRefine()
	 * @generated
	 */
	int REFINE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl <em>Derive Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getDeriveRequirement()
	 * @generated
	 */
	int DERIVE_REQUIREMENT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__NAME = REQUIREMENTS_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__BASE_NAMED_ELEMENT = REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__OWNED_COMMENT = REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__BASE_CLASS = REQUIREMENTS_RELATIONSHIP__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__BASE_ABSTRACTION = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Satisfied Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__SATISFIED_REQUIREMENT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__SATISFIED_BY = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Satisfied By path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__SATISFIED_BY_PATH = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Satisfied Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY__SATISFIED_USE_CASE = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Satisfy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFY_FEATURE_COUNT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__BASE_USE_CASE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Include</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__INCLUDE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extend</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__EXTEND = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__EXTENSION_POINT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.IncludeImpl <em>Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.IncludeImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getInclude()
	 * @generated
	 */
	int INCLUDE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__NAME = ElementsPackage.RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BASE_NAMED_ELEMENT = ElementsPackage.RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__OWNED_COMMENT = ElementsPackage.RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Include</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__BASE_INCLUDE = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Addition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__ADDITION = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_FEATURE_COUNT = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ExtendImpl <em>Extend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.ExtendImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getExtend()
	 * @generated
	 */
	int EXTEND = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__NAME = ElementsPackage.RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__BASE_NAMED_ELEMENT = ElementsPackage.RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__OWNED_COMMENT = ElementsPackage.RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Extend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__BASE_EXTEND = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__EXTENDED_CASE = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension Location</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND__EXTENSION_LOCATION = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Extend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTEND_FEATURE_COUNT = ElementsPackage.RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RedefinableElementImpl <em>Redefinable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RedefinableElementImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRedefinableElement()
	 * @generated
	 */
	int REDEFINABLE_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Base Redefinable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINABLE_ELEMENT__BASE_REDEFINABLE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Redefinable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDEFINABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.ExtensionPointImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getExtensionPoint()
	 * @generated
	 */
	int EXTENSION_POINT = 10;

	/**
	 * The feature id for the '<em><b>Base Redefinable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT__BASE_REDEFINABLE_ELEMENT = REDEFINABLE_ELEMENT__BASE_REDEFINABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Extension Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT__BASE_EXTENSION_POINT = REDEFINABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extension Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT_FEATURE_COUNT = REDEFINABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__NAME = REQUIREMENTS_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__BASE_NAMED_ELEMENT = REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__OWNED_COMMENT = REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__BASE_CLASS = REQUIREMENTS_RELATIONSHIP__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__BASE_ABSTRACTION = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__REFINED_REQUIREMENT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__REFINED_BY = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__BASE_DEPENDENCY = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refined By path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE__REFINED_BY_PATH = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Refine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINE_FEATURE_COUNT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__NAME = REQUIREMENTS_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__BASE_NAMED_ELEMENT = REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__OWNED_COMMENT = REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__BASE_CLASS = REQUIREMENTS_RELATIONSHIP__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__BASE_ABSTRACTION = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__DERIVED = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT__DERIVED_FROM = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Derive Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQUIREMENT_FEATURE_COUNT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationGroupImpl <em>Relation Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationGroupImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsRelationGroup()
	 * @generated
	 */
	int REQUIREMENTS_RELATION_GROUP = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__RELATION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP__BASE_PACKAGE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_RELATION_GROUP_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsLinkImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsLink()
	 * @generated
	 */
	int REQUIREMENTS_LINK = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__NAME = REQUIREMENTS_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__BASE_NAMED_ELEMENT = REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__OWNED_COMMENT = REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__BASE_CLASS = REQUIREMENTS_RELATIONSHIP__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__IS_BIDIRECTIONAL = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__SOURCE = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK__TARGET = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_LINK_FEATURE_COUNT = REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getRequirementsModel()
	 * @generated
	 */
	int REQUIREMENTS_MODEL = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__USE_CASE = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__REQUIREMENT = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requirement Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operational Situation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__OPERATIONAL_SITUATION = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENTS_MODEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.OperationalSituationImpl <em>Operational Situation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.OperationalSituationImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getOperationalSituation()
	 * @generated
	 */
	int OPERATIONAL_SITUATION = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operational Situation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_SITUATION_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.ActorImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__BASE_ACTOR = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind <em>Quality Requirement Kind</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind
	 * @see org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl#getQualityRequirementKind()
	 * @generated
	 */
	int QUALITY_REQUIREMENT_KIND = 19;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.DeriveRequirement <em>Derive Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derive Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.DeriveRequirement
	 * @generated
	 */
	EClass getDeriveRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.DeriveRequirement#getDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.DeriveRequirement#getDerived()
	 * @see #getDeriveRequirement()
	 * @generated
	 */
	EReference getDeriveRequirement_Derived();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.DeriveRequirement#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.DeriveRequirement#getDerivedFrom()
	 * @see #getDeriveRequirement()
	 * @generated
	 */
	EReference getDeriveRequirement_DerivedFrom();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.OperationalSituation <em>Operational Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operational Situation</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.OperationalSituation
	 * @generated
	 */
	EClass getOperationalSituation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.OperationalSituation#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.OperationalSituation#getBase_Class()
	 * @see #getOperationalSituation()
	 * @generated
	 */
	EReference getOperationalSituation_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Actor#getBase_Actor <em>Base Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Actor</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Actor#getBase_Actor()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Base_Actor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirement <em>Quality Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirement
	 * @generated
	 */
	EClass getQualityRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirement#getQualityRequirementType <em>Quality Requirement Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Requirement Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirement#getQualityRequirementType()
	 * @see #getQualityRequirement()
	 * @generated
	 */
	EAttribute getQualityRequirement_QualityRequirementType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind <em>Quality Requirement Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quality Requirement Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind
	 * @generated
	 */
	EEnum getQualityRequirementKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Refine <em>Refine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refine</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Refine
	 * @generated
	 */
	EClass getRefine();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy <em>Refined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refined By</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy()
	 * @see #getRefine()
	 * @generated
	 */
	EReference getRefine_RefinedBy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Refine#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Refine#getBase_Dependency()
	 * @see #getRefine()
	 * @generated
	 */
	EReference getRefine_Base_Dependency();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy_path <em>Refined By path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refined By path</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedBy_path()
	 * @see #getRefine()
	 * @generated
	 */
	EReference getRefine_RefinedBy_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refined Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Refine#getRefinedRequirement()
	 * @see #getRefine()
	 * @generated
	 */
	EReference getRefine_RefinedRequirement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getFormalism <em>Formalism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formalism</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Requirement#getFormalism()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Formalism();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Requirement#getMode()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Requirement#getUrl()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Url();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer
	 * @generated
	 */
	EClass getRequirementsContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getChildContainer <em>Child Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getChildContainer()
	 * @see #getRequirementsContainer()
	 * @generated
	 */
	EReference getRequirementsContainer_ChildContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getContainedReqSpecObject <em>Contained Req Spec Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contained Req Spec Object</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getContainedReqSpecObject()
	 * @see #getRequirementsContainer()
	 * @generated
	 */
	EReference getRequirementsContainer_ContainedReqSpecObject();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer <em>Parent Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer()
	 * @see #getRequirementsContainer()
	 * @generated
	 */
	EReference getRequirementsContainer_ParentContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Class()
	 * @see #getRequirementsContainer()
	 * @generated
	 */
	EReference getRequirementsContainer_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Package()
	 * @see #getRequirementsContainer()
	 * @generated
	 */
	EReference getRequirementsContainer_Base_Package();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementsFactory getRequirementsFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsLink
	 * @generated
	 */
	EClass getRequirementsLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#isIsBidirectional <em>Is Bidirectional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Bidirectional</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsLink#isIsBidirectional()
	 * @see #getRequirementsLink()
	 * @generated
	 */
	EAttribute getRequirementsLink_IsBidirectional();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getSource()
	 * @see #getRequirementsLink()
	 * @generated
	 */
	EReference getRequirementsLink_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getTarget()
	 * @see #getRequirementsLink()
	 * @generated
	 */
	EReference getRequirementsLink_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel
	 * @generated
	 */
	EClass getRequirementsModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getOperationalSituation <em>Operational Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operational Situation</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getOperationalSituation()
	 * @see #getRequirementsModel()
	 * @generated
	 */
	EReference getRequirementsModel_OperationalSituation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getBase_Package()
	 * @see #getRequirementsModel()
	 * @generated
	 */
	EReference getRequirementsModel_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getRequirement()
	 * @see #getRequirementsModel()
	 * @generated
	 */
	EReference getRequirementsModel_Requirement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getRequirementContainer <em>Requirement Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirement Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getRequirementContainer()
	 * @see #getRequirementsModel()
	 * @generated
	 */
	EReference getRequirementsModel_RequirementContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsModel#getUseCase()
	 * @see #getRequirementsModel()
	 * @generated
	 */
	EReference getRequirementsModel_UseCase();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject <em>Requirement Specification Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Specification Object</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject
	 * @generated
	 */
	EClass getRequirementSpecificationObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject#getReferencingContainer <em>Referencing Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencing Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject#getReferencingContainer()
	 * @see #getRequirementSpecificationObject()
	 * @generated
	 */
	EReference getRequirementSpecificationObject_ReferencingContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelatedInformation <em>Related Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Related Information</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelatedInformation
	 * @generated
	 */
	EClass getRequirementsRelatedInformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelatedInformation#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelatedInformation#getBase_Class()
	 * @see #getRequirementsRelatedInformation()
	 * @generated
	 */
	EReference getRequirementsRelatedInformation_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup <em>Relation Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup
	 * @generated
	 */
	EClass getRequirementsRelationGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relation</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getRelation()
	 * @see #getRequirementsRelationGroup()
	 * @generated
	 */
	EReference getRequirementsRelationGroup_Relation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getBase_Class()
	 * @see #getRequirementsRelationGroup()
	 * @generated
	 */
	EReference getRequirementsRelationGroup_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationGroup#getBase_Package()
	 * @see #getRequirementsRelationGroup()
	 * @generated
	 */
	EReference getRequirementsRelationGroup_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship
	 * @generated
	 */
	EClass getRequirementsRelationship();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship#getBase_Class()
	 * @see #getRequirementsRelationship()
	 * @generated
	 */
	EReference getRequirementsRelationship_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Satisfy <em>Satisfy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Satisfy</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Satisfy
	 * @generated
	 */
	EClass getSatisfy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy <em>Satisfied By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied By</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy()
	 * @see #getSatisfy()
	 * @generated
	 */
	EReference getSatisfy_SatisfiedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy_path <em>Satisfied By path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied By path</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedBy_path()
	 * @see #getSatisfy()
	 * @generated
	 */
	EReference getSatisfy_SatisfiedBy_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.UseCase#getBase_UseCase <em>Base Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Use Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.UseCase#getBase_UseCase()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Base_UseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.requirements.UseCase#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Include</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.UseCase#getInclude()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Include();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.requirements.UseCase#getExtend <em>Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extend</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.UseCase#getExtend()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Extend();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.requirements.UseCase#getExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension Point</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.UseCase#getExtensionPoint()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_ExtensionPoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Include <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Include
	 * @generated
	 */
	EClass getInclude();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Include#getBase_Include <em>Base Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Include</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Include#getBase_Include()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_Base_Include();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Include#getAddition <em>Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Addition</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Include#getAddition()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_Addition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.Extend <em>Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extend</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Extend
	 * @generated
	 */
	EClass getExtend();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Extend#getBase_Extend <em>Base Extend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Extend</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Extend#getBase_Extend()
	 * @see #getExtend()
	 * @generated
	 */
	EReference getExtend_Base_Extend();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.Extend#getExtendedCase <em>Extended Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Extend#getExtendedCase()
	 * @see #getExtend()
	 * @generated
	 */
	EReference getExtend_ExtendedCase();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Extend#getExtensionLocation <em>Extension Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extension Location</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Extend#getExtensionLocation()
	 * @see #getExtend()
	 * @generated
	 */
	EReference getExtend_ExtensionLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Point</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.ExtensionPoint
	 * @generated
	 */
	EClass getExtensionPoint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.ExtensionPoint#getBase_ExtensionPoint <em>Base Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Extension Point</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.ExtensionPoint#getBase_ExtensionPoint()
	 * @see #getExtensionPoint()
	 * @generated
	 */
	EReference getExtensionPoint_Base_ExtensionPoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.RedefinableElement <em>Redefinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redefinable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RedefinableElement
	 * @generated
	 */
	EClass getRedefinableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.RedefinableElement#getBase_RedefinableElement <em>Base Redefinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Redefinable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.RedefinableElement#getBase_RedefinableElement()
	 * @see #getRedefinableElement()
	 * @generated
	 */
	EReference getRedefinableElement_Base_RedefinableElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedRequirement <em>Satisfied Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedRequirement()
	 * @see #getSatisfy()
	 * @generated
	 */
	EReference getSatisfy_SatisfiedRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedUseCase <em>Satisfied Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied Use Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.Satisfy#getSatisfiedUseCase()
	 * @see #getSatisfy()
	 * @generated
	 */
	EReference getSatisfy_SatisfiedUseCase();

} // RequirementsPackage
