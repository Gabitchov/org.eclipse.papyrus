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
package org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling;

import org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Vehicle Feature</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * VehicleFeature represents a special kind of feature intended for use on the vehicle level. The main difference to features in general is that they
 * provide support for the multi-level concept (with their DeviationAttributeSet) and several additional attributes with meta-information specific to
 * the vehicle level viewpoint.
 * 
 * 
 * Constraints:
 * [1] VehicleFeatures can only be contained in FeatureModels on VehicleLevel.
 * 
 * Semantics:
 * A VehicleFeature is a functional or non-functional characteristic, constraint or property that can be present or not in a vehicle product line on
 * the level of the complete system, i.e. vehicle.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsDesignVariabilityRationale <em>Is Design Variability
 * Rationale</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsCustomerVisible <em>Is Customer Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsRemoved <em>Is Removed</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#getDeviationAttributeSet <em>Deviation Attribute Set</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getVehicleFeature()
 * @model
 * @generated
 */
public interface VehicleFeature extends Feature {

	/**
	 * Returns the value of the '<em><b>Deviation Attribute Set</b></em>' containment reference. It
	 * is bidirectional and its opposite is ' {@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationAttributeSet#getFeature
	 * <em>Feature</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deviation Attribute Set</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The deviation attributes belong to vehicle
	 * features that are part of a reference feature model in the context of multi-level feature
	 * models. The attribute can constrain the allowed deviation for the respective referring
	 * features. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Deviation Attribute Set</em>' containment reference.
	 * @see #setDeviationAttributeSet(DeviationAttributeSet)
	 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getVehicleFeature_DeviationAttributeSet()
	 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationAttributeSet#getFeature
	 * @model opposite="feature" containment="true" ordered="false"
	 * @generated
	 */
	DeviationAttributeSet getDeviationAttributeSet();

	/**
	 * Returns the value of the '<em><b>Is Customer Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Customer Visible</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Customer Visible</em>' attribute.
	 * @see #setIsCustomerVisible(boolean)
	 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getVehicleFeature_IsCustomerVisible()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsCustomerVisible();

	/**
	 * Returns the value of the '<em><b>Is Design Variability Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Design Variability Rationale</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Design Variability Rationale</em>' attribute.
	 * @see #setIsDesignVariabilityRationale(boolean)
	 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getVehicleFeature_IsDesignVariabilityRationale()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsDesignVariabilityRationale();

	/**
	 * Returns the value of the '<em><b>Is Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Removed</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Removed</em>' attribute.
	 * @see #setIsRemoved(boolean)
	 * @see org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage#getVehicleFeature_IsRemoved()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsRemoved();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#getDeviationAttributeSet
	 * <em>Deviation Attribute Set</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Deviation Attribute Set</em>' reference.
	 * @see #getDeviationAttributeSet()
	 * @generated
	 */
	void setDeviationAttributeSet(DeviationAttributeSet value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsCustomerVisible
	 * <em>Is Customer Visible</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Customer Visible</em>' attribute.
	 * @see #isIsCustomerVisible()
	 * @generated
	 */
	void setIsCustomerVisible(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsDesignVariabilityRationale
	 * <em>Is Design Variability Rationale</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Design Variability Rationale</em>' attribute.
	 * @see #isIsDesignVariabilityRationale()
	 * @generated
	 */
	void setIsDesignVariabilityRationale(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature#isIsRemoved <em>Is Removed</em>}'
	 * attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Removed</em>' attribute.
	 * @see #isIsRemoved()
	 * @generated
	 */
	void setIsRemoved(boolean value);

} // VehicleFeature
