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
package org.eclipse.papyrus.diagram.communication.custom.edit.policies;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.diagram.communication.custom.figures.CustomWrappingLabel;
import org.eclipse.papyrus.diagram.communication.custom.util.RotationHelper;
import org.eclipse.uml2.uml.Message;

/**
 * This EditPartPolicy is used to refresh the position of the label's icon of a
 * message, The icon has to be parallel with the connection
 */
public class MessageNameEditPolicy extends AbstractEditPolicy implements AnchorListener {

	/** The source connection anchor **/
	protected ConnectionAnchor sourceConnectionAnchor;

	/** The target connection anchor **/
	protected ConnectionAnchor targetConnectionAnchor;

	/**
	 * 
	 * @param connEditPart
	 * @return the ConnectionAnchor for the specified source connection
	 */
	public ConnectionAnchor getSrcConnectionAnchor(ConnectionNodeEditPart connEditPart) {
		return connEditPart.getSourceConnectionAnchor(connEditPart);
	}

	/**
	 * 
	 * @param connEditPart
	 * @return Returns the ConnectionAnchor for the specified target connection
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionNodeEditPart connEditPart) {
		return connEditPart.getTargetConnectionAnchor(connEditPart);
	}

	/**
	 * Creates a new MessageNameEditPolicy
	 */
	public MessageNameEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {

		ConnectionEditPart connEditPart = (ConnectionEditPart)getHost().getParent();
		sourceConnectionAnchor = getSrcConnectionAnchor((ConnectionNodeEditPart)connEditPart);

		if(sourceConnectionAnchor != null) {
			// System.out.println("MessageNameEditPolicy notifyChanged: Get source connection anchor succeed\n");
			sourceConnectionAnchor.addAnchorListener(this);
		}
		// } else {
		// System.out.println("MessageNameEditPolicy notifyChanged: Get source connection anchor failed \n");
		// }

		targetConnectionAnchor = getTargetConnectionAnchor((ConnectionNodeEditPart)connEditPart);

		if(targetConnectionAnchor != null) {
			// System.out.println("MessageNameEditPolicy notifyChanged: Get target connection anchor succeed\n");
			targetConnectionAnchor.addAnchorListener(this);
		}
		// } else {
		// System.out.println("MessageNameEditPolicy notifyChanged: Get target connection anchor failed \n");
		// }

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {

		sourceConnectionAnchor.removeAnchorListener(this);

		targetConnectionAnchor.removeAnchorListener(this);
	}

	/**
	 * This method rotates the message arrow icon to be parallel to the
	 * connection
	 * 
	 * @param editPart
	 *        MessageNameEditPart
	 * @param src
	 *        The location of the source connection anchor
	 * @param target
	 *        The location of the target connection anchor
	 */
	public void refreshEditPartDisplay(GraphicalEditPart editPart, Point src, Point target) {

		// System.out.format("Wrappinglabeltext %s \n",
		// ((MessageNameEditPart)editPart).getEditText());

		IFigure figure = (editPart).getFigure();

		// System.out.println("beforeIconSET \n");

		// System.out.format("ref point SRC x %d , y %d \n", src.x, src.y);
		// System.out.format("loc point Target x %d , y %d \n", target.x,
		// target.y);
		// System.out.format("Angle of rotation is %f \n",
		// RotationHelper.calculateRotAngle(src, target));
		((CustomWrappingLabel)figure).setRotation(Math.toRadians(RotationHelper.calculateRotAngle(src, target)));
		((CustomWrappingLabel)figure).setTextAlignment(PositionConstants.CENTER);
		((CustomWrappingLabel)figure).setTextStrikeThrough(false);

		// System.out.println("IconSET \n");

	}

	/**
	 * When the anchor is moved the label icon is rotated to be parallel to the
	 * connection
	 **/

	public void anchorMoved(ConnectionAnchor anchor) {
		// TODO Auto-generated method stub



		Point sLoc = new Point();
		Point tLoc = new Point();


		ConnectionEditPart connectionEditPart = (ConnectionEditPart)getHost().getParent();
		if(connectionEditPart.getModel() instanceof Edge) {
			Edge edge = (Edge)connectionEditPart.getModel();
			if(edge.getElement() instanceof Message) {
				if(connectionEditPart.getFigure() instanceof Polyline) {
					Polyline polyline = (Polyline)connectionEditPart.getFigure();
					// List bendpoints = (List)polyline.getPoints();
					sLoc = polyline.getPoints().getFirstPoint().getCopy();
					tLoc = polyline.getPoints().getLastPoint().getCopy();
				}
			}
		}


		/*
		 * refreshEditPartDisplay calculates the rotation angle and does the
		 * icon rotation
		 */
		refreshEditPartDisplay((GraphicalEditPart)getHost(), sLoc, tLoc);

	}

	/**
	 * 
	 * @param conn
	 *        the connection that connects two lifelines
	 * @return the source container (ie. Lifeline) of the connection
	 */

	protected IFigure getSourceContainer(Connection conn) {
		if(conn.getSourceAnchor() != null)
			// return findContainerFigure(conn.getSourceAnchor().getOwner());
			return findContainerFigure(conn.getTargetAnchor().getOwner());
		return null;
	}

	/**
	 * 
	 * @param conn
	 *        the connection that connects two lifelines
	 * @return the target container (ie. Lifeline) of the connection
	 */

	protected IFigure getTargetContainer(Connection conn) {
		if(conn.getTargetAnchor() != null)
			// return findContainerFigure(conn.getTargetAnchor().getOwner());
			return findContainerFigure(conn.getSourceAnchor().getOwner());
		return null;
	}

	/**
	 * 
	 * @param fig
	 * @return the container figure
	 */

	private IFigure findContainerFigure(IFigure fig) {
		if(fig == null)
			return null;

		if(fig.getLayoutManager() instanceof XYLayout)
			return fig;

		return findContainerFigure(fig.getParent());
	}

}
