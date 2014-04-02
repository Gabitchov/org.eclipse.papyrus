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
 * 
 */
package org.eclipse.papyrus.layers3.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers3.ui.view.LayersExplorerViewUtils;

/**
 * Open Layer Explorer ui handler.
 * 
 * @author cedric dumoulin
 *
 */
public class OpenLayerExplorerHandler extends AbstractHandler {

	/**
	 * 
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		LayersExplorerViewUtils.openView(event);
		
		return null;
	}
	
	
	@Override
	public void setEnabled(Object evaluationContext) {
		
		// 
		if(evaluationContext==null) {
			setBaseEnabled(false);
			return;
			
		}
		
		LayersExplorerViewUtils.isViewOpened((IEvaluationContext)evaluationContext);
		setBaseEnabled(true);
		super.setEnabled(evaluationContext);
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 * @throws NotFoundException
	 */
	protected IEvaluationContext getIEvaluationContext(ExecutionEvent event) throws NotFoundException {
		try {
			return (IEvaluationContext)event.getApplicationContext();
		} catch (ClassCastException e) {
			throw new NotFoundException("IEvaluationContext can't be found.");
		}
		
	}


}
