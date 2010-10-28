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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Com Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#isIsFixedMessageSize <em>Is Fixed Message Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getMechanism <em>Mechanism</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getMessageSizeElements <em>Message Size Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getMessageQueueCapacityElements <em>Message Queue Capacity Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getMessageQueuePolicy <em>Message Queue Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getSendServices <em>Send Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl#getReceiveServices <em>Receive Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageComResourceImpl extends SwCommunicationResourceImpl implements MessageComResource {
	/**
	 * The default value of the '{@link #isIsFixedMessageSize() <em>Is Fixed Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFixedMessageSize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FIXED_MESSAGE_SIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFixedMessageSize() <em>Is Fixed Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFixedMessageSize()
	 * @generated
	 * @ordered
	 */
	protected boolean isFixedMessageSize = IS_FIXED_MESSAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMechanism() <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanism()
	 * @generated
	 * @ordered
	 */
	protected static final MessageResourceKind MECHANISM_EDEFAULT = MessageResourceKind.MESSAGE_QUEUE;

	/**
	 * The cached value of the '{@link #getMechanism() <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanism()
	 * @generated
	 * @ordered
	 */
	protected MessageResourceKind mechanism = MECHANISM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMessageSizeElements() <em>Message Size Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageSizeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> messageSizeElements;

	/**
	 * The cached value of the '{@link #getMessageQueueCapacityElements() <em>Message Queue Capacity Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageQueueCapacityElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> messageQueueCapacityElements;

	/**
	 * The default value of the '{@link #getMessageQueuePolicy() <em>Message Queue Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageQueuePolicy()
	 * @generated
	 * @ordered
	 */
	protected static final QueuePolicyKind MESSAGE_QUEUE_POLICY_EDEFAULT = QueuePolicyKind.FIFO;

	/**
	 * The cached value of the '{@link #getMessageQueuePolicy() <em>Message Queue Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageQueuePolicy()
	 * @generated
	 * @ordered
	 */
	protected QueuePolicyKind messageQueuePolicy = MESSAGE_QUEUE_POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSendServices() <em>Send Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSendServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> sendServices;

	/**
	 * The cached value of the '{@link #getReceiveServices() <em>Receive Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiveServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> receiveServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageComResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_InteractionPackage.Literals.MESSAGE_COM_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFixedMessageSize() {
		return isFixedMessageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFixedMessageSize(boolean newIsFixedMessageSize) {
		boolean oldIsFixedMessageSize = isFixedMessageSize;
		isFixedMessageSize = newIsFixedMessageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE, oldIsFixedMessageSize, isFixedMessageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageResourceKind getMechanism() {
		return mechanism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMechanism(MessageResourceKind newMechanism) {
		MessageResourceKind oldMechanism = mechanism;
		mechanism = newMechanism == null ? MECHANISM_EDEFAULT : newMechanism;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.MESSAGE_COM_RESOURCE__MECHANISM, oldMechanism, mechanism));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMessageSizeElements() {
		if (messageSizeElements == null) {
			messageSizeElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS);
		}
		return messageSizeElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMessageQueueCapacityElements() {
		if (messageQueueCapacityElements == null) {
			messageQueueCapacityElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS);
		}
		return messageQueueCapacityElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueuePolicyKind getMessageQueuePolicy() {
		return messageQueuePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageQueuePolicy(QueuePolicyKind newMessageQueuePolicy) {
		QueuePolicyKind oldMessageQueuePolicy = messageQueuePolicy;
		messageQueuePolicy = newMessageQueuePolicy == null ? MESSAGE_QUEUE_POLICY_EDEFAULT : newMessageQueuePolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY, oldMessageQueuePolicy, messageQueuePolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getSendServices() {
		if (sendServices == null) {
			sendServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.MESSAGE_COM_RESOURCE__SEND_SERVICES);
		}
		return sendServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getReceiveServices() {
		if (receiveServices == null) {
			receiveServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.MESSAGE_COM_RESOURCE__RECEIVE_SERVICES);
		}
		return receiveServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE:
				return isIsFixedMessageSize();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MECHANISM:
				return getMechanism();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS:
				return getMessageSizeElements();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS:
				return getMessageQueueCapacityElements();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY:
				return getMessageQueuePolicy();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__SEND_SERVICES:
				return getSendServices();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__RECEIVE_SERVICES:
				return getReceiveServices();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE:
				setIsFixedMessageSize((Boolean)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MECHANISM:
				setMechanism((MessageResourceKind)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS:
				getMessageSizeElements().clear();
				getMessageSizeElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS:
				getMessageQueueCapacityElements().clear();
				getMessageQueueCapacityElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY:
				setMessageQueuePolicy((QueuePolicyKind)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__SEND_SERVICES:
				getSendServices().clear();
				getSendServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__RECEIVE_SERVICES:
				getReceiveServices().clear();
				getReceiveServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE:
				setIsFixedMessageSize(IS_FIXED_MESSAGE_SIZE_EDEFAULT);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MECHANISM:
				setMechanism(MECHANISM_EDEFAULT);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS:
				getMessageSizeElements().clear();
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS:
				getMessageQueueCapacityElements().clear();
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY:
				setMessageQueuePolicy(MESSAGE_QUEUE_POLICY_EDEFAULT);
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__SEND_SERVICES:
				getSendServices().clear();
				return;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__RECEIVE_SERVICES:
				getReceiveServices().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE:
				return isFixedMessageSize != IS_FIXED_MESSAGE_SIZE_EDEFAULT;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MECHANISM:
				return mechanism != MECHANISM_EDEFAULT;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS:
				return messageSizeElements != null && !messageSizeElements.isEmpty();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS:
				return messageQueueCapacityElements != null && !messageQueueCapacityElements.isEmpty();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY:
				return messageQueuePolicy != MESSAGE_QUEUE_POLICY_EDEFAULT;
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__SEND_SERVICES:
				return sendServices != null && !sendServices.isEmpty();
			case SW_InteractionPackage.MESSAGE_COM_RESOURCE__RECEIVE_SERVICES:
				return receiveServices != null && !receiveServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isFixedMessageSize: ");
		result.append(isFixedMessageSize);
		result.append(", mechanism: ");
		result.append(mechanism);
		result.append(", messageQueuePolicy: ");
		result.append(messageQueuePolicy);
		result.append(')');
		return result.toString();
	}

} //MessageComResourceImpl
