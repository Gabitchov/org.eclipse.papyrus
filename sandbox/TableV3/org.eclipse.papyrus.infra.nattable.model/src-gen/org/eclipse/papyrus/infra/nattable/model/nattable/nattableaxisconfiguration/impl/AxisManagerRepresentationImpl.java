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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Axis Manager Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl#getAxisManagerId <em>Axis Manager Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl#getLabelProviderContext <em>Label Provider Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl#getHeaderLabelConfiguration <em>Header Label Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerRepresentationImpl#getSpecificAxisConfiguration <em>Specific Axis Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AxisManagerRepresentationImpl extends MinimalEObjectImpl.Container implements AxisManagerRepresentation {
	/**
	 * The default value of the '{@link #getAxisManagerId() <em>Axis Manager Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisManagerId()
	 * @generated
	 * @ordered
	 */
	protected static final String AXIS_MANAGER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAxisManagerId() <em>Axis Manager Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisManagerId()
	 * @generated
	 * @ordered
	 */
	protected String axisManagerId = AXIS_MANAGER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabelProviderContext() <em>Label Provider Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelProviderContext()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_PROVIDER_CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelProviderContext() <em>Label Provider Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelProviderContext()
	 * @generated
	 * @ordered
	 */
	protected String labelProviderContext = LABEL_PROVIDER_CONTEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHeaderLabelConfiguration() <em>Header Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ILabelProviderConfiguration headerLabelConfiguration;

	/**
	 * The cached value of the '{@link #getSpecificAxisConfiguration() <em>Specific Axis Configuration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificAxisConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<IAxisConfiguration> specificAxisConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AxisManagerRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.AXIS_MANAGER_REPRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAxisManagerId() {
		return axisManagerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisManagerId(String newAxisManagerId) {
		String oldAxisManagerId = axisManagerId;
		axisManagerId = newAxisManagerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID, oldAxisManagerId, axisManagerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabelProviderContext() {
		return labelProviderContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelProviderContext(String newLabelProviderContext) {
		String oldLabelProviderContext = labelProviderContext;
		labelProviderContext = newLabelProviderContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT, oldLabelProviderContext, labelProviderContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabelProviderConfiguration getHeaderLabelConfiguration() {
		if (headerLabelConfiguration != null && headerLabelConfiguration.eIsProxy()) {
			InternalEObject oldHeaderLabelConfiguration = (InternalEObject)headerLabelConfiguration;
			headerLabelConfiguration = (ILabelProviderConfiguration)eResolveProxy(oldHeaderLabelConfiguration);
			if (headerLabelConfiguration != oldHeaderLabelConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION, oldHeaderLabelConfiguration, headerLabelConfiguration));
			}
		}
		return headerLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabelProviderConfiguration basicGetHeaderLabelConfiguration() {
		return headerLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderLabelConfiguration(ILabelProviderConfiguration newHeaderLabelConfiguration) {
		ILabelProviderConfiguration oldHeaderLabelConfiguration = headerLabelConfiguration;
		headerLabelConfiguration = newHeaderLabelConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION, oldHeaderLabelConfiguration, headerLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAxisConfiguration> getSpecificAxisConfiguration() {
		if (specificAxisConfiguration == null) {
			specificAxisConfiguration = new EObjectResolvingEList<IAxisConfiguration>(IAxisConfiguration.class, this, NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATION);
		}
		return specificAxisConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID:
				return getAxisManagerId();
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT:
				return getLabelProviderContext();
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION:
				if (resolve) return getHeaderLabelConfiguration();
				return basicGetHeaderLabelConfiguration();
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATION:
				return getSpecificAxisConfiguration();
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
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID:
				setAxisManagerId((String)newValue);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT:
				setLabelProviderContext((String)newValue);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION:
				setHeaderLabelConfiguration((ILabelProviderConfiguration)newValue);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATION:
				getSpecificAxisConfiguration().clear();
				getSpecificAxisConfiguration().addAll((Collection<? extends IAxisConfiguration>)newValue);
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
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID:
				setAxisManagerId(AXIS_MANAGER_ID_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT:
				setLabelProviderContext(LABEL_PROVIDER_CONTEXT_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION:
				setHeaderLabelConfiguration((ILabelProviderConfiguration)null);
				return;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATION:
				getSpecificAxisConfiguration().clear();
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
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID:
				return AXIS_MANAGER_ID_EDEFAULT == null ? axisManagerId != null : !AXIS_MANAGER_ID_EDEFAULT.equals(axisManagerId);
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT:
				return LABEL_PROVIDER_CONTEXT_EDEFAULT == null ? labelProviderContext != null : !LABEL_PROVIDER_CONTEXT_EDEFAULT.equals(labelProviderContext);
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION:
				return headerLabelConfiguration != null;
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATION:
				return specificAxisConfiguration != null && !specificAxisConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (axisManagerId: "); //$NON-NLS-1$
		result.append(axisManagerId);
		result.append(", labelProviderContext: "); //$NON-NLS-1$
		result.append(labelProviderContext);
		result.append(')');
		return result.toString();
	}

} //AxisManagerRepresentationImpl
