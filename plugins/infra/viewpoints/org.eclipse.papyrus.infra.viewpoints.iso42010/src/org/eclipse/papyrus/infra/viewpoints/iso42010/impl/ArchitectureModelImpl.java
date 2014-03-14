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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl#getGovernedBy <em>Governed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureModelImpl#getView <em>View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureModelImpl extends ADElementImpl implements ArchitectureModel {
	/**
	 * The cached value of the '{@link #getGovernedBy() <em>Governed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernedBy()
	 * @generated
	 * @ordered
	 */
	protected ModelKind governedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelKind getGovernedBy() {
		if (governedBy != null && governedBy.eIsProxy()) {
			InternalEObject oldGovernedBy = (InternalEObject)governedBy;
			governedBy = (ModelKind)eResolveProxy(oldGovernedBy);
			if (governedBy != oldGovernedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY, oldGovernedBy, governedBy));
			}
		}
		return governedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelKind basicGetGovernedBy() {
		return governedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGovernedBy(ModelKind newGovernedBy, NotificationChain msgs) {
		ModelKind oldGovernedBy = governedBy;
		governedBy = newGovernedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY, oldGovernedBy, newGovernedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGovernedBy(ModelKind newGovernedBy) {
		if (newGovernedBy != governedBy) {
			NotificationChain msgs = null;
			if (governedBy != null)
				msgs = ((InternalEObject)governedBy).eInverseRemove(this, Iso42010Package.MODEL_KIND__GOVERNS, ModelKind.class, msgs);
			if (newGovernedBy != null)
				msgs = ((InternalEObject)newGovernedBy).eInverseAdd(this, Iso42010Package.MODEL_KIND__GOVERNS, ModelKind.class, msgs);
			msgs = basicSetGovernedBy(newGovernedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY, newGovernedBy, newGovernedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureView getView() {
		if (eContainerFeatureID() != Iso42010Package.ARCHITECTURE_MODEL__VIEW) return null;
		return (ArchitectureView)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetView(ArchitectureView newView, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newView, Iso42010Package.ARCHITECTURE_MODEL__VIEW, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(ArchitectureView newView) {
		if (newView != eInternalContainer() || (eContainerFeatureID() != Iso42010Package.ARCHITECTURE_MODEL__VIEW && newView != null)) {
			if (EcoreUtil.isAncestor(this, newView))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, Iso42010Package.ARCHITECTURE_VIEW__MODELS, ArchitectureView.class, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_MODEL__VIEW, newView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				if (governedBy != null)
					msgs = ((InternalEObject)governedBy).eInverseRemove(this, Iso42010Package.MODEL_KIND__GOVERNS, ModelKind.class, msgs);
				return basicSetGovernedBy((ModelKind)otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetView((ArchitectureView)otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				return basicSetGovernedBy(null, msgs);
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				return basicSetView(null, msgs);
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
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				return eInternalContainer().eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEW__MODELS, ArchitectureView.class, msgs);
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
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				if (resolve) return getGovernedBy();
				return basicGetGovernedBy();
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				return getView();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				setGovernedBy((ModelKind)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				setView((ArchitectureView)newValue);
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
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				setGovernedBy((ModelKind)null);
				return;
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				setView((ArchitectureView)null);
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
			case Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY:
				return governedBy != null;
			case Iso42010Package.ARCHITECTURE_MODEL__VIEW:
				return getView() != null;
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureModelImpl
