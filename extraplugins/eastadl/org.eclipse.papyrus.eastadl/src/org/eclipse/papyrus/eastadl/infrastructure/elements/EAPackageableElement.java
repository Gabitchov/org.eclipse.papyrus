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
package org.eclipse.papyrus.eastadl.infrastructure.elements;

import org.eclipse.uml2.uml.PackageableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EA Packageable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement#getBase_PackageableElement <em>Base Packageable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getEAPackageableElement()
 * @model abstract="true"
 * @generated
 */
public interface EAPackageableElement extends EAElement {
	/**
	 * Returns the value of the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Packageable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Packageable Element</em>' reference.
	 * @see #setBase_PackageableElement(PackageableElement)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getEAPackageableElement_Base_PackageableElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PackageableElement getBase_PackageableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement#getBase_PackageableElement <em>Base Packageable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Packageable Element</em>' reference.
	 * @see #getBase_PackageableElement()
	 * @generated
	 */
	void setBase_PackageableElement(PackageableElement value);

} // EAPackageableElement
