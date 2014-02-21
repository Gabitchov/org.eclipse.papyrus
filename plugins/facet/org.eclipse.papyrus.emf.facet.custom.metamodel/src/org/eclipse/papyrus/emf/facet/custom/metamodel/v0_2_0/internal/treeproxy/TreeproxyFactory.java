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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage
 * @generated
 */
public interface TreeproxyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TreeproxyFactory eINSTANCE = org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.TreeproxyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EObject Tree Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Tree Element</em>'.
	 * @generated
	 */
	EObjectTreeElement createEObjectTreeElement();

	/**
	 * Returns a new object of class '<em>EReference Tree Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Tree Element</em>'.
	 * @generated
	 */
	EReferenceTreeElement createEReferenceTreeElement();

	/**
	 * Returns a new object of class '<em>EAttribute Tree Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAttribute Tree Element</em>'.
	 * @generated
	 */
	EAttributeTreeElement createEAttributeTreeElement();

	/**
	 * Returns a new object of class '<em>EStructural Feature Tree Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EStructural Feature Tree Element</em>'.
	 * @generated
	 */
	EStructuralFeatureTreeElement createEStructuralFeatureTreeElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TreeproxyPackage getTreeproxyPackage();

} //TreeproxyFactory
