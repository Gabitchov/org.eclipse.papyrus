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
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy.AbstractTabFolderPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.internal.DragCursors;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Controller associated to a tabfolder.
 * 
 * 
 * 
 * Extends MultiPageEditor to inherit methods implementations.
 * 
 * @param T
 *        Common ancestor for the model provided for the sash windows by the application.
 *        This is the type used externally by the application. Sash implementation don't use this type,
 *        it just carry it to ask for the appropriate wrapper. Concrete implementation can specify
 *        a type.
 * 
 *        TODO : be more precise for the generic type ?
 *        TODO : Listen to the page change event, and call setActivePage().
 */
@SuppressWarnings("restriction")
public class TabFolderPart extends AbstractTabFolderPart {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** Interface to the model */
	protected ITabFolderModel partModel;

	/** Raw model associated to this part. We store it because the PartModel do not provide it */
	private Object rawModel;

	/** The wrapper around the CTabFolder. This represent the SWT control associated to this part. */
	protected PTabFolder pTabFolder;

	/** Ordered set of currently shown diagrams (list of their models) TODO remove */
	protected TabPartList currentTabItems = new TabPartList();

	/** The drop target associated to this folderPart */
	private DropTarget dropTarget;

	/**
	 * Track the mouse hover and fire appropriate event.
	 */
	private MouseHoverTracker mouseHoverTracker;


	/**
	 * Listener on DragOver event.
	 */
	IDragOverListener dragOverListener = new IDragOverListener() {

		/**
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDragOverListener#drag(org.eclipse.swt.widgets.Control, java.lang.Object, org.eclipse.swt.graphics.Point,
		 *      org.eclipse.swt.graphics.Rectangle)
		 */
		public IDropTarget drag(Control currentControl, Object draggedObject, Point position, Rectangle dragRectangle) {
			// System.out.println(TabFolderPart.this.getClass().getSimpleName() + ".drag()");
			//			System.out.println(this + ".drag()");
			return null;
		}
	};

	/**
	 * Listener on CTabFolder events.
	 */
	private PTabFolder.IPTabFolderListener cTabFolderEventListener = new PTabFolder.IPTabFolderListener() {

		public void contextMenuDetectEvent(CTabItem tab, Event event) {
			//			System.out.println("contextMenuDetect()");
		}

		/**
		 * The close cross has been pressed. Remove the corresponding tab. {@inheritDoc}
		 */
		public void itemClosedEvent(CTabFolderEvent event, int pageIndex) {
			//			System.out.println("itemClosedEvent()");
			// TODO: call appropriate method (to be determine)
			//			model.removeTab(pageIndex);
			//			getSashWindowContainer().getContentProvider().removeTab(model, pageIndex);
			getContentProvider().removePage(partModel, pageIndex);
		}

		public void menuDetectEvent(CTabItem tab, MenuDetectEvent event) {
			//			System.out.println("menuDetectEvent()");
		}

		/**
		 * Listen to pageChange event, and propagate to TabFolderPart.
		 * 
		 * @param newPageIndex
		 */
		public void pageChangeEvent(int newPageIndex) {
			// User has change the page. Inform the TabFolderPart
			pageChange(newPageIndex);
		}

	};

	/**
	 * Constructor.
	 * 
	 * @param nestedPartManager
	 * @param partModel
	 * @param rawModel
	 * 
	 */
	public TabFolderPart(IPanelParent parent, ITabFolderModel partModel, Object rawModel) {
		super(parent);
		this.partModel = partModel;
		this.rawModel = rawModel;
	}

	/**
	 * Get the associated model.
	 */
	protected ITabFolderModel getPartModel() {
		return partModel;
	}

	/**
	 * Activate the part. Register as listener to required services.
	 */
	private void activate() {
		// Listen to page changes
		pTabFolder.getEventManager().addListener(cTabFolderEventListener);
		// Create the tracker that will show tooltips on tabs.
		mouseHoverTracker = new MouseHoverTracker(pTabFolder.getControl(), new ImageToolTipManager());
	}

	/**
	 * Deactivate this part.
	 * Unregistered from required service. Do not dispose the part.
	 */
	private void deactivate() {
		// Listen to page changes
		pTabFolder.getEventManager().removeListener(cTabFolderEventListener);
		mouseHoverTracker.deactivate();
	}

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin.
	 * 
	 * @param partMap
	 */
	@Override
	public void fillPartMap(PartLists partMap) {
		partMap.addPart(this);
		garbageState = GarbageState.UNVISITED;

		for(TabItemPart child : currentTabItems) {
			child.fillPartMap(partMap);
		}
	}

	/**
	 * Creates the control tree associated to this part.
	 * Create the control for this part, and eventually recursively call the method for the childs, if any.
	 * 
	 */
	@Override
	public void createPartControl(Composite parent) {

		createControl(parent);
		//		createPages();
		// model.addChangeListener(modelListener);
		// model.activate();
		activate();
	}

	/**
	 * Add a new page at the end of pages. A new tab is created for the page, and
	 * the page control is created.
	 * 
	 * @param pageModel
	 * @param index
	 */
	//	private void addPage(Object pageModel)
	//	{
	//		int index = currentTabItems.size();
	//		createTabItem(pageModel, index);
	//	}

	/**
	 * Create the control for this Part. Does not create children.
	 * This method is called by the parent after this folder is created.
	 * 
	 */
	public void createControl(Composite parent) {
		PTabFolder res = new PTabFolder();
		pTabFolder = res;
		res.createPartControl(parent);
		initDrag(res.getControl());
		// init menu
		initMenuManager();
	}

	/**
	 * Init the menuManager after the control has been created.
	 * Get the {@link MenuManager} from the {@link SashWindowsContainer}. Set it to this folder if it
	 * is not null.
	 */
	private void initMenuManager() {
		MenuManager menuManager = getSashWindowContainer().getFolderTabMenuManager();
		if(menuManager != null) {
			setFolderTabMenuManager(menuManager);
		}

	}

	/**
	 * Set a {@link MenuManager} used to manage a contextual menu that is shown on the tabs area of this folder.
	 * 
	 * @param menuManager
	 *        The {@link MenuManager} used to create the menu on the tab area.
	 */
	public void setFolderTabMenuManager(MenuManager menuManager) {
		Composite folderControl = getControl();
		Menu menu = menuManager.createContextMenu(folderControl);
		folderControl.setMenu(menu);
	}


	/**
	 * Called by any widget that has detected that the page has changed. <br>
	 * As the selected page has been changed by a user ui interaction, we now need
	 * to synchronize the ActivePage.
	 * Inform the {@link SashWindowsContainer} to set the active page accordingly to
	 * the new selection.
	 * 
	 * @param newPageIndex
	 */
	@Override
	protected void pageChange(int newPageIndex) {

		//		System.out.println(this.getClass().getSimpleName() + ".pageChange("+ newPageIndex +")");
		// Do nothing if out of range.
		if(newPageIndex < 0 || newPageIndex > currentTabItems.size() - 1) {
			return;
		}

		getSashWindowContainer().setActivePage(currentTabItems.get(newPageIndex).childPart);
	}

	/**
	 * An event signaling that the selected page is changed has been caught. Propagate the event to
	 * the container.
	 * Removed since 0.10
	 * 
	 * @param newPageIndex
	 */
	//	protected void pageChangedEvent(int newPageIndex) {
	//
	//		//		System.out.println(this.getClass().getSimpleName() + ".pageChange("+ newPageIndex +")");
	//		// Do nothing if out of range.
	//		if(newPageIndex < 0 || newPageIndex > currentTabItems.size() - 1)
	//			return;
	//
	//		getSashWindowContainer().pageChangedEvent(currentTabItems.get(newPageIndex).childPart);
	//	}

	/**
	 * Select the specified page.
	 * Do nothing if the index is out of range.
	 * 
	 * @param pageIndex
	 */
	protected void setSelection(int pageIndex) {
		//		Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
		if(!isValidPageIndex(pageIndex)) {
			return;
		}

		getTabFolder().setSelection(pageIndex);
	}

	/**
	 * Set the current selection of this folder. This do not fire events.
	 * This does not set the ActivePage.
	 * 
	 * @param page
	 *        the page that should be selected
	 * @since 3.3
	 */
	public final void setSelection(PagePart requestedPage) {
		// TODO There should be another way to get the index of the corresponding
		// PagePArt
		int count = getPageCount();
		for(int i = 0; i < count; i++) {
			PagePart page = getPagePart(i);
			if(page == requestedPage) {
				setSelection(i);
				break;
			}
		}
	}

	/**
	 * Dispose the TilePart and its controls.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.eclipsecopy.MultiPageEditorTile#dispose()
	 */
	@Override
	public void dispose() {
		// detach menu as it is shared between folders.
		getControl().setMenu(null);

		deactivate();


		//		getControl().dispose();
		pTabFolder.dispose();
	}

	/**
	 * Dispose this part and all its children.
	 * The method is called recursively on children of the part.
	 * Associated items are disposed.
	 */
	@Override
	public void disposeThisAndChildren() {

		// Dispose children if any
		for(TabItemPart child : currentTabItems) {
			if(child != null) {
				child.disposeThisAndChildren();
			}
		}

		// clean up properties to help GC
		partModel = null;
		rawModel = null;
		currentTabItems.clear();
		currentTabItems = null;
		dragOverListener = null;

	}

	/**
	 * 
	 */
	private void initDrag(Composite container) {
		DragUtil.addDragTarget(container, dragOverListener);
	}


	/**
	 * Get the associated CTabFolder
	 */
	@Override
	protected CTabFolder getTabFolder() {
		return pTabFolder.getTabFolder();
	}

	/**
	 * Return the swt Control associated to this part.
	 */
	@Override
	public Composite getControl() {
		return getTabFolder();
	}

	/**
	 * The <code>MultiPageEditor</code> implementation of this <code>IWorkbenchPart</code> method sets focus on
	 * the active nested editor, if there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	public void setFocus() {
		setFocus(getActivePage());
	}

	/**
	 * Sets focus to the control for the given page. If the page has an editor, this calls its <code>setFocus()</code> method. Otherwise, this calls
	 * <code>setFocus</code> on the control for the page.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 */
	private void setFocus(int pageIndex) {
		if(pageIndex < 0 || pageIndex >= getPageCount()) {
			// page index out of bounds, don't set focus.
			return;
		}
		getPagePart(pageIndex).setFocus();
	}

	/**
	 * Return the part containing specified point. Normally return this part, because the caller has
	 * already determine that this contain the part.
	 * 
	 */
	@Override
	public AbstractPart findPart(Point toFind) {
		return this;
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	@Override
	public AbstractPart findPartAt(Point toFind, Class<?> expectedTileType) {

		if(expectedTileType == this.getClass()) {
			return this;
		}

		// ask current active tab
		TabItemPart activeTabPart = getActiveTab();
		if(activeTabPart == null) {
			return null;
		}

		return getActiveTab().findPartAt(toFind, expectedTileType);
	}

	/**
	 * Get the currently active tab.
	 * 
	 * @return
	 */
	private TabItemPart getActiveTab() {
		int index = getActivePage();
		if(index != -1) {
			return currentTabItems.get(index);
		}
		return null;
	}

	/**
	 * Get the specified childPart
	 * 
	 * @param index
	 *        Index of the requested childPart.
	 * @return
	 */
	protected PagePart getPagePart(int index) {
		return currentTabItems.get(index).getChildPart();
	}

	/**
	 * Get the visible PagePart (from the Container point of view).
	 * The visible PagePart is the one that has its diagram area visible.
	 * From the folder point of view, this is the active PagePart.
	 * 
	 * @return
	 */
	public PagePart getVisiblePagePart() {
		int index = getActivePage();
		if(index != -1) {
			return getPagePart(index);
		}
		return null;
	}

	/**
	 * Find the part associated to the provided control.
	 * 
	 */
	@Override
	public AbstractPanelPart findPart(Object control) {
		if(getControl() == control) {
			return this;
		}

		// Check if it is one of the Item
		if(control instanceof CTabItem && ((CTabItem)control).getParent() == getControl()) {
			return this;
		}

		// Ask childs TODO
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.internal.AbstractPanelPart#getDropTarget(java.lang.Object,
	 *      org.eclipse.papyrus.infra.core.sasheditor.internal.TabFolderPart, org.eclipse.swt.graphics.Point)
	 * 
	 * @param draggedObject
	 * @param sourcePart
	 * @param position
	 * @return
	 */
	@Override
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		// see org.eclipse.ui.internal.presentations.util.ReplaceDragHandler
		// Determine which tab we're currently dragging over
		CTabItem tabUnderPointer = pTabFolder.getItem(position);

		// Compute source tab index. If folder, index==-1
		int sourceIndex = PTabFolder.getDraggedObjectTabIndex(draggedObject);
		// This drop target only deals with tabs... if we're not dragging over
		// a tab, exit.
		if(tabUnderPointer == null) {
			Rectangle titleArea = pTabFolder.getTabArea();

			// If we're dragging over the title area, treat this as a drop in the last
			// tab position.
			if(titleArea.contains(position) && pTabFolder.getTabFolder().getItemCount() > 0) {
				int dragOverIndex = pTabFolder.getTabFolder().getItemCount();
				CTabItem lastTab = pTabFolder.getTabFolder().getItem(dragOverIndex - 1);

				// Can't drag to end unless you can see the end
				if(!lastTab.isShowing()) {
					return null;
				}

				// If we are unable to compute the bounds for this tab, then ignore the drop
				Rectangle lastTabBounds = lastTab.getBounds();
				if(lastTabBounds.isEmpty()) {
					return null;
				}

				// if (dragStart >= 0) {
				// dragOverIndex--;
				//
				// return createDropTarget( sourcePart, lastTabBounds, dragOverIndex);
				// // return new StackDropResult(lastTabBounds, new Integer(dragOverIndex));
				// }

				// Make the drag-over rectangle look like a tab at the end of the tab region.
				// We don't actually know how wide the tab will be when it's dropped, so just
				// make it 3 times wider than it is tall.
				// titleArea is in Display coordinate, lastTabBounds in parent coordinate
				Rectangle dropRectangle = titleArea;

				dropRectangle.x = dropRectangle.x + lastTabBounds.x + lastTabBounds.width;
				dropRectangle.width = 3 * dropRectangle.height;
				return createDropTarget(sourcePart, sourceIndex, dropRectangle, dragOverIndex);
				// return new StackDropResult(dropRectangle, new Integer(dragOverIndex));

			} else {
				// If the closest side is the side with the tabs, consider this a stack operation.
				// Otherwise, let the drop fall through to whatever the default behavior is
				Rectangle displayBounds = DragUtil.getDisplayBounds(pTabFolder.getControl());
				int closestSide = Geometry.getClosestSide(displayBounds, position);
				if(closestSide == pTabFolder.getTabFolder().getTabPosition()) {
					return createDropTarget(sourcePart, sourceIndex, displayBounds, -1);
				}

				return null;
			}
		}

		if(!tabUnderPointer.isShowing()) {
			return null;
		}

		// Get thumbnail bounds in display coordinates
		Rectangle tabBounds = pTabFolder.getItemBounds(tabUnderPointer);

		if(tabBounds.isEmpty()) {
			return null;
		}

		return createDropTarget(sourcePart, sourceIndex, tabBounds, pTabFolder.getTabFolder().indexOf(tabUnderPointer));
	}

	/**
	 * Copied from org.eclipse.ui.internal.PartStack
	 */
	public IDropTarget createDropTarget(TabFolderPart sourcePart, int sourceIndex, Rectangle snapRectangle, int tabIndex) {

		if(dropTarget == null) {
			dropTarget = new DropTarget(sourcePart, sourceIndex, snapRectangle, tabIndex);
			return dropTarget;
		}

		dropTarget.setTarget(sourcePart, sourceIndex, snapRectangle, tabIndex);
		return dropTarget;
	}

	/**
	 * Class implementing methods required by drop targets. Drop target use when the drop occur on one of the thumbnail of the folder.
	 */
	protected class DropTarget implements IDropTarget {

		int cursor = SWT.CENTER;

		private TabFolderPart sourcePart;

		private Rectangle snapRectangle;

		private int targetIndex;

		private int sourceIndex;

		/**
		 * Constructor. targetPart is the current folder.
		 * 
		 * @param sourcePart
		 *        The sourcePart of the drag
		 * @param sourceIndex
		 *        Index of the tab from where the drop occur
		 * @param snapRectangle
		 *        the drop area.
		 * @param targetIndex
		 *        Index of the tab where the drop occur
		 */
		public DropTarget(TabFolderPart sourcePart, int sourceIndex, Rectangle snapRectangle, int targetIndex) {
			this.sourceIndex = sourceIndex;
			this.targetIndex = targetIndex;
			this.sourcePart = sourcePart;
			this.snapRectangle = snapRectangle;
		}

		public void setTarget(TabFolderPart sourcePart, int sourceIndex, Rectangle snapRectangle, int targetIndex) {
			this.sourceIndex = sourceIndex;
			this.targetIndex = targetIndex;
			this.sourcePart = sourcePart;
			this.snapRectangle = snapRectangle;
		}

		/**
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#drop()
		 */
		public void drop() {

			// move from a folder to another
			if(sourcePart == TabFolderPart.this) {
				// move inside the same folder
				getContentProvider().movePage(sourcePart.getPartModel(), sourceIndex, targetIndex);
			} else { // move between folder
				getContentProvider().movePage(sourcePart.getPartModel(), sourceIndex, TabFolderPart.this.getPartModel(), targetIndex);
			}
		}

		/**
		 * Return the cursor used during drag.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#getCursor()
		 */
		public Cursor getCursor() {
			// System.out.println(TabFolderPart.this.getClass().getSimpleName() + ".getCursor()-" + count++);
			return DragCursors.getCursor(DragCursors.positionToDragCursor(cursor));

		}

		public Rectangle getSnapRectangle() {
			// System.out.println(TabFolderPart.this.getClass().getSimpleName() + ".getSnapRectangle()-" + count);
			return snapRectangle;
		}

	}

	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged. The node can be reattached with reparent().
	 * 
	 * @see
	 * @return the parent
	 */
	@Override
	public void orphan() {
		// orphan only if we are in UNCHANGED state
		if(garbageState == GarbageState.UNVISITED) {
			garbageState = GarbageState.ORPHANED;
			parent = null;

		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.internal.AbstractPart#getGarbageState()
	 * 
	 * @return
	 */
	@Override
	public GarbageState getGarbageState() {
		return garbageState;
	}

	/**
	 * Change the parent of this method.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.infra.core.sasheditor.sash.ITilePart)
	 */
	@Override
	public void reparent(IPanelParent newParent, Composite swtParent) {
		parent = newParent;
		// Create control if needed
		// This can happen if the TilePart is just created after a refresh
		// if(getControl() == null)
		// {
		// return;
		// // createContainer(parent.getControl());
		// }
		// Reparent the control
		assert (getControl() != null);
		// getControl().setParent(newParent.getControl()) ;
		getControl().setParent(swtParent);
		garbageState = GarbageState.REPARENTED;
	}

	/**
	 * Return true if the Part is for the specified real model. Return false otherwise.
	 * 
	 * @param realModel
	 *        The raw model to check
	 * @return
	 */
	@Override
	public boolean isPartFor(Object realModel) {
		return getRawModel() == realModel;
	}

	/**
	 * Get the raw model associated to this part.
	 * 
	 * @return
	 */
	protected Object getRawModel() {
		return rawModel;
	}

	/**
	 * Refresh the tab of this page (I.e the name and icon in the tab).
	 * 
	 * @param page
	 *        The page to be refreshed
	 */
	public void refreshPageTab(PagePart page) {
		TabItemPart itemPart = currentTabItems.getByPagePart(page);
		if(itemPart == null) {
			return;
		}

		itemPart.refreshTabDecorations();
	}

	/**
	 * Synchronize the TabFolder with the models.
	 * The Tabs order is fixed and can't be moved. So, we move the associated ITilepart if needed.
	 * For each existing Tab, compare its model and the requested model. Synchronize if necessary.
	 * If there is more new model, add new Tab
	 * If there is less newModel, remove unused Tabs.
	 * 
	 * @param partLists
	 */
	@Override
	public void synchronize2(PartLists partLists) {

		// get list of model to be displayed. This is a list of Object.
		List<Object> newModels = (List<Object>)partModel.getChildren();

		// Disable redraw
		CTabFolder folder = getTabFolder();
		folder.setRedraw(false);
		// Remember active page
		int activePageIndex = getActivePage();

		// Iterate over the minimum common size
		// Synchronize each tab with the requested model
		int minSize = Math.min(newModels.size(), currentTabItems.size());
		int index;
		for(index = 0; index < minSize; index++) {
			Object curModel = newModels.get(index);
			TabItemPart curTab = currentTabItems.get(index);
			if(!curTab.isTabItemFor(curModel)) {
				resetTabItem(curTab, partLists, curModel);
				// end
				activePageIndex = index;
			} else {
				// Change curTab state
				curTab.getChildPart().unchanged();
			}
		}

		// Check for extra tabs or extra models
		if(index < newModels.size()) {
			// There is extra models, add new tabs
			for(int i = index; i < newModels.size(); i++) {
				Object curModel = newModels.get(i);
				// Create a new TabItem associated to the curModel.
				createTabItem(partLists, curModel, i);
				// end
			}
			// Set the last as active
			activePageIndex = newModels.size() - 1;
		} else if(index < currentTabItems.size()) {
			// There is too much tabs, remove them
			List<TabItemPart> toRemove = new ArrayList<TabItemPart>();
			// Collect tab to be removed
			for(int i = index; i < currentTabItems.size(); i++) {
				TabItemPart curTab = currentTabItems.get(i);
				toRemove.add(curTab);
			}
			// do remove
			for(TabItemPart curTab : toRemove) {
				// removeTab(curTab)
				removeTabItem(curTab);
				// end
			}
			// Set the active page as the last part if needed
			if(activePageIndex >= currentTabItems.size()) {
				activePageIndex = currentTabItems.size() - 1;
			}
		}


		folder.setRedraw(true);
		//		folder.setSelection(activePageIndex);
		folder.redraw();

		if(activePageIndex >= 0) {
			//			System.err.println("setActivePage(" + activePageIndex + ") : " + this);
			// Set the activeTab has visible.
			// Do it here because otherwise the active tab could be not visible.
			// This come from an undefined bug setting the tab.isVisible(false) in some case.
			folder.getItem(activePageIndex).getControl().setVisible(true);
			setSelection(activePageIndex);
		} else {
			// Check if there is item in the CTabFolder.
			// If true, we have a trouble
			if(getTabFolder().getItemCount() > 0) {
				//			  System.err.println("Active page not set while synchronizing !");
				// We have items, but none is selected.
				// Select the first one.
				if(getTabFolder().getSelectionIndex() < 0) {
					setSelection(0);
				}
			}
		}
		//		folder.update();
		//		folder.showSelection();

	}

	/**
	 * Remove the specified tabItem.
	 * Also call appropriate remove() method on the tabItem.
	 * 
	 * @param curTab
	 */
	private void removeTabItem(TabItemPart tabItem) {
		currentTabItems.remove(tabItem);
		tabItem.remove();
	}

	/**
	 * Create a new TabItem associated to the part corresponding to the specified newModel.
	 * The TabItem is created at the specified index.
	 * The associated parts is searched in the existingParts or created if none is found.
	 * 
	 * @param existingParts
	 *        List of existing parts.
	 * @param newModel
	 * @param index
	 * @param i
	 */
	private void createTabItem(PartLists existingParts, Object newModel, int index) {
		TabItemPart newTab = null;

		PagePart modelPart = existingParts.findPagePartFor(newModel);
		if(modelPart != null) {
			// A part already exist for the model. Use it.
			modelPart.reparent(this);
			newTab = new TabItemPart(this, modelPart, index);
		} else {
			// No part found, create one
			modelPart = createChildPart(newModel);
			if(modelPart != null) {
				existingParts.addCreatedPage(modelPart);
				// Attach it to the tabItem
				newTab = new TabItemPart(this, modelPart, index);
			}
		}

		// Add to the list of items.
		if(newTab != null) {
			currentTabItems.add(index, newTab);
		}
	}

	//	/**
	//	 * Create a new TabItem and associated part corresponding to the specified newModel.
	//	 * The TabItem is created at the specified index.
	//	 * The associated parts is created.
	//	 * 
	//	 * @param existingParts List of existing parts.
	//	 * @param newModel
	//	 * @param index
	//	 * @param i
	//	 */
	//	private void createTabItem(Object newModel, int index) {
	//		TabItemPart newTab;
	//
	//		PagePart modelPart = createChildPart( newModel );
	//		// Attach it to the tabItem
	//		newTab = new TabItemPart(this, modelPart, index);
	//
	//		// Add to the list of items.
	//		currentTabItems.add(index, newTab);
	//	}

	/**
	 * Instruct the specified tabItem to use the new model. Check if a part already exist for the model
	 * and use it if any. Otherwise create a new Part.
	 * 
	 * @param curTab
	 * @param existingParts
	 * @param newModel
	 */
	private void resetTabItem(TabItemPart tabItem, PartLists existingParts, Object newModel) {

		PagePart modelPart = existingParts.findPagePartFor(newModel);
		if(modelPart != null) {
			// A part already exist for the model. Use it.
			tabItem.resetChild(modelPart);
		} else {
			// No part found, create one
			modelPart = createChildPart(newModel);
			if(modelPart == null) {
				System.out.println("break");
			}
			existingParts.addCreatedPage(modelPart);
			// Attach it to the tabItem
			tabItem.resetChild(modelPart);
		}
	}

	/**
	 * Factory method to create a new Part for the specified newModel.
	 * The method should always return a valid Part. In case of error while creating the requested part,
	 * the method should return a default part, maybe showing the encountered error.
	 * The control for the child is created.
	 * 
	 * @param newModel
	 * @return The new part
	 */
	private PagePart createChildPart(Object newModel) {

		// Create the child PartModel. Delegate creation to this part PartModel.
		IPageModel partModel = getPartModel().createChildSashModel(newModel);

		if(partModel != null) {
			// Delegate part creation to the container. This allow the container to provide appropriate 
			// objects not available from the part.
			PagePart newPart = getSashWindowContainer().createPagePart(this, partModel, newModel);
			// Create control.
			// Fire events before and after
			getSashWindowContainer().getLifeCycleEventProvider().firePageAboutToBeOpenedEvent(newPart);
			newPart.createPartControl(getControl());
			getSashWindowContainer().getLifeCycleEventProvider().firePageOpenedEvent(newPart);

			return newPart;
		}
		// Use exception ?
		return null;
	}

	/**
	 * Show tab status
	 * 
	 * @debug This is fo debug purpose.
	 * @param msg
	 */
	private void showTabs(String msg) {
		System.out.println("------- " + msg);
		// Show items
		CTabFolder folder = getTabFolder();
		CTabItem items[] = folder.getItems();
		System.out.printf("sel.index %2d :\n", folder.getSelectionIndex());
		System.out.printf("items %2d :", folder.getItemCount());
		for(CTabItem item : items) {
			System.out.printf("%10s |", item.getControl());
		}
		System.out.println();

		System.out.printf("it.dispose:");
		for(CTabItem item : items) {
			System.out.printf("%10b |", item.getControl().isDisposed());
		}
		System.out.println();

		System.out.printf("it.ctrl.vis:");
		for(CTabItem item : items) {
			System.out.printf("%10s |", item.getControl().isVisible());
		}
		System.out.println();

		//
		System.out.printf("it.ctrl   :");
		for(CTabItem item : items) {
			System.out.printf("%10s |", item.getControl());
		}
		System.out.println();

		//
		//		System.out.printf("tabs.ctrl :"  );
		//		for( TabItemPart tab : currentModels)
		//		{
		//			System.out.printf( "%10s |", tab.childPart.getControl());
		//		}
		//		System.out.println();

		// 
		//		System.out.printf("tab.editor:"  );
		//		for( TabItemPart tab : currentModels)
		//		{
		//			System.out.printf( "%10s |", tab.childPart.getIEditorPart());
		//		}
		//		System.out.println();

		//
		System.out.printf("tabs %2d :", currentTabItems.size());
		for(TabItemPart tab : currentTabItems) {
			System.out.printf("%10s |", tab);
		}
		System.out.println();

	}

	/**
	 * Show tile status.
	 */
	protected void showStatus() {
		//		System.out.println( "tabfolder[" + currentModels.size()  + "]:"
		//				+ ", disposed=" + getCTabFolder().isDisposed()
		//				+ ", visible=" + getCTabFolder().isVisible()
		//				+ ", garbState=" + garbageState
		//				+ ", " + this);

		CTabFolder ctrl = getTabFolder();
		System.out.printf("tabfolder[%2d]: disposed=%-5b, visible=%-5b, garbState=%-10s, %s\n", currentTabItems.size(), ctrl.isDisposed(), (ctrl.isDisposed() ? false : getTabFolder().isVisible()), garbageState, this);
	}

	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	@Override
	public boolean visit(IPartVisitor visitor) {
		return visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile.
	 * 
	 * @param visitor
	 */
	public boolean visitChildren(IPartVisitor visitor) {

		for(TabItemPart child : currentTabItems) {
			if(!child.visit(visitor)) {
				return false;
			}
		}
		// All children have accepter the visit, continue visiting.
		return true;
	}


	/**
	 * Collection of tabpart.
	 * Add miscelenaous methods.
	 * 
	 * @author dumoulin
	 * 
	 */
	@SuppressWarnings("serial")
	public class TabPartList extends ArrayList<TabItemPart> {

		/**
		 * Does the list contains a part with the specified model.
		 * 
		 * @param model
		 * @return
		 */
		public boolean containsModel(Object model) {
			return indexOfModel(model) >= 0;
		}

		/**
		 * Returns the index of the first occurrence of the specified element
		 * in this list, or -1 if this list does not contain the element.
		 * More formally, returns the lowest index <tt>i</tt> such that <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
		 * or -1 if there is no such index.
		 */
		public int indexOfModel(Object o) {
			if(o == null) {
				for(int i = 0; i < size(); i++) {
					if(get(i) == null) {
						return i;
					}
				}
			} else {
				for(int i = 0; i < size(); i++) {
					if(o.equals(get(i).getChildPart().getRawModel())) {
						return i;
					}
				}
			}
			return -1;
		}


		/**
		 * Get the TabPart by its model.
		 * 
		 * @param model
		 * @return
		 */
		public TabItemPart getByModel(Object model) {
			return get(indexOfModel(model));
		}

		/**
		 * Get the TabPart by its PagePart.
		 * 
		 * @param page
		 * @return
		 */
		public TabItemPart getByPagePart(PagePart page) {
			return get(indexOfModel(page.getRawModel()));
		}

	}

	/**
	 * Track the mouse for flying over the tabs and show tooltip.
	 * Show the tooltip when the mouse stop over a tab.
	 * Disable the tooltip if mouse is clicked.
	 * Reenable the tooltip when exiting the tab.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class MouseHoverTracker {

		/**
		 * Control for which a mouse tracker is requested.
		 */
		private Control control;

		/** Tooltip manager showing tooltip */
		private ImageToolTipManager toolTipManager;

		/** Anonymous mouse tracker */
		MouseTrackListener mouseTrackListener = new MouseTrackListener() {

			private int count = 0;

			public void mouseEnter(MouseEvent e) {
				//				System.out.println("MouseEnter()" + count++);

			}

			public void mouseExit(MouseEvent e) {
				//				System.out.println("MouseExit()" + count++);
				toolTipManager.closeToolTip();
			}

			public void mouseHover(MouseEvent e) {
				CTabFolder folder = getTabFolder();
				//				Point pt = folder.toDisplay(e.x, e.y);
				Point pt = new Point(e.x, e.y);
				CTabItem item = folder.getItem(pt);
				int index = pTabFolder.getItemIndex(pt);
				if(index == -1) {
					toolTipManager.closeToolTip();
					return;
				}

				PagePart part = currentTabItems.get(index).getChildPart();
				//								System.out.println("MouseHover(" + e.widget 
				//										+ ", part=" + part.getPageTitle()
				//										+ ", item=" + item
				//										+ ") - " + count++);
				// TODO move it away 
				//toolTipManager.showToolTip(item.getBounds(), part.getControl(), pt);
				toolTipManager.showToolTip(part, item.getBounds(), pt);
			}


		};

		/**
		 * Listener on mouse clicked.
		 * Used to disable the current tooltip.
		 */
		private Listener mouseClickedListener = new Listener() {

			private int count = 0;

			public void handleEvent(Event event) {
				switch(event.type) {
				case SWT.MouseUp:
					//					System.out.println("MouseUp()" + count++);
					toolTipManager.disableToolTip();
					break;
				}
			}
		};

		/**
		 * Build a tracker for the specified control.
		 * Constructor.
		 * 
		 * @param control
		 */
		public MouseHoverTracker(Control control, ImageToolTipManager toolTipManager) {
			this.control = control;
			this.toolTipManager = toolTipManager;
			activate();
		}

		public void activate() {
			control.addMouseTrackListener(mouseTrackListener);
			control.addListener(SWT.MouseUp, mouseClickedListener);
		}

		public void deactivate() {
			control.removeMouseTrackListener(mouseTrackListener);
			control.removeListener(SWT.MouseUp, mouseClickedListener);
			toolTipManager.dispose();
		}


	}

}
