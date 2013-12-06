/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *      Lorenzo Vincent (CEA LIST) - Add Compartment Visibility
 *      Vincent Lorenzo (CEA-LIst) -  bug 335989: [Preferences] [Enhancement] Add a group for labels in each Connection Preference Page
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.utils;

import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;

/**
 * <p>
 * A class that defines the available preference type available through Papyrus.
 * </p>
 * <p>
 * It defines the following type:
 * </p>
 * <ul>
 * <li>COLOR_FILL</li>
 * <li>FONT</li>
 * <li>COLOR_FONT</li>
 * <li>COLOR_LINE</li>
 * <li>COLOR_GRADIENT</li>
 * <li>GRADIENT_POLICY</li>
 * <li>JUMPLINK_STATUS</li>
 * <li>JUMPLINK_REVERSE</li>
 * <li>JUMPLINK_TYPE</li>
 * <li>ROUTING_POLICY_DISTANCE</li>
 * <li>ROUTING_POLICY_OBSTRUCTION</li>
 * <li>ROUTING_STYLE</li>
 * <li>SMOOTHNESS</li>
 * </ul>
 * <p>
 * It also helps to retrieve the string used to store the preference type for a given element.
 * </p>
 * 
 * @deprecated use org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper
 */
@SuppressWarnings("restriction")
@Deprecated
public class PreferenceConstantHelper {

	/**
	 * Prefix for preference for Papyrus Level editor
	 */
	public static String PAPYRUS_EDITOR_PREFERENCE_PREFIX = PreferencesConstantsHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX;

	/**
	 * Prefix for preference for Diagram Level
	 */
	public static String DIAGRAM_PREFERENCE_PREFIX = PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX;

	/**
	 * Prefix for preference for element Level
	 */
	public static String DIAGRAM_ELEMENT = PreferencesConstantsHelper.DIAGRAM_ELEMENT;


	/**
	 * A preference of type COLOR FILL
	 */
	public final static int COLOR_FILL = PreferencesConstantsHelper.COLOR_FILL;

	/**
	 * A preference of type FONT
	 */
	public final static int FONT = PreferencesConstantsHelper.FONT;

	/**
	 * A preference of type COLOR FONT
	 */
	public final static int COLOR_FONT = PreferencesConstantsHelper.COLOR_FONT;

	/**
	 * A preference of type COLOR LINE
	 */
	public final static int COLOR_LINE = PreferencesConstantsHelper.COLOR_LINE;

	/**
	 * A preference of type COLOR GRADIENT
	 */
	public final static int COLOR_GRADIENT = PreferencesConstantsHelper.COLOR_GRADIENT;

	/**
	 * A preference of type GRADIENT POLICY
	 */
	public final static int GRADIENT_POLICY = PreferencesConstantsHelper.GRADIENT_POLICY;

	/**
	 * A preference of type JUMPLINK STATUS
	 */
	public final static int JUMPLINK_STATUS = PreferencesConstantsHelper.JUMPLINK_STATUS;

	/**
	 * A preference of type JUMPLINK REVERSE
	 */
	public final static int JUMPLINK_REVERSE = PreferencesConstantsHelper.JUMPLINK_REVERSE;

	/**
	 * A preference of type JUMPLINK TYPE
	 */
	public final static int JUMPLINK_TYPE = PreferencesConstantsHelper.JUMPLINK_TYPE;

	/**
	 * A preference of type ROUTING POLICY DISTANCE
	 */
	public final static int ROUTING_POLICY_DISTANCE = PreferencesConstantsHelper.ROUTING_POLICY_DISTANCE;

	/**
	 * A preference of type ROUTING POLICY OBSTRUCTION
	 */
	public final static int ROUTING_POLICY_OBSTRUCTION = PreferencesConstantsHelper.ROUTING_POLICY_OBSTRUCTION;

	/**
	 * A preference of type ROUTING STYLE
	 */
	public final static int ROUTING_STYLE = PreferencesConstantsHelper.ROUTING_STYLE;

	/**
	 * A preference of type SMOOTHNESS
	 */
	public final static int SMOOTHNESS = PreferencesConstantsHelper.SMOOTHNESS;

	/**
	 * A preference of type Shadow
	 */
	public final static int SHADOW = PreferencesConstantsHelper.SHADOW;

	/**
	 * A preference of type elementIcon
	 */
	public final static int ELEMENTICON = PreferencesConstantsHelper.ELEMENTICON;

	/**
	 * A preference of type QualifiedName
	 */
	public final static int QUALIFIEDNAME = PreferencesConstantsHelper.QUALIFIEDNAME;

	/**
	 * A preference of type height
	 */
	public static final int HEIGHT = PreferencesConstantsHelper.HEIGHT;

	/**
	 * A preference of type width
	 */
	public static final int WIDTH = PreferencesConstantsHelper.WIDTH;

	/**
	 * A preference of type compartment visibility
	 */
	public static final int COMPARTMENT_VISIBILITY = PreferencesConstantsHelper.COMPARTMENT_VISIBILITY;

	/**
	 * A preference of type compartment visibility
	 */
	public static final int COMPARTMENT_NAME_VISIBILITY = PreferencesConstantsHelper.COMPARTMENT_NAME_VISIBILITY;

	/**
	 * A preference of type label visibility
	 */
	public static final int LABEL_VISIBILITY = PreferencesConstantsHelper.LABEL_VISIBILITY;

	/**
	 * A preference for label default location
	 */
	public static final int LOCATION_X = PreferencesConstantsHelper.LOCATION_X;

	/**
	 * A preference for label default location
	 */
	public static final int LOCATION_Y = PreferencesConstantsHelper.LOCATION_Y;

	/**
	 * A preference to diplay or not the rulers
	 */
	public static final int SHOW_RULER = PreferencesConstantsHelper.SHOW_RULER;


	/**
	 * Get the preference constant used to store the preference of an element.
	 * 
	 * @param elementName
	 *        the name of the element
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the constant used.
	 */
	public static String getConstant(String elementName, int preferenceType) {
		return PreferencesConstantsHelper.getConstant(elementName, preferenceType);
	}

	/**
	 * 
	 * @param elementName
	 *        diagramKind+'_'+element
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the key for the element of a diagram
	 */
	public static String getElementConstant(String elementName, int preferenceType) {
		return PreferencesConstantsHelper.getElementConstant(elementName, preferenceType);
	}

	/**
	 * 
	 * @param elementName
	 *        diagramKind+'_'+element
	 * @param compartmentName
	 *        the compartment name
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the key for the element of a diagram
	 */
	public static String getCompartmentElementConstant(String elementName, String compartmentName, int preferenceType) {
		return PreferencesConstantsHelper.getCompartmentElementConstant(elementName, compartmentName, preferenceType);
	}

	/**
	 * 
	 * 
	 * @param elementName
	 *        diagramKind+'_'+element
	 * @param labelRole
	 *        he role of the label
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the key for the element of a diagram
	 */
	public static String getLabelElementConstant(String elementName, String labelRole, int preferenceType) {
		return PreferencesConstantsHelper.getLabelElementConstant(elementName, labelRole, preferenceType);
	}

	/**
	 * 
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return get the preference key at the papyrus editor level
	 */
	public static String getPapyrusEditorConstant(int preferenceType) {
		return PreferencesConstantsHelper.getPapyrusEditorConstant(preferenceType);
	}

	/**
	 * 
	 * @param diagramKind
	 *        the kind of diagram.
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the preference key at the diagram level
	 */
	public static String getDiagramConstant(String diagramKind, int preferenceType) {
		return PreferencesConstantsHelper.getDiagramConstant(diagramKind, preferenceType);
	}

}
