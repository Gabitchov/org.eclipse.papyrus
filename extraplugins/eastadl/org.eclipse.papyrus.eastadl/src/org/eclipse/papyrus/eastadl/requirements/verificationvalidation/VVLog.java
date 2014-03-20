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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VV Log</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * ConcreteVVCase represents the precise description of a V&V effort on a concrete technical level and thus provides all necessary information to
 * actually perform this V&V effort. However, it does not represent the actual execution of the effort.
 * 
 * This is the purpose of the VVLog. Each VVLog metaclass represents a certain execution of a ConcreteVVCase.
 * 
 * For example, if the HIL test of the wiper system with a certain set of stimuli was performed on Friday afternoon and, for checkup, again on Monday,
 * then there will be one ConcreteVVCase describing the HIL test and two VVLogs describing the test result from Friday and Monday respectively.
 * 
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getDate <em>Date</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getVvActualOutcome <em>Vv Actual Outcome</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getPerformedVVProcedure <em>Performed VV Procedure</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVLog()
 * @model
 * @generated
 */
public interface VVLog extends TraceableSpecification {

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
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVLog_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Date and time when this log was captured.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVLog_Date()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDate();

	/**
	 * Returns the value of the '<em><b>Performed VV Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Performed VV Procedure</em>' reference.
	 * @see #setPerformedVVProcedure(VVProcedure)
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVLog_PerformedVVProcedure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VVProcedure getPerformedVVProcedure();

	/**
	 * Returns the value of the '<em><b>Vv Actual Outcome</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVActualOutcome}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set of outcome results.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Vv Actual Outcome</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVLog_VvActualOutcome()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VVActualOutcome> getVvActualOutcome();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getBase_Class <em>Base Class</em>}'
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
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog#getPerformedVVProcedure
	 * <em>Performed VV Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Performed VV Procedure</em>' reference.
	 * @see #getPerformedVVProcedure()
	 * @generated
	 */
	void setPerformedVVProcedure(VVProcedure value);

} // VVLog
