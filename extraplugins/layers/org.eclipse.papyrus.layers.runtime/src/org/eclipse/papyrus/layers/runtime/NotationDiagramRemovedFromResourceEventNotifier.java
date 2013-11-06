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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * This class listen to a {@link Resource} and send following events to listeners:
 * <ul>
 *   <li>diagram removed</li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class NotationDiagramRemovedFromResourceEventNotifier {

	protected NotationModel notationModel;

	/**
	 * List of listener to notify.
	 */
	protected List<INotationDiagramRemovedEventListener> listeners = new ArrayList<INotationDiagramRemovedEventListener>();
	
	protected Adapter notationDiagramRemovedListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			
			// TODO When a Resource is unloaded, each diagram is removed and a corresponding event is fired.
			// We need to separate event from a regular removal (user choose to remove a diagram) from events 
			// event fired by 'resource.unload()' (to be done). 
			if( msg.getEventType() == Notification.REMOVE 
					&& msg.getNotifier() instanceof Resource
					&& msg.getOldValue() instanceof Diagram ) {
				// A diagram is removed from its resource
//				System.err.println("Resource notified. Feature=" + msg.getFeature()
//						+ ", type="+ msg.getEventType()
//						+ ", newValue=" + msg.getNewValue()
//						+ ", oldValue=" + msg.getOldValue());
				Resource resource = (Resource)msg.getNotifier();
				// Fire event only if resource is loaded. This should avoid firing event when the
				// diagram is removed because the resource is unloading.
				if( resource.isLoaded() ) {
				  fireDiagramRemovedEvent(msg);
				}
			}
		};
		
	};
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public NotationDiagramRemovedFromResourceEventNotifier(NotationModel notationModel) {
		this.notationModel = notationModel;
		activate();
	}

	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		// Listen on diagram removed events
		notationModel.getResource().eAdapters().add(notationDiagramRemovedListener);
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		// Listen on diagram removed events
		notationModel.getResource().eAdapters().remove(notationDiagramRemovedListener);
	}
	
	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
		// Deactivate listeners
		deactivate();
		notationModel = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	protected boolean isDisposed() {
		return notationModel == null;
	}
	
	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addLayersModelEventListener(INotationDiagramRemovedEventListener listener) {
		
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
	public void removeLayersModelEventListener(INotationDiagramRemovedEventListener listener) {

		listeners.remove(listener);
	}
	
	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	protected void fireDiagramRemovedEvent(Notification msg) {
		for(INotationDiagramRemovedEventListener listener : listeners) {
			listener.diagramRemoved(msg);
		}
	}

	/**
	 * Get the removed diagram in case of diagramRemoved event
	 * @param msg
	 * @return
	 */
	public static Diagram getRemovedDiagram(Notification msg) {
		return (Diagram)msg.getOldValue();
	}
	

}
