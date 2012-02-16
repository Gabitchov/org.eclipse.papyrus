/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.listener;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.Messages;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

/**
 * this class is a listener in charge to manage double on element of the model explorer
 * 
 */
public class DoubleClickListener implements IDoubleClickListener {

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 * 
	 */
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		IPageMngr pageMngr = null;
		//get the page Manager
		try {
			pageMngr = ServiceUtilsForActionHandlers.getInstance().getIPageMngr();
		} catch (Exception e) {
			Activator.log.error(Messages.DoubleClickListener_Error_NoLoadManagerToOpen, e);
		}
		if(pageMngr != null) {
			if(selection instanceof IStructuredSelection) {
				Iterator<?> iter = ((IStructuredSelection)selection).iterator();
				while(iter.hasNext()) {
					Object currentObject = iter.next();
					EObject diag = NavigatorUtils.getElement(currentObject, EObject.class);
					if(diag != null) {
						/**
						 * Close the diagram if it was already open
						 */
						if(pageMngr.isOpen(diag)) {
							pageMngr.closePage(diag);
						}
						pageMngr.openPage(diag);
					}
				}
			}

		}
	}

}
