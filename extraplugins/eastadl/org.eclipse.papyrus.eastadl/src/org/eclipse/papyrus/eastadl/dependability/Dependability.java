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
package org.eclipse.papyrus.eastadl.dependability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependability</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFunctionalSafetyConcept <em>Functional Safety Concept</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyGoal <em>Safety Goal</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getTechnicalSafetyConcept <em>Technical Safety Concept</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getHazardousEvent <em>Hazardous Event</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFeatureFlaw <em>Feature Flaw</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getItem <em>Item</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getEADatatype <em>EA Datatype</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getFaultFailure <em>Fault Failure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getQuantitativeSafetyConstraint <em>Quantitative Safety Constraint</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyConstraint <em>Safety Constraint</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getSafetyCase <em>Safety Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getErrorModelType <em>Error Model Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability()
 * @model
 * @generated
 */
public interface Dependability extends Context {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.Dependability#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Error Model Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Model Type</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Error Model Type</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_ErrorModelType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ErrorModelType> getErrorModelType();

	/**
	 * Returns the value of the '<em><b>Fault Failure</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Failure</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fault Failure</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_FaultFailure()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FaultFailure> getFaultFailure();

	/**
	 * Returns the value of the '<em><b>Feature Flaw</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.FeatureFlaw}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Flaw</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Flaw</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_FeatureFlaw()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureFlaw> getFeatureFlaw();

	/**
	 * Returns the value of the '<em><b>Functional Safety Concept</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Safety Concept</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Functional Safety Concept</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_FunctionalSafetyConcept()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionalSafetyConcept> getFunctionalSafetyConcept();

	/**
	 * Returns the value of the '<em><b>Hazardous Event</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.HazardousEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazardous Event</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hazardous Event</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_HazardousEvent()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HazardousEvent> getHazardousEvent();

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.Item}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Item</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_Item()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Item> getItem();

	/**
	 * Returns the value of the '<em><b>EA Datatype</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EA Datatype</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EA Datatype</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_EADatatype()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EADatatype> getEADatatype();

	/**
	 * Returns the value of the '<em><b>Quantitative Safety Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantitative Safety Constraint</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Quantitative Safety Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_QuantitativeSafetyConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<QuantitativeSafetyConstraint> getQuantitativeSafetyConstraint();

	/**
	 * Returns the value of the '<em><b>Safety Case</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Safety Case</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Safety Case</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_SafetyCase()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SafetyCase> getSafetyCase();

	/**
	 * Returns the value of the '<em><b>Safety Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Safety Constraint</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Safety Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_SafetyConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SafetyConstraint> getSafetyConstraint();

	/**
	 * Returns the value of the '<em><b>Safety Goal</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Safety Goal</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Safety Goal</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_SafetyGoal()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SafetyGoal> getSafetyGoal();

	/**
	 * Returns the value of the '<em><b>Technical Safety Concept</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technical Safety Concept</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Technical Safety Concept</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.DependabilityPackage#getDependability_TechnicalSafetyConcept()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TechnicalSafetyConcept> getTechnicalSafetyConcept();

} // Dependability
