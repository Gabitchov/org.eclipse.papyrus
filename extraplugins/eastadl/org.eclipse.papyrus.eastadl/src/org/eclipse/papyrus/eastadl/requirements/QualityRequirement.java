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
package org.eclipse.papyrus.eastadl.requirements;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Quality Requirement</b></em> '. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * QualityRequirements are the kind of requirements that are used to introduce externally visible properties of the system considered as a whole.
 * The attribute qualityRequirementType allows a more specific classification.
 * 
 * 
 * 
 * Extension:
 * Class, specializes Requirement
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirement#getQualityRequirementType <em>Quality Requirement Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getQualityRequirement()
 * @model
 * @generated
 */
public interface QualityRequirement extends Requirement {

	/**
	 * Returns the value of the '<em><b>Quality Requirement Type</b></em>' attribute. The default
	 * value is <code>""</code>. The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Requirement Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Quality Requirement Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind
	 * @see #setQualityRequirementType(QualityRequirementKind)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getQualityRequirement_QualityRequirementType()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	QualityRequirementKind getQualityRequirementType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.QualityRequirement#getQualityRequirementType
	 * <em>Quality Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Quality Requirement Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind
	 * @see #getQualityRequirementType()
	 * @generated
	 */
	void setQualityRequirementType(QualityRequirementKind value);

} // QualityRequirement
