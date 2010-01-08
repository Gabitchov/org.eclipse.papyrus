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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.commands.Property2CreateCommand;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;


public class CreateParameterViewCommand extends Command {

	/** The compartment which graphically contains the Constraint to create */
	private ConstraintPropertyEditPart compartment = null;

	/** The command to create the Constraint element */
	private ICommandProxy elementCreationCommand = null;

	/** The command to create corresponding views (constraint view and link view) */
	private CompoundCommand viewsCreationCommand = null;

	/** The type of local condition to create */
	private IHintedType type;
	
	public CreateParameterViewCommand() {
		super();
	}

	public CreateParameterViewCommand(String label) {
		super(label);
	}
	
	/**
	 * Constructor a new action to create the local condition and corresponding views.
	 * 
	 * @param conditionType
	 *        the type of the local condition : precondition (Constraint_3011) or postcondition (Constraint_3012)
	 * @param graphicalParent
	 *        the parent edit part which graphically contains the condition
	 * @param containerAction
	 *        the action which owns the local condition to create
	 * @param actionPart
	 *        the part of the action owning the condition
	 */
	public CreateParameterViewCommand(IHintedType conditionType, ConstraintPropertyEditPart graphicalParent, EObject containerAction, EditPart actionPart) {
		elementCreationCommand = getElementCreationCommand(containerAction, conditionType);
		compartment = graphicalParent;
		type = conditionType;
	}

	/**
	 * Get the Command to create the constraint element
	 * 
	 * @param containerAction
	 *        the action which owns the local condition to create
	 * @param conditionType
	 *        the type of the local condition : precondition (Constraint_3011) or postcondition (Constraint_3012)
	 * @return the command to create model element or null
	 */
	private static ICommandProxy getElementCreationCommand(EObject containerAction, IHintedType conditionType) {
		CreateElementRequest createElementReq = new CreateElementRequest(containerAction, conditionType);
		if(SysmlElementTypes.Property_3002.equals(conditionType)) {
			Property2CreateCommand cmd = new Property2CreateCommand(createElementReq);
			return new ICommandProxy(cmd);
		} else {
			return null;
		}
	}

	@Override
	public boolean canExecute() {
		return elementCreationCommand != null && elementCreationCommand.canExecute();
	}

	/**
	 * Execute the command : create the model element, then the corresponding views
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		Object property = null;
		if(elementCreationCommand != null) {
			//elementCreationCommand.execute();
			//property = elementCreationCommand.getICommand().getCommandResult().getReturnValue();
		}
		// TODO Do we need to add the property graphically in the class
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
