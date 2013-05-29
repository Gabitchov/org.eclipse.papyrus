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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ContainerConfiguration defines an actual configuration of the variable content of a ConfigurableContainer, in particular the selection or deselection of contained VariableElements and the configuration of the public feature models of contained other ConfigurableContainers. For more details on the variable content of a ConfigurableContainer refer to the documentation of meta-class ConfigurableContainer.
 * 
 * The ContainerConfiguration inherits from ConfigurationDecisionModel even though it does not define a configuration link between feature models, similar as FeatureConfiguration. For more information on this refer to the documentation of meta-class FeatureConfiguration.
 * 
 * The source and target feature models of a ContainerConfiguration are defined implicitly: it always has zero source feature models (as explained for FeatureConfiguration) and its target feature models can be deduced from the ConfigurableContainer being configured by applying the same rules as defined for InternalBinding.
 * 
 * Semantics:
 * The ContainerConfiguration specifies a concrete configuration of the variable content of a ConfigurableContainer.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ContainerConfiguration#getConfiguredContainer <em>Configured Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getContainerConfiguration()
 * @model
 * @generated
 */
public interface ContainerConfiguration extends ConfigurationDecisionModel {
	/**
	 * Returns the value of the '<em><b>Configured Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configured Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configured Container</em>' reference.
	 * @see #setConfiguredContainer(ConfigurableContainer)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getContainerConfiguration_ConfiguredContainer()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConfigurableContainer getConfiguredContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ContainerConfiguration#getConfiguredContainer <em>Configured Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configured Container</em>' reference.
	 * @see #getConfiguredContainer()
	 * @generated
	 */
	void setConfiguredContainer(ConfigurableContainer value);

} // ContainerConfiguration
