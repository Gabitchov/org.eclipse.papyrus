/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.newchild.MenuItem;

import org.eclipse.papyrus.newchild.ncpolicy.NcpolicyPackage;
import org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replace Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.impl.ReplacePolicyImpl#getReplaceWith <em>Replace With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplacePolicyImpl extends NewChildPolicyImpl implements ReplacePolicy {
	/**
	 * The cached value of the '{@link #getReplaceWith() <em>Replace With</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplaceWith()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuItem> replaceWith;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplacePolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NcpolicyPackage.Literals.REPLACE_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuItem> getReplaceWith() {
		if (replaceWith == null) {
			replaceWith = new EObjectContainmentEList<MenuItem>(MenuItem.class, this, NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH);
		}
		return replaceWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH:
				return ((InternalEList<?>)getReplaceWith()).basicRemove(otherEnd, msgs);
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
			case NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH:
				return getReplaceWith();
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
			case NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH:
				getReplaceWith().clear();
				getReplaceWith().addAll((Collection<? extends MenuItem>)newValue);
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
			case NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH:
				getReplaceWith().clear();
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
			case NcpolicyPackage.REPLACE_POLICY__REPLACE_WITH:
				return replaceWith != null && !replaceWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReplacePolicyImpl
