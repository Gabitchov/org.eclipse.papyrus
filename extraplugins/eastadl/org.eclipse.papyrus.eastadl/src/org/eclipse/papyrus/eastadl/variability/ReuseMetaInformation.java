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

import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Reuse Meta Information</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * ReuseMetaInformation represents the description information needed in the context of reuse. For example a specific entity is only a short-time
 * solution that is not intended to be reused. Also a specific entity can only be reused for specific model ranges (that are not reflected in the
 * product model). This kind of information can be stored in this information.
 * 
 * Semantics:
 * The ReuseMetaInformation represents information that explains if and how the respective entity can be reused.
 * 
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getInformation <em>Information</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#isIsReusable <em>Is Reusable</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getReuseMetaInformation()
 * @model
 * @generated
 */
public interface ReuseMetaInformation extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Information</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The reuse information is stored in this
	 * attribute. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Information</em>' attribute.
	 * @see #setInformation(String)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getReuseMetaInformation_Information()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getInformation();

	/**
	 * Returns the value of the '<em><b>Is Reusable</b></em>' attribute. The default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Reusable</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> This Boolean attributes just says if the
	 * entity itself can essentially be reused or not. Specific information or constraints on reuse
	 * are in the information attribute. Default value is TRUE. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Is Reusable</em>' attribute.
	 * @see #setIsReusable(boolean)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getReuseMetaInformation_IsReusable()
	 * @model default="true" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsReusable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getInformation <em>Information</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Information</em>' attribute.
	 * @see #getInformation()
	 * @generated
	 */
	void setInformation(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#isIsReusable <em>Is Reusable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Reusable</em>' attribute.
	 * @see #isIsReusable()
	 * @generated
	 */
	void setIsReusable(boolean value);

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
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getReuseMetaInformation_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // ReuseMetaInformation
