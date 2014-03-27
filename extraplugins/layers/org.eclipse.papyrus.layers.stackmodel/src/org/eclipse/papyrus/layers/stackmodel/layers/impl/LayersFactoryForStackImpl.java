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
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactoryForStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * This factory allows to create Layers dedicated to a Application and {@link LayersStack} <!-- end-user-doc -->
 * 
 * @generated
 */
public class LayersFactoryForStackImpl implements LayersFactoryForStack {

	/**
	 * Index used to postfix the layer name.
	 */
	protected int newIndex = 0;
	
	public final String LAYER_NAME_PREFIX = "layer";
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static LayersFactoryForStack init() {
		return new LayersFactoryForStackImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LayersFactoryForStackImpl() {
		super();
	}

	public String findNewLayerName( LayersContainer parent ) {
		
		String proposedName = LAYER_NAME_PREFIX + newIndex++;
	
		// Check if the name is available in the targetted container
		if( parent instanceof LayerOperator ) {
			LayerOperator parentOperator = (LayerOperator)parent;
			while( getLayerByName(parentOperator, proposedName) != null ) {
				proposedName = LAYER_NAME_PREFIX + newIndex++;
			}
		}
		return proposedName;
	}
	
	/**
	 * Get a layer by its name.
	 * @param parentOperator The container containing layers
	 * @param name Name of the requested layer.
	 * @return The requested layer, or null.
	 */
	private LayerExpression getLayerByName(LayerOperator parentOperator, String name) {
		

		for( LayerExpression layer : parentOperator.getLayers() ) {
			if( name.equals(layer.getName() ) ) {
				return layer;
			}
		}
		// Not found
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public LayersStack createLayersStack() {
		throw new UnsupportedOperationException("Not yet implemented");
	}


	/**
	 * 
	 * @param layer
	 *        The layer to init
	 * @param parentLayer
	 *        The parent Layer to which layer is added
	 * @param owningStack
	 *        The {@link LayersStack} owning the tree of layers
	 * @param application
	 *        The application required by layer.
	 * 
	 * @return
	 * @throws LayersException
	 */
	@Override
	public LayerExpression initLayer(LayerExpression layer, LayersContainer parentLayer, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		// Init the created layer
		layer.setApplication(application);
		layer.setName(findNewLayerName(parentLayer));
		parentLayer.addLayer(layer);
		layer.setOwningLayersStack(owningStack);
		// Start the layer
		layer.attach();

		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @throws LayersException
	 * @generated NOT
	 */
	@Override
	public Layer createLayer(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		// Init the created layer
		initLayer(layer, parent, owningStack, application);

		return layer;
	}

	@Override
	public RegExpLayer createRegExpLayer(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		RegExpLayer layer = LayersFactory.eINSTANCE.createRegExpLayer();
		// Init the created layer
		initLayer(layer, parent, owningStack, application);

		return layer;
	}

	@Override
	public TopLayerOperator createTopLayerOperator(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		// Init the created layer
		initLayer(layer, parent, owningStack, application);

		return layer;
	}

	@Override
	public StackedLayerOperator createStackedLayerOperator(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		StackedLayerOperator layer = LayersFactory.eINSTANCE.createStackedLayerOperator();
		// Init the created layer
		initLayer(layer, parent, owningStack, application);

		return layer;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersFactoryForStack#createLayerOperator(java.lang.String, org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)
	 *
	 * @param layerOperatorID
	 * @param parent
	 * @param owningStack
	 * @param application
	 * @return
	 * @throws LayersException
	 */
	@Override
	public AbstractLayerOperator createLayerOperator(String layerOperatorID, LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException {
		// Create a layer !
		 AbstractLayerOperator layerOperator = application.getLayerOperatorDescriptorRegistry().createLayerOperator(layerOperatorID);
		// Init the created layer
		initLayer(layerOperator, parent, owningStack, application);

		return layerOperator;
	}




} //LayersFactoryImpl
