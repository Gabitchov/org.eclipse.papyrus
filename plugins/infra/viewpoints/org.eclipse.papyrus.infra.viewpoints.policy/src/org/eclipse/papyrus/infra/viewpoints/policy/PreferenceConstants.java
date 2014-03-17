/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

/**
 * Contains all the constants for the management of the viewpoints-related configuration preferences
 * 
 * @author Laurent Wouters
 */
public class PreferenceConstants {

	/**
	 * Preference for the type of configuration selection
	 */
	public static final String P_CONF_TYPE = "papyrusViewpointsConfigurationType";

	/**
	 * Preference for the scheme of the path to a custom configuration
	 */
	public static final String P_CONF_PATH_SCHEME = "papyrusViewpointsUserDefinedScheme";

	/**
	 * Preference for the path to a custom configuration
	 */
	public static final String P_CONF_PATH = "papyrusViewpointsUserDefinedConfiguration";

	/**
	 * Preference for the configuration's stakeholder
	 */
	public static final String P_STAKEHOLDER = "papyrusViewpointsSelectedStakeholder";

	/**
	 * Preference for the configuration's viewpoint
	 */
	public static final String P_VIEWPOINT = "papyrusViewpointsSelectedViewpoint";

	/**
	 * Preference for the forced multiplicity
	 */
	public static final String P_FORCE_MULTIPLICITY = "papyrusViewpointsForceMultiplicity";


	public static final String P_CONF_TYPE_DEFAULT_LABEL = "Default (Papyrus built-in configuration, allows all)";
	public static final String P_CONF_TYPE_DEFAULT_VALUE = "default";

	public static final String P_CONF_TYPE_EXTENSION_LABEL = "Deployed through the extension point";
	public static final String P_CONF_TYPE_EXTENSION_VALUE = "extension";

	public static final String P_CONF_TYPE_USER_DEFINED_LABEL = "Manual configuration selection";
	public static final String P_CONF_TYPE_USER_DEFINED_VALUE = "custom";

	public static final String P_CONF_PATH_SCHEME_FILE_LABEL = "Absolute path";
	public static final String P_CONF_PATH_SCHEME_FILE_VALUE = "file";

	public static final String P_CONF_PATH_SCHEME_WORKSPACE_LABEL = "Workspace file";
	public static final String P_CONF_PATH_SCHEME_WORKSPACE_VALUE = "platform:/resource/";

	public static final String P_CONF_PATH_SCHEME_PLUGIN_LABEL = "Embedded in a plugin";
	public static final String P_CONF_PATH_SCHEME_PLUGIN_VALUE = "platform:/plugin/";

	public static final String P_FORCE_MULTIPLICITY_LABEL = "Force at most one view of each type per model element";
}
