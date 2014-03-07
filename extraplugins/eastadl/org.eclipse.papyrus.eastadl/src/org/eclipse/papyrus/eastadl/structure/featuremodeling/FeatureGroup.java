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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * FeatureGroup is a specialization of the FeatureTreeNode, enabling grouping of several Features. It specifies with its cardinality how these grouped
 * features can be combined. For example, a FeatureGroup owning the two Features A and B, with a cardinality of [1] means that A and B are
 * alternative.
 * 
 * 
 * Semantics:
 * FeatureGroup is a grouping entity for sibling Features to reflect variability for a set of Features.
 * 
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getCardinality <em>Cardinality</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getChildFeature <em>Child Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureGroup()
 * @model
 * @generated
 */
public interface FeatureGroup extends FeatureTreeNode {

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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureGroup_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getBase_Class <em>Base Class</em>}' reference.
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
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The Cardinality describes for a feature group
	 * its cardinality. It describes the variability behavior of the group (e.g. a cardinality of 1
	 * in a feature group means that one of the child features has to be selected). <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(String)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureGroup_Cardinality()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getCardinality();

	/**
	 * Returns the value of the '<em><b>Child Feature</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Feature</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Child Feature</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureGroup_ChildFeature()
	 * @model lower="2" ordered="false"
	 * @generated
	 */
	EList<Feature> getChildFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup#getCardinality <em>Cardinality</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(String value);

} // FeatureGroup
