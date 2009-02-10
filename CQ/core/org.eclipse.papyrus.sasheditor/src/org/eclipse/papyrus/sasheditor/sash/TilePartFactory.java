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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.sash;

import java.util.logging.Logger;

import org.eclipse.papyrus.sasheditor.sash.SashPart.ISashModel;
import org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel;

/**
 * Used to create part associated to diagram node.
 */
public class TilePartFactory implements ITilePartFactory {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * The manager taking in charge nested part (usually the main Part).
	 */
	protected TilePartContainer tilesContainer;

	/**
	 * Constructor.
	 */
	public TilePartFactory(TilePartContainer tilesContainer) {
		this.tilesContainer = tilesContainer;
	}

	/**
	 * Create the model for the specified real node
	 */
	private ITilePart.ITilePartNodeModel createTilePartModel(Object realModel) {
		return tilesContainer.getContainerModel().createTilePartModel(realModel);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePartFactory#createTilePart(java.lang.Object)
	 */
	public ITilePart createTilePart(ITilePart parent, Object realModel) {

		ITilePart.ITilePartNodeModel model = createTilePartModel(realModel);

		if (model instanceof ITabFolderModel) {
			return createTabFolderPart(parent, (ITabFolderModel) model);
		} else if (model instanceof ISashModel) {
			return createSashPart(parent, (ISashModel) model);
		}

		return null;
	}

	/**
	 * Create a SashPart
	 * 
	 * @TODO Move in a superclass inside multidiagram
	 */
	private ITilePart createSashPart(ITilePart parent, ISashModel model) {
		SashPart part = new SashPart(tilesContainer, parent, model);

		return part;
	}

	/**
	 * Create a TabFolderPart.
	 * 
	 * @TODO Move in a superclass inside multidiagram
	 */
	private ITilePart createTabFolderPart(ITilePart parent, ITabFolderModel model) {
		TabFolderPart part = new TabFolderPart(tilesContainer, parent, model);

		return part;
	}

}
