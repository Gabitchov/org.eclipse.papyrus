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
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.BlockDropHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.PartDropHelper;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * <pre>
 * Customization of the DND edit policy for BlockPropertyComposite that enables 
 * type modification, or creation of new Port and FlowPort by a drop on target.
 * </pre>
 */
public class CustomBlockPropertyStructureCompartmentEditPartDropEditPolicy extends CustomDragDropEditPolicy {

	/** Default constructor */
	public CustomBlockPropertyStructureCompartmentEditPartDropEditPolicy() {
		super();
	}

	/**
	 * {@inheritedDoc}.
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		BlockDropHelper helper = new BlockDropHelper(getEditingDomain());

		// Single drop management possible drop action list can be proposed
		if(dropRequest.getObjects().size() == 1) {

			// List of available drop commands
			final List<Command> commandChoice = new ArrayList<Command>();

			// 1. Build command to drop BlockProperty
			PartDropHelper partDropHelper = new PartDropHelper(getEditingDomain());
			Command dropPartOnPart = partDropHelper.getDropPartOnPart(dropRequest, (GraphicalEditPart)getHost());
			if((dropPartOnPart != null) && (dropPartOnPart.canExecute())) {
				commandChoice.add(dropPartOnPart);
			}

			// 2. Try to create a Part typed by the dropped object
			Command dropAsTypedPart = helper.getDropAsStructureItemOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.PART_PROPERTY);
			if((dropAsTypedPart != null) && (dropAsTypedPart.canExecute())) {
				commandChoice.add(dropAsTypedPart);
			}

			// 3. Try to create a Reference typed by the dropped object
			Command dropAsTypedReference = helper.getDropAsStructureItemOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.REFERENCE_PROPERTY);
			if((dropAsTypedReference != null) && (dropAsTypedReference.canExecute())) {
				commandChoice.add(dropAsTypedReference);
			}

			// 4. Try to create an ActorPart typed by the dropped object
			Command dropAsTypedActorPart = helper.getDropAsStructureItemOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.ACTOR_PART_PROPERTY);
			if((dropAsTypedActorPart != null) && (dropAsTypedActorPart.canExecute())) {
				commandChoice.add(dropAsTypedActorPart);
			}

			// 5. Try to create a Value typed by the dropped object
			Command dropAsTypedValue = helper.getDropAsStructureItemOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.VALUE_PROPERTY);
			if((dropAsTypedValue != null) && (dropAsTypedValue.canExecute())) {
				commandChoice.add(dropAsTypedValue);
			}

			// 6. Try to create a Property typed by the dropped object
			Command dropAsTypedProperty = helper.getDropAsStructureItemOnPart(dropRequest, (GraphicalEditPart)getHost(), UMLElementTypes.PROPERTY);
			if((dropAsTypedProperty != null) && (dropAsTypedProperty.canExecute())) {
				commandChoice.add(dropAsTypedProperty);
			}

			// 7. Build default drop command (show view of the dropped object)
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
