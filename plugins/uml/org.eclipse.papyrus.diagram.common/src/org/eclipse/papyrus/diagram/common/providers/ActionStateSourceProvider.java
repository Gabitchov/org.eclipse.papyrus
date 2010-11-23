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
package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.common.handlers.DeleteFromDiagramCommandHandler;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
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
 * This class provides the state of the actions. It's used to refresh
 * the status of these actions in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 */
public class ActionStateSourceProvider extends AbstractSourceProvider {

	/**
	 * The name of the variable to check.
	 */
	public static final String DELETE_IN_DIAGRAM = "deleteInDiagram";

	/**
	 * The enabled state value.
	 */
	private static final String ENABLED = "enabled";

	/**
	 * The disabled state value.
	 */
	private static final String DISABLED = "disabled";

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
	private ISelectionListener listener;

	/**
	 * the listener for the part service
	 */
	private IPartService partService;

	/**
	 * The listener for the part service
	 */
	private IPartListener partListener;

	/**
	 * The activated part
	 */
	private IWorkbenchPart workbenchPart = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ActionStateSourceProvider() {
		currentState.put(DELETE_IN_DIAGRAM, DISABLED);
		listener = new SelectionListener();
		partListener = new PartListener();
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#dispose()
	 * 
	 */
	public void dispose() {
		if(selectionService != null) {
			selectionService.removeSelectionListener(listener);
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
		return new String[]{ DELETE_IN_DIAGRAM };
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
							selectionService.addSelectionListener(listener);
						}
					}
				}
			});
		}
	}

	/**
	 * Adds a listener on the part service
	 */


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
	protected void refreshDeleteAction() {
		String oldState = currentState.get(DELETE_IN_DIAGRAM);
		String newState = (testDeleteFromDiagram() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(DELETE_IN_DIAGRAM, newState);
			fireSourceChanged(ISources.WORKBENCH, currentState);
		}
	}

	/**
	 * Tests if the action DeleteFromDiagram (now called Delete Selected Element can be executed
	 * 
	 * @return
	 *         <code>true</code> if the action DeleteFromDiagram (now called Delete Selected Element can be executed <code>false</code> if not
	 */
	protected boolean testDeleteFromDiagram() {
		DeleteFromDiagramCommandHandler handler = new DeleteFromDiagramCommandHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Test if the current ActivePart is the Model Explorer
	 * 
	 * @return
	 *         <code>true</code> if the current activePart is the Model Explorer <code>false</code> if not
	 */
	protected boolean isSelectionInDiagram() {
		return (workbenchPart instanceof PapyrusMultiDiagramEditor);
	}

	/**
	 * 
	 * The class {@link PartListener}
	 * 
	 * 
	 */
	public class PartListener implements IPartListener {

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partOpened(IWorkbenchPart part) {
			// TODO Auto-generated method stub
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partDeactivated(IWorkbenchPart part) {
			// TODO Auto-generated method stub
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partClosed(IWorkbenchPart part) {
			// TODO Auto-generated method stub

		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partBroughtToTop(IWorkbenchPart part) {
			// TODO Auto-generated method stub

		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partActivated(IWorkbenchPart part) {
			workbenchPart = part;
			refreshDeleteAction();
		}


	}

	/**
	 * 
	 * This class provides the listener for the selection service
	 * 
	 */
	protected class SelectionListener implements ISelectionListener {

		/**
		 * 
		 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
		 * 
		 * @param part
		 * @param selection
		 */
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			refreshDeleteAction();
		}
	}
}
