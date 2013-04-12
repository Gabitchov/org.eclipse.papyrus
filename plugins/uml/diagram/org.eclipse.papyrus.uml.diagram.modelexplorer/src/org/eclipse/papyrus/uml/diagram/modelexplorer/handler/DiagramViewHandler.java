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
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.internal.navigator.filters.UpdateActiveExtensionsOperation;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.INavigatorContentService;

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

	public static final String DIAGRAM_CONTENTS = "org.eclipse.papyrus.views.modelexplorer.DiagramNavigatorContent";

	public static final String UML_MODEL_CONTENTS = "org.eclipse.papyrus.views.modelexplorer.UMLnavigatorContent";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CommonViewer viewer = getCommonNavigator().getCommonViewer();

		String[] newContents = null;

		Object trigger = event.getTrigger();

		if(trigger instanceof Event) {
			//State based on the widget
			Event triggerEvent = (Event)trigger;
			if(triggerEvent.widget instanceof ToolItem) {
				if(((ToolItem)triggerEvent.widget).getSelection()) {
					newContents = new String[]{ DIAGRAM_CONTENTS };
				} else {
					newContents = new String[]{ UML_MODEL_CONTENTS };
				}
			}
		}

		if(newContents == null) {
			//Revert the current state
			INavigatorContentService navigatorContent = viewer.getNavigatorContentService();

			if(navigatorContent.isActive(DIAGRAM_CONTENTS)) {
				newContents = new String[]{ UML_MODEL_CONTENTS };
			} else {
				newContents = new String[]{ DIAGRAM_CONTENTS };
			}
		}

		UpdateActiveExtensionsOperation updateExtensions = new UpdateActiveExtensionsOperation(viewer, newContents);
		updateExtensions.execute(null, null);

		return null;
	}
}
