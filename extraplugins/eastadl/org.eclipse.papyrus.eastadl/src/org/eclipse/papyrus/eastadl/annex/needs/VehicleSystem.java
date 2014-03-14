/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.annex.needs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle System</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * A collection of components organized to accomplish a specific function or set of functions. [IEEE 1471]
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getFulfills <em>Fulfills</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHasAn <em>Has An</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHas <em>Has</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getVehicleSystem()
 * @model
 * @generated
 */
public interface VehicleSystem extends Concept {

	/**
	 * Returns the value of the '<em><b>Fulfills</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.Mission}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fulfills</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fulfills</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getVehicleSystem_Fulfills()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Mission> getFulfills();

	/**
	 * Returns the value of the '<em><b>Has</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.Stakeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Has</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getVehicleSystem_Has()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Stakeholder> getHas();

	/**
	 * Returns the value of the '<em><b>Has An</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has An</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Has An</em>' reference.
	 * @see #setHasAn(Architecture)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getVehicleSystem_HasAn()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Architecture getHasAn();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.VehicleSystem#getHasAn <em>Has An</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Has An</em>' reference.
	 * @see #getHasAn()
	 * @generated
	 */
	void setHasAn(Architecture value);

} // VehicleSystem
