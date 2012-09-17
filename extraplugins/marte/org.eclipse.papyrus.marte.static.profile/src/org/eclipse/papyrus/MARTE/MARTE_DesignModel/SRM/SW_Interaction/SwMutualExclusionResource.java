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
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sw Mutual Exclusion Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getMechanism <em>Mechanism</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getConcurrentAccessProtocol <em>Concurrent Access Protocol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAccessTokenElements <em>Access Token Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getReleaseServices <em>Release Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAcquireServices <em>Acquire Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource()
 * @model
 * @generated
 */
public interface SwMutualExclusionResource extends SwSynchronizationResource, MutualExclusionResource {
	/**
	 * Returns the value of the '<em><b>Mechanism</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mechanism</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mechanism</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind
	 * @see #setMechanism(MutualExclusionResourceKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource_Mechanism()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	MutualExclusionResourceKind getMechanism();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getMechanism <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mechanism</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind
	 * @see #getMechanism()
	 * @generated
	 */
	void setMechanism(MutualExclusionResourceKind value);

	/**
	 * Returns the value of the '<em><b>Concurrent Access Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concurrent Access Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concurrent Access Protocol</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind
	 * @see #setConcurrentAccessProtocol(ConcurrentAccessProtocolKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource_ConcurrentAccessProtocol()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	ConcurrentAccessProtocolKind getConcurrentAccessProtocol();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getConcurrentAccessProtocol <em>Concurrent Access Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concurrent Access Protocol</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind
	 * @see #getConcurrentAccessProtocol()
	 * @generated
	 */
	void setConcurrentAccessProtocol(ConcurrentAccessProtocolKind value);

	/**
	 * Returns the value of the '<em><b>Access Token Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Token Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Token Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource_AccessTokenElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getAccessTokenElements();

	/**
	 * Returns the value of the '<em><b>Release Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource_ReleaseServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getReleaseServices();

	/**
	 * Returns the value of the '<em><b>Acquire Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acquire Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquire Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwMutualExclusionResource_AcquireServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getAcquireServices();

} // SwMutualExclusionResource
