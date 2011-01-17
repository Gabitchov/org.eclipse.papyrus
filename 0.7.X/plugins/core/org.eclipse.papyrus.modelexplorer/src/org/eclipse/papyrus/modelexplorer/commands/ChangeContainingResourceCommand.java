/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * This command can be used to change the containing resource of an element
 * @author mvelten
 *
 */
public class ChangeContainingResourceCommand extends AbstractTransactionalCommand {

	private EObject element;
	private Resource newResource;

	public ChangeContainingResourceCommand(TransactionalEditingDomain domain, EObject element, Resource newResource) {
		super(domain, "Change containing resource", null);
		this.element = element;
		this.newResource = newResource;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Resource oldResource = element.eResource();
		if (oldResource != null) {
			oldResource.getContents().remove(element);
		}
		newResource.getContents().add(element);
		return CommandResult.newOKCommandResult();
	}

}
