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

	/** name of the drawer node */
	public final String DRAWER = "drawer";

	/** name of the stack node */
	public final String STACK = "stack";

	/** name of the tool node */
	public final String TOOL = "tool";

	/** name of the separator node */
	public final String SEPARATOR = "separator";

	/** name of the ID attribute */
	public final String ID = "id";

	/** name of the editor attribute */
	public final String EDITOR = "editor";

}
