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
package org.eclipse.papyrus.uml.diagram.common.layout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.uml.diagram.common.util.Util;

/**
 * This class provides utilities for the layout actions
 * 
 * 
 */
public class LayoutUtils {

	public final static String alignementCmdId = "org.eclipse.papyrus.uml.diagram.common.commands.AlignmentCommand"; //$NON-NLS-1$

	public final static String routingCmdId = "org.eclipse.papyrus.uml.diagram.common.commands.RoutingCommand"; //$NON-NLS-1$

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

	/** the parameter for the horizontal distribution */
	final public static String MIDDLE = "parameter_middle"; //$NON-NLS-1$

	/** the parameter for the horizontal distribution */
	final public static String HORIZONTALLY = "parameter_horizontally"; //$NON-NLS-1$

	/** the parameter for the horizontal distribution between nodes */
	final public static String HORIZONTALLY_BETWEEN_NODES = "parameter_horizontally_between_nodes"; //$NON-NLS-1$

	/** the parameter for the vertical distribution */
	final public static String VERTICALLY = "parameter_vertically"; //$NON-NLS-1$

	/** the parameter for the vertical distribution between nodes */
	final public static String VERTICALLY_BETWEEN_NODES = "parameter_vertically_between_nodes"; //$NON-NLS-1$

	/**
	 * the shift to avoid the scrollbar If there is no scrollBar, set
	 * scrollBarSize to 0.0!
	 */
	public static final double scrollBarSize = 6;

	/**
	 * 
	 * A {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 * @param ep
	 *        the {@link EditPart} that we want the position
	 * @return a {@link Rectangle} with the absolute position from the {@link EditPart}
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
	 *        the anchor. the anchor must in absolute coordinate before call
	 *        this method.
	 * @return the side on which the anchor is on the {@link EditPart} The
	 *         returned values can be :
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NONE}
	 *         <ul>
	 *         <li>if the figure is not not known. (This algorithm depends on the figure form).</li>
	 *         <li>Maybe you forgot to translate the anchor in absolute coordinate or the anchor is not attached to the figure</li>
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

		// we are not on EAST, not on WEST, but we are on the NORTH
		if((anchor.y == bounds.y) && (anchor.x != bounds.x) && (anchor.x != bounds.getRight().x)) {
			position = PositionConstants.NORTH;

			// we are not on the EAST and not on the WEST, but we are on the
			// SOUTH
		} else if((anchor.y == bounds.getBottom().y) && (anchor.x != bounds.x) && (anchor.x != bounds.getRight().x)) {
			position = PositionConstants.SOUTH;

			// we are on the EAST, but we are not on the NORTH and not on the
			// SOUTH
		} else if((anchor.x == bounds.getRight().x) && (anchor.y != bounds.y) && (anchor.y != bounds.getBottom().y)) {
			position = PositionConstants.EAST;

			// we are on the WEST, but we are not on the on the NORTH and not on
			// the SOUTH
		} else if((anchor.x == bounds.x) && (anchor.y != bounds.getTop().y) && (anchor.y != bounds.getBottom().y)) {
			position = PositionConstants.WEST;

			// we are on the NORTH and on the EAST
		} else if(anchor.equals(bounds.getLeft())) {
			position = PositionConstants.NORTH_EAST;

			// we are on the NORTH and on the WEST
		} else if(anchor.equals(bounds.getRight())) {
			position = PositionConstants.NORTH_WEST;

			// we are on the EAST and on the SOUTH
		} else if(anchor.equals(bounds.getBottomRight())) {
			position = PositionConstants.SOUTH_EAST;

			// we are on the WEST and on the SOUTH
		} else if(anchor.equals(bounds.getBottomLeft())) {
			position = PositionConstants.SOUTH_WEST;
		}

		if(position == PositionConstants.NONE) {// the figure is not a
												// rectangle
			if(node instanceof ShapeEditPart) {
				for(Object obj : node.getChildren()) {
					if(obj instanceof CompartmentEditPart && position == PositionConstants.NONE) {
						position = getAnchorPosition((EditPart)obj, anchor);
					}
				}
				if(position == PositionConstants.NONE) {// the figure is not a
														// rectangle
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

	private final static int[] northArray = { PositionConstants.NORTH, PositionConstants.NORTH_EAST, PositionConstants.NORTH_WEST };

	private final static int[] southArray = { PositionConstants.SOUTH, PositionConstants.SOUTH_EAST, PositionConstants.SOUTH_WEST };

	private final static int[] eastArray = { PositionConstants.EAST, PositionConstants.NORTH_EAST, PositionConstants.SOUTH_EAST };

	private final static int[] westArray = { PositionConstants.WEST, PositionConstants.NORTH_WEST, PositionConstants.SOUTH_WEST };

	public final static List<Integer> northPositions = fillList(northArray);

	public final static List<Integer> southPositions = fillList(southArray);

	public final static List<Integer> eastPositions = fillList(eastArray);

	public final static List<Integer> westPositions = fillList(westArray);

	private static List<Integer> fillList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			list.add(new Integer(array[i]));
		}
		return list;
	}

	/**
	 * This method return the position of the ends for the link to have a nice
	 * representation. Some cases can be distinguish :
	 * <ul>
	 * <li>The 2 EditParts do not have intersection</li>
	 * <li>An EditPart is included in the other</li>
	 * <li>An EditPart intersects a part of the other : we calculate nothing</li>
	 * </ul>
	 * 
	 * Moreover this method includes a specific algorithm when the EditPart is
	 * an Affixed Child Node
	 * 
	 * @param sourceEditPart
	 *        he source EditPart
	 * @param targetEditPart
	 *        the targetEditPart
	 * @return <ul>
	 *         <li>Point[0] is the source Anchor</li>
	 *         <li>Point[1] is the target Anchor</li>
	 *         </ul>
	 */
	public static Point[] getLinkAnchor(IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) {
		Point sourceLocation = new Point();
		Point targetLocation = new Point();
		int targetPosition = PositionConstants.NONE;
		PrecisionRectangle sourceBounds = getAbsolutePosition(sourceEditPart);
		PrecisionRectangle targetBounds = getAbsolutePosition(targetEditPart);
		EditPart diagramEP = sourceEditPart;
		while(!(diagramEP instanceof DiagramEditPart)) {
			diagramEP = diagramEP.getParent();
		}
		PrecisionRectangle diagramBounds = getAbsolutePosition(diagramEP);

		if(!sourceBounds.intersects(targetBounds)) {
			/*
			 * there is no intersection between the 2 EditParts we look for the
			 * position of targetEditPart/sourceEditPart
			 */
			targetPosition = getRelativePositionFor(sourceBounds, targetBounds, diagramBounds);
			// calculate source location
			if(!Util.isAffixedChildNode(sourceEditPart)) {
				switch(targetPosition) {
				case PositionConstants.NORTH:// 1
					sourceLocation = sourceBounds.getTop();
					if(sourceBounds.preciseX() >= targetBounds.preciseX() && sourceBounds.getRight().preciseX() <= targetBounds.getRight().preciseX()) {
						// nothing to do
					} else if(sourceBounds.preciseX() <= targetBounds.preciseX() && sourceBounds.getRight().preciseX() >= targetBounds.getRight().preciseX()) {
						sourceLocation.x = (int)targetBounds.getBottom().preciseX();
					} else if(sourceBounds.preciseX() <= targetBounds.preciseX() && sourceBounds.getRight().preciseX() <= targetBounds.getRight().preciseX()) {
						sourceLocation.x = (int)(((targetBounds.preciseX() + sourceBounds.getRight().preciseX()) / 2));
					} else {
						sourceLocation.x = (int)(((sourceBounds.preciseX() + targetBounds.getRight().preciseX()) / 2));
					}
					break;
				case PositionConstants.SOUTH:// 4
					sourceLocation = sourceBounds.getBottom();
					if(sourceBounds.preciseX() >= targetBounds.preciseX() && sourceBounds.getRight().preciseX() <= targetBounds.getRight().preciseX()) {
						// nothing to do
					} else if(sourceBounds.preciseX() <= targetBounds.preciseX() && sourceBounds.getRight().preciseX() >= targetBounds.getRight().preciseX()) {
						sourceLocation.x = (int)targetBounds.getBottom().preciseX();
					} else if(sourceBounds.preciseX() <= targetBounds.preciseX() && sourceBounds.getRight().preciseX() <= targetBounds.getRight().preciseX()) {
						sourceLocation.x = (int)(((targetBounds.preciseX() + sourceBounds.getRight().preciseX()) / 2));
					} else {
						sourceLocation.x = (int)(((sourceBounds.preciseX() + targetBounds.getRight().preciseX()) / 2));
					}
					// sourceLocation = sourceBounds.getBottom();
					break;
				case PositionConstants.EAST:// 16
					sourceLocation = sourceBounds.getRight();
					if(sourceBounds.preciseY() >= targetBounds.preciseY() && sourceBounds.getBottom().preciseY() <= targetBounds.getBottom().preciseY()) {
						// nothing to do
					} else if(sourceBounds.preciseY() <= targetBounds.preciseY() && sourceBounds.getBottom().preciseY() >= targetBounds.getBottom().preciseY()) {
						sourceLocation.y = (int)targetBounds.getLeft().preciseY();
					} else if(sourceBounds.preciseY() >= targetBounds.preciseY() && sourceBounds.getBottom().preciseY() >= targetBounds.getBottom().preciseY()) {
						sourceLocation.y = (int)((targetBounds.getBottom().preciseY() + sourceBounds.preciseY()) / 2);
					} else {
						sourceLocation.y = (int)((sourceBounds.getBottom().preciseY() + targetBounds.preciseY()) / 2);
					}
					// sourceLocation = sourceBounds.getRight();
					break;
				case PositionConstants.WEST:// 8
					sourceLocation = sourceBounds.getLeft();
					if(sourceBounds.preciseY() > targetBounds.preciseY() && sourceBounds.getBottom().preciseY() < targetBounds.getBottom().preciseY()) {
						// nothing to do
					} else if(sourceBounds.preciseY() < targetBounds.preciseY() && sourceBounds.getBottom().preciseY() > targetBounds.getBottom().preciseY()) {
						sourceLocation.y = (int)targetBounds.getLeft().preciseY();
					} else if(sourceBounds.preciseY() > targetBounds.preciseY() && sourceBounds.getBottom().preciseY() > targetBounds.getBottom().preciseY()) {
						sourceLocation.y = (int)((targetBounds.getBottom().preciseY() + sourceBounds.preciseY()) / 2);
					} else {
						sourceLocation.y = (int)((sourceBounds.getBottom().preciseY() + targetBounds.preciseY()) / 2);
					}
					// sourceLocation = sourceBounds.getLeft();
					break;
				case PositionConstants.NORTH_EAST:// 17
					sourceLocation = sourceBounds.getTop();
					break;
				case PositionConstants.NORTH_WEST:// 9
					sourceLocation = sourceBounds.getTop();
					break;
				case PositionConstants.SOUTH_EAST:// 20
					sourceLocation = sourceBounds.getBottom();
					break;
				case PositionConstants.SOUTH_WEST:// 12
					sourceLocation = sourceBounds.getBottom();
					break;
				default:
					break;
				}
			} else {
				IBorderItemLocator loc = ((IBorderItemEditPart)sourceEditPart).getBorderItemLocator();
				int side = loc.getCurrentSideOfParent();
				switch(targetPosition) {
				case PositionConstants.NORTH:// 1
					sourceLocation = sourceBounds.getTop();
					break;
				case PositionConstants.SOUTH:// 4
					sourceLocation = sourceBounds.getBottom();
					break;
				case PositionConstants.EAST:// 16
					sourceLocation = sourceBounds.getRight();
					break;
				case PositionConstants.WEST:// 8
					sourceLocation = sourceBounds.getLeft();
					break;
				case PositionConstants.NORTH_EAST:// 17
					if(eastPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getRight();
					} else if(westPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getRight();
					} else {// side is NORTH or SOUTH
						sourceLocation = sourceBounds.getTop();
					}
					break;
				case PositionConstants.NORTH_WEST:// 9
					if(eastPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getLeft();
					} else if(westPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getLeft();
					} else {// side is NORTH or SOUTH
						sourceLocation = sourceBounds.getTop();
					}
					break;
				case PositionConstants.SOUTH_EAST:// 20
					if(northPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getBottom();
					} else if(southPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getBottom();
					} else {// SIDE is EAST or WEST
						sourceLocation = sourceBounds.getRight();
					}
					break;
				case PositionConstants.SOUTH_WEST:// 12
					if(northPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getBottom();
					} else if(southPositions.contains(new Integer(side))) {
						sourceLocation = sourceBounds.getBottom();
					} else {// SIDE is EAST or WEST
						sourceLocation = sourceBounds.getLeft();
					}
					break;
				default:
					break;
				}
			}

			// calculate target location
			if(!Util.isAffixedChildNode(targetEditPart)) {
				switch(targetPosition) {
				case PositionConstants.NORTH:// 1
					targetLocation.setLocation(sourceLocation.x, (int)targetBounds.getBottom().preciseY());
					// targetLocation = targetBounds.getBottom();
					break;
				case PositionConstants.SOUTH:// 4
					targetLocation.setLocation(sourceLocation.x, (int)targetBounds.getTop().preciseY());
					// targetLocation = targetBounds.getTop();
					break;
				case PositionConstants.EAST:// 16
					targetLocation.setLocation((int)targetBounds.preciseX(), (int)sourceLocation.preciseY());
					// targetLocation = targetBounds.getLeft();
					break;
				case PositionConstants.WEST:// 8
					targetLocation.setLocation((int)targetBounds.preciseX(), (int)sourceLocation.preciseY());
					// targetLocation = targetBounds.getRight();
					break;
				case PositionConstants.NORTH_EAST:// 17
					targetLocation = targetBounds.getLeft();
					break;
				case PositionConstants.NORTH_WEST:// 9
					targetLocation = targetBounds.getRight();
					break;
				case PositionConstants.SOUTH_EAST:// 20
					targetLocation = targetBounds.getLeft();
					break;
				case PositionConstants.SOUTH_WEST:// 12
					targetLocation = targetBounds.getRight();
					break;
				default:
					break;
				}
			} else {
				IBorderItemLocator loc = ((IBorderItemEditPart)targetEditPart).getBorderItemLocator();
				int side = loc.getCurrentSideOfParent();
				switch(targetPosition) {
				case PositionConstants.NORTH:// 1
					targetLocation = targetBounds.getBottom();
					break;
				case PositionConstants.SOUTH:// 4
					targetLocation = targetBounds.getTop();
					break;
				case PositionConstants.EAST:// 16
					targetLocation = targetBounds.getLeft();
					break;
				case PositionConstants.WEST:// 8
					targetLocation = targetBounds.getRight();
					break;
				case PositionConstants.NORTH_EAST:// 17
					if(eastPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getRight();
					} else if(westPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getRight();
					} else {
						targetLocation = targetBounds.getTop();
					}
					break;
				case PositionConstants.NORTH_WEST:// 9
					if(eastPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getLeft();
					} else if(westPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getLeft();
					} else {
						targetLocation = targetBounds.getTop();
					}
					break;
				case PositionConstants.SOUTH_EAST:// 20
					if(northPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getTop();
					} else if(southPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getTop();
					} else {
						targetLocation = targetBounds.getLeft();
					}
					break;
				case PositionConstants.SOUTH_WEST:// 12
					if(northPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getTop();
					} else if(southPositions.contains(new Integer(side))) {
						targetLocation = targetBounds.getTop();
					} else {
						targetLocation = targetBounds.getRight();
					}
					break;
				default:
					break;
				}
			}

		} else {
			// source and target intersect them
			// test if one editpart is included in other
			if(sourceBounds.contains(targetBounds)) {
				sourceLocation.setLocation((int)targetBounds.getBottom().preciseX(), (int)sourceBounds.getBottom().preciseY());
				targetLocation = targetBounds.getBottom();
			} else if(targetBounds.contains(sourceBounds)) {
				sourceLocation = sourceBounds.getBottom();
				targetLocation.setLocation((int)sourceBounds.getBottom().preciseX(), (int)targetBounds.getBottom().preciseY());
			} else {
				Rectangle rect = new Rectangle(sourceBounds);
				Rectangle intersection = rect.getCopy().intersect(targetBounds);
				int intersectPosition = getRelativePositionFor(sourceBounds, new PrecisionRectangle(intersection), diagramBounds);
				// Currently we do nothing in this case
			}
		}
		// return new Point[]{ new Point(), new Point() };
		return new Point[]{ sourceLocation, targetLocation };
	}

	/**
	 * Return the Position of rect compared with reference
	 * 
	 * @param reference
	 *        the reference
	 * @param rect
	 *        another rectangle
	 * @return the position of rect compared with reference Returned values can
	 *         be :
	 *         <ul>
	 *         <li> {@link PositionConstants#NORTH}</li>
	 *         <li> {@link PositionConstants#SOUTH}</li>
	 *         <li> {@link PositionConstants#EAST}</li>
	 *         <li>{@link PositionConstants#WEST}</li>
	 *         <li> {@link PositionConstants#NORTH_EAST}</li>
	 *         <li> {@link PositionConstants#NORTH_WEST}</li>
	 *         <li> {@link PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@link PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 *         If the 2 Rectangles intersect between them, the answer will be
	 *         one of NORTH_EAST or SOUTH_EAST or NORTH_WEST or SOUTH_WEST
	 */
	public static int getRelativePositionFor(PrecisionRectangle reference, PrecisionRectangle rect, PrecisionRectangle diagramBounds) {
		// | |
		// NOTHING | NORTH |NOTHING
		// | |
		// ----------------- +-+-+-+-+-+-+-+-+-+-+-+-+ --------------------
		// | |
		// + +
		// | |
		// WEST + REFERENCE + EAST
		// | |
		// + +
		// | |
		// ----------------- +-+-+-+-+-+-+-+-+-+-+-+-+ -------------------
		// NOTHING | |NOTHING
		// SOUTH

		PrecisionRectangle pos = new PrecisionRectangle();
		// NORTH
		pos.setX(reference.preciseX());
		pos.setY(0);
		pos.setHeight(reference.preciseY());
		pos.setWidth(reference.preciseWidth());
		if(pos.intersects(rect)) {
			return PositionConstants.NORTH;// 1
		}
		// SOUTH
		pos.setX(reference.preciseX());
		pos.setY(reference.getBottom().preciseY());
		pos.setHeight(diagramBounds.preciseHeight() - reference.getBottom().preciseY());
		pos.setWidth(reference.preciseWidth());
		if(pos.intersects(rect)) {
			return PositionConstants.SOUTH;// 4
		}
		// EAST
		pos.setX(reference.getRight().preciseX());
		pos.setY(reference.getTop().preciseY());
		pos.setHeight(reference.preciseHeight());
		pos.setWidth(diagramBounds.preciseWidth() - reference.getLeft().preciseY());
		if(pos.intersects(rect)) {
			return PositionConstants.EAST;// 16
		}

		// WEST
		pos.setX(0);
		pos.setY(reference.preciseY());
		pos.setHeight(reference.preciseHeight());
		pos.setWidth(reference.preciseX());
		if(pos.intersects(rect)) {
			return PositionConstants.WEST;// 8
		}

		// |
		// NORTH-WEST | NORTH-EAST
		// |
		// |
		// |
		// +-+-+-+-+-+-+-+-+-+-+-+-+
		// | | |
		// + REF | REF +
		// | | |
		// --------------- + ----------+---------- + ----------------------
		// | | |
		// + REF | REF +
		// | | |
		// +-+-+-+-+-+-+-+-+-+-+-+-+
		// |
		// SOUTH-WEST | SOUTH-EAST
		// |
		// |
		// |

		// NORTH_EAST
		pos.setX(reference.getTop().preciseX());
		pos.setY(0);
		pos.setHeight(reference.getRight().preciseY());
		pos.setWidth(diagramBounds.preciseWidth() - reference.getTop().preciseX());
		if(pos.intersects(rect)) {
			return PositionConstants.NORTH_EAST;// 17
		}
		// NORTH_WEST
		pos = new PrecisionRectangle();
		pos.setX(0);
		pos.setY(0);
		pos.setHeight(reference.getLeft().preciseY());
		pos.setWidth(reference.getTop().preciseX());
		if(pos.intersects(rect)) {
			return PositionConstants.NORTH_WEST;// 9
		}

		// SOUTH_EAST
		pos = new PrecisionRectangle();
		pos.setX(reference.getBottom().preciseX());
		pos.setY(reference.getRight().preciseY());
		pos.setHeight(diagramBounds.preciseHeight() - reference.getRight().preciseY());
		pos.setWidth(diagramBounds.preciseWidth() - reference.getBottom().preciseX());
		if(pos.intersects(rect)) {
			return PositionConstants.SOUTH_EAST;// 20
		}

		// SOUTH_WEST
		pos = new PrecisionRectangle();
		pos.setX(0);
		pos.setY(reference.getLeft().preciseY());
		pos.setHeight(diagramBounds.preciseHeight() - reference.getLeft().preciseY());
		pos.setWidth(reference.getBottom().preciseX());
		if(pos.intersects(rect)) {
			return PositionConstants.SOUTH_WEST;// 12
		}

		Activator.log("I can't find the relative position for " + rect + " compared to " + reference + " ."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		return PositionConstants.NONE;
	}
}
