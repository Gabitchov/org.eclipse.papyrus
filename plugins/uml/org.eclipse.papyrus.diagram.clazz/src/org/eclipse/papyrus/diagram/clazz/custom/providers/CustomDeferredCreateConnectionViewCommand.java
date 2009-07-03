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
package org.eclipse.papyrus.diagram.clazz.custom.providers;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.AssociationClassViewCreateCommand;

/**
 * This class is used to create a connection view
 * 
 * @author Patrick Tessier
 */
public class CustomDeferredCreateConnectionViewCommand extends DeferredCreateConnectionViewCommand implements ICommand {

	private ICommand command;

	/** the command saved for undo and redo */
	private Command createConnectionCmd;

	protected ConnectionViewDescriptor viewDescriptor;

	/**
	 * Constructor
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param element
	 *            the semantic element (may be null)
	 * @param sourceViewAdapter
	 *            the source of the link
	 * @param targetViewAdapter
	 *            the target of the link (may be null if the command is filled)
	 * @param viewer
	 *            the viewer
	 * @param preferencesHint
	 *            the preferencehint of the diagram
	 * @param command
	 *            the command in which we look for the result for the target (may be null)
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer,
			PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint);
		this.command = command;
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * Constructor
	 * 
	 * @param editingDomain
	 *            the editing domain
	 *@param semanticHint
	 *            the semantic of the graphical element
	 * @param sourceViewAdapter
	 *            the source of the link
	 * @param targetViewAdapter
	 *            the target of the link (may be null if the command is filled)
	 * @param viewer
	 *            the viewer
	 * @param preferencesHint
	 *            the preferencehint of the diagram
	 * @param viewDescriptor
	 *            the view descriptor
	 * @param command
	 *            the command in which we look for the result for the target (may be null)
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer,
			PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint);
		this.viewDescriptor = viewDescriptor;
		this.command = command;
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Map epRegistry = viewer.getEditPartRegistry();
		IGraphicalEditPart sourceEP = (IGraphicalEditPart) epRegistry.get(sourceViewAdapter.getAdapter(View.class));
		IGraphicalEditPart targetEP = null;
		CreateConnectionViewRequest createRequest = null;
		if (command != null && command instanceof AssociationClassViewCreateCommand) {
			targetEP = (IGraphicalEditPart) epRegistry.get(((AssociationClassViewCreateCommand) command).getNode());
		} else {
			targetEP = (IGraphicalEditPart) epRegistry.get(targetViewAdapter.getAdapter(View.class));
		}

		// If these are null, then the diagram's editparts may not
		// have been refreshed yet.
		Assert.isNotNull(sourceEP);
		Assert.isNotNull(targetEP);

		// use the String semanticHint to create a view
		// modification in order to fixe the bug
		createRequest = new CreateConnectionViewRequest(viewDescriptor);
		createConnectionCmd = CreateConnectionViewRequest.getCreateCommand(createRequest, sourceEP, targetEP);

		if (createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
		}
		if (element != null) {
			((View) (createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(element);
		}
		viewer = null;// for garbage collection
		return CommandResult.newOKCommandResult();
	}

	public void setElement(EObject element) {
		this.element = element;
	}
}
