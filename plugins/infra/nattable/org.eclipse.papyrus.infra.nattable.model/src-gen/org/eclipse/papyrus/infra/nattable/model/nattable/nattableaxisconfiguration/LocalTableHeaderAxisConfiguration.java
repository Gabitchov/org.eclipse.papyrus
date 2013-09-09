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
 * A representation of the model object '<em><b>Local Table Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Define the configuration of the axis (rows or columns) in the table.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration#getAxisManagerConfigurations
 * <em>Axis Manager Configurations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getLocalTableHeaderAxisConfiguration()
 * @model
 * @generated
 */
public interface LocalTableHeaderAxisConfiguration extends AbstractHeaderAxisConfiguration {

	/**
	 * Returns the value of the '<em><b>Axis Manager Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list contains the configuration of the axis managers used in the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Axis Manager Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AxisManagerConfiguration> getAxisManagerConfigurations();

} // LocalTableHeaderAxisConfiguration
