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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Data Com Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getReadServices <em>Read Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getWriteServices <em>Write Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSharedDataComResource()
 * @model
 * @generated
 */
public interface SharedDataComResource extends SwCommunicationResource {
	/**
	 * Returns the value of the '<em><b>Read Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSharedDataComResource_ReadServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getReadServices();

	/**
	 * Returns the value of the '<em><b>Write Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSharedDataComResource_WriteServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getWriteServices();

} // SharedDataComResource
