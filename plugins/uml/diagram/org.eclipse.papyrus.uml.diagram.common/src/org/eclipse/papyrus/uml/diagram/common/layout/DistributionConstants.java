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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * 
 * This class provides constants for the distribution actions
 * 
 */
public class DistributionConstants {

	/**
	 * the list of the horizontal values for the distribution and the alignment
	 * actions
	 */
	public static final List<Integer> horizontalValuesList = createArrayList(new int[]{ PositionConstants.NORTH, PositionConstants.SOUTH, PositionConstants.NORTH_EAST, PositionConstants.NORTH_WEST, PositionConstants.SOUTH_EAST, PositionConstants.SOUTH_WEST });

	/**
	 * the list of the vertical values for the distribution and the alignment
	 * actions
	 */
	public static final List<Integer> verticalValuesList = createArrayList(new int[]{ PositionConstants.EAST, PositionConstants.WEST, PositionConstants.NORTH_EAST, PositionConstants.NORTH_WEST, PositionConstants.SOUTH_EAST, PositionConstants.SOUTH_WEST });

	/**
	 * Constant used to identify the horizontal distribution in the parent
	 * container
	 */
	public static final int DISTRIBUTE_H_CONTAINER_INT = PositionConstants.HORIZONTAL;

	/** Constant used to identify the horizontal distribution between nodes */
	public static final int DISTRIBUTE_H_NODES_INT = PositionConstants.HORIZONTAL | PositionConstants.CENTER;

	/**
	 * Constant used to identify the vertical distribution in the parent
	 * container
	 */
	public static final int DISTRIBUTE_V_CONTAINER_INT = PositionConstants.VERTICAL;

	/** Constant used to identify the vertical distribution between nodes */
	public static final int DISTRIBUTE_V_NODES_INT = PositionConstants.VERTICAL | PositionConstants.MIDDLE;

	/** id for the horizontal distribution in the parent container */
	public static final String DISTRIBUTE_H_CONTAINER = "org.eclipse.papyrus.uml.diagram.common.distribute_horizontally"; //$NON-NLS-1$

	/** id for the horizontal distribution between nodes */
	public static final String DISTRIBUTE_H_NODES = "org.eclipse.papyrus.uml.diagram.common.distribute_horizontally_between_nodes"; //$NON-NLS-1$

	/** id for the vertical distribution in the parent container */
	public static final String DISTRIBUTE_V_CONTAINER = "org.eclipse.papyrus.uml.diagram.common.distribute_vertically"; //$NON-NLS-1$

	/** id for the vertical distribution between nodes */
	public static final String DISTRIBUTE_V_NODES = "org.eclipse.papyrus.uml.diagram.common.distribute_vertically_between_nodes"; //$NON-NLS-1$

	/** id for the horizontal distribution in container action */
	public static final String ACTION_DISTRIBUTE_H_CONTAINER = "org.eclipse.papyrus.uml.diagram.common.distribute_horizontally_action"; //$NON-NLS-1$

	/** id for the horizontal distribution between nodes action */
	public static final String ACTION_DISTRIBUTE_H_NODES = "org.eclipse.papyrus.uml.diagram.common.distribute_horizontally_between_nodes_action"; //$NON-NLS-1$

	/** id for the vertical distribution in container action */
	public static final String ACTION_DISTRIBUTE_V_CONTAINER = "org.eclipse.papyrus.uml.diagram.common.distribute_vertically_action"; //$NON-NLS-1$

	/** id for the vertical distribution between nodes action */
	public static final String ACTION_DISTRIBUTE_V_NODES = "org.eclipse.papyrus.uml.diagram.common.distribute_vertically_between_nodes_action"; //$NON-NLS-1$

	/** id for the distribute menu */
	public static final String MENU_DISTRIBUTE = "distributeMenu"; //$NON-NLS-1$

	/** the icon path */
	public static final String ICON_PATH = "icons/"; //$NON-NLS-1$

	/** the icon for the horizontal distribution */
	public static final String ICON_D_HORIZONTALLY = ICON_PATH + "distribute_horizontally.gif"; //$NON-NLS-1$

	/** the icon for the horizontal distribution between nodes */
	public static final String ICON_D_HORIZONTALLY_WITHIN_BOUNDS = ICON_PATH + "distribute_horizontally_between_nodes.gif"; //$NON-NLS-1$

	/** the icon for the vertical distribution */
	public static final String ICON_D_VERTICALLY = ICON_PATH + "distibute_vertically.gif"; //$NON-NLS-1$

	/** the icon for the vertical distribution between nodes */
	public static final String ICON_D_VERTICALLY_WITHIN_BOUNDS = ICON_PATH + "distribute_vertically_between_nodes.gif"; //$NON-NLS-1$

	public static final String DistributeActionMenu_DistributeMenu = Messages.DistributionConstants_DistributionTitle;

	/** Message for horizontal distribution */
	public static final String DistributeHorizontally = Messages.DistributionConstants_Distribute_Horizontally;

	/** Message for horizontal distribution between nodes */
	public static final String DistributeHorizontallyBetweenNodes = Messages.DistributionConstants_Distribute_Horizontally_Between_Nodes;

	/** Message for vertical distribution */
	public static final String DistributeVertically = Messages.DistributionConstants_Distribute_Vertically;

	/** Message for vertical distribution between nodes */
	public static final String DistributeVerticallyBetweenNodes = Messages.DistributionConstants_Distribute_Vertically_Between_Nodes;

	/**
	 * Returns an {@link ArrayList}<{@link Integer}> filled with {@code array}
	 * 
	 * @param array
	 *        the array used to create an {@link ArrayList}<{@link Integer}>
	 * @return an {@link ArrayList}<{@link Integer}> filled with {@code array}
	 */
	private static List<Integer> createArrayList(int[] array) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			values.add(array[i]);
		}
		return values;
	}

}
