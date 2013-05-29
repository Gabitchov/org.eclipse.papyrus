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
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The collection of variability descriptions, related feature models, and decision models. This collection can be done across the EAST-ADL2 abstraction levels.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getConfigurableContainer <em>Configurable Container</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getProductFeatureModel <em>Product Feature Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getDecisionModel <em>Decision Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.Variability#getVariableElement <em>Variable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability()
 * @model
 * @generated
 */
public interface Variability extends Context {
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
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Class <em>Base Class</em>}' reference.
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
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.Variability#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Configurable Container</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurable Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurable Container</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_ConfigurableContainer()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigurableContainer> getConfigurableContainer();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_Configuration()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureConfiguration> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Decision Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decision Model</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decision Model</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_DecisionModel()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VehicleLevelBinding> getDecisionModel();

	/**
	 * Returns the value of the '<em><b>Product Feature Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Feature Model</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Feature Model</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_ProductFeatureModel()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureModel> getProductFeatureModel();

	/**
	 * Returns the value of the '<em><b>Variable Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.VariableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Element</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariability_VariableElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VariableElement> getVariableElement();

} // Variability
