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
 * @param T Common ancestor for the model provided for the sash windows by the application. 
 * This is the type used externally by the application. Sash implementation don't use this type,
 * it just carry it to ask for the appropriate wrapper. Concrete implementation can specify 
 * a type.
 */
public class TilePartFactory<T> implements ITilePartFactory<T> {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * The manager taking in charge nested part (usually the main Part).
	 */
	protected TilePartContainer<T> tilesContainer;

	/**
	 * Constructor.
	 */
	public TilePartFactory(TilePartContainer<T> tilesContainer) {
		this.tilesContainer = tilesContainer;
	}

	/**
	 * Create the sash model for the specified real node
	 */
	private ITilePart.ITilePartNodeModel<T> createTilePartModel(T realModel) {
		return tilesContainer.getContainerModel().createTilePartModel(realModel);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePartFactory#createTilePart(java.lang.Object)
	 */
	public ITilePart<T> createTilePart(ITilePart<T> parent, T realModel) {

		ITilePart.ITilePartNodeModel<T> model = createTilePartModel(realModel);

		if (model instanceof ITabFolderModel) {
			return createTabFolderPart(parent, (ITabFolderModel<T>) model);
		} else if (model instanceof ISashModel) {
			return createSashPart(parent, (ISashModel<T>) model);
		}

		return null;
	}

	/**
	 * Create a SashPart
	 * 
	 * @TODO Move in a superclass inside multidiagram
	 */
	private ITilePart<T> createSashPart(ITilePart<T> parent, ISashModel<T> model) {
		SashPart<T> part = new SashPart<T>(tilesContainer, parent, model);

		return part;
	}

	/**
	 * Create a TabFolderPart.
	 * 
	 * @TODO Move in a superclass inside multidiagram
	 */
	private ITilePart<T> createTabFolderPart(ITilePart<T> parent, ITabFolderModel<T> model) {
		TabFolderPart<T> part = new TabFolderPart<T>(tilesContainer, parent, model);

		return part;
	}

}
