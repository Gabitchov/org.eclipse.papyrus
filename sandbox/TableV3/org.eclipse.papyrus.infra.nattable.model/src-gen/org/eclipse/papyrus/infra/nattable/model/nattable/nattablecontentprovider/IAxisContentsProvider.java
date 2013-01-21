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

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IAxis Contents Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage#getIAxisContentsProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IAxisContentsProvider extends EModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IAxis> getAxis();

} // IAxisContentsProvider
