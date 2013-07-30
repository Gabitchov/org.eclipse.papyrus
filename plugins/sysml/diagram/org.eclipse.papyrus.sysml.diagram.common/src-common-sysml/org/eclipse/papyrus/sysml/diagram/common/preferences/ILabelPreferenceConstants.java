/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.common.preferences;

/**
 * Label constants for label mask preferences.
 */
public interface ILabelPreferenceConstants {

	/** preference id for display labels */
	public String LABEL_DISPLAY_PREFERENCE = "label.display";

	/** Style constant for visibility display in labels. */
	public final static int DISP_VISIBILITY = 1 << 1;

	/** Style constant for isDerive display in labels. */
	public final static int DISP_DERIVE = 1 << 2;

	/** Style constant for name display in labels. */
	public final static int DISP_NAME = 1 << 3;

	/** Style constant for type display in labels. */
	public final static int DISP_TYPE = 1 << 4;

	/** Style constant for multiplicity display in labels. */
	public final static int DISP_MULTIPLICITY = 1 << 5;

	/** Style constant for default value display in labels. */
	public final static int DISP_DEFAULTVALUE = 1 << 6;

	/** Style constant for modifiers display in labels. */
	public final static int DISP_MODIFIERS = 1 << 7;

	/** Style constant for direction display in labels. */
	public final static int DISP_DIRECTION = 1 << 8;

	/** Style constant for conjugated info display in labels. */
	public final static int DISP_CONJUGATED = 1 << 9;

	/** Style constant for id info display in labels. */
	public final static int DISP_ID = 1 << 10;

	/** Style constant for dimension info display in labels. */
	public final static int DISP_DIMENSION = 1 << 11;

	/** Style constant for specification info display in labels. */
	public final static int DISP_SPECIFICATION = 1 << 12;

	/** Style constant for signal info display in labels. */
	public final static int DISP_SIGNAL = 1 << 13;

	/** Style constant for parameter name display in labels. */
	public final static int DISP_PARAM_NAME = 1 << 14;

	/** Style constant for parameter type display in labels. */
	public final static int DISP_PARAM_TYPE = 1 << 15;

	/** Style constant for parameter multiplicity display in labels. */
	public final static int DISP_PARAM_MULTIPLICITY = 1 << 16;

	/** Style constant for parameter default value display in labels. */
	public final static int DISP_PARAM_DEFAULTVALUE = 1 << 17;

	/** Style constant for parameter modifiers display in labels. */
	public final static int DISP_PARAM_MODIFIERS = 1 << 18;

	/** Style constant for parameter direction display in labels. */
	public final static int DISP_PARAM_DIRECTION = 1 << 19;

	/** Style constant forcing multiplicity display in labels. */
	public final static int DISP_DEFAULT_MULTIPLICITY = 1 << 20;

	/** Style constant forcing type display in labels. */
	public final static int DISP_UNDEFINED_TYPE = 1 << 21;

	/** Style constant forcing name display in labels. */
	public final static int DISP_NON_NAVIGABLE_ROLE = 1 << 22;
}
