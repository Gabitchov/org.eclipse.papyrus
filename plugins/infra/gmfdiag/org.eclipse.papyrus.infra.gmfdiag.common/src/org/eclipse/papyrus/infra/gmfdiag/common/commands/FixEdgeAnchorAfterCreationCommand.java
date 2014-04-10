/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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


package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.geometry.RectangleUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.geometry.Segment;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;


/**
 * 
 * This command is used to fix the edge anchor just after the creation of the edge, in order to get anchor on the sides of the source
 * and target figure and not somewhere inside the figure.
 * 
 * This fix allows to avoid to get source (or target) location moving instead you are moving the target (or source) anchor
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 */
 
public class FixEdgeAnchorAfterCreationCommand extends AbstractTransactionalCommand {

	private static final String RECT_RIGHT_MIDDLE_ANCHOR = "(1.0,0.5)";

	private static final String RECT_BOTTOM_MIDDLE_ANCHOR = "(0.5,1.0)";

	/**
	 * the request used to create connection view
	 */
	protected CreateConnectionViewRequest request;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param request
	 *        the creation request
	 * @param containerEP
	 *        the diagram edit part
	 */
	public FixEdgeAnchorAfterCreationCommand(final TransactionalEditingDomain editingDomain, final CreateConnectionViewRequest request) {
		super(editingDomain, "Fix Edge Anchor after creation", null); //$NON-NLS-1$
		this.request = request;
	}


	/**
	 * Executes a fix anchor command for the created edge
	 * 
	 */
	protected CommandResult doExecuteWithResult(final IProgressMonitor progressMonitor, final IAdaptable info) throws ExecutionException {
		final ConnectionViewDescriptor connectionViewDescriptor = this.request.getConnectionViewDescriptor();
		final Edge createdEdge = (Edge)connectionViewDescriptor.getAdapter(View.class);
		final IAdaptable adaptable = (CreateElementRequestAdapter)connectionViewDescriptor.getElementAdapter();
		final CreateRelationshipRequest createRelationShipRequest = (CreateRelationshipRequest)adaptable.getAdapter(CreateRelationshipRequest.class);
		final Map<?, ?> requestParameters = createRelationShipRequest.getParameters();
		final IFigure sourceFigure = (IFigure)requestParameters.get(RequestParameterConstants.EDGE_SOURCE_FIGURE);
		final IFigure targetFigure = (IFigure)requestParameters.get(RequestParameterConstants.EDGE_TARGET_FIGURE);
		final Point sourcePoint = (Point)requestParameters.get(RequestParameterConstants.EDGE_SOURCE_POINT);
		final Point targetPoint = (Point)requestParameters.get(RequestParameterConstants.EDGE_TARGET_POINT);
		if(createdEdge != null && sourceFigure instanceof IAnchorableFigure && targetFigure instanceof IAnchorableFigure) {
			final String sourceTerminal;
			final String targetTerminal;
			if(sourceFigure == targetFigure) {
				sourceTerminal = RECT_RIGHT_MIDDLE_ANCHOR.toString();
				targetTerminal = RECT_BOTTOM_MIDDLE_ANCHOR.toString();
			} else {

				final Rectangle sourceBds = sourceFigure.getBounds().getCopy();
				final Rectangle targetBds = targetFigure.getBounds().getCopy();
				sourceFigure.translateToAbsolute(sourceBds);
				targetFigure.translateToAbsolute(targetBds);

				final Segment segment = new Segment(sourcePoint, targetPoint);
				final Point realSourcePoint = RectangleUtils.getIntersectionPoint(sourceBds, segment);
				final Point realTargetPoint = RectangleUtils.getIntersectionPoint(targetBds, segment);

				//get source anchor terminal
				final BaseSlidableAnchor anchorSource = (BaseSlidableAnchor)((IAnchorableFigure)sourceFigure).getSourceConnectionAnchorAt(realSourcePoint);
				sourceTerminal = anchorSource.getTerminal();

				//get target anchor terminal
				final BaseSlidableAnchor anchorTarget = (BaseSlidableAnchor)((IAnchorableFigure)targetFigure).getTargetConnectionAnchorAt(realTargetPoint);
				targetTerminal = anchorTarget.getTerminal();
				//create and set the source anchor
			}
			//TODO : it is possible that the result will be not correct when the preferred routing for the link is not the oblique router
			final IdentityAnchor sourceAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			sourceAnchor.setId(sourceTerminal);
			createdEdge.setSourceAnchor(sourceAnchor);

			//create an set the target anchor
			final IdentityAnchor targetAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			targetAnchor.setId(targetTerminal);
			createdEdge.setTargetAnchor(targetAnchor);

			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("Some required element can't be found to fix the anchors of the created edge");//$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	protected void cleanup() {
		this.request = null;
		super.cleanup();
	}


	/**
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && this.request != null;
	}
}
