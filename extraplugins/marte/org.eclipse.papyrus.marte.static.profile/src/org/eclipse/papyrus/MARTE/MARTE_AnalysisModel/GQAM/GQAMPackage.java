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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMFactory
 * @model kind="package"
 * @generated
 */
public interface GQAMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GQAM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/GQAM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "GQAM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GQAMPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadGeneratorImpl <em>Ga Workload Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadGeneratorImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadGenerator()
	 * @generated
	 */
	int GA_WORKLOAD_GENERATOR = 0;

	/**
	 * The feature id for the '<em><b>Pop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_GENERATOR__POP = 0;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_GENERATOR__BASE_BEHAVIOR = 1;

	/**
	 * The number of structural features of the '<em>Ga Workload Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_GENERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaEventTraceImpl <em>Ga Event Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaEventTraceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaEventTrace()
	 * @generated
	 */
	int GA_EVENT_TRACE = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EVENT_TRACE__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EVENT_TRACE__FORMAT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EVENT_TRACE__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EVENT_TRACE__BASE_NAMED_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Ga Event Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EVENT_TRACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl <em>Ga Workload Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadEvent()
	 * @generated
	 */
	int GA_WORKLOAD_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__GENERATOR = 1;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__TRACE = 2;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__EFFECT = 3;

	/**
	 * The feature id for the '<em><b>Timed Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__TIMED_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Ga Workload Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_EVENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaScenarioImpl <em>Ga Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaScenarioImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaScenario()
	 * @generated
	 */
	int GA_SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__EXEC_TIME = GRMPackage.RESOURCE_USAGE__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__ALLOCATED_MEMORY = GRMPackage.RESOURCE_USAGE__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__USED_MEMORY = GRMPackage.RESOURCE_USAGE__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__POWER_PEAK = GRMPackage.RESOURCE_USAGE__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__ENERGY = GRMPackage.RESOURCE_USAGE__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__BASE_NAMED_ELEMENT = GRMPackage.RESOURCE_USAGE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__SUB_USAGE = GRMPackage.RESOURCE_USAGE__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__USED_RESOURCES = GRMPackage.RESOURCE_USAGE__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__MSG_SIZE = GRMPackage.RESOURCE_USAGE__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__ON = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__BASE_ACTION = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__BASE_BEHAVIOR = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__BASE_MESSAGE = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__DURATION = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__START = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__FINISH = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__CAUSE = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__HOST_DEMAND = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__HOST_DEMAND_OPS = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__INTER_OCC_T = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__THROUGHPUT = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__RESP_T = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__UTILIZATION = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__UTILIZATION_ON_HOST = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__ROOT = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__STEPS = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__PARENT_STEP = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO__TIMING = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>Ga Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_SCENARIO_FEATURE_COUNT = GRMPackage.RESOURCE_USAGE_FEATURE_COUNT + 19;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl <em>Ga Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaStep()
	 * @generated
	 */
	int GA_STEP = 4;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__EXEC_TIME = GA_SCENARIO__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__ALLOCATED_MEMORY = GA_SCENARIO__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__USED_MEMORY = GA_SCENARIO__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__POWER_PEAK = GA_SCENARIO__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__ENERGY = GA_SCENARIO__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__BASE_NAMED_ELEMENT = GA_SCENARIO__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__SUB_USAGE = GA_SCENARIO__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__USED_RESOURCES = GA_SCENARIO__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__MSG_SIZE = GA_SCENARIO__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__ON = GA_SCENARIO__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__BASE_ACTION = GA_SCENARIO__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__BASE_BEHAVIOR = GA_SCENARIO__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__BASE_MESSAGE = GA_SCENARIO__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__DURATION = GA_SCENARIO__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__START = GA_SCENARIO__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__FINISH = GA_SCENARIO__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__CAUSE = GA_SCENARIO__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__HOST_DEMAND = GA_SCENARIO__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__HOST_DEMAND_OPS = GA_SCENARIO__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__INTER_OCC_T = GA_SCENARIO__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__THROUGHPUT = GA_SCENARIO__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__RESP_T = GA_SCENARIO__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__UTILIZATION = GA_SCENARIO__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__UTILIZATION_ON_HOST = GA_SCENARIO__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__ROOT = GA_SCENARIO__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__STEPS = GA_SCENARIO__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__PARENT_STEP = GA_SCENARIO__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__TIMING = GA_SCENARIO__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__IS_ATOMIC = GA_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__BLOCK_T = GA_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__REP = GA_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__PROB = GA_SCENARIO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__PRIORITY = GA_SCENARIO_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__CONCUR_RES = GA_SCENARIO_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__HOST = GA_SCENARIO_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__SERV_DEMAND = GA_SCENARIO_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__SERV_COUNT = GA_SCENARIO_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__SELF_DELAY = GA_SCENARIO_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__SCENARIO = GA_SCENARIO_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP__CHILD_SCENARIO = GA_SCENARIO_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Ga Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_STEP_FEATURE_COUNT = GA_SCENARIO_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl <em>Ga Exec Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaExecHost()
	 * @generated
	 */
	int GA_EXEC_HOST = 5;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__RES_MULT = GRMPackage.SCHEDULER__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__IS_PROTECTED = GRMPackage.SCHEDULER__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__IS_ACTIVE = GRMPackage.SCHEDULER__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__BASE_PROPERTY = GRMPackage.SCHEDULER__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__BASE_INSTANCE_SPECIFICATION = GRMPackage.SCHEDULER__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__BASE_CLASSIFIER = GRMPackage.SCHEDULER__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__BASE_LIFELINE = GRMPackage.SCHEDULER__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__BASE_CONNECTABLE_ELEMENT = GRMPackage.SCHEDULER__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__IS_PREEMPTIBLE = GRMPackage.SCHEDULER__IS_PREEMPTIBLE;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__SCHED_POLICY = GRMPackage.SCHEDULER__SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__OTHER_SCHED_POLICY = GRMPackage.SCHEDULER__OTHER_SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__SCHEDULE = GRMPackage.SCHEDULER__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__PROCESSING_UNITS = GRMPackage.SCHEDULER__PROCESSING_UNITS;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__HOST = GRMPackage.SCHEDULER__HOST;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__PROTECTED_SHARED_RESOURCES = GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__SCHEDULABLE_RESOURCES = GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__SPEED_FACTOR = GRMPackage.SCHEDULER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__MAIN_SCHEDULER = GRMPackage.SCHEDULER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comm Tx Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__COMM_TX_OVH = GRMPackage.SCHEDULER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comm Rcv Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__COMM_RCV_OVH = GRMPackage.SCHEDULER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cntxt Sw T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__CNTXT_SW_T = GRMPackage.SCHEDULER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Clock Ovh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__CLOCK_OVH = GRMPackage.SCHEDULER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sched Pri Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__SCHED_PRI_RANGE = GRMPackage.SCHEDULER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Mem Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__MEM_SIZE = GRMPackage.SCHEDULER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__UTILIZATION = GRMPackage.SCHEDULER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST__THROUGHPUT = GRMPackage.SCHEDULER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Ga Exec Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_EXEC_HOST_FEATURE_COUNT = GRMPackage.SCHEDULER_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRequestedServiceImpl <em>Ga Requested Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRequestedServiceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaRequestedService()
	 * @generated
	 */
	int GA_REQUESTED_SERVICE = 6;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__EXEC_TIME = GA_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__ALLOCATED_MEMORY = GA_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__USED_MEMORY = GA_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__POWER_PEAK = GA_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__ENERGY = GA_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BASE_NAMED_ELEMENT = GA_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__SUB_USAGE = GA_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__USED_RESOURCES = GA_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__MSG_SIZE = GA_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__ON = GA_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BASE_ACTION = GA_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BASE_BEHAVIOR = GA_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BASE_MESSAGE = GA_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__DURATION = GA_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__START = GA_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__FINISH = GA_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__CAUSE = GA_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__HOST_DEMAND = GA_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__HOST_DEMAND_OPS = GA_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__INTER_OCC_T = GA_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__THROUGHPUT = GA_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__RESP_T = GA_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__UTILIZATION = GA_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__UTILIZATION_ON_HOST = GA_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__ROOT = GA_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__STEPS = GA_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__PARENT_STEP = GA_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__TIMING = GA_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__IS_ATOMIC = GA_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BLOCK_T = GA_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__REP = GA_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__PROB = GA_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__PRIORITY = GA_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__CONCUR_RES = GA_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__HOST = GA_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__SERV_DEMAND = GA_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__SERV_COUNT = GA_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__SELF_DELAY = GA_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__SCENARIO = GA_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__CHILD_SCENARIO = GA_STEP__CHILD_SCENARIO;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE__BASE_OPERATION = GA_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ga Requested Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REQUESTED_SERVICE_FEATURE_COUNT = GA_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl <em>Ga Timed Obs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaTimedObs()
	 * @generated
	 */
	int GA_TIMED_OBS = 7;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__LAXITY = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__START_OBS = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS__END_OBS = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ga Timed Obs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_TIMED_OBS_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommStepImpl <em>Ga Comm Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommStep()
	 * @generated
	 */
	int GA_COMM_STEP = 8;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__EXEC_TIME = GA_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__ALLOCATED_MEMORY = GA_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__USED_MEMORY = GA_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__POWER_PEAK = GA_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__ENERGY = GA_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__BASE_NAMED_ELEMENT = GA_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__SUB_USAGE = GA_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__USED_RESOURCES = GA_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__MSG_SIZE = GA_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__ON = GA_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__BASE_ACTION = GA_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__BASE_BEHAVIOR = GA_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__BASE_MESSAGE = GA_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__DURATION = GA_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__START = GA_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__FINISH = GA_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__CAUSE = GA_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__HOST_DEMAND = GA_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__HOST_DEMAND_OPS = GA_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__INTER_OCC_T = GA_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__THROUGHPUT = GA_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__RESP_T = GA_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__UTILIZATION = GA_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__UTILIZATION_ON_HOST = GA_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__ROOT = GA_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__STEPS = GA_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__PARENT_STEP = GA_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__TIMING = GA_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__IS_ATOMIC = GA_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__BLOCK_T = GA_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__REP = GA_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__PROB = GA_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__PRIORITY = GA_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__CONCUR_RES = GA_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__HOST = GA_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__SERV_DEMAND = GA_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__SERV_COUNT = GA_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__SELF_DELAY = GA_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__SCENARIO = GA_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP__CHILD_SCENARIO = GA_STEP__CHILD_SCENARIO;

	/**
	 * The number of structural features of the '<em>Ga Comm Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_STEP_FEATURE_COUNT = GA_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl <em>Ga Acq Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaAcqStep()
	 * @generated
	 */
	int GA_ACQ_STEP = 9;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__EXEC_TIME = GA_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__ALLOCATED_MEMORY = GA_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__USED_MEMORY = GA_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__POWER_PEAK = GA_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__ENERGY = GA_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__BASE_NAMED_ELEMENT = GA_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__SUB_USAGE = GA_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__USED_RESOURCES = GA_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__MSG_SIZE = GA_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__ON = GA_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__BASE_ACTION = GA_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__BASE_BEHAVIOR = GA_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__BASE_MESSAGE = GA_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__DURATION = GA_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__START = GA_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__FINISH = GA_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__CAUSE = GA_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__HOST_DEMAND = GA_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__HOST_DEMAND_OPS = GA_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__INTER_OCC_T = GA_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__THROUGHPUT = GA_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__RESP_T = GA_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__UTILIZATION = GA_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__UTILIZATION_ON_HOST = GA_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__ROOT = GA_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__STEPS = GA_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__PARENT_STEP = GA_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__TIMING = GA_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__IS_ATOMIC = GA_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__BLOCK_T = GA_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__REP = GA_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__PROB = GA_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__PRIORITY = GA_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__CONCUR_RES = GA_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__HOST = GA_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__SERV_DEMAND = GA_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__SERV_COUNT = GA_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__SELF_DELAY = GA_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__SCENARIO = GA_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__CHILD_SCENARIO = GA_STEP__CHILD_SCENARIO;

	/**
	 * The feature id for the '<em><b>Acq Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__ACQ_RES = GA_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Res Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP__RES_UNITS = GA_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ga Acq Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ACQ_STEP_FEATURE_COUNT = GA_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl <em>Ga Rel Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaRelStep()
	 * @generated
	 */
	int GA_REL_STEP = 10;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__EXEC_TIME = GA_STEP__EXEC_TIME;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__ALLOCATED_MEMORY = GA_STEP__ALLOCATED_MEMORY;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__USED_MEMORY = GA_STEP__USED_MEMORY;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__POWER_PEAK = GA_STEP__POWER_PEAK;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__ENERGY = GA_STEP__ENERGY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__BASE_NAMED_ELEMENT = GA_STEP__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__SUB_USAGE = GA_STEP__SUB_USAGE;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__USED_RESOURCES = GA_STEP__USED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__MSG_SIZE = GA_STEP__MSG_SIZE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__ON = GA_STEP__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__BASE_ACTION = GA_STEP__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__BASE_BEHAVIOR = GA_STEP__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__BASE_MESSAGE = GA_STEP__BASE_MESSAGE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__DURATION = GA_STEP__DURATION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__START = GA_STEP__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__FINISH = GA_STEP__FINISH;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__CAUSE = GA_STEP__CAUSE;

	/**
	 * The feature id for the '<em><b>Host Demand</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__HOST_DEMAND = GA_STEP__HOST_DEMAND;

	/**
	 * The feature id for the '<em><b>Host Demand Ops</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__HOST_DEMAND_OPS = GA_STEP__HOST_DEMAND_OPS;

	/**
	 * The feature id for the '<em><b>Inter Occ T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__INTER_OCC_T = GA_STEP__INTER_OCC_T;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__THROUGHPUT = GA_STEP__THROUGHPUT;

	/**
	 * The feature id for the '<em><b>Resp T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__RESP_T = GA_STEP__RESP_T;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__UTILIZATION = GA_STEP__UTILIZATION;

	/**
	 * The feature id for the '<em><b>Utilization On Host</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__UTILIZATION_ON_HOST = GA_STEP__UTILIZATION_ON_HOST;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__ROOT = GA_STEP__ROOT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__STEPS = GA_STEP__STEPS;

	/**
	 * The feature id for the '<em><b>Parent Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__PARENT_STEP = GA_STEP__PARENT_STEP;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__TIMING = GA_STEP__TIMING;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__IS_ATOMIC = GA_STEP__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__BLOCK_T = GA_STEP__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Rep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__REP = GA_STEP__REP;

	/**
	 * The feature id for the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__PROB = GA_STEP__PROB;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__PRIORITY = GA_STEP__PRIORITY;

	/**
	 * The feature id for the '<em><b>Concur Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__CONCUR_RES = GA_STEP__CONCUR_RES;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__HOST = GA_STEP__HOST;

	/**
	 * The feature id for the '<em><b>Serv Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__SERV_DEMAND = GA_STEP__SERV_DEMAND;

	/**
	 * The feature id for the '<em><b>Serv Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__SERV_COUNT = GA_STEP__SERV_COUNT;

	/**
	 * The feature id for the '<em><b>Self Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__SELF_DELAY = GA_STEP__SELF_DELAY;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__SCENARIO = GA_STEP__SCENARIO;

	/**
	 * The feature id for the '<em><b>Child Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__CHILD_SCENARIO = GA_STEP__CHILD_SCENARIO;

	/**
	 * The feature id for the '<em><b>Rel Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__REL_RES = GA_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Res Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP__RES_UNITS = GA_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ga Rel Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_REL_STEP_FEATURE_COUNT = GA_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl <em>Ga Latency Obs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaLatencyObs()
	 * @generated
	 */
	int GA_LATENCY_OBS = 11;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__KIND = GA_TIMED_OBS__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__BASE_CONSTRAINT = GA_TIMED_OBS__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__MODE = GA_TIMED_OBS__MODE;

	/**
	 * The feature id for the '<em><b>Laxity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__LAXITY = GA_TIMED_OBS__LAXITY;

	/**
	 * The feature id for the '<em><b>Start Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__START_OBS = GA_TIMED_OBS__START_OBS;

	/**
	 * The feature id for the '<em><b>End Obs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__END_OBS = GA_TIMED_OBS__END_OBS;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__LATENCY = GA_TIMED_OBS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Miss</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__MISS = GA_TIMED_OBS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Utility</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__UTILITY = GA_TIMED_OBS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Jitter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS__MAX_JITTER = GA_TIMED_OBS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ga Latency Obs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_LATENCY_OBS_FEATURE_COUNT = GA_TIMED_OBS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommHostImpl <em>Ga Comm Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommHostImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommHost()
	 * @generated
	 */
	int GA_COMM_HOST = 12;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__RES_MULT = GRMPackage.COMMUNICATION_MEDIA__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__IS_PROTECTED = GRMPackage.COMMUNICATION_MEDIA__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__IS_ACTIVE = GRMPackage.COMMUNICATION_MEDIA__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_PROPERTY = GRMPackage.COMMUNICATION_MEDIA__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_INSTANCE_SPECIFICATION = GRMPackage.COMMUNICATION_MEDIA__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_CLASSIFIER = GRMPackage.COMMUNICATION_MEDIA__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_LIFELINE = GRMPackage.COMMUNICATION_MEDIA__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_CONNECTABLE_ELEMENT = GRMPackage.COMMUNICATION_MEDIA__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__SPEED_FACTOR = GRMPackage.COMMUNICATION_MEDIA__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__MAIN_SCHEDULER = GRMPackage.COMMUNICATION_MEDIA__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__ELEMENT_SIZE = GRMPackage.COMMUNICATION_MEDIA__ELEMENT_SIZE;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BASE_CONNECTOR = GRMPackage.COMMUNICATION_MEDIA__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__TRANSM_MODE = GRMPackage.COMMUNICATION_MEDIA__TRANSM_MODE;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__BLOCK_T = GRMPackage.COMMUNICATION_MEDIA__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__PACKET_T = GRMPackage.COMMUNICATION_MEDIA__PACKET_T;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__CAPACITY = GRMPackage.COMMUNICATION_MEDIA__CAPACITY;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__IS_PREEMPTIBLE = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__SCHED_POLICY = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__OTHER_SCHED_POLICY = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__SCHEDULE = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__PROCESSING_UNITS = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__HOST = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__PROTECTED_SHARED_RESOURCES = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__SCHEDULABLE_RESOURCES = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Throughput</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__THROUGHPUT = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST__UTILIZATION = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Ga Comm Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_HOST_FEATURE_COUNT = GRMPackage.COMMUNICATION_MEDIA_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl <em>Ga Comm Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommChannel()
	 * @generated
	 */
	int GA_COMM_CHANNEL = 13;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__RES_MULT = GRMPackage.SCHEDULABLE_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__IS_PROTECTED = GRMPackage.SCHEDULABLE_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__IS_ACTIVE = GRMPackage.SCHEDULABLE_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__BASE_PROPERTY = GRMPackage.SCHEDULABLE_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__BASE_INSTANCE_SPECIFICATION = GRMPackage.SCHEDULABLE_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__BASE_CLASSIFIER = GRMPackage.SCHEDULABLE_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__BASE_LIFELINE = GRMPackage.SCHEDULABLE_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__BASE_CONNECTABLE_ELEMENT = GRMPackage.SCHEDULABLE_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sched Params</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__SCHED_PARAMS = GRMPackage.SCHEDULABLE_RESOURCE__SCHED_PARAMS;

	/**
	 * The feature id for the '<em><b>Dependent Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__DEPENDENT_SCHEDULER = GRMPackage.SCHEDULABLE_RESOURCE__DEPENDENT_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__HOST = GRMPackage.SCHEDULABLE_RESOURCE__HOST;

	/**
	 * The feature id for the '<em><b>Packet Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__PACKET_SIZE = GRMPackage.SCHEDULABLE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL__UTILIZATION = GRMPackage.SCHEDULABLE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ga Comm Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_COMM_CHANNEL_FEATURE_COUNT = GRMPackage.SCHEDULABLE_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl <em>Ga Workload Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadBehavior()
	 * @generated
	 */
	int GA_WORKLOAD_BEHAVIOR = 14;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_BEHAVIOR__BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_BEHAVIOR__DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Ga Workload Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_WORKLOAD_BEHAVIOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl <em>Ga Analysis Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaAnalysisContext()
	 * @generated
	 */
	int GA_ANALYSIS_CONTEXT = 15;

	/**
	 * The feature id for the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__BASE_STRUCTURED_CLASSIFIER = CoreElementsPackage.CONFIGURATION__BASE_STRUCTURED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__BASE_PACKAGE = CoreElementsPackage.CONFIGURATION__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__MODE = CoreElementsPackage.CONFIGURATION__MODE;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT = CoreElementsPackage.CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__CONTEXT = CoreElementsPackage.CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__WORKLOAD = CoreElementsPackage.CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT__PLATFORM = CoreElementsPackage.CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ga Analysis Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_ANALYSIS_CONTEXT_FEATURE_COUNT = CoreElementsPackage.CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaResourcesPlatformImpl <em>Ga Resources Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaResourcesPlatformImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaResourcesPlatform()
	 * @generated
	 */
	int GA_RESOURCES_PLATFORM = 16;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_RESOURCES_PLATFORM__RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_RESOURCES_PLATFORM__BASE_CLASSIFIER = 1;

	/**
	 * The number of structural features of the '<em>Ga Resources Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GA_RESOURCES_PLATFORM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind <em>Laxity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getLaxityKind()
	 * @generated
	 */
	int LAXITY_KIND = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator <em>Ga Workload Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Workload Generator</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator
	 * @generated
	 */
	EClass getGaWorkloadGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator#getPop <em>Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pop</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator#getPop()
	 * @see #getGaWorkloadGenerator()
	 * @generated
	 */
	EAttribute getGaWorkloadGenerator_Pop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator#getBase_Behavior()
	 * @see #getGaWorkloadGenerator()
	 * @generated
	 */
	EReference getGaWorkloadGenerator_Base_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace <em>Ga Event Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Event Trace</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace
	 * @generated
	 */
	EClass getGaEventTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getContent()
	 * @see #getGaEventTrace()
	 * @generated
	 */
	EAttribute getGaEventTrace_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getFormat()
	 * @see #getGaEventTrace()
	 * @generated
	 */
	EAttribute getGaEventTrace_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getLocation()
	 * @see #getGaEventTrace()
	 * @generated
	 */
	EAttribute getGaEventTrace_Location();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace#getBase_NamedElement()
	 * @see #getGaEventTrace()
	 * @generated
	 */
	EReference getGaEventTrace_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent <em>Ga Workload Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Workload Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent
	 * @generated
	 */
	EClass getGaWorkloadEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getPattern()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EAttribute getGaWorkloadEvent_Pattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generator</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getGenerator()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EReference getGaWorkloadEvent_Generator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trace</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getTrace()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EReference getGaWorkloadEvent_Trace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Effect</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getEffect()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EReference getGaWorkloadEvent_Effect();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getTimedEvent <em>Timed Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Timed Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getTimedEvent()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EReference getGaWorkloadEvent_TimedEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent#getBase_NamedElement()
	 * @see #getGaWorkloadEvent()
	 * @generated
	 */
	EReference getGaWorkloadEvent_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario <em>Ga Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Scenario</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario
	 * @generated
	 */
	EClass getGaScenario();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cause</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getCause()
	 * @see #getGaScenario()
	 * @generated
	 */
	EReference getGaScenario_Cause();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getHostDemand <em>Host Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Host Demand</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getHostDemand()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_HostDemand();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getHostDemandOps <em>Host Demand Ops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Host Demand Ops</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getHostDemandOps()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_HostDemandOps();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getInterOccT <em>Inter Occ T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Inter Occ T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getInterOccT()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_InterOccT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getThroughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Throughput</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getThroughput()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_Throughput();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getRespT <em>Resp T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resp T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getRespT()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_RespT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Utilization</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getUtilization()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_Utilization();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getUtilizationOnHost <em>Utilization On Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Utilization On Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getUtilizationOnHost()
	 * @see #getGaScenario()
	 * @generated
	 */
	EAttribute getGaScenario_UtilizationOnHost();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getRoot()
	 * @see #getGaScenario()
	 * @generated
	 */
	EReference getGaScenario_Root();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Steps</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getSteps()
	 * @see #getGaScenario()
	 * @generated
	 */
	EReference getGaScenario_Steps();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getParentStep <em>Parent Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getParentStep()
	 * @see #getGaScenario()
	 * @generated
	 */
	EReference getGaScenario_ParentStep();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getTiming <em>Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Timing</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario#getTiming()
	 * @see #getGaScenario()
	 * @generated
	 */
	EReference getGaScenario_Timing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep <em>Ga Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep
	 * @generated
	 */
	EClass getGaStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getIsAtomic <em>Is Atomic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Atomic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getIsAtomic()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_IsAtomic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getBlockT <em>Block T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getBlockT()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_BlockT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getRep <em>Rep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rep</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getRep()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_Rep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getProb <em>Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prob</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getProb()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_Prob();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getPriority()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_Priority();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getConcurRes <em>Concur Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Concur Res</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getConcurRes()
	 * @see #getGaStep()
	 * @generated
	 */
	EReference getGaStep_ConcurRes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getHost()
	 * @see #getGaStep()
	 * @generated
	 */
	EReference getGaStep_Host();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getServDemand <em>Serv Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serv Demand</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getServDemand()
	 * @see #getGaStep()
	 * @generated
	 */
	EReference getGaStep_ServDemand();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getServCount <em>Serv Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Serv Count</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getServCount()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_ServCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getSelfDelay <em>Self Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Delay</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getSelfDelay()
	 * @see #getGaStep()
	 * @generated
	 */
	EAttribute getGaStep_SelfDelay();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scenario</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getScenario()
	 * @see #getGaStep()
	 * @generated
	 */
	EReference getGaStep_Scenario();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getChildScenario <em>Child Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child Scenario</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep#getChildScenario()
	 * @see #getGaStep()
	 * @generated
	 */
	EReference getGaStep_ChildScenario();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost <em>Ga Exec Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Exec Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost
	 * @generated
	 */
	EClass getGaExecHost();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCommTxOvh <em>Comm Tx Ovh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comm Tx Ovh</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCommTxOvh()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_CommTxOvh();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCommRcvOvh <em>Comm Rcv Ovh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comm Rcv Ovh</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCommRcvOvh()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_CommRcvOvh();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCntxtSwT <em>Cntxt Sw T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cntxt Sw T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getCntxtSwT()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_CntxtSwT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getClockOvh <em>Clock Ovh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Ovh</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getClockOvh()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_ClockOvh();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getSchedPriRange <em>Sched Pri Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sched Pri Range</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getSchedPriRange()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_SchedPriRange();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getMemSize <em>Mem Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mem Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getMemSize()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_MemSize();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Utilization</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getUtilization()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_Utilization();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getThroughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Throughput</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost#getThroughput()
	 * @see #getGaExecHost()
	 * @generated
	 */
	EAttribute getGaExecHost_Throughput();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService <em>Ga Requested Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Requested Service</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService
	 * @generated
	 */
	EClass getGaRequestedService();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService#getBase_Operation()
	 * @see #getGaRequestedService()
	 * @generated
	 */
	EReference getGaRequestedService_Base_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs <em>Ga Timed Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Timed Obs</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs
	 * @generated
	 */
	EClass getGaTimedObs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getLaxity <em>Laxity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Laxity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getLaxity()
	 * @see #getGaTimedObs()
	 * @generated
	 */
	EAttribute getGaTimedObs_Laxity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getStartObs <em>Start Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Start Obs</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getStartObs()
	 * @see #getGaTimedObs()
	 * @generated
	 */
	EReference getGaTimedObs_StartObs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getEndObs <em>End Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>End Obs</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getEndObs()
	 * @see #getGaTimedObs()
	 * @generated
	 */
	EReference getGaTimedObs_EndObs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommStep <em>Ga Comm Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Comm Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommStep
	 * @generated
	 */
	EClass getGaCommStep();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep <em>Ga Acq Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Acq Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep
	 * @generated
	 */
	EClass getGaAcqStep();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep#getAcqRes <em>Acq Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Acq Res</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep#getAcqRes()
	 * @see #getGaAcqStep()
	 * @generated
	 */
	EReference getGaAcqStep_AcqRes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep#getResUnits <em>Res Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Units</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep#getResUnits()
	 * @see #getGaAcqStep()
	 * @generated
	 */
	EAttribute getGaAcqStep_ResUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep <em>Ga Rel Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Rel Step</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep
	 * @generated
	 */
	EClass getGaRelStep();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getRelRes <em>Rel Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Res</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getRelRes()
	 * @see #getGaRelStep()
	 * @generated
	 */
	EReference getGaRelStep_RelRes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getResUnits <em>Res Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Units</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getResUnits()
	 * @see #getGaRelStep()
	 * @generated
	 */
	EAttribute getGaRelStep_ResUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs <em>Ga Latency Obs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Latency Obs</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs
	 * @generated
	 */
	EClass getGaLatencyObs();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getLatency <em>Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Latency</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getLatency()
	 * @see #getGaLatencyObs()
	 * @generated
	 */
	EAttribute getGaLatencyObs_Latency();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMiss <em>Miss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Miss</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMiss()
	 * @see #getGaLatencyObs()
	 * @generated
	 */
	EAttribute getGaLatencyObs_Miss();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getUtility <em>Utility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Utility</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getUtility()
	 * @see #getGaLatencyObs()
	 * @generated
	 */
	EAttribute getGaLatencyObs_Utility();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMaxJitter <em>Max Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Max Jitter</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs#getMaxJitter()
	 * @see #getGaLatencyObs()
	 * @generated
	 */
	EAttribute getGaLatencyObs_MaxJitter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost <em>Ga Comm Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Comm Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost
	 * @generated
	 */
	EClass getGaCommHost();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost#getThroughput <em>Throughput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Throughput</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost#getThroughput()
	 * @see #getGaCommHost()
	 * @generated
	 */
	EAttribute getGaCommHost_Throughput();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Utilization</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost#getUtilization()
	 * @see #getGaCommHost()
	 * @generated
	 */
	EAttribute getGaCommHost_Utilization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel <em>Ga Comm Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Comm Channel</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel
	 * @generated
	 */
	EClass getGaCommChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel#getPacketSize <em>Packet Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Packet Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel#getPacketSize()
	 * @see #getGaCommChannel()
	 * @generated
	 */
	EAttribute getGaCommChannel_PacketSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel#getUtilization()
	 * @see #getGaCommChannel()
	 * @generated
	 */
	EAttribute getGaCommChannel_Utilization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior <em>Ga Workload Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Workload Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior
	 * @generated
	 */
	EClass getGaWorkloadBehavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getBehavior()
	 * @see #getGaWorkloadBehavior()
	 * @generated
	 */
	EReference getGaWorkloadBehavior_Behavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Demand</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getDemand()
	 * @see #getGaWorkloadBehavior()
	 * @generated
	 */
	EReference getGaWorkloadBehavior_Demand();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior#getBase_NamedElement()
	 * @see #getGaWorkloadBehavior()
	 * @generated
	 */
	EReference getGaWorkloadBehavior_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext <em>Ga Analysis Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Analysis Context</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext
	 * @generated
	 */
	EClass getGaAnalysisContext();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Context</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getContext()
	 * @see #getGaAnalysisContext()
	 * @generated
	 */
	EAttribute getGaAnalysisContext_Context();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getWorkload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workload</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getWorkload()
	 * @see #getGaAnalysisContext()
	 * @generated
	 */
	EReference getGaAnalysisContext_Workload();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Platform</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getPlatform()
	 * @see #getGaAnalysisContext()
	 * @generated
	 */
	EReference getGaAnalysisContext_Platform();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform <em>Ga Resources Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ga Resources Platform</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform
	 * @generated
	 */
	EClass getGaResourcesPlatform();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform#getResources()
	 * @see #getGaResourcesPlatform()
	 * @generated
	 */
	EReference getGaResourcesPlatform_Resources();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform#getBase_Classifier()
	 * @see #getGaResourcesPlatform()
	 * @generated
	 */
	EReference getGaResourcesPlatform_Base_Classifier();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind <em>Laxity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Laxity Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind
	 * @generated
	 */
	EEnum getLaxityKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GQAMFactory getGQAMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadGeneratorImpl <em>Ga Workload Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadGeneratorImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadGenerator()
		 * @generated
		 */
		EClass GA_WORKLOAD_GENERATOR = eINSTANCE.getGaWorkloadGenerator();

		/**
		 * The meta object literal for the '<em><b>Pop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_WORKLOAD_GENERATOR__POP = eINSTANCE.getGaWorkloadGenerator_Pop();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_GENERATOR__BASE_BEHAVIOR = eINSTANCE.getGaWorkloadGenerator_Base_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaEventTraceImpl <em>Ga Event Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaEventTraceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaEventTrace()
		 * @generated
		 */
		EClass GA_EVENT_TRACE = eINSTANCE.getGaEventTrace();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EVENT_TRACE__CONTENT = eINSTANCE.getGaEventTrace_Content();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EVENT_TRACE__FORMAT = eINSTANCE.getGaEventTrace_Format();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EVENT_TRACE__LOCATION = eINSTANCE.getGaEventTrace_Location();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_EVENT_TRACE__BASE_NAMED_ELEMENT = eINSTANCE.getGaEventTrace_Base_NamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl <em>Ga Workload Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadEventImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadEvent()
		 * @generated
		 */
		EClass GA_WORKLOAD_EVENT = eINSTANCE.getGaWorkloadEvent();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_WORKLOAD_EVENT__PATTERN = eINSTANCE.getGaWorkloadEvent_Pattern();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_EVENT__GENERATOR = eINSTANCE.getGaWorkloadEvent_Generator();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_EVENT__TRACE = eINSTANCE.getGaWorkloadEvent_Trace();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_EVENT__EFFECT = eINSTANCE.getGaWorkloadEvent_Effect();

		/**
		 * The meta object literal for the '<em><b>Timed Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_EVENT__TIMED_EVENT = eINSTANCE.getGaWorkloadEvent_TimedEvent();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_EVENT__BASE_NAMED_ELEMENT = eINSTANCE.getGaWorkloadEvent_Base_NamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaScenarioImpl <em>Ga Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaScenarioImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaScenario()
		 * @generated
		 */
		EClass GA_SCENARIO = eINSTANCE.getGaScenario();

		/**
		 * The meta object literal for the '<em><b>Cause</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_SCENARIO__CAUSE = eINSTANCE.getGaScenario_Cause();

		/**
		 * The meta object literal for the '<em><b>Host Demand</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__HOST_DEMAND = eINSTANCE.getGaScenario_HostDemand();

		/**
		 * The meta object literal for the '<em><b>Host Demand Ops</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__HOST_DEMAND_OPS = eINSTANCE.getGaScenario_HostDemandOps();

		/**
		 * The meta object literal for the '<em><b>Inter Occ T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__INTER_OCC_T = eINSTANCE.getGaScenario_InterOccT();

		/**
		 * The meta object literal for the '<em><b>Throughput</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__THROUGHPUT = eINSTANCE.getGaScenario_Throughput();

		/**
		 * The meta object literal for the '<em><b>Resp T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__RESP_T = eINSTANCE.getGaScenario_RespT();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__UTILIZATION = eINSTANCE.getGaScenario_Utilization();

		/**
		 * The meta object literal for the '<em><b>Utilization On Host</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_SCENARIO__UTILIZATION_ON_HOST = eINSTANCE.getGaScenario_UtilizationOnHost();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_SCENARIO__ROOT = eINSTANCE.getGaScenario_Root();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_SCENARIO__STEPS = eINSTANCE.getGaScenario_Steps();

		/**
		 * The meta object literal for the '<em><b>Parent Step</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_SCENARIO__PARENT_STEP = eINSTANCE.getGaScenario_ParentStep();

		/**
		 * The meta object literal for the '<em><b>Timing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_SCENARIO__TIMING = eINSTANCE.getGaScenario_Timing();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl <em>Ga Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaStep()
		 * @generated
		 */
		EClass GA_STEP = eINSTANCE.getGaStep();

		/**
		 * The meta object literal for the '<em><b>Is Atomic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__IS_ATOMIC = eINSTANCE.getGaStep_IsAtomic();

		/**
		 * The meta object literal for the '<em><b>Block T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__BLOCK_T = eINSTANCE.getGaStep_BlockT();

		/**
		 * The meta object literal for the '<em><b>Rep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__REP = eINSTANCE.getGaStep_Rep();

		/**
		 * The meta object literal for the '<em><b>Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__PROB = eINSTANCE.getGaStep_Prob();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__PRIORITY = eINSTANCE.getGaStep_Priority();

		/**
		 * The meta object literal for the '<em><b>Concur Res</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_STEP__CONCUR_RES = eINSTANCE.getGaStep_ConcurRes();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_STEP__HOST = eINSTANCE.getGaStep_Host();

		/**
		 * The meta object literal for the '<em><b>Serv Demand</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_STEP__SERV_DEMAND = eINSTANCE.getGaStep_ServDemand();

		/**
		 * The meta object literal for the '<em><b>Serv Count</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__SERV_COUNT = eINSTANCE.getGaStep_ServCount();

		/**
		 * The meta object literal for the '<em><b>Self Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_STEP__SELF_DELAY = eINSTANCE.getGaStep_SelfDelay();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_STEP__SCENARIO = eINSTANCE.getGaStep_Scenario();

		/**
		 * The meta object literal for the '<em><b>Child Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_STEP__CHILD_SCENARIO = eINSTANCE.getGaStep_ChildScenario();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl <em>Ga Exec Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaExecHostImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaExecHost()
		 * @generated
		 */
		EClass GA_EXEC_HOST = eINSTANCE.getGaExecHost();

		/**
		 * The meta object literal for the '<em><b>Comm Tx Ovh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__COMM_TX_OVH = eINSTANCE.getGaExecHost_CommTxOvh();

		/**
		 * The meta object literal for the '<em><b>Comm Rcv Ovh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__COMM_RCV_OVH = eINSTANCE.getGaExecHost_CommRcvOvh();

		/**
		 * The meta object literal for the '<em><b>Cntxt Sw T</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__CNTXT_SW_T = eINSTANCE.getGaExecHost_CntxtSwT();

		/**
		 * The meta object literal for the '<em><b>Clock Ovh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__CLOCK_OVH = eINSTANCE.getGaExecHost_ClockOvh();

		/**
		 * The meta object literal for the '<em><b>Sched Pri Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__SCHED_PRI_RANGE = eINSTANCE.getGaExecHost_SchedPriRange();

		/**
		 * The meta object literal for the '<em><b>Mem Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__MEM_SIZE = eINSTANCE.getGaExecHost_MemSize();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__UTILIZATION = eINSTANCE.getGaExecHost_Utilization();

		/**
		 * The meta object literal for the '<em><b>Throughput</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_EXEC_HOST__THROUGHPUT = eINSTANCE.getGaExecHost_Throughput();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRequestedServiceImpl <em>Ga Requested Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRequestedServiceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaRequestedService()
		 * @generated
		 */
		EClass GA_REQUESTED_SERVICE = eINSTANCE.getGaRequestedService();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_REQUESTED_SERVICE__BASE_OPERATION = eINSTANCE.getGaRequestedService_Base_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl <em>Ga Timed Obs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaTimedObs()
		 * @generated
		 */
		EClass GA_TIMED_OBS = eINSTANCE.getGaTimedObs();

		/**
		 * The meta object literal for the '<em><b>Laxity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_TIMED_OBS__LAXITY = eINSTANCE.getGaTimedObs_Laxity();

		/**
		 * The meta object literal for the '<em><b>Start Obs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_TIMED_OBS__START_OBS = eINSTANCE.getGaTimedObs_StartObs();

		/**
		 * The meta object literal for the '<em><b>End Obs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_TIMED_OBS__END_OBS = eINSTANCE.getGaTimedObs_EndObs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommStepImpl <em>Ga Comm Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommStep()
		 * @generated
		 */
		EClass GA_COMM_STEP = eINSTANCE.getGaCommStep();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl <em>Ga Acq Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaAcqStep()
		 * @generated
		 */
		EClass GA_ACQ_STEP = eINSTANCE.getGaAcqStep();

		/**
		 * The meta object literal for the '<em><b>Acq Res</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_ACQ_STEP__ACQ_RES = eINSTANCE.getGaAcqStep_AcqRes();

		/**
		 * The meta object literal for the '<em><b>Res Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_ACQ_STEP__RES_UNITS = eINSTANCE.getGaAcqStep_ResUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl <em>Ga Rel Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaRelStep()
		 * @generated
		 */
		EClass GA_REL_STEP = eINSTANCE.getGaRelStep();

		/**
		 * The meta object literal for the '<em><b>Rel Res</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_REL_STEP__REL_RES = eINSTANCE.getGaRelStep_RelRes();

		/**
		 * The meta object literal for the '<em><b>Res Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_REL_STEP__RES_UNITS = eINSTANCE.getGaRelStep_ResUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl <em>Ga Latency Obs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaLatencyObs()
		 * @generated
		 */
		EClass GA_LATENCY_OBS = eINSTANCE.getGaLatencyObs();

		/**
		 * The meta object literal for the '<em><b>Latency</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_LATENCY_OBS__LATENCY = eINSTANCE.getGaLatencyObs_Latency();

		/**
		 * The meta object literal for the '<em><b>Miss</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_LATENCY_OBS__MISS = eINSTANCE.getGaLatencyObs_Miss();

		/**
		 * The meta object literal for the '<em><b>Utility</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_LATENCY_OBS__UTILITY = eINSTANCE.getGaLatencyObs_Utility();

		/**
		 * The meta object literal for the '<em><b>Max Jitter</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_LATENCY_OBS__MAX_JITTER = eINSTANCE.getGaLatencyObs_MaxJitter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommHostImpl <em>Ga Comm Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommHostImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommHost()
		 * @generated
		 */
		EClass GA_COMM_HOST = eINSTANCE.getGaCommHost();

		/**
		 * The meta object literal for the '<em><b>Throughput</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_COMM_HOST__THROUGHPUT = eINSTANCE.getGaCommHost_Throughput();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_COMM_HOST__UTILIZATION = eINSTANCE.getGaCommHost_Utilization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl <em>Ga Comm Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaCommChannel()
		 * @generated
		 */
		EClass GA_COMM_CHANNEL = eINSTANCE.getGaCommChannel();

		/**
		 * The meta object literal for the '<em><b>Packet Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_COMM_CHANNEL__PACKET_SIZE = eINSTANCE.getGaCommChannel_PacketSize();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_COMM_CHANNEL__UTILIZATION = eINSTANCE.getGaCommChannel_Utilization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl <em>Ga Workload Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaWorkloadBehavior()
		 * @generated
		 */
		EClass GA_WORKLOAD_BEHAVIOR = eINSTANCE.getGaWorkloadBehavior();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_BEHAVIOR__BEHAVIOR = eINSTANCE.getGaWorkloadBehavior_Behavior();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_BEHAVIOR__DEMAND = eINSTANCE.getGaWorkloadBehavior_Demand();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT = eINSTANCE.getGaWorkloadBehavior_Base_NamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl <em>Ga Analysis Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaAnalysisContext()
		 * @generated
		 */
		EClass GA_ANALYSIS_CONTEXT = eINSTANCE.getGaAnalysisContext();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GA_ANALYSIS_CONTEXT__CONTEXT = eINSTANCE.getGaAnalysisContext_Context();

		/**
		 * The meta object literal for the '<em><b>Workload</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_ANALYSIS_CONTEXT__WORKLOAD = eINSTANCE.getGaAnalysisContext_Workload();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_ANALYSIS_CONTEXT__PLATFORM = eINSTANCE.getGaAnalysisContext_Platform();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaResourcesPlatformImpl <em>Ga Resources Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaResourcesPlatformImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getGaResourcesPlatform()
		 * @generated
		 */
		EClass GA_RESOURCES_PLATFORM = eINSTANCE.getGaResourcesPlatform();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_RESOURCES_PLATFORM__RESOURCES = eINSTANCE.getGaResourcesPlatform_Resources();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GA_RESOURCES_PLATFORM__BASE_CLASSIFIER = eINSTANCE.getGaResourcesPlatform_Base_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind <em>Laxity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl#getLaxityKind()
		 * @generated
		 */
		EEnum LAXITY_KIND = eINSTANCE.getLaxityKind();

	}

} //GQAMPackage
