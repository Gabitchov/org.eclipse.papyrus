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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadEvent;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Workload Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl#getDemand <em>Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaWorkloadBehaviorImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaWorkloadBehaviorImpl extends EObjectImpl implements GaWorkloadBehavior {
	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<GaScenario> behavior;

	/**
	 * The cached value of the '{@link #getDemand() <em>Demand</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemand()
	 * @generated
	 * @ordered
	 */
	protected EList<GaWorkloadEvent> demand;

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaWorkloadBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_WORKLOAD_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaScenario> getBehavior() {
		if (behavior == null) {
			behavior = new EObjectResolvingEList<GaScenario>(GaScenario.class, this, GQAMPackage.GA_WORKLOAD_BEHAVIOR__BEHAVIOR);
		}
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaWorkloadEvent> getDemand() {
		if (demand == null) {
			demand = new EObjectResolvingEList<GaWorkloadEvent>(GaWorkloadEvent.class, this, GQAMPackage.GA_WORKLOAD_BEHAVIOR__DEMAND);
		}
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BEHAVIOR:
				return getBehavior();
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__DEMAND:
				return getDemand();
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
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
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BEHAVIOR:
				getBehavior().clear();
				getBehavior().addAll((Collection<? extends GaScenario>)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__DEMAND:
				getDemand().clear();
				getDemand().addAll((Collection<? extends GaWorkloadEvent>)newValue);
				return;
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
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
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BEHAVIOR:
				getBehavior().clear();
				return;
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__DEMAND:
				getDemand().clear();
				return;
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
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
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BEHAVIOR:
				return behavior != null && !behavior.isEmpty();
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__DEMAND:
				return demand != null && !demand.isEmpty();
			case GQAMPackage.GA_WORKLOAD_BEHAVIOR__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
		}
		return super.eIsSet(featureID);
	}

} //GaWorkloadBehaviorImpl
