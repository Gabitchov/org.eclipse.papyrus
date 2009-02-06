/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parameter;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.uml2.uml.Operation;

public class EditPropertyParametersCommand extends EditElementCommand {

	private final Operation myOldOperation;

	private final Operation myNewOperation;

	EditPropertyParametersCommand(Operation oldOperation, Operation newOperation) {
		super("Edit Property Parameters", oldOperation, new EmptyRequest(oldOperation));
		myOldOperation = oldOperation;
		myNewOperation = newOperation;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		myOldOperation.getOwnedParameters().clear();
		myOldOperation.getOwnedParameters().addAll(myNewOperation.getOwnedParameters());
		return CommandResult.newOKCommandResult(myOldOperation);
	}

	private static class EmptyRequest extends AbstractEditCommandRequest {

		EmptyRequest(EObject object) {
			super(TransactionUtil.getEditingDomain(object));
		}

		public Object getEditHelperContext() {
			return null;
		}
	}
}
