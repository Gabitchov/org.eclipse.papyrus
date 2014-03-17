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
 * A representation of the model object '<em><b>Architecture Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getJustifiedBy <em>Justified By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependsUpon <em>Depends Upon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependents <em>Dependents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getRaises <em>Raises</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getPertainsTo <em>Pertains To</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getAffects <em>Affects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision()
 * @model
 * @generated
 */
public interface ArchitectureDecision extends ADElement {
	/**
	 * Returns the value of the '<em><b>Justified By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale#getJustifies <em>Justifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Justified By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Justified By</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_JustifiedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureRationale#getJustifies
	 * @model opposite="justifies"
	 * @generated
	 */
	EList<ArchitectureRationale> getJustifiedBy();

	/**
	 * Returns the value of the '<em><b>Depends Upon</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependents <em>Dependents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends Upon</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends Upon</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_DependsUpon()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependents
	 * @model opposite="dependents"
	 * @generated
	 */
	EList<ArchitectureDecision> getDependsUpon();

	/**
	 * Returns the value of the '<em><b>Dependents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependsUpon <em>Depends Upon</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependents</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_Dependents()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getDependsUpon
	 * @model opposite="dependsUpon"
	 * @generated
	 */
	EList<ArchitectureDecision> getDependents();

	/**
	 * Returns the value of the '<em><b>Raises</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getRaisedBy <em>Raised By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raises</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raises</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_Raises()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getRaisedBy
	 * @model opposite="raisedBy"
	 * @generated
	 */
	EList<Concern> getRaises();

	/**
	 * Returns the value of the '<em><b>Pertains To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getDecisions <em>Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pertains To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pertains To</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_PertainsTo()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getDecisions
	 * @model opposite="decisions" required="true"
	 * @generated
	 */
	EList<Concern> getPertainsTo();

	/**
	 * Returns the value of the '<em><b>Affects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getAffectedBy <em>Affected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affects</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureDecision_Affects()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement#getAffectedBy
	 * @model opposite="affectedBy" required="true"
	 * @generated
	 */
	EList<ADElement> getAffects();

} // ArchitectureDecision
