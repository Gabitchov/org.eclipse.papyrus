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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.tree.menu;

import java.util.List;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.item.AbstractTreeItem;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.menu.AbstractTreeMenuItem;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.tree.menu.ExtendedTreeMenu;

/**
 * @see ExtendedTreeMenu
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ITreeMenu<T extends Object> {

	/**
	 * Select a menu item in the tree menu.
	 * 
	 * @param menuItemType
	 * @return an instance of T.
	 */
	T selectMenuItem(Class<? extends AbstractTreeMenuItem<T>> menuItemType);

	/**
	 * Select all the items of the tree with the name <code>treeItemName</code>
	 * 
	 * @param treeItemName
	 *            the name of the item to select.
	 * @return the list of all the tree item with the name in parameter.
	 */
	List<AbstractTreeItem<T>> getTreeItems(String treeItemName);
}