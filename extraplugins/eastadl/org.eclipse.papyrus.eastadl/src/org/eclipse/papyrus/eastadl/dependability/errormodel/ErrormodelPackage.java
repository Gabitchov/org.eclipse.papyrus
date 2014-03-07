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
package org.eclipse.papyrus.eastadl.dependability.errormodel;

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
 * The EAST-ADL2 sub-package for error modeling provides support for safety engineering by representing possible, incorrect behaviors of a system in
 * its operation (e.g., component errors and their propagations).
 * Abnormal behaviors of architectural elements as well as their instantiations in a particular product context can be represented, forming a basis
 * for safety analysis through external techniques and tools. Through the integration with other language constructs, definitions of error behaviors
 * and hazards can be traced to the specifications of safety requirements, and further to the subsequent functional and non-functional requirements on
 * error handing and hazard mitigations as well as to the necessary V&V efforts.
 * Error behaviors are treated as a separated view, orthogonal to the nominal architecture model. This separation of concern in modeling is considered
 * necessary in order to avoid some undesired effects of error modeling, such as the risk of mixing nominal and erroneous behavior in regards to the
 * comprehension, reuse, and system synthesis (e.g., code generation).
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelFactory
 * @model kind="package"
 * @generated
 */
public interface ErrormodelPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl
		 * <em>Error Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorBehavior()
		 * @generated
		 */
		EClass ERROR_BEHAVIOR = eINSTANCE.getErrorBehavior();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__BASE_BEHAVIOR = eINSTANCE.getErrorBehavior_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Failure Logic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ERROR_BEHAVIOR__FAILURE_LOGIC = eINSTANCE.getErrorBehavior_FailureLogic();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ERROR_BEHAVIOR__TYPE = eINSTANCE.getErrorBehavior_Type();

		/**
		 * The meta object literal for the '<em><b>Internal Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__INTERNAL_FAULT = eINSTANCE.getErrorBehavior_InternalFault();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__OWNER = eINSTANCE.getErrorBehavior_Owner();

		/**
		 * The meta object literal for the '<em><b>External Failure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__EXTERNAL_FAILURE = eINSTANCE.getErrorBehavior_ExternalFailure();

		/**
		 * The meta object literal for the '<em><b>External Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__EXTERNAL_FAULT = eINSTANCE.getErrorBehavior_ExternalFault();

		/**
		 * The meta object literal for the '<em><b>Process Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_BEHAVIOR__PROCESS_FAULT = eINSTANCE.getErrorBehavior_ProcessFault();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.AnomalyImpl <em>Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.AnomalyImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getAnomaly()
		 * @generated
		 */
		EClass ANOMALY = eINSTANCE.getAnomaly();

		/**
		 * The meta object literal for the '<em><b>Generic Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANOMALY__GENERIC_DESCRIPTION = eINSTANCE.getAnomaly_GenericDescription();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANOMALY__BASE_PROPERTY = eINSTANCE.getAnomaly_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANOMALY__TYPE = eINSTANCE.getAnomaly_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl
		 * <em>Internal Fault Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getInternalFaultPrototype()
		 * @generated
		 */
		EClass INTERNAL_FAULT_PROTOTYPE = eINSTANCE.getInternalFaultPrototype();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INTERNAL_FAULT_PROTOTYPE__BASE_CLASS = eINSTANCE.getInternalFaultPrototype_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INTERNAL_FAULT_PROTOTYPE__BASE_EVENT = eINSTANCE.getInternalFaultPrototype_Base_Event();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelTypeImpl
		 * <em>Error Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelTypeImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorModelType()
		 * @generated
		 */
		EClass ERROR_MODEL_TYPE = eINSTANCE.getErrorModelType();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__BASE_CLASS = eINSTANCE.getErrorModelType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Generic Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ERROR_MODEL_TYPE__GENERIC_DESCRIPTION = eINSTANCE.getErrorModelType_GenericDescription();

		/**
		 * The meta object literal for the '<em><b>Fault Failure Connector</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__FAULT_FAILURE_CONNECTOR = eINSTANCE.getErrorModelType_FaultFailureConnector();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__PART = eINSTANCE.getErrorModelType_Part();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__FAILURE = eINSTANCE.getErrorModelType_Failure();

		/**
		 * The meta object literal for the '<em><b>External Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__EXTERNAL_FAULT = eINSTANCE.getErrorModelType_ExternalFault();

		/**
		 * The meta object literal for the '<em><b>Internal Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__INTERNAL_FAULT = eINSTANCE.getErrorModelType_InternalFault();

		/**
		 * The meta object literal for the '<em><b>Process Fault</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__PROCESS_FAULT = eINSTANCE.getErrorModelType_ProcessFault();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__TARGET = eINSTANCE.getErrorModelType_Target();

		/**
		 * The meta object literal for the '<em><b>Hw Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__HW_TARGET = eINSTANCE.getErrorModelType_HwTarget();

		/**
		 * The meta object literal for the '<em><b>Error Behavior Description</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_TYPE__ERROR_BEHAVIOR_DESCRIPTION = eINSTANCE.getErrorModelType_ErrorBehaviorDescription();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl
		 * <em>Fault Failure Propagation Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultFailurePropagationLink()
		 * @generated
		 */
		EClass FAULT_FAILURE_PROPAGATION_LINK = eINSTANCE.getFaultFailurePropagationLink();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR = eINSTANCE.getFaultFailurePropagationLink_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Immediate Propagation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION = eINSTANCE.getFaultFailurePropagationLink_ImmediatePropagation();

		/**
		 * The meta object literal for the '<em><b>To Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PROPAGATION_LINK__TO_PORT = eINSTANCE.getFaultFailurePropagationLink_ToPort();

		/**
		 * The meta object literal for the '<em><b>From Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT = eINSTANCE.getFaultFailurePropagationLink_FromPort();

		/**
		 * The meta object literal for the '<em><b>From Port path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH = eINSTANCE.getFaultFailurePropagationLink_FromPort_path();

		/**
		 * The meta object literal for the '<em><b>To Port path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH = eINSTANCE.getFaultFailurePropagationLink_ToPort_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl
		 * <em>Fault Failure Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultFailurePort()
		 * @generated
		 */
		EClass FAULT_FAILURE_PORT = eINSTANCE.getFaultFailurePort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PORT__BASE_PORT = eINSTANCE.getFaultFailurePort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Function Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PORT__FUNCTION_TARGET = eINSTANCE.getFaultFailurePort_FunctionTarget();

		/**
		 * The meta object literal for the '<em><b>Hw Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PORT__HW_TARGET = eINSTANCE.getFaultFailurePort_HwTarget();

		/**
		 * The meta object literal for the '<em><b>Function Target path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH = eINSTANCE.getFaultFailurePort_FunctionTarget_path();

		/**
		 * The meta object literal for the '<em><b>Hw Target path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE_PORT__HW_TARGET_PATH = eINSTANCE.getFaultFailurePort_HwTarget_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelPrototypeImpl
		 * <em>Error Model Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorModelPrototype()
		 * @generated
		 */
		EClass ERROR_MODEL_PROTOTYPE = eINSTANCE.getErrorModelPrototype();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__BASE_PROPERTY = eINSTANCE.getErrorModelPrototype_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__TYPE = eINSTANCE.getErrorModelPrototype_Type();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__TARGET = eINSTANCE.getErrorModelPrototype_Target();

		/**
		 * The meta object literal for the '<em><b>Function Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__FUNCTION_TARGET = eINSTANCE.getErrorModelPrototype_FunctionTarget();

		/**
		 * The meta object literal for the '<em><b>Hw Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__HW_TARGET = eINSTANCE.getErrorModelPrototype_HwTarget();

		/**
		 * The meta object literal for the '<em><b>Function Target path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__FUNCTION_TARGET_PATH = eINSTANCE.getErrorModelPrototype_FunctionTarget_path();

		/**
		 * The meta object literal for the '<em><b>Hw Target path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ERROR_MODEL_PROTOTYPE__HW_TARGET_PATH = eINSTANCE.getErrorModelPrototype_HwTarget_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ProcessFaultPrototypeImpl
		 * <em>Process Fault Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ProcessFaultPrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getProcessFaultPrototype()
		 * @generated
		 */
		EClass PROCESS_FAULT_PROTOTYPE = eINSTANCE.getProcessFaultPrototype();

		/**
		 * The meta object literal for the '<em><b>Base Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCESS_FAULT_PROTOTYPE__BASE_EVENT = eINSTANCE.getProcessFaultPrototype_Base_Event();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FailureOutPortImpl
		 * <em>Failure Out Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FailureOutPortImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFailureOutPort()
		 * @generated
		 */
		EClass FAILURE_OUT_PORT = eINSTANCE.getFailureOutPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultInPortImpl <em>Fault In Port</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultInPortImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultInPort()
		 * @generated
		 */
		EClass FAULT_IN_PORT = eINSTANCE.getFaultInPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
		 * <em>Error Behavior Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
		 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorBehaviorKind()
		 * @generated
		 */
		EEnum ERROR_BEHAVIOR_KIND = eINSTANCE.getErrorBehaviorKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "errormodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Dependability/ErrorModel/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "ErrorModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ErrormodelPackage eINSTANCE = org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl <em>Error Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorBehavior()
	 * @generated
	 */
	int ERROR_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl
	 * <em>Internal Fault Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.InternalFaultPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getInternalFaultPrototype()
	 * @generated
	 */
	int INTERNAL_FAULT_PROTOTYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelTypeImpl <em>Error Model Type</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelTypeImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorModelType()
	 * @generated
	 */
	int ERROR_MODEL_TYPE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl
	 * <em>Fault Failure Propagation Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePropagationLinkImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultFailurePropagationLink()
	 * @generated
	 */
	int FAULT_FAILURE_PROPAGATION_LINK = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelPrototypeImpl
	 * <em>Error Model Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorModelPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorModelPrototype()
	 * @generated
	 */
	int ERROR_MODEL_PROTOTYPE = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FailureOutPortImpl <em>Failure Out Port</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FailureOutPortImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFailureOutPort()
	 * @generated
	 */
	int FAILURE_OUT_PORT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultInPortImpl <em>Fault In Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultInPortImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultInPort()
	 * @generated
	 */
	int FAULT_IN_PORT = 8;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__BASE_BEHAVIOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failure Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__FAILURE_LOGIC = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Internal Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__INTERNAL_FAULT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__OWNER = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>External Failure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__EXTERNAL_FAILURE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>External Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__EXTERNAL_FAULT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Process Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR__PROCESS_FAULT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Error Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_BEHAVIOR_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.AnomalyImpl <em>Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.AnomalyImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getAnomaly()
	 * @generated
	 */
	int ANOMALY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__GENERIC_DESCRIPTION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY__TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANOMALY_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__NAME = ANOMALY__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__BASE_NAMED_ELEMENT = ANOMALY__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__OWNED_COMMENT = ANOMALY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__GENERIC_DESCRIPTION = ANOMALY__GENERIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__BASE_PROPERTY = ANOMALY__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__TYPE = ANOMALY__TYPE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__BASE_CLASS = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE__BASE_EVENT = ANOMALY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Fault Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_PROTOTYPE_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__GENERIC_DESCRIPTION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault Failure Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__FAULT_FAILURE_CONNECTOR = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__PART = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__FAILURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>External Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__EXTERNAL_FAULT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Internal Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__INTERNAL_FAULT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Process Fault</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__PROCESS_FAULT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__TARGET = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Hw Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__HW_TARGET = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Error Behavior Description</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE__ERROR_BEHAVIOR_DESCRIPTION = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Error Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_TYPE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__BASE_CONNECTOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Immediate Propagation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__IMMEDIATE_PROPAGATION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__TO_PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>From Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>From Port path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__FROM_PORT_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>To Port path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK__TO_PORT_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Fault Failure Propagation Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PROPAGATION_LINK_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl <em>Fault Failure Port</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getFaultFailurePort()
	 * @generated
	 */
	int FAULT_FAILURE_PORT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__NAME = ANOMALY__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__BASE_NAMED_ELEMENT = ANOMALY__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__OWNED_COMMENT = ANOMALY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__GENERIC_DESCRIPTION = ANOMALY__GENERIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__BASE_PROPERTY = ANOMALY__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__TYPE = ANOMALY__TYPE;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__BASE_PORT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__FUNCTION_TARGET = ANOMALY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hw Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__HW_TARGET = ANOMALY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Function Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH = ANOMALY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hw Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT__HW_TARGET_PATH = ANOMALY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Fault Failure Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_PORT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ProcessFaultPrototypeImpl
	 * <em>Process Fault Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ProcessFaultPrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getProcessFaultPrototype()
	 * @generated
	 */
	int PROCESS_FAULT_PROTOTYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__TARGET = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Function Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__FUNCTION_TARGET = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hw Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__HW_TARGET = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Function Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__FUNCTION_TARGET_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hw Target path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE__HW_TARGET_PATH = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Error Model Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ERROR_MODEL_PROTOTYPE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__NAME = FAULT_FAILURE_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__BASE_NAMED_ELEMENT = FAULT_FAILURE_PORT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__OWNED_COMMENT = FAULT_FAILURE_PORT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__GENERIC_DESCRIPTION = FAULT_FAILURE_PORT__GENERIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__BASE_PROPERTY = FAULT_FAILURE_PORT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__TYPE = FAULT_FAILURE_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__BASE_PORT = FAULT_FAILURE_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Function Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__FUNCTION_TARGET = FAULT_FAILURE_PORT__FUNCTION_TARGET;

	/**
	 * The feature id for the '<em><b>Hw Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__HW_TARGET = FAULT_FAILURE_PORT__HW_TARGET;

	/**
	 * The feature id for the '<em><b>Function Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__FUNCTION_TARGET_PATH = FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Hw Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT__HW_TARGET_PATH = FAULT_FAILURE_PORT__HW_TARGET_PATH;

	/**
	 * The number of structural features of the '<em>Failure Out Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAILURE_OUT_PORT_FEATURE_COUNT = FAULT_FAILURE_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__NAME = FAULT_FAILURE_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__BASE_NAMED_ELEMENT = FAULT_FAILURE_PORT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__OWNED_COMMENT = FAULT_FAILURE_PORT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__GENERIC_DESCRIPTION = FAULT_FAILURE_PORT__GENERIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__BASE_PROPERTY = FAULT_FAILURE_PORT__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__TYPE = FAULT_FAILURE_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__BASE_PORT = FAULT_FAILURE_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Function Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__FUNCTION_TARGET = FAULT_FAILURE_PORT__FUNCTION_TARGET;

	/**
	 * The feature id for the '<em><b>Hw Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__HW_TARGET = FAULT_FAILURE_PORT__HW_TARGET;

	/**
	 * The feature id for the '<em><b>Function Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__FUNCTION_TARGET_PATH = FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Hw Target path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT__HW_TARGET_PATH = FAULT_FAILURE_PORT__HW_TARGET_PATH;

	/**
	 * The number of structural features of the '<em>Fault In Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_IN_PORT_FEATURE_COUNT = FAULT_FAILURE_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__NAME = ANOMALY__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__BASE_NAMED_ELEMENT = ANOMALY__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__OWNED_COMMENT = ANOMALY__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Generic Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__GENERIC_DESCRIPTION = ANOMALY__GENERIC_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__BASE_PROPERTY = ANOMALY__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__TYPE = ANOMALY__TYPE;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE__BASE_EVENT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Fault Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FAULT_PROTOTYPE_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind <em>Error Behavior Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl#getErrorBehaviorKind()
	 * @generated
	 */
	int ERROR_BEHAVIOR_KIND = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly <em>Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Anomaly</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly
	 * @generated
	 */
	EClass getAnomaly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getGenericDescription
	 * <em>Generic Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Generic Description</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getGenericDescription()
	 * @see #getAnomaly()
	 * @generated
	 */
	EAttribute getAnomaly_GenericDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getBase_Property
	 * <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getBase_Property()
	 * @see #getAnomaly()
	 * @generated
	 */
	EReference getAnomaly_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly#getType()
	 * @see #getAnomaly()
	 * @generated
	 */
	EReference getAnomaly_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior <em>Error Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Error Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior
	 * @generated
	 */
	EClass getErrorBehavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getBase_Behavior
	 * <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getBase_Behavior()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_Base_Behavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFailure
	 * <em>External Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>External Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFailure()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_ExternalFailure();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFault
	 * <em>External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>External Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getExternalFault()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_ExternalFault();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getFailureLogic
	 * <em>Failure Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Failure Logic</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getFailureLogic()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EAttribute getErrorBehavior_FailureLogic();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getInternalFault
	 * <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Internal Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getInternalFault()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_InternalFault();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getOwner()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_Owner();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getProcessFault
	 * <em>Process Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Process Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getProcessFault()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EReference getErrorBehavior_ProcessFault();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior#getType()
	 * @see #getErrorBehavior()
	 * @generated
	 */
	EAttribute getErrorBehavior_Type();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind <em>Error Behavior Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Error Behavior Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind
	 * @generated
	 */
	EEnum getErrorBehaviorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ErrormodelFactory getErrormodelFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype
	 * <em>Error Model Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Error Model Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype
	 * @generated
	 */
	EClass getErrorModelPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getBase_Property
	 * <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getBase_Property()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_Base_Property();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget <em>Function Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_FunctionTarget();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget
	 * <em>Hw Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hw Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_HwTarget();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget_path <em>Function Target path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function Target path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getFunctionTarget_path()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_FunctionTarget_path();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget_path <em>Hw Target path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Hw Target path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getHwTarget_path()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_HwTarget_path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getTarget
	 * <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getTarget()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype#getType()
	 * @see #getErrorModelPrototype()
	 * @generated
	 */
	EReference getErrorModelPrototype_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType <em>Error Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Error Model Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType
	 * @generated
	 */
	EClass getErrorModelType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getBase_Class()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_Base_Class();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getErrorBehaviorDescription <em>Error Behavior Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Error Behavior Description</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getErrorBehaviorDescription()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_ErrorBehaviorDescription();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getExternalFault
	 * <em>External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>External Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getExternalFault()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_ExternalFault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFailure
	 * <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFailure()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_Failure();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFaultFailureConnector <em>Fault Failure Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Fault Failure Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getFaultFailureConnector()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_FaultFailureConnector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getGenericDescription
	 * <em>Generic Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Generic Description</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getGenericDescription()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EAttribute getErrorModelType_GenericDescription();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getHwTarget
	 * <em>Hw Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hw Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getHwTarget()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_HwTarget();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getInternalFault
	 * <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Internal Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getInternalFault()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_InternalFault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getPart
	 * <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getPart()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_Part();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getProcessFault
	 * <em>Process Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Process Fault</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getProcessFault()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_ProcessFault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getTarget
	 * <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType#getTarget()
	 * @see #getErrorModelType()
	 * @generated
	 */
	EReference getErrorModelType_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort <em>Failure Out Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Failure Out Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort
	 * @generated
	 */
	EClass getFailureOutPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort <em>Fault Failure Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Fault Failure Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort
	 * @generated
	 */
	EClass getFaultFailurePort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getBase_Port
	 * <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getBase_Port()
	 * @see #getFaultFailurePort()
	 * @generated
	 */
	EReference getFaultFailurePort_Base_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget
	 * <em>Function Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget()
	 * @see #getFaultFailurePort()
	 * @generated
	 */
	EReference getFaultFailurePort_FunctionTarget();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget
	 * <em>Hw Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hw Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget()
	 * @see #getFaultFailurePort()
	 * @generated
	 */
	EReference getFaultFailurePort_HwTarget();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget_path <em>Function Target path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function Target path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget_path()
	 * @see #getFaultFailurePort()
	 * @generated
	 */
	EReference getFaultFailurePort_FunctionTarget_path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget_path
	 * <em>Hw Target path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Hw Target path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget_path()
	 * @see #getFaultFailurePort()
	 * @generated
	 */
	EReference getFaultFailurePort_HwTarget_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink
	 * <em>Fault Failure Propagation Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Fault Failure Propagation Link</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink
	 * @generated
	 */
	EClass getFaultFailurePropagationLink();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getBase_Connector()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EReference getFaultFailurePropagationLink_Base_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort
	 * <em>From Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>From Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EReference getFaultFailurePropagationLink_FromPort();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort_path <em>From Port path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>From Port path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getFromPort_path()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EReference getFaultFailurePropagationLink_FromPort_path();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort_path <em>To Port path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>To Port path</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort_path()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EReference getFaultFailurePropagationLink_ToPort_path();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#isImmediatePropagation <em>Immediate Propagation</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Immediate Propagation</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#isImmediatePropagation()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EAttribute getFaultFailurePropagationLink_ImmediatePropagation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort
	 * <em>To Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>To Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink#getToPort()
	 * @see #getFaultFailurePropagationLink()
	 * @generated
	 */
	EReference getFaultFailurePropagationLink_ToPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort <em>Fault In Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Fault In Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort
	 * @generated
	 */
	EClass getFaultInPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype
	 * <em>Internal Fault Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Internal Fault Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype
	 * @generated
	 */
	EClass getInternalFaultPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype#getBase_Class()
	 * @see #getInternalFaultPrototype()
	 * @generated
	 */
	EReference getInternalFaultPrototype_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype#getBase_Event
	 * <em>Base Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Event</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype#getBase_Event()
	 * @see #getInternalFaultPrototype()
	 * @generated
	 */
	EReference getInternalFaultPrototype_Base_Event();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype
	 * <em>Process Fault Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Process Fault Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype
	 * @generated
	 */
	EClass getProcessFaultPrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype#getBase_Event
	 * <em>Base Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Event</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype#getBase_Event()
	 * @see #getProcessFaultPrototype()
	 * @generated
	 */
	EReference getProcessFaultPrototype_Base_Event();

} //ErrormodelPackage
