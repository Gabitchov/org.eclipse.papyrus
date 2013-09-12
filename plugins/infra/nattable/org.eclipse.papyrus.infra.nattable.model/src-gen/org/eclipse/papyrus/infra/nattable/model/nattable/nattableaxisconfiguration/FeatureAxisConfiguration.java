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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Configuration to use for Axis representing features
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration#isShowOnlyCommonFeature <em>Show
 * Only Common Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getFeatureAxisConfiguration()
 * @model
 * @generated
 */
public interface FeatureAxisConfiguration extends IAxisConfiguration {

	/**
	 * Returns the value of the '<em><b>Show Only Common Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, only the common features will be displayed on the axis.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Show Only Common Feature</em>' attribute.
	 * @see #setShowOnlyCommonFeature(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getFeatureAxisConfiguration_ShowOnlyCommonFeature()
	 * @model
	 * @generated
	 */
	boolean isShowOnlyCommonFeature();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration#isShowOnlyCommonFeature
	 * <em>Show Only Common Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Show Only Common Feature</em>' attribute.
	 * @see #isShowOnlyCommonFeature()
	 * @generated
	 */
	void setShowOnlyCommonFeature(boolean value);

} // FeatureAxisConfiguration
