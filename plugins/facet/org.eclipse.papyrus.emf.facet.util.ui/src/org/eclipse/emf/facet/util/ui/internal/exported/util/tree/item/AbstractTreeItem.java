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
package org.eclipse.emf.facet.util.ui.internal.exported.util.tree.item;

import java.util.Map;

import org.eclipse.emf.facet.util.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.ExtendedTree;
import org.eclipse.emf.facet.util.ui.internal.exported.util.tree.menu.AbstractTreeMenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * This abstract class represent an item of the tree. All the item types of the
 * tree must extend this abstract class.
 * 
 * @since 0.3
 */
public abstract class AbstractTreeItem<T extends Object> {

	private AbstractTreeMenuItem<T> menuItem;
	private TreeItem treeItem;
	private Map<String, Object> extraProperties;

	/**
	 * Create a new item {@link TreeItem} into the parent.
	 * 
	 * @param parent
	 *            the parent of the item to create.
	 */
	public TreeItem createItem(final AbstractTreeMenuItem<T> itemMenu,
			final Tree parent) {
		this.menuItem = itemMenu;
		final TreeItem item = new TreeItem(parent, SWT.NONE);
		initialize(item);
		return item;
	}

	/**
	 * Create a new item {@link TreeItem} into the parent.
	 * 
	 * @param parent
	 *            the parent of the item to create.
	 */
	public TreeItem createItem(final AbstractTreeMenuItem<T> itemMenu,
			final TreeItem parent) {
		this.menuItem = itemMenu;
		final TreeItem item = new TreeItem(parent, SWT.NONE);
		// Open the parent of the item on the tree.
		parent.setExpanded(true);
		initialize(item);
		return item;
	}

	/**
	 * Initialize the tree item with the text and call the method
	 * {@link #onItemCreation()} if the user wants an extra action.
	 */
	private void initialize(final TreeItem item) {
		item.setChecked(true);
		if ((getItemText() == null) || "".equals(getItemText())) { //$NON-NLS-1$
			item.setText(getDefaultItemText());
		} else {
			item.setText(getItemText());
		}
		fireChanged();
		this.setTreeItem(item);
	}

	/**
	 * Return the default message when the item is created.
	 * 
	 * @return the default message.
	 */
	public static String getDefaultItemText() {
		return Messages.item_todo;
	}

	/**
	 * Return the text to display for the item. This text can be null or an
	 * empty string (the value of the string will be {@link Messages#item_todo}
	 * ). The item text can be setted later with {@link #setItemText(String)}.
	 * 
	 * @return the text of the item in the tree.
	 */
	public abstract String getItemText();

	/**
	 * Called when this object will be instantiate.
	 */
	public abstract T onItemCreation();

	/**
	 * This method is called when the item of the tree is selected.
	 */
	public abstract IDialog onItemMouseSelection();

	/**
	 * Return the value of this item.
	 * 
	 * @return the value.
	 */
	public abstract Object returnValue();

	/**
	 * Delete the item and all his children of the tree.
	 */
	public void removeItem() {
		for (final TreeItem item : getChildren()) {
			findTreeItemExtended(item).removeItem();
		}
		this.getTreeItem().dispose();
		fireChanged();
	}

	/**
	 * Return the children of this item in the tree.
	 * 
	 * @return the list of the children.
	 */
	public TreeItem[] getChildren() {
		return this.getTreeItem().getItems();
	}

	/**
	 * Return the parent of this item on the tree.
	 * 
	 * @return the parent of the item or null if the item is root.
	 */
	public AbstractTreeItem<T> getParent() {
		return findTreeItemExtended(getTreeItem().getParentItem());
	}

	/**
	 * Edit the text of the item into the tree.
	 * 
	 * @param newText
	 *            the new text.
	 */
	public void setTreeItemText(final String newText) {
		this.getTreeItem().setText(newText);
	}

	/**
	 * When a modification append, this method has to be called and the method
	 * {@link #notifyChanged()} is called for the listener of this Tree.
	 */
	protected void fireChanged() {
		this.getMenuItem().fireChanged();
	}

	/**
	 * @return the treeItem
	 */
	public TreeItem getTreeItem() {
		return this.treeItem;
	}

	/**
	 * @param treeItem
	 *            the treeItem to set
	 */
	private void setTreeItem(final TreeItem treeItem) {
		this.treeItem = treeItem;
	}

	/**
	 * @return the menuItem
	 */
	public AbstractTreeMenuItem<T> getMenuItem() {
		return this.menuItem;
	}

	/**
	 * @param item
	 * @return
	 */
	public AbstractTreeItem<T> findTreeItemExtended(final TreeItem item) {
		return getMenuItem().findTreeItemExtended(item);
	}

	/**
	 * This method gets the <code>properties</code> passed by the
	 * {@link #treeExtended} via the method
	 * {@link ExtendedTree#putExtraPropertiesToItems(Map)}.
	 * 
	 * @return the extraProperties
	 */
	public Map<String, Object> getExtraProperties() {
		return this.extraProperties;
	}

	/**
	 * @param extraProperties the extraProperties to set
	 */
	public void setExtraProperties(final Map<String, Object> extraProperties) {
		this.extraProperties = extraProperties;
	}
}
