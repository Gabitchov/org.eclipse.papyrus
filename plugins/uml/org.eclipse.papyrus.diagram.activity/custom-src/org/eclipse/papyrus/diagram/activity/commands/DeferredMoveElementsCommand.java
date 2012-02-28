/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.commands;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.DeferredMoveRequest;


public class DeferredMoveElementsCommand extends MoveElementsCommand {

	private DeferredMoveRequest request;
	
	public DeferredMoveElementsCommand(DeferredMoveRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	protected EObject getTargetContainer() {
		return request.getTargetContainer();
	}

	@Override
	protected Map getElementsToMove() {
		return request.getElementsToMove();
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (super.canExecute()){			
			return super.doExecuteWithResult(monitor, info);
		}
		return null;
	}
	
	
	
	



	
	
}
