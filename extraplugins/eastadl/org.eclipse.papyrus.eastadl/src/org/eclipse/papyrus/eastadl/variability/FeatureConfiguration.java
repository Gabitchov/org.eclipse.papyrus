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
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FeatureConfiguration defines an actual configuration of a FeatureModel, in particular the selection or deselection of optional features, values for selected parameterized features, and instance creations for cloned features.
 * 
 * Note that configurations of feature models are realized as a specialization of metaclass ConfigurationDecisionModel. This is possible because a ConfigurationDecisionModel also captures configuration, i.e. of its target feature model(s) ; while in the standard case of ConfigurationDecisionModel this target-side configuration depends on a given configuration of source feature model(s), we here simply define a "constant" target-side configuration without considering any source configurations. Therefore, the FeatureConfiguration meta-class has additional constraints compared to the super-class ConfigurationDecisionModel: the FeatureConfiguration has no source FeatureModel and only a single target FeatureModel, which serves as the FeatureModel being configured, explicitly defined through association 'configuredFeatureModel'. And since there are no source feature model to which the criterion can refer, all ConfigurationDecisions in a FeatureConfiguration must have "true" as their criterion.
 * 
 * 
 * Semantics:
 * The FeatureConfiguration specifies a concrete configuration of a feature model, in particular which Features of this FeatureModel are selected or deselected.
 * 
 * Extension:
 * Class
 * 
 * Constraint:
 * [1] Attribute criterion of all ConfigurationDecisions in a FeatureConfiguration must be set to "true".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration#getConfiguredFeatureModel <em>Configured Feature Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getFeatureConfiguration()
 * @model
 * @generated
 */
public interface FeatureConfiguration extends ConfigurationDecisionModel {
	/**
	 * Returns the value of the '<em><b>Configured Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configured Feature Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configured Feature Model</em>' reference.
	 * @see #setConfiguredFeatureModel(FeatureModel)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getFeatureConfiguration_ConfiguredFeatureModel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FeatureModel getConfiguredFeatureModel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration#getConfiguredFeatureModel <em>Configured Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configured Feature Model</em>' reference.
	 * @see #getConfiguredFeatureModel()
	 * @generated
	 */
	void setConfiguredFeatureModel(FeatureModel value);

} // FeatureConfiguration
