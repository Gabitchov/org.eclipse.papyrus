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
 * A representation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The problem statement represents a brief statement summarizing the problem being solved which gives the opportunity to establish traceability from artifacts created later, for example to provide rationales to design decisions or trade-off analysis.
 * 
 * The problem statement could be extended with further modeling of dependencies between different problems and deduction of root problems
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getAffects <em>Affects</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getImpact <em>Impact</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getProblem <em>Problem</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getSolutionBenefits <em>Solution Benefits</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement()
 * @model
 * @generated
 */
public interface ProblemStatement extends TraceableSpecification {
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
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Affects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affects</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement_Affects()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Stakeholder> getAffects();

	/**
	 * Returns the value of the '<em><b>Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impact</em>' attribute.
	 * @see #setImpact(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement_Impact()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getImpact();

	/**
	 * Returns the value of the '<em><b>Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' attribute.
	 * @see #setProblem(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement_Problem()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getProblem();

	/**
	 * Returns the value of the '<em><b>Solution Benefits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution Benefits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution Benefits</em>' attribute.
	 * @see #setSolutionBenefits(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProblemStatement_SolutionBenefits()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getSolutionBenefits();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getImpact <em>Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact</em>' attribute.
	 * @see #getImpact()
	 * @generated
	 */
	void setImpact(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getProblem <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' attribute.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement#getSolutionBenefits <em>Solution Benefits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution Benefits</em>' attribute.
	 * @see #getSolutionBenefits()
	 * @generated
	 */
	void setSolutionBenefits(String value);

} // ProblemStatement
