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
package org.eclipse.papyrus.eastadl.annex.needs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsFactory
 * @model kind="package"
 * @generated
 */
public interface NeedsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl <em>Stakeholder Need</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getStakeholderNeed()
		 * @generated
		 */
		EClass STAKEHOLDER_NEED = eINSTANCE.getStakeholderNeed();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER_NEED__BASE_CLASS = eINSTANCE.getStakeholderNeed_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Need</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STAKEHOLDER_NEED__NEED = eINSTANCE.getStakeholderNeed_Need();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STAKEHOLDER_NEED__PRIORITY = eINSTANCE.getStakeholderNeed_Priority();

		/**
		 * The meta object literal for the '<em><b>Stake Holder</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER_NEED__STAKE_HOLDER = eINSTANCE.getStakeholderNeed_StakeHolder();

		/**
		 * The meta object literal for the '<em><b>Problem Statement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER_NEED__PROBLEM_STATEMENT = eINSTANCE.getStakeholderNeed_ProblemStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getProblemStatement()
		 * @generated
		 */
		EClass PROBLEM_STATEMENT = eINSTANCE.getProblemStatement();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_STATEMENT__BASE_CLASS = eINSTANCE.getProblemStatement_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Affects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_STATEMENT__AFFECTS = eINSTANCE.getProblemStatement_Affects();

		/**
		 * The meta object literal for the '<em><b>Impact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_STATEMENT__IMPACT = eINSTANCE.getProblemStatement_Impact();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_STATEMENT__PROBLEM = eINSTANCE.getProblemStatement_Problem();

		/**
		 * The meta object literal for the '<em><b>Solution Benefits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_STATEMENT__SOLUTION_BENEFITS = eINSTANCE.getProblemStatement_SolutionBenefits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl <em>Product Positioning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getProductPositioning()
		 * @generated
		 */
		EClass PRODUCT_POSITIONING = eINSTANCE.getProductPositioning();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_POSITIONING__BASE_CLASS = eINSTANCE.getProductPositioning_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Driving Needs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_POSITIONING__DRIVING_NEEDS = eINSTANCE.getProductPositioning_DrivingNeeds();

		/**
		 * The meta object literal for the '<em><b>Key Capabilities</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_POSITIONING__KEY_CAPABILITIES = eINSTANCE.getProductPositioning_KeyCapabilities();

		/**
		 * The meta object literal for the '<em><b>Primary Competitive Alternative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE = eINSTANCE.getProductPositioning_PrimaryCompetitiveAlternative();

		/**
		 * The meta object literal for the '<em><b>Primary Differentiation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION = eINSTANCE.getProductPositioning_PrimaryDifferentiation();

		/**
		 * The meta object literal for the '<em><b>Target Customers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_POSITIONING__TARGET_CUSTOMERS = eINSTANCE.getProductPositioning_TargetCustomers();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl <em>Business Opportunity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getBusinessOpportunity()
		 * @generated
		 */
		EClass BUSINESS_OPPORTUNITY = eINSTANCE.getBusinessOpportunity();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_OPPORTUNITY__BASE_CLASS = eINSTANCE.getBusinessOpportunity_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Problem Statement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT = eINSTANCE.getBusinessOpportunity_ProblemStatement();

		/**
		 * The meta object literal for the '<em><b>Product Positioning</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING = eINSTANCE.getBusinessOpportunity_ProductPositioning();

		/**
		 * The meta object literal for the '<em><b>Business Opportunity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY = eINSTANCE.getBusinessOpportunity_BusinessOpportunity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ConceptImpl <em>Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ConceptImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getConcept()
		 * @generated
		 */
		EClass CONCEPT = eINSTANCE.getConcept();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.MissionImpl <em>Mission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.MissionImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getMission()
		 * @generated
		 */
		EClass MISSION = eINSTANCE.getMission();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.VehicleSystemImpl <em>Vehicle System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.VehicleSystemImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getVehicleSystem()
		 * @generated
		 */
		EClass VEHICLE_SYSTEM = eINSTANCE.getVehicleSystem();

		/**
		 * The meta object literal for the '<em><b>Fulfills</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE_SYSTEM__FULFILLS = eINSTANCE.getVehicleSystem_Fulfills();

		/**
		 * The meta object literal for the '<em><b>Has An</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE_SYSTEM__HAS_AN = eINSTANCE.getVehicleSystem_HasAn();

		/**
		 * The meta object literal for the '<em><b>Has</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE_SYSTEM__HAS = eINSTANCE.getVehicleSystem_Has();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitectureImpl <em>Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitectureImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecture()
		 * @generated
		 */
		EClass ARCHITECTURE = eINSTANCE.getArchitecture();

		/**
		 * The meta object literal for the '<em><b>Described By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__DESCRIBED_BY = eINSTANCE.getArchitecture_DescribedBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl <em>Architectural Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecturalDescription()
		 * @generated
		 */
		EClass ARCHITECTURAL_DESCRIPTION = eINSTANCE.getArchitecturalDescription();

		/**
		 * The meta object literal for the '<em><b>Aggregates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL_DESCRIPTION__AGGREGATES = eINSTANCE.getArchitecturalDescription_Aggregates();

		/**
		 * The meta object literal for the '<em><b>Identifies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL_DESCRIPTION__IDENTIFIES = eINSTANCE.getArchitecturalDescription_Identifies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalModelImpl <em>Architectural Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalModelImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecturalModel()
		 * @generated
		 */
		EClass ARCHITECTURAL_MODEL = eINSTANCE.getArchitecturalModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderImpl <em>Stakeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderImpl
		 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getStakeholder()
		 * @generated
		 */
		EClass STAKEHOLDER = eINSTANCE.getStakeholder();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__BASE_CLASS = eINSTANCE.getStakeholder_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Responsibilities</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STAKEHOLDER__RESPONSIBILITIES = eINSTANCE.getStakeholder_Responsibilities();

		/**
		 * The meta object literal for the '<em><b>Success Criteria</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STAKEHOLDER__SUCCESS_CRITERIA = eINSTANCE.getStakeholder_SuccessCriteria();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "needs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Annex/Needs/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Needs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NeedsPackage eINSTANCE = org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl <em>Stakeholder Need</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderNeedImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getStakeholderNeed()
	 * @generated
	 */
	int STAKEHOLDER_NEED = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getProblemStatement()
	 * @generated
	 */
	int PROBLEM_STATEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl <em>Product Positioning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getProductPositioning()
	 * @generated
	 */
	int PRODUCT_POSITIONING = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl <em>Business Opportunity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getBusinessOpportunity()
	 * @generated
	 */
	int BUSINESS_OPPORTUNITY = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ConceptImpl <em>Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ConceptImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getConcept()
	 * @generated
	 */
	int CONCEPT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.MissionImpl <em>Mission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.MissionImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getMission()
	 * @generated
	 */
	int MISSION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitectureImpl <em>Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitectureImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecture()
	 * @generated
	 */
	int ARCHITECTURE = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl <em>Architectural Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalDescriptionImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecturalDescription()
	 * @generated
	 */
	int ARCHITECTURAL_DESCRIPTION = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalModelImpl <em>Architectural Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitecturalModelImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getArchitecturalModel()
	 * @generated
	 */
	int ARCHITECTURAL_MODEL = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderImpl <em>Stakeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.StakeholderImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getStakeholder()
	 * @generated
	 */
	int STAKEHOLDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Responsibilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__RESPONSIBILITIES = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Success Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__SUCCESS_CRITERIA = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;


	/**
	 * The number of structural features of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Need</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__NEED = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__PRIORITY = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stake Holder</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__STAKE_HOLDER = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Problem Statement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED__PROBLEM_STATEMENT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Stakeholder Need</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_NEED_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__AFFECTS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__IMPACT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__PROBLEM = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Solution Benefits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT__SOLUTION_BENEFITS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Problem Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_STATEMENT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Driving Needs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__DRIVING_NEEDS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Capabilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__KEY_CAPABILITIES = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Primary Competitive Alternative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Primary Differentiation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Customers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING__TARGET_CUSTOMERS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Product Positioning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_POSITIONING_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Problem Statement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Product Positioning</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Business Opportunity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Business Opportunity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPPORTUNITY_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__BASE_NAMED_ELEMENT = CONCEPT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__OWNED_COMMENT = CONCEPT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Mission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.annex.needs.impl.VehicleSystemImpl <em>Vehicle System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.VehicleSystemImpl
	 * @see org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl#getVehicleSystem()
	 * @generated
	 */
	int VEHICLE_SYSTEM = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__BASE_NAMED_ELEMENT = CONCEPT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__OWNED_COMMENT = CONCEPT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Fulfills</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__FULFILLS = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has An</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__HAS_AN = CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM__HAS = CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Vehicle System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_SYSTEM_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__BASE_NAMED_ELEMENT = CONCEPT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__OWNED_COMMENT = CONCEPT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__DESCRIBED_BY = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION__BASE_NAMED_ELEMENT = CONCEPT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION__OWNED_COMMENT = CONCEPT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Aggregates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION__AGGREGATES = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION__IDENTIFIES = CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Architectural Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DESCRIPTION_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_MODEL__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_MODEL__BASE_NAMED_ELEMENT = CONCEPT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_MODEL__OWNED_COMMENT = CONCEPT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Architectural Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_MODEL_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription <em>Architectural Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architectural Description</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription
	 * @generated
	 */
	EClass getArchitecturalDescription();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getAggregates <em>Aggregates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Aggregates</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getAggregates()
	 * @see #getArchitecturalDescription()
	 * @generated
	 */
	EReference getArchitecturalDescription_Aggregates();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getIdentifies <em>Identifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifies</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getIdentifies()
	 * @see #getArchitecturalDescription()
	 * @generated
	 */
	EReference getArchitecturalDescription_Identifies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalModel <em>Architectural Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architectural Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalModel
	 * @generated
	 */
	EClass getArchitecturalModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Architecture
	 * @generated
	 */
	EClass getArchitecture();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.Architecture#getDescribedBy <em>Described By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Described By</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Architecture#getDescribedBy()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_DescribedBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity <em>Business Opportunity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Opportunity</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity
	 * @generated
	 */
	EClass getBusinessOpportunity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBase_Class()
	 * @see #getBusinessOpportunity()
	 * @generated
	 */
	EReference getBusinessOpportunity_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBusinessOpportunity <em>Business Opportunity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Business Opportunity</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBusinessOpportunity()
	 * @see #getBusinessOpportunity()
	 * @generated
	 */
	EAttribute getBusinessOpportunity_BusinessOpportunity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProblemStatement <em>Problem Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Problem Statement</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProblemStatement()
	 * @see #getBusinessOpportunity()
	 * @generated
	 */
	EReference getBusinessOpportunity_ProblemStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProductPositioning <em>Product Positioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Product Positioning</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProductPositioning()
	 * @see #getBusinessOpportunity()
	 * @generated
	 */
	EReference getBusinessOpportunity_ProductPositioning();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Concept
	 * @generated
	 */
	EClass getConcept();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.Mission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Mission
	 * @generated
	 */
	EClass getMission();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NeedsFactory getNeedsFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement <em>Problem Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Statement</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement
	 * @generated
	 */
	EClass getProblemStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getBase_Class()
	 * @see #getProblemStatement()
	 * @generated
	 */
	EReference getProblemStatement_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affects</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getAffects()
	 * @see #getProblemStatement()
	 * @generated
	 */
	EReference getProblemStatement_Affects();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getImpact <em>Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Impact</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getImpact()
	 * @see #getProblemStatement()
	 * @generated
	 */
	EAttribute getProblemStatement_Impact();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Problem</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getProblem()
	 * @see #getProblemStatement()
	 * @generated
	 */
	EAttribute getProblemStatement_Problem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getSolutionBenefits <em>Solution Benefits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solution Benefits</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getSolutionBenefits()
	 * @see #getProblemStatement()
	 * @generated
	 */
	EAttribute getProblemStatement_SolutionBenefits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning <em>Product Positioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Positioning</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning
	 * @generated
	 */
	EClass getProductPositioning();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getBase_Class()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EReference getProductPositioning_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getDrivingNeeds <em>Driving Needs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driving Needs</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getDrivingNeeds()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EAttribute getProductPositioning_DrivingNeeds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getKeyCapabilities <em>Key Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Capabilities</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getKeyCapabilities()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EAttribute getProductPositioning_KeyCapabilities();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryCompetitiveAlternative <em>Primary Competitive Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Competitive Alternative</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryCompetitiveAlternative()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EAttribute getProductPositioning_PrimaryCompetitiveAlternative();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryDifferentiation <em>Primary Differentiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Differentiation</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryDifferentiation()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EAttribute getProductPositioning_PrimaryDifferentiation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getTargetCustomers <em>Target Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Customers</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getTargetCustomers()
	 * @see #getProductPositioning()
	 * @generated
	 */
	EAttribute getProductPositioning_TargetCustomers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Stakeholder
	 * @generated
	 */
	EClass getStakeholder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getBase_Class()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getResponsibilities <em>Responsibilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Responsibilities</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getResponsibilities()
	 * @see #getStakeholder()
	 * @generated
	 */
	EAttribute getStakeholder_Responsibilities();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getSuccessCriteria <em>Success Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Criteria</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getSuccessCriteria()
	 * @see #getStakeholder()
	 * @generated
	 */
	EAttribute getStakeholder_SuccessCriteria();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed <em>Stakeholder Need</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder Need</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed
	 * @generated
	 */
	EClass getStakeholderNeed();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getBase_Class()
	 * @see #getStakeholderNeed()
	 * @generated
	 */
	EReference getStakeholderNeed_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getNeed <em>Need</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Need</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getNeed()
	 * @see #getStakeholderNeed()
	 * @generated
	 */
	EAttribute getStakeholderNeed_Need();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getPriority()
	 * @see #getStakeholderNeed()
	 * @generated
	 */
	EAttribute getStakeholderNeed_Priority();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getProblemStatement <em>Problem Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Problem Statement</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getProblemStatement()
	 * @see #getStakeholderNeed()
	 * @generated
	 */
	EReference getStakeholderNeed_ProblemStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getStakeHolder <em>Stake Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stake Holder</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getStakeHolder()
	 * @see #getStakeholderNeed()
	 * @generated
	 */
	EReference getStakeholderNeed_StakeHolder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem <em>Vehicle System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle System</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem
	 * @generated
	 */
	EClass getVehicleSystem();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getFulfills <em>Fulfills</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fulfills</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getFulfills()
	 * @see #getVehicleSystem()
	 * @generated
	 */
	EReference getVehicleSystem_Fulfills();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHas()
	 * @see #getVehicleSystem()
	 * @generated
	 */
	EReference getVehicleSystem_Has();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHasAn <em>Has An</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has An</em>'.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHasAn()
	 * @see #getVehicleSystem()
	 * @generated
	 */
	EReference getVehicleSystem_HasAn();

} //NeedsPackage
