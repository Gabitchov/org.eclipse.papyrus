/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getExpresses <em>Expresses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRationales <em>Rationales</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getDecisions <em>Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription()
 * @model
 * @generated
 */
public interface ArchitectureDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Stakeholders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Concerns()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Concern> getConcerns();

	/**
	 * Returns the value of the '<em><b>Viewpoints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoints</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Viewpoints()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ArchitectureViewpoint> getViewpoints();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Views()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ArchitectureView> getViews();

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(org.eclipse.papyrus.infra.viewpoints.iso42010.System)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_System()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.eclipse.papyrus.infra.viewpoints.iso42010.System getSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(org.eclipse.papyrus.infra.viewpoints.iso42010.System value);

	/**
	 * Returns the value of the '<em><b>Expresses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expresses</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expresses</em>' containment reference.
	 * @see #setExpresses(Architecture)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Expresses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Architecture getExpresses();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription#getExpresses <em>Expresses</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expresses</em>' containment reference.
	 * @see #getExpresses()
	 * @generated
	 */
	void setExpresses(Architecture value);

	/**
	 * Returns the value of the '<em><b>Rationales</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rationales</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rationales</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Rationales()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ArchitectureRationale> getRationales();

	/**
	 * Returns the value of the '<em><b>Correspondences</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correspondences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correspondences</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Correspondences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Correspondence> getCorrespondences();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<CorrespondenceRule> getRules();

	/**
	 * Returns the value of the '<em><b>Decisions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decisions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decisions</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDescription_Decisions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArchitectureDecision> getDecisions();

} // ArchitectureDescription
