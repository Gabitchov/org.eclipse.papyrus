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

package org.eclipse.papyrus.uml.diagram.common.part;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.palette.PaletteContextMenuProvider;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.action.IMenuManager;

/**
 * Specific context menu provider for Papyrus diagrams
 */
public class PapyrusPaletteContextMenuProvider extends PaletteContextMenuProvider {

	/**
	 * Creates a new PaletteContextMenuProvider
	 * 
	 * @param palette
	 *        the palette for which the context menu has to be buuild
	 */
	public PapyrusPaletteContextMenuProvider(PaletteViewer palette) {
		super(palette);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buildContextMenu(IMenuManager menu) {
		super.buildContextMenu(menu);

		// adds a new action with sub-menu to display which providers must be
		// displayed and which
		// ones should be hidden
		menu.appendToGroup(GEFActionConstants.GROUP_REST, new PaletteMenuAction(getPaletteViewer()));
	}

}
