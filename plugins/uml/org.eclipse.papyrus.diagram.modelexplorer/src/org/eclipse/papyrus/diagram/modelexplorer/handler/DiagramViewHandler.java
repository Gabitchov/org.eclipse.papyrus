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
package org.eclipse.papyrus.diagram.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.diagram.modelexplorer.DiagramContentProvider;
import org.eclipse.papyrus.diagram.modelexplorer.DiagramLabelProvider;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProviderWTooltips;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
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
		IViewPart part = org.eclipse.papyrus.modelexplorer.NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID); 
		// the part is only a book, retrieving correct page
		if (part instanceof ModelExplorerPageBookView) {
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

		if(((ToolItem)((Event)event.getTrigger()).widget).getSelection()){
			getCommonNavigator().getCommonViewer().setContentProvider(new DiagramContentProvider());
			getCommonNavigator().getCommonViewer().setLabelProvider(new DiagramLabelProvider());
		}
		else{
			getCommonNavigator().getCommonViewer().setContentProvider(new MoDiscoContentProvider());
			getCommonNavigator().getCommonViewer().setLabelProvider(new MoDiscoLabelProviderWTooltips());
		}
		getCommonNavigator().getCommonViewer().refresh();
		return null;
	}





}
