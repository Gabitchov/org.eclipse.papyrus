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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture#getExhibitedIn <em>Exhibited In</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitecture()
 * @model
 * @generated
 */
public interface Architecture extends EObject {
	/**
	 * Returns the value of the '<em><b>Exhibited In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.System#getExhibits <em>Exhibits</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exhibited In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exhibited In</em>' reference.
	 * @see #setExhibitedIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System)
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package#getArchitecture_ExhibitedIn()
	 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.System#getExhibits
	 * @model opposite="exhibits" required="true"
	 * @generated
	 */
	org.eclipse.papyrus.infra.viewpoints.iso42010.System getExhibitedIn();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.iso42010.Architecture#getExhibitedIn <em>Exhibited In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exhibited In</em>' reference.
	 * @see #getExhibitedIn()
	 * @generated
	 */
	void setExhibitedIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System value);

} // Architecture
