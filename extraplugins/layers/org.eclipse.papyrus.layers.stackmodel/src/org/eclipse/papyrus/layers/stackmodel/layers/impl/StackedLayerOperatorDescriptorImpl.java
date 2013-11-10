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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stacked Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StackedLayerOperatorDescriptorImpl extends LayerOperatorDescriptorImpl implements StackedLayerOperatorDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected StackedLayerOperatorDescriptorImpl() {
		super();
		init();
	}

	/**
	 * Init the descriptor.
	 */
	private void init() {
		setName("StackedLayerOperator");
		
	}
	
	/**
	 * New instance creation counter.
	 */
	static int count = 0;
	
	/**
	 * Create the requested {@link StackedLayerOperator} and init it.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#createLayerOperator()
	 *
	 * @return
	 */
	@Override
	public AbstractLayerOperator createLayerOperator() {


		StackedLayerOperator layerOperator = LayersFactory.eINSTANCE.createStackedLayerOperator();
		layerOperator.setLayerOperatorDescriptor(this);
		layerOperator.setLayerOperatorDescriptorName(this.getName());
		layerOperator.setName(getName() + count++);
		
		return layerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.STACKED_LAYER_OPERATOR_DESCRIPTOR;
	}

} //StackedLayerOperatorDescriptorImpl
