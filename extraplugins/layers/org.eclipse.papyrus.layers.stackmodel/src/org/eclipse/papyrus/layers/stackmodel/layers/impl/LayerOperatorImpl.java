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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorImpl#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LayerOperatorImpl extends LayerExpressionImpl implements LayerOperator {
	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<LayerExpression> layers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayerExpression> getLayers() {
		if (layers == null) {
			layers = new EObjectContainmentEList<LayerExpression>(LayerExpression.class, this, LayersPackage.LAYER_OPERATOR__LAYERS);
		}
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addLayer(LayerExpression layer) {
//		getLayers().add(layer);
		// Add layer on top of the stack.
		getLayers().add(0, layer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR__LAYERS:
				return ((InternalEList<?>)getLayers()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.LAYER_OPERATOR__LAYERS:
				return getLayers();
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
			case LayersPackage.LAYER_OPERATOR__LAYERS:
				getLayers().clear();
				getLayers().addAll((Collection<? extends LayerExpression>)newValue);
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
			case LayersPackage.LAYER_OPERATOR__LAYERS:
				getLayers().clear();
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
			case LayersPackage.LAYER_OPERATOR__LAYERS:
				return layers != null && !layers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == LayersContainer.class) {
			switch (baseOperationID) {
				case LayersPackage.LAYERS_CONTAINER___ADD_LAYER__LAYEREXPRESSION: return LayersPackage.LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.LAYER_OPERATOR___ADD_LAYER__LAYEREXPRESSION:
				addLayer((LayerExpression)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Get the LayersStack that own directly or indirectly this Layer.
	 * Throw an exception if no {@link LayersStack} can be found.
	 * <br>
	 * Lookup is done recursively in parent containers.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getLayersStack()
	 *
	 * @return
	 * @throws NotFoundException
	 */
//	@Override
//	public LayersStack getLayersStack() throws NotFoundException {
//		// TODO: performance improvment. It is possible to avoid the lookup 
//		// by caching the LayersStack, or by setting a corresponding property
//		// in the model
//		return (LayersStack)ECoreUtils.lookupAncestorOfType(this, LayersPackage.eINSTANCE.getLayersStack());
//	}

	/**
	 * Propagate the change to children
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#setIsBranchEnabled(boolean)
	 *
	 * @param newIsBranchEnabled
	 */
	@Override
	public void setIsBranchEnabled(boolean newIsBranchEnabled) {
		// First, set the value.
		super.setIsBranchEnabled(newIsBranchEnabled);
		// Now, propagate
		boolean value = isBranchEnabled();
		for( LayerExpression layer : getLayers() ) {
			layer.setIsBranchEnabled(value);
		}
	}
	
	/**
	 * Set the value then propagate to children nodes.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#setOwningLayersStack(org.eclipse.papyrus.layers.stackmodel.layers.LayersStack)
	 *
	 * @param newOwningLayersStack
	 */
	@Override
	public void setOwningLayersStack(LayersStack newOwningLayersStack) {
		// Set the value
		super.setOwningLayersStack(newOwningLayersStack);
		// Now propagate to children
		LayersStack value = getOwningLayersStack();
		for( LayerExpression layer : getLayers() ) {
			layer.setOwningLayersStack(value);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Start this element after its reloading by EMF
	 * This method is called recursively by the parent of this element.
	 * 
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @generated NOT
	 */
	@Override
	public void attach() throws LayersException {
		// Try to attach this Layer
		super.attach();
		// attach children
		for( LayerExpression l : getLayers()) {
			l.attach();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#detach()
	 *
	 * @throws LayersException
	 */
	@Override
	public void detach() throws LayersException {
		// Detach this Layer
		super.detach();
		// detach children
		for( LayerExpression l : getLayers()) {
			l.detach();
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated unless we need it again
	 * @generated NOT
	 */
	public void attachToLayersStack(LayersStack owningLayersStack) {
		
		// the owning stack
		setOwningLayersStack(owningLayersStack);
		
		// Ensure child is started, if any
		for( LayerExpression l : getLayers()) {
			l.attachToLayersStack(owningLayersStack);
		}
		
		// Start local behaviors
		startBehaviors();
	}


} //LayerOperatorImpl
