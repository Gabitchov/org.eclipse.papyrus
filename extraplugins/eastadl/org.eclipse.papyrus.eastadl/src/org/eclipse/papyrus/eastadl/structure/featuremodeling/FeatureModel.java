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
package org.eclipse.papyrus.eastadl.structure.featuremodeling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * FeatureModel denotes a model owning Features. The FeatureModel can be used to describe variability and commonality of a specified EE-System at any
 * abstraction level in the SystemModel.
 * 
 * The FeatureModel can be used either to describe the variability within a particular Function or to describe the overall variability of a vehicle
 * (cf. VehicleLevel). The FeatureModel describing internal variability of a FunctionType refers to the VehicleLevel by a «realizes» link
 * (informative).
 * 
 * Note, however, that a FeatureModel per definition does not always have to define variability. If a feature model contains only mandatory features,
 * then its purpose is completely unrelated to variability. The features in such a FeatureModel could serve, for example, as invariant
 * "coarse-grained requirements". The most important example is the core technical feature model on vehicle level which is also used for SystemModels
 * that do not contain any variability at all. However, most uses of feature models in EAST-ADL2 are primarily motivated by variability definition and
 * management.
 * 
 * A public, local FeatureModel of an artifact element realizes a VehicleFeature of the VehicleLevel.
 * 
 * 
 * Semantics:
 * The FeatureModel has no specific semantics. Further subclasses of FeatureModel will add semantics appropriate to the concept they represent.
 * 
 * 
 * Extension:
 * Package
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getRootFeature <em>Root Feature</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureLink <em>Feature Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getFeatureConstraint <em>Feature Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends Context {

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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Package <em>Base Package</em>}'
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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Feature Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Constraint</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel_FeatureConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureConstraint> getFeatureConstraint();

	/**
	 * Returns the value of the '<em><b>Feature Link</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Link</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Link</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel_FeatureLink()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureLink> getFeatureLink();

	/**
	 * Returns the value of the '<em><b>Root Feature</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Feature</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Root Feature</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureModel_RootFeature()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Feature> getRootFeature();

} // FeatureModel
