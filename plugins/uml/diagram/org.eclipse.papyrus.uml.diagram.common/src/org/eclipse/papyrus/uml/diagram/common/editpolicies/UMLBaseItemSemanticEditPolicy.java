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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

/**
 * <pre>
 * This class is currently generated for all diagram but could (for most of it)
 * be shared in common as a large part of it is diagram independent.
 * The LinkConstraints nested class should also be generated in a separate
 * class.
 * For now, in order to avoid to much changes in the generator, it only contains 
 * the constant use to hold a reoriented edge in the request extended data.
 * </pre>
 */
public abstract class UMLBaseItemSemanticEditPolicy {

	/**
	 * Extended request data key to hold the edge view during a reconnect
	 * request.
	 */
	public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; //$NON-NLS-1$

}
