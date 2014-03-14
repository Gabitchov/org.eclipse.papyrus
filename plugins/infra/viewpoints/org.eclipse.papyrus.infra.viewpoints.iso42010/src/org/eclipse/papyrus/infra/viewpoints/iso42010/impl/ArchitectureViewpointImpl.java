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

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureView;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Concern;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl#getModelKinds <em>Model Kinds</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl#getGoverns <em>Governs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.iso42010.impl.ArchitectureViewpointImpl#getFrames <em>Frames</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureViewpointImpl extends ADElementImpl implements ArchitectureViewpoint {
	/**
	 * The cached value of the '{@link #getModelKinds() <em>Model Kinds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelKinds()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelKind> modelKinds;

	/**
	 * The cached value of the '{@link #getGoverns() <em>Governs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoverns()
	 * @generated
	 * @ordered
	 */
	protected ArchitectureView governs;

	/**
	 * The cached value of the '{@link #getFrames() <em>Frames</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<Concern> frames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureViewpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Iso42010Package.Literals.ARCHITECTURE_VIEWPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelKind> getModelKinds() {
		if (modelKinds == null) {
			modelKinds = new EObjectContainmentWithInverseEList<ModelKind>(ModelKind.class, this, Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS, Iso42010Package.MODEL_KIND__VIEWPOINT);
		}
		return modelKinds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureView getGoverns() {
		if (governs != null && governs.eIsProxy()) {
			InternalEObject oldGoverns = (InternalEObject)governs;
			governs = (ArchitectureView)eResolveProxy(oldGoverns);
			if (governs != oldGoverns) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, oldGoverns, governs));
			}
		}
		return governs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureView basicGetGoverns() {
		return governs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoverns(ArchitectureView newGoverns, NotificationChain msgs) {
		ArchitectureView oldGoverns = governs;
		governs = newGoverns;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, oldGoverns, newGoverns);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoverns(ArchitectureView newGoverns) {
		if (newGoverns != governs) {
			NotificationChain msgs = null;
			if (governs != null)
				msgs = ((InternalEObject)governs).eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, ArchitectureView.class, msgs);
			if (newGoverns != null)
				msgs = ((InternalEObject)newGoverns).eInverseAdd(this, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, ArchitectureView.class, msgs);
			msgs = basicSetGoverns(newGoverns, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS, newGoverns, newGoverns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concern> getFrames() {
		if (frames == null) {
			frames = new EObjectWithInverseResolvingEList.ManyInverse<Concern>(Concern.class, this, Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES, Iso42010Package.CONCERN__FRAMED_BY);
		}
		return frames;
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelKinds()).basicAdd(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				if (governs != null)
					msgs = ((InternalEObject)governs).eInverseRemove(this, Iso42010Package.ARCHITECTURE_VIEW__GOVERNED_BY, ArchitectureView.class, msgs);
				return basicSetGoverns((ArchitectureView)otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFrames()).basicAdd(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				return ((InternalEList<?>)getModelKinds()).basicRemove(otherEnd, msgs);
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				return basicSetGoverns(null, msgs);
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				return ((InternalEList<?>)getFrames()).basicRemove(otherEnd, msgs);
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				return getModelKinds();
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				if (resolve) return getGoverns();
				return basicGetGoverns();
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				return getFrames();
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				getModelKinds().clear();
				getModelKinds().addAll((Collection<? extends ModelKind>)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				setGoverns((ArchitectureView)newValue);
				return;
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				getFrames().clear();
				getFrames().addAll((Collection<? extends Concern>)newValue);
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				getModelKinds().clear();
				return;
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				setGoverns((ArchitectureView)null);
				return;
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				getFrames().clear();
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
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__MODEL_KINDS:
				return modelKinds != null && !modelKinds.isEmpty();
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__GOVERNS:
				return governs != null;
			case Iso42010Package.ARCHITECTURE_VIEWPOINT__FRAMES:
				return frames != null && !frames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureViewpointImpl
