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
package org.eclipse.papyrus.eastadl.annex.needs;

import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The stakeholder represents various roles with regard to the creation and use of architectural descriptions. Stakeholders include clients, users,
 * the architect, developers, and evaluators. [IEEE 1471]
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getResponsibilities <em>Responsibilities</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getSuccessCriteria <em>Success Criteria</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends TraceableSpecification {

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
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholder_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Responsibilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsibilities</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Responsibilities</em>' attribute.
	 * @see #setResponsibilities(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholder_Responsibilities()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getResponsibilities();

	/**
	 * Returns the value of the '<em><b>Success Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success Criteria</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Success Criteria</em>' attribute.
	 * @see #setSuccessCriteria(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholder_SuccessCriteria()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getSuccessCriteria();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getResponsibilities <em>Responsibilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Responsibilities</em>' attribute.
	 * @see #getResponsibilities()
	 * @generated
	 */
	void setResponsibilities(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder#getSuccessCriteria <em>Success Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Success Criteria</em>' attribute.
	 * @see #getSuccessCriteria()
	 * @generated
	 */
	void setSuccessCriteria(String value);

} // Stakeholder
