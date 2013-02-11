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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.*;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMFactory;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaEventTrace;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadGenerator;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GQAMFactoryImpl extends EFactoryImpl implements GQAMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GQAMFactory init() {
		try {
			GQAMFactory theGQAMFactory = (GQAMFactory)EPackage.Registry.INSTANCE.getEFactory(GQAMPackage.eNS_URI);
			if (theGQAMFactory != null) {
				return theGQAMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GQAMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GQAMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GQAMPackage.GA_WORKLOAD_GENERATOR: return createGaWorkloadGenerator();
			case GQAMPackage.GA_EVENT_TRACE: return createGaEventTrace();
			case GQAMPackage.GA_WORKLOAD_EVENT: return createGaWorkloadEvent();
			case GQAMPackage.GA_SCENARIO: return createGaScenario();
			case GQAMPackage.GA_STEP: return createGaStep();
			case GQAMPackage.GA_EXEC_HOST: return createGaExecHost();
			case GQAMPackage.GA_REQUESTED_SERVICE: return createGaRequestedService();
			case GQAMPackage.GA_TIMED_OBS: return createGaTimedObs();
			case GQAMPackage.GA_COMM_STEP: return createGaCommStep();
			case GQAMPackage.GA_ACQ_STEP: return createGaAcqStep();
			case GQAMPackage.GA_REL_STEP: return createGaRelStep();
			case GQAMPackage.GA_LATENCY_OBS: return createGaLatencyObs();
			case GQAMPackage.GA_COMM_HOST: return createGaCommHost();
			case GQAMPackage.GA_COMM_CHANNEL: return createGaCommChannel();
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR: return createGaWorkloadBehavior();
			case GQAMPackage.GA_ANALYSIS_CONTEXT: return createGaAnalysisContext();
			case GQAMPackage.GA_RESOURCES_PLATFORM: return createGaResourcesPlatform();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GQAMPackage.LAXITY_KIND:
				return createLaxityKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GQAMPackage.LAXITY_KIND:
				return convertLaxityKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaWorkloadGenerator createGaWorkloadGenerator() {
		GaWorkloadGeneratorImpl gaWorkloadGenerator = new GaWorkloadGeneratorImpl();
		return gaWorkloadGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaEventTrace createGaEventTrace() {
		GaEventTraceImpl gaEventTrace = new GaEventTraceImpl();
		return gaEventTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaWorkloadEvent createGaWorkloadEvent() {
		GaWorkloadEventImpl gaWorkloadEvent = new GaWorkloadEventImpl();
		return gaWorkloadEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario createGaScenario() {
		GaScenarioImpl gaScenario = new GaScenarioImpl();
		return gaScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaStep createGaStep() {
		GaStepImpl gaStep = new GaStepImpl();
		return gaStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaExecHost createGaExecHost() {
		GaExecHostImpl gaExecHost = new GaExecHostImpl();
		return gaExecHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaRequestedService createGaRequestedService() {
		GaRequestedServiceImpl gaRequestedService = new GaRequestedServiceImpl();
		return gaRequestedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaTimedObs createGaTimedObs() {
		GaTimedObsImpl gaTimedObs = new GaTimedObsImpl();
		return gaTimedObs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaCommStep createGaCommStep() {
		GaCommStepImpl gaCommStep = new GaCommStepImpl();
		return gaCommStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaAcqStep createGaAcqStep() {
		GaAcqStepImpl gaAcqStep = new GaAcqStepImpl();
		return gaAcqStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaRelStep createGaRelStep() {
		GaRelStepImpl gaRelStep = new GaRelStepImpl();
		return gaRelStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaLatencyObs createGaLatencyObs() {
		GaLatencyObsImpl gaLatencyObs = new GaLatencyObsImpl();
		return gaLatencyObs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaCommHost createGaCommHost() {
		GaCommHostImpl gaCommHost = new GaCommHostImpl();
		return gaCommHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaCommChannel createGaCommChannel() {
		GaCommChannelImpl gaCommChannel = new GaCommChannelImpl();
		return gaCommChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaWorkloadBehavior createGaWorkloadBehavior() {
		GaWorkloadBehaviorImpl gaWorkloadBehavior = new GaWorkloadBehaviorImpl();
		return gaWorkloadBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaAnalysisContext createGaAnalysisContext() {
		GaAnalysisContextImpl gaAnalysisContext = new GaAnalysisContextImpl();
		return gaAnalysisContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaResourcesPlatform createGaResourcesPlatform() {
		GaResourcesPlatformImpl gaResourcesPlatform = new GaResourcesPlatformImpl();
		return gaResourcesPlatform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaxityKind createLaxityKindFromString(EDataType eDataType, String initialValue) {
		LaxityKind result = LaxityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLaxityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GQAMPackage getGQAMPackage() {
		return (GQAMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GQAMPackage getPackage() {
		return GQAMPackage.eINSTANCE;
	}

} //GQAMFactoryImpl
