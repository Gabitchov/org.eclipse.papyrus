/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *******************************************************************************/
package org.eclipse.emf.facet.util.swt.internal.exported;

import org.eclipse.swt.widgets.TreeItem;

public final class SWTTestUtils {
	private SWTTestUtils() {
		// utility class
	}

	/**
	 * Find a tree item with the given text among the list of tree items.
	 * 
	 * @param text
	 *            the text of the tree item to find
	 * @param items
	 *            the list of tree items to search
	 * @return the tree item or <code>null</code> if not found
	 */
	public static TreeItem findTreeItem(final String text, final TreeItem[] items) {
		TreeItem result = null;
		for (TreeItem item : items) {
			if (text.equals(item.getText())) {
				result = item;
			}
		}
		return result;
	}
}
