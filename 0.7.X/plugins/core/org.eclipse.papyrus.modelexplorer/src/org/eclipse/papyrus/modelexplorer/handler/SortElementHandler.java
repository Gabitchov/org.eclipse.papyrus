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

package org.eclipse.papyrus.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.CustomCommonViewer;
import org.eclipse.papyrus.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewerSorter;
/**
 * this handler is used to set a sorter on the model explorer
 *
 */
public class SortElementHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().getCustomizationManager() != null) {
			CustomizationManager customizationManager = Activator.getDefault()
			.getCustomizationManager();
			if(((ToolItem)((Event)event.getTrigger()).widget).getSelection()){
				getSelectedTreeViewer(event).setSorter(new CommonViewerSorter());
				if(getSelectedTreeViewer(event) instanceof CustomCommonViewer){
					((CustomCommonViewer)getSelectedTreeViewer(event)).getDropAdapter().setFeedbackEnabled(false);
				}
			}
			else{
				getSelectedTreeViewer(event).setSorter(null);
				if(getSelectedTreeViewer(event) instanceof CustomCommonViewer){
					((CustomCommonViewer)getSelectedTreeViewer(event)).getDropAdapter().setFeedbackEnabled(true);
				}
			
			}
			getSelectedTreeViewer(event).refresh();
		}
		return null;
	}

	/**
	 * used to obtain the tree viewer of the model explorer
	 * @param event
	 * @return
	 */
	protected TreeViewer getSelectedTreeViewer(ExecutionEvent event) {

		IWorkbenchPart activePart;
		// Try to get the active part

		// Try to get the TreeViewer from the evaluation context
		if( event.getApplicationContext() instanceof EvaluationContext) {
			EvaluationContext context = (EvaluationContext)event.getApplicationContext();
			// activeEditor, activeSite, selection, activeShell, activePart
			Object site = context.getVariable("activeSite");
			activePart = (IWorkbenchPart)context.getVariable("activePart");
		}
		else {
			activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		}

		if(activePart instanceof TreeViewer)
			return (TreeViewer)activePart;

		if( activePart instanceof MultiViewPageBookView)
		{
			MultiViewPageBookView pageBookView =(MultiViewPageBookView)activePart;
			IViewPart viewPart =  pageBookView.getActiveView();
			if(viewPart instanceof ModelExplorerView)
			{
				return ((ModelExplorerView)viewPart).getCommonViewer();
			}
		}

		// Not found
		return null;
	}
}
