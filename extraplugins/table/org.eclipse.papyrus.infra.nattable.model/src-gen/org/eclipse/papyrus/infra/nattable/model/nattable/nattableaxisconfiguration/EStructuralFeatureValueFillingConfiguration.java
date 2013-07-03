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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EStructural Feature Value Filling Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Configuration used to fill the table listening a feature of the context of the table
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration#getListenFeature
 * <em>Listen Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getEStructuralFeatureValueFillingConfiguration()
 * @model
 * @generated
 */
public interface EStructuralFeatureValueFillingConfiguration extends IFillingConfiguration {

	/**
	 * Returns the value of the '<em><b>Listen Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field can't be null. References the feature of the context of the table to listen.
	 * It is possible that the context doesn't have this feature.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Listen Feature</em>' reference.
	 * @see #setListenFeature(EStructuralFeature)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getEStructuralFeatureValueFillingConfiguration_ListenFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getListenFeature();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration#getListenFeature
	 * <em>Listen Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Listen Feature</em>' reference.
	 * @see #getListenFeature()
	 * @generated
	 */
	void setListenFeature(EStructuralFeature value);

} // EStructuralFeatureValueFillingConfiguration
