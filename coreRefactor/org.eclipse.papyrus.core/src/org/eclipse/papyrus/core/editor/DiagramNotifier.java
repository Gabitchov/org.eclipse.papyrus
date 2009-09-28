/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.editor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Class notifying event when a diagram is added/moved/removed from the graphical model
 * 
 * @author dumoulin
 * 
 */
public class DiagramNotifier {

	public static final String DIAGRAM_ADDED = "DIAGRAM_ADDED";

	public static final String DIAGRAM_MOVED = "DIAGRAM_MOVED";

	public static final String DIAGRAM_REMOVED = "DIAGRAM_REMOVED";

	/**
	 * Listener on diagram added/removed.
	 */
	private PropertyChangeSupport diagramListListener = new PropertyChangeSupport(this);

	/**
	 * Adapter listening to diagram addition/remove events
	 */
	private Adapter adapter = new Adapter() {

		Notifier notifier;

		public Notifier getTarget() {
			return notifier;
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		/**
		 * Notifies that a change to some feature has occurred.
		 * 
		 * @param notification
		 *            a description of the change.
		 */
		public void notifyChanged(Notification notification) {
			int eventType = notification.getEventType();
			// Check if this is a diagram
			Object newValue = notification.getNewValue();
			System.out.println(this.getClass().getCanonicalName() + "notifyChanged(" + newValue + " - " + eventType + ")");
			if (!isADiagram(newValue)) {
				return;
			}
			// Check the type of event
			if (eventType == Notification.ADD) {
				diagramListListener.firePropertyChange(DIAGRAM_ADDED, null, newValue);
			} else if (eventType == Notification.MOVE) {
				diagramListListener.firePropertyChange(DIAGRAM_MOVED, null, newValue);

			} else if (eventType == Notification.REMOVE) {
				diagramListListener.firePropertyChange(DIAGRAM_REMOVED, null, newValue);
			}
		}

		private boolean isADiagram(Object object) {
			return object instanceof Diagram;
		}

		public void setTarget(Notifier newTarget) {
			notifier = newTarget;

		}

	};

	/** Resource source of the events */
	private Resource eventSource;

	public DiagramNotifier(Resource eventSource) {
		this.eventSource = eventSource;
	}

	/**
	 * Add a listener that will be notified of diagram CRUD event in graphical model
	 * 
	 * @param listener
	 */
	public void addListener(PropertyChangeListener listener) {
		// Check if the class is already listening to events source
		boolean isListening = diagramListListener.hasListeners(null);
		// register listener
		diagramListListener.addPropertyChangeListener(listener);
		// Listen to event source if needed
		if (!isListening) {
			activate();
		}
		diagramListListener.getPropertyChangeListeners();
	}

	/**
	 * Add a listener that will be notified of diagram CRUD event in graphical model
	 * 
	 * @param listener
	 */
	public void removeListener(PropertyChangeListener listener) {
		diagramListListener.removePropertyChangeListener(listener);
		// Deactivate listening to event source if none is registered.
		if (!diagramListListener.hasListeners(null)) {
			deactivate();
		}
	}

	/**
	 * Called when the editor should be activated. Subclass should implements this method to register listeners to the model.
	 * 
	 */
	public void activate() {
		eventSource.eAdapters().add(adapter);

	}

	/**
	 * Called when the editor is deactivated.
	 * 
	 */
	public void deactivate() {
		eventSource.eAdapters().remove(adapter);
	}

}
