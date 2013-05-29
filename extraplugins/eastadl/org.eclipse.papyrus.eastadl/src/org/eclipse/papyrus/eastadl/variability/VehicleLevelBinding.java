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
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Level Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents a ConfigurationDecisionModel on vehicle level with explicitly defined source and target feature models. The source feature models must be on vehicle level, but the target feature models may be located on artifact level, e.g. the public feature model of the top-level FunctionType in the FDA. This way, a VehicleLevelConfigurationDecisionModel may be used to bridge the gap from vehicle level variability management to that on artifact level.
 * 
 * Source feature models may be either the core technical feature model (as defined by association technicalFeatureModel of meta-class VehicleLevel) or one of the optional product feature models (as defined by association productFeatureModel of meta-class Variability in the variability extension).
 * 
 * Constraints:
 * [1] The sourceVehicleFeatureModels shall only contain VehicleFeatures.
 * [2] The sourceVehicleFeatureModels shall be different from the targetFeatureModels
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getSourceVehicleFeatureModel <em>Source Vehicle Feature Model</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding#getTargetFeatureModel <em>Target Feature Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVehicleLevelBinding()
 * @model
 * @generated
 */
public interface VehicleLevelBinding extends ConfigurationDecisionModel {
	/**
	 * Returns the value of the '<em><b>Source Vehicle Feature Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Vehicle Feature Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Vehicle Feature Model</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVehicleLevelBinding_SourceVehicleFeatureModel()
	 * @model
	 * @generated
	 */
	EList<FeatureModel> getSourceVehicleFeatureModel();

	/**
	 * Returns the value of the '<em><b>Target Feature Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Feature Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Feature Model</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVehicleLevelBinding_TargetFeatureModel()
	 * @model
	 * @generated
	 */
	EList<FeatureModel> getTargetFeatureModel();

} // VehicleLevelBinding
