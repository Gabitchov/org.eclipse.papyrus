/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ClassPropertyCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.providers.ElementInitializers;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class PropertyCommandForAssociation use to create a property into an association (ownedEnd)
 */
public class PropertyCommandForAssociation extends ClassPropertyCreateCommand {

	/**
	 * Instantiates a new property command for association.
	 * 
	 * @param req
	 *        the req to launch the command
	 */
	public PropertyCommandForAssociation(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * {@inheritDoc}
	 */
	protected EObject doDefaultElementCreation() {
		Property newElement = UMLFactory.eINSTANCE.createProperty();

		Association owner = (Association)getElementToEdit();

		Object type = getRequest().getParameter("type");
		if(type != null && type instanceof Type) {
			newElement.setType((Type)type);
			newElement.setName(((Type)type).getName());
		}
		owner.getOwnedEnds().add(newElement);
		ElementInitializers.getInstance().init_Property_3002(newElement);
		if(type != null && type instanceof Type) {
			newElement.setName(((Type)type).getName());
		}
		return newElement;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Property newElement = (Property)doDefaultElementCreation();

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getAssociation();
	}

}
