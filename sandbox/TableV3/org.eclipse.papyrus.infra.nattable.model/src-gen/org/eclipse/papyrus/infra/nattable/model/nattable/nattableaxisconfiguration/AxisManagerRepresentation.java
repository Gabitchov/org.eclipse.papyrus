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
 * A representation of the model object '<em><b>Axis Manager Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getAxisManagerId <em>Axis Manager Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getLabelProviderContext <em>Label Provider Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getHeaderLabelConfiguration <em>Header Label Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getSpecificAxisConfiguration <em>Specific Axis Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerRepresentation()
 * @model
 * @generated
 */
public interface AxisManagerRepresentation extends EObject {
	/**
	 * Returns the value of the '<em><b>Axis Manager Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Manager Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Manager Id</em>' attribute.
	 * @see #setAxisManagerId(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerRepresentation_AxisManagerId()
	 * @model required="true"
	 * @generated
	 */
	String getAxisManagerId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getAxisManagerId <em>Axis Manager Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Manager Id</em>' attribute.
	 * @see #getAxisManagerId()
	 * @generated
	 */
	void setAxisManagerId(String value);

	/**
	 * Returns the value of the '<em><b>Label Provider Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Provider Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Provider Context</em>' attribute.
	 * @see #setLabelProviderContext(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerRepresentation_LabelProviderContext()
	 * @model
	 * @generated
	 */
	String getLabelProviderContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getLabelProviderContext <em>Label Provider Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Provider Context</em>' attribute.
	 * @see #getLabelProviderContext()
	 * @generated
	 */
	void setLabelProviderContext(String value);

	/**
	 * Returns the value of the '<em><b>Header Label Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Label Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Label Configuration</em>' reference.
	 * @see #setHeaderLabelConfiguration(ILabelProviderConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerRepresentation_HeaderLabelConfiguration()
	 * @model required="true"
	 * @generated
	 */
	ILabelProviderConfiguration getHeaderLabelConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation#getHeaderLabelConfiguration <em>Header Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Label Configuration</em>' reference.
	 * @see #getHeaderLabelConfiguration()
	 * @generated
	 */
	void setHeaderLabelConfiguration(ILabelProviderConfiguration value);

	/**
	 * Returns the value of the '<em><b>Specific Axis Configuration</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Axis Configuration</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Axis Configuration</em>' reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAxisManagerRepresentation_SpecificAxisConfiguration()
	 * @model
	 * @generated
	 */
	EList<IAxisConfiguration> getSpecificAxisConfiguration();

} // AxisManagerRepresentation
