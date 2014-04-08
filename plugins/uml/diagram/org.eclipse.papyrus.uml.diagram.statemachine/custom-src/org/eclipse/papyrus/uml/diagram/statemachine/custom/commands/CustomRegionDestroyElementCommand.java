/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.uml2.uml.StateMachine;

/*
 * The default command is fine only the canExecute needs to be changed to 
 * prevent deletion of the last region of a state machine
 */
public class CustomRegionDestroyElementCommand extends DestroyElementCommand {

	public CustomRegionDestroyElementCommand(DestroyElementRequest request) {
		super(request);
	}

	@Override
	public boolean canExecute() {
		if(super.canExecute()) {
			if(getElementToEdit() instanceof StateMachine) {
				StateMachine stateMachine = (StateMachine)getElementToEdit();
				if(stateMachine.getRegions().size() == 1)
					return false;
				return true;
			}
			return true;
			//			else if(getElementToEdit() instanceof State){
			//				State state = (State)getElementToEdit();
			//				if(state.getRegions().size() == 1)
			//					return false;
			//				return true;
			//			}
		}
		return false;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub
		return super.doExecuteWithResult(monitor, info);
	}
}
