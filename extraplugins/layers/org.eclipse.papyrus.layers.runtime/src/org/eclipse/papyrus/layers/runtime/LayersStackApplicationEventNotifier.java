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
package org.eclipse.papyrus.layers.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * This class listen to a {@link LayersStackApplication} and send following to listeners:
 * <ul>
 *   <li>LayerStack added</li>
 *   <li>LayerStack removed</li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class LayersStackApplicationEventNotifier {

	protected LayersModel layersModel;

	/**
	 * List of listener to notify.
	 */
	protected List<ILayersStackApplicationEventListener> listeners = new ArrayList<ILayersStackApplicationEventListener>();
	
	/**
	 * listener on LayerStack events
	 */
	protected Adapter layerStackListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			
			switch(msg.getFeatureID(LayersStackApplication.class)) {
			  case LayersPackage.LAYERS_STACK_APPLICATION__LAYERS_STACKS :
				  switch(msg.getEventType()) {
					case Notification.ADD:
						// a layerStack is added to application
						// layerStack = msg.getNewValue()
						layerStackAdded(msg);
						break;

					case Notification.REMOVE:
						// a layerStack is removed from application
						// layerStack = msg.getOldValue()
						layerStackRemoved(msg);
						break;

					default:
						break;
				  }
				  break;
			};
		};
	};
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public LayersStackApplicationEventNotifier(LayersModel layersModel) {
		this.layersModel = layersModel;
		activate();
	}

	/**
	 * Constructor.
	 *
	 * @param layersModel
	 * @param activate True if the notifier should be activated immediately. False otherwise.
	 */
	public LayersStackApplicationEventNotifier(LayersModel layersModel, boolean activate) {
		this.layersModel = layersModel;
		if( activate) {
		  activate();
		}
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		// Listen on LayerStackApplication for LayerStack creation
		// TODO Avoid to create the application here. Listen on its creation
		// and listen on it when created.
		
		LayersStackApplication application = layersModel.getLayerStackApplication();
		
		application.eAdapters().add( layerStackListener );
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		LayersStackApplication application = layersModel.getLayerStackApplication();
		
		application.eAdapters().remove( layerStackListener );
		
	}
	
	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
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
	public void addLayersModelEventListener(ILayersStackApplicationEventListener listener) {
		
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
	public void removeLayersModelEventListener(ILayersStackApplicationEventListener listener) {

		listeners.remove(listener);
	}
	
	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	protected void layerStackAdded(Notification msg) {
		for(ILayersStackApplicationEventListener listener : listeners) {
			listener.layerStackAdded(msg);
		}
	}
	
	/**
	 * Called by events when a {@link LayersStack} is removed from the {@link LayersStackApplication}
	 * @param msg
	 */
	protected void layerStackRemoved(Notification msg) {
		for(ILayersStackApplicationEventListener listener : listeners) {
			listener.layerStackRemoved(msg);
		}
	}

	/**
	 * Utility method returning the layer stack in case of addedLayer event.
	 * @param msg
	 * @return
	 */
	public static LayersStack getAddedLayerStack(Notification msg) {
		return (LayersStack)msg.getNewValue();
	}
	
	/**
	 * Utility method returning the layer stack in case of removeLayer event.
	 * @param msg
	 * @return
	 */
	public static LayersStack getRemovedLayerStack(Notification msg) {
		return (LayersStack)msg.getOldValue();
	}
	

}
