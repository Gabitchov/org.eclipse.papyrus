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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Secondary Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SecondarySchedulerImpl#getVirtualProcessingUnits <em>Virtual Processing Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecondarySchedulerImpl extends SchedulerImpl implements SecondaryScheduler {
	/**
	 * The cached value of the '{@link #getVirtualProcessingUnits() <em>Virtual Processing Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualProcessingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulableResource> virtualProcessingUnits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecondarySchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GRMPackage.Literals.SECONDARY_SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulableResource> getVirtualProcessingUnits() {
		if (virtualProcessingUnits == null) {
			virtualProcessingUnits = new EObjectWithInverseResolvingEList<SchedulableResource>(SchedulableResource.class, this, GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS, GRMPackage.SCHEDULABLE_RESOURCE__DEPENDENT_SCHEDULER);
		}
		return virtualProcessingUnits;
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVirtualProcessingUnits()).basicAdd(otherEnd, msgs);
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				return ((InternalEList<?>)getVirtualProcessingUnits()).basicRemove(otherEnd, msgs);
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				return getVirtualProcessingUnits();
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				getVirtualProcessingUnits().clear();
				getVirtualProcessingUnits().addAll((Collection<? extends SchedulableResource>)newValue);
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				getVirtualProcessingUnits().clear();
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
			case GRMPackage.SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS:
				return virtualProcessingUnits != null && !virtualProcessingUnits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SecondarySchedulerImpl
