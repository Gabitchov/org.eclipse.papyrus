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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.*;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage
 * @generated
 */
public class GQAMSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GQAMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GQAMSwitch() {
		if (modelPackage == null) {
			modelPackage = GQAMPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GQAMPackage.GA_WORKLOAD_GENERATOR: {
				GaWorkloadGenerator gaWorkloadGenerator = (GaWorkloadGenerator)theEObject;
				T result = caseGaWorkloadGenerator(gaWorkloadGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_EVENT_TRACE: {
				GaEventTrace gaEventTrace = (GaEventTrace)theEObject;
				T result = caseGaEventTrace(gaEventTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_WORKLOAD_EVENT: {
				GaWorkloadEvent gaWorkloadEvent = (GaWorkloadEvent)theEObject;
				T result = caseGaWorkloadEvent(gaWorkloadEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_SCENARIO: {
				GaScenario gaScenario = (GaScenario)theEObject;
				T result = caseGaScenario(gaScenario);
				if (result == null) result = caseResourceUsage(gaScenario);
				if (result == null) result = caseTimedProcessing(gaScenario);
				if (result == null) result = caseTimedElement(gaScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_STEP: {
				GaStep gaStep = (GaStep)theEObject;
				T result = caseGaStep(gaStep);
				if (result == null) result = caseGaScenario(gaStep);
				if (result == null) result = caseResourceUsage(gaStep);
				if (result == null) result = caseTimedProcessing(gaStep);
				if (result == null) result = caseTimedElement(gaStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_EXEC_HOST: {
				GaExecHost gaExecHost = (GaExecHost)theEObject;
				T result = caseGaExecHost(gaExecHost);
				if (result == null) result = caseScheduler(gaExecHost);
				if (result == null) result = caseComputingResource(gaExecHost);
				if (result == null) result = caseProcessingResource(gaExecHost);
				if (result == null) result = caseResource(gaExecHost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_REQUESTED_SERVICE: {
				GaRequestedService gaRequestedService = (GaRequestedService)theEObject;
				T result = caseGaRequestedService(gaRequestedService);
				if (result == null) result = caseGaStep(gaRequestedService);
				if (result == null) result = caseGaScenario(gaRequestedService);
				if (result == null) result = caseResourceUsage(gaRequestedService);
				if (result == null) result = caseTimedProcessing(gaRequestedService);
				if (result == null) result = caseTimedElement(gaRequestedService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_TIMED_OBS: {
				GaTimedObs gaTimedObs = (GaTimedObs)theEObject;
				T result = caseGaTimedObs(gaTimedObs);
				if (result == null) result = caseNfpConstraint(gaTimedObs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_COMM_STEP: {
				GaCommStep gaCommStep = (GaCommStep)theEObject;
				T result = caseGaCommStep(gaCommStep);
				if (result == null) result = caseGaStep(gaCommStep);
				if (result == null) result = caseGaScenario(gaCommStep);
				if (result == null) result = caseResourceUsage(gaCommStep);
				if (result == null) result = caseTimedProcessing(gaCommStep);
				if (result == null) result = caseTimedElement(gaCommStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_ACQ_STEP: {
				GaAcqStep gaAcqStep = (GaAcqStep)theEObject;
				T result = caseGaAcqStep(gaAcqStep);
				if (result == null) result = caseGaStep(gaAcqStep);
				if (result == null) result = caseGaScenario(gaAcqStep);
				if (result == null) result = caseResourceUsage(gaAcqStep);
				if (result == null) result = caseTimedProcessing(gaAcqStep);
				if (result == null) result = caseTimedElement(gaAcqStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_REL_STEP: {
				GaRelStep gaRelStep = (GaRelStep)theEObject;
				T result = caseGaRelStep(gaRelStep);
				if (result == null) result = caseGaStep(gaRelStep);
				if (result == null) result = caseGaScenario(gaRelStep);
				if (result == null) result = caseResourceUsage(gaRelStep);
				if (result == null) result = caseTimedProcessing(gaRelStep);
				if (result == null) result = caseTimedElement(gaRelStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_LATENCY_OBS: {
				GaLatencyObs gaLatencyObs = (GaLatencyObs)theEObject;
				T result = caseGaLatencyObs(gaLatencyObs);
				if (result == null) result = caseGaTimedObs(gaLatencyObs);
				if (result == null) result = caseNfpConstraint(gaLatencyObs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_COMM_HOST: {
				GaCommHost gaCommHost = (GaCommHost)theEObject;
				T result = caseGaCommHost(gaCommHost);
				if (result == null) result = caseCommunicationMedia(gaCommHost);
				if (result == null) result = caseScheduler(gaCommHost);
				if (result == null) result = caseProcessingResource(gaCommHost);
				if (result == null) result = caseResource(gaCommHost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_COMM_CHANNEL: {
				GaCommChannel gaCommChannel = (GaCommChannel)theEObject;
				T result = caseGaCommChannel(gaCommChannel);
				if (result == null) result = caseSchedulableResource(gaCommChannel);
				if (result == null) result = caseResource(gaCommChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR: {
				GaWorkloadBehavior gaWorkloadBehavior = (GaWorkloadBehavior)theEObject;
				T result = caseGaWorkloadBehavior(gaWorkloadBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_ANALYSIS_CONTEXT: {
				GaAnalysisContext gaAnalysisContext = (GaAnalysisContext)theEObject;
				T result = caseGaAnalysisContext(gaAnalysisContext);
				if (result == null) result = caseConfiguration(gaAnalysisContext);
				if (result == null) result = caseExpressionContext(gaAnalysisContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GQAMPackage.GA_RESOURCES_PLATFORM: {
				GaResourcesPlatform gaResourcesPlatform = (GaResourcesPlatform)theEObject;
				T result = caseGaResourcesPlatform(gaResourcesPlatform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Workload Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Workload Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaWorkloadGenerator(GaWorkloadGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Event Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Event Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaEventTrace(GaEventTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Workload Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Workload Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaWorkloadEvent(GaWorkloadEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaScenario(GaScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaStep(GaStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Exec Host</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Exec Host</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaExecHost(GaExecHost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Requested Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Requested Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaRequestedService(GaRequestedService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Timed Obs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Timed Obs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaTimedObs(GaTimedObs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Comm Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Comm Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaCommStep(GaCommStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Acq Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Acq Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaAcqStep(GaAcqStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Rel Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Rel Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaRelStep(GaRelStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Latency Obs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Latency Obs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaLatencyObs(GaLatencyObs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Comm Host</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Comm Host</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaCommHost(GaCommHost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Comm Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Comm Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaCommChannel(GaCommChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Workload Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Workload Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaWorkloadBehavior(GaWorkloadBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Analysis Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Analysis Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaAnalysisContext(GaAnalysisContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ga Resources Platform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ga Resources Platform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaResourcesPlatform(GaResourcesPlatform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceUsage(ResourceUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedElement(TimedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Processing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Processing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedProcessing(TimedProcessing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduler(Scheduler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingResource(ProcessingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computing Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputingResource(ComputingResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nfp Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nfp Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNfpConstraint(NfpConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Media</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Media</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationMedia(CommunicationMedia object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedulable Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedulable Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulableResource(SchedulableResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionContext(ExpressionContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //GQAMSwitch
