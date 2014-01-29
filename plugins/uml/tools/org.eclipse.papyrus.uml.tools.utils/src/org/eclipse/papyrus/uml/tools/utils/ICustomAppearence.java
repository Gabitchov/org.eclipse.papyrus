/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

/**
 * Interface that manages display constants for custom labels (ex: operations label in a class
 * diagram).
 */
public interface ICustomAppearence {

	/**
	 * key for the appearance property of graph nodes.
	 */
	// @unused
	public final static String CUSTOM_APPEARENCE_KEY = "custom_disp";

	// /////////////////////////////////////////////////////////////////////////
	// Style constants
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * Style constant for visibility display in labels.
	 */
	public final static int DISP_VISIBILITY = 1 << 1;

	/**
	 * Style constant for isDerive display in labels.
	 */
	public final static int DISP_DERIVE = 1 << 2;

	/**
	 * Style constant for name display in labels.
	 */
	public final static int DISP_NAME = 1 << 3;

	/**
	 * Style constant for type display in labels.
	 */
	public final static int DISP_TYPE = 1 << 4;

	/**
	 * Style constant for multiplicity display in labels.
	 */
	public final static int DISP_MULTIPLICITY = 1 << 5;

	/**
	 * Style constant for default value display in labels.
	 */
	public final static int DISP_DFLT_VALUE = 1 << 6;

	/**
	 * Style constant for modifiers display in labels.
	 */
	public final static int DISP_MOFIFIERS = 1 << 7;

	/**
	 * Style constant for parameters display in labels.
	 *
	 * @deprecated
	 * @see #DISP_PARAMETER_TYPE
	 */
	@Deprecated
	// @unused
	public final static int DISP_PARAMETERS = 1 << 8;

	/**
	 * Style constant for return parameters display in labels.
	 *
	 * @deprecated
	 * @see #DISP_RT_TYPE
	 */
	@Deprecated
	// @unused
	public final static int DISP_RETURN_PARAMETERS = 1 << 9;

	/** Style constant for carriage return in labels */
	public final static int DISP_MULTI_LINE = 1 << 10;

	/**
	 * Style constant for opaque action body display in labels.
	 */
	// @unused
	public final static int DISP_BODY = 1 << 11;

	/** Style constant for parameter direction display in labels */
	public final int DISP_PARAMETER_DIRECTION = 1 << 11;

	/** Style constant for parameter name display in labels */
	public final int DISP_PARAMETER_NAME = 1 << 12;

	/** Style constant for parameter type display in labels */
	public final int DISP_PARAMETER_TYPE = 1 << 8;

	/** Style constant for parameter multiplicity display in labels */
	public final int DISP_PARAMETER_MULTIPLICITY = 1 << 14;

	/** Style constant for parameter default value display in labels */
	public final int DISP_PARAMETER_DEFAULT = 1 << 15;

	/** Style constant for parameter modifiers display in labels */
	public final int DISP_PARAMETER_MODIFIERS = 1 << 16;

	/** Style constant for return parameter type display in labels */
	public final int DISP_RT_TYPE = 1 << 9;

	/** Style constant for return parameter multiplicity display in labels */
	public final int DISP_RT_MULTIPLICITY = 1 << 18;

	/** Style constant for conjugated labels */
	public final int DISP_CONJUGATED = 1 << 19;

	// /////////////////////////////////////////////////////////////////////////
	// UML DEFAULT DISPLAY
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * default uml property display in classes edit part.
	 */
	public final static int DEFAULT_UML_PROPERTY = DISP_VISIBILITY | DISP_DERIVE | DISP_NAME | DISP_TYPE | DISP_MULTIPLICITY;

	/**
	 * default uml property display in classes edit part.
	 */
	public final static int DEFAULT_UML_ROLE = DISP_VISIBILITY | DISP_DERIVE | DISP_NAME | DISP_TYPE;

	/**
	 * default uml operation display.
	 */
	public final static int DEFAULT_UML_OPERATION = DISP_VISIBILITY | DISP_NAME | DISP_PARAMETER_DIRECTION | DISP_PARAMETER_TYPE | DISP_RT_TYPE | DISP_PARAMETER_NAME;

	/**
	 * default uml Property in composite diagrams.
	 */
	// @unused
	public final static int DEFAULT_UML_COMPO_PROPERTY = DISP_NAME | DISP_TYPE;

	/**
	 * default uml Property in class diagrams as association ends.
	 */
	// @unused
	public final static int DEFAULT_UML_RELATIONEND_PROPERTY = DISP_VISIBILITY | DISP_DERIVE | DISP_NAME | DISP_MOFIFIERS | DISP_MULTI_LINE;

	/**
	 * default uml Port ins composite diagrams.
	 */
	public final static int DEFAULT_UML_PORT = DISP_VISIBILITY | DISP_DERIVE | DISP_NAME | DISP_TYPE | DISP_MULTIPLICITY | DISP_CONJUGATED;

	/**
	 * default uml OpaqueAction in activity diagrams.
	 */
	// @unused
	public final static int DEFAULT_UML_OPAQUE_ACTION = DISP_NAME;

	/**
	 * default uml Parameter in composite diagrams.
	 */
	public final static int DEFAULT_UML_PARAMETER = DISP_PARAMETER_DIRECTION | DISP_PARAMETER_NAME | DISP_PARAMETER_TYPE;

	/**
	 * default uml instancespecification .
	 */
	public final static int DEFAULT_UML_INSTANCESPECIFICATION = DISP_NAME | DISP_TYPE;
}
