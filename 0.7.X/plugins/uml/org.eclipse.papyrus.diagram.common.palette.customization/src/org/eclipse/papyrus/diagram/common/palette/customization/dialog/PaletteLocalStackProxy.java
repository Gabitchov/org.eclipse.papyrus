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

package org.eclipse.papyrus.diagram.common.palette.customization.dialog;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.palette.customization.dialog.LocalPaletteContentPage.EntryType;
import org.eclipse.swt.graphics.Image;

/**
 * proxy for a local stack
 */
public class PaletteLocalStackProxy extends PaletteContainerProxy {

	/** id of this separator */
	protected String id;

	/** icon for separators */
	public static String STACK_ICON = "/icons/stack.gif";

	/**
	 * Creates a new PaletteLocalEntryProxy
	 */
	public PaletteLocalStackProxy(String id) {
		super(null);
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntryType getType() {
		return EntryType.STACK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabel() {
		return "> Stack";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getPluginIconImage(Activator.ID, STACK_ICON);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getDescription() {
		return "<unused element>";
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getImagePath() {
		return "<unused element>";
	}
}
