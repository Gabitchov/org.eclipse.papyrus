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
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#getChildType <em>Child Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsPermitted <em>Is Permitted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage#getHierarchyPermission()
 * @model
 * @generated
 */
public interface HierarchyPermission extends EObject {
	/**
	 * Returns the value of the '<em><b>Child Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Type</em>' attribute.
	 * @see #setChildType(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage#getHierarchyPermission_ChildType()
	 * @model
	 * @generated
	 */
	String getChildType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#getChildType <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Type</em>' attribute.
	 * @see #getChildType()
	 * @generated
	 */
	void setChildType(String value);

	/**
	 * Returns the value of the '<em><b>Is Permitted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Permitted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Permitted</em>' attribute.
	 * @see #setIsPermitted(boolean)
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage#getHierarchyPermission_IsPermitted()
	 * @model
	 * @generated
	 */
	boolean isIsPermitted();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsPermitted <em>Is Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Permitted</em>' attribute.
	 * @see #isIsPermitted()
	 * @generated
	 */
	void setIsPermitted(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #setIsStrict(boolean)
	 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage#getHierarchyPermission_IsStrict()
	 * @model
	 * @generated
	 */
	boolean isIsStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isIsStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

} // HierarchyPermission
