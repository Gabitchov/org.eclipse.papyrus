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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Extended Element Type Set</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#isExtensible <em>Extensible</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet()
 * @model
 * @generated
 */
public interface ExtendedElementTypeSet extends ConfigurationElement {

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet_ElementType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ElementTypeConfiguration> getElementType();

	/**
	 * Returns the value of the '<em><b>Extensible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensible</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Extensible</em>' attribute.
	 * @see #setExtensible(boolean)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet_Extensible()
	 * @model
	 * @generated
	 */
	boolean isExtensible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#isExtensible <em>Extensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Extensible</em>' attribute.
	 * @see #isExtensible()
	 * @generated
	 */
	void setExtensible(boolean value);
} // ExtendedElementTypeSet
