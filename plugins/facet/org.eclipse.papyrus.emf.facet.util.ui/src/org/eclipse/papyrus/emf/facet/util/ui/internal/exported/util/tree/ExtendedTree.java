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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree;

import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.menu.AbstractTreeMenu;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.menu.ExtendedTreeMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;

/**
 * This class provides the creation of a {@link Tree} but with extended
 * elements.</p>
 * 
 * This tree creates its menu {@link ExtendedTreeMenu} and had the list of all the items
 * of the tree accessible with the method {@link #getTreeItems()}.
 * 
 * </p> Only one element of the tree can be selected at the same time.
 * 
 * @since 0.3
 */
public class ExtendedTree {

	private static final int TREE_HEIGHT = 250;
	private final Tree tree;
	private final ExtendedTreeMenu<IDialog> treeMenu;
	private Listener listener;

	/**
	 * Constructor.
	 * 
	 * Create a new instance of a {@link Tree} and create the {@link ExtendedTreeMenu}
	 * with the <code>menuItems</code> in parameter.
	 * 
	 * @param parent
	 *            the parent of the TreeExtended.
	 * @param menuItems
	 *            the items of the menu.
	 * 
	 * @see ExtendedTreeMenu
	 * @see AbstractTreeMenu
	 */
	public ExtendedTree(final Composite parent,
			final List<AbstractTreeMenu<IDialog>> menuItems) {

		// SWT.SINGLE -> a unique selection on the tree possible
		this.tree = new Tree(parent, SWT.SINGLE | SWT.NONE);
		final GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = TREE_HEIGHT;
		this.tree.setLayoutData(gridData);
		this.tree.addMouseListener(new MouseListener() {

			public void mouseUp(final MouseEvent mouseEvent) {
				// Nothing.
			}

			public void mouseDown(final MouseEvent mouseEvent) {
				// Nothing.
			}

			public void mouseDoubleClick(final MouseEvent mouseEvent) {
				onMouseDoubleClick();
			}
		});
		this.tree.addKeyListener(new KeyListener() {

			public void keyReleased(final KeyEvent event) {
				// Nothing.
			}

			public void keyPressed(final KeyEvent event) {
				onKeyPressed(event);
			}
		});
		this.treeMenu = new ExtendedTreeMenu<IDialog>(parent, this, menuItems);
		this.getTreeMenu().createMenu();
		this.tree.setMenu(this.getTreeMenu().getMenu());
	}

	/**
	 * This method is called when a key is pressed on the tree.
	 */
	protected void onKeyPressed(final KeyEvent event) {
		if (event.keyCode == SWT.DEL) {
			this.getTreeMenu().removeCurrentItemSelected();
		}
	}

	/**
	 * When the mouse does a double click on an element of the tree.
	 */
	protected void onMouseDoubleClick() {
		if (getTree().getSelection().length > 0) {
			// new Tree(parent, SWT.SINGLE | SWT.NONE) -> the tree can only had
			// one selection at the same time.
			this.getTreeMenu().onMouseSelection();
		}
	}

	/**
	 * @return the {@link Tree} created by this class.
	 */
	public Tree getTree() {
		return this.tree;
	}

	/**
	 * Add a {@link ModificationListener} to the list of listeners of the tree.
	 * 
	 * @param listener
	 */
	public void setListener(final Listener listener) {
		this.listener = listener;
	}

	/**
	 * When a modification appends, this method has to be called and the method
	 * {@link #notifyChanged()} is called for the listener of this Tree.
	 */
	public void fireChanged() {
		this.listener.handleEvent(null);
	}

	/**
	 * @return a map of properties to pass to the {@link AbstractTreeItem}. Each
	 *         items add to override the method
	 *         {@link AbstractTreeItem#getExtraProperties(Map)} to get this
	 *         properties.
	 */
	public void putExtraPropertiesToItems(final Map<String, Object> properties) {
		this.getTreeMenu().putExtraProperties(properties);
	}

	/**
	 * Return the first {@link AbstractTreeItem} of the tree.
	 * 
	 * @return the first item of the tree.
	 */
	public AbstractTreeItem<IDialog> getFirstTreeItem() {
		AbstractTreeItem<IDialog> result = null;
		if (this.tree.getItemCount() > 0) {
			result = this.getTreeMenu().getTreeItemExtended(this.tree.getItem(0));
		}
		return result;
	}

	/**
	 * @return the treeMenu of this tree.
	 */
	public ExtendedTreeMenu<IDialog> getTreeMenu() {
		return this.treeMenu;
	}

}
