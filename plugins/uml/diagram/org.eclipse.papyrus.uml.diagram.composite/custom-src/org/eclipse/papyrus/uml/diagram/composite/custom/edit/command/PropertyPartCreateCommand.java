/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.composite.providers.ElementInitializers;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;

public class PropertyPartCreateCommand extends org.eclipse.papyrus.uml.diagram.composite.edit.commands.PropertyPartCreateCommandCN {

	/** Constructor **/
	public PropertyPartCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * <pre>
	 * Checks if the Property can be created on the Property (means appearing graphically on the property).
	 * The Property must be typed by a StructuredClassifier (in other words, an element that 
	 * can own Property). The new Property is owned be the type of the Property. 
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
	 * Custom creation of the Property type : 
	 * - resolve the Property type
	 * - add a new Property on this type. 
	 *  
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Property newElement = UMLFactory.eINSTANCE.createProperty();

		StructuredClassifier owner = (StructuredClassifier)((Property)getElementToEdit()).getType();
		owner.getOwnedAttributes().add(newElement);

		ElementInitializers.getInstance().init_Property_3070(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
