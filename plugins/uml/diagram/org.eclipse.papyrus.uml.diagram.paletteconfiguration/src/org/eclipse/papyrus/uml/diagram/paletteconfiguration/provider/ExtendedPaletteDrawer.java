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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Activator;


/**
 * Specific implementation of the Palette Drawer for Papyrus. The one from GMF is not used, as it is internal.
 */
public class ExtendedPaletteDrawer extends org.eclipse.gef.palette.PaletteDrawer {

	/**
	 * Creates a new PaletteDrawerEx, with the default icon
	 * 
	 * @param label
	 *        the label of the drawer
	 * @param id
	 *        the unique identifier of this drawer.
	 */
	public ExtendedPaletteDrawer(String label, String id) {
		this(label, Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/drawer.gif"), id);
	}

	/**
	 * Creates a new PaletteDrawerEx.
	 * 
	 * @param label
	 *        the label of the drawer
	 * @param icon
	 *        the icon of the drawer
	 * @param id
	 *        the unique identifier of this drawer.
	 */
	public ExtendedPaletteDrawer(String label, ImageDescriptor icon, String id) {
		super(label, icon);
		setId(id);
	}

}
