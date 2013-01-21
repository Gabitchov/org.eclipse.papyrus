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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Content Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider#getAxis <em>Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage#getDefaultContentProvider()
 * @model
 * @generated
 */
public interface DefaultContentProvider extends IAxisContentsProvider {
	/**
	 * Returns the value of the '<em><b>Axis</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxis}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage#getDefaultContentProvider_Axis()
	 * @model containment="true"
	 * @generated
	 */
	EList<IAxis> getAxis();

} // DefaultContentProvider
