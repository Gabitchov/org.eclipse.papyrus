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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * This class is used to create a connection view
 * 
 * @author Patrick Tessier
 */
public class CommonDeferredCreateConnectionViewCommand extends DeferredCreateConnectionViewCommand implements ICommand {

	protected ICommand command;

	/** the command saved for undo and redo */
	protected Command createConnectionCmd;

	protected ConnectionViewDescriptor viewDescriptor;

	/**
	 * Constructor
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param element
	 *        the semantic element (may be null)
	 * @param sourceViewAdapter
	 *        the source of the link
	 * @param targetViewAdapter
	 *        the target of the link (may be null if the command is filled)
	 * @param viewer
	 *        the viewer
	 * @param preferencesHint
	 *        the preferencehint of the diagram
	 * @param command
	 *        the command in which we look for the result for the target
	 *        (may be null)
	 */
	public CommonDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint);
		this.command = command;
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * Constructor
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param semanticHint
	 *        the semantic of the graphical element
	 * @param sourceViewAdapter
	 *        the source of the link
	 * @param targetViewAdapter
	 *        the target of the link (may be null if the command is filled)
	 * @param viewer
	 *        the viewer
	 * @param preferencesHint
	 *        the preferencehint of the diagram
	 * @param viewDescriptor
	 *        the view descriptor
	 * @param command
	 *        the command in which we look for the result for the target
	 *        (may be null)
	 */
	public CommonDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint);
		this.viewDescriptor = viewDescriptor;
		this.command = command;
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Map<?, ?> epRegistry = viewer.getEditPartRegistry();
		IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
		IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(targetViewAdapter.getAdapter(View.class));

		/*
		 * when the source or the target of a link is an other link, the
		 * previous method returns something like ElementNameEditPart A such
		 * EditPart does not allow to get a Command for the creation of the link
		 */
		if(sourceEP instanceof LabelEditPart) {
			sourceEP = findEditPartForCreation((View)sourceViewAdapter.getAdapter(View.class));
		}

		if(targetEP instanceof LabelEditPart) {
			targetEP = findEditPartForCreation((View)targetViewAdapter.getAdapter(View.class));
		}

		return doExecuteWithResult(progressMonitor, info, sourceEP, targetEP);
	}

	/**
	 * Returns the EditPart for the creation
	 * 
	 * @param adapter
	 *        the view of the element for which we are looking for a valid
	 *        EditPart
	 * @return the EditPart for the creation
	 */
	protected IGraphicalEditPart findEditPartForCreation(View view) {
		Iterator<?> editPartIterator = viewer.getEditPartRegistry().values().iterator();
		EObject semanticElement = view.getElement();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = (EditPart)editPartIterator.next();
			if((!(currentEditPart instanceof CompartmentEditPart)) && currentEditPart instanceof IGraphicalEditPart && semanticElement == (((IGraphicalEditPart)currentEditPart).resolveSemanticElement())) {
				if(!(currentEditPart instanceof LabelEditPart)) {
					return (IGraphicalEditPart)currentEditPart;
				}
			}
		}
		return null;
	}

	/**
	 * Creates a connection view between the source and target.
	 * 
	 * @throws ExecutionException
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) throws ExecutionException {

		// If these are null, then the diagram's editparts may not
		// have been refreshed yet.
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);

		// use the String semanticHint to create a view
		// modification in order to fix the bug
		CreateConnectionViewRequest createRequest = new CreateConnectionViewRequest(viewDescriptor);
		createConnectionCmd = CreateConnectionViewRequest.getCreateCommand(createRequest, sourceEditPart, targetEditPart);
		
		if (createConnectionCmd == null) {
			throw new ExecutionException(Messages.CommonDeferredCreateConnectionViewCommand_NullConnectionCommand);
		}
		
		if(createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
		}

		if(element != null) {
			((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(element);
		}
		viewer = null;// for garbage collection
		return CommandResult.newOKCommandResult();
	}

	public void setElement(EObject element) {
		this.element = element;
	}
}
