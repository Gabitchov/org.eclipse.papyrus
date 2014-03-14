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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureModel;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl#getGoverns <em>Governs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ModelKindImpl#getViewpoint <em>Viewpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelKindImpl extends ADElementImpl implements ModelKind {
	/**
	 * The cached value of the '{@link #getGoverns() <em>Governs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoverns()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureModel> governs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelKindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.MODEL_KIND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureModel> getGoverns() {
		if (governs == null) {
			governs = new EObjectWithInverseResolvingEList<ArchitectureModel>(ArchitectureModel.class, this, Iso42010Package.MODEL_KIND__GOVERNS, Iso42010Package.ARCHITECTURE_MODEL__GOVERNED_BY);
		}
		return governs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureViewpoint getViewpoint() {
		if (eContainerFeatureID() != Iso42010Package.MODEL_KIND__VIEWPOINT) return null;
		return (ArchitectureViewpoint)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewpoint(ArchitectureViewpoint newViewpoint, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newViewpoint, Iso42010Package.MODEL_KIND__VIEWPOINT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewpoint(ArchitectureViewpoint newViewpoint) {
		if (newViewpoint != eInternalContainer() || (eContainerFeatureID() != Iso42010Package.MODEL_KIND__VIEWPOINT && newViewpoint != null)) {
			if (EcoreUtil.isAncestor(this, newViewpoint))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newViewpoint != null)
				msgs = ((InternalEObject)newViewpoint).eInverseAdd(this, Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS, ArchitectureViewpoint.class, msgs);
			msgs = basicSetViewpoint(newViewpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.MODEL_KIND__VIEWPOINT, newViewpoint, newViewpoint));
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGoverns()).basicAdd(otherEnd, msgs);
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetViewpoint((ArchitectureViewpoint)otherEnd, msgs);
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				return ((InternalEList<?>)getGoverns()).basicRemove(otherEnd, msgs);
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				return basicSetViewpoint(null, msgs);
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
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				return eInternalContainer().eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS, ArchitectureViewpoint.class, msgs);
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				return getGoverns();
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				return getViewpoint();
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				getGoverns().clear();
				getGoverns().addAll((Collection<? extends ArchitectureModel>)newValue);
				return;
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				setViewpoint((ArchitectureViewpoint)newValue);
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				getGoverns().clear();
				return;
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				setViewpoint((ArchitectureViewpoint)null);
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
			case Iso42010Package.MODEL_KIND__GOVERNS:
				return governs != null && !governs.isEmpty();
			case Iso42010Package.MODEL_KIND__VIEWPOINT:
				return getViewpoint() != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelKindImpl
