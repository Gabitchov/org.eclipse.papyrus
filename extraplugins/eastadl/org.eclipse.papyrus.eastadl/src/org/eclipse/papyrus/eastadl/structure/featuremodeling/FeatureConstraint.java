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


import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.Constraint;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature Constraint</b></em> '. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Captures a constraint on the containing feature model's configuration which is too complex to be expressed by way of a FeatureLink. In general, all
 * constraints that can be expressed by a FeatureLink can also be expressed by a FeatureConstraint, but not vice versa.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getCriterion <em>Criterion</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Constraint <em>Base Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureConstraint()
 * @model
 * @generated
 */
public interface FeatureConstraint extends EAElement {

	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The actual constraint. This is a logic expression
	 * in VSL like the inclusionCriterion of a ConfigDecision. For the constraint to be met this
	 * expression always has to evaluate to true. For example, to express a mutual exclusion of two
	 * features use the expression " ! (Radar & RainSensor) ". <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Criterion</em>' attribute.
	 * @see #setCriterion(String)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureConstraint_Criterion()
	 * @model unique="false" dataType="org.eclipse.uml2.uml.String" required="true" ordered="false"
	 * @generated
	 */
	String getCriterion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getCriterion <em>Criterion</em>}'
	 * attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Criterion</em>' attribute.
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(String value);

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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureConstraint_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Class <em>Base Class</em>}'
	 * reference.
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
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureConstraint_Base_Constraint()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint#getBase_Constraint
	 * <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

} // FeatureConstraint
