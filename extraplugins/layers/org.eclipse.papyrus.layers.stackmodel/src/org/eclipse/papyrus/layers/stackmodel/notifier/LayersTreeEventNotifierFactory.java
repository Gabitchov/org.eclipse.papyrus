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

package org.eclipse.papyrus.layers.stackmodel.notifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;

/**
 * Factory used to create a {@link LayersTreeEventNotifier}.
 * The factory ensures that there is only one Notifier for a given {@link LayersStack}.
 * @author cedric dumoulin
 *
 */
public class LayersTreeEventNotifierFactory extends AdapterFactoryImpl {

	/**
	 * Global factory.
	 */
	static public LayersTreeEventNotifierFactory instance = new LayersTreeEventNotifierFactory();
	
	/**
	 * Convenience method.
	 * @param target
	 * @return
	 */
	public LayersTreeEventNotifier adapt(Notifier target) {
		return (LayersTreeEventNotifier)adapt(target, LayersTreeEventNotifier.class);
	}
	
	/**
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#createAdapter(org.eclipse.emf.common.notify.Notifier)
	 *
	 * @param target
	 * @return
	 */
	@Override
	protected Adapter createAdapter(Notifier target) {
		return new LayersTreeEventNotifier();
	}

	/**
	 * This Factory is for {@link LayersTreeEventNotifier}.
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#isFactoryForType(java.lang.Object)
	 *
	 * @param type
	 * @return
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return type == LayersTreeEventNotifier.class;
	}
}
