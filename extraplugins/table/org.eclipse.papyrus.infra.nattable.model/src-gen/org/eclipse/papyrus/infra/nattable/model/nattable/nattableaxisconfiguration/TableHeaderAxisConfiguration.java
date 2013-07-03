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
 * A representation of the model object '<em><b>Table Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Defines the configuration of the axis in the TableConfiguration
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration#getAxisManagers <em>Axis
 * Managers</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getTableHeaderAxisConfiguration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='axisManagersIdUnique'"
 *        annotation=
 *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot axisManagersIdUnique='axisManagers->forAll(am1 : AxisManagerRepresentation, am2 : AxisManagerRepresentation | am1.axisManagerId <> am2.axisManagerId)'"
 * @generated
 */
public interface TableHeaderAxisConfiguration extends AbstractHeaderAxisConfiguration {

	/**
	 * Returns the value of the '<em><b>Axis Managers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list can't be empty. The list of the AxisManager used to fill the axis.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Axis Managers</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getTableHeaderAxisConfiguration_AxisManagers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AxisManagerRepresentation> getAxisManagers();

} // TableHeaderAxisConfiguration
