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
package org.eclipse.papyrus.views.modelexplorer.listener;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.Messages;

/**
 * this class is a listener in charge to manage double on element of the model explorer
 *
 */
public class DoubleClickListener implements IDoubleClickListener {

	private final ServicesRegistry servicesRegistry;

	public DoubleClickListener(ServicesRegistry servicesRegistry) {
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 *
	 */
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		final IPageManager pageManager;
		//get the page Manager
		try {
			pageManager = ServiceUtils.getInstance().getIPageManager(servicesRegistry);
		} catch (Exception e) {
			Activator.log.error(Messages.DoubleClickListener_Error_NoLoadManagerToOpen, e);
			return;
		}

		if(pageManager != null) {
			if(selection instanceof IStructuredSelection) {
				Iterator<?> iter = ((IStructuredSelection)selection).iterator();
				final List<EObject> pagesToOpen = new LinkedList<EObject>();
				EObject pageToSelect = null;
				while(iter.hasNext()) {
					Object currentObject = iter.next();
					EObject diag = EMFHelper.getEObject(currentObject);

					if(isPage(diag, pageManager) && canOpenByPolicy(diag)) {
						if(pageManager.isOpen(diag)) {
							pageToSelect = diag;
						} else {
							pagesToOpen.add(diag);
						}
					}
				}

				if(!pagesToOpen.isEmpty()) {
					for(EObject page : pagesToOpen) {
						pageManager.openPage(page);
					}
				} else if(pageToSelect != null) {
					pageManager.selectPage(pageToSelect);
				}
			}

		}
	}

	/**
	 * Determines whether the current policy allows this object to be opened
	 * @param selection The object to open
	 * @return <code>true</code> if the object can be opened
	 */
	private boolean canOpenByPolicy(EObject selection) {
		if (selection instanceof Diagram) {
			Diagram diagram = (Diagram)selection;
			ViewPrototype proto = DiagramUtils.getPrototype(diagram);
			return (proto != ViewPrototype.UNAVAILABLE_VIEW && proto != ViewPrototype.UNAVAILABLE_DIAGRAM);
		}
		return true;
	}
	
	protected boolean isPage(EObject element, IPageManager pageManager) {
		if(pageManager.allPages().contains(element)) {
			return true;
		}

		Object openable = Platform.getAdapterManager().getAdapter(element, IOpenable.class);
		return openable instanceof IOpenable;
	}
}
