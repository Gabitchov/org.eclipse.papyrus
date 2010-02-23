/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateElementAndInitializeFeatureCommand.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class CreateElementAndInitializeFeatureCommand extends Command {

	/** Compound command to undo/redo. */
	CompoundCommand compoundCommand = new CompoundCommand();

	/** Command to create the element. */
	private CreateElementCommand createElementCommand;

	/** Feature to initialize. */
	private EReference featureToInitialize;

	/** Value to initialize the feature to. */
	private Object initializationValue;

	/**
	 * Instantiates a new creates the element and initialize feature command.
	 * 
	 * @param createCommand
	 *        the create command
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 */
	public CreateElementAndInitializeFeatureCommand(CreateElementCommand createCommand, EReference feature, Object value) {
		createElementCommand = createCommand;
		featureToInitialize = feature;
		initializationValue = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return createElementCommand != null && featureToInitialize != null && initializationValue != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return compoundCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#chain(org.eclipse.gef.commands.Command)
	 */
	@Override
	public Command chain(Command command) {
		compoundCommand.chain(command);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		compoundCommand.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {

		/**
		 * 1) Create element via createElementCommand 2) Retrieve created element via
		 * createElementCommand.getNewElement() 3) Create SetValueCommand on newElement with
		 * indicated feature and value on construction 4) Set feature value via setValueCommand 5)
		 * both the createElementCommand and the setValueCommand are stored in a CompoundCommand to
		 * undo() and redo() easily
		 */

		try {
			createElementCommand.execute(null, null);
			compoundCommand.add(new ICommandProxy(createElementCommand));
		} catch (ExecutionException e) {
			e.printStackTrace();
			return;
		}

		EObject newElement = createElementCommand.getNewElement();

		SetRequest setRequest = new SetRequest(newElement, featureToInitialize, initializationValue);
		SetValueCommand setValueCommand = new SetValueCommand(setRequest);

		try {
			setValueCommand.execute(null, null);
			compoundCommand.add(new ICommandProxy(setValueCommand));
		} catch (ExecutionException e) {
			e.printStackTrace();
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getDebugLabel()
	 */
	@Override
	public String getDebugLabel() {
		return super.getDebugLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getLabel()
	 */
	@Override
	public String getLabel() {
		return super.getLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		compoundCommand.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setDebugLabel(java.lang.String)
	 */
	@Override
	public void setDebugLabel(String label) {
		super.setDebugLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		super.setLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		compoundCommand.redo();
	}

}
