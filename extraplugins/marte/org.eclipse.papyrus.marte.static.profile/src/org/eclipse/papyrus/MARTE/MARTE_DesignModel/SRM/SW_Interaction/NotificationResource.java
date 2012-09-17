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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurence <em>Occurence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMechanism <em>Mechanism</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurenceCountElements <em>Occurence Count Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMaskElements <em>Mask Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getFlushServices <em>Flush Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getSignalServices <em>Signal Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getWaitServices <em>Wait Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getClearServices <em>Clear Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource()
 * @model
 * @generated
 */
public interface NotificationResource extends SwSynchronizationResource {
	/**
	 * Returns the value of the '<em><b>Occurence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occurence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurence</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind
	 * @see #setOccurence(NotificationKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_Occurence()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	NotificationKind getOccurence();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurence <em>Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurence</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind
	 * @see #getOccurence()
	 * @generated
	 */
	void setOccurence(NotificationKind value);

	/**
	 * Returns the value of the '<em><b>Mechanism</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mechanism</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mechanism</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind
	 * @see #setMechanism(NotificationResourceKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_Mechanism()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	NotificationResourceKind getMechanism();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMechanism <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mechanism</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind
	 * @see #getMechanism()
	 * @generated
	 */
	void setMechanism(NotificationResourceKind value);

	/**
	 * Returns the value of the '<em><b>Occurence Count Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occurence Count Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurence Count Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_OccurenceCountElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getOccurenceCountElements();

	/**
	 * Returns the value of the '<em><b>Mask Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_MaskElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getMaskElements();

	/**
	 * Returns the value of the '<em><b>Flush Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flush Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flush Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_FlushServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getFlushServices();

	/**
	 * Returns the value of the '<em><b>Signal Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_SignalServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getSignalServices();

	/**
	 * Returns the value of the '<em><b>Wait Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_WaitServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getWaitServices();

	/**
	 * Returns the value of the '<em><b>Clear Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getNotificationResource_ClearServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getClearServices();

} // NotificationResource
