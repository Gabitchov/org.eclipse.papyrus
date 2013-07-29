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

import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * 
 * This class provides constants for the routing actions
 * 
 */
public class RoutingConstants {

	/** id for the distribute menu */
	public static final String MENU_ROUTE = "routingMenu"; //$NON-NLS-1$

	/** id for the vertical routing moving the left anchor */
	public static final String ROUTING_HORIZONTALLY_BY_LEFT = "org.eclipse.papyrus.uml.diagram.common.routing_horizontally_by_left"; //$NON-NLS-1$

	/** id for the vertical routing moving the right anchor */
	public static final String ROUTING_HORIZONTALLY_BY_RIGHT = "org.eclipse.papyrus.uml.diagram.common.routing_horizontally_by_right"; //$NON-NLS-1$

	/** id for the vertical routing moving the top anchor */
	public static final String ROUTING_VERTICALLY_BY_TOP = "org.eclipse.papyrus.uml.diagram.common.routing_vertically_by_top"; //$NON-NLS-1$

	/** id for the vertical routing moving the bottom anchor */
	public static final String ROUTING_VERTICALLY_BY_BOTTOM = "org.eclipse.papyrus.uml.diagram.common.routing_vertically_by_bottom"; //$NON-NLS-1$

	/** id for the vertical routing moving the left anchor for popup menu action */
	public static final String ROUTING_HORIZONTALLY_BY_LEFT_ACTION = "org.eclipse.papyrus.uml.diagram.common.routing_horizontally_by_left_action";; //$NON-NLS-1$

	/**
	 * id for the vertical routing moving the right anchor for popup menu action
	 */
	public static final String ROUTING_HORIZONTALLY_BY_RIGHT_ACTION = "org.eclipse.papyrus.uml.diagram.common.routing_horizontally_by_right_action"; //$NON-NLS-1$

	/** id for the vertical routing moving the top anchor for popup menu action */
	public static final String ROUTING_VERTICALLY_BY_TOP_ACTION = "org.eclipse.papyrus.uml.diagram.common.routing_vertically_by_top_action"; //$NON-NLS-1$

	/** id for the vertical routing moving the bottom anchor for popup menu */
	public static final String ROUTING_VERTICALLY_BY_BOTTOM_ACTION = "org.eclipse.papyrus.uml.diagram.common.routing_vertically_by_bottom_action"; //$NON-NLS-1$

	/** The icon folder */
	public static final String ICON_PATH = "icons/"; //$NON-NLS-1$

	/** Icon path to set link horizontal by left */
	public static final String ICON_SET_HORIZONTAL_BY_LEFT = ICON_PATH + "horizontal_by_left.gif"; //$NON-NLS-1$

	/** Icon path to set link horizontal by right */
	public static final String ICON_SET_HORIZONTAL_BY_RIGHT = ICON_PATH + "horizontal_by_right.gif"; //$NON-NLS-1$

	/** Icon path to set link horizontal by top */
	public static final String ICON_SET_VERTICAL_BY_TOP = ICON_PATH + "vertical_by_top.gif"; //$NON-NLS-1$

	/** Icon path to set link horizontal by bottom */
	public static final String ICON_SET_VERTICAL_BY_BOTTOM = ICON_PATH + "vertical_by_bottom.gif"; //$NON-NLS-1$

	/** Menu title for the routing action */
	public static String RouteActionMenu_MenuTitleText = Messages.RoutingConstants_MenuTitle;

	/** Menu ToolTip for the routing action */
	public static String RouteActionMenu_MenuTitleToolTipText = Messages.RoutingConstants_MenuToolTip;

	/** Message for horizontal routing by right action */
	public static String RouteHorizontallyByRightAction = Messages.RoutingConstants_Right;

	/** Message for horizontal routing by top action */
	public static String RouteVerticallyByTopAction = Messages.RoutingConstants_Top;

	/** Message for horizontal routing by left action */
	public static String RouteHorizontallyByLeftAction = Messages.RoutingConstants_Left;

	/** Message for horizontal routing by bottom action */
	public static String RouteVerticallyByBottomAction = Messages.RoutingConstants_Bottom;

	/** Message for horizontal routing by left */
	public static final String RouteHorizontallyByLeft = Messages.RoutingConstants_HorizontalByLeft;

	/** Message for horizontal routing by right */
	public static final String RouteHorizontallyByRight = Messages.RoutingConstants_HorizontalByRight;

	/** Message for horizontal routing by top */
	public static final String RouteVerticallyByTop = Messages.RoutingConstants_VerticalByTop;

	/** Message for horizontal routing by bottom */
	public static final String RouteVerticallyByBottom = Messages.RoutingConstants_VerticalByBottom;

	/** Tooltip message for horizontal routing by left */
	public static String RouteHorizontallyByLeftToolTipText = RouteHorizontallyByLeft;

	/** Tooltip message for horizontal routing by right */
	public static String RouteHorizontallyByRightToolTipText = RouteHorizontallyByRight;

	/** Tooltip message for horizontal routing by top */
	public static String RouteVerticallyByTopToolTipText = RouteVerticallyByTop;

	/** Tooltip message for horizontal routing by bottom */
	public static String RouteVerticallyByBottomToolTipText = RouteVerticallyByBottom;

}
