/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Context Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.DataContextPackage#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDataContextPackage()
 * @model
 * @generated
 */
public interface DataContextPackage extends DataContextElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.DataContextElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.DataContextElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDataContextPackage_Elements()
	 * @see org.eclipse.papyrus.properties.contexts.DataContextElement#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<DataContextElement> getElements();

} // DataContextPackage
