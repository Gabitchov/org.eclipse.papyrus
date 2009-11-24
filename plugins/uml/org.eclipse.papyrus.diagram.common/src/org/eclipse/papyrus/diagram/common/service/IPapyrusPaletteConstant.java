/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

/**
 * Constant for the papyrus palette extension point
 */
public interface IPapyrusPaletteConstant {

	/** Papyrus palette definition extension point name */
	public final String PALETTE_DEFINITION = "paletteDefinition"; //$NON-NLS-1$

	/** name for the field giving the path to the XML file */
	public final String CONTENT = "content"; //$NON-NLS-1$

	/** name for the field giving the path to the XML file */
	public final String PATH = "path"; //$NON-NLS-1$

	/** name of the properties node */
	public final String PALETTE_DESCRIPTION_PROPERTIES = "properties";

	/** name of the drawer node */
	public final String DRAWER = "drawer";

	/** name of the stack node */
	public final String STACK = "stack";

	/** name of the tool node */
	public final String TOOL = "tool";

	/** name of the tool node */
	public final String ASPECT_TOOL = "aspectTool";

	/** name of the separator node */
	public final String SEPARATOR = "separator";

	/** name of the ID attribute */
	public final String ID = "id";

	/** name of the preAction attribute */
	public final String PRE_ACTION = "preAction";

	/** name of the editor attribute */
	public final String EDITOR = "editor";

	/** name of the name attribute */
	public final String NAME = "name";

	/** name of the editor id attribute */
	public final String EDITOR_ID = "editorID";

	/** name of the priority attribute */
	public final String PRIORITY = "priority";

	/** name of the description attribute */
	public final String DESCRIPTION = "description";

	/** id for the preference store for palette customizations */
	public final String PALETTE_CUSTOMIZATIONS_ID = "paletteCustomization";

	/** id for the preference store for local palette definitions */
	public final String PALETTE_LOCAL_DEFINITIONS = "localPaletteDefinition";

	/** id for the preference definitions */
	public final String HIDDEN_PALETTES = "hiddenPalettes";

	/** id for the palette attribute */
	public final String PALETTE = "palette";

	/** id for the class attribute */
	public final String CLASS = "class";

	/** id for the icon path attribute */
	public final String ICON_PATH = "iconpath";

	/** id for the referenced tool in aspect tools */
	public final String REF_TOOL_ID = "refToolId";

	/** id for the post action node in aspect tool definition */
	public final String POST_ACTION = "postAction";

	/** id for the attribute stereotypes to apply qualified name */
	public final String STEREOTYPES_TO_APPLY = "stereotypesToApply";

	/** key for the properties tool */
	public final String STEREOTYPES_TO_APPLY_KEY = "StereotypesToApply";

	/** key for the profile list attribute */
	public final String PROFILE_LIST = "requiredProfiles";

}
