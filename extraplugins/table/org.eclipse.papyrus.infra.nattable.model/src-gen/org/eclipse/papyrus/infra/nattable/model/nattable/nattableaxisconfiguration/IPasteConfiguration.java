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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPaste Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Common Interface for the paste configuration.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration#getPostActions <em>Post Actions</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration#isDetachedMode <em>Detached Mode</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getIPasteConfiguration()
 * @model
 * @generated
 */
public interface IPasteConfiguration extends IAxisConfiguration {

	/**
	 * Returns the value of the '<em><b>Post Actions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references post actions, using a string to do during the paste, after the creation of the element.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Post Actions</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getIPasteConfiguration_PostActions()
	 * @model
	 * @generated
	 */
	EList<String> getPostActions();

	/**
	 * Returns the value of the '<em><b>Detached Mode</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, the created elements will be added at the end of the paste and the set values
	 * won't be do using the service edit
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Detached Mode</em>' attribute.
	 * @see #setDetachedMode(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getIPasteConfiguration_DetachedMode()
	 * @model default="true"
	 * @generated
	 */
	boolean isDetachedMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration#isDetachedMode
	 * <em>Detached Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Detached Mode</em>' attribute.
	 * @see #isDetachedMode()
	 * @generated
	 */
	void setDetachedMode(boolean value);
} // IPasteConfiguration
