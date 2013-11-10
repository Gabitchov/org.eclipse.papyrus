/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Descriptor Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerDescriptorRegistryImpl#getLayerDescriptors <em>Layer Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerDescriptorRegistryImpl extends MinimalEObjectImpl.Container implements LayerDescriptorRegistry {
	/**
	 * The cached value of the '{@link #getLayerDescriptors() <em>Layer Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<LayerDescriptor> layerDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerDescriptorRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_DESCRIPTOR_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayerDescriptor> getLayerDescriptors() {
		if (layerDescriptors == null) {
			layerDescriptors = new EObjectContainmentEList<LayerDescriptor>(LayerDescriptor.class, this, LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS);
		}
		return layerDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS:
				return ((InternalEList<?>)getLayerDescriptors()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS:
				return getLayerDescriptors();
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
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS:
				getLayerDescriptors().clear();
				getLayerDescriptors().addAll((Collection<? extends LayerDescriptor>)newValue);
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
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS:
				getLayerDescriptors().clear();
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
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS:
				return layerDescriptors != null && !layerDescriptors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayerDescriptorRegistryImpl
