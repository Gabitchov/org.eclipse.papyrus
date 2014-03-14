/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ADElement;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence;
import org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl#getGovernedBy <em>Governed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceImpl#getRelates <em>Relates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CorrespondenceImpl extends MinimalEObjectImpl.Container implements Correspondence {
	/**
	 * The cached value of the '{@link #getGovernedBy() <em>Governed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrespondenceRule> governedBy;

	/**
	 * The cached value of the '{@link #getRelates() <em>Relates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelates()
	 * @generated
	 * @ordered
	 */
	protected EList<ADElement> relates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrespondenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.CORRESPONDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrespondenceRule> getGovernedBy() {
		if (governedBy == null) {
			governedBy = new EObjectWithInverseResolvingEList.ManyInverse<CorrespondenceRule>(CorrespondenceRule.class, this, Iso42010Package.CORRESPONDENCE__GOVERNED_BY, Iso42010Package.CORRESPONDENCE_RULE__GOVERNS);
		}
		return governedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ADElement> getRelates() {
		if (relates == null) {
			relates = new EObjectResolvingEList<ADElement>(ADElement.class, this, Iso42010Package.CORRESPONDENCE__RELATES);
		}
		return relates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGovernedBy()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				return ((InternalEList<?>)getGovernedBy()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				return getGovernedBy();
			case Iso42010Package.CORRESPONDENCE__RELATES:
				return getRelates();
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
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				getGovernedBy().clear();
				getGovernedBy().addAll((Collection<? extends CorrespondenceRule>)newValue);
				return;
			case Iso42010Package.CORRESPONDENCE__RELATES:
				getRelates().clear();
				getRelates().addAll((Collection<? extends ADElement>)newValue);
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
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				getGovernedBy().clear();
				return;
			case Iso42010Package.CORRESPONDENCE__RELATES:
				getRelates().clear();
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
			case Iso42010Package.CORRESPONDENCE__GOVERNED_BY:
				return governedBy != null && !governedBy.isEmpty();
			case Iso42010Package.CORRESPONDENCE__RELATES:
				return relates != null && !relates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CorrespondenceImpl
