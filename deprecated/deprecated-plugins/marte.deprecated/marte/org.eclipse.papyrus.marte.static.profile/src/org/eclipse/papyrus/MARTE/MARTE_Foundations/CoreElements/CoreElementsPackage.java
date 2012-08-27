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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsFactory
 * @model kind="package"
 * @generated
 */
public interface CoreElementsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CoreElements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/CoreElements/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CoreElements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreElementsPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeTransitionImpl <em>Mode Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeTransitionImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getModeTransition()
	 * @generated
	 */
	int MODE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION__BASE_TRANSITION = 0;

	/**
	 * The number of structural features of the '<em>Mode Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TRANSITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeBehaviorImpl <em>Mode Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeBehaviorImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getModeBehavior()
	 * @generated
	 */
	int MODE_BEHAVIOR = 1;

	/**
	 * The feature id for the '<em><b>Base State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_BEHAVIOR__BASE_STATE_MACHINE = 0;

	/**
	 * The number of structural features of the '<em>Mode Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_BEHAVIOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ConfigurationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_STRUCTURED_CLASSIFIER = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MODE = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeImpl <em>Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getMode()
	 * @generated
	 */
	int MODE = 3;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__BASE_STATE = 0;

	/**
	 * The number of structural features of the '<em>Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeTransition <em>Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Transition</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeTransition
	 * @generated
	 */
	EClass getModeTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeTransition#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeTransition#getBase_Transition()
	 * @see #getModeTransition()
	 * @generated
	 */
	EReference getModeTransition_Base_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeBehavior <em>Mode Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeBehavior
	 * @generated
	 */
	EClass getModeBehavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeBehavior#getBase_StateMachine <em>Base State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State Machine</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.ModeBehavior#getBase_StateMachine()
	 * @see #getModeBehavior()
	 * @generated
	 */
	EReference getModeBehavior_Base_StateMachine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_StructuredClassifier <em>Base Structured Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structured Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_StructuredClassifier()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Base_StructuredClassifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_Package()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getMode()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Mode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Mode
	 * @generated
	 */
	EClass getMode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Mode#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Mode#getBase_State()
	 * @see #getMode()
	 * @generated
	 */
	EReference getMode_Base_State();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreElementsFactory getCoreElementsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeTransitionImpl <em>Mode Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeTransitionImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getModeTransition()
		 * @generated
		 */
		EClass MODE_TRANSITION = eINSTANCE.getModeTransition();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_TRANSITION__BASE_TRANSITION = eINSTANCE.getModeTransition_Base_Transition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeBehaviorImpl <em>Mode Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeBehaviorImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getModeBehavior()
		 * @generated
		 */
		EClass MODE_BEHAVIOR = eINSTANCE.getModeBehavior();

		/**
		 * The meta object literal for the '<em><b>Base State Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_BEHAVIOR__BASE_STATE_MACHINE = eINSTANCE.getModeBehavior_Base_StateMachine();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ConfigurationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Base Structured Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__BASE_STRUCTURED_CLASSIFIER = eINSTANCE.getConfiguration_Base_StructuredClassifier();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__BASE_PACKAGE = eINSTANCE.getConfiguration_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MODE = eINSTANCE.getConfiguration_Mode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeImpl <em>Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ModeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl#getMode()
		 * @generated
		 */
		EClass MODE = eINSTANCE.getMode();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE__BASE_STATE = eINSTANCE.getMode_Base_State();

	}

} //CoreElementsPackage
