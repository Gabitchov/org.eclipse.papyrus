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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMFactory
 * @model kind="package"
 * @generated
 */
public interface HLAMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HLAM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/HLAM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "HLAM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HLAMPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl <em>Rt Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtUnit()
	 * @generated
	 */
	int RT_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Is Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__IS_DYNAMIC = 0;

	/**
	 * The feature id for the '<em><b>Is Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__IS_MAIN = 1;

	/**
	 * The feature id for the '<em><b>Sr Pool Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__SR_POOL_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Sr Pool Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__SR_POOL_POLICY = 3;

	/**
	 * The feature id for the '<em><b>Sr Pool Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__SR_POOL_WAITING_TIME = 4;

	/**
	 * The feature id for the '<em><b>Operational Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__OPERATIONAL_MODE = 5;

	/**
	 * The feature id for the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__MAIN = 6;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__MEMORY_SIZE = 7;

	/**
	 * The feature id for the '<em><b>Base Behaviored Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__BASE_BEHAVIORED_CLASSIFIER = 8;

	/**
	 * The feature id for the '<em><b>Queue Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__QUEUE_SCHED_POLICY = 9;

	/**
	 * The feature id for the '<em><b>Queue Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__QUEUE_SIZE = 10;

	/**
	 * The feature id for the '<em><b>Msg Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT__MSG_MAX_SIZE = 11;

	/**
	 * The number of structural features of the '<em>Rt Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_UNIT_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl <em>Pp Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getPpUnit()
	 * @generated
	 */
	int PP_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Conc Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP_UNIT__CONC_POLICY = 0;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP_UNIT__MEMORY_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Base Behaviored Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP_UNIT__BASE_BEHAVIORED_CLASSIFIER = 2;

	/**
	 * The number of structural features of the '<em>Pp Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP_UNIT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl <em>Rt Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtFeature()
	 * @generated
	 */
	int RT_FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__BASE_BEHAVIORAL_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__BASE_MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Base Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__BASE_SIGNAL = 2;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__BASE_PORT = 3;

	/**
	 * The feature id for the '<em><b>Base Invocation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__BASE_INVOCATION_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE__SPECIFICATION = 5;

	/**
	 * The number of structural features of the '<em>Rt Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_FEATURE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl <em>Rt Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtSpecification()
	 * @generated
	 */
	int RT_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__UTILITY = 0;

	/**
	 * The feature id for the '<em><b>Occ Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__OCC_KIND = 1;

	/**
	 * The feature id for the '<em><b>TRef</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__TREF = 2;

	/**
	 * The feature id for the '<em><b>Rel Dl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__REL_DL = 3;

	/**
	 * The feature id for the '<em><b>Abs Dl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__ABS_DL = 4;

	/**
	 * The feature id for the '<em><b>Bound Dl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__BOUND_DL = 5;

	/**
	 * The feature id for the '<em><b>Rd Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__RD_TIME = 6;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__MISS = 7;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__PRIORITY = 8;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__BASE_COMMENT = 9;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION__CONTEXT = 10;

	/**
	 * The number of structural features of the '<em>Rt Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SPECIFICATION_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl <em>Rt Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtAction()
	 * @generated
	 */
	int RT_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION__IS_ATOMIC = 0;

	/**
	 * The feature id for the '<em><b>Synch Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION__SYNCH_KIND = 1;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION__MSG_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION__BASE_BEHAVIORAL_FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Base Invocation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION__BASE_INVOCATION_ACTION = 4;

	/**
	 * The number of structural features of the '<em>Rt Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_ACTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl <em>Rt Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtService()
	 * @generated
	 */
	int RT_SERVICE = 5;

	/**
	 * The feature id for the '<em><b>Conc Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE__CONC_POLICY = 0;

	/**
	 * The feature id for the '<em><b>Exe Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE__EXE_KIND = 1;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE__IS_ATOMIC = 2;

	/**
	 * The feature id for the '<em><b>Synch Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE__SYNCH_KIND = 3;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE__BASE_BEHAVIORAL_FEATURE = 4;

	/**
	 * The number of structural features of the '<em>Rt Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_SERVICE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind <em>Pool Mgt Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getPoolMgtPolicyKind()
	 * @generated
	 */
	int POOL_MGT_POLICY_KIND = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind <em>Call Concurrency Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getCallConcurrencyKind()
	 * @generated
	 */
	int CALL_CONCURRENCY_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind <em>Execution Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getExecutionKind()
	 * @generated
	 */
	int EXECUTION_KIND = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind <em>Concurrency Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getConcurrencyKind()
	 * @generated
	 */
	int CONCURRENCY_KIND = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit <em>Rt Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rt Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit
	 * @generated
	 */
	EClass getRtUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsDynamic <em>Is Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dynamic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsDynamic()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_IsDynamic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsMain <em>Is Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Main</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#isIsMain()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_IsMain();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolSize <em>Sr Pool Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sr Pool Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolSize()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_SrPoolSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolPolicy <em>Sr Pool Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sr Pool Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolPolicy()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_SrPoolPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolWaitingTime <em>Sr Pool Waiting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sr Pool Waiting Time</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getSrPoolWaitingTime()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_SrPoolWaitingTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getOperationalMode <em>Operational Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operational Mode</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getOperationalMode()
	 * @see #getRtUnit()
	 * @generated
	 */
	EReference getRtUnit_OperationalMode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMain()
	 * @see #getRtUnit()
	 * @generated
	 */
	EReference getRtUnit_Main();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMemorySize()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_MemorySize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behaviored Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getBase_BehavioredClassifier()
	 * @see #getRtUnit()
	 * @generated
	 */
	EReference getRtUnit_Base_BehavioredClassifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSchedPolicy <em>Queue Sched Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Sched Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSchedPolicy()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_QueueSchedPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSize <em>Queue Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getQueueSize()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_QueueSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMsgMaxSize <em>Msg Max Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg Max Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit#getMsgMaxSize()
	 * @see #getRtUnit()
	 * @generated
	 */
	EAttribute getRtUnit_MsgMaxSize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit <em>Pp Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pp Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit
	 * @generated
	 */
	EClass getPpUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getConcPolicy <em>Conc Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conc Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getConcPolicy()
	 * @see #getPpUnit()
	 * @generated
	 */
	EAttribute getPpUnit_ConcPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getMemorySize()
	 * @see #getPpUnit()
	 * @generated
	 */
	EAttribute getPpUnit_MemorySize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behaviored Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PpUnit#getBase_BehavioredClassifier()
	 * @see #getPpUnit()
	 * @generated
	 */
	EReference getPpUnit_Base_BehavioredClassifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature <em>Rt Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rt Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature
	 * @generated
	 */
	EClass getRtFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_BehavioralFeature()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Message <em>Base Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Message</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Message()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Base_Message();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Signal <em>Base Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Signal</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Signal()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Base_Signal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_Port()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Base_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_InvocationAction <em>Base Invocation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Invocation Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getBase_InvocationAction()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Base_InvocationAction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature#getSpecification()
	 * @see #getRtFeature()
	 * @generated
	 */
	EReference getRtFeature_Specification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification <em>Rt Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rt Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification
	 * @generated
	 */
	EClass getRtSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getUtility <em>Utility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utility</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getUtility()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_Utility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getOccKind <em>Occ Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occ Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getOccKind()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_OccKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getTRef <em>TRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>TRef</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getTRef()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EReference getRtSpecification_TRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getRelDl <em>Rel Dl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rel Dl</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getRelDl()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_RelDl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getAbsDl <em>Abs Dl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abs Dl</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getAbsDl()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_AbsDl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getBoundDl <em>Bound Dl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound Dl</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getBoundDl()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_BoundDl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getRdTime <em>Rd Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rd Time</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getRdTime()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_RdTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getMiss <em>Miss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Miss</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getMiss()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_Miss();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getPriority()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EAttribute getRtSpecification_Priority();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getBase_Comment()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EReference getRtSpecification_Base_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification#getContext()
	 * @see #getRtSpecification()
	 * @generated
	 */
	EReference getRtSpecification_Context();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction <em>Rt Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rt Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction
	 * @generated
	 */
	EClass getRtAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#isIsAtomic <em>Is Atomic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Atomic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#isIsAtomic()
	 * @see #getRtAction()
	 * @generated
	 */
	EAttribute getRtAction_IsAtomic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getSynchKind <em>Synch Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synch Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getSynchKind()
	 * @see #getRtAction()
	 * @generated
	 */
	EAttribute getRtAction_SynchKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getMsgSize <em>Msg Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getMsgSize()
	 * @see #getRtAction()
	 * @generated
	 */
	EAttribute getRtAction_MsgSize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getBase_BehavioralFeature()
	 * @see #getRtAction()
	 * @generated
	 */
	EReference getRtAction_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getBase_InvocationAction <em>Base Invocation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Invocation Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction#getBase_InvocationAction()
	 * @see #getRtAction()
	 * @generated
	 */
	EReference getRtAction_Base_InvocationAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService <em>Rt Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rt Service</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService
	 * @generated
	 */
	EClass getRtService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getConcPolicy <em>Conc Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conc Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getConcPolicy()
	 * @see #getRtService()
	 * @generated
	 */
	EAttribute getRtService_ConcPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getExeKind <em>Exe Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exe Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getExeKind()
	 * @see #getRtService()
	 * @generated
	 */
	EAttribute getRtService_ExeKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#isIsAtomic <em>Is Atomic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Atomic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#isIsAtomic()
	 * @see #getRtService()
	 * @generated
	 */
	EAttribute getRtService_IsAtomic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getSynchKind <em>Synch Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synch Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getSynchKind()
	 * @see #getRtService()
	 * @generated
	 */
	EAttribute getRtService_SynchKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService#getBase_BehavioralFeature()
	 * @see #getRtService()
	 * @generated
	 */
	EReference getRtService_Base_BehavioralFeature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind <em>Pool Mgt Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pool Mgt Policy Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind
	 * @generated
	 */
	EEnum getPoolMgtPolicyKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind <em>Call Concurrency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Call Concurrency Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind
	 * @generated
	 */
	EEnum getCallConcurrencyKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind <em>Synchronization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronization Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind
	 * @generated
	 */
	EEnum getSynchronizationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind <em>Execution Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind
	 * @generated
	 */
	EEnum getExecutionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind <em>Concurrency Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Concurrency Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind
	 * @generated
	 */
	EEnum getConcurrencyKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HLAMFactory getHLAMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl <em>Rt Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtUnit()
		 * @generated
		 */
		EClass RT_UNIT = eINSTANCE.getRtUnit();

		/**
		 * The meta object literal for the '<em><b>Is Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__IS_DYNAMIC = eINSTANCE.getRtUnit_IsDynamic();

		/**
		 * The meta object literal for the '<em><b>Is Main</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__IS_MAIN = eINSTANCE.getRtUnit_IsMain();

		/**
		 * The meta object literal for the '<em><b>Sr Pool Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__SR_POOL_SIZE = eINSTANCE.getRtUnit_SrPoolSize();

		/**
		 * The meta object literal for the '<em><b>Sr Pool Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__SR_POOL_POLICY = eINSTANCE.getRtUnit_SrPoolPolicy();

		/**
		 * The meta object literal for the '<em><b>Sr Pool Waiting Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__SR_POOL_WAITING_TIME = eINSTANCE.getRtUnit_SrPoolWaitingTime();

		/**
		 * The meta object literal for the '<em><b>Operational Mode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_UNIT__OPERATIONAL_MODE = eINSTANCE.getRtUnit_OperationalMode();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_UNIT__MAIN = eINSTANCE.getRtUnit_Main();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__MEMORY_SIZE = eINSTANCE.getRtUnit_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Base Behaviored Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_UNIT__BASE_BEHAVIORED_CLASSIFIER = eINSTANCE.getRtUnit_Base_BehavioredClassifier();

		/**
		 * The meta object literal for the '<em><b>Queue Sched Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__QUEUE_SCHED_POLICY = eINSTANCE.getRtUnit_QueueSchedPolicy();

		/**
		 * The meta object literal for the '<em><b>Queue Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__QUEUE_SIZE = eINSTANCE.getRtUnit_QueueSize();

		/**
		 * The meta object literal for the '<em><b>Msg Max Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_UNIT__MSG_MAX_SIZE = eINSTANCE.getRtUnit_MsgMaxSize();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl <em>Pp Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.PpUnitImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getPpUnit()
		 * @generated
		 */
		EClass PP_UNIT = eINSTANCE.getPpUnit();

		/**
		 * The meta object literal for the '<em><b>Conc Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PP_UNIT__CONC_POLICY = eINSTANCE.getPpUnit_ConcPolicy();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PP_UNIT__MEMORY_SIZE = eINSTANCE.getPpUnit_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Base Behaviored Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PP_UNIT__BASE_BEHAVIORED_CLASSIFIER = eINSTANCE.getPpUnit_Base_BehavioredClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl <em>Rt Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtFeature()
		 * @generated
		 */
		EClass RT_FEATURE = eINSTANCE.getRtFeature();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getRtFeature_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Base Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__BASE_MESSAGE = eINSTANCE.getRtFeature_Base_Message();

		/**
		 * The meta object literal for the '<em><b>Base Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__BASE_SIGNAL = eINSTANCE.getRtFeature_Base_Signal();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__BASE_PORT = eINSTANCE.getRtFeature_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Base Invocation Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__BASE_INVOCATION_ACTION = eINSTANCE.getRtFeature_Base_InvocationAction();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_FEATURE__SPECIFICATION = eINSTANCE.getRtFeature_Specification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl <em>Rt Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtSpecificationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtSpecification()
		 * @generated
		 */
		EClass RT_SPECIFICATION = eINSTANCE.getRtSpecification();

		/**
		 * The meta object literal for the '<em><b>Utility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__UTILITY = eINSTANCE.getRtSpecification_Utility();

		/**
		 * The meta object literal for the '<em><b>Occ Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__OCC_KIND = eINSTANCE.getRtSpecification_OccKind();

		/**
		 * The meta object literal for the '<em><b>TRef</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_SPECIFICATION__TREF = eINSTANCE.getRtSpecification_TRef();

		/**
		 * The meta object literal for the '<em><b>Rel Dl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__REL_DL = eINSTANCE.getRtSpecification_RelDl();

		/**
		 * The meta object literal for the '<em><b>Abs Dl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__ABS_DL = eINSTANCE.getRtSpecification_AbsDl();

		/**
		 * The meta object literal for the '<em><b>Bound Dl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__BOUND_DL = eINSTANCE.getRtSpecification_BoundDl();

		/**
		 * The meta object literal for the '<em><b>Rd Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__RD_TIME = eINSTANCE.getRtSpecification_RdTime();

		/**
		 * The meta object literal for the '<em><b>Miss</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__MISS = eINSTANCE.getRtSpecification_Miss();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SPECIFICATION__PRIORITY = eINSTANCE.getRtSpecification_Priority();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_SPECIFICATION__BASE_COMMENT = eINSTANCE.getRtSpecification_Base_Comment();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_SPECIFICATION__CONTEXT = eINSTANCE.getRtSpecification_Context();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl <em>Rt Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtAction()
		 * @generated
		 */
		EClass RT_ACTION = eINSTANCE.getRtAction();

		/**
		 * The meta object literal for the '<em><b>Is Atomic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_ACTION__IS_ATOMIC = eINSTANCE.getRtAction_IsAtomic();

		/**
		 * The meta object literal for the '<em><b>Synch Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_ACTION__SYNCH_KIND = eINSTANCE.getRtAction_SynchKind();

		/**
		 * The meta object literal for the '<em><b>Msg Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_ACTION__MSG_SIZE = eINSTANCE.getRtAction_MsgSize();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_ACTION__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getRtAction_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Base Invocation Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_ACTION__BASE_INVOCATION_ACTION = eINSTANCE.getRtAction_Base_InvocationAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl <em>Rt Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getRtService()
		 * @generated
		 */
		EClass RT_SERVICE = eINSTANCE.getRtService();

		/**
		 * The meta object literal for the '<em><b>Conc Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SERVICE__CONC_POLICY = eINSTANCE.getRtService_ConcPolicy();

		/**
		 * The meta object literal for the '<em><b>Exe Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SERVICE__EXE_KIND = eINSTANCE.getRtService_ExeKind();

		/**
		 * The meta object literal for the '<em><b>Is Atomic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SERVICE__IS_ATOMIC = eINSTANCE.getRtService_IsAtomic();

		/**
		 * The meta object literal for the '<em><b>Synch Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RT_SERVICE__SYNCH_KIND = eINSTANCE.getRtService_SynchKind();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RT_SERVICE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getRtService_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind <em>Pool Mgt Policy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getPoolMgtPolicyKind()
		 * @generated
		 */
		EEnum POOL_MGT_POLICY_KIND = eINSTANCE.getPoolMgtPolicyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind <em>Call Concurrency Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getCallConcurrencyKind()
		 * @generated
		 */
		EEnum CALL_CONCURRENCY_KIND = eINSTANCE.getCallConcurrencyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind <em>Synchronization Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getSynchronizationKind()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_KIND = eINSTANCE.getSynchronizationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind <em>Execution Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getExecutionKind()
		 * @generated
		 */
		EEnum EXECUTION_KIND = eINSTANCE.getExecutionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind <em>Concurrency Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl#getConcurrencyKind()
		 * @generated
		 */
		EEnum CONCURRENCY_KIND = eINSTANCE.getConcurrencyKind();

	}

} //HLAMPackage
