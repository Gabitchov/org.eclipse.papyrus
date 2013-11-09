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
package org.eclipse.papyrus.layers.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.impl.StringToTypeInstanceMapImpl;
import org.eclipse.papyrus.layers.stackmodel.layers.util.ECoreUtils;


/**
 * This class listen to a {@link LayersStack} and send event to listeners.
 * 
 * @author cedric dumoulin
 *
 */
public class LayersModelEventNotifier {

	/**
	 * The observed {@link LayersStack}.
	 */
	protected LayersStack layersStack;
	
	/**
	 * List of listener to notify.
	 */
	protected List<ILayersModelEventListener> listeners = new ArrayList<ILayersModelEventListener>();
	
	/**
	 * listener on layers changes.
	 * 
	 */
	protected Adapter layersListener = new EContentAdapter() {
		
		@Override
		public void notifyChanged(Notification notification) {
			System.err.println( this.getClass().getSimpleName() + ".event received " + notification.getFeature());
			// Self atttach
			super.notifyChanged(notification);
			
			// Check layers modification
			// There is two sources: LayerOperator::layers and LayersStack::layers
			if( notification.getFeature() == LayersPackage.eINSTANCE.getLayerOperator_Layers() 
					|| notification.getFeature() == LayersPackage.eINSTANCE.getLayersStack_Layers() ) {
				// LayerOperator::layers || LayersStack::layers
				// check the event type.
				switch(notification.getEventType()) {
				case Notification.SET:
						fireLayerSet(notification);
					break;
				case Notification.ADD:
					// A layer is added
					fireLayerAdded(notification);
					break;
				case Notification.REMOVE:
					// A layer is removed
					fireLayerRemoved(notification);
					break;
				case Notification.MOVE:
					// A layer is moved
					fireLayerMoved(notification);
					break;
				}
			} 
			// Check view event
			// View event can by fired by: AbstractLayer::views 
			else if (notification.getFeature() == LayersPackage.eINSTANCE.getAbstractLayer_Views() ) {

				// check the event type.
				switch(notification.getEventType()) {
				case Notification.ADD:
					// A layer is added
					// the concerned view
//					View view = (View)notification.getNewValue();
//					AbstractLayer layer = (AbstractLayer)notification.getNotifier()
							
					fireViewAddedToLayer(notification);
					break;
				case Notification.REMOVE:
					// A layer is removed
					// the concerned view
//					View view = (View)notification.getOldValue();
//					AbstractLayer layer = (AbstractLayer)notification.getNotifier()

					fireViewRemovedFromLayer(notification);
					break;
				}
				
			}
			// Check instance addition/deletion
			// instance event can by fired by: AbstractLayer::propertyValuesMap 
			else if (notification.getFeature() == LayersPackage.eINSTANCE.getAbstractLayer_PropertyValueMap() ) {
				// check the event type.
				switch(notification.getEventType()) {
//				case Notification.SET:	
//				{
//					// A key is added
//					break;
//				}
//				case Notification.UNSET:	
//					// A key is added
//					break;
				case Notification.ADD:	
				{
					// An entry is added
					StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)notification.getNewValue();
//					System.out.println("ADD" + entry.getValue()
//							 + ", key=" + entry.getKey());
					// Add the corresponding instance to propertyValues
					//Layer layer = (Layer)notification.getNotifier();
					//String propertyName = entry.getKey();
					//TypeInstance propertyValue = (TypeInstance)entry.getValue();
					firePropertyValueAddedEvent(notification);
					break;
				}
				case Notification.REMOVE:	
				{
					// An entry is removed
					StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)notification.getOldValue();
//					System.out.println("REMOVE" + entry.getValue()
//							 + ", key=" + entry.getKey());
					// Add the corresponding instance to propertyValues
					//Layer layer = (Layer)notification.getNotifier();
					//String propertyName = entry.getKey();
					//TypeInstance propertyValue = (TypeInstance)entry.getValue();
					firePropertyValueRemoved(notification);
					break;
				}
				default:
					break;
				}
				
			}
			// Check if the isLayerEnabled is modified
			// sources: LayerExpression::IsLayerEnabled
			else if(notification.getFeature() == LayersPackage.eINSTANCE.getLayerExpression_IsLayerEnabled() ) {
				firePropertyValueChanged(notification);
			}
			
			// Check property instance modification event
			// instance change event can by fired by: any modification in a subclass of TypeInstance 
			else {
				try {
					// Lookup if the event comes from a type instance
					TypeInstance ancestor = (TypeInstance)ECoreUtils.lookupAncestorOfType((EObject)notification.getNotifier(), LayersPackage.eINSTANCE.getTypeInstance());
					// originating layer
					AbstractLayer layer = (AbstractLayer)ECoreUtils.lookupAncestorOfType((EObject)notification.getNotifier(), LayersPackage.eINSTANCE.getAbstractLayer());
					// or: layer = (AbstractLayer)ancestor.eContainer().eContainer().eContainer();
					// StringToTypeInstanceMapImpl entry = (StringToTypeInstanceMapImpl)ancestor.eContainer();
					//String propertyName = entry.getKey();
					//TypeInstance propertyValue = (TypeInstance)entry.getValue();
					//					
//					String propertyName
					// check the event type.
					switch(notification.getEventType()) {
					case Notification.SET:
						// An instance value is set
						firePropertyValueChanged(notification);
						break;
					case Notification.ADD:
						// An instance value is set
						firePropertyValueChanged(notification);
						break;
					case Notification.REMOVE:
						// An instance value is set
						firePropertyValueChanged(notification);
						break;
					}
				} catch (NotFoundException e) {
					// lookupAncestorOfType() found nothing
					// silently fail
				}
				

				
			}
			
		}
	};
	
	/**
	 * Constructor.
	 *
	 * @param layersStack The observed {@link LayersStack}.
	 */
	public LayersModelEventNotifier(LayersStack layersStack) {
		this.layersStack = layersStack;
		activate();
	}

	/**
	 * setup the listeners.
	 */
	protected void activate() {
		layersStack.eAdapters().add(layersListener);
		
	}

	/**
	 * remove the listeners.
	 */
	protected void deactivate() {
		layersStack.eAdapters().remove(layersListener);
		
	}

	/**
	 * Dispose this object.
	 */
	public void dispose() {
		
		deactivate();
		listeners.clear();
		layersListener = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	public boolean isDisposed() {
		return layersListener==null;
	}

	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addLayersModelEventListener(ILayersModelEventListener listener) {
		
		if(listener == null ) {
			return;
		}
		
		// Check if exist
		if( listeners.contains(listener)) {
			return;
		}
		
		listeners.add(listener);
	}
	
	/** 
	 * Remove the specified listener from the list of listeners.
	 * @param listener
	 */
	public void removeLayersModelEventListener(ILayersModelEventListener listener) {

		listeners.remove(listener);
	}
	/**
	 * Method called when a value is added to one layer.
	 * The vent contains: the layer, the property name, the new value.
	 * 
	 * @param notification
	 */
	public void firePropertyValueAddedEvent( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.propertyValueAdded(notification);
		}
	}
	
	/**
	 * Method called when a value is removed from one layer.
	 * The vent contains: the layer, the property name, the new value.
	 * 
	 * @param notification
	 */
	public void firePropertyValueRemoved( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.propertyValueRemoved(notification);
		}
	}
	
	/**
	 * Method called when a value is changed in one layer.
	 * The vent contains: the layer, the property name, the new value.
	 * 
	 * @param notification
	 */
	public void firePropertyValueChanged( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.propertyValueChanged(notification);
		}
	}
	
	/**
	 * Method called when a layer is added to one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void fireLayerSet( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.layerSet(notification);
		}
	}
	
	/**
	 * Method called when a layer is added to one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void fireLayerAdded( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.layerAdded(notification);
		}
	}
	
	/**
	 * Method called when a layer is removed from one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void fireLayerRemoved( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.layerRemoved(notification);
		}
	}
	
	/**
	 * Method called when a layer is moved in LayerStack.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void fireLayerMoved( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.layerMoved(notification);
		}
	}
	

	/**
	 * Method called when a view is added to one layer.
	 * The event contains: the layer, the view.
	 * 
	 * @param notification
	 */
	public void fireViewAddedToLayer( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.viewAddedToLayer(notification);
		}
	}
	
	/**
	 * Method called when a view is removed from one layer.
	 * The event contains: the layer, the view.
	 * 
	 * @param notification
	 */
	public void fireViewRemovedFromLayer( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.viewRemovedFromLayer(notification);
		}
	}
	
	/**
	 * Method called when a view is moved from one layer to another layer.
	 * The event contains: the layer, the view.
	 * 
	 * @param notification
	 */
	public void fireViewMovedBetweenLayer( Notification notification ) {
		
		for(ILayersModelEventListener listener : listeners) {
			listener.viewMovedBetweenLayer(notification);
		}
	}

}
