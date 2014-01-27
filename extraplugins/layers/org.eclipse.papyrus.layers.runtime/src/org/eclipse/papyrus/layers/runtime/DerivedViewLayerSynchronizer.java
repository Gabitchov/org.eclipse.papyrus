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

package org.eclipse.papyrus.layers.runtime;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.layers.runtime.notifier.DiagramChangedEventNotifier;
import org.eclipse.papyrus.layers.runtime.notifier.DomainChangedEventNotifier;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier;

/**
 * A synchronizer used to call the {@link RegExpLayer#evaluateExpr()}.
 * The synchronizer listen on some events, and manage and {@link RegExpLayer} accordingly.
 * One instance of this class is associated with each {@link LayersStack}.
 * The instance is created by the {@link LayerStackSynchronizer#activate()}.
 * The instance is deleted by {@link LayerStackSynchronizer#dispose()}.
 * 
 * 
 * 
 * 
 * The listenned events:
 * <ul>
 *   <li></li>
*   <li></li>
*   <li></li>
*   <li></li>
*   <li></li>
 * </ul>
 * <br>
 * 
 * @author cedric dumoulin
 *
 */
public class DerivedViewLayerSynchronizer {

	/**
	 * Listener on external events of type Domain level 1.
	 */
	private DomainChangedEventNotifier domainChangedLevel1Notifier;
	
	/**
	 * Listener on external events of type Domain.
	 */
	private DomainChangedEventNotifier domainChangedAllLevelNotifier;

	private DiagramChangedEventNotifier diagramChangedLevel1Notifier;

	private DiagramChangedEventNotifier diagramChangedAllLevelNotifier;

	/**
	 * The {@link LayersStack} for which this Notifier works.
	 */
	private LayersStack layersStack;
	
	/**
	 * 
	 * Constructor.
	 *
	 */
	public DerivedViewLayerSynchronizer(LayersStack layersStack) {
		this.layersStack = layersStack;
	}
	
	public LayersStack getLayersStack() {
		return layersStack;
	}

	/**
	 * Init the class.
	 */
	protected void init() {
		
		// Domain events
		domainChangedLevel1Notifier = new DomainChangedEventNotifier(layersStack);
		domainChangedAllLevelNotifier = new DomainChangedEventNotifier(layersStack);
		
		// Diagram view events
		diagramChangedLevel1Notifier = new DiagramChangedEventNotifier(layersStack);
		diagramChangedAllLevelNotifier = new DiagramChangedEventNotifier(layersStack);

		// Diagram changed events
		// TODO reuse notifiers from elsewhere ?
		// LEt LayerStackSynchronizer call activate() and deactivate() ?
		
		registerDerivedViewLayers();
	}
	
	/**
	 * Activate the listeners.
	 * 
	 */
	protected void activate() {
		
		registerDerivedViewLayers();
	}

	/**
	 * Deactivate listeners
	 */
	protected void deactivate() {
		domainChangedLevel1Notifier.removeAllListeners();
		domainChangedAllLevelNotifier.removeAllListeners();
		
		diagramChangedLevel1Notifier.removeAllListeners();
		diagramChangedAllLevelNotifier.removeAllListeners();
	}
	
	/**
	 * Dispose the synchronizer
	 */
	protected void dispose() {
		// Deactivate listeners
		deactivate();
		domainChangedLevel1Notifier = null;
		domainChangedAllLevelNotifier = null;
		
		diagramChangedLevel1Notifier = null;
		diagramChangedAllLevelNotifier = null;
	}
	
	/**
	 * Return true if the object is disposed.
	 * @return
	 */
	protected boolean isDisposed() {
		return domainChangedLevel1Notifier == null;
	}
	
	/**
	 * Lookup the DerivedViewLayer existing in the associated LayerStack.
	 * Register them to the corresponding listeners.
	 * 
	 */
	private void registerDerivedViewLayers() {
		// get the Layers
		List<RegExpLayer> layers = lookupDerivedViewLayer();
		
		for(RegExpLayer layer : layers ) {
			registerDerivedLayer(layer);
		}
		
	}

	/**
	 * Lookup all DerivedViewLayer owned by the {@link LayersStack}.
	 * 
	 * @return a {@link List} of {@link DerivedViewLayer} owned by the {@link LayersStack}.
	 */
	private List<RegExpLayer> lookupDerivedViewLayer() {
		// TODO implements this:
		// with a visitor ?
		// with getAllContents ?
//		EcoreUtil.getObjectsByType(layersStack.e, type)
//		getLayersStack().
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Register the provided layer to the listeners required by such layer.
	 * 
	 * @param layer The layer to register.
	 */
	private void registerDerivedLayer(RegExpLayer layer) {
		
//		if(layer.isAnyDomainChangedEventDependant() ) {
//			if( layer.domainChangedEventLevel == 1) {
//				domainChangedLevel1Notifier.addListener(layer);
//			} else {
//				// All level
//				domainChangedAllLevelNotifier.addListener(layer);
//			}
//		}
//		if(layer.isAnyDiagramChangedEventDependant() ) {
//			if( layer.diagramChangedEventLevel == 1) {
//				diagramChangedLevel1Notifier.addListener(layer);
//			} else {
//				// All level
//				diagramChangedAllLevelNotifier.addListener(layer);
//			}
//		}
		
	}


}
