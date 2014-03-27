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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.StakeholderImpl#getHasInterestIn <em>Has Interest In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderImpl extends ADElementImpl implements Stakeholder {
	/**
	 * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> concerns;

	/**
	 * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> viewpoints;

	/**
	 * The cached value of the '{@link #getHasInterestIn() <em>Has Interest In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasInterestIn()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.papyrus.infra.viewpoints.iso42010.System hasInterestIn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.STAKEHOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getConcerns() {
		if (concerns == null) {
			concerns = new EObjectWithInverseResolvingEList.ManyInverse<Concern>(Concern.class, this, Iso42010Package.STAKEHOLDER__CONCERNS, Iso42010Package.CONCERN__STAKEHOLDERS);
		}
		return concerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getViewpoints() {
		if (viewpoints == null) {
			viewpoints = new EObjectResolvingEList<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, Iso42010Package.STAKEHOLDER__VIEWPOINTS);
		}
		return viewpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System getHasInterestIn() {
		if (hasInterestIn != null && hasInterestIn.eIsProxy()) {
			InternalEObject oldHasInterestIn = (InternalEObject)hasInterestIn;
			hasInterestIn = (org.eclipse.papyrus.infra.viewpoints.iso42010.System)eResolveProxy(oldHasInterestIn);
			if (hasInterestIn != oldHasInterestIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN, oldHasInterestIn, hasInterestIn));
			}
		}
		return hasInterestIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.infra.viewpoints.iso42010.System basicGetHasInterestIn() {
		return hasInterestIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasInterestIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System newHasInterestIn, NotificationChain msgs) {
		org.eclipse.papyrus.infra.viewpoints.iso42010.System oldHasInterestIn = hasInterestIn;
		hasInterestIn = newHasInterestIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN, oldHasInterestIn, newHasInterestIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasInterestIn(org.eclipse.papyrus.infra.viewpoints.iso42010.System newHasInterestIn) {
		if (newHasInterestIn != hasInterestIn) {
			NotificationChain msgs = null;
			if (hasInterestIn != null)
				msgs = ((InternalEObject)hasInterestIn).eInverseRemove(this, Iso42010Package.SYSTEM__STAKEHOLDERS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
			if (newHasInterestIn != null)
				msgs = ((InternalEObject)newHasInterestIn).eInverseAdd(this, Iso42010Package.SYSTEM__STAKEHOLDERS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
			msgs = basicSetHasInterestIn(newHasInterestIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN, newHasInterestIn, newHasInterestIn));
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConcerns()).basicAdd(otherEnd, msgs);
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				if (hasInterestIn != null)
					msgs = ((InternalEObject)hasInterestIn).eInverseRemove(this, Iso42010Package.SYSTEM__STAKEHOLDERS, org.eclipse.papyrus.infra.viewpoints.iso42010.System.class, msgs);
				return basicSetHasInterestIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)otherEnd, msgs);
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				return ((InternalEList<?>)getConcerns()).basicRemove(otherEnd, msgs);
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				return basicSetHasInterestIn(null, msgs);
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				return getConcerns();
			case Iso42010Package.STAKEHOLDER__VIEWPOINTS:
				return getViewpoints();
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				if (resolve) return getHasInterestIn();
				return basicGetHasInterestIn();
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				getConcerns().clear();
				getConcerns().addAll((Collection<? extends Concern>)newValue);
				return;
			case Iso42010Package.STAKEHOLDER__VIEWPOINTS:
				getViewpoints().clear();
				getViewpoints().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				setHasInterestIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)newValue);
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				getConcerns().clear();
				return;
			case Iso42010Package.STAKEHOLDER__VIEWPOINTS:
				getViewpoints().clear();
				return;
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				setHasInterestIn((org.eclipse.papyrus.infra.viewpoints.iso42010.System)null);
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
			case Iso42010Package.STAKEHOLDER__CONCERNS:
				return concerns != null && !concerns.isEmpty();
			case Iso42010Package.STAKEHOLDER__VIEWPOINTS:
				return viewpoints != null && !viewpoints.isEmpty();
			case Iso42010Package.STAKEHOLDER__HAS_INTEREST_IN:
				return hasInterestIn != null;
		}
		return super.eIsSet(featureID);
	}

} //StakeholderImpl
