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
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Tree Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a model element in a tree view
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getEObject <em>EObject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getSfTreeElmement <em>Sf Tree Elmement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEObjectTreeElement()
 * @model
 * @generated
 */
public interface EObjectTreeElement extends TreeElement {
	/**
	 * Returns the value of the '<em><b>EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The model element represented by this tree element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EObject</em>' reference.
	 * @see #setEObject(EObject)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEObjectTreeElement_EObject()
	 * @model
	 * @generated
	 */
	EObject getEObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getEObject <em>EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EObject</em>' reference.
	 * @see #getEObject()
	 * @generated
	 */
	void setEObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Sf Tree Elmement</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sf Tree Elmement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sf Tree Elmement</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEObjectTreeElement_SfTreeElmement()
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<EStructuralFeatureTreeElement> getSfTreeElmement();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getReferedEObjectTE <em>Refered EObject TE</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(EStructuralFeatureTreeElement)
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage#getEObjectTreeElement_Parent()
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement#getReferedEObjectTE
	 * @model opposite="referedEObjectTE" transient="false"
	 * @generated
	 */
	EStructuralFeatureTreeElement getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(EStructuralFeatureTreeElement value);

} // EObjectTreeElement
