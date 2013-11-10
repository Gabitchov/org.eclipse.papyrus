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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isLayerEnabledInternal <em>Is Layer Enabled Internal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isLayerEnabled <em>Is Layer Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LayerExpressionImpl extends 
ApplicationDependantElementImpl implements LayerExpression {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isLayerEnabledInternal() <em>Is Layer Enabled Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabledInternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LAYER_ENABLED_INTERNAL_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isLayerEnabled() <em>Is Layer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LAYER_ENABLED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isLayerEnabled() <em>Is Layer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLayerEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean isLayerEnabled = IS_LAYER_ENABLED_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLayerEnabledInternal() {
		return isLayerEnabled();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerEnabled() {
		return isLayerEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLayerEnabled(boolean newIsLayerEnabled) {
		boolean oldIsLayerEnabled = isLayerEnabled;
		isLayerEnabled = newIsLayerEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED, oldIsLayerEnabled, isLayerEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException  {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(EList<View> view, Property property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, EList<Property> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStack getLayersStack() throws NotFoundException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> view, Property property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> property) throws LayersException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.LAYER_EXPRESSION__NAME:
				return getName();
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				return getDescription();
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL:
				return isLayerEnabledInternal();
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				return isLayerEnabled();
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
			case LayersPackage.LAYER_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				setIsLayerEnabled((Boolean)newValue);
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
			case LayersPackage.LAYER_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				setIsLayerEnabled(IS_LAYER_ENABLED_EDEFAULT);
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
			case LayersPackage.LAYER_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayersPackage.LAYER_EXPRESSION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED_INTERNAL:
				return isLayerEnabledInternal() != IS_LAYER_ENABLED_INTERNAL_EDEFAULT;
			case LayersPackage.LAYER_EXPRESSION__IS_LAYER_ENABLED:
				return isLayerEnabled != IS_LAYER_ENABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY:
				try {
					return getComputePropertyValueCommand((View)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY:
				try {
					return getViewsComputePropertyValueCommand((EList<View>)arguments.get(0), (Property)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST:
				try {
					return getPropertiesComputePropertyValueCommand((View)arguments.get(0), (EList<Property>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_EXPRESSION___GET_LAYERS_STACK:
				try {
					return getLayersStack();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", isLayerEnabled: ");
		result.append(isLayerEnabled);
		result.append(')');
		return result.toString();
	}

} //LayerExpressionImpl
