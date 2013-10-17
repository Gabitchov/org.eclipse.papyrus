/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.util;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;


/**
 * A pop-up menu to attach to buttons, which presents a flat menu of actions for the user to choose from.
 */
public class PopupButtonMenu {

	private final Button button;

	private MenuManager menu;


	/**
	 * Initializes me with a button on which to present the pop-up menu.
	 * 
	 * @param button
	 *        the button on which I attach a pop-up menu
	 */
	public PopupButtonMenu(Button button) {
		this.button = button;

		initialize();
	}

	/**
	 * Add an action to the drop-down menu. Note that this explicitly excludes nested menu structures.
	 * 
	 * @param action
	 *        an action to add to the menu
	 */
	public void addAction(IAction action) {
		menu.add(action);
	}

	private void initialize() {
		menu = new MenuManager();

		button.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if(menu != null) {
					menu.dispose();
					menu = null;
				}
			}
		});

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				showMenu(e.x, e.y);
			}
		});
	}

	private void showMenu(int x, int y) {
		if(menu != null) {
			Menu menu = this.menu.createContextMenu(button);
			// don't set the menu as the button's context menu!  We don't want right-click to show it

			menu.setLocation(button.toDisplay(x, y));
			menu.setVisible(true);
		}
	}
}
