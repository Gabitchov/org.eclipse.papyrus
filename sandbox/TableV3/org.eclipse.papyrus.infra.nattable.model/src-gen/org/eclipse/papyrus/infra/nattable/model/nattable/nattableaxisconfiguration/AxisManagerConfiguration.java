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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis Manager Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalHeaderLabelConfiguration <em>Local Header Label Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getAxisManager <em>Axis Manager</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalSpecificConfigurations <em>Local Specific Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerConfiguration()
 * @model
 * @generated
 */
public interface AxisManagerConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Local Header Label Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Header Label Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Header Label Configuration</em>' reference.
	 * @see #setLocalHeaderLabelConfiguration(ILabelProviderConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerConfiguration_LocalHeaderLabelConfiguration()
	 * @model
	 * @generated
	 */
	ILabelProviderConfiguration getLocalHeaderLabelConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getLocalHeaderLabelConfiguration <em>Local Header Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Header Label Configuration</em>' reference.
	 * @see #getLocalHeaderLabelConfiguration()
	 * @generated
	 */
	void setLocalHeaderLabelConfiguration(ILabelProviderConfiguration value);

	/**
	 * Returns the value of the '<em><b>Axis Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Manager</em>' reference.
	 * @see #setAxisManager(AxisManagerRepresentation)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerConfiguration_AxisManager()
	 * @model required="true"
	 * @generated
	 */
	AxisManagerRepresentation getAxisManager();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration#getAxisManager <em>Axis Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Manager</em>' reference.
	 * @see #getAxisManager()
	 * @generated
	 */
	void setAxisManager(AxisManagerRepresentation value);

	/**
	 * Returns the value of the '<em><b>Local Specific Configurations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Specific Configurations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Specific Configurations</em>' reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerConfiguration_LocalSpecificConfigurations()
	 * @model
	 * @generated
	 */
	EList<IAxisConfiguration> getLocalSpecificConfigurations();

} // AxisManagerConfiguration
