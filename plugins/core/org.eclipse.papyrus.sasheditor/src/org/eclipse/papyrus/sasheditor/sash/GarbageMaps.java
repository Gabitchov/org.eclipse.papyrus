/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;

import java.util.HashMap;

/**
 * This class is used to Garbage unused Part after a synchronization with the underlying model.
 * The maps are filled before the synchronize(), and the parts are garbaged after the synchronize.
 * @author dumoulin
 *
 */
public class GarbageMaps <T> {

	/** Map of container nodes (FolderPart and SashPart)*/
	protected PartMap<T> partMap = new PartMap<T>();
	/** Map of leaf part (TabPart) */
	protected HashMap<Object, EditorTile<T>> tabPartMap = new HashMap<Object, EditorTile<T>>();
	
	/**
	 * @return the partMap
	 */
	public PartMap<T> getContainerPartMap() {
		return partMap;
	}
	/**
	 * @return the tabPartMap
	 */
	public HashMap<Object, EditorTile<T>> getTabPartMap() {
		return tabPartMap;
	}
	
	/**
	 * Garbage orphaned elements.
	 */
	public void garbage()
	{
		// Remove orphaned part (no more used)
		for (ITilePart<T> part : partMap.getTileParts()) {
			if (part.isOrphaned())
				part.dispose(false);
		}

		// Remove orphaned part (no more used)
		for (EditorTile<T> part : tabPartMap.values()) {
			if (part.isOrphaned())
				part.garbage();
		}
	}
	
	/**
	 * Add a leaf tile to the maps.
	 * 
	 * @param model The model associated to the Tile
	 * @param tile The tile to add.
	 */
	public void addTile(Object model, EditorTile<T> tile)
	{
		tabPartMap.put(model, tile);
	}
}
