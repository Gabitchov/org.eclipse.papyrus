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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage
 * @generated
 */
public class GCMSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GCMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCMSwitch() {
		if (modelPackage == null) {
			modelPackage = GCMPackage.eINSTANCE;
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
			case GCMPackage.FLOW_PROPERTY: {
				FlowProperty flowProperty = (FlowProperty)theEObject;
				T result = caseFlowProperty(flowProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.FLOW_PORT: {
				FlowPort flowPort = (FlowPort)theEObject;
				T result = caseFlowPort(flowPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.CLIENT_SERVER_PORT: {
				ClientServerPort clientServerPort = (ClientServerPort)theEObject;
				T result = caseClientServerPort(clientServerPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.CLIENT_SERVER_SPECIFICATION: {
				ClientServerSpecification clientServerSpecification = (ClientServerSpecification)theEObject;
				T result = caseClientServerSpecification(clientServerSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.FLOW_SPECIFICATION: {
				FlowSpecification flowSpecification = (FlowSpecification)theEObject;
				T result = caseFlowSpecification(flowSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.CLIENT_SERVER_FEATURE: {
				ClientServerFeature clientServerFeature = (ClientServerFeature)theEObject;
				T result = caseClientServerFeature(clientServerFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.GCM_TRIGGER: {
				GCMTrigger gcmTrigger = (GCMTrigger)theEObject;
				T result = caseGCMTrigger(gcmTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.GCM_INVOCATION_ACTION: {
				GCMInvocationAction gcmInvocationAction = (GCMInvocationAction)theEObject;
				T result = caseGCMInvocationAction(gcmInvocationAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.DATA_EVENT: {
				DataEvent dataEvent = (DataEvent)theEObject;
				T result = caseDataEvent(dataEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.DATA_POOL: {
				DataPool dataPool = (DataPool)theEObject;
				T result = caseDataPool(dataPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GCMPackage.GCM_INVOCATING_BEHAVIOR: {
				GCMInvocatingBehavior gcmInvocatingBehavior = (GCMInvocatingBehavior)theEObject;
				T result = caseGCMInvocatingBehavior(gcmInvocatingBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowProperty(FlowProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowPort(FlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Server Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Server Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClientServerPort(ClientServerPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Server Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Server Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClientServerSpecification(ClientServerSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowSpecification(FlowSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Server Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Server Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClientServerFeature(ClientServerFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGCMTrigger(GCMTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGCMInvocationAction(GCMInvocationAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataEvent(DataEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPool(DataPool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocating Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocating Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGCMInvocatingBehavior(GCMInvocatingBehavior object) {
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

} //GCMSwitch
