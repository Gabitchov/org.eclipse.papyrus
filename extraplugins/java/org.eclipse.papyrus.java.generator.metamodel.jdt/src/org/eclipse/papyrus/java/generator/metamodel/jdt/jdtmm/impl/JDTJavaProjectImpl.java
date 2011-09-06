/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Java Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl#getChildren <em>Children</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl#getJavaModel <em>Java Model</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl#getPackageFragmentRoots <em>Package Fragment Roots</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JDTJavaProjectImpl extends JDTParentJavaElementImpl implements JDTJavaProject {

	/**
	 * The cached value of the '{@link #getPackageFragmentRoots() <em>Package Fragment Roots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPackageFragmentRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTPackageFragmentRoot> packageFragmentRoots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JDTJavaProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_JAVA_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<JDTJavaElement> getChildren() {
		return new DerivedUnionEObjectEList<JDTJavaElement>(JDTJavaElement.class, this, JdtmmPackage.JDT_JAVA_PROJECT__CHILDREN, CHILDREN_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CHILDREN_ESUBSETS = new int[]{ JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTJavaModel getJavaModel() {
		if(eContainerFeatureID() != JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL)
			return null;
		return (JDTJavaModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetJavaModel(JDTJavaModel newJavaModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJavaModel, JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setJavaModel(JDTJavaModel newJavaModel) {
		if(newJavaModel != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL && newJavaModel != null)) {
			if(EcoreUtil.isAncestor(this, newJavaModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newJavaModel != null)
				msgs = ((InternalEObject)newJavaModel).eInverseAdd(this, JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT, JDTJavaModel.class, msgs);
			msgs = basicSetJavaModel(newJavaModel, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL, newJavaModel, newJavaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<JDTPackageFragmentRoot> getPackageFragmentRoots() {
		if(packageFragmentRoots == null) {
			packageFragmentRoots = new SubsetSupersetEObjectContainmentWithInverseEList<JDTPackageFragmentRoot>(JDTPackageFragmentRoot.class, this, JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS, PACKAGE_FRAGMENT_ROOTS_ESUPERSETS, null, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT);
		}
		return packageFragmentRoots;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getPackageFragmentRoots() <em>Package Fragment Roots</em>}' containment reference
	 * list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPackageFragmentRoots()
	 * @generated
	 * @ordered
	 */
	protected static final int[] PACKAGE_FRAGMENT_ROOTS_ESUPERSETS = new int[]{ JdtmmPackage.JDT_JAVA_PROJECT__CHILDREN };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetJavaModel((JDTJavaModel)otherEnd, msgs);
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackageFragmentRoots()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			return basicSetJavaModel(null, msgs);
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			return ((InternalEList<?>)getPackageFragmentRoots()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT, JDTJavaModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			return getJavaModel();
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			return getPackageFragmentRoots();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			setJavaModel((JDTJavaModel)newValue);
			return;
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			getPackageFragmentRoots().clear();
			getPackageFragmentRoots().addAll((Collection<? extends JDTPackageFragmentRoot>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			setJavaModel((JDTJavaModel)null);
			return;
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			getPackageFragmentRoots().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL:
			return getJavaModel() != null;
		case JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS:
			return packageFragmentRoots != null && !packageFragmentRoots.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetChildren() {
		return super.isSetChildren()
				|| eIsSet(JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS);
	}

} //JDTJavaProjectImpl
