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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architectural Description</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * A collection of products to document an architecture. [IEEE 1471]
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getAggregates <em>Aggregates</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription#getIdentifies <em>Identifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getArchitecturalDescription()
 * @model
 * @generated
 */
public interface ArchitecturalDescription extends Concept {

	/**
	 * Returns the value of the '<em><b>Aggregates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregates</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Aggregates</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getArchitecturalDescription_Aggregates()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ArchitecturalModel> getAggregates();

	/**
	 * Returns the value of the '<em><b>Identifies</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifies</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identifies</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getArchitecturalDescription_Identifies()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Stakeholder> getIdentifies();

} // ArchitecturalDescription
