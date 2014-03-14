/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragment2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Lifeline;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragment2CreateCommand extends CombinedFragment2CreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomCombinedFragment2CreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomCombinedFragment2CreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * Create a CoRegion :
	 * - creates two operands
	 * - set the Interaction Operator to parallel
	 * 
	 * @Override
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// Get the model container
		Object modelContainer = ((CreateElementRequest)getRequest()).getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);
		CombinedFragment combinedFragment = CommandHelper.doCreateCoRegion(modelContainer, (Lifeline)getElementToEdit());
		if(combinedFragment != null) {
			doConfigure(combinedFragment, monitor, info);
			((CreateElementRequest)getRequest()).setNewElement(combinedFragment);
			return CommandResult.newOKCommandResult(combinedFragment);
		}
		return CommandResult.newErrorCommandResult("");
	}
}
