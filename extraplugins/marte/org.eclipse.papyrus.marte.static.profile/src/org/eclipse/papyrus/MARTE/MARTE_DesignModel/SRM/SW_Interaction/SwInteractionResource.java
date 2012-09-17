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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SwResource;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sw Interaction Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#isIsIntraMemoryPartitionInteraction <em>Is Intra Memory Partition Interaction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueuePolicy <em>Waiting Queue Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueueCapacity <em>Waiting Queue Capacity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingPolicyElements <em>Waiting Policy Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwInteractionResource()
 * @model abstract="true"
 * @generated
 */
public interface SwInteractionResource extends SwResource {
	/**
	 * Returns the value of the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Intra Memory Partition Interaction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Intra Memory Partition Interaction</em>' attribute.
	 * @see #setIsIntraMemoryPartitionInteraction(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwInteractionResource_IsIntraMemoryPartitionInteraction()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	boolean isIsIntraMemoryPartitionInteraction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#isIsIntraMemoryPartitionInteraction <em>Is Intra Memory Partition Interaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Intra Memory Partition Interaction</em>' attribute.
	 * @see #isIsIntraMemoryPartitionInteraction()
	 * @generated
	 */
	void setIsIntraMemoryPartitionInteraction(boolean value);

	/**
	 * Returns the value of the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Queue Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Queue Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind
	 * @see #setWaitingQueuePolicy(QueuePolicyKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwInteractionResource_WaitingQueuePolicy()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	QueuePolicyKind getWaitingQueuePolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueuePolicy <em>Waiting Queue Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting Queue Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind
	 * @see #getWaitingQueuePolicy()
	 * @generated
	 */
	void setWaitingQueuePolicy(QueuePolicyKind value);

	/**
	 * Returns the value of the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Queue Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Queue Capacity</em>' attribute.
	 * @see #setWaitingQueueCapacity(int)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwInteractionResource_WaitingQueueCapacity()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Integer" ordered="false"
	 * @generated
	 */
	int getWaitingQueueCapacity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueueCapacity <em>Waiting Queue Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting Queue Capacity</em>' attribute.
	 * @see #getWaitingQueueCapacity()
	 * @generated
	 */
	void setWaitingQueueCapacity(int value);

	/**
	 * Returns the value of the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Policy Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Policy Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage#getSwInteractionResource_WaitingPolicyElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getWaitingPolicyElements();

} // SwInteractionResource
