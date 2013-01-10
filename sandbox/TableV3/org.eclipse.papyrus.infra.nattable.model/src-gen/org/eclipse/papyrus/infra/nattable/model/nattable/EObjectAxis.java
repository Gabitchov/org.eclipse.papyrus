/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis#getEobject <em>Eobject</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getEObjectAxis()
 * @model
 * @generated
 */
public interface EObjectAxis extends IAxis {
	/**
	 * Returns the value of the '<em><b>Eobject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eobject</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eobject</em>' reference.
	 * @see #setEobject(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getEObjectAxis_Eobject()
	 * @model
	 * @generated
	 */
	EObject getEobject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis#getEobject <em>Eobject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eobject</em>' reference.
	 * @see #getEobject()
	 * @generated
	 */
	void setEobject(EObject value);

} // EObjectAxis
