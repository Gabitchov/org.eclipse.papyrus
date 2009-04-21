/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.sasheditor.sash.EditorTile;
import org.eclipse.papyrus.sasheditor.sash.ITilePart;


/**
 * This class contains lists of parts, regardless of the part parents.
 * There is two lists: one for the pane Parts and one for the Leaf Parts.
 * This class is used when refreshing the SashesContainer: a new instance is created 
 * and filled with existing parts. Then the list is carried with each pane refresh methods.
 *   
 * @author cedric dumoulin
 */
public class PartLists {

	private List<PagePart> pageParts = new ArrayList<PagePart>();
	private List<AbstractPanelPart> panelParts = new ArrayList<AbstractPanelPart>();
	
	/**
	 * Search for a Part associated to the specified newModel.
	 * Return the part or null if none is found.
	 * @param rawModel
	 * @return
	 */
	public PagePart findPagePartFor(Object rawModel) {
		
		for (PagePart part : pageParts) {
			if (part.isPartFor(rawModel))
				return part;
		}
		return null;
	}

	/**
	 * Find the pane part for the specified rawModel.
	 * Return the found part or null
	 * 
	 * @param rawModel The raw model for which a part is lookup.
	 * @return
	 */
	public AbstractPanelPart findPartFor(Object rawModel) {

		for (AbstractPanelPart part : panelParts) {
			if (part.isPartFor(rawModel))
				return part;
		}

		return null;
	}

	/**
	 * Add a leaf part to the lists.
	 * @param pagePart
	 */
	public void addLeaf(PagePart pagePart) {
		pageParts.add(pagePart);
	}

	/**
	 * Add the partPane to the lists.
	 * @param panelPart
	 */
	public void addPart(AbstractPanelPart panelPart) {
		panelParts.add(panelPart);
		
	}

	/**
	 * Garbage orphaned elements.
	 */
	public void garbage()
	{
		// Remove orphaned part (no more used)
		for (AbstractPanelPart part : panelParts) {
			if (part.isOrphaned())
				part.dispose();
		}

		// Remove orphaned part (no more used)
		for (PagePart part : pageParts) {
			if (part.isOrphaned())
				part.garbage();
		}
	}
	

}
