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
 * A representation of the model object '<em><b>Correspondence Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule#getGoverns <em>Governs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getCorrespondenceRule()
 * @model
 * @generated
 */
public interface CorrespondenceRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Governs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getGovernedBy <em>Governed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Governs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Governs</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getCorrespondenceRule_Governs()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence#getGovernedBy
	 * @model opposite="governedBy" required="true"
	 * @generated
	 */
	EList<Correspondence> getGoverns();

} // CorrespondenceRule
