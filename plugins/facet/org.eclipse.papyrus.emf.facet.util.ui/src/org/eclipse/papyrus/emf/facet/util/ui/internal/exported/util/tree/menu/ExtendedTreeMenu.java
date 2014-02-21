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
import java.util.Map;

import org.eclipse.emf.facet.util.ui.internal.exported.tree.menu.ITreeMenu;
import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.ExtendedTree;
import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * This class provide the creation of the menu {@link Menu} of the tree (
 * {@link #createMenu(Control, ExtendedTree)}. The menu add a list of
 * {@link AbstractTreeItem} and for each an {@link AbstractTreeItem} which will
 * be instantiate when the menu item is selected.
 * 
 * @since 0.3
 */
public class ExtendedTreeMenu<IDialog> implements ITreeMenu<IDialog> {

	private final Control parent;
	private final ExtendedTree treeExtended;
	private final List<AbstractTreeMenu<IDialog>> menuItems;
	private Menu menu;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of the menu.
	 * @param treeExtended
	 *            the tree to which the menu will be linked.
	 * @param menuItems
	 */
	public ExtendedTreeMenu(final Control parent, final ExtendedTree treeExtended,
			final List<AbstractTreeMenu<IDialog>> menuItems) {
		this.parent = parent;
		this.treeExtended = treeExtended;
		this.menuItems = menuItems;
	}

	/**
	 * This method creates the tree menu, add put the listener into the menu.
	 * 
	 * @param parent
	 *            the parent of the menu.
	 * @param treeExtended
	 *            the associated {@link ExtendedTree} of the menu.
	 */
	public void createMenu() {
		this.menu = new Menu(this.parent);
		this.menu.addMenuListener(new MenuListener() {

			public void menuShown(final MenuEvent menuEvent) {
				onMenuShown();
			}

			public void menuHidden(final MenuEvent menuEvent) {
				// Nothing.
			}
		});
	}

	/**
	 * This method is called when the menu is displayed. It calls all the
	 * {@link AbstractTreeMenu#refresh(TreeMenu)} method of each element of the
	 * menu.
	 */
	public void onMenuShown() {
		for (final AbstractTreeMenu<IDialog> menuItem : this.getMenuItems()) {
			menuItem.refresh(this);
		}
	}

	/**
	 * Return the list of all the items of this menu.
	 * 
	 * @return the list of the {@link AbstractTreeMenu} of this menu.
	 */
	public List<AbstractTreeMenu<IDialog>> getTreeMenuItems() {
		return this.getMenuItems();
	}

	/**
	 * Return the {@link Menu} of this TreeMenu.
	 * 
	 * @return the menu.
	 */
	public Menu getMenu() {
		return this.menu;
	}

	/**
	 * Put this <code>properties</code> to each items created.
	 * 
	 * @param properties
	 *            the list of properties to pass.
	 */
	public void putExtraProperties(final Map<String, Object> properties) {
		for (final AbstractTreeMenu<IDialog> menuItem : this.getMenuItems()) {
			menuItem.setExtraProperties(properties);
		}
	}

	/**
	 * @return the current {@link TreeItem} selected on the tree.
	 */
	public TreeItem getCurrentItemSelected() {
		TreeItem result = null;
		final TreeItem[] items = this.treeExtended.getTree().getSelection();
		if (items.length > 0) {
			result = this.treeExtended.getTree().getSelection()[0];
		}
		return result;
	}

	/**
	 * @return the {@link AbstractTreeItem} selected on the tree. Can be null.
	 */
	public AbstractTreeItem<IDialog> getTreeItemExtended(final TreeItem treeItem) {
		AbstractTreeItem<IDialog> result = null;
		for (final AbstractTreeMenu<IDialog> menuItem : this.getMenuItems()) {
			final AbstractTreeItem<IDialog> itemExtended = menuItem
					.getTreeItemExtended(treeItem);
			if (itemExtended != null) {
				result = itemExtended;
				break;
			}
		}
		return result;
	}

	/**
	 * @return the {@link AbstractTreeMenu} selected on the tree. Can be null.
	 */
	public AbstractTreeMenu<IDialog> getTreeMenu(final TreeItem treeItem) {
		AbstractTreeMenu<IDialog> result = null;

		for (final AbstractTreeMenu<IDialog> menuItem : this.getMenuItems()) {
			final AbstractTreeItem<IDialog> itemExtended = menuItem
					.getTreeItemExtended(treeItem);
			if (itemExtended != null) {
				result = menuItem;
				break;
			}
		}
		return result;
	}

	/**
	 * Remove the current item selected of the tree.
	 */
	public void removeCurrentItemSelected() {
		final AbstractTreeMenu<IDialog> treeMenu = getTreeMenu(getCurrentItemSelected());
		if (treeMenu != null) {
			treeMenu.removeItem(getCurrentItemSelected());
		}
	}

	/**
	 * @return the {@link Tree}.
	 */
	public Tree getTree() {
		return this.treeExtended.getTree();
	}

	/**
	 * This method call the method
	 * {@link AbstractTreeItem#onItemMouseSelection()} of the current selection.
	 */
	public void onMouseSelection() {
		final AbstractTreeItem<IDialog> treeMenu = getTreeItemExtended(getCurrentItemSelected());
		if (treeMenu != null) {
			treeMenu.onItemMouseSelection();
			fireChanged();
		}
	}

	/**
	 * When a modification append, this method has to be called and the method
	 * {@link #notifyChanged()} is called for the listener of this Tree.
	 */
	public void fireChanged() {
		this.treeExtended.fireChanged();
	}

	/**
	 * @return the all the items of the menu.
	 */
	private List<AbstractTreeMenu<IDialog>> getMenuItems() {
		return this.menuItems;
	}

	/**
	 * Select the item into the menu (if the item exist).
	 * 
	 * @return can return a {@link IDialog}. Can be null.
	 */
	public IDialog selectMenuItem(
			final Class<? extends AbstractTreeMenuItem<IDialog>> menuItemType) {
		IDialog result = null;
		final AbstractTreeMenu<IDialog> treeMenu = findMenuItem(menuItemType);
		if (treeMenu != null) {
			result = treeMenu.onMenuItemSelection();
		}
		return result;
	}

	/**
	 * Return (if exist) the {@link AbstractTreeMenu} with the name
	 * <code>menuItemName</code> into the items of the tree menu.
	 * 
	 * @param menuItemType
	 *            the name of the element to find.
	 * @return the item menu with the name in parameter (can be null).
	 */
	private AbstractTreeMenuItem<IDialog> findMenuItem(
			final Class<? extends AbstractTreeMenuItem<IDialog>> menuItemType) {
		AbstractTreeMenuItem<IDialog> result = null;
		for (final AbstractTreeMenuItem<IDialog> item : getAllTreeMenuItems()) {
			if (item.getClass().isInstance(menuItemType)) {
				result = item;
			}
		}
		return result;
	}

	private List<AbstractTreeMenuItem<IDialog>> getAllTreeMenuItems() {
		final List<AbstractTreeMenuItem<IDialog>> result = new LinkedList<AbstractTreeMenuItem<IDialog>>();
		for (final AbstractTreeMenu<IDialog> menuItem : getMenuItems()) {
			if (menuItem instanceof AbstractTreeSubMenu) {
				result.addAll(getAllTreeMenuItems((AbstractTreeSubMenu<IDialog>) menuItem));
			} else {
				result.add((AbstractTreeMenuItem<IDialog>) menuItem);
			}
		}
		return result;
	}

	private List<AbstractTreeMenuItem<IDialog>> getAllTreeMenuItems(
			final AbstractTreeSubMenu<IDialog> subMenu) {
		final List<AbstractTreeMenuItem<IDialog>> result = new LinkedList<AbstractTreeMenuItem<IDialog>>();
		for (final AbstractTreeMenu<IDialog> menuItem : subMenu.getItems()) {
			if (menuItem instanceof AbstractTreeSubMenu) {
				result.addAll(getAllTreeMenuItems((AbstractTreeSubMenu<IDialog>) menuItem));
			} else {
				result.add((AbstractTreeMenuItem<IDialog>) menuItem);
			}
		}
		return result;
	}

	/**
	 * @return the treeMenuItem into the menu with is an instance of the type in
	 *         parameter.
	 */
	public AbstractTreeMenu<IDialog> getTreeMenuItem(final Class<?> treeMenuType) {
		AbstractTreeMenu<IDialog> result = null;
		final List<AbstractTreeMenu<IDialog>> treeMenuItems = getTreeMenuItems();
		for (final AbstractTreeMenu<IDialog> item : treeMenuItems) {
			result = getTreeMenuItem(item, treeMenuType);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	private AbstractTreeMenu<IDialog> getTreeMenuItem(
			final AbstractTreeSubMenu<IDialog> item,
			final Class<?> treeMenuType) {
		AbstractTreeMenu<IDialog> result = null;
		for (final AbstractTreeMenu<IDialog> subItem : item.getItems()) {
			result = getTreeMenuItem(subItem, treeMenuType);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	private AbstractTreeMenu<IDialog> getTreeMenuItem(
			final AbstractTreeMenu<IDialog> item,
			final Class<?> treeMenuType) {
		AbstractTreeMenu<IDialog> result = null;
		if (treeMenuType.isInstance(item)) {
			result = item;
		} else if (item instanceof AbstractTreeSubMenu) {
			result = getTreeMenuItem((AbstractTreeSubMenu<IDialog>) item,
					treeMenuType);
		}
		return result;
	}

	/**
	 * get all the items of the tree with the name <code>treeItemName</code>
	 * 
	 * @param treeItemName
	 *            the name of the item to select.
	 * @return the list of all the tree item with the name in parameter.
	 */
	public List<AbstractTreeItem<IDialog>> getTreeItems(
			final String treeItemName) {
		final List<AbstractTreeItem<IDialog>> result = new LinkedList<AbstractTreeItem<IDialog>>();
		for (final AbstractTreeMenuItem<IDialog> menuItem : getAllTreeMenuItems()) {
			for (final AbstractTreeItem<IDialog> treeItem : menuItem.getItems()) {
				if (treeItemName.equals(treeItem.getItemText())) {
					result.add(treeItem);
				}
			}
		}
		return result;
	}

	/**
	 * Select a item into the tree.
	 * 
	 * @param treeItem
	 *            the {@link AbstractTreeItem} to select
	 */
	public void selectTreeItem(final AbstractTreeItem<IDialog> treeItem) {
		this.treeExtended.getTree().setSelection(treeItem.getTreeItem());
	}
}
