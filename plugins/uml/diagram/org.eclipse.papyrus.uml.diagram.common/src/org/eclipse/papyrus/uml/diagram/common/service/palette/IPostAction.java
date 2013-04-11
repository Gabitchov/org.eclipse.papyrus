/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * Interface implemented by post exectuion actions
 */
public interface IPostAction extends IAspectAction {

	/**
	 * command that will be execute after the creation command
	 * 
	 * @param viewAdapter
	 * 	an adapter to retrieve the view created by the creation command.
	 *	the view will be available in the adapter
	 *  during the execute() of the command but is not available when
	 *  this method is called.
	 * @return
	 */
	public ICommand getPostCommand(IAdaptable viewAdapter);

	/**
	 * Do an action after the edit part has been created from the view.
	 * This is executed in post commit so you can't run a transactional command
	 * Except in unprotected mode which is dangerous.
	 * Please consider the use of getPostCommand instead if possible.
	 * 
	 * @param editPart
	 */
	public void runInPostCommit(EditPart editPart);

	/**
	 * Needs to return true if an action is specified in runInPostCommit()
	 * @return
	 */
	public boolean needsPostCommitRun();

}
