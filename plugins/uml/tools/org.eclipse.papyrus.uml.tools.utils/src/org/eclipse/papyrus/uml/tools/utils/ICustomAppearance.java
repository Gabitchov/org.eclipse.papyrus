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

import java.util.Arrays;
import java.util.Collection;

/**
 * Interface that manages display constants for custom labels (ex: operations label in a class
 * diagram).
 */
public interface ICustomAppearance {

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
	public final static String DISP_VISIBILITY = "visibility";

	/**
	 * Style constant for isDerive display in labels.
	 */
	public final static String DISP_DERIVE = "derived";

	/**
	 * Style constant for name display in labels.
	 */
	public final static String DISP_NAME = "name";

	/**
	 * Style constant for type display in labels.
	 */
	public final static String DISP_TYPE = "type";

	/**
	 * Style constant for multiplicity display in labels.
	 */
	public final static String DISP_MULTIPLICITY = "multiplicity";

	/**
	 * Style constant for default value display in labels.
	 */
	public final static String DISP_DEFAULT_VALUE = "defaultValue";

	/**
	 * Style constant for modifiers display in labels.
	 */
	public final static String DISP_MODIFIERS = "modifiers";

	/** Style constant for carriage return in labels */
	public final static String DISP_MULTI_LINE = "multiline";

	/** Prefix used to distinguish parameter-specific values (e.g. name vs parametersName, for an Operation) */
	public final static String PARAMETERS_PREFIX = "parameters";

	/** Style constant for operation#parameter direction display in labels */
	public final String DISP_PARAMETER_DIRECTION = PARAMETERS_PREFIX + "Direction";

	/** Style constant for direction display in labels */
	public final String DISP_DIRECTION = "direction";

	/** Style constant for operation#parameter name display in labels */
	public final String DISP_PARAMETER_NAME = PARAMETERS_PREFIX + "Name";

	/** Style constant for operation#parameter type display in labels */
	public final String DISP_PARAMETER_TYPE = PARAMETERS_PREFIX + "Type";

	/** Style constant for operation#parameter multiplicity display in labels */
	public final String DISP_PARAMETER_MULTIPLICITY = PARAMETERS_PREFIX + "Multiplicity";

	/** Style constant for operation#parameter default value display in labels */
	public final String DISP_PARAMETER_DEFAULT = PARAMETERS_PREFIX + "Default";

	/** Style constant for operation#parameter modifiers display in labels */
	public final String DISP_PARAMETER_MODIFIERS = PARAMETERS_PREFIX + "Modifiers";

	/** Style constant for return type display in labels */
	public final String DISP_RT_TYPE = "returnType";

	/** Style constant for return multiplicity display in labels */
	public final String DISP_RT_MULTIPLICITY = "returnMultiplicity";

	/** Style constant for conjugated labels */
	public final String DISP_CONJUGATED = "conjugated";

	// /////////////////////////////////////////////////////////////////////////
	// UML DEFAULT DISPLAY
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * default uml property display in classes edit part.
	 */
	public final static Collection<String> DEFAULT_UML_PROPERTY = Arrays.asList(DISP_VISIBILITY, DISP_DERIVE, DISP_NAME, DISP_TYPE, DISP_MULTIPLICITY);

	/**
	 * default uml property display in classes edit part.
	 */
	public final static Collection<String> DEFAULT_UML_ROLE = Arrays.asList(DISP_VISIBILITY, DISP_DERIVE, DISP_NAME, DISP_TYPE);

	/**
	 * default uml operation display.
	 */
	public final static Collection<String> DEFAULT_UML_OPERATION = Arrays.asList(DISP_VISIBILITY, DISP_NAME, DISP_PARAMETER_DIRECTION, DISP_PARAMETER_TYPE, DISP_RT_TYPE, DISP_PARAMETER_NAME);

	/**
	 * default uml Property in composite diagrams.
	 */
	// @unused
	public final static Collection<String> DEFAULT_UML_COMPO_PROPERTY = Arrays.asList(DISP_NAME, DISP_TYPE);

	/**
	 * default uml Property in class diagrams as association ends.
	 */
	// @unused
	public final static Collection<String> DEFAULT_UML_RELATIONEND_PROPERTY = Arrays.asList(DISP_VISIBILITY, DISP_DERIVE, DISP_NAME, DISP_MODIFIERS, DISP_MULTI_LINE);

	/**
	 * default uml Port ins composite diagrams.
	 */
	public final static Collection<String> DEFAULT_UML_PORT = Arrays.asList(DISP_VISIBILITY, DISP_DERIVE, DISP_NAME, DISP_TYPE, DISP_MULTIPLICITY, DISP_CONJUGATED);

	/**
	 * default uml OpaqueAction in activity diagrams.
	 */
	// @unused
	public final static Collection<String> DEFAULT_UML_OPAQUE_ACTION = Arrays.asList(DISP_NAME);

	/**
	 * default uml Parameter in composite diagrams.
	 */
	public final static Collection<String> DEFAULT_UML_PARAMETER = Arrays.asList(DISP_DIRECTION, DISP_NAME, DISP_TYPE);

	/**
	 * default uml instancespecification .
	 */
	public final static Collection<String> DEFAULT_UML_INSTANCESPECIFICATION = Arrays.asList(DISP_NAME, DISP_TYPE);

}
