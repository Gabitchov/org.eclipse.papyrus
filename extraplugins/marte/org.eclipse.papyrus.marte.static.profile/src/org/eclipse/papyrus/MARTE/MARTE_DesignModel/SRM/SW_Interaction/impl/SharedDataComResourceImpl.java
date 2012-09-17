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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource;
import org.eclipse.uml2.uml.BehavioralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shared Data Com Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl#getReadServices <em>Read Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl#getWriteServices <em>Write Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SharedDataComResourceImpl extends SwCommunicationResourceImpl implements SharedDataComResource {
	/**
	 * The cached value of the '{@link #getReadServices() <em>Read Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> readServices;

	/**
	 * The cached value of the '{@link #getWriteServices() <em>Write Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> writeServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SharedDataComResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_InteractionPackage.Literals.SHARED_DATA_COM_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getReadServices() {
		if (readServices == null) {
			readServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__READ_SERVICES);
		}
		return readServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getWriteServices() {
		if (writeServices == null) {
			writeServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__WRITE_SERVICES);
		}
		return writeServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__READ_SERVICES:
				return getReadServices();
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__WRITE_SERVICES:
				return getWriteServices();
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
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__READ_SERVICES:
				getReadServices().clear();
				getReadServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__WRITE_SERVICES:
				getWriteServices().clear();
				getWriteServices().addAll((Collection<? extends BehavioralFeature>)newValue);
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
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__READ_SERVICES:
				getReadServices().clear();
				return;
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__WRITE_SERVICES:
				getWriteServices().clear();
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
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__READ_SERVICES:
				return readServices != null && !readServices.isEmpty();
			case SW_InteractionPackage.SHARED_DATA_COM_RESOURCE__WRITE_SERVICES:
				return writeServices != null && !writeServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SharedDataComResourceImpl
