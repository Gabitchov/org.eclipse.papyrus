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
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.dependability.HazardousEvent;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.requirements.Requirement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SafetyGoal represents the top-level safety requirement defined in ISO26262. Its purpose is to define how to avoid its associated HazardousEvents, or reduce the risk associated with the hazardous event to an acceptable level.
 * The SafetyGoal is defined through one or several associated requirement elements.
 * An ASIL shall be assigned to each SafetyGoal, to represent the integrity level at which the SafetyGoal must be met.
 * Similar SafetyGoals can be combined into one SafetyGoal. If different ASILs are assigned to similar SafetyGoals, the highest ASIL shall be assigned to the combined SafetyGoal. 
 * For every SafetyGoal, a safe state should be defined, either textually or by referencing a specific mode. The safe state is a system state to be maintained or to be reached when a potential source of its hazardous event is detected.
 * 
 * Semantics:
 * SafetyGoal represents a safety Goal according to ISO26262. Requirements define the SafetyGoal and HazardousEvents identify the responsibility of each SafetyGoal. hazardClassification defines the integrity classification of the SafetyGoal and safeStates may be defined by a string or formalized through associated Modes.
 * 
 * Notation:
 * SafetyGoal is a box with text SafetyGoal at the top left.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeStates <em>Safe States</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getHazardClassification <em>Hazard Classification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeModes <em>Safe Modes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal()
 * @model
 * @generated
 */
public interface SafetyGoal extends EAElement {
	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_DerivedFrom()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<HazardousEvent> getDerivedFrom();

	/**
	 * Returns the value of the '<em><b>Hazard Classification</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazard Classification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazard Classification</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #setHazardClassification(ASILKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_HazardClassification()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ASILKind getHazardClassification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getHazardClassification <em>Hazard Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hazard Classification</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #getHazardClassification()
	 * @generated
	 */
	void setHazardClassification(ASILKind value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_Requirement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getRequirement();

	/**
	 * Returns the value of the '<em><b>Safe Modes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Safe Modes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safe Modes</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_SafeModes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getSafeModes();

	/**
	 * Returns the value of the '<em><b>Safe States</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For every safety goal, a safe state should be defined, in order to declare a system state to be maintained or to be reached when the failure is detected and so to allow a failure mitigation action without any violation of the associated safety goal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Safe States</em>' attribute.
	 * @see #setSafeStates(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_SafeStates()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getSafeStates();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getSafeStates <em>Safe States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safe States</em>' attribute.
	 * @see #getSafeStates()
	 * @generated
	 */
	void setSafeStates(String value);

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage#getSafetyGoal_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // SafetyGoal
