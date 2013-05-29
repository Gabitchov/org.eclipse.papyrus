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
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redefinable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RedefinableElement#getBase_RedefinableElement <em>Base Redefinable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRedefinableElement()
 * @model abstract="true"
 * @generated
 */
public interface RedefinableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Redefinable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Redefinable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Redefinable Element</em>' reference.
	 * @see #setBase_RedefinableElement(org.eclipse.uml2.uml.RedefinableElement)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRedefinableElement_Base_RedefinableElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.RedefinableElement getBase_RedefinableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RedefinableElement#getBase_RedefinableElement <em>Base Redefinable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Redefinable Element</em>' reference.
	 * @see #getBase_RedefinableElement()
	 * @generated
	 */
	void setBase_RedefinableElement(org.eclipse.uml2.uml.RedefinableElement value);

} // RedefinableElement
