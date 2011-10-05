/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polilyne</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.Polilyne#getWaypoints <em>Waypoints</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.Polilyne#getClosed <em>Closed</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.di.DiPackage#getPolilyne()
 * @model
 * @generated
 */
public interface Polilyne extends GraphicPrimitive {

	/**
	 * Returns the value of the '<em><b>Waypoints</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.draw2d.geometry.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waypoints</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Waypoints</em>' attribute list.
	 * @see org.eclipse.papyrus.di.DiPackage#getPolilyne_Waypoints()
	 * @model dataType="org.eclipse.papyrus.di.Point" lower="2"
	 * @generated
	 */
	EList<Point> getWaypoints();

	/**
	 * Returns the value of the '<em><b>Closed</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Closed</em>' attribute list.
	 * @see org.eclipse.papyrus.di.DiPackage#getPolilyne_Closed()
	 * @model dataType="org.eclipse.uml2.uml.Boolean" lower="2"
	 * @generated
	 */
	EList<Boolean> getClosed();

} // Polilyne
