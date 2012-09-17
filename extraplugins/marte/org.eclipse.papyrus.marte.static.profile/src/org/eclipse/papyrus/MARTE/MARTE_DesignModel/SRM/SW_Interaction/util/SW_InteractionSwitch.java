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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwSynchronizationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SwResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SynchronizationResource;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage
 * @generated
 */
public class SW_InteractionSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SW_InteractionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_InteractionSwitch() {
		if (modelPackage == null) {
			modelPackage = SW_InteractionPackage.eINSTANCE;
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
			case SW_InteractionPackage.SW_INTERACTION_RESOURCE: {
				SwInteractionResource swInteractionResource = (SwInteractionResource)theEObject;
				T result = caseSwInteractionResource(swInteractionResource);
				if (result == null) result = caseSwResource(swInteractionResource);
				if (result == null) result = caseResource(swInteractionResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.SW_COMMUNICATION_RESOURCE: {
				SwCommunicationResource swCommunicationResource = (SwCommunicationResource)theEObject;
				T result = caseSwCommunicationResource(swCommunicationResource);
				if (result == null) result = caseSwInteractionResource(swCommunicationResource);
				if (result == null) result = caseCommunicationMedia(swCommunicationResource);
				if (result == null) result = caseSwResource(swCommunicationResource);
				if (result == null) result = caseProcessingResource(swCommunicationResource);
				if (result == null) result = caseResource(swCommunicationResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.SW_SYNCHRONIZATION_RESOURCE: {
				SwSynchronizationResource swSynchronizationResource = (SwSynchronizationResource)theEObject;
				T result = caseSwSynchronizationResource(swSynchronizationResource);
				if (result == null) result = caseSwInteractionResource(swSynchronizationResource);
				if (result == null) result = caseSynchronizationResource(swSynchronizationResource);
				if (result == null) result = caseSwResource(swSynchronizationResource);
				if (result == null) result = caseResource(swSynchronizationResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE: {
				SharedDataComResource sharedDataComResource = (SharedDataComResource)theEObject;
				T result = caseSharedDataComResource(sharedDataComResource);
				if (result == null) result = caseSwCommunicationResource(sharedDataComResource);
				if (result == null) result = caseSwInteractionResource(sharedDataComResource);
				if (result == null) result = caseCommunicationMedia(sharedDataComResource);
				if (result == null) result = caseSwResource(sharedDataComResource);
				if (result == null) result = caseProcessingResource(sharedDataComResource);
				if (result == null) result = caseResource(sharedDataComResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE: {
				MessageComResource messageComResource = (MessageComResource)theEObject;
				T result = caseMessageComResource(messageComResource);
				if (result == null) result = caseSwCommunicationResource(messageComResource);
				if (result == null) result = caseSwInteractionResource(messageComResource);
				if (result == null) result = caseCommunicationMedia(messageComResource);
				if (result == null) result = caseSwResource(messageComResource);
				if (result == null) result = caseProcessingResource(messageComResource);
				if (result == null) result = caseResource(messageComResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.NOTIFICATION_RESOURCE: {
				NotificationResource notificationResource = (NotificationResource)theEObject;
				T result = caseNotificationResource(notificationResource);
				if (result == null) result = caseSwSynchronizationResource(notificationResource);
				if (result == null) result = caseSwInteractionResource(notificationResource);
				if (result == null) result = caseSynchronizationResource(notificationResource);
				if (result == null) result = caseSwResource(notificationResource);
				if (result == null) result = caseResource(notificationResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE: {
				SwMutualExclusionResource swMutualExclusionResource = (SwMutualExclusionResource)theEObject;
				T result = caseSwMutualExclusionResource(swMutualExclusionResource);
				if (result == null) result = caseSwSynchronizationResource(swMutualExclusionResource);
				if (result == null) result = caseMutualExclusionResource(swMutualExclusionResource);
				if (result == null) result = caseSwInteractionResource(swMutualExclusionResource);
				if (result == null) result = caseSynchronizationResource(swMutualExclusionResource);
				if (result == null) result = caseSwResource(swMutualExclusionResource);
				if (result == null) result = caseResource(swMutualExclusionResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sw Interaction Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sw Interaction Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwInteractionResource(SwInteractionResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sw Communication Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sw Communication Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwCommunicationResource(SwCommunicationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sw Synchronization Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sw Synchronization Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwSynchronizationResource(SwSynchronizationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Data Com Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Data Com Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSharedDataComResource(SharedDataComResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Com Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Com Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageComResource(MessageComResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotificationResource(NotificationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sw Mutual Exclusion Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sw Mutual Exclusion Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwMutualExclusionResource(SwMutualExclusionResource object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Sw Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sw Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwResource(SwResource object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Synchronization Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synchronization Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynchronizationResource(SynchronizationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutual Exclusion Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutual Exclusion Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutualExclusionResource(MutualExclusionResource object) {
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

} //SW_InteractionSwitch
