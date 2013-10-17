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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ClazzDiagramAssociationHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * custom class to create an association
 */
public class CAssociationCreateCommand extends org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationCreateCommand {

	// code copy from the super class!
	protected Package deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Package) {
				return (Package)element;
			}
		}
		return null;
	}

	protected Package container;

	protected EObject source;

	protected EObject target;

	public CAssociationCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if(source instanceof Type && target instanceof Type && container instanceof Package) {
			Association newElement = (Association)ClazzDiagramAssociationHelper.createAssociation(getEditingDomain(), (Type)source, (Type)target, (Package)container);
			((CreateElementRequest)getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		}
		return null;
	}
}
