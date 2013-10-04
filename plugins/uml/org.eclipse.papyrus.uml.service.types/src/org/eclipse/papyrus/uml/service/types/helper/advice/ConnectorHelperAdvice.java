/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * <pre>
 * This HelperAdvice completes {@link Connector} edit commands with:
 * 		- forbidding {@link ConnectorEnd} to be moved to another {@link Connector}
 * </pre>
 */
public class ConnectorHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Forbid move command of a {@link ConnectorEnd} to a {@link Connector}.
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);

		// Parse moved objects and detect ConnectorEnd moves
		for(Object movedObject : request.getElementsToMove().keySet()) {
			if(movedObject instanceof ConnectorEnd) {
				// Replace default command.
				gmfCommand = UnexecutableCommand.INSTANCE;
				break;
			}
		}

		return gmfCommand;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@Override
	protected ICommand getBeforeReorientRelationshipCommand(final ReorientRelationshipRequest request) {
		//we need to destroy the invalid views from the diagram
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy Connector View Command"); //$NON-NLS-1$
		final EObject relationShip = request.getRelationship();
		final Edge reorientedEdge = RequestParameterUtils.getReconnectedEdge(request);
		if(relationShip instanceof Connector) {
			final EObject newEnd = request.getNewRelationshipEnd();
			final EObject oldEnd = request.getOldRelationshipEnd();
			if(oldEnd != newEnd) {
				final Set<View> viewsToDestroy = new ConnectorUtils().getViewsRepresentingConnector((Connector)relationShip);
				final Iterator<View> iter = viewsToDestroy.iterator();

				while(iter.hasNext()) {
					final View current = iter.next();
					if(current != reorientedEdge) {//we don't destroy the edge that the user is reconnecting!
						//the role is changing, so We remove the invalid views
						final DestroyElementRequest destroyRequest = new DestroyElementRequest(request.getEditingDomain(), current, false);
						final IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(current);
						compositeCommand.add(commandProvider.getEditCommand(destroyRequest));
					}
				}
			}
		}
		if(!compositeCommand.isEmpty()) {
			return compositeCommand;
		}
		return null;
	}

}
