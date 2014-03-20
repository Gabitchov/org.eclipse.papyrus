/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.preferences;

import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;



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
@SuppressWarnings("restriction")
public class PreferencesConstantsHelper {

	/**
	 * Prefix for preference for Papyrus Level editor
	 */
	public final static String PAPYRUS_EDITOR_PREFERENCE_PREFIX = "PAPYRUS_EDITOR"; //$NON-NLS-1$

	/**
	 * Prefix for preference for Diagram Level
	 */
	public final static String DIAGRAM_PREFERENCE_PREFIX = "DIAGRAM_"; //$NON-NLS-1$

	/**
	 * Prefix for preference for element Level
	 */
	public final static String DIAGRAM_ELEMENT = "ELEMENT_"; //$NON-NLS-1$

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

	public final static String VIEW_RULERS_CONSTANT = WorkspaceViewerProperties.VIEWRULERS;

	public final static String VIEW_GRID_CONSTANT = WorkspaceViewerProperties.VIEWGRID;

	public final static String RULER_UNITS_CONSTANT = WorkspaceViewerProperties.RULERUNIT;

	public final static String SNAP_TO_GRID_CONSTANT = WorkspaceViewerProperties.SNAPTOGRID;

	public final static String SNAP_TO_GEOMETRY_CONSTANT = WorkspaceViewerProperties.SNAPTOGEOMETRY;

	public final static String GRID_LINE_COLOR_CONSTANT = WorkspaceViewerProperties.GRIDLINECOLOR;

	public final static String GRID_SPACING_CONSTANT = WorkspaceViewerProperties.GRIDSPACING;

	public final static String GRID_ORDER_CONSTANT = WorkspaceViewerProperties.GRIDORDER;

	public final static String GRID_LINE_STYLE_CONSTANT = WorkspaceViewerProperties.GRIDLINESTYLE;

	public final static String VIEW_PAGE_BREAK_CONSTANT = WorkspaceViewerProperties.VIEWPAGEBREAKS;

	public final static String DRAW_CONNECTION_POINT_CONSTANT = "drawConnectionPoint"; //$NON-NLS-1$

	public final static String INVERT_BINDING_FOR_DEFAULT_RESIZE_AND_CONSTRAINED_RESIZE_CONSTANT = "invertBindingForDefaultResizeAndConstrainedResize"; //$NON-NLS-1$

	
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
	 * A preference to diplay or not the rulers
	 */
	public static final int VIEW_RULER = LOCATION_Y + 1;

	/**
	 * A preference to diplay or not the grid
	 */

	public static final int VIEW_GRID = VIEW_RULER + 1;

	/**
	 * A preference to change the ruler unit
	 */

	public static final int RULER_UNITS = VIEW_GRID + 1;

	/**
	 * A preference to snap the created element to the grid
	 */
	public static final int SNAP_TO_GRID = RULER_UNITS + 1;

	/**
	 * A preference to snap the created element to the shape
	 */
	public static final int SNAP_TO_GEOMETRY = SNAP_TO_GRID + 1;

	/**
	 * A preference to change the grid color
	 */
	public static final int GRID_LINE_COLOR = SNAP_TO_GEOMETRY + 1;

	/**
	 * A preference to change the grid spacing
	 */
	public static final int GRID_SPACING = GRID_LINE_COLOR + 1;

	/**
	 * A preference to change the Z order of the Grid
	 */
	public static final int GRID_ORDER = GRID_SPACING + 1;

	/**
	 * A preference to change the style of the grid
	 */
	public static final int GRID_LINE_STYLE = GRID_ORDER + 1;

	/**
	 * A preference to view the page break on the diagram
	 */
	public static final int VIEW_PAGE_BREAK = GRID_LINE_STYLE + 1;

	/**
	 * A preference to draw big point when 2 links have a common part
	 */
	public static final int DRAW_CONNECTION_POINT = VIEW_PAGE_BREAK + 1;

	/**
	 * A Papyrus preference to define the if the default resize action is constrained or not.
	 * if the preference is <code>false</code>
	 * <ul>
	 * <li>default resize is not constraint</li>
	 * <li>resize + SHIFT is constrained</li>
	 * </ul>
	 */
	public static final int INVERT_BINDING_FOR_DEFAULT_RESIZE_AND_CONSTRAINED_RESIZE = DRAW_CONNECTION_POINT + 1;

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
		case VIEW_RULER:
			sb.append(VIEW_RULERS_CONSTANT);
			break;
		case VIEW_GRID:
			sb.append(VIEW_GRID_CONSTANT);
			break;
		case RULER_UNITS:
			sb.append(RULER_UNITS_CONSTANT);
			break;
		case SNAP_TO_GRID:
			sb.append(SNAP_TO_GRID_CONSTANT);
			break;
		case SNAP_TO_GEOMETRY:
			sb.append(SNAP_TO_GEOMETRY_CONSTANT);
			break;
		case GRID_LINE_COLOR:
			sb.append(GRID_LINE_COLOR_CONSTANT);
			break;
		case GRID_SPACING:
			sb.append(GRID_SPACING_CONSTANT);
			break;
		case GRID_ORDER:
			sb.append(GRID_ORDER_CONSTANT);
			break;
		case GRID_LINE_STYLE:
			sb.append(GRID_LINE_STYLE_CONSTANT);
			break;
		case VIEW_PAGE_BREAK:
			sb.append(VIEW_PAGE_BREAK_CONSTANT);
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
