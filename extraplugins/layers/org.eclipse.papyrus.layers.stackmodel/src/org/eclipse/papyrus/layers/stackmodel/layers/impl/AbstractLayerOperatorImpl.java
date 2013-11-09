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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractLayerOperatorImpl extends LayerOperatorImpl implements AbstractLayerOperator {
	/**
	 * The cached value of the '{@link #getLayerOperatorDescriptor() <em>Layer Operator Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 * @ordered
	 */
	protected LayerOperatorDescriptor layerOperatorDescriptor;

	/**
	 * The default value of the '{@link #getLayerOperatorDescriptorName() <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLayerOperatorDescriptorName() <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 * @ordered
	 */
	protected String layerOperatorDescriptorName = LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractLayerOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.ABSTRACT_LAYER_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor getLayerOperatorDescriptor() {
		if (layerOperatorDescriptor != null && layerOperatorDescriptor.eIsProxy()) {
			InternalEObject oldLayerOperatorDescriptor = (InternalEObject)layerOperatorDescriptor;
			layerOperatorDescriptor = (LayerOperatorDescriptor)eResolveProxy(oldLayerOperatorDescriptor);
			if (layerOperatorDescriptor != oldLayerOperatorDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR, oldLayerOperatorDescriptor, layerOperatorDescriptor));
			}
		}
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor basicGetLayerOperatorDescriptor() {
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerOperatorDescriptor(LayerOperatorDescriptor newLayerOperatorDescriptor) {
		LayerOperatorDescriptor oldLayerOperatorDescriptor = layerOperatorDescriptor;
		layerOperatorDescriptor = newLayerOperatorDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR, oldLayerOperatorDescriptor, layerOperatorDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayerOperatorDescriptorName() {
		return layerOperatorDescriptorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLayerOperatorDescriptorName(String newLayerOperatorDescriptorName) {

		// Avoid recursive call if name is the same
		if( newLayerOperatorDescriptorName.equals(layerOperatorDescriptorName) ) {
			return;
		}
		
		String oldLayerOperatorDescriptorName = layerOperatorDescriptorName;
		layerOperatorDescriptorName = newLayerOperatorDescriptorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME, oldLayerOperatorDescriptorName, layerOperatorDescriptorName));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDescriptorSet() {
		return getLayerOperatorDescriptor() != null;
	}

	/**
	 * Reset the descriptor accordingly to the descriptor name.
	 * The descriptor is resseted only if the ::application and ::layerOperatorDescriptorName are set.
	 * Nothing is done if one of the attribute is not set.
	 * Nothing is done if the descriptor can not be found (maybe a log is issue).
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void resetDescriptor() {

		if( getApplication() == null ) {
			return;
		}
		if( getLayerOperatorDescriptorName() == null) {
			return;
		}
		
		try {
			LayerOperatorDescriptor descriptor = application.getLayerOperatorDescriptorRegistry().getLayerOperatorDescriptor(getLayerOperatorDescriptorName());
			setLayerOperatorDescriptor(descriptor);
		} catch (NotFoundException e) {
			System.err.println("LOG - " + this.getClass().getName() + " - " + e.getMessage() );
		}
		
	}

	/**
	 * Override in order to call {@link #resetDescriptor()}
	 * @param newApplication
	 */
//	@Override
//	public void setApplication(LayersStackApplication newApplication) {
//		super.setApplication(newApplication);
//		resetDescriptor();
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLayerEnabledInternal() {
		return isLayerEnabled() && isDescriptorSet();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
				if (resolve) return getLayerOperatorDescriptor();
				return basicGetLayerOperatorDescriptor();
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				return getLayerOperatorDescriptorName();
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
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
				setLayerOperatorDescriptor((LayerOperatorDescriptor)newValue);
				return;
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				setLayerOperatorDescriptorName((String)newValue);
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
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
				setLayerOperatorDescriptor((LayerOperatorDescriptor)null);
				return;
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				setLayerOperatorDescriptorName(LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT);
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
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR:
				return layerOperatorDescriptor != null;
			case LayersPackage.ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME:
				return LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT == null ? layerOperatorDescriptorName != null : !LAYER_OPERATOR_DESCRIPTOR_NAME_EDEFAULT.equals(layerOperatorDescriptorName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET:
				return isDescriptorSet();
			case LayersPackage.ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR:
				resetDescriptor();
				return null;
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
		result.append(" (layerOperatorDescriptorName: ");
		result.append(layerOperatorDescriptorName);
		result.append(')');
		return result.toString();
	}

	/**
	 * Get the command to compute the required property value.
	 * Walk all layers and collect the non null command for the property and view.
	 * Then return the command provided by a call to the properties'operator(collectedCmd).
	 * 

	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException {
		
		// Do nothing if the layer is disable.
		if( ! isLayerEnabled() ) {
			return null;
		}
		
		
		// The list of commands provided by each layers
		EList<ComputePropertyValueCommand> collectedCmds = new BasicEList<ComputePropertyValueCommand>(getLayers().size());

		// Walk all layers and return the first cmd that is not null for specified view and proerty.
		for( LayerExpression layer : getLayers()) {
			
			ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				collectedCmds.add(cmd);
			}
		}
		
		// If we have no subcommand, skip the value by returning null.
		if( collectedCmds.size()==0) {
			return null;
		}
		
		// Call the corresponding operator
		ComputePropertyValueCommand res = getLayerOperatorDescriptor().getPropertyOperator(property).getComputePropertyValueCommand(collectedCmds);
		return res;
	
	}
	/**
	 * For each property, add the first property value in the list of result.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> properties) throws LayersException {

		// Do nothing if the layer is disable.
		if( ! isLayerEnabled() ) {
			return null;
		}
		
		// Simple implementation
		// TODO Check if we can optimize

		// the result list
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(properties.size());
		boolean isCmdFound = false;
		
		// Walk each property
		for( Property property : properties) {
			if( property == null) {
				resCmds.add(null);
				continue;
			}
			
			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);

				
		}
		// Return appropriate result
		if( isCmdFound) {
			return resCmds;
		}
		else {
			// No command ==> null 
			return null;
		}
	}
	
	/**
	 * For each view, add the first property value in the list of result.
	 * 
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.layers.stackmodel.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> views, Property property) throws LayersException {

		// Do nothing if the layer is disable.
		if( ! isLayerEnabled() ) {
			return null;
		}
		
		// Simple implementation
		// TODO Check if we can optimize
		
		// the result list
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(views.size());
		boolean isCmdFound = false;
		
		for( View view : views) {
			if( view == null) {
				resCmds.add(null);
				continue;
			}
			
			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);
		}
				
		// Return appropriate result
		if( isCmdFound) {
			return resCmds;
		}
		else {
			// No command ==> null 
			return null;
		}
	}
	
} //AbstractLayerOperatorImpl
