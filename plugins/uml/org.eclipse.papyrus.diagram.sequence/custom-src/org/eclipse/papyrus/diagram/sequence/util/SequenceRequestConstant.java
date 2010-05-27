/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

/**
 * Constants used in the sequence diagram
 */
public interface SequenceRequestConstant {

	/** A constant representing the container of an interactionFragment. It can be an Interaction or an InteractionOperand */
	public static final String INTERACTIONFRAGMENT_CONTAINER = "InteractionFragment Container"; //$NON-NLS-1$

	public static final String SOURCE_MODEL_CONTAINER = "Source model container"; //$NON-NLS-1$

	public static final String TARGET_MODEL_CONTAINER = "Target model container"; //$NON-NLS-1$

	/** A key used in the creation of a CORegion to identify the lifeline graphically containing the CoRegion*/
	public static final String LIFELINE_GRAPHICAL_CONTAINER = "Lifeline graphical container"; //$NON-NLS-1$ 

	/** The occurrence specification which is the nearest from a creation request */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION = "Nearest occurrence specification"; //$NON-NLS-1$

	/** The location of the occurrence specification which is the nearest from a creation request */
	public static final String OCCURRENCE_SPECIFICATION_LOCATION = "Nearest occurrence specification location"; //$NON-NLS-1$

	/** The occurrence specification which is the nearest from a creation request (2nd end of creation) */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION_2 = "Nearest occurrence specification (end)"; //$NON-NLS-1$

	/** The location of the occurrence specification which is the nearest from a creation request (2nd end of creation) */
	public static final String OCCURRENCE_SPECIFICATION_LOCATION_2 = "Nearest occurrence specification location (end)"; //$NON-NLS-1$

	/** The time element which must not be moved after reconnection command (when reconnection comes from a move command) */
	public static final Object DO_NOT_MOVE_TIME_ELEMENT = "Do not move this time element"; //$NON-NLS-1$
}
