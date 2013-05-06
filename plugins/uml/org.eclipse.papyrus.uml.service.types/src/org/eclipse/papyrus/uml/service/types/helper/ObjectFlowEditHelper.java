/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.command.ObjectFlowReorientCommand;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.papyrus.uml.tools.utils.ObjectFlowUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ObjectFlow;

/**
 * Edit helper class for binary {@link ObjectFlow}
 */
public class ObjectFlowEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ObjectFlowReorientCommand(req);
	}

	/**
	 * Test if the relationship creation is allowed.
	 * 
	 * @param source
	 *        the relationship source can be null
	 * @param target
	 *        the relationship target can be null
	 * @param sourceView
	 *        the relationship graphical source can be null
	 * @param targetView
	 *        the relationship graphical target can be null
	 * @return true if the creation is allowed
	 */
	protected boolean canCreate(EObject source, EObject target, View sourceView, View targetView) {
		return canCreate(source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		EObject source = req.getSource();
		EObject target = req.getTarget();
		boolean noSourceOrTarget = (source == null || target == null);
		boolean noSourceAndTarget = (source == null && target == null);
		if(!noSourceAndTarget && !canCreate(source, target, RequestParameterUtils.getSourceView(req), RequestParameterUtils.getTargetView(req))) {
			// Abort creation.
			return UnexecutableCommand.INSTANCE;
		}
		if(noSourceOrTarget && !noSourceAndTarget) {
			// The request isn't complete yet. Return the identity command so
			// that the create relationship gesture is enabled.
			if(source != null && !(source instanceof ActivityNode)) {
				return UnexecutableCommand.INSTANCE;
			}
			return IdentityCommand.INSTANCE;
		}
		// Propose a semantic container for the new control flow.
		Activity proposedContainer = deduceContainer(req);
		if(proposedContainer == null) {
			return UnexecutableCommand.INSTANCE;
		}
		req.setContainer(proposedContainer);
		return new CreateRelationshipCommand(req);
	}

	protected Activity deduceContainer(CreateRelationshipRequest request) {
		return deduceContainer(request.getSource(), request.getTarget());
	}

	protected Activity deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Activity) {
				return (Activity)element;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				ObjectFlow element = (ObjectFlow)req.getElementToConfigure();
				ActivityNode source = getSourceObject(req);
				ActivityNode target = getTargetObject(req);
				if(source != null) {
					element.setSource(getSourceObject(req));
				}
				if(target != null) {
					element.setTarget(target);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}

	/**
	 * This method provides the object to be use as source.
	 * 
	 * @return the source value
	 */
	protected ActivityNode getSourceObject(ConfigureRequest req) {
		Object result = req.getParameter(CreateRelationshipRequest.SOURCE);
		return (result instanceof ActivityNode) ? (ActivityNode)result : null;
	}

	/**
	 * This method provides the object to be used as target.
	 * 
	 * @return the target value
	 */
	protected ActivityNode getTargetObject(ConfigureRequest req) {
		Object result = req.getParameter(CreateRelationshipRequest.TARGET);
		return (result instanceof ActivityNode) ? (ActivityNode)result : null;
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean canCreate(EObject source, EObject target) {
		if((source != null) && !(source instanceof ActivityNode)) {
			return false;
		}
		if((target != null) && !(target instanceof ActivityNode)) {
			return false;
		}
		
		Activity container = deduceContainer(source, target);
		if(container == null) {
			return false;
		}
		return ObjectFlowUtil.canExistObjectFlow(container, null, (ActivityNode)source, (ActivityNode)target);
	}
}
