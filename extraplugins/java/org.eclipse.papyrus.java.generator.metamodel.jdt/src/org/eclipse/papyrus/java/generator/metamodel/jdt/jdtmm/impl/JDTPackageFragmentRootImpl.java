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
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Package Fragment Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl#getJavaProject <em>Java Project</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl#getPackageFragments <em>Package Fragments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDTPackageFragmentRootImpl extends JDTParentJavaElementImpl implements JDTPackageFragmentRoot {

	/**
	 * The cached value of the '{@link #getPackageFragments() <em>Package Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTPackageFragment> packageFragments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTPackageFragmentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_PACKAGE_FRAGMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JDTJavaElement> getChildren() {
		return new DerivedUnionEObjectEList<JDTJavaElement>(JDTJavaElement.class, this, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__CHILDREN, CHILDREN_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CHILDREN_ESUBSETS = new int[] {JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTJavaProject getJavaProject() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT) return null;
		return (JDTJavaProject)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJavaProject(JDTJavaProject newJavaProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJavaProject, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaProject(JDTJavaProject newJavaProject) {
		if (newJavaProject != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT && newJavaProject != null)) {
			if (EcoreUtil.isAncestor(this, newJavaProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJavaProject != null)
				msgs = ((InternalEObject)newJavaProject).eInverseAdd(this, JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS, JDTJavaProject.class, msgs);
			msgs = basicSetJavaProject(newJavaProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT, newJavaProject, newJavaProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJavaProject() {
		return getJavaProject() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTPackageFragment> getPackageFragments() {
		if (packageFragments == null) {
			packageFragments = new SubsetSupersetEObjectContainmentWithInverseEList<JDTPackageFragment>(JDTPackageFragment.class, this, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS, PACKAGE_FRAGMENTS_ESUPERSETS, null, JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT);
		}
		return packageFragments;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getPackageFragments() <em>Package Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageFragments()
	 * @generated
	 * @ordered
	 */
	protected static final int[] PACKAGE_FRAGMENTS_ESUPERSETS = new int[] {JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__CHILDREN};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetJavaProject((JDTJavaProject)otherEnd, msgs);
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackageFragments()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				return basicSetJavaProject(null, msgs);
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				return ((InternalEList<?>)getPackageFragments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS, JDTJavaProject.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				return getJavaProject();
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				return getPackageFragments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				setJavaProject((JDTJavaProject)newValue);
				return;
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				getPackageFragments().clear();
				getPackageFragments().addAll((Collection<? extends JDTPackageFragment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				setJavaProject((JDTJavaProject)null);
				return;
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				getPackageFragments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT:
				return isSetJavaProject();
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS:
				return packageFragments != null && !packageFragments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetChildren() {
		return super.isSetChildren()
			|| eIsSet(JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent getParent() {
		return getJavaProject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent basicGetParent() {
		return getJavaProject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParent() {
  		return false;
	}

} //JDTPackageFragmentRootImpl
