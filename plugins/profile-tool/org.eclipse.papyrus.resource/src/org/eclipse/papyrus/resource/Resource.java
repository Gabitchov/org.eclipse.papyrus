/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.resource.Resource#getEobjects <em>Eobjects</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.resource.ResourcePackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends EObject {

	/**
	 * Returns the value of the '<em><b>Eobjects</b></em>' containment reference list. The list
	 * contents are of type {@link org.eclipse.emf.ecore.EObject}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eobjects</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Eobjects</em>' containment reference list.
	 * @see org.eclipse.papyrus.resource.ResourcePackage#getResource_Eobjects()
	 * @model containment="true" transient="true" volatile="true"
	 * @generated
	 */
	EList<EObject> getEobjects();

} // Resource
