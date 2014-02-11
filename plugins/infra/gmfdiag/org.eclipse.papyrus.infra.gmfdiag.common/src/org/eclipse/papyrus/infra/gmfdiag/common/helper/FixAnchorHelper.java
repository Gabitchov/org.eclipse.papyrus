/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * This class provides command to fix the anchors during a resize.
 * The methods are not static to allow to overriding
 * 
 */
public class FixAnchorHelper {

	/**
	 * the editing domain used for the command
	 */
	protected final TransactionalEditingDomain domain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain to use, it must not be <code>null</code>
	 */
	public FixAnchorHelper(final TransactionalEditingDomain domain) {
		Assert.isNotNull(domain);
		this.domain = domain;
	}

	/**
	 * 
	 * @param node
	 *        the resized node
	 * @param move
	 *        the move direction
	 * @param sizeDelta
	 *        the delta of the size
	 * @param moveDirection
	 *        the direction for the resize/move
	 * @return
	 *         the command to fix the anchor or <code>null</code> if we can't fix it
	 */
	public Command getFixIdentityAnchorCommand(final INodeEditPart node, final Point move, final Dimension sizeDelta, int moveDirection) {
		final CompoundCommand cc = new CompoundCommand("Fix All Anchors Command"); //$NON-NLS-1$
		//1. we calculate the new bounds;
		final IFigure nodeFigure = node.getFigure();
		final PrecisionRectangle oldBounds = new PrecisionRectangle(nodeFigure.getBounds());

		//we translate the coordinates to absolute
		nodeFigure.translateToAbsolute(oldBounds);
		final PrecisionRectangle newBounds = oldBounds.getPreciseCopy();
		newBounds.translate(move.preciseX(), move.preciseY());
		newBounds.resize(sizeDelta.preciseWidth(), sizeDelta.preciseHeight());


		//2. we iterate on the target anchor
		for(final Object targetConnection : node.getTargetConnections()) {
			if(targetConnection instanceof AbstractConnectionEditPart) {
				final Command tmp = getFixAnchorCommand(node, oldBounds, newBounds, (AbstractConnectionEditPart)targetConnection, move, sizeDelta, false);
				if(tmp != null) {
					cc.add(tmp);
				}
			}
		}

		//. we iterate on the source anchor
		for(final Object sourceConnection : node.getSourceConnections()) {
			if(sourceConnection instanceof AbstractConnectionEditPart) {
				final Command tmp = getFixAnchorCommand(node, oldBounds, newBounds, (AbstractConnectionEditPart)sourceConnection, move, sizeDelta, true);
				if(tmp != null) {
					cc.add(tmp);
				}
			}
		}

		if(cc.isEmpty()) {
			return null;
		}
		return cc;
	}

	/**
	 * 
	 * @param edgeEP
	 *        the edge edit part
	 * @param sourcePoint
	 *        if <code>true</code> we return the source point and if false we return the end point
	 * @return
	 *         the real point to fix
	 */
	protected Point getRealAnchorPoint(final AbstractConnectionEditPart edgeEP, final boolean sourcePoint) {
		final IFigure figure = edgeEP.getFigure();
		Point point = null;
		if(figure instanceof AbstractPointListShape) {
			if(sourcePoint) {
				point = ((AbstractPointListShape)figure).getStart().getCopy();
			} else {
				point = ((AbstractPointListShape)figure).getEnd().getCopy();
			}
		}
		figure.translateToAbsolute(point);
		return point;
	}

	/**
	 * 
	 * @param edgeEP
	 *        the edge edit part
	 * @param sourcePoint
	 *        if <code>true</code> we return the source point and if false we return the end point
	 * @param nodeEP
	 *        the node edit part
	 * @param p
	 *        the real anchor point in absolute coordinate
	 * @return
	 *         the anchor representing the point to fix
	 */
	protected IdentityAnchor getIdentityAnchor(final AbstractConnectionEditPart edgeEP, final boolean sourcePoint, final INodeEditPart nodeEP, final Point p) {
		final View view = (View)edgeEP.getAdapter(View.class);
		IdentityAnchor anchor = null;
		if(view instanceof Edge) {
			final Object tmpAnchor;
			if(sourcePoint) {
				tmpAnchor = ((Edge)view).getSourceAnchor();
			} else {
				tmpAnchor = ((Edge)view).getTargetAnchor();
			}
			if(tmpAnchor instanceof IdentityAnchor) {
				anchor = (IdentityAnchor)tmpAnchor;
			}
			if(anchor == null) {
				ConnectionAnchor connectionAnchor = null;
				if(nodeEP.getFigure() instanceof NodeFigure) {
					NodeFigure nodeFigure = (NodeFigure)nodeEP.getFigure();
					if(sourcePoint) {
						connectionAnchor = nodeFigure.getSourceConnectionAnchorAt(p);
					} else {
						connectionAnchor = nodeFigure.getTargetConnectionAnchorAt(p);
					}
					if(connectionAnchor != null) {
						final String id = nodeEP.mapConnectionAnchorToTerminal(connectionAnchor);
						anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
						anchor.setId(id);
					}
				}
			}

		}
		return anchor;

	}

	/**
	 * 
	 * @param nodeEditPart
	 *        the resized edit part
	 * @param oldNodeBounds
	 *        the old bounds for this edit part
	 * @param newNodeBounds
	 *        the new bounds for this edit part
	 * @param targetConnectionEP
	 *        the edit part of the connection for which we want fix anchor
	 * @param move
	 *        the move
	 * @param sizeDelta
	 *        the delta of the resize
	 * @param fixSource
	 *        if <code>true</code> we are fixing the source anchor if <code>false</code> we are fixing the target anchor
	 * @return
	 */
	private Command getFixAnchorCommand(final INodeEditPart nodeEditPart, final PrecisionRectangle oldNodeBounds, final PrecisionRectangle newNodeBounds, final AbstractConnectionEditPart targetConnectionEP, final Point move, final Dimension sizeDelta, final boolean fixSource) {
		final Point realAnchorPoint = getRealAnchorPoint(targetConnectionEP, fixSource);

		final IFigure fig = nodeEditPart.getFigure();
		if(fig instanceof NodeFigure) {
			final NodeFigure nodeFigure = (NodeFigure)fig;
			final IdentityAnchor editedAnchor = getIdentityAnchor(targetConnectionEP, fixSource, nodeEditPart, realAnchorPoint);
			if(realAnchorPoint != null && editedAnchor != null) {

				final View view = (View)targetConnectionEP.getAdapter(View.class);
				if(view instanceof Edge) {
					//1. get the real side on which start/end the manipulated anchor
					final int anchorSide = getSideOfConnectionPoint(nodeFigure, targetConnectionEP, fixSource);
					//2. determine the new values
					double newX = -1;
					double newY = -1;
					switch(anchorSide) {
					case PositionConstants.NORTH:
						newY = 0;
						break;
					case PositionConstants.WEST:
						newX = 0;
						break;
					case PositionConstants.EAST:
						newX = 1;
						break;
					case PositionConstants.SOUTH:
						newY = 1;
						break;
					default:
						// other case not yet manager because they are resize dependant!
						break;
					}

					PrecisionPoint newRealAnchorPoint = new PrecisionPoint(realAnchorPoint);
					newRealAnchorPoint.setPreciseLocation(newRealAnchorPoint.x() - oldNodeBounds.preciseX(), newRealAnchorPoint.y() - oldNodeBounds.preciseY());

					PrecisionPoint newLocation = newRealAnchorPoint.getPreciseCopy();
					newLocation.setPreciseX(newLocation.preciseX() - move.preciseX());
					newLocation.setPreciseY(newLocation.preciseY() - move.preciseY());

					if(newX == -1) {
						newX = newLocation.preciseX() / newNodeBounds.preciseWidth();
					}
					if(newY == -1) {
						newY = newLocation.preciseY() / newNodeBounds.preciseHeight();
					}

					if(newX <= 1 && newX >= 0 && newY <= 1 && newY >= 0) {
						final String newIdValue = IdentityAnchorHelper.createNewAnchorIdValue(newX, newY);
						final ICommand cmd = new AbstractTransactionalCommand(this.domain, "Fix Anchor Location", null) { //$NON-NLS-1$

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								editedAnchor.setId(newIdValue);

								if(editedAnchor.eContainer() == null) {
									if(fixSource) {
										((Edge)view).setSourceAnchor(editedAnchor);
									} else {
										((Edge)view).setTargetAnchor(editedAnchor);
									}
								}
								return CommandResult.newOKCommandResult(editedAnchor);
							}
						};
						return new ICommandProxy(cmd);
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param nodeFigure
	 *        the node figure
	 * @param edgeEP
	 *        the connection edit part
	 * @param fixingSource
	 *        if <code>true</code> we are fixing the source anchor and if <code>false</code> we are fixing the target anchor
	 * @return
	 *         the direction of the manipulated anchor (according to {@link PositionConstants}
	 */
	protected final int getSideOfConnectionPoint(final IFigure nodeFigure, final AbstractConnectionEditPart edgeEP, final boolean fixingSource) {
		int side = -1;
		final IFigure figure = edgeEP.getFigure();
		if(figure instanceof PolylineConnectionEx) {
			final PolylineConnectionEx connection = (PolylineConnectionEx)figure;
			final Rectangle bounds = nodeFigure.getBounds().getCopy();
			nodeFigure.translateToAbsolute(bounds);
			final Point pt;
			if(fixingSource) {
				pt = connection.getStart();
			} else {
				pt = connection.getEnd();
			}
			figure.translateToAbsolute(pt);
			Rectangle includedRect = bounds.getCopy();
			while(includedRect.contains(pt)) {
				includedRect.shrink(1, 1);
			}
			side = includedRect.getPosition(pt);
			//if the anchor side is a corner, we determine its side using another point
			if(side == PositionConstants.NORTH_WEST || side == PositionConstants.NORTH_EAST || side == PositionConstants.SOUTH_EAST || side == PositionConstants.SOUTH_WEST) {
				final Point previousPoint;
				final PointList list = connection.getPoints();
				if(list.size() > 1) {

					if(fixingSource) {
						previousPoint = list.getPoint(1);
					} else {
						previousPoint = list.getPoint(list.size() - 2);
					}
					nodeFigure.translateToAbsolute(previousPoint.getCopy());
					while(includedRect.contains(previousPoint)) {
						includedRect.shrink(1, 1);
					}
					side = includedRect.getPosition(previousPoint);
				}
			}
		}
		return side;
	}
}
