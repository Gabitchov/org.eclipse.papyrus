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
package org.eclipse.papyrus.layers.stackmodel.layers.provider.custom;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.papyrus.layers.stackmodel.layers.provider.LayersItemProviderAdapterFactory;


/**
 * A custom {@link LayersItemProviderAdapterFactory} used to render layers element
 * in a tree.
 * This factory and its oveloaded Providers removed extra nodes in the tree.
 * 
 *  <br>
 *  To use a custom Providers, it is necessary to create it in this factory.
 *  
 * @author cedric dumoulin
 *
 */
public class CustomLayersItemProviderAdapterFactory extends LayersItemProviderAdapterFactory {

	/**
	 * Constructor.
	 *
	 */
	public CustomLayersItemProviderAdapterFactory() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Adapter createLayersStackApplicationAdapter() {
		if (layersStackApplicationItemProvider == null) {
			layersStackApplicationItemProvider = new LayersStackApplicationItemProvider(this);
		}

		return layersStackApplicationItemProvider;
	}
}
