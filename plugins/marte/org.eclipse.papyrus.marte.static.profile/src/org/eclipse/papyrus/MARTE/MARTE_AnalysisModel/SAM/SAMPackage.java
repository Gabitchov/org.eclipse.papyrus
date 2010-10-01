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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMFactory
 * @model kind="package"
 * @generated
 */
public interface SAMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SAM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/SAM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SAM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SAMPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl <em>Sa Analysis Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaAnalysisContext()
	 * @generated
	 */
	int SA_ANALYSIS_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__BASE_PACKAGE = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__MODE = GQAMPackage.GA_ANALYSIS_CONTEXT__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT = GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__CONTEXT = GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__WORKLOAD = GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__PLATFORM = GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM;

	/**
	 * The feature id for the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__IS_SCHED = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opt Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT__OPT_CRITERION = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sa Analysis Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ANALYSIS_CONTEXT_FEATURE_COUNT = GQAMPackage.GA_ANALYSIS_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl <em>Sa Endto End Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaEndtoEndFlow()
	 * @generated
	 */
	int SA_ENDTO_END_FLOW = 1;

	/**
	 * The feature id for the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__IS_SCHED = 0;

	/**
	 * The feature id for the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__SCH_SLACK = 1;

	/**
	 * The feature id for the '<em><b>End2 End T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__END2_END_T = 2;

	/**
	 * The feature id for the '<em><b>End2 End D</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__END2_END_D = 3;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__TIMING = 4;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Sa Endto End Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_ENDTO_END_FLOW_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommStepImpl <em>Sa Comm Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaCommStep()
	 * @generated
	 */
	int SA_COMM_STEP = 2;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__EXEC_TIME = GQAMPackage.GA_COMM_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__ALLOCATED_MEMORY = GQAMPackage.GA_COMM_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__USED_MEMORY = GQAMPackage.GA_COMM_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__POWER_PEAK = GQAMPackage.GA_COMM_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__ENERGY = GQAMPackage.GA_COMM_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BASE_NAMED_ELEMENT = GQAMPackage.GA_COMM_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SUB_USAGE = GQAMPackage.GA_COMM_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__USED_RESOURCES = GQAMPackage.GA_COMM_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__MSG_SIZE = GQAMPackage.GA_COMM_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__ON = GQAMPackage.GA_COMM_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BASE_ACTION = GQAMPackage.GA_COMM_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BASE_BEHAVIOR = GQAMPackage.GA_COMM_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BASE_MESSAGE = GQAMPackage.GA_COMM_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__DURATION = GQAMPackage.GA_COMM_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__START = GQAMPackage.GA_COMM_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__FINISH = GQAMPackage.GA_COMM_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__CAUSE = GQAMPackage.GA_COMM_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__HOST_DEMAND = GQAMPackage.GA_COMM_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__HOST_DEMAND_OPS = GQAMPackage.GA_COMM_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__INTER_OCC_T = GQAMPackage.GA_COMM_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__THROUGHPUT = GQAMPackage.GA_COMM_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__RESP_T = GQAMPackage.GA_COMM_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__UTILIZATION = GQAMPackage.GA_COMM_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__UTILIZATION_ON_HOST = GQAMPackage.GA_COMM_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__ROOT = GQAMPackage.GA_COMM_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__STEPS = GQAMPackage.GA_COMM_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__PARENT_STEP = GQAMPackage.GA_COMM_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__TIMING = GQAMPackage.GA_COMM_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__IS_ATOMIC = GQAMPackage.GA_COMM_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BLOCK_T = GQAMPackage.GA_COMM_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__REP = GQAMPackage.GA_COMM_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__PROB = GQAMPackage.GA_COMM_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__PRIORITY = GQAMPackage.GA_COMM_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__CONCUR_RES = GQAMPackage.GA_COMM_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__HOST = GQAMPackage.GA_COMM_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SERV_DEMAND = GQAMPackage.GA_COMM_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SERV_COUNT = GQAMPackage.GA_COMM_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SELF_DELAY = GQAMPackage.GA_COMM_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SCENARIO = GQAMPackage.GA_COMM_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__CHILD_SCENARIO = GQAMPackage.GA_COMM_STEP__CHILD_SCENARIO;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__DEADLINE = GQAMPackage.GA_COMM_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Spare Cap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SPARE_CAP = GQAMPackage.GA_COMM_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__SCH_SLACK = GQAMPackage.GA_COMM_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP__BASE_BEHAVIORAL_FEATURE = GQAMPackage.GA_COMM_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sa Comm Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_STEP_FEATURE_COUNT = GQAMPackage.GA_COMM_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl <em>Sa Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaStep()
	 * @generated
	 */
	int SA_STEP = 3;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__EXEC_TIME = GQAMPackage.GA_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__ALLOCATED_MEMORY = GQAMPackage.GA_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__USED_MEMORY = GQAMPackage.GA_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__POWER_PEAK = GQAMPackage.GA_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__ENERGY = GQAMPackage.GA_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BASE_NAMED_ELEMENT = GQAMPackage.GA_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SUB_USAGE = GQAMPackage.GA_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__USED_RESOURCES = GQAMPackage.GA_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__MSG_SIZE = GQAMPackage.GA_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__ON = GQAMPackage.GA_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BASE_ACTION = GQAMPackage.GA_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BASE_BEHAVIOR = GQAMPackage.GA_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BASE_MESSAGE = GQAMPackage.GA_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__DURATION = GQAMPackage.GA_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__START = GQAMPackage.GA_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__FINISH = GQAMPackage.GA_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__CAUSE = GQAMPackage.GA_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__HOST_DEMAND = GQAMPackage.GA_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__HOST_DEMAND_OPS = GQAMPackage.GA_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__INTER_OCC_T = GQAMPackage.GA_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__THROUGHPUT = GQAMPackage.GA_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__RESP_T = GQAMPackage.GA_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__UTILIZATION = GQAMPackage.GA_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__UTILIZATION_ON_HOST = GQAMPackage.GA_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__ROOT = GQAMPackage.GA_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__STEPS = GQAMPackage.GA_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__PARENT_STEP = GQAMPackage.GA_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__TIMING = GQAMPackage.GA_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__IS_ATOMIC = GQAMPackage.GA_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BLOCK_T = GQAMPackage.GA_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__REP = GQAMPackage.GA_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__PROB = GQAMPackage.GA_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__PRIORITY = GQAMPackage.GA_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__CONCUR_RES = GQAMPackage.GA_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__HOST = GQAMPackage.GA_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SERV_DEMAND = GQAMPackage.GA_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SERV_COUNT = GQAMPackage.GA_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SELF_DELAY = GQAMPackage.GA_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SCENARIO = GQAMPackage.GA_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__CHILD_SCENARIO = GQAMPackage.GA_STEP__CHILD_SCENARIO;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__BASE_BEHAVIORAL_FEATURE = GQAMPackage.GA_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__DEADLINE = GQAMPackage.GA_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Spare Cap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SPARE_CAP = GQAMPackage.GA_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SCH_SLACK = GQAMPackage.GA_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Preempt T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__PREEMPT_T = GQAMPackage.GA_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ready T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__READY_T = GQAMPackage.GA_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Nonpreemption Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__NONPREEMPTION_BLOCKING = GQAMPackage.GA_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Shared Res</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SHARED_RES = GQAMPackage.GA_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Self Suspension Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__SELF_SUSPENSION_BLOCKING = GQAMPackage.GA_STEP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Number Self Suspensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP__NUMBER_SELF_SUSPENSIONS = GQAMPackage.GA_STEP_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Sa Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_STEP_FEATURE_COUNT = GQAMPackage.GA_STEP_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl <em>Sa Shared Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaSharedResource()
	 * @generated
	 */
	int SA_SHARED_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__RES_MULT = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__IS_PROTECTED = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__IS_ACTIVE = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__BASE_PROPERTY = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__BASE_INSTANCE_SPECIFICATION = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__BASE_CLASSIFIER = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__BASE_LIFELINE = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__BASE_CONNECTABLE_ELEMENT = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Protect Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__PROTECT_KIND = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND;

	/**
	 * The feature id for the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__CEILING = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING;

	/**
	 * The feature id for the '<em><b>Other Protect Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__OTHER_PROTECT_PROTOCOL = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL;

	/**
	 * The feature id for the '<em><b>Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__SCHEDULER = GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__CAPACITY = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Preemp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__IS_PREEMP = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Consum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__IS_CONSUM = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Acquis T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__ACQUIS_T = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Release T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE__RELEASE_T = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sa Shared Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SHARED_RESOURCE_FEATURE_COUNT = GRMPackage.MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl <em>Sa Sched Obs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaSchedObs()
	 * @generated
	 */
	int SA_SCHED_OBS = 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__KIND = GQAMPackage.GA_TIMED_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__BASE_CONSTRAINT = GQAMPackage.GA_TIMED_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__MODE = GQAMPackage.GA_TIMED_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__LAXITY = GQAMPackage.GA_TIMED_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__START_OBS = GQAMPackage.GA_TIMED_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__END_OBS = GQAMPackage.GA_TIMED_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Suspentions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__SUSPENTIONS = GQAMPackage.GA_TIMED_OBS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__BLOCK_T = GQAMPackage.GA_TIMED_OBS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overlaps</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS__OVERLAPS = GQAMPackage.GA_TIMED_OBS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sa Sched Obs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_SCHED_OBS_FEATURE_COUNT = GQAMPackage.GA_TIMED_OBS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl <em>Sa Comm Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaCommHost()
	 * @generated
	 */
	int SA_COMM_HOST = 6;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__RES_MULT = GQAMPackage.GA_COMM_HOST__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__IS_PROTECTED = GQAMPackage.GA_COMM_HOST__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__IS_ACTIVE = GQAMPackage.GA_COMM_HOST__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_PROPERTY = GQAMPackage.GA_COMM_HOST__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_INSTANCE_SPECIFICATION = GQAMPackage.GA_COMM_HOST__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_CLASSIFIER = GQAMPackage.GA_COMM_HOST__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_LIFELINE = GQAMPackage.GA_COMM_HOST__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_CONNECTABLE_ELEMENT = GQAMPackage.GA_COMM_HOST__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__SPEED_FACTOR = GQAMPackage.GA_COMM_HOST__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__MAIN_SCHEDULER = GQAMPackage.GA_COMM_HOST__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__ELEMENT_SIZE = GQAMPackage.GA_COMM_HOST__ELEMENT_SIZE;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BASE_CONNECTOR = GQAMPackage.GA_COMM_HOST__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__TRANSM_MODE = GQAMPackage.GA_COMM_HOST__TRANSM_MODE;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__BLOCK_T = GQAMPackage.GA_COMM_HOST__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__PACKET_T = GQAMPackage.GA_COMM_HOST__PACKET_T;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__CAPACITY = GQAMPackage.GA_COMM_HOST__CAPACITY;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__IS_PREEMPTIBLE = GQAMPackage.GA_COMM_HOST__IS_PREEMPTIBLE;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__SCHED_POLICY = GQAMPackage.GA_COMM_HOST__SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__OTHER_SCHED_POLICY = GQAMPackage.GA_COMM_HOST__OTHER_SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__SCHEDULE = GQAMPackage.GA_COMM_HOST__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__PROCESSING_UNITS = GQAMPackage.GA_COMM_HOST__PROCESSING_UNITS;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__HOST = GQAMPackage.GA_COMM_HOST__HOST;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__PROTECTED_SHARED_RESOURCES = GQAMPackage.GA_COMM_HOST__PROTECTED_SHARED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__SCHEDULABLE_RESOURCES = GQAMPackage.GA_COMM_HOST__SCHEDULABLE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__THROUGHPUT = GQAMPackage.GA_COMM_HOST__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__UTILIZATION = GQAMPackage.GA_COMM_HOST__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__IS_SCHED = GQAMPackage.GA_COMM_HOST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST__SCH_SLACK = GQAMPackage.GA_COMM_HOST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sa Comm Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_COMM_HOST_FEATURE_COUNT = GQAMPackage.GA_COMM_HOST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl <em>Sa Exec Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaExecHost()
	 * @generated
	 */
	int SA_EXEC_HOST = 7;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__RES_MULT = GQAMPackage.GA_EXEC_HOST__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_PROTECTED = GQAMPackage.GA_EXEC_HOST__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_ACTIVE = GQAMPackage.GA_EXEC_HOST__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__BASE_PROPERTY = GQAMPackage.GA_EXEC_HOST__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__BASE_INSTANCE_SPECIFICATION = GQAMPackage.GA_EXEC_HOST__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__BASE_CLASSIFIER = GQAMPackage.GA_EXEC_HOST__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__BASE_LIFELINE = GQAMPackage.GA_EXEC_HOST__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__BASE_CONNECTABLE_ELEMENT = GQAMPackage.GA_EXEC_HOST__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_PREEMPTIBLE = GQAMPackage.GA_EXEC_HOST__IS_PREEMPTIBLE;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCHED_POLICY = GQAMPackage.GA_EXEC_HOST__SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__OTHER_SCHED_POLICY = GQAMPackage.GA_EXEC_HOST__OTHER_SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCHEDULE = GQAMPackage.GA_EXEC_HOST__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__PROCESSING_UNITS = GQAMPackage.GA_EXEC_HOST__PROCESSING_UNITS;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__HOST = GQAMPackage.GA_EXEC_HOST__HOST;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__PROTECTED_SHARED_RESOURCES = GQAMPackage.GA_EXEC_HOST__PROTECTED_SHARED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCHEDULABLE_RESOURCES = GQAMPackage.GA_EXEC_HOST__SCHEDULABLE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SPEED_FACTOR = GQAMPackage.GA_EXEC_HOST__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__MAIN_SCHEDULER = GQAMPackage.GA_EXEC_HOST__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Comm Tx Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__COMM_TX_OVH = GQAMPackage.GA_EXEC_HOST__COMM_TX_OVH;

	/**
	 * The feature id for the '<em><b>Comm Rcv Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__COMM_RCV_OVH = GQAMPackage.GA_EXEC_HOST__COMM_RCV_OVH;

	/**
	 * The feature id for the '<em><b>Cntxt Sw T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__CNTXT_SW_T = GQAMPackage.GA_EXEC_HOST__CNTXT_SW_T;

	/**
	 * The feature id for the '<em><b>Clock Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__CLOCK_OVH = GQAMPackage.GA_EXEC_HOST__CLOCK_OVH;

	/**
	 * The feature id for the '<em><b>Sched Pri Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCHED_PRI_RANGE = GQAMPackage.GA_EXEC_HOST__SCHED_PRI_RANGE;

	/**
	 * The feature id for the '<em><b>Mem Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__MEM_SIZE = GQAMPackage.GA_EXEC_HOST__MEM_SIZE;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__UTILIZATION = GQAMPackage.GA_EXEC_HOST__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__THROUGHPUT = GQAMPackage.GA_EXEC_HOST__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_SCHED = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sch Slack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCH_SLACK = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sched Utiliz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__SCHED_UTILIZ = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>IS Rswitch T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_RSWITCH_T = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>IS Rprio Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST__IS_RPRIO_RANGE = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sa Exec Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SA_EXEC_HOST_FEATURE_COUNT = GQAMPackage.GA_EXEC_HOST_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind <em>Optimallity Criterion Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getOptimallityCriterionKind()
	 * @generated
	 */
	int OPTIMALLITY_CRITERION_KIND = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext <em>Sa Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Analysis Context</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext
	 * @generated
	 */
	EClass getSaAnalysisContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getIsSched <em>Is Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sched</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getIsSched()
	 * @see #getSaAnalysisContext()
	 * @generated
	 */
	EAttribute getSaAnalysisContext_IsSched();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getOptCriterion <em>Opt Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opt Criterion</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getOptCriterion()
	 * @see #getSaAnalysisContext()
	 * @generated
	 */
	EAttribute getSaAnalysisContext_OptCriterion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow <em>Sa Endto End Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Endto End Flow</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow
	 * @generated
	 */
	EClass getSaEndtoEndFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getIsSched <em>Is Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sched</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getIsSched()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EAttribute getSaEndtoEndFlow_IsSched();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getSchSlack <em>Sch Slack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sch Slack</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getSchSlack()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EAttribute getSaEndtoEndFlow_SchSlack();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getEnd2EndT <em>End2 End T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>End2 End T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getEnd2EndT()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EAttribute getSaEndtoEndFlow_End2EndT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getEnd2EndD <em>End2 End D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>End2 End D</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getEnd2EndD()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EAttribute getSaEndtoEndFlow_End2EndD();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getTiming <em>Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Timing</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getTiming()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EReference getSaEndtoEndFlow_Timing();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow#getBase_NamedElement()
	 * @see #getSaEndtoEndFlow()
	 * @generated
	 */
	EReference getSaEndtoEndFlow_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep <em>Sa Comm Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Comm Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep
	 * @generated
	 */
	EClass getSaCommStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getDeadline()
	 * @see #getSaCommStep()
	 * @generated
	 */
	EAttribute getSaCommStep_Deadline();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getSpareCap <em>Spare Cap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spare Cap</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getSpareCap()
	 * @see #getSaCommStep()
	 * @generated
	 */
	EAttribute getSaCommStep_SpareCap();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getSchSlack <em>Sch Slack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sch Slack</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getSchSlack()
	 * @see #getSaCommStep()
	 * @generated
	 */
	EAttribute getSaCommStep_SchSlack();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommStep#getBase_BehavioralFeature()
	 * @see #getSaCommStep()
	 * @generated
	 */
	EReference getSaCommStep_Base_BehavioralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep <em>Sa Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep
	 * @generated
	 */
	EClass getSaStep();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getBase_BehavioralFeature()
	 * @see #getSaStep()
	 * @generated
	 */
	EReference getSaStep_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getDeadline()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_Deadline();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSpareCap <em>Spare Cap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spare Cap</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSpareCap()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_SpareCap();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSchSlack <em>Sch Slack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sch Slack</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSchSlack()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_SchSlack();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getPreemptT <em>Preempt T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preempt T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getPreemptT()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_PreemptT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getReadyT <em>Ready T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ready T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getReadyT()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_ReadyT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNonpreemptionBlocking <em>Nonpreemption Blocking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nonpreemption Blocking</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNonpreemptionBlocking()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_NonpreemptionBlocking();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSharedRes <em>Shared Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Res</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSharedRes()
	 * @see #getSaStep()
	 * @generated
	 */
	EReference getSaStep_SharedRes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSelfSuspensionBlocking <em>Self Suspension Blocking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Suspension Blocking</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getSelfSuspensionBlocking()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_SelfSuspensionBlocking();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNumberSelfSuspensions <em>Number Self Suspensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Self Suspensions</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep#getNumberSelfSuspensions()
	 * @see #getSaStep()
	 * @generated
	 */
	EAttribute getSaStep_NumberSelfSuspensions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource <em>Sa Shared Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Shared Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource
	 * @generated
	 */
	EClass getSaSharedResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getCapacity()
	 * @see #getSaSharedResource()
	 * @generated
	 */
	EAttribute getSaSharedResource_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsPreemp <em>Is Preemp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Preemp</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsPreemp()
	 * @see #getSaSharedResource()
	 * @generated
	 */
	EAttribute getSaSharedResource_IsPreemp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsConsum <em>Is Consum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Consum</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getIsConsum()
	 * @see #getSaSharedResource()
	 * @generated
	 */
	EAttribute getSaSharedResource_IsConsum();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getAcquisT <em>Acquis T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Acquis T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getAcquisT()
	 * @see #getSaSharedResource()
	 * @generated
	 */
	EAttribute getSaSharedResource_AcquisT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getReleaseT <em>Release T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Release T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource#getReleaseT()
	 * @see #getSaSharedResource()
	 * @generated
	 */
	EAttribute getSaSharedResource_ReleaseT();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs <em>Sa Sched Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Sched Obs</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs
	 * @generated
	 */
	EClass getSaSchedObs();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getSuspentions <em>Suspentions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Suspentions</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getSuspentions()
	 * @see #getSaSchedObs()
	 * @generated
	 */
	EAttribute getSaSchedObs_Suspentions();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getBlockT <em>Block T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Block T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getBlockT()
	 * @see #getSaSchedObs()
	 * @generated
	 */
	EAttribute getSaSchedObs_BlockT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getOverlaps <em>Overlaps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Overlaps</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSchedObs#getOverlaps()
	 * @see #getSaSchedObs()
	 * @generated
	 */
	EAttribute getSaSchedObs_Overlaps();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost <em>Sa Comm Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Comm Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost
	 * @generated
	 */
	EClass getSaCommHost();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost#getIsSched <em>Is Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sched</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost#getIsSched()
	 * @see #getSaCommHost()
	 * @generated
	 */
	EAttribute getSaCommHost_IsSched();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost#getSchSlack <em>Sch Slack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sch Slack</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost#getSchSlack()
	 * @see #getSaCommHost()
	 * @generated
	 */
	EAttribute getSaCommHost_SchSlack();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost <em>Sa Exec Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sa Exec Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost
	 * @generated
	 */
	EClass getSaExecHost();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getIsSched <em>Is Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sched</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getIsSched()
	 * @see #getSaExecHost()
	 * @generated
	 */
	EAttribute getSaExecHost_IsSched();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchSlack <em>Sch Slack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sch Slack</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchSlack()
	 * @see #getSaExecHost()
	 * @generated
	 */
	EAttribute getSaExecHost_SchSlack();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchedUtiliz <em>Sched Utiliz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sched Utiliz</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getSchedUtiliz()
	 * @see #getSaExecHost()
	 * @generated
	 */
	EAttribute getSaExecHost_SchedUtiliz();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRswitchT <em>IS Rswitch T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IS Rswitch T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRswitchT()
	 * @see #getSaExecHost()
	 * @generated
	 */
	EAttribute getSaExecHost_ISRswitchT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRprioRange <em>IS Rprio Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IS Rprio Range</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost#getISRprioRange()
	 * @see #getSaExecHost()
	 * @generated
	 */
	EAttribute getSaExecHost_ISRprioRange();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind <em>Optimallity Criterion Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Optimallity Criterion Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind
	 * @generated
	 */
	EEnum getOptimallityCriterionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SAMFactory getSAMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl <em>Sa Analysis Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaAnalysisContext()
		 * @generated
		 */
		EClass SA_ANALYSIS_CONTEXT = eINSTANCE.getSaAnalysisContext();

		/**
		 * The meta object literal for the '<em><b>Is Sched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ANALYSIS_CONTEXT__IS_SCHED = eINSTANCE.getSaAnalysisContext_IsSched();

		/**
		 * The meta object literal for the '<em><b>Opt Criterion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ANALYSIS_CONTEXT__OPT_CRITERION = eINSTANCE.getSaAnalysisContext_OptCriterion();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl <em>Sa Endto End Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaEndtoEndFlow()
		 * @generated
		 */
		EClass SA_ENDTO_END_FLOW = eINSTANCE.getSaEndtoEndFlow();

		/**
		 * The meta object literal for the '<em><b>Is Sched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ENDTO_END_FLOW__IS_SCHED = eINSTANCE.getSaEndtoEndFlow_IsSched();

		/**
		 * The meta object literal for the '<em><b>Sch Slack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ENDTO_END_FLOW__SCH_SLACK = eINSTANCE.getSaEndtoEndFlow_SchSlack();

		/**
		 * The meta object literal for the '<em><b>End2 End T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ENDTO_END_FLOW__END2_END_T = eINSTANCE.getSaEndtoEndFlow_End2EndT();

		/**
		 * The meta object literal for the '<em><b>End2 End D</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_ENDTO_END_FLOW__END2_END_D = eINSTANCE.getSaEndtoEndFlow_End2EndD();

		/**
		 * The meta object literal for the '<em><b>Timing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SA_ENDTO_END_FLOW__TIMING = eINSTANCE.getSaEndtoEndFlow_Timing();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT = eINSTANCE.getSaEndtoEndFlow_Base_NamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommStepImpl <em>Sa Comm Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaCommStep()
		 * @generated
		 */
		EClass SA_COMM_STEP = eINSTANCE.getSaCommStep();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_COMM_STEP__DEADLINE = eINSTANCE.getSaCommStep_Deadline();

		/**
		 * The meta object literal for the '<em><b>Spare Cap</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_COMM_STEP__SPARE_CAP = eINSTANCE.getSaCommStep_SpareCap();

		/**
		 * The meta object literal for the '<em><b>Sch Slack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_COMM_STEP__SCH_SLACK = eINSTANCE.getSaCommStep_SchSlack();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SA_COMM_STEP__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getSaCommStep_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl <em>Sa Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaStep()
		 * @generated
		 */
		EClass SA_STEP = eINSTANCE.getSaStep();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SA_STEP__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getSaStep_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__DEADLINE = eINSTANCE.getSaStep_Deadline();

		/**
		 * The meta object literal for the '<em><b>Spare Cap</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__SPARE_CAP = eINSTANCE.getSaStep_SpareCap();

		/**
		 * The meta object literal for the '<em><b>Sch Slack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__SCH_SLACK = eINSTANCE.getSaStep_SchSlack();

		/**
		 * The meta object literal for the '<em><b>Preempt T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__PREEMPT_T = eINSTANCE.getSaStep_PreemptT();

		/**
		 * The meta object literal for the '<em><b>Ready T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__READY_T = eINSTANCE.getSaStep_ReadyT();

		/**
		 * The meta object literal for the '<em><b>Nonpreemption Blocking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__NONPREEMPTION_BLOCKING = eINSTANCE.getSaStep_NonpreemptionBlocking();

		/**
		 * The meta object literal for the '<em><b>Shared Res</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SA_STEP__SHARED_RES = eINSTANCE.getSaStep_SharedRes();

		/**
		 * The meta object literal for the '<em><b>Self Suspension Blocking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__SELF_SUSPENSION_BLOCKING = eINSTANCE.getSaStep_SelfSuspensionBlocking();

		/**
		 * The meta object literal for the '<em><b>Number Self Suspensions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_STEP__NUMBER_SELF_SUSPENSIONS = eINSTANCE.getSaStep_NumberSelfSuspensions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl <em>Sa Shared Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSharedResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaSharedResource()
		 * @generated
		 */
		EClass SA_SHARED_RESOURCE = eINSTANCE.getSaSharedResource();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SHARED_RESOURCE__CAPACITY = eINSTANCE.getSaSharedResource_Capacity();

		/**
		 * The meta object literal for the '<em><b>Is Preemp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SHARED_RESOURCE__IS_PREEMP = eINSTANCE.getSaSharedResource_IsPreemp();

		/**
		 * The meta object literal for the '<em><b>Is Consum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SHARED_RESOURCE__IS_CONSUM = eINSTANCE.getSaSharedResource_IsConsum();

		/**
		 * The meta object literal for the '<em><b>Acquis T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SHARED_RESOURCE__ACQUIS_T = eINSTANCE.getSaSharedResource_AcquisT();

		/**
		 * The meta object literal for the '<em><b>Release T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SHARED_RESOURCE__RELEASE_T = eINSTANCE.getSaSharedResource_ReleaseT();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl <em>Sa Sched Obs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaSchedObsImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaSchedObs()
		 * @generated
		 */
		EClass SA_SCHED_OBS = eINSTANCE.getSaSchedObs();

		/**
		 * The meta object literal for the '<em><b>Suspentions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SCHED_OBS__SUSPENTIONS = eINSTANCE.getSaSchedObs_Suspentions();

		/**
		 * The meta object literal for the '<em><b>Block T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SCHED_OBS__BLOCK_T = eINSTANCE.getSaSchedObs_BlockT();

		/**
		 * The meta object literal for the '<em><b>Overlaps</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_SCHED_OBS__OVERLAPS = eINSTANCE.getSaSchedObs_Overlaps();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl <em>Sa Comm Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaCommHostImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaCommHost()
		 * @generated
		 */
		EClass SA_COMM_HOST = eINSTANCE.getSaCommHost();

		/**
		 * The meta object literal for the '<em><b>Is Sched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_COMM_HOST__IS_SCHED = eINSTANCE.getSaCommHost_IsSched();

		/**
		 * The meta object literal for the '<em><b>Sch Slack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_COMM_HOST__SCH_SLACK = eINSTANCE.getSaCommHost_SchSlack();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl <em>Sa Exec Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaExecHostImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getSaExecHost()
		 * @generated
		 */
		EClass SA_EXEC_HOST = eINSTANCE.getSaExecHost();

		/**
		 * The meta object literal for the '<em><b>Is Sched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_EXEC_HOST__IS_SCHED = eINSTANCE.getSaExecHost_IsSched();

		/**
		 * The meta object literal for the '<em><b>Sch Slack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_EXEC_HOST__SCH_SLACK = eINSTANCE.getSaExecHost_SchSlack();

		/**
		 * The meta object literal for the '<em><b>Sched Utiliz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_EXEC_HOST__SCHED_UTILIZ = eINSTANCE.getSaExecHost_SchedUtiliz();

		/**
		 * The meta object literal for the '<em><b>IS Rswitch T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_EXEC_HOST__IS_RSWITCH_T = eINSTANCE.getSaExecHost_ISRswitchT();

		/**
		 * The meta object literal for the '<em><b>IS Rprio Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SA_EXEC_HOST__IS_RPRIO_RANGE = eINSTANCE.getSaExecHost_ISRprioRange();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind <em>Optimallity Criterion Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl#getOptimallityCriterionKind()
		 * @generated
		 */
		EEnum OPTIMALLITY_CRITERION_KIND = eINSTANCE.getOptimallityCriterionKind();

	}

} //SAMPackage
