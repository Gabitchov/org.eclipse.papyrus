/**
 * *******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 
 *     Fabien Giquel (Mia-Software) - initial API and implementation
 * *******************************************************************************
 *
 */
package org.eclipse.papyrus.customization.properties.model.xwt.xwtxml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getDtd <em>Dtd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getLeadingPIs <em>Leading PIs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends Element {
	/**
	 * Returns the value of the '<em><b>Namespaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespaces</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage#getRoot_Namespaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Namespace> getNamespaces();

	/**
	 * Returns the value of the '<em><b>Dtd</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dtd</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dtd</em>' containment reference.
	 * @see #setDtd(DocumentTypeDeclaration)
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage#getRoot_Dtd()
	 * @model containment="true"
	 * @generated
	 */
	DocumentTypeDeclaration getDtd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getDtd <em>Dtd</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dtd</em>' containment reference.
	 * @see #getDtd()
	 * @generated
	 */
	void setDtd(DocumentTypeDeclaration value);

	/**
	 * Returns the value of the '<em><b>Leading PIs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leading PIs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leading PIs</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage#getRoot_LeadingPIs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProcessingInstruction> getLeadingPIs();

} // Root
