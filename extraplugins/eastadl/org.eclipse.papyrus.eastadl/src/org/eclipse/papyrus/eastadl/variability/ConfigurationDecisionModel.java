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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Decision Model</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * A ConfigurationDecisionModel defines how to configure m so-called target feature models, depending on a given configuration of n so-called source
 * feature models, thus establishing a configuration-related link from the n source feature models to the m target feature models (also called
 * configuration link). With the information captured in a ConfigurationDecisionModel it is then possible to transform a given set of source
 * configurations (one for every source feature model) into corresponding target configurations (one for every target feature model).
 * 
 * For example, a ConfigurationDecisionModel can capture information such as
 * "if feature 'S-Class' is selected in the source feature model, then select feature 'RainSensor' in the target feature model" or
 * "if feature 'USA' is selected in the source feature model, then select feature 'CupHolder' in the target feature model".
 * 
 * Note that in principle all ConfigurationDecisionModels have source / target feature models. However, only for those used on vehicle level they are
 * defined explicitly; for ConfigurationDecisionModels used as an internal binding on FunctionTypes the source and target feature models are defined
 * implicitly (cf. metaclass InternalBinding). In addition, in the special case of FeatureConfiguration there is by definition no source and only a
 * single target feature model, which is defined explicitly (cf. metaclass FeatureConfiguration).
 * 
 * The configuration information captured in a ConfigurationDecisionModel is represented by ConfigurationDecisions, each of which captures a single,
 * atomized rule on how to configure the target feature model(s) depending on a given configuration of the source feature model(s).
 * 
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getRootEntry <em>Root Entry</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionModel()
 * @model abstract="true"
 * @generated
 */
public interface ConfigurationDecisionModel extends EAElement {

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionModel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Package <em>Base Package</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionModel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Root Entry</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Entry</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Root Entry</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionModel_RootEntry()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigurationDecisionModelEntry> getRootEntry();

} // ConfigurationDecisionModel
