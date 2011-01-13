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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;


/**
 * The Class OpenDiagramCommand.
 */
public class OpenDiagramCommand extends AbstractTransactionalCommand {

	/** The diagram to open. */
	private Diagram diagramToOpen = null;
	
	private ICommand previousCreateDiagramCommand = null;

	private Resource diResource = null;

	/**
	 * Instantiates a new open diagram command.
	 * 
	 * @param domain
	 *        the domain
	 * @param diagram
	 *        the diagram
	 */
	public OpenDiagramCommand(Resource diResource, TransactionalEditingDomain editingDomain, Diagram diagram) {
		super(editingDomain, "Open diagram", null);
		this.diResource  = diResource;
		diagramToOpen = diagram;
	}
	
	public OpenDiagramCommand(Resource diResource, TransactionalEditingDomain editingDomain, ICommand previousCreateDiagramCommand) {
		super(editingDomain, "Open diagram", null);
		this.diResource  = diResource;
		this.previousCreateDiagramCommand = previousCreateDiagramCommand;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			if (diagramToOpen == null && previousCreateDiagramCommand != null) {
				diagramToOpen = (Diagram)previousCreateDiagramCommand.getCommandResult().getReturnValue();
			}

			IPageMngr pageMngr = EditorUtils.getIPageMngr(diResource);

			if(pageMngr.isOpen(diagramToOpen)) {
				pageMngr.closePage(diagramToOpen);
			}
			pageMngr.openPage(diagramToOpen);

			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			throw new ExecutionException("Can't open diagram", e);
		}
	}
}
