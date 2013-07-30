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
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.tools.AbstractConnectionCreationTool;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.uml.diagram.common.editparts.IEditpartListenerAccess;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLConnectionNodeEditPart;

/**
 * this class has to be used at very specific situation: During the
 * transformation of a binary link to multi -nary links, you need to remove the
 * link that is the source or the target of the new link. during the delete,
 * several listener has trigger (a cycle is created) and finally the active tool
 * close the transaction
 * 
 * In order to avoid the raise of the listener, one of editpartlisteners is
 * removed in the connectioneditpart before doing the deletion This listener is
 * created by the active tool. In this class, the listener editpart of
 * AbstractConnectionCreationTool is removed. in order to remove the editpart
 * listener the editpart must implements IEditpartListenerAccess
 * 
 * 
 */

public class DeleteLinkDuringCreationCommand extends DeleteCommand {

	/** the view that will suppressed **/
	protected Edge edge = null;

	/** the editpart viewer **/
	protected EditPartViewer viewer = null;

	/**
	 * 
	 * Constructor
	 * 
	 * @param editingDomain
	 *        in order to run this command
	 * @param view
	 *        has not to be null
	 * @param viewer
	 *        has not to be null
	 */
	public DeleteLinkDuringCreationCommand(TransactionalEditingDomain editingDomain, Edge view, EditPartViewer viewer) {
		super(editingDomain, view);

		assert (view != null);
		assert (viewer != null);

		this.edge = view;
		this.viewer = viewer;

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		// find editpartlistener to remove
		Map epRegistry = viewer.getEditPartRegistry();
		// the listener to remove
		EditPartListener listenerToRemove = null;
		// the graphical editpart to delete
		IGraphicalEditPart editPart = (IGraphicalEditPart)epRegistry.get(edge);

		if(editPart instanceof IEditpartListenerAccess) {
			Iterator iterlistener = ((UMLConnectionNodeEditPart)editPart).getEventListenerIterator(EditPartListener.class);
			while(iterlistener.hasNext()) {
				Object currentObject = iterlistener.next();

				Class classobject = currentObject.getClass();
				Class activeToolClass = AbstractConnectionCreationTool.class;
				String activeToolClassName = activeToolClass.getName();

				// compare the name of the listener.
				// because it was a inner class private we cannot test the type
				// or access to it
				if(classobject.getName().contains(activeToolClassName)) {
					listenerToRemove = (EditPartListener)currentObject;
				}
			}
		}
		if(listenerToRemove!=null){
			// Finally we remove the listener
			editPart.removeEditPartListener(listenerToRemove);
		}

		// we can do now the job
		CommandResult commandResult = super.doExecuteWithResult(progressMonitor, info);

		return commandResult;
	}
}
