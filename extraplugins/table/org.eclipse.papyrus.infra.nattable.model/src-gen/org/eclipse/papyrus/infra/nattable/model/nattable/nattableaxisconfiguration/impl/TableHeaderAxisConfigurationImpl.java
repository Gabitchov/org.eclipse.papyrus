/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.TableHeaderAxisConfigurationImpl#getAxisManagers <em>
 * Axis Managers</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TableHeaderAxisConfigurationImpl extends AbstractHeaderAxisConfigurationImpl implements TableHeaderAxisConfiguration {

	/**
	 * The cached value of the '{@link #getAxisManagers() <em>Axis Managers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAxisManagers()
	 * @generated
	 * @ordered
	 */
	protected EList<AxisManagerRepresentation> axisManagers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TableHeaderAxisConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.TABLE_HEADER_AXIS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AxisManagerRepresentation> getAxisManagers() {
		if(axisManagers == null) {
			axisManagers = new EObjectContainmentEList<AxisManagerRepresentation>(AxisManagerRepresentation.class, this, NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS);
		}
		return axisManagers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS:
			return ((InternalEList<?>)getAxisManagers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS:
			return getAxisManagers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS:
			getAxisManagers().clear();
			getAxisManagers().addAll((Collection<? extends AxisManagerRepresentation>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS:
			getAxisManagers().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS:
			return axisManagers != null && !axisManagers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableHeaderAxisConfigurationImpl
