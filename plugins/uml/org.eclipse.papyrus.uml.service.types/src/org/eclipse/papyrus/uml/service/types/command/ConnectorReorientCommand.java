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
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * <pre>
 * Re-orient command for binary {@link Connector}.
 * </pre>
 */
public class ConnectorReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	private final EObject oldEnd;

	private final EObject newEnd;

	private final View newEndView;

	private final Edge reorientedEdgeView;

	/**
	 * Constructor.
	 */
	public ConnectorReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
		reorientedEdgeView = RequestParameterUtils.getReconnectedEdge(request);
		newEndView = RequestParameterUtils.getReconnectedEndView(request);
	}

	/**
	 * Test if the command can be executed.
	 */
	public boolean canExecute() {
		if(!(getElementToEdit() instanceof Connector)) {
			return false;
		}

		if(getLink().getEnds().size() != 2) {
			return false;
		}

		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}

		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}

		return false;
	}

	/**
	 * <pre>
	 * This method test if the {@link Connector} can be re-oriented to a new source.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientSource() {
		// Verify possible type of new source
		if(!(getNewSource() instanceof ConnectableElement)) {
			return false;
		}

		if((reorientedEdgeView.getTarget() != null) && (newEndView != null)) {
			// Cannot create a self connector on a view
			if(reorientedEdgeView.getTarget() == newEndView) {
				return false;
			}

			// Cannot create a connector from a view to its own (or the opposite)
			if((reorientedEdgeView.getTarget().getChildren().contains(newEndView)) || (newEndView.getChildren().contains(reorientedEdgeView.getTarget()))) {
				return false;
			}
		}

		if(deduceContainer(reorientedEdgeView.getTarget(), newEndView) == null) {
			return false;
		}

		return true;
	}

	/**
	 * <pre>
	 * This method test if the {@link Connector} can be re-oriented to a new target.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new target
	 */
	protected boolean canReorientTarget() {
		// Verify possible type of new target
		if(!(getNewTarget() instanceof ConnectableElement)) {
			return false;
		}

		if((reorientedEdgeView.getSource() != null) && (newEndView != null)) {
			// Cannot create a self connector on a view
			if(reorientedEdgeView.getSource() == newEndView) {
				return false;
			}

			// Cannot create a connector from a view to its own (or the opposite)
			if((reorientedEdgeView.getSource().getChildren().contains(newEndView)) || (newEndView.getChildren().contains(reorientedEdgeView.getSource()))) {
				return false;
			}
		}

		if(deduceContainer(reorientedEdgeView.getSource(), newEndView) == null) {
			return false;
		}

		return true;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}

		throw new IllegalStateException();
	}

	protected CommandResult reorientSource() throws ExecutionException {
		// Nothing to do here on the connector itself, the connector end remains
		// the same but related to new Port or PartWithPort.
		ConnectorEnd reorientedEnd = getLink().getEnds().get(0);
		return reorientEnd(reorientedEnd, (ConnectableElement)getNewSource(), getNewPartWithPort());
	}

	protected CommandResult reorientTarget() throws ExecutionException {
		// Nothing to do here on the connector itself, the connector end remains
		// the same but related to new Port or PartWithPort.		
		ConnectorEnd reorientedEnd = getLink().getEnds().get(1);
		return reorientEnd(reorientedEnd, (ConnectableElement)getNewTarget(), getNewPartWithPort());
	}

	private CommandResult reorientEnd(ConnectorEnd end, ConnectableElement role, Property partWithPort) throws ExecutionException {
		end.setRole(role);
		end.setPartWithPort(partWithPort);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Get the link to re-orient.
	 * 
	 * @return the edited {@link Connector}
	 */
	protected Connector getLink() {
		return (Connector)getElementToEdit();
	}

	/**
	 * Get the old {@link Connector} source.
	 * 
	 * @return the previous {@link Connector} source.
	 */
	protected Element getOldSource() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Connector} source.
	 * 
	 * @return the new {@link Connector} source.
	 */
	protected Element getNewSource() {
		return (Element)newEnd;
	}

	/**
	 * Get the old {@link Connector} target.
	 * 
	 * @return the previous {@link Connector} target.
	 */
	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Connector} target.
	 * 
	 * @return the new {@link Connector} target.
	 */
	protected Element getNewTarget() {
		return (Element)newEnd;
	}

	/**
	 * Get the new {@link Connector} end graphical parent.
	 * 
	 * @return the new {@link Connector} end graphical parent.
	 */
	protected Element getEndParent(View endView) {
		EObject parent = ViewUtil.getContainerView(endView).getElement();
		return (parent instanceof Element) ? (Element)parent : null;
	}

	/**
	 * Get the new {@link Connector} end part with port.
	 * 
	 * @return the new {@link Connector} end part with port.
	 */
	private Property getNewPartWithPort() {
		Property partWithPort = null;
		Element newEndParent = getEndParent(newEndView);

		if((newEndParent != null) && (newEndParent instanceof Property) && !(newEndParent instanceof Port)) {
			partWithPort = (Property)newEndParent;
		}
		return partWithPort;
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
