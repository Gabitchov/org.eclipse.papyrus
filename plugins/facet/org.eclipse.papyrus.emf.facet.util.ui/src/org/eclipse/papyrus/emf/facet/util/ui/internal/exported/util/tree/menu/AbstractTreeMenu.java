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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.menu;

import java.util.Map;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Abstract class providing the creation of any item into the menu.
 * 
 * @see AbstractTreeMenuItem
 * @see AbstractTreeSubMenu
 * @since 0.3
 */
public abstract class AbstractTreeMenu<T extends Object> {

	private ExtendedTreeMenu<T> treeMenu;
	private MenuItem menuItem;
	private boolean menuItemCreated;
	private Map<String, Object> properties;

	/**
	 * Refresh the the menu according to the actual context.
	 */
	public void refresh(final ExtendedTreeMenu<T> menu) {
		this.treeMenu = menu;
		refreshMenu(this.treeMenu.getMenu());
	}

	/**
	 * Refresh the the menu according to the actual context.
	 */
	public void refresh(final ExtendedTreeMenu<T> menuTree, final Menu menu) {
		this.treeMenu = menuTree;
		refreshMenu(menu);
	}

	/**
	 * Refresh the the menu according to the actual context.
	 */
	private void refreshMenu(final Menu menu) {
		if (isEnabled()) {
			if (this.isMenuItemCreated()) {
				deleteMenuItem();
			}
				this.setMenuItemCreated(true);
				this.menuItem = createMenuItem(menu);
		} else {
			deleteMenuItem();
			this.setMenuItemCreated(false);
		}
	}

	/**
	 * Return if the menu item has to be enabled or not (by checking if the
	 * associated AbstractTreeItem is enabled or not).
	 * 
	 * @return if the menu item has to be enabled or not.
	 */
	public boolean isEnabled(final ExtendedTreeMenu<T> menuTree) {
		this.treeMenu = menuTree;
		return isEnabled();
	}

	/**
	 * Return if the menu item has to be enabled or not (by checking if the
	 * associated AbstractTreeItem is enabled or not).
	 * 
	 * @return if the menu item has to be enabled or not.
	 */
	public abstract boolean isEnabled();

	/**
	 * Create the concrete item. Has to be overrided by the classes extending
	 * this abstract class.
	 * 
	 * @param parent
	 *            the parent of the item.
	 * @return the item created.
	 */
	protected MenuItem createMenuItem(final Menu parent) {
		final MenuItem item = new MenuItem(parent, SWT.NONE);
		item.setText(getMenuName());
		item.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent selectionEvent) {
				onMenuItemSelection();
			}

			public void widgetDefaultSelected(
					final SelectionEvent selectionEvent) {
				// Nothing.
			}
		});
		return item;
	}

	/**
	 * @return the menu item name.
	 */
	public abstract String getMenuName();

	/**
	 * This method is called when the menu item is selected.
	 * 
	 * @return can return an instance of T.
	 */
	public abstract T onMenuItemSelection();

	/**
	 * Delete the item of the menu.
	 */
	public void deleteMenuItem() {
		if (this.isMenuItemCreated() && (this.menuItem != null)
				&& !this.menuItem.isDisposed()) {
			if (this.menuItem.getMenu() != null) {
				this.menuItem.getMenu().dispose();
			}
			this.menuItem.dispose();
		}
	}

	/**
	 * @return the treeMenu of the tree.
	 */
	public ExtendedTreeMenu<T> getTreeMenu() {
		return this.treeMenu;
	}

	/**
	 * Set the properties to pass to the new items.
	 * 
	 * @param extraProperties
	 *            the properties to pass.
	 * 
	 */
	public void setExtraProperties(final Map<String, Object> extraProperties) {
		this.properties = extraProperties;
	}

	/**
	 * @return the {@link Tree}.
	 */
	public Tree getTree() {
		return this.treeMenu.getTree();
	}

	/**
	 * @return the properties.
	 */
	public Map<String, Object> getProperties() {
		return this.properties;
	}

	/**
	 * @return true if the menu for this concrete item is created or not.
	 */
	public boolean isMenuItemCreated() {
		return this.menuItemCreated;
	}

	/**
	 * @param menuItemCreated
	 *            the menuItemCreated to set.
	 */
	public void setMenuItemCreated(final boolean menuItemCreated) {
		this.menuItemCreated = menuItemCreated;
	}

	/**
	 * Return the {@link AbstractTreeItem} according to the {@link TreeItem}.
	 * 
	 * @param treeItem
	 *            the treeItem related.
	 * @return the {@link AbstractTreeItem} related to the <code>treeItem</code>
	 *         .
	 */
	public abstract AbstractTreeItem<T> getTreeItemExtended(
			final TreeItem treeItem);

	/**
	 * Remove the item in parameter of the tree.
	 * 
	 * @param item
	 *            the item to remove.
	 */
	public abstract boolean removeItem(final TreeItem item);
}
