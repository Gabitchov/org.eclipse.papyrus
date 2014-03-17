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

import org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Failure</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The FaultFailure represents a certain fault or failure on its referenced Anomaly. The faultFailureValue specifies the value of the Anomaly that the
 * FaultFailure corresponds to, i.e. one of the possible values of the Anomaly.
 * 
 * Semantics:
 * A FaultFailure is defined as a certain value, faultFailureValue, occurring at the referenced Anomaly.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getFaultFailureValue <em>Fault Failure Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getAnomaly <em>Anomaly</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getFaultFailure()
 * @model
 * @generated
 */
public interface FaultFailure extends TraceableSpecification {

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
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getFaultFailure_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getBase_Class <em>Base Class</em>}'
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
	 * Returns the value of the '<em><b>Anomaly</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anomaly</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Anomaly</em>' reference.
	 * @see #setAnomaly(Anomaly)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getFaultFailure_Anomaly()
	 * @model ordered="false"
	 * @generated
	 */
	Anomaly getAnomaly();

	/**
	 * Returns the value of the '<em><b>Fault Failure Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Failure Value</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fault Failure Value</em>' attribute.
	 * @see #setFaultFailureValue(String)
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage#getFaultFailure_FaultFailureValue()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getFaultFailureValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getAnomaly <em>Anomaly</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Anomaly</em>' reference.
	 * @see #getAnomaly()
	 * @generated
	 */
	void setAnomaly(Anomaly value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getFaultFailureValue
	 * <em>Fault Failure Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Fault Failure Value</em>' attribute.
	 * @see #getFaultFailureValue()
	 * @generated
	 */
	void setFaultFailureValue(String value);

} // FaultFailure
