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
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TopLayerOperatorImpl extends AbstractLayerOperatorImpl implements TopLayerOperator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLayerOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.TOP_LAYER_OPERATOR;
	}

	/**
	 * Get the command to compute the required property value.
	 * Walk all layers and return the first cmd that is not null for specified view and proerty.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(View view, Property property) throws LayersException {
		
		// Walk all layers and return the first cmd that is not null for specified view and proerty.
		for( LayerExpression layer : getLayers()) {
			
			ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				return cmd;
			}
		}
		// Nothing found
		return null;
	
	}
	
	/**
	 * For each property, add the first property value in the list of result.
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public EList<ComputePropertyValueCommand> getPropertiesComputePropertyValueCommand(View view, List<Property> properties) throws LayersException {

		// Simple implementation
		// TODO Check if we can optimize

		// the result list
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(properties.size());
		boolean isCmdFound = false;
		
		for( Property property : properties) {
			if( property == null) {
				resCmds.add(null);
				continue;
			}
			
			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);

				
		}
		// Return appropriate result
		if( isCmdFound) {
			return resCmds;
		}
		else {
			// No command ==> null 
			return null;
		}
	}
	
	/**
	 * For each view, add the first property value in the list of result.
	 * 
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.layers.stackmodel.layers.Property)
	 *
	 * @param view
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public EList<ComputePropertyValueCommand> getViewsComputePropertyValueCommand(List<View> views, Property property) throws LayersException {

		// Simple implementation
		// TODO Check if we can optimize
		
		// the result list
		EList<ComputePropertyValueCommand> resCmds = new BasicEList<ComputePropertyValueCommand>(views.size());
		boolean isCmdFound = false;
		
		for( View view : views) {
			if( view == null) {
				resCmds.add(null);
				continue;
			}
			
			ComputePropertyValueCommand cmd = getComputePropertyValueCommand(view, property);
			if( cmd != null) {
				isCmdFound = true;
			}
			resCmds.add(cmd);
		}
				
		// Return appropriate result
		if( isCmdFound) {
			return resCmds;
		}
		else {
			// No command ==> null 
			return null;
		}
	}
} //TopLayerOperatorImpl
