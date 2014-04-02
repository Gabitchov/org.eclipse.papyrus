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

package org.eclipse.papyrus.layers.runtime.notifier;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;

/**
 * Notify listeners when a change occurs on an domain element associated to an element of the LayerStack's diagram.
 * 
 * @author cedric dumoulin
 *
 */
public class DomainChangedEventNotifier extends AbstractDerivedViewLayerNotifier {

	/**
	 * {@link LayersStack} containing the {@link Diagram} on which this notifier is listening changes.
	 */
	protected LayersStack layersStack;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param layersStack
	 */
	public DomainChangedEventNotifier(LayersStack layersStack) {
		this.layersStack = layersStack;
	}
	
	/**
	 * Start listening on externals events that should be relayed by this Notifier.
	 * @see org.eclipse.papyrus.layers.runtime.notifier.AbstractDerivedViewLayerNotifier#startListening()
	 *
	 */
	@Override
	protected void startListening() {
		// TODO Auto-generated method stub

	}

	/**
	 * Start listening on externals events that should be relayed by this Notifier.
	 * @see org.eclipse.papyrus.layers.runtime.notifier.AbstractDerivedViewLayerNotifier#stopListening()
	 *
	 */
	@Override
	protected void stopListening() {
		// TODO Auto-generated method stub

	}

}
