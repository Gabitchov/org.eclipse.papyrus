/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.layers.stackmodel.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewChangedEventNotifierFactory;
import org.eclipse.papyrus.layers.stackmodel.notifier.IDiagramViewEventListener;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This class allows to synchronize a specfied list with {@link View} elements from the specified 
 * {@link Diagram}.
 * 
 * @author cedric dumoulin
 *
 */
public class DiagramViewToListSynchronizer {

	protected Diagram diagram;
	
	protected Collection<View> synchronizedList;
	
	/**
	 * Listener on Diagram's View event.
	 * Synchronize the associated list according to the event.
	 */
	private IDiagramViewEventListener viewEventListener = new IDiagramViewEventListener() {
		
		@Override
		public void diagramViewRemoved(Notification msg) {
			// Add the removed view from the list
			synchronizedList.remove((View)msg.getOldValue());
			
		}
		
		@Override
		public void diagramViewAdded(Notification msg) {
			
			View view = (View)msg.getNewValue();
			if( synchronizedList.contains(view)) {
				return;
			}
			// add element 
			synchronizedList.add(view);
		}
	};
	
	/**
	 * Constructor.
	 *
	 * @param diagram
	 * @param synchronizedList
	 */
	public DiagramViewToListSynchronizer(Diagram diagram, Collection<View> synchronizedList) {
		this.synchronizedList = synchronizedList;
		
		// Listen to diagram's view event
		setDiagram(diagram);
	}
	
	/**
	 * The diagram should be set later.
	 * Constructor.
	 *
	 * @param synchronizedList
	 */
	public DiagramViewToListSynchronizer(Collection<View> synchronizedList) {
		this.synchronizedList = synchronizedList;
	}

	/**
	 * Set the diagram synchronized to the list.
	 * @param diagram
	 */
	public void setDiagram(Diagram diagram) {
		
		DiagramViewChangedEventNotifier notifier;
		// stop listening on old diagram if any
		Diagram oldDiagram = this.diagram;
		if( oldDiagram != null) {
			notifier  = DiagramViewChangedEventNotifierFactory.instance.adapt(oldDiagram);
			notifier.removeEventListener(viewEventListener);
		}
		// Reset the list and add view responding to the predicate	
		synchronizedList.clear();

		Iterable<View> filteredList = Iterables.filter(diagram.getChildren(), LayerDiagramViewPredicate.instance);
		for(  View view : filteredList ) {
			synchronizedList.add(view);
		}
		
		// attach to new diagram
		this.diagram = diagram;
		if( diagram != null) {
			notifier  = DiagramViewChangedEventNotifierFactory.instance.adapt(diagram);
			notifier.addEventListener(viewEventListener);
		}
		
	}
}
