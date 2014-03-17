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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy <em>Governed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView <em>View</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureModel()
 * @model
 * @generated
 */
public interface ArchitectureModel extends ADElement {
	/**
	 * Returns the value of the '<em><b>Governed By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getGoverns <em>Governs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Governed By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Governed By</em>' reference.
	 * @see #setGovernedBy(ModelKind)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureModel_GovernedBy()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind#getGoverns
	 * @model opposite="governs" required="true"
	 * @generated
	 */
	ModelKind getGovernedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getGovernedBy <em>Governed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Governed By</em>' reference.
	 * @see #getGovernedBy()
	 * @generated
	 */
	void setGovernedBy(ModelKind value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' container reference.
	 * @see #setView(ArchitectureView)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitectureModel_View()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView#getModels
	 * @model opposite="models" required="true" transient="false"
	 * @generated
	 */
	ArchitectureView getView();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel#getView <em>View</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' container reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(ArchitectureView value);

} // ArchitectureModel
