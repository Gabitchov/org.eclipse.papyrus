/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.component.providers.ElementInitializers;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Port creation command used to create Port on a Property (no direct containment link between
 * Property and Port).
 * 
 */
public class PortCreateCommand extends org.eclipse.papyrus.uml.diagram.component.edit.commands.PortCreateCommand {

	/** Constructor **/
	public PortCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * <pre>
	 * Checks if the Port can be created on the Property.
	 * The Property must be typed by a StructuredClassifier (in other words, an element that 
	 * can own Port). The new Port is owned be the type of the Property. 
	 *  
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public boolean canExecute() {
		Property target = (Property)getElementToEdit();

		if((target.getType() != null) && (target.getType() instanceof StructuredClassifier)) {
			return true;
		}

		return false;
	}

	/**
	 * <pre>
	 * Custom creation of the Port : 
	 * - resolve the Property type
	 * - add a new Port on this type. 
	 *  
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Port newElement = UMLFactory.eINSTANCE.createPort();

		StructuredClassifier owner = (StructuredClassifier)((Property)getElementToEdit()).getType();
		owner.getOwnedAttributes().add(newElement);

		ElementInitializers.getInstance().init_Port_3069(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
