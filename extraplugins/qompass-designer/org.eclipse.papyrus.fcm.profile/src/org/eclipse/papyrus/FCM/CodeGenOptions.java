/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Gen Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This information on a package tells the code generators which programming language and which component-to-OO mapping should be used
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.CodeGenOptions#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.CodeGenOptions#getCompToOOmapping <em>Comp To OOmapping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.CodeGenOptions#getProgLanguage <em>Prog Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getCodeGenOptions()
 * @model
 * @generated
 */
public interface CodeGenOptions extends EObject {
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
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getCodeGenOptions_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.CodeGenOptions#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Comp To OOmapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comp To OOmapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comp To OOmapping</em>' reference.
	 * @see #setCompToOOmapping(CompToOOmapping)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getCodeGenOptions_CompToOOmapping()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CompToOOmapping getCompToOOmapping();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.CodeGenOptions#getCompToOOmapping <em>Comp To OOmapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comp To OOmapping</em>' reference.
	 * @see #getCompToOOmapping()
	 * @generated
	 */
	void setCompToOOmapping(CompToOOmapping value);

	/**
	 * Returns the value of the '<em><b>Prog Language</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prog Language</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prog Language</em>' reference.
	 * @see #setProgLanguage(ProgLanguage)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getCodeGenOptions_ProgLanguage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProgLanguage getProgLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.CodeGenOptions#getProgLanguage <em>Prog Language</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prog Language</em>' reference.
	 * @see #getProgLanguage()
	 * @generated
	 */
	void setProgLanguage(ProgLanguage value);

} // CodeGenOptions
