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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder Need</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Stakeholder needs represent a list of the key problems as perceived by the stakeholder, and it gives the opportunity to establish traceability from artifacts created later, for example to provide rationales to design decisions or trade-off analysis.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getNeed <em>Need</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getStakeHolder <em>Stake Holder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getProblemStatement <em>Problem Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed()
 * @model
 * @generated
 */
public interface StakeholderNeed extends TraceableSpecification {
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
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Need</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need</em>' attribute.
	 * @see #setNeed(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed_Need()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getNeed();

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed_Priority()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getPriority();

	/**
	 * Returns the value of the '<em><b>Problem Statement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem Statement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem Statement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed_ProblemStatement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ProblemStatement> getProblemStatement();

	/**
	 * Returns the value of the '<em><b>Stake Holder</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stake Holder</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stake Holder</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getStakeholderNeed_StakeHolder()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Stakeholder> getStakeHolder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getNeed <em>Need</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need</em>' attribute.
	 * @see #getNeed()
	 * @generated
	 */
	void setNeed(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.StakeholderNeed#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

} // StakeholderNeed
