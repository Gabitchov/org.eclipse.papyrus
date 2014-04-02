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

package org.eclipse.papyrus.layers.stackmodel.layers.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;

/**
 * Utilities to create Layers for tests
 * 
 * @author cedric dumoulin
 *
 */
public class LayersFactoryTestUtils {

	/**
	 * Application object. 
	 */
	protected LayersStackApplication application;
	
	protected Map<String, LayerExpression> createdLayers = new HashMap<String, LayerExpression>();
	
	/**
	 * Constructor.
	 *
	 * @param application
	 */
	public LayersFactoryTestUtils(LayersStackApplication application) {
		this.application = application;
	}

	/**
	 * @return the createdLayers
	 */
	public Map<String, LayerExpression> getCreatedLayers() {
		return createdLayers;
	}

	/**
	 * @return the createdLayers
	 */
	public LayerExpression getLayer(String name) {
		return createdLayers.get(name);
	}

	/**
	 * Create a TopLayer
	 * @return
	 */
	public TopLayerOperator newTopLayer() {
		// Create a TopLayer
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		layer.setApplication(application);
		
		return layer;
	}
	
	/**
	 * Create a TopLayer
	 * @return
	 */
	public TopLayerOperator newTopLayer(String name) {
		TopLayerOperator layer = newTopLayer();
		createdLayers.put(name, layer);
		return layer;

	}
	
	/**
	 * Create a TopLayer
	 * @return
	 */
	public TopLayerOperator newTopLayer(String name, LayerExpression ...exprs) {

		TopLayerOperator layer = newTopLayer(exprs);
		createdLayers.put(name, layer);
		return layer;
	}
	
	/**
	 * Create a TopLayer
	 * @return
	 */
	public TopLayerOperator newTopLayer(LayerExpression ...exprs) {
		// Create a TopLayer
		TopLayerOperator layer = newTopLayer();
		
		for( LayerExpression l : exprs) {
			layer.getLayers().add(l);
		}
		
		return layer;
	}
	
	/**
	 * Create a Layer
	 * @return
	 */
	public LayerExpression newLayer() {
		// Create a TopLayer
		LayerExpression layer = LayersFactory.eINSTANCE.createLayer();
		layer.setApplication(application);
		
		return layer;
	}
	
	/**
	 * Create a TopLayer
	 * @return
	 */
	public LayerExpression newLayer(String name) {
		LayerExpression layer = newLayer();
		createdLayers.put(name, layer);
		return layer;

	}
	

}
