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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor code in CommonDeferredCreateConnectionViewCommand
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.command;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;

/**
 * This class is used to create a connection view
 * 
 * @author Patrick Tessier
 */
public class CustomDeferredCreateConnectionViewCommand extends CommonDeferredCreateConnectionViewCommand {

	/**
	 * {@inheritDoc}
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, command);
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
	}

	/**
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = null;
		if(command != null && command instanceof AssociationClassViewCreateCommand) {
			Map epRegistry = viewer.getEditPartRegistry();
			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
			IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(((AssociationClassViewCreateCommand)command).getNode());

			commandResult = super.doExecuteWithResult(progressMonitor, info, sourceEP, targetEP);
		} else {
			commandResult = super.doExecuteWithResult(progressMonitor, info);
		}
		return commandResult;
	}

}
