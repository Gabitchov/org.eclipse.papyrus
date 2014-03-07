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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation;

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
 * A multitude of different verification and validation (V&V) techniques, methods and tools are applied during the development of EE-Systems.
 * Different techniques are applicable at different abstraction levels. Also, the technique of choice depends on the properties to validate and/or
 * verify. Furthermore, each partner in a project may develop and employ his own V&V processes and activities. Hence it is impossible to introduce in
 * the EAST-ADL2 a way to model all the objects that can be required by all the possible V&V techniques. As a consequence, EAST-ADL2 furnishes just
 * the means for planning, organizing and describing V&V activities on a fairly abstract level, and for defining the links between those V&V
 * activities, the satisfied and verified requirements, and the objects modeling the system (Functional Analysis Architecture, Functional components,
 * Logical Tasks, etc.). The common parts of all V&V techniques are described by the EAST-ADL2, which includes: the results expected from the V&V
 * activities, the actual results which were obtained when applying the V&V techniques, how the V&V activities are constrained. Information that is
 * specific to an individual V&V technique is not described in EAST-ADL2, but a place for storing this information is provided.
 * 
 * Single V&V techniques may be used only once or at several stages during an overall V&V effort. Some of them are specific to one modeling design
 * stage; others can be applied at various design stages.
 * 
 * A set of V&V techniques and activities is necessary in order to achieve a complete verification and validation of a given system. Often these
 * techniques and activities are employed and performed by many different teams and departments, frequently even by different companies. This raises
 * the demand for an overall planning and organization of all V&V related information.
 * 
 * A very important notion of V&V support in EAST-ADL2 is the distinction of abstract and concrete V&V information:
 * 
 * (1) On the abstract level, verification and validation information is defined without referring to a concrete testing environment and without
 * specifying stimuli and the expected outcome of a particular VVProcedure on a detailed technical level.
 * 
 * (2) On the concrete level, verification and validation information specifies a concrete testing environment and provides all necessary details for
 * testing, e.g. stimuli and expected outcomes, on a concrete technical level applicable to that testing environment.
 * 
 * In accordance to the "what vs. how" definition of requirements one could say: the abstract level defines what needs to be done to verify and
 * validate a certain system, but not precisely how this is done. Conversely, the concrete level defines the precise technical details for particular
 * testing environments. So all abstract VVCases and VVProcedures for a certain system together form sort of a "to-do"-list, which describes what
 * needs to be done when actually testing the system with a concrete testing environment, but in a form applicable to all conceivable testing
 * environments to all conceivable testing environments.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationFactory
 * @model kind="package"
 * @generated
 */
public interface VerificationvalidationPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVStimuliImpl
		 * <em>VV Stimuli</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVStimuliImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVStimuli()
		 * @generated
		 */
		EClass VV_STIMULI = eINSTANCE.getVVStimuli();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_STIMULI__BASE_CLASS = eINSTANCE.getVVStimuli_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVIntendedOutcomeImpl
		 * <em>VV Intended Outcome</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVIntendedOutcomeImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVIntendedOutcome()
		 * @generated
		 */
		EClass VV_INTENDED_OUTCOME = eINSTANCE.getVVIntendedOutcome();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_INTENDED_OUTCOME__BASE_CLASS = eINSTANCE.getVVIntendedOutcome_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVTargetImpl
		 * <em>VV Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVTargetImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVTarget()
		 * @generated
		 */
		EClass VV_TARGET = eINSTANCE.getVVTarget();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_TARGET__BASE_CLASS = eINSTANCE.getVVTarget_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_TARGET__ELEMENT = eINSTANCE.getVVTarget_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVLogImpl <em>VV Log</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVLogImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVLog()
		 * @generated
		 */
		EClass VV_LOG = eINSTANCE.getVVLog();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VV_LOG__DATE = eINSTANCE.getVVLog_Date();

		/**
		 * The meta object literal for the '<em><b>Performed VV Procedure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_LOG__PERFORMED_VV_PROCEDURE = eINSTANCE.getVVLog_PerformedVVProcedure();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl
		 * <em>Verification Validation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVerificationValidation()
		 * @generated
		 */
		EClass VERIFICATION_VALIDATION = eINSTANCE.getVerificationValidation();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFICATION_VALIDATION__BASE_CLASS = eINSTANCE.getVerificationValidation_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFICATION_VALIDATION__BASE_PACKAGE = eINSTANCE.getVerificationValidation_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Verify</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFICATION_VALIDATION__VERIFY = eINSTANCE.getVerificationValidation_Verify();

		/**
		 * The meta object literal for the '<em><b>Vv Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFICATION_VALIDATION__VV_CASE = eINSTANCE.getVerificationValidation_VvCase();

		/**
		 * The meta object literal for the '<em><b>Vv Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFICATION_VALIDATION__VV_TARGET = eINSTANCE.getVerificationValidation_VvTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl <em>Verify</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVerify()
		 * @generated
		 */
		EClass VERIFY = eINSTANCE.getVerify();

		/**
		 * The meta object literal for the '<em><b>Verified By Procedure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFY__VERIFIED_BY_PROCEDURE = eINSTANCE.getVerify_VerifiedByProcedure();

		/**
		 * The meta object literal for the '<em><b>Verified By Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFY__VERIFIED_BY_CASE = eINSTANCE.getVerify_VerifiedByCase();

		/**
		 * The meta object literal for the '<em><b>Verified Requirement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERIFY__VERIFIED_REQUIREMENT = eINSTANCE.getVerify_VerifiedRequirement();

		/**
		 * The meta object literal for the '<em><b>Vv Actual Outcome</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_LOG__VV_ACTUAL_OUTCOME = eINSTANCE.getVVLog_VvActualOutcome();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_LOG__BASE_CLASS = eINSTANCE.getVVLog_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVActualOutcomeImpl
		 * <em>VV Actual Outcome</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVActualOutcomeImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVActualOutcome()
		 * @generated
		 */
		EClass VV_ACTUAL_OUTCOME = eINSTANCE.getVVActualOutcome();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_ACTUAL_OUTCOME__BASE_CLASS = eINSTANCE.getVVActualOutcome_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Intended Outcome</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_ACTUAL_OUTCOME__INTENDED_OUTCOME = eINSTANCE.getVVActualOutcome_IntendedOutcome();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl <em>VV Case</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVCase()
		 * @generated
		 */
		EClass VV_CASE = eINSTANCE.getVVCase();

		/**
		 * The meta object literal for the '<em><b>Vv Procedure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__VV_PROCEDURE = eINSTANCE.getVVCase_VvProcedure();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__BASE_CLASS = eINSTANCE.getVVCase_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Vv Case</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__VV_CASE = eINSTANCE.getVVCase_VvCase();

		/**
		 * The meta object literal for the '<em><b>Abstract VV Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__ABSTRACT_VV_CASE = eINSTANCE.getVVCase_AbstractVVCase();

		/**
		 * The meta object literal for the '<em><b>Vv Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__VV_TARGET = eINSTANCE.getVVCase_VvTarget();

		/**
		 * The meta object literal for the '<em><b>Vv Subject</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__VV_SUBJECT = eINSTANCE.getVVCase_VvSubject();

		/**
		 * The meta object literal for the '<em><b>Vv Log</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_CASE__VV_LOG = eINSTANCE.getVVCase_VvLog();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl
		 * <em>VV Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl
		 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVProcedure()
		 * @generated
		 */
		EClass VV_PROCEDURE = eINSTANCE.getVVProcedure();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_PROCEDURE__BASE_CLASS = eINSTANCE.getVVProcedure_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Abstract VV Procedure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_PROCEDURE__ABSTRACT_VV_PROCEDURE = eINSTANCE.getVVProcedure_AbstractVVProcedure();

		/**
		 * The meta object literal for the '<em><b>Concrete VV Procedure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_PROCEDURE__CONCRETE_VV_PROCEDURE = eINSTANCE.getVVProcedure_ConcreteVVProcedure();

		/**
		 * The meta object literal for the '<em><b>Vv Intended Outcome</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_PROCEDURE__VV_INTENDED_OUTCOME = eINSTANCE.getVVProcedure_VvIntendedOutcome();

		/**
		 * The meta object literal for the '<em><b>Vv Stimuli</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VV_PROCEDURE__VV_STIMULI = eINSTANCE.getVVProcedure_VvStimuli();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "verificationvalidation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Requirements/VerificationValidation/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "VerificationValidation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	VerificationvalidationPackage eINSTANCE = org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVStimuliImpl <em>VV Stimuli</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVStimuliImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVStimuli()
	 * @generated
	 */
	int VV_STIMULI = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VV Stimuli</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_STIMULI_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVIntendedOutcomeImpl
	 * <em>VV Intended Outcome</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVIntendedOutcomeImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVIntendedOutcome()
	 * @generated
	 */
	int VV_INTENDED_OUTCOME = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VV Intended Outcome</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_INTENDED_OUTCOME_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVTargetImpl <em>VV Target</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVTargetImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVTarget()
	 * @generated
	 */
	int VV_TARGET = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVLogImpl <em>VV Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVLogImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVLog()
	 * @generated
	 */
	int VV_LOG = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVActualOutcomeImpl
	 * <em>VV Actual Outcome</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVActualOutcomeImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVActualOutcome()
	 * @generated
	 */
	int VV_ACTUAL_OUTCOME = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl
	 * <em>Verification Validation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationValidationImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVerificationValidation()
	 * @generated
	 */
	int VERIFICATION_VALIDATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Intended Outcome</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME__INTENDED_OUTCOME = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VV Actual Outcome</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_ACTUAL_OUTCOME_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl <em>VV Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVCase()
	 * @generated
	 */
	int VV_CASE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vv Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__VV_CASE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract VV Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__ABSTRACT_VV_CASE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vv Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__VV_TARGET = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vv Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__VV_SUBJECT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vv Log</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__VV_LOG = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Vv Procedure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE__VV_PROCEDURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>VV Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_CASE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl <em>VV Procedure</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVVProcedure()
	 * @generated
	 */
	int VV_PROCEDURE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET__ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VV Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_TARGET_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__DATE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vv Actual Outcome</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__VV_ACTUAL_OUTCOME = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Performed VV Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG__PERFORMED_VV_PROCEDURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>VV Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_LOG_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract VV Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__ABSTRACT_VV_PROCEDURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Concrete VV Procedure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__CONCRETE_VV_PROCEDURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vv Intended Outcome</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__VV_INTENDED_OUTCOME = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vv Stimuli</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE__VV_STIMULI = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>VV Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VV_PROCEDURE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__VERIFY = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vv Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__VV_CASE = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vv Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION__VV_TARGET = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Verification Validation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_VALIDATION_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl <em>Verify</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl#getVerify()
	 * @generated
	 */
	int VERIFY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__NAME = RequirementsPackage.REQUIREMENTS_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__BASE_NAMED_ELEMENT = RequirementsPackage.REQUIREMENTS_RELATIONSHIP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__OWNED_COMMENT = RequirementsPackage.REQUIREMENTS_RELATIONSHIP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__BASE_CLASS = RequirementsPackage.REQUIREMENTS_RELATIONSHIP__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__BASE_ABSTRACTION = RequirementsPackage.REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Verified By Procedure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__VERIFIED_BY_PROCEDURE = RequirementsPackage.REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verified By Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__VERIFIED_BY_CASE = RequirementsPackage.REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Verified Requirement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__VERIFIED_REQUIREMENT = RequirementsPackage.REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Verify</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY_FEATURE_COUNT = RequirementsPackage.REQUIREMENTS_RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli <em>VV Stimuli</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Stimuli</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli
	 * @generated
	 */
	EClass getVVStimuli();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli#getBase_Class()
	 * @see #getVVStimuli()
	 * @generated
	 */
	EReference getVVStimuli_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome
	 * <em>VV Intended Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Intended Outcome</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome
	 * @generated
	 */
	EClass getVVIntendedOutcome();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome#getBase_Class()
	 * @see #getVVIntendedOutcome()
	 * @generated
	 */
	EReference getVVIntendedOutcome_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome
	 * <em>VV Actual Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Actual Outcome</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome
	 * @generated
	 */
	EClass getVVActualOutcome();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome#getBase_Class()
	 * @see #getVVActualOutcome()
	 * @generated
	 */
	EReference getVVActualOutcome_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome#getIntendedOutcome <em>Intended Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Intended Outcome</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome#getIntendedOutcome()
	 * @see #getVVActualOutcome()
	 * @generated
	 */
	EReference getVVActualOutcome_IntendedOutcome();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase <em>VV Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase
	 * @generated
	 */
	EClass getVVCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getBase_Class()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvCase
	 * <em>Vv Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvCase()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_VvCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getAbstractVVCase
	 * <em>Abstract VV Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Abstract VV Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getAbstractVVCase()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_AbstractVVCase();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvTarget
	 * <em>Vv Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvTarget()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_VvTarget();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvSubject
	 * <em>Vv Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Subject</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvSubject()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_VvSubject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvLog
	 * <em>Vv Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Log</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvLog()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_VvLog();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvProcedure
	 * <em>Vv Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvProcedure()
	 * @see #getVVCase()
	 * @generated
	 */
	EReference getVVCase_VvProcedure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget <em>VV Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget
	 * @generated
	 */
	EClass getVVTarget();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget#getBase_Class()
	 * @see #getVVTarget()
	 * @generated
	 */
	EReference getVVTarget_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget#getElement
	 * <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget#getElement()
	 * @see #getVVTarget()
	 * @generated
	 */
	EReference getVVTarget_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog <em>VV Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Log</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog
	 * @generated
	 */
	EClass getVVLog();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getDate <em>Date</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getDate()
	 * @see #getVVLog()
	 * @generated
	 */
	EAttribute getVVLog_Date();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getVvActualOutcome <em>Vv Actual Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Actual Outcome</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getVvActualOutcome()
	 * @see #getVVLog()
	 * @generated
	 */
	EReference getVVLog_VvActualOutcome();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getBase_Class()
	 * @see #getVVLog()
	 * @generated
	 */
	EReference getVVLog_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getPerformedVVProcedure <em>Performed VV Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Performed VV Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getPerformedVVProcedure()
	 * @see #getVVLog()
	 * @generated
	 */
	EReference getVVLog_PerformedVVProcedure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure <em>VV Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>VV Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure
	 * @generated
	 */
	EClass getVVProcedure();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getBase_Class()
	 * @see #getVVProcedure()
	 * @generated
	 */
	EReference getVVProcedure_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getAbstractVVProcedure <em>Abstract VV Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Abstract VV Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getAbstractVVProcedure()
	 * @see #getVVProcedure()
	 * @generated
	 */
	EReference getVVProcedure_AbstractVVProcedure();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getConcreteVVProcedure <em>Concrete VV Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Concrete VV Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getConcreteVVProcedure()
	 * @see #getVVProcedure()
	 * @generated
	 */
	EReference getVVProcedure_ConcreteVVProcedure();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getVvIntendedOutcome <em>Vv Intended Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Intended Outcome</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getVvIntendedOutcome()
	 * @see #getVVProcedure()
	 * @generated
	 */
	EReference getVVProcedure_VvIntendedOutcome();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getVvStimuli <em>Vv Stimuli</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Stimuli</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure#getVvStimuli()
	 * @see #getVVProcedure()
	 * @generated
	 */
	EReference getVVProcedure_VvStimuli();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation
	 * <em>Verification Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Verification Validation</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation
	 * @generated
	 */
	EClass getVerificationValidation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getBase_Class()
	 * @see #getVerificationValidation()
	 * @generated
	 */
	EReference getVerificationValidation_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getBase_Package()
	 * @see #getVerificationValidation()
	 * @generated
	 */
	EReference getVerificationValidation_Base_Package();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVerify <em>Verify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verify</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVerify()
	 * @see #getVerificationValidation()
	 * @generated
	 */
	EReference getVerificationValidation_Verify();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVvCase <em>Vv Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVvCase()
	 * @see #getVerificationValidation()
	 * @generated
	 */
	EReference getVerificationValidation_VvCase();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVvTarget <em>Vv Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Vv Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationValidation#getVvTarget()
	 * @see #getVerificationValidation()
	 * @generated
	 */
	EReference getVerificationValidation_VvTarget();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VerificationvalidationFactory getVerificationvalidationFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify <em>Verify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Verify</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify
	 * @generated
	 */
	EClass getVerify();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedByCase <em>Verified By Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verified By Case</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedByCase()
	 * @see #getVerify()
	 * @generated
	 */
	EReference getVerify_VerifiedByCase();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedByProcedure <em>Verified By Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verified By Procedure</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedByProcedure()
	 * @see #getVerify()
	 * @generated
	 */
	EReference getVerify_VerifiedByProcedure();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedRequirement <em>Verified Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verified Requirement</em>'.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify#getVerifiedRequirement()
	 * @see #getVerify()
	 * @generated
	 */
	EReference getVerify_VerifiedRequirement();

} //VerificationvalidationPackage
