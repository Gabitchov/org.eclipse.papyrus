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

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration#getLabelConfiguration <em>Label Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractAxisConfiguration()
 * @model
 * @generated
 */
public interface AbstractAxisConfiguration extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Label Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Configuration</em>' containment reference.
	 * @see #setLabelConfiguration(ILabelConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractAxisConfiguration_LabelConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ILabelConfiguration getLabelConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration#getLabelConfiguration <em>Label Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Configuration</em>' containment reference.
	 * @see #getLabelConfiguration()
	 * @generated
	 */
	void setLabelConfiguration(ILabelConfiguration value);

} // AbstractAxisConfiguration
