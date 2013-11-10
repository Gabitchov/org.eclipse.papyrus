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
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage;
import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LayerOperatorConfigImpl extends InstanciableElementImpl implements LayerOperatorConfig {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerOperatorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersconfigPackage.Literals.LAYER_OPERATOR_CONFIG;
	}

	/**
	 * Create the requested descriptor
	 * 
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.impl.InstanciableElementImpl#createLayersOperatorDescriptor()
	 *
	 * @return
	 * @throws NotFoundException 
	 * @generated NOT
	 */
	@Override
	public LayerOperatorDescriptor createLayersOperatorDescriptor() throws InstanciationException {

		// Create instance of layer
		EClassifier classifier = LayersPackage.eINSTANCE.getEClassifier(getClassname());
		if(classifier == null) {
			throw new InstanciationException("Can't create LayerOperatorDescriptor for name '" + getClassname() + "'");
		}
		LayerOperatorDescriptor res = (LayerOperatorDescriptor)LayersFactory.eINSTANCE.create((EClass)classifier);

		// Set values
		res.setName(getName());
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersconfigPackage.LAYER_OPERATOR_CONFIG___CREATE_LAYERS_OPERATOR_DESCRIPTOR:
				try {
					return createLayersOperatorDescriptor();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}
} //LayerOperatorConfigImpl
