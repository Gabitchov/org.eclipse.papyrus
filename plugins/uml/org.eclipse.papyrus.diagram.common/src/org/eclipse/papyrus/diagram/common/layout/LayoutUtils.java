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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.layout;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;

/**
 * This class provides utilities for the layout actions
 * 
 * 
 */
public class LayoutUtils {

	public final static String alignementCmdId = "org.eclipse.papyrus.diagram.common.commands.AlignmentCommand"; //$NON-NLS-1$

	public final static String routingCmdId = "org.eclipse.papyrus.diagram.common.commands.RoutingCommand"; //$NON-NLS-1$

	/** the parameter for the left command (alignment and routing command) */
	final public static String LEFT = "parameter_left"; //$NON-NLS-1$

	/** the parameter for the right commands (alignment and routing command) */
	final public static String RIGHT = "parameter_right"; //$NON-NLS-1$

	/** the parameter for the top commands (alignment and routing command) */
	final public static String TOP = "parameter_top"; //$NON-NLS-1$

	/** the parameter for the bottom commands (alignment and routing command) */
	final public static String BOTTOM = "parameter_bottom"; //$NON-NLS-1$

	/** the parameter for the center alignment */
	final public static String CENTER = "parameter_center"; //$NON-NLS-1$

	/** the parameter for the middle alignment */
	final public static String MIDDLE = "parameter_middle"; //$NON-NLS-1$

	/**
	 * the shift to avoid the scrollbar
	 * If there is no scrollBar, set scrollBarSize to 0.0!
	 */
	public static final double scrollBarSize = 6;

	/**
	 * 
	 * A {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 * @param ep
	 *        the {@link EditPart} that we want the position
	 * @return
	 *         a {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 */
	public static PrecisionRectangle getAbsolutePosition(EditPart ep) {
		GraphicalEditPart part = (GraphicalEditPart)ep;
		PrecisionRectangle rect = new PrecisionRectangle(part.getFigure().getBounds());
		part.getFigure().translateToAbsolute(rect);
		return rect;
	}


	/**
	 * Returns the side on which the anchor is on the {@link EditPart}
	 * 
	 * @param node
	 *        the node where is located the anchor
	 * @param anchor
	 *        the anchor. the anchor must in absolute coordinate before call this method.
	 * @return
	 *         the side on which the anchor is on the {@link EditPart} The returned values can be :
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NONE}
	 *         <ul>
	 *         <li>if the figure is not not known. (This algorithm depends on the figure form).</li>
	 *         <li>You forgot translate the anchor in absolute coordinate</li>
	 *         </ul>
	 *         </li>
	 *         <li>{@linkplain PositionConstants#NORTH}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#EAST}</li>
	 *         <li> {@linkplain PositionConstants#WEST}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#NORTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_WEST}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 */
	public static int getAnchorPosition(EditPart node, Point anchor) {
		int position = PositionConstants.NONE;
		PrecisionRectangle bounds = LayoutUtils.getAbsolutePosition(node);

		//we are not on EAST, not on WEST, but we are on the NORTH
		if((anchor.y == bounds.y) && (anchor.x != bounds.x) && (anchor.x != bounds.getRight().x)) {
			position = PositionConstants.NORTH;

			//we are not on the EAST and not on the WEST, but we are on the SOUTH			
		} else if((anchor.y == bounds.getBottom().y) && (anchor.x != bounds.x) && (anchor.x != bounds.getRight().x)) {
			position = PositionConstants.SOUTH;

			//we are on the EAST, but we are not on the NORTH and not on the SOUTH
		} else if((anchor.x == bounds.getRight().x) && (anchor.y != bounds.y) && (anchor.y != bounds.getBottom().y)) {
			position = PositionConstants.EAST;

			//we are on the WEST, but we are not on the on the NORTH and not on the SOUTH
		} else if((anchor.x == bounds.x) && (anchor.y != bounds.getTop().y) && (anchor.y != bounds.getBottom().y)) {
			position = PositionConstants.WEST;

			//we are on the NORTH and on the EAST
		} else if(anchor.equals(bounds.getLeft())) {
			position = PositionConstants.NORTH_EAST;

			//we are on the NORTH and on the WEST
		} else if(anchor.equals(bounds.getRight())) {
			position = PositionConstants.NORTH_WEST;

			//we are on the EAST and on the SOUTH
		} else if(anchor.equals(bounds.getBottomRight())) {
			position = PositionConstants.SOUTH_EAST;

			//we are on the WEST and on the SOUTH
		} else if(anchor.equals(bounds.getBottomLeft())) {
			position = PositionConstants.SOUTH_WEST;
		}

		if(position == PositionConstants.NONE) {//the figure is not a rectangle
			if(node instanceof ShapeEditPart) {
				for(Object obj : node.getChildren()) {
					if(obj instanceof CompartmentEditPart && position == PositionConstants.NONE) {
						position = getAnchorPosition((EditPart)obj, anchor);
					}
				}
				if(position == PositionConstants.NONE) {//the figure is not a rectangle
					IFigure figure = ((ShapeEditPart)node).getFigure();
					if(figure instanceof IOvalAnchorableFigure) {
						Rectangle bounds2 = ((IOvalAnchorableFigure)figure).getOvalBounds().getCopy();
						figure.translateToAbsolute(bounds2);
						Rectangle northWestBounds = new Rectangle(bounds2.x, bounds2.y, bounds2.width / 2, bounds2.height / 2);
						Rectangle southWestBounds = new Rectangle(bounds2.getLeft().x, bounds2.getLeft().y, bounds2.width / 2, bounds2.height / 2);
						Rectangle northEAstBounds = new Rectangle(bounds2.getTop().x, bounds2.getTop().y, bounds2.width / 2, bounds2.height / 2);
						Rectangle southEAstBounds = new Rectangle(bounds2.getTop().x, bounds2.getLeft().y, bounds2.width / 2, bounds2.height / 2);
						if(northEAstBounds.contains(anchor)) {
							return PositionConstants.NORTH_EAST;
						} else if(southEAstBounds.contains(anchor)) {
							return PositionConstants.SOUTH_EAST;
						} else if(southWestBounds.contains(anchor)) {
							return PositionConstants.SOUTH_WEST;
						} else if(northWestBounds.contains(anchor)) {
							return PositionConstants.NORTH_WEST;
						}
					}
				}
			}
		}
		return position;
	}
}
