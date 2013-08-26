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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy.PresentationUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.internal.dnd.DragUtil;

/**
 * Papyrus wrapper for CTabFolder.
 * Provides miscelaneous methods for dragging.
 * Provides different fireEvents for: menu detected, pageChange, itemClosed.
 * TODO : add listeners mechanism to listen on events ?
 */
@SuppressWarnings("restriction")
public class PTabFolder {

	/**
	 * The underlying tabfolder.
	 */
	protected CTabFolder tabFolder;

	/**
	 * This object allows to register listeners on event from this class.
	 */
	private EventsManager listenersManager = new EventsManager();

	private Listener dragListener = new Listener() {

		public void handleEvent(Event e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			handleDragStarted(globalPos, e);
		}
	};

	/**
	 * Listener on control activated event.
	 * This event is used to set the tab as the active page.
	 */
	private Listener activateListener = new Listener() {

		public void handleEvent(Event e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			handleFolderReselected(globalPos, null);
		}
	};

	/**
	 * Listen on menu detect.
	 * The event is forwarded.
	 * TODO [20100417] deprecated ?
	 */
	private MenuDetectListener menuDetectListener = new MenuDetectListener() {

		public void menuDetected(MenuDetectEvent e) {
			//			Point globalPos = ((Control) e.widget).toDisplay(e.x, e.y);
			Point globalPos = new Point(e.x, e.y);
			handleMenuDetect(globalPos, e);
		}

	};

	/**
	 * Listener on Mouse actions on tabs.
	 * This event is used to send mouse double click events.
	 */
	private MouseListener mouseListener = new MouseListener() {

		public void mouseUp(MouseEvent e) {
			handleMouseUp(e);
		}

		public void mouseDown(MouseEvent e) {
			handleMouseDown(e);
		}

		public void mouseDoubleClick(MouseEvent e) {
			handleMouseDoubleClick(e);
		}

	};

	/**
	 * Get the underlying control.
	 */
	public Composite getControl() {
		return tabFolder;
	}

	/**
	 * Create the corresponding SWT Control
	 */
	public void createPartControl(Composite parent) {
		tabFolder = createContainer(parent);

		// Attach listeners
		attachListeners(tabFolder, false);
	}

	/**
	 * Creates an empty container. Creates a CTabFolder with no style bits set, and hooks a selection listener which calls <code>pageChange()</code>
	 * whenever the selected tab changes.
	 * 
	 * @param parent
	 *        The composite in which the container tab folder should be created; must not be <code>null</code>.
	 * @return a new container
	 */
	private CTabFolder createContainer(Composite parent) {
		// use SWT.FLAT style so that an extra 1 pixel border is not reserved
		// inside the folder
		parent.setLayout(new FillLayout());
		final CTabFolder newContainer = new CTabFolder(parent, SWT.BOTTOM | SWT.FLAT | SWT.CLOSE);

		// TODO Move listener init in appropriate method.
		newContainer.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int newPageIndex = newContainer.indexOf((CTabItem)e.item);
				firePageChange(newPageIndex);
			}
		});

		// Test for the close icon. Need style=SWT.CLOSE
		// addCTabFolderListener is required :-(
		newContainer.setUnselectedCloseVisible(false);
		newContainer.addCTabFolder2Listener(new CTabFolder2Adapter() {

			@Override
			public void close(CTabFolderEvent event) {
				int pageIndex = newContainer.indexOf((CTabItem)event.item);
				event.doit = false;
				fireItemClosed(event, pageIndex);
			}
		});
		return newContainer;
	}

	/**
	 * Dispose internal resources.
	 */
	public void dispose() {
		if(tabFolder.isDisposed()) {
			return;
		}

		detachListeners(tabFolder);
		tabFolder.dispose();
	}

	/**
	 * Copied from org.eclipse.ui.internal.presentations.util.AbstractTabFolder.attachListeners(Control, boolean)
	 */
	protected void attachListeners(CTabFolder theControl, boolean recursive) {

		// Listen to menu event
		theControl.addMenuDetectListener(menuDetectListener);
		// Listen to drag event
		PresentationUtil.addDragListener(theControl, dragListener);

		theControl.addListener(SWT.Activate, activateListener);

		// mouse double click
		theControl.addMouseListener(mouseListener);

	}

	/**
	 * Copied from org.eclipse.ui.internal.presentations.util.AbstractTabFolder.detachListeners(Control, boolean)
	 */
	private void detachListeners(Control theControl) {
		theControl.removeMenuDetectListener(menuDetectListener);
		//
		PresentationUtil.removeDragListener(theControl, dragListener);
		// theControl.removeDragDetectListener(dragDetectListener);
		//		theControl.removeListener(SWT.MouseUp, mouseUpListener);
		theControl.removeListener(SWT.Activate, activateListener);
		// mouse double click
		theControl.removeMouseListener(mouseListener);
	}

	/**
	 * The context menu event has been fired, handle it.
	 * Actually, it is forwarded to the {@link EventsManager}.
	 * 
	 * @param displayPos
	 * @param e
	 */
	protected void handleContextMenu(Point displayPos, Event e) {

		CTabItem tab = getItem(displayPos);
		listenersManager.fireContextMenuEvent(tab, e);
	}

	/**
	 * Called when drag start. From here, DragUtil.performDrag() is called, which start the
	 * dragging process. DragUtil.performDrag() will contains the tabFolder or the dragged tab.
	 */
	protected void handleDragStarted(Point displayPos, Event e) {

		CTabItem tab = getItem(displayPos);

		boolean allowSnapping = true;
		Rectangle sourceBounds = Geometry.toDisplay(tabFolder.getParent(), tabFolder.getBounds());
		if(tab == null) { // drag folder
			DragUtil.performDrag(tabFolder, sourceBounds, displayPos, allowSnapping);
		} else { // drag item
			DragUtil.performDrag(tab, sourceBounds, displayPos, allowSnapping);
		}
	}

	/**
	 * Handle menu detect.
	 * TODO Connect menu staff here.
	 * 
	 * @param displayPos
	 * @param e
	 */
	private void handleMenuDetect(Point displayPos, MenuDetectEvent e) {

		//		if(isOnBorder(displayPos)) {
		//			return;
		//		}

		CTabItem tab = getItem(displayPos);
		listenersManager.fireMenuDetectEvent(tab, e);
	}

	/**
	 * Handle folder reselected.
	 * A folder is reselected by clicking on the active tabs, on the page or on the empty tabs area.
	 * In each case a PageChangeEvent is fired.
	 * When mouse click happen on the empty area, or on the page, the last selected tabs is used.
	 * Used to switch the Active tab when user click on already opened tabs.
	 * 
	 * @param displayPos
	 * @param e
	 */
	private void handleFolderReselected(Point displayPos, MouseEvent e) {
		int itemIndex = getItemIndex(displayPos);
		// If click is not from an item, it can come from a click on border.
		// restore the last selected item
		if(itemIndex == -1) {
			itemIndex = tabFolder.getSelectionIndex();
		}
		if(itemIndex == -1) {
			return;
		}

		listenersManager.firePageChange(itemIndex);
	}

	/**
	 * A mouse double click is detected on the tabs area.
	 * Fire the event to appropriate listeners.
	 * 
	 * @param globalPos
	 * @param e
	 */
	private void handleMouseDoubleClick(MouseEvent e) {

		// Get the indes. It can be <0 if the double click occurs in the
		// area with no tabs.
		Point displayPos = new Point(e.x, e.y);
		int itemIndex = getItemIndex(displayPos);
		listenersManager.fireMouseDoubleClick(itemIndex, e);
	}

	/**
	 * A mouse double click is detected on the tabs area.
	 * Fire the event to appropriate listeners.
	 * 
	 * @param globalPos
	 * @param e
	 */
	private void handleMouseUp(MouseEvent e) {

		// Get the index. It can be <0 if the double click occurs in the
		// area with no tabs.
		Point displayPos = new Point(e.x, e.y);
		int itemIndex = getItemIndex(displayPos);
		listenersManager.fireMouseUp(itemIndex, e);
	}

	/**
	 * A mouse double click is detected on the tabs area.
	 * Fire the event to appropriate listeners.
	 * 
	 * @param globalPos
	 * @param e
	 */
	private void handleMouseDown(MouseEvent e) {

		// Get the indes. It can be <0 if the double click occurs in the
		// area with no tabs.
		Point displayPos = new Point(e.x, e.y);
		int itemIndex = getItemIndex(displayPos);
		listenersManager.fireMouseDown(itemIndex, e);
	}


	/**
	 * Returns true iff the given point is on the border of the folder. By default, double-clicking,
	 * context menus, and drag/drop are disabled on the folder's border.
	 * 
	 * @param toTest
	 *        a point (display coordinates)
	 * @return true iff the point is on the presentation border
	 * @since 3.1
	 */
	private boolean isOnBorder(Point toTest) {
		Control content = getControl();
		if(content != null) {
			Rectangle displayBounds = DragUtil.getDisplayBounds(content);

			if(tabFolder.getTabPosition() == SWT.TOP) {
				return toTest.y >= displayBounds.y;
			}

			if(toTest.y >= displayBounds.y && toTest.y < displayBounds.y + displayBounds.height) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Get the item under the specified position.
	 */
	public CTabItem getItem(Point toFind) {
		CTabItem[] items = tabFolder.getItems();

		for(CTabItem item : items) {
			if(getItemBounds(item).contains(toFind)) {
				return item;
			}
		}

		return null;
	}

	/**
	 * Get the index of the item at the specified mouse position
	 * 
	 * @param pt
	 * @return
	 */
	public int getItemIndex(Point pt) {
		//Fix for Bug 414816: If we just closed the last tab of a folder, the folder is disposed. Return -1
		if(tabFolder.isDisposed()) {
			return -1;
		}
		//

		CTabItem item = tabFolder.getItem(pt);
		if(item == null) {
			return -1;
		}
		return getItemIndex(item);
	}

	/**
	 * Get the rectangle bounding the item, in the parent coordinates. Utility method. Can be moved somewhere else.
	 */
	public Rectangle getItemBounds(CTabItem item) {
		return Geometry.toDisplay(item.getParent(), item.getBounds());
	}

	/**
	 * Fire a page closed event. This event is fired when the close item is pressed. The item is not closed yet. By default, the item is closed after
	 * the event. The item is not closed if event.doit is
	 * set to false.
	 * 
	 */
	protected void fireItemClosed(CTabFolderEvent event, int pageIndex) {
		listenersManager.fireItemClosed(event, pageIndex);

	}

	/**
	 * Fire a PageChangeEvent.
	 */
	protected void firePageChange(int newPageIndex) {
		listenersManager.firePageChange(newPageIndex);
	}

	/**
	 * @return the tabFolder
	 */
	public CTabFolder getTabFolder() {
		return tabFolder;
	}

	/**
	 * Get bounds of the tabs area in display coordinate.
	 */
	public Rectangle getTabArea() {
		Rectangle bounds = DragUtil.getDisplayBounds(tabFolder);
		//
		if(tabFolder.getTabPosition() == SWT.TOP) {
			bounds.height = tabFolder.getTabHeight();
		} else { // bottom
			bounds.y = bounds.y + bounds.height - tabFolder.getTabHeight();
			bounds.height = tabFolder.getTabHeight();
		}

		return bounds;
	}

	/**
	 * Get the index of the draggedObject
	 * 
	 * @param draggedObject
	 *        draggedObject should be of type CTabFolder or CTabItem (as provided by handleDragStarted())
	 */
	static public int getDraggedObjectTabIndex(Object draggedObject) {
		if(draggedObject instanceof CTabItem) {
			CTabItem item = (CTabItem)draggedObject;
			int index = getItemIndex(item);
			return index;
		} else if(draggedObject instanceof CTabFolder) {
			return -1;
		}

		return -2;
	}

	/**
	 * Get the item index or -1 if not found.
	 */
	static private int getItemIndex(CTabItem item) {
		CTabItem[] items = item.getParent().getItems();

		for(int i = 0; i < items.length; i++) {
			CTabItem cur = items[i];

			if(cur == item) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Get the event manager.
	 * The event manager can be used to listen to events.
	 * 
	 * @return
	 */
	public EventsManager getEventManager() {
		return listenersManager;
	}

	/**
	 * This interface allows to listen on events from the CTabFolder.
	 * 
	 * 
	 * @author dumoulin
	 * 
	 */
	public interface IPTabFolderListener {

		/**
		 * 
		 * @param tab
		 * @param event
		 */
		public void menuDetectEvent(CTabItem tab, MenuDetectEvent event);

		public void contextMenuDetectEvent(CTabItem tab, Event event);

		public void itemClosedEvent(CTabFolderEvent event, int pageIndex);

		public void pageChangeEvent(int newPageIndex);

		public void mouseDoubleClickEvent(int itemIndex, MouseEvent e);

		public void mouseUpEvent(int itemIndex, MouseEvent e);

		public void mouseDownEvent(int itemIndex, MouseEvent e);
	}

	/**
	 * This class maintains a list of listeners (IPTabFolderListener). It allows to
	 * fire events on all registered listeners.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class EventsManager {

		/**
		 * List of event listeners.
		 */
		Set<IPTabFolderListener> listeners = new HashSet<IPTabFolderListener>();

		/**
		 * Add a listener
		 * 
		 * @param listener
		 */
		public void addListener(IPTabFolderListener listener) {
			listeners.add(listener);
		}

		/**
		 * Remove a listener
		 * 
		 * @param listener
		 */
		public void removeListener(IPTabFolderListener listener) {
			listeners.remove(listener);
		}

		/**
		 * @param tab
		 * @param e
		 */
		public void fireContextMenuEvent(CTabItem tab, Event event) {
			for(IPTabFolderListener cur : listeners) {
				cur.contextMenuDetectEvent(tab, event);
			}
		}

		/**
		 * @param event
		 * @param pageIndex
		 */
		private void fireItemClosed(CTabFolderEvent event, int pageIndex) {
			for(IPTabFolderListener cur : listeners) {
				cur.itemClosedEvent(event, pageIndex);
			}
		}

		/**
		 * @param newPageIndex
		 */
		private void firePageChange(int newPageIndex) {
			for(IPTabFolderListener cur : listeners) {
				cur.pageChangeEvent(newPageIndex);
			}
		}

		/**
		 * Fire the event to all listeners
		 * 
		 * @param e
		 * @param tab
		 */
		private void fireMenuDetectEvent(CTabItem tab, MenuDetectEvent e) {
			for(IPTabFolderListener cur : listeners) {
				cur.menuDetectEvent(tab, e);
			}
		}

		/**
		 * 
		 * @param itemIndex
		 * @param e
		 */
		public void fireMouseDoubleClick(int itemIndex, MouseEvent e) {
			for(IPTabFolderListener cur : listeners) {
				cur.mouseDoubleClickEvent(itemIndex, e);
			}
		}

		/**
		 * 
		 * @param itemIndex
		 * @param e
		 */
		public void fireMouseUp(int itemIndex, MouseEvent e) {
			for(IPTabFolderListener cur : listeners) {
				cur.mouseUpEvent(itemIndex, e);
			}
		}

		/**
		 * 
		 * @param itemIndex
		 * @param e
		 */
		public void fireMouseDown(int itemIndex, MouseEvent e) {
			for(IPTabFolderListener cur : listeners) {
				cur.mouseDownEvent(itemIndex, e);
			}
		}

	}

}
