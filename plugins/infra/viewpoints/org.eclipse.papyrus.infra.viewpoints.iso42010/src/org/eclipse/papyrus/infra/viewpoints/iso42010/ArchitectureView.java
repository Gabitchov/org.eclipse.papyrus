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
 * A representation of the model object '<em><b>Architecture View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy <em>Governed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getAddresses <em>Addresses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureView()
 * @model
 * @generated
 */
public interface ArchitectureView extends ADElement {
	/**
	 * Returns the value of the '<em><b>Governed By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns <em>Governs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Governed By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Governed By</em>' reference.
	 * @see #setGovernedBy(ArchitectureViewpoint)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureView_GovernedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns
	 * @model opposite="governs" required="true"
	 * @generated
	 */
	ArchitectureViewpoint getGovernedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy <em>Governed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Governed By</em>' reference.
	 * @see #getGovernedBy()
	 * @generated
	 */
	void setGovernedBy(ArchitectureViewpoint value);

	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureView_Models()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView
	 * @model opposite="view" containment="true" required="true"
	 * @generated
	 */
	EList<ArchitectureModel> getModels();

	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getAddressedBy <em>Addressed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addresses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addresses</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureView_Addresses()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getAddressedBy
	 * @model opposite="addressedBy" required="true"
	 * @generated
	 */
	EList<Concern> getAddresses();

} // ArchitectureView
