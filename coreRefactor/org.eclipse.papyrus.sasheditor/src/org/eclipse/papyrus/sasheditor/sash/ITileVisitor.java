/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;


/**
 * Visitor used to visit the hierarchy of Tiles.
 * @author dumoulin
 *
 */
@SuppressWarnings("unchecked")
public interface ITileVisitor {

	/**
	 * Accept the node of specified type.
	 * @param folder
	 */
	
	public void accept(RootPart tile);
	
	/**
	 * Accept the node of specified type.
	 * @param folder
	 */
	public void accept(SashPart tile);
	
	/**
	 * Accept the node of specified type.
	 * @param folder
	 */
	public void accept(TabFolderPart folder);
	
	/**
	 * Accept the node of specified type.
	 * @param folder
	 */
	public void accept(TabPart tile);
	
	/**
	 * Accept the node of specified type.
	 * @param folder
	 */
	public void accept(EditorTile tile);
	
	
}
