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
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Package Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl#getPackageFragmentRoot <em>Package Fragment Root</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl#getCompilationUnits <em>Compilation Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDTPackageFragmentImpl extends JDTParentJavaElementImpl implements JDTPackageFragment {

	/**
	 * The cached value of the '{@link #getCompilationUnits() <em>Compilation Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompilationUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTCompilationUnit> compilationUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTPackageFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_PACKAGE_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JDTJavaElement> getChildren() {
		return new DerivedUnionEObjectEList<JDTJavaElement>(JDTJavaElement.class, this, JdtmmPackage.JDT_PACKAGE_FRAGMENT__CHILDREN, CHILDREN_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CHILDREN_ESUBSETS = new int[] {JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTPackageFragmentRoot getPackageFragmentRoot() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT) return null;
		return (JDTPackageFragmentRoot)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackageFragmentRoot(JDTPackageFragmentRoot newPackageFragmentRoot, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackageFragmentRoot, JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageFragmentRoot(JDTPackageFragmentRoot newPackageFragmentRoot) {
		if (newPackageFragmentRoot != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT && newPackageFragmentRoot != null)) {
			if (EcoreUtil.isAncestor(this, newPackageFragmentRoot))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackageFragmentRoot != null)
				msgs = ((InternalEObject)newPackageFragmentRoot).eInverseAdd(this, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS, JDTPackageFragmentRoot.class, msgs);
			msgs = basicSetPackageFragmentRoot(newPackageFragmentRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT, newPackageFragmentRoot, newPackageFragmentRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPackageFragmentRoot() {
		return getPackageFragmentRoot() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTCompilationUnit> getCompilationUnits() {
		if (compilationUnits == null) {
			compilationUnits = new SubsetSupersetEObjectContainmentWithInverseEList<JDTCompilationUnit>(JDTCompilationUnit.class, this, JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS, COMPILATION_UNITS_ESUPERSETS, null, JdtmmPackage.JDT_COMPILATION_UNIT__PACKAGE_FRAGMENT);
		}
		return compilationUnits;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getCompilationUnits() <em>Compilation Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompilationUnits()
	 * @generated
	 * @ordered
	 */
	protected static final int[] COMPILATION_UNITS_ESUPERSETS = new int[] {JdtmmPackage.JDT_PACKAGE_FRAGMENT__CHILDREN};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackageFragmentRoot((JDTPackageFragmentRoot)otherEnd, msgs);
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompilationUnits()).basicAdd(otherEnd, msgs);
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				return basicSetPackageFragmentRoot(null, msgs);
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				return ((InternalEList<?>)getCompilationUnits()).basicRemove(otherEnd, msgs);
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS, JDTPackageFragmentRoot.class, msgs);
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				return getPackageFragmentRoot();
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				return getCompilationUnits();
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				setPackageFragmentRoot((JDTPackageFragmentRoot)newValue);
				return;
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				getCompilationUnits().clear();
				getCompilationUnits().addAll((Collection<? extends JDTCompilationUnit>)newValue);
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				setPackageFragmentRoot((JDTPackageFragmentRoot)null);
				return;
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				getCompilationUnits().clear();
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
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT:
				return isSetPackageFragmentRoot();
			case JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS:
				return compilationUnits != null && !compilationUnits.isEmpty();
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
			|| eIsSet(JdtmmPackage.JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent getParent() {
		return getPackageFragmentRoot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent basicGetParent() {
		return getPackageFragmentRoot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParent() {
  		return false;
	}

} //JDTPackageFragmentImpl
