/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.uml2.uml.Package;





// TODO: Auto-generated Javadoc
/**
 * The Class ExportAppliedProfileHandler.
 */
public class ExportAppliedProfileHandler extends AbstractCommandHandler {



	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand() {

		if(canExecute()) {

			AbstractTransactionalCommand cmd = new ExportProfilesCommand(getEditingDomain(), Messages.ExportAppliedProfileHandler_0, null);
			return new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(cmd);
		}

		else
			return UnexecutableCommand.INSTANCE;
	}





	/**
	 * Can execute.
	 * 
	 * @return true, if successful
	 */
	public boolean canExecute() {
		if(getSelectedElements().size() == 1) {
			return (getSelectedElement() instanceof Package);
		}
		return false;
	}



}
