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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionFactory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SW_InteractionFactoryImpl extends EFactoryImpl implements SW_InteractionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SW_InteractionFactory init() {
		try {
			SW_InteractionFactory theSW_InteractionFactory = (SW_InteractionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/SW_Interaction/1"); 
			if (theSW_InteractionFactory != null) {
				return theSW_InteractionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SW_InteractionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_InteractionFactoryImpl() {
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
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE: return createSharedDataComResource();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE: return createMessageComResource();
			case SW_InteractionPackage.NOTIFICATION_RESOURCE: return createNotificationResource();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE: return createSwMutualExclusionResource();
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
			case SW_InteractionPackage.QUEUE_POLICY_KIND:
				return createQueuePolicyKindFromString(eDataType, initialValue);
			case SW_InteractionPackage.MESSAGE_RESOURCE_KIND:
				return createMessageResourceKindFromString(eDataType, initialValue);
			case SW_InteractionPackage.NOTIFICATION_KIND:
				return createNotificationKindFromString(eDataType, initialValue);
			case SW_InteractionPackage.NOTIFICATION_RESOURCE_KIND:
				return createNotificationResourceKindFromString(eDataType, initialValue);
			case SW_InteractionPackage.MUTUAL_EXCLUSION_RESOURCE_KIND:
				return createMutualExclusionResourceKindFromString(eDataType, initialValue);
			case SW_InteractionPackage.CONCURRENT_ACCESS_PROTOCOL_KIND:
				return createConcurrentAccessProtocolKindFromString(eDataType, initialValue);
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
			case SW_InteractionPackage.QUEUE_POLICY_KIND:
				return convertQueuePolicyKindToString(eDataType, instanceValue);
			case SW_InteractionPackage.MESSAGE_RESOURCE_KIND:
				return convertMessageResourceKindToString(eDataType, instanceValue);
			case SW_InteractionPackage.NOTIFICATION_KIND:
				return convertNotificationKindToString(eDataType, instanceValue);
			case SW_InteractionPackage.NOTIFICATION_RESOURCE_KIND:
				return convertNotificationResourceKindToString(eDataType, instanceValue);
			case SW_InteractionPackage.MUTUAL_EXCLUSION_RESOURCE_KIND:
				return convertMutualExclusionResourceKindToString(eDataType, instanceValue);
			case SW_InteractionPackage.CONCURRENT_ACCESS_PROTOCOL_KIND:
				return convertConcurrentAccessProtocolKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SharedDataComResource createSharedDataComResource() {
		SharedDataComResourceImpl sharedDataComResource = new SharedDataComResourceImpl();
		return sharedDataComResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageComResource createMessageComResource() {
		MessageComResourceImpl messageComResource = new MessageComResourceImpl();
		return messageComResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationResource createNotificationResource() {
		NotificationResourceImpl notificationResource = new NotificationResourceImpl();
		return notificationResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwMutualExclusionResource createSwMutualExclusionResource() {
		SwMutualExclusionResourceImpl swMutualExclusionResource = new SwMutualExclusionResourceImpl();
		return swMutualExclusionResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueuePolicyKind createQueuePolicyKindFromString(EDataType eDataType, String initialValue) {
		QueuePolicyKind result = QueuePolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueuePolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageResourceKind createMessageResourceKindFromString(EDataType eDataType, String initialValue) {
		MessageResourceKind result = MessageResourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageResourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationKind createNotificationKindFromString(EDataType eDataType, String initialValue) {
		NotificationKind result = NotificationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotificationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationResourceKind createNotificationResourceKindFromString(EDataType eDataType, String initialValue) {
		NotificationResourceKind result = NotificationResourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotificationResourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutualExclusionResourceKind createMutualExclusionResourceKindFromString(EDataType eDataType, String initialValue) {
		MutualExclusionResourceKind result = MutualExclusionResourceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMutualExclusionResourceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrentAccessProtocolKind createConcurrentAccessProtocolKindFromString(EDataType eDataType, String initialValue) {
		ConcurrentAccessProtocolKind result = ConcurrentAccessProtocolKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConcurrentAccessProtocolKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_InteractionPackage getSW_InteractionPackage() {
		return (SW_InteractionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SW_InteractionPackage getPackage() {
		return SW_InteractionPackage.eINSTANCE;
	}

} //SW_InteractionFactoryImpl
