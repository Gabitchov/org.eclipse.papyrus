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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.PortDropHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.TypeDropHelper;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Port;

/**
 * <pre>
 * Customization of the DND edit policy for BlockPropertyComposite that enables 
 * type modification, or creation of new Port and FlowPort by a drop on target.
 * </pre>
 */
public class CustomBlockPropertyCompositeDropEditPolicy extends CustomDragDropEditPolicy {

	/** Default constructor */
	public CustomBlockPropertyCompositeDropEditPolicy() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		Set<String> specificDropBehaviorTypes = super.getSpecificDropBehaviorTypes();

		specificDropBehaviorTypes.add(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID);
		specificDropBehaviorTypes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID);

		return specificDropBehaviorTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getSpecificDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject, String nodeType, String edgeType) {
		if((UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID.equals(nodeType)) || (SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID.equals(nodeType))) {
			PortDropHelper portDropHelper = new PortDropHelper(getEditingDomain());
			Command portDropCommand = portDropHelper.getDropPortOnPart((Port)droppedEObject, dropRequest.getLocation().getCopy(), (GraphicalEditPart)getHost());
			return new CommandProxy(portDropCommand);
		}

		return super.getSpecificDropCommand(dropRequest, droppedEObject, nodeType, edgeType);
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

			// 2. Try to create a Port typed by the dropped object
			Command dropAsTypedPort = helper.getDropAsTypedPortOnPart(dropRequest, (GraphicalEditPart)getHost());
			if((dropAsTypedPort != null) && (dropAsTypedPort.canExecute())) {
				commandChoice.add(dropAsTypedPort);
			}

			// 3. Try to create a FlowPort (In - Out - InOut) typed by the dropped object 
			Command dropAsTypedFlowPort_In = helper.getDropAsTypedFlowPortOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.FLOW_PORT);
			if((dropAsTypedFlowPort_In != null) && (dropAsTypedFlowPort_In.canExecute())) {
				commandChoice.add(dropAsTypedFlowPort_In);
			}
			Command dropAsTypedFlowPort_Out = helper.getDropAsTypedFlowPortOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.FLOW_PORT_IN);
			if((dropAsTypedFlowPort_Out != null) && (dropAsTypedFlowPort_Out.canExecute())) {
				commandChoice.add(dropAsTypedFlowPort_Out);
			}
			Command dropAsTypedFlowPort_InOut = helper.getDropAsTypedFlowPortOnPart(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.FLOW_PORT_OUT);
			if((dropAsTypedFlowPort_InOut != null) && (dropAsTypedFlowPort_InOut.canExecute())) {
				commandChoice.add(dropAsTypedFlowPort_InOut);
			}

			//			Same behavior for 4 & 5
			//			// 4. Build command to drop Port and FlowPort
			//			PortDropHelper portDropHelper = new PortDropHelper(getEditingDomain());
			//			Command dropPortOnPart = portDropHelper.getDropPortOnPart(dropRequest, (GraphicalEditPart)getHost());
			//			if ((dropPortOnPart != null) && (dropPortOnPart.canExecute())) {
			//				commandChoice.add(dropPortOnPart);
			//			}

			// 5. Build default drop command (show view of the dropped object)
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
