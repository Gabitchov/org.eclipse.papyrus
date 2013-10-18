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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.runtime.model.ILayersModelRootEventListener;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.runtime.model.LayersModelEventRootNotifier;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * This class is used to notify listeners of events on the LayerStack life cycle.
 * The class require the {@link LayersModel} to register itself to appropriate objects.
 * The class take care to check if the {@link LayersStackApplication} exist or not.
 * So, it can be used in all cases, even if the {@link LayersStackApplication} is not
 * created.
 * 
 * The following events are fired:
 * <ul>
 *   <li>LayerStack added</li>
 *   <li>LayerStack removed</li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class LayersStackAndApplicationLifeCycleEventNotifier {

	/**
	 * States used in the state machine.
	 */
	protected enum State {NoApplication, ApplicationCreated, disposed};
	protected State state;
	
	protected LayersModel layersModel;

	/**
	 * Notifier on {@link LayersStack} life cycle events
	 */
	protected LayersStackApplicationEventNotifier layersStackApplicationEventNotifier;
	
	/**
	 * Notifier on {@link LayersStackApplication} life cycle events.
	 */
	protected LayersModelEventRootNotifier layersModelEventRootNotifier;

	/**
	 * Listener on {@link LayersStackApplication} life cycle events
	 */
	protected ILayersModelRootEventListener layersStackApplicationLifeCycleEventListener = new ILayersModelRootEventListener() {
		
		@Override
		public void layersModelRootRemoved(Notification msg) {
			if( state == State.ApplicationCreated) {
				transitionApplicationCreatedToNoApplicationState();
			}
		}
		
		@Override
		public void layersModelRootAdded(Notification msg) {
			if( state == State.NoApplication) {
				transitionNoApplicationToApplicationCreatedState();
			}
		}
	};
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public LayersStackAndApplicationLifeCycleEventNotifier(LayersModel layersModel) {
		this.layersModel = layersModel;
		createListeners();
		initState();
	}

	/**
	 * Init the state of the object
	 */
	private void initState() {
		
		if( layersModel.lookupLayerStackApplication() != null) {
			transitionInitToApplicationCreatedState();
		}
		else {
			transitionInitToNoApplicationState();
		}
	}
	
	/**
	 * Initialize the class for the NoApplication state:
	 * - listen on LayersModel notifiers for application creation
	 */
	private void transitionInitToApplicationCreatedState() {
		activateLayersStackLifeCycleEventNotifier();
		state = State.ApplicationCreated;
	}

	/**
	 * Initialize the class for the ApplicationCreated state:
	 * - listen on appropriate notifiers
	 * - check if some LayerStack are already there.
	 */
	private void transitionInitToNoApplicationState() {
		state = State.NoApplication;
	}

	/**
	 * Initialize the class for the NoApplication state:
	 * - listen on LayersModel notifiers for application creation
	 */
	private void transitionNoApplicationToApplicationCreatedState() {
		activateLayersStackLifeCycleEventNotifier();
		state = State.ApplicationCreated;
	}

	/**
	 * Initialize the class for the ApplicationCreated state:
	 * - listen on appropriate notifiers
	 * - check if some LayerStack are already there.
	 */
	private void transitionApplicationCreatedToNoApplicationState() {
		deactivateLayersStackLifeCycleEventNotifier();
		state = State.NoApplication;
	}


	/**
	 * Activate the notifier.
	 * 
	 */
	protected void activate() {
		createListeners();		
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		deleteListeners();
	}
	
	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
		// Deactivate listeners
		deleteListeners();
		layersModel = null;
		state = State.disposed;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	protected boolean isDisposed() {
		return state == State.disposed;
	}
	
	/**
	 * Activate the notifier.
	 */
	private void activateLayersStackLifeCycleEventNotifier() {
		layersStackApplicationEventNotifier.activate();
		
	}

	/**
	 * Deactivate the notifier.
	 */
	private void deactivateLayersStackLifeCycleEventNotifier() {
		layersStackApplicationEventNotifier.deactivate();
		
	}


	/**
	 * Create and activate internal listeners
	 */
	private void createListeners() {
		createLayersModelAndDiagramDeletionNotifiers();
		createLayersModelRootNotifier();
	}

	/**
	 * Deactivate internal listeners
	 */
	private void deleteListeners() {
		deleteLayersModelAndDiagramDeletionNotifiers();
		deleteLayersModelRootNotifier();
	}
	
	/**
	 * Activate the listeners.
	 * 
	 */
	private void createLayersModelRootNotifier() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		
		layersModelEventRootNotifier = new LayersModelEventRootNotifier(layersModel);
		layersModelEventRootNotifier.addEventListener(layersStackApplicationLifeCycleEventListener);	
	}


	/**
	 * Deactivate the listeners.
	 * 
	 */
	private void deleteLayersModelRootNotifier() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		if( layersModelEventRootNotifier != null ) {
			layersModelEventRootNotifier.removeEventListener(layersStackApplicationLifeCycleEventListener);
			layersModelEventRootNotifier.dispose();
			layersModelEventRootNotifier = null;	
		}
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	private void createLayersModelAndDiagramDeletionNotifiers() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		layersStackApplicationEventNotifier = new LayersStackApplicationEventNotifier(layersModel, false);
//		layersStackApplicationEventNotifier.addLayersModelEventListener(layersStackLifeCycleEventListener);	
	}

	/**
	 * Deactivate listeners
	 */
	protected void deleteLayersModelAndDiagramDeletionNotifiers() {
		if(layersStackApplicationEventNotifier!=null) {
//			layersStackApplicationEventNotifier.removeLayersModelEventListener(layersStackLifeCycleEventListener);
			layersStackApplicationEventNotifier.dispose();
			layersStackApplicationEventNotifier = null;
		}
	}
	

	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addLayersModelEventListener(ILayersStackApplicationEventListener listener) {
		// Add to the inner notifier
		layersStackApplicationEventNotifier.addLayersModelEventListener(listener);
	}
	
	/** 
	 * Remove the specified listener from the list of listeners.
	 * @param listener
	 */
	public void removeLayersModelEventListener(ILayersStackApplicationEventListener listener) {

		layersStackApplicationEventNotifier.removeLayersModelEventListener(listener);
	}
	
	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addLayersStackApplicationLifeCycleEventListener(ILayersModelRootEventListener listener) {
		// Add to the inner notifier
		layersModelEventRootNotifier.addEventListener(listener);
	}
	
	/** 
	 * Remove the specified listener from the list of listeners.
	 * @param listener
	 */
	public void removeLayersStackApplicationLifeCycleEventListener(ILayersModelRootEventListener listener) {

		layersModelEventRootNotifier.removeEventListener(listener);
	}
	

}
