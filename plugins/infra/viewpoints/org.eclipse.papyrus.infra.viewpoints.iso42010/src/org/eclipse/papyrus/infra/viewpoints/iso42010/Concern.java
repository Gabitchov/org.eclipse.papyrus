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
 * A representation of the model object '<em><b>Concern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getFramedBy <em>Framed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getAddressedBy <em>Addressed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getRaisedBy <em>Raised By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getDecisions <em>Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern()
 * @model
 * @generated
 */
public interface Concern extends ADElement {
	/**
	 * Returns the value of the '<em><b>Framed By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Framed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Framed By</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern_FramedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getFrames
	 * @model opposite="frames" required="true"
	 * @generated
	 */
	EList<ArchitectureViewpoint> getFramedBy();

	/**
	 * Returns the value of the '<em><b>Addressed By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getAddresses <em>Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addressed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addressed By</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern_AddressedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getAddresses
	 * @model opposite="addresses" required="true"
	 * @generated
	 */
	EList<ArchitectureView> getAddressedBy();

	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern_Stakeholders()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder#getConcerns
	 * @model opposite="concerns" required="true"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Raised By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getRaises <em>Raises</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised By</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern_RaisedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getRaises
	 * @model opposite="raises"
	 * @generated
	 */
	EList<ArchitectureDecision> getRaisedBy();

	/**
	 * Returns the value of the '<em><b>Decisions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getPertainsTo <em>Pertains To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decisions</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getConcern_Decisions()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDecision#getPertainsTo
	 * @model opposite="pertainsTo"
	 * @generated
	 */
	EList<ArchitectureDecision> getDecisions();

} // Concern
