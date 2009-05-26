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
package org.eclipse.papyrus.sasheditor.multipage.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * A MultiPageEditor implementation accepting IMultiSashContentProvider as content provider.
 * This implementation extends the regular eclipse MultiPageEditorPart.
 * The refresh() method allows to refresh the tabs.
 * 
 * The implementation do not listen on model change. This can be done by subclasses.
 * To add a new tab, one should add it as a model in the ContentProvider. The addPage() 
 * methods should not be used for this purpose.
 * 
 * This implementation is intended for debug and testing purpose : it can be used in place
 * of the AbstractMultiPageSashEditor. It takes the same arguments and ContentProvider, but
 * it only allows one folder and don't deal with multisashes. 
 * Also, the implementation use the regular Eclipse EditorSite management. This allows to check for problems from this
 * site management.
 * 
 * @author dumoulin 
 */
public  abstract class MultiPageEditor extends MultiPageEditorPart {

	/** Log object */
	protected Logger log = Logger.getLogger(getClass().getName());

	/** The pageProvider */
	private ISashWindowsContentProvider pageProvider;
	
	/**
	 * The tabfolder model providing the pages that must be shown.
	 */
	private ITabFolderModel tabFolderModel;

	/** Ordered set of currently shown diagrams */
	protected List<IPageModel> currentTabs = new ArrayList<IPageModel>();

	/**
	 * Constructor.
	 */
	public MultiPageEditor() {
		super();
	}

	@Override
	public Object getAdapter(Class adapter) {
		
		// Get the content provider if requested.
		if(ISashWindowsContentProvider.class == adapter)
			return getContentProvider();
		
		return super.getAdapter(adapter);
	}
	
	/**
	 * get the contentProvider. Create it if necessary.
	 * @return
	 */
	protected ISashWindowsContentProvider getContentProvider()
	{
		if(pageProvider == null)
			pageProvider = createPageProvider();
		
		return pageProvider;
	}
	
	/**
	 * Add a page containing the Component described by the provided model.
	 * @param tabItem
	 */
	protected int addPage(IComponentModel tabItem) {
		Composite composite = tabItem.createPartControl( getContainer() );
	
		int index = addPage(composite);
		setPageText(index, tabItem.getTabTitle() );
		Image image = tabItem.getTabIcon();
		if(image !=null)
		  setPageImage(index, image);
		return index;
	}

	/**
	 * Add the editor corresponding to the model to the folder.
	 * @param editorModel
	 */
	protected int addPage(IEditorModel editorModel) {
		try {
			IEditorPart editor = editorModel.createIEditorPart();
			int index = addPage(editor, getEditorInput());
			setPageText(index, editorModel.getTabTitle());
			Image image = editorModel.getTabIcon();
			if(image !=null)
			  setPageImage(index, image);
			return index;
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested text editor",
				null,
				e.getStatus());
			return -1;
		}
		
	}

	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		// get the page descriptions
		pageProvider = createPageProvider();
		// Get the current tabFolder
		// 
		tabFolderModel = lookupFolder();
	
		refreshTabs();
		
//		// iterate over pages to be show
//		for( Object rawPageModel : tabFolderModel.getChildren() )
//			{
//			// Get the model interface
//			ITabItemModel tabItem = tabFolderModel.createChildSashModel( rawPageModel);
//			if(tabItem instanceof IEditorModel )
//			{
//				addPage((IEditorModel)tabItem );
//			}
//			else if(tabItem instanceof IComponentModel )
//			{
//				addPage((IComponentModel)tabItem );				
//			}
//			else
//			{
//				System.err.println("Can't create page for model '" + tabItem + "'. Skipp it.");
//			}
//		}
	}

	/**
	 * Lookup for a folder in the SashModel. Return the first folder found.
	 * @return
	 */
	private ITabFolderModel lookupFolder() {
		if (pageProvider == null)
			return null;
		
		Object rawModel = pageProvider.getRootModel();
		IAbstractPanelModel panelModel = pageProvider.createChildSashModel(rawModel);
		
		return lookupFolder(panelModel);
	}

	/**
	 * Recursively search in sash models for a FolderModel.
	 * Return the first encountered folder.
	 * @param panelModel
	 * @return
	 */
	private ITabFolderModel lookupFolder(IAbstractPanelModel panelModel) {
		
		if(panelModel instanceof ITabFolderModel)
			return (ITabFolderModel)panelModel;
		else
		{
			ISashPanelModel sashModel = (ISashPanelModel)panelModel;
			// Iterate on children
			for(Object child : sashModel.getChildren() )
			{
				IAbstractPanelModel childModel = pageProvider.createChildSashModel(child);
				ITabFolderModel res = lookupFolder(childModel);
				if(res != null)
					return res;
			}
		}
		// Not found
		return null;
	}
	
	/**
	 * Create the provider.
	 * Subclass must implements this method. It should return the provider used by the editor.
	 * 
	 */
	abstract protected ISashWindowsContentProvider createPageProvider();

	/**
	 * Refresh the tabs order.
	 * This method should be called after the model list is modified.
	 */
	protected void refreshTabs()
	{
		// get list of diagrams to be displayed
		List<?> newModels = tabFolderModel.getChildren();

		// Check if each model has an open pageEditor. If not, create the editor.
		Iterator<?> newIter = newModels.iterator();
		while(newIter.hasNext())
		{
			Object model = newIter.next();
			if( ! tabExistsFor(model) )
			{ // create a new editor for the model
				addEditor(tabFolderModel.createChildSashModel(model) );
			}
		}

		// If open editor count is the same has models count, 
		// all models have an editor. So, end the refresh process.
		if( newModels.size() == getPageCount() )
			return;

		// There is some extra editors ! remove them.
		// remove extra editors : for each open editor, check if its model is in
		// the list of required models.
		List<IPageModel> toBeRemoved = new ArrayList<IPageModel>();
		Iterator<IPageModel> currentIter = currentTabs.iterator();
		while(currentIter.hasNext())
		{
			IPageModel model = currentIter.next();
			if( ! newModels.contains(model.getRawModel() ) )
			{ // remove editor
				toBeRemoved.add(model);
			}
		}

		// Remove editor from the editors displayed by the multi editor
		Iterator<IPageModel> removeIter = toBeRemoved.iterator();
		while(removeIter.hasNext())
		{
			IPageModel model = removeIter.next();
			removeEditor(model);
		}	
	}

	/**
	 * Check if an editor exists for the specified model.
	 * @param model the diagram (model) that should be displayed 
	 * @return <code>true</code> if the editor exists for this model
	 */
	private boolean tabExistsFor(Object model) {
		for(IPageModel tabItem : currentTabs)
		{
			if(tabItem.getRawModel() == model)
				return true;
		}
		return false;
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.MultiPageEditorPart#removePage(int)
	 */
	@Override
	public void removePage(int pageIndex) {
		super.removePage(pageIndex);
		// synchronize the list of currently shown models.
		currentTabs.remove(pageIndex);
	}

	/** 
	 * Removes the editor associated to the specified model.
	 * @param model the diagram (model) displayed in the editor
	 */
	private void removeEditor(IPageModel model) {
		int index = currentTabs.indexOf(model);
		removePage(index);
	}

	/**
	 * Add a new editor at the end of existing editors.
	 * First, create the editor, then add it to the tabs.
	 * @param contentProvider the diagram (model) to be displayed in the editor
	 */
	private void addEditor(IPageModel tabItem) {
		// Check if an editor already exists
		if( tabExistsFor(tabItem) )
		{
			if(log.isLoggable(Level.FINE))
				log.fine("Editor already exists for '" + tabItem + "'");
			return;
		}

			int editorIndex=-1;
			if(tabItem instanceof IEditorModel )
			{
				editorIndex = addPage((IEditorModel)tabItem );
			}
			else if(tabItem instanceof IComponentModel )
			{
				editorIndex = addPage((IComponentModel)tabItem );				
			}
			else
			{
				System.err.println("Can't create page for model '" + tabItem + "'. Skipp it.");
				return;
			}

			// Add the model in the list of current tabs.
			currentTabs.add(tabItem);
			//  set active page
			setActivePage(editorIndex);

	}


}