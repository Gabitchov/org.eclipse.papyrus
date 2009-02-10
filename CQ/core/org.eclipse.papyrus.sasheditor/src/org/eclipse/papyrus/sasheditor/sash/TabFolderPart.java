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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorTile;
import org.eclipse.papyrus.sasheditor.gef.InstantiationException;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.DragCursors;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Tile drawing a tabfolder.
 * 
 * Extends MultiPageEditor to inherit methods implementations.
 */
public class TabFolderPart extends MultiPageEditorTile implements ITilePart {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/**
	 * The nestedPartManager (i.e. the main editor.)
	 */
	public IMultiEditorNestedPartManager nestedPartManager;

	/** Root Container of the Parts */
	protected TilePartContainer parentPartContainer;

	/** Interface to the model */
	protected ITabFolderModel model;

	/** The wrapper arround the CTabFolder. CTabFolder is duplicated in the parent class. */
	protected PTabFolder pTabFolder;

	/** The parent of this ITilePart */
	protected ITilePart parent;

	/** Ordered set of currently shown diagrams (list of their models) */
	protected List<Object> currentModels = new ArrayList<Object>();

	/** Garbage state used during refresh */
	protected GarbageState garbageState;

	private DropTarget dropTarget;

	IDragOverListener dragOverListener = new IDragOverListener() {

		/**
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDragOverListener#drag(org.eclipse.swt.widgets.Control, java.lang.Object, org.eclipse.swt.graphics.Point, org.eclipse.swt.graphics.Rectangle)
		 */
		public IDropTarget drag(Control currentControl, Object draggedObject, Point position, Rectangle dragRectangle) {
			// System.out.println(TabFolderPart.this.getClass().getSimpleName() + ".drag()");
			System.out.println(this + ".drag()");
			return null;
		}
	};

	/**
	 * Listener on model change. When model change, refresh the TilePart
	 */
	private ITilePart.IListener modelListener = new ITilePart.IListener() {

		public void notifyChanged(ITilePart.ITilePartNodeModel node) {
			refreshTabs();
		}

	};

	/**
	 * Interface used to access model.
	 */
	public interface ITabFolderModel extends ITilePartNodeModel {

		List<Object> getChildModels();
	}

	/**
	 * Constructor.
	 * 
	 * @param nestedPartManager
	 */
	public TabFolderPart(TilePartContainer tilesContainer, ITilePart parent, ITabFolderModel model) {
		this.parentPartContainer = tilesContainer;
		this.parent = parent;
		this.nestedPartManager = tilesContainer.getNestedPartManager();
		this.model = model;
	}

	/**
	 * Get the associated model.
	 */
	public ITabFolderModel getModel() {
		return model;
	}

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(PartMap partMap) {
		partMap.put(model.getNodeModel(), this);
		garbageState = ITilePart.GarbageState.UNCHANGED;

		// for( ITilePart child : currentModels)
		// {
		// child.fillPartMap(partMap);
		// }
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setParentPartContainer(org.eclipse.papyrus.sasheditor.sash.TilePartContainer)
	 */
	public void setParentPartContainer(TilePartContainer rootContainer) {
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
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorTile#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		super.createPartControl(parent);
		// model.addChangeListener(modelListener);
		// model.activate();
	}

	/**
	 * Create the control for this Part. Does not create children.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite pageContainer = createPageContainer(parent);
		setContainer(createContainer(pageContainer));
	}

	/**
	 * Dispose the TilePart and its controls.
	 * 
	 * @param isRecursive
	 *            No effect here. Children are always disposed.
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {
		// dispose local
		model.deactivate();
		model.removeChangeListener(modelListener);

		super.dispose();
		// Also dispose this folder control.
		getControl().dispose();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorTile#dispose()
	 */
	public void dispose() {
		dispose(true);
	}

	/**
	 * Creates the pages of the multi-page editor.
	 */
	@Override
	protected void createPages() {
		refreshTabs();
	}

	@Override
	protected CTabFolder createContainer(Composite parent) {
		PTabFolder res = new PTabFolder();
		pTabFolder = res;
		res.createPartControl(parent);
		initDrag(res.getControl());
		return res.getTabFolder();

	}

	/**
	 * 
	 */
	private void initDrag(Composite container) {
		DragUtil.addDragTarget(container, dragOverListener);
	}

	/**
	 * Refresh the tabs order. This method should be called after the model list is modified.
	 */
	public void refreshTabs() {
		// get list of diagrams to be displayed
		List<Object> newModels = model.getChildModels();

		// Check if each model has an open pageEditor. If not, create the editor.
		Iterator<Object> newIter = newModels.iterator();
		while (newIter.hasNext()) {
			Object model = newIter.next();
			if (!editorExistsFor(model)) { // create a new editor for the model
				addEditor(model);
			}
		}

		// If open editor count is the same has models count,
		// all models have an editor. So, end the refresh process.
		if (newModels.size() == getPageCount()) {
			// Reorder list
			refreshCTabFolderOrder(newModels);
			// Collections.copy(currentModels, newModels);
			return;
		}

		// There is some extra editors ! remove them.
		// remove extra editors : for each open editor, check if its model is in
		// the list of required models.
		List<Object> toBeRemoved = new ArrayList<Object>();
		Iterator<Object> currentIter = currentModels.iterator();
		while (currentIter.hasNext()) {
			Object model = currentIter.next();
			if (!newModels.contains(model)) { // remove editor
				toBeRemoved.add(model);
			}
		}

		// Remove editor from the editors displayed by the multi editor
		Iterator<Object> removeIter = toBeRemoved.iterator();
		while (removeIter.hasNext()) {
			Object model = removeIter.next();
			removeEditor(model);
		}

		// Reorder list
		refreshCTabFolderOrder(newModels);
		// Collections.copy(currentModels, newModels);
	}

	/**
	 * Move the specified model, and its associated tab, to the newIndex. After the operation, the model will have the requested index.
	 * 
	 * @param model
	 *            The model to move
	 * @param newIndex
	 *            Index where to move the model.
	 */
	private void moveModelTab(Object model, int newIndex) {
		CTabFolder folder = pTabFolder.getTabFolder();
		CTabItem items[] = folder.getItems();

		int oldIndex = currentModels.indexOf(model);
		Object targetModel = currentModels.get(newIndex);
		CTabItem oldItem = items[oldIndex];
		Object oldData = oldItem.getData();
		Control oldControl = oldItem.getControl();
		Image oldImage = oldItem.getImage();
		String oldText = oldItem.getText();

		CTabItem newItem = items[newIndex];
		// Swap old and new. First, disable redraw
		folder.setRedraw(false);

		oldItem.setControl(newItem.getControl());
		oldItem.setData(newItem.getData());
		oldItem.setImage(newItem.getImage());
		oldItem.setText(newItem.getText());

		newItem.setControl(oldControl);
		newItem.setData(oldData);
		newItem.setImage(oldImage);
		newItem.setText(oldText);

		// swap model in currentModel
		currentModels.set(newIndex, model);
		currentModels.set(oldIndex, targetModel);
		folder.setRedraw(true);
		folder.setSelection(newIndex);
		folder.redraw();

		setActivePage(newIndex);

	}

	/**
	 * Refresh the order of the item according to the currentModels.
	 */
	private void refreshCTabFolderOrder(List<Object> newModels) {
		assert (newModels.size() == currentModels.size()) : "lists size should be equals " + newModels.size() + "<->" + currentModels.size();

		for (int i = 0; i < newModels.size(); i++) {
			if (newModels.get(i) != currentModels.get(i)) { // swap
				moveModelTab(newModels.get(i), i);
			}
		}
	}

	/**
	 * @see org.eclipse.ui.part.MultiPageEditorPart#addPage(int, org.eclipse.ui.IEditorPart, org.eclipse.ui.IEditorInput)
	 */
	private int addPage(IEditorPart viewer, IEditorInput editorInput, Object model) throws PartInitException {
		int index = getPageCount();
		addPage(index, viewer, editorInput, model);
		return index;
	}

	/**
	 * @param index
	 * @param editor
	 * @param input
	 * @param model
	 * @throws PartInitException
	 */
	public void addPage(int index, IEditorPart editor, IEditorInput input, Object model) throws PartInitException {
		super.addPage(index, editor, input);
		currentModels.add(index, model);
	}

	/**
	 * Check if an editor exists for the specified model.
	 * 
	 * @param model
	 *            the diagram (model) that should be displayed
	 * @return <code>true</code> if the editor exists for this model
	 */
	private boolean editorExistsFor(Object model) {
		return currentModels.contains(model);
	}

	/**
	 * Removes the editor associated to the specified model.
	 * 
	 * @param model
	 *            the diagram (model) displayed in the editor
	 */
	private void removeEditor(Object model) {
		int index = currentModels.indexOf(model);
		removePage(index);
		currentModels.remove(index);
	}

	/**
	 * Add a new editor at the end of existing editors. First, create the editor, then add it to the tabs.
	 * 
	 * @param model
	 *            the diagram (model) to be displayed in the editor
	 */
	private void addEditor(Object model) {
		// Check if an editor already exists
		int index = currentModels.indexOf(model);
		if (index >= 0) {
			if (log.isLoggable(Level.FINE))
				log.fine("Editor already exists for '" + model + "'");
			return;
		}

		try {
			IEditorPart viewer = nestedPartManager.createPageEditor(model);

			// add page and set its name
			int editorIndex = addPage(viewer, nestedPartManager.getEditorInput(), model);
			// setPageText(editorIndex, viewer.getPartName());
			setPageText(editorIndex, viewer.getTitle());
			setPageImage(editorIndex, viewer.getTitleImage());

			// set active page
			setActivePage(editorIndex);

			// synchronise list of current models. First check for consistency.
			// assert( editorIndex == currentModels.size() );
			// currentModels.add(model);

		} catch (PartInitException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage()));
		} catch (InstantiationException e) {
			e.printStackTrace();
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage() + " skip."));
		} catch (MultiDiagramException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getLocalizedMessage() + " skip."));
		}
	}

	@Override
	protected void firePropertyChange(int propertyId) {
		nestedPartManager.firePropertyChange(propertyId);

	}

	public Composite getControl() {
		return getContainer();
	}

	/**
	 * Return the part containing specified point. Normaly return this part, because the caller has already determine that this contain the part.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.graphics.Point)
	 */
	public ITilePart findPart(Point toFind) {
		return this;
	}

	/**
	 * Find the part associated to the provided control.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.widgets.Control)
	 */
	public ITilePart findPart(Object control) {
		if (getControl() == control)
			return this;

		// Check if it is one of the Item
		if (control instanceof CTabItem && ((CTabItem) control).getParent() == getControl())
			return this;

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		// see org.eclipse.ui.internal.presentations.util.ReplaceDragHandler
		// Determine which tab we're currently dragging over
		CTabItem tabUnderPointer = pTabFolder.getItem(position);

		// Compute source tab index. If folder, index==-1
		int sourceIndex = pTabFolder.getDraggedObjectTabIndex(draggedObject);
		// This drop target only deals with tabs... if we're not dragging over
		// a tab, exit.
		if (tabUnderPointer == null) {
			Rectangle titleArea = pTabFolder.getTabArea();

			System.out.println("titleArea=" + titleArea + ", position=" + position);
			// If we're dragging over the title area, treat this as a drop in the last
			// tab position.
			if (titleArea.contains(position) && pTabFolder.getTabFolder().getItemCount() > 0) {
				int dragOverIndex = pTabFolder.getTabFolder().getItemCount();
				CTabItem lastTab = pTabFolder.getTabFolder().getItem(dragOverIndex - 1);

				// Can't drag to end unless you can see the end
				if (!lastTab.isShowing()) {
					return null;
				}

				// If we are unable to compute the bounds for this tab, then ignore the drop
				Rectangle lastTabBounds = lastTab.getBounds();
				if (lastTabBounds.isEmpty()) {
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
				if (closestSide == pTabFolder.getTabFolder().getTabPosition()) {
					return createDropTarget(sourcePart, sourceIndex, displayBounds, -1);
				}

				return null;
			}
		}

		if (!tabUnderPointer.isShowing()) {
			return null;
		}

		// Get thumbnail bounds in display coordinates
		Rectangle tabBounds = pTabFolder.getItemBounds(tabUnderPointer);

		if (tabBounds.isEmpty()) {
			return null;
		}

		return createDropTarget(sourcePart, sourceIndex, tabBounds, pTabFolder.getTabFolder().indexOf(tabUnderPointer));
	}

	/**
	 * Copied from org.eclipse.ui.internal.PartStack
	 */
	public IDropTarget createDropTarget(TabFolderPart sourcePart, int sourceIndex, Rectangle snapRectangle, int tabIndex) {

		if (dropTarget == null) {
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
		 *            The sourcePart of the drag
		 * @param sourceIndex
		 *            Index of the tab from where the drop occur
		 * @param snapRectangle
		 *            the drop area.
		 * @param targetIndex
		 *            Index of the tab where the drop occur
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
			System.out.println(TabFolderPart.this.getClass().getSimpleName() + ".drop(source=" + sourcePart + "sourceIndex=" + sourceIndex + ", target=" + TabFolderPart.this + ", targetIndex="
					+ targetIndex);

			// move from a folder to another
			if (sourcePart == TabFolderPart.this) { // move inside the same folder
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
		if (garbageState == ITilePart.GarbageState.UNCHANGED) {
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
	public void reparent(ITilePart newParent, Composite compositeParent) {
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
	 * @param model
	 * @return
	 */
	public boolean isTilePartFor(Object realModel) {
		return model.getNodeModel() == realModel;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#synchronize2(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void synchronize2(PartMap partMap) {

		// Check if control is set
		if (getControl() == null) { // This is the first time that the node is access.
			// locally initialize it.
			// createPartControl(parent.getControl());
			Composite pageContainer = createPageContainer(parent.getControl());
			setContainer(createContainer(pageContainer));
			// set the active page (page 0 by default), unless it has already been
			// done
			// postCreatePartControl();
		} else {

			refreshTabs();
		}
	}

}
