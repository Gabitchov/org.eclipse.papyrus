/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This handler allows to Close Diagrams and Tables
 * 
 * 
 * 
 */
public class CloseHandler extends AbstractModelExplorerHandler implements IExecutableExtension {

	/** parameters for this action */
	/**
	 * close all open elements
	 */
	public static final String PARAMETER_ALL = "all"; //$NON-NLS-1$

	/**
	 * Close only the selected elements
	 */
	public static final String PARAMETER_SELECTION = "selection"; //$NON-NLS-1$

	/** parameter for this handler */
	protected String parameter = null;

	/** parameter ID */
	protected String parameterID = "close_parameter"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IPageMngr pageMngr = getPageManager();
		if(selection instanceof IStructuredSelection && pageMngr != null) {
			if(PARAMETER_SELECTION.equals(parameter)) {
				Iterator<?> iter = ((IStructuredSelection)selection).iterator();
				while(iter.hasNext()) {
					pageMngr.closePage(iter.next());
				}
			} else if(PARAMETER_ALL.equals(parameter)) {
				pageMngr.closeAllOpenedPages();
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 *      java.lang.Object)
	 * 
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(data instanceof Hashtable && this.parameterID != null) {
			this.parameter = (String)((Hashtable)data).get(this.parameterID);
		}
	}

}
