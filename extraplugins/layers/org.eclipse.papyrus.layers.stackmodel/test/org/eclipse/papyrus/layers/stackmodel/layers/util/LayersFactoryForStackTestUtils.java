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

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactoryForStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;

/**
 * Utilities to create programmatically a Tree of layers with the {@link LayersFactoryForStack}
 * 
 * @author cedric dumoulin
 *
 */
public class LayersFactoryForStackTestUtils {

	/**
	 * Application object. 
	 */
	protected LayersStackApplication application;
	
	/**
	 * Stack object. 
	 */
	protected LayersStack stack;
	
	/**
	 * factory object. 
	 */
	protected LayersFactoryForStack factory;
	
	protected Map<String, LayerExpression> createdLayers = new HashMap<String, LayerExpression>();
	
	
	/**
	 * Constructor.
	 *
	 * @param stack
	 * @param factory
	 * @param application
	 */
	public LayersFactoryForStackTestUtils(LayersStack stack, LayersFactoryForStack factory, LayersStackApplication application) {
		this.stack = stack;
		this.factory = factory;
		this.application = application;
	}

	/**
	 * Constructor.
	 *  Use the global factory for {@link LayersFactoryForStack}
	 * @param stack
	 * @param application
	 */
	public LayersFactoryForStackTestUtils(LayersStack stack, LayersStackApplication application) {
		this.stack = stack;
		this.factory = LayersFactoryForStack.eINSTANCE;
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
	 * @throws LayersException 
	 */
	public TopLayerOperator newTopLayer() throws LayersException {
		// Create a TopLayer
		TopLayerOperator layer = factory.createTopLayerOperator(stack, stack, application);
		
		return layer;
	}
	
	/**
	 * Create a TopLayer
	 * @return
	 * @throws LayersException 
	 */
	public TopLayerOperator newTopLayer(String name) throws LayersException {
		TopLayerOperator layer = newTopLayer();
		createdLayers.put(name, layer);
		return layer;

	}
	
	/**
	 * Create a TopLayer and add the specified sublayers to it.
	 * Sublayers are initialized with {@link LayersFactoryForStack#initLayer(LayerExpression, org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, LayersStack, LayersStackApplication)} 
	 * before being added to their parent.
	 * @return
	 * @throws LayersException 
	 */
	public TopLayerOperator newTopLayer(String name, LayerExpression ...exprs) throws LayersException {

		TopLayerOperator layer = newTopLayer(exprs);
		createdLayers.put(name, layer);
		return layer;
	}
	
	/**
	 * Create a TopLayer and add the specified sublayers to it.
	 * Sublayers are initialized with {@link LayersFactoryForStack#initLayer(LayerExpression, org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, LayersStack, LayersStackApplication)} 
	 * before being added to their parent.
	 * 
	 * @return
	 * @throws LayersException 
	 */
	public TopLayerOperator newTopLayer(LayerExpression ...exprs) throws LayersException {
		// Create a TopLayer
		TopLayerOperator layer = newTopLayer();
		
		for( LayerExpression l : exprs) {
			factory.initLayer(l, layer, stack, application);
		}
		
		return layer;
	}
	
	/**
	 * Create an uninitialized Layer
	 * @return
	 */
	public LayerExpression newLayer() {
		// Create a TopLayer
		LayerExpression layer = LayersFactory.eINSTANCE.createLayer();
		
		return layer;
	}
	
	/**
	 * Create a an uninitialized  Layer and store it in the map of layers under the specified name.
	 * @return
	 */
	public LayerExpression newLayer(String name) {
		LayerExpression layer = newLayer();
		createdLayers.put(name, layer);
		return layer;

	}
	

}
