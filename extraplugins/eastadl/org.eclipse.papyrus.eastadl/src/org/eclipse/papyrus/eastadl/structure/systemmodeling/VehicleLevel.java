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
package org.eclipse.papyrus.eastadl.structure.systemmodeling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Level</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * VehicleLevel represents an arbitrary set of feature models containing only VehicleFeatures.
 * 
 * Constraints:
 * [1] All contained feature models are FeatureModels that only contain VehicleFeatures.
 * 
 * Semantics:
 * The VehicleLevel contains the technical feature models.
 * 
 * Extension: class.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getTechnicalFeatureModel <em>Technical Feature Model</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getVehicleLevel()
 * @model
 * @generated
 */
public interface VehicleLevel extends Context {

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getVehicleLevel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Package <em>Base Package</em>}'
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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getVehicleLevel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Technical Feature Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technical Feature Model</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Technical Feature Model</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getVehicleLevel_TechnicalFeatureModel()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureModel> getTechnicalFeatureModel();

} // VehicleLevel
