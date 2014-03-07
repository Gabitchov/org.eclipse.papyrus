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
package org.eclipse.papyrus.eastadl.dependability.safetyconstraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.uml2.uml.Constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantitative Safety Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The QuantitativeSafetyConstraint metaclass represents the quantitative integrity constraints on a fault or failure. Thus, the system has same or
 * better performance with respect to the constrained fault or failure, and depending on the role this is either a requirement or a property.
 * 
 * Semantics:
 * A QuantitativeSafetyConstraint provides information about the probabilistic estimates of target faults/failures, further specified by the
 * failureRate and repairRate attribute.
 * 
 * Extension:
 * (see ADLTraceableSpecification)
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getConstrainedFaultFailure <em>Constrained
 * Fault Failure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getFailureRate <em>Failure Rate</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getRepairRate <em>Repair Rate</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Constraint <em>Base Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint()
 * @model
 * @generated
 */
public interface QuantitativeSafetyConstraint extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Constrained Fault Failure</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Fault Failure</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constrained Fault Failure</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint_ConstrainedFaultFailure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<FaultFailure> getConstrainedFaultFailure();

	/**
	 * Returns the value of the '<em><b>Failure Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Rate</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Failure Rate</em>' attribute.
	 * @see #setFailureRate(Float)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint_FailureRate()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" required="true" ordered="false"
	 * @generated
	 */
	Float getFailureRate();

	/**
	 * Returns the value of the '<em><b>Repair Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Rate</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Repair Rate</em>' attribute.
	 * @see #setRepairRate(Float)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint_RepairRate()
	 * @model unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" required="true" ordered="false"
	 * @generated
	 */
	Float getRepairRate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getFailureRate
	 * <em>Failure Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Failure Rate</em>' attribute.
	 * @see #getFailureRate()
	 * @generated
	 */
	void setFailureRate(Float value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getRepairRate
	 * <em>Repair Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Repair Rate</em>' attribute.
	 * @see #getRepairRate()
	 * @generated
	 */
	void setRepairRate(Float value);

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Class
	 * <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getQuantitativeSafetyConstraint_Base_Constraint()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Constraint
	 * <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

} // QuantitativeSafetyConstraint
