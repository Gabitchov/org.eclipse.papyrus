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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.dependability.safetycase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SafetyCase represents a safety case that communicates a clear, comprehensive and defensible argument that a system is acceptable safe to operate in a given context.
 * 
 * Safety Cases are used in safety related systems, where failures can lead to catastrophic or at least dangerous consequences.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getSafetyCase <em>Safety Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getStage <em>Stage</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getGround <em>Ground</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getWarrant <em>Warrant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getClaim <em>Claim</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends TraceableSpecification {
	/**
	 * Returns the value of the '<em><b>Claim</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Claim}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Claim</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Claim</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Claim()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Claim> getClaim();

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Context()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getContext();

	/**
	 * Returns the value of the '<em><b>Ground</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Ground}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ground</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ground</em>' containment reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Ground()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Ground> getGround();

	/**
	 * Returns the value of the '<em><b>Safety Case</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Attached SafetyCases
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Safety Case</em>' containment reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_SafetyCase()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SafetyCase> getSafetyCase();

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.safetycase.LifecycleStageKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.LifecycleStageKind
	 * @see #setStage(LifecycleStageKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Stage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LifecycleStageKind getStage();

	/**
	 * Returns the value of the '<em><b>Warrant</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warrant</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warrant</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage#getSafetyCase_Warrant()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Warrant> getWarrant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetycase.LifecycleStageKind
	 * @see #getStage()
	 * @generated
	 */
	void setStage(LifecycleStageKind value);

} // SafetyCase
