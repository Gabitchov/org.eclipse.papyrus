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
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.papyrus.layers.stackmodel.LayersException;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage
 * @generated
 */
public interface LayersFactoryForStack {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersFactoryForStack eINSTANCE = org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl.init();

	/**
	 * Returns a new object of class '<em>Stack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack</em>'.
	 * @generated
	 */
	LayersStack createLayersStack();

	/**
	 * Returns a new object of class '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer</em>'.
	 * @generated NOT
	 */
	public Layer createLayer(LayersContainer parent, LayersStack owningStack, LayersStackApplication application)
			throws LayersException;


	/**
	 * Returns a new object of class '<em>Reg Exp Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Exp Layer</em>'.
	 * @throws LayersException 
	 * @generated
	 */
	public RegExpLayer createRegExpLayer(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException;

	/**
	 * Returns a new object of class '<em>Top Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Layer Operator</em>'.
	 * @generated
	 */
	public TopLayerOperator createTopLayerOperator(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException;

	/**
	 * Returns a new object of class '<em>Stacked Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stacked Layer Operator</em>'.
	 * @generated
	 */
	public StackedLayerOperator createStackedLayerOperator(LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException;

	/**
	 * Standard initialization of a newly created layer.
	 * 
	 * @param layer
	 * @param parentLayer
	 * @param owningStack
	 * @param application
	 * @return
	 * @throws LayersException
	 */
	public LayerExpression initLayer(LayerExpression layer, LayersContainer parentLayer, LayersStack owningStack, LayersStackApplication application) throws LayersException;

	/**
	 * Create a LayerOperator by its ID. 
	 * IDs are those used when the LayerOperator is registered in application'registry.
	 * 
	 * @param layerOperatorID
	 * @param parent
	 * @param owningStack
	 * @param application
	 * @return
	 * @throws LayersException
	 */
	public AbstractLayerOperator createLayerOperator(String layerOperatorID, LayersContainer parent, LayersStack owningStack, LayersStackApplication application) throws LayersException;


} //LayersFactory
