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
 * A representation of the model object '<em><b>Safety Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The SafetyConstraint metaclass represents the qualitative integrity constraints on a fault or failure. Thus, the system has same or better
 * performance with respect to the constrained fault or failure, and depending on the role this is either a requirement or a property.
 * 
 * Semantics:
 * A SafetyConstraint defines qualitative bounds on the constrainedFaultFailure in terms of safety integrity level, asilValue.
 * 
 * Depending on role, the SafetyConstraint may define a required or an actual safety integrity level.
 * 
 * 
 * Extension:
 * (see ADLTraceableSpecification)
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getAsilValue <em>Asil Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getConstrainedFaultFailure <em>Constrained Fault Failure
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Constraint <em>Base Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getSafetyConstraint()
 * @model
 * @generated
 */
public interface SafetyConstraint extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Asil Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asil Value</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Asil Value</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #setAsilValue(ASILKind)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getSafetyConstraint_AsilValue()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ASILKind getAsilValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getAsilValue <em>Asil Value</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Asil Value</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see #getAsilValue()
	 * @generated
	 */
	void setAsilValue(ASILKind value);

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getSafetyConstraint_ConstrainedFaultFailure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<FaultFailure> getConstrainedFaultFailure();

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getSafetyConstraint_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Class <em>Base Class</em>}'
	 * reference.
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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getSafetyConstraint_Base_Constraint()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Constraint
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

} // SafetyConstraint
