/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * this is an helper that redirect destroy request to get destroy command from uml plugin
 *
 */

public class ActivityNodeHelper extends ElementEditHelper {

	@Override
	protected ICommand getBasicDestroyElementCommand(DestroyElementRequest req) {
		ICommand result = req.getBasicDestroyCommand();

		if (result == null) {
			result = new DestroyActivityNode(req);
		} else {
			// ensure that re-use of this request will not accidentally
			//    propagate this command, which would destroy the wrong object
			req.setBasicDestroyCommand(null);
		}

		return result;
	}

	/**
	 * inner class for the destruction of element
	 *
	 */
	private class DestroyActivityNode extends DestroyElementCommand{


		private Command emfcmd=null;
		public DestroyActivityNode(DestroyElementRequest request) {
			super(request);
		}
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
			//this code comes from super class and we replace explicitly by a call of the command of UML
			// for node specific commands have been done
			EObject destructee = getElementToDestroy();

			// only destroy attached elements
			if ((destructee != null) && (destructee.eResource() != null)) {
				
				// here has been commented because uml commands take all in charge
				// tear down incoming references
				//tearDownIncomingReferences(destructee);

				// also tear down outgoing references, because we don't want
				//    reverse-reference lookups to find destroyed objects
				//tearDownOutgoingReferences(destructee);

				// remove the object from its container
				emfcmd=DeleteCommand.create(getRequest().getEditingDomain(),getElementToDestroy());
				if (emfcmd != null && emfcmd.canExecute()) {
					emfcmd.execute();
				}

			// here has been commented because uml commands take all in charge	
			// in case it was cross-resource-contained
			//	Resource res = destructee.eResource();
			//	if (res != null) {
			//res.getContents().remove(destructee);
			//	}
			}

			return CommandResult.newOKCommandResult();
		}


		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// The undo has to be explicitly called 
			emfcmd.canUndo();	
			emfcmd.undo();

			return Status.OK_STATUS;
		}

		@Override
		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// The redo has to be explicitly called 
			//IStatus status =super.doRedo(monitor, info);
			// IStatus status =super.doRedo(monitor, info);
			// emfcmd.canExecute();
			emfcmd.redo();
			
			return Status.OK_STATUS;
		}
	}

}
