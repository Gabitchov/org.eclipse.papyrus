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
package org.eclipse.papyrus.uml.diagram.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.providers.MoDiscoContentProvider;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.diagram.modelexplorer.Activator;
import org.eclipse.papyrus.uml.diagram.modelexplorer.provider.DiagramContentProvider;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This is a class that launches the button load Customization. this code comes
 * from the {@link LoadCustomizationsDialog}
 */
public class DiagramViewHandler extends AbstractHandler {

	/**
	 * 
	 * 
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.views.modelexplorer.NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		// the part is only a book, retrieving correct page
		if(part instanceof ModelExplorerPageBookView) {
			IViewPart page = ((ModelExplorerPageBookView)part).getActiveView();
			if(page instanceof CommonNavigator) {
				return ((CommonNavigator)page);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ILabelProvider labelProvider;
		try {
			labelProvider = ServiceUtilsForHandlers.getInstance().getService(LabelProviderService.class, event).getLabelProvider();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			labelProvider = new LabelProvider();
		}

		if(((ToolItem)((Event)event.getTrigger()).widget).getSelection()) {
			getCommonNavigator().getCommonViewer().setContentProvider(new DiagramContentProvider());
		} else {
			getCommonNavigator().getCommonViewer().setContentProvider(new MoDiscoContentProvider());
		}
		getCommonNavigator().getCommonViewer().setLabelProvider(labelProvider);
		getCommonNavigator().getCommonViewer().refresh();
		return null;
	}
}
