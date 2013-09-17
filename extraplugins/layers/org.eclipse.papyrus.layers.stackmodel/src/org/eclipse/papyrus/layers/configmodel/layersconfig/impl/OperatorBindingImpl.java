/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl#getLayerOperatorConfig <em>Layer Operator Config</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.OperatorBindingImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorBindingImpl extends MinimalEObjectImpl.Container implements OperatorBinding {
	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected OperatorConfig operator;

	/**
	 * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyId()
	 * @generated
	 * @ordered
	 */
	protected PropertyId propertyId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersconfigPackage.Literals.OPERATOR_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorConfig getOperator() {
		if (operator != null && operator.eIsProxy()) {
			InternalEObject oldOperator = (InternalEObject)operator;
			operator = (OperatorConfig)eResolveProxy(oldOperator);
			if (operator != oldOperator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersconfigPackage.OPERATOR_BINDING__OPERATOR, oldOperator, operator));
			}
		}
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorConfig basicGetOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(OperatorConfig newOperator) {
		OperatorConfig oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.OPERATOR_BINDING__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorConfig getLayerOperatorConfig() {
		LayerOperatorConfig layerOperatorConfig = basicGetLayerOperatorConfig();
		return layerOperatorConfig != null && layerOperatorConfig.eIsProxy() ? (LayerOperatorConfig)eResolveProxy((InternalEObject)layerOperatorConfig) : layerOperatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayerOperatorConfig basicGetLayerOperatorConfig() {
		// 
		return getOwner().getLayerOperatorConfig();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyId getPropertyId() {
		if (propertyId != null && propertyId.eIsProxy()) {
			InternalEObject oldPropertyId = (InternalEObject)propertyId;
			propertyId = (PropertyId)eResolveProxy(oldPropertyId);
			if (propertyId != oldPropertyId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID, oldPropertyId, propertyId));
			}
		}
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyId basicGetPropertyId() {
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyId(PropertyId newPropertyId) {
		PropertyId oldPropertyId = propertyId;
		propertyId = newPropertyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID, oldPropertyId, propertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorMultipleBinding getOwner() {
		if (eContainerFeatureID() != LayersconfigPackage.OPERATOR_BINDING__OWNER) return null;
		return (LayerOperatorMultipleBinding)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(LayerOperatorMultipleBinding newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, LayersconfigPackage.OPERATOR_BINDING__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(LayerOperatorMultipleBinding newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != LayersconfigPackage.OPERATOR_BINDING__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, LayersconfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS, LayerOperatorMultipleBinding.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersconfigPackage.OPERATOR_BINDING__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((LayerOperatorMultipleBinding)otherEnd, msgs);
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
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				return basicSetOwner(null, msgs);
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
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				return eInternalContainer().eInverseRemove(this, LayersconfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING__BINDINGS, LayerOperatorMultipleBinding.class, msgs);
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
			case LayersconfigPackage.OPERATOR_BINDING__OPERATOR:
				if (resolve) return getOperator();
				return basicGetOperator();
			case LayersconfigPackage.OPERATOR_BINDING__LAYER_OPERATOR_CONFIG:
				if (resolve) return getLayerOperatorConfig();
				return basicGetLayerOperatorConfig();
			case LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID:
				if (resolve) return getPropertyId();
				return basicGetPropertyId();
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				return getOwner();
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
			case LayersconfigPackage.OPERATOR_BINDING__OPERATOR:
				setOperator((OperatorConfig)newValue);
				return;
			case LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID:
				setPropertyId((PropertyId)newValue);
				return;
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				setOwner((LayerOperatorMultipleBinding)newValue);
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
			case LayersconfigPackage.OPERATOR_BINDING__OPERATOR:
				setOperator((OperatorConfig)null);
				return;
			case LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID:
				setPropertyId((PropertyId)null);
				return;
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				setOwner((LayerOperatorMultipleBinding)null);
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
			case LayersconfigPackage.OPERATOR_BINDING__OPERATOR:
				return operator != null;
			case LayersconfigPackage.OPERATOR_BINDING__LAYER_OPERATOR_CONFIG:
				return basicGetLayerOperatorConfig() != null;
			case LayersconfigPackage.OPERATOR_BINDING__PROPERTY_ID:
				return propertyId != null;
			case LayersconfigPackage.OPERATOR_BINDING__OWNER:
				return getOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //OperatorBindingImpl
