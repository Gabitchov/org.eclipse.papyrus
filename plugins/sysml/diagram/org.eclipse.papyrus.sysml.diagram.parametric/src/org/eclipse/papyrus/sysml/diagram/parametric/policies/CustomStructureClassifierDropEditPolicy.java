/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.parametric.utils.BlockDropHelper;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <pre>
 * Customization of the DND edit policy for the StructureClassifier compartments, that enables the direct
 * creation of typed Part, Reference, ConstraintProperty, Value, ActorPart or Property by dragging types in a Block structure compartment.
 * </pre>
 */
public class CustomStructureClassifierDropEditPolicy extends CustomDragDropEditPolicy {

	/** Default constructor */
	public CustomStructureClassifierDropEditPolicy() {
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

			// 1. Try to create a Part typed by the dropped object
			Command dropAsTypedPart = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.PART_PROPERTY);
			if((dropAsTypedPart != null) && (dropAsTypedPart.canExecute())) {
				commandChoice.add(dropAsTypedPart);
			}

			// 2. Try to create a Reference typed by the dropped object
			Command dropAsTypedReference = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.REFERENCE_PROPERTY);
			if((dropAsTypedReference != null) && (dropAsTypedReference.canExecute())) {
				commandChoice.add(dropAsTypedReference);
			}

			// 3. Try to create an ActorPart typed by the dropped object
			Command dropAsTypedActorPart = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.ACTOR_PART_PROPERTY);
			if((dropAsTypedActorPart != null) && (dropAsTypedActorPart.canExecute())) {
				commandChoice.add(dropAsTypedActorPart);
			}

			// 4. Try to create a Value typed by the dropped object
			Command dropAsTypedValue = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.VALUE_PROPERTY);
			if((dropAsTypedValue != null) && (dropAsTypedValue.canExecute())) {
				commandChoice.add(dropAsTypedValue);
			}

			// 5. Try to create a Property typed by the dropped object
			Command dropAsTypedProperty = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), UMLElementTypes.PROPERTY);
			if((dropAsTypedProperty != null) && (dropAsTypedProperty.canExecute())) {
				commandChoice.add(dropAsTypedProperty);
			}
			
			// 6. Try to create a ConstraintProperty typed by the dropped object
			Command dropAsTypedConstraintProperty = helper.getDropAsStructureItem(dropRequest, (GraphicalEditPart)getHost(), SysMLElementTypes.CONSTRAINT_PROPERTY);
			if((dropAsTypedConstraintProperty != null) && (dropAsTypedConstraintProperty.canExecute())) {
				commandChoice.add(dropAsTypedConstraintProperty);
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected View getReferenceViewForConnectorEnd() {
		return ViewUtil.getContainerView(super.getReferenceViewForConnectorEnd());
	}
	
	@Override
	protected ICommand getDropObjectCommand(DropObjectsRequest dropRequest, EObject droppedObject) {
		View dropTargetView = ((IGraphicalEditPart)getHost()).getNotationView();
		EObject dropTargetElement = dropTargetView.getElement();

		EObject diagramOwner = getDiagramOwner(dropTargetView);
		if (UMLUtil.getStereotypeApplication((Element)diagramOwner, ConstraintBlock.class) != null) {
			// ConstraintBlock
			if (UMLUtil.getStereotypeApplication((Element)dropTargetElement, ConstraintProperty.class) == null) {
				// only ConstraintProperty can be dropped in structure compartment of a diagram owned by a ConstraintBlock
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}
		}
		return super.getDropObjectCommand(dropRequest, droppedObject);
	}

	private EObject getDiagramOwner(View dropTargetView) {
		Diagram diagram = dropTargetView.getDiagram();
		EObject diagramOwer = diagram.getElement();
		return diagramOwer;
	}
}
