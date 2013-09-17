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
package org.eclipse.papyrus.layers3.ui.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * @author cedric dumoulin
 *
 */
public class CreateLayerOperatorsFromParameter extends AbstractLayersCommand {

	/**
	 * Value used to compute new names.
	 */
	private static int creationCount = 0;
	
	/**
	 * ID of the layer to create
	 */
	private String newLayerID;

	/**
	 * the application object, if found
	 */
	private LayersStackApplication application;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public CreateLayerOperatorsFromParameter() {
		super();
	}

	/**
	 * Prepare the execution of the command
	 * 
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#preExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected boolean preExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) throws ExecutionException {

		if(!isEnabled(context, selections)) {
			return false;
		}

		// Get command parameters
		newLayerID = event.getParameter("org.eclipse.papyrus.layers.ui.createLayerOperator.parameters");
		System.err.println("Create Layer Operators '" + newLayerID + "'.");
		
		// Get application
		try {
		   application = lookupLayersStackApplicationChecked(context);
		} catch (NotFoundException e) {
			// Silently fails
			return false;
		} catch (org.eclipse.papyrus.infra.core.resource.NotFoundException e) {
			// Silently fails
			return false;
		} catch (ServiceException e) {
			// Silently fails
			return false;
		}
	

		return true;
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#doExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 */
	@Override
	protected void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) {
		System.out.println( this.getClass().getSimpleName() + ".doExecute()");
		
		// Create a layer !
		AbstractLayerOperator layerOperator;
		try {
			layerOperator = application.getLayerOperatorDescriptorRegistry().createLayerOperator(newLayerID);
			layerOperator.setName("layer" + creationCount++);
			layerOperator.setApplication(application);
		} catch (LayersException e) {
//			e.printStackTrace();
			System.err.println("Log - " + this.getClass().getName() 
					+ " - " + e.getMessage());
			return;
		}
		
		// insert layer in selected object
		Object selection = selections.get(0);
		if(selection instanceof LayersStack) {
			LayersStack stack = (LayersStack)selection;
			stack.setLayers(layerOperator);
		}
		else {
			LayerOperator operator = (LayerOperator)selection;
			operator.getLayers().add(layerOperator);
		}
		
	}

	/**
	 * Return true if it is possible to attach aLyerStack.
	 */
	@Override
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {
	    if( selections.size() != 1) {
	    	return false;
	    }
	    Object first = selections.get(0);
	    boolean res = (first instanceof LayerOperator) || (first instanceof LayersStack);
	    System.err.println("isEnable(" + res + ")");
		return res;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Create Layer Operator";
	}

}
