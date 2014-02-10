/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.internal.exported.util.tree.menu;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Class for the creation of a sub-menu in the menu. The sub-menu is not
 * selectable and own a list of sub-items (declared by the contributor with the
 * extension point).
 * 
 * @since 0.3
 */
public abstract class AbstractTreeSubMenu<T extends Object> extends
		AbstractTreeMenu<T> {

	private final List<AbstractTreeMenu<T>> items;

	/**
	 * Constructor.
	 */
	public AbstractTreeSubMenu() {
		super();
		this.items = new LinkedList<AbstractTreeMenu<T>>();
	}

	/**
	 * Add an item to the list of the sub-menu items.
	 * 
	 * @param item
	 *            the item to add.
	 */
	public void addItem(final AbstractTreeMenu<T> item) {
		this.getItems().add(item);
	}

	/**
	 * Creation of the sub-menu and all his children.
	 */
	@Override
	protected MenuItem createMenuItem(final Menu parent) {
		MenuItem menuItem = null;
		for (final AbstractTreeMenu<T> item : this.getItems()) {
			if (item.isEnabled(getTreeMenu())) {
				if (menuItem == null) {
					menuItem = createConcreteMenu(parent);
				}
				item.setExtraProperties(getProperties());
				item.refresh(getTreeMenu(), menuItem.getMenu());
			}
		}
		return menuItem;
	}

	/**
	 * Create the concrete sub menu into the tree menu.
	 * 
	 * @param parent
	 *            the menu parent of this sub menu.
	 * @return the new item into the menu.
	 */
	protected MenuItem createConcreteMenu(final Menu parent) {
		final MenuItem menuItem = new MenuItem(parent, SWT.CASCADE);
		menuItem.setText(getMenuName());
		menuItem.setMenu(new Menu(parent));
		return menuItem;
	}

	@Override
	public boolean isEnabled() {
		boolean result = false;
		for (final AbstractTreeMenu<T> item : this.getItems()) {
			if (item.isEnabled(getTreeMenu())) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public AbstractTreeItem<T> getTreeItemExtended(final TreeItem treeItem) {
		AbstractTreeItem<T> result = null;
		for (final AbstractTreeMenu<T> menuItem : this.getItems()) {
			final AbstractTreeItem<T> itemExtended = menuItem
					.getTreeItemExtended(treeItem);
			if (itemExtended != null) {
				result = itemExtended;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean removeItem(final TreeItem item) {
		boolean removed = false;
		for (final AbstractTreeMenu<T> menuItem : this.getItems()) {
			removed = menuItem.removeItem(item);
			if (removed) {
				break;
			}
		}
		return removed;
	}

	/**
	 * @return the items
	 */
	public List<AbstractTreeMenu<T>> getItems() {
		return this.items;
	}
}
