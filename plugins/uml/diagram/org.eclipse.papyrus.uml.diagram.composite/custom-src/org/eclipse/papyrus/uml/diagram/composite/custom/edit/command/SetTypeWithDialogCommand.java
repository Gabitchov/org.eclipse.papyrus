/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * This command set the type of a typed element with the dropped type. A confirmation dialog opens in case the TypedElement is already typed.
 */
public class SetTypeWithDialogCommand extends SetValueCommand {

	protected SetRequest request;

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		CommandResult result;
		Object currentValue = getElementToEdit().eGet(request.getFeature());
		if(currentValue != null) {
			String[] labels = new String[2];
			labels[0] = "OK";
			labels[1] = "Cancel";
			MessageDialog dialog = new MessageDialog(new Shell(), "Confirm changes", null, "Do you want to replace current type ?", MessageDialog.QUESTION_WITH_CANCEL, labels, 0);
			dialog.open();
			switch(dialog.getReturnCode()) {
			case MessageDialog.OK:
				result = super.doExecuteWithResult(monitor, info);
				break;
			default:
				result = CommandResult.newOKCommandResult();
				break;
			};

		} else {
			result = super.doExecuteWithResult(monitor, info);
		}

		return result;
	}

	public SetTypeWithDialogCommand(SetRequest request) {
		super(request);
		this.request = request;
	}

}
