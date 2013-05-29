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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConfigurableContainer is a marker class that marks an element identified by association configurableElement as a configurable container of some variable content, i.e. VariableElements and other, lower-level ConfigurableContainers. In order to describe the contained variability to the outside world and to allow configuration of it, the ConfigurableContainer can have a public feature model and an internal configuration decision model not visible from the outside, called "internal binding".
 * 
 * In addition, the ConfigurableContainer can be used to extend the EAST-ADL2 variability approach to other languages and standards by pointing from the ConfigurableContainer to the respective (non EAST-ADL2) element with association configurableElement. This provides the public feature model and the ConfigurationDecisionModel to that non EAST-ADL2 element.
 * 
 * The variable content of a ConfigurableContainer is defined as all VariableElements and all other ConfigurableContainers that are directly or indirectly contained in the Identifiable denoted by association configurableElement. Instead of 'variable content' the term 'internal variability' may be used.
 * 
 * Note that, according to this rule, the containment between a ConfigurableContainer and its variable content, i.e. its contained VariableElements and lower-level ConfigurableContainers, is not(!) directly defined between these meta-classes. Instead, the containment is defined by the Identifiable pointed to by association configurableElement. For example, consider a FunctionType "WiperSystem" containing two FunctionPrototypes "front" and "rear" both typed by FunctionType "WiperMotor"; to make the wiper system configurable and the rear wiper motor optional, a ConfigurableContainer is created that points to FunctionType "WiperSystem" (with association configurableElement) and a VariableElement is created that points to FunctionPrototype "rear" (with association optionalElement); the containment between the ConfigurableContainer and the VariableElement is therefore not explicitly defined between these classes but instead only between FunctionType "WiperSystem" and "FunctionPrototype" rear. In addition, the variability-related visibility of "rear" can be changed with PrivateContent: by default the variability of "rear" will be public and visible for direct configuration from the outside of its containing ConfigurableContainer, i.e. "WiperSystem"; by defining a PrivateContent marker object pointing to the FunctionPrototype "rear" this can be changed to private and this variability will not be visible from the outside of "WiperSystem".
 * 
 * Constraints:
 * [1] Identifies one FunctionType or one HardwareComponentType.
 * 
 * [2] The publicFeatureModel is only allowed to contain Features (no VehicleFeatures).
 * 
 * Semantics:
 * Marks the element identified by association configurableElement as a configurable container of variable content (i.e. it contains VariableElements and/or other, lower-level ConfigurableContainers) and optionally provides a public feature model and an internal configuration decision model for it, thus providing configurability support for them.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getInternalBinding <em>Internal Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getVariationGroup <em>Variation Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getConfigurableElement <em>Configurable Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getPublicFeatureModel <em>Public Feature Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer()
 * @model
 * @generated
 */
public interface ConfigurableContainer extends EAElement {
	/**
	 * Returns the value of the '<em><b>Configurable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurable Element</em>' reference.
	 * @see #setConfigurableElement(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_ConfigurableElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getConfigurableElement();

	/**
	 * Returns the value of the '<em><b>Internal Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PDM of the configurable container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Binding</em>' reference.
	 * @see #setInternalBinding(InternalBinding)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_InternalBinding()
	 * @model ordered="false"
	 * @generated
	 */
	InternalBinding getInternalBinding();

	/**
	 * Returns the value of the '<em><b>Public Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local feature model of the configurable container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Public Feature Model</em>' reference.
	 * @see #setPublicFeatureModel(FeatureModel)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_PublicFeatureModel()
	 * @model ordered="false"
	 * @generated
	 */
	FeatureModel getPublicFeatureModel();

	/**
	 * Returns the value of the '<em><b>Variation Group</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.VariationGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variation groups that define certain constraints between this ADLVariableContainer's variable elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variation Group</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_VariationGroup()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VariationGroup> getVariationGroup();

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurableContainer_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getConfigurableElement <em>Configurable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configurable Element</em>' reference.
	 * @see #getConfigurableElement()
	 * @generated
	 */
	void setConfigurableElement(NamedElement value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getInternalBinding <em>Internal Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Binding</em>' reference.
	 * @see #getInternalBinding()
	 * @generated
	 */
	void setInternalBinding(InternalBinding value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer#getPublicFeatureModel <em>Public Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Feature Model</em>' reference.
	 * @see #getPublicFeatureModel()
	 * @generated
	 */
	void setPublicFeatureModel(FeatureModel value);

} // ConfigurableContainer
