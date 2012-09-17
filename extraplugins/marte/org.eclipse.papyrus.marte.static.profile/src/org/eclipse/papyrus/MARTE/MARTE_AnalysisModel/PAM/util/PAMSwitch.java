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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaCommStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaLogicalResource;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaRequestedStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaResPassStep;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaRunTInstance;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage;
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
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage
 * @generated
 */
public class PAMSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PAMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAMSwitch() {
		if (modelPackage == null) {
			modelPackage = PAMPackage.eINSTANCE;
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
			case PAMPackage.PA_STEP: {
				PaStep paStep = (PaStep)theEObject;
				T result = casePaStep(paStep);
				if (result == null) result = caseGaStep(paStep);
				if (result == null) result = caseGaScenario(paStep);
				if (result == null) result = caseResourceUsage(paStep);
				if (result == null) result = caseTimedProcessing(paStep);
				if (result == null) result = caseTimedElement(paStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PAMPackage.PA_REQUESTED_STEP: {
				PaRequestedStep paRequestedStep = (PaRequestedStep)theEObject;
				T result = casePaRequestedStep(paRequestedStep);
				if (result == null) result = casePaStep(paRequestedStep);
				if (result == null) result = caseGaRequestedService(paRequestedStep);
				if (result == null) result = caseGaStep(paRequestedStep);
				if (result == null) result = caseGaScenario(paRequestedStep);
				if (result == null) result = caseResourceUsage(paRequestedStep);
				if (result == null) result = caseTimedProcessing(paRequestedStep);
				if (result == null) result = caseTimedElement(paRequestedStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PAMPackage.PA_COMM_STEP: {
				PaCommStep paCommStep = (PaCommStep)theEObject;
				T result = casePaCommStep(paCommStep);
				if (result == null) result = casePaStep(paCommStep);
				if (result == null) result = caseGaCommStep(paCommStep);
				if (result == null) result = caseGaStep(paCommStep);
				if (result == null) result = caseGaScenario(paCommStep);
				if (result == null) result = caseResourceUsage(paCommStep);
				if (result == null) result = caseTimedProcessing(paCommStep);
				if (result == null) result = caseTimedElement(paCommStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PAMPackage.PA_RES_PASS_STEP: {
				PaResPassStep paResPassStep = (PaResPassStep)theEObject;
				T result = casePaResPassStep(paResPassStep);
				if (result == null) result = caseGaStep(paResPassStep);
				if (result == null) result = caseGaScenario(paResPassStep);
				if (result == null) result = caseResourceUsage(paResPassStep);
				if (result == null) result = caseTimedProcessing(paResPassStep);
				if (result == null) result = caseTimedElement(paResPassStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PAMPackage.PA_LOGICAL_RESOURCE: {
				PaLogicalResource paLogicalResource = (PaLogicalResource)theEObject;
				T result = casePaLogicalResource(paLogicalResource);
				if (result == null) result = caseResource(paLogicalResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PAMPackage.PA_RUN_TINSTANCE: {
				PaRunTInstance paRunTInstance = (PaRunTInstance)theEObject;
				T result = casePaRunTInstance(paRunTInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaStep(PaStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Requested Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Requested Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaRequestedStep(PaRequestedStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Comm Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Comm Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaCommStep(PaCommStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Res Pass Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Res Pass Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaResPassStep(PaResPassStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Logical Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Logical Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaLogicalResource(PaLogicalResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pa Run TInstance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pa Run TInstance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaRunTInstance(PaRunTInstance object) {
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

} //PAMSwitch
