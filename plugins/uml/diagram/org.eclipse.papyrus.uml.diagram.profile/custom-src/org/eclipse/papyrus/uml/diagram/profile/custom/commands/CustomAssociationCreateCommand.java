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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram to the profile diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.profile.custom.helper.ProfileDiagramAssociationHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * custom class to create an association
 */
public class CustomAssociationCreateCommand extends org.eclipse.papyrus.uml.diagram.profile.edit.commands.AssociationCreateCommand {
	/**
	 * 
	 * Constructor.
	 * 
	 * @param request
	 *        the request
	 * @param source
	 *        the source of the association to create
	 * @param target
	 *        the target of the association to create
	 */
	public CustomAssociationCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
		container = deduceContainer(source, target);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if (source instanceof Type && target instanceof Type && container instanceof Package) {
			Association newElement = (Association) ProfileDiagramAssociationHelper.createAssociation(getEditingDomain(), (Type) source, (Type) target, container, null);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		}
		return null;
	}
}
