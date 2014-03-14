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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl#getGovernedBy <em>Governed By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewImpl#getAddresses <em>Addresses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureViewImpl extends ADElementImpl implements ArchitectureView {
	/**
	 * The cached value of the '{@link #getGovernedBy() <em>Governed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGovernedBy()
	 * @generated
	 * @ordered
	 */
	protected ArchitectureViewpoint governedBy;

	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureModel> models;

	/**
	 * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddresses()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> addresses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureViewpoint getGovernedBy() {
		if (governedBy != null && governedBy.eIsProxy()) {
			InternalEObject oldGovernedBy = (InternalEObject)governedBy;
			governedBy = (ArchitectureViewpoint)eResolveProxy(oldGovernedBy);
			if (governedBy != oldGovernedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, oldGovernedBy, governedBy));
			}
		}
		return governedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureViewpoint basicGetGovernedBy() {
		return governedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGovernedBy(ArchitectureViewpoint newGovernedBy, NotificationChain msgs) {
		ArchitectureViewpoint oldGovernedBy = governedBy;
		governedBy = newGovernedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, oldGovernedBy, newGovernedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGovernedBy(ArchitectureViewpoint newGovernedBy) {
		if (newGovernedBy != governedBy) {
			NotificationChain msgs = null;
			if (governedBy != null)
				msgs = ((InternalEObject)governedBy).eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, ArchitectureViewpoint.class, msgs);
			if (newGovernedBy != null)
				msgs = ((InternalEObject)newGovernedBy).eInverseAdd(this, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, ArchitectureViewpoint.class, msgs);
			msgs = basicSetGovernedBy(newGovernedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, newGovernedBy, newGovernedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureModel> getModels() {
		if (models == null) {
			models = new EObjectContainmentWithInverseEList<ArchitectureModel>(ArchitectureModel.class, this, Iso42010Package.ARCHITECTURE_VIEW__MODELS, Iso42010Package.ARCHITECTURE_MODEL__VIEW);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getAddresses() {
		if (addresses == null) {
			addresses = new EObjectWithInverseResolvingEList.ManyInverse<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES, Iso42010Package.CONCERN__ADDRESSED_BY);
		}
		return addresses;
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				if (governedBy != null)
					msgs = ((InternalEObject)governedBy).eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, ArchitectureViewpoint.class, msgs);
				return basicSetGovernedBy((ArchitectureViewpoint)otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModels()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAddresses()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				return basicSetGovernedBy(null, msgs);
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				return ((InternalEList<?>)getAddresses()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				if (resolve) return getGovernedBy();
				return basicGetGovernedBy();
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				return getModels();
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				return getAddresses();
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				setGovernedBy((ArchitectureViewpoint)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends ArchitectureModel>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				getAddresses().clear();
				getAddresses().addAll((Collection<? extends Concern>)newValue);
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				setGovernedBy((ArchitectureViewpoint)null);
				return;
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				getModels().clear();
				return;
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				getAddresses().clear();
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
			case Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY:
				return governedBy != null;
			case Iso42010Package.ARCHITECTURE_VIEW__MODELS:
				return models != null && !models.isEmpty();
			case Iso42010Package.ARCHITECTURE_VIEW__ADDRESSES:
				return addresses != null && !addresses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureViewImpl
