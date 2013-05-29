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
package org.eclipse.papyrus.uml.diagram.sequence.util;

/**
 * Constants used in the sequence diagram
 */
public interface SequenceRequestConstant {

	/** A constant representing the container of an interactionFragment. It can be an Interaction or an InteractionOperand */
	public static final String INTERACTIONFRAGMENT_CONTAINER = "InteractionFragment Container"; //$NON-NLS-1$

	/** key for a set of covered InteractionFragment which needs to be moved inside a new container. */
	public static final String COVERED_INTERACTIONFRAGMENTS = "Covered InteractionFragments"; //$NON-NLS-1$

	public static final String SOURCE_MODEL_CONTAINER = "Source model container"; //$NON-NLS-1$

	public static final String TARGET_MODEL_CONTAINER = "Target model container"; //$NON-NLS-1$

	/** A key used in the creation of a CORegion to identify the lifeline graphically containing the CoRegion */
	public static final String LIFELINE_GRAPHICAL_CONTAINER = "Lifeline graphical container"; //$NON-NLS-1$ 

	/** The occurrence specification(s) which are the nearest from a creation request */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION = "Nearest occurrence specification"; //$NON-NLS-1$

	/** The location of the occurrence specification which is the nearest from a creation request */
	public static final String OCCURRENCE_SPECIFICATION_LOCATION = "Nearest occurrence specification location"; //$NON-NLS-1$

	/** The occurrence specification(s) which are the nearest from a creation request (2nd end of creation) */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION_2 = "Nearest occurrence specification (end)"; //$NON-NLS-1$

	/** The location of the occurrence specification which is the nearest from a creation request (2nd end of creation) */
	public static final String OCCURRENCE_SPECIFICATION_LOCATION_2 = "Nearest occurrence specification location (end)"; //$NON-NLS-1$

	/** Tag signifying that the edit parts must not be moved when an occurrence specification is moved (to avoid loop in chain effects) */
	public static final String DO_NOT_MOVE_EDIT_PARTS = "Do not move these edit parts"; //$NON-NLS-1$

	/** The location of the connection start creation request */
	public static final String SOURCE_LOCATION_DATA = "Location of connection source point"; //$NON-NLS-1$

	/** update connectable element reference */
	public static final String CONNECTABLE_ELEMENT = "Connectable Element"; //$NON-NLS-1$

	/** Direct edit request after creation. */
	public static final String DIRECT_EDIT_AFTER_CREATION = "Direct Edit After Creation"; //$NON-NLS-1$
}
