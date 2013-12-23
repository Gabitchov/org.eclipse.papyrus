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
import java.util.List;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.NullInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getPropertyValueMap <em>Property Value Map</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getLayerDescriptor <em>Layer Descriptor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getAttachedProperties <em>Attached Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractLayerImpl extends LayerExpressionImpl implements AbstractLayer {
	/**
	 * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeInstance> propertyValues;

	/**
	 * The cached value of the '{@link #getPropertyValueMap() <em>Property Value Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValueMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, TypeInstance> propertyValueMap;

	/**
	 * The cached value of the '{@link #getLayerDescriptor() <em>Layer Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerDescriptor()
	 * @generated
	 * @ordered
	 */
	protected LayerDescriptor layerDescriptor;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<View> views;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AbstractLayerImpl() {
		super();
		
		// Add an observer
		Adapter adapter = new PropertyValuesSynchronizer();
		this.eAdapters().add(adapter);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.ABSTRACT_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("serial")
	public EList<TypeInstance> getPropertyValues() {
		if (propertyValues == null) {
			propertyValues = new EObjectResolvingEList<TypeInstance>(TypeInstance.class, this, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUES) {

				// Allows double
				@Override
				protected boolean isUnique() {
					return false;
				}
			};
		}
		return propertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, TypeInstance> getPropertyValueMap() {
		if (propertyValueMap == null) {
			propertyValueMap = new EcoreEMap<String,TypeInstance>(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP, StringToTypeInstanceMapImpl.class, this, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP);
		}
		return propertyValueMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptor getLayerDescriptor() {
		if (layerDescriptor != null && layerDescriptor.eIsProxy()) {
			InternalEObject oldLayerDescriptor = (InternalEObject)layerDescriptor;
			layerDescriptor = (LayerDescriptor)eResolveProxy(oldLayerDescriptor);
			if (layerDescriptor != oldLayerDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR, oldLayerDescriptor, layerDescriptor));
			}
		}
		return layerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptor basicGetLayerDescriptor() {
		return layerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerDescriptor(LayerDescriptor newLayerDescriptor) {
		LayerDescriptor oldLayerDescriptor = layerDescriptor;
		layerDescriptor = newLayerDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR, oldLayerDescriptor, layerDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> getViews() {
		if (views == null) {
			views = new EObjectResolvingEList<View>(View.class, this, LayersPackage.ABSTRACT_LAYER__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Property> getAttachedProperties() {
		
		// Silly implementation:
		// walk existing instance keys, and get there descriptor 
		// from the propertyRegistry.
		// TODO: improve this method: have a list updated when an instance is 
		// added or removed.
		
		EList<Property> res = new BasicEList<Property>();
		
		for( Entry<String, TypeInstance> entry : getPropertyValueMap()) {
			String propertyName = entry.getKey();
			
			try {
				res.add(application.getPropertyRegistry().getProperty(propertyName));
			} catch (NotFoundException e) {
				// This should not happen
				res.add(null);
				e.printStackTrace();
			}
			
			
		}
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeInstance addPropertyInstance(Property property) throws LayersException {

		String name = property.getName();
		if( name == null || name.length()==0) {
			throw new LayersException("The name of a property must be set.");
		}
		
		try {
			TypeInstance instance = property.createInstance();
			getPropertyValueMap().put(name, instance);
			return instance;
		} catch (NullPointerException e) {
			throw new LayersException("The type of the property '" 
		                   + name + "' must be set.", e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removePropertyInstance(Property property) {
		getPropertyValueMap().remove(property.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeInstance getPropertyInstance(Property property) throws LayersException {
		return getPropertyInstance(property.getName() );
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeInstance getPropertyInstance(String property) throws LayersException {
		TypeInstance instance = getPropertyValueMap().get(property);
		
		if( instance == null) {
			throw new NotFoundException("Can't find instance for the specified property");
		}
		
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				return ((InternalEList<?>)getPropertyValueMap()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUES:
				return getPropertyValues();
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				if (coreType) return getPropertyValueMap();
				else return getPropertyValueMap().map();
			case LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR:
				if (resolve) return getLayerDescriptor();
				return basicGetLayerDescriptor();
			case LayersPackage.ABSTRACT_LAYER__VIEWS:
				return getViews();
			case LayersPackage.ABSTRACT_LAYER__ATTACHED_PROPERTIES:
				return getAttachedProperties();
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
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUES:
				getPropertyValues().clear();
				getPropertyValues().addAll((Collection<? extends TypeInstance>)newValue);
				return;
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				((EStructuralFeature.Setting)getPropertyValueMap()).set(newValue);
				return;
			case LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR:
				setLayerDescriptor((LayerDescriptor)newValue);
				return;
			case LayersPackage.ABSTRACT_LAYER__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends View>)newValue);
				return;
			case LayersPackage.ABSTRACT_LAYER__ATTACHED_PROPERTIES:
				getAttachedProperties().clear();
				getAttachedProperties().addAll((Collection<? extends Property>)newValue);
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
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUES:
				getPropertyValues().clear();
				return;
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				getPropertyValueMap().clear();
				return;
			case LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR:
				setLayerDescriptor((LayerDescriptor)null);
				return;
			case LayersPackage.ABSTRACT_LAYER__VIEWS:
				getViews().clear();
				return;
			case LayersPackage.ABSTRACT_LAYER__ATTACHED_PROPERTIES:
				getAttachedProperties().clear();
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
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUES:
				return propertyValues != null && !propertyValues.isEmpty();
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				return propertyValueMap != null && !propertyValueMap.isEmpty();
			case LayersPackage.ABSTRACT_LAYER__LAYER_DESCRIPTOR:
				return layerDescriptor != null;
			case LayersPackage.ABSTRACT_LAYER__VIEWS:
				return views != null && !views.isEmpty();
			case LayersPackage.ABSTRACT_LAYER__ATTACHED_PROPERTIES:
				return !getAttachedProperties().isEmpty();
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
			case LayersPackage.ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY:
				try {
					return addPropertyInstance((Property)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY:
				removePropertyInstance((Property)arguments.get(0));
				return null;
			case LayersPackage.ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY:
				try {
					return getPropertyInstance((Property)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING:
				try {
					return getPropertyInstance((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/** 
	 * Set the {@link #propertyValues} property. 
	 * The #application proerty must be set.
	 * Set the list size to the number of availale property
	 * Synchronize the values with instances found in {@link #propertyValueMap}.
	 * @throws BadStateException 
	 */
	protected void resetAllPropertyValuesFromRegistry() throws BadStateException {
		
		// Reset list
		getPropertyValues().clear();

		// Check application
		LayersStackApplication application = getApplication();
		if(application== null) {
			// do not synchronize the list
			return;
//			throw new BadStateException("Property 'application' must be set for resetAllPropertyValuesFromRegistry() to work.");
		}
		
		List<Property> availableProperties;
		int size;
		try {
			availableProperties = application.getPropertyRegistry().getProperties();
			size = availableProperties.size();
		} catch (NullPointerException e) {
			throw new BadStateException("Property 'application.propertyRegistry' must be set for resetAllPropertyValuesFromRegistry() to work.");
		}
		
		// initialize the propertyValues
		getPropertyValues().clear();
		for(int i=0;i<size;i++) {
			String propertyName = availableProperties.get(i).getName();
//			getPropertyValues().set(i, getPropertyValueMap().get(propertyName));
			// Add the instance, or null if not found. This ensure
			// That the list will have the correct size.
			TypeInstance instance = getPropertyValueMap().get(propertyName);
			if( instance == null ) {
				instance = NullInstance.NULLINSTANCE;
			} 
			getPropertyValues().add( instance);
		}
	}
	
	/**
	 * Synchronize the specified propertyName with the value in the {@link #propertyValues} list.
	 * @param propertyName
	 * @param value
	 * @throws NotFoundException 
	 */
	protected void synchronizePropertyValue(String propertyName, TypeInstance value) throws BadStateException, NotFoundException {
		
		if( application == null) {
			//silently fail
			return;
		}
		
		try {
			int propertyIndex = application.getPropertyRegistry().getPropertyIndex(propertyName);
			getPropertyValues().set(propertyIndex, value);
		} catch (NullPointerException e) {
			throw new BadStateException("application should be set first.");
		}
	}
	
	/**
	 * This class listen to #propertyValueMap, and synchronize propertyValues accordingly.
	 * 
	 *
	 */
	public class PropertyValuesSynchronizer extends AdapterImpl {
		
		@Override
		public void notifyChanged(Notification msg) {
			System.err.println("event " + msg.getEventType());
			
			switch(msg.getFeatureID(AbstractLayer.class)) {
			case LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP:
				notifyLayerPropertyValueMapChanged(msg);
				break;

			case LayersPackage.ABSTRACT_LAYER__APPLICATION:
				notifyLayerApplicationFeatureChanged(msg);
				break;

			default:
				break;
			}
		}
		
		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 * @param msg
		 */
		protected void notifyLayerPropertyValueMapChanged(Notification msg) {
			System.err.println("map changed " + msg.getEventType());
			switch(msg.getEventType()) {
			case Notification.SET:	
			{
				// A key is modified
				// Add the value to other list
				// An entry is added
				StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)msg.getNewValue();
				System.out.println("SET - newValue=" + entry.getValue()
						 + ", key=" + entry.getKey());
				
				String newKey = entry.getKey();
				TypeInstance value = entry.getValue();
				if( value != null) {
					try {
						synchronizePropertyValue(newKey, value);
					} catch (BadStateException e) {
						// Show error for debug
						e.printStackTrace();
					} catch (NotFoundException e) {
						// Show error for debug
						e.printStackTrace();
					}
				}
				

				break;
			}
			case Notification.UNSET:	
				// A key is added
				break;
			case Notification.ADD:	
			{
				// An entry is added
				StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)msg.getNewValue();
				System.out.println("ADD - newValue=" + entry.getValue()
						 + ", key=" + entry.getKey());
				// Add the corresponding instance to propertyValues
				try {
					synchronizePropertyValue(entry.getKey(), entry.getValue());
				} catch (LayersException e) {
					// should not happen
					e.printStackTrace();
				}
				break;
			}
			case Notification.REMOVE:	
			{
				// An entry is removed
				StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)msg.getOldValue();
				System.out.println("REMOVE" + entry.getValue()
						 + ", key=" + entry.getKey());
				// Add the corresponding instance to propertyValues
				try {
					synchronizePropertyValue(entry.getKey(), NullInstance.NULLINSTANCE);
				} catch (LayersException e) {
					// should not happen
					e.printStackTrace();
				}
				break;
			}
			default:
				break;
			}

		}
		/**
		 * The {@link LayerImpl#propertyValueMap} has changed. Synchronize the {@link LayerImpl#propertyValues} list.
		 * @param msg
		 */
		protected void notifyLayerApplicationFeatureChanged(Notification msg) {
			System.err.println("application changed " + msg.getEventType());
			switch(msg.getEventType()) {
			case Notification.SET:	
			{
				// The property is set.
				// Synchronize propertyValues
				try {
					resetAllPropertyValuesFromRegistry();
				} catch (BadStateException e) {
					// should not happen
					e.printStackTrace();
				}
				break;
			}
			case Notification.UNSET:	
				// application is removed
				// clear propertyValues
				getPropertyValues().clear();
				break;
			}
		}

	}
	/**
	 * Get the command to compute the required property value.
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
		
		// If the layer is disabled, return a null command.
		// If the view is not attached to the layer, stop.
		if( ! isLayerEnabledInternal() || ! getViews().contains(view)) {
			return null;
		}
		
		try {
			return getPropertyInstance(property);
		} catch (NotFoundException e) {
			// not found ==> return null
			return null;
		}
	}
	
	/**
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

		// Check if the view is attached to the layer
		if( ! isLayerEnabledInternal() || ! getViews().contains(view)) {
			return null;
		}
	
		// the result list
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(properties.size());
		boolean isCmdFound = false;
		
		for( Property property : properties) {
			if( property != null) {
				// Add the cmd allowing to get the value of the Property
				// That is, the PropertyInstance itself
				try {
					resCmds.add( getPropertyInstance(property) );
					isCmdFound = true;
				} catch (NotFoundException e) {
					// not found ==> cmd = null
					resCmds.add(null);
				}
			}
			else {
				resCmds.add(null);
			}
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

		
		// If the layer is disabled, return a null command.
		if( ! isLayerEnabledInternal() ) {
			return null;
		}

		// Stop if the property is not attached to the layer
		TypeInstance value;
		try {
			value = getPropertyInstance(property);
		} catch (NotFoundException e1) {
			// the property is not set in this layer;
			return null;
		}
	
		// Now, compute the list of commands. One command for each view.
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(views.size());
		boolean isCmdFound = false;
		
		for( View view : views) {
			if( view != null && getViews().contains(view)) {
				isCmdFound = true;
				resCmds.add( value );
			}
			else {
				resCmds.add(null);
			}
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
	

} //AbstractLayerImpl
