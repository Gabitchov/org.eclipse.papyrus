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
 */
public class PreferenceConstantHelper {

	/**
	 * Prefix for preference for Papyrus Level editor
	 */
	public static String PAPYRUS_EDITOR_PREFERENCE_PREFIX = "PAPYRUS_EDITOR"; //$NON-NLS-1$

	/**
	 * Prefix for preference for Diagram Level
	 */
	public static String DIAGRAM_PREFERENCE_PREFIX = "DIAGRAM_"; //$NON-NLS-1$

	/**
	 * Prefix for preference for element Level
	 */
	public static String DIAGRAM_ELEMENT = "ELEMENT_"; //$NON-NLS-1$

	private final static String COLOR = "color."; //$NON-NLS-1$

	private final static String GRADIENT = "gradient"; //$NON-NLS-1$

	private final static String POLICY = ".policy"; //$NON-NLS-1$

	private final static String JUMPLINK = "jumplink."; //$NON-NLS-1$

	private final static String ROUTING = "routing"; //$NON-NLS-1$

	private final static String ROUTING_POLICY = ROUTING + POLICY;

	private final static String COLOR_FILL_CONSTANT = COLOR + "fill"; //$NON-NLS-1$

	private final static String FONT_CONSTANT = "font"; //$NON-NLS-1$

	private final static String COLOR_FONT_CONSTANT = COLOR + FONT_CONSTANT;

	private final static String COLOR_LINE_CONSTANT = COLOR + "line"; //$NON-NLS-1$

	private final static String COLOR_GRADIENT_CONSTANT = COLOR + GRADIENT;

	private final static String GRADIENT_POLICY_CONSTANT = GRADIENT + POLICY;

	private final static String JUMPLINK_STATUS_CONSTANT = JUMPLINK + "status"; //$NON-NLS-1$

	private final static String JUMPLINK_REVERSE_CONSTANT = JUMPLINK + "reverse"; //$NON-NLS-1$

	private final static String JUMPLINK_TYPE_CONSTANT = JUMPLINK + "type"; //$NON-NLS-1$

	private final static String ROUTING_POLICY_DISTANCE_CONSTANT = ROUTING_POLICY + ".distance"; //$NON-NLS-1$

	private final static String ROUTING_POLICY_OBSTRUCTION_CONSTANT = ROUTING_POLICY + ".obstruction"; //$NON-NLS-1$

	private final static String ROUTING_STYLE_CONSTANT = ROUTING + ".style"; //$NON-NLS-1$

	private final static String SMOOTHNESS_CONSTANT = "smoothness"; //$NON-NLS-1$

	private final static String SHADOW_CONSTANT = "shadow"; //$NON-NLS-1$

	private final static String ELEMENTICON_CONSTANT = "elementicon"; //$NON-NLS-1$

	private final static String QUALIFIEDNAME_CONSTANT = "qualifiedname"; //$NON-NLS-1$

	private final static String HEIGHT_CONSTANT = "height";//$NON-NLS-1$

	private final static String WIDTH_CONSTANT = "width"; //$NON-NLS-1$

	private final static String COMPARTMENT_VISIBILITY_CONSTANT = "compartment.visibility"; //$NON-NLS-1$

	private final static String COMPARTMENT_NAME_VISIBILITY_CONSTANT = "compartment_name.visibility"; //$NON-NLS-1$

	private final static String LABEL_VISIBILITY_CONSTANT = "label.visibility"; //$NON-NLS-1$

	private final static String LOCATION_X_CONSTANT = "location_x";//$NON-NLS-1$

	private final static String LOCATION_Y_CONSTANT = "location_y"; //$NON-NLS-1$

	/**
	 * A preference of type COLOR FILL
	 */
	public final static int COLOR_FILL = 0;

	/**
	 * A preference of type FONT
	 */
	public final static int FONT = COLOR_FILL + 1;

	/**
	 * A preference of type COLOR FONT
	 */
	public final static int COLOR_FONT = FONT + 1;

	/**
	 * A preference of type COLOR LINE
	 */
	public final static int COLOR_LINE = COLOR_FONT + 1;

	/**
	 * A preference of type COLOR GRADIENT
	 */
	public final static int COLOR_GRADIENT = COLOR_LINE + 1;

	/**
	 * A preference of type GRADIENT POLICY
	 */
	public final static int GRADIENT_POLICY = COLOR_GRADIENT + 1;

	/**
	 * A preference of type JUMPLINK STATUS
	 */
	public final static int JUMPLINK_STATUS = GRADIENT_POLICY + 1;

	/**
	 * A preference of type JUMPLINK REVERSE
	 */
	public final static int JUMPLINK_REVERSE = JUMPLINK_STATUS + 1;

	/**
	 * A preference of type JUMPLINK TYPE
	 */
	public final static int JUMPLINK_TYPE = JUMPLINK_REVERSE + 1;

	/**
	 * A preference of type ROUTING POLICY DISTANCE
	 */
	public final static int ROUTING_POLICY_DISTANCE = JUMPLINK_TYPE + 1;

	/**
	 * A preference of type ROUTING POLICY OBSTRUCTION
	 */
	public final static int ROUTING_POLICY_OBSTRUCTION = ROUTING_POLICY_DISTANCE + 1;

	/**
	 * A preference of type ROUTING STYLE
	 */
	public final static int ROUTING_STYLE = ROUTING_POLICY_OBSTRUCTION + 1;

	/**
	 * A preference of type SMOOTHNESS
	 */
	public final static int SMOOTHNESS = ROUTING_STYLE + 1;

	/**
	 * A preference of type Shadow
	 */
	public final static int SHADOW = SMOOTHNESS + 1;

	/**
	 * A preference of type elementIcon
	 */
	public final static int ELEMENTICON = SHADOW + 1;

	/**
	 * A preference of type QualifiedName
	 */
	public final static int QUALIFIEDNAME = ELEMENTICON + 1;

	/**
	 * A preference of type height
	 */
	public static final int HEIGHT = QUALIFIEDNAME + 1;

	/**
	 * A preference of type width
	 */
	public static final int WIDTH = HEIGHT + 1;

	/**
	 * A preference of type compartment visibility
	 */
	public static final int COMPARTMENT_VISIBILITY = WIDTH + 1;

	/**
	 * A preference of type compartment visibility
	 */
	public static final int COMPARTMENT_NAME_VISIBILITY = COMPARTMENT_VISIBILITY + 1;

	/**
	 * A preference of type label visibility
	 */
	public static final int LABEL_VISIBILITY = COMPARTMENT_NAME_VISIBILITY + 1;

	/**
	 * A preference for label default location
	 */
	public static final int LOCATION_X = LABEL_VISIBILITY + 1;

	/**
	 * A preference for label default location
	 */
	public static final int LOCATION_Y = LOCATION_X + 1;


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
		StringBuffer sb = new StringBuffer();
		sb.append(elementName);
		sb.append("."); //$NON-NLS-1$

		switch(preferenceType) {
		case COLOR_FILL:
			sb.append(COLOR_FILL_CONSTANT);
			break;
		case FONT:
			sb.append(FONT_CONSTANT);
			break;
		case COLOR_FONT:
			sb.append(COLOR_FONT_CONSTANT);
			break;
		case COLOR_LINE:
			sb.append(COLOR_LINE_CONSTANT);
			break;
		case COLOR_GRADIENT:
			sb.append(COLOR_GRADIENT_CONSTANT);
			break;
		case GRADIENT_POLICY:
			sb.append(GRADIENT_POLICY_CONSTANT);
			break;
		case JUMPLINK_STATUS:
			sb.append(JUMPLINK_STATUS_CONSTANT);
			break;
		case JUMPLINK_REVERSE:
			sb.append(JUMPLINK_REVERSE_CONSTANT);
			break;
		case JUMPLINK_TYPE:
			sb.append(JUMPLINK_TYPE_CONSTANT);
			break;
		case ROUTING_POLICY_DISTANCE:
			sb.append(ROUTING_POLICY_DISTANCE_CONSTANT);
			break;
		case ROUTING_POLICY_OBSTRUCTION:
			sb.append(ROUTING_POLICY_OBSTRUCTION_CONSTANT);
			break;
		case ROUTING_STYLE:
			sb.append(ROUTING_STYLE_CONSTANT);
			break;
		case SMOOTHNESS:
			sb.append(SMOOTHNESS_CONSTANT);
			break;
		case SHADOW:
			sb.append(SHADOW_CONSTANT);
			break;
		case ELEMENTICON:
			sb.append(ELEMENTICON_CONSTANT);
			break;
		case QUALIFIEDNAME:
			sb.append(QUALIFIEDNAME_CONSTANT);
			break;
		case HEIGHT:
			sb.append(HEIGHT_CONSTANT);
			break;
		case WIDTH:
			sb.append(WIDTH_CONSTANT);
			break;
		case COMPARTMENT_VISIBILITY:
			sb.append(COMPARTMENT_VISIBILITY_CONSTANT);
			break;
		case COMPARTMENT_NAME_VISIBILITY:
			sb.append(COMPARTMENT_NAME_VISIBILITY_CONSTANT);
			break;
		case LABEL_VISIBILITY:
			sb.append(LABEL_VISIBILITY_CONSTANT);
			break;
		case LOCATION_X:
			sb.append(LOCATION_X_CONSTANT);
			break;
		case LOCATION_Y:
			sb.append(LOCATION_Y_CONSTANT);
			break;
		default:
			break;
		}

		return sb.toString();
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
		return DIAGRAM_ELEMENT + getConstant(elementName, preferenceType);
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
		String tmp = getElementConstant(elementName, preferenceType);
		return tmp.replaceFirst("\\.", "_" + compartmentName + "."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
		String tmp = getElementConstant(elementName, preferenceType);
		return tmp.replaceFirst("\\.", "_" + labelRole + "."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * 
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return get the preference key at the papyrus editor level
	 */
	public static String getPapyrusEditorConstant(int preferenceType) {
		return getConstant(PAPYRUS_EDITOR_PREFERENCE_PREFIX, preferenceType);
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
		return DIAGRAM_PREFERENCE_PREFIX + getConstant(diagramKind, preferenceType);
	}

}
