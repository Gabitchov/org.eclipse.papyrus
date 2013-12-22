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
package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.notifier.LayersTreeEventNotifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;


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
public class ValueChangedEventNotifier extends EContentAdapter {

	boolean isDisposed = false;

	/**
	 * List of listener to notify.
	 */
	protected List<IValueChangedEventListener> listeners = new ArrayList<IValueChangedEventListener>();

	/**
	 * Something happen on the tree of object
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param msg
	 */
	public void notifyChanged(Notification notification) {

		// Self atttach
		super.notifyChanged(notification);

		// Take into account the domain hierarchy found from the notation.
		
		// Now, filter
		if( isDiagramRootView(notification)) {
			fireValueChangedEvent(notification);
		}
		else if ( isUmlDomainElementChanged(notification)) {
			fireValueChangedEvent(notification);
		}
		

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
	 * Return true if the notification indicates a change in a uml element.
	 * @param notification
	 * @return
	 */
	private boolean isUmlDomainElementChanged(Notification notification) {
		// Notifier should be the diagram
		if( ! (notification.getNotifier() instanceof NamedElement) ) {
			return false;
		}
			
		Object feature = notification.getFeature();

		if( feature == UMLPackage.eINSTANCE.getNamedElement_Name() ) {
			// check the event type.
			switch(notification.getEventType()) {
			case Notification.SET:
			case Notification.ADD:
			case Notification.REMOVE:
				
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if the notification indicates that a Diagram root view is modifified.
	 * @param notification
	 * @return
	 */
	private boolean isDiagramRootView(Notification notification) {
		
		// Notifier should be the diagram
		if( ! (notification.getNotifier() instanceof Diagram) ) {
			return false;
		}
			
		Object feature = notification.getFeature();

		if( feature == NotationPackage.eINSTANCE.getView_PersistedChildren()
				|| feature == NotationPackage.eINSTANCE.getView_TransientChildren()
				|| feature == NotationPackage.eINSTANCE.getDiagram_PersistedEdges() 
				|| feature == NotationPackage.eINSTANCE.getDiagram_TransientEdges() ) {
			// LayerOperator::layers || LayersStack::layers
			// check the event type.
			switch(notification.getEventType()) {
			case Notification.SET:
			case Notification.ADD:
			case Notification.REMOVE:
				
				return true;
			}
		}
		return false;
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
		return type == ValueChangedEventNotifier.class;
	}
	
	/**
	 * Constructor.
	 *
	 * @param layersModel
	 */
	public ValueChangedEventNotifier() {
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
	public void addEventListener(IValueChangedEventListener listener) {

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
	public void removeEventListener(IValueChangedEventListener listener) {

		listeners.remove(listener);
	}

	/**
	 * Called by events when a {@link LayersStack} is added to the {@link LayersStackApplication}
	 * @param msg
	 */
	protected void fireValueChangedEvent(Notification msg) {
		for(IValueChangedEventListener listener : listeners) {
			listener.valueChanged(msg);
		}
	}

	/**
	 * Handle View::element hierarchy in the self adapt mechanism.
	 * Handles a notification by calling {@link #handleContainment handleContainment}
	 * for any containment-based notification.
	 */
	@Override
	protected void selfAdapt(Notification notification)
	{
		System.err.println( this.getClass().getSimpleName() + ".selfAdapt("+ notification+")" );
		// Handle the View::element tree
		if (notification.getFeature() == NotationPackage.eINSTANCE.getView_Element())
		{
			handleContainment(notification);
		}
		else {
			super.selfAdapt(notification);			
		}
	}

	/**
	 * Handle View::element hierarchy in the self adapt mechanism.
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#setTarget(org.eclipse.emf.ecore.EObject)
	 *
	 * @param target
	 */
	@Override
	protected void setTarget(EObject target) {
		System.err.println( this.getClass().getSimpleName() + ".setTarget("+ target+")" );
		super.setTarget(target);
		// Handle the View::element tree
		if( target instanceof View ) {
			EObject extraTarget = ((View)target).getElement();
			if( extraTarget != null) {
				System.err.println( this.getClass().getSimpleName() + ".setExtraTarget("+ extraTarget+")" );
				// copied from org.eclipse.emf.ecore.util.EContentAdapter.setTarget(EObject)
//			    basicSetTarget(target);
				// Add the extra object
				addAdapter(extraTarget);
				// Add the content of the extra object
//			    for (Iterator<? extends Notifier> i = resolve() ? 
//			    		extraTarget.eContents().iterator() : 
//			           ((InternalEList<? extends Notifier>)extraTarget.eContents()).basicIterator();
//			         i.hasNext(); )
//			    {
//			      Notifier notifier = i.next();
//			      addAdapter(notifier);
//			    }

			}
		}
	}
	
	/**
	 * Handle View::element hierarchy in the self adapt mechanism.
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#unsetTarget(org.eclipse.emf.ecore.EObject)
	 *
	 * @param target
	 */
	@Override
	protected void unsetTarget(EObject target) {
		// TODO Auto-generated method stub
		super.unsetTarget(target);
		// Handle the View::element tree
		if( target instanceof View ) {
			EObject extraTarget = ((View)target).getElement();
			if( extraTarget != null) {
				// copied from org.eclipse.emf.ecore.util.EContentAdapter.setTarget(EObject)
//			    basicSetTarget(target);
				// Remove the extra object
				removeAdapter(extraTarget);
				// Remove contents of the extra object
//			    for (Iterator<? extends Notifier> i = resolve() ? 
//			    		extraTarget.eContents().iterator() : 
//			           ((InternalEList<? extends Notifier>)extraTarget.eContents()).basicIterator();
//			         i.hasNext(); )
//			    {
//			      Notifier notifier = i.next();
//			      removeAdapter(notifier);
//			    }

			}
		}
	}

}
