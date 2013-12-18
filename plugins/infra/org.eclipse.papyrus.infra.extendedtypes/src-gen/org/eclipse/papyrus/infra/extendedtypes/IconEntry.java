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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Icon Entry</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath <em>Icon Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId <em>Bundle Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getIconEntry()
 * @model
 * @generated
 */
public interface IconEntry extends EObject {

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Path</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getIconEntry_IconPath()
	 * @model
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getIconPath
	 * <em>Icon Path</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Bundle Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bundle Id</em>' attribute.
	 * @see #setBundleId(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getIconEntry_BundleId()
	 * @model
	 * @generated
	 */
	String getBundleId();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.infra.extendedtypes.IconEntry#getBundleId
	 * <em>Bundle Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Bundle Id</em>' attribute.
	 * @see #getBundleId()
	 * @generated
	 */
	void setBundleId(String value);
} // IconEntry
