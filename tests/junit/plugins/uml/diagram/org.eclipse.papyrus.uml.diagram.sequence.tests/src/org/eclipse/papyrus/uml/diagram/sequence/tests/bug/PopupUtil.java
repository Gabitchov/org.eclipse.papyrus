/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;


public class PopupUtil {

	static boolean menuPopup = false;

	static int clickMenuIndex = 0;

	public static boolean isMenuPopup() {
		return menuPopup;
	}

	public static void addMenuListener(int clickIndex) {
		menuPopup = false;
		clickMenuIndex = clickIndex;
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Display.getDefault().addFilter(SWT.Show, menuListener);
				Display.getDefault().addFilter(SWT.Hide, menuListener);
			}
		});
	}

	public static void removeMenuListener() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Display.getDefault().removeFilter(SWT.Show, menuListener);
				Display.getDefault().removeFilter(SWT.Hide, menuListener);
			}
		});
	}

	public static void click(final Menu bar) {
		click(bar, 0);
	}

	public static void click(final Menu bar, int index) {
		MenuItem[] items = bar.getItems();
		if(items != null && index < items.length)
			notifyEvent(items[index], SWT.Selection);

		bar.setVisible(false);
		bar.notifyListeners(SWT.Hide, new Event());
		waitForComplete();
	}

	protected static void waitForComplete() {
		boolean run = true;
		while(run) {
			try {
				run = Display.getDefault().readAndDispatch();
			} catch (Exception e) {
				run = true;
			}
		}
	}

	public static void notifyEvent(final Widget menuItem, final int eventType) {
		final Event event = new Event();
		event.time = (int)System.currentTimeMillis();
		event.widget = menuItem;
		event.display = menuItem.getDisplay();
		event.type = eventType;

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				menuItem.notifyListeners(eventType, event);
			}
		});

		waitForComplete();
	}

	/**
	 * A private class to listen for the show/hide events.
	 */
	static class ShowHideListener implements Listener {

		/**
		 * Handles the event by checking if it is the proper event. If it is a show, then the current context menu is
		 * set. Otherwise it will be set to <code>null</code> if it is a hide event.
		 * 
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 * @param event
		 *        the event to check.
		 */
		public void handleEvent(Event event) {
			if(!(event.widget instanceof Menu))
				return;
			Menu menu = (Menu)event.widget;
			if(hasStyle(menu, SWT.POP_UP)) {
				if(event.type == SWT.Show) {
					currentContextMenu = menu;
					click(menu, clickMenuIndex);
					menuPopup = true;
				}
				if(event.type == SWT.Hide)
					currentContextMenu = null;
			}
		}
	}

	/**
	 * Checks if the widget has the given style.
	 * 
	 * @param w
	 *        the widget.
	 * @param style
	 *        the style.
	 * @return <code>true</code> if the widget has the specified style bit set. Otherwise <code>false</code>.
	 */
	public static boolean hasStyle(final Widget w, final int style) {
		if((w == null) || w.isDisposed())
			return false;
		if(style == SWT.NONE)
			return true;

		final List<Boolean> list = new ArrayList<Boolean>();
		w.getDisplay().syncExec(new Runnable() {


			public void run() {
				list.add((w.getStyle() & style) != 0);
			}
		});
		return list.get(0);
	}

	private static Menu currentContextMenu;

	private static Listener menuListener = new ShowHideListener();

	private static Listener dialogCloseHandler = new Listener() {

		public void handleEvent(Event event) {
			if(event.widget instanceof Shell) {
				Shell shell = (Shell)event.widget;
				waitForComplete();
				notifyEvent(shell.getDefaultButton(), SWT.Selection);
			}
		}
	};

	public static void addDialogCloseHandler() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Display.getDefault().addFilter(SWT.Show, dialogCloseHandler);
			}
		});
	}

	public static void removeDialogCloseHandler() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Display.getDefault().removeFilter(SWT.Show, dialogCloseHandler);
			}
		});
	}
}
