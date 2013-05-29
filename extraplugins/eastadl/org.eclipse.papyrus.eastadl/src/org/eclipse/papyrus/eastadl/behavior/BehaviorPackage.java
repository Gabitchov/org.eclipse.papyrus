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
package org.eclipse.papyrus.eastadl.behavior;

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
 * <!-- end-user-doc --> <!-- begin-model-doc --> There are needs for several different forms of
 * behavioral descriptions because of the very different requirements in the various automotive
 * application domains. For these different forms of behavior specifications, varying tools will be
 * used by different automotive companies and suppliers. Therefore a support for legacy tools and
 * legacy models will be provided within the EAST-ADL2. With the introduced concepts it will be
 * possible to connect external behavioral descriptions to EAST-ADL2 elements, e.g. connect it to
 * the respective software function and associate requirements and test cases with it. In addition,
 * a native behavioral notation can be used. This means that the defined behavior is an integrated
 * part of the system model and it is recognized by EAST-ADL2-compliant tools. Note that this
 * chapter only addresses the algorithmic behavior of the EAST-ADL2 structural entities. The timing
 * and synchronization between e.g. ADL functions is part of the structural definition through
 * timing attributes, precedence relations, task allocation, etc. The purpose of the metaclasses in
 * the Behavior subprofile is to specify rigorously ("formally") the Behavior concepts for the
 * specific domain. This section contains a specification for each individual stereotype in the
 * Behavior subprofile.
 * 
 * Overview: The set of stereotypes is deliberately kept minimal. The idea here is to distinguish
 * between externally defined behaviors thanks to some tools such as ASCET or Simulink and natively
 * defined behaviors. The latter are connected to UML::Behavior, so that in principle one can reuse
 * the constructs provided by UML to define native behaviors in EAST-ADL2. Yet as described in the
 * deliverable 3.2 some semantics mismatches may occur. The reader is asked to refer to the results
 * summarized in deliverable 3.2 on behavior modeling.Further investigation is needed here. <!--
 * end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviorPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl <em>Function Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionBehavior()
		 * @generated
		 */
		EClass FUNCTION_BEHAVIOR = eINSTANCE.getFunctionBehavior();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BEHAVIOR__BASE_BEHAVIOR = eINSTANCE.getFunctionBehavior_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BEHAVIOR__PATH = eINSTANCE.getFunctionBehavior_Path();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BEHAVIOR__REPRESENTATION = eINSTANCE.getFunctionBehavior_Representation();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BEHAVIOR__FUNCTION = eINSTANCE.getFunctionBehavior_Function();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BEHAVIOR__MODE = eINSTANCE.getFunctionBehavior_Mode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__BEHAVIOR = eINSTANCE.getBehavior_Behavior();

		/**
		 * The meta object literal for the '<em><b>Function Trigger</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__FUNCTION_TRIGGER = eINSTANCE.getBehavior_FunctionTrigger();

		/**
		 * The meta object literal for the '<em><b>Mode Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__MODE_GROUP = eINSTANCE.getBehavior_ModeGroup();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__BASE_PACKAGE = eINSTANCE.getBehavior_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__BASE_CLASS = eINSTANCE.getBehavior_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionTriggerImpl <em>Function Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.FunctionTriggerImpl
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionTrigger()
		 * @generated
		 */
		EClass FUNCTION_TRIGGER = eINSTANCE.getFunctionTrigger();

		/**
		 * The meta object literal for the '<em><b>Trigger Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_TRIGGER__TRIGGER_CONDITION = eINSTANCE.getFunctionTrigger_TriggerCondition();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TRIGGER__BASE_CLASS = eINSTANCE.getFunctionTrigger_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Trigger Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_TRIGGER__TRIGGER_POLICY = eINSTANCE.getFunctionTrigger_TriggerPolicy();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TRIGGER__MODE = eINSTANCE.getFunctionTrigger_Mode();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TRIGGER__FUNCTION = eINSTANCE.getFunctionTrigger_Function();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TRIGGER__PORT = eINSTANCE.getFunctionTrigger_Port();

		/**
		 * The meta object literal for the '<em><b>Function Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TRIGGER__FUNCTION_PROTOTYPE = eINSTANCE.getFunctionTrigger_FunctionPrototype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.ModeGroupImpl <em>Mode Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.ModeGroupImpl
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getModeGroup()
		 * @generated
		 */
		EClass MODE_GROUP = eINSTANCE.getModeGroup();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE_GROUP__PRECONDITION = eINSTANCE.getModeGroup_Precondition();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_GROUP__MODE = eINSTANCE.getModeGroup_Mode();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_GROUP__BASE_CLASS = eINSTANCE.getModeGroup_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.ModeImpl <em>Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.ModeImpl
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getMode()
		 * @generated
		 */
		EClass MODE = eINSTANCE.getMode();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE__CONDITION = eINSTANCE.getMode_Condition();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE__BASE_CLASS = eINSTANCE.getMode_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind <em>Function Behavior Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionBehaviorKind()
		 * @generated
		 */
		EEnum FUNCTION_BEHAVIOR_KIND = eINSTANCE.getFunctionBehaviorKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind <em>Trigger Policy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind
		 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getTriggerPolicyKind()
		 * @generated
		 */
		EEnum TRIGGER_POLICY_KIND = eINSTANCE.getTriggerPolicyKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "behavior";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Behavior/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Behavior";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorPackage eINSTANCE = org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl <em>Function Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionBehavior()
	 * @generated
	 */
	int FUNCTION_BEHAVIOR = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionTriggerImpl <em>Function Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.FunctionTriggerImpl
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionTrigger()
	 * @generated
	 */
	int FUNCTION_TRIGGER = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.ModeGroupImpl <em>Mode Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.ModeGroupImpl
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getModeGroup()
	 * @generated
	 */
	int MODE_GROUP = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.impl.ModeImpl <em>Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.ModeImpl
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getMode()
	 * @generated
	 */
	int MODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__BASE_BEHAVIOR = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__PATH = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__REPRESENTATION = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__MODE = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR__FUNCTION = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Function Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BEHAVIOR_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__CONDITION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__FUNCTION_TRIGGER = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mode Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__MODE_GROUP = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Trigger Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__TRIGGER_CONDITION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Trigger Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__TRIGGER_POLICY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__MODE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__FUNCTION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Function Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER__FUNCTION_PROTOTYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Function Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TRIGGER_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__PRECONDITION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__MODE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mode Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_GROUP_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind <em>Function Behavior Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getFunctionBehaviorKind()
	 * @generated
	 */
	int FUNCTION_BEHAVIOR_KIND = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind <em>Trigger Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind
	 * @see org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl#getTriggerPolicyKind()
	 * @generated
	 */
	int TRIGGER_POLICY_KIND = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.behavior.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior#getBehavior()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Behavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getFunctionTrigger <em>Function Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Trigger</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior#getFunctionTrigger()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_FunctionTrigger();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getModeGroup <em>Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior#getModeGroup()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_ModeGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Package()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Behavior#getBase_Class()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BehaviorFactory getBehaviorFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior <em>Function Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior
	 * @generated
	 */
	EClass getFunctionBehavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getBase_Behavior()
	 * @see #getFunctionBehavior()
	 * @generated
	 */
	EReference getFunctionBehavior_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getFunction()
	 * @see #getFunctionBehavior()
	 * @generated
	 */
	EReference getFunctionBehavior_Function();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getMode()
	 * @see #getFunctionBehavior()
	 * @generated
	 */
	EReference getFunctionBehavior_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getPath()
	 * @see #getFunctionBehavior()
	 * @generated
	 */
	EAttribute getFunctionBehavior_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Representation</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehavior#getRepresentation()
	 * @see #getFunctionBehavior()
	 * @generated
	 */
	EAttribute getFunctionBehavior_Representation();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind <em>Function Behavior Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Function Behavior Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind
	 * @generated
	 */
	EEnum getFunctionBehaviorKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger <em>Function Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Trigger</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger
	 * @generated
	 */
	EClass getFunctionTrigger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunction()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EReference getFunctionTrigger_Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunctionPrototype <em>Function Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getFunctionPrototype()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EReference getFunctionTrigger_FunctionPrototype();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getMode()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EReference getFunctionTrigger_Mode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getPort()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EReference getFunctionTrigger_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerCondition <em>Trigger Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Condition</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerCondition()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EAttribute getFunctionTrigger_TriggerCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getBase_Class()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EReference getFunctionTrigger_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerPolicy <em>Trigger Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Policy</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.FunctionTrigger#getTriggerPolicy()
	 * @see #getFunctionTrigger()
	 * @generated
	 */
	EAttribute getFunctionTrigger_TriggerPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.behavior.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Mode
	 * @generated
	 */
	EClass getMode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.Mode#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Mode#getCondition()
	 * @see #getMode()
	 * @generated
	 */
	EAttribute getMode_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.Mode#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.Mode#getBase_Class()
	 * @see #getMode()
	 * @generated
	 */
	EReference getMode_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.behavior.ModeGroup <em>Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Group</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.ModeGroup
	 * @generated
	 */
	EClass getModeGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.behavior.ModeGroup#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.ModeGroup#getMode()
	 * @see #getModeGroup()
	 * @generated
	 */
	EReference getModeGroup_Mode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.behavior.ModeGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.ModeGroup#getBase_Class()
	 * @see #getModeGroup()
	 * @generated
	 */
	EReference getModeGroup_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.behavior.ModeGroup#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precondition</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.ModeGroup#getPrecondition()
	 * @see #getModeGroup()
	 * @generated
	 */
	EAttribute getModeGroup_Precondition();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind <em>Trigger Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trigger Policy Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.behavior.TriggerPolicyKind
	 * @generated
	 */
	EEnum getTriggerPolicyKind();

} // BehaviorPackage
