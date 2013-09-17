/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptor#getPropertyRegistry <em>Property Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerDescriptor()
 * @model
 * @generated
 */
public interface LayerDescriptor extends EObject {

	/**
	 * Returns the value of the '<em><b>Property Registry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Registry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Registry</em>' reference.
	 * @see #setPropertyRegistry(PropertyRegistry)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerDescriptor_PropertyRegistry()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PropertyRegistry getPropertyRegistry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptor#getPropertyRegistry <em>Property Registry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Registry</em>' reference.
	 * @see #getPropertyRegistry()
	 * @generated
	 */
	void setPropertyRegistry(PropertyRegistry value);
} // LayerDescriptor
