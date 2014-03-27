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
 * A representation of the model object '<em><b>Model Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getGoverns <em>Governs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint <em>Viewpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getModelKind()
 * @model
 * @generated
 */
public interface ModelKind extends ADElement {
	/**
	 * Returns the value of the '<em><b>Governs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Governs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Governs</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getModelKind_Governs()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy
	 * @model opposite="governedBy" required="true"
	 * @generated
	 */
	EList<ArchitectureModel> getGoverns();

	/**
	 * Returns the value of the '<em><b>Viewpoint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getModelKinds <em>Model Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoint</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoint</em>' container reference.
	 * @see #setViewpoint(ArchitectureViewpoint)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getModelKind_Viewpoint()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getModelKinds
	 * @model opposite="modelKinds" required="true" transient="false"
	 * @generated
	 */
	ArchitectureViewpoint getViewpoint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint <em>Viewpoint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewpoint</em>' container reference.
	 * @see #getViewpoint()
	 * @generated
	 */
	void setViewpoint(ArchitectureViewpoint value);

} // ModelKind
