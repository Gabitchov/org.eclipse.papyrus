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
package org.eclipse.papyrus.layers.stackmodel.layers.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;


/**
 * An EMF {@link EObjectResolvingEList} that automaticaly reflect a
 * Map of (String, T). The keys are the names of the Property.
 * The list also know the list of Properties, and use it to indexing
 * the types of the Map.
 * <br>
 * usage:
 * <br>
 * list = new PropertyIndexedList<type>(...);
 * list.setPropertyList( propertyRegistry.getProperties() );
 * 
 * @author cedric dumoulin
 *
 * @param <T> The type of the objects contained in the list. The type should be 
 * the same as the type of the values in the backuped Map.
 */
public class PropertyIndexedList<T> extends EObjectResolvingEList<T> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The backuped Map. The implementation should be an Observable Map from EMF.
	 * 
	 */
	protected EMap<String, T> map;
	
	/**
	 * The ordered list of Property, used to indexing this List.
	 * The Property::index should be set.
	 */
	protected List<Property> propertyList;
	
	/**
	 * The classtype of the owner of the map
	 */
	protected Class<?> mapParentClasstype;
	
	/**
	 * The id of the map property in its parent.
	 */
	final protected int MAP_FEATURE_ID;
	
	/**
	 * The value that is used as a "null value".
	 * We can't use 'null' because the list don't support it (even
	 * if we set canSupportNull to true).
	 */
	final protected T NULL_VALUE;
	
	/**
	 * Constructor.
	 *
	 * @param dataClass Type of the element of the list
	 * @param layer The owner of this list and of the map
	 * @param featureID The feature Id of this list in the owner
	 * 
	 * @param mapFeatureID The map feature id in the owner
	 */
	public PropertyIndexedList(EMap<String, T> map, Class<T> dataClass, InternalEObject layer, int featureID, int mapFeatureID, T nullValue) {
		super(dataClass, layer, featureID);
		MAP_FEATURE_ID = mapFeatureID;
		NULL_VALUE = nullValue;
		mapParentClasstype = layer.getClass();
		this.map= map; 
		init();
	}

	/**
	 * Constructor.
	 *
	 * @param dataClass Type of the element of the list
	 * @param layer The owner of this list and of the map
	 * @param featureID The feature Id of this list in the owner
	 * 
	 * @param mapFeatureID The map feature id in the owner
	 */
	public PropertyIndexedList(Map<String, T> map, Class<T> dataClass, InternalEObject layer, int featureID, int mapFeatureID, T nullValue) {
		super(dataClass, layer, featureID);
		MAP_FEATURE_ID = mapFeatureID;
		NULL_VALUE = nullValue;
		mapParentClasstype = layer.getClass();
		this.map= (EMap<String, T>)map; 
		init();
	}

	/**
	 * Listen on the map for addition/deletion.
	 * 
	 */	
	protected void init() {
		getEObject().eAdapters().add(new PropertyValuesSynchronizer());
		
	}

	/**
	 * Allows double
	 * @see org.eclipse.emf.ecore.util.EObjectEList#isUnique()
	 *
	 * @return
	 */
	// 
	protected boolean isUnique() {
		return false;
	}

	/**
	 * Allow null values in the list.
	 * @see org.eclipse.emf.ecore.util.EObjectEList#canContainNull()
	 *
	 * @return
	 */
//	@Override
//	protected boolean canContainNull() {
//		return true;
//	}
	
	
	/**
	 * @param propertyList the propertyList to set
	 */
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
		try {
			resetListElements();
		} catch (BadStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reset the elements of the list, according to the map and the 
	 * propertyList.
	 * @throws BadStateException 
	 * 
	 */
	private void resetListElements() throws BadStateException {
		// Reset list
		this.clear();

		// Check application
		if(propertyList== null) {
			// do not synchronize the list
			return;
//			throw new BadStateException("Property 'application' must be set for resetAllPropertyValuesFromRegistry() to work.");
		}
		
		List<Property> availableProperties;
		int size;
		try {
			availableProperties = propertyList;
			size = availableProperties.size();
		} catch (NullPointerException e) {
			throw new BadStateException("Property 'application.propertyRegistry' must be set for resetAllPropertyValuesFromRegistry() to work.");
		}
		
		// initialize the list
		for(int i=0;i<size;i++) {
			String propertyName = availableProperties.get(i).getName();
			// Add the value, or null if not found. This ensure
			// That the list will have the correct size.
			T value = map.get(propertyName);
			if( value == null ) {
				value = NULL_VALUE;
			} 
			this.add( value);
		}
	}

	/**
	 * Get an element by its property.
	 * @param property
	 * @return
	 * @throws NotFoundException If the index of the property is not found.
	 */
	public T get(Property property) throws NotFoundException {
		try {
			return get( property.getIndex());
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Can't get element for Property '" + property.getName()
					+ "'. ", e);
		}
	}
	
	/**
	 * Set the element for the specified Property.
	 * @param property
	 * @param ele
	 * @throws BadStateException When the associated map is not set.
	 */
	public void set( Property property, T value ) throws BadStateException {
		if( map == null) {
			throw new BadStateException("Can't set element for Property '" + property.getName()
					+ "'. The associated map should be set first");
			
		}
		
		// Set the element in the map
		map.put(property.getName(), value);
	}
	
	/**
	 * Synchronize the specified propertyName with the value in the {@link #propertyValues} list.
	 * @param propertyName
	 * @param value
	 * @throws NotFoundException 
	 */
	protected void synchronizePropertyValue(String propertyName, T value) throws BadStateException, NotFoundException {
		
		if( propertyList == null) {
			//silently fail
			return;
		}
		
		try {
			int propertyIndex = getPropertyIndex(propertyName);
			set(propertyIndex, value);
		} catch (NullPointerException e) {
			throw new BadStateException("propertyList should be set first.");
		}
	}
	

	/**
	 * Get a Property by its name.
	 * Lookup in the {@link #propertyList} property.
	 * 
	 * @param propertyName
	 * @return
	 * @throws NotFoundException
	 */
	protected int getPropertyIndex( String propertyName) throws NotFoundException {
		
		if(propertyName == null) {
			throw new NotFoundException("Null name not Allowed");
		}
		for( int i=0; i<propertyList.size(); i++) {
			if( propertyName.equals(propertyList.get(i).getName() ) ) {
				return i;
			}
		}
		
		// Not found
		throw new NotFoundException("No property found under name '" + propertyName + "'");

		
	}
	/**
	 * This class listen to #propertyValueMap, and synchronize propertyValues accordingly.
	 * 
	 * This adapter listen on the map's parent to know if a Property key is
	 * added or removed.
	 * 
	 */
	public class PropertyValuesSynchronizer extends AdapterImpl {
		
		
		@Override
		public void notifyChanged(Notification msg) {
			System.err.println("event " + msg.getEventType());
			
		
			// Check if the notification comes from the map
			if( msg.getFeatureID(mapParentClasstype) ==  MAP_FEATURE_ID) {
				notifyLayerPropertyValueMapChanged(msg);
			}
		}
		
		/**
		 * The {@link PropertyIndexedList#map} has changed. Synchronize this list.
		 * @param msg
		 */
		protected void notifyLayerPropertyValueMapChanged(Notification msg) {
			System.err.println("map changed " + msg.getEventType());
			switch(msg.getEventType()) {
			case Notification.SET:	
			{
				// A key is modified
				// Add the value to other list
				@SuppressWarnings("unchecked")
				Map.Entry<String, T> entry = (Map.Entry<String, T>)msg.getNewValue();
				System.out.println("SET - newValue=" + entry.getValue()
						 + ", key=" + entry.getKey());
				
//				String newKey = (String)msg.getNewValue();
				T value = entry.getValue();
				if( value != null) {
					try {
						synchronizePropertyValue(entry.getKey(), value);
//						synchronizePropertyValue(newKey, value);
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
				@SuppressWarnings("unchecked")
				Map.Entry<String, T> entry = (Map.Entry<String, T>)msg.getNewValue();
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
				@SuppressWarnings("unchecked")
				Map.Entry<String, T> entry = (Map.Entry<String, T>)msg.getNewValue();
				System.out.println("REMOVE" + entry.getValue()
						 + ", key=" + entry.getKey());
				// Add the corresponding instance to propertyValues
				try {
					synchronizePropertyValue(entry.getKey(), NULL_VALUE);
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
	
	}

}
