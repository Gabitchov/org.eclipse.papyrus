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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_StructuredClassifier <em>Base Structured Classifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Structured Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Structured Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Structured Classifier</em>' reference.
	 * @see #setBase_StructuredClassifier(StructuredClassifier)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage#getConfiguration_Base_StructuredClassifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StructuredClassifier getBase_StructuredClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_StructuredClassifier <em>Base Structured Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Structured Classifier</em>' reference.
	 * @see #getBase_StructuredClassifier()
	 * @generated
	 */
	void setBase_StructuredClassifier(StructuredClassifier value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage#getConfiguration_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage#getConfiguration_Mode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getMode();

} // Configuration
