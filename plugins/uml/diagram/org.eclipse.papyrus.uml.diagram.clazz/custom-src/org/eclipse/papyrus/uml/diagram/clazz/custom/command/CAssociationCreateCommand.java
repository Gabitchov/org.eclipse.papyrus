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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ClazzDiagramAssociationHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * custom class to create an association
 */
public class CAssociationCreateCommand extends org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationCreateCommand {
	
	private final Diagram diagram;
	
	public CAssociationCreateCommand(CreateRelationshipRequest request, EObject source, EObject target, Diagram diagram) {
		super(request, source, target);
		this.diagram = diagram;
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
			Association newElement = (Association)ClazzDiagramAssociationHelper.createAssociation(getEditingDomain(), (Type)source, (Type)target, (Package)container, diagram);
			((CreateElementRequest)getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		}
		return null;
	}
}
