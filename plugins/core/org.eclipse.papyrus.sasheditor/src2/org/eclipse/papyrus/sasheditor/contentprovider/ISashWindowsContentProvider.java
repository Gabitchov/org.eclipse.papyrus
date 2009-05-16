package org.eclipse.papyrus.sasheditor.contentprovider;

/**
 * This interface is used by the sash windows system to discover its content. It is considered
 * as the root of the sash windows models.
 * The sashsystem is able to retrieve all its content from this interface, and associated interfaces 
 * {@link ITabFolderModel}, {@link ISashPanelModel}, {@link IPageModel}.
 * The interface is also used by the sashsystem to communicate, by sending event, with the 
 * effective implementation or upper level.
 * @author dumoulin
 *
 */
public interface ISashWindowsContentProvider {
	
	/**
	 * Get the root object shown in the sashes window.
	 * The type of the returned object is left to the implementation.
	 * The sashes window will ask for an interface used to interact with the object.
	 * In normal implementation, this method should return the model used by the implementation.
	 * @return The object representing the root of the sashes window.
	 */
	public Object getRootModel();
	
	/**
	 * create the interface used by the sashes window to access the root model.
	 * This method is called by the sashes window to get the interface.
	 * The method is called only once for a given object.
	 * @param root
	 * @return The SashModel corresponding to the specified root object.
	 */
	public IAbstractPanelModel createChildSashModel( Object root );
	
	/**
	 * Add a Page to the current TabFolder.
	 * The Page is added at the end of the tab list.
	 * @param tabItem TabItem to add
	 */
	public void addPage( IPageModel tabItem );

	/**
	 * Move a tab inside the specified folder.
	 * @param model
	 * @param oldIndex 
	 * @param newIndex
	 */
	public void movePage(ITabFolderModel folderModel, int oldIndex, int newIndex);

	/**
	 * Move a tab from folder to folder.
	 * @param model
	 * @param sourceIndex
	 * @param model2
	 * @param targetIndex
	 */
	public void movePage(ITabFolderModel srcFolderModel, int sourceIndex, ITabFolderModel targetFolderModel, int targetIndex);
	
	/**
	 * Add a page to the current TabFolder.
	 * The page is added at the end of the page list.
	 * @param index Index to where the tabItem should be added.
	 * @param tabItem TabItem to add
	 */
	public void addPage( int index, IPageModel tabItem );
	
	/**
	 * Remove the page at the specified index of the current tabFolder
	 * @param index
	 */
	public void removePage(int index);
	
	/**
	 * Remove the page from the sashes window.
	 * Look for the folder containing the page.
	 * 
	 * @param tabItem
	 */
	public void removePage(IPageModel tabItem);
	
	/**
	 * Remove the specified page from the parentFolder.
	 * 
	 * @param tabItem
	 */
	public void removePage(ITabFolderModel parentFolder, int tabIndex);
	
	/**
	 * Ask the model to move the specified tab to the specified side of the specified targetFolder. 
	 * This method 
	 * is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This 
	 * will be done when the corresponding event will occur.
	 * 
	 * @param tabFolder The folder containing the tab to move
	 * @param tabIndex The index of the tab to move
	 * @param targetFolder The folder to which the side refer to
	 * @param side Side where node should be inserted : SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.DOWN.
	 */
	public ITabFolderModel createFolder(ITabFolderModel tabFolder, int tabIndex, ITabFolderModel targetFolder, int side);

	/**
	 * Get the current tabFolder.
	 * TODO Check if this method is really needed from sasheditor. If not, move it away.
	 * It is needed by MultiPageEditor.
	 * @return
	 */
	public ITabFolderModel getCurrentTabFolder();


}
