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
package org.eclipse.papyrus.layers.runtime.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * This class listen to a {@link LayersModel} and send following events to listeners:
 * <ul>
 *   <li>root of type {@link LayersStackApplication} added</li>
 *   <li>root of type {@link LayersStackApplication}  removed</li>
 * </ul>
 * 
 * @author cedric dumoulin
 * TODO Rename to LayersStackApplicationLifeCycleEventNotifier
 */
public class LayersModelEventRootNotifier {

	protected LayersModel  layersModel;

	/**
	 * List of listener to notify.
	 */
	protected List<ILayersModelRootEventListener> listeners = new ArrayList<ILayersModelRootEventListener>();
	
	protected Adapter modelListener = new AdapterImpl() {
		
		/**
		 * Something happen on the tree of object
		 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 *
		 * @param msg
		 */
		public void notifyChanged(Notification notification) {
			
			
			// Check Resource modification
			// There is 1 sources: 
			// LayersModel::Resource::contents
			if( notification.getFeatureID(Resource.class) == Resource.RESOURCE__CONTENTS) {
				// LayerOperator::layers || LayersStack::layers
				// check the event type.
				switch(notification.getEventType()) {
				case Notification.SET:
						
					break;
				case Notification.ADD:
					// A root is added
					if( notification.getNewValue() instanceof LayersStackApplication ) {
						fireLayersModelRootAddedEvent(notification);
					}
					break;
				case Notification.REMOVE:
					// A root is removed
					if( notification.getOldValue() instanceof LayersStackApplication ) {
						fireLayersModelRootRemovedEvent(notification);
					}
					break;
				}
			}
		}
		
	};
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public LayersModelEventRootNotifier(LayersModel layersModel) {
		this.layersModel = layersModel;
		activate();
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		// Listen on diagram removed events
		layersModel.getResource().eAdapters().add(modelListener);
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		// Listen on diagram removed events
		layersModel.getResource().eAdapters().remove(modelListener);
	}
	
	/**
	 * Dispose the synchronizer
	 */
	public void dispose() {
		// Deactivate listeners
		deactivate();
		layersModel = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	protected boolean isDisposed() {
		return layersModel == null;
	}
	
	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addEventListener(ILayersModelRootEventListener listener) {
		
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
	public void removeEventListener(ILayersModelRootEventListener listener) {

		listeners.remove(listener);
	}
	
	/**
	 * Called by events when a root is added to the {@link LayersModel}
	 * @param msg
	 */
	protected void fireLayersModelRootAddedEvent(Notification msg) {
		for(ILayersModelRootEventListener listener : listeners) {
			listener.layersModelRootAdded(msg);
		}
	}

	/**
	 * Called by events when a root is added to the {@link LayersModel}
	 * @param msg
	 */
	protected void fireLayersModelRootRemovedEvent(Notification msg) {
		for(ILayersModelRootEventListener listener : listeners) {
			listener.layersModelRootRemoved(msg);
		}
	}
	
}
