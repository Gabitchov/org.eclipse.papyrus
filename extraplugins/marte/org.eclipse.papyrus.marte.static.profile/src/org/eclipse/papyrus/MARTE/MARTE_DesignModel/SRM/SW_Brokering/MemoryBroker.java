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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SwResource;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Broker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getAccessPolicy <em>Access Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemories <em>Memories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockAdressElements <em>Memory Block Adress Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockSizeElements <em>Memory Block Size Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getLockServices <em>Lock Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnlockServices <em>Unlock Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMapServices <em>Map Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnMapServices <em>Un Map Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker()
 * @model
 * @generated
 */
public interface MemoryBroker extends SwResource {
	/**
	 * Returns the value of the '<em><b>Access Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind
	 * @see #setAccessPolicy(AccessPolicyKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_AccessPolicy()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	AccessPolicyKind getAccessPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getAccessPolicy <em>Access Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Policy</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind
	 * @see #getAccessPolicy()
	 * @generated
	 */
	void setAccessPolicy(AccessPolicyKind value);

	/**
	 * Returns the value of the '<em><b>Memories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memories</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_Memories()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getMemories();

	/**
	 * Returns the value of the '<em><b>Memory Block Adress Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Block Adress Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Block Adress Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_MemoryBlockAdressElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getMemoryBlockAdressElements();

	/**
	 * Returns the value of the '<em><b>Memory Block Size Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TypedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Block Size Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Block Size Elements</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_MemoryBlockSizeElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedElement> getMemoryBlockSizeElements();

	/**
	 * Returns the value of the '<em><b>Lock Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lock Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lock Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_LockServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getLockServices();

	/**
	 * Returns the value of the '<em><b>Unlock Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unlock Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unlock Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_UnlockServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getUnlockServices();

	/**
	 * Returns the value of the '<em><b>Map Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_MapServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getMapServices();

	/**
	 * Returns the value of the '<em><b>Un Map Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.BehavioralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Un Map Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Un Map Services</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage#getMemoryBroker_UnMapServices()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BehavioralFeature> getUnMapServices();

} // MemoryBroker
