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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getHasInterestIn <em>Has Interest In</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends ADElement {
	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getStakeholder_Concerns()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getStakeholders
	 * @model opposite="stakeholders" required="true"
	 * @generated
	 */
	EList<Concern> getConcerns();

	/**
	 * Returns the value of the '<em><b>Viewpoints</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoints</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getStakeholder_Viewpoints()
	 * @model required="true"
	 * @generated
	 */
	EList<ArchitectureViewpoint> getViewpoints();

	/**
	 * Returns the value of the '<em><b>Has Interest In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interest In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interest In</em>' reference.
	 * @see #setHasInterestIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getStakeholder_HasInterestIn()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System#getStakeholders
	 * @model opposite="stakeholders" required="true"
	 * @generated
	 */
	org.eclipse.papyrus.infra.viewpoints.iso42010.System getHasInterestIn();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getHasInterestIn <em>Has Interest In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Interest In</em>' reference.
	 * @see #getHasInterestIn()
	 * @generated
	 */
	void setHasInterestIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System value);

} // Stakeholder
