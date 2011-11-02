/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;



import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.communication.providers.UMLViewProvider;



// TODO: Auto-generated Javadoc
/**
 * The Class DiagramShortCutCreationViewCommand.
 */
public class DiagramShortCutCreationViewCommand extends AbstractTransactionalCommand {

	/** the view descriptor. */
	protected final CreateViewRequest.ViewDescriptor viewDescriptor;

	/** The container view. */
	protected final View containerView;

	/**
	 * Instantiates a new diagram short cut creation view command.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param viewDescriptor
	 *        the view descriptor
	 * @param containerView
	 *        the container view
	 */
	public DiagramShortCutCreationViewCommand(TransactionalEditingDomain editingDomain, CreateViewRequest.ViewDescriptor viewDescriptor, View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(containerView));

		Assert.isNotNull(viewDescriptor);
		Assert.isNotNull(containerView);

		this.viewDescriptor = viewDescriptor;
		this.containerView = containerView;

		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}


	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		UMLViewProvider umlViewProvider = new UMLViewProvider();
		EObject eObject = (EObject)(viewDescriptor.getElementAdapter()).getAdapter(EObject.class);
		View view = umlViewProvider.createDiagram_8016(eObject, containerView, -1, viewDescriptor.isPersisted(), viewDescriptor.getPreferencesHint());
		Assert.isNotNull(view, "failed to create a view"); //$NON-NLS-1$
		viewDescriptor.setView(view);

		return CommandResult.newOKCommandResult(viewDescriptor);
	}

}
