/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.ConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DurationConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.DurationConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.IntervalConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.IntervalConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.TimeConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.TimeConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.uml2.uml.Constraint;

/**
 * This command creates an action's local condition, then the corresponding edit
 * part and the link between the condition and the action.
 */
public class CreateActionLocalConditionViewCommand extends Command {

	/** The compartment which graphically contains the Constraint to create */
	private ActivityActivityContentCompartmentEditPart compartment = null;

	/** The command to create the Constraint element */
	private ICommandProxy elementCreationCommand = null;

	/**
	 * The command to create corresponding views (constraint view and link view)
	 */
	private CompoundCommand viewsCreationCommand = null;

	/** The edit part of the action containing the Constraint element */
	private EditPart linkedActionEditPart;

	/** The type of local condition to create */
	private IHintedType type;

	/**
	 * Constructor a new action to create the local condition and corresponding
	 * views.
	 * 
	 * @param conditionType
	 *        the type of the local condition : precondition
	 *        (Constraint_3011) or postcondition (Constraint_3012)
	 * @param graphicalParent
	 *        the parent edit part which graphically contains the condition
	 * @param containerAction
	 *        the action which owns the local condition to create
	 * @param actionPart
	 *        the part of the action owning the condition
	 */
	public CreateActionLocalConditionViewCommand(IHintedType conditionType, ActivityActivityContentCompartmentEditPart graphicalParent, EObject containerAction, EditPart actionPart) {
		elementCreationCommand = getElementCreationCommand(containerAction, conditionType, graphicalParent);
		compartment = graphicalParent;
		linkedActionEditPart = actionPart;
		type = conditionType;
	}

	/**
	 * Get the Command to create the constraint element
	 * 
	 * @param containerAction
	 *        the action which owns the local condition to create
	 * @param conditionType
	 *        the type of the local condition : precondition
	 *        (Constraint_3011) or postcondition (Constraint_3012)
	 * @return the command to create model element or null
	 */
	private static ICommandProxy getElementCreationCommand(EObject containerAction, IHintedType conditionType, EditPart part) {
		CreateElementRequest createElementReq = new CreateElementRequest(containerAction, conditionType);
		if(UMLElementTypes.Constraint_3011.equals(conditionType)) {
			ConstraintAsLocalPrecondCreateCommand cmd = new ConstraintAsLocalPrecondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.Constraint_3012.equals(conditionType)) {
			ConstraintAsLocalPostcondCreateCommand cmd = new ConstraintAsLocalPostcondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.IntervalConstraint_3032.equals(conditionType)) {
			IntervalConstraintAsLocalPrecondCreateCommand cmd = new IntervalConstraintAsLocalPrecondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.IntervalConstraint_3033.equals(conditionType)) {
			IntervalConstraintAsLocalPostcondCreateCommand cmd = new IntervalConstraintAsLocalPostcondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.DurationConstraint_3034.equals(conditionType)) {
			DurationConstraintAsLocalPrecondCreateCommand cmd = new DurationConstraintAsLocalPrecondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.DurationConstraint_3035.equals(conditionType)) {
			DurationConstraintAsLocalPostcondCreateCommand cmd = new DurationConstraintAsLocalPostcondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.TimeConstraint_3036.equals(conditionType)) {
			TimeConstraintAsLocalPrecondCreateCommand cmd = new TimeConstraintAsLocalPrecondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else if(UMLElementTypes.TimeConstraint_3037.equals(conditionType)) {
			TimeConstraintAsLocalPostcondCreateCommand cmd = new TimeConstraintAsLocalPostcondCreateCommand(createElementReq, DiagramUtils.getDiagramFrom(part));
			return new ICommandProxy(cmd);
		} else {
			return null;
		}
	}

	/**
	 * Get the corresponding local condition link type
	 * 
	 * @return link type or null
	 */
	private IHintedType getLinkType() {
		if(UMLElementTypes.Constraint_3011.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPrecondition_4001;
		} else if(UMLElementTypes.Constraint_3012.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPostcondition_4002;
		} else if(UMLElementTypes.IntervalConstraint_3032.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPrecondition_4001;
		} else if(UMLElementTypes.IntervalConstraint_3033.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPostcondition_4002;
		} else if(UMLElementTypes.DurationConstraint_3034.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPrecondition_4001;
		} else if(UMLElementTypes.DurationConstraint_3035.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPostcondition_4002;
		} else if(UMLElementTypes.TimeConstraint_3036.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPrecondition_4001;
		} else if(UMLElementTypes.TimeConstraint_3037.equals(type)) {
			return (IHintedType)UMLElementTypes.ActionLocalPostcondition_4002;
		} else {
			return null;
		}
	}

	@Override
	public boolean canExecute() {
		return elementCreationCommand != null && elementCreationCommand.canExecute();
	}

	/**
	 * Execute the command : create the model element, then the corresponding
	 * views
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		Object constraint = null;
		if(elementCreationCommand != null) {
			elementCreationCommand.execute();
			constraint = elementCreationCommand.getICommand().getCommandResult().getReturnValue();
		}
		if(constraint instanceof Constraint && compartment != null && type != null) {
			// construct the complete command for views creation and execute it.
			viewsCreationCommand = new CompoundCommand();
			// creation of the node by the compartment
			ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject)constraint), Node.class, type.getSemanticHint(), compartment.getDiagramPreferencesHint());
			CreateViewRequest request = new CreateViewRequest(descriptor);
			Command nodeCreationCommand = compartment.getCommand(request);
			viewsCreationCommand.add(nodeCreationCommand);
			// try and recover the created edit part, then create the link
			if(linkedActionEditPart != null && getLinkType() != null) {
				IAdaptable targetAdapter = extractResult(nodeCreationCommand);
				if(targetAdapter != null) {
					IAdaptable sourceAdapter = new SemanticAdapter(null, linkedActionEditPart.getModel());
					// descriptor of the link
					CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getLinkType(), getLinkType().getSemanticHint(), compartment.getDiagramPreferencesHint());
					CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(EditorUtils.getTransactionalEditingDomain(), getLinkType().getSemanticHint(), sourceAdapter, targetAdapter, compartment.getViewer(), compartment.getDiagramPreferencesHint(), linkdescriptor, null);
					aLinkCommand.setElement((EObject)constraint);
					viewsCreationCommand.add(new ICommandProxy(aLinkCommand));
				}
			}
			viewsCreationCommand.execute();
		}
	}

	/**
	 * Extract the result out of a node creation command
	 * 
	 * @param nodeCreationCommand
	 *        the command
	 * @return the adaptable result of the command or null
	 */
	private IAdaptable extractResult(Command nodeCreationCommand) {
		if(nodeCreationCommand instanceof ICommandProxy) {
			ICommand createConstraintNodeCommand = ((ICommandProxy)nodeCreationCommand).getICommand();
			// creation of the link between edit parts
			IAdaptable targetAdapter = (IAdaptable)createConstraintNodeCommand.getCommandResult().getReturnValue();
			return targetAdapter;
		} else if(nodeCreationCommand instanceof CompoundCommand) {
			Object[] childrenCmd = ((CompoundCommand)nodeCreationCommand).getChildren();
			for(Object command : childrenCmd) {
				if(command instanceof Command) {
					IAdaptable result = extractResult((Command)command);
					if(result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Undo model and views creation
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if(viewsCreationCommand != null) {
			viewsCreationCommand.undo();
		}
		if(elementCreationCommand != null) {
			elementCreationCommand.undo();
		}
	}
}
