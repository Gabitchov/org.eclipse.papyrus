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

package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener.ContentEvent;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.PanelParent;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.SashPanel;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.Window;


/**
 * EMF implementation of the {@link ISashWindowsContentProvider}.
 * 
 * @author dumoulin
 */
public class DiContentProvider implements ISashWindowsContentProvider, IContentChangedProvider {

	/** Internal EMF model */
	private SashModel diSashModel;
	/** Factory used to create SWT Editor or Component from Page Identifiers. */
	private IPageModelFactory pageModelFactory;
	/** */
	private ContentChangeListenerManager contentChangedListenerManager = new ContentChangeListenerManager();
	
	private EMFAdapter emfAdapter = new EMFAdapter();
	
	/**
	 * Create a ContentProvider
	 * @param diSashModel
	 * @param pageModelFactory
	 */
	public DiContentProvider(SashModel diSashModel, IPageModelFactory pageModelFactory) {
		this.diSashModel = diSashModel;
		this.pageModelFactory = pageModelFactory;
		connectChangeListeners();
	}

	/**
	 * Connect EMF changeListener to the {@link ContentChangeListenerManager}.
	 * Changes in the EMF di model will be fired by the ContentChangeListenerManager.
	 */
	private void connectChangeListeners() {
		diSashModel.eAdapters().add(emfAdapter);
	}

	
	/**
	 * Access to internal structure for tests. 
	 * This method is not intended to be used for other purpose.
	 * @return the diSashModel
	 */
	protected SashModel getDiSashModel() {
		return diSashModel;
	}

	/**
	 * Add a page identifier to the SashModel. This page identifier will be added as "child" of the current 
	 * TabFolder.
	 * 
	 * @param pageIdentifier
	 */
	public void addPage(Object pageIdentifier)
	{
		diSashModel.addPage(pageIdentifier);
	}
	
	/**
	 * Add a page to the current folder.
	 * Create the Page (Editor or Component) with the help of the factory.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#addPage(int, org.eclipse.papyrus.sasheditor.contentprovider.IPageModel)
	 *
	 * @param index
	 * @param tabItem
	 */
	public void addPage(Object page, int index ) {
		
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#createFolder(org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param tabFolder
	 * @param tabIndex
	 * @param targetFolder
	 * @param side
	 * @return
	 */
	public void createFolder(ITabFolderModel tabFolder, int tabIndex, ITabFolderModel targetFolder, int side) {

		// disable fired events
		contentChangedListenerManager.setDeliver(false);
		// Create new folder. Parent will be set when inserted.
		TabFolder newFolder = DiFactory.eINSTANCE.createTabFolder();
		
		TabFolder refFolder = ((TabFolderModel)targetFolder).getTabFolder();
		TabFolder pageSrcFolder = ((TabFolderModel)tabFolder).getTabFolder();
		
		// Insert folder
		diSashModel.insertFolder(newFolder, refFolder, side);
		// Move tab from folder to folder
		diSashModel.movePage(pageSrcFolder, tabIndex, newFolder);
		// Remove unused folder if necessary
		diSashModel.removeEmptyFolder(pageSrcFolder);
		diSashModel.setCurrentSelection(newFolder);
		
		// Reenable events, and fire the last one
		contentChangedListenerManager.setDeliver(true);
		
	}

	/**
	 * Get the node used as root of the SashWindows.
	 * For now, this is the first window.
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#getRootModel()
	 *
	 * @return
	 */
	public Object getRootModel() {
		// Get the first window.
		return diSashModel.getWindows().get(0).getPanel();
	}

	/**
	 * Create the IPanelModel for the rootModel returned by {@link DiContentProvider#getRootModel()}.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#createChildSashModel(java.lang.Object)
	 *
	 * @param root
	 * @return
	 */
	public IAbstractPanelModel createChildSashModel(Object root) {
		
		
		if(root instanceof SashPanel)
			return new SashPanelModel((SashPanel)root, pageModelFactory);
		else if(root instanceof TabFolder)
			return new TabFolderModel((TabFolder)root, pageModelFactory);
		else
			throw new IllegalArgumentException("Can't create IPanelModel from raw model '" + root + "'.");
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int, int)
	 *
	 * @param folderModel
	 * @param oldIndex
	 * @param newIndex
	 */
	public void movePage(ITabFolderModel folderModel, int oldIndex, int newIndex) {
		TabFolder folder = ((TabFolderModel)folderModel).getTabFolder();
		
		contentChangedListenerManager.setDeliver(false);
		folder.movePage(oldIndex, newIndex);
		diSashModel.setCurrentSelection(folder);
		contentChangedListenerManager.setDeliver(true);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param srcFolderModel
	 * @param sourceIndex
	 * @param targetFolderModel
	 * @param targetIndex
	 */
	public void movePage(ITabFolderModel srcFolderModel, int sourceIndex, ITabFolderModel targetFolderModel, int targetIndex) {

		TabFolder srcFolder = ((TabFolderModel)srcFolderModel).getTabFolder();
		TabFolder targetFolder = ((TabFolderModel)targetFolderModel).getTabFolder();
		
		contentChangedListenerManager.setDeliver(false);
		diSashModel.movePage(srcFolder, sourceIndex, targetFolder, targetIndex);
        diSashModel.removeEmptyFolder(srcFolder);
        diSashModel.setCurrentSelection(targetFolder);
		contentChangedListenerManager.setDeliver(true);
        
	}

	/**
	 * Remove specified page from the current folder.
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(int)
	 *
	 * @param index
	 */
	public void removePage(int index) {
		diSashModel.removePage(index);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(org.eclipse.papyrus.sasheditor.contentprovider.IPageModel)
	 *
	 * @param tabItem
	 */
	public void removePage(Object page) {
		throw new UnsupportedOperationException("Not yet implemented.");

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param parentFolder
	 * @param tabIndex
	 */
	public void removePage(ITabFolderModel parentFolder, int tabIndex) {
		TabFolderModel folder = (TabFolderModel)parentFolder;
		
		folder.getTabFolder().removePage(tabIndex);
	}
	
	/**
	 * Add a listener listening on content changed. This listener will be 
	 * notified each time the content change.
	 * @param listener
	 */
	public void addContentChangedListener( IContentChangedListener listener)
	{
		contentChangedListenerManager.addContentChangedListener(listener);
	}
	
	/**
	 * Add a listener listening on content changed. This listener will be 
	 * notified each time the content change.
	 * @param listener
	 */
	public void removeContentChangedListener( IContentChangedListener listener)
	{
		contentChangedListenerManager.removeContentChangedListener(listener);
	}
	
	/**
	 * Add a listener listening on content changed. This listener will be 
	 * notified each time the content change.
	 * @param listener
	 */
	protected void firePropertyChanged( ContentEvent event)
	{
		contentChangedListenerManager.fireContentChanged(event);
	}
	
	/**
	 * A class managing a list of listeners.
	 * @author dumoulin
	 */
	protected class ContentChangeListenerManager {
		
		private List<IContentChangedListener> listeners;

		/** Is this mngr delivering events ? */
		private boolean isDeliverEnable = true;

		/** Last event stored when isDeliverEnable == false; */
		private ContentEvent storedEvent;
		
		
		/**
		 * @return the isDeliverEnable
		 */
		protected boolean isDeliver() {
			return isDeliverEnable;
		}
		
		/**
		 * @param isDeliverEnable the isDeliverEnable to set
		 */
		protected void setDeliver(boolean isDeliverEnable) {
			
			if( this.isDeliverEnable == isDeliverEnable)
				return;
			
			// Check if the old value is not delivering event
			if( !this.isDeliverEnable)
			{
				this.isDeliverEnable = true;
				// reenable events. Check if an event is stored
				if(storedEvent!=null)
					fireContentChanged(storedEvent);
				
			}
			else
			  this.isDeliverEnable = isDeliverEnable;
			
			storedEvent = null;
		}
		/**
		 * Add a listener listening on content changed. This listener will be 
		 * notified each time the content change.
		 * @param listener
		 */
		public void addContentChangedListener( IContentChangedListener listener)
		{
			if(listeners == null)
				createListeners();
			
			// Check if already exists.
			if(listeners.contains(listener))
				return;
			
			listeners.add(listener);
		}
		/**
		 * Add a listener listening on content changed. This listener will be 
		 * notified each time the content change.
		 * @param listener
		 */
		public void removeContentChangedListener( IContentChangedListener listener)
		{
			if(listeners == null)
				return;
			
			listeners.remove(listener);
		}
		
		/**
		 * Create the list of listeners.
		 */
		private void createListeners() {
			if(listeners == null)
		  	  listeners = new ArrayList<IContentChangedListener>();
			
		}
		
		/**
		 * Fire the changed event.
		 * @param event
		 */
		public void fireContentChanged(ContentEvent event)
		{
			if(listeners==null)
				return;
			
			if( !isDeliverEnable)
			{
				storedEvent = event;
				return;
			}

			for( IContentChangedListener listener : listeners)
			{
				listener.contentChanged(event);
			}
		}
	}

	/**
	 * Change event Adapter.
	 * Forward EMF changeEvent to the {@link ContentChangeListenerManager}.
	 * @author cedric dumoulin
	 */
	public class EMFAdapter extends EContentAdapter {

		/**
		 * Model has changed.
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 *
		 * @param msg
		 */
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			
			Object sender = msg.getNotifier();
			if(sender instanceof AbstractPanel || sender instanceof Window || sender instanceof PageRef )
			  firePropertyChanged(new ContentEvent(msg.getEventType(), sender, null));
		}
	}
}
