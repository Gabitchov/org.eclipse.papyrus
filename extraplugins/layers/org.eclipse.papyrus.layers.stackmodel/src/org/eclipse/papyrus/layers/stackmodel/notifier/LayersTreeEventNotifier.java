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
package org.eclipse.papyrus.layers.stackmodel.notifier;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;


/**
 * Notifier/observers firing events concerning the structure of the tree of layers.
 * Obeserver should implements {@link ILayersTreeEventListener} and register themself to this
 * notifier.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class LayersTreeEventNotifier extends EContentAdapter {

	/**
	 * List of listener to notify.
	 */
	protected List<ILayersTreeEventListener> listeners = new ArrayList<ILayersTreeEventListener>();
	
	/**
	 * Constructor.
	 *
	 * @param layersStack The observed {@link LayersStack}.
	 */
	public LayersTreeEventNotifier() {
	}

	/**
	 * Dispose this object.
	 */
	public void dispose() {
		if(isDisposed()) {
			return;
		}
		listeners.clear();
		listeners = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	public boolean isDisposed() {
		return listeners==null;
	}

	/**
	 * Called when something happen on the tree.
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
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
	}
	
	/**
	 * This Adapter is for {@link LayersTreeEventNotifier}.
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 *
	 * @param type
	 * @return
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == LayersTreeEventNotifier.class;
	}
	
	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addLayersModelEventListener(ILayersTreeEventListener listener) {
		
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
	public void removeLayersModelEventListener(ILayersTreeEventListener listener) {

		listeners.remove(listener);
	}
	
	/**
	 * Method called when a layer is added to one layer.
	 * The event contains: the layer.
	 * 
	 * @param notification
	 */
	public void fireLayerSet( Notification notification ) {
		
		for(ILayersTreeEventListener listener : listeners) {
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
		
		for(ILayersTreeEventListener listener : listeners) {
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
		
		for(ILayersTreeEventListener listener : listeners) {
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
		
		for(ILayersTreeEventListener listener : listeners) {
			listener.layerMoved(notification);
		}
	}
	
}
