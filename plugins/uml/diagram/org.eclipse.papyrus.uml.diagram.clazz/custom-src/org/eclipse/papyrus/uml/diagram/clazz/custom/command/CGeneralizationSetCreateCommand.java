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
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.GeneralizationSetHelper;
import org.eclipse.uml2.uml.GeneralizationSet;

/**
 * custom class to create an association
 */
public class CGeneralizationSetCreateCommand extends org.eclipse.papyrus.uml.diagram.clazz.edit.commands.GeneralizationSetCreateCommand {

	public CGeneralizationSetCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		GeneralizationSetHelper generalizationSetHelper = new GeneralizationSetHelper(getEditingDomain());
		GeneralizationSet newElement = generalizationSetHelper.createGeneralizationSet(getSource(), getTarget(), container);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
