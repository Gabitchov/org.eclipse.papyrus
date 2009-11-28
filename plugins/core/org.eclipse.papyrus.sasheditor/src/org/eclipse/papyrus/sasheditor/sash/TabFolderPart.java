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
package org.eclipse.papyrus.sasheditor.sash;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorTile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
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
public class TabFolderPart<T> extends MultiPageEditorTile implements ITilePart<T> {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * The nestedPartManager (i.e. the main editor.)
	 */
	public IMultiEditorNestedPartManager nestedPartManager;

	/** Root Container of the Parts */
	protected TilePartContainer<T> parentPartContainer;

	/** Interface to the model */
	protected ITabFolderModel<T> model;

	/** The wrapper arround the CTabFolder. CTabFolder is duplicated in the parent class. */
	protected PTabFolder pTabFolder;

	/** The parent of this ITilePart */
	protected ITilePart<T> parent;

	/** Ordered set of currently shown diagrams (list of their models) TODO remove */
	protected TabPartList currentModels = new TabPartList();

	/** Garbage state used during refresh */
	protected GarbageState garbageState = GarbageState.CREATED;

	/** The drop target associated to this folderPart */
	private DropTarget dropTarget;

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
			System.out.println(this + ".drag()");
			return null;
		}
	};

	/**
	 * Listener on CTabFolder events.
	 */
	private PTabFolder.IPTabFolderListener cTabFolderEventListener = new PTabFolder.IPTabFolderListener() {

		public void contextMenuDetectEvent(CTabItem tab, Event event) {
			System.out.println("contextMenuDetect()");
		}

		public void itemClosedEvent(CTabFolderEvent event, int pageIndex) {
			System.out.println("itemClosedEvent()");
			parentPartContainer.getContainerModel().removeTab(model, pageIndex);
		}

		public void menuDetectEvent(CTabItem tab, MenuDetectEvent event) {
			System.out.println("menuDetectEvent()");
		}

		/**
		 * Listen to pageChange event, and propagate to TabFolderPart.
		 * 
		 * @param newPageIndex
		 */
		public void pageChangeEvent(int newPageIndex) {
			pageChange(newPageIndex);
		}

	};

	/**
	 * Interface used to access model.
	 */
	public interface ITabFolderModel<T> extends ITilePartNodeModel<T> {

		/**
		 * Get the models used to show editors in the folder.
		 * Models can be of any type for now.
		 * 
		 * @return
		 */
		List<Object> getChildModels();
	}

	/**
	 * Constructor.
	 * 
	 * @param nestedPartManager
	 */
	public TabFolderPart(TilePartContainer<T> tilesContainer, ITilePart<T> parent, ITabFolderModel<T> model) {
		this.parentPartContainer = tilesContainer;
		this.parent = parent;
		this.nestedPartManager = tilesContainer.getNestedPartManager();
		this.model = model;
	}

	/**
	 * Get the associated model.
	 */
	public ITabFolderModel<T> getModel() {
		return model;
	}

	/**
	 * Activate the part. Register as listener to required services.
	 */
	private void activate() {
		// Listen to page changes
		pTabFolder.getEventManager().addListener(cTabFolderEventListener);
	}

	/**
	 * Deactivate this part.
	 * Unregistered from required service. Do not dispose the part.
	 */
	private void deactivate() {
		// Listen to page changes
		pTabFolder.getEventManager().removeListener(cTabFolderEventListener);
	}

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(GarbageMaps<T> partMap) {
		partMap.getContainerPartMap().put(model.getNodeModel(), this);
		garbageState = ITilePart.GarbageState.UNCHANGED;

		for(TabPart<T> child : currentModels) {
			child.fillPartMap(partMap);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setParentPartContainer(org.eclipse.papyrus.sasheditor.sash.TilePartContainer)
	 */
	public void setParentPartContainer(TilePartContainer<T> rootContainer) {
		this.parentPartContainer = rootContainer;

	}

	/**
	 * Return the site of the main editor.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getSite()
	 */
	@Override
	public IEditorSite getEditorSite() {
		return nestedPartManager.getEditorSite();
	}

	/**
	 * Creates the control tree associated to this part.
	 * Create the control for this part, and eventually recursively call the method for the childs, if any.
	 * 
	 */
	@Override
	public void createPartControl(Composite parent) {

		createControl(parent);
		createPages();
		postCreatePartControl();
		// model.addChangeListener(modelListener);
		// model.activate();
		activate();
	}

	/**
	 * Create children of this folder, that is, pages.
	 * This is called the first time the control are created.
	 */
	private void createPages() {
		List<Object> newModels = model.getChildModels();
		// There is no childs.
		// Check if each model has an open pageEditor. If not, lookup or create the editor.
		for(Object curModel : newModels) {
			int index = newModels.indexOf(curModel);
			TabPart<T> curTab = new TabPart<T>(this, curModel);
			curTab.createPartControl(getCTabFolder(), index);
			currentModels.add(index, curTab);
		}

		// Set active page
		if(currentModels.size() > 0)
			setActivePage(0);
	}

	/**
	 * Create the control for this Part. Does not create children.
	 * This method is called by the parent after this folder is created.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		PTabFolder res = new PTabFolder();
		pTabFolder = res;
		res.createPartControl(parent);
		initDrag(res.getControl());
		// initialize super()
		setTabFolder(res.getTabFolder());
	}

	@Override
	protected void pageChange(int newPageIndex) {

		//		System.out.println(this.getClass().getSimpleName() + ".pageChange("+ newPageIndex +")");
		parentPartContainer.setActiveEditorTile(currentModels.get(newPageIndex).editorTile);

	}

	/**
	 * Dispose the TilePart and its controls.
	 * 
	 * @param isRecursive
	 *        No effect here. Children are always disposed.
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {
		// dispose local
		model.deactivate();

		//		super.dispose();
		// Also dispose this folder control.
		getControl().dispose();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorTile#dispose()
	 */
	public void dispose() {
		deactivate();
		dispose(true);
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
	protected CTabFolder getCTabFolder() {
		return pTabFolder.getTabFolder();
	}

	/**
	 * 
	 */
	@Override
	protected void firePropertyChange(int propertyId) {
		nestedPartManager.firePropertyChange(propertyId);

	}

	/**
	 * Return the swt Control associated to this part.
	 */
	public Composite getControl() {
		return getCTabFolder();
	}

	/**
	 * Return the part containing specified point. Normally return this part, because the caller has
	 * already determine that this contain the part.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.graphics.Point)
	 */
	public ITilePart<T> findPart(Point toFind) {
		return this;
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	public <U extends ITilePart<T>> U findPartAt(Point toFind, Class<U> expectedTileType) {

		if(expectedTileType == this.getClass())
			return (U)this;

		// ask current active tab
		TabPart<T> activeTabPart = getActiveTab();
		if(activeTabPart == null)
			return null;

		return getActiveTab().findPartAt(toFind, expectedTileType);
	}

	/**
	 * Get the currently active tab.
	 * 
	 * @return
	 */
	private TabPart<T> getActiveTab() {
		int index = getActivePage();
		if(index != -1) {
			return currentModels.get(index);
		}
		return null;
	}

	/**
	 * Find the part associated to the provided control.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.widgets.Control)
	 */
	public ITilePart<T> findPart(Object control) {
		if(getControl() == control)
			return this;

		// Check if it is one of the Item
		if(control instanceof CTabItem && ((CTabItem)control).getParent() == getControl())
			return this;

		// Ask childs TODO
		return null;
	}

	/**
	 * Returns the editor for the given page index. The page index must be valid.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @return the editor for the specified page, or <code>null</code> if the specified page was not created with
	 *         <code>addPage(IEditorPart,IEditorInput)</code>
	 */
	protected IEditorPart getEditor(int pageIndex) {
		return currentModels.get(pageIndex).getIEditorPart();
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IEditorPart</code> method returns whether the contents of any of this
	 * multi-page editor's nested editors have changed since the
	 * last save. Pages created with <code>addPage(Control)</code> are ignored.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @return <code>true</code> if any of the nested editors are dirty; <code>false</code> otherwise.
	 */
	public boolean isDirty() {
		// use nestedEditors to avoid SWT requests; see bug 12996
		for(TabPart<T> tabPart : currentModels) {
			if(tabPart.getIEditorPart().isDirty()) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart<T> sourcePart, Point position) {
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
	public IDropTarget createDropTarget(TabFolderPart<T> sourcePart, int sourceIndex, Rectangle snapRectangle, int tabIndex) {

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

		private TabFolderPart<T> sourcePart;

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
		public DropTarget(TabFolderPart<T> sourcePart, int sourceIndex, Rectangle snapRectangle, int targetIndex) {
			this.sourceIndex = sourceIndex;
			this.targetIndex = targetIndex;
			this.sourcePart = sourcePart;
			this.snapRectangle = snapRectangle;
		}

		public void setTarget(TabFolderPart<T> sourcePart, int sourceIndex, Rectangle snapRectangle, int targetIndex) {
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
			if(sourcePart == TabFolderPart.this) { // move inside the same folder
				parentPartContainer.getContainerModel().moveTab(sourcePart.getModel(), sourceIndex, targetIndex);
			} else { // move between folder
				parentPartContainer.getContainerModel().moveTab(sourcePart.getModel(), sourceIndex, TabFolderPart.this.getModel(), targetIndex);
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
	public void orphan() {
		// orphan only if we are in UNCHANGED state
		if(garbageState == ITilePart.GarbageState.UNCHANGED) {
			garbageState = ITilePart.GarbageState.ORPHANED;
			parent = null;
		}
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getGarbageState()
	 */
	public GarbageState getGarbageState() {
		return garbageState;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isOrphaned()
	 */
	public boolean isOrphaned() {
		return garbageState == ITilePart.GarbageState.ORPHANED;
	}

	/**
	 * Change the parent of this method.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.sasheditor.sash.ITilePart)
	 */
	public void reparent(ITilePart<T> newParent, Composite compositeParent) {
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
		getControl().setParent(compositeParent);
		garbageState = ITilePart.GarbageState.REPARENTED;
	}

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param realModel
	 * @return
	 */
	public boolean isTilePartFor(T realModel) {
		return model.getNodeModel() == realModel;
	}

	/**
	 * Synchronize the TabFolder with the models.
	 * The Tabs order is fixed and can't be moved. So, we move the associated ITilepart if needed.
	 * For each existing Tab, compare its model and the requested model. Synchronize if necessary.
	 * If their is more new model, add new Tab
	 * If their is less newModel, remove unused Tabs.
	 * 
	 * @param partMap
	 */
	public void synchronize2(GarbageMaps<T> partMap) {

		// get list of diagrams to be displayed. This is a list of Object.
		// We need a list of parts
		List<Object> newModels = model.getChildModels();

		// Disable redraw
		CTabFolder folder = getCTabFolder();
		folder.setRedraw(false);
		// Remember active page
		int activePageIndex = getActivePage();

		// Iterate over the minimum common size
		// Synchronize each tab with the requested model
		int minSize = Math.min(newModels.size(), currentModels.size());
		int index;
		for(index = 0; index < minSize; index++) {
			Object curModel = newModels.get(index);
			TabPart<T> curTab = currentModels.get(index);
			if(!curTab.isTilePartFor(curModel)) {
				curTab.synchronizeWith(curModel, partMap);
				activePageIndex = index;
			}
		}

		// Check for extra tabs or extra models
		if(index < newModels.size()) {
			// There is extra models, add new tabs
			for(int i = index; i < newModels.size(); i++) {
				Object curModel = newModels.get(i);
				TabPart<T> curTab = new TabPart<T>(this, curModel);
				curTab.createPartControl(getCTabFolder(), index, partMap);
				currentModels.add(i, curTab);
			}
			// Set the last as active
			activePageIndex = newModels.size() - 1;
		} else if(index < currentModels.size()) {
			// There is too much tabs, remove them
			List<TabPart<T>> toRemove = new ArrayList<TabPart<T>>();
			// Collect tab to be removed
			for(int i = index; i < currentModels.size(); i++) {
				TabPart<T> curTab = currentModels.get(i);
				toRemove.add(curTab);
			}
			// do remove
			for(TabPart<T> curTab : toRemove) {
				currentModels.remove(curTab);
				curTab.remove();
			}
			// Set the active page as the last part if needed
			if(activePageIndex >= currentModels.size())
				activePageIndex = currentModels.size() - 1;
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
			setActivePage(activePageIndex);
		} else
			System.err.println("Active page not set while synchronizing !");
		//		folder.update();
		//		folder.showSelection();

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
		CTabFolder folder = getCTabFolder();
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
		System.out.printf("tabs.ctrl :");
		for(TabPart<T> tab : currentModels) {
			System.out.printf("%10s |", tab.editorTile.getControl());
		}
		System.out.println();

		// 
		System.out.printf("tab.editor:");
		for(TabPart<T> tab : currentModels) {
			System.out.printf("%10s |", tab.editorTile.getIEditorPart());
		}
		System.out.println();

		//
		System.out.printf("tabs %2d :", currentModels.size());
		for(TabPart<T> tab : currentModels) {
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

		CTabFolder ctrl = getCTabFolder();
		System.out.printf("tabfolder[%2d]: disposed=%-5b, visible=%-5b, garbState=%-10s, %s\n"
				, currentModels.size(), ctrl.isDisposed(), (ctrl.isDisposed() ? false : getCTabFolder().isVisible()), garbageState, this);
	}

	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	public void visit(ITileVisitor visitor) {
		visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile.
	 * 
	 * @param visitor
	 */
	public void visitChildren(ITileVisitor visitor) {
		for(TabPart<T> child : currentModels) {
			child.visit(visitor);
		}
	}


	/**
	 * Collection of tabpart.
	 * Add miscelenaous methods.
	 * 
	 * @author dumoulin
	 * 
	 */
	@SuppressWarnings("serial")
	public class TabPartList extends ArrayList<TabPart<T>> {

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
				for(int i = 0; i < size(); i++)
					if(get(i) == null)
						return i;
			} else {
				for(int i = 0; i < size(); i++)
					if(o.equals(get(i).getModel()))
						return i;
			}
			return -1;
		}


		/**
		 * Get the TabPart by its model.
		 * 
		 * @param model
		 * @return
		 */
		public TabPart<T> getByModel(Object model) {
			return get(indexOfModel(model));
		}

	}
}
