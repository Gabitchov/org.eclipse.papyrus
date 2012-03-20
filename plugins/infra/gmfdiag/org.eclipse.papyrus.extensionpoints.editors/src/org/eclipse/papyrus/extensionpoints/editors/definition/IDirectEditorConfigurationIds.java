/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.extensionpoints.editors.definition;

/**
 * Constant for the direct editor extension point
 */
public interface IDirectEditorConfigurationIds {

	/** id of the direct editor configuration extension point */
	public final static String DIRECT_EDITOR_CONFIGURATION_EXTENSION_ID = org.eclipse.papyrus.extensionpoints.editors.Activator.PLUGIN_ID + ".DirectEditor";

	/** id of the direct editor configuration element */
	public static final String TAG_DIRECT_EDITOR_CONFIGURATION = "DirectEditor";

	/** id of the language attribute */
	public static final String ATT_LANGUAGE = "language";

	/** id of the object to edit attribute */
	public static final String ATT_OBJECT_TO_EDIT = "objectToEdit";

	/** id of the direct editor configuration attribute */
	public static final String ATT_EDITOR_CONFIGURATION = "editorConfiguration";

	/** id of the direct editor simple configuration tag */
	public static final String TAG_SIMPLE_EDITOR = "simpleeditor";

	/** id of the direct editor advanced configuration tag */
	public static final String TAG_ADVANCED_EDITOR = "advancededitor";
	
	/** id of the direct editor popup configuration tag */
	public static final String TAG_POPUP_EDITOR = "popupeditor";
	
	/** id of the constraint associated to a directEditor */
	public static final String ATT_CONSTRAINT= "constraint";
	
	/** id of the priority associated to a directEditor */
	public static final String ATT_PRIORITY="Priority";
	
	/** id of the priority name associated to a directEditor */
	public static final String ATT_PRIORITY_NAME="name";

	/** string that represents the lowest priority**/
	public static final String PRIORITY_LOWEST = "Lowest";
	
	/** string that represents a Low priority**/
	public static final String PRIORITY_LOW = "Low";
	
	/** string that represents a Medium priority**/
	public static final String PRIORITY_MEDIUM = "Medium";
	
	/** string that represents a High priority**/
	public static final String PRIORITY_HIGH = "High";

	/** string that represents the Highest priority**/
	public static final String PRIORITY_HIGHEST = "Highest";
}
