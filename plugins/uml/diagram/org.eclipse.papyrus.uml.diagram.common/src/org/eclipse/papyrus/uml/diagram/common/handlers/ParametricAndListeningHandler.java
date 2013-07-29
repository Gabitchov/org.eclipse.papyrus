/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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

package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.util.Hashtable;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This abstract command handler: - calculates the current selection -
 * calculates the visibility and enablement based on command executability -
 * executes the command in Papyrus command stack - listen the SelectionService
 * (usefull when the action is inside a Menu (like Diagram)
 */
public abstract class ParametricAndListeningHandler extends GraphicalCommandHandler implements IExecutableExtension {

	/** the selection service */
	private ISelectionService serv = null;

	/** this handler */
	private ParametricAndListeningHandler thisHandler;

	/** parameter for this handler */
	protected String parameter = null;

	/** parameter ID */
	protected String parametedID = null;

	/** listener on the selection */
	protected ISelectionListener listener = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ParametricAndListeningHandler() {
		this.thisHandler = this;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ParametricAndListeningHandler(String parameterID) {
		this.thisHandler = this;
		this.parametedID = parameterID;
	}

	/**
	 * This method add a listener on the selection service and return a command
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return {@link UnexecutableCommand}
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		addSelectionListener();
		return UnexecutableCommand.INSTANCE;
	}

	/***
	 * Add a listener on the selection, in order to refresh the status of the
	 * action when the selection changes
	 */
	protected void addSelectionListener() {
		// when we are in the Menu, we need to refresh
		if(serv == null) {// should be always!=null after the first call to
							// getCommand()
			IWorkbench workbench = PlatformUI.getWorkbench();

			if(workbench != null) {
				IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
				if(workbenchWindow != null) {
					this.serv = workbenchWindow.getSelectionService();
					if(this.serv != null) {
						this.listener = new ISelectionListener() {

							public void selectionChanged(IWorkbenchPart part, ISelection selection) {
								refreshMenu();
							}
						};

						serv.addSelectionListener(listener);
					}
				}
			}
		}
	}

	/**
	 * If the handled action is in a Menu, we need to refresh the handler status
	 */
	protected void refreshMenu() {
		fireHandlerChanged(new HandlerEvent(thisHandler, true, false));
	}

	/**
	 * Initialize the field {@link #parameter}
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 *      java.lang.Object)
	 * 
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(data instanceof Hashtable && this.parametedID != null) {
			this.parameter = (String)((Hashtable)data).get(this.parametedID);
		}
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		if(this.serv != null && this.listener != null) {
			this.serv.removeSelectionListener(listener);
		}
	}

}
