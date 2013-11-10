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

import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.OrStackedLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Stacked Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrStackedLayerOperatorDescriptorImpl extends StackedLayerOperatorDescriptorImpl implements OrStackedLayerOperatorDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected OrStackedLayerOperatorDescriptorImpl() {
		super();
		setName("OrStackedLayerOperator");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.OR_STACKED_LAYER_OPERATOR_DESCRIPTOR;
	}

} //OrStackedLayerOperatorDescriptorImpl
