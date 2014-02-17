/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.appearance.helper;

//Refactoring 0.9: Some constants have been moved to UMLVisualInformationPapyrusConstant
public interface VisualInformationPapyrusConstants {

	/** The qualified name. */
	public static String QUALIFIED_NAME = "QualifiedName";

	/** The qualified name depth. */
	public static String QUALIFIED_NAME_DEPTH = "QualifiedNameDepth";

	public static String SHADOWFIGURE = "ShadowFigure";

	public static String SHADOWFIGURE_VALUE = "ShadowFigure_Value";

	public static String DISPLAY_NAMELABELICON = "displayNameLabelIcon";

	public static String DISPLAY_NAMELABELICON_VALUE = "displayNameLabelIcon_value";

	public static String LAYOUTFIGURE = "layoutFigure";

	public static String LAYOUTFIGURE_VALUE = "layoutFigure_value";

	/**
	 * key for the appearance of properties or other specific display
	 * 
	 * @deprecated Use a StringListValueStyle instead. See {{@link #CUSTOM_MASK_LABEL}
	 */
	@Deprecated
	public static final String CUSTOM_APPEARENCE_ANNOTATION = "CustomAppearance_Annotation";

	/**
	 * The name of the StringListValueStyle used for storing MaskLabels
	 *
	 * Replaces the former int-based EAnnotation ({@link #CUSTOM_APPEARENCE_ANNOTATION}, {@link #CUSTOM_APPEARANCE_MASK_VALUE})
	 */
	public static final String CUSTOM_MASK_LABEL = "maskLabel";

	/**
	 * this is a key of eAnnnotation that contains hypertext link or referenced document
	 **/
	public static final String HYPERLINK_DIAGRAM = "PapyrusHyperLink_Diagram";

	public static final String HYPERLINK_DIAGRAM_NAME = "diagram_name";

	/**
	 * key for the appearance of properties or other specific display
	 * 
	 * @deprecated Use a StringListValueStyle instead. See {{@link #CUSTOM_MASK_LABEL}
	 */
	@Deprecated
	public static final String CUSTOM_APPEARANCE_MASK_VALUE = "CustomAppearance_MaskValue";
}
