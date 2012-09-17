/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocating Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl#getOnPorts <em>On Ports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl#getOnFeatures <em>On Features</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl#getInvocations <em>Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GCMInvocatingBehaviorImpl extends EObjectImpl implements GCMInvocatingBehavior {
	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * The cached value of the '{@link #getOnPorts() <em>On Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> onPorts;

	/**
	 * The cached value of the '{@link #getOnFeatures() <em>On Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> onFeatures;

	/**
	 * The cached value of the '{@link #getInvocations() <em>Invocations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocations()
	 * @generated
	 * @ordered
	 */
	protected EList<InvocationAction> invocations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GCMInvocatingBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GCMPackage.Literals.GCM_INVOCATING_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if (base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if (base_Behavior != oldBase_Behavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOnPorts() {
		if (onPorts == null) {
			onPorts = new EObjectResolvingEList<Port>(Port.class, this, GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_PORTS);
		}
		return onPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getOnFeatures() {
		if (onFeatures == null) {
			onFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_FEATURES);
		}
		return onFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InvocationAction> getInvocations() {
		if (invocations == null) {
			invocations = new EObjectResolvingEList<InvocationAction>(InvocationAction.class, this, GCMPackage.GCM_INVOCATING_BEHAVIOR__INVOCATIONS);
		}
		return invocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR:
				if (resolve) return getBase_Behavior();
				return basicGetBase_Behavior();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_PORTS:
				return getOnPorts();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_FEATURES:
				return getOnFeatures();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__INVOCATIONS:
				return getInvocations();
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
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)newValue);
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_PORTS:
				getOnPorts().clear();
				getOnPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_FEATURES:
				getOnFeatures().clear();
				getOnFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__INVOCATIONS:
				getInvocations().clear();
				getInvocations().addAll((Collection<? extends InvocationAction>)newValue);
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
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)null);
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_PORTS:
				getOnPorts().clear();
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_FEATURES:
				getOnFeatures().clear();
				return;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__INVOCATIONS:
				getInvocations().clear();
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
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR:
				return base_Behavior != null;
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_PORTS:
				return onPorts != null && !onPorts.isEmpty();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__ON_FEATURES:
				return onFeatures != null && !onFeatures.isEmpty();
			case GCMPackage.GCM_INVOCATING_BEHAVIOR__INVOCATIONS:
				return invocations != null && !invocations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GCMInvocatingBehaviorImpl
