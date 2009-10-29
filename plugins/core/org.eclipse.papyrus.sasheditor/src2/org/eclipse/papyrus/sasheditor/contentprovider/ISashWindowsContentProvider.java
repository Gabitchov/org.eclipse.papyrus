package org.eclipse.papyrus.sasheditor.contentprovider;

/**
 * This interface is used by the sash windows system to discover its content. It is considered as
 * the root of the sash windows models. The sashsystem is able to retrieve all its content from this
 * interface, and associated interfaces {@link ITabFolderModel}, {@link ISashPanelModel},
 * {@link IPageModel}. The interface is also used by the sashsystem to communicate, by sending
 * event, with the effective implementation or upper level.
 * 
 * @author dumoulin
 * 
 */
public interface ISashWindowsContentProvider {

	/**
	 * Get the root object shown in the sashes window. The type of the returned object is left to
	 * the implementation. The sashes window will ask for an interface used to interact with the
	 * object. In normal implementation, this method should return the model used by the
	 * implementation.
	 * 
	 * @return The object representing the root of the sashes window.
	 */
	public Object getRootModel();

	/**
	 * create the interface used by the sashes window to access the root model. This method is
	 * called by the sashes window to get the interface. The method is called only once for a given
	 * object.
	 * 
	 * @param root
	 * @return The SashModel corresponding to the specified root object.
	 */
	public IAbstractPanelModel createChildSashModel(Object root);

	/**
	 * Add a page to the current TabFolder. The Page is added at the end of the tab list.
	 * 
	 * @param page
	 *            An object identifying the page to add. The object could be anything. It will be
	 *            passed to the {@link ITabFolderModel#createChildSashModel(Object)} method.
	 */
	public void addPage(Object page);

	/**
	 * Add a page at the specified index of TabFolder.
	 * 
	 * @param page
	 *            An object identifying the page to add. The object could be anything. It will be
	 *            passed to the {@link ITabFolderModel#createChildSashModel(Object)} method.
	 * @param index
	 *            Index to where the tabItem should be added.
	 */
	public void addPage(Object page, int index);

	/**
	 * Move a tab inside the specified folder.
	 * 
	 * @param model
	 * @param oldIndex
	 * @param newIndex
	 */
	public void movePage(ITabFolderModel folderModel, int oldIndex, int newIndex);

	/**
	 * Move a tab from folder to folder.
	 * 
	 * @param model
	 * @param sourceIndex
	 * @param model2
	 * @param targetIndex
	 */
	public void movePage(ITabFolderModel srcFolderModel, int sourceIndex, ITabFolderModel targetFolderModel,
			int targetIndex);

	/**
	 * Remove the page at the specified index of the current tabFolder
	 * 
	 * @param index
	 */
	public void removePage(int index);

	/**
	 * Remove the page from the sashes window. Look for the folder containing the page.
	 * 
	 * @param page
	 *            The Object identifying the page. This is the object used in
	 *            {@link #addPage(Object)}.
	 */
	public void removePage(Object page);

	/**
	 * Remove the specified page from the parentFolder.
	 * 
	 * @param tabItem
	 */
	public void removePage(ITabFolderModel parentFolder, int tabIndex);

	/**
	 * Ask the model to move the specified tab to the specified side of the specified targetFolder.
	 * This method is called by the the SashTileContainer when the user have drag a tab in a correct
	 * place. The SashTileContainer has not change is presentation yet. This will be done when the
	 * corresponding event will occur.
	 * 
	 * @param tabFolder
	 *            The folder containing the tab to move
	 * @param tabIndex
	 *            The index of the tab to move
	 * @param targetFolder
	 *            The folder to which the side refer to
	 * @param side
	 *            Side where node should be inserted : SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.DOWN.
	 */
	public void createFolder(ITabFolderModel tabFolder, int tabIndex, ITabFolderModel targetFolder, int side);

	/**
	 * Ask the model to keep trace of the Current Folder. The notion of Current Folder is used by
	 * {@link #addPage(Object)}. Calling this method should not fire a Change Event.
	 * 
	 * This method is used by the SashSystem when the user select a new folder by clicking on one of
	 * the tabs.
	 * 
	 * @param rawModel
	 *            The Raw model identifying the folder. This is the same object as the one returned
	 *            by {@link ISashPanelModel#getChildren()} when the child denote a folder.
	 */
	public void setCurrentFolder(Object rawModel);

}
