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
package org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Type Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getValidTypes <em>Valid Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration#getCreationTypes <em>Creation Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationPackage#getSetTypeActionConfiguration()
 * @model
 * @generated
 */
public interface SetTypeActionConfiguration extends SemanticActionConfiguration {
	/**
	 * Returns the value of the '<em><b>Valid Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Types</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationPackage#getSetTypeActionConfiguration_ValidTypes()
	 * @model
	 * @generated
	 */
	EList<String> getValidTypes();

	/**
	 * Returns the value of the '<em><b>Creation Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Types</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationPackage#getSetTypeActionConfiguration_CreationTypes()
	 * @model
	 * @generated
	 */
	EList<String> getCreationTypes();

} // SetTypeActionConfiguration
