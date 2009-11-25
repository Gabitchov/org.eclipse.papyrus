/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;


/**
 * Default implementation visiting the hierarchy.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("unchecked")
public class TileVisitor implements ITileVisitor {

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(TabFolderPart tile) {
		acceptTabFolderPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(RootPart tile) {
		acceptRootPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(SashPart tile) {
		acceptSashPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(TabPart tile) {
		acceptTabPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param tile
	 */
	public void accept(EditorTile tile) {
		acceptEditorTile(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	// ----------------------------------------------

	/**
	 * Visit the specified type.
	 * 
	 * @param tile
	 */
	protected void acceptRootPart(RootPart tile) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param tile
	 */
	protected void acceptSashPart(SashPart tile) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param tile
	 */
	protected void acceptTabFolderPart(TabFolderPart tile) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param tile
	 */
	protected void acceptTabPart(TabPart tile) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param tile
	 */
	protected void acceptEditorTile(EditorTile tile) {
	}



}
