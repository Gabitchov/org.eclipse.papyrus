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
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeproxyFactoryImpl extends EFactoryImpl implements TreeproxyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreeproxyFactory init() {
		try {
			TreeproxyFactory theTreeproxyFactory = (TreeproxyFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/facet/custom/0.2.incubation/internal/treeproxy"); 
			if (theTreeproxyFactory != null) {
				return theTreeproxyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TreeproxyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeproxyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT: return createEObjectTreeElement();
			case TreeproxyPackage.EREFERENCE_TREE_ELEMENT: return createEReferenceTreeElement();
			case TreeproxyPackage.EATTRIBUTE_TREE_ELEMENT: return createEAttributeTreeElement();
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT: return createEStructuralFeatureTreeElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectTreeElement createEObjectTreeElement() {
		EObjectTreeElementImpl eObjectTreeElement = new EObjectTreeElementImpl();
		return eObjectTreeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReferenceTreeElement createEReferenceTreeElement() {
		EReferenceTreeElementImpl eReferenceTreeElement = new EReferenceTreeElementImpl();
		return eReferenceTreeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttributeTreeElement createEAttributeTreeElement() {
		EAttributeTreeElementImpl eAttributeTreeElement = new EAttributeTreeElementImpl();
		return eAttributeTreeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeatureTreeElement createEStructuralFeatureTreeElement() {
		EStructuralFeatureTreeElementImpl eStructuralFeatureTreeElement = new EStructuralFeatureTreeElementImpl();
		return eStructuralFeatureTreeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeproxyPackage getTreeproxyPackage() {
		return (TreeproxyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TreeproxyPackage getPackage() {
		return TreeproxyPackage.eINSTANCE;
	}

} //TreeproxyFactoryImpl
