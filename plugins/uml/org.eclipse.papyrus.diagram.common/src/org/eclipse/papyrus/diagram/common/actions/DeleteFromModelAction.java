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
package org.eclipse.papyrus.diagram.common.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.AbstractDeleteFromAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * The action Delete From Model
 * 
 * This code is a copy of the generated code for each diagram before
 * we add this action in the common. (@see Bug 267163)
 * 
 */
public class DeleteFromModelAction extends AbstractDeleteFromAction {

	public DeleteFromModelAction() {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param part
	 */
	public DeleteFromModelAction(IWorkbenchPart part) {
		super(part);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 */
	public DeleteFromModelAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#init()
	 * 
	 */
	@Override
	public void init() {
		super.init();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommandLabel()
	 * 
	 * @return
	 */
	@Override
	protected String getCommandLabel() {
		return DiagramUIMessages.DiagramEditor_Delete_from_Model;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCommand(Request request) {
		List operationSet = getOperationSet();
		if(operationSet.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}
		Iterator editParts = operationSet.iterator();
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(getEditingDomain(), getCommandLabel());
		while(editParts.hasNext()) {
			EditPart editPart = (EditPart)editParts.next();
			Command curCommand = editPart.getCommand(request);
			if(curCommand != null) {
				command.compose(new CommandProxy(curCommand));
			}
		}
		if(command.isEmpty() || command.size() != operationSet.size()) {
			return UnexecutableCommand.INSTANCE;
		}
		return new ICommandProxy(command);
	}
}
