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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutual Exclusion Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getProtectKind <em>Protect Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getCeiling <em>Ceiling</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getOtherProtectProtocol <em>Other Protect Protocol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler <em>Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getMutualExclusionResource()
 * @model
 * @generated
 */
public interface MutualExclusionResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Protect Kind</b></em>' attribute.
	 * The default value is <code>"PriorityInheritance"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protect Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protect Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind
	 * @see #setProtectKind(ProtectProtocolKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getMutualExclusionResource_ProtectKind()
	 * @model default="PriorityInheritance" unique="false" ordered="false"
	 * @generated
	 */
	ProtectProtocolKind getProtectKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getProtectKind <em>Protect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protect Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind
	 * @see #getProtectKind()
	 * @generated
	 */
	void setProtectKind(ProtectProtocolKind value);

	/**
	 * Returns the value of the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ceiling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ceiling</em>' attribute.
	 * @see #setCeiling(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getMutualExclusionResource_Ceiling()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getCeiling();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getCeiling <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ceiling</em>' attribute.
	 * @see #getCeiling()
	 * @generated
	 */
	void setCeiling(String value);

	/**
	 * Returns the value of the '<em><b>Other Protect Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Protect Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Protect Protocol</em>' attribute.
	 * @see #setOtherProtectProtocol(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getMutualExclusionResource_OtherProtectProtocol()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.String" ordered="false"
	 * @generated
	 */
	String getOtherProtectProtocol();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getOtherProtectProtocol <em>Other Protect Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Protect Protocol</em>' attribute.
	 * @see #getOtherProtectProtocol()
	 * @generated
	 */
	void setOtherProtectProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Scheduler</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProtectedSharedResources <em>Protected Shared Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler</em>' reference.
	 * @see #setScheduler(Scheduler)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getMutualExclusionResource_Scheduler()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProtectedSharedResources
	 * @model opposite="protectedSharedResources" ordered="false"
	 * @generated
	 */
	Scheduler getScheduler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler <em>Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduler</em>' reference.
	 * @see #getScheduler()
	 * @generated
	 */
	void setScheduler(Scheduler value);

} // MutualExclusionResource
