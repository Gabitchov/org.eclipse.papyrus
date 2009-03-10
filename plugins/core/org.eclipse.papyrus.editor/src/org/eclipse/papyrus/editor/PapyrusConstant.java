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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.editor;

public interface PapyrusConstant {

	public static String STEREOTYPE_ANNOTATION = "Stereotype_Annotation";

	/**
	 * the kind of presentation for stereotype
	 */
	public static String STEREOTYPE_PRESENTATION_KIND = "Stereotype_Presentation_Kind";

	/**
	 * the list of steretype to display
	 */
	public static String STEREOTYPE_LIST = "StereotypeList";

	/**
	 * 
	 */
	public static String TEXT_ICON_STEREOTYPE_PRESENTATION = "TextIconStereotype";

	/**
	 * 
	 */
	public static String ICON_STEREOTYPE_PRESENTATION = "IconStereotype";

	/**
	 * 
	 */
	public static String IMAGE_STEREOTYPE_PRESENTATION = "ImageStereotype";

	/**
	 * 
	 */
	public static String STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION = "HorizontalStereo";

	/**
	 * 
	 */
	public static String STEREOTYPE_TEXT_VERTICAL_PRESENTATION = "VerticalStereo";

	/**
	 * 
	 */
	public static String PROPERTY_STEREOTYPE_DISPLAY = "PropStereoDisplay";

	/**
	 * 
	 */
	public static String PROPERTY_STEREOTYPE_PROPERTY_VALUES_DISPLAY = "PropStereoPropValuesDisplay";

	/**
	 * 
	 */
	public static String OPAQUE_EXPRESSION_BODY_DISPLAY = "OpaqueExpressionBodyDisplay";

	/**
	 * String represent the location of stereotype properties within a comment
	 */
	public static String STEREOTYPE_COMMENT_LOCATION = "Comment";

	/**
	 * String represent the location of stereotype properties within a compartment of a graph node
	 */
	public static String STEREOTYPE_COMPARTMENT_LOCATION = "Compartment";

	public static String QUALIFIED_NAME = "QualifiedName";

	public static Object QUALIFIED_NAME_DEPTH = "QualifiedNameDepth";

	/**
	 * The Constant P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED.
	 */
	public final static String P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED = "User Controlled";

	/**
	 * The Constant P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM.
	 */
	public final static String P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM = "UML Compatibility (lower case first letter - default)";

	/**
	 * The Constant P_STEREOTYPE_NAME_APPEARANCE.
	 */
	public static final String P_STEREOTYPE_NAME_APPEARANCE = "ProfileApplicationPreferenceConstants.stereotype.name.appearance";

}
