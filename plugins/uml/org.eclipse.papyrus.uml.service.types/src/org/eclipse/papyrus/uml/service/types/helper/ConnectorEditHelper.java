/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.command.ConnectorReorientCommand;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Edit helper class for binary {@link Connector}
 */
public class ConnectorEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ConnectorReorientCommand(req);
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

		if((source != null) && !(source instanceof ConnectableElement)) {
			return false;
		}

		if((target != null) && !(target instanceof ConnectableElement)) {
			return false;
		}

		if((sourceView != null) && (targetView != null)) {
			// Cannot create a self connector on a view
			if(sourceView == targetView) {
				return false;
			}

			// Cannot create a connector from a view representing a Part to its own Port (or the opposite)
			if((sourceView.getChildren().contains(targetView)) || (targetView.getChildren().contains(sourceView))) {
				return false;
			}
		}

		return true;
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

		if(!noSourceAndTarget && !canCreate(source, target, getSourceView(req), getTargetView(req))) {
			// Abort creation.
			return UnexecutableCommand.INSTANCE;
		}

		if(noSourceOrTarget && !noSourceAndTarget) {
			// The request isn't complete yet. Return the identity command so
			// that the create relationship gesture is enabled.
			return IdentityCommand.INSTANCE;
		}

		// Propose a semantic container for the new Connector.
		StructuredClassifier proposedContainer = deduceContainer(getSourceView(req), getTargetView(req));
		if(proposedContainer == null) {
			return UnexecutableCommand.INSTANCE;
		}

		req.setContainer(proposedContainer);

		return new CreateRelationshipCommand(req);
	}

	/**
	 * This method provides the source role provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private ConnectableElement getSourceRole(IEditCommandRequest req) {
		ConnectableElement result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.SOURCE);
		if(paramObject instanceof ConnectableElement) {
			result = (ConnectableElement)paramObject;
		}

		return result;
	}

	/**
	 * This method provides the target role provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private ConnectableElement getTargetRole(IEditCommandRequest req) {
		ConnectableElement result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if(paramObject instanceof ConnectableElement) {
			result = (ConnectableElement)paramObject;
		}

		return result;
	}

	/**
	 * This method provides the source partWithPort provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target partWithPort
	 */
	private Property getSourcePartWithPort(IEditCommandRequest req) {
		Property result = null;
		View parentView = ViewUtil.getContainerView(getSourceView(req));
		EObject semanticParent = parentView.getElement();
		if((semanticParent instanceof Property) && !(semanticParent instanceof Port)) {
			result = (Property)semanticParent;
		}

		return result;
	}

	/**
	 * This method provides the target partWithPort provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target partWithPort
	 */
	private Property getTargetPartWithPort(IEditCommandRequest req) {
		Property result = null;
		View parentView = ViewUtil.getContainerView(getTargetView(req));
		EObject semanticParent = parentView.getElement();
		if((semanticParent instanceof Property) && !(semanticParent instanceof Port)) {
			result = (Property)semanticParent;
		}

		return result;
	}

	/**
	 * This method provides the source graphical view provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the source view
	 */
	private View getSourceView(IEditCommandRequest req) {
		return (View)req.getParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_SOURCE_VIEW);
	}

	/**
	 * This method provides the target graphical view provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target view
	 */
	private View getTargetView(IEditCommandRequest req) {
		return (View)req.getParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_TARGET_VIEW);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		final Connector connector = (Connector)req.getElementToConfigure();
		final ConnectableElement sourceRole = getSourceRole(req);
		final ConnectableElement targetRole = getTargetRole(req);
		final Property sourcePartWithPort = getSourcePartWithPort(req);
		final Property targetPartWithPort = getTargetPartWithPort(req);

		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				if((sourceRole == null) || (targetRole == null)) {
					return CommandResult.newCancelledCommandResult();
				}

				// Add source connector end
				ConnectorEnd sourceEnd = UMLFactory.eINSTANCE.createConnectorEnd();
				sourceEnd.setLower(1);
				sourceEnd.setUpper(1);
				sourceEnd.setRole(sourceRole);
				sourceEnd.setPartWithPort(sourcePartWithPort);

				// Add target connector end
				ConnectorEnd targetEnd = UMLFactory.eINSTANCE.createConnectorEnd();
				targetEnd.setLower(1);
				targetEnd.setUpper(1);
				targetEnd.setRole(targetRole);
				targetEnd.setPartWithPort(targetPartWithPort);

				connector.getEnds().add(sourceEnd);
				connector.getEnds().add(targetEnd);

				return CommandResult.newOKCommandResult(connector);
			}
		};

		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}

	/**
	 * Tries to find a common StructuredClassifier container to add the new Connector.
	 * 
	 * @param source
	 *        the source graphical view
	 * @param target
	 *        the target graphical view
	 * @return a common StructuredClassifier container (graphical search)
	 */
	private StructuredClassifier deduceContainer(View source, View target) {

		StructuredClassifier containerProposedBySource = proposedContainer(source);
		StructuredClassifier containerProposedByTarget = proposedContainer(target);

		StructuredClassifier deducedContainer = null;

		if((containerProposedBySource != null) && (containerProposedByTarget != null)) {
			if(containerProposedBySource == containerProposedByTarget) {
				deducedContainer = containerProposedBySource;
			}
		}

		return deducedContainer;
	}

	/**
	 * Parse view hierarchy to find a view representing a StructureClassifier is found.
	 * 
	 * @param view
	 *        the graphical view
	 * @return null or a StructuredClassifier represented by the view or one of its parent
	 */
	private StructuredClassifier proposedContainer(View view) {

		for(View currentView = view; currentView != null; currentView = ViewUtil.getContainerView(currentView)) {
			EObject semanticElement = currentView.getElement();
			if(semanticElement instanceof StructuredClassifier) {
				return (StructuredClassifier)semanticElement;
			}
		}

		return null;
	}
}
