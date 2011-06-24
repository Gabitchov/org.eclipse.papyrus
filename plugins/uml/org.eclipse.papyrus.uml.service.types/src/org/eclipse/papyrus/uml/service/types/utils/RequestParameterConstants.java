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
package org.eclipse.papyrus.uml.service.types.utils;

/**
 * <pre>
 * IDs of request parameters.
 * </pre>
 */
public interface RequestParameterConstants {

	/**
	 * The ID for the additional parameter SOURCE_PARENT possibly required in link creation request
	 */
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_PARENT = "SOURCE_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_PARENT possibly required in link creation request
	 */
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_PARENT = "TARGET_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter RECONNECT_PARENT possibly required in link reconnect request
	 */
	public static final String CONNECTOR_REORIENT_REQUEST_TARGET_PARENT = "RECONNECT_PARENT"; //$NON-NLS-1$

	/**
	 * Extended request data key to hold the edge view during a reconnect request.
	 */
	public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; //$NON-NLS-1$

}
