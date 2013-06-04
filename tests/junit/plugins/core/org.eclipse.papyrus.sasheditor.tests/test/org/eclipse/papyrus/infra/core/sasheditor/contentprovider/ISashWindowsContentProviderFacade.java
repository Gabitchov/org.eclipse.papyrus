/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;


/**
 * Interface providing a common facade to test the {@link ISashWindowsContentProvider} implementations.
 * <br>
 * This facade provides methods to manipulate {@link ISashWindowsContentProvider} with
 * the help of names. Each element in the {@link SimpleSashWindowsContentProvider} can be identified
 * by a name (String). Then, the facade provide methods similar to {@link ISashWindowsContentProvider}, but using 
 * names rather than {@link IAbstractPanelModel} and {@link ITabFolderModel}.
 * <br>
 * The facade maintains a mapping between the names and the {@link ISashWindowsContentProvider} models.

 * <br>
 * Implementations of this class
 * allow to create an internal model according to a provided {@link IModelExp}. It is also possible
 * to check if the internal model is conform to the {@link IModelExp}.
 * 
 * <br>
 * There is several {@link ISashWindowsContentProvider} implementations, but a lot of tests are commons to
 * all the implementations. The interface allows to develop common tests regardless of the real implementation.
 * <br>
 * One develop common tests using {@link ISashWindowsContentProvider} and {@link ISashWindowsContentProviderFacade}. Then,
 * this test is subclassed and the appropriate implementations are specified in the subclasses.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface ISashWindowsContentProviderFacade {

	/**
	 * Create an internal model conform to the specified query.
	 * Any previous model is disguarded.
	 * 
	 * Some implementations do not allow to call this method more than once. In this case,
	 * the implementation should throw an Exception.
	 * 
	 * @param query Should be a subtype PanelTerm (Folder, HSash, VSash)
	 * @throws QueryException 
	 * 
	 */
	public abstract void createModel(IModelExp query) throws PagesModelException;

	/**
	 * Check if the internal model is conformed to the specified query.
	 * @param query
	 * @throws QueryException 
	 */
	public abstract void assertConform(IModelExp query) throws PagesModelException;

	/**
	 * Get element in the model.
	 * Each model element whose corresponding model query part as a name is added to the result map.
	 * The element is then accessible with the name set in the query part.
	 * 
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public abstract Map<String, Object> queryModel(IModelExp query) throws PagesModelException;

	/**
	 * Get the {@link ISashWindowsContentProvider} associated to this utility class.
	 * @return
	 */
	public ISashWindowsContentProvider getIContentProvider();
	
	/**
	 * Add a page at the specified index of TabFolder.
	 * <br>
	 * This method is not used by the {@link ISashWindowsContainer}.
	 * 
	 * @param page
	 *        An object identifying the page to add. The object could be anything. It will be
	 *        passed to the {@link ITabFolderModel#createChildSashModel(Object)} method.
	 * @param index
	 *        Index to where the tabItem should be added.
	 * @throws NotFoundException 
	 */
	public void /*IPageModel*/ addPage(Page page, String folderName, int index) throws PagesModelException;

	/**
	 * Add a page at the end of TabFolder.
	 * <br>
	 * This method is not used by the {@link ISashWindowsContainer}.
	 * 
	 * @param page
	 *        An object identifying the page to add. The object could be anything. It will be
	 *        passed to the {@link ITabFolderModel#createChildSashModel(Object)} method.
	 * @return 
	 * @throws NotFoundException 
	 */
	public void /*IPageModel*/ addPage(Page page, String folderName) throws PagesModelException;

	/**
	 * Move a tab inside the specified folder.
	 * 
	 * @param model
	 * @param oldIndex
	 * @param newIndex
	 * @throws NotFoundException 
	 */
	public void movePage(String folderName, int oldIndex, int newIndex) throws NotFoundException;

	/**
	 * Move a tab from folder to folder.
	 * 
	 * @param model
	 * @param sourceIndex
	 * @param model2
	 * @param targetIndex
	 */
	public void movePage(String srcFolderName, int sourceIndex, String targetFolderName, int targetIndex) throws NotFoundException;

	/**
	 * Remove the page from the sashes window.
	 * Look for the folder containing the page.
	 * 
	 * @param page
	 *        The Object identifying the page. This is the object used in {@link #addPage(Object)}.
	 */
	public void removePage(String pageName) throws NotFoundException;

	/**
	 * Remove the specified page from the parentFolder.
	 * 
	 * @param tabItem
	 */
	public void removePage(String folderName, int tabIndex) throws NotFoundException;

	/**
	 * Ask the model to move the specified tab to the specified side of the specified targetFolder.
	 * This method
	 * is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This
	 * will be done when the corresponding event will occur.
	 * 
	 * @param tabFolder
	 *        The folder containing the tab to move
	 * @param tabIndex
	 *        The index of the tab to move
	 * @param targetFolder
	 *        The folder to which the side refer to
	 * @param side
	 *        Side where node should be inserted : SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.DOWN.
	 * @throws PagesModelException 
	 */
	public void createFolder(String tabFolder, int tabIndex, String targetFolder, int side) throws PagesModelException;

	/**
	 * 
	 * Reset the namesMapping context accordingly to the provided expr.
	 * The names mapping is used to lookup Model element by there name.
	 * The name mapping should be reset when the internal structure has change,
	 * and especially when an element is added.
	 * <br>
	 * Reseting the names context allows to remove or add names to the context. 
	 * It is used to add names of newly created elements (created with addPage() or createFolder() )

	 * @param expr
	 * @throws PagesModelException
	 */
	public void resetNamesContext(IModelExp expr) throws PagesModelException;

	/**
	 * A facade is associated to a names and internal models map that is internally used
	 * to lookup elements.
	 * This maps is reset with {@link #resetNamesContext(IModelExp)}
	 * @return The names to internal maps.
	 */
	public Map<String, Object> getNamesToInternalMap();
	
	/**
	 * Ask the model to move the specified tab to the specified side of the specified targetFolder.
	 * This method
	 * is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This
	 * will be done when the corresponding event will occur.
	 * 
	 * @param tabFolder
	 *        The folder containing the tab to move
	 * @param tabIndex
	 *        The index of the tab to move
	 * @param targetFolder
	 *        The folder to which the side refer to
	 * @param side
	 *        Side where node should be inserted : SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.DOWN.
	 * @throws PagesModelException 
	 */
//	public void createFolder(String newFolderName, String tabFolder, int tabIndex, String targetFolder, int side) throws PagesModelException;


}
