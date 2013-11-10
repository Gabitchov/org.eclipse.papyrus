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
package org.eclipse.papyrus.layers3.ui.view;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Utilities to open, close or check the LayersExplorerView.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class LayersExplorerViewUtils {

	/**
	 * Id of the View.
	 */
	static final public  String LayersExplorerViewId = "org.eclipse.papyrus.layers.ui.view.layersexplorer";
	
	/**
	 * 
	 * @param event
	 */
	static public void openView(ExecutionEvent event) {
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(LayersExplorerViewId);
		} catch (PartInitException e) {
			// Do nothing;
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	static public void openView(IEvaluationContext	context) {
		try {
			getActiveWorkbenchWindow(context).getActivePage().showView(LayersExplorerViewId);
		} catch (PartInitException e) {
			// Do nothing;
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws NotFoundException 
	 */
	static public LayersExplorerView findView(ExecutionEvent event) throws NotFoundException {
			IViewPart part = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().findView(LayersExplorerViewId);

			if(part instanceof LayersExplorerView ) {
				return (LayersExplorerView)part;
			} 
			else {
				throw new NotFoundException("Can't find LayersExplorerView.");
			}
	}
	
	/**
	 * 
	 * @param event
	 * @throws NotFoundException 
	 */
	static public LayersExplorerView findView(IEvaluationContext	context) throws NotFoundException {
			IViewPart part = getActiveWorkbenchWindow(context).getActivePage().findView(LayersExplorerViewId);

			if(part instanceof LayersExplorerView ) {
				return (LayersExplorerView)part;
			} 
			else {
				throw new NotFoundException("Can't find LayersExplorerView.");
			}
	}
	/**
	 * 
	 * @param event
	 * @return 
	 */
	static public boolean isViewOpened(ExecutionEvent event) {
		try {
			return findView(event)!=null;
		} catch (NotFoundException e) {
			// Do nothing;
			return false;
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return 
	 */
	static public boolean isViewOpened(IEvaluationContext	context) {
		try {
			return findView(context)!=null;
		} catch (NotFoundException e) {
			// Do nothing;
			return false;
		}
	}
	
	public static IWorkbenchWindow getActiveWorkbenchWindow(IEvaluationContext	context) {
		Object o = HandlerUtil.getVariable(context, ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
		if (o instanceof IWorkbenchWindow) {
			return (IWorkbenchWindow) o;
		}
		return null;
	}

}
