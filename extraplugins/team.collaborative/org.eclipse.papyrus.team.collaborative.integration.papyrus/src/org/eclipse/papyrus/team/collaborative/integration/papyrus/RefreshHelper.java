/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Olivier Melois <a href="mailto:olivier.melois@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Helper used to store method for refreshin model explorer view
 * 
 * @author omelois
 * 
 */
public final class RefreshHelper {


	private RefreshHelper() {
	}


	/**
	 * Runnable that will be used to refresh the model explorer view
	 * 
	 * @author adaussy
	 * 
	 */
	public static final class RefreshModelExplorerRunnable implements Runnable {

		private final Collection<EObject> elementsToRefresh;

		private static final int TIME_TO_REFRESH_MODEL_EXPLORER = 100;

		/**
		 * @param elementsToRefresh
		 *        Element to Refresh
		 */
		public RefreshModelExplorerRunnable(Collection<EObject> elementsToRefresh) {
			this.elementsToRefresh = elementsToRefresh;
		}

		@Override
		public void run() {

			try {
				Thread.sleep(TIME_TO_REFRESH_MODEL_EXPLORER);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(elementsToRefresh != null) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if(activePage != null) {
					IViewReference viewRef = activePage.findViewReference(ModelExplorerPageBookView.VIEW_ID);
					if(viewRef != null && viewRef.getView(false) instanceof ModelExplorerView) {
						ModelExplorerView modelExplorerView = (ModelExplorerView)viewRef.getView(false);
						modelExplorerView.refresh();
//						Set<Object> alreadyRefreshed = new HashSet<Object>();
//						if(view != null) {
//							for(EObject elementToRefresh : elementsToRefresh) {
//								
//								view.refreshObject(elementToRefresh, alreadyRefreshed);
//								alreadyRefreshed.add(elementToRefresh);
//							}
//						}
					}
				}
//				IViewReference[] viewReferences = activePage.getViewReferences();
//				for(IViewReference viewRef : viewReferences) {
//					if(viewRef.getId().equals(ModelExplorerPageBookView.VIEW_ID));
//				}
				
			}
		}
	}

	protected static final String ELEMENTS_TO_REFRESH_KEY = "elementsToRefresh"; //$NON-NLS-1$

	/**
	 * Get the model explorer refresh command
	 * 
	 * @param request
	 *        IEditCommandRequest which implies refresh
	 * @return
	 */
	public static ICommand getRefreshCommand(final IEditCommandRequest request) {
		return new AbstractCommand("Refresh") //$NON-NLS-1$
		{

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				refreshPostMove(request);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				refreshPostMove(request);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				refreshPostMove(request);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * Function to asynchronously refresh the model explorer after moving a breakdown element.
	 * 
	 * @param request
	 */
	private static void refreshPostMove(final IEditCommandRequest request) {
		@SuppressWarnings("unchecked")
		final Set<EObject> elementsToRefresh = (Set<EObject>)request.getParameter(ELEMENTS_TO_REFRESH_KEY);

		refreshModelExplorer(elementsToRefresh);
	}

	public static void refreshModelExplorer(Collection<EObject> elementsToRefresh) {
		if(elementsToRefresh != null && !(elementsToRefresh.isEmpty())) {
			Display.getDefault().asyncExec(new RefreshModelExplorerRunnable(elementsToRefresh));
		}
	}

	/**
	 * Adds an element to the list of elements that should be refreshed, in the request.
	 * 
	 * @param element
	 *        Element you want to refresh
	 * @param request
	 *        Request in which the information about a refresh will be added
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addElementToRefresh(EObject element, IEditCommandRequest request) {
		Object elementsToRefresh = request.getParameter(ELEMENTS_TO_REFRESH_KEY);
		if(elementsToRefresh == null) {
			elementsToRefresh = new HashSet<EObject>();
			request.getParameters().put(ELEMENTS_TO_REFRESH_KEY, elementsToRefresh);
		}
		if(elementsToRefresh instanceof Set<?>) {
			((Set)elementsToRefresh).add(element);
		}
	}

	/**
	 * Checks whether a request has elements to refresh;
	 * 
	 * @param request
	 *        Request in which the information about a refresh will be added
	 * @return
	 */
	public static boolean hasElementsToRefresh(IEditCommandRequest request) {
		Object elementsToRefresh = request.getParameter(ELEMENTS_TO_REFRESH_KEY);
		return elementsToRefresh instanceof Set<?> && (!((Set<?>)elementsToRefresh).isEmpty());
	}
}
