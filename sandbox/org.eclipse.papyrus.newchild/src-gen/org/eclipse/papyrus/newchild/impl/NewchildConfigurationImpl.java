/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewchildConfiguration;
import org.eclipse.papyrus.newchild.NewchildPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.impl.NewchildConfigurationImpl#getRoots <em>Roots</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewchildConfigurationImpl extends EObjectImpl implements NewchildConfiguration {
	/**
	 * The cached value of the '{@link #getRoots() <em>Roots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuRoot> roots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewchildConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewchildPackage.Literals.NEWCHILD_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuRoot> getRoots() {
		if (roots == null) {
			roots = new EObjectContainmentEList<MenuRoot>(MenuRoot.class, this, NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS);
		}
		return roots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
				return ((InternalEList<?>)getRoots()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
				return getRoots();
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
			case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
				getRoots().clear();
				getRoots().addAll((Collection<? extends MenuRoot>)newValue);
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
			case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
				getRoots().clear();
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
			case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
				return roots != null && !roots.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NewchildConfigurationImpl
