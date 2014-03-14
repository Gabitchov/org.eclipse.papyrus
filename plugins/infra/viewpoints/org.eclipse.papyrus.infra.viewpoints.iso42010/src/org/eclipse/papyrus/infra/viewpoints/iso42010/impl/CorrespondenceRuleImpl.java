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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.Correspondence;
import org.eclipse.papyrus.infra.viewpoints.iso42010.CorrespondenceRule;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correspondence Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.CorrespondenceRuleImpl#getGoverns <em>Governs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CorrespondenceRuleImpl extends MinimalEObjectImpl.Container implements CorrespondenceRule {
	/**
	 * The cached value of the '{@link #getGoverns() <em>Governs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoverns()
	 * @generated
	 * @ordered
	 */
	protected EList<Correspondence> governs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrespondenceRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.CORRESPONDENCE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Correspondence> getGoverns() {
		if (governs == null) {
			governs = new EObjectWithInverseResolvingEList.ManyInverse<Correspondence>(Correspondence.class, this, Iso42010Package.CORRESPONDENCE_RULE__GOVERNS, Iso42010Package.CORRESPONDENCE__GOVERNED_BY);
		}
		return governs;
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGoverns()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				return ((InternalEList<?>)getGoverns()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				return getGoverns();
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				getGoverns().clear();
				getGoverns().addAll((Collection<? extends Correspondence>)newValue);
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				getGoverns().clear();
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
			case Iso42010Package.CORRESPONDENCE_RULE__GOVERNS:
				return governs != null && !governs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CorrespondenceRuleImpl
