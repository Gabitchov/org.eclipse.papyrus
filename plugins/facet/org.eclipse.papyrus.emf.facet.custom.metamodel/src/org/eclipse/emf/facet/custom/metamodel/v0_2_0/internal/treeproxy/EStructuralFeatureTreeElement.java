/**
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *    Gregoire Dupe (Mia-Software) - Bug 386387 - [CustomizedTreeContentProvider] The TreeElements are not preserved between two calls to getElements() 
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EStructural Feature Tree Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getReferedEObjectTE <em>Refered EObject TE</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEStructuralFeatureTreeElement()
 * @model
 * @generated
 */
public interface EStructuralFeatureTreeElement extends TreeElement {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getSfTreeElmement <em>Sf Tree Elmement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(EObjectTreeElement)
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEStructuralFeatureTreeElement_Parent()
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getSfTreeElmement
	 * @model opposite="sfTreeElmement" transient="false"
	 * @generated
	 */
	EObjectTreeElement getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(EObjectTreeElement value);

	/**
	 * Returns the value of the '<em><b>Refered EObject TE</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refered EObject TE</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refered EObject TE</em>' containment reference list.
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEStructuralFeatureTreeElement_ReferedEObjectTE()
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<EObjectTreeElement> getReferedEObjectTE();
} // EStructuralFeatureTreeElement
