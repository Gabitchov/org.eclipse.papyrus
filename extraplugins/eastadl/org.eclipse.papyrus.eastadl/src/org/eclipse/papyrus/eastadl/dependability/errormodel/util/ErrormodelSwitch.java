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
package org.eclipse.papyrus.eastadl.dependability.errormodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelPrototype;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePropagationLink;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


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
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage
 * @generated
 */
public class ErrormodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ErrormodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrormodelSwitch() {
		if (modelPackage == null) {
			modelPackage = ErrormodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnomaly(Anomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorBehavior(ErrorBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Model Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Model Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorModelPrototype(ErrorModelPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorModelType(ErrorModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure Out Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure Out Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailureOutPort(FailureOutPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Failure Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Failure Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultFailurePort(FaultFailurePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Failure Propagation Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Failure Propagation Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultFailurePropagationLink(FaultFailurePropagationLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault In Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault In Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultInPort(FaultInPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Fault Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Fault Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalFaultPrototype(InternalFaultPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Fault Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Fault Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessFaultPrototype(ProcessFaultPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAElement(EAElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAPackageableElement(EAPackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceableSpecification(TraceableSpecification object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ErrormodelPackage.ERROR_BEHAVIOR: {
				ErrorBehavior errorBehavior = (ErrorBehavior)theEObject;
				T result = caseErrorBehavior(errorBehavior);
				if (result == null) result = caseEAElement(errorBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.INTERNAL_FAULT_PROTOTYPE: {
				InternalFaultPrototype internalFaultPrototype = (InternalFaultPrototype)theEObject;
				T result = caseInternalFaultPrototype(internalFaultPrototype);
				if (result == null) result = caseAnomaly(internalFaultPrototype);
				if (result == null) result = caseEAElement(internalFaultPrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.ANOMALY: {
				Anomaly anomaly = (Anomaly)theEObject;
				T result = caseAnomaly(anomaly);
				if (result == null) result = caseEAElement(anomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.ERROR_MODEL_TYPE: {
				ErrorModelType errorModelType = (ErrorModelType)theEObject;
				T result = caseErrorModelType(errorModelType);
				if (result == null) result = caseTraceableSpecification(errorModelType);
				if (result == null) result = caseEAPackageableElement(errorModelType);
				if (result == null) result = caseEAElement(errorModelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.FAULT_FAILURE_PROPAGATION_LINK: {
				FaultFailurePropagationLink faultFailurePropagationLink = (FaultFailurePropagationLink)theEObject;
				T result = caseFaultFailurePropagationLink(faultFailurePropagationLink);
				if (result == null) result = caseEAElement(faultFailurePropagationLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.FAULT_FAILURE_PORT: {
				FaultFailurePort faultFailurePort = (FaultFailurePort)theEObject;
				T result = caseFaultFailurePort(faultFailurePort);
				if (result == null) result = caseAnomaly(faultFailurePort);
				if (result == null) result = caseEAElement(faultFailurePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.ERROR_MODEL_PROTOTYPE: {
				ErrorModelPrototype errorModelPrototype = (ErrorModelPrototype)theEObject;
				T result = caseErrorModelPrototype(errorModelPrototype);
				if (result == null) result = caseEAElement(errorModelPrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.FAILURE_OUT_PORT: {
				FailureOutPort failureOutPort = (FailureOutPort)theEObject;
				T result = caseFailureOutPort(failureOutPort);
				if (result == null) result = caseFaultFailurePort(failureOutPort);
				if (result == null) result = caseAnomaly(failureOutPort);
				if (result == null) result = caseEAElement(failureOutPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.FAULT_IN_PORT: {
				FaultInPort faultInPort = (FaultInPort)theEObject;
				T result = caseFaultInPort(faultInPort);
				if (result == null) result = caseFaultFailurePort(faultInPort);
				if (result == null) result = caseAnomaly(faultInPort);
				if (result == null) result = caseEAElement(faultInPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ErrormodelPackage.PROCESS_FAULT_PROTOTYPE: {
				ProcessFaultPrototype processFaultPrototype = (ProcessFaultPrototype)theEObject;
				T result = caseProcessFaultPrototype(processFaultPrototype);
				if (result == null) result = caseAnomaly(processFaultPrototype);
				if (result == null) result = caseEAElement(processFaultPrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

} //ErrormodelSwitch
