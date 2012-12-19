/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.TypeDropHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * <pre>
 * Customization of the DND edit policy for TypedElement (Port, Part, Reference, FlowPort), that enables 
 * type modification by a drop on target.
 * </pre>
 */
public class TypedElementDropEditPolicy extends CustomDragDropEditPolicy {

	/** Default constructor */
	public TypedElementDropEditPolicy() {
		super();
	}

	/**
	 * {@inheritedDoc}.
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		TypeDropHelper helper = new TypeDropHelper(getEditingDomain());

		// Single drop management possible drop action list can be proposed
		if(dropRequest.getObjects().size() == 1) {

			// List of available drop commands
			final List<Command> commandChoice = new ArrayList<Command>();

			// 1. Try to set the target element type with dropped object
			Command dropAsSetType = helper.getDropAsTypedElementType(dropRequest, (GraphicalEditPart)getHost());
			if((dropAsSetType != null) && (dropAsSetType.canExecute())) {
				commandChoice.add(dropAsSetType);
			}

			// 3. Build default drop command (show view of the dropped object)
			Command defaultDropCommand = super.getDropObjectsCommand(dropRequest);
			defaultDropCommand.setLabel("Default drop (Show dropped object in diagram)");
			if((defaultDropCommand != null) && (defaultDropCommand.canExecute())) {
				commandChoice.add(defaultDropCommand);
			}

			// Prepare the selection command (if several command are available) or return the drop command
			if(commandChoice.size() > 1) {
				RunnableWithResult<ICommand> runnable;
				Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<ICommand>() {

					public void run() {
						setResult(new SelectAndExecuteCommand("Select drop action for ", PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), commandChoice));
					}
				});

				ICommand selectCommand = runnable.getResult();

				return new ICommandProxy(selectCommand);
			} else if(commandChoice.size() == 1) {
				return commandChoice.get(0);
			}

			// else (command choice is empty)
			return UnexecutableCommand.INSTANCE;

		}

		return super.getDropObjectsCommand(dropRequest);
	}
}
