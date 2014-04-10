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
package org.eclipse.papyrus.infra.services.edit.utils;

/**
 * <pre>
 * IDs of request parameters.
 * </pre>
 */
public interface RequestParameterConstants {

	/**
	 * The ID for the additional parameter SOURCE_PARENT possibly required in link creation request
	 * 
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_PARENT = "SOURCE_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_PARENT possibly required in link creation request
	 * 
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_PARENT = "TARGET_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter RECONNECT_PARENT possibly required in link reconnect request
	 * 
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_REORIENT_REQUEST_TARGET_PARENT = "RECONNECT_PARENT"; //$NON-NLS-1$

	/**
	 * Extended request data key to hold the edge view during a reconnect request.
	 */
	public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter SOURCE_GRAPHICAL_VIEW possibly required in link creation request
	 */
	public static final String EDGE_CREATE_REQUEST_SOURCE_VIEW = "SOURCE_GRAPHICAL_VIEW"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_GRAPHICAL_VIEW possibly required in link creation request
	 */
	public static final String EDGE_CREATE_REQUEST_TARGET_VIEW = "TARGET_GRAPHICAL_VIEW"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter RECONNECT_END_VIEW possibly required in link reconnect request
	 */
	public static final String EDGE_REORIENT_REQUEST_END_VIEW = "RECONNECT_END_VIEW"; //$NON-NLS-1$

	/**
	 * The ID to store the list of element under re-factoring.
	 */
	public static final String ASSOCIATION_REFACTORED_ELEMENTS = "ASSOCIATION_REFACTORED_ELEMENTS"; //$NON-NLS-1$

	/**
	 * The ID to store the list of element that should not be destroyed (avoid dependents destroy).
	 */
	public static final String DEPENDENTS_TO_KEEP = "DEPENDENTS_TO_KEEP"; //$NON-NLS-1$

	/**
	 * The ID to store the source figure for an edge creation
	 */
	public static final String EDGE_SOURCE_FIGURE = "EDGE_SOURCE_FIGURE"; //$NON-NLS-1$

	/**
	 * The ID to store the target figure for an edge creation
	 */
	public static final String EDGE_TARGET_FIGURE = "EDGE_TARGET_FIGURE"; //$NON-NLS-1$
	
	/**
	 * the ID to store the source point for an edge creation
	 */
	public static final String EDGE_SOURCE_POINT = "EDGE_SOURCE_POINT"; //$NON-NLS-1$

	/**
	 * the ID to store the target point for an edge creation
	 */
	public static final String EDGE_TARGET_POINT = "EDGE_TARGET_POINT"; //$NON-NLS-1$
	
}
