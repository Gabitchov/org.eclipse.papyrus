/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.TypeRegistry#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getTypeRegistry()
 * @model
 * @generated
 */
public interface TypeRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.papyrus.layers.stackmodel.layers.Type},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' map.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getTypeRegistry_Types()
	 * @model mapType="org.eclipse.papyrus.layers.stackmodel.layers.StringToTypeMap<org.eclipse.papyrus.layers.stackmodel.layers.String, org.eclipse.papyrus.layers.stackmodel.layers.Type>" ordered="false"
	 * @generated
	 */
	EMap<String, Type> getTypes();

} // TypeRegistry
