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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The fundamental organization of a system embodied in its components, their relationships to each other, and to the environment, and the principles guiding its design and evolution. [IEEE 1471]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.Architecture#getDescribedBy <em>Described By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getArchitecture()
 * @model
 * @generated
 */
public interface Architecture extends Concept {
	/**
	 * Returns the value of the '<em><b>Described By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Described By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Described By</em>' reference.
	 * @see #setDescribedBy(ArchitecturalDescription)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getArchitecture_DescribedBy()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ArchitecturalDescription getDescribedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.Architecture#getDescribedBy <em>Described By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Described By</em>' reference.
	 * @see #getDescribedBy()
	 * @generated
	 */
	void setDescribedBy(ArchitecturalDescription value);

} // Architecture
