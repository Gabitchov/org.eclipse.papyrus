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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.uml2.uml.NamedElement;


/**
 * An EMF {@link Adapter} listening on uml::NamedElement properties changes.
 * 
 * This class listen to a {@link NamedElement} and send following events to listeners:
 * <ul>
 *   <li>valueChanged</li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class UmlNamedElementChangedEventNotifier extends EContentAdapter {

	boolean isDisposed = false;

	/**
	 * List of listener to notify.
	 */
	protected List<IUmlNamedElementChangedEventListener> listeners = new ArrayList<IUmlNamedElementChangedEventListener>();

	/**
	 * Something happen on the tree of object
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	public void notifyChanged(Notification notification) {

		// Self atttach
		super.notifyChanged(notification);

		// Retain only NamedElement
		if( ! (notification.getNotifier() instanceof NamedElement) ) {
			return;
		}
		
		// No more filter: all events are forwarded
		fireValueChangedEvent(notification);

//		// We are only interested in NamedElement (from newValue if set, or oldValue if removed)
//		Object newValue = notification.getNewValue();
//		if( ! (newValue instanceof NamedElement || notification.getOldValue() instanceof NamedElement ) ) {
//			return;
//		}
//		// Check diagram modification
//		// There is 4 sources: View::persistedChildren and View::transientChildren
//		// Diagram::persistedChildren and Diagram::transientChildren
//		Object feature = notification.getFeature();
//		if( feature == UMLPackage.eINSTANCE.getNamedElement()
//				|| feature == NotationPackage.eINSTANCE.getView_TransientChildren() 
//				|| feature == NotationPackage.eINSTANCE.getDiagram_PersistedEdges() 
//				|| feature == NotationPackage.eINSTANCE.getDiagram_TransientEdges() ) {
//			// LayerOperator::layers || LayersStack::layers
//			// check the event type.
//			switch(notification.getEventType()) {
//			case Notification.SET:
//
//				break;
//			case Notification.ADD:
//				// A view is added
//				fireValueChangedEvent(notification);
//				break;
//			case Notification.REMOVE:
//				// A layer is removed
//				fireDiagramViewRemovedEvent(notification);
//				break;
//			}
//		}

	};

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
		return type == UmlNamedElementChangedEventNotifier.class;
	}
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public UmlNamedElementChangedEventNotifier() {
	}

	/**
	 * Dispose the synchronizer
	 */
	public void dispose() {

		if(isDisposed()) {
			return;
		}

		isDisposed = true;
		listeners.clear();
	}

	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	public boolean isDisposed() {
		return isDisposed == true;
	}

	/**
	 * Add the specified listener to the list of listener.
	 * Do not add it if the listener is already in the list.
	 * 
	 * @param listener
	 */
	public void addEventListener(IUmlNamedElementChangedEventListener listener) {

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
	public void removeEventListener(IUmlNamedElementChangedEventListener listener) {

		listeners.remove(listener);
	}

	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	protected void fireValueChangedEvent(Notification msg) {
		for(IUmlNamedElementChangedEventListener listener : listeners) {
			listener.valueChanged(msg);
		}
	}

}
