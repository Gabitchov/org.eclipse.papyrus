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

package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.CustomCommonViewer;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonViewerSorter;


/**
 * this handler is used to set a sorter on the model explorer
 */
public class SortElementHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(Activator.getDefault().getCustomizationManager() != null) {
			TreeViewer selectedTreeViewer = getSelectedTreeViewer(event);
			if(selectedTreeViewer == null) {
				return null;
			}

			if(((ToolItem)((Event)event.getTrigger()).widget).getSelection()) {


				selectedTreeViewer.setSorter(new CommonViewerSorter());
				if(selectedTreeViewer instanceof CustomCommonViewer) {
					((CustomCommonViewer)selectedTreeViewer).getDropAdapter().setFeedbackEnabled(false);
				}
			} else {
				selectedTreeViewer.setSorter(null);
				if(selectedTreeViewer instanceof CustomCommonViewer) {
					((CustomCommonViewer)selectedTreeViewer).getDropAdapter().setFeedbackEnabled(true);
				}
			}

			getSelectedTreeViewer(event).refresh();
		}
		return null;
	}

	/**
	 * used to obtain the tree viewer of the model explorer
	 * 
	 * @param event
	 * @return
	 */
	protected TreeViewer getSelectedTreeViewer(ExecutionEvent event) {
		// Try to get the active part
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);

		if(activePart instanceof TreeViewer) {
			return (TreeViewer)activePart;
		}

		if(activePart instanceof MultiViewPageBookView) {
			MultiViewPageBookView pageBookView = (MultiViewPageBookView)activePart;
			IViewPart viewPart = pageBookView.getActiveView();
			if(viewPart instanceof ModelExplorerView) {
				return ((ModelExplorerView)viewPart).getCommonViewer();
			}
		}

		// Not found
		return null;
	}
}
