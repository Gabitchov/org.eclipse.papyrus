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

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.ui.internal.Activator;
import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Abstract class for the tree menu item. Each Menu Item had an handler which
 * provide the methods: <li>{@link #isEnabled()} : return if the menu item has
 * to be displayed.</li> <li>{@link #onMenuItemSelection()} : this method will
 * be execute when the item is selected.</li> <li>
 * {@link #getAssociatedTreeItemClass()} : links this class with an
 * {@link AbstractTreeItem}. This item will be instantiate when the user select
 * this element on the tree menu.</li>
 * 
 * @see AbstractTreeItem
 * @see AbstractTreeMenu
 * @since 0.3
 */
public abstract class AbstractTreeMenuItem<T extends Object> extends
		AbstractTreeMenu<T> {

	private final List<AbstractTreeItem<T>> items;

	/**
	 * Constructor.
	 */
	public AbstractTreeMenuItem() {
		super();
		this.items = new LinkedList<AbstractTreeItem<T>>();
	}

	/**
	 * This method creates the associated item and set the extra properties to
	 * it.
	 */
	@Override
	public T onMenuItemSelection() {
		AbstractTreeItem<T> item = null;
		if (getCurrentItemSelected() == null) {
			item = createItem(getTree());
		} else {
			item = createItem(getCurrentItemSelected());
		}
		this.getItems().add(item);
		item.setExtraProperties(getProperties());
		fireChanged();
		return item.onItemCreation();
	}

	/**
	 * Create a new item {@link TreeItem} into the parent.
	 * 
	 * @param parent
	 *            the parent of the item to create.
	 */
	public AbstractTreeItem<T> createItem(final Tree parent) {
		return createTreeItem(parent);
	}

	/**
	 * Create a new item {@link TreeItem} into the parent.
	 * 
	 * @param parent
	 *            the parent of the item to create.
	 */
	public AbstractTreeItem<T> createItem(final TreeItem parent) {
		return createTreeItem(parent);
	}

	/**
	 * Create a new item {@link TreeItem} into the parent.
	 * 
	 * @param parent
	 *            the parent of the item to create.
	 */
	protected AbstractTreeItem<T> createTreeItem(final Object parent) {
		AbstractTreeItem<T> newTreeItem = null;
		try {
			newTreeItem = getAssociatedTreeItemClass().newInstance();
			if (parent instanceof Tree) {
				newTreeItem.createItem(this, (Tree) parent);
			} else if (parent instanceof TreeItem) {
				newTreeItem.createItem(this, (TreeItem) parent);
			}
		} catch (final SecurityException e) {
			Logger.logError(e, Activator.getDefault());
		} catch (final IllegalArgumentException e) {
			Logger.logError(e, Activator.getDefault());
		} catch (final InstantiationException e) {
			Logger.logError(e, Activator.getDefault());
		} catch (final IllegalAccessException e) {
			Logger.logError(e, Activator.getDefault());
		}

		return newTreeItem;
	}

	/**
	 * Find the treeItem searching into the all tree.
	 * 
	 * @param treeItem
	 *            the treeItem to find.
	 * @return the corresponding {@link AbstractTreeItem}. Null if not.
	 */
	public AbstractTreeItem<T> findTreeItemExtended(final TreeItem treeItem) {
		return this.getTreeMenu().getTreeItemExtended(treeItem);
	}

	/**
	 * This method only find the item into the corresponding element of this
	 * menu item. To find an element searching it into the all tree, use the
	 * method {@link #findTreeItemExtended(TreeItem)}.
	 */
	@Override
	public AbstractTreeItem<T> getTreeItemExtended(final TreeItem item) {
		AbstractTreeItem<T> result = null;
		for (final AbstractTreeItem<T> itemExtended : this.getItems()) {
			if (itemExtended.getTreeItem().equals(item)) {
				result = itemExtended;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean removeItem(final TreeItem item) {
		boolean removed = false;
		final AbstractTreeItem<T> itemExtended = findTreeItemExtended(item);
		if (itemExtended != null) {
			this.getItems().remove(itemExtended);
			itemExtended.removeItem();
			removed = true;
			fireChanged();
		}
		return removed;
	}

	/**
	 * @return get the current selection of the tree.
	 */
	public TreeItem getCurrentItemSelected() {
		return getTreeMenu().getCurrentItemSelected();
	}

	/**
	 * Remove the last item created.
	 */
	protected void removeLastItem() {
		// The list created is a LinkedList<AbstractTreeItem>
		((LinkedList<AbstractTreeItem<T>>) this.getItems()).getLast()
				.removeItem();
		fireChanged();
	}

	/**
	 * Set a new text to the last item created.
	 * 
	 * @param newText
	 *            the new text to set.
	 */
	protected void setLastItemText(final String newText) {
		// The list created is a LinkedList<AbstractTreeItem>
		((LinkedList<AbstractTreeItem<T>>) this.getItems()).getLast()
				.setTreeItemText(newText);
		fireChanged();
	}

	/**
	 * When a modification append, this method has to be called and the method
	 * {@link #notifyChanged()} is called for the listener of this Tree.
	 */
	public void fireChanged() {
		final ExtendedTreeMenu<T> treeMenu = getTreeMenu();
		if (treeMenu != null) {
			treeMenu.fireChanged();
		}
	}

	/**
	 * Return the class associated with this menu item. When this menu item will
	 * be selected, a new instance of this associated {@link AbstractTreeItem}
	 * will be created.
	 * 
	 * @return the associated class.
	 */
	public abstract Class<? extends AbstractTreeItem<T>> getAssociatedTreeItemClass();


	/**
	 * @return the items created by this menu item.
	 */
	public List<AbstractTreeItem<T>> getItems() {
		return this.items;
	}
}
