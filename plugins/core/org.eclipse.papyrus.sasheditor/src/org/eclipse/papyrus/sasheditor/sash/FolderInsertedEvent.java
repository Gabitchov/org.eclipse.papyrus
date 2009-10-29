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

public class FolderInsertedEvent extends ChangeEvent {

	private Object insertedFolder;

	private int side;

	private Object relativeFolder;

	/**
	 * Create an event specifying that a folder has been inserted on the side of the relative
	 * folder. Side can be left of right.
	 */
	public FolderInsertedEvent(Object insertedFolder, int side, Object relativeFolder) {
		this.insertedFolder = insertedFolder;
		this.side = side;
		this.relativeFolder = relativeFolder;
	}

	/**
	 * @return the insertedFolder
	 */
	// @unused
	public Object getInsertedFolder() {
		return insertedFolder;
	}

	/**
	 * @param insertedFolder
	 *            the insertedFolder to set
	 */
	// @unused
	public void setInsertedFolder(Object insertedFolder) {
		this.insertedFolder = insertedFolder;
	}

	/**
	 * @return the side
	 */
	// @unused
	public int getSide() {
		return side;
	}

	/**
	 * @param side
	 *            the side to set
	 */
	// @unused
	public void setSide(int side) {
		this.side = side;
	}

	/**
	 * @return the relativeFolder
	 */
	// @unused
	public Object getRelativeFolder() {
		return relativeFolder;
	}

	/**
	 * @param relativeFolder
	 *            the relativeFolder to set
	 */
	// @unused
	public void setRelativeFolder(Object relativeFolder) {
		this.relativeFolder = relativeFolder;
	}

}
