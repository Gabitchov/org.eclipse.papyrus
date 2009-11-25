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
package org.eclipse.papyrus.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.util.Geometry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.presentations.PresentationUtil;

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

	/**
	 * Listen on menu event.
	 */
	private Listener menuListener = new Listener() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			Point globalPos = new Point(event.x, event.y);
			handleContextMenu(globalPos, event);
		}
	};

	private Listener dragListener = new Listener() {

		public void handleEvent(Event e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			handleDragStarted(globalPos, e);
		}
	};

	private Listener mouseUpListener = new Listener() {

		public void handleEvent(Event e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			System.out.println("mouseUpListener(" + globalPos + ", event=" + e + ")");
		}
	};

	private Listener activateListener = new Listener() {

		public void handleEvent(Event e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			System.out.println("activateListener(" + globalPos + ", event=" + e + ")");
			handleFolderReselected(globalPos, null);
		}
	};

	private SelectionListener selectionListener = new SelectionListener() {

		public void widgetDefaultSelected(SelectionEvent e) {
			System.out.println("selectionListener(event=" + e + ")");
		}

		public void widgetSelected(SelectionEvent e) {
			System.out.println("selectionListener(event=" + e + ")");
		}

	};

	private TraverseListener traverseListener = new TraverseListener() {

		public void keyTraversed(TraverseEvent e) {
			//			System.out.println("traverseListener(event=" + e + ")");
		}

	};

	/**
	 * 
	 */
	private MouseListener mouseListener = new MouseListener() {

		public void mouseDoubleClick(MouseEvent e) {
			//			System.out.println("mouseDoubleClick(event=" + e + ")");
		}

		public void mouseDown(MouseEvent e) {
			Point globalPos = ((Control)e.widget).toDisplay(e.x, e.y);
			//			System.out.println("mouseDown(" + globalPos + ", event=" + e + ")");
			handleFolderReselected(globalPos, e);
		}

		public void mouseUp(MouseEvent e) {
			//			System.out.println("mousemouseUpListener(event=" + e + ")");
		}

	};


	//	private DragDetectListener dragDetectListener = new DragDetectListener() {
	//
	//		public void dragDetected(DragDetectEvent e) {
	//			Point globalPos = ((Control) e.widget).toDisplay(e.x, e.y);
	//			handleDragDetectStarted(globalPos, e);
	//		}
	//
	//	};

	private MenuDetectListener menuDetectListener = new MenuDetectListener() {

		public void menuDetected(MenuDetectEvent e) {
			//			Point globalPos = ((Control) e.widget).toDisplay(e.x, e.y);
			Point globalPos = new Point(e.x, e.y);
			System.out.println("menuDetected(" + globalPos + ")");
			handleMenuDetect(globalPos, e);
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
		if(tabFolder.isDisposed())
			return;

		detachListeners(tabFolder, false);
		tabFolder.dispose();
	}

	/**
	 * Copied from org.eclipse.ui.internal.presentations.util.AbstractTabFolder.attachListeners(Control, boolean)
	 */
	protected void attachListeners(CTabFolder theControl, boolean recursive) {

		// Both following methods listen to the same event. 
		// So use only one of them
		theControl.addListener(SWT.MenuDetect, menuListener);
		theControl.addMenuDetectListener(menuDetectListener);
		// Both listener works. Choose one
		PresentationUtil.addDragListener(theControl, dragListener);
		// theControl.addDragDetectListener(dragDetectListener);
		// Listen on mouse enter event.
		//		theControl.addListener(SWT.MouseEnter, mouseEnterListener);
		//		theControl.addListener(SWT.MouseUp, mouseUpListener);
		//		tabFolder.addSelectionListener(selectionListener);
		//		tabFolder.addTraverseListener(traverseListener);

		theControl.addMouseListener(mouseListener);
		theControl.addListener(SWT.Activate, activateListener);

		//		if (recursive && theControl instanceof Composite) {
		//			Composite composite = (Composite) theControl;
		//			Control[] children = composite.getChildren();
		//
		//			for (int i = 0; i < children.length; i++) {
		//				Control control = children[i];
		//
		//				attachListeners(control, recursive);
		//			}
		//		}
	}

	/**
	 * Copied from org.eclipse.ui.internal.presentations.util.AbstractTabFolder.detachListeners(Control, boolean)
	 */
	protected void detachListeners(Control theControl, boolean recursive) {
		theControl.removeListener(SWT.MenuDetect, menuListener);
		theControl.removeMenuDetectListener(menuDetectListener);
		//
		PresentationUtil.removeDragListener(theControl, dragListener);
		// theControl.removeDragDetectListener(dragDetectListener);
		//		theControl.removeListener(SWT.MouseUp, mouseUpListener);
		theControl.removeMouseListener(mouseListener);
		theControl.removeListener(SWT.Activate, activateListener);

		if(recursive && theControl instanceof Composite) {
			Composite composite = (Composite)theControl;
			Control[] children = composite.getChildren();

			for(int i = 0; i < children.length; i++) {
				Control control = children[i];

				detachListeners(control, recursive);
			}
		}
	}

	protected void handleContextMenu(Point displayPos, Event e) {
		// if (isOnBorder(displayPos)) {
		// return;
		// }

		CTabItem tab = getItem(displayPos);

		System.out.println(this.getClass().getName() + ".handleContextMenu() for item=" + tab);
		// fireEvent(TabFolderEvent.EVENT_SYSTEM_MENU, tab, displayPos);
		listenersManager.fireContextMenuEvent(tab, e);
	}

	/**
	 * Called when drag start. From here, DragUtil.performDrag() is called, which start the
	 * dragging process. DragUtil.performDrag() will contains the tabFolder or the dragged tab.
	 */
	protected void handleDragStarted(Point displayPos, Event e) {

		// if (isOnBorder(displayPos)) {
		// return;
		// }

		CTabItem tab = getItem(displayPos);
		System.out.println(this.getClass().getName() + ".handleDragStarted() for item=" + tab);
		// fireEvent(TabFolderEvent.EVENT_DRAG_START, tab, displayPos);

		boolean allowSnapping = true;
		Rectangle sourceBounds = Geometry.toDisplay(tabFolder.getParent(), tabFolder.getBounds());
		if(tab == null) { // drag folder
			DragUtil.performDrag(tabFolder, sourceBounds, displayPos, allowSnapping);
		} else { // drag item
			DragUtil.performDrag(tab, sourceBounds, displayPos, allowSnapping);
		}
	}

	/**
	 * 
	 * @param displayPos
	 * @param e
	 *        TODO REmove, it is not used.
	 */
	private void handleDragDetectStarted(Point displayPos, DragDetectEvent e) {

		// if (isOnBorder(displayPos)) {
		// return;
		// }

		CTabItem tab = getItem(displayPos);
		System.out.println(this.getClass().getName() + ".handleDragDetectStarted() for item=" + tab);
		// fireEvent(TabFolderEvent.EVENT_DRAG_START, tab, displayPos);
	}

	/**
	 * Handle menu detect.
	 * TODO Connect menu staff here.
	 * 
	 * @param displayPos
	 * @param e
	 */
	private void handleMenuDetect(Point displayPos, MenuDetectEvent e) {

		if(isOnBorder(displayPos)) {
			return;
		}

		CTabItem tab = getItem(displayPos);
		System.out.println(this.getClass().getName() + ".handleMenuDetectStarted() for item=" + tab);
		// fireEvent(TabFolderEvent.EVENT_DRAG_START, tab, displayPos);
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

		//		if (isOnBorder(displayPos)) {
		//			return;
		//		}

		//		System.out.println(this.getClass().getName() + ".handleMouseDown() for item=" + getItem(displayPos));

		int itemIndex = getItemIndex(displayPos);
		// If click is not from an item, it can come from a click on border.
		// restore the last selected item
		if(itemIndex == -1)
			itemIndex = tabFolder.getSelectionIndex();
		if(itemIndex == -1)
			return;

		listenersManager.firePageChange(itemIndex);
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

		for(int i = 0; i < items.length; i++) {
			CTabItem item = items[i];

			if(getItemBounds(item).contains(toFind)) {
				return item;
			}
		}

		return null;
	}

	public int getItemIndex(Point pt) {
		CTabItem item = tabFolder.getItem(pt);
		if(item == null)
			return -1;
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
	 * Interface to ne implemented by listeners on PTabFodler events.
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
	}

	/**
	 * Internal implementations.
	 * Implements a list of listeners.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class EventsManager {

		/**
		 * List of event listeners.
		 */
		List<IPTabFolderListener> listeners = new ArrayList<IPTabFolderListener>();

		/**
		 * Add a listener
		 * 
		 * @param listener
		 */
		public void addListener(IPTabFolderListener listener) {
			if(listeners.contains(listener))
				return;

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
	}

}
