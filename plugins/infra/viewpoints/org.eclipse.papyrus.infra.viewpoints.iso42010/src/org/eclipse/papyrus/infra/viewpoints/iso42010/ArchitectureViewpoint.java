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
 * A representation of the model object '<em><b>Architecture Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getModelKinds <em>Model Kinds</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns <em>Governs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getFrames <em>Frames</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureViewpoint()
 * @model
 * @generated
 */
public interface ArchitectureViewpoint extends ADElement {
	/**
	 * Returns the value of the '<em><b>Model Kinds</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint <em>Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Kinds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Kinds</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureViewpoint_ModelKinds()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getViewpoint
	 * @model opposite="viewpoint" containment="true" required="true"
	 * @generated
	 */
	EList<ModelKind> getModelKinds();

	/**
	 * Returns the value of the '<em><b>Governs</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Governs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Governs</em>' reference.
	 * @see #setGoverns(ArchitectureView)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureViewpoint_Governs()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getGovernedBy
	 * @model opposite="governedBy" required="true"
	 * @generated
	 */
	ArchitectureView getGoverns();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint#getGoverns <em>Governs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Governs</em>' reference.
	 * @see #getGoverns()
	 * @generated
	 */
	void setGoverns(ArchitectureView value);

	/**
	 * Returns the value of the '<em><b>Frames</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getFramedBy <em>Framed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frames</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frames</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureViewpoint_Frames()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Concern#getFramedBy
	 * @model opposite="framedBy" required="true"
	 * @generated
	 */
	EList<Concern> getFrames();

} // ArchitectureViewpoint
