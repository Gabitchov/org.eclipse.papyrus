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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.runtime.model.ILayersModelRootEventListener;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.runtime.model.LayersModelEventRootNotifier;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import static org.eclipse.papyrus.layers.runtime.Activator.log;


/**
 * 
 * Listen to:
 *   - LayerStack added
 *   - application added/removed in LayerModel
 *   
 * <br>
 * The class has an internal state machine with two states: ApplicationExist and NoApplication.
 * <br>
 * In the ApplicationExist state, the class listen to {@link LayersStack} added/removed and to the Diagrams deletion.
 * <br>
 * In the NoApplication state, the  class listen on the LayerModel to be informed when the application is created.
 * When application is created, we change the state to ApplicationExist.
 * 
 * There is an UML sm diagram of this in architecture.di.
 *   
 *   
 *   
 * @author cedric dumoulin
 *
 */
public class LayerStackApplicationSynchronizer implements ILayersModelRootEventListener, ILayersStackApplicationEventListener, INotationDiagramRemovedEventListener{

	/**
	 * States used in the state machine.
	 */
	protected enum State {NoApplication, ApplicationCreated, disposed};
	protected State state;
	
	protected LayersModel layersModel;
	protected NotationModel notationModel;
	
	/**
	 * All registered synchronizers.
	 */
	protected Map<Diagram, LayerStackSynchronizer> synchronizers = new HashMap<Diagram, LayerStackSynchronizer>();
	
	/**
	 * Notifier on Diagram removed event.
	 */
	protected NotationDiagramRemovedFromResourceEventNotifier notationDiagramRemovedNotifier;
	
	/**
	 * Notifier on LayerSTackApplication events
	 */
	protected LayersStackApplicationEventNotifier layersStackApplicationEventNotifier;
	
	/**
	 * Notifier on {@link LayersModel} events.
	 */
	protected LayersModelEventRootNotifier layersModelEventRootNotifier;

	/**
	 * Constructor.
	 *
	 */
	public LayerStackApplicationSynchronizer(LayersModel layersModel, NotationModel notationModel) {
		
		this.layersModel = layersModel;
		this.notationModel = notationModel;
		
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
		activateLayersModelAndDiagramDeletionNotifiers();
		activateLayersModelRootNotifier();
		createSynchronizerForExistingStacks();
		state = State.ApplicationCreated;
	}

	/**
	 * Initialize the class for the NoApplication state:
	 * - listen on LayersModel notifiers for application creation
	 */
	private void transitionNoApplicationToApplicationCreatedState() {
		activateLayersModelAndDiagramDeletionNotifiers();
		activateLayersModelRootNotifier();
		state = State.ApplicationCreated;
	}

	/**
	 * Initialize the class for the ApplicationCreated state:
	 * - listen on appropriate notifiers
	 * - check if some LayerStack are already there.
	 */
	private void transitionInitToNoApplicationState() {
		activateLayersModelRootNotifier();
		state = State.NoApplication;
	}

	/**
	 * Initialize the class for the ApplicationCreated state:
	 * - listen on appropriate notifiers
	 * - check if some LayerStack are already there.
	 */
	private void transitionApplicationCreatedToNoApplicationState() {
		deactivateLayersModelAndDiagramDeletionNotifiers();
		state = State.NoApplication;
	}

	/**
	 * Create synchronizer for already created stack.
	 * The application object must exist.
	 */
	private void createSynchronizerForExistingStacks() {

		LayersStackApplication application = layersModel.lookupLayerStackApplication();
		if(application == null) {
			// Application is not set, skip.
			return;
		}
		
		for( LayersStack stack : application.getLayersStacks()) {
			if( stack.getDiagram() != null) {
			  addLayerStackSynchronizer(stack);
			}
		}
		
	}



	/**
	 * @return the synchronizers
	 */
	public Map<Diagram, LayerStackSynchronizer> getSynchronizers() {
		return synchronizers;
	}


	/**
	 * @return the layersModel
	 */
	public LayersModel getLayersModel() {
		return layersModel;
	}

	
	/**
	 * @return the notationModel
	 */
	public NotationModel getNotationModel() {
		return notationModel;
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		initState();		
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	private void activateLayersModelRootNotifier() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		
		layersModelEventRootNotifier = new LayersModelEventRootNotifier(layersModel);
		layersModelEventRootNotifier.addEventListener(this);	
	}


	/**
	 * Activate the listeners.
	 * 
	 */
	private void deactivateLayersModelRootNotifier() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		if( layersModelEventRootNotifier != null ) {
			layersModelEventRootNotifier.removeEventListener(this);
			layersModelEventRootNotifier = null;	
		}
	}

	/**
	 * Deactivate the listeners.
	 * 
	 */
	private void activateLayersModelAndDiagramDeletionNotifiers() {
		/** 
		 * Listen on layersModel to be inform when the application object is created.
		 * When it is created, we can listen on it.
		 */
		notationDiagramRemovedNotifier = new NotationDiagramRemovedFromResourceEventNotifier(notationModel);
		notationDiagramRemovedNotifier.addLayersModelEventListener(this);
		
		layersStackApplicationEventNotifier = new LayersStackApplicationEventNotifier(layersModel);
		layersStackApplicationEventNotifier.addLayersModelEventListener(this);	
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivateLayersModelAndDiagramDeletionNotifiers() {
		if( notationDiagramRemovedNotifier != null) {
			notationDiagramRemovedNotifier.removeLayersModelEventListener(this);
			notationDiagramRemovedNotifier = null;
		}

		if(layersStackApplicationEventNotifier!=null) {
			layersStackApplicationEventNotifier.removeLayersModelEventListener(this);
			layersStackApplicationEventNotifier = null;
		}
	}
	
	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		deactivateLayersModelAndDiagramDeletionNotifiers();
		deactivateLayersModelRootNotifier();
	}
	
	/**
	 * Dispose the synchronizer
	 */
	public void dispose() {
		// Deactivate listeners
		deactivate();
		layersModel = null;
		notationModel = null;
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
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	public void layerStackAdded(Notification msg) {
		
		if(log.isDebugEnabled()) {
			log.debug("LayerStackApplicationSynchronizer.layerStackAdded : " + msg.getNewValue());
		}
		
		// Find the LayerStack
		LayersStack stack = LayersStackApplicationEventNotifier.getAddedLayerStack(msg);
		
		addLayerStackSynchronizer(stack);
	}


	/**
	 * Create and add a {@link LayerStackSynchronizer} for the stack.
	 * Do nothing if the stack has already a synchronizer.
	 * 
	 * @param stack
	 */
	private void addLayerStackSynchronizer(LayersStack stack) {
		// Check if already exist
		if( lookupLayersStackSynchronizer(stack.getDiagram()) != null) {
			return;
		}
		
		// Create a new synchronizer
		LayerStackSynchronizer layerStackSynchronizer = new LayerStackSynchronizer(stack);
		putLayersStackSynchronizer(layerStackSynchronizer);
	}
	
	/**
	 * Lookup a {@link LayerStackSynchronizer} by its diagram.
	 * @param diagram
	 * @return
	 */
	protected LayerStackSynchronizer lookupLayersStackSynchronizer(Diagram diagram) {
		return synchronizers.get(diagram);
	}

	/**
	 * Lookup a {@link LayerStackSynchronizer} by its diagram.
	 * @param diagram
	 * @return
	 */
	protected  void putLayersStackSynchronizer(LayerStackSynchronizer layerStackSynchronizer) {
		
		synchronizers.put(layerStackSynchronizer.getDiagram(), layerStackSynchronizer);
	}


	/**
	 * Called by events when a {@link LayersStack} is removed from the {@link LayersStackApplication}
	 * @param msg
	 */
	public void layerStackRemoved(Notification msg) {
		if(log.isDebugEnabled()) {
			log.debug("LayerStack is removed" + msg.getOldValue());
		}
		
		// Find the LayerStack
		LayersStack stack = LayersStackApplicationEventNotifier.getRemovedLayerStack(msg);
		
		LayerStackSynchronizer synchronizer = synchronizers.remove(stack.getDiagram());
		synchronizer.dispose();
		
		// Also remove from application
		
	}
	
	/**
	 * Called by events when a {@link Diagram} is removed from the {@link NotationModel}
	 * @param msg
	 */
	public void diagramRemoved(Notification msg) {
		
		if(log.isDebugEnabled()) {
			log.debug(this.getClass().getSimpleName() + ".diagramRemoved() - " + msg.getOldValue());
		}
		
		if( state != State.ApplicationCreated) {
			return;
		}
		
		// Find the diagram
		Diagram diagram = NotationDiagramRemovedFromResourceEventNotifier.getRemovedDiagram(msg);

		// Remove from application
		// This should in turn remove the LayerStackSynchronizer from
		// this class (LayerStackApplicationSynchronizer).
		getLayersModel().lookupLayerStackApplication().removeLayersStackFor(diagram);

		// check if really removed from this object
		LayerStackSynchronizer synchronizer = synchronizers.remove(diagram);
		if( synchronizer != null ) {
			// Should not happen
			log.info(this.getClass().getSimpleName() + ".diagramRemoved() - synchronizer not completly cleaned. Finish the job.");
			synchronizer.dispose();
		}
	}


	@Override
	public void layersModelRootAdded(Notification msg) {
		if( state == State.NoApplication) {
			transitionNoApplicationToApplicationCreatedState();
		}
		
	}


	@Override
	public void layersModelRootRemoved(Notification msg) {
		if( state == State.ApplicationCreated) {
			transitionApplicationCreatedToNoApplicationState();
		}
	}
}
