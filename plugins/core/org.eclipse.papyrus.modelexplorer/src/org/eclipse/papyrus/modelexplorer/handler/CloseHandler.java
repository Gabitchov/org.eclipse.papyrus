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
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
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
		IPageMngr pageMngr = getPageManager();
		if(pageMngr == null) {
			return null;
		}
		
		// What kind of command ?
		if(PARAMETER_ALL.equals(parameter)) {
			pageMngr.closeAllOpenedPages();
		}
		
		// Try to close each selected editor.
		// There is no common type for object representing an editor. So,
		// We try to get the EObject, and try to close it as an Editor.
		List<EObject> selectedProperties = getCurrentSelectionAdaptedToType( event, EObject.class );
		if( selectedProperties == null) {
			// nothing to do
			return null;
		}
		
		
		// Check each selected object
		for( EObject selected : selectedProperties) {
			
				pageMngr.closePage(selected);
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
