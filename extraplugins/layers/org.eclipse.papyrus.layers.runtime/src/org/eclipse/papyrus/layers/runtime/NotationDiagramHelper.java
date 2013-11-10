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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * This class manage a notation.Diagram. It allows to :
 * <ul>
 * <li>Add or remove a LayersStack</li>
 * <li>get the LayersStackMngr if a LayersStack exist.</li>
 * </ul>
 * 
 * @author Cedric dumoulin
 * 
 */
public class NotationDiagramHelper {

	/**
	 * Associated Diagram.
	 */
	protected Diagram diagram;
	
	/**
	 * Layers model.
	 */
	protected LayersModel layersModel;
	
	protected LayersStackApplication layersApplication;

//	/**
//	 * The associated {@link LayersStackMngr}. Maybe null if no LayersStack is associated.
//	 */
//	protected LayersStackMngr layerStackMngr;
//
//	/**
//	 * Notifier sending event when the layerStack is added or removed.
//	 */
//	private LayersStackAttachedNotifier layerStackAttachedNotifier;

//	/**
//	 * Listen on events from the layerStackAttachedNotifier.
//	 */
//	private LayersStackAttachedListener layerStackAttachedListener = new LayersStackAttachedListener() {
//
//		public void layerStackRemoved(LayersStackAttachedEvent event) {
//			layerStackMngr.dispose();
//			layerStackMngr = null;
//		}
//
//		public void layerStackAttached(LayersStackAttachedEvent event) {
//
//			if(layerStackMngr != null)
//			{
//				layerStackMngr.dispose();
//				layerStackMngr = null;
//			}
//
//			layerStackMngr = new LayersStackMngr(event.getLayersStack());
//		}
//
//		public void diagramChanged(LayersStackAttachedEvent event) {
//			// Not used because diagram is never set.
//			if(layerStackMngr != null)
//			{
//				layerStackMngr.dispose();
//				layerStackMngr = null;
//			}
//
//			layerStackMngr = new LayersStackMngr(event.getLayersStack());
//
//		}
//	};

	/**
	 * Constructor.
	 * Construct the manager and initialize it.
	 * @param layersModel 
	 * 
	 */
	public NotationDiagramHelper(LayersModel layersModel, Diagram diagram) {
		this.diagram = diagram;
		this.layersModel = layersModel;

//		// Set the layerStackMngr if necessary
//		LayersStack layerStack = LayersStackUtil.getInstance().lookupLayersStack(diagram);
//		if(layerStack != null) {
//			layerStackMngr = new LayersStackMngr(layerStack);
//		}
//
//		// Set the listeners on changes
//		layerStackAttachedNotifier = new LayersStackAttachedNotifier(diagram);
//		layerStackAttachedNotifier.addLayersStackAttachedEventListener(layerStackAttachedListener);

		activate();
	}

	/**
	 * Activate the manager.
	 */
	public void activate() {
//		layerStackAttachedNotifier.activate();
	}

	/**
	 * Deactivate the manager.
	 */
	public void deactivate() {
//		layerStackAttachedNotifier.deactivate();
	}

	/**
	 * Dispose all resources.
	 */
	public void dispose() {
//		layerStackAttachedNotifier.deactivate();

		diagram = null;
	}

	
	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	
//	/**
//	 * Return the {@link LayersStackMngr} if any. Throw an 
//	 * @return the layerStackMngr
//	 * @throws NotSetException If the layerStackMngr is not set.
//	 */
//	public LayersStackMngr getLayersStackMngr() throws NotSetException {
//		
//		if(layerStackMngr == null)
//			throw new NotSetException(this.getClass().getSimpleName() + ".getLayersStackMngr(): layerStackMngr is not set.");
//		
//		return layerStackMngr;
//	}

	/**
	 * Attach the {@link LayersStack} to the diagram.
	 * Do nothing if a LayersStack is already attached.
	 */
	public void attachLayersStack() {

		LayersStackApplication application = layersModel.getLayerStackApplication();
		application.getLayersStackFor(diagram);
	}

	/**
	 * detach the {@link LayersStack} from the diagram.
	 * Do nothing if no LayersStack is attached.
	 */
	public void removeLayersStack() {
		LayersStackApplication application = layersModel.getLayerStackApplication();
		application.removeLayersStackFor(diagram);
	}

	/**
	 * Return True if a {@link LayersStack} is attached to the diagram.
	 * 
	 * @return True if a {@link LayersStack} is attached to the diagram.
	 */
	public boolean isLayersStackAttached() {
		LayersStackApplication application = layersModel.lookupLayerStackApplication();
		if(application == null ) {
			return false;
		}
		return application.isLayersStackAttachedFor(diagram);
	}

//	/**
//	 * Add a listener for the {@link LayersStackActivatedEvent}.
//	 * 
//	 * @param listener
//	 */
//	public void addLayersStackAttachedEventListener(LayersStackAttachedListener listener) {
//		layerStackAttachedNotifier.addLayersStackAttachedEventListener(listener);
//	}
//
//	/**
//	 * Remove a listener for the {@link LayersStackActivatedEvent}.
//	 * 
//	 * @param listener
//	 */
//	public void removeLayersStackAttachedEventListener(LayersStackAttachedListener listener) {
//		layerStackAttachedNotifier.removeLayersStackAttachedEventListener(listener);
//	}


}
