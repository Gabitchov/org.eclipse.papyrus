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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class provides the state for the Delete Action in the Model Explorer.
 * This state is used to refresh the status of this action in the Edit Menu.
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 * 
 */
public class ActionStateSourceProvider extends AbstractSourceProvider {

	/**
	 * The name of the variable to check.
	 */
	public static final String DELETE_IN_MODEL_EXPLORER = "deleteInModelExplorer"; //$NON-NLS-1$

	/**
	 * The enabled state value.
	 */
	private static final String ENABLED = "enabled"; //$NON-NLS-1$

	/**
	 * The disabled state value.
	 */
	private static final String DISABLED = "disabled"; //$NON-NLS-1$

	/**
	 * Map used to register the state of the actions
	 */
	private final HashMap<String, String> currentState = new HashMap<String, String>(2);

	/**
	 * The selection service
	 */
	private ISelectionService selectionService;

	/**
	 * The listener for the selection service
	 */
	private ISelectionListener selectionListener;

	/**
	 * the listener for the part service
	 */
	private IPartService partService;

	/**
	 * The listener for the part service
	 */
	private IPartListener partListener;

	/**
	 * Title of the activated part
	 */
	private String title = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ActionStateSourceProvider() {
		currentState.put(DELETE_IN_MODEL_EXPLORER, DISABLED);
		selectionListener = new SelectionListener();
		partListener = new PartListener();
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#dispose()
	 * 
	 */
	public void dispose() {
		if(selectionService != null) {
			selectionService.removeSelectionListener(selectionListener);
		}
		if(partService != null) {
			partService.removePartListener(partListener);
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getCurrentState()
	 * 
	 * @return
	 */
	public Map<String, String> getCurrentState() {
		addSelectionListener();
		addPartListener();
		return currentState;
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	public String[] getProvidedSourceNames() {
		return new String[]{ DELETE_IN_MODEL_EXPLORER };
	}

	/**
	 * Adds a listener on the selection service if the field {@link #selectionService} is <code>null</code>
	 */
	protected void addSelectionListener() {
		if(this.selectionService == null) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					IWorkbench workbench = PlatformUI.getWorkbench();
					selectionService = (ISelectionService)workbench.getService(ISelectionService.class);
					IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
					if(activeWorkbench != null) {
						selectionService = activeWorkbench.getSelectionService();
						if(selectionService != null) {
							selectionService.addSelectionListener(selectionListener);
						}
					}
				}
			});
		}
	}

	protected void addPartListener() {
		if(this.partService == null) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					IWorkbench workbench = PlatformUI.getWorkbench();
					partService = (IPartService)workbench.getService(IPartService.class);
					IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
					if(activeWorkbench != null) {
						partService = activeWorkbench.getPartService();
						if(partService != null) {
							partService.addPartListener(partListener);
						}
					}
				}
			});
		}
	}

	/**
	 * Refresh the state of the Delete Action
	 */
	protected boolean testDeleteFromModelExplorer() {
		DeleteCommandHandler handler = new DeleteCommandHandler();
		return isSelectionInModelExplorer() && handler.isEnabled();
	}

	/**
	 * Tests if the Delete action can be executed
	 * 
	 * @return
	 *         <code>true</code> if the Delete action can be executed <code>false</code> if not
	 */
	protected void refreshDeleteAction() {
		String oldState = currentState.get(DELETE_IN_MODEL_EXPLORER);
		String newState = (testDeleteFromModelExplorer() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(DELETE_IN_MODEL_EXPLORER, newState);
			fireSourceChanged(ISources.WORKBENCH, currentState);
		}
	}

	/**
	 * Test if the current ActivePart is the Model Explorer
	 * 
	 * @return
	 *         <code>true</code> if the current activePart is the Model Explorer <code>false</code> if not
	 */
	protected boolean isSelectionInModelExplorer() {
		return (title != null) ? title.equals("Model Explorer") : false;
	}

	/**
	 * The class {@link PartListener}
	 */
	public class PartListener implements IPartListener {

		/**
		 * {@inheritDoc}
		 */
		public void partOpened(IWorkbenchPart part) {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		public void partDeactivated(IWorkbenchPart part) {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		public void partClosed(IWorkbenchPart part) {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		public void partBroughtToTop(IWorkbenchPart part) {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		public void partActivated(IWorkbenchPart part) {
			title = part.getTitle();
			refreshDeleteAction();
		}
	}

	/**
	 * This class provides the listener for the selection service
	 */
	public class SelectionListener implements ISelectionListener {

		/**
		 * {@inheritDoc}
		 */
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			refreshDeleteAction();
		}
	}
}
