/*****************************************************************************
 * Copyright (c) 2012 Atos .
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Arthur daussy - arthur.daussy@atos.net - 374607: [model explorer] moving a model element in another model does not move associated diagrams
 *
 **/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Element;

/**
 * The aim of this command is to move all stereotype applications of an element into a new resource
 * @author adaussy
 *
 */
public class MoveStereotypeApplicationsCommand extends AbstractTransactionalCommand {

	private Element element;
	
	private Resource newContainer;
	
	private static String LABEL = "Move stereotype applications to a new resource";////$NON-NLS-1$
	
	public MoveStereotypeApplicationsCommand(TransactionalEditingDomain domain,Element element, Resource newContainer) {
		super(domain, LABEL, null);
		this.element = element;
		this.newContainer = newContainer;
		Assert.isNotNull(element);
		Assert.isNotNull(newContainer);
		/*
		 * set modified list file
		 */
		List<?> notations = getWorkspaceFiles(element);
		getAffectedFiles().add(WorkspaceSynchronizer.getFile(newContainer));
	}



	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EList<EObject> stereotypeApplications = element.getStereotypeApplications();
		if (stereotypeApplications != null){
			EList<EObject> contents = newContainer.getContents();
			if (contents == null){
				return CommandResult.newErrorCommandResult("Enable to add stereotype application to the new resource");////$NON-NLS-1$
			}
			for ( EObject stereotypeApp : stereotypeApplications){
				contents.add(stereotypeApp);
			}
		}
		return CommandResult.newOKCommandResult();
	}
}
