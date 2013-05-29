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
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Feature represents a characteristic or trait of some object of consideration. The actual object of consideration depends on the particular purpose of the feature's containing feature model.
 * 
 * Example 1: The core technical feature model on vehicle level defines the technical properties of the complete-system, i.e. vehicle. So its object of consideration is the vehicle as a whole and therefore its features represent characteristics or traits of the vehicle as a whole.
 * 
 * Example 2: The public feature model of some function F in the FDA defines the features of this particular software function. So its object of consideration is function F and therefore its features represent characteristics or traits of this function F.
 * 
 * 
 * Semantics:
 * Feature is a (non)functional characteristic, constraint or property that can be present or not in a (vehicle) product line.
 * 
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getRequiredBindingTime <em>Required Binding Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getActualBindingTime <em>Actual Binding Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getFeatureParameter <em>Feature Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getChildNode <em>Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends FeatureTreeNode {

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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Actual Binding Time</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Actual Binding Time</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The actual binding time, independent of the
	 * required binding time. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Actual Binding Time</em>' reference.
	 * @see #setActualBindingTime(BindingTimeAttribute)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_ActualBindingTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BindingTime getActualBindingTime();

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The Cardinality describes for a feature its
	 * cardinality. In the context of a feature group it describes the variability behavior of the
	 * group (e.g. a cardinality of 1 in a feature group means that one of the child features has to
	 * be selected). Cardinalities for features: A cardinality of 0..1 at a feature means that this
	 * feature is optional. A cardinality of 1 means that this feature is mandatory and a
	 * cardinality of 0..n with n>1 means that this feature may be instantiated more than once in
	 * the product to be realized. Note that allowing cardinalities >1 has far-reaching consequences
	 * for how features are applied. If this is not desired-needed in a certain project,
	 * cardinalities >1 can be prohibited by specifying a complianceLevel in FeatureModel. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(String)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_Cardinality()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getCardinality();

	/**
	 * Returns the value of the '<em><b>Child Node</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureTreeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Node</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_ChildNode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureTreeNode> getChildNode();

	/**
	 * Returns the value of the '<em><b>Feature Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Parameter</em>' reference.
	 * @see #setFeatureParameter(EADatatypePrototype)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_FeatureParameter()
	 * @model ordered="false"
	 * @generated
	 */
	EADatatypePrototype getFeatureParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getFeatureParameter <em>Feature Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Parameter</em>' reference.
	 * @see #getFeatureParameter()
	 * @generated
	 */
	void setFeatureParameter(EADatatypePrototype value);

	/**
	 * Returns the value of the '<em><b>Required Binding Time</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The required binding time
	 * could possibly deviate from the actual binding time but reflects the intended binding time
	 * and actual binding time can be later adapted to the required binding time, if surrounding
	 * constraints allow a change. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Required Binding Time</em>' reference.
	 * @see #setRequiredBindingTime(BindingTimeAttribute)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeature_RequiredBindingTime()
	 * @model ordered="false"
	 * @generated
	 */
	BindingTime getRequiredBindingTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getActualBindingTime <em>Actual Binding Time</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Binding Time</em>' reference.
	 * @see #getActualBindingTime()
	 * @generated
	 */
	void setActualBindingTime(BindingTime value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getRequiredBindingTime <em>Required Binding Time</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Binding Time</em>' reference.
	 * @see #getRequiredBindingTime()
	 * @generated
	 */
	void setRequiredBindingTime(BindingTime value);

} // Feature
